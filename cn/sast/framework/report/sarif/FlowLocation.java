package cn.sast.framework.report.sarif;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FlowLocation {
    @NotNull
    private final Message message;
    @NotNull
    private final PhysicalLocation physicalLocation;

    public FlowLocation(@NotNull Message message, @NotNull PhysicalLocation physicalLocation) {
        if (message == null) {
            throw new IllegalArgumentException("message cannot be null");
        }
        if (physicalLocation == null) {
            throw new IllegalArgumentException("physicalLocation cannot be null");
        }
        this.message = message;
        this.physicalLocation = physicalLocation;
    }

    @NotNull
    public Message getMessage() {
        return message;
    }

    @NotNull
    public PhysicalLocation getPhysicalLocation() {
        return physicalLocation;
    }

    @NotNull
    public Message component1() {
        return message;
    }

    @NotNull
    public PhysicalLocation component2() {
        return physicalLocation;
    }

    @NotNull
    public FlowLocation copy(@NotNull Message message, @NotNull PhysicalLocation physicalLocation) {
        if (message == null) {
            throw new IllegalArgumentException("message cannot be null");
        }
        if (physicalLocation == null) {
            throw new IllegalArgumentException("physicalLocation cannot be null");
        }
        return new FlowLocation(message, physicalLocation);
    }

    @Override
    public String toString() {
        return "FlowLocation(message=" + message + ", physicalLocation=" + physicalLocation + ")";
    }

    @Override
    public int hashCode() {
        int result = message.hashCode();
        result = 31 * result + physicalLocation.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowLocation)) {
            return false;
        }
        FlowLocation flowLocation = (FlowLocation) other;
        return message.equals(flowLocation.message) && 
               physicalLocation.equals(flowLocation.physicalLocation);
    }
}