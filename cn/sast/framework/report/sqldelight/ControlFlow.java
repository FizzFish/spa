package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ControlFlow {
    private final long id;
    private final long __file_id;
    @NotNull
    private final String _file_abs_path;
    @Nullable
    private final String message_en;
    @Nullable
    private final String message_zh;
    private final long __edge_from_region_id;
    private final long __edge_to_region_id;

    public ControlFlow(long id, long __file_id, @NotNull String _file_abs_path, 
                      @Nullable String message_en, @Nullable String message_zh,
                      long __edge_from_region_id, long __edge_to_region_id) {
        if (_file_abs_path == null) {
            throw new NullPointerException("_file_abs_path");
        }
        this.id = id;
        this.__file_id = __file_id;
        this._file_abs_path = _file_abs_path;
        this.message_en = message_en;
        this.message_zh = message_zh;
        this.__edge_from_region_id = __edge_from_region_id;
        this.__edge_to_region_id = __edge_to_region_id;
    }

    public long getId() {
        return id;
    }

    public long get__file_id() {
        return __file_id;
    }

    @NotNull
    public String get_file_abs_path() {
        return _file_abs_path;
    }

    @Nullable
    public String getMessage_en() {
        return message_en;
    }

    @Nullable
    public String getMessage_zh() {
        return message_zh;
    }

    public long get__edge_from_region_id() {
        return __edge_from_region_id;
    }

    public long get__edge_to_region_id() {
        return __edge_to_region_id;
    }

    @NotNull
    public ControlFlow copy(long id, long __file_id, @NotNull String _file_abs_path,
                          @Nullable String message_en, @Nullable String message_zh,
                          long __edge_from_region_id, long __edge_to_region_id) {
        return new ControlFlow(id, __file_id, _file_abs_path, message_en, message_zh, 
                             __edge_from_region_id, __edge_to_region_id);
    }

    @Override
    public String toString() {
        return "ControlFlow(id=" + id + 
               ", __file_id=" + __file_id + 
               ", _file_abs_path=" + _file_abs_path + 
               ", message_en=" + message_en + 
               ", message_zh=" + message_zh + 
               ", __edge_from_region_id=" + __edge_from_region_id + 
               ", __edge_to_region_id=" + __edge_to_region_id + ")";
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + Long.hashCode(__file_id);
        result = 31 * result + _file_abs_path.hashCode();
        result = 31 * result + (message_en != null ? message_en.hashCode() : 0);
        result = 31 * result + (message_zh != null ? message_zh.hashCode() : 0);
        result = 31 * result + Long.hashCode(__edge_from_region_id);
        result = 31 * result + Long.hashCode(__edge_to_region_id);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof ControlFlow)) return false;
        
        ControlFlow that = (ControlFlow) other;
        return id == that.id &&
               __file_id == that.__file_id &&
               _file_abs_path.equals(that._file_abs_path) &&
               (message_en != null ? message_en.equals(that.message_en) : that.message_en == null) &&
               (message_zh != null ? message_zh.equals(that.message_zh) : that.message_zh == null) &&
               __edge_from_region_id == that.__edge_from_region_id &&
               __edge_to_region_id == that.__edge_to_region_id;
    }
}