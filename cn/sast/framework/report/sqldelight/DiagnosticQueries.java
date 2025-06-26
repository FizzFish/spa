/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.ExecutableQuery
 *  app.cash.sqldelight.Query
 *  app.cash.sqldelight.QueryKt
 *  app.cash.sqldelight.Transacter
 *  app.cash.sqldelight.Transacter$DefaultImpls
 *  app.cash.sqldelight.TransacterImpl
 *  app.cash.sqldelight.TransactionWithoutReturn
 *  app.cash.sqldelight.db.SqlCursor
 *  app.cash.sqldelight.db.SqlDriver
 *  app.cash.sqldelight.db.SqlPreparedStatement
 *  cn.sast.framework.report.sqldelight.Diagnostic
 *  cn.sast.framework.report.sqldelight.DiagnosticQueries
 *  cn.sast.framework.report.sqldelight.DiagnosticQueries$IdQuery
 *  cn.sast.framework.report.sqldelight.DiagnosticQueries$Verify_control_flow_pathQuery
 *  cn.sast.framework.report.sqldelight.DiagnosticQueries$Verify_fileQuery
 *  cn.sast.framework.report.sqldelight.DiagnosticQueries$Verify_macroQuery
 *  cn.sast.framework.report.sqldelight.DiagnosticQueries$Verify_note_pathQuery
 *  cn.sast.framework.report.sqldelight.DiagnosticQueries$Verify_rule_nameQuery
 *  cn.sast.framework.report.sqldelight.Verify_control_flow_path
 *  cn.sast.framework.report.sqldelight.Verify_macro
 *  cn.sast.framework.report.sqldelight.Verify_note_path
 *  cn.sast.framework.report.sqldelight.Verify_rule_name
 *  cn.sast.framework.report.sqldelight.diagnostic.Verify_file
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function19
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
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
import cn.sast.framework.report.sqldelight.Diagnostic;
import cn.sast.framework.report.sqldelight.DiagnosticQueries;
import cn.sast.framework.report.sqldelight.Verify_control_flow_path;
import cn.sast.framework.report.sqldelight.Verify_macro;
import cn.sast.framework.report.sqldelight.Verify_note_path;
import cn.sast.framework.report.sqldelight.Verify_rule_name;
import cn.sast.framework.report.sqldelight.diagnostic.Verify_file;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0006456789B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0097\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0018JN\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0007\"\b\b\u0000\u0010\u001a*\u00020\u001b26\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\t\u0012\u0004\u0012\u0002H\u001a0\u001dJ\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020 0\u0007JP\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0007\"\b\b\u0000\u0010\u001a*\u00020\u001b28\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u001a0\u001dJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0007JN\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0007\"\b\b\u0000\u0010\u001a*\u00020\u001b26\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u0002H\u001a0\u001dJ\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0007JN\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0007\"\b\b\u0000\u0010\u001a*\u00020\u001b26\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u0002H\u001a0\u001dJ\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0007JN\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0007\"\b\b\u0000\u0010\u001a*\u00020\u001b26\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u001a0\u001dJ\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0007J\u00cb\u0003\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u001a0*\"\b\b\u0000\u0010\u001a*\u00020\u001b2\u00b2\u0003\u0010\u001c\u001a\u00ad\u0003\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u001a0+J\f\u0010)\u001a\b\u0012\u0004\u0012\u0002000*J\u00b1\u0001\u00101\u001a\u0002022\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u00103\u00a8\u0006:"}, d2={"Lcn/sast/framework/report/sqldelight/DiagnosticQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "id", "Lapp/cash/sqldelight/ExecutableQuery;", "", "rule_name", "", "_rule_short_description_zh", "__file_id", "_file_abs_path", "severity", "precision", "likelihood", "impact", "technique", "analysis_scope", "line_content", "__note_array_hash_id", "__control_flow_array_hash_id", "__macro_note_set_hash_id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;)Lapp/cash/sqldelight/ExecutableQuery;", "verify_rule_name", "T", "", "mapper", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcn/sast/framework/report/sqldelight/Verify_rule_name;", "verify_file", "Lcn/sast/framework/report/sqldelight/diagnostic/Verify_file;", "verify_note_path", "Lcn/sast/framework/report/sqldelight/Verify_note_path;", "verify_control_flow_path", "Lcn/sast/framework/report/sqldelight/Verify_control_flow_path;", "verify_macro", "Lcn/sast/framework/report/sqldelight/Verify_macro;", "selectAll", "Lapp/cash/sqldelight/Query;", "Lkotlin/Function19;", "_line", "_column", "_message_en", "_message_zh", "Lcn/sast/framework/report/sqldelight/Diagnostic;", "insert", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;)V", "IdQuery", "Verify_rule_nameQuery", "Verify_fileQuery", "Verify_note_pathQuery", "Verify_control_flow_pathQuery", "Verify_macroQuery", "corax-framework"})
public final class DiagnosticQueries
extends TransacterImpl {
    public DiagnosticQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final ExecutableQuery<Long> id(@NotNull String rule_name, @Nullable String _rule_short_description_zh, @Nullable Long __file_id, @NotNull String _file_abs_path, @Nullable String severity, @Nullable String precision, @Nullable String likelihood, @Nullable String impact, @Nullable String technique, @Nullable String analysis_scope, @Nullable String line_content, long __note_array_hash_id, @Nullable Long __control_flow_array_hash_id, @Nullable Long __macro_note_set_hash_id) {
        Intrinsics.checkNotNullParameter((Object)rule_name, (String)"rule_name");
        Intrinsics.checkNotNullParameter((Object)_file_abs_path, (String)"_file_abs_path");
        return (ExecutableQuery)new IdQuery(this, rule_name, _rule_short_description_zh, __file_id, _file_abs_path, severity, precision, likelihood, impact, technique, analysis_scope, line_content, __note_array_hash_id, __control_flow_array_hash_id, __macro_note_set_hash_id, DiagnosticQueries::id$lambda$0);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_rule_name(@NotNull Function2<? super Long, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return (ExecutableQuery)new Verify_rule_nameQuery(this, arg_0 -> DiagnosticQueries.verify_rule_name$lambda$1(mapper, arg_0));
    }

    @NotNull
    public final ExecutableQuery<Verify_rule_name> verify_rule_name() {
        return this.verify_rule_name(DiagnosticQueries::verify_rule_name$lambda$2);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_file(@NotNull Function2<? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return (ExecutableQuery)new Verify_fileQuery(this, arg_0 -> DiagnosticQueries.verify_file$lambda$3(mapper, arg_0));
    }

    @NotNull
    public final ExecutableQuery<Verify_file> verify_file() {
        return this.verify_file(DiagnosticQueries::verify_file$lambda$4);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_note_path(@NotNull Function2<? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return (ExecutableQuery)new Verify_note_pathQuery(this, arg_0 -> DiagnosticQueries.verify_note_path$lambda$5(mapper, arg_0));
    }

    @NotNull
    public final ExecutableQuery<Verify_note_path> verify_note_path() {
        return this.verify_note_path(DiagnosticQueries::verify_note_path$lambda$6);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_control_flow_path(@NotNull Function2<? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return (ExecutableQuery)new Verify_control_flow_pathQuery(this, arg_0 -> DiagnosticQueries.verify_control_flow_path$lambda$7(mapper, arg_0));
    }

    @NotNull
    public final ExecutableQuery<Verify_control_flow_path> verify_control_flow_path() {
        return this.verify_control_flow_path(DiagnosticQueries::verify_control_flow_path$lambda$8);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_macro(@NotNull Function2<? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return (ExecutableQuery)new Verify_macroQuery(this, arg_0 -> DiagnosticQueries.verify_macro$lambda$9(mapper, arg_0));
    }

    @NotNull
    public final ExecutableQuery<Verify_macro> verify_macro() {
        return this.verify_macro(DiagnosticQueries::verify_macro$lambda$10);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function19<? super Long, ? super String, ? super String, ? super Long, ? super String, ? super Long, ? super Long, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super Long, ? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"Diagnostic"};
        return QueryKt.Query((int)2051098827, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"Diagnostic.sq", (String)"selectAll", (String)"SELECT Diagnostic.id, Diagnostic.rule_name, Diagnostic._rule_short_description_zh, Diagnostic.__file_id, Diagnostic._file_abs_path, Diagnostic._line, Diagnostic._column, Diagnostic._message_en, Diagnostic._message_zh, Diagnostic.severity, Diagnostic.precision, Diagnostic.likelihood, Diagnostic.impact, Diagnostic.technique, Diagnostic.analysis_scope, Diagnostic.line_content, Diagnostic.__note_array_hash_id, Diagnostic.__control_flow_array_hash_id, Diagnostic.__macro_note_set_hash_id\nFROM Diagnostic", arg_0 -> DiagnosticQueries.selectAll$lambda$11(mapper, arg_0));
    }

    @NotNull
    public final Query<Diagnostic> selectAll() {
        return this.selectAll(DiagnosticQueries::selectAll$lambda$12);
    }

    public final void insert(@NotNull String rule_name, @Nullable String _rule_short_description_zh, @Nullable Long __file_id, @NotNull String _file_abs_path, long _line, long _column, @NotNull String _message_en, @NotNull String _message_zh, @Nullable String severity, @Nullable String precision, @Nullable String likelihood, @Nullable String impact, @Nullable String technique, @Nullable String analysis_scope, @Nullable String line_content, long __note_array_hash_id, @Nullable Long __control_flow_array_hash_id, @Nullable Long __macro_note_set_hash_id) {
        Intrinsics.checkNotNullParameter((Object)rule_name, (String)"rule_name");
        Intrinsics.checkNotNullParameter((Object)_file_abs_path, (String)"_file_abs_path");
        Intrinsics.checkNotNullParameter((Object)_message_en, (String)"_message_en");
        Intrinsics.checkNotNullParameter((Object)_message_zh, (String)"_message_zh");
        Transacter.DefaultImpls.transaction$default((Transacter)((Transacter)this), (boolean)false, arg_0 -> DiagnosticQueries.insert$lambda$14(this, rule_name, _rule_short_description_zh, __file_id, _file_abs_path, _line, _column, _message_en, _message_zh, severity, precision, likelihood, impact, technique, analysis_scope, line_content, __note_array_hash_id, __control_flow_array_hash_id, __macro_note_set_hash_id, arg_0), (int)1, null);
        this.notifyQueries(949328563, DiagnosticQueries::insert$lambda$15);
    }

    private static final long id$lambda$0(SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        return l;
    }

    private static final Object verify_rule_name$lambda$1(Function2 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        String string = cursor.getString(1);
        Intrinsics.checkNotNull((Object)string);
        return $mapper.invoke((Object)l, (Object)string);
    }

    private static final Verify_rule_name verify_rule_name$lambda$2(long id, String rule_name) {
        Intrinsics.checkNotNullParameter((Object)rule_name, (String)"rule_name");
        return new Verify_rule_name(id, rule_name);
    }

    private static final Object verify_file$lambda$3(Function2 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        return $mapper.invoke((Object)l, (Object)cursor.getLong(1));
    }

    private static final Verify_file verify_file$lambda$4(long id, Long __file_id) {
        return new Verify_file(id, __file_id);
    }

    private static final Object verify_note_path$lambda$5(Function2 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        Long l2 = cursor.getLong(1);
        Intrinsics.checkNotNull((Object)l2);
        return $mapper.invoke((Object)l, (Object)l2);
    }

    private static final Verify_note_path verify_note_path$lambda$6(long id, long __note_array_hash_id) {
        return new Verify_note_path(id, __note_array_hash_id);
    }

    private static final Object verify_control_flow_path$lambda$7(Function2 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        Long l2 = cursor.getLong(1);
        Intrinsics.checkNotNull((Object)l2);
        return $mapper.invoke((Object)l, (Object)l2);
    }

    private static final Verify_control_flow_path verify_control_flow_path$lambda$8(long id, long __control_flow_array_hash_id) {
        return new Verify_control_flow_path(id, __control_flow_array_hash_id);
    }

    private static final Object verify_macro$lambda$9(Function2 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        Long l2 = cursor.getLong(1);
        Intrinsics.checkNotNull((Object)l2);
        return $mapper.invoke((Object)l, (Object)l2);
    }

    private static final Verify_macro verify_macro$lambda$10(long id, long __macro_note_set_hash_id) {
        return new Verify_macro(id, __macro_note_set_hash_id);
    }

    private static final Object selectAll$lambda$11(Function19 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        String string = cursor.getString(1);
        Intrinsics.checkNotNull((Object)string);
        String string2 = cursor.getString(2);
        Long l2 = cursor.getLong(3);
        String string3 = cursor.getString(4);
        Intrinsics.checkNotNull((Object)string3);
        Long l3 = cursor.getLong(5);
        Intrinsics.checkNotNull((Object)l3);
        Long l4 = cursor.getLong(6);
        Intrinsics.checkNotNull((Object)l4);
        String string4 = cursor.getString(7);
        Intrinsics.checkNotNull((Object)string4);
        String string5 = cursor.getString(8);
        Intrinsics.checkNotNull((Object)string5);
        String string6 = cursor.getString(9);
        String string7 = cursor.getString(10);
        String string8 = cursor.getString(11);
        String string9 = cursor.getString(12);
        String string10 = cursor.getString(13);
        String string11 = cursor.getString(14);
        String string12 = cursor.getString(15);
        Long l5 = cursor.getLong(16);
        Intrinsics.checkNotNull((Object)l5);
        return $mapper.invoke((Object)l, (Object)string, (Object)string2, (Object)l2, (Object)string3, (Object)l3, (Object)l4, (Object)string4, (Object)string5, (Object)string6, (Object)string7, (Object)string8, (Object)string9, (Object)string10, (Object)string11, (Object)string12, (Object)l5, (Object)cursor.getLong(17), (Object)cursor.getLong(18));
    }

    private static final Diagnostic selectAll$lambda$12(long id, String rule_name, String _rule_short_description_zh, Long __file_id, String _file_abs_path, long _line, long _column, String _message_en, String _message_zh, String severity, String precision, String likelihood, String impact, String technique, String analysis_scope, String line_content, long __note_array_hash_id, Long __control_flow_array_hash_id, Long __macro_note_set_hash_id) {
        Intrinsics.checkNotNullParameter((Object)rule_name, (String)"rule_name");
        Intrinsics.checkNotNullParameter((Object)_file_abs_path, (String)"_file_abs_path");
        Intrinsics.checkNotNullParameter((Object)_message_en, (String)"_message_en");
        Intrinsics.checkNotNullParameter((Object)_message_zh, (String)"_message_zh");
        return new Diagnostic(id, rule_name, _rule_short_description_zh, __file_id, _file_abs_path, _line, _column, _message_en, _message_zh, severity, precision, likelihood, impact, technique, analysis_scope, line_content, __note_array_hash_id, __control_flow_array_hash_id, __macro_note_set_hash_id);
    }

    private static final Unit insert$lambda$14$lambda$13(String $rule_name, String $_rule_short_description_zh, Long $__file_id, String $_file_abs_path, long $_line, long $_column, String $_message_en, String $_message_zh, String $severity, String $precision, String $likelihood, String $impact, String $technique, String $analysis_scope, String $line_content, long $__note_array_hash_id, Long $__control_flow_array_hash_id, Long $__macro_note_set_hash_id, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $rule_name);
        $this$execute.bindString(1, $_rule_short_description_zh);
        $this$execute.bindLong(2, $__file_id);
        $this$execute.bindString(3, $_file_abs_path);
        $this$execute.bindLong(4, Long.valueOf($_line));
        $this$execute.bindLong(5, Long.valueOf($_column));
        $this$execute.bindString(6, $_message_en);
        $this$execute.bindString(7, $_message_zh);
        $this$execute.bindString(8, $severity);
        $this$execute.bindString(9, $precision);
        $this$execute.bindString(10, $likelihood);
        $this$execute.bindString(11, $impact);
        $this$execute.bindString(12, $technique);
        $this$execute.bindString(13, $analysis_scope);
        $this$execute.bindString(14, $line_content);
        $this$execute.bindLong(15, Long.valueOf($__note_array_hash_id));
        $this$execute.bindLong(16, $__control_flow_array_hash_id);
        $this$execute.bindLong(17, $__macro_note_set_hash_id);
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$14(DiagnosticQueries this$0, String $rule_name, String $_rule_short_description_zh, Long $__file_id, String $_file_abs_path, long $_line, long $_column, String $_message_en, String $_message_zh, String $severity, String $precision, String $likelihood, String $impact, String $technique, String $analysis_scope, String $line_content, long $__note_array_hash_id, Long $__control_flow_array_hash_id, Long $__macro_note_set_hash_id, TransactionWithoutReturn $this$transaction) {
        Intrinsics.checkNotNullParameter((Object)$this$transaction, (String)"$this$transaction");
        this$0.getDriver().execute(Integer.valueOf(1771685284), "INSERT OR IGNORE INTO Diagnostic(rule_name, _rule_short_description_zh,\n                                     __file_id, _file_abs_path,\n                                     _line, _column, _message_en, _message_zh,\n                                     severity, precision, likelihood, impact, technique, analysis_scope,\n                                     line_content,\n                                     __note_array_hash_id, __control_flow_array_hash_id, __macro_note_set_hash_id\n--                                      issue_context_kind, issue_context, issue_hash_func_offset\n                                     )\n    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?\n--     ?, ?, ?\n    )", 18, arg_0 -> DiagnosticQueries.insert$lambda$14$lambda$13($rule_name, $_rule_short_description_zh, $__file_id, $_file_abs_path, $_line, $_column, $_message_en, $_message_zh, $severity, $precision, $likelihood, $impact, $technique, $analysis_scope, $line_content, $__note_array_hash_id, $__control_flow_array_hash_id, $__macro_note_set_hash_id, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$15(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"Diagnostic");
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ SqlDriver access$getDriver(DiagnosticQueries $this) {
        return $this.getDriver();
    }
}

