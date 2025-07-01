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

public interface IIMethodDecl4<R, This, P0, P1, P2, P3> extends IIMethodDecl<R, This> {

    @NotNull
    CheckBuilder<R, This, P0, P1, P2, P3> checkBuilder(@NotNull MethodConfigurator config);

    @NotNull
    default IIMethodDecl4<R, This, P0, P1, P2, P3> model(@NotNull MethodConfigurator config, 
            @NotNull ModelBlock<R, This, P0, P1, P2, P3> block) {
        CheckBuilder<R, This, P0, P1, P2, P3> builder = checkBuilder(config);
        block.apply(builder, builder.getP0(), builder.getP1(), builder.getP2(), builder.getP3());
        return this;
    }

    @NotNull
    default IIMethodDecl4<R, This, P0, P1, P2, P3> modelNoArg(@NotNull MethodConfigurator config, 
            @NotNull CheckBuilderConsumer<R, This, P0, P1, P2, P3> block) {
        CheckBuilder<R, This, P0, P1, P2, P3> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R, This, P0, P1, P2, P3> extends IIMethodDecl.CheckBuilder<R, This> {
        @NotNull
        IIMethodDecl4<R, This, P0, P1, P2, P3> getMethod();

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
    }

    @FunctionalInterface
    interface MethodConfigurator {
        void configure(MethodConfig config);
    }

    @FunctionalInterface
    interface ModelBlock<R, This, P0, P1, P2, P3> {
        void apply(CheckBuilder<R, This, P0, P1, P2, P3> builder, 
                  IParameterT<P0> p0, 
                  IParameterT<P1> p1, 
                  IParameterT<P2> p2, 
                  IParameterT<P3> p3);
    }

    @FunctionalInterface
    interface CheckBuilderConsumer<R, This, P0, P1, P2, P3> {
        void accept(CheckBuilder<R, This, P0, P1, P2, P3> builder);
    }
}
