/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ProcessRegex
 *  cn.sast.api.config.ProcessRegex$$serializer
 *  cn.sast.api.config.ProjectConfig
 *  cn.sast.api.config.ProjectConfig$$serializer
 *  cn.sast.api.config.ProjectConfig$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.SerialName
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.Transient
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.config;

import cn.sast.api.config.ProcessRegex;
import cn.sast.api.config.ProcessRegex$;
import cn.sast.api.config.ProjectConfig;
import cn.sast.api.config.ProjectConfig$;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0004\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001\u00a2\u0006\u0002\b%R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006("}, d2={"Lcn/sast/api/config/ProjectConfig;", "", "processRegex", "Lcn/sast/api/config/ProcessRegex;", "<init>", "(Lcn/sast/api/config/ProcessRegex;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcn/sast/api/config/ProcessRegex;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProcessRegex$annotations", "()V", "getProcessRegex", "()Lcn/sast/api/config/ProcessRegex;", "ymlFile", "Ljava/io/File;", "getYmlFile$annotations", "getYmlFile", "()Ljava/io/File;", "setYmlFile", "(Ljava/io/File;)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_api", "Companion", "$serializer", "corax-api"})
public final class ProjectConfig {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ProcessRegex processRegex;
    @Nullable
    private File ymlFile;
    @NotNull
    public static final String RECORD_FILE_NAME = "scan-classifier-info.json";

    public ProjectConfig(@NotNull ProcessRegex processRegex) {
        Intrinsics.checkNotNullParameter((Object)processRegex, (String)"processRegex");
        this.processRegex = processRegex;
    }

    public /* synthetic */ ProjectConfig(ProcessRegex processRegex, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            processRegex = new ProcessRegex(null, null, null, 7, null);
        }
        this(processRegex);
    }

    @NotNull
    public final ProcessRegex getProcessRegex() {
        return this.processRegex;
    }

    @SerialName(value="process-regex")
    public static /* synthetic */ void getProcessRegex$annotations() {
    }

    @Nullable
    public final File getYmlFile() {
        return this.ymlFile;
    }

    public final void setYmlFile(@Nullable File file) {
        this.ymlFile = file;
    }

    @Transient
    public static /* synthetic */ void getYmlFile$annotations() {
    }

    @NotNull
    public final ProcessRegex component1() {
        return this.processRegex;
    }

    @NotNull
    public final ProjectConfig copy(@NotNull ProcessRegex processRegex) {
        Intrinsics.checkNotNullParameter((Object)processRegex, (String)"processRegex");
        return new ProjectConfig(processRegex);
    }

    public static /* synthetic */ ProjectConfig copy$default(ProjectConfig projectConfig, ProcessRegex processRegex, int n, Object object) {
        if ((n & 1) != 0) {
            processRegex = projectConfig.processRegex;
        }
        return projectConfig.copy(processRegex);
    }

    @NotNull
    public String toString() {
        return "ProjectConfig(processRegex=" + this.processRegex + ")";
    }

    public int hashCode() {
        return this.processRegex.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProjectConfig)) {
            return false;
        }
        ProjectConfig projectConfig = (ProjectConfig)other;
        return Intrinsics.areEqual((Object)this.processRegex, (Object)projectConfig.processRegex);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_api(ProjectConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) ? true : !Intrinsics.areEqual((Object)self.processRegex, (Object)new ProcessRegex(null, null, null, 7, null))) {
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)ProcessRegex$.serializer.INSTANCE, (Object)self.processRegex);
        }
    }

    public /* synthetic */ ProjectConfig(int seen0, ProcessRegex processRegex, SerializationConstructorMarker serializationConstructorMarker) {
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)0, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.processRegex = (seen0 & 1) == 0 ? new ProcessRegex(null, null, null, 7, null) : processRegex;
        this.ymlFile = null;
    }

    public ProjectConfig() {
        this(null, 1, null);
    }
}

