/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.fraunhofer.aisec.cpg.TranslationResult
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisKey;
import com.feysh.corax.cache.analysis.CompilationUnitOfCPGDataFactory;
import com.feysh.corax.cache.analysis.cpg.CPGKeyConfiguration;
import de.fraunhofer.aisec.cpg.TranslationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004H\u00c6\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2={"Lcom/feysh/corax/cache/analysis/CPGCompilationUnitKey;", "Lcom/feysh/corax/cache/AnalysisKey;", "Lde/fraunhofer/aisec/cpg/TranslationResult;", "cpgKeyConfiguration", "Lcom/feysh/corax/cache/analysis/cpg/CPGKeyConfiguration;", "<init>", "(Lcom/feysh/corax/cache/analysis/cpg/CPGKeyConfiguration;)V", "getCpgKeyConfiguration", "()Lcom/feysh/corax/cache/analysis/cpg/CPGKeyConfiguration;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "corax-config-api"})
public final class CPGCompilationUnitKey
extends AnalysisKey<TranslationResult> {
    @NotNull
    private final CPGKeyConfiguration cpgKeyConfiguration;

    public CPGCompilationUnitKey(@NotNull CPGKeyConfiguration cpgKeyConfiguration) {
        Intrinsics.checkNotNullParameter((Object)cpgKeyConfiguration, (String)"cpgKeyConfiguration");
        super(CompilationUnitOfCPGDataFactory.INSTANCE.getKey());
        this.cpgKeyConfiguration = cpgKeyConfiguration;
    }

    @NotNull
    public final CPGKeyConfiguration getCpgKeyConfiguration() {
        return this.cpgKeyConfiguration;
    }

    @NotNull
    public final CPGKeyConfiguration component1() {
        return this.cpgKeyConfiguration;
    }

    @NotNull
    public final CPGCompilationUnitKey copy(@NotNull CPGKeyConfiguration cpgKeyConfiguration) {
        Intrinsics.checkNotNullParameter((Object)cpgKeyConfiguration, (String)"cpgKeyConfiguration");
        return new CPGCompilationUnitKey(cpgKeyConfiguration);
    }

    public static /* synthetic */ CPGCompilationUnitKey copy$default(CPGCompilationUnitKey cPGCompilationUnitKey, CPGKeyConfiguration cPGKeyConfiguration, int n, Object object) {
        if ((n & 1) != 0) {
            cPGKeyConfiguration = cPGCompilationUnitKey.cpgKeyConfiguration;
        }
        return cPGCompilationUnitKey.copy(cPGKeyConfiguration);
    }

    @NotNull
    public String toString() {
        return "CPGCompilationUnitKey(cpgKeyConfiguration=" + this.cpgKeyConfiguration + ")";
    }

    @Override
    public int hashCode() {
        return this.cpgKeyConfiguration.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CPGCompilationUnitKey)) {
            return false;
        }
        CPGCompilationUnitKey cPGCompilationUnitKey = (CPGCompilationUnitKey)other;
        return Intrinsics.areEqual((Object)this.cpgKeyConfiguration, (Object)cPGCompilationUnitKey.cpgKeyConfiguration);
    }
}

