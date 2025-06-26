/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage
 *  cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.override.lang.Debug
 *  cn.sast.dataflow.interprocedural.override.lang.Debug$Companion
 *  cn.sast.dataflow.interprocedural.override.lang.Debug$register$1
 *  cn.sast.dataflow.interprocedural.override.lang.Debug$register$3
 *  com.feysh.corax.config.api.utils.UtilsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KCallable
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl;
import cn.sast.dataflow.interprocedural.override.lang.Debug;
import com.feysh.corax.config.api.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u0007*\u00100\bj\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\tH\u0016\u00a8\u0006\u000b"}, d2={"Lcn/sast/dataflow/interprocedural/override/lang/Debug;", "Lcn/sast/dataflow/interprocedural/analysis/SummaryHandlePackage;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "<init>", "()V", "register", "", "Lcn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/AnalysisInSummary;", "Companion", "corax-data-flow"})
public final class Debug
implements SummaryHandlePackage<IValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);

    public void register(@NotNull ACheckCallAnalysis $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"<this>");
        KLogger logger = KotlinLogging.INSTANCE.logger(Debug::register$lambda$0);
        $this$register.evalCallAtCaller(UtilsKt.getSootSignature((KCallable)((KCallable)register.1.INSTANCE)), arg_0 -> Debug.register$lambda$2(logger, arg_0));
        $this$register.evalCallAtCaller(UtilsKt.getSootSignature((KCallable)((KCallable)register.3.INSTANCE)), arg_0 -> Debug.register$lambda$4(logger, arg_0));
    }

    private static final Unit register$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final Object register$lambda$2$lambda$1() {
        return "debug break";
    }

    private static final Unit register$lambda$2(KLogger $logger, CallerSiteCBImpl.EvalCall $this$evalCallAtCaller) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCallAtCaller, (String)"$this$evalCallAtCaller");
        $logger.debug(Debug::register$lambda$2$lambda$1);
        return Unit.INSTANCE;
    }

    private static final Object register$lambda$4$lambda$3(IHeapValues $res) {
        return "debug print(" + $res + ")";
    }

    private static final Unit register$lambda$4(KLogger $logger, CallerSiteCBImpl.EvalCall $this$evalCallAtCaller) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCallAtCaller, (String)"$this$evalCallAtCaller");
        IHeapValues res = $this$evalCallAtCaller.arg(0);
        $logger.debug(() -> Debug.register$lambda$4$lambda$3(res));
        return Unit.INSTANCE;
    }
}

