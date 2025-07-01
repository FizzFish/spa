package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class NoteExtQueries extends TransacterImpl {
    public NoteExtQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public <T> Query<T> selectAll(@NotNull Function3<Long, String, String, T> mapper) {
        String[] stringArray = new String[]{"NoteExt"};
        return QueryKt.Query(313069709, stringArray, this.getDriver(), "NoteExt.sq", 
            "selectAll", 
            "SELECT NoteExt.__note_id, NoteExt.attr_name, NoteExt.attr_value\nFROM NoteExt", 
            cursor -> {
                Long l = cursor.getLong(0);
                String name = cursor.getString(1);
                String value = cursor.getString(2);
                return mapper.apply(l, name, value);
            });
    }

    @NotNull
    public Query<NoteExt> selectAll() {
        return this.selectAll(NoteExt::new);
    }

    public void insert(@NotNull NoteExt noteExt) {
        this.getDriver().execute(-1109476815, 
            "INSERT OR IGNORE INTO NoteExt (__note_id, attr_name, attr_value)\nVALUES (?, ?, ?)", 
            3, 
            stmt -> {
                stmt.bindLong(0, noteExt.get__note_id());
                stmt.bindString(1, noteExt.getAttr_name());
                stmt.bindString(2, noteExt.getAttr_value());
                return null;
            });
        this.notifyQueries(-1109476815, emit -> {
            emit.accept("NoteExt");
            return null;
        });
    }

    @FunctionalInterface
    public interface Function3<A, B, C, R> {
        R apply(A a, B b, C c);
    }
}
