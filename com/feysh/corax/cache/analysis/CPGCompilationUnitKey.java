package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisKey;
import com.feysh.corax.cache.analysis.CompilationUnitOfCPGDataFactory;
import com.feysh.corax.cache.analysis.cpg.CPGKeyConfiguration;
import de.fraunhofer.aisec.cpg.TranslationResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public final class CPGCompilationUnitKey extends AnalysisKey<TranslationResult> {
    @NotNull
    private final CPGKeyConfiguration cpgKeyConfiguration;

    public CPGCompilationUnitKey(@NotNull CPGKeyConfiguration cpgKeyConfiguration) {
        super(CompilationUnitOfCPGDataFactory.INSTANCE.getKey());
        this.cpgKeyConfiguration = Objects.requireNonNull(cpgKeyConfiguration, "cpgKeyConfiguration");
    }

    @NotNull
    public CPGKeyConfiguration getCpgKeyConfiguration() {
        return cpgKeyConfiguration;
    }

    @NotNull
    public CPGCompilationUnitKey copy(@NotNull CPGKeyConfiguration cpgKeyConfiguration) {
        return new CPGCompilationUnitKey(Objects.requireNonNull(cpgKeyConfiguration, "cpgKeyConfiguration"));
    }

    @Override
    public String toString() {
        return "CPGCompilationUnitKey(cpgKeyConfiguration=" + cpgKeyConfiguration + ")";
    }

    @Override
    public int hashCode() {
        return cpgKeyConfiguration.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CPGCompilationUnitKey)) {
            return false;
        }
        CPGCompilationUnitKey that = (CPGCompilationUnitKey) other;
        return cpgKeyConfiguration.equals(that.cpgKeyConfiguration);
    }
}