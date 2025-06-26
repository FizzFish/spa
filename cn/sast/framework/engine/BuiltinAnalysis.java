/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.BuiltinAnalysisConfig
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.util.OthersKt
 *  cn.sast.dataflow.analysis.IBugReporter
 *  cn.sast.dataflow.analysis.deadcode.DeadCode
 *  cn.sast.dataflow.analysis.deadstore.DeadStore
 *  cn.sast.framework.SootCtx
 *  cn.sast.framework.engine.BuiltinAnalysis
 *  cn.sast.framework.engine.BuiltinAnalysis$BugReporter
 *  cn.sast.framework.engine.BuiltinAnalysis$CHA-AllMethodsProvider
 *  cn.sast.framework.engine.BuiltinAnalysis$Companion
 *  cn.sast.framework.engine.BuiltinAnalysis$analyzeInScene$1
 *  cn.sast.framework.result.IBuiltInAnalysisCollector
 *  com.feysh.corax.cache.analysis.SootInfoCache
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.CoroutineScopeKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.utbot.common.LoggerWithLogMethod
 *  org.utbot.common.LoggingKt
 *  org.utbot.common.Maybe
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 */
package cn.sast.framework.engine;

import cn.sast.api.config.BuiltinAnalysisConfig;
import cn.sast.api.config.MainConfig;
import cn.sast.api.util.OthersKt;
import cn.sast.dataflow.analysis.IBugReporter;
import cn.sast.dataflow.analysis.deadcode.DeadCode;
import cn.sast.dataflow.analysis.deadstore.DeadStore;
import cn.sast.framework.SootCtx;
import cn.sast.framework.engine.BuiltinAnalysis;
import cn.sast.framework.result.IBuiltInAnalysisCollector;
import com.feysh.corax.cache.analysis.SootInfoCache;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.common.LoggerWithLogMethod;
import org.utbot.common.LoggingKt;
import org.utbot.common.Maybe;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0003\u0017\u0018\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0010J.\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001a"}, d2={"Lcn/sast/framework/engine/BuiltinAnalysis;", "", "mainConfig", "Lcn/sast/api/config/MainConfig;", "info", "Lcom/feysh/corax/cache/analysis/SootInfoCache;", "<init>", "(Lcn/sast/api/config/MainConfig;Lcom/feysh/corax/cache/analysis/SootInfoCache;)V", "getInfo", "()Lcom/feysh/corax/cache/analysis/SootInfoCache;", "analyzeInScene", "", "soot", "Lcn/sast/framework/SootCtx;", "resultCollector", "Lcn/sast/framework/result/IBuiltInAnalysisCollector;", "(Lcn/sast/framework/SootCtx;Lcn/sast/framework/result/IBuiltInAnalysisCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "allMethodsAnalyzeInScene", "builtinAnalysisConfig", "Lcn/sast/api/config/BuiltinAnalysisConfig;", "allMethodsProvider", "Lcn/sast/framework/engine/BuiltinAnalysis$CHA-AllMethodsProvider;", "(Lcn/sast/framework/SootCtx;Lcn/sast/api/config/BuiltinAnalysisConfig;Lcn/sast/framework/engine/BuiltinAnalysis$CHA-AllMethodsProvider;Lcn/sast/framework/result/IBuiltInAnalysisCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "BugReporter", "CHA-AllMethodsProvider", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nBuiltinAnalysis.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuiltinAnalysis.kt\ncn/sast/framework/engine/BuiltinAnalysis\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Logging.kt\norg/utbot/common/LoggingKt\n*L\n1#1,185:1\n774#2:186\n865#2,2:187\n1368#2:189\n1454#2,2:190\n774#2:192\n865#2,2:193\n1456#2,3:195\n49#3,24:198\n49#3,24:222\n*S KotlinDebug\n*F\n+ 1 BuiltinAnalysis.kt\ncn/sast/framework/engine/BuiltinAnalysis\n*L\n115#1:186\n115#1:187,2\n116#1:189\n116#1:190,2\n116#1:192\n116#1:193,2\n116#1:195,3\n120#1:198,24\n168#1:222,24\n*E\n"})
public final class BuiltinAnalysis {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final SootInfoCache info;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(BuiltinAnalysis::logger$lambda$6);

    public BuiltinAnalysis(@NotNull MainConfig mainConfig, @NotNull SootInfoCache info2) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        Intrinsics.checkNotNullParameter((Object)info2, (String)"info");
        this.mainConfig = mainConfig;
        this.info = info2;
    }

    @NotNull
    public final SootInfoCache getInfo() {
        return this.info;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    @Nullable
    public final Object analyzeInScene(@NotNull SootCtx var1_1, @NotNull IBuiltInAnalysisCollector var2_2, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof analyzeInScene.1)) ** GOTO lbl-1000
        var28_4 = $completion;
        if ((var28_4.label & -2147483648) != 0) {
            var28_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var30_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                soot.getCallGraph();
                reporter = new BugReporter((IBuiltInAnalysisCollector)resultCollector, this.info);
                deadStore = new DeadStore((IBugReporter)reporter);
                deadCode = new DeadCode((IBugReporter)reporter);
                v0 = Scene.v().getApplicationClasses();
                Intrinsics.checkNotNullExpressionValue((Object)v0, (String)"getApplicationClasses(...)");
                $this$filter$iv = (Iterable)v0;
                $i$f$filter = false;
                var10_13 = $this$filter$iv;
                destination$iv$iv = new ArrayList<E>();
                $i$f$filterTo = false;
                for (T element$iv$iv : $this$filterTo$iv$iv) {
                    it = (SootClass)element$iv$iv;
                    $i$a$-filter-BuiltinAnalysis$analyzeInScene$analyzedMethods$1 = false;
                    if (Scene.v().isExcluded(it)) ** GOTO lbl-1000
                    Intrinsics.checkNotNull((Object)it);
                    if (!OthersKt.isSyntheticComponent((SootClass)it)) {
                        v1 = true;
                    } else lbl-1000:
                    // 2 sources

                    {
                        v1 = false;
                    }
                    if (!v1) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                $this$flatMap$iv = (List)destination$iv$iv;
                $i$f$flatMap = false;
                $this$filterTo$iv$iv = $this$flatMap$iv;
                destination$iv$iv = new ArrayList<E>();
                $i$f$flatMapTo = false;
                for (T element$iv$iv : $this$flatMapTo$iv$iv) {
                    it = (SootClass)element$iv$iv;
                    $i$a$-flatMap-BuiltinAnalysis$analyzeInScene$analyzedMethods$2 = false;
                    v2 = it.getMethods();
                    Intrinsics.checkNotNullExpressionValue((Object)v2, (String)"getMethods(...)");
                    $this$filter$iv = v2;
                    $i$f$filter = false;
                    var19_28 = $this$filter$iv;
                    destination$iv$iv = new ArrayList<E>();
                    $i$f$filterTo = false;
                    for (T element$iv$iv : $this$filterTo$iv$iv) {
                        m = (SootMethod)element$iv$iv;
                        $i$a$-filter-BuiltinAnalysis$analyzeInScene$analyzedMethods$2$1 = false;
                        Intrinsics.checkNotNull((Object)m);
                        if (!(OthersKt.isDummy((SootMethod)m) == false && m.hasActiveBody() != false)) continue;
                        destination$iv$iv.add(element$iv$iv);
                    }
                    list$iv$iv = (List)destination$iv$iv;
                    CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
                }
                analyzedMethods = (List)destination$iv$iv;
                targets = this.mainConfig.simpleDeclIncrementalAnalysisFilter((Collection)analyzedMethods);
                $i$f$flatMap = LoggingKt.info((KLogger)BuiltinAnalysis.logger);
                msg$iv = "Builtin analysis phase 2.";
                $i$f$bracket = false;
                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                startTime$iv = LocalDateTime.now();
                alreadyLogged$iv = 0;
                res$iv = new Ref.ObjectRef();
                res$iv.element = Maybe.Companion.empty();
                var26_36 = res$iv;
                $i$a$-bracket$default-BuiltinAnalysis$analyzeInScene$2 = false;
                $continuation.L$0 = $this$bracket_u24default$iv;
                $continuation.L$1 = msg$iv;
                $continuation.L$2 = startTime$iv;
                $continuation.L$3 = res$iv;
                $continuation.L$4 = var26_36;
                $continuation.I$0 = alreadyLogged$iv;
                $continuation.label = 1;
                v3 = CoroutineScopeKt.coroutineScope((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (Continuation)$continuation);
                ** if (v3 != var30_6) goto lbl89
lbl88:
                // 1 sources

                return var30_6;
lbl89:
                // 1 sources

                ** GOTO lbl103
            }
            case 1: {
                $i$f$bracket = false;
                $i$a$-bracket$default-BuiltinAnalysis$analyzeInScene$2 = false;
                alreadyLogged$iv = $continuation.I$0;
                var26_36 = (Ref.ObjectRef)$continuation.L$4;
                res$iv = (Ref.ObjectRef)$continuation.L$3;
                startTime$iv = (LocalDateTime)$continuation.L$2;
                msg$iv = (String)$continuation.L$1;
                $this$bracket_u24default$iv = (LoggerWithLogMethod)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v3 = $result;
lbl103:
                    // 2 sources

                    var29_37 = Unit.INSTANCE;
                    var26_36.element = new Maybe((Object)var29_37);
                    var16_23 = ((Maybe)res$iv.element).getOrThrow();
                }
                catch (Throwable t$iv) {
                    try {
                        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                        alreadyLogged$iv = 1;
                        throw t$iv;
                    }
                    catch (Throwable var17_26) {
                        if (alreadyLogged$iv == 0) {
                            if (((Maybe)res$iv.element).getHasValue()) {
                                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                            } else {
                                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                            }
                        }
                        throw var17_26;
                    }
                }
                if (((Maybe)res$iv.element).getHasValue()) {
                    $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                } else {
                    $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                }
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Exception decompiling
     */
    @Nullable
    public final Object allMethodsAnalyzeInScene(@NotNull SootCtx var1_1, @NotNull BuiltinAnalysisConfig var2_2, @NotNull CHA-AllMethodsProvider var3_3, @NotNull IBuiltInAnalysisCollector var4_4, @NotNull Continuation<? super Unit> $completion) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[CASE], 5[SWITCH]], but top level block is 3[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static final Object allMethodsAnalyzeInScene$lambda$5$lambda$4() {
        return "Please file this bug to us";
    }

    private static final Unit logger$lambda$6() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }
}

