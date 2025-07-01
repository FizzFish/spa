/*
 * Copyright (c) 2023, Feysh LLC. All rights reserved.
 */
package com.feysh.corax.config.api;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import soot.Local;
import soot.Scene;

public interface ILocalVarMatch {
    @NotNull
    List<Local> matched(@NotNull Scene scene);
}