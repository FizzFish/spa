/*
 * Copyright (c) 2023 Feysh LLC. All rights reserved.
 */
package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;
import org.pf4j.ExtensionPoint;
import java.util.LinkedHashSet;

public interface IConfigPluginExtension extends ExtensionPoint {
    @NotNull
    LinkedHashSet<CheckerUnit> getUnits();

    @NotNull
    ISootInitializeHandler getSootConfig();

    @NotNull
    String getName();
}