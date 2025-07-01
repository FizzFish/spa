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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;

public final class ModelingCallBack {
    @NotNull
    private final SootMethod method;
    @NotNull
    private final IStmt stmt;

    public ModelingCallBack(@NotNull SootMethod method, @NotNull IStmt stmt) {
        if (method == null) {
            throw new IllegalArgumentException("method cannot be null");
        }
        if (stmt == null) {
            throw new IllegalArgumentException("stmt cannot be null");
        }
        this.method = method;
        this.stmt = stmt;
    }

    @NotNull
    public SootMethod getMethod() {
        return method;
    }

    @NotNull
    public IStmt getStmt() {
        return stmt;
    }

    @Override
    @NotNull
    public String toString() {
        return method + ":  " + stmt;
    }

    @Nullable
    public IFact<IValue> model(
            @NotNull InterproceduralCFG icfg,
            @NotNull AbstractHeapFactory<IValue> hf,
            @NotNull HookEnv env,
            @NotNull ICallCB<IHeapValues<IValue>, IFact.Builder<IValue>> summaryCtxCalleeSite) {
        if (icfg == null) {
            throw new IllegalArgumentException("icfg cannot be null");
        }
        if (hf == null) {
            throw new IllegalArgumentException("hf cannot be null");
        }
        if (env == null) {
            throw new IllegalArgumentException("env cannot be null");
        }
        if (summaryCtxCalleeSite == null) {
            throw new IllegalArgumentException("summaryCtxCalleeSite cannot be null");
        }

        HeapValuesEnv envWithStmt;
        if (summaryCtxCalleeSite instanceof IPrevCB) {
            envWithStmt = new StmtModelingEnv(env.getNode(), new PrevCallStmtInfo(stmt, method));
        } else if (summaryCtxCalleeSite instanceof IPostCB) {
            envWithStmt = new StmtModelingEnv(env.getNode(), new PostCallStmtInfo(stmt, env.getNode()));
        } else {
            envWithStmt = env;
        }

        FactModeling m = new FactModeling(hf, envWithStmt, summaryCtxCalleeSite, summaryCtxCalleeSite.getOut());
        IModelStmtVisitor stmtVisitor = m.getVisitor();
        stmt.accept(stmtVisitor);
        return null;
    }
}
