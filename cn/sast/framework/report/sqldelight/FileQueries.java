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

import java.util.function.Function;

public final class FileQueries extends TransacterImpl {
    public FileQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public final ExecutableQuery<Long> id(@NotNull String fileRawContentHash, @NotNull String relativePath) {
        return new IdQuery(this, fileRawContentHash, relativePath, cursor -> {
            Long id = cursor.getLong(0);
            if (id == null) {
                throw new IllegalStateException("id cannot be null");
            }
            return id;
        });
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function7<Long, String, String, Long, String, Long, byte[], T> mapper) {
        String[] tables = {"File"};
        return QueryKt.Query(
            -1345738410,
            tables,
            this.getDriver(),
            "File.sq",
            "selectAll",
            "SELECT File.id, File.file_raw_content_hash, File.relative_path, File.lines, File.encoding, File.file_raw_content_size, File.file_raw_content\nFROM File",
            cursor -> {
                Long id = requireNonNull(cursor.getLong(0));
                String hash = requireNonNull(cursor.getString(1));
                String path = requireNonNull(cursor.getString(2));
                Long lines = requireNonNull(cursor.getLong(3));
                String encoding = cursor.getString(4);
                Long size = requireNonNull(cursor.getLong(5));
                byte[] content = requireNonNull(cursor.getBytes(6));
                return mapper.apply(id, hash, path, lines, encoding, size, content);
            }
        );
    }

    @NotNull
    public final Query<File> selectAll() {
        return selectAll(File::new);
    }

    public final void insert(
        @NotNull String fileRawContentHash,
        @NotNull String relativePath,
        long lines,
        long fileRawContentSize,
        @NotNull byte[] fileRawContent
    ) {
        transaction(false, transaction -> {
            getDriver().execute(
                1385015225,
                "INSERT OR IGNORE INTO File(file_raw_content_hash, relative_path, lines, file_raw_content_size, file_raw_content)\n    VALUES (?, ?, ?, ?, ?)",
                5,
                stmt -> {
                    stmt.bindString(0, fileRawContentHash);
                    stmt.bindString(1, relativePath);
                    stmt.bindLong(2, lines);
                    stmt.bindLong(3, fileRawContentSize);
                    stmt.bindBytes(4, fileRawContent);
                    return null;
                }
            );
            return null;
        });
        notifyQueries(-204145144, emit -> {
            emit.apply("File");
            return null;
        });
    }

    private static <T> T requireNonNull(T obj) {
        if (obj == null) {
            throw new IllegalStateException("Required value was null");
        }
        return obj;
    }

    private static final class IdQuery extends ExecutableQuery<Long> {
        private final FileQueries queries;
        private final String fileRawContentHash;
        private final String relativePath;
        private final Function<SqlCursor, Long> mapper;

        IdQuery(FileQueries queries, String fileRawContentHash, String relativePath, Function<SqlCursor, Long> mapper) {
            super(queries.getDriver());
            this.queries = queries;
            this.fileRawContentHash = fileRawContentHash;
            this.relativePath = relativePath;
            this.mapper = mapper;
        }

        @Override
        protected Long execute(SqlPreparedStatement stmt) {
            stmt.bindString(0, fileRawContentHash);
            stmt.bindString(1, relativePath);
            try (SqlCursor cursor = stmt.executeQuery()) {
                return mapper.apply(cursor);
            }
        }
    }

    @FunctionalInterface
    public interface Function7<A, B, C, D, E, F, G, R> {
        R apply(A a, B b, C c, D d, E e, F f, G g);
    }
}