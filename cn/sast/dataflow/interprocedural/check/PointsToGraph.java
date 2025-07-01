package cn.sast.dataflow.interprocedural.check;

import cn.sast.api.config.ExtSettings;
import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.idfa.analysis.Context;
import cn.sast.idfa.analysis.FixPointStatus;
import gnu.trove.set.hash.TCustomHashSet;
import gnu.trove.strategy.HashingStrategy;
import org.jetbrains.annotations.NotNull;
import soot.PrimType;
import soot.SootMethod;
import soot.Unit;
import java.util.Collection;
import java.util.Set;

public class PointsToGraph extends PointsToGraphAbstract<IValue> {

    public PointsToGraph(
            @NotNull AbstractHeapFactory<IValue> hf,
            @NotNull IVGlobal vg,
            @NotNull CallStackContext callStack,
            @NotNull PersistentMap<Object, ? extends IHeapValues<IValue>> slots,
            @NotNull PersistentMap<IValue, ? extends PersistentMap<Object, ? extends IData<IValue>>> heap,
            @NotNull PersistentSet<? extends SootMethod> calledMethods) {
        super(hf, vg, callStack, slots, heap, calledMethods);
    }

    @Override
    @NotNull
    public IFact.Builder<IValue> builder() {
        return new PointsToGraphBuilder(
                this,
                getHf(),
                getVg(),
                getCallStack(),
                getSlots().builder(),
                getHeap().builder(),
                getCalledMethods().builder());
    }

    @Override
    @NotNull
    public FixPointStatus hasChange(
            @NotNull Context<SootMethod, Unit, IFact<IValue>> context,
            @NotNull IProblemIteratorTerminal<IValue> newState) {
        
        if (!(newState instanceof IFact)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (!((IFact) newState).isValid()) {
            return FixPointStatus.HasChange;
        }
        if (!(newState instanceof PointsToGraphAbstract)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (this == newState) {
            return FixPointStatus.Fixpoint;
        }

        Set<Object> oldSlots = getSlots();
        Set<Object> newSlots = ((PointsToGraphAbstract<?>) newState).getSlots();
        if (!oldSlots.equals(newSlots)) {
            return FixPointStatus.HasChange;
        }

        boolean needWiden = false;
        for (Object local : oldSlots) {
            IHeapValues<IValue> oldTarget = getTargets(local);
            IHeapValues<IValue> newTarget = ((PointsToGraphAbstract<?>) newState).getTargets(local);
            Collection<IValue> valueOld = oldTarget.getValues();
            Collection<IValue> valueNew = newTarget.getValues();

            IValue firstValue = valueOld.isEmpty() ? null : valueOld.iterator().next();
            if (firstValue != null && firstValue.getType() instanceof PrimType) {
                IntegerInterval oldInterval = IntegerInterval.of(valueOld);
                IntegerInterval newInterval = IntegerInterval.of(valueNew);
                
                if (oldInterval.getWidening() != newInterval.getWidening()) {
                    return FixPointStatus.HasChange;
                }
                if (oldInterval.getWidening()) {
                    continue;
                }
                
                int max = ExtSettings.getInstance().getDataFlowIteratorIsFixPointSizeLimit();
                if (max > 0 && (newInterval.getConstants().size() > max || oldInterval.getConstants().size() > max)) {
                    needWiden = true;
                }
            }

            TCustomHashSet<IValue> hashSet = new TCustomHashSet<>(FactValuesHashingStrategy.getInstance());
            hashSet.addAll(valueOld);
            boolean change = hashSet.addAll(valueNew);
            
            if (!change) {
                continue;
            }
            if (needWiden) {
                return FixPointStatus.NeedWideningOperators;
            }
            return FixPointStatus.HasChange;
        }
        return FixPointStatus.Fixpoint;
    }
}