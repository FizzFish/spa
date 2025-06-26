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
 *  cn.sast.framework.report.sqldelight.MacroExpansion
 *  cn.sast.framework.report.sqldelight.MacroExpansionQueries
 *  cn.sast.framework.report.sqldelight.MacroExpansionQueries$Verify_noteQuery
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
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
import cn.sast.framework.report.sqldelight.MacroExpansion;
import cn.sast.framework.report.sqldelight.MacroExpansionQueries;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005JN\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t26\u0010\n\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007JN\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\b0\u0013\"\b\b\u0000\u0010\b*\u00020\t26\u0010\n\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011\u00a8\u0006\u0018"}, d2={"Lcn/sast/framework/report/sqldelight/MacroExpansionQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "verify_note", "Lapp/cash/sqldelight/ExecutableQuery;", "T", "", "mapper", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "__macro_note_set_hash_id", "__macro_note_id", "Lcn/sast/framework/report/sqldelight/MacroExpansion;", "selectAll", "Lapp/cash/sqldelight/Query;", "insert", "", "MacroExpansion", "Verify_noteQuery", "corax-framework"})
public final class MacroExpansionQueries
extends TransacterImpl {
    public MacroExpansionQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_note(@NotNull Function2<? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return (ExecutableQuery)new Verify_noteQuery(this, arg_0 -> MacroExpansionQueries.verify_note$lambda$0(mapper, arg_0));
    }

    @NotNull
    public final ExecutableQuery<MacroExpansion> verify_note() {
        return this.verify_note(MacroExpansionQueries::verify_note$lambda$1);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function2<? super Long, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"MacroExpansion"};
        return QueryKt.Query((int)1160581151, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"MacroExpansion.sq", (String)"selectAll", (String)"SELECT MacroExpansion.__macro_note_set_hash_id, MacroExpansion.__macro_note_id\nFROM MacroExpansion", arg_0 -> MacroExpansionQueries.selectAll$lambda$2(mapper, arg_0));
    }

    @NotNull
    public final Query<MacroExpansion> selectAll() {
        return this.selectAll(MacroExpansionQueries::selectAll$lambda$3);
    }

    public final void insert(@NotNull MacroExpansion MacroExpansion2) {
        Intrinsics.checkNotNullParameter((Object)MacroExpansion2, (String)"MacroExpansion");
        this.getDriver().execute(Integer.valueOf(-1356123169), "INSERT OR IGNORE INTO MacroExpansion (__macro_note_set_hash_id, __macro_note_id)\nVALUES (?, ?)", 2, arg_0 -> MacroExpansionQueries.insert$lambda$4(MacroExpansion2, arg_0));
        this.notifyQueries(-1356123169, MacroExpansionQueries::insert$lambda$5);
    }

    private static final Object verify_note$lambda$0(Function2 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        Long l2 = cursor.getLong(1);
        Intrinsics.checkNotNull((Object)l2);
        return $mapper.invoke((Object)l, (Object)l2);
    }

    private static final MacroExpansion verify_note$lambda$1(long __macro_note_set_hash_id, long __macro_note_id) {
        return new MacroExpansion(__macro_note_set_hash_id, __macro_note_id);
    }

    private static final Object selectAll$lambda$2(Function2 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        Long l2 = cursor.getLong(1);
        Intrinsics.checkNotNull((Object)l2);
        return $mapper.invoke((Object)l, (Object)l2);
    }

    private static final MacroExpansion selectAll$lambda$3(long __macro_note_set_hash_id, long __macro_note_id) {
        return new MacroExpansion(__macro_note_set_hash_id, __macro_note_id);
    }

    private static final Unit insert$lambda$4(MacroExpansion $MacroExpansion, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindLong(0, Long.valueOf($MacroExpansion.get__macro_note_set_hash_id()));
        $this$execute.bindLong(1, Long.valueOf($MacroExpansion.get__macro_note_id()));
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$5(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"MacroExpansion");
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ SqlDriver access$getDriver(MacroExpansionQueries $this) {
        return $this.getDriver();
    }
}

