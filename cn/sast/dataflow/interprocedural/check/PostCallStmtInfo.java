package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.check.ModelingStmtInfo;
import com.feysh.corax.config.api.IStmt;
import com.feysh.corax.config.api.MLocal;
import com.feysh.corax.config.api.MParameter;
import com.feysh.corax.config.api.MReturn;
import java.io.Serializable;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;
import soot.Value;
import soot.jimple.DefinitionStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import java.util.function.Function;

public final class PostCallStmtInfo extends ModelingStmtInfo {
    @NotNull
    private final Unit node;

    public PostCallStmtInfo(@NotNull IStmt stmt, @NotNull Unit node) {
        super(stmt);
        if (node == null) throw new IllegalArgumentException("node cannot be null");
        this.node = node;
    }

    @NotNull
    public Unit getNode() {
        return node;
    }

    @Nullable
    public Object getParameterNameByIndex(@NotNull MLocal index, @NotNull Function<Object, Boolean> filter) {
        if (index == null) throw new IllegalArgumentException("index cannot be null");
        if (filter == null) throw new IllegalArgumentException("filter cannot be null");

        if (index instanceof MParameter) {
            Value value = getParameterNameByIndex(((MParameter) index).getIndex());
            if (value != null && filter.apply(value)) {
                if (getFirstParamIndex() == null) {
                    setFirstParamIndex(((MParameter) index).getIndex());
                }
                return value;
            }
            return null;
        } else if (index instanceof MReturn) {
            if (node instanceof DefinitionStmt) {
                Value leftOp = ((DefinitionStmt) node).getLeftOp();
                return leftOp != null && filter.apply(leftOp) ? leftOp : null;
            }
            return null;
        } else {
            return filter.apply(index) ? index : null;
        }
    }

    @Nullable
    public Value getParameterNameByIndex(int index) {
        if (!(node instanceof Stmt stmt) || !stmt.containsInvokeExpr()) {
            return null;
        }

        InvokeExpr invokeExpr = stmt.getInvokeExpr();
        List<Value> args = invokeExpr.getArgs();

        if (index == -1 && invokeExpr instanceof InstanceInvokeExpr) {
            return ((InstanceInvokeExpr) invokeExpr).getBase();
        }

        if (index >= 0 && index < args.size()) {
            return args.get(index);
        }

        return null;
    }
}