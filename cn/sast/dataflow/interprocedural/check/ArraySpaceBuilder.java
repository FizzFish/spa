package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapBuilder;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArraySpaceBuilder extends ArrayHeapBuilder<IValue> {
    @NotNull
    private final ArraySpace orig;

    public ArraySpaceBuilder(@NotNull ArraySpace orig, 
                            @NotNull PersistentMap.Builder<Integer, IHeapValues<IValue>> element, 
                            @Nullable IHeapValues.Builder<IValue> unreferenced) {
        super(element, unreferenced, orig.getType(), orig.getAllSize().builder(), orig.getSize(), orig.getInitializedValue());
        this.orig = orig;
    }

    @NotNull
    public ArraySpace getOrig() {
        return orig;
    }

    @Override
    @NotNull
    public IData<IValue> build() {
        PersistentMap<Integer, IHeapValues<IValue>> newMap = getMap().build();
        IHeapValues.Builder<IValue> builder = getUnreferenced();
        IHeapValues<IValue> newUn = builder != null ? builder.build() : null;
        IHeapValues<IValue> newAllSize = getAllSize().build();

        if (newMap.equals(orig.getMap()) 
            && newUn == orig.getUnreferenced() 
            && newAllSize.equals(orig.getAllSize()) 
            && getInitializedValue() == orig.getInitializedValue()) {
            return orig;
        }
        return new ArraySpace(newMap, newUn, getType(), newAllSize, getSize(), getInitializedValue());
    }
}