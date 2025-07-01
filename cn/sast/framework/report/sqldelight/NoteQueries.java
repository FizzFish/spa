package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.ExecutableQuery;
import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.TransactionWithoutReturn;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import cn.sast.framework.report.sqldelight.Note;
import cn.sast.framework.report.sqldelight.note.Verify_file;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiFunction;
import java.util.function.Function;

public final class NoteQueries extends TransacterImpl {

    public NoteQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public final ExecutableQuery<Long> id(
        @NotNull String kind,
        @NotNull String displayHint,
        long fileId,
        @NotNull String fileAbsPath,
        long line,
        @Nullable Long column,
        @NotNull String messageEn,
        @NotNull String messageZh,
        @Nullable Long noticesRegionId,
        @Nullable Long funcRegionId
    ) {
        return new IdQuery(this, kind, displayHint, fileId, fileAbsPath, line, column, messageEn, messageZh, noticesRegionId, funcRegionId, cursor -> {
            Long id = cursor.getLong(0);
            if (id == null) throw new IllegalStateException("id cannot be null");
            return id;
        });
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_file(@NotNull BiFunction<Long, Long, T> mapper) {
        return new Verify_fileQuery(this, cursor -> {
            Long id = cursor.getLong(0);
            Long fileId = cursor.getLong(1);
            if (id == null || fileId == null) throw new IllegalStateException("id and fileId cannot be null");
            return mapper.apply(id, fileId);
        });
    }

    @NotNull
    public final ExecutableQuery<Verify_file> verify_file() {
        return verify_file(Verify_file::new);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull NoteMapper<T> mapper) {
        String[] tables = {"Note"};
        return QueryKt.Query(
            1298079392,
            tables,
            getDriver(),
            "Note.sq",
            "selectAll",
            "SELECT Note.id, Note.kind, Note.display_hint, Note.__file_id, Note._file_abs_path, Note.line, Note.column, Note.message_en, Note.message_zh, Note.__notices_region_id, Note.__func_region_id\nFROM Note",
            cursor -> {
                Long id = requireNonNull(cursor.getLong(0), fileId = requireNonNull(cursor.getLong(3)), line = requireNonNull(cursor.getLong(5));
                return mapper.map(
                    id,
                    requireNonNull(cursor.getString(1)),
                    requireNonNull(cursor.getString(2)),
                    fileId,
                    requireNonNull(cursor.getString(4)),
                    line,
                    cursor.getLong(6),
                    requireNonNull(cursor.getString(7)),
                    requireNonNull(cursor.getString(8)),
                    cursor.getLong(9),
                    cursor.getLong(10)
                );
            }
        );
    }

    @NotNull
    public final Query<Note> selectAll() {
        return selectAll(Note::new);
    }

    public final void insert(
        @NotNull String kind,
        @NotNull String displayHint,
        long fileId,
        @NotNull String fileAbsPath,
        long line,
        @Nullable Long column,
        @NotNull String messageEn,
        @NotNull String messageZh,
        @Nullable Long noticesRegionId,
        @Nullable Long funcRegionId
    ) {
        transaction(false, transaction -> {
            getDriver().execute(
                -1993383633,
                "INSERT OR IGNORE INTO Note(kind, display_hint, __file_id, _file_abs_path, line, column, message_en, message_zh, __notices_region_id, __func_region_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                10,
                stmt -> {
                    stmt.bindString(0, kind);
                    stmt.bindString(1, displayHint);
                    stmt.bindLong(2, fileId);
                    stmt.bindString(3, fileAbsPath);
                    stmt.bindLong(4, line);
                    stmt.bindLong(5, column);
                    stmt.bindString(6, messageEn);
                    stmt.bindString(7, messageZh);
                    stmt.bindLong(8, noticesRegionId);
                    stmt.bindLong(9, funcRegionId);
                }
            );
            return null;
        });
        notifyQueries(-681403138, emit -> emit.accept("Note"));
    }

    private static <T> T requireNonNull(T obj) {
        if (obj == null) throw new IllegalStateException("Required value was null");
        return obj;
    }

    public interface NoteMapper<T> {
        T map(
            long id,
            String kind,
            String displayHint,
            long fileId,
            String fileAbsPath,
            long line,
            Long column,
            String messageEn,
            String messageZh,
            Long noticesRegionId,
            Long funcRegionId
        );
    }

    private static final class IdQuery extends ExecutableQuery<Long> {
        // Implementation omitted for brevity
    }

    private static final class Verify_fileQuery<T> extends ExecutableQuery<T> {
        // Implementation omitted for brevity
    }
}