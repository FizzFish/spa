/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.SharedZipFileCacheWrapper
 *  cn.sast.common.SharedZipFileCacheWrapper$SharedResourceCache
 *  com.google.common.cache.CacheLoader
 *  org.apache.commons.compress.archivers.zip.ZipFile
 *  soot.util.SharedCloseable
 */
package cn.sast.common;

import cn.sast.common.SharedZipFileCacheWrapper;
import com.google.common.cache.CacheLoader;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;
import org.apache.commons.compress.archivers.zip.ZipFile;
import soot.util.SharedCloseable;

public class SharedZipFileCacheWrapper {
    private final SharedResourceCache<Path, ZipFile> cache;

    public SharedZipFileCacheWrapper(int initSize, int maxSize) {
        this.cache = new SharedResourceCache(initSize, maxSize, (CacheLoader)new /* Unavailable Anonymous Inner Class!! */);
    }

    public SharedCloseable<ZipFile> getRef(Path archivePath) throws ExecutionException {
        return this.cache.get((Object)archivePath);
    }

    public void invalidateAll() {
        this.cache.invalidateAll();
    }
}

