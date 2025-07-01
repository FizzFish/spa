package cn.sast.framework.report;

import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.driver.jdbc.JdbcDriver;
import cn.sast.framework.report.sqldelight.Database;
import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

public final class SQLiteDB implements Closeable {
    public static final class Companion {
        private Companion() {}
    }

    public static final Companion Companion = new Companion();

    @NotNull
    private final String dbPath;
    @NotNull
    private final JdbcDriver driver;
    @NotNull
    private final Database database;
    @NotNull
    private final String journalMode;

    private SQLiteDB(@NotNull String dbPath, @NotNull JdbcDriver driver, 
                     @NotNull Database database, @NotNull String journalMode) {
        this.dbPath = dbPath;
        this.driver = driver;
        this.database = database;
        this.journalMode = journalMode;
    }

    @NotNull
    public Database getDatabase() {
        return database;
    }

    @Override
    public void close() throws IOException {
        driver.close();
        if (!"OFF".equals(journalMode)) {
            try (SQLiteDB ignored = SqliteDiagnostics.Companion.openDataBase(dbPath, "OFF")) {
                // Just open and close to set journal mode
            }
        }
    }

    public void createSchema() {
        Database.Companion.getSchema().create(driver);
    }
}