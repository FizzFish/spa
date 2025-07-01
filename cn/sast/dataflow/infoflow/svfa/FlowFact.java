package cn.sast.dataflow.infoflow.svfa;

import kotlinx.collections.immutable.PersistentMap;
import kotlinx.collections.immutable.PersistentSet;
import org.jetbrains.annotations.NotNull;
import soot.Value;
import java.util.Objects;

public final class FlowFact {
    @NotNull
    private PersistentMap<Value, PersistentSet<VFNode>> data = PersistentMap.empty();

    @NotNull
    public PersistentMap<Value, PersistentSet<VFNode>> getData() {
        return data;
    }

    public void setData(@NotNull PersistentMap<Value, ? extends PersistentSet<VFNode>> data) {
        Objects.requireNonNull(data, "data cannot be null");
        this.data = (PersistentMap<Value, PersistentSet<VFNode>>) data;
    }

    @Override
    public String toString() {
        return "\n" + String.join("\n", data.values().stream()
            .flatMap(PersistentSet::stream)
            .toList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof FlowFact)) return false;
        FlowFact that = (FlowFact) other;
        return Objects.equals(data, that.data);
    }
}