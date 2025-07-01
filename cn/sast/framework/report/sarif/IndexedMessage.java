package cn.sast.framework.report.sarif;

import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
public final class IndexedMessage {
    @NotNull
    private final String id;

    public IndexedMessage(@NotNull String id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        this.id = id;
    }

    public IndexedMessage() {
        this("default");
    }

    @NotNull
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof IndexedMessage)) return false;
        IndexedMessage that = (IndexedMessage) other;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "IndexedMessage(id=" + id + ")";
    }

    @NotNull
    public IndexedMessage copy(@NotNull String id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        return new IndexedMessage(id);
    }
}