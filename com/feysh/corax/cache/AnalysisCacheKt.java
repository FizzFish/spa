package com.feysh.corax.cache;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.jetbrains.annotations.NotNull;

public final class AnalysisCacheKt {
    @NotNull
    public static <K1, V1> LoadingCache<K1, XOptional<V1>> buildX(
            @NotNull Caffeine<Object, Object> builder,
            @NotNull CacheLoader<K1, V1> loader) {
        
        if (builder == null) {
            throw new IllegalArgumentException("builder cannot be null");
        }
        if (loader == null) {
            throw new IllegalArgumentException("loader cannot be null");
        }

        LoadingCache<K1, XOptional<V1>> cache = builder.build(new CacheLoader<K1, XOptional<V1>>() {
            @Override
            public XOptional<V1> load(K1 key) {
                V1 value = null;
                try {
                    value = loader.load(key);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                return XOptional.of(value);
            }
        });

        return cache;
    }
}
