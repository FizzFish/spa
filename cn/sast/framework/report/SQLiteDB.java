/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.db.SqlDriver
 *  app.cash.sqldelight.driver.jdbc.JdbcDriver
 *  cn.sast.framework.report.SQLiteDB
 *  cn.sast.framework.report.SQLiteDB$Companion
 *  cn.sast.framework.report.SqliteDiagnostics
 *  cn.sast.framework.report.sqldelight.Database
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report;

import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.driver.jdbc.JdbcDriver;
import cn.sast.framework.report.SQLiteDB;
import cn.sast.framework.report.SqliteDiagnostics;
import cn.sast.framework.report.sqldelight.Database;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0006\u0010\u000f\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lcn/sast/framework/report/SQLiteDB;", "Ljava/io/Closeable;", "dbPath", "", "driver", "Lapp/cash/sqldelight/driver/jdbc/JdbcDriver;", "database", "Lcn/sast/framework/report/sqldelight/Database;", "journalMode", "<init>", "(Ljava/lang/String;Lapp/cash/sqldelight/driver/jdbc/JdbcDriver;Lcn/sast/framework/report/sqldelight/Database;Ljava/lang/String;)V", "getDatabase", "()Lcn/sast/framework/report/sqldelight/Database;", "close", "", "createSchema", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nSqliteDiagnostics.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SqliteDiagnostics.kt\ncn/sast/framework/report/SQLiteDB\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,813:1\n1#2:814\n*E\n"})
public final class SQLiteDB
implements Closeable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String dbPath;
    @NotNull
    private final JdbcDriver driver;
    @NotNull
    private final Database database;
    @NotNull
    private final String journalMode;

    private SQLiteDB(String dbPath, JdbcDriver driver, Database database, String journalMode) {
        this.dbPath = dbPath;
        this.driver = driver;
        this.database = database;
        this.journalMode = journalMode;
    }

    @NotNull
    public final Database getDatabase() {
        return this.database;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        this.driver.close();
        if (!Intrinsics.areEqual((Object)this.journalMode, (Object)"OFF")) {
            Closeable closeable = (Closeable)SqliteDiagnostics.Companion.openDataBase(this.dbPath, "OFF");
            Throwable throwable = null;
            try {
                SQLiteDB it = (SQLiteDB)closeable;
                boolean bl = false;
                Unit unit = Unit.INSTANCE;
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
            }
        }
    }

    public final void createSchema() {
        Database.Companion.getSchema().create((SqlDriver)this.driver);
    }

    public /* synthetic */ SQLiteDB(String dbPath, JdbcDriver driver, Database database, String journalMode, DefaultConstructorMarker $constructor_marker) {
        this(dbPath, driver, database, journalMode);
    }
}

