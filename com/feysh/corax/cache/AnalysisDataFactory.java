/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.benmanes.caffeine.cache.Caffeine
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.cache;

import com.feysh.corax.cache.AnalysisKey;
import com.feysh.corax.cache.XOptional;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u000f*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004:\u0002\u000f\u0010R4\u0010\u0005\u001a$\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006j\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000`\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2={"Lcom/feysh/corax/cache/AnalysisDataFactory;", "T", "K", "Lcom/feysh/corax/cache/AnalysisKey;", "", "cache", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "Lcom/feysh/corax/cache/XOptional;", "Lcom/feysh/corax/cache/XLoadingCache;", "getCache", "()Lcom/github/benmanes/caffeine/cache/LoadingCache;", "key", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "getKey", "()Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "Companion", "Key", "corax-config-api"})
public interface AnalysisDataFactory<T, K extends AnalysisKey<T>> {
    @NotNull
    public static final Companion Companion = com.feysh.corax.cache.AnalysisDataFactory$Companion.$$INSTANCE;

    @NotNull
    public LoadingCache<K, XOptional<T>> getCache();

    @NotNull
    public Key<T> getKey();

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R!\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lcom/feysh/corax/cache/AnalysisDataFactory$Companion;", "", "<init>", "()V", "defaultBuilder", "Lcom/github/benmanes/caffeine/cache/Caffeine;", "getDefaultBuilder", "()Lcom/github/benmanes/caffeine/cache/Caffeine;", "corax-config-api"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        private static final Caffeine<Object, Object> defaultBuilder;

        private Companion() {
        }

        @NotNull
        public final Caffeine<Object, Object> getDefaultBuilder() {
            return defaultBuilder;
        }

        static {
            $$INSTANCE = new Companion();
            Caffeine caffeine = Caffeine.newBuilder().expireAfterAccess(15L, TimeUnit.SECONDS).softValues();
            Intrinsics.checkNotNullExpressionValue((Object)caffeine, (String)"softValues(...)");
            defaultBuilder = caffeine;
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "T", "", "<init>", "()V", "corax-config-api"})
    public static class Key<T> {
    }
}

