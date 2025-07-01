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

public final class AnalyzeResultFileQueries extends TransacterImpl {

    public AnalyzeResultFileQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_file(@NotNull Function3<String, String, Long, T> mapper) {
        return new Verify_fileQuery(this, cursor -> {
            String fileName = cursor.getString(0);
            String filePath = cursor.getString(1);
            long fileId = cursor.getLong(2);
            return mapper.apply(fileName, filePath, fileId);
        });
    }

    @NotNull
    public final ExecutableQuery<AnalyzerResultFile> verify_file() {
        return verify_file(AnalyzerResultFile::new);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function3<String, String, Long, T> mapper) {
        return QueryKt.Query(
            1331798327,
            new String[]{"AnalyzerResultFile"},
            getDriver(),
            "AnalyzeResultFile.sq",
            "selectAll",
            "SELECT AnalyzerResultFile.file_name, AnalyzerResultFile.file_path, AnalyzerResultFile.__file_id\nFROM AnalyzerResultFile",
            cursor -> {
                String fileName = cursor.getString(0);
                String filePath = cursor.getString(1);
                long fileId = cursor.getLong(2);
                return mapper.apply(fileName, filePath, fileId);
            }
        );
    }

    @NotNull
    public final Query<AnalyzerResultFile> selectAll() {
        return selectAll(AnalyzerResultFile::new);
    }

    public final void insert(@NotNull AnalyzerResultFile analyzerResultFile) {
        getDriver().execute(
            397277639,
            "INSERT OR IGNORE INTO AnalyzerResultFile (file_name, file_path, __file_id)\nVALUES (?, ?, ?)",
            3,
            stmt -> {
                stmt.bindString(0, analyzerResultFile.getFile_name());
                stmt.bindString(1, analyzerResultFile.getFile_path());
                stmt.bindLong(2, analyzerResultFile.get__file_id());
                return null;
            }
        );
        notifyQueries(397277639, emit -> {
            emit.accept("AnalyzerResultFile");
            return null;
        });
    }

    @FunctionalInterface
    public interface Function3<A, B, C, R> {
        R apply(A a, B b, C c);
    }

    private static final class Verify_fileQuery<T> implements ExecutableQuery<T> {
        private final AnalyzeResultFileQueries parent;
        private final Function<SqlCursor, T> mapper;

        Verify_fileQuery(AnalyzeResultFileQueries parent, Function<SqlCursor, T> mapper) {
            this.parent = parent;
            this.mapper = mapper;
        }

        @Override
        public T execute() {
            try (SqlCursor cursor = parent.getDriver().executeQuery(null, "SELECT * FROM AnalyzerResultFile", null, 0)) {
                return mapper.apply(cursor);
            }
        }
    }
}