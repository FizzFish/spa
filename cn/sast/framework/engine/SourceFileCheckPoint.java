package cn.sast.framework.engine;

import cn.sast.api.config.MainConfig;
import cn.sast.api.report.DefaultEnv;
import cn.sast.api.report.FileResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import com.feysh.corax.config.api.ISourceFileCheckPoint;
import com.feysh.corax.config.api.report.Region;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class SourceFileCheckPoint extends CheckPoint implements ISourceFileCheckPoint, Closeable {
    private static final Logger logger = LoggerFactory.getLogger(SourceFileCheckPoint.class);
    private static final ExecutorService ioExecutor = Executors.newCachedThreadPool();

    private final IResFile sFile;
    private final MainConfig mainConfig;
    private final Path path;
    private final IBugResInfo file;
    
    private byte[] bytes;
    private String text;
    private List<IndexedValue<String>> lines;

    public SourceFileCheckPoint(@NotNull IResFile sFile, @NotNull MainConfig mainConfig) {
        if (sFile == null) throw new NullPointerException("sFile is null");
        if (mainConfig == null) throw new NullPointerException("mainConfig is null");
        
        this.sFile = sFile;
        this.mainConfig = mainConfig;
        this.path = sFile.getPath();
        this.file = new FileResInfo(sFile);
    }

    @NotNull
    public MainConfig getMainConfig() {
        return mainConfig;
    }

    @Override
    @NotNull
    public Path getPath() {
        return path;
    }

    @Override
    @NotNull
    public MainConfig.RelativePath getRelativePath() {
        return mainConfig.tryGetRelativePath(sFile);
    }

    @Override
    @NotNull
    public URI getUri() {
        return sFile.getUri();
    }

    @Override
    @Nullable
    public Path getArchiveFile() {
        return sFile.isJarScheme() ? sFile.getSchemePath().toAbsolutePath() : null;
    }

    @Override
    @NotNull
    public IBugResInfo getFile() {
        return file;
    }

    @Override
    @NotNull
    public DefaultEnv getEnv$corax_framework() {
        return new DefaultEnv(Region.ERROR.getMutable(), null, null, null, null, null, null, null, null, 510, null);
    }

    @Override
    public CompletableFuture<byte[]> readAllBytes() {
        if (bytes != null) {
            return CompletableFuture.completedFuture(bytes);
        }
        return CompletableFuture.supplyAsync(() -> {
            try {
                bytes = sFile.readAllBytes();
                return bytes;
            } catch (IOException e) {
                throw new RuntimeException("Failed to read file bytes", e);
            }
        }, ioExecutor);
    }

    @Override
    public CompletableFuture<String> text() {
        if (text != null) {
            return CompletableFuture.completedFuture(text);
        }
        return readAllBytes().thenApplyAsync(bytes -> {
            try {
                text = new String(bytes, "UTF-8");
                return text;
            } catch (Exception e) {
                logger.error("Failed to read file text: {}", path, e);
                return null;
            }
        }, ioExecutor);
    }

    @Override
    public CompletableFuture<List<IndexedValue<String>>> lines() {
        if (lines != null) {
            return CompletableFuture.completedFuture(lines);
        }
        return text().thenApplyAsync(text -> {
            if (text == null) {
                return List.of();
            }
            
            String[] split = text.split("\n");
            List<IndexedValue<String>> result = new ArrayList<>(split.length);
            for (int i = 0; i < split.length; i++) {
                result.add(new IndexedValue<>(i + 1, split[i]));
            }
            lines = result;
            return result;
        }, ioExecutor);
    }

    @Override
    public void close() {
        text = null;
        lines = null;
        bytes = null;
    }

    @Override
    @NotNull
    public String getFilename() {
        return ISourceFileCheckPoint.super.getFilename();
    }

    private static class IndexedValue<T> {
        private final int index;
        private final T value;

        public IndexedValue(int index, T value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public T getValue() {
            return value;
        }
    }
}
