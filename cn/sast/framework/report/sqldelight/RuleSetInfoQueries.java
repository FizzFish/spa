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
 *  cn.sast.framework.report.sqldelight.RuleSetInfo
 *  cn.sast.framework.report.sqldelight.RuleSetInfoQueries
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function8
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
import cn.sast.framework.report.sqldelight.RuleSetInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u00d6\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2\u00bd\u0001\u0010\n\u001a\u00b8\u0001\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017\u00a8\u0006\u001b"}, d2={"Lcn/sast/framework/report/sqldelight/RuleSetInfoQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "selectAll", "Lapp/cash/sqldelight/Query;", "T", "", "mapper", "Lkotlin/Function8;", "", "Lkotlin/ParameterName;", "name", "language", "description", "prefix", "id_pattern", "", "section_level", "version", "revision", "Lcn/sast/framework/report/sqldelight/RuleSetInfo;", "insert", "", "RuleSetInfo", "corax-framework"})
public final class RuleSetInfoQueries
extends TransacterImpl {
    public RuleSetInfoQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function8<? super String, ? super String, ? super String, ? super String, ? super String, ? super Long, ? super String, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"RuleSetInfo"};
        return QueryKt.Query((int)1731641704, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"RuleSetInfo.sq", (String)"selectAll", (String)"SELECT RuleSetInfo.name, RuleSetInfo.language, RuleSetInfo.description, RuleSetInfo.prefix, RuleSetInfo.id_pattern, RuleSetInfo.section_level, RuleSetInfo.version, RuleSetInfo.revision\nFROM RuleSetInfo", arg_0 -> RuleSetInfoQueries.selectAll$lambda$0(mapper, arg_0));
    }

    @NotNull
    public final Query<RuleSetInfo> selectAll() {
        return this.selectAll(RuleSetInfoQueries::selectAll$lambda$1);
    }

    public final void insert(@NotNull RuleSetInfo RuleSetInfo2) {
        Intrinsics.checkNotNullParameter((Object)RuleSetInfo2, (String)"RuleSetInfo");
        this.getDriver().execute(Integer.valueOf(1006841654), "INSERT OR IGNORE INTO RuleSetInfo (name, language, description, prefix, id_pattern, section_level, version, revision)\nVALUES (?, ?, ?, ?, ?, ?, ?, ?)", 8, arg_0 -> RuleSetInfoQueries.insert$lambda$2(RuleSetInfo2, arg_0));
        this.notifyQueries(1006841654, RuleSetInfoQueries::insert$lambda$3);
    }

    private static final Object selectAll$lambda$0(Function8 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        String string = cursor.getString(0);
        Intrinsics.checkNotNull((Object)string);
        String string2 = cursor.getString(1);
        Intrinsics.checkNotNull((Object)string2);
        String string3 = cursor.getString(2);
        String string4 = cursor.getString(3);
        String string5 = cursor.getString(4);
        Long l = cursor.getLong(5);
        String string6 = cursor.getString(6);
        Intrinsics.checkNotNull((Object)string6);
        String string7 = cursor.getString(7);
        Intrinsics.checkNotNull((Object)string7);
        return $mapper.invoke((Object)string, (Object)string2, (Object)string3, (Object)string4, (Object)string5, (Object)l, (Object)string6, (Object)string7);
    }

    private static final RuleSetInfo selectAll$lambda$1(String name, String language, String description, String prefix, String id_pattern, Long section_level, String version, String revision) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)language, (String)"language");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        Intrinsics.checkNotNullParameter((Object)revision, (String)"revision");
        return new RuleSetInfo(name, language, description, prefix, id_pattern, section_level, version, revision);
    }

    private static final Unit insert$lambda$2(RuleSetInfo $RuleSetInfo, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $RuleSetInfo.getName());
        $this$execute.bindString(1, $RuleSetInfo.getLanguage());
        $this$execute.bindString(2, $RuleSetInfo.getDescription());
        $this$execute.bindString(3, $RuleSetInfo.getPrefix());
        $this$execute.bindString(4, $RuleSetInfo.getId_pattern());
        $this$execute.bindLong(5, $RuleSetInfo.getSection_level());
        $this$execute.bindString(6, $RuleSetInfo.getVersion());
        $this$execute.bindString(7, $RuleSetInfo.getRevision());
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$3(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"RuleSetInfo");
        return Unit.INSTANCE;
    }
}

