/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.Type
 *  soot.Value
 */
package com.feysh.corax.config.api;

import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Value;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\f\u0010\u000b\u001a\u00020\f*\u00020\rH&J\u001b\u0010\u000e\u001a\u0004\u0018\u00010\f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH&\u00a2\u0006\u0002\u0010\u0011J\u0014\u0010\u000e\u001a\u00020\f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH&R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003*\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u0012"}, d2={"Lcom/feysh/corax/config/api/ICheckPoint;", "", "possibleTypes", "", "Lsoot/Type;", "Lsoot/Value;", "getPossibleTypes", "(Lsoot/Value;)Ljava/util/Set;", "possibleConstantValues", "", "getPossibleConstantValues", "hasSideEffect", "", "Lsoot/SootMethod;", "isInstanceOf", "Lsoot/SootClass;", "parent", "(Lsoot/SootClass;Ljava/lang/String;)Ljava/lang/Boolean;", "corax-config-api"})
public interface ICheckPoint {
    @NotNull
    public Set<Type> getPossibleTypes(@NotNull Value var1);

    @NotNull
    public Set<String> getPossibleConstantValues(@NotNull Value var1);

    public boolean hasSideEffect(@NotNull SootMethod var1);

    @Nullable
    public Boolean isInstanceOf(@NotNull SootClass var1, @NotNull String var2);

    public boolean isInstanceOf(@NotNull SootClass var1, @NotNull SootClass var2);
}

