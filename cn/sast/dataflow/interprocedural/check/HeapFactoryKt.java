/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.ConstVal
 *  cn.sast.dataflow.interprocedural.analysis.FieldUtil
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.analysis.JSootFieldType
 *  cn.sast.dataflow.interprocedural.check.HeapFactoryKt
 *  cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowCollector
 *  kotlinx.coroutines.flow.FlowKt
 *  org.jetbrains.annotations.NotNull
 *  soot.SootField
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.FieldUtil;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.JSootFieldType;
import cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import soot.SootField;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aX\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r29\b\u0004\u0010\u000e\u001a3\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\r0\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000fH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016\u001aF\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00070\u0018*\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001a0\u00192\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00070\u00182\u0006\u0010\u001c\u001a\u00020\u001d\u001aF\u0010\u001e\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00070\u0018*\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001a0\u00192\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00070\u00182\u0006\u0010\u001c\u001a\u00020\u001d*\f\b\u0002\u0010\u0000\"\u00020\u00012\u00020\u0001*\u0018\b\u0002\u0010\u0002\"\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00020\u00040\u0003*\u001c\b\u0002\u0010\u0005\"\b\u0012\u0004\u0012\u0002`\u00070\u00062\f\u0012\b\u0012\u00060\u0001j\u0002`\u00070\u0006*\u0014\b\u0002\u0010\b\"\u0006\u0012\u0002\b\u00030\t2\u0006\u0012\u0002\b\u00030\t*\u0018\b\u0002\u0010\n\"\b\u0012\u0004\u0012\u00020\u00040\t2\b\u0012\u0004\u0012\u00020\u00040\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001f"}, d2={"V", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "ExprResType", "Lkotlin/sequences/Sequence;", "", "ValueType", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "Lcn/sast/dataflow/interprocedural/check/V;", "SetType", "Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementSet;", "SetTypeAny", "flowIt", "Lkotlinx/coroutines/flow/Flow;", "T", "c", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/ParameterName;", "name", "flow", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "getValueField", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "Lcn/sast/dataflow/interprocedural/check/callback/ICallCBImpl;", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "obj", "valueField", "Lsoot/SootField;", "getConstantValue", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nHeapFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeapFactory.kt\ncn/sast/dataflow/interprocedural/check/HeapFactoryKt\n+ 2 IFact.kt\ncn/sast/dataflow/interprocedural/analysis/FieldUtil\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1430:1\n44#2:1431\n1#3:1432\n*S KotlinDebug\n*F\n+ 1 HeapFactory.kt\ncn/sast/dataflow/interprocedural/check/HeapFactoryKt\n*L\n44#1:1431\n*E\n"})
public final class HeapFactoryKt {
    @NotNull
    public static final <T> Flow<T> flowIt(@NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> c) {
        Intrinsics.checkNotNullParameter(c, (String)"c");
        boolean $i$f$flowIt = false;
        return FlowKt.flow((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
    }

    @NotNull
    public static final IHeapValues<IValue> getValueField(@NotNull ICallCBImpl<IHeapValues<IValue>, IFact.Builder<IValue>> $this$getValueField, @NotNull IHeapValues<IValue> obj, @NotNull SootField valueField) {
        Intrinsics.checkNotNullParameter($this$getValueField, (String)"<this>");
        Intrinsics.checkNotNullParameter(obj, (String)"obj");
        Intrinsics.checkNotNullParameter((Object)valueField, (String)"valueField");
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)((IFact.Builder)$this$getValueField.getOut()), (HeapValuesEnv)((HeapValuesEnv)$this$getValueField.getEnv()), (Object)"@obj", obj, (boolean)false, (int)8, null);
        FieldUtil this_$iv = FieldUtil.INSTANCE;
        boolean $i$f$of = false;
        ((IFact.Builder)$this$getValueField.getOut()).getField((HeapValuesEnv)$this$getValueField.getEnv(), (Object)"@obj.value", (Object)"@obj", (JFieldType)new JSootFieldType(valueField), true);
        IHeapValues r = ((IFact.Builder)$this$getValueField.getOut()).getTargetsUnsafe((Object)"@obj.value");
        ((IFact.Builder)$this$getValueField.getOut()).kill((Object)"@obj");
        ((IFact.Builder)$this$getValueField.getOut()).kill((Object)"@obj.value");
        IHeapValues iHeapValues = r;
        if (iHeapValues == null) {
            iHeapValues = $this$getValueField.getHf().empty();
        }
        return iHeapValues;
    }

    @NotNull
    public static final IHeapValues<IValue> getConstantValue(@NotNull ICallCBImpl<IHeapValues<IValue>, IFact.Builder<IValue>> $this$getConstantValue, @NotNull IHeapValues<IValue> obj, @NotNull SootField valueField) {
        Intrinsics.checkNotNullParameter($this$getConstantValue, (String)"<this>");
        Intrinsics.checkNotNullParameter(obj, (String)"obj");
        Intrinsics.checkNotNullParameter((Object)valueField, (String)"valueField");
        IHeapValues.Builder res = $this$getConstantValue.getHf().emptyBuilder();
        IHeapValues iHeapValues = HeapFactoryKt.getValueField($this$getConstantValue, obj, (SootField)valueField);
        IHeapValues it = iHeapValues;
        boolean bl = false;
        res.add(it);
        for (CompanionV o : obj) {
            if (!(o.getValue() instanceof ConstVal)) continue;
            res.add(o);
        }
        return res.build();
    }
}

