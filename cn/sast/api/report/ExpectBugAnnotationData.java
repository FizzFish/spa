package cn.sast.api.report;

import cn.sast.common.IResFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ExpectBugAnnotationData<BugT> {
    public enum Kind {
    }

    @NotNull
    private final IResFile file;
    private final int line;
    private final int column;
    private final BugT bug;
    @NotNull
    private final Kind kind;

    public ExpectBugAnnotationData(@NotNull IResFile file, int line, int column, BugT bug, @NotNull Kind kind) {
        if (file == null) throw new IllegalArgumentException("file cannot be null");
        if (kind == null) throw new IllegalArgumentException("kind cannot be null");
        this.file = file;
        this.line = line;
        this.column = column;
        this.bug = bug;
        this.kind = kind;
    }

    @NotNull
    public IResFile getFile() {
        return file;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public BugT getBug() {
        return bug;
    }

    @NotNull
    public Kind getKind() {
        return kind;
    }

    @Override
    public String toString() {
        return "file: " + file + ":" + line + ":" + column + " kind: " + kind + " a bug: " + bug;
    }

    @NotNull
    public IResFile component1() {
        return file;
    }

    public int component2() {
        return line;
    }

    public int component3() {
        return column;
    }

    public BugT component4() {
        return bug;
    }

    @NotNull
    public Kind component5() {
        return kind;
    }

    @NotNull
    public ExpectBugAnnotationData<BugT> copy(@NotNull IResFile file, int line, int column, BugT bug, @NotNull Kind kind) {
        if (file == null) throw new IllegalArgumentException("file cannot be null");
        if (kind == null) throw new IllegalArgumentException("kind cannot be null");
        return new ExpectBugAnnotationData<>(file, line, column, bug, kind);
    }

    @Override
    public int hashCode() {
        int result = file.hashCode();
        result = 31 * result + Integer.hashCode(line);
        result = 31 * result + Integer.hashCode(column);
        result = 31 * result + (bug != null ? bug.hashCode() : 0);
        result = 31 * result + kind.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof ExpectBugAnnotationData)) return false;
        ExpectBugAnnotationData<?> that = (ExpectBugAnnotationData<?>) other;
        return file.equals(that.file) &&
                line == that.line &&
                column == that.column &&
                (bug == null ? that.bug == null : bug.equals(that.bug)) &&
                kind == that.kind;
    }
}