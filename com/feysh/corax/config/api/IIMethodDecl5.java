package com.feysh.corax.config.api;

import com.feysh.corax.config.api.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public interface IIMethodDecl5<R, This, P0, P1, P2, P3, P4> extends IIMethodDecl<R, This> {

    @NotNull
    CheckBuilder<R, This, P0, P1, P2, P3, P4> checkBuilder(@NotNull Consumer<MethodConfig> config);

    @NotNull
    default IIMethodDecl5<R, This, P0, P1, P2, P3, P4> model(
            @NotNull Consumer<MethodConfig> config,
            @NotNull Function6<CheckBuilder<R, This, P0, P1, P2, P3, P4>, IParameterT<P0>, IParameterT<P1>, 
                              IParameterT<P2>, IParameterT<P3>, IParameterT<P4>, Unit> block) {
        CheckBuilder<R, This, P0, P1, P2, P3, P4> builder = checkBuilder(config);
        block.apply(builder, builder.getP0(), builder.getP1(), builder.getP2(), builder.getP3(), builder.getP4());
        return this;
    }

    @NotNull
    default IIMethodDecl5<R, This, P0, P1, P2, P3, P4> modelNoArg(
            @NotNull Consumer<MethodConfig> config,
            @NotNull Consumer<CheckBuilder<R, This, P0, P1, P2, P3, P4>> block) {
        CheckBuilder<R, This, P0, P1, P2, P3, P4> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R, This, P0, P1, P2, P3, P4> extends IIMethodDecl.CheckBuilder<R, This> {
        
        @NotNull
        IIMethodDecl5<R, This, P0, P1, P2, P3, P4> getMethod();

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
    }

    @FunctionalInterface
    interface Function6<A, B, C, D, E, F, R> {
        R apply(A a, B b, C c, D d, E e, F f);
    }
}