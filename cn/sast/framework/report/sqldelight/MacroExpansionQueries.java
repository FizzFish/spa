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

public final class MacroExpansionQueries extends TransacterImpl {
    public MacroExpansionQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_note(@NotNull BiFunction<Long, Long, T> mapper) {
        return new Verify_noteQuery(this, cursor -> {
            Long hashId = cursor.getLong(0);
            Long noteId = cursor.getLong(1);
            return mapper.apply(hashId, noteId);
        });
    }

    @NotNull
    public final ExecutableQuery<MacroExpansion> verify_note() {
        return this.verify_note(MacroExpansion::new);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull BiFunction<Long, Long, T> mapper) {
        String[] tables = {"MacroExpansion"};
        return QueryKt.Query(1160581151, tables, this.getDriver(), "MacroExpansion.sq", 
            "selectAll", "SELECT MacroExpansion.__macro_note_set_hash_id, MacroExpansion.__macro_note_id\nFROM MacroExpansion", 
            cursor -> {
                Long hashId = cursor.getLong(0);
                Long noteId = cursor.getLong(1);
                return mapper.apply(hashId, noteId);
            });
    }

    @NotNull
    public final Query<MacroExpansion> selectAll() {
        return this.selectAll(MacroExpansion::new);
    }

    public final void insert(@NotNull MacroExpansion macroExpansion) {
        this.getDriver().execute(-1356123169, 
            "INSERT OR IGNORE INTO MacroExpansion (__macro_note_set_hash_id, __macro_note_id)\nVALUES (?, ?)", 
            2, stmt -> {
                stmt.bindLong(0, macroExpansion.get__macro_note_set_hash_id());
                stmt.bindLong(1, macroExpansion.get__macro_note_id());
                return null;
            });
        
        this.notifyQueries(-1356123169, emit -> {
            emit.accept("MacroExpansion");
            return null;
        });
    }

    private static final class Verify_noteQuery<T> implements ExecutableQuery<T> {
        private final MacroExpansionQueries queries;
        private final java.util.function.Function<SqlCursor, T> mapper;

        Verify_noteQuery(MacroExpansionQueries queries, java.util.function.Function<SqlCursor, T> mapper) {
            this.queries = queries;
            this.mapper = mapper;
        }

        @Override
        public T execute() {
            SqlCursor cursor = queries.getDriver().executeQuery(-1, "SELECT __macro_note_set_hash_id, __macro_note_id FROM MacroExpansion", 0, null);
            try {
                return mapper.apply(cursor);
            } finally {
                cursor.close();
            }
        }
    }
}