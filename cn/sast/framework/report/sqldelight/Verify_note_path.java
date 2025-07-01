package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VerifyNotePath {
    private final long id;
    private final long noteArrayHashId;

    public VerifyNotePath(long id, long noteArrayHashId) {
        this.id = id;
        this.noteArrayHashId = noteArrayHashId;
    }

    public long getId() {
        return id;
    }

    public long getNoteArrayHashId() {
        return noteArrayHashId;
    }

    @NotNull
    public VerifyNotePath copy(long id, long noteArrayHashId) {
        return new VerifyNotePath(id, noteArrayHashId);
    }

    @Override
    public String toString() {
        return "VerifyNotePath(id=" + id + ", noteArrayHashId=" + noteArrayHashId + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof VerifyNotePath)) return false;
        VerifyNotePath that = (VerifyNotePath) other;
        return id == that.id && noteArrayHashId == that.noteArrayHashId;
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + Long.hashCode(noteArrayHashId);
        return result;
    }
}