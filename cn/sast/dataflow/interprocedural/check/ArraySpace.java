package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapKV;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;

public class ArraySpace extends ArrayHeapKV<IValue> {
    public static final Companion Companion = new Companion();

    public ArraySpace(@NotNull PersistentMap<Integer, ? extends IHeapValues<IValue>> element,
                      @Nullable IHeapValues<IValue> unreferenced,
                      @NotNull ArrayType type,
                      @NotNull IHeapValues<IValue> allSize,
                      @Nullable Integer size,
                      @Nullable CompanionV<IValue> initializedValue) {
        super(element, unreferenced, allSize, type, size, initializedValue);
    }

    @NotNull
    public ArraySpaceBuilder builder() {
        IHeapValues<IValue> unreferenced = this.getUnreferenced();
        return new ArraySpaceBuilder(this, 
            this.getMap().builder(), 
            unreferenced != null ? unreferenced.builder() : null);
    }

    @NotNull
    public IHeapValues<IValue> getElement(@NotNull AbstractHeapFactory<IValue> hf) {
        IHeapValues.Builder<IValue> b = hf.emptyBuilder();
        IHeapValues<IValue> unreferenced = this.getUnreferenced();
        
        if (unreferenced != null) {
            b.add(unreferenced);
        }
        
        for (IHeapValues<IValue> element : this.getMap().values()) {
            b.add(element);
        }
        
        return b.build();
    }

    @NotNull
    public IData<IValue> cloneAndReNewObjects(@NotNull IReNew<IValue> re) {
        ArraySpaceBuilder b = this.builder();
        b.cloneAndReNewObjects(re);
        return b.build();
    }

    @Nullable
    public IValue[] getArray(@NotNull IHeapValuesFactory<IValue> hf) {
        Integer size = this.getSize();
        if (size == null) {
            return null;
        }
        
        IValue[] result = new IValue[size];
        for (int i = 0; i < size; i++) {
            IHeapValues<IValue> exist = this.get(hf, i);
            if (exist == null || !exist.isSingle()) {
                return null;
            }
            result[i] = exist.getSingle().getValue();
        }
        return result;
    }

    @Nullable
    public byte[] getByteArray(@NotNull IHeapValuesFactory<IValue> hf) {
        IValue[] values = getArray(hf);
        if (values == null) {
            return null;
        }
        
        byte[] result = new byte[values.length];
        for (int i = 0; i < values.length; i++) {
            ConstVal constVal = values[i] instanceof ConstVal ? (ConstVal) values[i] : null;
            Byte byteValue = constVal != null ? FactValuesKt.getByteValue(constVal, true) : null;
            if (byteValue == null) {
                return null;
            }
            result[i] = byteValue;
        }
        return result;
    }

    public static final class Companion {
        private Companion() {}
    }
}