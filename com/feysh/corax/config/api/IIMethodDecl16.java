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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public interface IIMethodDecl16<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
        extends IIMethodDecl<R, This> {

    @NotNull
    CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> checkBuilder(
            @NotNull Consumer<? super MethodConfig> config);

    @NotNull
    default IIMethodDecl16<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> model(
            @NotNull Consumer<? super MethodConfig> config,
            @NotNull Function17<? super CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>,
                    ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, ? super IParameterT<P3>,
                    ? super IParameterT<P4>, ? super IParameterT<P5>, ? super IParameterT<P6>, ? super IParameterT<P7>,
                    ? super IParameterT<P8>, ? super IParameterT<P9>, ? super IParameterT<P10>, ? super IParameterT<P11>,
                    ? super IParameterT<P12>, ? super IParameterT<P13>, ? super IParameterT<P14>, ? super IParameterT<P15>, Unit> block) {
        CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> builder = checkBuilder(config);
        block.invoke(builder,
                builder.getP0(), builder.getP1(), builder.getP2(), builder.getP3(),
                builder.getP4(), builder.getP5(), builder.getP6(), builder.getP7(),
                builder.getP8(), builder.getP9(), builder.getP10(), builder.getP11(),
                builder.getP12(), builder.getP13(), builder.getP14(), builder.getP15());
        return this;
    }

    @NotNull
    default IIMethodDecl16<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> modelNoArg(
            @NotNull Consumer<? super MethodConfig> config,
            @NotNull Consumer<? super CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>> block) {
        CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
            extends IIMethodDecl.CheckBuilder<R, This> {

        @NotNull
        IIMethodDecl16<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> getMethod();

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

        @NotNull
        default IParameterT<P7> getP7() {
            return paramAt(7);
        }

        @NotNull
        default IParameterT<P8> getP8() {
            return paramAt(8);
        }

        @NotNull
        default IParameterT<P9> getP9() {
            return paramAt(9);
        }

        @NotNull
        default IParameterT<P10> getP10() {
            return paramAt(10);
        }

        @NotNull
        default IParameterT<P11> getP11() {
            return paramAt(11);
        }

        @NotNull
        default IParameterT<P12> getP12() {
            return paramAt(12);
        }

        @NotNull
        default IParameterT<P13> getP13() {
            return paramAt(13);
        }

        @NotNull
        default IParameterT<P14> getP14() {
            return paramAt(14);
        }

        @NotNull
        default IParameterT<P15> getP15() {
            return paramAt(15);
        }
    }

    @FunctionalInterface
    interface Function17<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, R> {
        R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12, P13 p13, P14 p14, P15 p15, P16 p16, P17 p17);
    }

    class Unit {
        public static final Unit INSTANCE = new Unit();
        private Unit() {}
    }
}
