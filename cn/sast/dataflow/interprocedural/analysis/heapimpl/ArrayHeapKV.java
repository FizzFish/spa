package cn.sast.dataflow.interprocedural.analysis.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IDiffAble;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;

import java.util.Map;

public abstract class ArrayHeapKV<V> extends HeapKVData<Integer, V> implements IArrayHeapKV<Integer, V> {
    @NotNull
    private final IHeapValues<V> allSize;
    @NotNull
    private final ArrayType type;
    @Nullable
    private final Integer size;
    @Nullable
    private final CompanionV<V> initializedValue;

    public ArrayHeapKV(@NotNull Map<Integer, ? extends IHeapValues<V>> element, 
                      @Nullable IHeapValues<V> unreferenced, 
                      @NotNull IHeapValues<V> allSize, 
                      @NotNull ArrayType type, 
                      @Nullable Integer size, 
                      @Nullable CompanionV<V> initializedValue) {
        super(element, unreferenced);
        if (element == null) throw new IllegalArgumentException("element cannot be null");
        if (allSize == null) throw new IllegalArgumentException("allSize cannot be null");
        if (type == null) throw new IllegalArgumentException("type cannot be null");
        
        this.allSize = allSize;
        this.type = type;
        this.size = size;
        this.initializedValue = initializedValue;

        if (!this.allSize.isNotEmpty()) {
            throw new IllegalArgumentException("array length value set is empty");
        }
    }

    @NotNull
    public final IHeapValues<V> getAllSize() {
        return allSize;
    }

    @NotNull
    public ArrayType getType() {
        return type;
    }

    @Nullable
    public final Integer getSize() {
        return size;
    }

    @Nullable
    public final CompanionV<V> getInitializedValue() {
        return initializedValue;
    }

    @NotNull
    public String getName() {
        return type.getElementType() + "[" + size + "]";
    }

    @Nullable
    public Boolean isValidKey(@Nullable Integer key) {
        if (key == null) return false;
        return size == null || (key >= 0 && key < size);
    }

    public void diff(@NotNull IDiff<V> cmp, @NotNull IDiffAble<?> that) {
        if (cmp == null) throw new IllegalArgumentException("cmp cannot be null");
        if (that == null) throw new IllegalArgumentException("that cannot be null");
        
        if (that instanceof ArrayHeapKV) {
            ArrayHeapKV<V> other = (ArrayHeapKV<V>) that;
            allSize.diff(cmp, other.allSize);
            if (initializedValue != null && other.initializedValue != null) {
                cmp.diff(initializedValue, other.initializedValue);
            }
        }
        super.diff(cmp, that);
    }

    @Nullable
    public IHeapValues<V> getValue(@NotNull IHeapValuesFactory<V> hf, int key) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        
        IHeapValues<V> value = super.getValue(hf, key);
        if (value != null) return value;
        
        if (size == null) return null;
        if (size != getMap().size()) return null;
        
        IHeapValues<V> unreferenced = getUnreferenced();
        if (unreferenced == null || !unreferenced.isNotEmpty()) return null;
        if (initializedValue == null) return null;
        
        return hf.single(initializedValue);
    }

    @Nullable
    public IHeapValues<V> get(@NotNull IHeapValuesFactory<V> hf, @Nullable Integer key) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        if (Boolean.FALSE.equals(isValidKey(key))) return null;
        return super.get(hf, key);
    }

    @NotNull
    public IHeapValues<V> getArrayLength() {
        return allSize;
    }

    public int computeHash() {
        int result = super.computeHash();
        result = 31 * result + allSize.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (!super.equals(other)) return false;
        if (!(other instanceof ArrayHeapKV)) return false;
        ArrayHeapKV<?> that = (ArrayHeapKV<?>) other;
        return allSize.equals(that.allSize);
    }

    public int hashCode() {
        return super.hashCode();
    }

    @NotNull
    public String ppKey(int key) {
        return String.valueOf(key);
    }

    @NotNull
    public IHeapValues<V> getFromNullKey(@NotNull IHeapValuesFactory<V> hf) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        
        IHeapValues<V> result = super.getFromNullKey(hf);
        if (size != null && size == getMap().size() && initializedValue != null) {
            return result.plus(hf.single(initializedValue));
        }
        return result;
    }
}
