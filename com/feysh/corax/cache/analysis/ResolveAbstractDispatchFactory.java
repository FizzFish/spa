/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  soot.SootMethod
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.feysh.corax.cache.analysis.ResolveAbstractDispatchFactory;
import com.feysh.corax.cache.analysis.ResolveAbstractDispatchKey;
import com.github.benmanes.caffeine.cache.LoadingCache;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006RB\u0010\u0007\u001a0\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\t0\bj\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lcom/feysh/corax/cache/analysis/ResolveAbstractDispatchFactory;", "Lcom/feysh/corax/cache/AnalysisDataFactory;", "", "Lsoot/SootMethod;", "Lcom/feysh/corax/cache/analysis/ResolveAbstractDispatchKey;", "<init>", "()V", "cache", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "Lcom/feysh/corax/cache/XOptional;", "Lcom/feysh/corax/cache/XLoadingCache;", "getCache", "()Lcom/github/benmanes/caffeine/cache/LoadingCache;", "key", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "getKey", "()Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "corax-config-api"})
public final class ResolveAbstractDispatchFactory
implements AnalysisDataFactory<Set<? extends SootMethod>, ResolveAbstractDispatchKey> {
    @NotNull
    public static final ResolveAbstractDispatchFactory INSTANCE = new ResolveAbstractDispatchFactory();
    @NotNull
    private static final LoadingCache<ResolveAbstractDispatchKey, XOptional<Set<SootMethod>>> cache = AnalysisCacheKt.buildX(AnalysisDataFactory.Companion.getDefaultBuilder(), cache.1.INSTANCE);
    @NotNull
    private static final AnalysisDataFactory.Key<Set<SootMethod>> key = new AnalysisDataFactory.Key<Set<? extends SootMethod>>(){};

    private ResolveAbstractDispatchFactory() {
    }

    @Override
    @NotNull
    public LoadingCache<ResolveAbstractDispatchKey, XOptional<Set<SootMethod>>> getCache() {
        return cache;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<Set<SootMethod>> getKey() {
        return key;
    }

    static {
        AnalysisCache.G.INSTANCE.registerFactory(INSTANCE);
    }
}

