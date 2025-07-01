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

public interface ISMethodDecl8<R, P0, P1, P2, P3, P4, P5, P6, P7> extends ISMethodDecl<R> {
    @NotNull
    CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7> checkBuilder(@NotNull MethodConfigurator config);

    @NotNull
    ISMethodDecl8<R, P0, P1, P2, P3, P4, P5, P6, P7> model(
        @NotNull MethodConfigurator config,
        @NotNull MethodModeler<R, P0, P1, P2, P3, P4, P5, P6, P7> block
    );

    @NotNull
    ISMethodDecl8<R, P0, P1, P2, P3, P4, P5, P6, P7> modelNoArg(
        @NotNull MethodConfigurator config,
        @NotNull NoArgModeler<R, P0, P1, P2, P3, P4, P5, P6, P7> block
    );

    interface CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7> extends ISMethodDecl.CheckBuilder<R> {
        @NotNull
        ISMethodDecl8<R, P0, P1, P2, P3, P4, P5, P6, P7> getMethod();

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
    }

    @FunctionalInterface
    interface MethodConfigurator {
        void configure(MethodConfig config);
    }

    @FunctionalInterface
    interface MethodModeler<R, P0, P1, P2, P3, P4, P5, P6, P7> {
        void model(
            CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7> builder,
            IParameterT<P0> p0,
            IParameterT<P1> p1,
            IParameterT<P2> p2,
            IParameterT<P3> p3,
            IParameterT<P4> p4,
            IParameterT<P5> p5,
            IParameterT<P6> p6,
            IParameterT<P7> p7
        );
    }

    @FunctionalInterface
    interface NoArgModeler<R, P0, P1, P2, P3, P4, P5, P6, P7> {
        void model(CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7> builder);
    }
}
