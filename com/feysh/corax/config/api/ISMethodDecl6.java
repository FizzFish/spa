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

public interface ISMethodDecl6<R, P0, P1, P2, P3, P4, P5> extends ISMethodDecl<R> {

    @NotNull
    CheckBuilder<R, P0, P1, P2, P3, P4, P5> checkBuilder(@NotNull Consumer<MethodConfig> config);

    @NotNull
    default ISMethodDecl6<R, P0, P1, P2, P3, P4, P5> model(
            @NotNull Consumer<MethodConfig> config,
            @NotNull Function7<CheckBuilder<R, P0, P1, P2, P3, P4, P5>, IParameterT<P0>, IParameterT<P1>, 
                             IParameterT<P2>, IParameterT<P3>, IParameterT<P4>, IParameterT<P5>, Void> block) {
        CheckBuilder<R, P0, P1, P2, P3, P4, P5> builder = checkBuilder(config);
        block.apply(builder, builder.getP0(), builder.getP1(), builder.getP2(), 
                   builder.getP3(), builder.getP4(), builder.getP5());
        return this;
    }

    @NotNull
    default ISMethodDecl6<R, P0, P1, P2, P3, P4, P5> modelNoArg(
            @NotNull Consumer<MethodConfig> config,
            @NotNull Consumer<CheckBuilder<R, P0, P1, P2, P3, P4, P5>> block) {
        CheckBuilder<R, P0, P1, P2, P3, P4, P5> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R, P0, P1, P2, P3, P4, P5> extends ISMethodDecl.CheckBuilder<R> {
        @NotNull
        ISMethodDecl6<R, P0, P1, P2, P3, P4, P5> getMethod();

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
    }

    @FunctionalInterface
    interface Function7<T1, T2, T3, T4, T5, T6, T7, R> {
        R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7);
    }
}
