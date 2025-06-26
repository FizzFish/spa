/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sarif.CodeFlow
 *  cn.sast.framework.report.sarif.CodeFlow$$serializer
 *  cn.sast.framework.report.sarif.CodeFlow$Companion
 *  cn.sast.framework.report.sarif.ThreadFlow
 *  cn.sast.framework.report.sarif.ThreadFlow$$serializer
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
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
import cn.sast.framework.report.sarif.ThreadFlow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
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
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\bH\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001\u00a2\u0006\u0002\b\u001dR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006 "}, d2={"Lcn/sast/framework/report/sarif/CodeFlow;", "", "threadFlows", "", "Lcn/sast/framework/report/sarif/ThreadFlow;", "<init>", "(Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getThreadFlows", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
public final class CodeFlow {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<ThreadFlow> threadFlows;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public CodeFlow(@NotNull List<ThreadFlow> threadFlows) {
        Intrinsics.checkNotNullParameter(threadFlows, (String)"threadFlows");
        this.threadFlows = threadFlows;
    }

    @NotNull
    public final List<ThreadFlow> getThreadFlows() {
        return this.threadFlows;
    }

    @NotNull
    public final List<ThreadFlow> component1() {
        return this.threadFlows;
    }

    @NotNull
    public final CodeFlow copy(@NotNull List<ThreadFlow> threadFlows) {
        Intrinsics.checkNotNullParameter(threadFlows, (String)"threadFlows");
        return new CodeFlow(threadFlows);
    }

    public static /* synthetic */ CodeFlow copy$default(CodeFlow codeFlow, List list, int n, Object object) {
        if ((n & 1) != 0) {
            list = codeFlow.threadFlows;
        }
        return codeFlow.copy(list);
    }

    @NotNull
    public String toString() {
        return "CodeFlow(threadFlows=" + this.threadFlows + ")";
    }

    public int hashCode() {
        return ((Object)this.threadFlows).hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CodeFlow)) {
            return false;
        }
        CodeFlow codeFlow = (CodeFlow)other;
        return Intrinsics.areEqual((Object)this.threadFlows, (Object)codeFlow.threadFlows);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(CodeFlow self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArray = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)kSerializerArray[0], (Object)self.threadFlows);
    }

    public /* synthetic */ CodeFlow(int seen0, List threadFlows, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.threadFlows = threadFlows;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{new ArrayListSerializer((KSerializer)ThreadFlow.$serializer.INSTANCE)};
        $childSerializers = kSerializerArray;
    }
}

