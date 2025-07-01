package com.feysh.corax.cache.coroutines;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Expiry;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.RemovalListener;
import com.github.benmanes.caffeine.cache.Ticker;
import com.github.benmanes.caffeine.cache.Weigher;
import com.github.benmanes.caffeine.cache.stats.StatsCounter;
import java.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class XCache<K, V> {
    @NotNull
    private final Configuration<K, V> config;
    @NotNull
    private final Caffeine<Object, Object> caffeine;

    private XCache(@NotNull Configuration<K, V> config, @NotNull Caffeine<Object, Object> caffeine) {
        this.config = config;
        this.caffeine = caffeine;
    }

    @NotNull
    public Configuration<K, V> getConfig() {
        return config;
    }

    @NotNull
    public Caffeine<Object, Object> getCaffeine() {
        return caffeine;
    }

    public boolean getUseCallingContext() {
        return config.getUseCallingContext();
    }

    @Nullable
    public StatsCounter getStats() {
        return config.getStatsCounter();
    }

    @NotNull
    public Cache<K, V> build() {
        return caffeine.build();
    }

    public static final class Builder {
        private Builder() {}

        @NotNull
        public static <K, V> XCache<K, V> create(@NotNull Configuration<K, V> config) {
            Caffeine<Object, Object> caffeine = Caffeine.newBuilder();

            if (config.getEvictionListener() != null) {
                caffeine.evictionListener((key, value, cause) -> 
                    config.getEvictionListener().invoke(key, value, cause, null));
            }

            if (config.getRemovalListener() != null) {
                caffeine.removalListener((key, value, cause) -> 
                    config.getRemovalListener().invoke(key, value, cause, null));
            }

            if (config.getInitialCapacity() != null) {
                caffeine.initialCapacity(config.getInitialCapacity());
            }

            if (config.getTicker() != null) {
                caffeine.ticker(() -> config.getTicker().invoke());
            }

            if (config.getMaximumSize() != null) {
                caffeine.maximumSize(config.getMaximumSize());
            }

            if (config.getMaximumWeight() != null) {
                caffeine.maximumWeight(config.getMaximumWeight());
            }

            if (config.getWeigher() != null) {
                caffeine.weigher((key, value) -> config.getWeigher().invoke(key, value));
            }

            if (config.getExpireAfterWrite() != null) {
                caffeine.expireAfterWrite(config.getExpireAfterWrite());
            }

            if (config.getExpireAfterAccess() != null) {
                caffeine.expireAfterAccess(config.getExpireAfterAccess());
            }

            if (config.getExpireAfter() != null) {
                caffeine.expireAfter(config.getExpireAfter());
            }

            if (config.getRefreshAfterWrite() != null) {
                caffeine.refreshAfterWrite(config.getRefreshAfterWrite());
            }

            if (config.getStatsCounter() != null) {
                caffeine.recordStats(() -> config.getStatsCounter());
            }

            if (Boolean.TRUE.equals(config.getWeakKeys())) {
                caffeine.weakKeys();
            }

            if (Boolean.TRUE.equals(config.getWeakValues())) {
                caffeine.weakValues();
            }

            if (Boolean.TRUE.equals(config.getSoftValues())) {
                caffeine.softValues();
            }

            if (config.getScheduler() != null) {
                caffeine.scheduler(new com.github.benmanes.caffeine.cache.Scheduler() {
                    @Override
                    public Future<?> schedule(Executor executor, Runnable command, long delay, TimeUnit unit) {
                        return config.getScheduler().schedule(executor, command, delay, unit);
                    }
                });
            }

            if (config.getCaffeineScheduler() != null) {
                caffeine.scheduler(config.getCaffeineScheduler());
            }

            return new XCache<>(config, caffeine);
        }
    }
}
