/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.ExecutableQuery
 *  app.cash.sqldelight.Query
 *  app.cash.sqldelight.QueryKt
 *  app.cash.sqldelight.TransacterImpl
 *  app.cash.sqldelight.db.SqlCursor
 *  app.cash.sqldelight.db.SqlDriver
 *  app.cash.sqldelight.db.SqlPreparedStatement
 *  cn.sast.framework.report.sqldelight.NotePath
 *  cn.sast.framework.report.sqldelight.NotePathQueries
 *  cn.sast.framework.report.sqldelight.NotePathQueries$Verify_noteQuery
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.ExecutableQuery;
import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import cn.sast.framework.report.sqldelight.NotePath;
import cn.sast.framework.report.sqldelight.NotePathQueries;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0091\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2y\u0010\n\u001au\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007J\u0091\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\b0\u0016\"\b\b\u0000\u0010\b*\u00020\t2y\u0010\n\u001au\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014\u00a8\u0006\u001b"}, d2={"Lcn/sast/framework/report/sqldelight/NotePathQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "verify_note", "Lapp/cash/sqldelight/ExecutableQuery;", "T", "", "mapper", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "name", "__note_array_hash_id", "note_sequence", "note_stack_depth", "note_is_key_event", "__note_id", "Lcn/sast/framework/report/sqldelight/NotePath;", "selectAll", "Lapp/cash/sqldelight/Query;", "insert", "", "NotePath", "Verify_noteQuery", "corax-framework"})
public final class NotePathQueries
extends TransacterImpl {
    public NotePathQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_note(@NotNull Function5<? super Long, ? super Long, ? super Long, ? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return (ExecutableQuery)new Verify_noteQuery(this, arg_0 -> NotePathQueries.verify_note$lambda$0(mapper, arg_0));
    }

    @NotNull
    public final ExecutableQuery<NotePath> verify_note() {
        return this.verify_note(NotePathQueries::verify_note$lambda$1);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function5<? super Long, ? super Long, ? super Long, ? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"NotePath"};
        return QueryKt.Query((int)-1170787845, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"NotePath.sq", (String)"selectAll", (String)"SELECT NotePath.__note_array_hash_id, NotePath.note_sequence, NotePath.note_stack_depth, NotePath.note_is_key_event, NotePath.__note_id\nFROM NotePath", arg_0 -> NotePathQueries.selectAll$lambda$2(mapper, arg_0));
    }

    @NotNull
    public final Query<NotePath> selectAll() {
        return this.selectAll(NotePathQueries::selectAll$lambda$3);
    }

    public final void insert(@NotNull NotePath NotePath2) {
        Intrinsics.checkNotNullParameter((Object)NotePath2, (String)"NotePath");
        this.getDriver().execute(Integer.valueOf(-476332157), "INSERT OR IGNORE INTO NotePath (__note_array_hash_id, note_sequence, note_stack_depth, note_is_key_event, __note_id)\nVALUES (?, ?, ?, ?, ?)", 5, arg_0 -> NotePathQueries.insert$lambda$4(NotePath2, arg_0));
        this.notifyQueries(-476332157, NotePathQueries::insert$lambda$5);
    }

    private static final Object verify_note$lambda$0(Function5 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        Long l2 = cursor.getLong(1);
        Intrinsics.checkNotNull((Object)l2);
        Long l3 = cursor.getLong(2);
        Long l4 = cursor.getLong(3);
        Long l5 = cursor.getLong(4);
        Intrinsics.checkNotNull((Object)l5);
        return $mapper.invoke((Object)l, (Object)l2, (Object)l3, (Object)l4, (Object)l5);
    }

    private static final NotePath verify_note$lambda$1(long __note_array_hash_id, long note_sequence, Long note_stack_depth, Long note_is_key_event, long __note_id) {
        return new NotePath(__note_array_hash_id, note_sequence, note_stack_depth, note_is_key_event, __note_id);
    }

    private static final Object selectAll$lambda$2(Function5 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        Long l2 = cursor.getLong(1);
        Intrinsics.checkNotNull((Object)l2);
        Long l3 = cursor.getLong(2);
        Long l4 = cursor.getLong(3);
        Long l5 = cursor.getLong(4);
        Intrinsics.checkNotNull((Object)l5);
        return $mapper.invoke((Object)l, (Object)l2, (Object)l3, (Object)l4, (Object)l5);
    }

    private static final NotePath selectAll$lambda$3(long __note_array_hash_id, long note_sequence, Long note_stack_depth, Long note_is_key_event, long __note_id) {
        return new NotePath(__note_array_hash_id, note_sequence, note_stack_depth, note_is_key_event, __note_id);
    }

    private static final Unit insert$lambda$4(NotePath $NotePath, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindLong(0, Long.valueOf($NotePath.get__note_array_hash_id()));
        $this$execute.bindLong(1, Long.valueOf($NotePath.getNote_sequence()));
        $this$execute.bindLong(2, $NotePath.getNote_stack_depth());
        $this$execute.bindLong(3, $NotePath.getNote_is_key_event());
        $this$execute.bindLong(4, Long.valueOf($NotePath.get__note_id()));
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$5(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"NotePath");
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ SqlDriver access$getDriver(NotePathQueries $this) {
        return $this.getDriver();
    }
}

