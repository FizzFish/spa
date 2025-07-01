import cn.sast.common.FileSystemLocator;
import cn.sast.common.IResource;
import cn.sast.framework.report.FileIndexer;
import cn.sast.framework.report.FileIndexerBuilder;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import kotlin.Pair;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Function;

public final class FileSystemCacheLocator {
    public static final FileSystemCacheLocator INSTANCE = new FileSystemCacheLocator();
    private static final LoadingCache<Pair<IResource, FileSystemLocator.TraverseMode>, Deferred<FileIndexer>> cache;

    private FileSystemCacheLocator() {
    }

    @NotNull
    public LoadingCache<Pair<IResource, FileSystemLocator.TraverseMode>, Deferred<FileIndexer>> getCache() {
        return cache;
    }

    private Deferred<FileIndexer> getFileIndexer(IResource res, FileSystemLocator.TraverseMode traverseMode) {
        return cache.get(new Pair<>(res, traverseMode));
    }

    public FileIndexerBuilder getIndexer(Set<? extends IResource> resources, FileSystemLocator.TraverseMode traverseMode) {
        FileIndexerBuilder builder = new FileIndexerBuilder();
        List<Deferred<FileIndexer>> deferredList = new ArrayList<>(resources.size());
        
        for (IResource res : resources) {
            deferredList.add(getFileIndexer(res, traverseMode));
        }
        
        for (Deferred<FileIndexer> deferred : deferredList) {
            builder.union(deferred.getCompleted());
        }
        
        return builder;
    }

    public void clear() {
        cache.cleanUp();
    }

    static {
        CacheLoader<Pair<IResource, FileSystemLocator.TraverseMode>, Deferred<FileIndexer>> loader = 
            pair -> GlobalScope.INSTANCE.async(() -> 
                FileIndexerBuilder.createIndexer(pair.getFirst(), pair.getSecond())
            );
            
        cache = Caffeine.newBuilder()
            .build(loader);
    }
}