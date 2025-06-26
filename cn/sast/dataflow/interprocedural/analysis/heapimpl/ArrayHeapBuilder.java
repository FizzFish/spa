/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.analysis.ReferenceContext$ArrayElement
 *  cn.sast.dataflow.interprocedural.analysis.ReferenceContext$ArrayInitialized
 *  cn.sast.dataflow.interprocedural.analysis.ReferenceContext$ArraySize
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapBuilder
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapKVKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.PersistentMap$Builder
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.ArrayType
 */
package cn.sast.dataflow.interprocedural.analysis.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.ReferenceContext;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapKVKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002Ba\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\u00a2\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\u001f\u001a\u00020\u0003H\u0016JE\u0010 \u001a\u00020!2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\"\u001a\u00020#2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\u0006\u0010%\u001a\u00020&H\u0016\u00a2\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020!2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*H\u0016J\u0006\u0010+\u001a\u00020!R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006,"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/heapimpl/ArrayHeapBuilder;", "V", "Lcn/sast/dataflow/interprocedural/analysis/HeapDataBuilder;", "", "element", "Lkotlinx/collections/immutable/PersistentMap$Builder;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "type", "Lsoot/ArrayType;", "allSize", "size", "initializedValue", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "<init>", "(Lkotlinx/collections/immutable/PersistentMap$Builder;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;Lsoot/ArrayType;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;Ljava/lang/Integer;Lcn/sast/dataflow/interprocedural/analysis/CompanionV;)V", "getType", "()Lsoot/ArrayType;", "getAllSize", "()Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "getSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInitializedValue", "()Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "setInitializedValue", "(Lcn/sast/dataflow/interprocedural/analysis/CompanionV;)V", "getValue", "hf", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;", "key", "set", "", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "update", "append", "", "(Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;Ljava/lang/Integer;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;Z)V", "cloneAndReNewObjects", "re", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "clearAllIndex", "corax-data-flow"})
public abstract class ArrayHeapBuilder<V>
extends HeapDataBuilder<Integer, V> {
    @NotNull
    private final ArrayType type;
    @NotNull
    private final IHeapValues.Builder<V> allSize;
    @Nullable
    private final Integer size;
    @Nullable
    private CompanionV<V> initializedValue;

    public ArrayHeapBuilder(@NotNull PersistentMap.Builder<Integer, IHeapValues<V>> element, @Nullable IHeapValues.Builder<V> unreferenced, @NotNull ArrayType type, @NotNull IHeapValues.Builder<V> allSize, @Nullable Integer size, @Nullable CompanionV<V> initializedValue) {
        Intrinsics.checkNotNullParameter(element, (String)"element");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter(allSize, (String)"allSize");
        super(element, unreferenced);
        this.type = type;
        this.allSize = allSize;
        this.size = size;
        this.initializedValue = initializedValue;
        if (!this.allSize.isNotEmpty()) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
    }

    @NotNull
    public final ArrayType getType() {
        return this.type;
    }

    @NotNull
    public final IHeapValues.Builder<V> getAllSize() {
        return this.allSize;
    }

    @Nullable
    public final Integer getSize() {
        return this.size;
    }

    @Nullable
    public final CompanionV<V> getInitializedValue() {
        return this.initializedValue;
    }

    public final void setInitializedValue(@Nullable CompanionV<V> companionV) {
        this.initializedValue = companionV;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Nullable
    public IHeapValues<V> getValue(@NotNull IHeapValuesFactory<V> hf, int key2) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        CompanionV initializedValue = this.initializedValue;
        IHeapValues iHeapValues = super.getValue(hf, (Object)key2);
        IHeapValues iHeapValues2 = iHeapValues;
        if (iHeapValues != null) return iHeapValues2;
        if (this.size != null) {
            Integer n = this.size;
            int n2 = this.getMap().size();
            if (n != null) {
                if (n == n2) return null;
            }
        }
        if (initializedValue == null) return null;
        iHeapValues2 = hf.single(initializedValue);
        return iHeapValues2;
    }

    public void set(@NotNull IHeapValuesFactory<V> hf, @NotNull HeapValuesEnv env, @Nullable Integer key2, @Nullable IHeapValues<V> update2, boolean append) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        if (Intrinsics.areEqual((Object)ArrayHeapKVKt.isValidKey((Integer)key2, (Integer)this.size), (Object)false)) {
            return;
        }
        super.set(hf, env, (Object)key2, update2, append);
    }

    public void cloneAndReNewObjects(@NotNull IReNew<V> re) {
        Intrinsics.checkNotNullParameter(re, (String)"re");
        super.cloneAndReNewObjects(re.context((Object)ReferenceContext.ArrayElement.INSTANCE));
        this.allSize.cloneAndReNewObjects(re.context((Object)ReferenceContext.ArraySize.INSTANCE));
        CompanionV initializedValue = this.initializedValue;
        if (initializedValue != null) {
            CompanionV newCompV;
            CompanionV companionV;
            Object newV;
            Object k = initializedValue.getValue();
            Object object = re.checkNeedReplace(k);
            if (object == null) {
                object = newV = k;
            }
            if ((companionV = re.context((Object)ReferenceContext.ArrayInitialized.INSTANCE).checkNeedReplace(initializedValue)) == null) {
                companionV = newCompV = initializedValue;
            }
            if (Intrinsics.areEqual((Object)k, (Object)newV) && newCompV == initializedValue) {
                return;
            }
            if (!Intrinsics.areEqual((Object)newCompV.getValue(), (Object)newV)) {
                newCompV = newCompV.copy(newV);
            }
            this.initializedValue = newCompV;
        }
    }

    public final void clearAllIndex() {
    }
}

