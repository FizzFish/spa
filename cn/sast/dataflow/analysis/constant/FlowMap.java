package cn.sast.dataflow.analysis.constant;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Local;
import soot.Value;
import soot.jimple.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class FlowMap {
    private static final CPValue DEFAULT_VALUE = CPValue.getUndef();
    
    @NotNull
    private Map<Local, CPValue> delegateMap;

    public FlowMap() {
        this(new HashMap<>());
    }

    public FlowMap(@NotNull Map<Local, CPValue> delegateMap) {
        this.delegateMap = delegateMap;
    }

    @NotNull
    public Map<Local, CPValue> getDelegateMap() {
        return delegateMap;
    }

    public void setDelegateMap(@NotNull Map<Local, CPValue> delegateMap) {
        this.delegateMap = delegateMap;
    }

    @NotNull
    public CPValue get(@NotNull Local local) {
        return delegateMap.computeIfAbsent(local, k -> DEFAULT_VALUE);
    }

    @Nullable
    public CPValue put(@NotNull Local local, @NotNull CPValue value) {
        return delegateMap.put(local, value);
    }

    @NotNull
    public Set<Local> keySet() {
        return delegateMap.keySet();
    }

    public boolean copyFrom(@NotNull FlowMap flowMap) {
        delegateMap.putAll(flowMap.delegateMap);
        return Objects.equals(flowMap.delegateMap, this.delegateMap);
    }

    @NotNull
    public CPValue computeValue(@NotNull Value sootValue) {
        if (sootValue instanceof Local) {
            return get((Local) sootValue);
        }
        if (sootValue instanceof IntConstant) {
            return CPValue.makeConstant(((IntConstant) sootValue).value);
        }
        if (sootValue instanceof BinopExpr) {
            BinopExpr binop = (BinopExpr) sootValue;
            Value op1 = binop.getOp1();
            Value op2 = binop.getOp2();
            CPValue op1Val = computeValue(op1);
            CPValue op2Val = computeValue(op2);

            if (op1Val == CPValue.getUndef() && op2Val == CPValue.getUndef()) {
                return CPValue.getUndef();
            }
            if (op1Val == CPValue.getUndef() || op2Val == CPValue.getUndef()) {
                return CPValue.getNac();
            }
            if (op1Val == CPValue.getNac() || op2Val == CPValue.getNac()) {
                return CPValue.getNac();
            }

            try {
                int v1 = op1Val.value();
                int v2 = op2Val.value();
                
                if (binop instanceof AddExpr) {
                    return CPValue.makeConstant(v1 + v2);
                } else if (binop instanceof SubExpr) {
                    return CPValue.makeConstant(v1 - v2);
                } else if (binop instanceof MulExpr) {
                    return CPValue.makeConstant(v1 * v2);
                } else if (binop instanceof DivExpr) {
                    return CPValue.makeConstant(v1 / v2);
                } else if (binop instanceof EqExpr) {
                    return CPValue.makeConstant(v1 == v2);
                } else if (binop instanceof NeExpr) {
                    return CPValue.makeConstant(v1 != v2);
                } else if (binop instanceof GeExpr) {
                    return CPValue.makeConstant(v1 >= v2);
                } else if (binop instanceof GtExpr) {
                    return CPValue.makeConstant(v1 > v2);
                } else if (binop instanceof LeExpr) {
                    return CPValue.makeConstant(v1 <= v2);
                } else if (binop instanceof LtExpr) {
                    return CPValue.makeConstant(v1 < v2);
                }
            } catch (ArithmeticException ignored) {
            }
            return CPValue.getNac();
        }
        return CPValue.getNac();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        FlowMap flowMap = (FlowMap) other;
        return Objects.equals(delegateMap, flowMap.delegateMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delegateMap);
    }

    @Override
    public String toString() {
        return delegateMap.toString();
    }
}