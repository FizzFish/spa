/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.fraunhofer.aisec.cpg.passes.Pass
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.cache.analysis.cpg;

import com.feysh.corax.cache.analysis.cpg.InferenceConfigurationType;
import com.feysh.corax.cache.analysis.cpg.Lang;
import de.fraunhofer.aisec.cpg.passes.Pass;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0002%&BK\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\b0\u00070\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u001b\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\b0\u00070\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\fH\u00c6\u0003JU\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\b0\u00070\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020$H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\b0\u00070\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006'"}, d2={"Lcom/feysh/corax/cache/analysis/cpg/CPGKeyConfiguration;", "", "sourceFiles", "", "Ljava/io/File;", "topLevel", "passTypes", "Lkotlin/reflect/KClass;", "Lde/fraunhofer/aisec/cpg/passes/Pass;", "inferenceConfigurationType", "Lcom/feysh/corax/cache/analysis/cpg/InferenceConfigurationType;", "lang", "Lcom/feysh/corax/cache/analysis/cpg/Lang;", "<init>", "(Ljava/util/Set;Ljava/io/File;Ljava/util/Set;Lcom/feysh/corax/cache/analysis/cpg/InferenceConfigurationType;Lcom/feysh/corax/cache/analysis/cpg/Lang;)V", "getSourceFiles", "()Ljava/util/Set;", "getTopLevel", "()Ljava/io/File;", "getPassTypes", "getInferenceConfigurationType", "()Lcom/feysh/corax/cache/analysis/cpg/InferenceConfigurationType;", "getLang", "()Lcom/feysh/corax/cache/analysis/cpg/Lang;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Builder", "Companion", "corax-config-api"})
public final class CPGKeyConfiguration {
    @NotNull
    public static final Companion Companion = new Companion(null);
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

    private CPGKeyConfiguration(Set<? extends File> sourceFiles, File topLevel, Set<? extends KClass<? extends Pass<?>>> passTypes, InferenceConfigurationType inferenceConfigurationType, Lang lang) {
        this.sourceFiles = sourceFiles;
        this.topLevel = topLevel;
        this.passTypes = passTypes;
        this.inferenceConfigurationType = inferenceConfigurationType;
        this.lang = lang;
    }

    @NotNull
    public final Set<File> getSourceFiles() {
        return this.sourceFiles;
    }

    @Nullable
    public final File getTopLevel() {
        return this.topLevel;
    }

    @NotNull
    public final Set<KClass<? extends Pass<?>>> getPassTypes() {
        return this.passTypes;
    }

    @NotNull
    public final InferenceConfigurationType getInferenceConfigurationType() {
        return this.inferenceConfigurationType;
    }

    @NotNull
    public final Lang getLang() {
        return this.lang;
    }

    @NotNull
    public final Set<File> component1() {
        return this.sourceFiles;
    }

    @Nullable
    public final File component2() {
        return this.topLevel;
    }

    @NotNull
    public final Set<KClass<? extends Pass<?>>> component3() {
        return this.passTypes;
    }

    @NotNull
    public final InferenceConfigurationType component4() {
        return this.inferenceConfigurationType;
    }

    @NotNull
    public final Lang component5() {
        return this.lang;
    }

    @NotNull
    public final CPGKeyConfiguration copy(@NotNull Set<? extends File> sourceFiles, @Nullable File topLevel, @NotNull Set<? extends KClass<? extends Pass<?>>> passTypes, @NotNull InferenceConfigurationType inferenceConfigurationType, @NotNull Lang lang) {
        Intrinsics.checkNotNullParameter(sourceFiles, (String)"sourceFiles");
        Intrinsics.checkNotNullParameter(passTypes, (String)"passTypes");
        Intrinsics.checkNotNullParameter((Object)((Object)inferenceConfigurationType), (String)"inferenceConfigurationType");
        Intrinsics.checkNotNullParameter((Object)((Object)lang), (String)"lang");
        return new CPGKeyConfiguration(sourceFiles, topLevel, passTypes, inferenceConfigurationType, lang);
    }

    public static /* synthetic */ CPGKeyConfiguration copy$default(CPGKeyConfiguration cPGKeyConfiguration, Set set, File file, Set set2, InferenceConfigurationType inferenceConfigurationType, Lang lang, int n, Object object) {
        if ((n & 1) != 0) {
            set = cPGKeyConfiguration.sourceFiles;
        }
        if ((n & 2) != 0) {
            file = cPGKeyConfiguration.topLevel;
        }
        if ((n & 4) != 0) {
            set2 = cPGKeyConfiguration.passTypes;
        }
        if ((n & 8) != 0) {
            inferenceConfigurationType = cPGKeyConfiguration.inferenceConfigurationType;
        }
        if ((n & 0x10) != 0) {
            lang = cPGKeyConfiguration.lang;
        }
        return cPGKeyConfiguration.copy(set, file, set2, inferenceConfigurationType, lang);
    }

    @NotNull
    public String toString() {
        return "CPGKeyConfiguration(sourceFiles=" + this.sourceFiles + ", topLevel=" + this.topLevel + ", passTypes=" + this.passTypes + ", inferenceConfigurationType=" + this.inferenceConfigurationType + ", lang=" + this.lang + ")";
    }

    public int hashCode() {
        int result = ((Object)this.sourceFiles).hashCode();
        result = result * 31 + (this.topLevel == null ? 0 : this.topLevel.hashCode());
        result = result * 31 + ((Object)this.passTypes).hashCode();
        result = result * 31 + this.inferenceConfigurationType.hashCode();
        result = result * 31 + this.lang.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CPGKeyConfiguration)) {
            return false;
        }
        CPGKeyConfiguration cPGKeyConfiguration = (CPGKeyConfiguration)other;
        if (!Intrinsics.areEqual(this.sourceFiles, cPGKeyConfiguration.sourceFiles)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.topLevel, (Object)cPGKeyConfiguration.topLevel)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.passTypes, cPGKeyConfiguration.passTypes)) {
            return false;
        }
        if (this.inferenceConfigurationType != cPGKeyConfiguration.inferenceConfigurationType) {
            return false;
        }
        return this.lang == cPGKeyConfiguration.lang;
    }

    public /* synthetic */ CPGKeyConfiguration(Set sourceFiles, File topLevel, Set passTypes, InferenceConfigurationType inferenceConfigurationType, Lang lang, DefaultConstructorMarker $constructor_marker) {
        this(sourceFiles, topLevel, passTypes, inferenceConfigurationType, lang);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J \u0010\b\u001a\u00020\u00002\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\n0\tJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lcom/feysh/corax/cache/analysis/cpg/CPGKeyConfiguration$Builder;", "", "<init>", "()V", "sourceFiles", "", "Ljava/io/File;", "topLevel", "passTypes", "", "Lkotlin/reflect/KClass;", "Lde/fraunhofer/aisec/cpg/passes/Pass;", "inferenceConfigurationType", "Lcom/feysh/corax/cache/analysis/cpg/InferenceConfigurationType;", "lang", "Lcom/feysh/corax/cache/analysis/cpg/Lang;", "", "build", "Lcom/feysh/corax/cache/analysis/cpg/CPGKeyConfiguration;", "corax-config-api"})
    public static final class Builder {
        @NotNull
        private Set<? extends File> sourceFiles = SetsKt.emptySet();
        @Nullable
        private File topLevel;
        @NotNull
        private List<? extends KClass<? extends Pass<?>>> passTypes = new ArrayList();
        @NotNull
        private InferenceConfigurationType inferenceConfigurationType = InferenceConfigurationType.DEFAULT;
        @NotNull
        private Lang lang = Lang.JAVA;

        @NotNull
        public final Builder sourceFiles(@NotNull Collection<? extends File> sourceFiles) {
            Intrinsics.checkNotNullParameter(sourceFiles, (String)"sourceFiles");
            this.sourceFiles = CollectionsKt.toHashSet((Iterable)sourceFiles);
            return this;
        }

        @NotNull
        public final Builder topLevel(@Nullable File topLevel) {
            this.topLevel = topLevel;
            return this;
        }

        @NotNull
        public final Builder passTypes(@NotNull List<? extends KClass<? extends Pass<?>>> passTypes) {
            Intrinsics.checkNotNullParameter(passTypes, (String)"passTypes");
            this.passTypes = passTypes;
            return this;
        }

        @NotNull
        public final Builder inferenceConfigurationType(@NotNull InferenceConfigurationType inferenceConfigurationType) {
            Intrinsics.checkNotNullParameter((Object)((Object)inferenceConfigurationType), (String)"inferenceConfigurationType");
            this.inferenceConfigurationType = inferenceConfigurationType;
            return this;
        }

        @NotNull
        public final Builder lang(@NotNull Lang lang) {
            Intrinsics.checkNotNullParameter((Object)((Object)lang), (String)"lang");
            this.lang = lang;
            return this;
        }

        @NotNull
        public final CPGKeyConfiguration build() {
            File file = this.topLevel;
            return new CPGKeyConfiguration(CollectionsKt.toHashSet((Iterable)this.sourceFiles), file != null ? file.getCanonicalFile() : null, CollectionsKt.toHashSet((Iterable)this.passTypes), this.inferenceConfigurationType, this.lang, null);
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0006"}, d2={"Lcom/feysh/corax/cache/analysis/cpg/CPGKeyConfiguration$Companion;", "", "<init>", "()V", "builder", "Lcom/feysh/corax/cache/analysis/cpg/CPGKeyConfiguration$Builder;", "corax-config-api"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Builder builder() {
            return new Builder();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

