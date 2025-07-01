package cn.sast.common;

import cn.sast.api.config.MainConfig;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.PathExtensionsKt;
import cn.sast.common.Resource;
import cn.sast.common.WalkFileTreeResult;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public abstract class FileSystemLocator {
    public enum TraverseMode {
        PROCESS_ARCHIVES(true),
        SKIP_ARCHIVES(false);

        private final boolean processArchive;

        TraverseMode(boolean processArchive) {
            this.processArchive = processArchive;
        }

        public boolean getProcessArchive() {
            return processArchive;
        }
    }

    private static final KLogger logger = KotlinLogging.logger(FileSystemLocator.class);
    private static final LoadingCache<Path, CompletableFuture<WalkFileTreeResult>> walkTreeCache = 
        Caffeine.newBuilder()
            .expireAfterAccess(Duration.ofSeconds(15))
            .build(CacheLoader.from(FileSystemLocator::walkTreeResultSafe));

    private final Set<Path> visitedArchive = Collections.synchronizedSet(new HashSet<>(1000));

    protected static CompletableFuture<WalkFileTreeResult> getWalkTreeResultSafe(Path path) {
        try {
            return walkTreeCache.get(path);
        } catch (ExecutionException e) {
            throw new RuntimeException("Failed to load walk tree result", e);
        }
    }

    private static CompletableFuture<WalkFileTreeResult> walkTreeResultSafe(Path path) {
        // Implementation would go here
        return CompletableFuture.completedFuture(new WalkFileTreeResult(path, List.of(), List.of()));
    }

    public final void process(@NotNull Path path, @NotNull TraverseMode traverseMode) {
        try {
            WalkFileTreeResult result = getWalkTreeResultSafe(path).get();
            visit(result, traverseMode);
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Failed to process path: " + path, e);
        }
    }

    private void visit(WalkFileTreeResult res, TraverseMode traverseMode) {
        List<IResFile> archives = new ArrayList<>();
        for (Path it : res.getFiles()) {
            IResFile file = Resource.INSTANCE.fileOf(it);
            visitFile(file);
            if (traverseMode.getProcessArchive() && file.getZipLike()) {
                archives.add(file);
            }
        }
        for (Path dir : res.getDirs()) {
            visitDirectory(Resource.INSTANCE.dirOf(dir));
        }
        if (!archives.isEmpty()) {
            for (IResFile archive : archives) {
                if (visitArchive(archive)) {
                    WalkFileTreeResult archiveResult = traverseArchive(archive);
                    visit(archiveResult, traverseMode);
                }
            }
        }
    }

    private WalkFileTreeResult traverseArchive(IResFile archiveLike) {
        List<Path> files = new ArrayList<>();
        List<Path> dirs = new ArrayList<>();
        files.add(archiveLike.getPath());
        int errorCnt = 0;
        Set<String> entries = archiveLike.getEntries();
        for (String entry : entries) {
            try {
                Path innerPath = Resource.INSTANCE.archivePath(archiveLike.getPath(), entry);
                if (PathExtensionsKt.isDirectory(innerPath)) {
                    dirs.add(innerPath);
                } else {
                    files.add(innerPath);
                }
            } catch (Exception e) {
                logger.error("invalid inner zip file: `{}!/{}` {} {}", 
                    archiveLike, entry, e.getClass(), e.getMessage());
                logger.debug("invalid inner zip file: `{}!/{}`", archiveLike, entry, e);
                if (errorCnt++ >= 10) {
                    logger.error("Skip invalid zip file: `{}`", archiveLike);
                    break;
                }
            }
        }
        return new WalkFileTreeResult(archiveLike.getPath(), files, dirs);
    }

    public void visitFile(@NotNull IResFile file) {
        // Default implementation does nothing
    }

    public boolean visitArchive(@NotNull IResFile file) {
        try {
            if ("apk".equals(file.getExtension())) {
                return false;
            }
            if (MainConfig.getExcludeFiles().contains(file.getName())) {
                return false;
            }
            if (file.resolve("java.base/module-info.java").getExists()) {
                return false;
            }
            if (file.resolve("jdk.zipfs/module-info.java").getExists()) {
                return false;
            }
            if (file.getZipLike() 
                && file.resolve("AndroidManifest.xml").getExists() 
                && !"aar".equals(file.getExtension())) {
                return false;
            }
        } catch (Exception ignored) {
        }
        return true;
    }

    public void visitDirectory(@NotNull IResDirectory dir) {
        // Default implementation does nothing
    }
}
