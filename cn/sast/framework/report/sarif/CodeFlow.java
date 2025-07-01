package cn.sast.framework.report.sarif;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CodeFlow {
    @NotNull
    private final List<ThreadFlow> threadFlows;

    public CodeFlow(@NotNull List<ThreadFlow> threadFlows) {
        if (threadFlows == null) {
            throw new IllegalArgumentException("threadFlows cannot be null");
        }
        this.threadFlows = threadFlows;
    }

    @NotNull
    public List<ThreadFlow> getThreadFlows() {
        return threadFlows;
    }

    @NotNull
    public CodeFlow copy(@NotNull List<ThreadFlow> threadFlows) {
        if (threadFlows == null) {
            throw new IllegalArgumentException("threadFlows cannot be null");
        }
        return new CodeFlow(threadFlows);
    }

    @Override
    public String toString() {
        return "CodeFlow(threadFlows=" + threadFlows + ")";
    }

    @Override
    public int hashCode() {
        return threadFlows.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CodeFlow)) {
            return false;
        }
        CodeFlow codeFlow = (CodeFlow) other;
        return threadFlows.equals(codeFlow.threadFlows);
    }
}
