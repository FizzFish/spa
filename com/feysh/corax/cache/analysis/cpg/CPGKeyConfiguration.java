package com.feysh.corax.cache.analysis.cpg;

import de.fraunhofer.aisec.cpg.passes.Pass;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CPGKeyConfiguration {
    @NotNull
    private final Set<File> sourceFiles;
    @Nullable
    private final File topLevel;
    @NotNull
    private final Set<KClass<? extends Pass<?>>> passTypes;
    @NotNull
    private final InferenceConfigurationType inferenceConfigurationType;
    @NotNull
    private final Lang lang;

    private CPGKeyConfiguration(@NotNull Set<? extends File> sourceFiles, @Nullable File topLevel, 
            @NotNull Set<? extends KClass<? extends Pass<?>>> passTypes,
            @NotNull InferenceConfigurationType inferenceConfigurationType, 
            @NotNull Lang lang) {
        this.sourceFiles = new HashSet<>(sourceFiles);
        this.topLevel = topLevel;
        this.passTypes = new HashSet<>(passTypes);
        this.inferenceConfigurationType = inferenceConfigurationType;
        this.lang = lang;
    }

    @NotNull
    public Set<File> getSourceFiles() {
        return sourceFiles;
    }

    @Nullable
    public File getTopLevel() {
        return topLevel;
    }

    @NotNull
    public Set<KClass<? extends Pass<?>>> getPassTypes() {
        return passTypes;
    }

    @NotNull
    public InferenceConfigurationType getInferenceConfigurationType() {
        return inferenceConfigurationType;
    }

    @NotNull
    public Lang getLang() {
        return lang;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof CPGKeyConfiguration)) return false;
        CPGKeyConfiguration that = (CPGKeyConfiguration) other;
        return sourceFiles.equals(that.sourceFiles) &&
                Objects.equals(topLevel, that.topLevel) &&
                passTypes.equals(that.passTypes) &&
                inferenceConfigurationType == that.inferenceConfigurationType &&
                lang == that.lang;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceFiles, topLevel, passTypes, inferenceConfigurationType, lang);
    }

    @Override
    public String toString() {
        return "CPGKeyConfiguration(sourceFiles=" + sourceFiles + 
               ", topLevel=" + topLevel + 
               ", passTypes=" + passTypes + 
               ", inferenceConfigurationType=" + inferenceConfigurationType + 
               ", lang=" + lang + ")";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        @NotNull
        private Set<? extends File> sourceFiles = new HashSet<>();
        @Nullable
        private File topLevel;
        @NotNull
        private List<? extends KClass<? extends Pass<?>>> passTypes = new ArrayList<>();
        @NotNull
        private InferenceConfigurationType inferenceConfigurationType = InferenceConfigurationType.DEFAULT;
        @NotNull
        private Lang lang = Lang.JAVA;

        @NotNull
        public Builder sourceFiles(@NotNull Collection<? extends File> sourceFiles) {
            this.sourceFiles = new HashSet<>(sourceFiles);
            return this;
        }

        @NotNull
        public Builder topLevel(@Nullable File topLevel) {
            this.topLevel = topLevel;
            return this;
        }

        @NotNull
        public Builder passTypes(@NotNull List<? extends KClass<? extends Pass<?>>> passTypes) {
            this.passTypes = new ArrayList<>(passTypes);
            return this;
        }

        @NotNull
        public Builder inferenceConfigurationType(@NotNull InferenceConfigurationType inferenceConfigurationType) {
            this.inferenceConfigurationType = inferenceConfigurationType;
            return this;
        }

        @NotNull
        public Builder lang(@NotNull Lang lang) {
            this.lang = lang;
            return this;
        }

        @NotNull
        public CPGKeyConfiguration build() {
            File canonicalTopLevel = topLevel != null ? topLevel.getAbsoluteFile() : null;
            return new CPGKeyConfiguration(
                new HashSet<>(sourceFiles),
                canonicalTopLevel,
                new HashSet<>(passTypes),
                inferenceConfigurationType,
                lang
            );
        }
    }
}