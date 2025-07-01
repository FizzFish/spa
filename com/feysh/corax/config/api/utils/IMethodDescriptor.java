package com.feysh.corax.config.api.utils;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface IMethodDescriptor {
    @NotNull
    String getClazz();

    @NotNull
    String getName();

    @NotNull
    String getReturnType();

    @NotNull
    List<String> getParameters();
}