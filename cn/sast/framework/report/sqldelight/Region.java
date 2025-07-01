package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Region {
    private final long id;
    private final long __file_id;
    private final long start_line;
    @Nullable
    private final Long start_column;
    @Nullable
    private final Long end_line;
    @Nullable
    private final Long end_column;

    public Region(long id, long __file_id, long start_line, @Nullable Long start_column, 
                 @Nullable Long end_line, @Nullable Long end_column) {
        this.id = id;
        this.__file_id = __file_id;
        this.start_line = start_line;
        this.start_column = start_column;
        this.end_line = end_line;
        this.end_column = end_column;
    }

    public long getId() {
        return id;
    }

    public long get__file_id() {
        return __file_id;
    }

    public long getStart_line() {
        return start_line;
    }

    @Nullable
    public Long getStart_column() {
        return start_column;
    }

    @Nullable
    public Long getEnd_line() {
        return end_line;
    }

    @Nullable
    public Long getEnd_column() {
        return end_column;
    }

    @NotNull
    public Region copy(long id, long __file_id, long start_line, @Nullable Long start_column, 
                       @Nullable Long end_line, @Nullable Long end_column) {
        return new Region(id, __file_id, start_line, start_column, end_line, end_column);
    }

    @Override
    public String toString() {
        return "Region(id=" + id + 
               ", __file_id=" + __file_id + 
               ", start_line=" + start_line + 
               ", start_column=" + start_column + 
               ", end_line=" + end_line + 
               ", end_column=" + end_column + ")";
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + Long.hashCode(__file_id);
        result = 31 * result + Long.hashCode(start_line);
        result = 31 * result + (start_column != null ? start_column.hashCode() : 0);
        result = 31 * result + (end_line != null ? end_line.hashCode() : 0);
        result = 31 * result + (end_column != null ? end_column.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof Region)) return false;
        
        Region region = (Region) other;
        return id == region.id &&
               __file_id == region.__file_id &&
               start_line == region.start_line &&
               (start_column == null ? region.start_column == null : start_column.equals(region.start_column)) &&
               (end_line == null ? region.end_line == null : end_line.equals(region.end_line)) &&
               (end_column == null ? region.end_column == null : end_column.equals(region.end_column));
    }
}