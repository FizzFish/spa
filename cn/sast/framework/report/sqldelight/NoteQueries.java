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
 *  cn.sast.framework.report.sqldelight.Note
 *  cn.sast.framework.report.sqldelight.NoteQueries
 *  cn.sast.framework.report.sqldelight.NoteQueries$IdQuery
 *  cn.sast.framework.report.sqldelight.NoteQueries$Verify_fileQuery
 *  cn.sast.framework.report.sqldelight.note.Verify_file
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function11
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
import cn.sast.framework.report.sqldelight.Note;
import cn.sast.framework.report.sqldelight.NoteQueries;
import cn.sast.framework.report.sqldelight.note.Verify_file;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002$%B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005Jg\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0014JN\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0007\"\b\b\u0000\u0010\u0016*\u00020\u001726\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00160\u0019J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0007J\u0093\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00160\u001e\"\b\b\u0000\u0010\u0016*\u00020\u00172\u00fa\u0001\u0010\u0018\u001a\u00f5\u0001\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H\u00160\u001fJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020 0\u001eJa\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010#\u00a8\u0006&"}, d2={"Lcn/sast/framework/report/sqldelight/NoteQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "id", "Lapp/cash/sqldelight/ExecutableQuery;", "", "kind", "", "display_hint", "__file_id", "_file_abs_path", "line", "column", "message_en", "message_zh", "__notices_region_id", "__func_region_id", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lapp/cash/sqldelight/ExecutableQuery;", "verify_file", "T", "", "mapper", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcn/sast/framework/report/sqldelight/note/Verify_file;", "selectAll", "Lapp/cash/sqldelight/Query;", "Lkotlin/Function11;", "Lcn/sast/framework/report/sqldelight/Note;", "insert", "", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "IdQuery", "Verify_fileQuery", "corax-framework"})
public final class NoteQueries
extends TransacterImpl {
    public NoteQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final ExecutableQuery<Long> id(@NotNull String kind, @NotNull String display_hint, long __file_id, @NotNull String _file_abs_path, long line, @Nullable Long column, @NotNull String message_en, @NotNull String message_zh, @Nullable Long __notices_region_id, @Nullable Long __func_region_id) {
        Intrinsics.checkNotNullParameter((Object)kind, (String)"kind");
        Intrinsics.checkNotNullParameter((Object)display_hint, (String)"display_hint");
        Intrinsics.checkNotNullParameter((Object)_file_abs_path, (String)"_file_abs_path");
        Intrinsics.checkNotNullParameter((Object)message_en, (String)"message_en");
        Intrinsics.checkNotNullParameter((Object)message_zh, (String)"message_zh");
        return (ExecutableQuery)new IdQuery(this, kind, display_hint, __file_id, _file_abs_path, line, column, message_en, message_zh, __notices_region_id, __func_region_id, NoteQueries::id$lambda$0);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_file(@NotNull Function2<? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return (ExecutableQuery)new Verify_fileQuery(this, arg_0 -> NoteQueries.verify_file$lambda$1(mapper, arg_0));
    }

    @NotNull
    public final ExecutableQuery<Verify_file> verify_file() {
        return this.verify_file(NoteQueries::verify_file$lambda$2);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function11<? super Long, ? super String, ? super String, ? super Long, ? super String, ? super Long, ? super Long, ? super String, ? super String, ? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"Note"};
        return QueryKt.Query((int)1298079392, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"Note.sq", (String)"selectAll", (String)"SELECT Note.id, Note.kind, Note.display_hint, Note.__file_id, Note._file_abs_path, Note.line, Note.column, Note.message_en, Note.message_zh, Note.__notices_region_id, Note.__func_region_id\nFROM Note", arg_0 -> NoteQueries.selectAll$lambda$3(mapper, arg_0));
    }

    @NotNull
    public final Query<Note> selectAll() {
        return this.selectAll(NoteQueries::selectAll$lambda$4);
    }

    public final void insert(@NotNull String kind, @NotNull String display_hint, long __file_id, @NotNull String _file_abs_path, long line, @Nullable Long column, @NotNull String message_en, @NotNull String message_zh, @Nullable Long __notices_region_id, @Nullable Long __func_region_id) {
        Intrinsics.checkNotNullParameter((Object)kind, (String)"kind");
        Intrinsics.checkNotNullParameter((Object)display_hint, (String)"display_hint");
        Intrinsics.checkNotNullParameter((Object)_file_abs_path, (String)"_file_abs_path");
        Intrinsics.checkNotNullParameter((Object)message_en, (String)"message_en");
        Intrinsics.checkNotNullParameter((Object)message_zh, (String)"message_zh");
        Transacter.DefaultImpls.transaction$default((Transacter)((Transacter)this), (boolean)false, arg_0 -> NoteQueries.insert$lambda$6(this, kind, display_hint, __file_id, _file_abs_path, line, column, message_en, message_zh, __notices_region_id, __func_region_id, arg_0), (int)1, null);
        this.notifyQueries(-681403138, NoteQueries::insert$lambda$7);
    }

    private static final long id$lambda$0(SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        return l;
    }

    private static final Object verify_file$lambda$1(Function2 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        Long l2 = cursor.getLong(1);
        Intrinsics.checkNotNull((Object)l2);
        return $mapper.invoke((Object)l, (Object)l2);
    }

    private static final Verify_file verify_file$lambda$2(long id, long __file_id) {
        return new Verify_file(id, __file_id);
    }

    private static final Object selectAll$lambda$3(Function11 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        String string = cursor.getString(1);
        Intrinsics.checkNotNull((Object)string);
        String string2 = cursor.getString(2);
        Intrinsics.checkNotNull((Object)string2);
        Long l2 = cursor.getLong(3);
        Intrinsics.checkNotNull((Object)l2);
        String string3 = cursor.getString(4);
        Intrinsics.checkNotNull((Object)string3);
        Long l3 = cursor.getLong(5);
        Intrinsics.checkNotNull((Object)l3);
        Long l4 = cursor.getLong(6);
        String string4 = cursor.getString(7);
        Intrinsics.checkNotNull((Object)string4);
        String string5 = cursor.getString(8);
        Intrinsics.checkNotNull((Object)string5);
        return $mapper.invoke((Object)l, (Object)string, (Object)string2, (Object)l2, (Object)string3, (Object)l3, (Object)l4, (Object)string4, (Object)string5, (Object)cursor.getLong(9), (Object)cursor.getLong(10));
    }

    private static final Note selectAll$lambda$4(long id, String kind, String display_hint, long __file_id, String _file_abs_path, long line, Long column, String message_en, String message_zh, Long __notices_region_id, Long __func_region_id) {
        Intrinsics.checkNotNullParameter((Object)kind, (String)"kind");
        Intrinsics.checkNotNullParameter((Object)display_hint, (String)"display_hint");
        Intrinsics.checkNotNullParameter((Object)_file_abs_path, (String)"_file_abs_path");
        Intrinsics.checkNotNullParameter((Object)message_en, (String)"message_en");
        Intrinsics.checkNotNullParameter((Object)message_zh, (String)"message_zh");
        return new Note(id, kind, display_hint, __file_id, _file_abs_path, line, column, message_en, message_zh, __notices_region_id, __func_region_id);
    }

    private static final Unit insert$lambda$6$lambda$5(String $kind, String $display_hint, long $__file_id, String $_file_abs_path, long $line, Long $column, String $message_en, String $message_zh, Long $__notices_region_id, Long $__func_region_id, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $kind);
        $this$execute.bindString(1, $display_hint);
        $this$execute.bindLong(2, Long.valueOf($__file_id));
        $this$execute.bindString(3, $_file_abs_path);
        $this$execute.bindLong(4, Long.valueOf($line));
        $this$execute.bindLong(5, $column);
        $this$execute.bindString(6, $message_en);
        $this$execute.bindString(7, $message_zh);
        $this$execute.bindLong(8, $__notices_region_id);
        $this$execute.bindLong(9, $__func_region_id);
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$6(NoteQueries this$0, String $kind, String $display_hint, long $__file_id, String $_file_abs_path, long $line, Long $column, String $message_en, String $message_zh, Long $__notices_region_id, Long $__func_region_id, TransactionWithoutReturn $this$transaction) {
        Intrinsics.checkNotNullParameter((Object)$this$transaction, (String)"$this$transaction");
        this$0.getDriver().execute(Integer.valueOf(-1993383633), "INSERT OR IGNORE INTO Note(kind, display_hint, __file_id, _file_abs_path, line, column, message_en, message_zh, __notices_region_id, __func_region_id)\n    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 10, arg_0 -> NoteQueries.insert$lambda$6$lambda$5($kind, $display_hint, $__file_id, $_file_abs_path, $line, $column, $message_en, $message_zh, $__notices_region_id, $__func_region_id, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$7(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"Note");
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ SqlDriver access$getDriver(NoteQueries $this) {
        return $this.getDriver();
    }
}

