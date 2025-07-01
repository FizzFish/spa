/*
 * Copyright (c) 2023 Feysh LLC
 */
package com.feysh.corax.config.api;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootClass;

public interface IClassMatch {
    @NotNull
    List<SootClass> matched(@NotNull Scene scene);

    @NotNull
    List<String> getSimpleName();
}