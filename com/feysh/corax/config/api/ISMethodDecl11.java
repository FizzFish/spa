package com.feysh.corax.config.api;

import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.ISMethodDecl;
import com.feysh.corax.config.api.IStringExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import com.feysh.corax.config.api.utils.KFunctionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public interface ISMethodDecl11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> extends ISMethodDecl<R> {

    @NotNull
    CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> checkBuilder(@NotNull Consumer<MethodConfig> config);

    @NotNull
    default ISMethodDecl11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> model(
            @NotNull Consumer<MethodConfig> config,
            @NotNull Function12<CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>, 
                              IParameterT<P0>, IParameterT<P1>, IParameterT<P2>, IParameterT<P3>, 
                              IParameterT<P4>, IParameterT<P5>, IParameterT<P6>, IParameterT<P7>, 
                              IParameterT<P8>, IParameterT<P9>, IParameterT<P10>, Unit> block) {
        CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> builder = checkBuilder(config);
        block.apply(builder, builder.getP0(), builder.getP1(), builder.getP2(), builder.getP3(), 
                   builder.getP4(), builder.getP5(), builder.getP6(), builder.getP7(), 
                   builder.getP8(), builder.getP9(), builder.getP10());
        return this;
    }

    @NotNull
    default ISMethodDecl11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> modelNoArg(
            @NotNull Consumer<MethodConfig> config,
            @NotNull Consumer<CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>> block) {
        CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> extends ISMethodDecl.CheckBuilder<R> {
        @NotNull
        ISMethodDecl11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> getMethod();

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

        @NotNull
        IParameterT<P7> getP7();

        @NotNull
        IParameterT<P8> getP8();

        @NotNull
        IParameterT<P9> getP9();

        @NotNull
        IParameterT<P10> getP10();
    }

    @FunctionalInterface
    interface Function12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> {
        R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12);
    }
}
