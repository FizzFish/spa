package com.feysh.corax.config.api;

import com.feysh.corax.config.api.*;
import org.jetbrains.annotations.NotNull;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public interface ISMethodDecl3<R, P0, P1, P2> extends ISMethodDecl<R> {

    @NotNull
    CheckBuilder<R, P0, P1, P2> checkBuilder(@NotNull Consumer<MethodConfig> config);

    @NotNull
    default ISMethodDecl3<R, P0, P1, P2> model(@NotNull Consumer<MethodConfig> config,
                                               @NotNull QuadFunction<CheckBuilder<R, P0, P1, P2>, IParameterT<P0>, IParameterT<P1>, IParameterT<P2>, Void> block) {
        CheckBuilder<R, P0, P1, P2> builder = checkBuilder(config);
        block.apply(builder, builder.getP0(), builder.getP1(), builder.getP2());
        return this;
    }

    @NotNull
    default ISMethodDecl3<R, P0, P1, P2> modelNoArg(@NotNull Consumer<MethodConfig> config,
                                                    @NotNull Consumer<CheckBuilder<R, P0, P1, P2>> block) {
        CheckBuilder<R, P0, P1, P2> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R, P0, P1, P2> extends ISMethodDecl.CheckBuilder<R> {
        @NotNull
        ISMethodDecl3<R, P0, P1, P2> getMethod();

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
    interface QuadFunction<A, B, C, D, R> {
        R apply(A a, B b, C c, D d);
    }
}