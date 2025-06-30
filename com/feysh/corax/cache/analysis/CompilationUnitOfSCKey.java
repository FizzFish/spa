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
 *  soot.SootClass
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.AnalysisKey;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\u0017\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0007H\u00c6\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2={"Lcom/feysh/corax/cache/analysis/CompilationUnitOfSCKey;", "Lcom/feysh/corax/cache/AnalysisKey;", "Lcom/github/javaparser/ParseResult;", "Lcom/github/javaparser/ast/CompilationUnit;", "sc", "Lsoot/SootClass;", "factoryKey", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "<init>", "(Lsoot/SootClass;Lcom/feysh/corax/cache/AnalysisDataFactory$Key;)V", "getSc", "()Lsoot/SootClass;", "getFactoryKey", "()Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "corax-config-api"})
public final class CompilationUnitOfSCKey
extends AnalysisKey<ParseResult<CompilationUnit>> {
    @NotNull
    private final SootClass sc;
    @NotNull
    private final AnalysisDataFactory.Key<ParseResult<CompilationUnit>> factoryKey;

    public CompilationUnitOfSCKey(@NotNull SootClass sc, @NotNull AnalysisDataFactory.Key<ParseResult<CompilationUnit>> factoryKey) {
        Intrinsics.checkNotNullParameter((Object)sc, (String)"sc");
        Intrinsics.checkNotNullParameter(factoryKey, (String)"factoryKey");
        super(factoryKey);
        this.sc = sc;
        this.factoryKey = factoryKey;
    }

    @NotNull
    public final SootClass getSc() {
        return this.sc;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<ParseResult<CompilationUnit>> getFactoryKey() {
        return this.factoryKey;
    }

    @NotNull
    public final SootClass component1() {
        return this.sc;
    }

    @NotNull
    public final AnalysisDataFactory.Key<ParseResult<CompilationUnit>> component2() {
        return this.factoryKey;
    }

    @NotNull
    public final CompilationUnitOfSCKey copy(@NotNull SootClass sc, @NotNull AnalysisDataFactory.Key<ParseResult<CompilationUnit>> factoryKey) {
        Intrinsics.checkNotNullParameter((Object)sc, (String)"sc");
        Intrinsics.checkNotNullParameter(factoryKey, (String)"factoryKey");
        return new CompilationUnitOfSCKey(sc, factoryKey);
    }

    public static /* synthetic */ CompilationUnitOfSCKey copy$default(CompilationUnitOfSCKey compilationUnitOfSCKey, SootClass sootClass, AnalysisDataFactory.Key key2, int n, Object object) {
        if ((n & 1) != 0) {
            sootClass = compilationUnitOfSCKey.sc;
        }
        if ((n & 2) != 0) {
            key2 = compilationUnitOfSCKey.factoryKey;
        }
        return compilationUnitOfSCKey.copy(sootClass, key2);
    }

    @NotNull
    public String toString() {
        return "CompilationUnitOfSCKey(sc=" + this.sc + ", factoryKey=" + this.factoryKey + ")";
    }

    @Override
    public int hashCode() {
        int result = this.sc.hashCode();
        result = result * 31 + this.factoryKey.hashCode();
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
        CompilationUnitOfSCKey compilationUnitOfSCKey = (CompilationUnitOfSCKey)other;
        if (!Intrinsics.areEqual((Object)this.sc, (Object)compilationUnitOfSCKey.sc)) {
            return false;
        }
        return Intrinsics.areEqual(this.factoryKey, compilationUnitOfSCKey.factoryKey);
    }
}

