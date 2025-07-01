package com.feysh.corax.config.api;

import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.IIMethodDecl;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.IStringExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

public interface IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6> extends IIMethodDecl<R, This> {

    @NotNull
    CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> checkBuilder(@NotNull Consumer<MethodConfig> config);

    @NotNull
    default IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6> model(
            @NotNull Consumer<MethodConfig> config,
            @NotNull EightParamFunction<
                    CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6>,
                    IParameterT<P0>, IParameterT<P1>, IParameterT<P2>, IParameterT<P3>,
                    IParameterT<P4>, IParameterT<P5>, IParameterT<P6>, Void> block) {
        CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> builder = checkBuilder(config);
        block.apply(builder, builder.getP0(), builder.getP1(), builder.getP2(), builder.getP3(),
                builder.getP4(), builder.getP5(), builder.getP6());
        return this;
    }

    @NotNull
    default IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6> modelNoArg(
            @NotNull Consumer<MethodConfig> config,
            @NotNull Consumer<CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6>> block) {
        CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> extends IIMethodDecl.CheckBuilder<R, This> {
        @NotNull
        IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6> getMethod();

        @NotNull
        IParameterT<P0> getP0();

        @NotNull
        IParameterT<P1> getP1();

        @NotNull
        IParameterT<P2> getP2();

        @NotNull
        IParameterT<P3> getP3();

        @NotNull
        IParameterT<P4> getP4();

        @NotNull
        IParameterT<P5> getP5();

        @NotNull
        IParameterT<P6> getP6();
    }

    @FunctionalInterface
    interface EightParamFunction<T, U, V, W, X, Y, Z, A, B, R> {
        R apply(T t, U u, V v, W w, X x, Y y, Z z, A a, B b);
    }
}
