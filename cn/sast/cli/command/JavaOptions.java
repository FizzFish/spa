/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.cli.command.IClassAnalyzeOptionGroup
 *  cn.sast.cli.command.JavaOptions
 *  cn.sast.cli.command.JavaOptions$Companion
 *  cn.sast.cli.command.TargetOptions
 *  cn.sast.framework.EntryPointCreatorFactory
 *  cn.sast.framework.SootCtx
 *  cn.sast.framework.entries.IEntryPointProvider
 *  cn.sast.framework.entries.component.HybridUnReachThenComponent
 *  cn.sast.framework.entries.custom.CustomEntryProvider
 *  cn.sast.framework.entries.custom.HybridCustomThenComponent
 *  cn.sast.framework.entries.java.UnReachableEntryProvider
 *  cn.sast.framework.report.ProjectFileLocator
 *  com.github.ajalt.clikt.core.ParameterHolder
 *  com.github.ajalt.clikt.parameters.options.FlagOptionKt
 *  com.github.ajalt.clikt.parameters.options.OptionWithValues
 *  com.github.ajalt.clikt.parameters.options.OptionWithValuesKt
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.properties.ReadOnlyProperty
 *  kotlin.reflect.KProperty
 *  kotlinx.coroutines.BuildersKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  soot.jimple.infoflow.InfoflowConfiguration
 */
package cn.sast.cli.command;

import cn.sast.api.config.MainConfig;
import cn.sast.cli.command.IClassAnalyzeOptionGroup;
import cn.sast.cli.command.JavaOptions;
import cn.sast.cli.command.TargetOptions;
import cn.sast.framework.EntryPointCreatorFactory;
import cn.sast.framework.SootCtx;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.entries.component.HybridUnReachThenComponent;
import cn.sast.framework.entries.custom.CustomEntryProvider;
import cn.sast.framework.entries.custom.HybridCustomThenComponent;
import cn.sast.framework.entries.java.UnReachableEntryProvider;
import cn.sast.framework.report.ProjectFileLocator;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.parameters.options.FlagOptionKt;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.OptionWithValuesKt;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.InfoflowConfiguration;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0018\u0010\u0015\u00a8\u0006&"}, d2={"Lcn/sast/cli/command/JavaOptions;", "Lcn/sast/cli/command/TargetOptions;", "Lcn/sast/cli/command/IClassAnalyzeOptionGroup;", "<init>", "()V", "customEntryPoint", "", "", "getCustomEntryPoint", "()Ljava/util/List;", "customEntryPoint$delegate", "Lkotlin/properties/ReadOnlyProperty;", "infoFlowConfig", "Lsoot/jimple/infoflow/InfoflowConfiguration;", "getInfoFlowConfig", "()Lsoot/jimple/infoflow/InfoflowConfiguration;", "infoFlowConfig$delegate", "Lkotlin/Lazy;", "makeComponentDummyMain", "", "getMakeComponentDummyMain", "()Z", "makeComponentDummyMain$delegate", "disableJavaEEComponent", "getDisableJavaEEComponent", "disableJavaEEComponent$delegate", "getProvider", "Lcn/sast/framework/entries/IEntryPointProvider;", "sootCtx", "Lcn/sast/framework/SootCtx;", "locator", "Lcn/sast/framework/report/ProjectFileLocator;", "configureMainConfig", "", "mainConfig", "Lcn/sast/api/config/MainConfig;", "initSoot", "Companion", "corax-cli"})
public final class JavaOptions
extends TargetOptions
implements IClassAnalyzeOptionGroup {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ReadOnlyProperty customEntryPoint$delegate = OptionWithValuesKt.help((OptionWithValues)OptionWithValuesKt.multiple$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, (String)"method signature, signature file", (boolean)false, null, null, null, null, (boolean)false, (int)506, null), null, (boolean)false, (int)3, null), (String)"Sets the entry point method(s) for analyze.").provideDelegate((ParameterHolder)this, $$delegatedProperties[0]);
    @NotNull
    private final Lazy infoFlowConfig$delegate = LazyKt.lazy(JavaOptions::infoFlowConfig_delegate$lambda$0);
    @NotNull
    private final ReadOnlyProperty makeComponentDummyMain$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Simple entry point creator that builds a sequential list of method invocations. Each method is invoked only once.", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[1]);
    @NotNull
    private final ReadOnlyProperty disableJavaEEComponent$delegate;
    @NotNull
    private static final KLogger logger;

    public JavaOptions() {
        super("Java Target Options");
        String[] stringArray = new String[]{"--disable-javaee-component"};
        this.disableJavaEEComponent$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])stringArray, (String)"disable create the JavaEE lifecycle component methods", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[2]);
    }

    private final List<String> getCustomEntryPoint() {
        return (List)this.customEntryPoint$delegate.getValue((Object)this, $$delegatedProperties[0]);
    }

    @NotNull
    public InfoflowConfiguration getInfoFlowConfig() {
        Lazy lazy = this.infoFlowConfig$delegate;
        return (InfoflowConfiguration)lazy.getValue();
    }

    private final boolean getMakeComponentDummyMain() {
        return (Boolean)this.makeComponentDummyMain$delegate.getValue((Object)this, $$delegatedProperties[1]);
    }

    private final boolean getDisableJavaEEComponent() {
        return (Boolean)this.disableJavaEEComponent$delegate.getValue((Object)this, $$delegatedProperties[2]);
    }

    @NotNull
    public IEntryPointProvider getProvider(@NotNull SootCtx sootCtx, @NotNull ProjectFileLocator locator2) {
        Intrinsics.checkNotNullParameter((Object)sootCtx, (String)"sootCtx");
        Intrinsics.checkNotNullParameter((Object)locator2, (String)"locator");
        Set entries = (Set)EntryPointCreatorFactory.INSTANCE.getEntryPointFromArgs(this.getCustomEntryPoint()).invoke();
        if (this.getMakeComponentDummyMain()) {
            return !((Collection)entries).isEmpty() ? (IEntryPointProvider)new HybridCustomThenComponent(sootCtx, entries) : (IEntryPointProvider)new HybridUnReachThenComponent(sootCtx);
        }
        return !((Collection)entries).isEmpty() ? (IEntryPointProvider)new CustomEntryProvider(entries) : (this.getDisableJavaEEComponent() ? (IEntryPointProvider)new UnReachableEntryProvider(sootCtx, null, 2, null) : (IEntryPointProvider)BuildersKt.runBlocking$default(null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)1, null));
    }

    public void configureMainConfig(@NotNull MainConfig mainConfig) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
    }

    public void initSoot(@NotNull SootCtx sootCtx, @NotNull ProjectFileLocator locator2) {
        Intrinsics.checkNotNullParameter((Object)sootCtx, (String)"sootCtx");
        Intrinsics.checkNotNullParameter((Object)locator2, (String)"locator");
        sootCtx.configureSoot();
        sootCtx.constructSoot(locator2);
    }

    private static final InfoflowConfiguration infoFlowConfig_delegate$lambda$0() {
        return new InfoflowConfiguration();
    }

    private static final Unit logger$lambda$1() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(JavaOptions.class, "customEntryPoint", "getCustomEntryPoint()Ljava/util/List;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(JavaOptions.class, "makeComponentDummyMain", "getMakeComponentDummyMain()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(JavaOptions.class, "disableJavaEEComponent", "getDisableJavaEEComponent()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        logger = KotlinLogging.INSTANCE.logger(JavaOptions::logger$lambda$1);
    }
}

