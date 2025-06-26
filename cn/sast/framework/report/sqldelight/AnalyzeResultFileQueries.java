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
 *  cn.sast.framework.report.sqldelight.AnalyzeResultFileQueries
 *  cn.sast.framework.report.sqldelight.AnalyzeResultFileQueries$Verify_fileQuery
 *  cn.sast.framework.report.sqldelight.AnalyzerResultFile
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
import cn.sast.framework.report.sqldelight.AnalyzeResultFileQueries;
import cn.sast.framework.report.sqldelight.AnalyzerResultFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005Je\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2M\u0010\n\u001aI\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007Je\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\b0\u0015\"\b\b\u0000\u0010\b*\u00020\t2M\u0010\n\u001aI\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013\u00a8\u0006\u001a"}, d2={"Lcn/sast/framework/report/sqldelight/AnalyzeResultFileQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "verify_file", "Lapp/cash/sqldelight/ExecutableQuery;", "T", "", "mapper", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "file_name", "file_path", "", "__file_id", "Lcn/sast/framework/report/sqldelight/AnalyzerResultFile;", "selectAll", "Lapp/cash/sqldelight/Query;", "insert", "", "AnalyzerResultFile", "Verify_fileQuery", "corax-framework"})
public final class AnalyzeResultFileQueries
extends TransacterImpl {
    public AnalyzeResultFileQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_file(@NotNull Function3<? super String, ? super String, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return (ExecutableQuery)new Verify_fileQuery(this, arg_0 -> AnalyzeResultFileQueries.verify_file$lambda$0(mapper, arg_0));
    }

    @NotNull
    public final ExecutableQuery<AnalyzerResultFile> verify_file() {
        return this.verify_file(AnalyzeResultFileQueries::verify_file$lambda$1);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function3<? super String, ? super String, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"AnalyzerResultFile"};
        return QueryKt.Query((int)1331798327, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"AnalyzeResultFile.sq", (String)"selectAll", (String)"SELECT AnalyzerResultFile.file_name, AnalyzerResultFile.file_path, AnalyzerResultFile.__file_id\nFROM AnalyzerResultFile", arg_0 -> AnalyzeResultFileQueries.selectAll$lambda$2(mapper, arg_0));
    }

    @NotNull
    public final Query<AnalyzerResultFile> selectAll() {
        return this.selectAll(AnalyzeResultFileQueries::selectAll$lambda$3);
    }

    public final void insert(@NotNull AnalyzerResultFile AnalyzerResultFile2) {
        Intrinsics.checkNotNullParameter((Object)AnalyzerResultFile2, (String)"AnalyzerResultFile");
        this.getDriver().execute(Integer.valueOf(397277639), "INSERT OR IGNORE INTO AnalyzerResultFile (file_name, file_path, __file_id)\nVALUES (?, ?, ?)", 3, arg_0 -> AnalyzeResultFileQueries.insert$lambda$4(AnalyzerResultFile2, arg_0));
        this.notifyQueries(397277639, AnalyzeResultFileQueries::insert$lambda$5);
    }

    private static final Object verify_file$lambda$0(Function3 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        String string = cursor.getString(0);
        Intrinsics.checkNotNull((Object)string);
        String string2 = cursor.getString(1);
        Long l = cursor.getLong(2);
        Intrinsics.checkNotNull((Object)l);
        return $mapper.invoke((Object)string, (Object)string2, (Object)l);
    }

    private static final AnalyzerResultFile verify_file$lambda$1(String file_name, String file_path, long __file_id) {
        Intrinsics.checkNotNullParameter((Object)file_name, (String)"file_name");
        return new AnalyzerResultFile(file_name, file_path, __file_id);
    }

    private static final Object selectAll$lambda$2(Function3 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        String string = cursor.getString(0);
        Intrinsics.checkNotNull((Object)string);
        String string2 = cursor.getString(1);
        Long l = cursor.getLong(2);
        Intrinsics.checkNotNull((Object)l);
        return $mapper.invoke((Object)string, (Object)string2, (Object)l);
    }

    private static final AnalyzerResultFile selectAll$lambda$3(String file_name, String file_path, long __file_id) {
        Intrinsics.checkNotNullParameter((Object)file_name, (String)"file_name");
        return new AnalyzerResultFile(file_name, file_path, __file_id);
    }

    private static final Unit insert$lambda$4(AnalyzerResultFile $AnalyzerResultFile, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $AnalyzerResultFile.getFile_name());
        $this$execute.bindString(1, $AnalyzerResultFile.getFile_path());
        $this$execute.bindLong(2, Long.valueOf($AnalyzerResultFile.get__file_id()));
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$5(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"AnalyzerResultFile");
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ SqlDriver access$getDriver(AnalyzeResultFileQueries $this) {
        return $this.getDriver();
    }
}

