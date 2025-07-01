package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisKey;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import java.nio.file.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CompilationUnitAnalysisKey extends AnalysisKey<ParseResult<CompilationUnit>> {
    @NotNull
    private final Path sourceFile;

    public CompilationUnitAnalysisKey(@NotNull Path sourceFile) {
        super(CompilationUnitAnalysisDataFactory.INSTANCE.getKey());
        this.sourceFile = sourceFile;
    }

    @NotNull
    public Path getSourceFile() {
        return sourceFile;
    }

    @NotNull
    public CompilationUnitAnalysisKey copy(@NotNull Path sourceFile) {
        if (sourceFile == null) {
            throw new IllegalArgumentException("sourceFile cannot be null");
        }
        return new CompilationUnitAnalysisKey(sourceFile);
    }

    @Override
    public String toString() {
        return "CompilationUnitAnalysisKey(sourceFile=" + sourceFile + ")";
    }

    @Override
    public int hashCode() {
        return sourceFile.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompilationUnitAnalysisKey)) {
            return false;
        }
        CompilationUnitAnalysisKey that = (CompilationUnitAnalysisKey) other;
        return sourceFile.equals(that.sourceFile);
    }
}