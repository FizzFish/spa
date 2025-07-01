package com.feysh.corax.config.api;

import com.feysh.corax.config.api.*;
import org.jetbrains.annotations.NotNull;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public interface ISMethodDecl2<R, P0, P1> extends ISMethodDecl<R> {

    @NotNull
    CheckBuilder<R, P0, P1> checkBuilder(@NotNull Consumer<MethodConfig> config);

    @NotNull
    default ISMethodDecl2<R, P0, P1> model(@NotNull Consumer<MethodConfig> config, 
            @NotNull TriFunction<CheckBuilder<R, P0, P1>, IParameterT<P0>, IParameterT<P1>, Void> block) {
        CheckBuilder<R, P0, P1> builder = checkBuilder(config);
        block.apply(builder, builder.getP0(), builder.getP1());
        return this;
    }

    @NotNull
    default ISMethodDecl2<R, P0, P1> modelNoArg(@NotNull Consumer<MethodConfig> config, 
            @NotNull Consumer<CheckBuilder<R, P0, P1>> block) {
        CheckBuilder<R, P0, P1> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R, P0, P1> extends ISMethodDecl.CheckBuilder<R> {
        @NotNull
        ISMethodDecl2<R, P0, P1> getMethod();

        @NotNull
        default IParameterT<P0> getP0() {
            return paramAt(0);
        }

        @NotNull
        default IParameterT<P1> getP1() {
            return paramAt(1);
        }
    }

    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
}