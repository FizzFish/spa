/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.Query$Listener
 *  app.cash.sqldelight.driver.jdbc.ConnectionManager
 *  app.cash.sqldelight.driver.jdbc.ConnectionManager$Transaction
 *  app.cash.sqldelight.driver.jdbc.JdbcDriver
 *  cn.sast.framework.report.sqlite.JdbcSqliteDriverDelegate
 *  cn.sast.framework.report.sqlite.JdbcSqliteDriverDelegate$Companion
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.sqlite;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.driver.jdbc.ConnectionManager;
import app.cash.sqldelight.driver.jdbc.JdbcDriver;
import cn.sast.framework.report.sqlite.JdbcSqliteDriverDelegate;
import java.sql.Connection;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0011\"\u00020\n2\u0006\u0010\u0012\u001a\u00020\fH\u0016\u00a2\u0006\u0002\u0010\u0013J)\u0010\u0014\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0011\"\u00020\n2\u0006\u0010\u0012\u001a\u00020\fH\u0016\u00a2\u0006\u0002\u0010\u0013J!\u0010\u0015\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0011\"\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u0016J\f\u0010\u0017\u001a\u00020\u000f*\u00020\u0018H\u0016J\r\u0010\u0019\u001a\u00020\u000f*\u00020\u0018H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0018H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0018H\u0096\u0001J\r\u0010\u001e\u001a\u00020\u000f*\u00020\u0018H\u0096\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R6\u0010\b\u001a*\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tj\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b`\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u0004\u0018\u00010 X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006&"}, d2={"Lcn/sast/framework/report/sqlite/JdbcSqliteDriverDelegate;", "Lapp/cash/sqldelight/driver/jdbc/JdbcDriver;", "Lapp/cash/sqldelight/driver/jdbc/ConnectionManager;", "delegate", "<init>", "(Lapp/cash/sqldelight/driver/jdbc/ConnectionManager;)V", "getDelegate", "()Lapp/cash/sqldelight/driver/jdbc/ConnectionManager;", "listeners", "Ljava/util/LinkedHashMap;", "", "", "Lapp/cash/sqldelight/Query$Listener;", "Lkotlin/collections/LinkedHashMap;", "addListener", "", "queryKeys", "", "listener", "([Ljava/lang/String;Lapp/cash/sqldelight/Query$Listener;)V", "removeListener", "notifyListeners", "([Ljava/lang/String;)V", "endTransaction", "Ljava/sql/Connection;", "beginTransaction", "close", "closeConnection", "connection", "getConnection", "rollbackTransaction", "transaction", "Lapp/cash/sqldelight/driver/jdbc/ConnectionManager$Transaction;", "getTransaction", "()Lapp/cash/sqldelight/driver/jdbc/ConnectionManager$Transaction;", "setTransaction", "(Lapp/cash/sqldelight/driver/jdbc/ConnectionManager$Transaction;)V", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nJdbcSqliteDriverDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JdbcSqliteDriverDelegate.kt\ncn/sast/framework/report/sqlite/JdbcSqliteDriverDelegate\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,49:1\n13409#2:50\n13410#2:58\n13409#2,2:59\n13409#2:61\n13410#2:63\n381#3,7:51\n1#4:62\n1863#5,2:64\n*S KotlinDebug\n*F\n+ 1 JdbcSqliteDriverDelegate.kt\ncn/sast/framework/report/sqlite/JdbcSqliteDriverDelegate\n*L\n17#1:50\n17#1:58\n25#1:59,2\n34#1:61\n34#1:63\n18#1:51,7\n36#1:64,2\n*E\n"})
public class JdbcSqliteDriverDelegate
extends JdbcDriver
implements ConnectionManager {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ConnectionManager delegate;
    @NotNull
    private final LinkedHashMap<String, Set<Query.Listener>> listeners;
    @NotNull
    public static final String IN_MEMORY = "jdbc:sqlite:";

    public JdbcSqliteDriverDelegate(@NotNull ConnectionManager delegate) {
        Intrinsics.checkNotNullParameter((Object)delegate, (String)"delegate");
        this.delegate = delegate;
        this.listeners = new LinkedHashMap();
    }

    @NotNull
    protected final ConnectionManager getDelegate() {
        return this.delegate;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addListener(@NotNull String[] queryKeys, @NotNull Query.Listener listener) {
        Intrinsics.checkNotNullParameter((Object)queryKeys, (String)"queryKeys");
        Intrinsics.checkNotNullParameter((Object)listener, (String)"listener");
        LinkedHashMap linkedHashMap = this.listeners;
        synchronized (linkedHashMap) {
            boolean bl = false;
            String[] $this$forEach$iv = queryKeys;
            boolean $i$f$forEach = false;
            int n = $this$forEach$iv.length;
            for (int i = 0; i < n; ++i) {
                Object object;
                String element$iv;
                String it = element$iv = $this$forEach$iv[i];
                boolean bl2 = false;
                Map $this$getOrPut$iv = this.listeners;
                boolean $i$f$getOrPut = false;
                Object value$iv = $this$getOrPut$iv.get(it);
                if (value$iv == null) {
                    boolean bl3 = false;
                    Set answer$iv = new LinkedHashSet();
                    $this$getOrPut$iv.put(it, answer$iv);
                    object = answer$iv;
                } else {
                    object = value$iv;
                }
                ((Set)object).add(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeListener(@NotNull String[] queryKeys, @NotNull Query.Listener listener) {
        Intrinsics.checkNotNullParameter((Object)queryKeys, (String)"queryKeys");
        Intrinsics.checkNotNullParameter((Object)listener, (String)"listener");
        LinkedHashMap linkedHashMap = this.listeners;
        synchronized (linkedHashMap) {
            boolean bl = false;
            String[] $this$forEach$iv = queryKeys;
            boolean $i$f$forEach = false;
            int n = $this$forEach$iv.length;
            for (int i = 0; i < n; ++i) {
                String element$iv;
                String it = element$iv = $this$forEach$iv[i];
                boolean bl2 = false;
                Set set = (Set)this.listeners.get(it);
                if (set == null) continue;
                set.remove(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifyListeners(String ... queryKeys) {
        Intrinsics.checkNotNullParameter((Object)queryKeys, (String)"queryKeys");
        LinkedHashSet listenersToNotify = new LinkedHashSet();
        LinkedHashMap linkedHashMap = this.listeners;
        synchronized (linkedHashMap) {
            boolean bl = false;
            String[] $this$forEach$iv = queryKeys;
            boolean $i$f$forEach = false;
            int n = $this$forEach$iv.length;
            for (int i = 0; i < n; ++i) {
                String element$iv;
                String it = element$iv = $this$forEach$iv[i];
                boolean bl2 = false;
                Set set = (Set)this.listeners.get(it);
                if (set == null) continue;
                Collection p0 = set;
                boolean bl3 = false;
                boolean $i$f$notifyListeners$lambda$6$lambda$5$stub_for_inlining = false;
                listenersToNotify.addAll(p0);
            }
            Unit unit = Unit.INSTANCE;
        }
        Iterable $this$forEach$iv = listenersToNotify;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Query.Listener p0 = (Query.Listener)element$iv;
            boolean $i$f$notifyListeners$stub_for_inlining$7 = false;
            boolean bl = false;
            p0.queryResultsChanged();
        }
    }

    public void endTransaction(@NotNull Connection $this$endTransaction) {
        Intrinsics.checkNotNullParameter((Object)$this$endTransaction, (String)"<this>");
        ConnectionManager $this$endTransaction_u24lambda_u248 = this.delegate;
        boolean bl = false;
        $this$endTransaction_u24lambda_u248.endTransaction($this$endTransaction);
        this.delegate.setTransaction(null);
        this.closeConnection($this$endTransaction);
    }

    public void close() {
        this.delegate.close();
    }

    public void beginTransaction(@NotNull Connection $this$beginTransaction) {
        Intrinsics.checkNotNullParameter((Object)$this$beginTransaction, (String)"<this>");
        this.delegate.beginTransaction($this$beginTransaction);
    }

    public void rollbackTransaction(@NotNull Connection $this$rollbackTransaction) {
        Intrinsics.checkNotNullParameter((Object)$this$rollbackTransaction, (String)"<this>");
        this.delegate.rollbackTransaction($this$rollbackTransaction);
    }

    @Nullable
    public ConnectionManager.Transaction getTransaction() {
        return this.delegate.getTransaction();
    }

    public void setTransaction(@Nullable ConnectionManager.Transaction value) {
        this.delegate.setTransaction(value);
    }

    public void closeConnection(@NotNull Connection connection) {
        Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
        this.delegate.closeConnection(connection);
    }

    @NotNull
    public Connection getConnection() {
        return this.delegate.getConnection();
    }
}

