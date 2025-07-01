package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.feysh.corax.cache.analysis.defuse.SimpleLocalUses;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.jetbrains.annotations.NotNull;
import soot.Unit;
import soot.toolkits.scalar.LocalDefs;
import soot.toolkits.scalar.LocalUses;

public final class LocalUsesAnalysisFactory implements AnalysisDataFactory<LocalUses, LocalUsesAnalysis> {
    public static final LocalUsesAnalysisFactory INSTANCE = new LocalUsesAnalysisFactory();
    private static final LoadingCache<LocalUsesAnalysis, XOptional<LocalUses>> cache = AnalysisCacheKt.buildX(AnalysisDataFactory.Companion.getDefaultBuilder(), new CacheLoader() { // from class: com.feysh.corax.cache.analysis.LocalUsesAnalysisFactory$cache$1
        public final LocalUses load(LocalUsesAnalysis key2) {
            return new SimpleLocalUses((Iterable<Unit>) key2.getGraph(), (LocalDefs) AnalysisCache.G.INSTANCE.get(new LocalDefsAnalysis(key2.getGraph(), key2.getLocals(), key2.getMode())));
        }
    });

    private static final AnalysisDataFactory.Key<LocalUses> key = new AnalysisDataFactory.Key<LocalUses>() {};

    private LocalUsesAnalysisFactory() {}

    @Override
    @NotNull
    public LoadingCache<LocalUsesAnalysis, XOptional<LocalUses>> getCache() {
        return cache;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<LocalUses> getKey() {
        return key;
    }

    static {
        AnalysisCache.G.INSTANCE.registerFactory(INSTANCE);
    }
}
