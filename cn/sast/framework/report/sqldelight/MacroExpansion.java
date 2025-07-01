package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MacroExpansion {
    private final long macroNoteSetHashId;
    private final long macroNoteId;

    public MacroExpansion(long macroNoteSetHashId, long macroNoteId) {
        this.macroNoteSetHashId = macroNoteSetHashId;
        this.macroNoteId = macroNoteId;
    }

    public long getMacroNoteSetHashId() {
        return macroNoteSetHashId;
    }

    public long getMacroNoteId() {
        return macroNoteId;
    }

    @NotNull
    public MacroExpansion copy(long macroNoteSetHashId, long macroNoteId) {
        return new MacroExpansion(macroNoteSetHashId, macroNoteId);
    }

    @Override
    public @NotNull String toString() {
        return "MacroExpansion(macroNoteSetHashId=" + macroNoteSetHashId + 
               ", macroNoteId=" + macroNoteId + ")";
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(macroNoteSetHashId);
        result = 31 * result + Long.hashCode(macroNoteId);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof MacroExpansion)) return false;
        MacroExpansion that = (MacroExpansion) other;
        return macroNoteSetHashId == that.macroNoteSetHashId && 
               macroNoteId == that.macroNoteId;
    }
}