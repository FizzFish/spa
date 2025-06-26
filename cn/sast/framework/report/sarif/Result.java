/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sarif.CodeFlow
 *  cn.sast.framework.report.sarif.CodeFlow$$serializer
 *  cn.sast.framework.report.sarif.IndexedMessage
 *  cn.sast.framework.report.sarif.IndexedMessage$$serializer
 *  cn.sast.framework.report.sarif.Location
 *  cn.sast.framework.report.sarif.Location$$serializer
 *  cn.sast.framework.report.sarif.Result
 *  cn.sast.framework.report.sarif.Result$$serializer
 *  cn.sast.framework.report.sarif.Result$Companion
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.EncodeDefault
 *  kotlinx.serialization.EncodeDefault$Mode
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.sarif;

import cn.sast.framework.report.sarif.CodeFlow;
import cn.sast.framework.report.sarif.CodeFlow$;
import cn.sast.framework.report.sarif.IndexedMessage;
import cn.sast.framework.report.sarif.IndexedMessage$;
import cn.sast.framework.report.sarif.Location;
import cn.sast.framework.report.sarif.Location$;
import cn.sast.framework.report.sarif.Result;
import cn.sast.framework.report.sarif.Result$;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.EncodeDefault;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u00a2\u0006\u0004\b\r\u0010\u000eBW\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\r\u0010\u0012J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u00c6\u0003JG\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u00c6\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010'\u001a\u00020\u0005H\u00d6\u0001J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001\u00a2\u0006\u0002\b0R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c\u00a8\u00063"}, d2={"Lcn/sast/framework/report/sarif/Result;", "", "ruleId", "", "ruleIndex", "", "message", "Lcn/sast/framework/report/sarif/IndexedMessage;", "locations", "", "Lcn/sast/framework/report/sarif/Location;", "codeFlows", "Lcn/sast/framework/report/sarif/CodeFlow;", "<init>", "(Ljava/lang/String;ILcn/sast/framework/report/sarif/IndexedMessage;Ljava/util/List;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILcn/sast/framework/report/sarif/IndexedMessage;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRuleId", "()Ljava/lang/String;", "getRuleIndex", "()I", "getMessage$annotations", "()V", "getMessage", "()Lcn/sast/framework/report/sarif/IndexedMessage;", "getLocations", "()Ljava/util/List;", "getCodeFlows", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
public final class Result {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String ruleId;
    private final int ruleIndex;
    @NotNull
    private final IndexedMessage message;
    @NotNull
    private final List<Location> locations;
    @NotNull
    private final List<CodeFlow> codeFlows;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public Result(@NotNull String ruleId, int ruleIndex, @NotNull IndexedMessage message, @NotNull List<Location> locations, @NotNull List<CodeFlow> codeFlows) {
        Intrinsics.checkNotNullParameter((Object)ruleId, (String)"ruleId");
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
        Intrinsics.checkNotNullParameter(locations, (String)"locations");
        Intrinsics.checkNotNullParameter(codeFlows, (String)"codeFlows");
        this.ruleId = ruleId;
        this.ruleIndex = ruleIndex;
        this.message = message;
        this.locations = locations;
        this.codeFlows = codeFlows;
    }

    public /* synthetic */ Result(String string, int n, IndexedMessage indexedMessage, List list, List list2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            indexedMessage = new IndexedMessage(null, 1, null);
        }
        if ((n2 & 0x10) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        this(string, n, indexedMessage, list, list2);
    }

    @NotNull
    public final String getRuleId() {
        return this.ruleId;
    }

    public final int getRuleIndex() {
        return this.ruleIndex;
    }

    @NotNull
    public final IndexedMessage getMessage() {
        return this.message;
    }

    @EncodeDefault(mode=EncodeDefault.Mode.ALWAYS)
    public static /* synthetic */ void getMessage$annotations() {
    }

    @NotNull
    public final List<Location> getLocations() {
        return this.locations;
    }

    @NotNull
    public final List<CodeFlow> getCodeFlows() {
        return this.codeFlows;
    }

    @NotNull
    public final String component1() {
        return this.ruleId;
    }

    public final int component2() {
        return this.ruleIndex;
    }

    @NotNull
    public final IndexedMessage component3() {
        return this.message;
    }

    @NotNull
    public final List<Location> component4() {
        return this.locations;
    }

    @NotNull
    public final List<CodeFlow> component5() {
        return this.codeFlows;
    }

    @NotNull
    public final Result copy(@NotNull String ruleId, int ruleIndex, @NotNull IndexedMessage message, @NotNull List<Location> locations, @NotNull List<CodeFlow> codeFlows) {
        Intrinsics.checkNotNullParameter((Object)ruleId, (String)"ruleId");
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
        Intrinsics.checkNotNullParameter(locations, (String)"locations");
        Intrinsics.checkNotNullParameter(codeFlows, (String)"codeFlows");
        return new Result(ruleId, ruleIndex, message, locations, codeFlows);
    }

    public static /* synthetic */ Result copy$default(Result result, String string, int n, IndexedMessage indexedMessage, List list, List list2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = result.ruleId;
        }
        if ((n2 & 2) != 0) {
            n = result.ruleIndex;
        }
        if ((n2 & 4) != 0) {
            indexedMessage = result.message;
        }
        if ((n2 & 8) != 0) {
            list = result.locations;
        }
        if ((n2 & 0x10) != 0) {
            list2 = result.codeFlows;
        }
        return result.copy(string, n, indexedMessage, list, list2);
    }

    @NotNull
    public String toString() {
        return "Result(ruleId=" + this.ruleId + ", ruleIndex=" + this.ruleIndex + ", message=" + this.message + ", locations=" + this.locations + ", codeFlows=" + this.codeFlows + ")";
    }

    public int hashCode() {
        int result = this.ruleId.hashCode();
        result = result * 31 + Integer.hashCode(this.ruleIndex);
        result = result * 31 + this.message.hashCode();
        result = result * 31 + ((Object)this.locations).hashCode();
        result = result * 31 + ((Object)this.codeFlows).hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Result)) {
            return false;
        }
        Result result = (Result)other;
        if (!Intrinsics.areEqual((Object)this.ruleId, (Object)result.ruleId)) {
            return false;
        }
        if (this.ruleIndex != result.ruleIndex) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.message, (Object)result.message)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.locations, (Object)result.locations)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.codeFlows, (Object)result.codeFlows);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(Result self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.ruleId);
        output.encodeIntElement(serialDesc, 1, self.ruleIndex);
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)IndexedMessage$.serializer.INSTANCE, (Object)self.message);
        output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy)kSerializerArray[3], (Object)self.locations);
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : !Intrinsics.areEqual((Object)self.codeFlows, (Object)CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy)kSerializerArray[4], (Object)self.codeFlows);
        }
    }

    public /* synthetic */ Result(int seen0, String ruleId, int ruleIndex, IndexedMessage message, List locations, List codeFlows, SerializationConstructorMarker serializationConstructorMarker) {
        if (11 != (0xB & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)11, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.ruleId = ruleId;
        this.ruleIndex = ruleIndex;
        this.message = (seen0 & 4) == 0 ? new IndexedMessage(null, 1, null) : message;
        this.locations = locations;
        this.codeFlows = (seen0 & 0x10) == 0 ? CollectionsKt.emptyList() : codeFlows;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{null, null, null, new ArrayListSerializer((KSerializer)Location$.serializer.INSTANCE), new ArrayListSerializer((KSerializer)CodeFlow$.serializer.INSTANCE)};
        $childSerializers = kSerializerArray;
    }
}

