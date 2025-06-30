/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.tagkit.Host
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.AnalysisKey;
import com.feysh.corax.cache.analysis.SootHostExtend;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.tagkit.Host;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006j\u0002`\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0004H\u00c6\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006j\u0002`\u0007H\u00c6\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006j\u0002`\u0007H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\u0005\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006j\u0002`\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2={"Lcom/feysh/corax/cache/analysis/SootHostExtInfoKey;", "Lcom/feysh/corax/cache/AnalysisKey;", "Lcom/feysh/corax/cache/analysis/SootHostExtend;", "host", "Lsoot/tagkit/Host;", "factoryKey", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "Lcom/feysh/corax/cache/analysis/SootHostExtInfoFKey;", "<init>", "(Lsoot/tagkit/Host;Lcom/feysh/corax/cache/AnalysisDataFactory$Key;)V", "getHost", "()Lsoot/tagkit/Host;", "getFactoryKey", "()Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "corax-config-api"})
public final class SootHostExtInfoKey
extends AnalysisKey<SootHostExtend> {
    @NotNull
    private final Host host;
    @NotNull
    private final AnalysisDataFactory.Key<SootHostExtend> factoryKey;

    public SootHostExtInfoKey(@NotNull Host host, @NotNull AnalysisDataFactory.Key<SootHostExtend> factoryKey) {
        Intrinsics.checkNotNullParameter((Object)host, (String)"host");
        Intrinsics.checkNotNullParameter(factoryKey, (String)"factoryKey");
        super(factoryKey);
        this.host = host;
        this.factoryKey = factoryKey;
    }

    @NotNull
    public final Host getHost() {
        return this.host;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<SootHostExtend> getFactoryKey() {
        return this.factoryKey;
    }

    @NotNull
    public final Host component1() {
        return this.host;
    }

    @NotNull
    public final AnalysisDataFactory.Key<SootHostExtend> component2() {
        return this.factoryKey;
    }

    @NotNull
    public final SootHostExtInfoKey copy(@NotNull Host host, @NotNull AnalysisDataFactory.Key<SootHostExtend> factoryKey) {
        Intrinsics.checkNotNullParameter((Object)host, (String)"host");
        Intrinsics.checkNotNullParameter(factoryKey, (String)"factoryKey");
        return new SootHostExtInfoKey(host, factoryKey);
    }

    public static /* synthetic */ SootHostExtInfoKey copy$default(SootHostExtInfoKey sootHostExtInfoKey, Host host, AnalysisDataFactory.Key key2, int n, Object object) {
        if ((n & 1) != 0) {
            host = sootHostExtInfoKey.host;
        }
        if ((n & 2) != 0) {
            key2 = sootHostExtInfoKey.factoryKey;
        }
        return sootHostExtInfoKey.copy(host, key2);
    }

    @NotNull
    public String toString() {
        return "SootHostExtInfoKey(host=" + this.host + ", factoryKey=" + this.factoryKey + ")";
    }

    @Override
    public int hashCode() {
        int result = this.host.hashCode();
        result = result * 31 + this.factoryKey.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SootHostExtInfoKey)) {
            return false;
        }
        SootHostExtInfoKey sootHostExtInfoKey = (SootHostExtInfoKey)other;
        if (!Intrinsics.areEqual((Object)this.host, (Object)sootHostExtInfoKey.host)) {
            return false;
        }
        return Intrinsics.areEqual(this.factoryKey, sootHostExtInfoKey.factoryKey);
    }
}

