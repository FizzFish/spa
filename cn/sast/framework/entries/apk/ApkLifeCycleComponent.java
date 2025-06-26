/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.common.IResource
 *  cn.sast.common.Resource
 *  cn.sast.framework.entries.IEntryPointProvider
 *  cn.sast.framework.entries.IEntryPointProvider$AnalyzeTask
 *  cn.sast.framework.entries.IEntryPointProvider$DefaultImpls
 *  cn.sast.framework.entries.apk.ApkLifeCycleComponent
 *  cn.sast.framework.entries.apk.ApkLifeCycleComponent$Companion
 *  cn.sast.framework.entries.apk.ApkLifeCycleComponent$WSetupApplication
 *  cn.sast.framework.entries.apk.ApkLifeCycleComponentKt
 *  cn.sast.framework.entries.apk.CallbackAnalyzerType
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowCollector
 *  kotlinx.coroutines.flow.FlowKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.jimple.infoflow.InfoflowConfiguration$SootIntegrationMode
 *  soot.jimple.infoflow.android.InfoflowAndroidConfiguration
 *  soot.jimple.infoflow.android.InfoflowAndroidConfiguration$AnalysisFileConfiguration
 *  soot.jimple.infoflow.android.InfoflowAndroidConfiguration$CallbackAnalyzer
 *  soot.jimple.infoflow.android.InfoflowAndroidConfiguration$CallbackConfiguration
 *  soot.jimple.infoflow.android.InfoflowAndroidConfiguration$IccConfiguration
 *  soot.jimple.infoflow.handlers.PreAnalysisHandler
 *  soot.jimple.infoflow.methodSummary.data.provider.IMethodSummaryProvider
 *  soot.jimple.infoflow.methodSummary.taintWrappers.SummaryTaintWrapper
 */
package cn.sast.framework.entries.apk;

import cn.sast.api.config.MainConfig;
import cn.sast.common.IResource;
import cn.sast.common.Resource;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.entries.apk.ApkLifeCycleComponent;
import cn.sast.framework.entries.apk.ApkLifeCycleComponentKt;
import cn.sast.framework.entries.apk.CallbackAnalyzerType;
import java.util.Arrays;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.jimple.infoflow.InfoflowConfiguration;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration;
import soot.jimple.infoflow.handlers.PreAnalysisHandler;
import soot.jimple.infoflow.methodSummary.data.provider.IMethodSummaryProvider;
import soot.jimple.infoflow.methodSummary.taintWrappers.SummaryTaintWrapper;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 U2\u00020\u0001:\u0002UVB\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015B!\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0014\u0010\u001aJ\u0012\u0010F\u001a\u00020G2\n\u0010H\u001a\u00060BR\u00020\u0000J.\u0010I\u001a\u00020G*\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010L\u001a\u00020\u00032\f\u0010M\u001a\b\u0012\u0004\u0012\u00020O0NH\u0086@\u00a2\u0006\u0002\u0010PR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\"\"\u0004\b$\u0010%R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010%R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0011\u0010\u0010\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001b\u0010<\u001a\u00020\u00178FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b=\u0010>R\u001f\u0010A\u001a\u00060BR\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010@\u001a\u0004\bC\u0010DR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020K0R8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bS\u0010T\u00a8\u0006W"}, d2={"Lcn/sast/framework/entries/apk/ApkLifeCycleComponent;", "Lcn/sast/framework/entries/IEntryPointProvider;", "targetAPKFile", "", "androidPlatformDir", "oneComponentAtATime", "", "ignoreFlowsInSystemPackages", "enableCallbacks", "callbacksFile", "callbackAnalyzer", "Lcn/sast/framework/entries/apk/CallbackAnalyzerType;", "filterThreadCallbacks", "maxCallbacksPerComponent", "", "callbackAnalysisTimeout", "maxCallbackAnalysisDepth", "serializeCallbacks", "iccModel", "iccResultsPurify", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Lcn/sast/framework/entries/apk/CallbackAnalyzerType;ZIIIZLjava/lang/String;Z)V", "c", "Lsoot/jimple/infoflow/android/InfoflowAndroidConfiguration;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "(Lsoot/jimple/infoflow/android/InfoflowAndroidConfiguration;Lcn/sast/api/config/MainConfig;Ljava/lang/String;)V", "getTargetAPKFile", "()Ljava/lang/String;", "setTargetAPKFile", "(Ljava/lang/String;)V", "getAndroidPlatformDir", "setAndroidPlatformDir", "getOneComponentAtATime", "()Z", "getIgnoreFlowsInSystemPackages", "setIgnoreFlowsInSystemPackages", "(Z)V", "getEnableCallbacks", "getCallbacksFile", "getCallbackAnalyzer", "()Lcn/sast/framework/entries/apk/CallbackAnalyzerType;", "setCallbackAnalyzer", "(Lcn/sast/framework/entries/apk/CallbackAnalyzerType;)V", "getFilterThreadCallbacks", "setFilterThreadCallbacks", "getMaxCallbacksPerComponent", "()I", "getCallbackAnalysisTimeout", "getMaxCallbackAnalysisDepth", "getSerializeCallbacks", "getIccModel", "setIccModel", "getIccResultsPurify", "taintWrapper", "Lsoot/jimple/infoflow/methodSummary/taintWrappers/SummaryTaintWrapper;", "getTaintWrapper", "()Lsoot/jimple/infoflow/methodSummary/taintWrappers/SummaryTaintWrapper;", "setTaintWrapper", "(Lsoot/jimple/infoflow/methodSummary/taintWrappers/SummaryTaintWrapper;)V", "config", "getConfig", "()Lsoot/jimple/infoflow/android/InfoflowAndroidConfiguration;", "config$delegate", "Lkotlin/Lazy;", "delegateSetupApplication", "Lcn/sast/framework/entries/apk/ApkLifeCycleComponent$WSetupApplication;", "getDelegateSetupApplication", "()Lcn/sast/framework/entries/apk/ApkLifeCycleComponent$WSetupApplication;", "delegateSetupApplication$delegate", "injectStubDroidHierarchy", "", "analyzer", "emit", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcn/sast/framework/entries/IEntryPointProvider$AnalyzeTask;", "name", "entries", "", "Lsoot/SootMethod;", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/String;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "iterator", "Lkotlinx/coroutines/flow/Flow;", "getIterator", "()Lkotlinx/coroutines/flow/Flow;", "Companion", "WSetupApplication", "corax-framework"})
public final class ApkLifeCycleComponent
implements IEntryPointProvider {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private String targetAPKFile;
    @NotNull
    private String androidPlatformDir;
    private final boolean oneComponentAtATime;
    private boolean ignoreFlowsInSystemPackages;
    private final boolean enableCallbacks;
    @NotNull
    private final String callbacksFile;
    @NotNull
    private CallbackAnalyzerType callbackAnalyzer;
    private boolean filterThreadCallbacks;
    private final int maxCallbacksPerComponent;
    private final int callbackAnalysisTimeout;
    private final int maxCallbackAnalysisDepth;
    private final boolean serializeCallbacks;
    @Nullable
    private String iccModel;
    private final boolean iccResultsPurify;
    @Nullable
    private SummaryTaintWrapper taintWrapper;
    @NotNull
    private final Lazy config$delegate;
    @NotNull
    private final Lazy delegateSetupApplication$delegate;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(ApkLifeCycleComponent::logger$lambda$2);

    public ApkLifeCycleComponent(@NotNull String targetAPKFile, @NotNull String androidPlatformDir, boolean oneComponentAtATime, boolean ignoreFlowsInSystemPackages, boolean enableCallbacks, @NotNull String callbacksFile, @NotNull CallbackAnalyzerType callbackAnalyzer, boolean filterThreadCallbacks, int maxCallbacksPerComponent, int callbackAnalysisTimeout, int maxCallbackAnalysisDepth, boolean serializeCallbacks, @Nullable String iccModel, boolean iccResultsPurify) {
        Intrinsics.checkNotNullParameter((Object)targetAPKFile, (String)"targetAPKFile");
        Intrinsics.checkNotNullParameter((Object)androidPlatformDir, (String)"androidPlatformDir");
        Intrinsics.checkNotNullParameter((Object)callbacksFile, (String)"callbacksFile");
        Intrinsics.checkNotNullParameter((Object)callbackAnalyzer, (String)"callbackAnalyzer");
        this.targetAPKFile = targetAPKFile;
        this.androidPlatformDir = androidPlatformDir;
        this.oneComponentAtATime = oneComponentAtATime;
        this.ignoreFlowsInSystemPackages = ignoreFlowsInSystemPackages;
        this.enableCallbacks = enableCallbacks;
        this.callbacksFile = callbacksFile;
        this.callbackAnalyzer = callbackAnalyzer;
        this.filterThreadCallbacks = filterThreadCallbacks;
        this.maxCallbacksPerComponent = maxCallbacksPerComponent;
        this.callbackAnalysisTimeout = callbackAnalysisTimeout;
        this.maxCallbackAnalysisDepth = maxCallbackAnalysisDepth;
        this.serializeCallbacks = serializeCallbacks;
        this.iccModel = iccModel;
        this.iccResultsPurify = iccResultsPurify;
        this.config$delegate = LazyKt.lazy(() -> ApkLifeCycleComponent.config_delegate$lambda$0(this));
        this.delegateSetupApplication$delegate = LazyKt.lazy(() -> ApkLifeCycleComponent.delegateSetupApplication_delegate$lambda$1(this));
    }

    public /* synthetic */ ApkLifeCycleComponent(String string, String string2, boolean bl, boolean bl2, boolean bl3, String string3, CallbackAnalyzerType callbackAnalyzerType, boolean bl4, int n, int n2, int n3, boolean bl5, String string4, boolean bl6, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 4) != 0) {
            bl = true;
        }
        if ((n4 & 8) != 0) {
            bl2 = false;
        }
        if ((n4 & 0x10) != 0) {
            bl3 = true;
        }
        if ((n4 & 0x20) != 0) {
            string3 = "";
        }
        if ((n4 & 0x40) != 0) {
            callbackAnalyzerType = CallbackAnalyzerType.Default;
        }
        if ((n4 & 0x80) != 0) {
            bl4 = true;
        }
        if ((n4 & 0x100) != 0) {
            n = 100;
        }
        if ((n4 & 0x200) != 0) {
            n2 = 0;
        }
        if ((n4 & 0x400) != 0) {
            n3 = -1;
        }
        if ((n4 & 0x800) != 0) {
            bl5 = false;
        }
        if ((n4 & 0x1000) != 0) {
            string4 = null;
        }
        if ((n4 & 0x2000) != 0) {
            bl6 = true;
        }
        this(string, string2, bl, bl2, bl3, string3, callbackAnalyzerType, bl4, n, n2, n3, bl5, string4, bl6);
    }

    @NotNull
    public final String getTargetAPKFile() {
        return this.targetAPKFile;
    }

    public final void setTargetAPKFile(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.targetAPKFile = string;
    }

    @NotNull
    public final String getAndroidPlatformDir() {
        return this.androidPlatformDir;
    }

    public final void setAndroidPlatformDir(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.androidPlatformDir = string;
    }

    public final boolean getOneComponentAtATime() {
        return this.oneComponentAtATime;
    }

    public final boolean getIgnoreFlowsInSystemPackages() {
        return this.ignoreFlowsInSystemPackages;
    }

    public final void setIgnoreFlowsInSystemPackages(boolean bl) {
        this.ignoreFlowsInSystemPackages = bl;
    }

    public final boolean getEnableCallbacks() {
        return this.enableCallbacks;
    }

    @NotNull
    public final String getCallbacksFile() {
        return this.callbacksFile;
    }

    @NotNull
    public final CallbackAnalyzerType getCallbackAnalyzer() {
        return this.callbackAnalyzer;
    }

    public final void setCallbackAnalyzer(@NotNull CallbackAnalyzerType callbackAnalyzerType) {
        Intrinsics.checkNotNullParameter((Object)callbackAnalyzerType, (String)"<set-?>");
        this.callbackAnalyzer = callbackAnalyzerType;
    }

    public final boolean getFilterThreadCallbacks() {
        return this.filterThreadCallbacks;
    }

    public final void setFilterThreadCallbacks(boolean bl) {
        this.filterThreadCallbacks = bl;
    }

    public final int getMaxCallbacksPerComponent() {
        return this.maxCallbacksPerComponent;
    }

    public final int getCallbackAnalysisTimeout() {
        return this.callbackAnalysisTimeout;
    }

    public final int getMaxCallbackAnalysisDepth() {
        return this.maxCallbackAnalysisDepth;
    }

    public final boolean getSerializeCallbacks() {
        return this.serializeCallbacks;
    }

    @Nullable
    public final String getIccModel() {
        return this.iccModel;
    }

    public final void setIccModel(@Nullable String string) {
        this.iccModel = string;
    }

    public final boolean getIccResultsPurify() {
        return this.iccResultsPurify;
    }

    @Nullable
    public final SummaryTaintWrapper getTaintWrapper() {
        return this.taintWrapper;
    }

    public final void setTaintWrapper(@Nullable SummaryTaintWrapper summaryTaintWrapper) {
        this.taintWrapper = summaryTaintWrapper;
    }

    public ApkLifeCycleComponent(@NotNull InfoflowAndroidConfiguration c, @NotNull MainConfig mainConfig, @NotNull String targetAPKFile) {
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        Intrinsics.checkNotNullParameter((Object)targetAPKFile, (String)"targetAPKFile");
        String string = mainConfig.getAndroidPlatformDir();
        Intrinsics.checkNotNull((Object)string);
        boolean bl = c.getOneComponentAtATime();
        boolean bl2 = c.getIgnoreFlowsInSystemPackages();
        boolean bl3 = c.getCallbackConfig().getEnableCallbacks();
        String string2 = c.getCallbackConfig().getCallbacksFile();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getCallbacksFile(...)");
        InfoflowAndroidConfiguration.CallbackAnalyzer callbackAnalyzer = c.getCallbackConfig().getCallbackAnalyzer();
        Intrinsics.checkNotNullExpressionValue((Object)callbackAnalyzer, (String)"getCallbackAnalyzer(...)");
        this(targetAPKFile, string, bl, bl2, bl3, string2, ApkLifeCycleComponentKt.getConvert((InfoflowAndroidConfiguration.CallbackAnalyzer)callbackAnalyzer), c.getCallbackConfig().getFilterThreadCallbacks(), c.getCallbackConfig().getMaxCallbacksPerComponent(), c.getCallbackConfig().getCallbackAnalysisTimeout(), c.getCallbackConfig().getMaxAnalysisCallbackDepth(), c.getCallbackConfig().isSerializeCallbacks(), c.getIccConfig().getIccModel(), c.getIccConfig().isIccResultsPurifyEnabled());
    }

    @NotNull
    public final InfoflowAndroidConfiguration getConfig() {
        Lazy lazy = this.config$delegate;
        return (InfoflowAndroidConfiguration)lazy.getValue();
    }

    private final WSetupApplication getDelegateSetupApplication() {
        Lazy lazy = this.delegateSetupApplication$delegate;
        return (WSetupApplication)lazy.getValue();
    }

    public final void injectStubDroidHierarchy(@NotNull WSetupApplication analyzer2) {
        Intrinsics.checkNotNullParameter((Object)analyzer2, (String)"analyzer");
        SummaryTaintWrapper summaryTaintWrapper = this.taintWrapper;
        if (summaryTaintWrapper == null) {
            return;
        }
        SummaryTaintWrapper taintWrapper = summaryTaintWrapper;
        IMethodSummaryProvider provider = taintWrapper.getProvider();
        analyzer2.addPreprocessor((PreAnalysisHandler)new /* Unavailable Anonymous Inner Class!! */);
    }

    @Nullable
    public final Object emit(@NotNull FlowCollector<? super IEntryPointProvider.AnalyzeTask> $this$emit, @NotNull String name, @NotNull Set<? extends SootMethod> entries, @NotNull Continuation<? super Unit> $completion) {
        Object object = $this$emit.emit((Object)new /* Unavailable Anonymous Inner Class!! */, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public Flow<IEntryPointProvider.AnalyzeTask> getIterator() {
        return FlowKt.flow((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
    }

    public void startAnalyse() {
        IEntryPointProvider.DefaultImpls.startAnalyse((IEntryPointProvider)this);
    }

    public void endAnalyse() {
        IEntryPointProvider.DefaultImpls.endAnalyse((IEntryPointProvider)this);
    }

    private static final InfoflowAndroidConfiguration config_delegate$lambda$0(ApkLifeCycleComponent this$0) {
        InfoflowAndroidConfiguration config = new InfoflowAndroidConfiguration();
        config.setIgnoreFlowsInSystemPackages(this$0.ignoreFlowsInSystemPackages);
        config.setSootIntegrationMode(InfoflowConfiguration.SootIntegrationMode.CreateNewInstance);
        config.setCallgraphAlgorithm(null);
        InfoflowAndroidConfiguration.IccConfiguration iccConfig = config.getIccConfig();
        iccConfig.setIccModel(this$0.iccModel);
        iccConfig.setIccResultsPurify(this$0.iccResultsPurify);
        InfoflowAndroidConfiguration.AnalysisFileConfiguration analysisFileConfig = config.getAnalysisFileConfig();
        analysisFileConfig.setTargetAPKFile(this$0.targetAPKFile);
        InfoflowAndroidConfiguration.CallbackConfiguration callbackConfig = config.getCallbackConfig();
        callbackConfig.setEnableCallbacks(this$0.enableCallbacks);
        callbackConfig.setCallbacksFile(this$0.callbacksFile);
        callbackConfig.setCallbackAnalyzer(ApkLifeCycleComponentKt.getConvert((CallbackAnalyzerType)this$0.callbackAnalyzer));
        callbackConfig.setFilterThreadCallbacks(this$0.filterThreadCallbacks);
        callbackConfig.setMaxCallbacksPerComponent(this$0.maxCallbacksPerComponent);
        callbackConfig.setCallbackAnalysisTimeout(this$0.callbackAnalysisTimeout);
        callbackConfig.setMaxAnalysisCallbackDepth(this$0.maxCallbackAnalysisDepth);
        callbackConfig.setSerializeCallbacks(this$0.serializeCallbacks);
        IResource targetFile = Resource.INSTANCE.of(this$0.targetAPKFile);
        if (!targetFile.getExists()) {
            String string = "Target APK file %s does not exist";
            Object[] objectArray = new Object[]{targetFile.getAbsolutePath()};
            String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
            String string3 = string2;
            throw new IllegalStateException(string3.toString());
        }
        return config;
    }

    private static final WSetupApplication delegateSetupApplication_delegate$lambda$1(ApkLifeCycleComponent this$0) {
        this$0.getConfig().getAnalysisFileConfig().setAndroidPlatformDir(this$0.androidPlatformDir);
        WSetupApplication wSetupApplication = new WSetupApplication(this$0, this$0.getConfig());
        this$0.getConfig().getAnalysisFileConfig().setAndroidPlatformDir("unused");
        return wSetupApplication;
    }

    private static final Unit logger$lambda$2() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ WSetupApplication access$getDelegateSetupApplication(ApkLifeCycleComponent $this) {
        return $this.getDelegateSetupApplication();
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }
}

