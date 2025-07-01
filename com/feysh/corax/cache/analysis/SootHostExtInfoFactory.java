package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.tagkit.Host;

public final class SootHostExtInfoFactory implements AnalysisDataFactory<SootHostExtend, SootHostExtInfoKey> {
    @NotNull
    private final JavaParser p;
    @NotNull
    private final LoadingCache<SootHostExtInfoKey, XOptional<SootHostExtend>> cache;
    @NotNull
    private final AnalysisDataFactory.Key<SootHostExtend> key;

    public SootHostExtInfoFactory(@NotNull CompilationUnitOfSCFactory scFactory) {
        if (scFactory == null) {
            throw new IllegalArgumentException("scFactory cannot be null");
        }
        
        this.p = new JavaParser();
        this.cache = AnalysisCacheKt.buildX(
            AnalysisDataFactory.Companion.getDefaultBuilder(),
            new CacheLoader<SootHostExtInfoKey, SootHostExtend>() {
                private final CompilationUnitOfSCFactory scFactory = scFactory;

                @Override
                public SootHostExtend load(SootHostExtInfoKey key) {
                    Host host = key.getHost();
                    SootClass sootClass = null;

                    if (host instanceof SootClass) {
                        sootClass = (SootClass) host;
                    } else if (host instanceof SootField) {
                        sootClass = ((SootField) host).getDeclaringClass();
                    } else if (host instanceof SootMethod) {
                        sootClass = ((SootMethod) host).getDeclaringClass();
                    } else {
                        return null;
                    }

                    if (sootClass == null) {
                        return null;
                    }

                    ParseResult<CompilationUnit> parseResult = AnalysisCache.G.INSTANCE.get(
                        new CompilationUnitOfSCKey(sootClass, scFactory.getKey())
                    );

                    if (parseResult == null || !parseResult.getResult().isPresent()) {
                        return null;
                    }

                    CompilationUnit compilationUnit = parseResult.getResult().get();

                    if (host instanceof SootClass) {
                        return new SootClassExtend((SootClass) host, compilationUnit);
                    } else if (host instanceof SootField) {
                        return new SootFieldExtend((SootField) host, compilationUnit);
                    } else if (host instanceof SootMethod) {
                        return new SootMethodExtend((SootMethod) host, compilationUnit);
                    }
                    return null;
                }
            }
        );
        this.key = new AnalysisDataFactory.Key<SootHostExtend>() {};
        AnalysisCache.G.INSTANCE.registerFactory(this);
    }

    @NotNull
    public JavaParser getP() {
        return p;
    }

    @Override
    @NotNull
    public LoadingCache<SootHostExtInfoKey, XOptional<SootHostExtend>> getCache() {
        return cache;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<SootHostExtend> getKey() {
        return key;
    }
}