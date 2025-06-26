/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.Query
 *  app.cash.sqldelight.QueryKt
 *  app.cash.sqldelight.TransacterImpl
 *  app.cash.sqldelight.db.SqlCursor
 *  app.cash.sqldelight.db.SqlDriver
 *  app.cash.sqldelight.db.SqlPreparedStatement
 *  cn.sast.framework.report.sqldelight.NoteExt
 *  cn.sast.framework.report.sqldelight.NoteExtQueries
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import cn.sast.framework.report.sqldelight.NoteExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005Jc\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2K\u0010\n\u001aG\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013\u00a8\u0006\u0017"}, d2={"Lcn/sast/framework/report/sqldelight/NoteExtQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "selectAll", "Lapp/cash/sqldelight/Query;", "T", "", "mapper", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "__note_id", "", "attr_name", "attr_value", "Lcn/sast/framework/report/sqldelight/NoteExt;", "insert", "", "NoteExt", "corax-framework"})
public final class NoteExtQueries
extends TransacterImpl {
    public NoteExtQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function3<? super Long, ? super String, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"NoteExt"};
        return QueryKt.Query((int)313069709, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"NoteExt.sq", (String)"selectAll", (String)"SELECT NoteExt.__note_id, NoteExt.attr_name, NoteExt.attr_value\nFROM NoteExt", arg_0 -> NoteExtQueries.selectAll$lambda$0(mapper, arg_0));
    }

    @NotNull
    public final Query<NoteExt> selectAll() {
        return this.selectAll(NoteExtQueries::selectAll$lambda$1);
    }

    public final void insert(@NotNull NoteExt NoteExt2) {
        Intrinsics.checkNotNullParameter((Object)NoteExt2, (String)"NoteExt");
        this.getDriver().execute(Integer.valueOf(-1109476815), "INSERT OR IGNORE INTO NoteExt (__note_id, attr_name, attr_value)\nVALUES (?, ?, ?)", 3, arg_0 -> NoteExtQueries.insert$lambda$2(NoteExt2, arg_0));
        this.notifyQueries(-1109476815, NoteExtQueries::insert$lambda$3);
    }

    private static final Object selectAll$lambda$0(Function3 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        String string = cursor.getString(1);
        Intrinsics.checkNotNull((Object)string);
        String string2 = cursor.getString(2);
        Intrinsics.checkNotNull((Object)string2);
        return $mapper.invoke((Object)l, (Object)string, (Object)string2);
    }

    private static final NoteExt selectAll$lambda$1(long __note_id, String attr_name, String attr_value) {
        Intrinsics.checkNotNullParameter((Object)attr_name, (String)"attr_name");
        Intrinsics.checkNotNullParameter((Object)attr_value, (String)"attr_value");
        return new NoteExt(__note_id, attr_name, attr_value);
    }

    private static final Unit insert$lambda$2(NoteExt $NoteExt, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindLong(0, Long.valueOf($NoteExt.get__note_id()));
        $this$execute.bindString(1, $NoteExt.getAttr_name());
        $this$execute.bindString(2, $NoteExt.getAttr_value());
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$3(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"NoteExt");
        return Unit.INSTANCE;
    }
}

