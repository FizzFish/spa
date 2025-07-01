package com.feysh.corax.cache.coroutines;

import com.github.benmanes.caffeine.cache.Expiry;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.Scheduler;
import com.github.benmanes.caffeine.cache.stats.StatsCounter;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public final class Configuration<K, V> {
    private boolean useCallingContext;
    @Nullable
    private CoroutineScope scope;
    @Nullable
    private Duration refreshAfterWrite;
    @Nullable
    private Duration expireAfterAccess;
    @Nullable
    private Duration expireAfterWrite;
    @Nullable
    private Boolean weakKeys;
    @Nullable
    private Boolean weakValues;
    @Nullable
    private Boolean softValues;
    @Nullable
    private Long maximumWeight;
    @Nullable
    private Long maximumSize;
    @Nullable
    private StatsCounter statsCounter;
    @Nullable
    private Expiry<K, V> expireAfter;
    @Nullable
    private Supplier<Long> ticker;
    @Nullable
    private EvictionListener<K, V> evictionListener;
    @Nullable
    private RemovalListener<K, V> removalListener;
    @Nullable
    private Integer initialCapacity;
    @Nullable
    private BiFunction<K, V, Integer> weigher;
    @Nullable
    private Scheduler caffeineScheduler;
    @Nullable
    private com.feysh.corax.cache.coroutines.Scheduler scheduler;

    public Configuration(boolean useCallingContext, 
                        @Nullable CoroutineScope scope,
                        @Nullable Duration refreshAfterWrite,
                        @Nullable Duration expireAfterAccess,
                        @Nullable Duration expireAfterWrite,
                        @Nullable Boolean weakKeys,
                        @Nullable Boolean weakValues,
                        @Nullable Boolean softValues,
                        @Nullable Long maximumWeight,
                        @Nullable Long maximumSize,
                        @Nullable StatsCounter statsCounter,
                        @Nullable Expiry<K, V> expireAfter,
                        @Nullable Supplier<Long> ticker,
                        @Nullable EvictionListener<K, V> evictionListener,
                        @Nullable RemovalListener<K, V> removalListener,
                        @Nullable Integer initialCapacity,
                        @Nullable BiFunction<K, V, Integer> weigher,
                        @Nullable Scheduler caffeineScheduler,
                        @Nullable com.feysh.corax.cache.coroutines.Scheduler scheduler) {
        this.useCallingContext = useCallingContext;
        this.scope = scope;
        this.refreshAfterWrite = refreshAfterWrite;
        this.expireAfterAccess = expireAfterAccess;
        this.expireAfterWrite = expireAfterWrite;
        this.weakKeys = weakKeys;
        this.weakValues = weakValues;
        this.softValues = softValues;
        this.maximumWeight = maximumWeight;
        this.maximumSize = maximumSize;
        this.statsCounter = statsCounter;
        this.expireAfter = expireAfter;
        this.ticker = ticker;
        this.evictionListener = evictionListener;
        this.removalListener = removalListener;
        this.initialCapacity = initialCapacity;
        this.weigher = weigher;
        this.caffeineScheduler = caffeineScheduler;
        this.scheduler = scheduler;
    }

    public boolean getUseCallingContext() {
        return useCallingContext;
    }

    public void setUseCallingContext(boolean useCallingContext) {
        this.useCallingContext = useCallingContext;
    }

    @Nullable
    public CoroutineScope getScope() {
        return scope;
    }

    public void setScope(@Nullable CoroutineScope scope) {
        this.scope = scope;
    }

    @Nullable
    public Duration getRefreshAfterWrite() {
        return refreshAfterWrite;
    }

    public void setRefreshAfterWrite(@Nullable Duration refreshAfterWrite) {
        this.refreshAfterWrite = refreshAfterWrite;
    }

    @Nullable
    public Duration getExpireAfterAccess() {
        return expireAfterAccess;
    }

    public void setExpireAfterAccess(@Nullable Duration expireAfterAccess) {
        this.expireAfterAccess = expireAfterAccess;
    }

    @Nullable
    public Duration getExpireAfterWrite() {
        return expireAfterWrite;
    }

    public void setExpireAfterWrite(@Nullable Duration expireAfterWrite) {
        this.expireAfterWrite = expireAfterWrite;
    }

    @Nullable
    public Boolean getWeakKeys() {
        return weakKeys;
    }

    public void setWeakKeys(@Nullable Boolean weakKeys) {
        this.weakKeys = weakKeys;
    }

    @Nullable
    public Boolean getWeakValues() {
        return weakValues;
    }

    public void setWeakValues(@Nullable Boolean weakValues) {
        this.weakValues = weakValues;
    }

    @Nullable
    public Boolean getSoftValues() {
        return softValues;
    }

    public void setSoftValues(@Nullable Boolean softValues) {
        this.softValues = softValues;
    }

    @Nullable
    public Long getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(@Nullable Long maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    @Nullable
    public Long getMaximumSize() {
        return maximumSize;
    }

    public void setMaximumSize(@Nullable Long maximumSize) {
        this.maximumSize = maximumSize;
    }

    @Nullable
    public StatsCounter getStatsCounter() {
        return statsCounter;
    }

    public void setStatsCounter(@Nullable StatsCounter statsCounter) {
        this.statsCounter = statsCounter;
    }

    @Nullable
    public Expiry<K, V> getExpireAfter() {
        return expireAfter;
    }

    public void setExpireAfter(@Nullable Expiry<K, V> expireAfter) {
        this.expireAfter = expireAfter;
    }

    @Nullable
    public Supplier<Long> getTicker() {
        return ticker;
    }

    public void setTicker(@Nullable Supplier<Long> ticker) {
        this.ticker = ticker;
    }

    @Nullable
    public EvictionListener<K, V> getEvictionListener() {
        return evictionListener;
    }

    public void setEvictionListener(@Nullable EvictionListener<K, V> evictionListener) {
        this.evictionListener = evictionListener;
    }

    @Nullable
    public RemovalListener<K, V> getRemovalListener() {
        return removalListener;
    }

    public void setRemovalListener(@Nullable RemovalListener<K, V> removalListener) {
        this.removalListener = removalListener;
    }

    @Nullable
    public Integer getInitialCapacity() {
        return initialCapacity;
    }

    public void setInitialCapacity(@Nullable Integer initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    @Nullable
    public BiFunction<K, V, Integer> getWeigher() {
        return weigher;
    }

    public void setWeigher(@Nullable BiFunction<K, V, Integer> weigher) {
        this.weigher = weigher;
    }

    @Nullable
    public Scheduler getCaffeineScheduler() {
        return caffeineScheduler;
    }

    public void setCaffeineScheduler(@Nullable Scheduler caffeineScheduler) {
        this.caffeineScheduler = caffeineScheduler;
    }

    @Nullable
    public com.feysh.corax.cache.coroutines.Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(@Nullable com.feysh.corax.cache.coroutines.Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Configuration)) return false;
        Configuration<?, ?> that = (Configuration<?, ?>) o;
        return useCallingContext == that.useCallingContext &&
                Objects.equals(scope, that.scope) &&
                Objects.equals(refreshAfterWrite, that.refreshAfterWrite) &&
                Objects.equals(expireAfterAccess, that.expireAfterAccess) &&
                Objects.equals(expireAfterWrite, that.expireAfterWrite) &&
                Objects.equals(weakKeys, that.weakKeys) &&
                Objects.equals(weakValues, that.weakValues) &&
                Objects.equals(softValues, that.softValues) &&
                Objects.equals(maximumWeight, that.maximumWeight) &&
                Objects.equals(maximumSize, that.maximumSize) &&
                Objects.equals(statsCounter, that.statsCounter) &&
                Objects.equals(expireAfter, that.expireAfter) &&
                Objects.equals(ticker, that.ticker) &&
                Objects.equals(evictionListener, that.evictionListener) &&
                Objects.equals(removalListener, that.removalListener) &&
                Objects.equals(initialCapacity, that.initialCapacity) &&
                Objects.equals(weigher, that.weigher) &&
                Objects.equals(caffeineScheduler, that.caffeineScheduler) &&
                Objects.equals(scheduler, that.scheduler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(useCallingContext, scope, refreshAfterWrite, expireAfterAccess, expireAfterWrite,
                weakKeys, weakValues, softValues, maximumWeight, maximumSize, statsCounter, expireAfter,
                ticker, evictionListener, removalListener, initialCapacity, weigher, caffeineScheduler, scheduler);
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "useCallingContext=" + useCallingContext +
                ", scope=" + scope +
                ", refreshAfterWrite=" + refreshAfterWrite +
                ", expireAfterAccess=" + expireAfterAccess +
                ", expireAfterWrite=" + expireAfterWrite +
                ", weakKeys=" + weakKeys +
                ", weakValues=" + weakValues +
                ", softValues=" + softValues +
                ", maximumWeight=" + maximumWeight +
                ", maximumSize=" + maximumSize +
                ", statsCounter=" + statsCounter +
                ", expireAfter=" + expireAfter +
                ", ticker=" + ticker +
                ", evictionListener=" + evictionListener +
                ", removalListener=" + removalListener +
                ", initialCapacity=" + initialCapacity +
                ", weigher=" + weigher +
                ", caffeineScheduler=" + caffeineScheduler +
                ", scheduler=" + scheduler +
                '}';
    }

    public interface EvictionListener<K, V> {
        void onEviction(K key, V value, RemovalCause cause);
    }

    public interface RemovalListener<K, V> {
        void onRemoval(K key, V value, RemovalCause cause);
    }
}
