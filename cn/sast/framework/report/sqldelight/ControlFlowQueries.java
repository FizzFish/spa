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
 *  cn.sast.framework.report.sqldelight.ControlFlow
 *  cn.sast.framework.report.sqldelight.ControlFlowQueries
 *  cn.sast.framework.report.sqldelight.ControlFlowQueries$IdQuery
 *  cn.sast.framework.report.sqldelight.ControlFlowQueries$Verify_fileQuery
 *  cn.sast.framework.report.sqldelight.controlFlow.Verify_file
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function7
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
import cn.sast.framework.report.sqldelight.ControlFlow;
import cn.sast.framework.report.sqldelight.ControlFlowQueries;
import cn.sast.framework.report.sqldelight.controlFlow.Verify_file;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J@\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bJN\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0007\"\b\b\u0000\u0010\u0011*\u00020\u001226\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t\u0012\u0004\u0012\u0002H\u00110\u0014J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007J\u00bd\u0001\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0019\"\b\b\u0000\u0010\u0011*\u00020\u00122\u00a4\u0001\u0010\u0013\u001a\u009f\u0001\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u0002H\u00110\u001aJ\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0019J:\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b\u00a8\u0006 "}, d2={"Lcn/sast/framework/report/sqldelight/ControlFlowQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "id", "Lapp/cash/sqldelight/ExecutableQuery;", "", "__file_id", "_file_abs_path", "", "message_en", "message_zh", "__edge_from_region_id", "__edge_to_region_id", "verify_file", "T", "", "mapper", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcn/sast/framework/report/sqldelight/controlFlow/Verify_file;", "selectAll", "Lapp/cash/sqldelight/Query;", "Lkotlin/Function7;", "Lcn/sast/framework/report/sqldelight/ControlFlow;", "insert", "", "IdQuery", "Verify_fileQuery", "corax-framework"})
public final class ControlFlowQueries
extends TransacterImpl {
    public ControlFlowQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final ExecutableQuery<Long> id(long __file_id, @NotNull String _file_abs_path, @Nullable String message_en, @Nullable String message_zh, long __edge_from_region_id, long __edge_to_region_id) {
        Intrinsics.checkNotNullParameter((Object)_file_abs_path, (String)"_file_abs_path");
        return (ExecutableQuery)new IdQuery(this, __file_id, _file_abs_path, message_en, message_zh, __edge_from_region_id, __edge_to_region_id, ControlFlowQueries::id$lambda$0);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_file(@NotNull Function2<? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return (ExecutableQuery)new Verify_fileQuery(this, arg_0 -> ControlFlowQueries.verify_file$lambda$1(mapper, arg_0));
    }

    @NotNull
    public final ExecutableQuery<Verify_file> verify_file() {
        return this.verify_file(ControlFlowQueries::verify_file$lambda$2);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function7<? super Long, ? super Long, ? super String, ? super String, ? super String, ? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"ControlFlow"};
        return QueryKt.Query((int)590154801, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"ControlFlow.sq", (String)"selectAll", (String)"SELECT ControlFlow.id, ControlFlow.__file_id, ControlFlow._file_abs_path, ControlFlow.message_en, ControlFlow.message_zh, ControlFlow.__edge_from_region_id, ControlFlow.__edge_to_region_id\nFROM ControlFlow", arg_0 -> ControlFlowQueries.selectAll$lambda$3(mapper, arg_0));
    }

    @NotNull
    public final Query<ControlFlow> selectAll() {
        return this.selectAll(ControlFlowQueries::selectAll$lambda$4);
    }

    public final void insert(long __file_id, @NotNull String _file_abs_path, @Nullable String message_en, @Nullable String message_zh, long __edge_from_region_id, long __edge_to_region_id) {
        Intrinsics.checkNotNullParameter((Object)_file_abs_path, (String)"_file_abs_path");
        Transacter.DefaultImpls.transaction$default((Transacter)((Transacter)this), (boolean)false, arg_0 -> ControlFlowQueries.insert$lambda$6(this, __file_id, _file_abs_path, message_en, message_zh, __edge_from_region_id, __edge_to_region_id, arg_0), (int)1, null);
        this.notifyQueries(1615921421, ControlFlowQueries::insert$lambda$7);
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

    private static final Object selectAll$lambda$3(Function7 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        Long l2 = cursor.getLong(1);
        Intrinsics.checkNotNull((Object)l2);
        String string = cursor.getString(2);
        Intrinsics.checkNotNull((Object)string);
        String string2 = cursor.getString(3);
        String string3 = cursor.getString(4);
        Long l3 = cursor.getLong(5);
        Intrinsics.checkNotNull((Object)l3);
        Long l4 = cursor.getLong(6);
        Intrinsics.checkNotNull((Object)l4);
        return $mapper.invoke((Object)l, (Object)l2, (Object)string, (Object)string2, (Object)string3, (Object)l3, (Object)l4);
    }

    private static final ControlFlow selectAll$lambda$4(long id, long __file_id, String _file_abs_path, String message_en, String message_zh, long __edge_from_region_id, long __edge_to_region_id) {
        Intrinsics.checkNotNullParameter((Object)_file_abs_path, (String)"_file_abs_path");
        return new ControlFlow(id, __file_id, _file_abs_path, message_en, message_zh, __edge_from_region_id, __edge_to_region_id);
    }

    private static final Unit insert$lambda$6$lambda$5(long $__file_id, String $_file_abs_path, String $message_en, String $message_zh, long $__edge_from_region_id, long $__edge_to_region_id, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindLong(0, Long.valueOf($__file_id));
        $this$execute.bindString(1, $_file_abs_path);
        $this$execute.bindString(2, $message_en);
        $this$execute.bindString(3, $message_zh);
        $this$execute.bindLong(4, Long.valueOf($__edge_from_region_id));
        $this$execute.bindLong(5, Long.valueOf($__edge_to_region_id));
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$6(ControlFlowQueries this$0, long $__file_id, String $_file_abs_path, String $message_en, String $message_zh, long $__edge_from_region_id, long $__edge_to_region_id, TransactionWithoutReturn $this$transaction) {
        Intrinsics.checkNotNullParameter((Object)$this$transaction, (String)"$this$transaction");
        this$0.getDriver().execute(Integer.valueOf(-1877672578), "INSERT OR IGNORE INTO ControlFlow(__file_id, _file_abs_path, message_en, message_zh, __edge_from_region_id, __edge_to_region_id)\n    VALUES (?, ?, ?, ?, ?, ?)", 6, arg_0 -> ControlFlowQueries.insert$lambda$6$lambda$5($__file_id, $_file_abs_path, $message_en, $message_zh, $__edge_from_region_id, $__edge_to_region_id, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$7(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"ControlFlow");
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ SqlDriver access$getDriver(ControlFlowQueries $this) {
        return $this.getDriver();
    }
}

