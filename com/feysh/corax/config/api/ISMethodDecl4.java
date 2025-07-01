package com.feysh.corax.config.api;

import com.feysh.corax.config.api.*;
import org.jetbrains.annotations.NotNull;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public interface ISMethodDecl4<R, P0, P1, P2, P3> extends ISMethodDecl<R> {

    @NotNull
    CheckBuilder<R, P0, P1, P2, P3> checkBuilder(@NotNull Consumer<MethodConfig> config);

    @NotNull
    default ISMethodDecl4<R, P0, P1, P2, P3> model(
        @NotNull Consumer<MethodConfig> config,
        @NotNull Function5<CheckBuilder<R, P0, P1, P2, P3>, IParameterT<P0>, IParameterT<P1>, IParameterT<P2>, IParameterT<P3>, Void> block
    ) {
        CheckBuilder<R, P0, P1, P2, P3> builder = checkBuilder(config);
        block.apply(builder, builder.getP0(), builder.getP1(), builder.getP2(), builder.getP3());
        return this;
    }

    @NotNull
    default ISMethodDecl4<R, P0, P1, P2, P3> modelNoArg(
        @NotNull Consumer<MethodConfig> config,
        @NotNull Consumer<CheckBuilder<R, P0, P1, P2, P3>> block
    ) {
        CheckBuilder<R, P0, P1, P2, P3> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R, P0, P1, P2, P3> extends ISMethodDecl.CheckBuilder<R> {
        @NotNull
        ISMethodDecl4<R, P0, P1, P2, P3> getMethod();

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

        @NotNull
        default IParameterT<P3> getP3() {
            return paramAt(3);
        }
    }

    @FunctionalInterface
    interface Function5<A, B, C, D, E, R> {
        R apply(A a, B b, C c, D d, E e);
    }
}
