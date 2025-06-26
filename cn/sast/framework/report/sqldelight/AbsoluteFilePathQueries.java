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
 *  cn.sast.framework.report.sqldelight.AbsoluteFilePath
 *  cn.sast.framework.report.sqldelight.AbsoluteFilePathQueries
 *  cn.sast.framework.report.sqldelight.AbsoluteFilePathQueries$Verify_absolute_file_pathQuery
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
import cn.sast.framework.report.sqldelight.AbsoluteFilePath;
import cn.sast.framework.report.sqldelight.AbsoluteFilePathQueries;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005JN\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t26\u0010\n\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007JN\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0014\"\b\b\u0000\u0010\b*\u00020\t26\u0010\n\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012\u00a8\u0006\u0019"}, d2={"Lcn/sast/framework/report/sqldelight/AbsoluteFilePathQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "verify_absolute_file_path", "Lapp/cash/sqldelight/ExecutableQuery;", "T", "", "mapper", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "file_abs_path", "", "__file_id", "Lcn/sast/framework/report/sqldelight/AbsoluteFilePath;", "selectAll", "Lapp/cash/sqldelight/Query;", "insert", "", "AbsoluteFilePath", "Verify_absolute_file_pathQuery", "corax-framework"})
public final class AbsoluteFilePathQueries
extends TransacterImpl {
    public AbsoluteFilePathQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_absolute_file_path(@NotNull Function2<? super String, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return (ExecutableQuery)new Verify_absolute_file_pathQuery(this, arg_0 -> AbsoluteFilePathQueries.verify_absolute_file_path$lambda$0(mapper, arg_0));
    }

    @NotNull
    public final ExecutableQuery<AbsoluteFilePath> verify_absolute_file_path() {
        return this.verify_absolute_file_path(AbsoluteFilePathQueries::verify_absolute_file_path$lambda$1);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function2<? super String, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"AbsoluteFilePath"};
        return QueryKt.Query((int)77310330, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"AbsoluteFilePath.sq", (String)"selectAll", (String)"SELECT AbsoluteFilePath.file_abs_path, AbsoluteFilePath.__file_id\nFROM AbsoluteFilePath", arg_0 -> AbsoluteFilePathQueries.selectAll$lambda$2(mapper, arg_0));
    }

    @NotNull
    public final Query<AbsoluteFilePath> selectAll() {
        return this.selectAll(AbsoluteFilePathQueries::selectAll$lambda$3);
    }

    public final void insert(@NotNull AbsoluteFilePath AbsoluteFilePath2) {
        Intrinsics.checkNotNullParameter((Object)AbsoluteFilePath2, (String)"AbsoluteFilePath");
        this.getDriver().execute(Integer.valueOf(365662308), "INSERT OR IGNORE INTO AbsoluteFilePath (file_abs_path, __file_id) VALUES (?, ?)", 2, arg_0 -> AbsoluteFilePathQueries.insert$lambda$4(AbsoluteFilePath2, arg_0));
        this.notifyQueries(365662308, AbsoluteFilePathQueries::insert$lambda$5);
    }

    private static final Object verify_absolute_file_path$lambda$0(Function2 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        String string = cursor.getString(0);
        Intrinsics.checkNotNull((Object)string);
        Long l = cursor.getLong(1);
        Intrinsics.checkNotNull((Object)l);
        return $mapper.invoke((Object)string, (Object)l);
    }

    private static final AbsoluteFilePath verify_absolute_file_path$lambda$1(String file_abs_path, long __file_id) {
        Intrinsics.checkNotNullParameter((Object)file_abs_path, (String)"file_abs_path");
        return new AbsoluteFilePath(file_abs_path, __file_id);
    }

    private static final Object selectAll$lambda$2(Function2 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        String string = cursor.getString(0);
        Intrinsics.checkNotNull((Object)string);
        Long l = cursor.getLong(1);
        Intrinsics.checkNotNull((Object)l);
        return $mapper.invoke((Object)string, (Object)l);
    }

    private static final AbsoluteFilePath selectAll$lambda$3(String file_abs_path, long __file_id) {
        Intrinsics.checkNotNullParameter((Object)file_abs_path, (String)"file_abs_path");
        return new AbsoluteFilePath(file_abs_path, __file_id);
    }

    private static final Unit insert$lambda$4(AbsoluteFilePath $AbsoluteFilePath, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $AbsoluteFilePath.getFile_abs_path());
        $this$execute.bindLong(1, Long.valueOf($AbsoluteFilePath.get__file_id()));
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$5(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"AbsoluteFilePath");
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ SqlDriver access$getDriver(AbsoluteFilePathQueries $this) {
        return $this.getDriver();
    }
}

