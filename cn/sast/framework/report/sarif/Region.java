package cn.sast.framework.report.sarif;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Region {
    private final int startLine;
    private final int startColumn;
    private final int endLine;
    private final int endColumn;

    public Region(int startLine, int startColumn, int endLine, int endColumn) {
        this.startLine = startLine;
        this.startColumn = startColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

    public Region(int startLine) {
        this(startLine, 0, 0, 0);
    }

    public Region(@NotNull com.feysh.corax.config.api.report.Region region) {
        this(
            Math.max(region.startLine, 0),
            Math.max(region.startColumn, 0),
            Math.max(region.getEndLine(), 0),
            Math.max(region.getEndColumn() + 1, 0)
        );
    }

    public int getStartLine() {
        return startLine;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public int getEndLine() {
        return endLine;
    }

    public int getEndColumn() {
        return endColumn;
    }

    @NotNull
    public Region copy(int startLine, int startColumn, int endLine, int endColumn) {
        return new Region(startLine, startColumn, endLine, endColumn);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof Region)) return false;
        
        Region region = (Region) other;
        return startLine == region.startLine &&
               startColumn == region.startColumn &&
               endLine == region.endLine &&
               endColumn == region.endColumn;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(startLine);
        result = 31 * result + Integer.hashCode(startColumn);
        result = 31 * result + Integer.hashCode(endLine);
        result = 31 * result + Integer.hashCode(endColumn);
        return result;
    }

    @Override
    public String toString() {
        return "Region(startLine=" + startLine + 
               ", startColumn=" + startColumn + 
               ", endLine=" + endLine + 
               ", endColumn=" + endColumn + ")";
    }
}