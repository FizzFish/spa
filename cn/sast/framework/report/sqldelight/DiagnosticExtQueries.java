package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class DiagnosticExtQueries extends TransacterImpl {
    public DiagnosticExtQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function3<Long, String, String, T> mapper) {
        String[] stringArray = new String[]{"DiagnosticExt"};
        return QueryKt.Query(900870786, stringArray, this.getDriver(), "DiagnosticExt.sq", "selectAll", 
            "SELECT DiagnosticExt.__diagnostic_id, DiagnosticExt.attr_name, DiagnosticExt.attr_value\nFROM DiagnosticExt", 
            cursor -> {
                Long id = cursor.getLong(0);
                String name = cursor.getString(1);
                String value = cursor.getString(2);
                return mapper.apply(id, name, value);
            });
    }

    @NotNull
    public final Query<DiagnosticExt> selectAll() {
        return this.selectAll(DiagnosticExt::new);
    }

    public final void insert(@NotNull DiagnosticExt diagnosticExt) {
        this.getDriver().execute(-356457380, 
            "INSERT OR IGNORE INTO DiagnosticExt (__diagnostic_id, attr_name, attr_value)\nVALUES (?, ?, ?)", 
            3, 
            stmt -> {
                stmt.bindLong(0, diagnosticExt.get__diagnostic_id());
                stmt.bindString(1, diagnosticExt.getAttr_name());
                stmt.bindString(2, diagnosticExt.getAttr_value());
                return null;
            });
        this.notifyQueries(-356457380, emit -> {
            emit.accept("DiagnosticExt");
            return null;
        });
    }

    @FunctionalInterface
    public interface Function3<A, B, C, R> {
        R apply(A a, B b, C c);
    }
}