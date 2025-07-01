package cn.sast.dataflow.interprocedural.check.checker;

import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.dataflow.interprocedural.check.BuiltInModelT;
import cn.sast.dataflow.interprocedural.check.heapimpl.*;
import cn.sast.idfa.check.ICallCB;
import com.feysh.corax.config.api.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;
import soot.Scene;
import soot.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class FactModeling {
    private final AbstractHeapFactory<IValue> hf;
    private final HeapValuesEnv env;
    private final ICallCB<IHeapValues<IValue>, IFact.Builder<IValue>> summaryCtxCalleeSite;
    private final IFact.Builder<IValue> builder;

    public FactModeling(
            @NotNull AbstractHeapFactory<IValue> hf,
            @NotNull HeapValuesEnv env,
            @NotNull ICallCB<IHeapValues<IValue>, IFact.Builder<IValue>> summaryCtxCalleeSite,
            @NotNull IFact.Builder<IValue> builder) {
        this.hf = hf;
        this.env = env;
        this.summaryCtxCalleeSite = summaryCtxCalleeSite;
        this.builder = builder;
    }

    @NotNull
    public AbstractHeapFactory<IValue> getHf() {
        return hf;
    }

    @NotNull
    public HeapValuesEnv getEnv() {
        return env;
    }

    @NotNull
    public ICallCB<IHeapValues<IValue>, IFact.Builder<IValue>> getSummaryCtxCalleeSite() {
        return summaryCtxCalleeSite;
    }

    @NotNull
    public IFact.Builder<IValue> getBuilder() {
        return builder;
    }

    @NotNull
    public IHeapValues<IValue> toHV(@NotNull List<?> values) {
        IHeapValues.Builder b = hf.emptyBuilder();
        for (Object obj : values) {
            if (obj instanceof CompanionV cv && cv.getValue() instanceof IValue) {
                b.add(cv);
            }
        }
        return b.build();
    }

    public boolean isArray(@NotNull Object obj) {
        return obj instanceof CompanionV cv 
                && cv.getValue() instanceof IValue 
                && ((IValue) cv.getValue()).getType() instanceof ArrayType;
    }

    public void store(@NotNull List<?> values, @NotNull MLocal dest, boolean append) {
        PointsToGraphBuilderAbstract out = (PointsToGraphBuilderAbstract) builder;
        IHeapValues value = toHV(values);

        if (dest.equals(MReturn.INSTANCE)) {
            if (append) {
                ICallCB<IHeapValues<IValue>, IFact.Builder<IValue>> cb = summaryCtxCalleeSite;
                cb.setReturn(cb.getReturn().plus(value));
            } else {
                summaryCtxCalleeSite.setReturn(value);
            }
        } else if (dest instanceof MParameter param) {
            Object destValue = summaryCtxCalleeSite.argToValue(param.getIndex());
            out.assignNewExpr(env, destValue, value, append);
        } else if (!dest.equals(MGlobal.INSTANCE)) {
            throw new IllegalStateException("Unexpected MLocal type");
        }
    }

    public void setField(
            @Nullable IExpr baseExpr,
            @NotNull List<?> bases,
            @NotNull List<?> values,
            @NotNull IClassField field,
            boolean append) {
        if (field instanceof BuiltInField builtInField) {
            if (builtInField.equals(TaintProperty.INSTANCE) || builtInField.equals(ViaProperty.INSTANCE)) {
                propertyPropagate(baseExpr, bases, values, field, append);
                return;
            } else if (builtInField.equals(MapKeys.INSTANCE) 
                    || builtInField.equals(MapValues.INSTANCE)
                    || builtInField.equals(Elements.INSTANCE)) {
                handleBuiltInField(bases, values, builtInField);
                return;
            }
            throw new IllegalStateException("Unsupported BuiltInField");
        } else if (field instanceof ClassField classField) {
            handleClassField(bases, values, classField);
        } else if (field instanceof AttributeName attributeName) {
            handleAttributeField(bases, values, attributeName);
        }
    }

    private void handleBuiltInField(List<?> bases, List<?> values, BuiltInField field) {
        BuiltInModelT mt;
        if (field instanceof Elements) {
            List<Object> arrayObjects = filterArrays(bases, true);
            List<Object> nonArrayObjects = filterArrays(bases, false);
            
            if (!arrayObjects.isEmpty()) {
                builder.assignNewExpr(env, "@arr", toHV(arrayObjects), false);
                builder.setArrayValueNew(env, "@arr", null, toHV(values));
                builder.kill("@arr");
            }
            mt = BuiltInModelT.Element;
        } else if (field instanceof MapKeys) {
            mt = BuiltInModelT.MapKeys;
        } else {
            mt = BuiltInModelT.MapValues;
        }

        IHeapValues base = toHV(bases);
        boolean append = !base.isSingle();
        hf.resolveOp(env, new IHeapValues[]{base})
                .resolve((op, ret, comps) -> handleBuiltInResolve(append, this, mt, values, op, ret, comps));
    }

    private List<Object> filterArrays(List<?> bases, boolean wantArrays) {
        List<Object> result = new ArrayList<>();
        for (Object base : bases) {
            if (isArray(base) == wantArrays) {
                result.add(base);
            }
        }
        return result;
    }

    private void handleClassField(List<?> bases, List<?> values, ClassField field) {
        IHeapValues base = toHV(bases);
        IHeapValues value = toHV(values);
        
        Type type = field.getFieldType() != null 
                ? Scene.v().getTypeUnsafe(field.getFieldType(), true)
                : Scene.v().getObjectType();
                
        JFieldNameType sootField = new JFieldNameType(field.getFieldName(), type);
        builder.assignNewExpr(env, "@base", base, false);
        builder.setFieldNew(env, "@base", sootField, value);
        builder.kill("@base");
    }

    private void handleAttributeField(List<?> bases, List<?> values, AttributeName field) {
        Object key = CheckerModelingKt.getKeyAttribute();
        IHeapValues value = toHV(values);
        IHeapValues baseHeapValues = toHV(bases);
        boolean append = !baseHeapValues.isSingle();

        for (CompanionV<IValue> base : toHV(bases)) {
            IData data = builder.getValueData(base.getValue(), key);
            ImmutableElementHashMap map = data instanceof ImmutableElementHashMap 
                    ? (ImmutableElementHashMap) data 
                    : new ImmutableElementHashMap(null, null, 3, null);
                    
            ImmutableElementHashMapBuilder b = map.builder();
            b.set(hf, env, field.getName(), value, append);
            
            if (!(base.getValue() instanceof ConstVal)) {
                builder.setValueData(env, base.getValue(), key, b.build());
            }
        }
    }

    public void setConstValue(@NotNull IExpr rvalue, @NotNull CompanionV<IValue> newBase) {
        if (rvalue instanceof IIexGetField getField) {
            if (getField.getAccessPath().isEmpty()) return;
            List<IClassField> acp = getField.getAccessPath().subList(0, getField.getAccessPath().size() - 1);
            IExpr baseExpr = new IIexLoad(getField.getBase());
            List<Object> bases = hf.resolve(env, summaryCtxCalleeSite, baseExpr);
            setField(null, bases, List.of(newBase), getField.getAccessPath().get(getField.getAccessPath().size() - 1), true);
        } else if (rvalue instanceof IIexLoad load) {
            store(List.of(newBase), load.getOp(), true);
        }
    }

    public void propertyPropagate(
            @Nullable IExpr baseExpr,
            @NotNull List<?> bases,
            @NotNull List<?> values,
            @NotNull IClassField field,
            boolean append) {
        IHeapValues base = toHV(bases);
        boolean append1 = !base.isSingle() || append;
        hf.resolveOp(env, new IHeapValues[]{base})
                .resolve((op, ret, comps) -> handlePropertyResolve(append1, this, field, values, op, ret, comps));
    }

    @NotNull
    public IModelStmtVisitor<Object> getVisitor() {
        return new IModelStmtVisitor<Object>() {
            // Visitor implementation
        };
    }

    private static boolean handleBuiltInResolve(
            boolean append,
            FactModeling factModeling,
            BuiltInModelT mt,
            List<?> values,
            IOpCalculator op,
            IHeapValues.Builder ret,
            CompanionV<IValue>[] comps) {
        CompanionV<IValue> base = comps[0];
        if (append) {
            IData data = factModeling.builder.getValueData(base.getValue(), mt);
            ObjectValues collection = data instanceof ObjectValues 
                    ? (ObjectValues) data 
                    : new ObjectValues(factModeling.hf.empty());
                    
            ObjectValuesBuilder b = collection.builder();
            b.addAll(factModeling.toHV(values));
            factModeling.builder.setValueData(factModeling.env, base.getValue(), mt, b.build());
        } else {
            factModeling.builder.setValueData(factModeling.env, base.getValue(), mt, new ObjectValues(factModeling.toHV(values)));
        }
        return true;
    }

    private static boolean handlePropertyResolve(
            boolean append1,
            FactModeling factModeling,
            IClassField field,
            List<?> values,
            IOpCalculator op,
            IHeapValues.Builder builder,
            CompanionV<IValue>[] comps) {
        CompanionV<IValue> base = comps[0];
        IData data = append1 ? factModeling.builder.getValueData(base.getValue(), field) : null;
        ImmutableElementSet setData = data instanceof ImmutableElementSet ? (ImmutableElementSet) data : null;

        if (setData == null || setData.isEmpty()) {
            if (values.size() == 1 && values.get(0) instanceof ImmutableElementSet) {
                setData = (ImmutableElementSet) values.get(0);
            } else {
                setData = null;
            }
        }

        if (setData == null) {
            ImmutableElementSetBuilder setBuilder = new ImmutableElementSet(null, null, 3, null).builder();
            for (Object typeValues : values) {
                if (typeValues instanceof ImmutableElementSet set) {
                    for (Object e : set.getElement()) {
                        setBuilder.set(factModeling.hf, factModeling.env, e, set.get(factModeling.hf, e), append1);
                    }
                }
            }
            setData = setBuilder.build();
        }

        if (!(base.getValue() instanceof ConstVal)) {
            factModeling.builder.setValueData(factModeling.env, base.getValue(), CheckerModelingKt.getKeyTaintProperty(), setData);
        }
        return true;
    }
}
