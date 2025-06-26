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
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage
 *  cn.sast.dataflow.interprocedural.check.ArraySpace
 *  cn.sast.dataflow.interprocedural.check.ArraySpaceBuilder
 *  cn.sast.dataflow.interprocedural.check.OverrideModel
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.override.lang.util.WHashMap
 *  cn.sast.dataflow.interprocedural.override.lang.util.WHashMap$Companion
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.collections.immutable.ExtensionsKt
 *  org.jetbrains.annotations.NotNull
 *  soot.G
 *  soot.IntType
 *  soot.Type
 */
package cn.sast.dataflow.interprocedural.override.lang.util;

import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.check.ArraySpace;
import cn.sast.dataflow.interprocedural.check.ArraySpaceBuilder;
import cn.sast.dataflow.interprocedural.check.OverrideModel;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl;
import cn.sast.dataflow.interprocedural.override.lang.util.WHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.collections.immutable.ExtensionsKt;
import org.jetbrains.annotations.NotNull;
import soot.G;
import soot.IntType;
import soot.Type;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u0007*\u00100\bj\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\tH\u0016\u00a8\u0006\u000b"}, d2={"Lcn/sast/dataflow/interprocedural/override/lang/util/WHashMap;", "Lcn/sast/dataflow/interprocedural/analysis/SummaryHandlePackage;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "<init>", "()V", "register", "", "Lcn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/AnalysisInSummary;", "Companion", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nWHashMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WHashMap.kt\ncn/sast/dataflow/interprocedural/override/lang/util/WHashMap\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,182:1\n1863#2,2:183\n*S KotlinDebug\n*F\n+ 1 WHashMap.kt\ncn/sast/dataflow/interprocedural/override/lang/util/WHashMap\n*L\n49#1:183,2\n*E\n"})
public final class WHashMap
implements SummaryHandlePackage<IValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);

    /*
     * WARNING - void declaration
     */
    public void register(@NotNull ACheckCallAnalysis $this$register) {
        void $this$forEach$iv;
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"<this>");
        String constructor1Sig = "<java.util.HashMap: void <init>()>";
        String constructor2Sig = "<java.util.HashMap: void <init>(int)>";
        String constructor3Sig = "<java.util.HashMap: void <init>(int, float)>";
        String clearSig = "<java.util.HashMap: void clear()>";
        String containsKeySig = "<java.util.HashMap: boolean containsKey()>";
        String containsValueSig = "<java.util.HashMap: boolean containsValue()>";
        String getSig = "<java.util.HashMap: java.lang.Object get(java.lang.Object)>";
        String getOrDefaultSig = "<java.util.HashMap: java.lang.Object getOrDefault(java.lang.Object,java.lang.Object)>";
        String isEmptySig = "<java.util.HashMap: boolean isEmpty()>";
        String putSig = "<java.util.HashMap: java.lang.Object put(java.lang.Object,java.lang.Object)>";
        String putAllSig = "";
        String putIfAbsent = "";
        Object object = new String[]{constructor1Sig, constructor2Sig, constructor3Sig};
        object = CollectionsKt.listOf((Object[])object);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String)element$iv;
            boolean bl = false;
            $this$register.evalCallAtCaller(it, WHashMap::register$lambda$2$lambda$1);
        }
        $this$register.evalCallAtCaller(clearSig, WHashMap::register$lambda$4);
        $this$register.evalCallAtCaller(getSig, arg_0 -> WHashMap.register$lambda$6($this$register, arg_0));
        $this$register.evalCallAtCaller(getOrDefaultSig, arg_0 -> WHashMap.register$lambda$8($this$register, arg_0));
        $this$register.evalCall(putSig, WHashMap::register$lambda$10);
    }

    private static final IHeapValues<IValue> register$mapGetModel(ACheckCallAnalysis $this_register, IData<IValue> mapData, IValue key2) {
        if (Intrinsics.areEqual((Object)FactValuesKt.isNull((IValue)key2), (Object)true)) {
            // empty if block
        }
        if (Intrinsics.areEqual((Object)key2.getType(), (Object)$this_register.getHf().getVg().getSTRING_TYPE())) {
            String string = FactValuesKt.getStringValue((IValue)key2, (boolean)false);
            if (string == null) {
                return null;
            }
            String keyStr = string;
            Intrinsics.checkNotNull(mapData, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.check.ArraySpace");
            ArraySpace cfr_ignored_0 = (ArraySpace)mapData;
            return ((ArraySpace)mapData).get((IHeapValuesFactory)$this_register.getHf(), Integer.valueOf(Math.abs(keyStr.hashCode())));
        }
        return null;
    }

    private static final boolean register$lambda$2$lambda$1$lambda$0(CallerSiteCBImpl.EvalCall $this_evalCallAtCaller, IOpCalculator $this$resolve, IHeapValues.Builder builder2, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)builder2, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV self = companionVArray[0];
        AbstractHeapFactory abstractHeapFactory = $this_evalCallAtCaller.getHf();
        HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this_evalCallAtCaller.getEnv();
        AbstractHeapFactory abstractHeapFactory2 = $this_evalCallAtCaller.getHf();
        HeapValuesEnv heapValuesEnv2 = (HeapValuesEnv)$this_evalCallAtCaller.getEnv();
        IntType intType = G.v().soot_IntType();
        Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
        IHeapValues length = abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory2.newSummaryVal(heapValuesEnv2, (Type)intType, (Object)"mapSize")).popHV();
        ArraySpace map = ArraySpace.Companion.v($this_evalCallAtCaller.getHf(), (HeapValuesEnv)$this_evalCallAtCaller.getEnv(), ExtensionsKt.persistentHashMapOf(), $this_evalCallAtCaller.getHf().empty(), $this_evalCallAtCaller.getHf().getVg().getOBJ_ARRAY_TYPE(), length);
        $this_evalCallAtCaller.getOut().setValueData((HeapValuesEnv)$this_evalCallAtCaller.getEnv(), self.getValue(), (Object)OverrideModel.HashMap, (IData)map);
        return true;
    }

    private static final Unit register$lambda$2$lambda$1(CallerSiteCBImpl.EvalCall $this$evalCallAtCaller) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCallAtCaller, (String)"$this$evalCallAtCaller");
        IHeapValues self = $this$evalCallAtCaller.arg(-1);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{self};
        IOpCalculator calculator = $this$evalCallAtCaller.getHf().resolveOp((HeapValuesEnv)$this$evalCallAtCaller.getEnv(), iHeapValuesArray);
        calculator.resolve((arg_0, arg_1, arg_2) -> WHashMap.register$lambda$2$lambda$1$lambda$0($this$evalCallAtCaller, arg_0, arg_1, arg_2));
        return Unit.INSTANCE;
    }

    private static final boolean register$lambda$4$lambda$3(CallerSiteCBImpl.EvalCall $this_evalCallAtCaller, IOpCalculator $this$resolve, IHeapValues.Builder builder2, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)builder2, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV self = companionVArray[0];
        AbstractHeapFactory abstractHeapFactory = $this_evalCallAtCaller.getHf();
        HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this_evalCallAtCaller.getEnv();
        AbstractHeapFactory abstractHeapFactory2 = $this_evalCallAtCaller.getHf();
        HeapValuesEnv heapValuesEnv2 = (HeapValuesEnv)$this_evalCallAtCaller.getEnv();
        IntType intType = G.v().soot_IntType();
        Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
        IHeapValues length = abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory2.newSummaryVal(heapValuesEnv2, (Type)intType, (Object)"mapSize")).popHV();
        ArraySpace map = ArraySpace.Companion.v($this_evalCallAtCaller.getHf(), (HeapValuesEnv)$this_evalCallAtCaller.getEnv(), ExtensionsKt.persistentHashMapOf(), $this_evalCallAtCaller.getHf().empty(), $this_evalCallAtCaller.getHf().getVg().getOBJ_ARRAY_TYPE(), length);
        $this_evalCallAtCaller.getOut().setValueData((HeapValuesEnv)$this_evalCallAtCaller.getEnv(), self.getValue(), (Object)OverrideModel.HashMap, (IData)map);
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
        calculator.resolve((arg_0, arg_1, arg_2) -> WHashMap.register$lambda$4$lambda$3($this$evalCallAtCaller, arg_0, arg_1, arg_2));
        return Unit.INSTANCE;
    }

    private static final boolean register$lambda$6$lambda$5(CallerSiteCBImpl.EvalCall $this_evalCallAtCaller, ACheckCallAnalysis $this_register, IOpCalculator $this$get, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$get, (String)"$this$get");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV map = companionVArray[0];
        CompanionV key2 = companionVArray[1];
        IData iData = $this_evalCallAtCaller.getOut().getValueData(map.getValue(), (Object)OverrideModel.HashMap);
        if (iData == null) {
            return false;
        }
        IData mapData = iData;
        IHeapValues iHeapValues = WHashMap.register$mapGetModel((ACheckCallAnalysis)$this_register, (IData)mapData, (IValue)((IValue)key2.getValue()));
        if (iHeapValues == null) {
            return false;
        }
        res.add(iHeapValues);
        return true;
    }

    private static final Unit register$lambda$6(ACheckCallAnalysis $this_register, CallerSiteCBImpl.EvalCall $this$evalCallAtCaller) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCallAtCaller, (String)"$this$evalCallAtCaller");
        IHeapValues map = $this$evalCallAtCaller.getThis();
        IHeapValues key2 = $this$evalCallAtCaller.arg(0);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{map, key2};
        IOpCalculator calculator = $this$evalCallAtCaller.getHf().resolveOp((HeapValuesEnv)$this$evalCallAtCaller.getEnv(), iHeapValuesArray);
        if (!map.isSingle()) {
            $this$evalCallAtCaller.setEvalAble(false);
            return Unit.INSTANCE;
        }
        calculator.resolve((arg_0, arg_1, arg_2) -> WHashMap.register$lambda$6$lambda$5($this$evalCallAtCaller, $this_register, arg_0, arg_1, arg_2));
        if (!calculator.isFullySimplified() || calculator.getRes().isEmpty()) {
            $this$evalCallAtCaller.setEvalAble(false);
            return Unit.INSTANCE;
        }
        $this$evalCallAtCaller.setReturn(calculator.getRes().build());
        return Unit.INSTANCE;
    }

    private static final boolean register$lambda$8$lambda$7(CallerSiteCBImpl.EvalCall $this_evalCallAtCaller, ACheckCallAnalysis $this_register, IOpCalculator $this$get, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$get, (String)"$this$get");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV map = companionVArray[0];
        CompanionV key2 = companionVArray[1];
        CompanionV defaultValue = companionVArray[2];
        IData iData = $this_evalCallAtCaller.getOut().getValueData(map.getValue(), (Object)OverrideModel.HashMap);
        if (iData == null) {
            return false;
        }
        IData mapData = iData;
        IHeapValues iHeapValues = WHashMap.register$mapGetModel((ACheckCallAnalysis)$this_register, (IData)mapData, (IValue)((IValue)key2.getValue()));
        if (iHeapValues == null) {
            iHeapValues = $this_evalCallAtCaller.getHf().single(defaultValue);
        }
        res.add(iHeapValues);
        return true;
    }

    private static final Unit register$lambda$8(ACheckCallAnalysis $this_register, CallerSiteCBImpl.EvalCall $this$evalCallAtCaller) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCallAtCaller, (String)"$this$evalCallAtCaller");
        IHeapValues map = $this$evalCallAtCaller.getThis();
        if (!map.isSingle()) {
            $this$evalCallAtCaller.setEvalAble(false);
            return Unit.INSTANCE;
        }
        IHeapValues key2 = $this$evalCallAtCaller.arg(0);
        IHeapValues defaultValue = $this$evalCallAtCaller.arg(1);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{map, key2, defaultValue};
        IOpCalculator calculator = $this$evalCallAtCaller.getHf().resolveOp((HeapValuesEnv)$this$evalCallAtCaller.getEnv(), iHeapValuesArray);
        calculator.resolve((arg_0, arg_1, arg_2) -> WHashMap.register$lambda$8$lambda$7($this$evalCallAtCaller, $this_register, arg_0, arg_1, arg_2));
        if (!calculator.isFullySimplified() || calculator.getRes().isEmpty()) {
            $this$evalCallAtCaller.setEvalAble(false);
            return Unit.INSTANCE;
        }
        $this$evalCallAtCaller.setReturn(calculator.getRes().build());
        return Unit.INSTANCE;
    }

    private static final boolean register$lambda$10$lambda$9(CalleeCBImpl.EvalCall $this_evalCall, IHeapValues $value, IOpCalculator $this$put, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$put, (String)"$this$put");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV map = companionVArray[0];
        CompanionV key2 = companionVArray[1];
        IData iData = $this_evalCall.getOut().getValueData(map.getValue(), (Object)OverrideModel.HashMap);
        if (iData == null) {
            return false;
        }
        IData mapData = iData;
        ArraySpace cfr_ignored_0 = (ArraySpace)mapData;
        ArraySpaceBuilder builder2 = ((ArraySpace)mapData).builder();
        if (Intrinsics.areEqual((Object)((IValue)key2.getValue()).getType(), (Object)$this_evalCall.getHf().getVg().getSTRING_TYPE())) {
            String keyStr = FactValuesKt.getStringValue((IValue)((IValue)key2.getValue()), (boolean)false);
            if (keyStr == null) {
                builder2.set((IHeapValuesFactory)$this_evalCall.getHf(), (HeapValuesEnv)$this_evalCall.getEnv(), null, $value, true);
            } else {
                builder2.set((IHeapValuesFactory)$this_evalCall.getHf(), (HeapValuesEnv)$this_evalCall.getEnv(), Integer.valueOf(Math.abs(keyStr.hashCode())), $value, true);
            }
            $this_evalCall.getOut().setValueData((HeapValuesEnv)$this_evalCall.getEnv(), map.getValue(), (Object)OverrideModel.HashMap, builder2.build());
            res.add(((ArraySpace)mapData).getElement($this_evalCall.getHf()));
            return true;
        }
        builder2.set((IHeapValuesFactory)$this_evalCall.getHf(), (HeapValuesEnv)$this_evalCall.getEnv(), null, $value, true);
        return true;
    }

    private static final Unit register$lambda$10(CalleeCBImpl.EvalCall $this$evalCall) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCall, (String)"$this$evalCall");
        IHeapValues map = $this$evalCall.getThis();
        if (!map.isSingle()) {
            $this$evalCall.setEvalAble(false);
            return Unit.INSTANCE;
        }
        IHeapValues key2 = $this$evalCall.arg(0);
        IHeapValues value = $this$evalCall.arg(1);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{map, key2};
        IOpCalculator calculator = $this$evalCall.getHf().resolveOp((HeapValuesEnv)$this$evalCall.getEnv(), iHeapValuesArray);
        calculator.resolve((arg_0, arg_1, arg_2) -> WHashMap.register$lambda$10$lambda$9($this$evalCall, value, arg_0, arg_1, arg_2));
        if (!calculator.isFullySimplified()) {
            $this$evalCall.setEvalAble(false);
            return Unit.INSTANCE;
        }
        $this$evalCall.setReturn(calculator.getRes().build());
        return Unit.INSTANCE;
    }
}

