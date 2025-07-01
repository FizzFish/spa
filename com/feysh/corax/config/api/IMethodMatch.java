package com.feysh.corax.config.api;

import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootMethod;

public interface IMethodMatch {
    @Nullable
    KFunctionType getActualType();

    @Nullable
    Integer getArgumentCnt();

    @NotNull
    Exception getException();

    @NotNull
    List<SootMethod> matched(@NotNull Scene scene);
}