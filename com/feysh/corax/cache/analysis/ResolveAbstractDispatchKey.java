package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisKey;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;

public final class ResolveAbstractDispatchKey extends AnalysisKey<Set<SootMethod>> {
    @NotNull
    private final SootClass baseType;
    @NotNull
    private final SootMethodRef sourceMethodRef;

    public ResolveAbstractDispatchKey(@NotNull SootClass baseType, @NotNull SootMethodRef sourceMethodRef) {
        super(ResolveAbstractDispatchFactory.INSTANCE.getKey());
        this.baseType = Objects.requireNonNull(baseType, "baseType");
        this.sourceMethodRef = Objects.requireNonNull(sourceMethodRef, "sourceMethodRef");
    }

    @NotNull
    public SootClass getBaseType() {
        return baseType;
    }

    @NotNull
    public SootMethodRef getSourceMethodRef() {
        return sourceMethodRef;
    }

    @NotNull
    public ResolveAbstractDispatchKey copy(@NotNull SootClass baseType, @NotNull SootMethodRef sourceMethodRef) {
        return new ResolveAbstractDispatchKey(
            Objects.requireNonNull(baseType, "baseType"),
            Objects.requireNonNull(sourceMethodRef, "sourceMethodRef")
        );
    }

    @Override
    public String toString() {
        return "ResolveAbstractDispatchKey(baseType=" + baseType + ", sourceMethodRef=" + sourceMethodRef + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseType, sourceMethodRef);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof ResolveAbstractDispatchKey)) return false;
        ResolveAbstractDispatchKey that = (ResolveAbstractDispatchKey) other;
        return baseType.equals(that.baseType) && 
               sourceMethodRef.equals(that.sourceMethodRef);
    }
}