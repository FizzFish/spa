package cn.sast.common;

import com.google.common.cache.CacheLoader;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;
import org.apache.commons.compress.archivers.zip.ZipFile;
import soot.util.SharedCloseable;

public class SharedZipFileCacheWrapper {
    private final SharedResourceCache<Path, ZipFile> cache;

    public SharedZipFileCacheWrapper(int initSize, int maxSize) {
        this.cache = new SharedResourceCache<>(initSize, maxSize, new ZipFileCacheLoader());
    }

    public SharedCloseable<ZipFile> getRef(Path archivePath) throws ExecutionException {
        return cache.get(archivePath);
    }

    public void invalidateAll() {
        cache.invalidateAll();
    }

    private static class ZipFileCacheLoader extends CacheLoader<Path, ZipFile> {
        @Override
        public ZipFile load(Path key) throws Exception {
            return new ZipFile(key.toFile());
        }
    }
}