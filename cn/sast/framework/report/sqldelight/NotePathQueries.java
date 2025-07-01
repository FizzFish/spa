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

public final class NotePathQueries extends TransacterImpl {
    private static final int VERIFY_NOTE_QUERY_ID = -1170787845;
    private static final int INSERT_QUERY_ID = -476332157;

    public NotePathQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public <T> ExecutableQuery<T> verify_note(@NotNull Function5<Long, Long, Long, Long, Long, T> mapper) {
        return new VerifyNoteQuery<>(this, cursor -> {
            Long hashId = cursor.getLong(0);
            Long sequence = cursor.getLong(1);
            Long stackDepth = cursor.getLong(2);
            Long isKeyEvent = cursor.getLong(3);
            Long noteId = cursor.getLong(4);
            return mapper.apply(hashId, sequence, stackDepth, isKeyEvent, noteId);
        });
    }

    @NotNull
    public ExecutableQuery<NotePath> verify_note() {
        return verify_note(NotePath::new);
    }

    @NotNull
    public <T> Query<T> selectAll(@NotNull Function5<Long, Long, Long, Long, Long, T> mapper) {
        return QueryKt.Query(
            VERIFY_NOTE_QUERY_ID,
            new String[]{"NotePath"},
            getDriver(),
            "NotePath.sq",
            "selectAll",
            "SELECT NotePath.__note_array_hash_id, NotePath.note_sequence, NotePath.note_stack_depth, " +
                "NotePath.note_is_key_event, NotePath.__note_id FROM NotePath",
            cursor -> {
                Long hashId = cursor.getLong(0);
                Long sequence = cursor.getLong(1);
                Long stackDepth = cursor.getLong(2);
                Long isKeyEvent = cursor.getLong(3);
                Long noteId = cursor.getLong(4);
                return mapper.apply(hashId, sequence, stackDepth, isKeyEvent, noteId);
            }
        );
    }

    @NotNull
    public Query<NotePath> selectAll() {
        return selectAll(NotePath::new);
    }

    public void insert(@NotNull NotePath notePath) {
        getDriver().execute(
            INSERT_QUERY_ID,
            "INSERT OR IGNORE INTO NotePath (__note_array_hash_id, note_sequence, " +
                "note_stack_depth, note_is_key_event, __note_id) VALUES (?, ?, ?, ?, ?)",
            5,
            stmt -> {
                stmt.bindLong(0, notePath.get__note_array_hash_id());
                stmt.bindLong(1, notePath.getNote_sequence());
                stmt.bindLong(2, notePath.getNote_stack_depth());
                stmt.bindLong(3, notePath.getNote_is_key_event());
                stmt.bindLong(4, notePath.get__note_id());
                return null;
            }
        );
        notifyQueries(INSERT_QUERY_ID, emit -> {
            emit.accept("NotePath");
            return null;
        });
    }

    @FunctionalInterface
    public interface Function5<A, B, C, D, E, R> {
        R apply(A a, B b, C c, D d, E e);
    }

    private static final class VerifyNoteQuery<T> implements ExecutableQuery<T> {
        private final NotePathQueries queries;
        private final Function<SqlCursor, T> mapper;

        VerifyNoteQuery(NotePathQueries queries, Function<SqlCursor, T> mapper) {
            this.queries = queries;
            this.mapper = mapper;
        }

        @Override
        public T execute() {
            try (SqlCursor cursor = queries.getDriver().executeQuery(
                NotePathQueries.VERIFY_NOTE_QUERY_ID,
                "SELECT __note_array_hash_id, note_sequence, note_stack_depth, " +
                    "note_is_key_event, __note_id FROM NotePath",
                0
            )) {
                return cursor.next() ? mapper.apply(cursor) : null;
            }
        }
    }
}