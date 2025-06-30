/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  com.github.javaparser.ParseResult
 *  com.github.javaparser.ast.CompilationUnit
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.feysh.corax.cache.analysis.CompilationUnitAnalysisDataFactory;
import com.feysh.corax.cache.analysis.CompilationUnitAnalysisKey;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006RB\u0010\u0007\u001a0\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\t0\bj\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lcom/feysh/corax/cache/analysis/CompilationUnitAnalysisDataFactory;", "Lcom/feysh/corax/cache/AnalysisDataFactory;", "Lcom/github/javaparser/ParseResult;", "Lcom/github/javaparser/ast/CompilationUnit;", "Lcom/feysh/corax/cache/analysis/CompilationUnitAnalysisKey;", "<init>", "()V", "cache", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "Lcom/feysh/corax/cache/XOptional;", "Lcom/feysh/corax/cache/XLoadingCache;", "getCache", "()Lcom/github/benmanes/caffeine/cache/LoadingCache;", "key", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "getKey", "()Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "corax-config-api"})
public final class CompilationUnitAnalysisDataFactory
implements AnalysisDataFactory<ParseResult<CompilationUnit>, CompilationUnitAnalysisKey> {
    @NotNull
    public static final CompilationUnitAnalysisDataFactory INSTANCE = new CompilationUnitAnalysisDataFactory();
    @NotNull
    private static final LoadingCache<CompilationUnitAnalysisKey, XOptional<ParseResult<CompilationUnit>>> cache = AnalysisCacheKt.buildX(AnalysisDataFactory.Companion.getDefaultBuilder(), cache.1.INSTANCE);
    @NotNull
    private static final AnalysisDataFactory.Key<ParseResult<CompilationUnit>> key = new AnalysisDataFactory.Key<ParseResult<CompilationUnit>>(){};

    private CompilationUnitAnalysisDataFactory() {
    }

    @Override
    @NotNull
    public LoadingCache<CompilationUnitAnalysisKey, XOptional<ParseResult<CompilationUnit>>> getCache() {
        return cache;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<ParseResult<CompilationUnit>> getKey() {
        return key;
    }

    static {
        AnalysisCache.G.INSTANCE.registerFactory(INSTANCE);
    }
}

