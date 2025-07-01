package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public final class OpCalculator extends CalculatorBase implements IOpCalculator<IValue> {
    private final IHeapValues<IValue>[] ops;

    public OpCalculator(@NotNull HeapValuesEnv env, 
                        @NotNull AbstractHeapFactory<IValue> cf, 
                        IHeapValues<IValue>... ops) {
        super(env, cf);
        this.ops = ops;
    }

    @NotNull
    public IHeapValues<IValue>[] getOps() {
        return ops;
    }

    @NotNull
    public IOpCalculator<IValue> resolve(@NotNull OperationResolver<IValue> fx) {
        int size = ops.length;
        Integer[] sizes = new Integer[size];
        
        // Collect sizes of all heaps
        for (int i = 0; i < size; i++) {
            IHeapValues<IValue> heap = ops[i];
            if (heap == null) {
                return this;
            }
            sizes[i] = heap.getSize();
        }

        CompanionV<IValue>[][] valueArrays = new CompanionV[size][];
        Iterator<IValue>[] iterators = new Iterator[size];
        
        // Initialize value arrays and iterators
        for (int i = 0; i < size; i++) {
            valueArrays[i] = new CompanionV[sizes[i]];
            iterators[i] = ops[i].iterator();
        }

        Integer[] counters = new Integer[size];
        CompanionV<IValue>[] currentValues = new CompanionV[size];
        
        // Initialize counters and first values
        for (int i = 0; i < size; i++) {
            counters[i] = 0;
            currentValues[i] = valueArrays[i][0] = iterators[i].next();
        }

        while (getCount() < getCalculateLimit()) {
            boolean ok = fx.apply(this, getRes(), currentValues);
            incrementCount();
            
            if (!ok) {
                getUnHandle().add(currentValues);
            }

            // Find next combination
            int i = 0;
            while (i < size) {
                if (counters[i] != sizes[i] - 1) {
                    counters[i]++;
                    int x = counters[i];
                    if (valueArrays[i][x] == null) {
                        valueArrays[i][x] = iterators[i].next();
                    }
                    currentValues[i] = valueArrays[i][x];
                    break;
                }
                counters[i] = 0;
                currentValues[i] = valueArrays[i][0];
                i++;
            }
            
            if (i == size) {
                break;
            }
        }
        
        return this;
    }

    @FunctionalInterface
    public interface OperationResolver<V extends IValue> {
        boolean apply(IOpCalculator<V> calculator, 
                     IHeapValues.Builder<V> builder, 
                     CompanionV<V>[] values);
    }
}