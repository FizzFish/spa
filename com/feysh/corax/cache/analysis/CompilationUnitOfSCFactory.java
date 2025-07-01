package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import java.nio.file.Path;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;

public final class CompilationUnitOfSCFactory implements AnalysisDataFactory<ParseResult<CompilationUnit>, CompilationUnitOfSCKey> {
    @NotNull
    private final Function<SootClass, Path> locator;
    @NotNull
    private final LoadingCache<CompilationUnitOfSCKey, XOptional<ParseResult<CompilationUnit>>> cache;
    @NotNull
    private final AnalysisDataFactory.Key<ParseResult<CompilationUnit>> key;

    public CompilationUnitOfSCFactory(@NotNull Function<SootClass, Path> locator) {
        if (locator == null) {
            throw new IllegalArgumentException("locator cannot be null");
        }
        this.locator = locator;
        this.cache = AnalysisCacheKt.buildX(
            AnalysisDataFactory.Companion.getDefaultBuilder(),
                new CacheLoader() {
                public ParseResult<CompilationUnit> load(CompilationUnitOfSCKey key) {
                    Path path = CompilationUnitOfSCFactory.this.locator.apply(key.getSc());
                    if (path == null || !"java".equals(getFileExtension(path))) {
                        return null;
                    }
                    return AnalysisCache.G.INSTANCE.get(new CompilationUnitAnalysisKey(path));
                }
            }
        );
        this.key = new AnalysisDataFactory.Key<ParseResult<CompilationUnit>>() {};
        AnalysisCache.G.INSTANCE.registerFactory(this);
    }

    private static String getFileExtension(Path path) {
        String fileName = path.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    @NotNull
    public Function<SootClass, Path> getLocator() {
        return locator;
    }

    @Override
    @NotNull
    public LoadingCache<CompilationUnitOfSCKey, XOptional<ParseResult<CompilationUnit>>> getCache() {
        return cache;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<ParseResult<CompilationUnit>> getKey() {
        return key;
    }
}
