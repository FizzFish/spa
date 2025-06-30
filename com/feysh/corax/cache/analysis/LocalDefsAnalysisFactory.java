/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  soot.toolkits.scalar.LocalDefs
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.feysh.corax.cache.analysis.LocalDefsAnalysis;
import com.feysh.corax.cache.analysis.LocalDefsAnalysisFactory;
import com.github.benmanes.caffeine.cache.LoadingCache;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import soot.toolkits.scalar.LocalDefs;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005R6\u0010\u0006\u001a$\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0002`\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lcom/feysh/corax/cache/analysis/LocalDefsAnalysisFactory;", "Lcom/feysh/corax/cache/AnalysisDataFactory;", "Lsoot/toolkits/scalar/LocalDefs;", "Lcom/feysh/corax/cache/analysis/LocalDefsAnalysis;", "<init>", "()V", "cache", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "Lcom/feysh/corax/cache/XOptional;", "Lcom/feysh/corax/cache/XLoadingCache;", "getCache", "()Lcom/github/benmanes/caffeine/cache/LoadingCache;", "key", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "getKey", "()Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "corax-config-api"})
public final class LocalDefsAnalysisFactory
implements AnalysisDataFactory<LocalDefs, LocalDefsAnalysis> {
    @NotNull
    public static final LocalDefsAnalysisFactory INSTANCE = new LocalDefsAnalysisFactory();
    @NotNull
    private static final LoadingCache<LocalDefsAnalysis, XOptional<LocalDefs>> cache = AnalysisCacheKt.buildX(AnalysisDataFactory.Companion.getDefaultBuilder(), cache.1.INSTANCE);
    @NotNull
    private static final AnalysisDataFactory.Key<LocalDefs> key = new AnalysisDataFactory.Key<LocalDefs>(){};

    private LocalDefsAnalysisFactory() {
    }

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
        AnalysisCache.G.INSTANCE.registerFactory(INSTANCE);
    }
}

