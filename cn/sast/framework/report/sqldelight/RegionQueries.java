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
 *  cn.sast.framework.report.sqldelight.Region
 *  cn.sast.framework.report.sqldelight.RegionQueries
 *  cn.sast.framework.report.sqldelight.RegionQueries$IdQuery
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function6
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
import cn.sast.framework.report.sqldelight.Region;
import cn.sast.framework.report.sqldelight.RegionQueries;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J?\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u000eJ\u00aa\u0001\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0010\"\b\b\u0000\u0010\u0011*\u00020\u00122\u0091\u0001\u0010\u0013\u001a\u008c\u0001\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\r\u0012\u0004\u0012\u0002H\u00110\u0014J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00170\u0010J9\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001a\u00a8\u0006\u001c"}, d2={"Lcn/sast/framework/report/sqldelight/RegionQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "id", "Lapp/cash/sqldelight/ExecutableQuery;", "", "__file_id", "start_line", "start_column", "end_line", "end_column", "(JJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lapp/cash/sqldelight/ExecutableQuery;", "selectAll", "Lapp/cash/sqldelight/Query;", "T", "", "mapper", "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", "Lcn/sast/framework/report/sqldelight/Region;", "insert", "", "(JJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "IdQuery", "corax-framework"})
public final class RegionQueries
extends TransacterImpl {
    public RegionQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final ExecutableQuery<Long> id(long __file_id, long start_line, @Nullable Long start_column, @Nullable Long end_line, @Nullable Long end_column) {
        return (ExecutableQuery)new IdQuery(this, __file_id, start_line, start_column, end_line, end_column, RegionQueries::id$lambda$0);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function6<? super Long, ? super Long, ? super Long, ? super Long, ? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"Region"};
        return QueryKt.Query((int)-1166723042, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"Region.sq", (String)"selectAll", (String)"SELECT Region.id, Region.__file_id, Region.start_line, Region.start_column, Region.end_line, Region.end_column\nFROM Region", arg_0 -> RegionQueries.selectAll$lambda$1(mapper, arg_0));
    }

    @NotNull
    public final Query<Region> selectAll() {
        return this.selectAll(RegionQueries::selectAll$lambda$2);
    }

    public final void insert(long __file_id, long start_line, @Nullable Long start_column, @Nullable Long end_line, @Nullable Long end_column) {
        Transacter.DefaultImpls.transaction$default((Transacter)((Transacter)this), (boolean)false, arg_0 -> RegionQueries.insert$lambda$4(this, __file_id, start_line, start_column, end_line, end_column, arg_0), (int)1, null);
        this.notifyQueries(1577657408, RegionQueries::insert$lambda$5);
    }

    private static final long id$lambda$0(SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        return l;
    }

    private static final Object selectAll$lambda$1(Function6 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        Long l2 = cursor.getLong(1);
        Intrinsics.checkNotNull((Object)l2);
        Long l3 = cursor.getLong(2);
        Intrinsics.checkNotNull((Object)l3);
        return $mapper.invoke((Object)l, (Object)l2, (Object)l3, (Object)cursor.getLong(3), (Object)cursor.getLong(4), (Object)cursor.getLong(5));
    }

    private static final Region selectAll$lambda$2(long id, long __file_id, long start_line, Long start_column, Long end_line, Long end_column) {
        return new Region(id, __file_id, start_line, start_column, end_line, end_column);
    }

    private static final Unit insert$lambda$4$lambda$3(long $__file_id, long $start_line, Long $start_column, Long $end_line, Long $end_column, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindLong(0, Long.valueOf($__file_id));
        $this$execute.bindLong(1, Long.valueOf($start_line));
        $this$execute.bindLong(2, $start_column);
        $this$execute.bindLong(3, $end_line);
        $this$execute.bindLong(4, $end_column);
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$4(RegionQueries this$0, long $__file_id, long $start_line, Long $start_column, Long $end_line, Long $end_column, TransactionWithoutReturn $this$transaction) {
        Intrinsics.checkNotNullParameter((Object)$this$transaction, (String)"$this$transaction");
        this$0.getDriver().execute(Integer.valueOf(0x511FF1), "INSERT OR IGNORE INTO Region(__file_id, start_line, start_column, end_line, end_column)\n    VALUES (?, ?, ?, ?, ?)", 5, arg_0 -> RegionQueries.insert$lambda$4$lambda$3($__file_id, $start_line, $start_column, $end_line, $end_column, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$5(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"Region");
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ SqlDriver access$getDriver(RegionQueries $this) {
        return $this.getDriver();
    }
}

