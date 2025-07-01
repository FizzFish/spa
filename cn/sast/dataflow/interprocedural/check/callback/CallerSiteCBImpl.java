package cn.sast.dataflow.interprocedural.check.callback;

import cn.sast.api.config.StaticFieldTrackingMode;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.HookEnv;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.callback.ICallerSiteCBImpl;
import cn.sast.dataflow.util.SootUtilsKt;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.DefinitionStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;

public final class CallerSiteCBImpl implements ICallerSiteCBImpl {
    @NotNull
    private final AbstractHeapFactory<IValue> hf;
    @NotNull
    private final SootMethod caller;
    @NotNull
    private final Stmt stmt;
    @NotNull
    private IFact.Builder<IValue> out;
    @NotNull
    private final Type returnType;
    @NotNull
    private final HookEnv env;
    @NotNull
    private IHeapValues<IValue> return;

    public CallerSiteCBImpl(@NotNull AbstractHeapFactory<IValue> hf, @NotNull SootMethod caller, 
            @NotNull Stmt stmt, @NotNull IFact.Builder<IValue> out, 
            @NotNull Type returnType, @NotNull HookEnv env) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        if (caller == null) throw new IllegalArgumentException("caller cannot be null");
        if (stmt == null) throw new IllegalArgumentException("stmt cannot be null");
        if (out == null) throw new IllegalArgumentException("out cannot be null");
        if (returnType == null) throw new IllegalArgumentException("returnType cannot be null");
        if (env == null) throw new IllegalArgumentException("env cannot be null");

        this.hf = hf;
        this.caller = caller;
        this.stmt = stmt;
        this.out = out;
        this.returnType = returnType;
        this.env = env;

        Value returnValue = stmt instanceof DefinitionStmt ? 
            ((DefinitionStmt) stmt).getLeftOp() : 
            "return";
        this.return = hf.push((HeapValuesEnv) env, 
                hf.newSummaryVal((HeapValuesEnv) env, returnType, returnValue))
            .markSummaryReturnValueInCalleeSite()
            .popHV();
    }

    @Override
    @NotNull
    public AbstractHeapFactory<IValue> getHf() {
        return hf;
    }

    @Override
    @NotNull
    public SootMethod getCaller() {
        return caller;
    }

    @Override
    @NotNull
    public Stmt getStmt() {
        return stmt;
    }

    @Override
    @NotNull
    public IFact.Builder<IValue> getOut() {
        return out;
    }

    @Override
    public void setOut(@NotNull IFact.Builder<IValue> builder) {
        if (builder == null) throw new IllegalArgumentException("builder cannot be null");
        this.out = builder;
    }

    @Override
    @NotNull
    public HookEnv getEnv() {
        return env;
    }

    @Override
    @NotNull
    public AnyNewExprEnv getNewEnv() {
        return new AnyNewExprEnv(getCaller(), (Unit) getStmt());
    }

    @Override
    @NotNull
    public Object argToValue(int argIndex) {
        InvokeExpr iee = stmt.getInvokeExpr();
        if (iee == null) throw new IllegalStateException("InvokeExpr is null");
        return SootUtilsKt.argToOpAndType(iee, argIndex).component1();
    }

    @Override
    @NotNull
    public IHeapValues<IValue> getGlobal() {
        if (hf.getVg().getStaticFieldTrackingMode() != StaticFieldTrackingMode.None) {
            return hf.push((HeapValuesEnv) env, hf.getVg().getGLOBAL_SITE()).popHV();
        }
        return hf.empty();
    }

    @Override
    @NotNull
    public IHeapValues<IValue> arg(int argIndex) {
        if (!stmt.containsInvokeExpr()) {
            throw new IllegalStateException("env: " + env + "\nstmt = " + stmt + "\nargIndex=" + argIndex);
        }
        InvokeExpr iee = stmt.getInvokeExpr();
        if (iee == null) throw new IllegalStateException("InvokeExpr is null");
        var pair = SootUtilsKt.argToOpAndType(iee, argIndex);
        Value sootValue = (Value) pair.component1();
        Type type = (Type) pair.component2();
        return out.getOfSootValue((HeapValuesEnv) env, sootValue, type);
    }

    @Override
    @NotNull
    public IHeapValues<IValue> getReturn() {
        return return;
    }

    @Override
    public void setReturn(@NotNull IHeapValues<IValue> value) {
        if (value == null) throw new IllegalArgumentException("value cannot be null");
        this.return = value;
    }

    @Override
    @NotNull
    public IHeapValues<IValue> getThis() {
        return arg(-1);
    }
}
