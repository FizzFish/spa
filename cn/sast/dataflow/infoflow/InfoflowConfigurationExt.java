package cn.sast.dataflow.infoflow;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public final class InfoflowConfigurationExt {
    private boolean useSparseOpt;
    @Nullable
    private String missingSummariesFile;

    public InfoflowConfigurationExt(boolean useSparseOpt, @Nullable String missingSummariesFile) {
        this.useSparseOpt = useSparseOpt;
        this.missingSummariesFile = missingSummariesFile;
    }

    public InfoflowConfigurationExt() {
        this(true, null);
    }

    public boolean getUseSparseOpt() {
        return useSparseOpt;
    }

    public void setUseSparseOpt(boolean useSparseOpt) {
        this.useSparseOpt = useSparseOpt;
    }

    @Nullable
    public String getMissingSummariesFile() {
        return missingSummariesFile;
    }

    public void setMissingSummariesFile(@Nullable String missingSummariesFile) {
        this.missingSummariesFile = missingSummariesFile;
    }

    @NotNull
    public InfoflowConfigurationExt copy(boolean useSparseOpt, @Nullable String missingSummariesFile) {
        return new InfoflowConfigurationExt(useSparseOpt, missingSummariesFile);
    }

    @Override
    public String toString() {
        return "InfoflowConfigurationExt(useSparseOpt=" + useSparseOpt + 
               ", missingSummariesFile=" + missingSummariesFile + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(useSparseOpt, missingSummariesFile);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof InfoflowConfigurationExt)) return false;
        InfoflowConfigurationExt that = (InfoflowConfigurationExt) other;
        return useSparseOpt == that.useSparseOpt && 
               Objects.equals(missingSummariesFile, that.missingSummariesFile);
    }
}