/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ExtSettings
 *  cn.sast.framework.report.sarif.Run
 *  cn.sast.framework.report.sarif.Run$$serializer
 *  cn.sast.framework.report.sarif.SarifLog
 *  cn.sast.framework.report.sarif.SarifLog$$serializer
 *  cn.sast.framework.report.sarif.SarifLog$Companion
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  kotlin.Metadata
 *  kotlin.Unit
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
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JsonBuilder
 *  kotlinx.serialization.json.JsonKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.sarif;

import cn.sast.api.config.ExtSettings;
import cn.sast.framework.report.sarif.Run;
import cn.sast.framework.report.sarif.Run$;
import cn.sast.framework.report.sarif.SarifLog;
import cn.sast.framework.report.sarif.SarifLog$;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002()B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\b\u0010\u000eJ\u0006\u0010\u0016\u001a\u00020\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J-\u0010\u001a\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001\u00a2\u0006\u0002\b'R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006*"}, d2={"Lcn/sast/framework/report/sarif/SarifLog;", "", "schema", "", "version", "runs", "", "Lcn/sast/framework/report/sarif/Run;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSchema$annotations", "()V", "getSchema", "()Ljava/lang/String;", "getVersion", "getRuns", "()Ljava/util/List;", "toJson", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "Companion", "$serializer", "corax-framework"})
public final class SarifLog {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String schema;
    @NotNull
    private final String version;
    @NotNull
    private final List<Run> runs;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;
    @NotNull
    private static final Json jsonFormat;

    public SarifLog(@JsonProperty(value="$schema") @NotNull String schema, @NotNull String version, @NotNull List<Run> runs) {
        Intrinsics.checkNotNullParameter((Object)schema, (String)"schema");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        Intrinsics.checkNotNullParameter(runs, (String)"runs");
        this.schema = schema;
        this.version = version;
        this.runs = runs;
    }

    @NotNull
    public final String getSchema() {
        return this.schema;
    }

    @SerialName(value="$schema")
    public static /* synthetic */ void getSchema$annotations() {
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    @NotNull
    public final List<Run> getRuns() {
        return this.runs;
    }

    @NotNull
    public final String toJson() {
        return jsonFormat.encodeToString((SerializationStrategy)Companion.serializer(), (Object)this);
    }

    @NotNull
    public final String component1() {
        return this.schema;
    }

    @NotNull
    public final String component2() {
        return this.version;
    }

    @NotNull
    public final List<Run> component3() {
        return this.runs;
    }

    @NotNull
    public final SarifLog copy(@JsonProperty(value="$schema") @NotNull String schema, @NotNull String version, @NotNull List<Run> runs) {
        Intrinsics.checkNotNullParameter((Object)schema, (String)"schema");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        Intrinsics.checkNotNullParameter(runs, (String)"runs");
        return new SarifLog(schema, version, runs);
    }

    public static /* synthetic */ SarifLog copy$default(SarifLog sarifLog, String string, String string2, List list, int n, Object object) {
        if ((n & 1) != 0) {
            string = sarifLog.schema;
        }
        if ((n & 2) != 0) {
            string2 = sarifLog.version;
        }
        if ((n & 4) != 0) {
            list = sarifLog.runs;
        }
        return sarifLog.copy(string, string2, list);
    }

    @NotNull
    public String toString() {
        return "SarifLog(schema=" + this.schema + ", version=" + this.version + ", runs=" + this.runs + ")";
    }

    public int hashCode() {
        int result = this.schema.hashCode();
        result = result * 31 + this.version.hashCode();
        result = result * 31 + ((Object)this.runs).hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SarifLog)) {
            return false;
        }
        SarifLog sarifLog = (SarifLog)other;
        if (!Intrinsics.areEqual((Object)this.schema, (Object)sarifLog.schema)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.version, (Object)sarifLog.version)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.runs, (Object)sarifLog.runs);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(SarifLog self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.schema);
        output.encodeStringElement(serialDesc, 1, self.version);
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)kSerializerArray[2], (Object)self.runs);
    }

    public /* synthetic */ SarifLog(int seen0, String schema, String version, List runs, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (7 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)7, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.schema = schema;
        this.version = version;
        this.runs = runs;
    }

    private static final Unit jsonFormat$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter((Object)$this$Json, (String)"$this$Json");
        $this$Json.setUseArrayPolymorphism(true);
        $this$Json.setPrettyPrint(ExtSettings.INSTANCE.getPrettyPrintJsonReport());
        $this$Json.setEncodeDefaults(false);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{null, null, new ArrayListSerializer((KSerializer)Run$.serializer.INSTANCE)};
        $childSerializers = kSerializerArray;
        jsonFormat = JsonKt.Json$default(null, SarifLog::jsonFormat$lambda$0, (int)1, null);
    }
}

