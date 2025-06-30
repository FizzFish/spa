/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.cache;

import com.feysh.corax.cache.AnalysisDataFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lcom/feysh/corax/cache/AnalysisKey;", "T", "", "factoryKey", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "<init>", "(Lcom/feysh/corax/cache/AnalysisDataFactory$Key;)V", "getFactoryKey", "()Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "hashCode", "", "equals", "", "other", "corax-config-api"})
public abstract class AnalysisKey<T> {
    @NotNull
    private final AnalysisDataFactory.Key<T> factoryKey;

    public AnalysisKey(@NotNull AnalysisDataFactory.Key<T> factoryKey) {
        Intrinsics.checkNotNullParameter(factoryKey, (String)"factoryKey");
        this.factoryKey = factoryKey;
    }

    @NotNull
    public AnalysisDataFactory.Key<T> getFactoryKey() {
        return this.factoryKey;
    }

    public int hashCode() {
        throw new IllegalStateException("did u forgot override hashCode()?".toString());
    }

    public boolean equals(@Nullable Object other) {
        throw new IllegalStateException("did u forgot override equals()?".toString());
    }
}

