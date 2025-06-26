/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CallStackContext
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IIFact
 *  cn.sast.dataflow.interprocedural.analysis.IIFact$Companion
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV
 *  kotlin.Metadata
 *  kotlinx.collections.immutable.ImmutableSet
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.Type
 *  soot.Value
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CallStackContext;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IIFact;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import java.util.Set;
import kotlin.Metadata;
import kotlinx.collections.immutable.ImmutableSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Type;
import soot.Value;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 -*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001-J)\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b2\u0006\u0010\t\u001a\u00028\u00002\n\u0010\n\u001a\u00060\u0002j\u0002`\u000bH&\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&J\b\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0017H&J\b\u0010\u0019\u001a\u00020\u0017H\u0016J \u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0002H&J\u001d\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001fJ#\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00028\u0000\u0018\u00010!2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010#J&\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010)\u001a\u00020*X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u00a8\u0006."}, d2={"Lcn/sast/dataflow/interprocedural/analysis/IIFact;", "V", "", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "getHf", "()Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "getValueData", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "v", "mt", "Lcn/sast/dataflow/interprocedural/check/ModelT;", "(Ljava/lang/Object;Ljava/lang/Object;)Lcn/sast/dataflow/interprocedural/analysis/IData;", "getTargets", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "slot", "getTargetsUnsafe", "getSlots", "", "getCalledMethods", "Lkotlinx/collections/immutable/ImmutableSet;", "Lsoot/SootMethod;", "isBottom", "", "isTop", "isValid", "getOfSlot", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "getArrayLength", "array", "(Ljava/lang/Object;)Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "getArray", "Lcn/sast/dataflow/interprocedural/analysis/heapimpl/IArrayHeapKV;", "", "(Ljava/lang/Object;)Lcn/sast/dataflow/interprocedural/analysis/heapimpl/IArrayHeapKV;", "getOfSootValue", "value", "Lsoot/Value;", "valueType", "Lsoot/Type;", "callStack", "Lcn/sast/dataflow/interprocedural/analysis/CallStackContext;", "getCallStack", "()Lcn/sast/dataflow/interprocedural/analysis/CallStackContext;", "Companion", "corax-data-flow"})
public interface IIFact<V> {
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @NotNull
    public AbstractHeapFactory<V> getHf();

    @Nullable
    public IData<V> getValueData(V var1, @NotNull Object var2);

    @NotNull
    public IHeapValues<V> getTargets(@NotNull Object var1);

    @Nullable
    public IHeapValues<V> getTargetsUnsafe(@NotNull Object var1);

    @NotNull
    public Set<Object> getSlots();

    @NotNull
    public ImmutableSet<SootMethod> getCalledMethods();

    public boolean isBottom();

    public boolean isTop();

    public boolean isValid();

    @Nullable
    public IHeapValues<V> getOfSlot(@NotNull HeapValuesEnv var1, @NotNull Object var2);

    @Nullable
    public IHeapValues<V> getArrayLength(V var1);

    @Nullable
    public IArrayHeapKV<Integer, V> getArray(V var1);

    @NotNull
    public IHeapValues<V> getOfSootValue(@NotNull HeapValuesEnv var1, @NotNull Value var2, @NotNull Type var3);

    @NotNull
    public CallStackContext getCallStack();
}

