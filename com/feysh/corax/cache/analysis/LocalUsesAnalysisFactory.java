/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  soot.toolkits.scalar.LocalUses
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.feysh.corax.cache.analysis.LocalUsesAnalysis;
import com.feysh.corax.cache.analysis.LocalUsesAnalysisFactory;
import com.github.benmanes.caffeine.cache.LoadingCache;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import soot.toolkits.scalar.LocalUses;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005R6\u0010\u0006\u001a$\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0002`\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lcom/feysh/corax/cache/analysis/LocalUsesAnalysisFactory;", "Lcom/feysh/corax/cache/AnalysisDataFactory;", "Lsoot/toolkits/scalar/LocalUses;", "Lcom/feysh/corax/cache/analysis/LocalUsesAnalysis;", "<init>", "()V", "cache", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "Lcom/feysh/corax/cache/XOptional;", "Lcom/feysh/corax/cache/XLoadingCache;", "getCache", "()Lcom/github/benmanes/caffeine/cache/LoadingCache;", "key", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "getKey", "()Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "corax-config-api"})
public final class LocalUsesAnalysisFactory
implements AnalysisDataFactory<LocalUses, LocalUsesAnalysis> {
    @NotNull
    public static final LocalUsesAnalysisFactory INSTANCE = new LocalUsesAnalysisFactory();
    @NotNull
    private static final LoadingCache<LocalUsesAnalysis, XOptional<LocalUses>> cache = AnalysisCacheKt.buildX(AnalysisDataFactory.Companion.getDefaultBuilder(), cache.1.INSTANCE);
    @NotNull
    private static final AnalysisDataFactory.Key<LocalUses> key = new AnalysisDataFactory.Key<LocalUses>(){};

    private LocalUsesAnalysisFactory() {
    }

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

