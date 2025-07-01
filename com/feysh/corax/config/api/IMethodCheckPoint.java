/*
 * Copyright (c) 2023, Feysh LLC. All rights reserved.
 */
package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.tagkit.VisibilityAnnotationTag;
import java.util.function.Consumer;

public interface IMethodCheckPoint extends IClassMemberCheckPoint {
    @NotNull
    SootMethod getSootMethod();

    @Nullable
    VisibilityAnnotationTag getVisibilityAnnotationTag();

    void forEachUnit(@NotNull Consumer<? super IUnitCheckPoint> block);
}