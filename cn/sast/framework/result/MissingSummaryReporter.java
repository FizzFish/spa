package cn.sast.framework.result;

import cn.sast.api.report.Counter;
import cn.sast.api.report.IResultCollector;
import cn.sast.common.IResFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;

public final class MissingSummaryReporter implements IMissingSummaryReporter, IResultCollector {
    @Nullable
    private final IResFile outputFile;
    @NotNull
    private final Counter<SootMethod> counter;

    public MissingSummaryReporter() {
        this(null);
    }

    public MissingSummaryReporter(@Nullable IResFile outputFile) {
        this.outputFile = outputFile;
        this.counter = new Counter<>();
    }

    @Override
    public void reportMissingMethod(@NotNull SootMethod method) {
        if (method == null) {
            throw new NullPointerException("method cannot be null");
        }
        counter.count(method);
    }

    @Override
    public void flush() {
        if (outputFile != null) {
            counter.writeResults(outputFile);
        }
    }
}