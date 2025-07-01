package cn.sast.api.report;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Range implements Comparable<Range>, IReportHashAble {
    private final int start_line;
    private final int start_col;
    private final int end_line;
    private final int end_col;

    public Range(int start_line, int start_col, int end_line, int end_col) {
        this.start_line = start_line;
        this.start_col = start_col;
        this.end_line = end_line;
        this.end_col = end_col;
    }

    public int getStart_line() {
        return start_line;
    }

    public int getStart_col() {
        return start_col;
    }

    public int getEnd_line() {
        return end_line;
    }

    public int getEnd_col() {
        return end_col;
    }

    @Override
    public int compareTo(@NotNull Range other) {
        int result = Integer.compare(start_line, other.start_line);
        if (result != 0) return result;
        
        result = Integer.compare(start_col, other.start_col);
        if (result != 0) return result;
        
        result = Integer.compare(end_line, other.end_line);
        if (result != 0) return result;
        
        return Integer.compare(end_col, other.end_col);
    }

    @Override
    @NotNull
    public String reportHash(@NotNull IReportHashCalculator c) {
        return start_line + "," + start_col + "," + end_line + "," + end_col;
    }

    @Override
    @NotNull
    public String toString() {
        return "[" + start_line + ":" + start_col + "," + end_line + ":" + end_col + "]";
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(start_line);
        result = 31 * result + Integer.hashCode(start_col);
        result = 31 * result + Integer.hashCode(end_line);
        result = 31 * result + Integer.hashCode(end_col);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof Range)) return false;
        
        Range range = (Range) other;
        return start_line == range.start_line &&
               start_col == range.start_col &&
               end_line == range.end_line &&
               end_col == range.end_col;
    }

    public Range copy(int start_line, int start_col, int end_line, int end_col) {
        return new Range(start_line, start_col, end_line, end_col);
    }
}