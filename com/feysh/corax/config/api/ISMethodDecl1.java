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

public interface ISMethodDecl1<R, P0> extends ISMethodDecl<R> {
    @NotNull
    CheckBuilder<R, P0> checkBuilder(@NotNull MethodConfigurator config);

    @NotNull
    default ISMethodDecl1<R, P0> model(@NotNull MethodConfigurator config, 
                                      @NotNull CheckBuilderConsumer<R, P0> block) {
        CheckBuilder<R, P0> builder = checkBuilder(config);
        block.accept(builder, builder.getP0());
        return this;
    }

    @NotNull
    default ISMethodDecl1<R, P0> modelNoArg(@NotNull MethodConfigurator config, 
                                          @NotNull SimpleCheckBuilderConsumer<R, P0> block) {
        CheckBuilder<R, P0> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R, P0> extends ISMethodDecl.CheckBuilder<R> {
        @NotNull
        ISMethodDecl1<R, P0> getMethod();

        @NotNull
        default IParameterT<P0> getP0() {
            return paramAt(0);
        }
    }

    @FunctionalInterface
    interface MethodConfigurator {
        void configure(MethodConfig config);
    }

    @FunctionalInterface
    interface CheckBuilderConsumer<R, P0> {
        void accept(CheckBuilder<R, P0> builder, IParameterT<P0> parameter);
    }

    @FunctionalInterface
    interface SimpleCheckBuilderConsumer<R, P0> {
        void accept(CheckBuilder<R, P0> builder);
    }
}
