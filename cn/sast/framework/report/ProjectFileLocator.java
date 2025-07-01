package cn.sast.framework.report;

import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.FileResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.api.util.IMonitor;
import cn.sast.common.FileSystemLocator;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.ResourceKt;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.sequences.Sequence;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ProjectFileLocator implements IProjectFileLocator {
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(() -> Unit.INSTANCE);

    @Nullable
    private final IMonitor monitor;
    @NotNull
    private Set<? extends IResource> sourceDir;
    @Nullable
    private final IResDirectory fileWrapperOutPutDir;
    @NotNull
    private FileSystemLocator.TraverseMode traverseMode;
    private final boolean enableInfo;
    
    private CompletableFuture<FileIndexer> updateJob;
    @NotNull
    private final CacheLoader<Pair<IBugResInfo, IWrapperFileGenerator>, IResFile> loader;
    @NotNull
    private final LoadingCache<Pair<IBugResInfo, IWrapperFileGenerator>, IResFile> cache;

    public ProjectFileLocator(@Nullable IMonitor monitor, 
                            @NotNull Set<? extends IResource> sourceDir,
                            @Nullable IResDirectory fileWrapperOutPutDir,
                            @NotNull FileSystemLocator.TraverseMode traverseMode,
                            boolean enableInfo) {
        this.monitor = monitor;
        this.sourceDir = sourceDir;
        this.fileWrapperOutPutDir = fileWrapperOutPutDir;
        this.traverseMode = traverseMode;
        this.enableInfo = enableInfo;
        
        this.loader = key -> {
            IBugResInfo resInfo = key.getFirst();
            IWrapperFileGenerator generator = key.getSecond();
            if (resInfo instanceof ClassResInfo) {
                return get((ClassResInfo) resInfo, generator);
            } else if (resInfo instanceof FileResInfo) {
                return get((FileResInfo) resInfo, generator);
            }
            return null;
        };
        
        this.cache = Caffeine.newBuilder()
                .softValues()
                .maximumSize(8000)
                .build(loader);
    }

    @NotNull
    public Set<IResource> getSourceDir() {
        return sourceDir;
    }

    public void setSourceDir(@NotNull Set<? extends IResource> sourceDir) {
        this.sourceDir = sourceDir;
    }

    private FileIndexer indexer() throws ExecutionException, InterruptedException {
        if (updateJob == null) {
            throw new IllegalStateException("update at first!");
        }
        return updateJob.get();
    }

    public void update() {
        if (updateJob != null) {
            throw new IllegalStateException("Check failed.");
        }
        updateJob = CompletableFuture.supplyAsync(() -> {
            FileIndexer indexer = new FileIndexer(sourceDir, traverseMode, enableInfo);
            if (monitor != null) {
                monitor.log("Start indexing...");
            }
            indexer.update();
            if (monitor != null) {
                monitor.log("Indexing completed");
            }
            return indexer;
        });
    }

    @NotNull
    public Sequence<IResFile> findFromFileIndexMap(@NotNull List<String> parentSubPath, 
                                                  @NotNull AbstractFileIndexer.CompareMode mode) {
        try {
            return indexer().findFromFileIndexMap(parentSubPath, mode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public long totalFiles() {
        try {
            return indexer().getFileNameToPathMap().values().stream()
                    .mapToLong(Set::size)
                    .sum();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public long totalJavaSrcFiles() {
        try {
            Map<String, Set<IResFile>> extensionToPathMap = indexer().getExtensionToPathMap();
            return ResourceKt.getJavaExtensions().stream()
                    .mapToLong(ext -> extensionToPathMap.getOrDefault(ext, Set.of()).size())
                    .sum();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    private IResFile makeWrapperFile(IBugResInfo resInfo, IWrapperFileGenerator fileWrapperIfNotEExists) {
        if (fileWrapperOutPutDir == null) {
            return null;
        }
        return fileWrapperIfNotEExists.makeWrapperFile(fileWrapperOutPutDir, resInfo);
    }

    @Nullable
    private IResFile get(ClassResInfo resInfo, IWrapperFileGenerator fileWrapperIfNotEExists) {
        try {
            IResFile found = indexer().findAnyFile(resInfo.getSourceFile(), AbstractFileIndexer.getDefaultClassCompareMode());
            return found != null ? found : makeWrapperFile(resInfo, fileWrapperIfNotEExists);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    private IResFile get(FileResInfo resInfo, IWrapperFileGenerator fileWrapperIfNotEExists) {
        if (resInfo.getSourcePath().getExists()) {
            return resInfo.getSourcePath();
        }
        return makeWrapperFile(resInfo, fileWrapperIfNotEExists);
    }

    @Nullable
    public IResFile get(@NotNull IBugResInfo resInfo, @NotNull IWrapperFileGenerator fileWrapperIfNotEExists) {
        return cache.get(Pair.create(resInfo, fileWrapperIfNotEExists));
    }

    @NotNull
    public String toString() {
        return "Source-Locator@" + System.identityHashCode(this);
    }
}
