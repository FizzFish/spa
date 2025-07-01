package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import java.util.Arrays;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;
import soot.ByteType;
import soot.G;
import soot.Type;
import soot.Unit;
import soot.jimple.Constant;
import soot.jimple.IntConstant;
import mu.KLogger;
import mu.KotlinLogging;

public final class JStrArrValue implements IArrayHeapKV<Integer, IValue> {
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(JStrArrValue.class);
    
    @NotNull
    private final Unit node;
    @NotNull
    private final byte[] byteArray;
    @NotNull
    private final ArrayType type;
    @NotNull
    private final IHeapValues<IValue> arrayLength;
    @NotNull
    private final CompanionV<IValue>[] byteArrayConstVal;

    public JStrArrValue(@NotNull Unit node, @NotNull AbstractHeapFactory<IValue> hf, @NotNull byte[] byteArray) {
        if (node == null) throw new IllegalArgumentException("node cannot be null");
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        if (byteArray == null) throw new IllegalArgumentException("byteArray cannot be null");
        
        this.node = node;
        this.byteArray = byteArray;
        this.type = hf.getVg().getBYTE_ARRAY_TYPE();
        
        IntConstant lengthConst = IntConstant.v(this.byteArray.length);
        HeapValuesEnv env = hf.env(this.node);
        this.arrayLength = hf.push(env, hf.newConstVal(lengthConst, this.getType()))
            .markOfConstant(lengthConst)
            .popHV();

        this.byteArrayConstVal = new CompanionV[this.byteArray.length];
        for (int i = 0; i < this.byteArray.length; i++) {
            IntConstant byteConst = IntConstant.v(this.byteArray[i]);
            IValue cv = hf.newConstVal(byteConst, G.v().soot_ByteType());
            this.byteArrayConstVal[i] = hf.push(hf.env(this.node), cv)
                .markOfConstant(byteConst)
                .pop();
        }
    }

    @NotNull
    public Unit getNode() {
        return node;
    }

    @NotNull
    public byte[] getByteArray() {
        return byteArray;
    }

    @NotNull
    public ArrayType getType() {
        return type;
    }

    @Nullable
    public IHeapValues<IValue> get(@NotNull IHeapValuesFactory<IValue> hf, @Nullable Integer key) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        
        if (key != null) {
            if (key < 0 || key >= byteArray.length) {
                return null;
            }
            return hf.single(byteArrayConstVal[key]);
        }
        
        IHeapValues.Builder<IValue> b = hf.emptyBuilder();
        for (CompanionV<IValue> val : byteArrayConstVal) {
            b.add(val);
        }
        return b.build();
    }

    @NotNull
    public String toString() {
        return "ImByteArray_" + new String(byteArray, java.nio.charset.StandardCharsets.UTF_8);
    }

    @NotNull
    public IHeapKVData.Builder<Integer, IValue> builder() {
        return new IHeapKVData.Builder<Integer, IValue>() {
            // Builder implementation
        };
    }

    public void reference(@NotNull Collection<IValue> res) {
        if (res == null) throw new IllegalArgumentException("res cannot be null");
    }

    public int computeHash() {
        return 1138 + Arrays.hashCode(byteArray);
    }

    public void diff(@NotNull IDiff<IValue> cmp, @NotNull IDiffAble<?> that) {
        if (cmp == null) throw new IllegalArgumentException("cmp cannot be null");
        if (that == null) throw new IllegalArgumentException("that cannot be null");
    }

    public int hashCode() {
        return computeHash();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof JStrArrValue)) return false;
        JStrArrValue that = (JStrArrValue) other;
        return hashCode() == that.hashCode() && Arrays.equals(byteArray, that.byteArray);
    }

    @NotNull
    public IData<IValue> cloneAndReNewObjects(@NotNull IReNew<IValue> re) {
        if (re == null) throw new IllegalArgumentException("re cannot be null");
        return this;
    }

    @NotNull
    public IHeapValues<IValue> getArrayLength() {
        return arrayLength;
    }

    @NotNull
    public IHeapValues<IValue> getElement(@NotNull AbstractHeapFactory<IValue> hf) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        
        IHeapValues.Builder<IValue> b = hf.emptyBuilder();
        for (CompanionV<IValue> val : byteArrayConstVal) {
            b.add(val);
        }
        return b.build();
    }

    @NotNull
    public IValue[] getArray(@NotNull IHeapValuesFactory<IValue> hf) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        
        IValue[] result = new IValue[byteArrayConstVal.length];
        for (int i = 0; i < byteArrayConstVal.length; i++) {
            result[i] = byteArrayConstVal[i].getValue();
        }
        return result;
    }

    @NotNull
    public byte[] getByteArray(@NotNull IHeapValuesFactory<IValue> hf) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        return byteArray;
    }
}
