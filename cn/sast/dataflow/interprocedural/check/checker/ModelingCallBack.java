/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.HookEnv
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.StmtModelingEnv
 *  cn.sast.dataflow.interprocedural.check.ModelingStmtInfo
 *  cn.sast.dataflow.interprocedural.check.PostCallStmtInfo
 *  cn.sast.dataflow.interprocedural.check.PrevCallStmtInfo
 *  cn.sast.dataflow.interprocedural.check.checker.FactModeling
 *  cn.sast.dataflow.interprocedural.check.checker.ModelingCallBack
 *  cn.sast.idfa.analysis.InterproceduralCFG
 *  cn.sast.idfa.check.ICallCB
 *  cn.sast.idfa.check.IPostCB
 *  cn.sast.idfa.check.IPrevCB
 *  com.feysh.corax.config.api.IModelStmtVisitor
 *  com.feysh.corax.config.api.IStmt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 */
package cn.sast.dataflow.interprocedural.check.checker;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.HookEnv;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.StmtModelingEnv;
import cn.sast.dataflow.interprocedural.check.ModelingStmtInfo;
import cn.sast.dataflow.interprocedural.check.PostCallStmtInfo;
import cn.sast.dataflow.interprocedural.check.PrevCallStmtInfo;
import cn.sast.dataflow.interprocedural.check.checker.FactModeling;
import cn.sast.idfa.analysis.InterproceduralCFG;
import cn.sast.idfa.check.ICallCB;
import cn.sast.idfa.check.IPostCB;
import cn.sast.idfa.check.IPrevCB;
import com.feysh.corax.config.api.IModelStmtVisitor;
import com.feysh.corax.config.api.IStmt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016JX\u0010\u000e\u001a\u000e\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110\u00152\u0006\u0010\u0016\u001a\u00020\u00172\"\u0010\u0018\u001a\u001e\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001b0\u0019R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001c"}, d2={"Lcn/sast/dataflow/interprocedural/check/checker/ModelingCallBack;", "", "method", "Lsoot/SootMethod;", "stmt", "Lcom/feysh/corax/config/api/IStmt;", "<init>", "(Lsoot/SootMethod;Lcom/feysh/corax/config/api/IStmt;)V", "getMethod", "()Lsoot/SootMethod;", "getStmt", "()Lcom/feysh/corax/config/api/IStmt;", "toString", "", "model", "Lcn/sast/dataflow/interprocedural/analysis/IFact;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "icfg", "Lcn/sast/idfa/analysis/InterproceduralCFG;", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "env", "Lcn/sast/dataflow/interprocedural/analysis/HookEnv;", "summaryCtxCalleeSite", "Lcn/sast/idfa/check/ICallCB;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "corax-data-flow"})
public final class ModelingCallBack {
    @NotNull
    private final SootMethod method;
    @NotNull
    private final IStmt stmt;

    public ModelingCallBack(@NotNull SootMethod method, @NotNull IStmt stmt) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
        this.method = method;
        this.stmt = stmt;
    }

    @NotNull
    public final SootMethod getMethod() {
        return this.method;
    }

    @NotNull
    public final IStmt getStmt() {
        return this.stmt;
    }

    @NotNull
    public String toString() {
        return this.method + ":  " + this.stmt;
    }

    @Nullable
    public final IFact<IValue> model(@NotNull InterproceduralCFG icfg, @NotNull AbstractHeapFactory<IValue> hf, @NotNull HookEnv env, @NotNull ICallCB<IHeapValues<IValue>, IFact.Builder<IValue>> summaryCtxCalleeSite) {
        Intrinsics.checkNotNullParameter((Object)icfg, (String)"icfg");
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(summaryCtxCalleeSite, (String)"summaryCtxCalleeSite");
        HeapValuesEnv envWithStmt = summaryCtxCalleeSite instanceof IPrevCB ? (HeapValuesEnv)new StmtModelingEnv(env.getNode(), (ModelingStmtInfo)new PrevCallStmtInfo(this.stmt, this.method)) : (summaryCtxCalleeSite instanceof IPostCB ? (HeapValuesEnv)new StmtModelingEnv(env.getNode(), (ModelingStmtInfo)new PostCallStmtInfo(this.stmt, env.getNode())) : (HeapValuesEnv)env);
        FactModeling m = new FactModeling(hf, envWithStmt, summaryCtxCalleeSite, (IFact.Builder)summaryCtxCalleeSite.getOut());
        IModelStmtVisitor stmtVisitor2 = m.getVisitor();
        this.stmt.accept(stmtVisitor2);
        return null;
    }
}

