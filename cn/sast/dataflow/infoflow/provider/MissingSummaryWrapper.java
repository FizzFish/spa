/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.provider.MissingSummaryWrapper
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.SootMethod
 *  soot.jimple.infoflow.methodSummary.data.provider.IMethodSummaryProvider
 *  soot.jimple.infoflow.methodSummary.taintWrappers.ReportMissingSummaryWrapper
 */
package cn.sast.dataflow.infoflow.provider;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;
import soot.jimple.infoflow.methodSummary.data.provider.IMethodSummaryProvider;
import soot.jimple.infoflow.methodSummary.taintWrappers.ReportMissingSummaryWrapper;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B2\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0014R,\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2={"Lcn/sast/dataflow/infoflow/provider/MissingSummaryWrapper;", "Lsoot/jimple/infoflow/methodSummary/taintWrappers/ReportMissingSummaryWrapper;", "flows", "Lsoot/jimple/infoflow/methodSummary/data/provider/IMethodSummaryProvider;", "reportMissing", "Lkotlin/Function1;", "Lsoot/SootMethod;", "Lkotlin/ParameterName;", "name", "method", "", "<init>", "(Lsoot/jimple/infoflow/methodSummary/data/provider/IMethodSummaryProvider;Lkotlin/jvm/functions/Function1;)V", "getReportMissing", "()Lkotlin/jvm/functions/Function1;", "reportMissingMethod", "corax-data-flow"})
public final class MissingSummaryWrapper
extends ReportMissingSummaryWrapper {
    @NotNull
    private final Function1<SootMethod, Unit> reportMissing;

    public MissingSummaryWrapper(@NotNull IMethodSummaryProvider flows, @NotNull Function1<? super SootMethod, Unit> reportMissing) {
        Intrinsics.checkNotNullParameter((Object)flows, (String)"flows");
        Intrinsics.checkNotNullParameter(reportMissing, (String)"reportMissing");
        super(flows);
        this.reportMissing = reportMissing;
    }

    @NotNull
    public final Function1<SootMethod, Unit> getReportMissing() {
        return this.reportMissing;
    }

    protected void reportMissingMethod(@NotNull SootMethod method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        this.reportMissing.invoke((Object)method);
        super.reportMissingMethod(method);
    }
}

