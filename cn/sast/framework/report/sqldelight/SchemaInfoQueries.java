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
 *  cn.sast.framework.report.sqldelight.SchemaInfo
 *  cn.sast.framework.report.sqldelight.SchemaInfoQueries
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
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
import cn.sast.framework.report.sqldelight.SchemaInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005JN\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t26\u0010\n\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011\u00a8\u0006\u0015"}, d2={"Lcn/sast/framework/report/sqldelight/SchemaInfoQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "selectAll", "Lapp/cash/sqldelight/Query;", "T", "", "mapper", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "key", "value_", "Lcn/sast/framework/report/sqldelight/SchemaInfo;", "insert", "", "SchemaInfo", "corax-framework"})
public final class SchemaInfoQueries
extends TransacterImpl {
    public SchemaInfoQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function2<? super String, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"SchemaInfo"};
        return QueryKt.Query((int)-1428765821, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"SchemaInfo.sq", (String)"selectAll", (String)"SELECT SchemaInfo.key, SchemaInfo.value FROM SchemaInfo", arg_0 -> SchemaInfoQueries.selectAll$lambda$0(mapper, arg_0));
    }

    @NotNull
    public final Query<SchemaInfo> selectAll() {
        return this.selectAll(SchemaInfoQueries::selectAll$lambda$1);
    }

    public final void insert(@NotNull SchemaInfo SchemaInfo2) {
        Intrinsics.checkNotNullParameter((Object)SchemaInfo2, (String)"SchemaInfo");
        this.getDriver().execute(Integer.valueOf(710466299), "INSERT OR IGNORE INTO SchemaInfo (key, value) VALUES (?, ?)", 2, arg_0 -> SchemaInfoQueries.insert$lambda$2(SchemaInfo2, arg_0));
        this.notifyQueries(710466299, SchemaInfoQueries::insert$lambda$3);
    }

    private static final Object selectAll$lambda$0(Function2 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        String string = cursor.getString(0);
        Intrinsics.checkNotNull((Object)string);
        String string2 = cursor.getString(1);
        Intrinsics.checkNotNull((Object)string2);
        return $mapper.invoke((Object)string, (Object)string2);
    }

    private static final SchemaInfo selectAll$lambda$1(String key2, String value_) {
        Intrinsics.checkNotNullParameter((Object)key2, (String)"key");
        Intrinsics.checkNotNullParameter((Object)value_, (String)"value_");
        return new SchemaInfo(key2, value_);
    }

    private static final Unit insert$lambda$2(SchemaInfo $SchemaInfo, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $SchemaInfo.getKey());
        $this$execute.bindString(1, $SchemaInfo.getValue_());
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$3(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"SchemaInfo");
        return Unit.INSTANCE;
    }
}

