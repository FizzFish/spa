package com.feysh.corax.config.api;

import com.feysh.corax.config.api.*;
import org.jetbrains.annotations.NotNull;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public interface ISMethodDecl7<R, P0, P1, P2, P3, P4, P5, P6> extends ISMethodDecl<R> {

    @NotNull
    CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6> checkBuilder(@NotNull Consumer<MethodConfig> config);

    @NotNull
    default ISMethodDecl7<R, P0, P1, P2, P3, P4, P5, P6> model(
            @NotNull Consumer<MethodConfig> config,
            @NotNull EightParamFunction<
                    CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6>,
                    IParameterT<P0>, IParameterT<P1>, IParameterT<P2>, 
                    IParameterT<P3>, IParameterT<P4>, IParameterT<P5>, 
                    IParameterT<P6>, Void> block) {
        CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6> builder = checkBuilder(config);
        block.apply(builder, 
            builder.getP0(), builder.getP1(), builder.getP2(),
            builder.getP3(), builder.getP4(), builder.getP5(), 
            builder.getP6());
        return this;
    }

    @NotNull
    default ISMethodDecl7<R, P0, P1, P2, P3, P4, P5, P6> modelNoArg(
            @NotNull Consumer<MethodConfig> config,
            @NotNull Consumer<CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6>> block) {
        CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6> extends ISMethodDecl.CheckBuilder<R> {
        @NotNull
        ISMethodDecl7<R, P0, P1, P2, P3, P4, P5, P6> getMethod();

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

        @NotNull
        default IParameterT<P4> getP4() {
            return paramAt(4);
        }

        @NotNull
        default IParameterT<P5> getP5() {
            return paramAt(5);
        }

        @NotNull
        default IParameterT<P6> getP6() {
            return paramAt(6);
        }
    }

    @FunctionalInterface
    interface EightParamFunction<T1, T2, T3, T4, T5, T6, T7, T8, R> {
        R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8);
    }
}