/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.javaparser.ParseResult
 *  com.github.javaparser.ast.CompilationUnit
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisKey;
import com.feysh.corax.cache.analysis.CompilationUnitAnalysisDataFactory;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0005H\u00c6\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0014"}, d2={"Lcom/feysh/corax/cache/analysis/CompilationUnitAnalysisKey;", "Lcom/feysh/corax/cache/AnalysisKey;", "Lcom/github/javaparser/ParseResult;", "Lcom/github/javaparser/ast/CompilationUnit;", "sourceFile", "Ljava/nio/file/Path;", "<init>", "(Ljava/nio/file/Path;)V", "getSourceFile", "()Ljava/nio/file/Path;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "corax-config-api"})
public final class CompilationUnitAnalysisKey
extends AnalysisKey<ParseResult<CompilationUnit>> {
    @NotNull
    private final Path sourceFile;

    public CompilationUnitAnalysisKey(@NotNull Path sourceFile) {
        Intrinsics.checkNotNullParameter((Object)sourceFile, (String)"sourceFile");
        super(CompilationUnitAnalysisDataFactory.INSTANCE.getKey());
        this.sourceFile = sourceFile;
    }

    @NotNull
    public final Path getSourceFile() {
        return this.sourceFile;
    }

    @NotNull
    public final Path component1() {
        return this.sourceFile;
    }

    @NotNull
    public final CompilationUnitAnalysisKey copy(@NotNull Path sourceFile) {
        Intrinsics.checkNotNullParameter((Object)sourceFile, (String)"sourceFile");
        return new CompilationUnitAnalysisKey(sourceFile);
    }

    public static /* synthetic */ CompilationUnitAnalysisKey copy$default(CompilationUnitAnalysisKey compilationUnitAnalysisKey, Path path, int n, Object object) {
        if ((n & 1) != 0) {
            path = compilationUnitAnalysisKey.sourceFile;
        }
        return compilationUnitAnalysisKey.copy(path);
    }

    @NotNull
    public String toString() {
        return "CompilationUnitAnalysisKey(sourceFile=" + this.sourceFile + ")";
    }

    @Override
    public int hashCode() {
        return ((Object)this.sourceFile).hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompilationUnitAnalysisKey)) {
            return false;
        }
        CompilationUnitAnalysisKey compilationUnitAnalysisKey = (CompilationUnitAnalysisKey)other;
        return Intrinsics.areEqual((Object)this.sourceFile, (Object)compilationUnitAnalysisKey.sourceFile);
    }
}

