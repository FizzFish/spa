/*
 * Copyright (c) 2023, Feysh LLC. All rights reserved.
 */
package com.feysh.corax.config.api;

import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Value;

public interface ICheckPoint {
    @NotNull
    Set<Type> getPossibleTypes(@NotNull Value value);

    @NotNull
    Set<String> getPossibleConstantValues(@NotNull Value value);

    boolean hasSideEffect(@NotNull SootMethod method);

    @Nullable
    Boolean isInstanceOf(@NotNull SootClass clazz, @NotNull String parent);

    boolean isInstanceOf(@NotNull SootClass clazz, @NotNull SootClass parent);
}