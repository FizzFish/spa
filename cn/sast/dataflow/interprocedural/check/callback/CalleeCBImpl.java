package cn.sast.dataflow.interprocedural.check.callback;

import cn.sast.api.config.StaticFieldTrackingMode;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.HookEnv;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import org.jetbrains.annotations.NotNull;
import soot.RefType;
import soot.Scene;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.jimple.Stmt;

import java.util.Objects;

public final class CalleeCBImpl implements ICalleeSiteCBImpl {
    @NotNull
    private final AbstractHeapFactory<IValue> hf;
    @NotNull
    private final SootMethod callee;
    @NotNull
    private final Stmt stmt;
    @NotNull
    private IFact.Builder<IValue> out;
    @NotNull
    private final HookEnv env;

    public CalleeCBImpl(@NotNull AbstractHeapFactory<IValue> hf, @NotNull SootMethod callee, 
                       @NotNull Stmt stmt, @NotNull IFact.Builder<IValue> out, @NotNull HookEnv env) {
        Objects.requireNonNull(hf, "hf");
        Objects.requireNonNull(callee, "callee");
        Objects.requireNonNull(stmt, "stmt");
        Objects.requireNonNull(out, "out");
        Objects.requireNonNull(env, "env");
        
        this.hf = hf;
        this.callee = callee;
        this.stmt = stmt;
        this.out = out;
        this.env = env;
    }

    @Override
    @NotNull
    public AbstractHeapFactory<IValue> getHf() {
        return hf;
    }

    @Override
    @NotNull
    public SootMethod getCallee() {
        return callee;
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
        Objects.requireNonNull(builder, "<set-?>");
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
        return new AnyNewExprEnv(getCallee(), getStmt());
    }

    @NotNull
    public Pair<String, RefType> getGlobalStaticObject() {
        return Pair.of(getHf().getVg().getGLOBAL_LOCAL(), Scene.v().getObjectType());
    }

    @Override
    @NotNull
    public IHeapValues<IValue> arg(int argIndex) {
        IHeapValues<IValue> values = getOut().getTargetsUnsafe(argIndex);
        return values != null ? values : getHf().empty();
    }

    @Override
    @NotNull
    public Object argToValue(int argIndex) {
        return argIndex;
    }

    @Override
    @NotNull
    public IHeapValues<IValue> getGlobal() {
        return getHf().getVg().getStaticFieldTrackingMode() != StaticFieldTrackingMode.None
                ? getHf().push((HeapValuesEnv)getEnv(), getHf().getVg().getGLOBAL_SITE()).popHV()
                : getHf().empty();
    }

    @Override
    @NotNull
    public IHeapValues<IValue> getThis() {
        return arg(-1);
    }

    @Override
    @NotNull
    public IHeapValues<IValue> getReturn() {
        IHeapValues<IValue> values = getOut().getTargetsUnsafe(getHf().getVg().getRETURN_LOCAL());
        if (values != null) {
            return values;
        }

        Type returnType = getCallee().getReturnType();
        Objects.requireNonNull(returnType);
        
        IHeapValues<IValue> newValues = getHf().push((HeapValuesEnv)getEnv(), 
                getHf().newSummaryVal((HeapValuesEnv)getEnv(), returnType, getHf().getVg().getRETURN_LOCAL()))
                .markSummaryReturnValueInCalleeSite()
                .popHV();
        
        getOut().assignNewExpr((HeapValuesEnv)getEnv(), getHf().getVg().getRETURN_LOCAL(), newValues, false);
        return newValues;
    }

    @Override
    public void setReturn(@NotNull IHeapValues<IValue> value) {
        Objects.requireNonNull(value, "value");
        getOut().assignNewExpr((HeapValuesEnv)getEnv(), getHf().getVg().getRETURN_LOCAL(), value, false);
    }
}