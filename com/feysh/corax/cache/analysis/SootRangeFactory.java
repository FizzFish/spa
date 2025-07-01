package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.jetbrains.annotations.NotNull;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import kotlin.Pair;

public final class SootRangeFactory implements AnalysisDataFactory<Map.Entry<Integer, Integer>, SootRangeKey> {
    @NotNull
    public static final SootRangeFactory INSTANCE = new SootRangeFactory();
    
    @NotNull
    private static final LoadingCache<SootRangeKey, XOptional<Pair<Integer, Integer>>> cache = AnalysisCacheKt.buildX(AnalysisDataFactory.Companion.getDefaultBuilder(), new CacheLoader() { // from class: com.feysh.corax.cache.analysis.SootRangeFactory$cache$1
        public final Pair<Integer, Integer> load(SootRangeKey key2) {
            return SootRangeKt.getRange(key2.getSootMethod());
        }
    });


    @NotNull
    private static final AnalysisDataFactory.Key<Map.Entry<Integer, Integer>> key = 
        new AnalysisDataFactory.Key<Map.Entry<Integer, Integer>>() {};

    private SootRangeFactory() {
    }

    @Override
    @NotNull
    public LoadingCache<SootRangeKey, XOptional<Map.Entry<Integer, Integer>>> getCache() {
        return cache;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<Map.Entry<Integer, Integer>> getKey() {
        return key;
    }

    static {
        AnalysisCache.G.INSTANCE.registerFactory(INSTANCE);
    }
}