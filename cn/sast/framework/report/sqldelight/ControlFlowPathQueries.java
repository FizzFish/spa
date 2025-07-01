package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.ExecutableQuery;
import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class ControlFlowPathQueries extends TransacterImpl {

    public ControlFlowPathQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_control_flow(@NotNull TriFunction<Long, Long, Long, T> mapper) {
        return new VerifyControlFlowQuery(this, cursor -> {
            Long hashId = cursor.getLong(0);
            Long sequence = cursor.getLong(1);
            Long flowId = cursor.getLong(2);
            return mapper.apply(hashId, sequence, flowId);
        });
    }

    @NotNull
    public final ExecutableQuery<ControlFlowPath> verify_control_flow() {
        return verify_control_flow(ControlFlowPath::new);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull TriFunction<Long, Long, Long, T> mapper) {
        String[] tables = {"ControlFlowPath"};
        return QueryKt.Query(
            -180228340,
            tables,
            getDriver(),
            "ControlFlowPath.sq",
            "selectAll",
            "SELECT ControlFlowPath.__control_flow_array_hash_id, ControlFlowPath.control_flow_sequence, ControlFlowPath.__control_flow_id\nFROM ControlFlowPath",
            cursor -> {
                Long hashId = cursor.getLong(0);
                Long sequence = cursor.getLong(1);
                Long flowId = cursor.getLong(2);
                return mapper.apply(hashId, sequence, flowId);
            }
        );
    }

    @NotNull
    public final Query<ControlFlowPath> selectAll() {
        return selectAll(ControlFlowPath::new);
    }

    public final void insert(@NotNull ControlFlowPath controlFlowPath) {
        getDriver().execute(
            -947157998,
            "INSERT OR IGNORE INTO ControlFlowPath (__control_flow_array_hash_id, control_flow_sequence, __control_flow_id)\nVALUES (?, ?, ?)",
            3,
            stmt -> {
                stmt.bindLong(0, controlFlowPath.get__control_flow_array_hash_id());
                stmt.bindLong(1, controlFlowPath.getControl_flow_sequence());
                stmt.bindLong(2, controlFlowPath.get__control_flow_id());
                return null;
            }
        );
        notifyQueries(-947157998, emit -> {
            emit.accept("ControlFlowPath");
            return null;
        });
    }

    private static final class VerifyControlFlowQuery<T> implements ExecutableQuery<T> {
        private final ControlFlowPathQueries parent;
        private final Function<SqlCursor, T> mapper;

        VerifyControlFlowQuery(ControlFlowPathQueries parent, Function<SqlCursor, T> mapper) {
            this.parent = parent;
            this.mapper = mapper;
        }

        @Override
        public T execute() {
            // Implementation would go here
            return null;
        }
    }

    @FunctionalInterface
    public interface TriFunction<A, B, C, R> {
        R apply(A a, B b, C c);
    }
}