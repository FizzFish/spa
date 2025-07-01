package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public final class SchemaInfoQueries extends TransacterImpl {
    public SchemaInfoQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull BiFunction<String, String, T> mapper) {
        String[] stringArray = {"SchemaInfo"};
        return Query.create(
            -1428765821,
            stringArray,
            this.getDriver(),
            "SchemaInfo.sq",
            "selectAll",
            "SELECT SchemaInfo.key, SchemaInfo.value FROM SchemaInfo",
            cursor -> mapper.apply(cursor.getString(0), cursor.getString(1))
        );
    }

    @NotNull
    public final Query<SchemaInfo> selectAll() {
        return this.selectAll(SchemaInfo::new);
    }

    public final void insert(@NotNull SchemaInfo schemaInfo) {
        this.getDriver().execute(
            710466299,
            "INSERT OR IGNORE INTO SchemaInfo (key, value) VALUES (?, ?)",
            2,
            stmt -> {
                stmt.bindString(0, schemaInfo.getKey());
                stmt.bindString(1, schemaInfo.getValue_());
            }
        );
        this.notifyQueries(710466299, emit -> emit.accept("SchemaInfo"));
    }
}