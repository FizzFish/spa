package cn.sast.coroutines.caffine.impl;

import cn.sast.coroutines.caffine.impl.WeakEntryHolder;
import cn.sast.graph.NoBackEdgeDirectGraph;
import com.feysh.corax.cache.coroutines.RecCoroutineCache;
import com.feysh.corax.cache.coroutines.XCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Interner;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Function;

public class RecCoroutineCacheImpl<K, V> implements RecCoroutineCache<K, V> {
    @NotNull
    private final XCache<K, Deferred<V>> xCache;
    @NotNull
    private final Cache<K, Deferred<V>> cache;
    @NotNull
    private final Function1<V, Object[]> weakKeyAssociateByValue;
    @NotNull
    private final Cache<K, Deferred<V>> lruCache;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final Interner<K> interner;
    @NotNull
    private final NoBackEdgeDirectGraph<Object> noBackEdgeDirectGraph;
    @NotNull
    private final WeakEntryHolder<K, Object> weakHolder;
    private int _x;

    public RecCoroutineCacheImpl(@NotNull XCache<K, Deferred<V>> xCache, 
                                @NotNull Cache<K, Deferred<V>> cache,
                                @NotNull Function1<? super V, Object[]> weakKeyAssociateByValue) {
        Objects.requireNonNull(xCache, "xCache");
        Objects.requireNonNull(cache, "cache");
        Objects.requireNonNull(weakKeyAssociateByValue, "weakKeyAssociateByValue");
        
        this.xCache = xCache;
        this.cache = cache;
        this.weakKeyAssociateByValue = weakKeyAssociateByValue;
        this.lruCache = Caffeine.newBuilder()
                .initialCapacity(2000)
                .maximumSize(10000L)
                .build();
        this.scope = xCache.getDefaultScope().getValue();
        this.interner = Interner.newWeakInterner();
        this.noBackEdgeDirectGraph = new NoBackEdgeDirectGraph<>();
        this.weakHolder = new WeakEntryHolder<>();
    }

    @NotNull
    public final CoroutineScope getScope() {
        return scope;
    }

    @NotNull
    public CacheStats getCacheStats() {
        return cache.stats();
    }

    private Object recursiveId(CoroutineContext context) {
        Object id = context.get(RecursiveContext.Key);
        if (id == null) {
            throw new IllegalStateException("current coroutine context has no RecursiveContext");
        }
        return ((RecursiveContext) id).getId();
    }

    @Nullable
    public Object get(K key, @NotNull Function3<? super RecCoroutineCache<K, V>, ? super K, ? super Continuation<? super V>, ?> mappingFunction,
                     @NotNull Continuation<? super Deferred<? extends V>> completion) {
        // Implementation simplified - actual suspend logic would need proper coroutine handling
        CoroutineContext ctx = completion.getContext();
        Job parentJob = JobKt.getJob(ctx);
        Object src = recursiveId(ctx);
        return get(src, parentJob, key, mappingFunction);
    }

    private Deferred<V> get(Object src, Job parentJob, K key, Function3<? super RecCoroutineCache<K, V>, ? super K, ? super Continuation<? super V>, ?> mappingFunction) {
        K canonicalKey = interner.intern(key);
        Ref.BooleanRef mapped = new Ref.BooleanRef();
        
        Function<K, Deferred<V>> mapping = k -> {
            if (mapped.element) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            mapped.element = true;
            RecID id = new RecID();
            if (!noBackEdgeDirectGraph.addEdgeSynchronized(src, id)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            return BuildersKt.async(scope, new RecursiveContext(id).plus(parentJob), CoroutineStart.DEFAULT, 
                    (scope, cont) -> mappingFunction.invoke(this, key, cont));
        };

        Ref.ObjectRef<Deferred<V>> deferred = new Ref.ObjectRef<>();
        deferred.element = cache.get(canonicalKey, mapping);

        if (deferred.element.isCancelled() && !parentJob.isCancelled()) {
            cache.asMap().remove(canonicalKey);
            mapped.element = false;
            deferred.element = cache.get(canonicalKey, mapping);
        }

        lruCache.get(canonicalKey, k -> deferred.element);

        Object tgt = recursiveId(deferred.element.getCoroutineContext());
        if (!mapped.element) {
            if (deferred.element.isCompleted()) {
                return deferred.element;
            }
            if (!noBackEdgeDirectGraph.addEdgeSynchronized(src, tgt)) {
                return null;
            }
        }

        deferred.element.invokeOnCompletion(cause -> {
            _x += System.identityHashCode(deferred.element) + System.identityHashCode(canonicalKey);
            noBackEdgeDirectGraph.removeEdgeSynchronized(src, tgt);
            return null;
        });

        return deferred.element;
    }

    @Nullable
    public Object getEntry(K key, @NotNull Function3<? super RecCoroutineCache<K, V>, ? super K, ? super Continuation<? super V>, ?> mappingFunction,
                          @NotNull Continuation<? super Deferred<? extends V>> completion) {
        return get(new EntryRecID(), JobKt.getJob(completion.getContext()), key, mappingFunction);
    }

    public boolean validateAfterFinished() {
        if (!noBackEdgeDirectGraph.isComplete()) {
            logger.error(() -> noBackEdgeDirectGraph + " is not complete");
            return false;
        }
        return true;
    }

    public long getSize() {
        return cache.estimatedSize();
    }

    public void cleanUp() {
        cache.cleanUp();
        noBackEdgeDirectGraph.cleanUp();
        weakHolder.clean();
        lruCache.cleanUp();
    }

    @Nullable
    public Object getPredSize(@NotNull Continuation<? super Integer> completion) {
        Object src = recursiveId(completion.getContext());
        return noBackEdgeDirectGraph.getPredSize(src);
    }

    private static class RecursiveContext implements CoroutineContext.Element {
        public static final Key Key = new Key();
        private final Object id;

        public RecursiveContext(Object id) {
            this.id = id;
        }

        public Object getId() {
            return id;
        }

        @Override
        public Key getKey() {
            return Key;
        }

        public static class Key implements CoroutineContext.Key<RecursiveContext> {}
    }

    private static class RecID {}
    private static class EntryRecID extends RecID {}
}
