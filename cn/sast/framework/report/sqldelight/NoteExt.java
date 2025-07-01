package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NoteExt {
    private final long __note_id;
    @NotNull
    private final String attr_name;
    @NotNull
    private final String attr_value;

    public NoteExt(long __note_id, @NotNull String attr_name, @NotNull String attr_value) {
        if (attr_name == null) {
            throw new IllegalArgumentException("attr_name cannot be null");
        }
        if (attr_value == null) {
            throw new IllegalArgumentException("attr_value cannot be null");
        }
        this.__note_id = __note_id;
        this.attr_name = attr_name;
        this.attr_value = attr_value;
    }

    public long get__note_id() {
        return __note_id;
    }

    @NotNull
    public String getAttr_name() {
        return attr_name;
    }

    @NotNull
    public String getAttr_value() {
        return attr_value;
    }

    @NotNull
    public NoteExt copy(long __note_id, @NotNull String attr_name, @NotNull String attr_value) {
        return new NoteExt(__note_id, attr_name, attr_value);
    }

    @Override
    public String toString() {
        return "NoteExt(__note_id=" + __note_id + ", attr_name=" + attr_name + ", attr_value=" + attr_value + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof NoteExt)) return false;
        
        NoteExt noteExt = (NoteExt) other;
        return __note_id == noteExt.__note_id 
            && attr_name.equals(noteExt.attr_name) 
            && attr_value.equals(noteExt.attr_value);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(__note_id);
        result = 31 * result + attr_name.hashCode();
        result = 31 * result + attr_value.hashCode();
        return result;
    }
}