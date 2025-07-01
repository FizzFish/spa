package cn.sast.framework.report.sqlite;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.driver.jdbc.ConnectionManager;
import app.cash.sqldelight.driver.jdbc.JdbcDriver;
import java.sql.Connection;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JdbcSqliteDriverDelegate extends JdbcDriver implements ConnectionManager {
    public static final String IN_MEMORY = "jdbc:sqlite:";
    private final ConnectionManager delegate;
    private final LinkedHashMap<String, Set<Query.Listener>> listeners = new LinkedHashMap<>();

    public JdbcSqliteDriverDelegate(@NotNull ConnectionManager delegate) {
        if (delegate == null) {
            throw new IllegalArgumentException("delegate must not be null");
        }
        this.delegate = delegate;
    }

    protected final ConnectionManager getDelegate() {
        return delegate;
    }

    public void addListener(@NotNull String[] queryKeys, @NotNull Query.Listener listener) {
        if (queryKeys == null) {
            throw new IllegalArgumentException("queryKeys must not be null");
        }
        if (listener == null) {
            throw new IllegalArgumentException("listener must not be null");
        }

        synchronized (listeners) {
            for (String key : queryKeys) {
                listeners.computeIfAbsent(key, k -> new LinkedHashSet<>()).add(listener);
            }
        }
    }

    public void removeListener(@NotNull String[] queryKeys, @NotNull Query.Listener listener) {
        if (queryKeys == null) {
            throw new IllegalArgumentException("queryKeys must not be null");
        }
        if (listener == null) {
            throw new IllegalArgumentException("listener must not be null");
        }

        synchronized (listeners) {
            for (String key : queryKeys) {
                Set<Query.Listener> set = listeners.get(key);
                if (set != null) {
                    set.remove(listener);
                }
            }
        }
    }

    public void notifyListeners(@NotNull String... queryKeys) {
        if (queryKeys == null) {
            throw new IllegalArgumentException("queryKeys must not be null");
        }

        Set<Query.Listener> listenersToNotify = new LinkedHashSet<>();
        synchronized (listeners) {
            for (String key : queryKeys) {
                Set<Query.Listener> set = listeners.get(key);
                if (set != null) {
                    listenersToNotify.addAll(set);
                }
            }
        }

        for (Query.Listener listener : listenersToNotify) {
            listener.queryResultsChanged();
        }
    }

    public void endTransaction(@NotNull Connection connection) {
        if (connection == null) {
            throw new IllegalArgumentException("connection must not be null");
        }
        delegate.endTransaction(connection);
        delegate.setTransaction(null);
        closeConnection(connection);
    }

    public void close() {
        delegate.close();
    }

    public void beginTransaction(@NotNull Connection connection) {
        if (connection == null) {
            throw new IllegalArgumentException("connection must not be null");
        }
        delegate.beginTransaction(connection);
    }

    public void rollbackTransaction(@NotNull Connection connection) {
        if (connection == null) {
            throw new IllegalArgumentException("connection must not be null");
        }
        delegate.rollbackTransaction(connection);
    }

    @Nullable
    public ConnectionManager.Transaction getTransaction() {
        return delegate.getTransaction();
    }

    public void setTransaction(@Nullable ConnectionManager.Transaction value) {
        delegate.setTransaction(value);
    }

    public void closeConnection(@NotNull Connection connection) {
        if (connection == null) {
            throw new IllegalArgumentException("connection must not be null");
        }
        delegate.closeConnection(connection);
    }

    @NotNull
    public Connection getConnection() {
        return delegate.getConnection();
    }
}