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
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl
 *  cn.sast.dataflow.interprocedural.check.callback.ICalleeSiteCBImpl
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.RefType
 *  soot.Scene
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
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
import cn.sast.dataflow.interprocedural.check.callback.ICalleeSiteCBImpl;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.RefType;
import soot.Scene;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.jimple.Stmt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0003789B;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010&\u001a\f\u0012\u0004\u0012\u00020\u00040'j\u0002`(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010)\u001a\u00020*H\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR%\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020!\u0012\f\u0012\n #*\u0004\u0018\u00010\"0\"0 8F\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u001e\u0010-\u001a\f\u0012\u0004\u0012\u00020\u00040'j\u0002`(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u001e\u00100\u001a\f\u0012\u0004\u0012\u00020\u00040'j\u0002`(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u0010/R8\u00103\u001a\f\u0012\u0004\u0012\u00020\u00040'j\u0002`(2\u0010\u00102\u001a\f\u0012\u0004\u0012\u00020\u00040'j\u0002`(8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b4\u0010/\"\u0004\b5\u00106\u00a8\u0006:"}, d2={"Lcn/sast/dataflow/interprocedural/check/callback/CalleeCBImpl;", "Lcn/sast/dataflow/interprocedural/check/callback/ICalleeSiteCBImpl;", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "callee", "Lsoot/SootMethod;", "stmt", "Lsoot/jimple/Stmt;", "out", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "env", "Lcn/sast/dataflow/interprocedural/analysis/HookEnv;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;Lsoot/SootMethod;Lsoot/jimple/Stmt;Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;Lcn/sast/dataflow/interprocedural/analysis/HookEnv;)V", "getHf", "()Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "getCallee", "()Lsoot/SootMethod;", "getStmt", "()Lsoot/jimple/Stmt;", "getOut", "()Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "setOut", "(Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;)V", "getEnv", "()Lcn/sast/dataflow/interprocedural/analysis/HookEnv;", "newEnv", "Lcn/sast/dataflow/interprocedural/analysis/AnyNewExprEnv;", "getNewEnv", "()Lcn/sast/dataflow/interprocedural/analysis/AnyNewExprEnv;", "globalStaticObject", "Lkotlin/Pair;", "", "Lsoot/RefType;", "kotlin.jvm.PlatformType", "getGlobalStaticObject", "()Lkotlin/Pair;", "arg", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "Lcn/sast/dataflow/interprocedural/check/callback/V;", "argIndex", "", "argToValue", "", "global", "getGlobal", "()Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "this", "getThis", "value", "return", "getReturn", "setReturn", "(Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;)V", "PrevCall", "EvalCall", "PostCall", "corax-data-flow"})
public final class CalleeCBImpl
implements ICalleeSiteCBImpl {
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

    public CalleeCBImpl(@NotNull AbstractHeapFactory<IValue> hf, @NotNull SootMethod callee, @NotNull Stmt stmt, @NotNull IFact.Builder<IValue> out, @NotNull HookEnv env) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)callee, (String)"callee");
        Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
        Intrinsics.checkNotNullParameter(out, (String)"out");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        this.hf = hf;
        this.callee = callee;
        this.stmt = stmt;
        this.out = out;
        this.env = env;
    }

    @NotNull
    public AbstractHeapFactory<IValue> getHf() {
        return this.hf;
    }

    @NotNull
    public SootMethod getCallee() {
        return this.callee;
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
        return new AnyNewExprEnv(this.getCallee(), (Unit)this.getStmt());
    }

    @NotNull
    public final Pair<String, RefType> getGlobalStaticObject() {
        return TuplesKt.to((Object)this.getHf().getVg().getGLOBAL_LOCAL(), (Object)Scene.v().getObjectType());
    }

    @NotNull
    public IHeapValues<IValue> arg(int argIndex) {
        IHeapValues iHeapValues = this.getOut().getTargetsUnsafe((Object)argIndex);
        if (iHeapValues == null) {
            iHeapValues = this.getHf().empty();
        }
        return iHeapValues;
    }

    @NotNull
    public Object argToValue(int argIndex) {
        return argIndex;
    }

    @NotNull
    public IHeapValues<IValue> getGlobal() {
        if (this.getHf().getVg().getStaticFieldTrackingMode() != StaticFieldTrackingMode.None) {
            return this.getHf().push((HeapValuesEnv)this.getEnv(), (Object)this.getHf().getVg().getGLOBAL_SITE()).popHV();
        }
        return this.getHf().empty();
    }

    @NotNull
    public IHeapValues<IValue> getThis() {
        return this.arg(-1);
    }

    @NotNull
    public IHeapValues<IValue> getReturn() {
        IHeapValues iHeapValues = this.getOut().getTargetsUnsafe((Object)this.getHf().getVg().getRETURN_LOCAL());
        if (iHeapValues != null) {
            IHeapValues it = iHeapValues;
            boolean bl = false;
            return it;
        }
        Type returnType = this.getCallee().getReturnType();
        AbstractHeapFactory abstractHeapFactory = this.getHf();
        HeapValuesEnv heapValuesEnv = (HeapValuesEnv)this.getEnv();
        AbstractHeapFactory abstractHeapFactory2 = this.getHf();
        HeapValuesEnv heapValuesEnv2 = (HeapValuesEnv)this.getEnv();
        Intrinsics.checkNotNull((Object)returnType);
        IHeapValues iHeapValues2 = abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory2.newSummaryVal(heapValuesEnv2, returnType, (Object)this.getHf().getVg().getRETURN_LOCAL())).markSummaryReturnValueInCalleeSite().popHV();
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)this.getOut(), (HeapValuesEnv)((HeapValuesEnv)this.getEnv()), (Object)this.getHf().getVg().getRETURN_LOCAL(), (IHeapValues)iHeapValues2, (boolean)false, (int)8, null);
        return iHeapValues2;
    }

    public void setReturn(@NotNull IHeapValues<IValue> value) {
        Intrinsics.checkNotNullParameter(value, (String)"value");
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)this.getOut(), (HeapValuesEnv)((HeapValuesEnv)this.getEnv()), (Object)this.getHf().getVg().getRETURN_LOCAL(), value, (boolean)false, (int)8, null);
    }
}

