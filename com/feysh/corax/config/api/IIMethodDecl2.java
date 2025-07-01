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

public interface IIMethodDecl2<R, This, P0, P1> extends IIMethodDecl<R, This> {

    @NotNull
    CheckBuilder<R, This, P0, P1> checkBuilder(@NotNull Consumer<MethodConfig> config);

    @NotNull
    default IIMethodDecl2<R, This, P0, P1> model(@NotNull Consumer<MethodConfig> config,
                                                @NotNull TriFunction<CheckBuilder<R, This, P0, P1>, IParameterT<P0>, IParameterT<P1>, Void> block) {
        CheckBuilder<R, This, P0, P1> builder = checkBuilder(config);
        block.apply(builder, builder.getP0(), builder.getP1());
        return this;
    }

    @NotNull
    default IIMethodDecl2<R, This, P0, P1> modelNoArg(@NotNull Consumer<MethodConfig> config,
                                                      @NotNull Consumer<CheckBuilder<R, This, P0, P1>> block) {
        CheckBuilder<R, This, P0, P1> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R, This, P0, P1> extends IIMethodDecl.CheckBuilder<R, This> {
        @NotNull
        IIMethodDecl2<R, This, P0, P1> getMethod();

        @NotNull
        default IParameterT<P0> getP0() {
            return paramAt(0);
        }

        @NotNull
        default IParameterT<P1> getP1() {
            return paramAt(1);
        }
    }

    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
}