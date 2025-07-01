package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.ExecutableQuery;
import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public final class AbsoluteFilePathQueries extends TransacterImpl {

    public AbsoluteFilePathQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_absolute_file_path(@NotNull BiFunction<String, Long, T> mapper) {
        return new Verify_absolute_file_pathQuery(this, cursor -> {
            String filePath = cursor.getString(0);
            long fileId = cursor.getLong(1);
            return mapper.apply(filePath, fileId);
        });
    }

    @NotNull
    public final ExecutableQuery<AbsoluteFilePath> verify_absolute_file_path() {
        return verify_absolute_file_path(AbsoluteFilePath::new);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull BiFunction<String, Long, T> mapper) {
        String[] tables = {"AbsoluteFilePath"};
        return QueryKt.Query(
            77310330,
            tables,
            getDriver(),
            "AbsoluteFilePath.sq",
            "selectAll",
            "SELECT AbsoluteFilePath.file_abs_path, AbsoluteFilePath.__file_id\nFROM AbsoluteFilePath",
            cursor -> {
                String filePath = cursor.getString(0);
                long fileId = cursor.getLong(1);
                return mapper.apply(filePath, fileId);
            }
        );
    }

    @NotNull
    public final Query<AbsoluteFilePath> selectAll() {
        return selectAll(AbsoluteFilePath::new);
    }

    public final void insert(@NotNull AbsoluteFilePath absoluteFilePath) {
        getDriver().execute(
            365662308,
            "INSERT OR IGNORE INTO AbsoluteFilePath (file_abs_path, __file_id) VALUES (?, ?)",
            2,
            stmt -> {
                stmt.bindString(0, absoluteFilePath.getFile_abs_path());
                stmt.bindLong(1, absoluteFilePath.get__file_id());
                return null;
            }
        );
        notifyQueries(365662308, emit -> emit.accept("AbsoluteFilePath"));
    }

    private static final class Verify_absolute_file_pathQuery<T> implements ExecutableQuery<T> {
        private final AbsoluteFilePathQueries queries;
        private final java.util.function.Function<SqlCursor, T> mapper;

        Verify_absolute_file_pathQuery(AbsoluteFilePathQueries queries, java.util.function.Function<SqlCursor, T> mapper) {
            this.queries = queries;
            this.mapper = mapper;
        }

        @Override
        public T execute() {
            try (SqlCursor cursor = queries.getDriver().executeQuery(null, "SELECT file_abs_path, __file_id FROM AbsoluteFilePath", null, 0, null)) {
                return mapper.apply(cursor);
            }
        }
    }
}