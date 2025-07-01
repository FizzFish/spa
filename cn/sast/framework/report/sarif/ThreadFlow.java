package cn.sast.framework.report.sarif;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ThreadFlow {
    @NotNull
    private final List<FlowLocationWrapper> locations;

    public ThreadFlow(@NotNull List<FlowLocationWrapper> locations) {
        if (locations == null) {
            throw new IllegalArgumentException("locations cannot be null");
        }
        this.locations = locations;
    }

    @NotNull
    public List<FlowLocationWrapper> getLocations() {
        return locations;
    }

    @NotNull
    public ThreadFlow copy(@NotNull List<FlowLocationWrapper> locations) {
        if (locations == null) {
            throw new IllegalArgumentException("locations cannot be null");
        }
        return new ThreadFlow(locations);
    }

    @Override
    public String toString() {
        return "ThreadFlow(locations=" + locations + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadFlow)) {
            return false;
        }
        ThreadFlow threadFlow = (ThreadFlow) other;
        return locations.equals(threadFlow.locations);
    }

    @Override
    public int hashCode() {
        return locations.hashCode();
    }
}