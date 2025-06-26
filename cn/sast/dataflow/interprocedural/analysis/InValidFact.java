/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.CallStackContext
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.dataflow.interprocedural.analysis.IFact$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IProblemIteratorTerminal
 *  cn.sast.dataflow.interprocedural.analysis.InValidFact
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV
 *  cn.sast.idfa.analysis.Context
 *  cn.sast.idfa.analysis.FixPointStatus
 *  cn.sast.idfa.analysis.FixPointStatus$Companion
 *  kotlin.Metadata
 *  kotlin.NotImplementedError
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.ImmutableSet
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.Value
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.CallStackContext;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IProblemIteratorTerminal;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import cn.sast.idfa.analysis.Context;
import cn.sast.idfa.analysis.FixPointStatus;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J6\u0010\u0005\u001a\u00020\u00062\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H\u0016J)\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00028\u00002\n\u0010\u0018\u001a\u00060\u000fj\u0002`\u0019H\u0016\u00a2\u0006\u0002\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\u001f"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/InValidFact;", "V", "Lcn/sast/dataflow/interprocedural/analysis/IFact;", "<init>", "()V", "hasChange", "Lcn/sast/idfa/analysis/FixPointStatus;", "context", "Lcn/sast/idfa/analysis/Context;", "Lsoot/SootMethod;", "Lsoot/Unit;", "new", "Lcn/sast/dataflow/interprocedural/analysis/IProblemIteratorTerminal;", "getSlots", "", "", "getTargetsUnsafe", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "slot", "getCalledMethods", "Lkotlinx/collections/immutable/ImmutableSet;", "getValueData", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "v", "mt", "Lcn/sast/dataflow/interprocedural/check/ModelT;", "(Ljava/lang/Object;Ljava/lang/Object;)Lcn/sast/dataflow/interprocedural/analysis/IData;", "callStack", "Lcn/sast/dataflow/interprocedural/analysis/CallStackContext;", "getCallStack", "()Lcn/sast/dataflow/interprocedural/analysis/CallStackContext;", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nIFact.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IFact.kt\ncn/sast/dataflow/interprocedural/analysis/InValidFact\n+ 2 FixPointStatus.kt\ncn/sast/idfa/analysis/FixPointStatus$Companion\n*L\n1#1,507:1\n10#2:508\n*S KotlinDebug\n*F\n+ 1 IFact.kt\ncn/sast/dataflow/interprocedural/analysis/InValidFact\n*L\n230#1:508\n*E\n"})
public abstract class InValidFact<V>
implements IFact<V> {
    @NotNull
    public FixPointStatus hasChange(@NotNull Context<SootMethod, Unit, IFact<V>> context, @NotNull IProblemIteratorTerminal<V> iProblemIteratorTerminal) {
        Intrinsics.checkNotNullParameter(context, (String)"context");
        Intrinsics.checkNotNullParameter(iProblemIteratorTerminal, (String)"new");
        FixPointStatus.Companion companion = FixPointStatus.Companion;
        boolean hasChange$iv = !Intrinsics.areEqual((Object)this, iProblemIteratorTerminal);
        boolean $i$f$of = false;
        return hasChange$iv ? FixPointStatus.HasChange : FixPointStatus.Fixpoint;
    }

    @NotNull
    public Set<Object> getSlots() {
        return SetsKt.emptySet();
    }

    @Nullable
    public IHeapValues<V> getTargetsUnsafe(@NotNull Object slot) {
        Intrinsics.checkNotNullParameter((Object)slot, (String)"slot");
        return null;
    }

    @NotNull
    public ImmutableSet<SootMethod> getCalledMethods() {
        return (ImmutableSet)ExtensionsKt.persistentHashSetOf();
    }

    @Nullable
    public IData<V> getValueData(V v, @NotNull Object mt) {
        Intrinsics.checkNotNullParameter((Object)mt, (String)"mt");
        return null;
    }

    @NotNull
    public CallStackContext getCallStack() {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @NotNull
    public IHeapValues<V> getTargets(@NotNull Object slot) {
        return IFact.DefaultImpls.getTargets((IFact)this, (Object)slot);
    }

    public boolean isValid() {
        return IFact.DefaultImpls.isValid((IFact)this);
    }

    @Nullable
    public IHeapValues<V> getArrayLength(V array) {
        return IFact.DefaultImpls.getArrayLength((IFact)this, array);
    }

    @Nullable
    public IArrayHeapKV<Integer, V> getArray(V array) {
        return IFact.DefaultImpls.getArray((IFact)this, array);
    }

    @NotNull
    public IHeapValues<V> getOfSootValue(@NotNull HeapValuesEnv env, @NotNull Value value, @NotNull Type valueType) {
        return IFact.DefaultImpls.getOfSootValue((IFact)this, (HeapValuesEnv)env, (Value)value, (Type)valueType);
    }
}

