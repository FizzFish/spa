package cn.sast.dataflow.interprocedural.check;

import com.feysh.corax.config.api.IModelStmtVisitor;
import com.feysh.corax.config.api.IStmt;
import com.feysh.corax.config.api.MLocal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Local;
import soot.Unit;
import soot.ValueBox;
import soot.jimple.Constant;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class ModelingStmtInfo {
    @NotNull
    private final IStmt stmt;
    @Nullable
    private Integer firstParamIndex;

    public ModelingStmtInfo(@NotNull IStmt stmt) {
        if (stmt == null) {
            throw new IllegalArgumentException("stmt cannot be null");
        }
        this.stmt = stmt;
    }

    @NotNull
    public final IStmt getStmt() {
        return stmt;
    }

    @Nullable
    public final Integer getFirstParamIndex() {
        return firstParamIndex;
    }

    public final void setFirstParamIndex(@Nullable Integer firstParamIndex) {
        this.firstParamIndex = firstParamIndex;
    }

    @Nullable
    public abstract Object getParameterNameByIndex(int index);

    @Nullable
    public abstract Object getParameterNameByIndex(@NotNull MLocal index, @NotNull Function<Object, Boolean> filter);

    @NotNull
    public final List<Object> getParameterNamesInUnitDefUse(@NotNull Unit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("unit cannot be null");
        }
        
        Set<Object> useDef = unit.getUseAndDefBoxes().stream()
                .map(ValueBox::getValue)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        
        return getParameterNames(it -> {
            if (it == null) {
                throw new IllegalArgumentException("it cannot be null");
            }
            return it instanceof Local ? useDef.contains(it) : !(it instanceof Constant);
        });
    }

    @NotNull
    public final List<Object> getParameterNames(@NotNull Function<Object, Boolean> filter) {
        if (filter == null) {
            throw new IllegalArgumentException("filter cannot be null");
        }
        
        ParameterNameVisitor visitor = new ParameterNameVisitor(filter);
        stmt.accept(visitor);
        
        return visitor.getResult().stream()
                .sorted(Comparator.comparingInt(this::getParameterIndex))
                .collect(Collectors.toList());
    }

    private static class ParameterNameVisitor implements IModelStmtVisitor {
        private final Function<Object, Boolean> filter;
        private final List<Object> result = new ArrayList<>();

        public ParameterNameVisitor(Function<Object, Boolean> filter) {
            this.filter = filter;
        }

        @Override
        public void visit(IStmt stmt) {
            // Implementation depends on actual IModelStmtVisitor interface
        }

        public List<Object> getResult() {
            return result;
        }
    }

    private int getParameterIndex(Object param) {
        // Implementation depends on how parameter indices are determined
        return 0;
    }
}
