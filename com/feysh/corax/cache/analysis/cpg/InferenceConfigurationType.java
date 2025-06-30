/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.fraunhofer.aisec.cpg.InferenceConfiguration
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.cache.analysis.cpg;

import de.fraunhofer.aisec.cpg.InferenceConfiguration;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2={"Lcom/feysh/corax/cache/analysis/cpg/InferenceConfigurationType;", "", "configuration", "Lde/fraunhofer/aisec/cpg/InferenceConfiguration;", "<init>", "(Ljava/lang/String;ILde/fraunhofer/aisec/cpg/InferenceConfiguration;)V", "getConfiguration", "()Lde/fraunhofer/aisec/cpg/InferenceConfiguration;", "DEFAULT", "DISABLE_ALL", "ENABLE_ALL", "corax-config-api"})
public final class InferenceConfigurationType
extends Enum<InferenceConfigurationType> {
    @NotNull
    private final InferenceConfiguration configuration;
    public static final /* enum */ InferenceConfigurationType DEFAULT = new InferenceConfigurationType(InferenceConfiguration.Companion.builder().build());
    public static final /* enum */ InferenceConfigurationType DISABLE_ALL = new InferenceConfigurationType(InferenceConfiguration.Companion.builder().enabled(false).build());
    public static final /* enum */ InferenceConfigurationType ENABLE_ALL = new InferenceConfigurationType(InferenceConfiguration.Companion.builder().build());
    private static final /* synthetic */ InferenceConfigurationType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private InferenceConfigurationType(InferenceConfiguration configuration) {
        this.configuration = configuration;
    }

    @NotNull
    public final InferenceConfiguration getConfiguration() {
        return this.configuration;
    }

    public static InferenceConfigurationType[] values() {
        return (InferenceConfigurationType[])$VALUES.clone();
    }

    public static InferenceConfigurationType valueOf(String value) {
        return Enum.valueOf(InferenceConfigurationType.class, value);
    }

    @NotNull
    public static EnumEntries<InferenceConfigurationType> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = inferenceConfigurationTypeArray = new InferenceConfigurationType[]{InferenceConfigurationType.DEFAULT, InferenceConfigurationType.DISABLE_ALL, InferenceConfigurationType.ENABLE_ALL};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

