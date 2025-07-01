package cn.sast.framework.report.sarif;

import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
public final class Location {
    @NotNull
    private final PhysicalLocation physicalLocation;

    public Location(@NotNull PhysicalLocation physicalLocation) {
        if (physicalLocation == null) {
            throw new IllegalArgumentException("physicalLocation cannot be null");
        }
        this.physicalLocation = physicalLocation;
    }

    @NotNull
    public PhysicalLocation getPhysicalLocation() {
        return physicalLocation;
    }

    @NotNull
    public Location copy(@NotNull PhysicalLocation physicalLocation) {
        if (physicalLocation == null) {
            throw new IllegalArgumentException("physicalLocation cannot be null");
        }
        return new Location(physicalLocation);
    }

    @Override
    public String toString() {
        return "Location(physicalLocation=" + physicalLocation + ")";
    }

    @Override
    public int hashCode() {
        return physicalLocation.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Location)) {
            return false;
        }
        Location location = (Location) other;
        return physicalLocation.equals(location.physicalLocation);
    }

    public static void write$Self$corax_framework(Location self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) PhysicalLocation.$serializer.INSTANCE, self.physicalLocation);
    }
}