/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.override.lang.WObject
 *  cn.sast.dataflow.interprocedural.override.lang.WObject$Companion
 *  cn.sast.dataflow.interprocedural.override.lang.WObject$register$1
 *  cn.sast.dataflow.interprocedural.override.lang.WObject$register$3
 *  cn.sast.dataflow.interprocedural.override.lang.WObject$register$hashCodeSignature$1
 *  com.feysh.corax.config.api.utils.UtilsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KCallable
 *  org.jetbrains.annotations.NotNull
 *  soot.ArrayType
 *  soot.G
 *  soot.IntType
 *  soot.PrimType
 *  soot.RefType
 *  soot.Type
 *  soot.jimple.ClassConstant
 *  soot.jimple.Constant
 */
package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.override.lang.WObject;
import com.feysh.corax.config.api.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import org.jetbrains.annotations.NotNull;
import soot.ArrayType;
import soot.G;
import soot.IntType;
import soot.PrimType;
import soot.RefType;
import soot.Type;
import soot.jimple.ClassConstant;
import soot.jimple.Constant;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r*\u00100\u000ej\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\u000fH\u0016R\u001b\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2={"Lcn/sast/dataflow/interprocedural/override/lang/WObject;", "Lcn/sast/dataflow/interprocedural/analysis/SummaryHandlePackage;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "<init>", "()V", "jClassType", "Lsoot/RefType;", "kotlin.jvm.PlatformType", "getJClassType", "()Lsoot/RefType;", "Lsoot/RefType;", "register", "", "Lcn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/AnalysisInSummary;", "Companion", "corax-data-flow"})
public final class WObject
implements SummaryHandlePackage<IValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final RefType jClassType = RefType.v((String)"java.lang.Class");

    public final RefType getJClassType() {
        return this.jClassType;
    }

    public void register(@NotNull ACheckCallAnalysis $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"<this>");
        $this$register.evalCall(UtilsKt.getSootSignature((KCallable)((KCallable)register.1.INSTANCE)), arg_0 -> WObject.register$lambda$1(this, arg_0));
        $this$register.evalCall(UtilsKt.getSootSignature((KCallable)((KCallable)register.3.INSTANCE)), WObject::register$lambda$3);
        String hashCodeSignature2 = UtilsKt.getSootSignature((KCallable)((KCallable)register.hashCodeSignature.1.INSTANCE));
        $this$register.evalCall(hashCodeSignature2, WObject::register$lambda$5);
    }

    private static final boolean register$lambda$1$lambda$0(CalleeCBImpl.EvalCall $this_evalCall, WObject this$0, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Type type;
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV cop = companionVArray[0];
        IValue op = (IValue)cop.getValue();
        if (!op.typeIsConcrete()) {
            return false;
        }
        Type type2 = type = op.getType();
        Object object = type2 instanceof RefType || type2 instanceof ArrayType || type2 instanceof PrimType ? ClassConstant.fromType((Type)type) : null;
        if (object == null) {
            return false;
        }
        ClassConstant c = object;
        AbstractHeapFactory abstractHeapFactory = $this_evalCall.getHf();
        HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this_evalCall.getEnv();
        AbstractHeapFactory abstractHeapFactory2 = $this_evalCall.getHf();
        Constant constant = (Constant)c;
        RefType refType = this$0.jClassType;
        Intrinsics.checkNotNullExpressionValue((Object)refType, (String)"jClassType");
        res.add(abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory2.newConstVal(constant, (Type)refType)).markOfGetClass(cop).pop());
        return true;
    }

    private static final Unit register$lambda$1(WObject this$0, CalleeCBImpl.EvalCall $this$evalCall) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCall, (String)"$this$evalCall");
        IHeapValues obj = $this$evalCall.arg(-1);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{obj};
        IOpCalculator unop = $this$evalCall.getHf().resolveOp((HeapValuesEnv)$this$evalCall.getEnv(), iHeapValuesArray);
        unop.resolve((arg_0, arg_1, arg_2) -> WObject.register$lambda$1$lambda$0($this$evalCall, this$0, arg_0, arg_1, arg_2));
        RefType refType = this$0.jClassType;
        Intrinsics.checkNotNullExpressionValue((Object)refType, (String)"jClassType");
        unop.putSummaryIfNotConcrete((Type)refType, (Object)"return");
        $this$evalCall.setReturn(unop.getRes().build());
        return Unit.INSTANCE;
    }

    private static final boolean register$lambda$3$lambda$2(CalleeCBImpl.EvalCall $this_evalCall, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV th1s = companionVArray[0];
        CompanionV that = companionVArray[1];
        if (((IValue)that.getValue()).isNullConstant()) {
            v0 = res.add($this_evalCall.getHf().push((HeapValuesEnv)$this_evalCall.getEnv(), $this_evalCall.getHf().toConstVal((Object)false)).markOfObjectEqualsResult(th1s, that).pop());
        } else {
            boolean eq = Intrinsics.areEqual((Object)th1s.getValue(), (Object)that.getValue());
            v0 = res.add($this_evalCall.getHf().push((HeapValuesEnv)$this_evalCall.getEnv(), $this_evalCall.getHf().toConstVal((Object)eq)).markOfObjectEqualsResult(th1s, that).pop());
        }
        return true;
    }

    private static final Unit register$lambda$3(CalleeCBImpl.EvalCall $this$evalCall) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCall, (String)"$this$evalCall");
        IHeapValues selfO = $this$evalCall.arg(-1);
        IHeapValues thatO = $this$evalCall.arg(0);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{selfO, thatO};
        IOpCalculator strObjectOp = $this$evalCall.getHf().resolveOp((HeapValuesEnv)$this$evalCall.getEnv(), iHeapValuesArray);
        strObjectOp.resolve((arg_0, arg_1, arg_2) -> WObject.register$lambda$3$lambda$2($this$evalCall, arg_0, arg_1, arg_2));
        $this$evalCall.setReturn(strObjectOp.getRes().build());
        return Unit.INSTANCE;
    }

    private static final boolean register$lambda$5$lambda$4(CalleeCBImpl.EvalCall $this_evalCall, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV instance = companionVArray[0];
        res.add($this_evalCall.getHf().push((HeapValuesEnv)$this_evalCall.getEnv(), $this_evalCall.getHf().toConstVal((Object)instance.hashCode())).markOfReturnValueOfMethod($this_evalCall).pop());
        return true;
    }

    private static final Unit register$lambda$5(CalleeCBImpl.EvalCall $this$evalCall) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCall, (String)"$this$evalCall");
        IHeapValues obj = $this$evalCall.arg(0);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{obj};
        IOpCalculator unop = $this$evalCall.getHf().resolveOp((HeapValuesEnv)$this$evalCall.getEnv(), iHeapValuesArray);
        unop.resolve((arg_0, arg_1, arg_2) -> WObject.register$lambda$5$lambda$4($this$evalCall, arg_0, arg_1, arg_2));
        IntType intType = G.v().soot_IntType();
        Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
        unop.putSummaryIfNotConcrete((Type)intType, (Object)"return");
        $this$evalCall.setReturn(unop.getRes().build());
        return Unit.INSTANCE;
    }
}

