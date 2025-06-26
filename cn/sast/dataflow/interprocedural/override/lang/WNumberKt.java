/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.FieldUtil
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.analysis.JSootFieldType
 *  cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl
 *  cn.sast.dataflow.interprocedural.override.lang.WNumberKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  soot.G
 *  soot.RefType
 *  soot.SootField
 *  soot.Type
 */
package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.FieldUtil;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.JSootFieldType;
import cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import soot.G;
import soot.RefType;
import soot.SootField;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aB\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00032\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u00042\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\n"}, d2={"getValueFromObject", "Lcn/sast/dataflow/interprocedural/analysis/IOpCalculator;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/check/callback/ICallCBImpl;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "obj", "Lcn/sast/dataflow/interprocedural/analysis/V;", "type", "Lsoot/Type;", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nWNumber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WNumber.kt\ncn/sast/dataflow/interprocedural/override/lang/WNumberKt\n+ 2 IFact.kt\ncn/sast/dataflow/interprocedural/analysis/FieldUtil\n*L\n1#1,263:1\n44#2:264\n*S KotlinDebug\n*F\n+ 1 WNumber.kt\ncn/sast/dataflow/interprocedural/override/lang/WNumberKt\n*L\n35#1:264\n*E\n"})
public final class WNumberKt {
    @NotNull
    public static final IOpCalculator<IValue> getValueFromObject(@NotNull ICallCBImpl<IHeapValues<IValue>, IFact.Builder<IValue>> $this$getValueFromObject, @NotNull IHeapValues<IValue> obj, @NotNull Type type) {
        Intrinsics.checkNotNullParameter($this$getValueFromObject, (String)"<this>");
        Intrinsics.checkNotNullParameter(obj, (String)"obj");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{obj};
        IOpCalculator c = $this$getValueFromObject.getHf().resolveOp((HeapValuesEnv)$this$getValueFromObject.getEnv(), iHeapValuesArray);
        c.resolve((arg_0, arg_1, arg_2) -> WNumberKt.getValueFromObject$lambda$0(type, $this$getValueFromObject, arg_0, arg_1, arg_2));
        return c;
    }

    private static final boolean getValueFromObject$lambda$0(Type $type, ICallCBImpl $this_getValueFromObject, IOpCalculator $this$getValue, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Number number;
        Intrinsics.checkNotNullParameter((Object)$this$getValue, (String)"$this$getValue");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV numObj = companionVArray[0];
        Type type = $type;
        if (Intrinsics.areEqual((Object)type, (Object)G.v().soot_ByteType())) {
            number = FactValuesKt.getIntValue((IValue)((IValue)numObj.getValue()), (boolean)false);
        } else if (Intrinsics.areEqual((Object)type, (Object)G.v().soot_CharType())) {
            number = FactValuesKt.getIntValue((IValue)((IValue)numObj.getValue()), (boolean)false);
        } else if (Intrinsics.areEqual((Object)type, (Object)G.v().soot_BooleanType())) {
            number = FactValuesKt.getIntValue((IValue)((IValue)numObj.getValue()), (boolean)false);
        } else if (Intrinsics.areEqual((Object)type, (Object)G.v().soot_ShortType())) {
            number = FactValuesKt.getIntValue((IValue)((IValue)numObj.getValue()), (boolean)false);
        } else if (Intrinsics.areEqual((Object)type, (Object)G.v().soot_IntType())) {
            number = FactValuesKt.getIntValue((IValue)((IValue)numObj.getValue()), (boolean)false);
        } else if (Intrinsics.areEqual((Object)type, (Object)G.v().soot_LongType())) {
            number = FactValuesKt.getLongValue((IValue)((IValue)numObj.getValue()), (boolean)false);
        } else if (Intrinsics.areEqual((Object)type, (Object)G.v().soot_FloatType())) {
            number = FactValuesKt.getFloatValue((IValue)((IValue)numObj.getValue()), (boolean)false);
        } else if (Intrinsics.areEqual((Object)type, (Object)G.v().soot_DoubleType())) {
            number = FactValuesKt.getDoubleValue((IValue)((IValue)numObj.getValue()), (boolean)false);
        } else {
            return false;
        }
        Integer num = number;
        if (num != null) {
            res.add(numObj);
            return true;
        }
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)((IFact.Builder)$this_getValueFromObject.getOut()), (HeapValuesEnv)((HeapValuesEnv)$this_getValueFromObject.getEnv()), (Object)"@num", (IHeapValues)$this_getValueFromObject.getHf().empty().plus(numObj), (boolean)false, (int)8, null);
        Type type2 = ((IValue)numObj.getValue()).getType();
        RefType refType = type2 instanceof RefType ? (RefType)type2 : null;
        if (refType == null) {
            return false;
        }
        RefType boxedPrimRefType = refType;
        SootField sootField = boxedPrimRefType.getSootClass().getFieldByNameUnsafe("value");
        if (sootField == null) {
            return false;
        }
        SootField field = sootField;
        FieldUtil this_$iv = FieldUtil.INSTANCE;
        boolean $i$f$of = false;
        IFact.Builder.DefaultImpls.getField$default((IFact.Builder)((IFact.Builder)$this_getValueFromObject.getOut()), (HeapValuesEnv)((HeapValuesEnv)$this_getValueFromObject.getEnv()), (Object)"@value", (Object)"@num", (JFieldType)((JFieldType)new JSootFieldType(field)), (boolean)false, (int)16, null);
        IHeapValues value = ((IFact.Builder)$this_getValueFromObject.getOut()).getTargets((Object)"@value");
        ((IFact.Builder)$this_getValueFromObject.getOut()).kill((Object)"@value");
        ((IFact.Builder)$this_getValueFromObject.getOut()).kill((Object)"@num");
        res.add(value);
        return true;
    }
}

