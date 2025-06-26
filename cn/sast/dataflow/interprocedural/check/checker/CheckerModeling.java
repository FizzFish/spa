/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.MainConfigKt
 *  cn.sast.common.GLB
 *  cn.sast.coroutines.caffine.impl.FastCacheImpl
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$PostCall
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$PrevCall
 *  cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl$PostCall
 *  cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl$PrevCall
 *  cn.sast.dataflow.interprocedural.check.checker.CheckCallBack
 *  cn.sast.dataflow.interprocedural.check.checker.CheckerModeling
 *  cn.sast.dataflow.interprocedural.check.checker.CheckerModeling$Checker
 *  cn.sast.dataflow.interprocedural.check.checker.CheckerModeling$Companion
 *  cn.sast.dataflow.interprocedural.check.checker.CheckerModeling$WhenMappings
 *  cn.sast.dataflow.interprocedural.check.checker.ModelingCallBack
 *  cn.sast.dataflow.util.ConfigInfoLogger
 *  cn.sast.idfa.analysis.InterproceduralCFG
 *  cn.sast.idfa.check.CallBackManager
 *  com.feysh.corax.cache.coroutines.FastCache
 *  com.feysh.corax.config.api.BugMessage$Env
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.api.IAnalysisDepends
 *  com.feysh.corax.config.api.IBoolExpr
 *  com.feysh.corax.config.api.IExpr
 *  com.feysh.corax.config.api.IJDecl
 *  com.feysh.corax.config.api.IMethodDecl
 *  com.feysh.corax.config.api.IMethodMatch
 *  com.feysh.corax.config.api.IStmt
 *  com.feysh.corax.config.api.MethodConfig
 *  com.feysh.corax.config.api.MethodConfig$CheckCall
 *  com.feysh.corax.config.api.PreAnalysisApi
 *  com.feysh.corax.config.api.XDecl
 *  com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.NotImplementedError
 *  kotlin.Triple
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.GlobalScope
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  soot.Scene
 *  soot.SootMethod
 */
package cn.sast.dataflow.interprocedural.check.checker;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.MainConfigKt;
import cn.sast.common.GLB;
import cn.sast.coroutines.caffine.impl.FastCacheImpl;
import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl;
import cn.sast.dataflow.interprocedural.check.checker.CheckCallBack;
import cn.sast.dataflow.interprocedural.check.checker.CheckerModeling;
import cn.sast.dataflow.interprocedural.check.checker.ModelingCallBack;
import cn.sast.dataflow.util.ConfigInfoLogger;
import cn.sast.idfa.analysis.InterproceduralCFG;
import cn.sast.idfa.check.CallBackManager;
import com.feysh.corax.cache.coroutines.FastCache;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IAnalysisDepends;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IJDecl;
import com.feysh.corax.config.api.IMethodDecl;
import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.IStmt;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.PreAnalysisApi;
import com.feysh.corax.config.api.XDecl;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0006\u0018\u0000 K2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u00020\u00042\u00020\u0005:\u0002KLB\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u001c\u001a\u00020\u001d*\u00100\u001ej\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\u001fH\u0016J9\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.2\u001f\u0010/\u001a\u001b\u0012\b\u0012\u00060%j\u0002`&\u0012\u0004\u0012\u00020\u001d0$j\u0002`(\u00a2\u0006\u0002\b'2\u0006\u00100\u001a\u00020)H\u0016JZ\u00101\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.2\u001f\u0010/\u001a\u001b\u0012\b\u0012\u00060%j\u0002`&\u0012\u0004\u0012\u00020\u001d0$j\u0002`(\u00a2\u0006\u0002\b'2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001d0$\u00a2\u0006\u0002\b'H\u0016J\\\u00108\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.2\u001f\u0010/\u001a\u001b\u0012\b\u0012\u00060%j\u0002`&\u0012\u0004\u0012\u00020\u001d0$j\u0002`(\u00a2\u0006\u0002\b'2\u0006\u00102\u001a\u0002092!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110;\u00a2\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020\u001d0$H\u0016J\b\u0010?\u001a\u00020\u001dH\u0016J\u0015\u0010D\u001a\u00020\u001d*\u00020E2\u0006\u0010F\u001a\u00020EH\u0096\u0005J!\u0010D\u001a\u00020\u001d*\b\u0012\u0004\u0012\u00020E0G2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020E0GH\u0096\u0005J\u0011\u0010I\u001a\u00020E2\u0006\u0010J\u001a\u00020;H\u0096\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR?\u0010 \u001a3\u0012/\u0012-\u0012\u0004\u0012\u00020#\u0012\u001d\u0012\u001b\u0012\b\u0012\u00060%j\u0002`&\u0012\u0004\u0012\u00020\u001d0$j\u0002`(\u00a2\u0006\u0002\b'\u0012\u0004\u0012\u00020)0\"0!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020+0!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010@\u001a\u00020AX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010C\u00a8\u0006M"}, d2={"Lcn/sast/dataflow/interprocedural/check/checker/CheckerModeling;", "Lcn/sast/dataflow/interprocedural/analysis/SummaryHandlePackage;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "Lcom/feysh/corax/config/api/baseimpl/AIAnalysisBaseImpl;", "Lcom/feysh/corax/config/api/IAnalysisDepends;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "icfg", "Lcn/sast/idfa/analysis/InterproceduralCFG;", "preAnalysis", "Lcom/feysh/corax/config/api/PreAnalysisApi;", "<init>", "(Lcn/sast/api/config/MainConfig;Lcn/sast/idfa/analysis/InterproceduralCFG;Lcom/feysh/corax/config/api/PreAnalysisApi;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "getIcfg", "()Lcn/sast/idfa/analysis/InterproceduralCFG;", "getPreAnalysis", "()Lcom/feysh/corax/config/api/PreAnalysisApi;", "fastCache", "Lcom/feysh/corax/cache/coroutines/FastCache;", "getFastCache", "()Lcom/feysh/corax/cache/coroutines/FastCache;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "register", "", "Lcn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/AnalysisInSummary;", "summaries", "", "Lkotlin/Triple;", "Lsoot/SootMethod;", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "Lcom/feysh/corax/config/api/IStmt;", "checkPoints", "Lcn/sast/dataflow/interprocedural/check/checker/CheckerModeling$Checker;", "addStmt", "decl", "Lcom/feysh/corax/config/api/IJDecl;", "config", "stmt", "check", "expr", "Lcom/feysh/corax/config/api/IBoolExpr;", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "env", "Lcom/feysh/corax/config/api/BugMessage$Env;", "eval", "Lcom/feysh/corax/config/api/IExpr;", "accept", "", "Lkotlin/ParameterName;", "name", "value", "validate", "error", "Lcn/sast/dataflow/util/ConfigInfoLogger;", "getError", "()Lcn/sast/dataflow/util/ConfigInfoLogger;", "dependsOn", "Lcom/feysh/corax/config/api/XDecl;", "dep", "", "deps", "toDecl", "target", "Companion", "Checker", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nCheckerModeling.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckerModeling.kt\ncn/sast/dataflow/interprocedural/check/checker/CheckerModeling\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 CheckerManager.kt\ncn/sast/idfa/check/CallBackManager\n*L\n1#1,565:1\n1863#2:566\n1864#2:585\n1863#2:586\n1864#2:605\n1863#2,2:606\n1863#2,2:608\n83#3,3:567\n83#3,3:570\n83#3,3:573\n83#3,3:576\n83#3,3:579\n83#3,3:582\n83#3,3:587\n83#3,3:590\n83#3,3:593\n83#3,3:596\n83#3,3:599\n83#3,3:602\n*S KotlinDebug\n*F\n+ 1 CheckerModeling.kt\ncn/sast/dataflow/interprocedural/check/checker/CheckerModeling\n*L\n392#1:566\n392#1:585\n436#1:586\n436#1:605\n500#1:606,2\n526#1:608,2\n399#1:567,3\n405#1:570,3\n411#1:573,3\n416#1:576,3\n422#1:579,3\n427#1:582,3\n443#1:587,3\n449#1:590,3\n455#1:593,3\n460#1:596,3\n466#1:599,3\n471#1:602,3\n*E\n"})
public final class CheckerModeling
extends AIAnalysisBaseImpl
implements SummaryHandlePackage<IValue>,
IAnalysisDepends {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final /* synthetic */ IAnalysisDepends $$delegate_0;
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final InterproceduralCFG icfg;
    @NotNull
    private final PreAnalysisApi preAnalysis;
    @NotNull
    private final List<Triple<SootMethod, Function1<MethodConfig, Unit>, IStmt>> summaries;
    @NotNull
    private final List<Checker> checkPoints;
    @NotNull
    private final ConfigInfoLogger error;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(CheckerModeling::logger$lambda$10);

    public CheckerModeling(@NotNull MainConfig mainConfig, @NotNull InterproceduralCFG icfg, @NotNull PreAnalysisApi preAnalysis) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        Intrinsics.checkNotNullParameter((Object)icfg, (String)"icfg");
        Intrinsics.checkNotNullParameter((Object)preAnalysis, (String)"preAnalysis");
        this.$$delegate_0 = MainConfigKt.interProceduralAnalysisDepends((MainConfig)mainConfig);
        this.mainConfig = mainConfig;
        this.icfg = icfg;
        this.preAnalysis = preAnalysis;
        this.summaries = new ArrayList();
        this.checkPoints = new ArrayList();
        this.error = new ConfigInfoLogger();
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    @NotNull
    public final InterproceduralCFG getIcfg() {
        return this.icfg;
    }

    @NotNull
    public PreAnalysisApi getPreAnalysis() {
        return this.preAnalysis;
    }

    @NotNull
    public FastCache getFastCache() {
        return (FastCache)FastCacheImpl.INSTANCE;
    }

    @NotNull
    public CoroutineScope getScope() {
        return (CoroutineScope)GlobalScope.INSTANCE;
    }

    public void register(@NotNull ACheckCallAnalysis $this$register) {
        MethodConfig imp;
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"<this>");
        this.getLogger().info(() -> CheckerModeling.register$lambda$0(this));
        Iterable $this$forEach$iv = this.summaries;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Triple triple = (Triple)element$iv;
            boolean bl = false;
            SootMethod method = (SootMethod)triple.component1();
            Function1 config = (Function1)triple.component2();
            IStmt stmt = (IStmt)triple.component3();
            imp = new MethodConfig(MethodConfig.CheckCall.PostCallInCaller);
            config.invoke((Object)imp);
            ModelingCallBack cb = new ModelingCallBack(method, stmt);
            switch (WhenMappings.$EnumSwitchMapping$0[imp.getAt().ordinal()]) {
                case 1: {
                    CallBackManager this_$iv;
                    CallBackManager callBackManager = $this$register.getCallBackManager();
                    Function2 cb$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
                    boolean $i$f$put = false;
                    Class<CallerSiteCBImpl.PrevCall> x$iv = CallerSiteCBImpl.PrevCall.class;
                    this_$iv.put(x$iv, method, cb$iv);
                    break;
                }
                case 2: {
                    CallBackManager this_$iv = $this$register.getCallBackManager();
                    Function2 cb$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
                    boolean $i$f$put = false;
                    Class<CallerSiteCBImpl.PrevCall> x$iv = CallerSiteCBImpl.EvalCall.class;
                    this_$iv.put(x$iv, method, cb$iv);
                    break;
                }
                case 3: {
                    CallBackManager this_$iv = $this$register.getCallBackManager();
                    Function2 cb$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
                    boolean $i$f$put = false;
                    Class<CallerSiteCBImpl.PrevCall> x$iv = CallerSiteCBImpl.PostCall.class;
                    this_$iv.put(x$iv, method, cb$iv);
                    break;
                }
                case 4: {
                    CallBackManager this_$iv = $this$register.getCallBackManager();
                    Function2 cb$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
                    boolean $i$f$put = false;
                    Class<CallerSiteCBImpl.PrevCall> x$iv = CalleeCBImpl.PrevCall.class;
                    this_$iv.put(x$iv, method, cb$iv);
                    break;
                }
                case 5: {
                    CallBackManager this_$iv = $this$register.getCallBackManager();
                    Function2 cb$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
                    boolean $i$f$put = false;
                    Class<CallerSiteCBImpl.PrevCall> x$iv = CalleeCBImpl.EvalCall.class;
                    this_$iv.put(x$iv, method, cb$iv);
                    break;
                }
                case 6: {
                    CallBackManager this_$iv = $this$register.getCallBackManager();
                    Function2 cb$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
                    boolean $i$f$put = false;
                    Class<CallerSiteCBImpl.PrevCall> x$iv = CalleeCBImpl.PostCall.class;
                    this_$iv.put(x$iv, method, cb$iv);
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        this.getLogger().info(() -> CheckerModeling.register$lambda$2(this));
        $this$forEach$iv = this.checkPoints;
        $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Checker checker = (Checker)element$iv;
            boolean bl = false;
            MethodConfig imp2 = new MethodConfig(MethodConfig.CheckCall.PostCallInCaller);
            checker.getConfig().invoke((Object)imp2);
            CheckCallBack cb = new CheckCallBack(checker.getAtMethod(), checker);
            SootMethod method = checker.getAtMethod();
            switch (WhenMappings.$EnumSwitchMapping$0[imp2.getAt().ordinal()]) {
                case 1: {
                    CallBackManager this_$iv;
                    imp = $this$register.getCallBackManager();
                    Function2 cb$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
                    boolean $i$f$put = false;
                    Class<CallerSiteCBImpl.PrevCall> x$iv = CallerSiteCBImpl.PrevCall.class;
                    this_$iv.put(x$iv, method, cb$iv);
                    break;
                }
                case 2: {
                    CallBackManager this_$iv = $this$register.getCallBackManager();
                    Function2 cb$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
                    boolean $i$f$put = false;
                    Class<CallerSiteCBImpl.PrevCall> x$iv = CallerSiteCBImpl.EvalCall.class;
                    this_$iv.put(x$iv, method, cb$iv);
                    break;
                }
                case 3: {
                    CallBackManager this_$iv = $this$register.getCallBackManager();
                    Function2 cb$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
                    boolean $i$f$put = false;
                    Class<CallerSiteCBImpl.PrevCall> x$iv = CallerSiteCBImpl.PostCall.class;
                    this_$iv.put(x$iv, method, cb$iv);
                    break;
                }
                case 4: {
                    CallBackManager this_$iv = $this$register.getCallBackManager();
                    Function2 cb$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
                    boolean $i$f$put = false;
                    Class<CallerSiteCBImpl.PrevCall> x$iv = CalleeCBImpl.PrevCall.class;
                    this_$iv.put(x$iv, method, cb$iv);
                    break;
                }
                case 5: {
                    CallBackManager this_$iv = $this$register.getCallBackManager();
                    Function2 cb$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
                    boolean $i$f$put = false;
                    Class<CallerSiteCBImpl.PrevCall> x$iv = CalleeCBImpl.EvalCall.class;
                    this_$iv.put(x$iv, method, cb$iv);
                    break;
                }
                case 6: {
                    CallBackManager this_$iv = $this$register.getCallBackManager();
                    Function2 cb$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
                    boolean $i$f$put = false;
                    Class<CallerSiteCBImpl.PrevCall> x$iv = CalleeCBImpl.PostCall.class;
                    this_$iv.put(x$iv, method, cb$iv);
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addStmt(@NotNull IJDecl decl, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull IStmt stmt) {
        Intrinsics.checkNotNullParameter((Object)decl, (String)"decl");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
        if (decl instanceof IMethodDecl) {
            IMethodMatch iMethodMatch = ((IMethodDecl)decl).getMatch();
            Scene scene = Scene.v();
            Intrinsics.checkNotNullExpressionValue((Object)scene, (String)"v(...)");
            List sootMethods = iMethodMatch.matched(scene);
            Iterable $this$forEach$iv = sootMethods;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                SootMethod it = (SootMethod)element$iv;
                boolean bl = false;
                List list = this.summaries;
                synchronized (list) {
                    boolean bl2 = false;
                    this.summaries.add(new Triple((Object)it, config, (Object)stmt));
                    Unit unit = Unit.INSTANCE;
                }
            }
        } else {
            this.getLogger().debug(() -> CheckerModeling.addStmt$lambda$6(decl));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void check(@NotNull IJDecl decl, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull IBoolExpr expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
        Intrinsics.checkNotNullParameter((Object)decl, (String)"decl");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
        Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
        Intrinsics.checkNotNullParameter(env, (String)"env");
        GLB.INSTANCE.plusAssign(checkType);
        if (!this.mainConfig.isEnable(checkType)) {
            return;
        }
        if (decl instanceof IMethodDecl) {
            IMethodMatch iMethodMatch = ((IMethodDecl)decl).getMatch();
            Scene scene = Scene.v();
            Intrinsics.checkNotNullExpressionValue((Object)scene, (String)"v(...)");
            List sootMethods = iMethodMatch.matched(scene);
            Iterable $this$forEach$iv = sootMethods;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                SootMethod it = (SootMethod)element$iv;
                boolean bl = false;
                List list = this.checkPoints;
                synchronized (list) {
                    boolean bl2 = false;
                    this.checkPoints.add(new Checker(it, config, expr, checkType, env));
                    Unit unit = Unit.INSTANCE;
                }
            }
        } else {
            this.getLogger().error(() -> CheckerModeling.check$lambda$9(decl));
        }
    }

    public void eval(@NotNull IJDecl decl, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull IExpr expr, @NotNull Function1<Object, Unit> accept) {
        Intrinsics.checkNotNullParameter((Object)decl, (String)"decl");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
        Intrinsics.checkNotNullParameter(accept, (String)"accept");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    public void validate() {
    }

    @NotNull
    public ConfigInfoLogger getError() {
        return this.error;
    }

    @NotNull
    public XDecl toDecl(@NotNull Object target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        return this.$$delegate_0.toDecl(target);
    }

    public void dependsOn(@NotNull XDecl $this$dependsOn, @NotNull XDecl dep) {
        Intrinsics.checkNotNullParameter((Object)$this$dependsOn, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)dep, (String)"dep");
        this.$$delegate_0.dependsOn($this$dependsOn, dep);
    }

    public void dependsOn(@NotNull Collection<? extends XDecl> $this$dependsOn, @NotNull Collection<? extends XDecl> deps) {
        Intrinsics.checkNotNullParameter($this$dependsOn, (String)"<this>");
        Intrinsics.checkNotNullParameter(deps, (String)"deps");
        this.$$delegate_0.dependsOn($this$dependsOn, deps);
    }

    private static final Object register$lambda$0(CheckerModeling this$0) {
        return "summaries model size: " + this$0.summaries.size();
    }

    private static final Object register$lambda$2(CheckerModeling this$0) {
        return "check-points size: " + this$0.checkPoints.size();
    }

    private static final Object addStmt$lambda$6(IJDecl $decl) {
        return "TODO: decl: " + $decl + " not support";
    }

    private static final Object check$lambda$9(IJDecl $decl) {
        return "TODO: decl: " + $decl + " not support";
    }

    private static final Unit logger$lambda$10() {
        return Unit.INSTANCE;
    }
}

