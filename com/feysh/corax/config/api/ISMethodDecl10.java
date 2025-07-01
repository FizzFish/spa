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
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

public interface ISMethodDecl10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> extends ISMethodDecl<R> {
    @NotNull
    CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> config);

    @NotNull
    ISMethodDecl10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> model(
        @NotNull Function1<? super MethodConfig, Unit> config,
        @NotNull Function11<? super CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>, 
                          ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, 
                          ? super IParameterT<P3>, ? super IParameterT<P4>, ? super IParameterT<P5>, 
                          ? super IParameterT<P6>, ? super IParameterT<P7>, ? super IParameterT<P8>, 
                          ? super IParameterT<P9>, Unit> block);

    @NotNull
    ISMethodDecl10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> modelNoArg(
        @NotNull Function1<? super MethodConfig, Unit> config,
        @NotNull Function1<? super CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>, Unit> block);

    interface CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> extends ISMethodDecl.CheckBuilder<R> {
        @NotNull
        ISMethodDecl10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> getMethod();

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
    }
}
