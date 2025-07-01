package cn.sast.api.report;

import cn.sast.api.report.IBugResInfo;
import cn.sast.api.report.Range;
import cn.sast.api.util.ComparatorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MacroExpansion implements Comparable<MacroExpansion> {
    @NotNull
    private final String message;
    @NotNull
    private final IBugResInfo classname;
    private final int line;
    private final int column;
    @Nullable
    private final Range range;

    public MacroExpansion(@NotNull String message, @NotNull IBugResInfo classname, int line, int column, @Nullable Range range) {
        if (message == null) {
            throw new IllegalArgumentException("message cannot be null");
        }
        if (classname == null) {
            throw new IllegalArgumentException("classname cannot be null");
        }
        this.message = message;
        this.classname = classname;
        this.line = line;
        this.column = column;
        this.range = range;
    }

    public MacroExpansion(@NotNull String message, @NotNull IBugResInfo classname, int line, int column) {
        this(message, classname, line, column, null);
    }

    @NotNull
    public String getMessage() {
        return message;
    }

    @NotNull
    public IBugResInfo getClassname() {
        return classname;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    @Nullable
    public Range getRange() {
        return range;
    }

    @Override
    public int compareTo(@NotNull MacroExpansion other) {
        if (other == null) {
            throw new IllegalArgumentException("other cannot be null");
        }

        int result = message.compareTo(other.message);
        if (result != 0) return result;

        result = classname.compareTo(other.classname);
        if (result != 0) return result;

        result = Integer.compare(line, other.line);
        if (result != 0) return result;

        result = Integer.compare(column, other.column);
        if (result != 0) return result;

        return ComparatorUtilsKt.compareToNullable(range, other.range);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof MacroExpansion)) return false;

        MacroExpansion that = (MacroExpansion) other;
        return message.equals(that.message) &&
               classname.equals(that.classname) &&
               line == that.line &&
               column == that.column &&
               (range == null ? that.range == null : range.equals(that.range));
    }

    @Override
    public int hashCode() {
        int result = message.hashCode();
        result = 31 * result + classname.hashCode();
        result = 31 * result + line;
        result = 31 * result + column;
        result = 31 * result + (range != null ? range.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MacroExpansion(message=" + message + 
               ", classname=" + classname + 
               ", line=" + line + 
               ", column=" + column + 
               ", range=" + range + ")";
    }

    @NotNull
    public MacroExpansion copy(@NotNull String message, @NotNull IBugResInfo classname, 
                              int line, int column, @Nullable Range range) {
        return new MacroExpansion(message, classname, line, column, range);
    }
}