/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.SootMethodRef
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisKey;
import com.feysh.corax.cache.analysis.ResolveAbstractDispatchFactory;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0007H\u00c6\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2={"Lcom/feysh/corax/cache/analysis/ResolveAbstractDispatchKey;", "Lcom/feysh/corax/cache/AnalysisKey;", "", "Lsoot/SootMethod;", "baseType", "Lsoot/SootClass;", "sourceMethodRef", "Lsoot/SootMethodRef;", "<init>", "(Lsoot/SootClass;Lsoot/SootMethodRef;)V", "getBaseType", "()Lsoot/SootClass;", "getSourceMethodRef", "()Lsoot/SootMethodRef;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "corax-config-api"})
public final class ResolveAbstractDispatchKey
extends AnalysisKey<Set<? extends SootMethod>> {
    @NotNull
    private final SootClass baseType;
    @NotNull
    private final SootMethodRef sourceMethodRef;

    public ResolveAbstractDispatchKey(@NotNull SootClass baseType, @NotNull SootMethodRef sourceMethodRef) {
        Intrinsics.checkNotNullParameter((Object)baseType, (String)"baseType");
        Intrinsics.checkNotNullParameter((Object)sourceMethodRef, (String)"sourceMethodRef");
        super(ResolveAbstractDispatchFactory.INSTANCE.getKey());
        this.baseType = baseType;
        this.sourceMethodRef = sourceMethodRef;
    }

    @NotNull
    public final SootClass getBaseType() {
        return this.baseType;
    }

    @NotNull
    public final SootMethodRef getSourceMethodRef() {
        return this.sourceMethodRef;
    }

    @NotNull
    public final SootClass component1() {
        return this.baseType;
    }

    @NotNull
    public final SootMethodRef component2() {
        return this.sourceMethodRef;
    }

    @NotNull
    public final ResolveAbstractDispatchKey copy(@NotNull SootClass baseType, @NotNull SootMethodRef sourceMethodRef) {
        Intrinsics.checkNotNullParameter((Object)baseType, (String)"baseType");
        Intrinsics.checkNotNullParameter((Object)sourceMethodRef, (String)"sourceMethodRef");
        return new ResolveAbstractDispatchKey(baseType, sourceMethodRef);
    }

    public static /* synthetic */ ResolveAbstractDispatchKey copy$default(ResolveAbstractDispatchKey resolveAbstractDispatchKey, SootClass sootClass, SootMethodRef sootMethodRef, int n, Object object) {
        if ((n & 1) != 0) {
            sootClass = resolveAbstractDispatchKey.baseType;
        }
        if ((n & 2) != 0) {
            sootMethodRef = resolveAbstractDispatchKey.sourceMethodRef;
        }
        return resolveAbstractDispatchKey.copy(sootClass, sootMethodRef);
    }

    @NotNull
    public String toString() {
        return "ResolveAbstractDispatchKey(baseType=" + this.baseType + ", sourceMethodRef=" + this.sourceMethodRef + ")";
    }

    @Override
    public int hashCode() {
        int result = this.baseType.hashCode();
        result = result * 31 + this.sourceMethodRef.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResolveAbstractDispatchKey)) {
            return false;
        }
        ResolveAbstractDispatchKey resolveAbstractDispatchKey = (ResolveAbstractDispatchKey)other;
        if (!Intrinsics.areEqual((Object)this.baseType, (Object)resolveAbstractDispatchKey.baseType)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.sourceMethodRef, (Object)resolveAbstractDispatchKey.sourceMethodRef);
    }
}

