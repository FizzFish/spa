package cn.sast.framework.report.sqldelight.coraxframework;

import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlSchema;
import cn.sast.framework.report.sqldelight.Database;
import org.jetbrains.annotations.NotNull;

public final class DatabaseImplKt {
    @NotNull
    public static SqlSchema<QueryResult.Value<Void>> getSchema(@NotNull Class<Database> clazz) {
        return DatabaseImpl.Schema.INSTANCE;
    }

    @NotNull
    public static Database newInstance(@NotNull Class<Database> clazz, @NotNull SqlDriver driver) {
        return new DatabaseImpl(driver);
    }
}