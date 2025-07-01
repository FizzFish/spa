package com.feysh.corax.config.api;

import com.feysh.corax.config.api.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import java.util.Set;
import kotlin.reflect.KClass;

public interface IFieldDecl<This, T> extends IJDecl {

    @NotNull
    IFieldDecl<This, T> atGet(@NotNull Function1<? super MethodConfig, Unit> config, 
                             @NotNull Function1<? super IGet<This, T>, Unit> block);

    @NotNull
    IFieldDecl<This, T> atSet(@NotNull Function1<? super MethodConfig, Unit> config, 
                             @NotNull Function2<? super ISet<This, T>, ? super IParameterT<T>, Unit> block);

    interface IBuilder<This, T> extends IOperatorFactory {
        @NotNull IFieldDecl<This, T> getDecl();
        @NotNull IParameterT<This> getThis();
        @NotNull IAccessPathT<T> getField();
        @NotNull IFieldMatch getMatch();
        @NotNull Function1<MethodConfig, Unit> getConfig();
    }

    interface IGet<This, T> extends IBuilder<This, T> {
        @NotNull IReturnT<T> getReturn();
    }

    interface ISet<This, T> extends IBuilder<This, T> {
        @NotNull IParameterT<T> getValue();
    }
}