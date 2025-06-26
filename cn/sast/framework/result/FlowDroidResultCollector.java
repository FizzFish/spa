/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.result.FlowDroidResultCollector
 *  cn.sast.framework.result.IFlowDroidResultCollector
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.jimple.infoflow.data.AbstractionAtSink
 *  soot.jimple.infoflow.results.InfoflowResults
 *  soot.jimple.infoflow.solver.cfg.IInfoflowCFG
 */
package cn.sast.framework.result;

import cn.sast.framework.result.IFlowDroidResultCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.jimple.infoflow.data.AbstractionAtSink;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0013"}, d2={"Lcn/sast/framework/result/FlowDroidResultCollector;", "Lcn/sast/framework/result/IFlowDroidResultCollector;", "<init>", "()V", "result", "Lsoot/jimple/infoflow/results/InfoflowResults;", "getResult", "()Lsoot/jimple/infoflow/results/InfoflowResults;", "onResultsAvailable", "", "cfg", "Lsoot/jimple/infoflow/solver/cfg/IInfoflowCFG;", "results", "onResultAvailable", "", "abs", "Lsoot/jimple/infoflow/data/AbstractionAtSink;", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "corax-framework"})
public final class FlowDroidResultCollector
implements IFlowDroidResultCollector {
    @NotNull
    private final InfoflowResults result = new InfoflowResults();

    @NotNull
    public final InfoflowResults getResult() {
        return this.result;
    }

    public void onResultsAvailable(@Nullable IInfoflowCFG cfg, @Nullable InfoflowResults results) {
        this.result.addAll(results);
    }

    public boolean onResultAvailable(@NotNull IInfoflowCFG cfg, @Nullable AbstractionAtSink abs) {
        Intrinsics.checkNotNullParameter((Object)cfg, (String)"cfg");
        return true;
    }

    @Nullable
    public Object flush(@NotNull Continuation<? super Unit> $completion) {
        return Unit.INSTANCE;
    }
}

