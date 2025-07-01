package com.feysh.corax.config.api;

import com.feysh.corax.config.api.AIAnalysisApi;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IMethodDecl;
import com.feysh.corax.config.api.IRule;
import com.feysh.corax.config.api.ISootMethodDecl;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.baseimpl.ConfigException;
import java.util.Set;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AIAnalysisApiKt {
    private static <T> T tryApply(T obj, Consumer<T> block) {
        try {
            block.accept(obj);
        } catch (ConfigException ignore) {
            System.err.println(ignore);
        }
        return obj;
    }

    @NotNull
    public static Set<IRule> getFeyshRules(@NotNull CheckType checkType) {
        return checkType.getRulesByName("feysh");
    }

    @NotNull
    public static Set<IRule> getCweRules(@NotNull CheckType checkType) {
        return checkType.getRulesByName("cwe");
    }

    @NotNull
    public static Set<IRule> getCertRules(@NotNull CheckType checkType) {
        return checkType.getRulesByName("cert");
    }

    @NotNull
    public static String quotedIfNotNull(@Nullable Object s) {
        return s == null ? "" : "`" + s + "`";
    }

    @NotNull
    public static BugMessage msgGenerator(@NotNull java.util.function.Function<BugMessage.Env, String> msg) {
        return new BugMessage(msg);
    }

    @NotNull
    public static <R> IMethodDecl<R> modelNoArgSoot(
            @NotNull AIAnalysisApi context,
            @NotNull IMethodDecl<R> methodDecl,
            @NotNull Consumer<MethodConfig> config,
            @NotNull Consumer<ISootMethodDecl.CheckBuilder<R>> block) {
        
        for (ISootMethodDecl sootMethodDecl : context.getSootDecl(methodDecl)) {
            sootMethodDecl.modelNoArg(config, block);
        }
        return methodDecl;
    }

    @NotNull
    public static <R> IMethodDecl<R> modelNoArgSoot(
            @NotNull AIAnalysisApi context,
            @NotNull IMethodDecl<R> methodDecl,
            @NotNull Consumer<ISootMethodDecl.CheckBuilder<R>> block) {
        
        return modelNoArgSoot(context, methodDecl, c -> {}, block);
    }
}