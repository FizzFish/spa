/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.StaticFieldTrackingMode
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.HookEnv
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl
 *  cn.sast.dataflow.interprocedural.check.callback.ICallerSiteCBImpl
 *  cn.sast.dataflow.util.SootUtilsKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.Value
 *  soot.jimple.DefinitionStmt
 *  soot.jimple.InvokeExpr
 *  soot.jimple.Stmt
 */
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
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.DefinitionStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0003123BC\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u001a\u0010*\u001a\f\u0012\u0004\u0012\u00020\u00040&j\u0002`'2\u0006\u0010#\u001a\u00020$H\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001e\u0010%\u001a\f\u0012\u0004\u0012\u00020\u00040&j\u0002`'8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R$\u0010+\u001a\f\u0012\u0004\u0012\u00020\u00040&j\u0002`'X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010.R\u001e\u0010/\u001a\f\u0012\u0004\u0012\u00020\u00040&j\u0002`'8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u0010)\u00a8\u00064"}, d2={"Lcn/sast/dataflow/interprocedural/check/callback/CallerSiteCBImpl;", "Lcn/sast/dataflow/interprocedural/check/callback/ICallerSiteCBImpl;", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "caller", "Lsoot/SootMethod;", "stmt", "Lsoot/jimple/Stmt;", "out", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "returnType", "Lsoot/Type;", "env", "Lcn/sast/dataflow/interprocedural/analysis/HookEnv;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;Lsoot/SootMethod;Lsoot/jimple/Stmt;Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;Lsoot/Type;Lcn/sast/dataflow/interprocedural/analysis/HookEnv;)V", "getHf", "()Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "getCaller", "()Lsoot/SootMethod;", "getStmt", "()Lsoot/jimple/Stmt;", "getOut", "()Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "setOut", "(Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;)V", "getEnv", "()Lcn/sast/dataflow/interprocedural/analysis/HookEnv;", "newEnv", "Lcn/sast/dataflow/interprocedural/analysis/AnyNewExprEnv;", "getNewEnv", "()Lcn/sast/dataflow/interprocedural/analysis/AnyNewExprEnv;", "argToValue", "", "argIndex", "", "global", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "Lcn/sast/dataflow/interprocedural/check/callback/V;", "getGlobal", "()Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "arg", "return", "getReturn", "setReturn", "(Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;)V", "this", "getThis", "PrevCall", "EvalCall", "PostCall", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nCallCallBackImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallCallBackImpl.kt\ncn/sast/dataflow/interprocedural/check/callback/CallerSiteCBImpl\n+ 2 SootUtils.kt\ncn/sast/api/util/SootUtilsKt\n*L\n1#1,164:1\n310#2:165\n*S KotlinDebug\n*F\n+ 1 CallCallBackImpl.kt\ncn/sast/dataflow/interprocedural/check/callback/CallerSiteCBImpl\n*L\n63#1:165\n*E\n"})
public final class CallerSiteCBImpl
implements ICallerSiteCBImpl {
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

    public CallerSiteCBImpl(@NotNull AbstractHeapFactory<IValue> hf, @NotNull SootMethod caller, @NotNull Stmt stmt, @NotNull IFact.Builder<IValue> out, @NotNull Type returnType, @NotNull HookEnv env) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)caller, (String)"caller");
        Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
        Intrinsics.checkNotNullParameter(out, (String)"out");
        Intrinsics.checkNotNullParameter((Object)returnType, (String)"returnType");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        this.hf = hf;
        this.caller = caller;
        this.stmt = stmt;
        this.out = out;
        this.returnType = returnType;
        this.env = env;
        CallerSiteCBImpl callerSiteCBImpl = this;
        boolean bl = false;
        Unit $this$leftOp$iv = (Unit)this.getStmt();
        boolean $i$f$getLeftOp = false;
        DefinitionStmt definitionStmt = $this$leftOp$iv instanceof DefinitionStmt ? (DefinitionStmt)$this$leftOp$iv : null;
        Object object = definitionStmt != null ? definitionStmt.getLeftOp() : null;
        IHeapValues iHeapValues = this.getHf().push((HeapValuesEnv)this.getEnv(), this.getHf().newSummaryVal((HeapValuesEnv)this.getEnv(), this.returnType, (Object)(object != null ? (Serializable)object : (Serializable)((Object)"return")))).markSummaryReturnValueInCalleeSite().popHV();
        callerSiteCBImpl.return = iHeapValues;
    }

    @NotNull
    public AbstractHeapFactory<IValue> getHf() {
        return this.hf;
    }

    @NotNull
    public SootMethod getCaller() {
        return this.caller;
    }

    @NotNull
    public Stmt getStmt() {
        return this.stmt;
    }

    @NotNull
    public IFact.Builder<IValue> getOut() {
        return this.out;
    }

    public void setOut(@NotNull IFact.Builder<IValue> builder2) {
        Intrinsics.checkNotNullParameter(builder2, (String)"<set-?>");
        this.out = builder2;
    }

    @NotNull
    public HookEnv getEnv() {
        return this.env;
    }

    @NotNull
    public AnyNewExprEnv getNewEnv() {
        return new AnyNewExprEnv(this.getCaller(), (Unit)this.getStmt());
    }

    @NotNull
    public Object argToValue(int argIndex) {
        InvokeExpr iee = this.getStmt().getInvokeExpr();
        Intrinsics.checkNotNull((Object)iee);
        Pair pair = SootUtilsKt.argToOpAndType((InvokeExpr)iee, (int)argIndex);
        Value sootValue = (Value)pair.component1();
        Type type = (Type)pair.component2();
        return sootValue;
    }

    @NotNull
    public IHeapValues<IValue> getGlobal() {
        if (this.getHf().getVg().getStaticFieldTrackingMode() != StaticFieldTrackingMode.None) {
            return this.getHf().push((HeapValuesEnv)this.getEnv(), (Object)this.getHf().getVg().getGLOBAL_SITE()).popHV();
        }
        return this.getHf().empty();
    }

    @NotNull
    public IHeapValues<IValue> arg(int argIndex) {
        if (!this.getStmt().containsInvokeExpr()) {
            boolean bl = false;
            String string = "env: " + this.getEnv() + "\nstmt = " + this.getStmt() + "\nargIndex=" + argIndex;
            throw new IllegalStateException(string.toString());
        }
        InvokeExpr iee = this.getStmt().getInvokeExpr();
        Intrinsics.checkNotNull((Object)iee);
        Pair pair = SootUtilsKt.argToOpAndType((InvokeExpr)iee, (int)argIndex);
        Value sootValue = (Value)pair.component1();
        Type type = (Type)pair.component2();
        return this.getOut().getOfSootValue((HeapValuesEnv)this.getEnv(), sootValue, type);
    }

    @NotNull
    public IHeapValues<IValue> getReturn() {
        return this.return;
    }

    public void setReturn(@NotNull IHeapValues<IValue> iHeapValues) {
        Intrinsics.checkNotNullParameter(iHeapValues, (String)"<set-?>");
        this.return = iHeapValues;
    }

    @NotNull
    public IHeapValues<IValue> getThis() {
        return this.arg(-1);
    }
}

