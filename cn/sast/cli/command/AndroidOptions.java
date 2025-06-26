/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.cli.command.AndroidOptions
 *  cn.sast.cli.command.AndroidOptions$special$$inlined$check$default$1
 *  cn.sast.cli.command.IClassAnalyzeOptionGroup
 *  cn.sast.cli.command.TargetOptions
 *  cn.sast.common.IResource
 *  cn.sast.framework.SootCtx
 *  cn.sast.framework.entries.IEntryPointProvider
 *  cn.sast.framework.entries.apk.ApkLifeCycleComponent
 *  cn.sast.framework.report.ProjectFileLocator
 *  com.github.ajalt.clikt.core.ParameterHolder
 *  com.github.ajalt.clikt.parameters.options.FlagOptionKt
 *  com.github.ajalt.clikt.parameters.options.OptionDelegate
 *  com.github.ajalt.clikt.parameters.options.OptionWithValues
 *  com.github.ajalt.clikt.parameters.options.OptionWithValues$DefaultImpls
 *  com.github.ajalt.clikt.parameters.options.OptionWithValuesKt
 *  com.github.ajalt.clikt.parameters.types.FileKt
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.properties.ReadOnlyProperty
 *  kotlin.reflect.KProperty
 *  kotlinx.collections.immutable.PersistentSet
 *  org.jetbrains.annotations.NotNull
 *  soot.jimple.infoflow.android.InfoflowAndroidConfiguration
 *  soot.jimple.infoflow.android.InfoflowAndroidConfiguration$AnalysisFileConfiguration
 *  soot.jimple.infoflow.android.InfoflowAndroidConfiguration$CallbackAnalyzer
 *  soot.jimple.infoflow.android.InfoflowAndroidConfiguration$CallbackConfiguration
 *  soot.jimple.infoflow.android.InfoflowAndroidConfiguration$IccConfiguration
 *  soot.jimple.infoflow.android.InfoflowAndroidConfiguration$SourceSinkConfiguration
 */
package cn.sast.cli.command;

import cn.sast.api.config.MainConfig;
import cn.sast.cli.command.AndroidOptions$special$;
import cn.sast.cli.command.IClassAnalyzeOptionGroup;
import cn.sast.cli.command.TargetOptions;
import cn.sast.common.IResource;
import cn.sast.framework.SootCtx;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.entries.apk.ApkLifeCycleComponent;
import cn.sast.framework.report.ProjectFileLocator;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.parameters.options.FlagOptionKt;
import com.github.ajalt.clikt.parameters.options.OptionDelegate;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.OptionWithValuesKt;
import com.github.ajalt.clikt.parameters.types.FileKt;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.collections.immutable.PersistentSet;
import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010$\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010 \u001a\u00020!*\u00020\u001f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006%"}, d2={"Lcn/sast/cli/command/AndroidOptions;", "Lcn/sast/cli/command/TargetOptions;", "Lcn/sast/cli/command/IClassAnalyzeOptionGroup;", "<init>", "()V", "androidPlatformDir", "Ljava/io/File;", "getAndroidPlatformDir", "()Ljava/io/File;", "androidPlatformDir$delegate", "Lkotlin/properties/ReadOnlyProperty;", "oneComponentAtATime", "", "getOneComponentAtATime", "()Z", "oneComponentAtATime$delegate", "infoFlowConfig", "Lsoot/jimple/infoflow/android/InfoflowAndroidConfiguration;", "getInfoFlowConfig", "()Lsoot/jimple/infoflow/android/InfoflowAndroidConfiguration;", "infoFlowConfig$delegate", "Lkotlin/Lazy;", "getProvider", "Lcn/sast/framework/entries/IEntryPointProvider;", "sootCtx", "Lcn/sast/framework/SootCtx;", "locator", "Lcn/sast/framework/report/ProjectFileLocator;", "configureMainConfig", "", "mainConfig", "Lcn/sast/api/config/MainConfig;", "targetApkFile", "", "getTargetApkFile", "(Lcn/sast/api/config/MainConfig;)Ljava/lang/String;", "initSoot", "corax-cli"})
@SourceDebugExtension(value={"SMAP\nAndroidOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidOptions.kt\ncn/sast/cli/command/AndroidOptions\n+ 2 Validate.kt\ncom/github/ajalt/clikt/parameters/options/ValidateKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,94:1\n65#2,5:95\n25#2:100\n1#3:101\n*S KotlinDebug\n*F\n+ 1 AndroidOptions.kt\ncn/sast/cli/command/AndroidOptions\n*L\n20#1:95,5\n20#1:100\n*E\n"})
public final class AndroidOptions
extends TargetOptions
implements IClassAnalyzeOptionGroup {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ReadOnlyProperty androidPlatformDir$delegate;
    @NotNull
    private final ReadOnlyProperty oneComponentAtATime$delegate;
    @NotNull
    private final Lazy infoFlowConfig$delegate;

    public AndroidOptions() {
        super("Android Target Options");
        OptionWithValues $this$check_u24default$iv = OptionWithValuesKt.required((OptionWithValues)FileKt.file$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Sets the android platform directory or path of android.jar. \nThe value of environment variable \"ANDROID_JARS\" is also accepted.", null, (boolean)false, (String)"ANDROID_JARS", null, null, null, (boolean)false, (int)492, null), (boolean)true, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (int)62, null));
        boolean $i$f$check = false;
        OptionWithValues $this$validate$iv$iv = $this$check_u24default$iv;
        boolean $i$f$validate = false;
        this.androidPlatformDir$delegate = ((OptionDelegate)OptionWithValues.DefaultImpls.copy$default((OptionWithValues)$this$validate$iv$iv, (Function2)$this$validate$iv$iv.getTransformValue(), (Function2)$this$validate$iv$iv.getTransformEach(), (Function2)$this$validate$iv$iv.getTransformAll(), (Function2)((Function2)new special$$inlined$check$default$1()), null, null, null, null, (boolean)false, null, null, null, null, null, null, (boolean)false, (boolean)false, (boolean)false, (int)262128, null)).provideDelegate((ParameterHolder)this, $$delegatedProperties[0]);
        this.oneComponentAtATime$delegate = OptionWithValuesKt.help((OptionWithValues)FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)false, null, null, null, null, (boolean)false, (int)510, null), (String[])new String[0], (boolean)false, null, (int)6, null), (String)"Set if analysis shall be performed on one entry of (Android component/Web application) at a time").provideDelegate((ParameterHolder)this, $$delegatedProperties[1]);
        this.infoFlowConfig$delegate = LazyKt.lazy(() -> AndroidOptions.infoFlowConfig_delegate$lambda$5(this));
    }

    private final File getAndroidPlatformDir() {
        return (File)this.androidPlatformDir$delegate.getValue((Object)this, $$delegatedProperties[0]);
    }

    private final boolean getOneComponentAtATime() {
        return (Boolean)this.oneComponentAtATime$delegate.getValue((Object)this, $$delegatedProperties[1]);
    }

    @NotNull
    public InfoflowAndroidConfiguration getInfoFlowConfig() {
        Lazy lazy = this.infoFlowConfig$delegate;
        return (InfoflowAndroidConfiguration)lazy.getValue();
    }

    @NotNull
    public IEntryPointProvider getProvider(@NotNull SootCtx sootCtx, @NotNull ProjectFileLocator locator2) {
        Intrinsics.checkNotNullParameter((Object)sootCtx, (String)"sootCtx");
        Intrinsics.checkNotNullParameter((Object)locator2, (String)"locator");
        MainConfig mainConfig = sootCtx.getMainConfig();
        String targetApkFile = this.getTargetApkFile(mainConfig);
        return (IEntryPointProvider)new ApkLifeCycleComponent(this.getInfoFlowConfig(), mainConfig, targetApkFile);
    }

    public void configureMainConfig(@NotNull MainConfig mainConfig) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        mainConfig.setAndroidPlatformDir(this.getAndroidPlatformDir().getAbsolutePath());
    }

    private final String getTargetApkFile(MainConfig $this$targetApkFile) {
        PersistentSet it = $this$targetApkFile.getProcessDir();
        boolean bl = false;
        if (!(it.size() == 1)) {
            boolean bl2 = false;
            String string = "process: " + $this$targetApkFile.getProcessDir() + " must be a single apk file";
            throw new IllegalStateException(string.toString());
        }
        String targetApkFile = ((IResource)CollectionsKt.first((Iterable)((Iterable)it))).getAbsolutePath();
        return targetApkFile;
    }

    public void initSoot(@NotNull SootCtx sootCtx, @NotNull ProjectFileLocator locator2) {
        Intrinsics.checkNotNullParameter((Object)sootCtx, (String)"sootCtx");
        Intrinsics.checkNotNullParameter((Object)locator2, (String)"locator");
        MainConfig mainConfig = sootCtx.getMainConfig();
        String targetApkFile = this.getTargetApkFile(mainConfig);
        String string = mainConfig.getAndroidJarClasspath(targetApkFile);
        if (string == null) {
            throw new IllegalStateException(("could not find android jar in androidPlatformDir: " + mainConfig.getAndroidPlatformDir() + " with apk: " + targetApkFile).toString());
        }
        String androidJar = string;
        mainConfig.setClasspath(mainConfig.getClasspath().add((Object)androidJar));
        sootCtx.configureSoot();
        sootCtx.constructSoot(locator2);
    }

    private static final InfoflowAndroidConfiguration infoFlowConfig_delegate$lambda$5(AndroidOptions this$0) {
        InfoflowAndroidConfiguration infoConfig = new InfoflowAndroidConfiguration();
        InfoflowAndroidConfiguration.AnalysisFileConfiguration $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u241 = infoConfig.getAnalysisFileConfig();
        boolean bl = false;
        $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u241.setTargetAPKFile("unused");
        $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u241.setSourceSinkFile("unused");
        $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u241.setAndroidPlatformDir("unused");
        $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u241.setAdditionalClasspath("unused");
        $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u241.setOutputFile("unused");
        InfoflowAndroidConfiguration.CallbackConfiguration $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u242 = infoConfig.getCallbackConfig();
        boolean bl2 = false;
        $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u242.setEnableCallbacks(true);
        $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u242.setCallbackAnalyzer(InfoflowAndroidConfiguration.CallbackAnalyzer.Default);
        $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u242.setFilterThreadCallbacks(true);
        $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u242.setMaxCallbacksPerComponent(100);
        $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u242.setCallbackAnalysisTimeout(0);
        $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u242.setMaxAnalysisCallbackDepth(-1);
        $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u242.setSerializeCallbacks(false);
        $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u242.setCallbacksFile("");
        InfoflowAndroidConfiguration.SourceSinkConfiguration $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u243 = infoConfig.getSourceSinkConfig();
        boolean bl3 = false;
        InfoflowAndroidConfiguration.IccConfiguration $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u244 = infoConfig.getIccConfig();
        boolean bl4 = false;
        $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u244.setIccModel(null);
        $this$infoFlowConfig_delegate_u24lambda_u245_u24lambda_u244.setIccResultsPurify(true);
        infoConfig.setOneComponentAtATime(this$0.getOneComponentAtATime());
        return infoConfig;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(AndroidOptions.class, "androidPlatformDir", "getAndroidPlatformDir()Ljava/io/File;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(AndroidOptions.class, "oneComponentAtATime", "getOneComponentAtATime()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}

