package com.feysh.corax.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

public interface AnalysisDataFactory<T, K extends AnalysisKey<T>> {

    @NotNull
    LoadingCache<K, XOptional<T>> getCache();

    @NotNull
    Key<T> getKey();

    final class Companion {
        private static final Companion INSTANCE = new Companion();
        @NotNull
        private static final Caffeine<Object, Object> DEFAULT_BUILDER = Caffeine.newBuilder()
            .expireAfterAccess(15L, TimeUnit.SECONDS)
            .softValues();

        private Companion() {
        }

        @NotNull
        public static Caffeine<Object, Object> getDefaultBuilder() {
            return DEFAULT_BUILDER;
        }

        public static Companion getInstance() {
            return INSTANCE;
        }
    }

    class Key<T> {
    }

    static final Companion COMPANION = Companion.getInstance();
}