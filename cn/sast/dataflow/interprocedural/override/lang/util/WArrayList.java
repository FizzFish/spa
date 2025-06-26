/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage
 *  cn.sast.dataflow.interprocedural.check.OverrideModel
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.override.lang.util.ListSpace
 *  cn.sast.dataflow.interprocedural.override.lang.util.ListSpaceBuilder
 *  cn.sast.dataflow.interprocedural.override.lang.util.WArrayList
 *  cn.sast.dataflow.interprocedural.override.lang.util.WArrayList$Companion
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  soot.BooleanType
 *  soot.G
 *  soot.IntType
 *  soot.Type
 *  soot.jimple.Constant
 *  soot.jimple.IntConstant
 */
package cn.sast.dataflow.interprocedural.override.lang.util;

import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.check.OverrideModel;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl;
import cn.sast.dataflow.interprocedural.override.lang.util.ListSpace;
import cn.sast.dataflow.interprocedural.override.lang.util.ListSpaceBuilder;
import cn.sast.dataflow.interprocedural.override.lang.util.WArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import soot.BooleanType;
import soot.G;
import soot.IntType;
import soot.Type;
import soot.jimple.Constant;
import soot.jimple.IntConstant;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r*\u00100\u000ej\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\u000fH\u0016R\u001b\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2={"Lcn/sast/dataflow/interprocedural/override/lang/util/WArrayList;", "Lcn/sast/dataflow/interprocedural/analysis/SummaryHandlePackage;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "<init>", "()V", "intType", "Lsoot/IntType;", "kotlin.jvm.PlatformType", "getIntType", "()Lsoot/IntType;", "Lsoot/IntType;", "register", "", "Lcn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/AnalysisInSummary;", "Companion", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nWArrayList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WArrayList.kt\ncn/sast/dataflow/interprocedural/override/lang/util/WArrayList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,344:1\n1863#2,2:345\n*S KotlinDebug\n*F\n+ 1 WArrayList.kt\ncn/sast/dataflow/interprocedural/override/lang/util/WArrayList\n*L\n47#1:345,2\n*E\n"})
public final class WArrayList
implements SummaryHandlePackage<IValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final IntType intType = G.v().soot_IntType();

    public final IntType getIntType() {
        return this.intType;
    }

    /*
     * WARNING - void declaration
     */
    public void register(@NotNull ACheckCallAnalysis $this$register) {
        void $this$forEach$iv;
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"<this>");
        String constructor1Sig = "<java.util.ArrayList: void <init>()>";
        String constructor2Sig = "<java.util.ArrayList: void <init>(int)>";
        String constructor3Sig = "<java.util.ArrayList: void <init>(java.util.Collection)>";
        String clearSig = "<java.util.ArrayList: void clear()>";
        String getSig = "<java.util.ArrayList: java.lang.Object get(int)>";
        String addSig = "<java.util.ArrayList: boolean add(java.lang.Object)>";
        String removeSig = "<java.util.ArrayList: java.lang.Object remove(int)>";
        Object object = new String[]{constructor1Sig, constructor2Sig};
        object = CollectionsKt.listOf((Object[])object);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String)element$iv;
            boolean bl = false;
            $this$register.evalCallAtCaller(it, WArrayList::register$lambda$2$lambda$1);
        }
        $this$register.evalCallAtCaller(clearSig, WArrayList::register$lambda$4);
        $this$register.evalCallAtCaller(getSig, arg_0 -> WArrayList.register$lambda$6($this$register, arg_0));
        $this$register.evalCall(addSig, WArrayList::register$lambda$8);
        $this$register.evalCallAtCaller(removeSig, WArrayList::register$lambda$10);
    }

    private static final IHeapValues<IValue> register$mapGetModel(ACheckCallAnalysis $this_register, IData<IValue> mapData, IValue key2) {
        if (Intrinsics.areEqual((Object)FactValuesKt.isNull((IValue)key2), (Object)true)) {
            // empty if block
        }
        if (Intrinsics.areEqual((Object)key2.getType(), (Object)G.v().soot_IntType())) {
            Integer keyIndex = FactValuesKt.getIntValue((IValue)key2, (boolean)false);
            Intrinsics.checkNotNull(mapData, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.override.lang.util.ListSpace");
            ListSpace cfr_ignored_0 = (ListSpace)mapData;
            return ((ListSpace)mapData).get($this_register.getHf(), keyIndex);
        }
        return null;
    }

    private static final boolean register$lambda$2$lambda$1$lambda$0(CallerSiteCBImpl.EvalCall $this_evalCallAtCaller, IOpCalculator $this$resolve, IHeapValues.Builder builder2, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)builder2, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV self = companionVArray[0];
        $this_evalCallAtCaller.getOut().setValueData((HeapValuesEnv)$this_evalCallAtCaller.getEnv(), self.getValue(), (Object)OverrideModel.ArrayList, (IData)new ListSpace(null, null, 3, null));
        return true;
    }

    private static final Unit register$lambda$2$lambda$1(CallerSiteCBImpl.EvalCall $this$evalCallAtCaller) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCallAtCaller, (String)"$this$evalCallAtCaller");
        IHeapValues self = $this$evalCallAtCaller.getThis();
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{self};
        IOpCalculator calculator = $this$evalCallAtCaller.getHf().resolveOp((HeapValuesEnv)$this$evalCallAtCaller.getEnv(), iHeapValuesArray);
        calculator.resolve((arg_0, arg_1, arg_2) -> WArrayList.register$lambda$2$lambda$1$lambda$0($this$evalCallAtCaller, arg_0, arg_1, arg_2));
        return Unit.INSTANCE;
    }

    private static final boolean register$lambda$4$lambda$3(CallerSiteCBImpl.EvalCall $this_evalCallAtCaller, IOpCalculator $this$resolve, IHeapValues.Builder builder2, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)builder2, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV self = companionVArray[0];
        $this_evalCallAtCaller.getOut().setValueData((HeapValuesEnv)$this_evalCallAtCaller.getEnv(), self.getValue(), (Object)OverrideModel.ArrayList, (IData)new ListSpace(null, null, 3, null));
        return true;
    }

    private static final Unit register$lambda$4(CallerSiteCBImpl.EvalCall $this$evalCallAtCaller) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCallAtCaller, (String)"$this$evalCallAtCaller");
        IHeapValues self = $this$evalCallAtCaller.getThis();
        if (!self.isSingle()) {
            $this$evalCallAtCaller.setEvalAble(false);
            return Unit.INSTANCE;
        }
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{self};
        IOpCalculator calculator = $this$evalCallAtCaller.getHf().resolveOp((HeapValuesEnv)$this$evalCallAtCaller.getEnv(), iHeapValuesArray);
        calculator.resolve((arg_0, arg_1, arg_2) -> WArrayList.register$lambda$4$lambda$3($this$evalCallAtCaller, arg_0, arg_1, arg_2));
        return Unit.INSTANCE;
    }

    private static final boolean register$lambda$6$lambda$5(CallerSiteCBImpl.EvalCall $this_evalCallAtCaller, ACheckCallAnalysis $this_register, IOpCalculator $this$get, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$get, (String)"$this$get");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV self = companionVArray[0];
        CompanionV key2 = companionVArray[1];
        IData iData = $this_evalCallAtCaller.getOut().getValueData(self.getValue(), (Object)OverrideModel.ArrayList);
        if (iData == null) {
            return false;
        }
        IData list = iData;
        IHeapValues iHeapValues = WArrayList.register$mapGetModel((ACheckCallAnalysis)$this_register, (IData)list, (IValue)((IValue)key2.getValue()));
        if (iHeapValues == null) {
            return false;
        }
        res.add(iHeapValues);
        return true;
    }

    private static final Unit register$lambda$6(ACheckCallAnalysis $this_register, CallerSiteCBImpl.EvalCall $this$evalCallAtCaller) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCallAtCaller, (String)"$this$evalCallAtCaller");
        IHeapValues self = $this$evalCallAtCaller.getThis();
        IHeapValues key2 = $this$evalCallAtCaller.arg(0);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{self, key2};
        IOpCalculator calculator = $this$evalCallAtCaller.getHf().resolveOp((HeapValuesEnv)$this$evalCallAtCaller.getEnv(), iHeapValuesArray);
        calculator.resolve((arg_0, arg_1, arg_2) -> WArrayList.register$lambda$6$lambda$5($this$evalCallAtCaller, $this_register, arg_0, arg_1, arg_2));
        if (!calculator.isFullySimplified()) {
            $this$evalCallAtCaller.setEvalAble(false);
            return Unit.INSTANCE;
        }
        $this$evalCallAtCaller.setReturn(calculator.getRes().build());
        return Unit.INSTANCE;
    }

    private static final boolean register$lambda$8$lambda$7(CalleeCBImpl.EvalCall $this_evalCall, IHeapValues $value, IOpCalculator $this$add, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$add, (String)"$this$add");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV self = companionVArray[0];
        IData iData = $this_evalCall.getOut().getValueData(self.getValue(), (Object)OverrideModel.ArrayList);
        ListSpace listSpace = iData instanceof ListSpace ? (ListSpace)iData : null;
        if (listSpace == null) {
            return false;
        }
        ListSpace list = listSpace;
        ListSpaceBuilder listBuilder = list.builder();
        listBuilder.add($value);
        $this_evalCall.getOut().setValueData((HeapValuesEnv)$this_evalCall.getEnv(), self.getValue(), (Object)OverrideModel.ArrayList, listBuilder.build());
        AbstractHeapFactory abstractHeapFactory = $this_evalCall.getHf();
        HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this_evalCall.getEnv();
        AbstractHeapFactory abstractHeapFactory2 = $this_evalCall.getHf();
        IntConstant intConstant = IntConstant.v((int)1);
        Intrinsics.checkNotNullExpressionValue((Object)intConstant, (String)"v(...)");
        Constant constant = (Constant)intConstant;
        BooleanType booleanType = G.v().soot_BooleanType();
        Intrinsics.checkNotNullExpressionValue((Object)booleanType, (String)"soot_BooleanType(...)");
        res.add(abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory2.newConstVal(constant, (Type)booleanType)).popHV());
        return true;
    }

    private static final Unit register$lambda$8(CalleeCBImpl.EvalCall $this$evalCall) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCall, (String)"$this$evalCall");
        IHeapValues self = $this$evalCall.getThis();
        IHeapValues value = $this$evalCall.arg(0);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{self};
        IOpCalculator calculator = $this$evalCall.getHf().resolveOp((HeapValuesEnv)$this$evalCall.getEnv(), iHeapValuesArray);
        calculator.resolve((arg_0, arg_1, arg_2) -> WArrayList.register$lambda$8$lambda$7($this$evalCall, value, arg_0, arg_1, arg_2));
        if (!calculator.isFullySimplified()) {
            $this$evalCall.setEvalAble(false);
            return Unit.INSTANCE;
        }
        BooleanType booleanType = G.v().soot_BooleanType();
        Intrinsics.checkNotNullExpressionValue((Object)booleanType, (String)"soot_BooleanType(...)");
        calculator.putSummaryIfNotConcrete((Type)booleanType, (Object)"return");
        $this$evalCall.setReturn(calculator.getRes().build());
        return Unit.INSTANCE;
    }

    private static final boolean register$lambda$10$lambda$9(CallerSiteCBImpl.EvalCall $this_evalCallAtCaller, IOpCalculator $this$add, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$add, (String)"$this$add");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV self = companionVArray[0];
        CompanionV index = companionVArray[1];
        IData iData = $this_evalCallAtCaller.getOut().getValueData(self.getValue(), (Object)OverrideModel.ArrayList);
        ListSpace listSpace = iData instanceof ListSpace ? (ListSpace)iData : null;
        if (listSpace == null) {
            return false;
        }
        ListSpace list = listSpace;
        Integer indexConstant = FactValuesKt.getIntValue((IValue)((IValue)index.getValue()), (boolean)true);
        ListSpaceBuilder listBuilder = list.builder();
        IHeapValues resValue = listBuilder.remove($this_evalCallAtCaller.getHf(), indexConstant);
        $this_evalCallAtCaller.getOut().setValueData((HeapValuesEnv)$this_evalCallAtCaller.getEnv(), self.getValue(), (Object)OverrideModel.ArrayList, listBuilder.build());
        res.add(resValue);
        return true;
    }

    private static final Unit register$lambda$10(CallerSiteCBImpl.EvalCall $this$evalCallAtCaller) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCallAtCaller, (String)"$this$evalCallAtCaller");
        IHeapValues self = $this$evalCallAtCaller.getThis();
        IHeapValues index = $this$evalCallAtCaller.arg(0);
        if (!self.isSingle()) {
            $this$evalCallAtCaller.setEvalAble(false);
            return Unit.INSTANCE;
        }
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{self, index};
        IOpCalculator calculator = $this$evalCallAtCaller.getHf().resolveOp((HeapValuesEnv)$this$evalCallAtCaller.getEnv(), iHeapValuesArray);
        calculator.resolve((arg_0, arg_1, arg_2) -> WArrayList.register$lambda$10$lambda$9($this$evalCallAtCaller, arg_0, arg_1, arg_2));
        if (!calculator.isFullySimplified()) {
            $this$evalCallAtCaller.setEvalAble(false);
            return Unit.INSTANCE;
        }
        calculator.putSummaryIfNotConcrete((Type)$this$evalCallAtCaller.getHf().getVg().getOBJECT_TYPE(), (Object)"return");
        $this$evalCallAtCaller.setReturn(calculator.getRes().build());
        return Unit.INSTANCE;
    }
}

