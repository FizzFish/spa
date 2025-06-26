/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.cli.command.tools.CheckerInfoGeneratorKt
 *  cn.sast.cli.command.tools.SubToolsOptions
 *  cn.sast.cli.command.tools.SubToolsOptions$Companion
 *  cn.sast.framework.plugin.ConfigPluginLoader
 *  cn.sast.framework.plugin.PluginDefinitions
 *  cn.sast.framework.plugin.PluginDefinitions$CheckTypeDefinition
 *  com.feysh.corax.config.api.CheckType
 *  com.github.ajalt.clikt.core.ParameterHolder
 *  com.github.ajalt.clikt.parameters.groups.OptionGroup
 *  com.github.ajalt.clikt.parameters.options.FlagOptionKt
 *  com.github.ajalt.clikt.parameters.options.OptionWithValues
 *  com.github.ajalt.clikt.parameters.options.OptionWithValuesKt
 *  com.github.ajalt.clikt.parameters.types.BooleanKt
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.properties.ReadOnlyProperty
 *  kotlin.reflect.KProperty
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.StringFormat
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.StringSerializer
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JsonBuilder
 *  kotlinx.serialization.json.JsonKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.cli.command.tools;

import cn.sast.cli.command.tools.CheckerInfoGeneratorKt;
import cn.sast.cli.command.tools.SubToolsOptions;
import cn.sast.framework.plugin.ConfigPluginLoader;
import cn.sast.framework.plugin.PluginDefinitions;
import com.feysh.corax.config.api.CheckType;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.parameters.groups.OptionGroup;
import com.github.ajalt.clikt.parameters.options.FlagOptionKt;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.OptionWithValuesKt;
import com.github.ajalt.clikt.parameters.types.BooleanKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007\u00a8\u0006\u0018\u00b2\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002\u00b2\u0006\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u008a\u0084\u0002"}, d2={"Lcn/sast/cli/command/tools/SubToolsOptions;", "Lcom/github/ajalt/clikt/parameters/groups/OptionGroup;", "<init>", "()V", "subtools", "", "getSubtools", "()Z", "subtools$delegate", "Lkotlin/properties/ReadOnlyProperty;", "listRules", "getListRules", "listRules$delegate", "listCheckTypes", "getListCheckTypes", "listCheckTypes$delegate", "run", "", "pl", "Lcn/sast/framework/plugin/ConfigPluginLoader;", "rules", "", "", "Companion", "corax-cli", "pluginDefinitions", "Lcn/sast/framework/plugin/PluginDefinitions;", "checkTypes", "", "Lcom/feysh/corax/config/api/CheckType;"})
@SourceDebugExtension(value={"SMAP\nSubToolsOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubToolsOptions.kt\ncn/sast/cli/command/tools/SubToolsOptions\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SerialFormat.kt\nkotlinx/serialization/SerialFormatKt\n*L\n1#1,56:1\n1557#2:57\n1628#2,3:58\n1557#2:62\n1628#2,3:63\n1557#2:67\n1628#2,3:68\n1053#2:71\n113#3:61\n113#3:66\n*S KotlinDebug\n*F\n+ 1 SubToolsOptions.kt\ncn/sast/cli/command/tools/SubToolsOptions\n*L\n39#1:57\n39#1:58,3\n42#1:62\n42#1:63,3\n36#1:67\n36#1:68,3\n36#1:71\n39#1:61\n42#1:66\n*E\n"})
public final class SubToolsOptions
extends OptionGroup {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ReadOnlyProperty subtools$delegate;
    @NotNull
    private final ReadOnlyProperty listRules$delegate;
    @NotNull
    private final ReadOnlyProperty listCheckTypes$delegate;
    @NotNull
    private static final KLogger logger;
    @NotNull
    private static final Json jsonFormat;

    public SubToolsOptions() {
        super("Sub tools Options", null, 2, null);
        String[] stringArray = new String[]{"--subtools"};
        this.subtools$delegate = OptionWithValuesKt.required((OptionWithValues)BooleanKt.boolean((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])stringArray, (String)"subtools", (String)"", (boolean)false, null, null, null, null, (boolean)false, (int)504, null))).provideDelegate((ParameterHolder)this, $$delegatedProperties[0]);
        stringArray = new String[]{"--list-rules"};
        this.listRules$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])stringArray, (String)"Print all the rules", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[1]);
        stringArray = new String[]{"--list-check-types"};
        this.listCheckTypes$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])stringArray, (String)"Print all the rules", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[2]);
    }

    private final boolean getSubtools() {
        return (Boolean)this.subtools$delegate.getValue((Object)this, $$delegatedProperties[0]);
    }

    private final boolean getListRules() {
        return (Boolean)this.listRules$delegate.getValue((Object)this, $$delegatedProperties[1]);
    }

    private final boolean getListCheckTypes() {
        return (Boolean)this.listCheckTypes$delegate.getValue((Object)this, $$delegatedProperties[2]);
    }

    /*
     * WARNING - void declaration
     */
    public final void run(@NotNull ConfigPluginLoader pl, @Nullable Set<String> rules2) {
        Intrinsics.checkNotNullParameter((Object)pl, (String)"pl");
        if (this.getSubtools()) {
            void value$iv;
            Object $this$encodeToString$iv;
            boolean $i$f$encodeToString;
            CheckType it;
            Collection collection;
            Iterable $this$mapTo$iv$iv;
            boolean $i$f$mapTo;
            Collection destination$iv$iv;
            boolean $i$f$map;
            Iterable $this$map$iv;
            Object object;
            Lazy pluginDefinitions$delegate = LazyKt.lazy(() -> SubToolsOptions.run$lambda$0(pl));
            Lazy checkTypes$delegate = LazyKt.lazy(() -> SubToolsOptions.run$lambda$4(pluginDefinitions$delegate));
            if (this.getListRules()) {
                object = (StringFormat)jsonFormat;
                $this$map$iv = SubToolsOptions.run$lambda$5((Lazy)checkTypes$delegate);
                $i$f$map = false;
                Iterable iterable = $this$map$iv;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    CheckType checkType = (CheckType)item$iv$iv;
                    collection = destination$iv$iv;
                    boolean bl = false;
                    collection.add(CheckerInfoGeneratorKt.getId((CheckType)it));
                }
                $this$map$iv = (List)destination$iv$iv;
                $i$f$encodeToString = false;
                $this$encodeToString$iv.getSerializersModule();
                $this$encodeToString$iv = $this$encodeToString$iv.encodeToString((SerializationStrategy)new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), (Object)value$iv);
                System.out.println($this$encodeToString$iv);
            }
            if (this.getListCheckTypes()) {
                $this$encodeToString$iv = (StringFormat)jsonFormat;
                $this$map$iv = SubToolsOptions.run$lambda$5((Lazy)checkTypes$delegate);
                $i$f$map = false;
                $this$mapTo$iv$iv = $this$map$iv;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    it = (CheckType)item$iv$iv;
                    collection = destination$iv$iv;
                    boolean bl = false;
                    collection.add(it.toString());
                }
                $this$map$iv = (List)destination$iv$iv;
                $i$f$encodeToString = false;
                $this$encodeToString$iv.getSerializersModule();
                object = $this$encodeToString$iv.encodeToString((SerializationStrategy)new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), (Object)value$iv);
                System.out.println(object);
            }
        }
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    private static final PluginDefinitions run$lambda$0(ConfigPluginLoader $pl) {
        return PluginDefinitions.Companion.load($pl.getPluginManager());
    }

    private static final PluginDefinitions run$lambda$1(Lazy<PluginDefinitions> $pluginDefinitions$delegate) {
        Lazy<PluginDefinitions> lazy = $pluginDefinitions$delegate;
        return (PluginDefinitions)lazy.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final List run$lambda$4(Lazy $pluginDefinitions$delegate) {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = SubToolsOptions.run$lambda$1((Lazy)$pluginDefinitions$delegate).getCheckTypeDefinition(CheckType.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            PluginDefinitions.CheckTypeDefinition checkTypeDefinition = (PluginDefinitions.CheckTypeDefinition)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getSingleton());
        }
        Iterable $this$sortedBy$iv = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        return CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */));
    }

    private static final List<CheckType> run$lambda$5(Lazy<? extends List<? extends CheckType>> $checkTypes$delegate) {
        Lazy<? extends List<? extends CheckType>> lazy = $checkTypes$delegate;
        return (List)lazy.getValue();
    }

    private static final Unit logger$lambda$8() {
        return Unit.INSTANCE;
    }

    private static final Unit jsonFormat$lambda$9(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter((Object)$this$Json, (String)"$this$Json");
        $this$Json.setUseArrayPolymorphism(true);
        $this$Json.setPrettyPrint(true);
        return Unit.INSTANCE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(SubToolsOptions.class, "subtools", "getSubtools()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(SubToolsOptions.class, "listRules", "getListRules()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(SubToolsOptions.class, "listCheckTypes", "getListCheckTypes()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        logger = KotlinLogging.INSTANCE.logger(SubToolsOptions::logger$lambda$8);
        jsonFormat = JsonKt.Json$default(null, SubToolsOptions::jsonFormat$lambda$9, (int)1, null);
    }
}

