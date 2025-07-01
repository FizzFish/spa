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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

public interface IIMethodDecl13<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> 
    extends IIMethodDecl<R, This> {

    @NotNull
    CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> checkBuilder(
        @NotNull Function1<? super MethodConfig, Unit> config);

    @NotNull
    IIMethodDecl13<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> model(
        @NotNull Function1<? super MethodConfig, Unit> config,
        @NotNull Function14<? super CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>, 
            ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, 
            ? super IParameterT<P3>, ? super IParameterT<P4>, ? super IParameterT<P5>, 
            ? super IParameterT<P6>, ? super IParameterT<P7>, ? super IParameterT<P8>, 
            ? super IParameterT<P9>, ? super IParameterT<P10>, ? super IParameterT<P11>, 
            ? super IParameterT<P12>, Unit> block);

    @NotNull
    IIMethodDecl13<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> modelNoArg(
        @NotNull Function1<? super MethodConfig, Unit> config,
        @NotNull Function1<? super CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>, Unit> block);

    interface CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> 
        extends IIMethodDecl.CheckBuilder<R, This> {

        @NotNull
        IIMethodDecl13<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> getMethod();

        @NotNull IParameterT<P0> getP0();
        @NotNull IParameterT<P1> getP1();
        @NotNull IParameterT<P2> getP2();
        @NotNull IParameterT<P3> getP3();
        @NotNull IParameterT<P4> getP4();
        @NotNull IParameterT<P5> getP5();
        @NotNull IParameterT<P6> getP6();
        @NotNull IParameterT<P7> getP7();
        @NotNull IParameterT<P8> getP8();
        @NotNull IParameterT<P9> getP9();
        @NotNull IParameterT<P10> getP10();
        @NotNull IParameterT<P11> getP11();
        @NotNull IParameterT<P12> getP12();
    }

    @FunctionalInterface
    interface Function1<T, R> {
        R invoke(T t);
    }

    @FunctionalInterface
    interface Function14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> {
        R invoke(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, 
                T9 t9, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14);
    }

    final class Unit {
        public static final Unit INSTANCE = new Unit();
        private Unit() {}
    }
}
