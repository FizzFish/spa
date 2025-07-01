package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VerifyMacro {
    private final long id;
    private final long macroNoteSetHashId;

    public VerifyMacro(long id, long macroNoteSetHashId) {
        this.id = id;
        this.macroNoteSetHashId = macroNoteSetHashId;
    }

    public long getId() {
        return id;
    }

    public long getMacroNoteSetHashId() {
        return macroNoteSetHashId;
    }

    @NotNull
    public VerifyMacro copy(long id, long macroNoteSetHashId) {
        return new VerifyMacro(id, macroNoteSetHashId);
    }

    @Override
    public String toString() {
        return "VerifyMacro(id=" + id + ", macroNoteSetHashId=" + macroNoteSetHashId + ")";
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + Long.hashCode(macroNoteSetHashId);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof VerifyMacro)) return false;
        VerifyMacro that = (VerifyMacro) other;
        return id == that.id && macroNoteSetHashId == that.macroNoteSetHashId;
    }
}