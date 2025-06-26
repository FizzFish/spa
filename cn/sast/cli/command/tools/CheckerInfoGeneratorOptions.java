/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.CheckerInfoGenResult
 *  cn.sast.cli.command.tools.CheckerInfoGenerator
 *  cn.sast.cli.command.tools.CheckerInfoGenerator$Companion
 *  cn.sast.cli.command.tools.CheckerInfoGeneratorOptions
 *  cn.sast.cli.command.tools.CheckerInfoGeneratorOptions$Companion
 *  cn.sast.framework.plugin.ConfigPluginLoader
 *  com.github.ajalt.clikt.core.ParameterHolder
 *  com.github.ajalt.clikt.parameters.groups.OptionGroup
 *  com.github.ajalt.clikt.parameters.options.OptionWithValues
 *  com.github.ajalt.clikt.parameters.options.OptionWithValuesKt
 *  com.github.ajalt.clikt.parameters.types.BooleanKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.properties.ReadOnlyProperty
 *  kotlin.reflect.KProperty
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.cli.command.tools;

import cn.sast.api.config.CheckerInfoGenResult;
import cn.sast.cli.command.tools.CheckerInfoGenerator;
import cn.sast.cli.command.tools.CheckerInfoGeneratorOptions;
import cn.sast.framework.plugin.ConfigPluginLoader;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.parameters.groups.OptionGroup;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.OptionWithValuesKt;
import com.github.ajalt.clikt.parameters.types.BooleanKt;
import java.io.File;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0015R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2={"Lcn/sast/cli/command/tools/CheckerInfoGeneratorOptions;", "Lcom/github/ajalt/clikt/parameters/groups/OptionGroup;", "<init>", "()V", "genCheckerInfoJson", "", "getGenCheckerInfoJson", "()Z", "genCheckerInfoJson$delegate", "Lkotlin/properties/ReadOnlyProperty;", "language", "", "", "getLanguage", "()Ljava/util/List;", "language$delegate", "run", "", "pl", "Lcn/sast/framework/plugin/ConfigPluginLoader;", "rules", "", "Companion", "corax-cli"})
public final class CheckerInfoGeneratorOptions
extends OptionGroup {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ReadOnlyProperty genCheckerInfoJson$delegate;
    @NotNull
    private final ReadOnlyProperty language$delegate;
    @NotNull
    private static final KLogger logger;

    public CheckerInfoGeneratorOptions() {
        super("Generate checker_info.json for CoraxServer Options", null, 2, null);
        ParameterHolder parameterHolder = (ParameterHolder)this;
        Object[] objectArray = new String[]{"--gen-checker-info"};
        Object[] objectArray2 = objectArray;
        objectArray = new String[]{"CoraxUnCompressDir", "Corax", "Plugins", "Canary"};
        Iterable iterable = CollectionsKt.listOf((Object[])objectArray);
        String string = File.pathSeparator;
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"pathSeparator");
        this.genCheckerInfoJson$delegate = OptionWithValuesKt.required((OptionWithValues)BooleanKt.boolean((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)parameterHolder, (String[])objectArray2, (String)"Generate checker_info.json from Corax/Corax/Plugins/Canary/analysis-config", (String)("the \"" + CollectionsKt.joinToString$default((Iterable)iterable, (CharSequence)string, null, null, (int)0, null, null, (int)62, null) + "\" directory path"), (boolean)false, null, null, null, null, (boolean)false, (int)504, null))).provideDelegate((ParameterHolder)this, $$delegatedProperties[0]);
        objectArray = new String[]{"--info-lang"};
        OptionWithValues optionWithValues = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])objectArray, (String)"", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null);
        objectArray = new String[]{"zh-CN", "en-US"};
        this.language$delegate = OptionWithValuesKt.multiple$default((OptionWithValues)optionWithValues, (List)CollectionsKt.listOf((Object[])objectArray), (boolean)false, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[1]);
    }

    private final boolean getGenCheckerInfoJson() {
        return (Boolean)this.genCheckerInfoJson$delegate.getValue((Object)this, $$delegatedProperties[0]);
    }

    private final List<String> getLanguage() {
        return (List)this.language$delegate.getValue((Object)this, $$delegatedProperties[1]);
    }

    public final void run(@NotNull ConfigPluginLoader pl, @Nullable Set<String> rules2) {
        Intrinsics.checkNotNullParameter((Object)pl, (String)"pl");
        if (this.getGenCheckerInfoJson()) {
            CheckerInfoGenerator checkerInfoGenerator = CheckerInfoGenerator.Companion.createCheckerInfoGenerator$default((CheckerInfoGenerator.Companion)CheckerInfoGenerator.Companion, (ConfigPluginLoader)pl, (List)this.getLanguage(), (boolean)false, (int)4, null);
            if (checkerInfoGenerator == null) {
                System.exit(2);
                throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
            }
            CheckerInfoGenerator gen2 = checkerInfoGenerator;
            CheckerInfoGenResult checkerInfo = CheckerInfoGenerator.getCheckerInfo$default((CheckerInfoGenerator)gen2, (boolean)false, (int)1, null);
            gen2.dumpCheckerInfoJson(checkerInfo, true);
            gen2.dumpRuleAndRuleMappingDB(checkerInfo, rules2);
        }
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    private static final Unit logger$lambda$0() {
        return Unit.INSTANCE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(CheckerInfoGeneratorOptions.class, "genCheckerInfoJson", "getGenCheckerInfoJson()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(CheckerInfoGeneratorOptions.class, "language", "getLanguage()Ljava/util/List;", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        logger = KotlinLogging.INSTANCE.logger(CheckerInfoGeneratorOptions::logger$lambda$0);
    }
}

