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
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import soot.SootField;

public final class HeapFactoryKt {

    @NotNull
    public static <T> Flow<T> flowIt(@NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> c) {
        return FlowKt.flow(c);
    }

    @NotNull
    public static IHeapValues<IValue> getValueField(
            @NotNull ICallCBImpl<IHeapValues<IValue>, IFact.Builder<IValue>> receiver,
            @NotNull IHeapValues<IValue> obj,
            @NotNull SootField valueField) {
        
        receiver.getOut().assignNewExpr(receiver.getEnv(), "@obj", obj, false);
        
        FieldUtil fieldUtil = FieldUtil.INSTANCE;
        receiver.getOut().getField(receiver.getEnv(), "@obj.value", "@obj", new JSootFieldType(valueField), true);
        
        IHeapValues<IValue> result = receiver.getOut().getTargetsUnsafe("@obj.value");
        receiver.getOut().kill("@obj");
        receiver.getOut().kill("@obj.value");
        
        return result != null ? result : receiver.getHf().empty();
    }

    @NotNull
    public static IHeapValues<IValue> getConstantValue(
            @NotNull ICallCBImpl<IHeapValues<IValue>, IFact.Builder<IValue>> receiver,
            @NotNull IHeapValues<IValue> obj,
            @NotNull SootField valueField) {
        
        IHeapValues.Builder<IValue> res = receiver.getHf().emptyBuilder();
        IHeapValues<IValue> fieldValues = getValueField(receiver, obj, valueField);
        
        res.add(fieldValues);
        
        for (CompanionV o : obj) {
            if (o.getValue() instanceof ConstVal) {
                res.add(o);
            }
        }
        
        return res.build();
    }
}