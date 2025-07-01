package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.feysh.corax.cache.analysis.defuse.SimpleLocalDefs;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.jetbrains.annotations.NotNull;
import soot.toolkits.scalar.LocalDefs;

public final class LocalDefsAnalysisFactory implements AnalysisDataFactory<LocalDefs, LocalDefsAnalysis> {
    public static final LocalDefsAnalysisFactory INSTANCE = new LocalDefsAnalysisFactory();

    private static final LoadingCache<LocalDefsAnalysis, XOptional<LocalDefs>> cache =
        AnalysisCacheKt.buildX(AnalysisDataFactory.Companion.getDefaultBuilder(), new CacheLoader() { // from class: com.feysh.corax.cache.analysis.LocalDefsAnalysisFactory$cache$1
            public final LocalDefs load(LocalDefsAnalysis key2) {
                return new SimpleLocalDefs(key2.getGraph(), key2.getLocals(), key2.getMode());
            }
        });


    private static final AnalysisDataFactory.Key<LocalDefs> key = new AnalysisDataFactory.Key<>() {};

    private LocalDefsAnalysisFactory() {}

    @Override
    @NotNull
    public LoadingCache<LocalDefsAnalysis, XOptional<LocalDefs>> getCache() {
        return cache;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<LocalDefs> getKey() {
        return key;
    }

    static {
        AnalysisCache.G.registerFactory(INSTANCE);
    }
}