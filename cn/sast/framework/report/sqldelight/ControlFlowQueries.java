package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.ExecutableQuery;
import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import cn.sast.framework.report.sqldelight.controlFlow.Verify_file;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiFunction;
import java.util.function.Function;

public final class ControlFlowQueries extends TransacterImpl {
    public ControlFlowQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public final ExecutableQuery<Long> id(long __file_id, @NotNull String _file_abs_path, 
            @Nullable String message_en, @Nullable String message_zh, 
            long __edge_from_region_id, long __edge_to_region_id) {
        return new IdQuery(this, __file_id, _file_abs_path, message_en, message_zh, 
                __edge_from_region_id, __edge_to_region_id, cursor -> cursor.getLong(0));
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_file(@NotNull BiFunction<Long, Long, T> mapper) {
        return new Verify_fileQuery(this, cursor -> 
                mapper.apply(cursor.getLong(0), cursor.getLong(1)));
    }

    @NotNull
    public final ExecutableQuery<Verify_file> verify_file() {
        return verify_file(Verify_file::new);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function7<Long, Long, String, String, String, Long, Long, T> mapper) {
        return QueryKt.Query(590154801, new String[]{"ControlFlow"}, getDriver(), 
                "ControlFlow.sq", "selectAll", 
                "SELECT ControlFlow.id, ControlFlow.__file_id, ControlFlow._file_abs_path, " +
                "ControlFlow.message_en, ControlFlow.message_zh, ControlFlow.__edge_from_region_id, " +
                "ControlFlow.__edge_to_region_id FROM ControlFlow",
                cursor -> mapper.apply(
                        cursor.getLong(0),
                        cursor.getLong(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getLong(5),
                        cursor.getLong(6)));
    }

    @NotNull
    public final Query<ControlFlow> selectAll() {
        return selectAll(ControlFlow::new);
    }

    public final void insert(long __file_id, @NotNull String _file_abs_path, 
            @Nullable String message_en, @Nullable String message_zh, 
            long __edge_from_region_id, long __edge_to_region_id) {
        transaction(false, tx -> {
            getDriver().execute(-1877672578, 
                    "INSERT OR IGNORE INTO ControlFlow(__file_id, _file_abs_path, message_en, " +
                    "message_zh, __edge_from_region_id, __edge_to_region_id) VALUES (?, ?, ?, ?, ?, ?)", 
                    6, stmt -> {
                        stmt.bindLong(0, __file_id);
                        stmt.bindString(1, _file_abs_path);
                        stmt.bindString(2, message_en);
                        stmt.bindString(3, message_zh);
                        stmt.bindLong(4, __edge_from_region_id);
                        stmt.bindLong(5, __edge_to_region_id);
                        return null;
                    });
            return null;
        });
        notifyQueries(1615921421, emit -> {
            emit.accept("ControlFlow");
            return null;
        });
    }

    private static final class IdQuery extends ExecutableQuery<Long> {
        private final long __file_id;
        private final String _file_abs_path;
        private final String message_en;
        private final String message_zh;
        private final long __edge_from_region_id;
        private final long __edge_to_region_id;

        IdQuery(ControlFlowQueries queries, long __file_id, String _file_abs_path, 
                String message_en, String message_zh, 
                long __edge_from_region_id, long __edge_to_region_id, 
                Function<SqlCursor, Long> mapper) {
            super(queries.getDriver(), "ControlFlow.sq", "id", mapper);
            this.__file_id = __file_id;
            this._file_abs_path = _file_abs_path;
            this.message_en = message_en;
            this.message_zh = message_zh;
            this.__edge_from_region_id = __edge_from_region_id;
            this.__edge_to_region_id = __edge_to_region_id;
        }
    }

    private static final class Verify_fileQuery<T> extends ExecutableQuery<T> {
        Verify_fileQuery(ControlFlowQueries queries, Function<SqlCursor, T> mapper) {
            super(queries.getDriver(), "ControlFlow.sq", "verify_file", mapper);
        }
    }

    @FunctionalInterface
    public interface Function7<A, B, C, D, E, F, G, R> {
        R apply(A a, B b, C c, D d, E e, F f, G g);
    }
}