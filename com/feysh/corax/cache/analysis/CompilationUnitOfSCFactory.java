/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.benmanes.caffeine.cache.CacheLoader
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  com.github.javaparser.ParseResult
 *  com.github.javaparser.ast.CompilationUnit
 *  kotlin.Metadata
 *  kotlin.io.path.PathsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.SootClass
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.feysh.corax.cache.analysis.CompilationUnitAnalysisKey;
import com.feysh.corax.cache.analysis.CompilationUnitOfSCKey;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.io.path.PathsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u001d\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006\u00a2\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fRF\u0010\r\u001a4\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u000f0\u000ej\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002`\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0014X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2={"Lcom/feysh/corax/cache/analysis/CompilationUnitOfSCFactory;", "Lcom/feysh/corax/cache/AnalysisDataFactory;", "Lcom/github/javaparser/ParseResult;", "Lcom/github/javaparser/ast/CompilationUnit;", "Lcom/feysh/corax/cache/analysis/CompilationUnitOfSCKey;", "locator", "Lkotlin/Function1;", "Lsoot/SootClass;", "Ljava/nio/file/Path;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getLocator", "()Lkotlin/jvm/functions/Function1;", "cache", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "Lcom/feysh/corax/cache/XOptional;", "Lcom/feysh/corax/cache/XLoadingCache;", "getCache", "()Lcom/github/benmanes/caffeine/cache/LoadingCache;", "key", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "getKey", "()Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "corax-config-api"})
public final class CompilationUnitOfSCFactory
implements AnalysisDataFactory<ParseResult<CompilationUnit>, CompilationUnitOfSCKey> {
    @NotNull
    private final Function1<SootClass, Path> locator;
    @NotNull
    private final LoadingCache<CompilationUnitOfSCKey, XOptional<ParseResult<CompilationUnit>>> cache;
    @NotNull
    private final AnalysisDataFactory.Key<ParseResult<CompilationUnit>> key;

    public CompilationUnitOfSCFactory(@NotNull Function1<? super SootClass, ? extends Path> locator) {
        Intrinsics.checkNotNullParameter(locator, (String)"locator");
        this.locator = locator;
        this.cache = AnalysisCacheKt.buildX(AnalysisDataFactory.Companion.getDefaultBuilder(), (CacheLoader)new CacheLoader(this){
            final /* synthetic */ CompilationUnitOfSCFactory this$0;
            {
                this.this$0 = $receiver;
            }

            public final ParseResult<CompilationUnit> load(CompilationUnitOfSCKey key2) {
                Path path = (Path)this.this$0.getLocator().invoke((Object)key2.getSc());
                if (path == null) {
                    return null;
                }
                Path foundFile = path;
                if (!Intrinsics.areEqual((Object)PathsKt.getExtension((Path)foundFile), (Object)"java")) {
                    return null;
                }
                return (ParseResult)AnalysisCache.G.INSTANCE.get(new CompilationUnitAnalysisKey(foundFile));
            }
        });
        this.key = new AnalysisDataFactory.Key<ParseResult<CompilationUnit>>(){};
        AnalysisCache.G.INSTANCE.registerFactory(this);
    }

    @NotNull
    public final Function1<SootClass, Path> getLocator() {
        return this.locator;
    }

    @Override
    @NotNull
    public LoadingCache<CompilationUnitOfSCKey, XOptional<ParseResult<CompilationUnit>>> getCache() {
        return this.cache;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<ParseResult<CompilationUnit>> getKey() {
        return this.key;
    }
}

