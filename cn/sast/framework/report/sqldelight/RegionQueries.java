package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.ExecutableQuery;
import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.TransactionWithoutReturn;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.function.Function;

public final class RegionQueries extends TransacterImpl {
    public RegionQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public ExecutableQuery<Long> id(long fileId, long startLine, @Nullable Long startColumn, 
                                  @Nullable Long endLine, @Nullable Long endColumn) {
        return new IdQuery(this, fileId, startLine, startColumn, endLine, endColumn, cursor -> {
            Long id = cursor.getLong(0);
            if (id == null) throw new IllegalStateException("id cannot be null");
            return id;
        });
    }

    @NotNull
    public <T> Query<T> selectAll(@NotNull Function<Region, T> mapper) {
        String[] tables = {"Region"};
        return QueryKt.Query(-1166723042, tables, getDriver(), "Region.sq", "selectAll",
            "SELECT Region.id, Region.__file_id, Region.start_line, Region.start_column, Region.end_line, Region.end_column\nFROM Region",
            cursor -> {
                Long id = cursor.getLong(0);
                Long fileId = cursor.getLong(1);
                Long startLine = cursor.getLong(2);
                if (id == null || fileId == null || startLine == null) {
                    throw new IllegalStateException("Required fields cannot be null");
                }
                return mapper.apply(new Region(
                    id, fileId, startLine,
                    cursor.getLong(3), cursor.getLong(4), cursor.getLong(5)
                );
            });
    }

    @NotNull
    public Query<Region> selectAll() {
        return selectAll(region -> region);
    }

    public void insert(long fileId, long startLine, @Nullable Long startColumn, 
                      @Nullable Long endLine, @Nullable Long endColumn) {
        transaction(false, tx -> {
            getDriver().execute(0x511FF1, 
                "INSERT OR IGNORE INTO Region(__file_id, start_line, start_column, end_line, end_column)\nVALUES (?, ?, ?, ?, ?)", 
                5, stmt -> {
                    stmt.bindLong(0, fileId);
                    stmt.bindLong(1, startLine);
                    stmt.bindLong(2, startColumn);
                    stmt.bindLong(3, endLine);
                    stmt.bindLong(4, endColumn);
                });
        });
        notifyQueries(1577657408, emit -> emit.accept("Region"));
    }

    private static final class IdQuery extends ExecutableQuery<Long> {
        private final RegionQueries queries;
        private final long fileId;
        private final long startLine;
        private final Long startColumn;
        private final Long endLine;
        private final Long endColumn;
        private final Function<SqlCursor, Long> mapper;

        IdQuery(RegionQueries queries, long fileId, long startLine, Long startColumn, 
               Long endLine, Long endColumn, Function<SqlCursor, Long> mapper) {
            this.queries = queries;
            this.fileId = fileId;
            this.startLine = startLine;
            this.startColumn = startColumn;
            this.endLine = endLine;
            this.endColumn = endColumn;
            this.mapper = mapper;
        }

        @Override
        public Long execute() {
            return queries.getDriver().executeQuery(0, 
                "SELECT id FROM Region WHERE __file_id = ? AND start_line = ? AND start_column = ? AND end_line = ? AND end_column = ?",
                5, stmt -> {
                    stmt.bindLong(0, fileId);
                    stmt.bindLong(1, startLine);
                    stmt.bindLong(2, startColumn);
                    stmt.bindLong(3, endLine);
                    stmt.bindLong(4, endColumn);
                }, mapper);
        }
    }
}