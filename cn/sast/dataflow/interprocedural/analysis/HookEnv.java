/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AIContext
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.HookEnv
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.Unit
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AIContext;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.Unit;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/HookEnv;", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "ctx", "Lcn/sast/dataflow/interprocedural/analysis/AIContext;", "u", "Lsoot/Unit;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/AIContext;Lsoot/Unit;)V", "getCtx", "()Lcn/sast/dataflow/interprocedural/analysis/AIContext;", "corax-data-flow"})
public final class HookEnv
extends HeapValuesEnv {
    @NotNull
    private final AIContext ctx;

    public HookEnv(@NotNull AIContext ctx2, @NotNull Unit u) {
        Intrinsics.checkNotNullParameter((Object)ctx2, (String)"ctx");
        Intrinsics.checkNotNullParameter((Object)u, (String)"u");
        super(u);
        this.ctx = ctx2;
    }

    @NotNull
    public final AIContext getCtx() {
        return this.ctx;
    }
}

