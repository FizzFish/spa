package com.feysh.corax.config.api;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootField;

public interface IFieldMatch {
    @NotNull
    String getDeclaringClassType();

    @NotNull
    String getFieldName();

    @Nullable
    String getFieldType();

    @Nullable
    Boolean isStatic();

    @NotNull
    List<SootField> matched(@NotNull Scene scene);
}