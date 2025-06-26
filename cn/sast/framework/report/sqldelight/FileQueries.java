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
 *  cn.sast.framework.report.sqldelight.File
 *  cn.sast.framework.report.sqldelight.FileQueries
 *  cn.sast.framework.report.sqldelight.FileQueries$IdQuery
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function7
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
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
import cn.sast.framework.report.sqldelight.File;
import cn.sast.framework.report.sqldelight.FileQueries;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u00bb\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0000\u0010\u000e*\u00020\u000f2\u00a2\u0001\u0010\u0010\u001a\u009d\u0001\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\u000e0\u0011J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00190\rJ.\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017\u00a8\u0006\u001d"}, d2={"Lcn/sast/framework/report/sqldelight/FileQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "id", "Lapp/cash/sqldelight/ExecutableQuery;", "", "file_raw_content_hash", "", "relative_path", "selectAll", "Lapp/cash/sqldelight/Query;", "T", "", "mapper", "Lkotlin/Function7;", "Lkotlin/ParameterName;", "name", "lines", "encoding", "file_raw_content_size", "", "file_raw_content", "Lcn/sast/framework/report/sqldelight/File;", "insert", "", "IdQuery", "corax-framework"})
public final class FileQueries
extends TransacterImpl {
    public FileQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final ExecutableQuery<Long> id(@NotNull String file_raw_content_hash, @NotNull String relative_path) {
        Intrinsics.checkNotNullParameter((Object)file_raw_content_hash, (String)"file_raw_content_hash");
        Intrinsics.checkNotNullParameter((Object)relative_path, (String)"relative_path");
        return (ExecutableQuery)new IdQuery(this, file_raw_content_hash, relative_path, FileQueries::id$lambda$0);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function7<? super Long, ? super String, ? super String, ? super Long, ? super String, ? super Long, ? super byte[], ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"File"};
        return QueryKt.Query((int)-1345738410, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"File.sq", (String)"selectAll", (String)"SELECT File.id, File.file_raw_content_hash, File.relative_path, File.lines, File.encoding, File.file_raw_content_size, File.file_raw_content\nFROM File", arg_0 -> FileQueries.selectAll$lambda$1(mapper, arg_0));
    }

    @NotNull
    public final Query<File> selectAll() {
        return this.selectAll(FileQueries::selectAll$lambda$2);
    }

    public final void insert(@NotNull String file_raw_content_hash, @NotNull String relative_path, long lines2, long file_raw_content_size, @NotNull byte[] file_raw_content) {
        Intrinsics.checkNotNullParameter((Object)file_raw_content_hash, (String)"file_raw_content_hash");
        Intrinsics.checkNotNullParameter((Object)relative_path, (String)"relative_path");
        Intrinsics.checkNotNullParameter((Object)file_raw_content, (String)"file_raw_content");
        Transacter.DefaultImpls.transaction$default((Transacter)((Transacter)this), (boolean)false, arg_0 -> FileQueries.insert$lambda$4(this, file_raw_content_hash, relative_path, lines2, file_raw_content_size, file_raw_content, arg_0), (int)1, null);
        this.notifyQueries(-204145144, FileQueries::insert$lambda$5);
    }

    private static final long id$lambda$0(SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        return l;
    }

    private static final Object selectAll$lambda$1(Function7 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        String string = cursor.getString(1);
        Intrinsics.checkNotNull((Object)string);
        String string2 = cursor.getString(2);
        Intrinsics.checkNotNull((Object)string2);
        Long l2 = cursor.getLong(3);
        Intrinsics.checkNotNull((Object)l2);
        String string3 = cursor.getString(4);
        Long l3 = cursor.getLong(5);
        Intrinsics.checkNotNull((Object)l3);
        byte[] byArray = cursor.getBytes(6);
        Intrinsics.checkNotNull((Object)byArray);
        return $mapper.invoke((Object)l, (Object)string, (Object)string2, (Object)l2, (Object)string3, (Object)l3, (Object)byArray);
    }

    private static final File selectAll$lambda$2(long id, String file_raw_content_hash, String relative_path, long lines2, String encoding, long file_raw_content_size, byte[] file_raw_content) {
        Intrinsics.checkNotNullParameter((Object)file_raw_content_hash, (String)"file_raw_content_hash");
        Intrinsics.checkNotNullParameter((Object)relative_path, (String)"relative_path");
        Intrinsics.checkNotNullParameter((Object)file_raw_content, (String)"file_raw_content");
        return new File(id, file_raw_content_hash, relative_path, lines2, encoding, file_raw_content_size, file_raw_content);
    }

    private static final Unit insert$lambda$4$lambda$3(String $file_raw_content_hash, String $relative_path, long $lines, long $file_raw_content_size, byte[] $file_raw_content, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $file_raw_content_hash);
        $this$execute.bindString(1, $relative_path);
        $this$execute.bindLong(2, Long.valueOf($lines));
        $this$execute.bindLong(3, Long.valueOf($file_raw_content_size));
        $this$execute.bindBytes(4, $file_raw_content);
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$4(FileQueries this$0, String $file_raw_content_hash, String $relative_path, long $lines, long $file_raw_content_size, byte[] $file_raw_content, TransactionWithoutReturn $this$transaction) {
        Intrinsics.checkNotNullParameter((Object)$this$transaction, (String)"$this$transaction");
        this$0.getDriver().execute(Integer.valueOf(1385015225), "INSERT OR IGNORE INTO File(file_raw_content_hash, relative_path, lines, file_raw_content_size, file_raw_content)\n    VALUES (?, ?, ?, ?, ?)", 5, arg_0 -> FileQueries.insert$lambda$4$lambda$3($file_raw_content_hash, $relative_path, $lines, $file_raw_content_size, $file_raw_content, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$5(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"File");
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ SqlDriver access$getDriver(FileQueries $this) {
        return $this.getDriver();
    }
}

