/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.benmanes.caffeine.cache.CacheLoader
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  com.github.javaparser.JavaParser
 *  com.github.javaparser.ParseResult
 *  com.github.javaparser.ast.CompilationUnit
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 *  soot.tagkit.Host
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.feysh.corax.cache.analysis.CompilationUnitOfSCFactory;
import com.feysh.corax.cache.analysis.CompilationUnitOfSCKey;
import com.feysh.corax.cache.analysis.SootClassExtend;
import com.feysh.corax.cache.analysis.SootFieldExtend;
import com.feysh.corax.cache.analysis.SootHostExtInfoKey;
import com.feysh.corax.cache.analysis.SootHostExtend;
import com.feysh.corax.cache.analysis.SootMethodExtend;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.tagkit.Host;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR:\u0010\f\u001a(\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e0\rj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2={"Lcom/feysh/corax/cache/analysis/SootHostExtInfoFactory;", "Lcom/feysh/corax/cache/AnalysisDataFactory;", "Lcom/feysh/corax/cache/analysis/SootHostExtend;", "Lcom/feysh/corax/cache/analysis/SootHostExtInfoKey;", "scFactory", "Lcom/feysh/corax/cache/analysis/CompilationUnitOfSCFactory;", "<init>", "(Lcom/feysh/corax/cache/analysis/CompilationUnitOfSCFactory;)V", "p", "Lcom/github/javaparser/JavaParser;", "getP", "()Lcom/github/javaparser/JavaParser;", "cache", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "Lcom/feysh/corax/cache/XOptional;", "Lcom/feysh/corax/cache/XLoadingCache;", "getCache", "()Lcom/github/benmanes/caffeine/cache/LoadingCache;", "key", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "getKey", "()Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "corax-config-api"})
public final class SootHostExtInfoFactory
implements AnalysisDataFactory<SootHostExtend, SootHostExtInfoKey> {
    @NotNull
    private final JavaParser p;
    @NotNull
    private final LoadingCache<SootHostExtInfoKey, XOptional<SootHostExtend>> cache;
    @NotNull
    private final AnalysisDataFactory.Key<SootHostExtend> key;

    public SootHostExtInfoFactory(@NotNull CompilationUnitOfSCFactory scFactory) {
        Intrinsics.checkNotNullParameter((Object)scFactory, (String)"scFactory");
        this.p = new JavaParser();
        this.cache = AnalysisCacheKt.buildX(AnalysisDataFactory.Companion.getDefaultBuilder(), (CacheLoader)new CacheLoader(scFactory){
            final /* synthetic */ CompilationUnitOfSCFactory $scFactory;
            {
                this.$scFactory = $scFactory;
            }

            public final SootHostExtend load(SootHostExtInfoKey key2) {
                SootClass sootClass;
                Host host = key2.getHost();
                Host host2 = host;
                if (host2 instanceof SootClass) {
                    sootClass = (SootClass)host;
                } else if (host2 instanceof SootField) {
                    sootClass = ((SootField)host).getDeclaringClass();
                } else if (host2 instanceof SootMethod) {
                    sootClass = ((SootMethod)host).getDeclaringClass();
                } else {
                    return null;
                }
                SootClass clazz = sootClass;
                Intrinsics.checkNotNull((Object)clazz);
                ParseResult parseResult = (ParseResult)AnalysisCache.G.INSTANCE.get(new CompilationUnitOfSCKey(clazz, this.$scFactory.getKey()));
                if (parseResult == null) {
                    return null;
                }
                ParseResult cu = parseResult;
                if (!cu.getResult().isPresent()) {
                    return null;
                }
                T t = cu.getResult().get();
                Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
                CompilationUnit compilationUnit = (CompilationUnit)t;
                Host host3 = host;
                return host3 instanceof SootClass ? (SootHostExtend)new SootClassExtend((SootClass)host, compilationUnit) : (host3 instanceof SootField ? (SootHostExtend)new SootFieldExtend((SootField)host, compilationUnit) : (host3 instanceof SootMethod ? (SootHostExtend)new SootMethodExtend((SootMethod)host, compilationUnit) : null));
            }
        });
        this.key = new AnalysisDataFactory.Key<SootHostExtend>(){};
        AnalysisCache.G.INSTANCE.registerFactory(this);
    }

    @NotNull
    public final JavaParser getP() {
        return this.p;
    }

    @Override
    @NotNull
    public LoadingCache<SootHostExtInfoKey, XOptional<SootHostExtend>> getCache() {
        return this.cache;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<SootHostExtend> getKey() {
        return this.key;
    }
}

