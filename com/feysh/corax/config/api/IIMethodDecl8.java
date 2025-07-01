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

public interface IIMethodDecl8<R, This, P0, P1, P2, P3, P4, P5, P6, P7> extends IIMethodDecl<R, This> {

    @NotNull
    CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7> checkBuilder(@NotNull Consumer<MethodConfig> config);

    @NotNull
    default IIMethodDecl8<R, This, P0, P1, P2, P3, P4, P5, P6, P7> model(
            @NotNull Consumer<MethodConfig> config,
            @NotNull NineArgConsumer<CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7>, 
                IParameterT<P0>, IParameterT<P1>, IParameterT<P2>, IParameterT<P3>, 
                IParameterT<P4>, IParameterT<P5>, IParameterT<P6>, IParameterT<P7>> block) {
        CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7> builder = checkBuilder(config);
        block.accept(builder, 
            builder.getP0(), builder.getP1(), builder.getP2(), builder.getP3(),
            builder.getP4(), builder.getP5(), builder.getP6(), builder.getP7());
        return this;
    }

    @NotNull
    default IIMethodDecl8<R, This, P0, P1, P2, P3, P4, P5, P6, P7> modelNoArg(
            @NotNull Consumer<MethodConfig> config,
            @NotNull Consumer<CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7>> block) {
        CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7> extends IIMethodDecl.CheckBuilder<R, This> {
        @NotNull
        IIMethodDecl8<R, This, P0, P1, P2, P3, P4, P5, P6, P7> getMethod();

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
    }

    @FunctionalInterface
    interface NineArgConsumer<T, A, B, C, D, E, F, G, H, I> {
        void accept(T t, A a, B b, C c, D d, E e, F f, G g, H h, I i);
    }
}