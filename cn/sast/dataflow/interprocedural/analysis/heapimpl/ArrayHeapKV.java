/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapKVData
 *  cn.sast.dataflow.interprocedural.analysis.IDiff
 *  cn.sast.dataflow.interprocedural.analysis.IDiffAble
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapKV
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapKVKt
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.PersistentMap
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.ArrayType
 */
package cn.sast.dataflow.interprocedural.analysis.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IDiffAble;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapKVKt;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u00022\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0004Ba\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0002\u0010\u001fJ(\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0010\u0010$\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010&0%H\u0016J&\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00072\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J-\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00072\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0002\u0010+J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016J\b\u0010-\u001a\u00020\u0003H\u0016J\u0013\u0010.\u001a\u00020\u001d2\b\u0010/\u001a\u0004\u0018\u00010&H\u0096\u0002J\b\u00100\u001a\u00020\u0003H\u0016J\u0010\u00101\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u001c\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)H\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u00063"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/heapimpl/ArrayHeapKV;", "V", "Lcn/sast/dataflow/interprocedural/analysis/HeapKVData;", "", "Lcn/sast/dataflow/interprocedural/analysis/heapimpl/IArrayHeapKV;", "element", "Lkotlinx/collections/immutable/PersistentMap;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "allSize", "type", "Lsoot/ArrayType;", "size", "initializedValue", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "<init>", "(Lkotlinx/collections/immutable/PersistentMap;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;Lsoot/ArrayType;Ljava/lang/Integer;Lcn/sast/dataflow/interprocedural/analysis/CompanionV;)V", "getAllSize", "()Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "getType", "()Lsoot/ArrayType;", "getSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInitializedValue", "()Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "getName", "", "isValidKey", "", "key", "(Ljava/lang/Integer;)Ljava/lang/Boolean;", "diff", "", "cmp", "Lcn/sast/dataflow/interprocedural/analysis/IDiff;", "that", "Lcn/sast/dataflow/interprocedural/analysis/IDiffAble;", "", "getValue", "hf", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;", "get", "(Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;Ljava/lang/Integer;)Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "getArrayLength", "computeHash", "equals", "other", "hashCode", "ppKey", "getFromNullKey", "corax-data-flow"})
public abstract class ArrayHeapKV<V>
extends HeapKVData<Integer, V>
implements IArrayHeapKV<Integer, V> {
    @NotNull
    private final IHeapValues<V> allSize;
    @NotNull
    private final ArrayType type;
    @Nullable
    private final Integer size;
    @Nullable
    private final CompanionV<V> initializedValue;

    public ArrayHeapKV(@NotNull PersistentMap<Integer, ? extends IHeapValues<V>> element, @Nullable IHeapValues<V> unreferenced, @NotNull IHeapValues<V> allSize, @NotNull ArrayType type, @Nullable Integer size, @Nullable CompanionV<V> initializedValue) {
        Intrinsics.checkNotNullParameter(element, (String)"element");
        Intrinsics.checkNotNullParameter(allSize, (String)"allSize");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        super(element, unreferenced);
        this.allSize = allSize;
        this.type = type;
        this.size = size;
        this.initializedValue = initializedValue;
        if (!this.allSize.isNotEmpty()) {
            boolean bl = false;
            String string = "array length value set is empty";
            throw new IllegalArgumentException(string.toString());
        }
    }

    @NotNull
    public final IHeapValues<V> getAllSize() {
        return this.allSize;
    }

    @NotNull
    public ArrayType getType() {
        return this.type;
    }

    @Nullable
    public final Integer getSize() {
        return this.size;
    }

    @Nullable
    public final CompanionV<V> getInitializedValue() {
        return this.initializedValue;
    }

    @NotNull
    public String getName() {
        return this.getType().getElementType() + "[" + this.size + "]";
    }

    @Nullable
    public Boolean isValidKey(@Nullable Integer key2) {
        return ArrayHeapKVKt.isValidKey((Integer)key2, (Integer)this.size);
    }

    public void diff(@NotNull IDiff<V> cmp, @NotNull IDiffAble<? extends Object> that) {
        Intrinsics.checkNotNullParameter(cmp, (String)"cmp");
        Intrinsics.checkNotNullParameter(that, (String)"that");
        if (that instanceof ArrayHeapKV) {
            this.allSize.diff(cmp, (IDiffAble)((ArrayHeapKV)that).allSize);
            if (this.initializedValue != null && ((ArrayHeapKV)that).initializedValue != null) {
                cmp.diff(this.initializedValue, ((ArrayHeapKV)that).initializedValue);
            }
        }
        super.diff(cmp, that);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Nullable
    public IHeapValues<V> getValue(@NotNull IHeapValuesFactory<V> hf, int key2) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        IHeapValues iHeapValues = super.getValue(hf, (Object)key2);
        IHeapValues iHeapValues2 = iHeapValues;
        if (iHeapValues != null) return iHeapValues2;
        if (this.size == null) return null;
        Integer n = this.size;
        int n2 = this.getMap().size();
        if (n == null) return null;
        if (n != n2) return null;
        IHeapValues iHeapValues3 = this.getUnreferenced();
        if (iHeapValues3 == null) return null;
        if (!iHeapValues3.isNotEmpty()) return null;
        boolean bl = true;
        if (!bl) return null;
        if (this.initializedValue == null) return null;
        iHeapValues2 = hf.single(this.initializedValue);
        return iHeapValues2;
    }

    @Nullable
    public IHeapValues<V> get(@NotNull IHeapValuesFactory<V> hf, @Nullable Integer key2) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        if (Intrinsics.areEqual((Object)this.isValidKey(key2), (Object)false)) {
            return null;
        }
        return super.get(hf, (Object)key2);
    }

    @NotNull
    public IHeapValues<V> getArrayLength() {
        return this.allSize;
    }

    public int computeHash() {
        int result = super.computeHash();
        result = 31 * result + this.allSize.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (!super.equals(other)) {
            return false;
        }
        if (!(other instanceof ArrayHeapKV)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.allSize, (Object)((ArrayHeapKV)other).allSize);
    }

    public int hashCode() {
        return super.hashCode();
    }

    @NotNull
    public String ppKey(int key2) {
        return String.valueOf(key2);
    }

    @NotNull
    public IHeapValues<V> getFromNullKey(@NotNull IHeapValuesFactory<V> hf) {
        IHeapValues r;
        block5: {
            block4: {
                Intrinsics.checkNotNullParameter(hf, (String)"hf");
                r = super.getFromNullKey(hf);
                if (this.size == null) break block4;
                Integer n = this.size;
                int n2 = this.getMap().size();
                if (n != null && n == n2) break block5;
            }
            if (this.initializedValue != null) {
                return r.plus(hf.single(this.initializedValue));
            }
        }
        return r;
    }
}

