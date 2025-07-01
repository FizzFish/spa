package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.ExecutableQuery;
import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.TransactionWithoutReturn;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import cn.sast.framework.report.sqldelight.Diagnostic;
import cn.sast.framework.report.sqldelight.Verify_control_flow_path;
import cn.sast.framework.report.sqldelight.Verify_macro;
import cn.sast.framework.report.sqldelight.Verify_note_path;
import cn.sast.framework.report.sqldelight.Verify_rule_name;
import cn.sast.framework.report.sqldelight.diagnostic.Verify_file;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiFunction;
import java.util.function.Function;

public final class DiagnosticQueries extends TransacterImpl {
    public DiagnosticQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public final ExecutableQuery<Long> id(@NotNull String rule_name, @Nullable String _rule_short_description_zh, 
            @Nullable Long __file_id, @NotNull String _file_abs_path, @Nullable String severity, 
            @Nullable String precision, @Nullable String likelihood, @Nullable String impact, 
            @Nullable String technique, @Nullable String analysis_scope, @Nullable String line_content, 
            long __note_array_hash_id, @Nullable Long __control_flow_array_hash_id, 
            @Nullable Long __macro_note_set_hash_id) {
        return new IdQuery(this, rule_name, _rule_short_description_zh, __file_id, _file_abs_path, 
                severity, precision, likelihood, impact, technique, analysis_scope, line_content, 
                __note_array_hash_id, __control_flow_array_hash_id, __macro_note_set_hash_id, 
                cursor -> cursor.getLong(0));
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_rule_name(@NotNull BiFunction<Long, String, T> mapper) {
        return new Verify_rule_nameQuery(this, cursor -> mapper.apply(cursor.getLong(0), cursor.getString(1)));
    }

    @NotNull
    public final ExecutableQuery<Verify_rule_name> verify_rule_name() {
        return verify_rule_name(Verify_rule_name::new);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_file(@NotNull BiFunction<Long, Long, T> mapper) {
        return new Verify_fileQuery(this, cursor -> mapper.apply(cursor.getLong(0), cursor.getLong(1));
    }

    @NotNull
    public final ExecutableQuery<Verify_file> verify_file() {
        return verify_file(Verify_file::new);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_note_path(@NotNull BiFunction<Long, Long, T> mapper) {
        return new Verify_note_pathQuery(this, cursor -> mapper.apply(cursor.getLong(0), cursor.getLong(1)));
    }

    @NotNull
    public final ExecutableQuery<Verify_note_path> verify_note_path() {
        return verify_note_path(Verify_note_path::new);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_control_flow_path(@NotNull BiFunction<Long, Long, T> mapper) {
        return new Verify_control_flow_pathQuery(this, cursor -> mapper.apply(cursor.getLong(0), cursor.getLong(1)));
    }

    @NotNull
    public final ExecutableQuery<Verify_control_flow_path> verify_control_flow_path() {
        return verify_control_flow_path(Verify_control_flow_path::new);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_macro(@NotNull BiFunction<Long, Long, T> mapper) {
        return new Verify_macroQuery(this, cursor -> mapper.apply(cursor.getLong(0), cursor.getLong(1)));
    }

    @NotNull
    public final ExecutableQuery<Verify_macro> verify_macro() {
        return verify_macro(Verify_macro::new);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function19<Long, String, String, Long, String, Long, Long, 
            String, String, String, String, String, String, String, String, String, Long, Long, Long, T> mapper) {
        return QueryKt.Query(2051098827, new String[]{"Diagnostic"}, this.getDriver(), "Diagnostic.sq", 
                "selectAll", "SELECT Diagnostic.id, Diagnostic.rule_name, Diagnostic._rule_short_description_zh, " +
                "Diagnostic.__file_id, Diagnostic._file_abs_path, Diagnostic._line, Diagnostic._column, " +
                "Diagnostic._message_en, Diagnostic._message_zh, Diagnostic.severity, Diagnostic.precision, " +
                "Diagnostic.likelihood, Diagnostic.impact, Diagnostic.technique, Diagnostic.analysis_scope, " +
                "Diagnostic.line_content, Diagnostic.__note_array_hash_id, Diagnostic.__control_flow_array_hash_id, " +
                "Diagnostic.__macro_note_set_hash_id FROM Diagnostic", 
                cursor -> mapper.apply(cursor.getLong(0), cursor.getString(1), cursor.getString(2), 
                        cursor.getLong(3), cursor.getString(4), cursor.getLong(5), cursor.getLong(6), 
                        cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), 
                        cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), 
                        cursor.getString(15), cursor.getLong(16), cursor.getLong(17), cursor.getLong(18)));
    }

    @NotNull
    public final Query<Diagnostic> selectAll() {
        return selectAll(Diagnostic::new);
    }

    public final void insert(@NotNull String rule_name, @Nullable String _rule_short_description_zh, 
            @Nullable Long __file_id, @NotNull String _file_abs_path, long _line, long _column, 
            @NotNull String _message_en, @NotNull String _message_zh, @Nullable String severity, 
            @Nullable String precision, @Nullable String likelihood, @Nullable String impact, 
            @Nullable String technique, @Nullable String analysis_scope, @Nullable String line_content, 
            long __note_array_hash_id, @Nullable Long __control_flow_array_hash_id, 
            @Nullable Long __macro_note_set_hash_id) {
        transaction(false, transaction -> {
            getDriver().execute(1771685284, 
                    "INSERT OR IGNORE INTO Diagnostic(rule_name, _rule_short_description_zh, " +
                    "__file_id, _file_abs_path, _line, _column, _message_en, _message_zh, " +
                    "severity, precision, likelihood, impact, technique, analysis_scope, " +
                    "line_content, __note_array_hash_id, __control_flow_array_hash_id, __macro_note_set_hash_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
                    18, statement -> {
                        statement.bindString(0, rule_name);
                        statement.bindString(1, _rule_short_description_zh);
                        statement.bindLong(2, __file_id);
                        statement.bindString(3, _file_abs_path);
                        statement.bindLong(4, _line);
                        statement.bindLong(5, _column);
                        statement.bindString(6, _message_en);
                        statement.bindString(7, _message_zh);
                        statement.bindString(8, severity);
                        statement.bindString(9, precision);
                        statement.bindString(10, likelihood);
                        statement.bindString(11, impact);
                        statement.bindString(12, technique);
                        statement.bindString(13, analysis_scope);
                        statement.bindString(14, line_content);
                        statement.bindLong(15, __note_array_hash_id);
                        statement.bindLong(16, __control_flow_array_hash_id);
                        statement.bindLong(17, __macro_note_set_hash_id);
                        return null;
                    });
            return null;
        });
        notifyQueries(949328563, emit -> {
            emit.accept("Diagnostic");
            return null;
        });
    }
}
