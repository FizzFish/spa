/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sarif.Location
 *  cn.sast.framework.report.sarif.Location$$serializer
 *  cn.sast.framework.report.sarif.Location$Companion
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

import cn.sast.framework.report.sarif.Location;
import cn.sast.framework.report.sarif.Location$;
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
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001\u00a2\u0006\u0002\b\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001f"}, d2={"Lcn/sast/framework/report/sarif/Location;", "", "physicalLocation", "Lcn/sast/framework/report/sarif/PhysicalLocation;", "<init>", "(Lcn/sast/framework/report/sarif/PhysicalLocation;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcn/sast/framework/report/sarif/PhysicalLocation;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPhysicalLocation", "()Lcn/sast/framework/report/sarif/PhysicalLocation;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
public final class Location {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final PhysicalLocation physicalLocation;

    public Location(@NotNull PhysicalLocation physicalLocation) {
        Intrinsics.checkNotNullParameter((Object)physicalLocation, (String)"physicalLocation");
        this.physicalLocation = physicalLocation;
    }

    @NotNull
    public final PhysicalLocation getPhysicalLocation() {
        return this.physicalLocation;
    }

    @NotNull
    public final PhysicalLocation component1() {
        return this.physicalLocation;
    }

    @NotNull
    public final Location copy(@NotNull PhysicalLocation physicalLocation) {
        Intrinsics.checkNotNullParameter((Object)physicalLocation, (String)"physicalLocation");
        return new Location(physicalLocation);
    }

    public static /* synthetic */ Location copy$default(Location location, PhysicalLocation physicalLocation, int n, Object object) {
        if ((n & 1) != 0) {
            physicalLocation = location.physicalLocation;
        }
        return location.copy(physicalLocation);
    }

    @NotNull
    public String toString() {
        return "Location(physicalLocation=" + this.physicalLocation + ")";
    }

    public int hashCode() {
        return this.physicalLocation.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Location)) {
            return false;
        }
        Location location = (Location)other;
        return Intrinsics.areEqual((Object)this.physicalLocation, (Object)location.physicalLocation);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(Location self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)PhysicalLocation.$serializer.INSTANCE, (Object)self.physicalLocation);
    }

    public /* synthetic */ Location(int seen0, PhysicalLocation physicalLocation, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.physicalLocation = physicalLocation;
    }
}

