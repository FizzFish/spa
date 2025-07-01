package cn.sast.dataflow.interprocedural.analysis;

import gnu.trove.strategy.HashingStrategy;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class FactValuesHashingStrategy implements HashingStrategy<IValue> {
    @NotNull
    public static final FactValuesHashingStrategy INSTANCE = new FactValuesHashingStrategy();

    public static FactValuesHashingStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int computeHashCode(@NotNull IValue v) {
        Objects.requireNonNull(v, "v");
        
        if (v instanceof AnyNewValue) {
            return Objects.hash(((AnyNewValue) v).getNewExpr());
        } else if (v instanceof ConstVal) {
            return Objects.hash(((ConstVal) v).getV());
        } else if (v instanceof SummaryValue) {
            SummaryValue sv = (SummaryValue) v;
            return Objects.hash(sv.getType(), sv.getUnit(), sv.getSpecial());
        } else if (v instanceof EntryParam) {
            EntryParam ep = (EntryParam) v;
            return Objects.hash(ep.getMethod(), ep.getParamIndex());
        } else if (v instanceof GlobalStaticObject) {
            return v.hashCode();
        } else if (v instanceof PhantomField) {
            PhantomField pf = (PhantomField) v;
            return Objects.hash(computeHashCode(pf.getBase()), pf.getAccessPath());
        } else {
            throw new IllegalStateException("error type of " + v.getClass() + ": " + v);
        }
    }

    @Override
    public boolean equals(@NotNull IValue a, @NotNull IValue b) {
        Objects.requireNonNull(a, "a");
        Objects.requireNonNull(b, "b");
        
        if (a == b) {
            return true;
        }
        if (computeHashCode(a) != computeHashCode(b)) {
            return false;
        }
        
        if (a instanceof AnyNewValue && b instanceof AnyNewValue) {
            return Objects.equals(((AnyNewValue) a).getNewExpr(), ((AnyNewValue) b).getNewExpr());
        }
        if (a instanceof ConstVal && b instanceof ConstVal) {
            return Objects.equals(((ConstVal) a).getV(), ((ConstVal) b).getV());
        }
        if (a instanceof SummaryValue && b instanceof SummaryValue) {
            SummaryValue sa = (SummaryValue) a;
            SummaryValue sb = (SummaryValue) b;
            return Objects.equals(sa.getType(), sb.getType()) 
                && Objects.equals(sa.getUnit(), sb.getUnit())
                && Objects.equals(sa.getSpecial(), sb.getSpecial());
        }
        if (a instanceof EntryParam && b instanceof EntryParam) {
            EntryParam ea = (EntryParam) a;
            EntryParam eb = (EntryParam) b;
            return Objects.equals(ea.getMethod(), eb.getMethod()) 
                && ea.getParamIndex() == eb.getParamIndex();
        }
        if (a instanceof GlobalStaticObject && b instanceof GlobalStaticObject) {
            return a.equals(b);
        }
        if (a instanceof PhantomField && b instanceof PhantomField) {
            PhantomField pa = (PhantomField) a;
            PhantomField pb = (PhantomField) b;
            return equals(pa.getBase(), pb.getBase()) 
                && Objects.equals(pa.getAccessPath(), pb.getAccessPath());
        }
        throw new IllegalStateException("error type of a: \n" + a.getClass() + ": " + a 
            + "    b:\n" + b.getClass() + ": " + b);
    }
}
