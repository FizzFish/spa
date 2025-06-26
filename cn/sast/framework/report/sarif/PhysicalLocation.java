/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sarif.ArtifactLocation
 *  cn.sast.framework.report.sarif.ArtifactLocation$$serializer
 *  cn.sast.framework.report.sarif.PhysicalLocation
 *  cn.sast.framework.report.sarif.PhysicalLocation$$serializer
 *  cn.sast.framework.report.sarif.PhysicalLocation$Companion
 *  cn.sast.framework.report.sarif.Region
 *  cn.sast.framework.report.sarif.Region$$serializer
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

import cn.sast.framework.report.sarif.ArtifactLocation;
import cn.sast.framework.report.sarif.ArtifactLocation$;
import cn.sast.framework.report.sarif.PhysicalLocation;
import cn.sast.framework.report.sarif.Region;
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
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001\u00a2\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006$"}, d2={"Lcn/sast/framework/report/sarif/PhysicalLocation;", "", "artifactLocation", "Lcn/sast/framework/report/sarif/ArtifactLocation;", "region", "Lcn/sast/framework/report/sarif/Region;", "<init>", "(Lcn/sast/framework/report/sarif/ArtifactLocation;Lcn/sast/framework/report/sarif/Region;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcn/sast/framework/report/sarif/ArtifactLocation;Lcn/sast/framework/report/sarif/Region;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getArtifactLocation", "()Lcn/sast/framework/report/sarif/ArtifactLocation;", "getRegion", "()Lcn/sast/framework/report/sarif/Region;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
public final class PhysicalLocation {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ArtifactLocation artifactLocation;
    @NotNull
    private final Region region;

    public PhysicalLocation(@NotNull ArtifactLocation artifactLocation, @NotNull Region region) {
        Intrinsics.checkNotNullParameter((Object)artifactLocation, (String)"artifactLocation");
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        this.artifactLocation = artifactLocation;
        this.region = region;
    }

    @NotNull
    public final ArtifactLocation getArtifactLocation() {
        return this.artifactLocation;
    }

    @NotNull
    public final Region getRegion() {
        return this.region;
    }

    @NotNull
    public final ArtifactLocation component1() {
        return this.artifactLocation;
    }

    @NotNull
    public final Region component2() {
        return this.region;
    }

    @NotNull
    public final PhysicalLocation copy(@NotNull ArtifactLocation artifactLocation, @NotNull Region region) {
        Intrinsics.checkNotNullParameter((Object)artifactLocation, (String)"artifactLocation");
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        return new PhysicalLocation(artifactLocation, region);
    }

    public static /* synthetic */ PhysicalLocation copy$default(PhysicalLocation physicalLocation, ArtifactLocation artifactLocation, Region region, int n, Object object) {
        if ((n & 1) != 0) {
            artifactLocation = physicalLocation.artifactLocation;
        }
        if ((n & 2) != 0) {
            region = physicalLocation.region;
        }
        return physicalLocation.copy(artifactLocation, region);
    }

    @NotNull
    public String toString() {
        return "PhysicalLocation(artifactLocation=" + this.artifactLocation + ", region=" + this.region + ")";
    }

    public int hashCode() {
        int result = this.artifactLocation.hashCode();
        result = result * 31 + this.region.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhysicalLocation)) {
            return false;
        }
        PhysicalLocation physicalLocation = (PhysicalLocation)other;
        if (!Intrinsics.areEqual((Object)this.artifactLocation, (Object)physicalLocation.artifactLocation)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.region, (Object)physicalLocation.region);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(PhysicalLocation self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)ArtifactLocation$.serializer.INSTANCE, (Object)self.artifactLocation);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)Region.$serializer.INSTANCE, (Object)self.region);
    }

    public /* synthetic */ PhysicalLocation(int seen0, ArtifactLocation artifactLocation, Region region, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.artifactLocation = artifactLocation;
        this.region = region;
    }
}

