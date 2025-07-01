package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.ICalculator;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import org.jetbrains.annotations.NotNull;
import soot.RefType;
import soot.Type;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class CalculatorBase implements ICalculator<IValue> {
    @NotNull
    private final HeapValuesEnv env;
    @NotNull
    private final AbstractHeapFactory<IValue> cf;
    private int count;
    private final int calculateLimit = 24;
    @NotNull
    private final Set<Object> unHandle = new LinkedHashSet<>();
    @NotNull
    private IHeapValues.Builder<IValue> res;

    public CalculatorBase(@NotNull HeapValuesEnv env, @NotNull AbstractHeapFactory<IValue> cf) {
        if (env == null) throw new IllegalArgumentException("env cannot be null");
        if (cf == null) throw new IllegalArgumentException("cf cannot be null");
        this.env = env;
        this.cf = cf;
        this.res = cf.empty().builder();
    }

    @NotNull
    public final HeapValuesEnv getEnv() {
        return env;
    }

    @NotNull
    public final AbstractHeapFactory<IValue> getCf() {
        return cf;
    }

    public final int getCount() {
        return count;
    }

    public final void setCount(int count) {
        this.count = count;
    }

    public final int getCalculateLimit() {
        return calculateLimit;
    }

    @NotNull
    public final Set<Object> getUnHandle() {
        return unHandle;
    }

    @Override
    @NotNull
    public IHeapValues.Builder<IValue> getRes() {
        return res;
    }

    @Override
    public void setRes(@NotNull IHeapValues.Builder<IValue> builder) {
        if (builder == null) throw new IllegalArgumentException("builder cannot be null");
        this.res = builder;
    }

    @Override
    public void putSummaryIfNotConcrete(@NotNull Type type, @NotNull Object special) {
        if (type == null) throw new IllegalArgumentException("type cannot be null");
        if (special == null) throw new IllegalArgumentException("special cannot be null");
        if (!isFullySimplified()) {
            putSummaryValue(type, special);
        }
    }

    @Override
    public void putSummaryValue(@NotNull Type type, @NotNull Object special) {
        if (type == null) throw new IllegalArgumentException("type cannot be null");
        if (special == null) throw new IllegalArgumentException("special cannot be null");
        
        if (type instanceof RefType) {
            getRes().add(cf.push(env, cf.getNullConst()).markOfCantCalcAbstractResultValue().pop());
        }
        IValue summary = cf.push(env, cf.newSummaryVal(env, type, special))
                          .markOfCantCalcAbstractResultValue()
                          .pop();
        getRes().add(summary);
    }

    @Override
    public boolean isFullySimplified() {
        return count < calculateLimit && unHandle.isEmpty();
    }
}