package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.LoadingCache;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootMethod;

public final class ResolveAbstractDispatchFactory 
    implements AnalysisDataFactory<Set<SootMethod>, ResolveAbstractDispatchKey> {

    public static final ResolveAbstractDispatchFactory INSTANCE = new ResolveAbstractDispatchFactory();

    @NotNull
    private static final LoadingCache<ResolveAbstractDispatchKey, XOptional<Set<SootMethod>>> cache = AnalysisCacheKt.buildX(AnalysisDataFactory.Companion.getDefaultBuilder(), new CacheLoader() { // from class: com.feysh.corax.cache.analysis.ResolveAbstractDispatchFactory$cache$1
        public final Set<SootMethod> load(ResolveAbstractDispatchKey key2) {
            return Scene.v().getOrMakeFastHierarchy().resolveAbstractDispatch(key2.getBaseType(), key2.getSourceMethodRef());
        }
    });


    @NotNull
    private static final AnalysisDataFactory.Key<Set<SootMethod>> key = new AnalysisDataFactory.Key<>() {};

    private ResolveAbstractDispatchFactory() {}

    @Override
    public @NotNull LoadingCache<ResolveAbstractDispatchKey, XOptional<Set<SootMethod>>> getCache() {
        return cache;
    }

    @Override
    public @NotNull Key<Set<SootMethod>> getKey() {
        return key;
    }

    static {
        AnalysisCache.G.INSTANCE.registerFactory(INSTANCE);
    }
}
