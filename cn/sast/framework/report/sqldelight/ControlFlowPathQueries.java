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
 *  cn.sast.framework.report.sqldelight.ControlFlowPath
 *  cn.sast.framework.report.sqldelight.ControlFlowPathQueries
 *  cn.sast.framework.report.sqldelight.ControlFlowPathQueries$Verify_control_flowQuery
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
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
import cn.sast.framework.report.sqldelight.ControlFlowPath;
import cn.sast.framework.report.sqldelight.ControlFlowPathQueries;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005Jc\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2K\u0010\n\u001aG\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007Jc\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0014\"\b\b\u0000\u0010\b*\u00020\t2K\u0010\n\u001aG\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012\u00a8\u0006\u0019"}, d2={"Lcn/sast/framework/report/sqldelight/ControlFlowPathQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "verify_control_flow", "Lapp/cash/sqldelight/ExecutableQuery;", "T", "", "mapper", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "__control_flow_array_hash_id", "control_flow_sequence", "__control_flow_id", "Lcn/sast/framework/report/sqldelight/ControlFlowPath;", "selectAll", "Lapp/cash/sqldelight/Query;", "insert", "", "ControlFlowPath", "Verify_control_flowQuery", "corax-framework"})
public final class ControlFlowPathQueries
extends TransacterImpl {
    public ControlFlowPathQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_control_flow(@NotNull Function3<? super Long, ? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return (ExecutableQuery)new Verify_control_flowQuery(this, arg_0 -> ControlFlowPathQueries.verify_control_flow$lambda$0(mapper, arg_0));
    }

    @NotNull
    public final ExecutableQuery<ControlFlowPath> verify_control_flow() {
        return this.verify_control_flow(ControlFlowPathQueries::verify_control_flow$lambda$1);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function3<? super Long, ? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"ControlFlowPath"};
        return QueryKt.Query((int)-180228340, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"ControlFlowPath.sq", (String)"selectAll", (String)"SELECT ControlFlowPath.__control_flow_array_hash_id, ControlFlowPath.control_flow_sequence, ControlFlowPath.__control_flow_id\nFROM ControlFlowPath", arg_0 -> ControlFlowPathQueries.selectAll$lambda$2(mapper, arg_0));
    }

    @NotNull
    public final Query<ControlFlowPath> selectAll() {
        return this.selectAll(ControlFlowPathQueries::selectAll$lambda$3);
    }

    public final void insert(@NotNull ControlFlowPath ControlFlowPath2) {
        Intrinsics.checkNotNullParameter((Object)ControlFlowPath2, (String)"ControlFlowPath");
        this.getDriver().execute(Integer.valueOf(-947157998), "INSERT OR IGNORE INTO ControlFlowPath (__control_flow_array_hash_id, control_flow_sequence, __control_flow_id)\nVALUES (?, ?, ?)", 3, arg_0 -> ControlFlowPathQueries.insert$lambda$4(ControlFlowPath2, arg_0));
        this.notifyQueries(-947157998, ControlFlowPathQueries::insert$lambda$5);
    }

    private static final Object verify_control_flow$lambda$0(Function3 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        Long l2 = cursor.getLong(1);
        Intrinsics.checkNotNull((Object)l2);
        Long l3 = cursor.getLong(2);
        Intrinsics.checkNotNull((Object)l3);
        return $mapper.invoke((Object)l, (Object)l2, (Object)l3);
    }

    private static final ControlFlowPath verify_control_flow$lambda$1(long __control_flow_array_hash_id, long control_flow_sequence, long __control_flow_id) {
        return new ControlFlowPath(__control_flow_array_hash_id, control_flow_sequence, __control_flow_id);
    }

    private static final Object selectAll$lambda$2(Function3 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        Long l2 = cursor.getLong(1);
        Intrinsics.checkNotNull((Object)l2);
        Long l3 = cursor.getLong(2);
        Intrinsics.checkNotNull((Object)l3);
        return $mapper.invoke((Object)l, (Object)l2, (Object)l3);
    }

    private static final ControlFlowPath selectAll$lambda$3(long __control_flow_array_hash_id, long control_flow_sequence, long __control_flow_id) {
        return new ControlFlowPath(__control_flow_array_hash_id, control_flow_sequence, __control_flow_id);
    }

    private static final Unit insert$lambda$4(ControlFlowPath $ControlFlowPath, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindLong(0, Long.valueOf($ControlFlowPath.get__control_flow_array_hash_id()));
        $this$execute.bindLong(1, Long.valueOf($ControlFlowPath.getControl_flow_sequence()));
        $this$execute.bindLong(2, Long.valueOf($ControlFlowPath.get__control_flow_id()));
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$5(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"ControlFlowPath");
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ SqlDriver access$getDriver(ControlFlowPathQueries $this) {
        return $this.getDriver();
    }
}

