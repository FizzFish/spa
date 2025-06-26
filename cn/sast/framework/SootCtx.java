/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ExtSettings
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.SaConfig
 *  cn.sast.api.config.ScanFilter
 *  cn.sast.api.config.SrcPrecedence
 *  cn.sast.api.incremental.IncrementalAnalyze
 *  cn.sast.api.report.ClassResInfo
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.api.util.IMonitor
 *  cn.sast.api.util.OthersKt
 *  cn.sast.api.util.PhaseIntervalTimer
 *  cn.sast.api.util.PhaseIntervalTimer$Snapshot
 *  cn.sast.api.util.Timer
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResDirectory$DefaultImpls
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.framework.CgAlgorithmProvider
 *  cn.sast.framework.SootCtx
 *  cn.sast.framework.SootCtx$Companion
 *  cn.sast.framework.SootCtx$WhenMappings
 *  cn.sast.framework.SootCtx$findClassesInnerJar$1
 *  cn.sast.framework.SootCtx$findClassesInnerJarUnderAutoAppClassPath$1
 *  cn.sast.framework.SootCtxKt
 *  cn.sast.framework.SourceLocatorPlus
 *  cn.sast.framework.compiler.EcjCompiler
 *  cn.sast.framework.graph.CGUtils
 *  cn.sast.framework.incremental.IncrementalAnalyzeImplByChangeFiles
 *  cn.sast.framework.report.IWrapperFileGenerator
 *  cn.sast.framework.report.NullWrapperFileGenerator
 *  cn.sast.framework.report.ProjectFileLocator
 *  cn.sast.framework.rewrite.LibraryClassPatcher
 *  cn.sast.framework.rewrite.StringConcatRewriterTransform
 *  cn.sast.idfa.analysis.ProcessInfoView
 *  com.feysh.corax.config.api.ISootInitializeHandler
 *  com.feysh.corax.config.api.ISootInitializeHandler$DefaultImpls
 *  com.feysh.corax.config.api.rules.ProcessRule$ScanAction
 *  driver.PTAFactory
 *  driver.PTAPattern
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.PersistentSet
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScopeKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.utbot.common.LoggerWithLogMethod
 *  org.utbot.common.LoggingKt
 *  org.utbot.common.Maybe
 *  org.utbot.framework.plugin.services.JdkInfo
 *  org.utbot.framework.plugin.services.JdkInfoService
 *  qilin.CoreConfig
 *  qilin.CoreConfig$CorePTAConfiguration
 *  qilin.core.PTA
 *  qilin.core.PTAScene
 *  qilin.core.pag.ValNode
 *  qilin.pta.PTAConfig
 *  qilin.util.MemoryWatcher
 *  qilin.util.PTAUtils
 *  soot.G
 *  soot.Main
 *  soot.MethodOrMethodContext
 *  soot.Pack
 *  soot.PackManager
 *  soot.PointsToAnalysis
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.SourceLocator
 *  soot.Transform
 *  soot.Transformer
 *  soot.jimple.infoflow.AbstractInfoflow
 *  soot.jimple.toolkits.callgraph.CallGraph
 *  soot.jimple.toolkits.callgraph.Edge
 *  soot.jimple.toolkits.pointer.DumbPointerAnalysis
 *  soot.options.Options
 *  soot.util.Chain
 */
package cn.sast.framework;

import cn.sast.api.config.ExtSettings;
import cn.sast.api.config.MainConfig;
import cn.sast.api.config.SaConfig;
import cn.sast.api.config.ScanFilter;
import cn.sast.api.config.SrcPrecedence;
import cn.sast.api.incremental.IncrementalAnalyze;
import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.api.util.IMonitor;
import cn.sast.api.util.OthersKt;
import cn.sast.api.util.PhaseIntervalTimer;
import cn.sast.api.util.Timer;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.framework.CgAlgorithmProvider;
import cn.sast.framework.SootCtx;
import cn.sast.framework.SootCtxKt;
import cn.sast.framework.SourceLocatorPlus;
import cn.sast.framework.compiler.EcjCompiler;
import cn.sast.framework.graph.CGUtils;
import cn.sast.framework.incremental.IncrementalAnalyzeImplByChangeFiles;
import cn.sast.framework.report.IWrapperFileGenerator;
import cn.sast.framework.report.NullWrapperFileGenerator;
import cn.sast.framework.report.ProjectFileLocator;
import cn.sast.framework.rewrite.LibraryClassPatcher;
import cn.sast.framework.rewrite.StringConcatRewriterTransform;
import cn.sast.idfa.analysis.ProcessInfoView;
import com.feysh.corax.config.api.ISootInitializeHandler;
import com.feysh.corax.config.api.rules.ProcessRule;
import driver.PTAFactory;
import driver.PTAPattern;
import java.io.File;
import java.lang.invoke.LambdaMetafactory;
import java.nio.file.InvalidPathException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentSet;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.common.LoggerWithLogMethod;
import org.utbot.common.LoggingKt;
import org.utbot.common.Maybe;
import org.utbot.framework.plugin.services.JdkInfo;
import org.utbot.framework.plugin.services.JdkInfoService;
import qilin.CoreConfig;
import qilin.core.PTA;
import qilin.core.PTAScene;
import qilin.core.pag.ValNode;
import qilin.pta.PTAConfig;
import qilin.util.MemoryWatcher;
import qilin.util.PTAUtils;
import soot.G;
import soot.Main;
import soot.MethodOrMethodContext;
import soot.Pack;
import soot.PackManager;
import soot.PointsToAnalysis;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SourceLocator;
import soot.Transform;
import soot.Transformer;
import soot.jimple.infoflow.AbstractInfoflow;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.pointer.DumbPointerAnalysis;
import soot.options.Options;
import soot.util.Chain;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J(\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\"\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010!\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\u0006\u0010\"\u001a\u00020\u0017J(\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0$2\u0006\u0010'\u001a\u00020(H\u0086@\u00a2\u0006\u0002\u0010)J\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020&0+H\u0086@\u00a2\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u00103\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u0002062\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010-\u001a\u00020\u00172\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010-\u001a\u00020\u00172\u0006\u00107\u001a\u000208H\u0016J\u0018\u00109\u001a\u00020\u00172\u0006\u00105\u001a\u0002062\b\u0010'\u001a\u0004\u0018\u00010(J\u001c\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020<0;*\b\u0012\u0004\u0012\u00020>0=J\u0010\u0010?\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020>0=J.\u0010@\u001a\u00020\u00172\u0006\u00105\u001a\u0002062\b\b\u0002\u0010A\u001a\u00020\u001b2\u0014\b\u0002\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0CJ\u001a\u0010D\u001a\u00020\u00172\u0006\u00105\u001a\u0002062\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010E\u001a\u00020\u0017H\u0016J\u0014\u0010F\u001a\u00020\u00172\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0018\u0010G\u001a\u00020\u00172\u0006\u00105\u001a\u0002062\u0006\u0010H\u001a\u00020IH\u0016J\b\u0010G\u001a\u00020\u0017H\u0016J\b\u0010J\u001a\u00020\u0017H\u0016J\b\u0010K\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010.\u001a\u00020(8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b/\u00100R$\u0010N\u001a\u00020M2\u0006\u0010L\u001a\u00020M8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0011\u0010S\u001a\u00020M8F\u00a2\u0006\u0006\u001a\u0004\bT\u0010PR\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020W0V8F\u00a2\u0006\u0006\u001a\u0004\bX\u0010Y\u00a8\u0006["}, d2={"Lcn/sast/framework/SootCtx;", "Lcom/feysh/corax/config/api/ISootInitializeHandler;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "<init>", "(Lcn/sast/api/config/MainConfig;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "monitor", "Lcn/sast/api/util/IMonitor;", "getMonitor", "()Lcn/sast/api/util/IMonitor;", "_loadClassesTimer", "Lcn/sast/api/util/Timer;", "_classesClassificationTimer", "_cgConstructTimer", "cgAlgorithmProvider", "Lcn/sast/framework/CgAlgorithmProvider;", "getCgAlgorithmProvider", "()Lcn/sast/framework/CgAlgorithmProvider;", "setCgAlgorithmProvider", "(Lcn/sast/framework/CgAlgorithmProvider;)V", "configureCallGraph", "", "options", "Lsoot/options/Options;", "callGraphAlgorithm", "", "appOnly", "", "enableReflection", "constructCallGraph", "cgAlgorithm", "record", "showPta", "findClassesInnerJar", "", "", "Lcn/sast/common/IResFile;", "locator", "Lcn/sast/framework/report/ProjectFileLocator;", "(Lcn/sast/framework/report/ProjectFileLocator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findClassesInnerJarUnderAutoAppClassPath", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configure", "autoAppClassesLocator", "getAutoAppClassesLocator", "()Lcn/sast/framework/report/ProjectFileLocator;", "autoAppClassesLocator$delegate", "Lkotlin/Lazy;", "configureSootClassPath", "configureAfterSceneInit", "scene", "Lsoot/Scene;", "main", "Lsoot/Main;", "classesClassification", "activeBodyMethods", "Lkotlin/Pair;", "", "Lsoot/util/Chain;", "Lsoot/SootClass;", "show", "showClasses", "prefix", "fx", "Lkotlin/Function1;", "loadClasses", "configureSoot", "constructSoot", "releaseCallGraph", "g", "Lsoot/G;", "onBeforeCallGraphConstruction", "onAfterCallGraphConstruction", "value", "Lsoot/jimple/toolkits/callgraph/CallGraph;", "callGraph", "getCallGraph", "()Lsoot/jimple/toolkits/callgraph/CallGraph;", "setCallGraph", "(Lsoot/jimple/toolkits/callgraph/CallGraph;)V", "sootMethodCallGraph", "getSootMethodCallGraph", "entryPoints", "", "Lsoot/SootMethod;", "getEntryPoints", "()Ljava/util/List;", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nSootCtx.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SootCtx.kt\ncn/sast/framework/SootCtx\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Logging.kt\norg/utbot/common/LoggingKt\n+ 4 Timer.kt\ncn/sast/api/util/TimerKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n2632#2,3:732\n1557#2:767\n1628#2,2:768\n2318#2,14:770\n1630#2:784\n1053#2:785\n1368#2:787\n1454#2,5:788\n774#2:793\n865#2,2:794\n774#2:796\n865#2,2:797\n1053#2:871\n1053#2:872\n49#3,13:735\n62#3,11:756\n49#3,13:799\n62#3,11:836\n49#3,24:847\n16#4,8:748\n16#4,8:812\n16#4,8:820\n16#4,8:828\n1#5:786\n*S KotlinDebug\n*F\n+ 1 SootCtx.kt\ncn/sast/framework/SootCtx\n*L\n192#1:732,3\n313#1:767\n313#1:768,2\n314#1:770,14\n313#1:784\n315#1:785\n537#1:787\n537#1:788,5\n537#1:793\n537#1:794,2\n538#1:796\n538#1:797,2\n580#1:871\n586#1:872\n201#1:735,13\n201#1:756,11\n608#1:799,13\n608#1:836,11\n706#1:847,24\n212#1:748,8\n609#1:812,8\n612#1:820,8\n615#1:828,8\n*E\n"})
public class SootCtx
implements ISootInitializeHandler {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MainConfig mainConfig;
    @Nullable
    private final IMonitor monitor;
    @Nullable
    private final Timer _loadClassesTimer;
    @Nullable
    private final Timer _classesClassificationTimer;
    @Nullable
    private final Timer _cgConstructTimer;
    public CgAlgorithmProvider cgAlgorithmProvider;
    @NotNull
    private final Lazy autoAppClassesLocator$delegate;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(SootCtx::logger$lambda$51);

    public SootCtx(@NotNull MainConfig mainConfig) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        this.mainConfig = mainConfig;
        IMonitor iMonitor = this.monitor = this.mainConfig.getMonitor();
        this._loadClassesTimer = iMonitor != null ? iMonitor.timer("loadClasses") : null;
        IMonitor iMonitor2 = this.monitor;
        this._classesClassificationTimer = iMonitor2 != null ? iMonitor2.timer("classes.classification") : null;
        IMonitor iMonitor3 = this.monitor;
        this._cgConstructTimer = iMonitor3 != null ? iMonitor3.timer("callgraph.construct") : null;
        this.autoAppClassesLocator$delegate = LazyKt.lazy(() -> SootCtx.autoAppClassesLocator_delegate$lambda$25(this));
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    @Nullable
    public final IMonitor getMonitor() {
        return this.monitor;
    }

    @NotNull
    public final CgAlgorithmProvider getCgAlgorithmProvider() {
        CgAlgorithmProvider cgAlgorithmProvider = this.cgAlgorithmProvider;
        if (cgAlgorithmProvider != null) {
            return cgAlgorithmProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"cgAlgorithmProvider");
        return null;
    }

    public final void setCgAlgorithmProvider(@NotNull CgAlgorithmProvider cgAlgorithmProvider) {
        Intrinsics.checkNotNullParameter((Object)cgAlgorithmProvider, (String)"<set-?>");
        this.cgAlgorithmProvider = cgAlgorithmProvider;
    }

    public void configureCallGraph(@NotNull Options options) {
        Intrinsics.checkNotNullParameter((Object)options, (String)"options");
        this.setCgAlgorithmProvider(this.configureCallGraph(options, this.mainConfig.getCallGraphAlgorithm(), this.mainConfig.getApponly(), this.mainConfig.getEnableReflection()));
    }

    @NotNull
    public CgAlgorithmProvider configureCallGraph(@NotNull Options options, @NotNull String callGraphAlgorithm, boolean appOnly, boolean enableReflection) {
        Intrinsics.checkNotNullParameter((Object)options, (String)"options");
        Intrinsics.checkNotNullParameter((Object)callGraphAlgorithm, (String)"callGraphAlgorithm");
        CgAlgorithmProvider cgAlgorithmProvider = null;
        Options $this$configureCallGraph_u24lambda_u242 = options;
        boolean bl = false;
        String appOnlySootOptionValue = "apponly:" + (appOnly ? "true" : "false");
        $this$configureCallGraph_u24lambda_u242.set_ignore_resolving_levels(true);
        logger.info(() -> SootCtx.configureCallGraph$lambda$2$lambda$0(callGraphAlgorithm, appOnly));
        String algorithm = callGraphAlgorithm;
        if (StringsKt.equals((String)algorithm, (String)"SPARK", (boolean)true)) {
            $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.spark", "on");
            $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.spark", "on-fly-cg:true");
            $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.spark", appOnlySootOptionValue);
            cgAlgorithmProvider = CgAlgorithmProvider.Soot;
        } else if (StringsKt.startsWith((String)algorithm, (String)"GEOM", (boolean)true)) {
            $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.spark", "on");
            $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.spark", appOnlySootOptionValue);
            AbstractInfoflow.setGeomPtaSpecificOptions();
            if (StringsKt.equals((String)StringsKt.substringAfter$default((String)algorithm, (String)"-", null, (int)2, null), (String)"HeapIns", (boolean)true)) {
                v0 = $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.spark", "geom-encoding:HeapIns");
            } else if (StringsKt.equals((String)StringsKt.substringAfter$default((String)algorithm, (String)"-", null, (int)2, null), (String)"PtIns", (boolean)true)) {
                v0 = $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.spark", "geom-encoding:PtIns");
            } else {
                throw new IllegalStateException((algorithm + " is incorrect").toString());
            }
            cgAlgorithmProvider = CgAlgorithmProvider.Soot;
        } else if (StringsKt.equals((String)algorithm, (String)"CHA", (boolean)true)) {
            $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.cha", "on");
            $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.cha", appOnlySootOptionValue);
            cgAlgorithmProvider = CgAlgorithmProvider.Soot;
        } else if (StringsKt.equals((String)algorithm, (String)"RTA", (boolean)true)) {
            $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.spark", "on");
            $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.spark", "rta:true");
            $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.spark", "on-fly-cg:false");
            $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.spark", appOnlySootOptionValue);
            cgAlgorithmProvider = CgAlgorithmProvider.Soot;
        } else if (StringsKt.equals((String)algorithm, (String)"VTA", (boolean)true)) {
            $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.spark", "on");
            $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.spark", "vta:true");
            $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.spark", appOnlySootOptionValue);
            cgAlgorithmProvider = CgAlgorithmProvider.Soot;
        } else {
            PTAConfig $this$configureCallGraph_u24lambda_u242_u24lambda_u241 = PTAConfig.v();
            boolean bl2 = false;
            $this$configureCallGraph_u24lambda_u242_u24lambda_u241.getPtaConfig().ptaPattern = new PTAPattern(callGraphAlgorithm);
            $this$configureCallGraph_u24lambda_u242_u24lambda_u241.getPtaConfig().singleentry = false;
            $this$configureCallGraph_u24lambda_u242_u24lambda_u241.getPtaConfig().ctxDebloating = true;
            $this$configureCallGraph_u24lambda_u242_u24lambda_u241.getPtaConfig().stringConstants = true;
            cgAlgorithmProvider = CgAlgorithmProvider.QiLin;
        }
        if (enableReflection) {
            $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg", "types-for-invoke:true");
        }
        $this$configureCallGraph_u24lambda_u242.setPhaseOption("cg.spark", "set-impl:hybrid");
        $this$configureCallGraph_u24lambda_u242.setPhaseOption("jb", "model-lambdametafactory:false");
        $this$configureCallGraph_u24lambda_u242.setPhaseOption("jb.ulp", "off");
        return cgAlgorithmProvider;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public void constructCallGraph(@NotNull CgAlgorithmProvider cgAlgorithm, boolean appOnly, boolean record2) {
        void $this$bracket_u24default$iv;
        Intrinsics.checkNotNullParameter((Object)cgAlgorithm, (String)"cgAlgorithm");
        Scene scene = Scene.v();
        this.releaseCallGraph();
        this.onBeforeCallGraphConstruction();
        if (!this.mainConfig.getSkipClass()) {
            boolean bl;
            block35: {
                Chain chain = scene.getApplicationClasses();
                Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getApplicationClasses(...)");
                Iterable $this$none$iv = (Iterable)chain;
                boolean $i$f$none = false;
                if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                    bl = true;
                } else {
                    for (Object element$iv : $this$none$iv) {
                        SootClass it = (SootClass)element$iv;
                        boolean bl2 = false;
                        Intrinsics.checkNotNull((Object)it);
                        if (!(!OthersKt.isSyntheticComponent((SootClass)it))) continue;
                        bl = false;
                        break block35;
                    }
                    bl = true;
                }
            }
            if (bl) {
                throw new IllegalStateException("application classes must not be empty. check your --auto-app-classes, --process, --source-path, --class-path options".toString());
            }
        }
        scene.getOrMakeFastHierarchy();
        Timer timer = this._cgConstructTimer;
        PhaseIntervalTimer.Snapshot cgs = timer != null ? timer.start() : null;
        LoggerWithLogMethod $i$f$none = LoggingKt.info((KLogger)logger);
        String msg$iv = "Constructing the call graph [" + cgAlgorithm + "] ...";
        boolean $i$f$bracket = false;
        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
        LocalDateTime startTime$iv = LocalDateTime.now();
        boolean alreadyLogged$iv = false;
        Ref.ObjectRef res$iv = new Ref.ObjectRef();
        res$iv.element = Maybe.Companion.empty();
        try {
            block36: {
                Ref.ObjectRef objectRef = res$iv;
                boolean bl = false;
                PackManager.v().getPack("wjpp").apply();
                scene.getOrMakeFastHierarchy();
                scene.setAllowModifyHierarchy(false);
                System.gc();
                logger.info(SootCtx::constructCallGraph$lambda$8$lambda$4);
                long pid = ProcessHandle.current().pid();
                MemoryWatcher memoryWatcher = new MemoryWatcher(pid, "Main PTA");
                memoryWatcher.start();
                try {
                    IMonitor iMonitor = this.monitor;
                    PhaseIntervalTimer $this$bracket$iv = (PhaseIntervalTimer)(iMonitor != null ? iMonitor.timer("cgAlgorithm:" + cgAlgorithm) : null);
                    boolean $i$f$bracket2 = false;
                    if ($this$bracket$iv == null) {
                        boolean bl3 = false;
                        switch (WhenMappings.$EnumSwitchMapping$0[cgAlgorithm.ordinal()]) {
                            case 1: {
                                PackManager.v().getPack("cg").apply();
                                break;
                            }
                            case 2: {
                                PTAUtils.setAppOnly((boolean)appOnly);
                                CoreConfig.CorePTAConfiguration ptaConfig = CoreConfig.v().getPtaConfig();
                                ptaConfig.printAliasInfo = ExtSettings.INSTANCE.getPrintAliasInfo();
                                ptaConfig.castNeverFailsOfPhantomClass = ExtSettings.INSTANCE.getCastNeverFailsOfPhantomClass();
                                ValNode.UseRoaringPointsToSet = ExtSettings.INSTANCE.getUseRoaringPointsToSet();
                                List entries = scene.getEntryPoints();
                                PTA pta = PTAFactory.createPTA((PTAPattern)PTAConfig.v().getPtaConfig().ptaPattern);
                                pta.getCgb().getReachableMethods();
                                pta.run();
                                CallGraph qilingCG = pta.getCallGraph();
                                CallGraph sootCG = scene.getCallGraph();
                                scene.setPointsToAnalysis((PointsToAnalysis)pta);
                                PTAUtils.clear();
                                pta.getPag().small();
                                break;
                            }
                            default: {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        break block36;
                    }
                    PhaseIntervalTimer.Snapshot s$iv = $this$bracket$iv.start();
                    try {
                        boolean bl4 = false;
                        switch (WhenMappings.$EnumSwitchMapping$0[cgAlgorithm.ordinal()]) {
                            case 1: {
                                PackManager.v().getPack("cg").apply();
                                break;
                            }
                            case 2: {
                                PTAUtils.setAppOnly((boolean)appOnly);
                                CoreConfig.CorePTAConfiguration ptaConfig = CoreConfig.v().getPtaConfig();
                                ptaConfig.printAliasInfo = ExtSettings.INSTANCE.getPrintAliasInfo();
                                ptaConfig.castNeverFailsOfPhantomClass = ExtSettings.INSTANCE.getCastNeverFailsOfPhantomClass();
                                ValNode.UseRoaringPointsToSet = ExtSettings.INSTANCE.getUseRoaringPointsToSet();
                                List entries = scene.getEntryPoints();
                                PTA pta = PTAFactory.createPTA((PTAPattern)PTAConfig.v().getPtaConfig().ptaPattern);
                                pta.getCgb().getReachableMethods();
                                pta.run();
                                CallGraph qilingCG = pta.getCallGraph();
                                CallGraph sootCG = scene.getCallGraph();
                                scene.setPointsToAnalysis((PointsToAnalysis)pta);
                                PTAUtils.clear();
                                pta.getPag().small();
                                break;
                            }
                            default: {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    finally {
                        $this$bracket$iv.stop(s$iv);
                    }
                }
                finally {
                    memoryWatcher.stop();
                    logger.info(() -> SootCtx.constructCallGraph$lambda$8$lambda$6(memoryWatcher));
                }
            }
            scene.setAllowModifyHierarchy(true);
            System.gc();
            logger.info(SootCtx::constructCallGraph$lambda$8$lambda$7);
            Unit unit = Unit.INSTANCE;
            objectRef.element = new Maybe((Object)unit);
            Object object = ((Maybe)res$iv.element).getOrThrow();
        }
        catch (Throwable t$iv) {
            try {
                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                alreadyLogged$iv = true;
                throw t$iv;
            }
            catch (Throwable throwable) {
                if (!alreadyLogged$iv) {
                    if (((Maybe)res$iv.element).getHasValue()) {
                        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                    } else {
                        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                    }
                }
                throw throwable;
            }
        }
        if (((Maybe)res$iv.element).getHasValue()) {
            $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
        }
        Timer timer2 = this._cgConstructTimer;
        if (timer2 != null) {
            PhaseIntervalTimer.Snapshot snapshot = cgs;
            Intrinsics.checkNotNull((Object)snapshot);
            timer2.stop(snapshot);
        }
        CGUtils.INSTANCE.addCallEdgeForPhantomMethods();
        this.showPta();
        scene.releaseReachableMethods();
        Intrinsics.checkNotNull((Object)scene);
        CGUtils.INSTANCE.fixScene(scene);
        if (record2) {
            IMonitor iMonitor;
            IMonitor iMonitor2;
            Chain $this$constructCallGraph_u24lambda_u249 = scene.getApplicationClasses();
            boolean bl = false;
            Intrinsics.checkNotNull((Object)$this$constructCallGraph_u24lambda_u249);
            Pair pair = this.activeBodyMethods($this$constructCallGraph_u24lambda_u249);
            int active = ((Number)pair.component1()).intValue();
            int total = ((Number)pair.component2()).intValue();
            IMonitor iMonitor3 = this.monitor;
            if (iMonitor3 != null && (iMonitor3 = iMonitor3.getProjectMetrics()) != null) {
                iMonitor3.setApplicationMethodsHaveBody(active);
            }
            if ((iMonitor2 = this.monitor) != null && (iMonitor2 = iMonitor2.getProjectMetrics()) != null) {
                iMonitor2.setApplicationMethods(total);
            }
            Chain $this$constructCallGraph_u24lambda_u2410 = scene.getLibraryClasses();
            boolean bl5 = false;
            Intrinsics.checkNotNull((Object)$this$constructCallGraph_u24lambda_u2410);
            pair = this.activeBodyMethods($this$constructCallGraph_u24lambda_u2410);
            active = ((Number)pair.component1()).intValue();
            total = ((Number)pair.component2()).intValue();
            IMonitor iMonitor4 = this.monitor;
            if (iMonitor4 != null && (iMonitor4 = iMonitor4.getProjectMetrics()) != null) {
                iMonitor4.setLibraryMethodsHaveBody(active);
            }
            if ((iMonitor = this.monitor) != null && (iMonitor = iMonitor.getProjectMetrics()) != null) {
                iMonitor.setLibraryMethods(total);
            }
        }
        this.onAfterCallGraphConstruction();
    }

    public static /* synthetic */ void constructCallGraph$default(SootCtx sootCtx, CgAlgorithmProvider cgAlgorithmProvider, boolean bl, boolean bl2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: constructCallGraph");
        }
        if ((n & 4) != 0) {
            bl2 = true;
        }
        sootCtx.constructCallGraph(cgAlgorithmProvider, bl, bl2);
    }

    public void constructCallGraph() {
        SootCtx.constructCallGraph$default((SootCtx)this, (CgAlgorithmProvider)this.getCgAlgorithmProvider(), (boolean)this.mainConfig.getApponly(), (boolean)false, (int)4, null);
    }

    public final void showPta() {
        PointsToAnalysis pta = Scene.v().getPointsToAnalysis();
        if (Scene.v().getPointsToAnalysis() instanceof DumbPointerAnalysis) {
            logger.warn(SootCtx::showPta$lambda$11);
            Scene.v().setPointsToAnalysis(pta);
        }
        logger.info(SootCtx::showPta$lambda$12);
        logger.info(SootCtx::showPta$lambda$13);
        Scene scene = Scene.v();
        Intrinsics.checkNotNullExpressionValue((Object)scene, (String)"v(...)");
        this.showClasses(scene, "After PTA: ", (Function1)new /* Unavailable Anonymous Inner Class!! */);
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object findClassesInnerJar(@NotNull ProjectFileLocator var1_1, @NotNull Continuation<? super Map<String, ? extends Set<IResFile>>> $completion) {
        if (!($completion instanceof findClassesInnerJar.1)) ** GOTO lbl-1000
        var6_3 = $completion;
        if ((var6_3.label & -2147483648) != 0) {
            var6_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var7_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                md5Map = new ConcurrentHashMap<K, V>();
                $continuation.L$0 = md5Group = new ConcurrentHashMap<K, V>();
                $continuation.label = 1;
                v0 = CoroutineScopeKt.coroutineScope((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (Continuation)$continuation);
                if (v0 == var7_5) {
                    return var7_5;
                }
                ** GOTO lbl23
            }
            case 1: {
                md5Group = (ConcurrentHashMap<K, V>)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl23:
                // 2 sources

                return md5Group;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object findClassesInnerJarUnderAutoAppClassPath(@NotNull Continuation<? super Set<? extends IResFile>> $completion) {
        if (!($completion instanceof findClassesInnerJarUnderAutoAppClassPath.1)) ** GOTO lbl-1000
        var23_2 = $completion;
        if ((var23_2.label & -2147483648) != 0) {
            var23_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var24_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                if (!(((Collection)this.mainConfig.getAutoAppClasses()).isEmpty() == false)) {
                    var3_5 = "Check failed.";
                    throw new IllegalStateException(var3_5.toString());
                }
                $continuation.L$0 = this;
                $continuation.label = 1;
                v0 = this.findClassesInnerJar(this.getAutoAppClassesLocator(), (Continuation)$continuation);
                if (v0 == var24_4) {
                    return var24_4;
                }
                ** GOTO lbl26
            }
            case 1: {
                this = (SootCtx)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl26:
                // 2 sources

                jarDeduplication = (Map)v0;
                $this$map$iv = jarDeduplication.values();
                $i$f$map = false;
                var6_11 = $this$map$iv;
                destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                $i$f$mapTo = false;
                for (T item$iv$iv : $this$mapTo$iv$iv) {
                    var11_18 = (Set)item$iv$iv;
                    var21_29 = destination$iv$iv;
                    $i$a$-map-SootCtx$findClassesInnerJarUnderAutoAppClassPath$jars$1 = false;
                    $this$minBy$iv = (Iterable)dupFiles;
                    $i$f$minByOrThrow = false;
                    iterator$iv = $this$minBy$iv.iterator();
                    if (!iterator$iv.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    minElem$iv = iterator$iv.next();
                    if (!iterator$iv.hasNext()) {
                        v1 = minElem$iv;
                    } else {
                        it = (IResFile)minElem$iv;
                        $i$a$-minByOrThrow-SootCtx$findClassesInnerJarUnderAutoAppClassPath$jars$1$1 = false;
                        minValue$iv = (Comparable)this.mainConfig.tryGetRelativePath((IResource)it).getRelativePath();
                        do {
                            e$iv = iterator$iv.next();
                            it = (IResFile)e$iv;
                            $i$a$-minByOrThrow-SootCtx$findClassesInnerJarUnderAutoAppClassPath$jars$1$1 = false;
                            v$iv = (Comparable)this.mainConfig.tryGetRelativePath((IResource)it).getRelativePath();
                            if (minValue$iv.compareTo(v$iv) <= 0) continue;
                            minElem$iv = e$iv;
                            minValue$iv = v$iv;
                        } while (iterator$iv.hasNext());
                        v1 = minElem$iv;
                    }
                    var21_29.add((IResFile)v1);
                }
                $this$sortedBy$iv = (List)destination$iv$iv;
                $i$f$sortedBy = false;
                jars = CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */));
                result = new LinkedHashSet<IResFile>();
                for (IResFile jar : jars) {
                    if (jar.isFileScheme()) {
                        v2 = jar;
                    } else if (jar.isJarScheme()) {
                        try {
                            var8_14 = jar.expandRes(this.mainConfig.getOutput_dir()).toFile();
                        }
                        catch (InvalidPathException e) {
                            SootCtx.logger.error((Throwable)e, (Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, findClassesInnerJarUnderAutoAppClassPath$lambda$17(cn.sast.common.IResFile ), ()Ljava/lang/Object;)((IResFile)jar));
                            continue;
                        }
                        v2 = var8_14;
                    } else {
                        SootCtx.logger.error((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, findClassesInnerJarUnderAutoAppClassPath$lambda$18(cn.sast.common.IResFile ), ()Ljava/lang/Object;)((IResFile)jar));
                        continue;
                    }
                    extract = v2;
                    result.add(extract);
                }
                return result;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public void configure(@NotNull Options options) {
        block11: {
            Intrinsics.checkNotNullParameter((Object)options, (String)"options");
            if (this.mainConfig.getSrc_precedence() == SrcPrecedence.prec_java) {
                Boolean bl = this.mainConfig.isAndroidScene();
                Intrinsics.checkNotNull((Object)bl);
                if (!bl.booleanValue()) {
                    IResDirectory classOpt = this.mainConfig.getOutput_dir().resolve("gen-classes").toDirectory();
                    classOpt.deleteDirectoryRecursively();
                    classOpt.mkdirs();
                    List customOptions = this.mainConfig.getEcj_options();
                    PersistentSet sourcePath = this.mainConfig.getProcessDir();
                    EcjCompiler ecj = new EcjCompiler(ExtensionsKt.toPersistentSet((Iterable)((Iterable)sourcePath)), this.mainConfig.getClasspath(), (IResource)classOpt, customOptions, this.mainConfig.getUseDefaultJavaClassPath(), null, null, false, null, null, 992, null);
                    if (!ecj.compile()) {
                        logger.error(SootCtx::configure$lambda$19);
                    }
                    if (!(!((Collection)IResDirectory.DefaultImpls.listPathEntries$default((IResDirectory)classOpt, null, (int)1, null)).isEmpty())) {
                        boolean $i$a$-check-SootCtx$configure$32 = false;
                        String $i$a$-check-SootCtx$configure$32 = "\n\n!!! no class file found under " + classOpt + " !!!\n\n";
                        throw new IllegalStateException($i$a$-check-SootCtx$configure$32.toString());
                    }
                    this.mainConfig.setProcessDir(this.mainConfig.getProcessDir().add((Object)classOpt));
                    this.mainConfig.setClasspath(ExtensionsKt.toPersistentSet((Iterable)ecj.getCollectClassPath()));
                }
            }
            this.getAutoAppClassesLocator().update();
            PersistentSet autoAppClasses = this.mainConfig.getAutoAppClasses();
            if (!((Collection)autoAppClasses).isEmpty()) {
                Boolean bl = this.mainConfig.isAndroidScene();
                Intrinsics.checkNotNull((Object)bl);
                if (!bl.booleanValue() && !this.mainConfig.getSkipClass()) {
                    BuildersKt.runBlocking$default(null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)1, null);
                }
            }
            MainConfig $this$configure_u24lambda_u2424 = this.mainConfig;
            boolean bl = false;
            Options $this$configure_u24lambda_u2424_u24lambda_u2423 = options;
            boolean bl2 = false;
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_verbose(true);
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_allow_phantom_elms(true);
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_whole_program($this$configure_u24lambda_u2424.getWhole_program());
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_src_prec($this$configure_u24lambda_u2424.getSrc_precedence().getSootFlag());
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_prepend_classpath($this$configure_u24lambda_u2424.getPrepend_classpath());
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_no_bodies_for_excluded($this$configure_u24lambda_u2424.getNo_bodies_for_excluded());
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_include_all(true);
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_allow_phantom_refs($this$configure_u24lambda_u2424.getAllow_phantom_refs());
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_ignore_classpath_errors(false);
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_throw_analysis($this$configure_u24lambda_u2424.getThrow_analysis());
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_process_multiple_dex($this$configure_u24lambda_u2424.getProcess_multiple_dex());
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_field_type_mismatches(2);
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_full_resolver(true);
            $this$configure_u24lambda_u2424_u24lambda_u2423.classes().addAll($this$configure_u24lambda_u2424.getAppClasses());
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_app(false);
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_search_dex_in_archives(true);
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_process_dir(CollectionsKt.toList((Iterable)$this$configure_u24lambda_u2424.getSoot_process_dir()));
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_output_format($this$configure_u24lambda_u2424.getOutput_format());
            $this$configure_u24lambda_u2424.getSoot_output_dir().deleteDirectoryRecursively();
            $this$configure_u24lambda_u2424.getSoot_output_dir().mkdirs();
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_output_dir($this$configure_u24lambda_u2424.getSoot_output_dir().getAbsolutePath());
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_keep_offset(false);
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_keep_line_number($this$configure_u24lambda_u2424.getEnableLineNumbers());
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_ignore_resolution_errors(true);
            Boolean bl3 = $this$configure_u24lambda_u2424.getForceAndroidJar();
            if (bl3 != null) {
                boolean it = bl3;
                boolean bl4 = false;
                if (it) {
                    $this$configure_u24lambda_u2424_u24lambda_u2423.set_force_android_jar($this$configure_u24lambda_u2424.getAndroidPlatformDir());
                } else {
                    $this$configure_u24lambda_u2424_u24lambda_u2423.set_android_jars($this$configure_u24lambda_u2424.getAndroidPlatformDir());
                }
                logger.info(() -> SootCtx.configure$lambda$24$lambda$23$lambda$22$lambda$21($this$configure_u24lambda_u2424));
            }
            Boolean bl5 = this.mainConfig.isAndroidScene();
            Intrinsics.checkNotNull((Object)bl5);
            if (bl5.booleanValue()) {
                $this$configure_u24lambda_u2424_u24lambda_u2423.set_throw_analysis(3);
            }
            if ($this$configure_u24lambda_u2424.getEnableOriginalNames()) {
                $this$configure_u24lambda_u2424_u24lambda_u2423.setPhaseOption("jb", "use-original-names:true");
            }
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_debug(false);
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_verbose(false);
            $this$configure_u24lambda_u2424_u24lambda_u2423.set_validate(false);
            this.configureCallGraph(options);
            Pack p = PackManager.v().getPack("jb");
            p.add(new Transform("jb.rewriter", (Transformer)new StringConcatRewriterTransform()));
            SaConfig saConfig = this.mainConfig.getSaConfig();
            if (saConfig == null || (saConfig = saConfig.getSootConfig()) == null) break block11;
            saConfig.configure(options);
        }
    }

    @NotNull
    public final ProjectFileLocator getAutoAppClassesLocator() {
        Lazy lazy = this.autoAppClassesLocator$delegate;
        return (ProjectFileLocator)lazy.getValue();
    }

    public final void configureSootClassPath(@NotNull Options options) {
        Intrinsics.checkNotNullParameter((Object)options, (String)"options");
        SortedSet cp = CollectionsKt.toSortedSet((Iterable)this.mainConfig.get_soot_classpath());
        Scene.v().setSootClassPath(null);
        Iterable iterable = cp;
        String string = File.pathSeparator;
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"pathSeparator");
        options.set_soot_classpath(CollectionsKt.joinToString$default((Iterable)iterable, (CharSequence)string, null, null, (int)0, null, null, (int)62, null));
    }

    public void configureAfterSceneInit(@NotNull Scene scene, @NotNull Options options) {
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        Intrinsics.checkNotNullParameter((Object)options, (String)"options");
        this.configureSootClassPath(options);
    }

    public void configure(@NotNull Scene scene) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
            logger.info(SootCtx::configure$lambda$26);
            Scene.v().addBasicClass("java.lang.String", 3);
            Scene.v().addBasicClass("java.lang.StringLatin1", 3);
            Scene.v().addBasicClass("java.util.Arrays", 3);
            Scene.v().addBasicClass("java.lang.Math", 3);
            Scene.v().addBasicClass("java.lang.StringCoding", 3);
            SaConfig saConfig = this.mainConfig.getSaConfig();
            if (saConfig == null || (saConfig = saConfig.getSootConfig()) == null) break block0;
            saConfig.configure(scene);
        }
    }

    public void configure(@NotNull Main main3) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)main3, (String)"main");
            main3.autoSetOptions();
            SaConfig saConfig = this.mainConfig.getSaConfig();
            if (saConfig == null || (saConfig = saConfig.getSootConfig()) == null) break block0;
            saConfig.configure(main3);
        }
    }

    public final void classesClassification(@NotNull Scene scene, @Nullable ProjectFileLocator locator2) {
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        Timer timer = this._classesClassificationTimer;
        PhaseIntervalTimer.Snapshot st = timer != null ? timer.start() : null;
        if (!(!this.mainConfig.getSkipClass())) {
            String string = "Check failed.";
            throw new IllegalStateException(string.toString());
        }
        boolean findAny = false;
        PersistentSet autoAppClasses = this.mainConfig.getAutoAppClasses();
        SootCtx.showClasses$default((SootCtx)this, (Scene)scene, (String)"Before classes classification: ", null, (int)4, null);
        Iterator iterator2 = Scene.v().getClasses().iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"iterator(...)");
        Iterator iterator3 = iterator2;
        block5: while (iterator3.hasNext()) {
            String string;
            SootClass sc = (SootClass)iterator3.next();
            if (sc.isPhantom()) continue;
            ProjectFileLocator projectFileLocator = this.getAutoAppClassesLocator();
            Intrinsics.checkNotNull((Object)sc);
            IResFile sourceFile = projectFileLocator.get((IBugResInfo)ClassResInfo.Companion.of(sc), (IWrapperFileGenerator)NullWrapperFileGenerator.INSTANCE);
            Object origAction = null;
            if (!((Collection)autoAppClasses).isEmpty()) {
                if (sourceFile != null && (this.mainConfig.getAutoAppSrcInZipScheme() || sourceFile.isFileScheme())) {
                    findAny = true;
                    sc.setApplicationClass();
                    origAction = "application";
                } else if (sc.isApplicationClass()) {
                    sc.setLibraryClass();
                    origAction = "library";
                }
            }
            if ((string = origAction) == null) {
                string = sc.isApplicationClass() ? "application" : (sc.isLibraryClass() ? "library" : "phantom");
            }
            origAction = string;
            ProjectFileLocator projectFileLocator2 = locator2;
            IResFile sourceFileInLocator = projectFileLocator2 != null ? projectFileLocator2.get((IBugResInfo)ClassResInfo.Companion.of(sc), (IWrapperFileGenerator)NullWrapperFileGenerator.INSTANCE) : null;
            origAction = sourceFileInLocator != null ? "(src exists) " + (String)origAction : "(src not exists) " + (String)origAction;
            ProcessRule.ScanAction scanAction = ScanFilter.getActionOf$default((ScanFilter)this.mainConfig.getScanFilter(), (String)origAction, (SootClass)sc, null, (int)4, null);
            switch (WhenMappings.$EnumSwitchMapping$1[scanAction.ordinal()]) {
                case 1: {
                    sc.setApplicationClass();
                    continue block5;
                }
                case 2: {
                    sc.setLibraryClass();
                    continue block5;
                }
                case 3: {
                    continue block5;
                }
            }
            throw new NoWhenBranchMatchedException();
        }
        Timer timer2 = this._classesClassificationTimer;
        if (timer2 != null) {
            PhaseIntervalTimer.Snapshot snapshot = st;
            Intrinsics.checkNotNull((Object)snapshot);
            timer2.stop(snapshot);
        }
        if (!((Collection)autoAppClasses).isEmpty() && !findAny) {
            String hintAppend1 = this.mainConfig.getProjectConfig().getYmlFile() != null ? "Or check your project-scan-config file: " + this.mainConfig.getProjectConfig().getYmlFile() + " and get more information from match result: " + this.mainConfig.getOutput_dir().resolve("scan-classifier-info.json") : "";
            logger.error(() -> SootCtx.classesClassification$lambda$27(autoAppClasses, hintAppend1));
        }
        SootCtx.showClasses$default((SootCtx)this, (Scene)scene, (String)"After classes classification: ", null, (int)4, null);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Pair<Integer, Integer> activeBodyMethods(@NotNull Chain<SootClass> $this$activeBodyMethods) {
        void $this$filterTo$iv$iv;
        void $this$filterTo$iv$iv2;
        SootClass it;
        Iterable $this$flatMapTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$activeBodyMethods, (String)"<this>");
        Iterable $this$flatMap$iv = (Iterable)$this$activeBodyMethods;
        boolean $i$f$flatMap = false;
        Iterable iterable = $this$flatMap$iv;
        Iterable destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            it = (SootClass)element$iv$iv;
            boolean bl = false;
            List list = it.getMethods();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getMethods(...)");
            Iterable list$iv$iv = list;
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        Iterable $this$filter$iv = (List)destination$iv$iv;
        boolean $i$f$filter = false;
        $this$flatMapTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv2) {
            it = (SootMethod)element$iv$iv;
            boolean bl = false;
            if (!(!it.isAbstract())) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List total = (List)destination$iv$iv;
        Iterable $this$filter$iv2 = total;
        boolean $i$f$filter2 = false;
        destination$iv$iv = $this$filter$iv2;
        Collection destination$iv$iv2 = new ArrayList();
        boolean $i$f$filterTo2 = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            SootMethod it2 = (SootMethod)element$iv$iv;
            boolean bl = false;
            if (!it2.hasActiveBody()) continue;
            destination$iv$iv2.add(element$iv$iv);
        }
        List active = (List)destination$iv$iv2;
        return TuplesKt.to((Object)((Collection)active).size(), (Object)((Collection)total).size());
    }

    @NotNull
    public final String show(@NotNull Chain<SootClass> $this$show) {
        Intrinsics.checkNotNullParameter($this$show, (String)"<this>");
        Pair pair = this.activeBodyMethods($this$show);
        int active = ((Number)pair.component1()).intValue();
        int total = ((Number)pair.component2()).intValue();
        if (total == 0) {
            return "empty";
        }
        int n = $this$show.size();
        String string = "%.2f";
        Object[] objectArray = new Object[]{Float.valueOf((float)active / (float)total)};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
        return n + "(" + total + "*" + string2 + ")";
    }

    public final void showClasses(@NotNull Scene scene, @NotNull String prefix, @NotNull Function1<? super String, String> fx) {
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        Intrinsics.checkNotNullParameter((Object)prefix, (String)"prefix");
        Intrinsics.checkNotNullParameter(fx, (String)"fx");
        boolean bl = false;
        Chain classes = scene.getClasses();
        Chain applicationClasses = scene.getApplicationClasses();
        Chain libraryClasses = scene.getLibraryClasses();
        Chain phantomClasses = scene.getPhantomClasses();
        logger.info(() -> SootCtx.showClasses$lambda$33$lambda$32(fx, prefix, this, applicationClasses, libraryClasses, phantomClasses, classes));
    }

    public static /* synthetic */ void showClasses$default(SootCtx sootCtx, Scene scene, String string, Function1 function1, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showClasses");
        }
        if ((n & 2) != 0) {
            string = "";
        }
        if ((n & 4) != 0) {
            function1 = SootCtx::showClasses$lambda$31;
        }
        sootCtx.showClasses(scene, string, function1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public void loadClasses(@NotNull Scene scene, @Nullable ProjectFileLocator locator2) {
        IMonitor iMonitor;
        IMonitor iMonitor2;
        block41: {
            block39: {
                void $this$bracket_u24default$iv;
                String javaExtDirs;
                String sunBootClassPath;
                CharSequence charSequence;
                Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
                G.v().set_SourceLocator((SourceLocator)new SourceLocatorPlus(this.mainConfig));
                switch (WhenMappings.$EnumSwitchMapping$0[this.getCgAlgorithmProvider().ordinal()]) {
                    case 1: {
                        break;
                    }
                    case 2: {
                        Scene.v().addBasicClass("java.lang.ClassLoader", 3);
                        Scene.v().addBasicClass("java.lang.ref.Finalizer", 3);
                        PTAScene.v().addBasicClasses();
                        break;
                    }
                    default: {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                if (!this.mainConfig.getSkipClass()) {
                    LinkedList exclude = SootCtxKt.access$getExcludedPackages((Scene)scene);
                    logger.info(() -> SootCtx.loadClasses$lambda$34(exclude));
                    logger.info(() -> SootCtx.loadClasses$lambda$37(scene, this));
                    logger.info(() -> SootCtx.loadClasses$lambda$40(this));
                }
                if (Options.v().src_prec() == 4 && ((charSequence = (CharSequence)(sunBootClassPath = this.mainConfig.getSunBootClassPath())) == null || charSequence.length() == 0) | ((charSequence = (CharSequence)(javaExtDirs = this.mainConfig.getJavaExtDirs())) == null || charSequence.length() == 0)) {
                    throw new IllegalStateException("sunBootClassPath or javaExtDirs must not be null".toString());
                }
                logger.info(SootCtx::loadClasses$lambda$41);
                if (this.mainConfig.getSkipClass()) break block39;
                sunBootClassPath = LoggingKt.info((KLogger)logger);
                String msg$iv = "Loading Necessary Classes...";
                boolean $i$f$bracket = false;
                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                LocalDateTime startTime$iv = LocalDateTime.now();
                boolean alreadyLogged$iv = false;
                Ref.ObjectRef res$iv = new Ref.ObjectRef();
                res$iv.element = Maybe.Companion.empty();
                try {
                    Object object;
                    boolean $i$f$bracket2;
                    Ref.ObjectRef objectRef = res$iv;
                    boolean bl = false;
                    Timer timer = this._loadClassesTimer;
                    if (timer != null) {
                        PhaseIntervalTimer $this$bracket$iv = (PhaseIntervalTimer)timer;
                        $i$f$bracket2 = false;
                        if ($this$bracket$iv == null) {
                            boolean bl2 = false;
                            scene.loadNecessaryClasses(false);
                        } else {
                            PhaseIntervalTimer.Snapshot s$iv = $this$bracket$iv.start();
                            try {
                                boolean $i$a$-bracket-SootCtx$loadClasses$5$42 = false;
                                scene.loadNecessaryClasses(false);
                                Unit $i$a$-bracket-SootCtx$loadClasses$5$42 = Unit.INSTANCE;
                            }
                            finally {
                                $this$bracket$iv.stop(s$iv);
                            }
                        }
                    }
                    IMonitor iMonitor3 = this.monitor;
                    PhaseIntervalTimer $this$bracket$iv = (PhaseIntervalTimer)(iMonitor3 != null ? iMonitor3.timer("classesClassification") : null);
                    boolean $i$f$bracket3 = false;
                    if ($this$bracket$iv == null) {
                        $i$a$-bracket-SootCtx$loadClasses$5$2 = false;
                        this.classesClassification(scene, locator2);
                    } else {
                        PhaseIntervalTimer.Snapshot s$iv = $this$bracket$iv.start();
                        try {
                            $i$a$-bracket-SootCtx$loadClasses$5$2 = false;
                            this.classesClassification(scene, locator2);
                            object = Unit.INSTANCE;
                        }
                        finally {
                            $this$bracket$iv.stop(s$iv);
                        }
                    }
                    Timer timer2 = this._loadClassesTimer;
                    if (timer2 != null) {
                        PhaseIntervalTimer $this$bracket$iv2 = (PhaseIntervalTimer)timer2;
                        $i$f$bracket2 = false;
                        if ($this$bracket$iv2 == null) {
                            $i$a$-bracket-SootCtx$loadClasses$5$3 = false;
                            Iterator iterator2 = scene.getApplicationClasses().iterator();
                            Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"iterator(...)");
                            object = iterator2;
                            while (object.hasNext()) {
                                SootClass appClass = (SootClass)object.next();
                                if (appClass.isPhantom()) continue;
                                scene.loadClass(appClass.getName(), 3);
                            }
                        } else {
                            PhaseIntervalTimer.Snapshot s$iv = $this$bracket$iv2.start();
                            try {
                                $i$a$-bracket-SootCtx$loadClasses$5$3 = false;
                                Iterator iterator3 = scene.getApplicationClasses().iterator();
                                Intrinsics.checkNotNullExpressionValue((Object)iterator3, (String)"iterator(...)");
                                object = iterator3;
                                while (object.hasNext()) {
                                    SootClass appClass = (SootClass)object.next();
                                    if (appClass.isPhantom()) continue;
                                    scene.loadClass(appClass.getName(), 3);
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                            finally {
                                $this$bracket$iv2.stop(s$iv);
                            }
                        }
                    }
                    logger.info(SootCtx::loadClasses$lambda$46$lambda$45);
                    Unit unit = Unit.INSTANCE;
                    objectRef.element = new Maybe((Object)unit);
                    Object object2 = ((Maybe)res$iv.element).getOrThrow();
                }
                catch (Throwable t$iv) {
                    try {
                        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                        alreadyLogged$iv = true;
                        throw t$iv;
                    }
                    catch (Throwable throwable) {
                        if (!alreadyLogged$iv) {
                            if (((Maybe)res$iv.element).getHasValue()) {
                                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                            } else {
                                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                            }
                        }
                        throw throwable;
                    }
                }
                if (((Maybe)res$iv.element).getHasValue()) {
                    $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                } else {
                    $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                }
                SootCtx.showClasses$default((SootCtx)this, (Scene)scene, null, (Function1)((Function1)new /* Unavailable Anonymous Inner Class!! */), (int)2, null);
                break block41;
            }
            scene.loadBasicClasses();
            scene.loadDynamicClasses();
            scene.doneResolving();
            CGUtils.createDummyMain$default((CGUtils)CGUtils.INSTANCE, (Scene)scene, null, null, (int)6, null);
        }
        logger.info(SootCtx::loadClasses$lambda$47);
        CGUtils.INSTANCE.removeLargeClasses(scene);
        CGUtils.INSTANCE.makeSpuriousMethodFromInvokeExpr();
        PackManager.v().getPack("wjpp").apply();
        new LibraryClassPatcher().patchLibraries();
        IMonitor iMonitor4 = this.monitor;
        if (iMonitor4 != null && (iMonitor4 = iMonitor4.getProjectMetrics()) != null) {
            Chain chain = scene.getApplicationClasses();
            Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getApplicationClasses(...)");
            iMonitor4.setApplicationClasses(((Collection)chain).size());
        }
        if ((iMonitor2 = this.monitor) != null && (iMonitor2 = iMonitor2.getProjectMetrics()) != null) {
            Chain chain = scene.getLibraryClasses();
            Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getLibraryClasses(...)");
            iMonitor2.setLibraryClasses(((Collection)chain).size());
        }
        if ((iMonitor = this.monitor) != null && (iMonitor = iMonitor.getProjectMetrics()) != null) {
            Chain chain = scene.getPhantomClasses();
            Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getPhantomClasses(...)");
            iMonitor.setPhantomClasses(((Collection)chain).size());
        }
        IncrementalAnalyze incrementalAnalyze = this.mainConfig.getIncrementAnalyze();
        IncrementalAnalyzeImplByChangeFiles incrementalAnalyzeImplByChangeFiles = incrementalAnalyze instanceof IncrementalAnalyzeImplByChangeFiles ? (IncrementalAnalyzeImplByChangeFiles)incrementalAnalyze : null;
        if (incrementalAnalyzeImplByChangeFiles != null) {
            incrementalAnalyzeImplByChangeFiles.update(scene, locator2);
        }
        logger.info(SootCtx::loadClasses$lambda$48);
    }

    public void configureSoot() {
        Companion.restAll();
        this.mainConfig.validate();
        JdkInfo jdkInfo = JdkInfoService.INSTANCE.provide();
        Options options = Options.v();
        Intrinsics.checkNotNull((Object)options);
        this.configure(options);
        if (!(Companion.getInstance_soot_Scene() == null)) {
            boolean $i$a$-check-SootCtx$configureSoot$22 = false;
            String $i$a$-check-SootCtx$configureSoot$22 = "Soot should not be initialized in clinit or init. check your plugins";
            throw new IllegalStateException($i$a$-check-SootCtx$configureSoot$22.toString());
        }
        Scene scene = Scene.v();
        Intrinsics.checkNotNull((Object)scene);
        this.configure(scene);
        this.configureAfterSceneInit(scene, options);
        Main main3 = Main.v();
        Intrinsics.checkNotNull((Object)main3);
        this.configure(main3);
    }

    public void constructSoot(@Nullable ProjectFileLocator locator2) {
        Scene scene = Scene.v();
        Intrinsics.checkNotNull((Object)scene);
        this.loadClasses(scene, locator2);
    }

    public static /* synthetic */ void constructSoot$default(SootCtx sootCtx, ProjectFileLocator projectFileLocator, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: constructSoot");
        }
        if ((n & 1) != 0) {
            projectFileLocator = null;
        }
        sootCtx.constructSoot(projectFileLocator);
    }

    public void releaseCallGraph(@NotNull Scene scene, @NotNull G g2) {
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        Intrinsics.checkNotNullParameter((Object)g2, (String)"g");
        scene.releaseCallGraph();
        scene.releasePointsToAnalysis();
        scene.releaseReachableMethods();
        g2.resetSpark();
    }

    public void releaseCallGraph() {
        Scene scene = Scene.v();
        Intrinsics.checkNotNullExpressionValue((Object)scene, (String)"v(...)");
        G g2 = G.v();
        Intrinsics.checkNotNullExpressionValue((Object)g2, (String)"v(...)");
        this.releaseCallGraph(scene, g2);
    }

    public void onBeforeCallGraphConstruction() {
        block0: {
            SaConfig saConfig = this.mainConfig.getSaConfig();
            if (saConfig == null || (saConfig = saConfig.getSootConfig()) == null) break block0;
            Scene scene = Scene.v();
            Intrinsics.checkNotNullExpressionValue((Object)scene, (String)"v(...)");
            Options options = Options.v();
            Intrinsics.checkNotNullExpressionValue((Object)options, (String)"v(...)");
            saConfig.onBeforeCallGraphConstruction(scene, options);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public void onAfterCallGraphConstruction() {
        void $this$bracket_u24default$iv;
        SaConfig saConfig = this.mainConfig.getSaConfig();
        if (saConfig != null && (saConfig = saConfig.getSootConfig()) != null) {
            CallGraph callGraph = this.getCallGraph();
            Scene scene = Scene.v();
            Intrinsics.checkNotNullExpressionValue((Object)scene, (String)"v(...)");
            Options options = Options.v();
            Intrinsics.checkNotNullExpressionValue((Object)options, (String)"v(...)");
            saConfig.onAfterCallGraphConstruction(callGraph, scene, options);
        }
        LoggerWithLogMethod loggerWithLogMethod = LoggingKt.info((KLogger)logger);
        String msg$iv = "Rewrite soot scene";
        boolean $i$f$bracket = false;
        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
        LocalDateTime startTime$iv = LocalDateTime.now();
        boolean alreadyLogged$iv = false;
        Ref.ObjectRef res$iv = new Ref.ObjectRef();
        res$iv.element = Maybe.Companion.empty();
        try {
            Ref.ObjectRef objectRef = res$iv;
            boolean bl = false;
            CGUtils.INSTANCE.rewriteJimpleBodyAfterCG();
            Unit unit = Unit.INSTANCE;
            objectRef.element = new Maybe((Object)unit);
            Object object = ((Maybe)res$iv.element).getOrThrow();
        }
        catch (Throwable t$iv) {
            try {
                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                alreadyLogged$iv = true;
                throw t$iv;
            }
            catch (Throwable throwable) {
                if (!alreadyLogged$iv) {
                    if (((Maybe)res$iv.element).getHasValue()) {
                        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                    } else {
                        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                    }
                }
                throw throwable;
            }
        }
        if (((Maybe)res$iv.element).getHasValue()) {
            $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    @NotNull
    public final CallGraph getCallGraph() {
        CallGraph callGraph = Scene.v().getCallGraph();
        Intrinsics.checkNotNullExpressionValue((Object)callGraph, (String)"getCallGraph(...)");
        return callGraph;
    }

    public final void setCallGraph(@NotNull CallGraph value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Scene.v().setCallGraph(value);
    }

    @NotNull
    public final CallGraph getSootMethodCallGraph() {
        CallGraph cg = new CallGraph();
        Iterator iterator2 = this.getCallGraph().iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"iterator(...)");
        Iterator edgeIterator = iterator2;
        while (edgeIterator.hasNext()) {
            Object e = edgeIterator.next();
            Intrinsics.checkNotNullExpressionValue(e, (String)"next(...)");
            Edge e2 = (Edge)e;
            if (e2.isInvalid()) continue;
            cg.addEdge(new Edge((MethodOrMethodContext)e2.src(), e2.srcUnit(), (MethodOrMethodContext)e2.tgt(), e2.kind()));
        }
        return cg;
    }

    @NotNull
    public final List<SootMethod> getEntryPoints() {
        List list = Scene.v().getEntryPoints();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getEntryPoints(...)");
        return list;
    }

    public void onBeforeCallGraphConstruction(@NotNull Scene scene, @NotNull Options options) {
        ISootInitializeHandler.DefaultImpls.onBeforeCallGraphConstruction((ISootInitializeHandler)this, (Scene)scene, (Options)options);
    }

    public void onAfterCallGraphConstruction(@NotNull CallGraph cg, @NotNull Scene scene, @NotNull Options options) {
        ISootInitializeHandler.DefaultImpls.onAfterCallGraphConstruction((ISootInitializeHandler)this, (CallGraph)cg, (Scene)scene, (Options)options);
    }

    private static final Object configureCallGraph$lambda$2$lambda$0(String $callGraphAlgorithm, boolean $appOnly) {
        return "using cg algorithm: " + $callGraphAlgorithm + " with " + $appOnly;
    }

    private static final Object constructCallGraph$lambda$8$lambda$4() {
        return "Before build CG: Process information: " + ProcessInfoView.Companion.getGlobalProcessInfo().getProcessInfoText();
    }

    private static final Object constructCallGraph$lambda$8$lambda$6(MemoryWatcher $memoryWatcher) {
        return $memoryWatcher.toString();
    }

    private static final Object constructCallGraph$lambda$8$lambda$7() {
        return "After build CG: Process information: " + ProcessInfoView.Companion.getGlobalProcessInfo().getProcessInfoText();
    }

    private static final Object showPta$lambda$11() {
        return "PointsToAnalysis of scene is DumbPointerAnalysis!!!";
    }

    private static final Object showPta$lambda$12() {
        return "PointsToAnalysis of scene is " + Scene.v().getPointsToAnalysis().getClass().getSimpleName();
    }

    private static final Object showPta$lambda$13() {
        return "Call Graph has been constructed with " + Scene.v().getCallGraph().size() + " edges.";
    }

    private static final Object findClassesInnerJarUnderAutoAppClassPath$lambda$17(IResFile $jar) {
        return "Bad archive file: " + $jar;
    }

    private static final Object findClassesInnerJarUnderAutoAppClassPath$lambda$18(IResFile $jar) {
        return "unknown scheme: " + $jar.getUri();
    }

    private static final Object configure$lambda$19() {
        return "\n\n!!! There are some errors in source code compilation !!!\n\n";
    }

    private static final Object configure$lambda$24$lambda$23$lambda$22$lambda$21(MainConfig $this_with) {
        return "android platform dir: " + $this_with.getAndroidPlatformDir();
    }

    private static final ProjectFileLocator autoAppClassesLocator_delegate$lambda$25(SootCtx this$0) {
        return new ProjectFileLocator(this$0.mainConfig.getMonitor(), (Set)this$0.mainConfig.getAutoAppClasses(), null, this$0.mainConfig.getAutoAppTraverseMode(), false, 16, null);
    }

    private static final Object configure$lambda$26() {
        return "Initializing Soot Scene...";
    }

    private static final Object classesClassification$lambda$27(PersistentSet $autoAppClasses, String $hintAppend1) {
        return "\n\n\nSince " + $autoAppClasses + " has no source files corresponding to the classes, the classifier is unable to classify based on the location of the source code\n" + $hintAppend1 + "\n\n";
    }

    private static final String showClasses$lambda$31(String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it;
    }

    private static final Object showClasses$lambda$33$lambda$32(Function1 $fx, String $prefix, SootCtx this$0, Chain $applicationClasses, Chain $libraryClasses, Chain $phantomClasses, Chain $classes) {
        Intrinsics.checkNotNull((Object)$applicationClasses);
        String string = this$0.show($applicationClasses);
        Intrinsics.checkNotNull((Object)$libraryClasses);
        String string2 = this$0.show($libraryClasses);
        Intrinsics.checkNotNull((Object)$phantomClasses);
        String string3 = this$0.show($phantomClasses);
        Intrinsics.checkNotNull((Object)$classes);
        return $fx.invoke((Object)($prefix + "applicationClasses: " + string + ". libraryClasses: " + string2 + ". phantomClasses: " + string3 + ". classes: " + this$0.show($classes)));
    }

    private static final Object loadClasses$lambda$34(LinkedList $exclude) {
        return "\nsoot exclude " + $exclude;
    }

    private static final CharSequence loadClasses$lambda$37$lambda$36(SootCtx this$0, String p) {
        MainConfig mainConfig = this$0.mainConfig;
        Intrinsics.checkNotNull((Object)p);
        return "\t" + mainConfig.tryGetRelativePathFromAbsolutePath(p).getIdentifier();
    }

    private static final Object loadClasses$lambda$37(Scene $scene, SootCtx this$0) {
        Collection collection = CollectionsKt.listOf((Object)"*PROCESS_DIRS");
        String string = $scene.getSootClassPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getSootClassPath(...)");
        String[] stringArray = new String[]{File.pathSeparator};
        Iterable iterable = StringsKt.split$default((CharSequence)string, (String[])stringArray, (boolean)false, (int)0, (int)6, null);
        List list = Options.v().process_dir();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"process_dir(...)");
        Iterable $this$sortedBy$iv = CollectionsKt.plus((Collection)collection, (Iterable)CollectionsKt.minus((Iterable)iterable, (Iterable)CollectionsKt.toSet((Iterable)list)));
        boolean $i$f$sortedBy = false;
        return "\nsoot classpath:\n " + CollectionsKt.joinToString$default((Iterable)CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */)), (CharSequence)"\n", null, null, (int)0, null, arg_0 -> SootCtx.loadClasses$lambda$37$lambda$36(this$0, arg_0), (int)30, null) + "\n";
    }

    private static final CharSequence loadClasses$lambda$40$lambda$39(SootCtx this$0, String p) {
        MainConfig mainConfig = this$0.mainConfig;
        Intrinsics.checkNotNull((Object)p);
        return "\t" + mainConfig.tryGetRelativePathFromAbsolutePath(p).getIdentifier();
    }

    private static final Object loadClasses$lambda$40(SootCtx this$0) {
        List list = Options.v().process_dir();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"process_dir(...)");
        Iterable $this$sortedBy$iv = list;
        boolean $i$f$sortedBy = false;
        return "\nsoot process_dir:\n " + CollectionsKt.joinToString$default((Iterable)CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */)), (CharSequence)"\n", null, null, (int)0, null, arg_0 -> SootCtx.loadClasses$lambda$40$lambda$39(this$0, arg_0), (int)30, null) + "\n";
    }

    private static final Object loadClasses$lambda$41() {
        return "Before Loading Classes: " + ProcessInfoView.Companion.getGlobalProcessInfo().getProcessInfoText();
    }

    private static final Object loadClasses$lambda$46$lambda$45() {
        return "Load classes done";
    }

    private static final Object loadClasses$lambda$47() {
        return "After Loading Classes: " + ProcessInfoView.Companion.getGlobalProcessInfo().getProcessInfoText();
    }

    private static final Object loadClasses$lambda$48() {
        return "After Rewrite Classes: " + ProcessInfoView.Companion.getGlobalProcessInfo().getProcessInfoText();
    }

    private static final Unit logger$lambda$51() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }
}

