package cn.sast.framework.validator;

import cn.sast.api.report.ReportKt;
import cn.sast.common.IResFile;
import com.feysh.corax.config.api.CheckType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public final class ActualBugAnnotationData {
    @NotNull
    private final IResFile file;
    private final int line;
    @NotNull
    private final CheckType checkType;

    public ActualBugAnnotationData(@NotNull IResFile file, int line, @NotNull CheckType checkType) {
        this.file = Objects.requireNonNull(file, "file");
        this.line = line;
        this.checkType = Objects.requireNonNull(checkType, "checkType");
    }

    @NotNull
    public IResFile getFile() {
        return file;
    }

    public int getLine() {
        return line;
    }

    @NotNull
    public CheckType getCheckType() {
        return checkType;
    }

    @Override
    public String toString() {
        checkType.getBugMessage();
        return file + ":" + line + " report a [" + ReportKt.getPerfectName(checkType) + "]";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof ActualBugAnnotationData)) return false;
        ActualBugAnnotationData that = (ActualBugAnnotationData) other;
        return line == that.line &&
                file.equals(that.file) &&
                checkType.equals(that.checkType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, line, checkType);
    }

    @NotNull
    public ActualBugAnnotationData copy(@NotNull IResFile file, int line, @NotNull CheckType checkType) {
        return new ActualBugAnnotationData(
                Objects.requireNonNull(file, "file"),
                line,
                Objects.requireNonNull(checkType, "checkType")
        );
    }
}