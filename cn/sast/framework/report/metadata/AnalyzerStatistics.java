/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.metadata.AnalyzerStatistics
 *  cn.sast.framework.report.metadata.AnalyzerStatistics$$serializer
 *  cn.sast.framework.report.metadata.AnalyzerStatistics$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerialName
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.metadata;

import cn.sast.framework.report.metadata.AnalyzerStatistics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bBU\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00c6\u0003JG\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\t\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001J\t\u0010%\u001a\u00020\u0006H\u00d6\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001\u00a2\u0006\u0002\b-R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u00060"}, d2={"Lcn/sast/framework/report/metadata/AnalyzerStatistics;", "", "failed", "", "failedSources", "", "", "successful", "successfulSources", "version", "<init>", "(ILjava/util/List;ILjava/util/List;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/util/List;ILjava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFailed", "()I", "getFailedSources$annotations", "()V", "getFailedSources", "()Ljava/util/List;", "getSuccessful", "getSuccessfulSources$annotations", "getSuccessfulSources", "getVersion", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
public final class AnalyzerStatistics {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int failed;
    @NotNull
    private final List<String> failedSources;
    private final int successful;
    @NotNull
    private final List<String> successfulSources;
    @NotNull
    private final String version;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public AnalyzerStatistics(int failed, @NotNull List<String> failedSources, int successful, @NotNull List<String> successfulSources, @NotNull String version) {
        Intrinsics.checkNotNullParameter(failedSources, (String)"failedSources");
        Intrinsics.checkNotNullParameter(successfulSources, (String)"successfulSources");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        this.failed = failed;
        this.failedSources = failedSources;
        this.successful = successful;
        this.successfulSources = successfulSources;
        this.version = version;
    }

    public final int getFailed() {
        return this.failed;
    }

    @NotNull
    public final List<String> getFailedSources() {
        return this.failedSources;
    }

    @SerialName(value="failed_sources")
    public static /* synthetic */ void getFailedSources$annotations() {
    }

    public final int getSuccessful() {
        return this.successful;
    }

    @NotNull
    public final List<String> getSuccessfulSources() {
        return this.successfulSources;
    }

    @SerialName(value="successful_sources")
    public static /* synthetic */ void getSuccessfulSources$annotations() {
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    public final int component1() {
        return this.failed;
    }

    @NotNull
    public final List<String> component2() {
        return this.failedSources;
    }

    public final int component3() {
        return this.successful;
    }

    @NotNull
    public final List<String> component4() {
        return this.successfulSources;
    }

    @NotNull
    public final String component5() {
        return this.version;
    }

    @NotNull
    public final AnalyzerStatistics copy(int failed, @NotNull List<String> failedSources, int successful, @NotNull List<String> successfulSources, @NotNull String version) {
        Intrinsics.checkNotNullParameter(failedSources, (String)"failedSources");
        Intrinsics.checkNotNullParameter(successfulSources, (String)"successfulSources");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        return new AnalyzerStatistics(failed, failedSources, successful, successfulSources, version);
    }

    public static /* synthetic */ AnalyzerStatistics copy$default(AnalyzerStatistics analyzerStatistics, int n, List list, int n2, List list2, String string, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = analyzerStatistics.failed;
        }
        if ((n3 & 2) != 0) {
            list = analyzerStatistics.failedSources;
        }
        if ((n3 & 4) != 0) {
            n2 = analyzerStatistics.successful;
        }
        if ((n3 & 8) != 0) {
            list2 = analyzerStatistics.successfulSources;
        }
        if ((n3 & 0x10) != 0) {
            string = analyzerStatistics.version;
        }
        return analyzerStatistics.copy(n, list, n2, list2, string);
    }

    @NotNull
    public String toString() {
        return "AnalyzerStatistics(failed=" + this.failed + ", failedSources=" + this.failedSources + ", successful=" + this.successful + ", successfulSources=" + this.successfulSources + ", version=" + this.version + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.failed);
        result = result * 31 + ((Object)this.failedSources).hashCode();
        result = result * 31 + Integer.hashCode(this.successful);
        result = result * 31 + ((Object)this.successfulSources).hashCode();
        result = result * 31 + this.version.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnalyzerStatistics)) {
            return false;
        }
        AnalyzerStatistics analyzerStatistics = (AnalyzerStatistics)other;
        if (this.failed != analyzerStatistics.failed) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.failedSources, (Object)analyzerStatistics.failedSources)) {
            return false;
        }
        if (this.successful != analyzerStatistics.successful) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.successfulSources, (Object)analyzerStatistics.successfulSources)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.version, (Object)analyzerStatistics.version);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(AnalyzerStatistics self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArray = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.failed);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)kSerializerArray[1], (Object)self.failedSources);
        output.encodeIntElement(serialDesc, 2, self.successful);
        output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy)kSerializerArray[3], (Object)self.successfulSources);
        output.encodeStringElement(serialDesc, 4, self.version);
    }

    public /* synthetic */ AnalyzerStatistics(int seen0, int failed, List failedSources, int successful, List successfulSources, String version, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (0x1F & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)31, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.failed = failed;
        this.failedSources = failedSources;
        this.successful = successful;
        this.successfulSources = successfulSources;
        this.version = version;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{null, new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), null, new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), null};
        $childSerializers = kSerializerArray;
    }
}

