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

public interface IIMethodDecl9<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8> extends IIMethodDecl<R, This> {

    @NotNull
    CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8> checkBuilder(@NotNull Consumer<MethodConfig> config);

    @NotNull
    default IIMethodDecl9<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8> model(
            @NotNull Consumer<MethodConfig> config,
            @NotNull Function10<CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8>, 
                                IParameterT<P0>, IParameterT<P1>, IParameterT<P2>, IParameterT<P3>, 
                                IParameterT<P4>, IParameterT<P5>, IParameterT<P6>, IParameterT<P7>, 
                                IParameterT<P8>, Unit> block) {
        CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8> builder = checkBuilder(config);
        block.invoke(builder, builder.getP0(), builder.getP1(), builder.getP2(), builder.getP3(), 
                    builder.getP4(), builder.getP5(), builder.getP6(), builder.getP7(), builder.getP8());
        return this;
    }

    @NotNull
    default IIMethodDecl9<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8> modelNoArg(
            @NotNull Consumer<MethodConfig> config,
            @NotNull Consumer<CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8>> block) {
        CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8> extends IIMethodDecl.CheckBuilder<R, This> {
        @NotNull
        IIMethodDecl9<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8> getMethod();

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
    }

    @FunctionalInterface
    interface Function10<A, B, C, D, E, F, G, H, I, J, R> {
        R invoke(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j);
    }
}
