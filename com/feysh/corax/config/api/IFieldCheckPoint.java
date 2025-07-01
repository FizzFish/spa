/*
 * Copyright (c) 2023, Feysh LLC. All rights reserved.
 */
package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import soot.tagkit.VisibilityAnnotationTag;

public interface IFieldCheckPoint extends IClassMemberCheckPoint {
    @NotNull
    SootField getSootField();

    @Nullable
    VisibilityAnnotationTag getVisibilityAnnotationTag();
}