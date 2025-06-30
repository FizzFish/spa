/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u0002H\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\b\u0005H\u0082\b\u00a2\u0006\u0002\u0010\u0006\u001a\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u001a\u001f\u0010\u0015\u001a\u00020\u00162\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00120\u0003\u00a2\u0006\u0002\b\u0005\u001ag\u0010 \u001a\b\u0012\u0004\u0012\u0002H\"0!\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0!2!\b\u0002\u0010$\u001a\u001b\u0012\b\u0012\u00060%j\u0002`&\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`'\u00a2\u0006\u0002\b\u00052\u001d\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0(\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\b\u0005R\u00020#\u00a2\u0006\u0002\u0010)\"\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\f\"\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\f*.\u0010\u0019\"\u0014\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\b0\u001a2\u0014\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\b0\u001a*.\u0010\u001d\"\u0014\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\b0\u001a2\u0014\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\b0\u001a\u00a8\u0006*"}, d2={"tryApply", "T", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "feyshRules", "", "Lcom/feysh/corax/config/api/IRule;", "Lcom/feysh/corax/config/api/CheckType;", "getFeyshRules", "(Lcom/feysh/corax/config/api/CheckType;)Ljava/util/Set;", "cweRules", "getCweRules", "certRules", "getCertRules", "quotedIfNotNull", "", "s", "", "msgGenerator", "Lcom/feysh/corax/config/api/BugMessage;", "msg", "Lcom/feysh/corax/config/api/BugMessage$Env;", "ITaintSet", "Lcom/feysh/corax/config/api/IAttribute;", "Lcom/feysh/corax/config/api/TaintProperty;", "Lcom/feysh/corax/config/api/ITaintType;", "IViaSet", "Lcom/feysh/corax/config/api/ViaProperty;", "Lcom/feysh/corax/config/api/IViaType;", "modelNoArgSoot", "Lcom/feysh/corax/config/api/IMethodDecl;", "R", "Lcom/feysh/corax/config/api/AIAnalysisApi;", "config", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "Lcom/feysh/corax/config/api/ISootMethodDecl$CheckBuilder;", "(Lcom/feysh/corax/config/api/AIAnalysisApi;Lcom/feysh/corax/config/api/IMethodDecl;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lcom/feysh/corax/config/api/IMethodDecl;", "corax-config-api"})
public final class AIAnalysisApiKt {
    private static final <T> T tryApply(T $this$tryApply, Function1<? super T, Unit> block) {
        boolean $i$f$tryApply = false;
        try {
            block.invoke($this$tryApply);
        }
        catch (ConfigException ignore) {
            System.err.println(ignore);
        }
        return $this$tryApply;
    }

    @NotNull
    public static final Set<IRule> getFeyshRules(@NotNull CheckType $this$feyshRules) {
        Intrinsics.checkNotNullParameter((Object)$this$feyshRules, (String)"<this>");
        return $this$feyshRules.getRulesByName("feysh");
    }

    @NotNull
    public static final Set<IRule> getCweRules(@NotNull CheckType $this$cweRules) {
        Intrinsics.checkNotNullParameter((Object)$this$cweRules, (String)"<this>");
        return $this$cweRules.getRulesByName("cwe");
    }

    @NotNull
    public static final Set<IRule> getCertRules(@NotNull CheckType $this$certRules) {
        Intrinsics.checkNotNullParameter((Object)$this$certRules, (String)"<this>");
        return $this$certRules.getRulesByName("cert");
    }

    @NotNull
    public static final String quotedIfNotNull(@Nullable Object s) {
        return s == null ? "" : "`" + s + "`";
    }

    @NotNull
    public static final BugMessage msgGenerator(@NotNull Function1<? super BugMessage.Env, String> msg) {
        Intrinsics.checkNotNullParameter(msg, (String)"msg");
        return new BugMessage(msg);
    }

    @NotNull
    public static final <R> IMethodDecl<R> modelNoArgSoot(@NotNull AIAnalysisApi $context_receiver_0, @NotNull IMethodDecl<R> $this$modelNoArgSoot, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function1<? super ISootMethodDecl.CheckBuilder<R>, Unit> block) {
        Intrinsics.checkNotNullParameter($this$modelNoArgSoot, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        for (ISootMethodDecl sootMethodDecl : $context_receiver_0.getSootDecl($this$modelNoArgSoot)) {
            sootMethodDecl.modelNoArg(config, block);
        }
        return $this$modelNoArgSoot;
    }

    public static /* synthetic */ IMethodDecl modelNoArgSoot$default(AIAnalysisApi aIAnalysisApi, IMethodDecl iMethodDecl, Function1 function1, Function1 function12, int n, Object object) {
        if ((n & 2) != 0) {
            function1 = AIAnalysisApiKt::modelNoArgSoot$lambda$0;
        }
        return AIAnalysisApiKt.modelNoArgSoot(aIAnalysisApi, iMethodDecl, (Function1<? super MethodConfig, Unit>)function1, function12);
    }

    private static final Unit modelNoArgSoot$lambda$0(MethodConfig methodConfig) {
        Intrinsics.checkNotNullParameter((Object)methodConfig, (String)"<this>");
        return Unit.INSTANCE;
    }
}

