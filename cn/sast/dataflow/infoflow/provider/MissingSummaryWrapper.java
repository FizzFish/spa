package cn.sast.dataflow.infoflow.provider;

import org.jetbrains.annotations.NotNull;
import soot.SootMethod;
import soot.jimple.infoflow.methodSummary.data.provider.IMethodSummaryProvider;
import soot.jimple.infoflow.methodSummary.taintWrappers.ReportMissingSummaryWrapper;
import java.util.function.Consumer;

public final class MissingSummaryWrapper extends ReportMissingSummaryWrapper {
    private final Consumer<SootMethod> reportMissing;

    public MissingSummaryWrapper(@NotNull IMethodSummaryProvider flows, 
            @NotNull Consumer<SootMethod> reportMissing) {
        super(flows);
        if (flows == null) throw new IllegalArgumentException("flows cannot be null");
        if (reportMissing == null) throw new IllegalArgumentException("reportMissing cannot be null");
        this.reportMissing = reportMissing;
    }

    @NotNull
    public Consumer<SootMethod> getReportMissing() {
        return reportMissing;
    }

    @Override
    protected void reportMissingMethod(@NotNull SootMethod method) {
        if (method == null) throw new IllegalArgumentException("method cannot be null");
        reportMissing.accept(method);
        super.reportMissingMethod(method);
    }
}