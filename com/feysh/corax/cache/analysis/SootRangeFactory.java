/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  kotlin.Metadata
 *  kotlin.Pair
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.feysh.corax.cache.analysis.SootRangeFactory;
import com.feysh.corax.cache.analysis.SootRangeKey;
import com.github.benmanes.caffeine.cache.LoadingCache;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006RR\u0010\u0007\u001a@\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\t0\bj\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002`\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR(\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lcom/feysh/corax/cache/analysis/SootRangeFactory;", "Lcom/feysh/corax/cache/AnalysisDataFactory;", "Lkotlin/Pair;", "", "Lcom/feysh/corax/cache/analysis/SootRangeKey;", "<init>", "()V", "cache", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "Lcom/feysh/corax/cache/XOptional;", "Lcom/feysh/corax/cache/XLoadingCache;", "getCache", "()Lcom/github/benmanes/caffeine/cache/LoadingCache;", "key", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "getKey", "()Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "corax-config-api"})
public final class SootRangeFactory
implements AnalysisDataFactory<Pair<? extends Integer, ? extends Integer>, SootRangeKey> {
    @NotNull
    public static final SootRangeFactory INSTANCE = new SootRangeFactory();
    @NotNull
    private static final LoadingCache<SootRangeKey, XOptional<Pair<Integer, Integer>>> cache = AnalysisCacheKt.buildX(AnalysisDataFactory.Companion.getDefaultBuilder(), cache.1.INSTANCE);
    @NotNull
    private static final AnalysisDataFactory.Key<Pair<Integer, Integer>> key = new AnalysisDataFactory.Key<Pair<? extends Integer, ? extends Integer>>(){};

    private SootRangeFactory() {
    }

    @Override
    @NotNull
    public LoadingCache<SootRangeKey, XOptional<Pair<Integer, Integer>>> getCache() {
        return cache;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<Pair<Integer, Integer>> getKey() {
        return key;
    }

    static {
        AnalysisCache.G.INSTANCE.registerFactory(INSTANCE);
    }
}

