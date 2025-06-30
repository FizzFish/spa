/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.benmanes.caffeine.cache.CacheLoader
 *  com.github.benmanes.caffeine.cache.Caffeine
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.cache;

import com.feysh.corax.cache.XOptional;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\\\u0010\u0005\u001a$\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00040\u0003j\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007`\b\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007*\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\f*:\u0010\u0000\u001a\u0004\b\u0000\u0010\u0001\u001a\u0004\b\u0001\u0010\u0002\"\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003\u00a8\u0006\r"}, d2={"XLoadingCache", "K", "V", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "Lcom/feysh/corax/cache/XOptional;", "buildX", "K1", "V1", "Lcom/feysh/corax/cache/XLoadingCache;", "Lcom/github/benmanes/caffeine/cache/Caffeine;", "", "loader", "Lcom/github/benmanes/caffeine/cache/CacheLoader;", "corax-config-api"})
public final class AnalysisCacheKt {
    @NotNull
    public static final <K1, V1> LoadingCache<K1, XOptional<V1>> buildX(@NotNull Caffeine<Object, Object> $this$buildX, @NotNull CacheLoader<K1, V1> loader) {
        Intrinsics.checkNotNullParameter($this$buildX, (String)"<this>");
        Intrinsics.checkNotNullParameter(loader, (String)"loader");
        Function1 function1 = arg_0 -> AnalysisCacheKt.buildX$lambda$0(loader, arg_0);
        LoadingCache x = $this$buildX.build(new CacheLoader(function1){
            private final /* synthetic */ Function1 function;
            {
                Intrinsics.checkNotNullParameter((Object)function, (String)"function");
                this.function = function;
            }

            public final /* synthetic */ Object load(Object p0) {
                return this.function.invoke(p0);
            }
        });
        Intrinsics.checkNotNull((Object)x);
        return x;
    }

    private static final XOptional buildX$lambda$0(CacheLoader $loader, Object k) {
        Object v = $loader.load(k);
        return XOptional.Companion.of(v);
    }
}

