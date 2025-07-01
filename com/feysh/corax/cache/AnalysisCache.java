package com.feysh.corax.cache;

import com.feysh.corax.cache.analysis.CompilationUnitOfSCFactory;
import com.feysh.corax.cache.analysis.CompilationUnitOfSCKey;
import com.feysh.corax.cache.analysis.SootHostExtInfoFactory;
import com.feysh.corax.cache.analysis.SootHostExtend;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.SootClass;
import soot.tagkit.Host;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;

/**
 * A lightweight, thread‑safe cache for analysis artefacts.
 * <p>
 *     • A factory must first be registered via {@link #registerFactory(AnalysisDataFactory)}. <br>
 *     • {@link #get(AnalysisKey)} returns the value synchronously, throwing if no factory is registered. <br>
 *     • {@link #getAsync(AnalysisKey, Executor)} provides an async wrapper backed by the supplied executor. <br>
 * </p>
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class AnalysisCache {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnalysisCache.class);

    /**
     * Key → Factory mapping.  We keep insertion order mainly for deterministic iteration in {@link #clear()}.
     */
    private final Map<AnalysisDataFactory.Key<?>, AnalysisDataFactory<?, ?>> factoryMap = new LinkedHashMap<>();

    /* ---------------------------------------------------------------------- */
    /*  Public API                                                            */
    /* ---------------------------------------------------------------------- */

    /**
     * Async convenience around {@link #get(AnalysisKey)}.
     */
    public <T> CompletableFuture<T> getAsync(AnalysisKey<T> key, Executor executor) {
        Objects.requireNonNull(key, "key");
        Objects.requireNonNull(executor, "executor");
        return CompletableFuture.supplyAsync(() -> get(key), executor);
    }

    /**
     * Uses the common ForkJoinPool for background work.
     */
    public <T> CompletableFuture<T> getAsync(AnalysisKey<T> key) {
        return getAsync(key, ForkJoinPool.commonPool());
    }

    /**
     * Synchronously resolve the value associated with the given key.
     *
     * @throws IllegalStateException if the corresponding factory has not been registered.
     */
    public <T> T get(AnalysisKey<T> key) {
        Objects.requireNonNull(key, "key");
        AnalysisDataFactory<?, ?> rawFactory = factoryMap.get(key.getFactoryKey());
        if (!(rawFactory instanceof AnalysisDataFactory<?, ?> factory)) {
            throw new IllegalStateException("Did you forget to call registerFactory(" + key.getFactoryKey() + ")?");
        }
        //noinspection unchecked – the factory enforces correct types.
        XOptional<T> opt = (XOptional<T>) factory.getCache().get(key);
        return opt.getValue();
    }

    /** Register a factory before querying its keys. */
    public <T, K extends AnalysisKey<T>> void registerFactory(AnalysisDataFactory<T, K> factory) {
        Objects.requireNonNull(factory, "factory");
        factoryMap.put(factory.getKey(), factory);
    }

    /**
     * Clears all underlying Caffeine caches and frees memory.
     */
    public void clear() {
        factoryMap.values().forEach(f -> f.getCache().cleanUp());
    }

    /* ---------------------------------------------------------------------- */
    /*  Nested global cache                                                   */
    /* ---------------------------------------------------------------------- */

    /**
     * A process‑wide singleton cache for commonly reused analysis objects.
     */
    public static class GlobalAnalysisCache extends AnalysisCache {

        private final Cache<Object, Object> analysisCache = Caffeine.newBuilder().build();

        private CompilationUnitOfSCFactory compilationUnitOfSCFactory;
        private SootHostExtInfoFactory sootHostExtInfoFactory;

        // ------------------------------------------------------------------
        //  Dependency injection
        // ------------------------------------------------------------------
        public CompilationUnitOfSCFactory getCompilationUnitOfSCFactory() {
            return Objects.requireNonNull(compilationUnitOfSCFactory, "compilationUnitOfSCFactory not set");
        }

        public void setCompilationUnitOfSCFactory(CompilationUnitOfSCFactory factory) {
            this.compilationUnitOfSCFactory = Objects.requireNonNull(factory);
        }

        public SootHostExtInfoFactory getSootHostExtInfoFactory() {
            return Objects.requireNonNull(sootHostExtInfoFactory, "sootHostExtInfoFactory not set");
        }

        public void setSootHostExtInfoFactory(SootHostExtInfoFactory factory) {
            this.sootHostExtInfoFactory = Objects.requireNonNull(factory);
        }

        // ------------------------------------------------------------------
        //  Helper shortcuts
        // ------------------------------------------------------------------
        public CompilationUnitOfSCKey class2CompilationUnit(SootClass sc) {
            Objects.requireNonNull(sc, "sc");
            return new CompilationUnitOfSCKey(sc, getCompilationUnitOfSCFactory().getKey());
        }

        public Path class2SourceFile(SootClass sc) {
            Objects.requireNonNull(sc, "sc");
            return (Path) getCompilationUnitOfSCFactory().getLocator().apply(sc);
        }

        public SootHostExtend sootHost2decl(Host host) {
            Objects.requireNonNull(host, "host");
            return com.feysh.corax.cache.analysis.SootHostExtendKt.ext(
                    host,
                    G.INSTANCE,
                    getSootHostExtInfoFactory().getKey()
            );
        }

        public Cache<Object, Object> getAnalysisCache() {
            return analysisCache;
        }
    }

    /**
     * Singleton holder for {@link GlobalAnalysisCache}.  Named <code>G</code> to preserve historical Kotlin symbol.
     */
    public static final class G extends GlobalAnalysisCache {
        public static final G INSTANCE = new G();
        private G() {}
    }
}
