package cn.sast.framework.report.sarif;

import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
public final class FlowLocationWrapper {
    @NotNull
    private final FlowLocation location;

    public FlowLocationWrapper(@NotNull FlowLocation location) {
        if (location == null) {
            throw new IllegalArgumentException("location cannot be null");
        }
        this.location = location;
    }

    @NotNull
    public FlowLocation getLocation() {
        return location;
    }

    @NotNull
    public FlowLocation component1() {
        return location;
    }

    @NotNull
    public FlowLocationWrapper copy(@NotNull FlowLocation location) {
        if (location == null) {
            throw new IllegalArgumentException("location cannot be null");
        }
        return new FlowLocationWrapper(location);
    }

    @Override
    public String toString() {
        return "FlowLocationWrapper(location=" + location + ")";
    }

    @Override
    public int hashCode() {
        return location.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowLocationWrapper)) {
            return false;
        }
        FlowLocationWrapper that = (FlowLocationWrapper) other;
        return location.equals(that.location);
    }

    @JvmStatic
    public static void write$Self$corax_framework(FlowLocationWrapper self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, FlowLocation$.serializer.INSTANCE, self.location);
    }
}