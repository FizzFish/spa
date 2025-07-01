package com.feysh.corax.config.api;

import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.IMethodDecl;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.IStringExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import com.feysh.corax.config.api.baseimpl.ConfigException;
import com.feysh.corax.config.api.utils.KFunctionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.BiConsumer;

public interface IRawMethodDecl<R> extends IMethodDecl<R> {
    @NotNull
    CheckBuilder<R> checkBuilder(@NotNull Consumer<MethodConfig> config);

    @NotNull
    default IRawMethodDecl<R> model(@NotNull Consumer<MethodConfig> config, 
                                  @NotNull BiConsumer<CheckBuilder<R>, IParameterT<Object>[]> block) {
        Integer cnt = getArgumentCnt();
        if (cnt == null) {
            getError().error("The argumentCnt of this method match: " + getMatch() + 
                " is unknown. Please use \".modelNoArg\". Or implemented argumentCnt method of " + 
                getMatch().getClass());
            return this;
        }

        CheckBuilder<R> builder = checkBuilder(config);
        try {
            IParameterT<Object>[] params = new IParameterT[cnt];
            for (int i = 0; i < cnt; i++) {
                params[i] = builder.paramAt(i);
            }
            block.accept(builder, params);
        } catch (ConfigException e) {
            System.err.println(e);
        }
        return this;
    }

    @NotNull
    default IRawMethodDecl<R> modelNoArg(@NotNull Consumer<MethodConfig> config, 
                                       @NotNull Consumer<CheckBuilder<R>> block) {
        CheckBuilder<R> builder = checkBuilder(config);
        try {
            block.accept(builder);
        } catch (ConfigException e) {
            System.err.println(e);
        }
        return this;
    }

    interface CheckBuilder<R> extends IMethodDecl.CheckBuilder<R> {
        @NotNull IParameterT<Object> getThis();
        @NotNull IParameterT<Object> getP0();
        @NotNull IParameterT<Object> getP1();
        @NotNull IParameterT<Object> getP2();
        @NotNull IParameterT<Object> getP3();
        @NotNull IParameterT<Object> getP4();
        @NotNull IParameterT<Object> getP5();
        @NotNull IParameterT<Object> getP6();
        @NotNull IParameterT<Object> getP7();
        @NotNull IParameterT<Object> getP8();
        @NotNull IParameterT<Object> getP9();
        @NotNull IParameterT<Object> getP10();
        @NotNull IParameterT<Object> getP11();
        @NotNull IParameterT<Object> getP12();
        @NotNull IParameterT<Object> getP13();
        @NotNull IParameterT<Object> getP14();
        @NotNull IParameterT<Object> getP15();
        @NotNull IParameterT<Object> parameter(int index);

        default @NotNull IParameterT<Object> getThis() { return paramAt(-1); }
        default @NotNull IParameterT<Object> getP0() { return paramAt(0); }
        default @NotNull IParameterT<Object> getP1() { return paramAt(1); }
        default @NotNull IParameterT<Object> getP2() { return paramAt(2); }
        default @NotNull IParameterT<Object> getP3() { return paramAt(3); }
        default @NotNull IParameterT<Object> getP4() { return paramAt(4); }
        default @NotNull IParameterT<Object> getP5() { return paramAt(5); }
        default @NotNull IParameterT<Object> getP6() { return paramAt(6); }
        default @NotNull IParameterT<Object> getP7() { return paramAt(7); }
        default @NotNull IParameterT<Object> getP8() { return paramAt(8); }
        default @NotNull IParameterT<Object> getP9() { return paramAt(9); }
        default @NotNull IParameterT<Object> getP10() { return paramAt(10); }
        default @NotNull IParameterT<Object> getP11() { return paramAt(11); }
        default @NotNull IParameterT<Object> getP12() { return paramAt(12); }
        default @NotNull IParameterT<Object> getP13() { return paramAt(13); }
        default @NotNull IParameterT<Object> getP14() { return paramAt(14); }
        default @NotNull IParameterT<Object> getP15() { return paramAt(15); }
        default @NotNull IParameterT<Object> parameter(int index) { return paramAt(index); }
    }
}
