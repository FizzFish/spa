/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ExtSettings
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CallStackContext
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesHashingStrategy
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IProblemIteratorTerminal
 *  cn.sast.dataflow.interprocedural.analysis.IVGlobal
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.PointsToGraphAbstract
 *  cn.sast.dataflow.interprocedural.check.PointsToGraph
 *  cn.sast.dataflow.interprocedural.check.PointsToGraph$IntegerInterval
 *  cn.sast.dataflow.interprocedural.check.PointsToGraphBuilder
 *  cn.sast.idfa.analysis.Context
 *  cn.sast.idfa.analysis.FixPointStatus
 *  gnu.trove.set.hash.TCustomHashSet
 *  gnu.trove.strategy.HashingStrategy
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.PersistentMap
 *  kotlinx.collections.immutable.PersistentSet
 *  org.jetbrains.annotations.NotNull
 *  soot.PrimType
 *  soot.SootMethod
 *  soot.Unit
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.api.config.ExtSettings;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CallStackContext;
import cn.sast.dataflow.interprocedural.analysis.FactValuesHashingStrategy;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IProblemIteratorTerminal;
import cn.sast.dataflow.interprocedural.analysis.IVGlobal;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.PointsToGraphAbstract;
import cn.sast.dataflow.interprocedural.check.PointsToGraph;
import cn.sast.dataflow.interprocedural.check.PointsToGraphBuilder;
import cn.sast.idfa.analysis.Context;
import cn.sast.idfa.analysis.FixPointStatus;
import gnu.trove.set.hash.TCustomHashSet;
import gnu.trove.strategy.HashingStrategy;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentMap;
import kotlinx.collections.immutable.PersistentSet;
import org.jetbrains.annotations.NotNull;
import soot.PrimType;
import soot.SootMethod;
import soot.Unit;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001 B\u0087\u0001\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\r0\u000b\u00120\u0010\u000e\u001a,\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u001e\u0012\u001c\u0012\b\u0012\u00060\fj\u0002`\u000f\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00100\u000b0\u000b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0017H\u0016J>\u0010\u0018\u001a\u00020\u00192\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001d0\u001b2\u0010\u0010\u001e\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001fH\u0016\u00a8\u0006!"}, d2={"Lcn/sast/dataflow/interprocedural/check/PointsToGraph;", "Lcn/sast/dataflow/interprocedural/analysis/PointsToGraphAbstract;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "vg", "Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;", "callStack", "Lcn/sast/dataflow/interprocedural/analysis/CallStackContext;", "slots", "Lkotlinx/collections/immutable/PersistentMap;", "", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "heap", "Lcn/sast/dataflow/interprocedural/check/ModelT;", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "calledMethods", "Lkotlinx/collections/immutable/PersistentSet;", "Lsoot/SootMethod;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;Lcn/sast/dataflow/interprocedural/analysis/CallStackContext;Lkotlinx/collections/immutable/PersistentMap;Lkotlinx/collections/immutable/PersistentMap;Lkotlinx/collections/immutable/PersistentSet;)V", "builder", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "hasChange", "Lcn/sast/idfa/analysis/FixPointStatus;", "context", "Lcn/sast/idfa/analysis/Context;", "Lsoot/Unit;", "Lcn/sast/dataflow/interprocedural/analysis/IFact;", "new", "Lcn/sast/dataflow/interprocedural/analysis/IProblemIteratorTerminal;", "IntegerInterval", "corax-data-flow"})
public class PointsToGraph
extends PointsToGraphAbstract<IValue> {
    public PointsToGraph(@NotNull AbstractHeapFactory<IValue> hf, @NotNull IVGlobal vg, @NotNull CallStackContext callStack, @NotNull PersistentMap<Object, ? extends IHeapValues<IValue>> slots, @NotNull PersistentMap<IValue, ? extends PersistentMap<Object, ? extends IData<IValue>>> heap, @NotNull PersistentSet<? extends SootMethod> calledMethods) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)vg, (String)"vg");
        Intrinsics.checkNotNullParameter((Object)callStack, (String)"callStack");
        Intrinsics.checkNotNullParameter(slots, (String)"slots");
        Intrinsics.checkNotNullParameter(heap, (String)"heap");
        Intrinsics.checkNotNullParameter(calledMethods, (String)"calledMethods");
        super(hf, vg, callStack, slots, heap, calledMethods);
    }

    @NotNull
    public IFact.Builder<IValue> builder() {
        return (IFact.Builder)new PointsToGraphBuilder((PointsToGraphAbstract)this, this.getHf(), this.getVg(), this.getCallStack(), this.getSlots().builder(), this.getHeap().builder(), this.getCalledMethods().builder());
    }

    @NotNull
    public FixPointStatus hasChange(@NotNull Context<SootMethod, Unit, IFact<IValue>> context, @NotNull IProblemIteratorTerminal<IValue> iProblemIteratorTerminal) {
        Set newSlots;
        Intrinsics.checkNotNullParameter(context, (String)"context");
        Intrinsics.checkNotNullParameter(iProblemIteratorTerminal, (String)"new");
        if (!(iProblemIteratorTerminal instanceof IFact)) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        if (!((IFact)iProblemIteratorTerminal).isValid()) {
            return FixPointStatus.HasChange;
        }
        if (!(iProblemIteratorTerminal instanceof PointsToGraphAbstract)) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        if (this == iProblemIteratorTerminal) {
            return FixPointStatus.Fixpoint;
        }
        Set oldSlots = this.getSlots();
        if (!Intrinsics.areEqual((Object)oldSlots, (Object)(newSlots = ((PointsToGraphAbstract)iProblemIteratorTerminal).getSlots()))) {
            return FixPointStatus.HasChange;
        }
        boolean needWiden = false;
        for (Object local : oldSlots) {
            IHeapValues oldTarget = this.getTargets(local);
            IHeapValues newTarget = ((PointsToGraphAbstract)iProblemIteratorTerminal).getTargets(local);
            Collection valueOld = (Collection)oldTarget.getValues();
            Collection valueNew = (Collection)newTarget.getValues();
            IValue iValue = (IValue)CollectionsKt.firstOrNull((Iterable)valueOld);
            if ((iValue != null ? iValue.getType() : null) instanceof PrimType) {
                IntegerInterval oldInterval = IntegerInterval.Companion.invoke(valueOld);
                IntegerInterval newInterval = IntegerInterval.Companion.invoke(valueNew);
                if (oldInterval.getWidening() != newInterval.getWidening()) {
                    return FixPointStatus.HasChange;
                }
                if (oldInterval.getWidening()) continue;
                int max = ExtSettings.INSTANCE.getDataFlowIteratorIsFixPointSizeLimit();
                if (max > 0 && (newInterval.getConstants().size() > max || oldInterval.getConstants().size() > max)) {
                    needWiden = true;
                }
            }
            TCustomHashSet hashSet = new TCustomHashSet((HashingStrategy)FactValuesHashingStrategy.Companion.getINSTANCE());
            hashSet.addAll(valueOld);
            boolean change = hashSet.addAll(valueNew);
            if (!change) continue;
            if (needWiden) {
                return FixPointStatus.NeedWideningOperators;
            }
            return FixPointStatus.HasChange;
        }
        return FixPointStatus.Fixpoint;
    }
}

