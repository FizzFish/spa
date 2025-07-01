package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.AnalysisKey;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;

public final class CompilationUnitOfSCKey extends AnalysisKey<ParseResult<CompilationUnit>> {
    @NotNull
    private final SootClass sc;
    @NotNull
    private final AnalysisDataFactory.Key<ParseResult<CompilationUnit>> factoryKey;

    public CompilationUnitOfSCKey(@NotNull SootClass sc, @NotNull AnalysisDataFactory.Key<ParseResult<CompilationUnit>> factoryKey) {
        super(factoryKey);
        if (sc == null) {
            throw new IllegalArgumentException("sc cannot be null");
        }
        if (factoryKey == null) {
            throw new IllegalArgumentException("factoryKey cannot be null");
        }
        this.sc = sc;
        this.factoryKey = factoryKey;
    }

    @NotNull
    public SootClass getSc() {
        return sc;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<ParseResult<CompilationUnit>> getFactoryKey() {
        return factoryKey;
    }

    @NotNull
    public CompilationUnitOfSCKey copy(@NotNull SootClass sc, @NotNull AnalysisDataFactory.Key<ParseResult<CompilationUnit>> factoryKey) {
        if (sc == null) {
            throw new IllegalArgumentException("sc cannot be null");
        }
        if (factoryKey == null) {
            throw new IllegalArgumentException("factoryKey cannot be null");
        }
        return new CompilationUnitOfSCKey(sc, factoryKey);
    }

    @Override
    public String toString() {
        return "CompilationUnitOfSCKey(sc=" + sc + ", factoryKey=" + factoryKey + ")";
    }

    @Override
    public int hashCode() {
        int result = sc.hashCode();
        result = 31 * result + factoryKey.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompilationUnitOfSCKey)) {
            return false;
        }
        CompilationUnitOfSCKey that = (CompilationUnitOfSCKey) other;
        return sc.equals(that.sc) && factoryKey.equals(that.factoryKey);
    }
}