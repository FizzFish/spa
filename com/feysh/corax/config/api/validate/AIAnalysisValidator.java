/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.GlobalScope
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.validate;

import com.feysh.corax.cache.coroutines.FastCache;
import com.feysh.corax.config.api.AIAnalysisApi;
import com.feysh.corax.config.api.AnalysisApiNotImplException;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IJDecl;
import com.feysh.corax.config.api.IStmt;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.PreAnalysisApi;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import com.feysh.corax.config.api.validate.AIAnalysisValidator;
import com.feysh.corax.config.api.validate.CheckInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020&J9\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00112\u001f\u0010-\u001a\u001b\u0012\b\u0012\u00060/j\u0002`0\u0012\u0004\u0012\u00020$0.j\u0002`2\u00a2\u0006\u0002\b12\u0006\u00103\u001a\u00020\u0012H\u0016JZ\u0010%\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00112\u001f\u0010-\u001a\u001b\u0012\b\u0012\u00060/j\u0002`0\u0012\u0004\u0012\u00020$0.j\u0002`2\u00a2\u0006\u0002\b12\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0017\u00108\u001a\u0013\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020$0.\u00a2\u0006\u0002\b1H\u0016J\\\u0010\u0018\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00112\u001f\u0010-\u001a\u001b\u0012\b\u0012\u00060/j\u0002`0\u0012\u0004\u0012\u00020$0.j\u0002`2\u00a2\u0006\u0002\b12\u0006\u00104\u001a\u00020\u00192!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110;\u00a2\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020$0.H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR#\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R#\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020(X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*\u00a8\u0006@"}, d2={"Lcom/feysh/corax/config/api/validate/AIAnalysisValidator;", "Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "errors", "", "", "getErrors", "()Ljava/util/List;", "warnings", "getWarnings", "stmts", "", "Lcom/feysh/corax/config/api/IJDecl;", "Lcom/feysh/corax/config/api/IStmt;", "getStmts", "()Ljava/util/Map;", "checkPoint", "Lcom/feysh/corax/config/api/validate/CheckInfo;", "getCheckPoint", "eval", "Lcom/feysh/corax/config/api/IExpr;", "getEval", "preAnalysis", "Lcom/feysh/corax/config/api/PreAnalysisApi;", "getPreAnalysis", "()Lcom/feysh/corax/config/api/PreAnalysisApi;", "fastCache", "Lcom/feysh/corax/cache/coroutines/FastCache;", "getFastCache", "()Lcom/feysh/corax/cache/coroutines/FastCache;", "validate", "", "check", "", "error", "Lcom/feysh/corax/config/api/AIAnalysisApi$Error;", "getError", "()Lcom/feysh/corax/config/api/AIAnalysisApi$Error;", "addStmt", "decl", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "stmt", "expr", "Lcom/feysh/corax/config/api/IBoolExpr;", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "env", "Lcom/feysh/corax/config/api/BugMessage$Env;", "accept", "", "Lkotlin/ParameterName;", "name", "value", "Companion", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nAIAnalysisValidator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIAnalysisValidator.kt\ncom/feysh/corax/config/api/validate/AIAnalysisValidator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,110:1\n1863#2,2:111\n1863#2,2:113\n381#3,7:115\n381#3,7:122\n381#3,7:129\n*S KotlinDebug\n*F\n+ 1 AIAnalysisValidator.kt\ncom/feysh/corax/config/api/validate/AIAnalysisValidator\n*L\n39#1:111,2\n47#1:113,2\n75#1:115,7\n92#1:122,7\n101#1:129,7\n*E\n"})
public class AIAnalysisValidator
extends AIAnalysisBaseImpl {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final List<String> errors;
    @NotNull
    private final List<String> warnings;
    @NotNull
    private final Map<IJDecl, List<IStmt>> stmts;
    @NotNull
    private final Map<IJDecl, List<CheckInfo>> checkPoint;
    @NotNull
    private final Map<IJDecl, List<IExpr>> eval;
    @NotNull
    private final AIAnalysisApi.Error error;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(AIAnalysisValidator::logger$lambda$20);

    public AIAnalysisValidator(@NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter((Object)scope, (String)"scope");
        this.scope = scope;
        this.errors = new ArrayList();
        this.warnings = new ArrayList();
        this.stmts = new LinkedHashMap();
        this.checkPoint = new LinkedHashMap();
        this.eval = new LinkedHashMap();
        this.error = new AIAnalysisApi.Error(this){
            final /* synthetic */ AIAnalysisValidator this$0;
            {
                this.this$0 = $receiver;
            }

            public void error(String msg) {
                Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
                this.getLogger().error(() -> error.1.error$lambda$0(msg));
                this.this$0.getErrors().add(msg);
            }

            public void warning(String msg) {
                Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
                this.getLogger().warn(() -> error.1.warning$lambda$1(msg));
                this.this$0.getWarnings().add(msg);
            }

            public KLogger getLogger() {
                return AIAnalysisValidator.Companion.getLogger();
            }

            private static final Object error$lambda$0(String $msg) {
                return $msg;
            }

            private static final Object warning$lambda$1(String $msg) {
                return $msg;
            }
        };
    }

    public /* synthetic */ AIAnalysisValidator(CoroutineScope coroutineScope, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            coroutineScope = (CoroutineScope)GlobalScope.INSTANCE;
        }
        this(coroutineScope);
    }

    @Override
    @NotNull
    public CoroutineScope getScope() {
        return this.scope;
    }

    @NotNull
    public final List<String> getErrors() {
        return this.errors;
    }

    @NotNull
    public final List<String> getWarnings() {
        return this.warnings;
    }

    @NotNull
    public final Map<IJDecl, List<IStmt>> getStmts() {
        return this.stmts;
    }

    @NotNull
    public final Map<IJDecl, List<CheckInfo>> getCheckPoint() {
        return this.checkPoint;
    }

    @NotNull
    public final Map<IJDecl, List<IExpr>> getEval() {
        return this.eval;
    }

    @Override
    @NotNull
    public PreAnalysisApi getPreAnalysis() {
        throw new AnalysisApiNotImplException("just a test");
    }

    @Override
    @NotNull
    public FastCache getFastCache() {
        throw new AnalysisApiNotImplException("just a test");
    }

    @Override
    public void validate() {
        String it;
        Iterable $this$forEach$iv = this.warnings;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            it = (String)element$iv;
            boolean bl = false;
            this.getLogger().warn(() -> AIAnalysisValidator.validate$lambda$1$lambda$0(it));
        }
        if (!this.check()) {
            this.getLogger().error(AIAnalysisValidator::validate$lambda$2);
            this.getLogger().error(AIAnalysisValidator::validate$lambda$3);
            this.getLogger().error(AIAnalysisValidator::validate$lambda$4);
            $this$forEach$iv = this.errors;
            $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                it = (String)element$iv;
                boolean bl = false;
                this.getLogger().error(() -> AIAnalysisValidator.validate$lambda$6$lambda$5(it));
            }
            this.getLogger().error(() -> AIAnalysisValidator.validate$lambda$7(this));
        }
    }

    public final boolean check() {
        return this.errors.isEmpty();
    }

    @Override
    @NotNull
    public AIAnalysisApi.Error getError() {
        return this.error;
    }

    @Override
    public void addStmt(@NotNull IJDecl decl, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull IStmt stmt) {
        List list;
        Intrinsics.checkNotNullParameter((Object)decl, (String)"decl");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
        Map<IJDecl, List<IStmt>> $this$getOrPut$iv = this.stmts;
        boolean $i$f$getOrPut = false;
        List value$iv = $this$getOrPut$iv.get(decl);
        if (value$iv == null) {
            boolean bl = false;
            this.getLogger().debug(AIAnalysisValidator::addStmt$lambda$10$lambda$8);
            this.getLogger().debug(() -> AIAnalysisValidator.addStmt$lambda$10$lambda$9(decl));
            List answer$iv = new ArrayList();
            $this$getOrPut$iv.put(decl, answer$iv);
            list = answer$iv;
        } else {
            list = value$iv;
        }
        list.add((IStmt)stmt);
        this.getLogger().debug(() -> AIAnalysisValidator.addStmt$lambda$11(stmt));
    }

    @Override
    public void check(@NotNull IJDecl decl, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull IBoolExpr expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
        List list;
        Intrinsics.checkNotNullParameter((Object)decl, (String)"decl");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
        Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
        Intrinsics.checkNotNullParameter(env, (String)"env");
        CheckInfo check = new CheckInfo(expr, checkType);
        Map<IJDecl, List<CheckInfo>> $this$getOrPut$iv = this.checkPoint;
        boolean $i$f$getOrPut = false;
        List value$iv = $this$getOrPut$iv.get(decl);
        if (value$iv == null) {
            boolean bl = false;
            this.getLogger().debug(AIAnalysisValidator::check$lambda$14$lambda$12);
            this.getLogger().debug(() -> AIAnalysisValidator.check$lambda$14$lambda$13(decl));
            List answer$iv = new ArrayList();
            $this$getOrPut$iv.put(decl, answer$iv);
            list = answer$iv;
        } else {
            list = value$iv;
        }
        list.add((CheckInfo)check);
        this.getLogger().debug(() -> AIAnalysisValidator.check$lambda$15(check));
    }

    @Override
    public void eval(@NotNull IJDecl decl, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull IExpr expr, @NotNull Function1<Object, Unit> accept) {
        List list;
        Intrinsics.checkNotNullParameter((Object)decl, (String)"decl");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
        Intrinsics.checkNotNullParameter(accept, (String)"accept");
        Map<IJDecl, List<IExpr>> $this$getOrPut$iv = this.eval;
        boolean $i$f$getOrPut = false;
        List value$iv = $this$getOrPut$iv.get(decl);
        if (value$iv == null) {
            boolean bl = false;
            this.getLogger().debug(AIAnalysisValidator::eval$lambda$18$lambda$16);
            this.getLogger().debug(() -> AIAnalysisValidator.eval$lambda$18$lambda$17(decl));
            List answer$iv = new ArrayList();
            $this$getOrPut$iv.put(decl, answer$iv);
            list = answer$iv;
        } else {
            list = value$iv;
        }
        list.add((IExpr)expr);
        this.getLogger().debug(() -> AIAnalysisValidator.eval$lambda$19(expr));
    }

    private static final Object validate$lambda$1$lambda$0(String $it) {
        return $it;
    }

    private static final Object validate$lambda$2() {
        return "";
    }

    private static final Object validate$lambda$3() {
        return "";
    }

    private static final Object validate$lambda$4() {
        return "";
    }

    private static final Object validate$lambda$6$lambda$5(String $it) {
        return $it;
    }

    private static final Object validate$lambda$7(AIAnalysisValidator this$0) {
        return "Please fix errors. num: " + this$0.errors.size();
    }

    private static final Object addStmt$lambda$10$lambda$8() {
        return "";
    }

    private static final Object addStmt$lambda$10$lambda$9(IJDecl $decl) {
        return $decl + " :";
    }

    private static final Object addStmt$lambda$11(IStmt $stmt) {
        return "\t\tadd stmt: " + $stmt;
    }

    private static final Object check$lambda$14$lambda$12() {
        return "";
    }

    private static final Object check$lambda$14$lambda$13(IJDecl $decl) {
        return $decl + " :";
    }

    private static final Object check$lambda$15(CheckInfo $check) {
        return "\t\tadd check point: " + $check;
    }

    private static final Object eval$lambda$18$lambda$16() {
        return "";
    }

    private static final Object eval$lambda$18$lambda$17(IJDecl $decl) {
        return $decl + " :";
    }

    private static final Object eval$lambda$19(IExpr $expr) {
        return "\t\tadd eval expr: " + $expr;
    }

    private static final Unit logger$lambda$20() {
        return Unit.INSTANCE;
    }

    public AIAnalysisValidator() {
        this(null, 1, null);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lcom/feysh/corax/config/api/validate/AIAnalysisValidator$Companion;", "", "<init>", "()V", "logger", "Lmu/KLogger;", "getLogger", "()Lmu/KLogger;", "corax-config-api"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KLogger getLogger() {
            return logger;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

