package cn.sast.framework.result;

import cn.sast.api.report.BugPathEvent;
import cn.sast.api.report.IBugResInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public final class PurificationReportKey {
    @NotNull
    private final IBugResInfo bugResFile;
    private final int line;
    @NotNull
    private final String checkName;
    @NotNull
    private final BugPathEvent firstEvent;

    public PurificationReportKey(@NotNull IBugResInfo bugResFile, int line, 
            @NotNull String checkName, @NotNull BugPathEvent firstEvent) {
        this.bugResFile = Objects.requireNonNull(bugResFile, "bugResFile");
        this.line = line;
        this.checkName = Objects.requireNonNull(checkName, "checkName");
        this.firstEvent = Objects.requireNonNull(firstEvent, "firstEvent");
    }

    @NotNull
    public IBugResInfo getBugResFile() {
        return bugResFile;
    }

    public int getLine() {
        return line;
    }

    @NotNull
    public String getCheckName() {
        return checkName;
    }

    @NotNull
    public BugPathEvent getFirstEvent() {
        return firstEvent;
    }

    @NotNull
    public PurificationReportKey copy(@NotNull IBugResInfo bugResFile, int line, 
            @NotNull String checkName, @NotNull BugPathEvent firstEvent) {
        return new PurificationReportKey(
            Objects.requireNonNull(bugResFile, "bugResFile"),
            line,
            Objects.requireNonNull(checkName, "checkName"),
            Objects.requireNonNull(firstEvent, "firstEvent")
        );
    }

    @Override
    public String toString() {
        return "PurificationReportKey(bugResFile=" + bugResFile + 
               ", line=" + line + 
               ", checkName=" + checkName + 
               ", firstEvent=" + firstEvent + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof PurificationReportKey)) return false;
        PurificationReportKey that = (PurificationReportKey) other;
        return line == that.line &&
               bugResFile.equals(that.bugResFile) &&
               checkName.equals(that.checkName) &&
               firstEvent.equals(that.firstEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bugResFile, line, checkName, firstEvent);
    }
}