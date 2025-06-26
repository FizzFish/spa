/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sarif.FlowLocation
 *  cn.sast.framework.report.sarif.FlowLocation$$serializer
 *  cn.sast.framework.report.sarif.FlowLocation$Companion
 *  cn.sast.framework.report.sarif.Message
 *  cn.sast.framework.report.sarif.Message$$serializer
 *  cn.sast.framework.report.sarif.PhysicalLocation
 *  cn.sast.framework.report.sarif.PhysicalLocation$$serializer
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.sarif;

import cn.sast.framework.report.sarif.FlowLocation;
import cn.sast.framework.report.sarif.FlowLocation$;
import cn.sast.framework.report.sarif.Message;
import cn.sast.framework.report.sarif.PhysicalLocation;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001\u00a2\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006$"}, d2={"Lcn/sast/framework/report/sarif/FlowLocation;", "", "message", "Lcn/sast/framework/report/sarif/Message;", "physicalLocation", "Lcn/sast/framework/report/sarif/PhysicalLocation;", "<init>", "(Lcn/sast/framework/report/sarif/Message;Lcn/sast/framework/report/sarif/PhysicalLocation;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcn/sast/framework/report/sarif/Message;Lcn/sast/framework/report/sarif/PhysicalLocation;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMessage", "()Lcn/sast/framework/report/sarif/Message;", "getPhysicalLocation", "()Lcn/sast/framework/report/sarif/PhysicalLocation;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
public final class FlowLocation {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Message message;
    @NotNull
    private final PhysicalLocation physicalLocation;

    public FlowLocation(@NotNull Message message, @NotNull PhysicalLocation physicalLocation) {
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
        Intrinsics.checkNotNullParameter((Object)physicalLocation, (String)"physicalLocation");
        this.message = message;
        this.physicalLocation = physicalLocation;
    }

    @NotNull
    public final Message getMessage() {
        return this.message;
    }

    @NotNull
    public final PhysicalLocation getPhysicalLocation() {
        return this.physicalLocation;
    }

    @NotNull
    public final Message component1() {
        return this.message;
    }

    @NotNull
    public final PhysicalLocation component2() {
        return this.physicalLocation;
    }

    @NotNull
    public final FlowLocation copy(@NotNull Message message, @NotNull PhysicalLocation physicalLocation) {
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
        Intrinsics.checkNotNullParameter((Object)physicalLocation, (String)"physicalLocation");
        return new FlowLocation(message, physicalLocation);
    }

    public static /* synthetic */ FlowLocation copy$default(FlowLocation flowLocation, Message message, PhysicalLocation physicalLocation, int n, Object object) {
        if ((n & 1) != 0) {
            message = flowLocation.message;
        }
        if ((n & 2) != 0) {
            physicalLocation = flowLocation.physicalLocation;
        }
        return flowLocation.copy(message, physicalLocation);
    }

    @NotNull
    public String toString() {
        return "FlowLocation(message=" + this.message + ", physicalLocation=" + this.physicalLocation + ")";
    }

    public int hashCode() {
        int result = this.message.hashCode();
        result = result * 31 + this.physicalLocation.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowLocation)) {
            return false;
        }
        FlowLocation flowLocation = (FlowLocation)other;
        if (!Intrinsics.areEqual((Object)this.message, (Object)flowLocation.message)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.physicalLocation, (Object)flowLocation.physicalLocation);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(FlowLocation self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)Message.$serializer.INSTANCE, (Object)self.message);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)PhysicalLocation.$serializer.INSTANCE, (Object)self.physicalLocation);
    }

    public /* synthetic */ FlowLocation(int seen0, Message message, PhysicalLocation physicalLocation, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.message = message;
        this.physicalLocation = physicalLocation;
    }
}

