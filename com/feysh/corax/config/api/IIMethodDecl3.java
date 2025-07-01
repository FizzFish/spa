package com.feysh.corax.config.api;

import com.feysh.corax.config.api.*;
import org.jetbrains.annotations.NotNull;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public interface IIMethodDecl3<R, This, P0, P1, P2> extends IIMethodDecl<R, This> {

    @NotNull
    CheckBuilder<R, This, P0, P1, P2> checkBuilder(@NotNull Consumer<MethodConfig> config);

    @NotNull
    default IIMethodDecl3<R, This, P0, P1, P2> model(@NotNull Consumer<MethodConfig> config,
            @NotNull Function4<CheckBuilder<R, This, P0, P1, P2>, IParameterT<P0>, IParameterT<P1>, IParameterT<P2>, Void> block) {
        CheckBuilder<R, This, P0, P1, P2> builder = checkBuilder(config);
        block.apply(builder, builder.getP0(), builder.getP1(), builder.getP2());
        return this;
    }

    @NotNull
    default IIMethodDecl3<R, This, P0, P1, P2> modelNoArg(@NotNull Consumer<MethodConfig> config,
            @NotNull Consumer<CheckBuilder<R, This, P0, P1, P2>> block) {
        CheckBuilder<R, This, P0, P1, P2> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R, This, P0, P1, P2> extends IIMethodDecl.CheckBuilder<R, This> {
        @NotNull
        IIMethodDecl3<R, This, P0, P1, P2> getMethod();

        @NotNull
        default IParameterT<P0> getP0() {
            return paramAt(0);
        }

        @NotNull
        default IParameterT<P1> getP1() {
            return paramAt(1);
        }

        @NotNull
        default IParameterT<P2> getP2() {
            return paramAt(2);
        }
    }

    @FunctionalInterface
    interface Function4<A, B, C, D, R> {
        R apply(A a, B b, C c, D d);
    }
}