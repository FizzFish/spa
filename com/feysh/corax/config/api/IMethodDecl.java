package com.feysh.corax.config.api;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import java.util.Set;
import java.util.function.Consumer;

public interface IMethodDecl<R> extends IJDecl {
    @NotNull
    IMethodMatch getMatch();

    @NotNull
    AIAnalysisApi.Error getError();

    @Nullable
    default Integer getArgumentCnt() {
        return getMatch().getArgumentCnt();
    }

    @Nullable
    default KFunctionType getActualType() {
        return getMatch().getActualType();
    }

    void eachLocalVar(@NotNull Consumer<? super ISootLocalVarDecl<Object>> block);

    @NotNull
    CheckBuilder<R> checkBuilder(@NotNull Consumer<? super MethodConfig> config);

    interface CheckBuilder<R> extends IOperatorFactory {
        @NotNull
        IMethodDecl<R> getMethod();

        @NotNull
        Consumer<MethodConfig> getConfig();

        @NotNull
        ILocalT<Object> getGlobal();

        @NotNull
        <T> IParameterT<T> paramAt(int index);

        @NotNull
        IReturnT<R> getReturn();
    }
}