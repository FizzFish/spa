/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.BuiltinAnalysisConfig
 *  cn.sast.api.config.BuiltinAnalysisConfig$$serializer
 *  cn.sast.api.config.MainConfigKt
 *  cn.sast.api.config.PreAnalysisConfig
 *  cn.sast.api.config.PreAnalysisConfig$$serializer
 *  cn.sast.api.config.SaConfig
 *  cn.sast.api.util.Kotlin_extKt
 *  cn.sast.common.GLB
 *  cn.sast.common.IResFile
 *  cn.sast.framework.plugin.CheckerFilterByName
 *  cn.sast.framework.plugin.CheckersConfig
 *  cn.sast.framework.plugin.CheckersConfig$$serializer
 *  cn.sast.framework.plugin.ConfigSerializable
 *  cn.sast.framework.plugin.IConfig
 *  cn.sast.framework.plugin.IOptional
 *  cn.sast.framework.plugin.PluginDefinitions
 *  cn.sast.framework.plugin.PluginDefinitions$CheckTypeDefinition
 *  cn.sast.framework.plugin.PluginDefinitions$CheckerUnitDefinition
 *  cn.sast.framework.plugin.PluginDefinitions$Definition
 *  cn.sast.framework.plugin.PluginDefinitions$ISootInitializeHandlerDefinition
 *  cn.sast.framework.plugin.SAConfiguration
 *  cn.sast.framework.plugin.SAConfiguration$$serializer
 *  cn.sast.framework.plugin.SAConfiguration$Companion
 *  cn.sast.framework.plugin.SAConfiguration$EnablesConfig
 *  cn.sast.framework.plugin.SAConfigurationKt
 *  com.charleskorn.kaml.Yaml
 *  com.feysh.corax.config.api.AIAnalysisUnit
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.api.CheckerUnit
 *  com.feysh.corax.config.api.ISootInitializeHandler
 *  com.feysh.corax.config.api.PreAnalysisUnit
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.Transient
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.LinkedHashSetSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  kotlinx.serialization.modules.SerializersModule
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.plugin;

import cn.sast.api.config.BuiltinAnalysisConfig;
import cn.sast.api.config.BuiltinAnalysisConfig$;
import cn.sast.api.config.MainConfigKt;
import cn.sast.api.config.PreAnalysisConfig;
import cn.sast.api.config.PreAnalysisConfig$;
import cn.sast.api.config.SaConfig;
import cn.sast.api.util.Kotlin_extKt;
import cn.sast.common.GLB;
import cn.sast.common.IResFile;
import cn.sast.framework.plugin.CheckerFilterByName;
import cn.sast.framework.plugin.CheckersConfig;
import cn.sast.framework.plugin.CheckersConfig$;
import cn.sast.framework.plugin.ConfigSerializable;
import cn.sast.framework.plugin.IConfig;
import cn.sast.framework.plugin.IOptional;
import cn.sast.framework.plugin.PluginDefinitions;
import cn.sast.framework.plugin.SAConfiguration;
import cn.sast.framework.plugin.SAConfiguration$;
import cn.sast.framework.plugin.SAConfigurationKt;
import com.charleskorn.kaml.Yaml;
import com.feysh.corax.config.api.AIAnalysisUnit;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.CheckerUnit;
import com.feysh.corax.config.api.ISootInitializeHandler;
import com.feysh.corax.config.api.PreAnalysisUnit;
import java.io.Closeable;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.modules.SerializersModule;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Exception performing whole class analysis ignored.
 */
@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 H2\u00020\u0001:\u0004FGHIBG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u00a2\u0006\u0004\b\r\u0010\u000eB[\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\r\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J+\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\u0004\b\u0000\u0010\u0018*\u0006\u0012\u0002\b\u00030\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0002\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u0019H\u0002J+\u0010\u001f\u001a\u0004\u0018\u0001H\u0018\"\u0004\b\u0000\u0010\u0018*\u0006\u0012\u0002\b\u00030\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0002\u00a2\u0006\u0002\u0010\u001cJ\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0018\u0010&\u001a\u00020'2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u0018\u00104\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\b\u00105\u001a\u0004\u0018\u00010\bJ\t\u00106\u001a\u00020\u0003H\u00c2\u0003J\t\u00107\u001a\u00020\u0005H\u00c2\u0003J\u001b\u00108\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007H\u00c2\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u00c2\u0003JI\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u00c6\u0001J\u0013\u0010;\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010=\u001a\u00020\u0010H\u00d6\u0001J\t\u0010>\u001a\u00020\bH\u00d6\u0001J%\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0001\u00a2\u0006\u0002\bER\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010.\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u00020\u001e0/8\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b0\u00101R&\u00102\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u00020\u001e0/8\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b3\u00101\u00a8\u0006J"}, d2={"Lcn/sast/framework/plugin/SAConfiguration;", "", "builtinAnalysisConfig", "Lcn/sast/api/config/BuiltinAnalysisConfig;", "preAnalysisConfig", "Lcn/sast/api/config/PreAnalysisConfig;", "configurations", "Ljava/util/LinkedHashMap;", "", "Ljava/util/LinkedHashSet;", "Lcn/sast/framework/plugin/ConfigSerializable;", "checkers", "Lcn/sast/framework/plugin/CheckersConfig;", "<init>", "(Lcn/sast/api/config/BuiltinAnalysisConfig;Lcn/sast/api/config/PreAnalysisConfig;Ljava/util/LinkedHashMap;Ljava/util/LinkedHashSet;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcn/sast/api/config/BuiltinAnalysisConfig;Lcn/sast/api/config/PreAnalysisConfig;Ljava/util/LinkedHashMap;Ljava/util/LinkedHashSet;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "linkedHashCode", "sort", "", "getInstance", "T", "Lcn/sast/framework/plugin/PluginDefinitions$Definition;", "clz", "Ljava/lang/Class;", "(Lcn/sast/framework/plugin/PluginDefinitions$Definition;Ljava/lang/Class;)Ljava/lang/Object;", "relateConfig", "Lcn/sast/framework/plugin/IConfig;", "get", "getCheckers", "Lcn/sast/framework/plugin/SAConfiguration$EnablesConfig;", "defs", "Lcn/sast/framework/plugin/PluginDefinitions;", "checkerFilter", "Lcn/sast/framework/plugin/CheckerFilterByName;", "filter", "Lcn/sast/api/config/SaConfig;", "serialize", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "out", "Lcn/sast/common/IResFile;", "relatedMap", "Ljava/util/IdentityHashMap;", "getRelatedMap$annotations", "()V", "disabled", "getDisabled$annotations", "supplementAndMerge", "ymlPath", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "EnablesConfig", "Compare", "Companion", "$serializer", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nSAConfiguration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SAConfiguration.kt\ncn/sast/framework/plugin/SAConfiguration\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,557:1\n126#2:558\n153#2,3:559\n126#2:645\n153#2,3:646\n1557#3:562\n1628#3,3:563\n1261#3,4:566\n1628#3,3:570\n230#3,2:573\n1628#3,3:575\n774#3:578\n865#3,2:579\n2632#3,3:581\n774#3:584\n865#3,2:585\n1611#3,9:587\n1863#3:596\n1864#3:598\n1620#3:599\n1611#3,9:600\n1863#3:609\n1864#3:611\n1620#3:612\n1611#3,9:613\n1863#3:622\n1864#3:624\n1620#3:625\n1611#3,9:626\n1863#3:635\n1864#3:637\n1620#3:638\n1279#3,2:639\n1293#3,4:641\n1557#3:649\n1628#3,3:650\n1#4:597\n1#4:610\n1#4:623\n1#4:636\n1#4:660\n487#5,7:653\n*S KotlinDebug\n*F\n+ 1 SAConfiguration.kt\ncn/sast/framework/plugin/SAConfiguration\n*L\n195#1:558\n195#1:559,3\n289#1:645\n289#1:646,3\n196#1:562\n196#1:563,3\n203#1:566,4\n204#1:570,3\n245#1:573,2\n262#1:575,3\n263#1:578\n263#1:579,2\n266#1:581,3\n270#1:584\n270#1:585,2\n274#1:587,9\n274#1:596\n274#1:598\n274#1:599\n275#1:600,9\n275#1:609\n275#1:611\n275#1:612\n276#1:613,9\n276#1:622\n276#1:624\n276#1:625\n277#1:626,9\n277#1:635\n277#1:637\n277#1:638\n288#1:639,2\n288#1:641,4\n336#1:649\n336#1:650,3\n274#1:597\n275#1:610\n276#1:623\n277#1:636\n418#1:653,7\n*E\n"})
public final class SAConfiguration {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private BuiltinAnalysisConfig builtinAnalysisConfig;
    @NotNull
    private PreAnalysisConfig preAnalysisConfig;
    @NotNull
    private LinkedHashMap<String, LinkedHashSet<ConfigSerializable>> configurations;
    @NotNull
    private LinkedHashSet<CheckersConfig> checkers;
    @NotNull
    private final IdentityHashMap<PluginDefinitions.Definition<?>, IConfig> relatedMap;
    @NotNull
    private final IdentityHashMap<PluginDefinitions.Definition<?>, IConfig> disabled;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;
    @NotNull
    private static final KLogger logger;

    public SAConfiguration(@NotNull BuiltinAnalysisConfig builtinAnalysisConfig, @NotNull PreAnalysisConfig preAnalysisConfig, @NotNull LinkedHashMap<String, LinkedHashSet<ConfigSerializable>> configurations, @NotNull LinkedHashSet<CheckersConfig> checkers) {
        Intrinsics.checkNotNullParameter((Object)builtinAnalysisConfig, (String)"builtinAnalysisConfig");
        Intrinsics.checkNotNullParameter((Object)preAnalysisConfig, (String)"preAnalysisConfig");
        Intrinsics.checkNotNullParameter(configurations, (String)"configurations");
        Intrinsics.checkNotNullParameter(checkers, (String)"checkers");
        this.builtinAnalysisConfig = builtinAnalysisConfig;
        this.preAnalysisConfig = preAnalysisConfig;
        this.configurations = configurations;
        this.checkers = checkers;
        this.relatedMap = new IdentityHashMap();
        this.disabled = new IdentityHashMap();
    }

    public /* synthetic */ SAConfiguration(BuiltinAnalysisConfig builtinAnalysisConfig, PreAnalysisConfig preAnalysisConfig, LinkedHashMap linkedHashMap, LinkedHashSet linkedHashSet, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            builtinAnalysisConfig = new BuiltinAnalysisConfig(null, null, 0, 0, 15, null);
        }
        if ((n & 2) != 0) {
            preAnalysisConfig = new PreAnalysisConfig(0, 0, 0, null, 0, 31, null);
        }
        if ((n & 4) != 0) {
            linkedHashMap = new LinkedHashMap();
        }
        if ((n & 8) != 0) {
            linkedHashSet = new LinkedHashSet();
        }
        this(builtinAnalysisConfig, preAnalysisConfig, linkedHashMap, linkedHashSet);
    }

    private final int linkedHashCode() {
        CheckersConfig it;
        Collection collection;
        Map.Entry item$iv$iv;
        Object $this$mapTo$iv$iv;
        List hash = new ArrayList();
        Collection collection2 = hash;
        Object $this$map$iv = this.configurations;
        boolean $i$f$map = false;
        Map map = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.size());
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry = item$iv$iv = iterator2.next();
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(CollectionsKt.toList((Iterable)((Iterable)it.getValue())));
        }
        collection2.add(((Object)((List)destination$iv$iv)).hashCode());
        collection2 = hash;
        $this$map$iv = CollectionsKt.toList((Iterable)this.checkers);
        $i$f$map = false;
        $this$mapTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        $i$f$mapTo = false;
        iterator2 = $this$mapTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            item$iv$iv = iterator2.next();
            it = (CheckersConfig)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(CollectionsKt.toList((Iterable)it.getCheckTypes()));
        }
        collection2.add(((Object)((List)destination$iv$iv)).hashCode());
        return ((Object)hash).hashCode();
    }

    /*
     * WARNING - void declaration
     */
    public final boolean sort() {
        void $this$mapTo$iv;
        CheckersConfig checkersConfig;
        Collection destination$iv;
        Iterable $this$associateTo$iv;
        int old = this.linkedHashCode();
        Iterable iterable = CollectionsKt.sortedWith((Iterable)MapsKt.toList((Map)this.configurations), (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */));
        Map map = new LinkedHashMap();
        SAConfiguration sAConfiguration = this;
        boolean $i$f$associateTo = false;
        for (Object element$iv : $this$associateTo$iv) {
            checkersConfig = destination$iv;
            Pair it = (Pair)element$iv;
            boolean bl = false;
            it = TuplesKt.to((Object)it.getFirst(), (Object)SAConfigurationKt.access$getSort((LinkedHashSet)((LinkedHashSet)it.getSecond())));
            checkersConfig.put(it.getFirst(), it.getSecond());
        }
        sAConfiguration.configurations = (LinkedHashMap)((Object)destination$iv);
        $this$associateTo$iv = CollectionsKt.sortedWith((Iterable)CollectionsKt.toList((Iterable)this.checkers), (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */));
        destination$iv = new LinkedHashSet();
        sAConfiguration = this;
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            checkersConfig = (CheckersConfig)item$iv;
            Collection collection = destination$iv;
            boolean bl = false;
            collection.add(it.sort());
        }
        sAConfiguration.checkers = (LinkedHashSet)((Object)map);
        return this.linkedHashCode() != old;
    }

    private final <T> T getInstance(PluginDefinitions.Definition<?> $this$getInstance, Class<T> clz) {
        if (clz.isInstance($this$getInstance.getSingleton())) {
            return (T)$this$getInstance.getSingleton();
        }
        return null;
    }

    private final IConfig relateConfig(PluginDefinitions.Definition<?> $this$relateConfig) {
        IConfig iConfig = (IConfig)this.relatedMap.get($this$relateConfig);
        if (iConfig == null) {
            throw new IllegalStateException(($this$relateConfig + " not relate to a config").toString());
        }
        return iConfig;
    }

    private final <T> T get(PluginDefinitions.Definition<?> $this$get, Class<T> clz) {
        IConfig config = this.relateConfig($this$get);
        IOptional iOptional = config instanceof IOptional ? (IOptional)config : null;
        boolean bl = iOptional != null ? !iOptional.getEnable() : false;
        if (bl) {
            ((Map)this.disabled).put($this$get, config);
            return null;
        }
        if ($this$get instanceof PluginDefinitions.CheckTypeDefinition) {
            Object element$iv2;
            block4: {
                CheckersConfig checkerMatches = new CheckersConfig(((PluginDefinitions.CheckTypeDefinition)$this$get).getSingleton().getChecker());
                Iterable $this$first$iv = this.checkers;
                boolean $i$f$first = false;
                for (Object element$iv2 : $this$first$iv) {
                    CheckersConfig it = (CheckersConfig)element$iv2;
                    boolean bl2 = false;
                    if (!Intrinsics.areEqual((Object)it.getName(), (Object)checkerMatches.getName())) continue;
                    break block4;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            if (!((CheckersConfig)element$iv2).getEnable()) {
                return null;
            }
        }
        return (T)this.getInstance($this$get, clz);
    }

    /*
     * WARNING - void declaration
     */
    private final EnablesConfig getCheckers(PluginDefinitions defs, CheckerFilterByName checkerFilter) {
        void $this$mapTo$iv$iv;
        PreAnalysisUnit it$iv$iv;
        boolean bl;
        Iterable $this$mapNotNullTo$iv$iv;
        Iterable $this$mapNotNull$iv;
        Iterator destination$iv$iv;
        List notExistsCheckerNames;
        Object element$iv$iv;
        Object object;
        Set oldNames;
        EnablesConfig res = new EnablesConfig(null, null, null, null, null, 31, null);
        LinkedHashSet checkerUnits = defs.getCheckerUnitDefinition(CheckerUnit.class);
        LinkedHashSet sootInitializeHandlers = defs.getISootInitializeHandlerDefinition(ISootInitializeHandler.class);
        LinkedHashSet checkTypes = defs.getCheckTypeDefinition(CheckType.class);
        Set enableCheckers = null;
        CheckerFilterByName checkerFilterByName = checkerFilter;
        Set set = enableCheckers = checkerFilterByName != null ? checkerFilterByName.getEnables() : null;
        if (checkerFilter != null) {
            void $this$filterTo$iv$iv;
            Iterable element$iv2;
            Iterator $this$filterTo$iv$iv2;
            void destination$iv;
            void $this$mapTo$iv;
            enableCheckers = checkerFilter.getEnables();
            oldNames = checkerFilter.getRenameMap().keySet();
            Iterable iterable = checkTypes;
            Collection collection = new LinkedHashSet();
            boolean $i$f$mapTo = false;
            for (Object item$iv : $this$mapTo$iv) {
                void it;
                PluginDefinitions.CheckTypeDefinition checkTypeDefinition = (PluginDefinitions.CheckTypeDefinition)item$iv;
                object = destination$iv;
                boolean bl2 = false;
                object.add(it.getDefaultConfig().getCheckType());
            }
            Set existsCheckerNames = (Set)destination$iv;
            Iterable $this$filter$iv = enableCheckers;
            boolean $i$f$filter = false;
            Iterable iterable2 = $this$filter$iv;
            Collection destination$iv$iv2 = new ArrayList();
            boolean $i$f$filterTo = false;
            Iterator bl2 = $this$filterTo$iv$iv2.iterator();
            while (bl2.hasNext()) {
                element$iv$iv = bl2.next();
                String it = (String)element$iv$iv;
                boolean bl3 = false;
                if (!(!existsCheckerNames.contains(it) && !oldNames.contains(it))) continue;
                destination$iv$iv2.add(element$iv$iv);
            }
            notExistsCheckerNames = (List)destination$iv$iv2;
            if (!((Collection)notExistsCheckerNames).isEmpty()) {
                boolean bl4;
                block15: {
                    logger.warn(() -> SAConfiguration.getCheckers$lambda$9(notExistsCheckerNames));
                    Iterable $this$none$iv = enableCheckers;
                    boolean $i$f$none = false;
                    if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                        bl4 = true;
                    } else {
                        for (Iterable element$iv2 : $this$none$iv) {
                            String it = (String)((Object)element$iv2);
                            boolean bl5 = false;
                            if (!existsCheckerNames.contains(it)) continue;
                            bl4 = false;
                            break block15;
                        }
                        bl4 = true;
                    }
                }
                if (bl4) {
                    throw new IllegalStateException("No checker type are enabled".toString());
                }
            }
            Iterable $this$filter$iv2 = existsCheckerNames;
            boolean $i$f$filter2 = false;
            element$iv2 = $this$filter$iv2;
            destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo2 = false;
            for (Object element$iv$iv2 : $this$filterTo$iv$iv) {
                String it = (String)element$iv$iv2;
                boolean bl6 = false;
                if (!(!enableCheckers.contains(it))) continue;
                destination$iv$iv.add(element$iv$iv2);
            }
            List disabledCheckers = (List)((Object)destination$iv$iv);
            logger.debug(() -> SAConfiguration.getCheckers$lambda$12(disabledCheckers));
        }
        oldNames = checkerUnits;
        object = res.getPreAnalysisUnits();
        boolean $i$f$mapNotNull = false;
        notExistsCheckerNames = $this$mapNotNull$iv;
        Collection destination$iv$iv3 = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        Iterable $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        destination$iv$iv = $this$forEach$iv$iv$iv.iterator();
        while (destination$iv$iv.hasNext()) {
            Object element$iv$iv$iv;
            element$iv$iv = element$iv$iv$iv = destination$iv$iv.next();
            boolean bl7 = false;
            PluginDefinitions.CheckerUnitDefinition unit = (PluginDefinitions.CheckerUnitDefinition)element$iv$iv;
            boolean bl8 = false;
            if ((PreAnalysisUnit)this.get((PluginDefinitions.Definition)unit, PreAnalysisUnit.class) == null) continue;
            bl = false;
            destination$iv$iv3.add(it$iv$iv);
        }
        object.addAll((List)destination$iv$iv3);
        $this$mapNotNull$iv = checkerUnits;
        object = res.getAiAnalysisUnits();
        $i$f$mapNotNull = false;
        $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
        destination$iv$iv3 = new ArrayList();
        $i$f$mapNotNullTo = false;
        $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        $i$f$forEach = false;
        destination$iv$iv = $this$forEach$iv$iv$iv.iterator();
        while (destination$iv$iv.hasNext()) {
            Object element$iv$iv$iv;
            element$iv$iv = element$iv$iv$iv = destination$iv$iv.next();
            boolean bl9 = false;
            PluginDefinitions.CheckerUnitDefinition unit = (PluginDefinitions.CheckerUnitDefinition)element$iv$iv;
            boolean bl10 = false;
            if ((AIAnalysisUnit)this.get((PluginDefinitions.Definition)unit, AIAnalysisUnit.class) == null) continue;
            bl = false;
            destination$iv$iv3.add(it$iv$iv);
        }
        object.addAll((List)destination$iv$iv3);
        $this$mapNotNull$iv = sootInitializeHandlers;
        object = res.getSootConfig();
        $i$f$mapNotNull = false;
        $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
        destination$iv$iv3 = new ArrayList();
        $i$f$mapNotNullTo = false;
        $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        $i$f$forEach = false;
        destination$iv$iv = $this$forEach$iv$iv$iv.iterator();
        while (destination$iv$iv.hasNext()) {
            Object element$iv$iv$iv;
            element$iv$iv = element$iv$iv$iv = destination$iv$iv.next();
            boolean bl11 = false;
            PluginDefinitions.ISootInitializeHandlerDefinition unit = (PluginDefinitions.ISootInitializeHandlerDefinition)element$iv$iv;
            boolean bl12 = false;
            if ((ISootInitializeHandler)this.get((PluginDefinitions.Definition)unit, ISootInitializeHandler.class) == null) continue;
            bl = false;
            destination$iv$iv3.add(it$iv$iv);
        }
        object.addAll((List)destination$iv$iv3);
        $this$mapNotNull$iv = checkTypes;
        object = res.getCheckTypes();
        $i$f$mapNotNull = false;
        $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
        destination$iv$iv3 = new ArrayList();
        $i$f$mapNotNullTo = false;
        $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        $i$f$forEach = false;
        destination$iv$iv = $this$forEach$iv$iv$iv.iterator();
        while (destination$iv$iv.hasNext()) {
            Object element$iv$iv$iv;
            element$iv$iv = element$iv$iv$iv = destination$iv$iv.next();
            boolean bl13 = false;
            PluginDefinitions.CheckTypeDefinition unit = (PluginDefinitions.CheckTypeDefinition)element$iv$iv;
            boolean bl14 = false;
            if ((enableCheckers != null ? (enableCheckers.contains(unit.getDefaultConfig().getCheckType()) ? (CheckType)this.getInstance((PluginDefinitions.Definition)unit, CheckType.class) : null) : (CheckType)this.get((PluginDefinitions.Definition)unit, CheckType.class)) == null) continue;
            it$iv$iv = it$iv$iv;
            bl = false;
            destination$iv$iv3.add(it$iv$iv);
        }
        object.addAll((List)destination$iv$iv3);
        Iterable $this$associateWith$iv = checkerUnits;
        boolean $i$f$associateWith = false;
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv, (int)10)), (int)16));
        Object $this$associateWithTo$iv$iv = $this$associateWith$iv;
        boolean $i$f$associateWithTo = false;
        Iterator $i$f$forEach2 = $this$associateWithTo$iv$iv.iterator();
        while ($i$f$forEach2.hasNext()) {
            void unit;
            Object element$iv$iv3 = $i$f$forEach2.next();
            PluginDefinitions.CheckerUnitDefinition element$iv$iv$iv = (PluginDefinitions.CheckerUnitDefinition)element$iv$iv3;
            Object t = element$iv$iv3;
            object = result$iv;
            boolean bl15 = false;
            CheckerUnit checkerUnit = (CheckerUnit)this.get((PluginDefinitions.Definition)unit, CheckerUnit.class);
            object.put(t, checkerUnit);
        }
        Map def2checkerUnit = Kotlin_extKt.nonNullValue((Map)result$iv);
        Map map = res.getDef2config();
        Map $this$map$iv = def2checkerUnit;
        boolean $i$f$map = false;
        $this$associateWithTo$iv$iv = $this$map$iv;
        Collection destination$iv$iv4 = new ArrayList($this$map$iv.size());
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry item$iv$iv;
            Map.Entry entry = item$iv$iv = iterator2.next();
            object = destination$iv$iv4;
            boolean bl16 = false;
            PluginDefinitions.CheckerUnitDefinition def = (PluginDefinitions.CheckerUnitDefinition)entry.getKey();
            CheckerUnit unit = (CheckerUnit)entry.getValue();
            object.add(TuplesKt.to((Object)unit, (Object)this.relateConfig((PluginDefinitions.Definition)def)));
        }
        Iterable iterable = (List)destination$iv$iv4;
        MapsKt.putAll((Map)map, (Iterable)iterable);
        return res;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final SaConfig filter(@NotNull PluginDefinitions defs, @Nullable CheckerFilterByName checkerFilter) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter((Object)defs, (String)"defs");
        EnablesConfig enableDefinitions = this.getCheckers(defs, checkerFilter);
        logger.info(() -> SAConfiguration.filter$lambda$19(enableDefinitions, defs));
        logger.info(() -> SAConfiguration.filter$lambda$20(enableDefinitions, defs));
        logger.info(() -> SAConfiguration.filter$lambda$21(enableDefinitions, defs));
        logger.info(() -> SAConfiguration.filter$lambda$22(enableDefinitions, defs));
        ISootInitializeHandler sootConfigMerge2 = enableDefinitions.getSootConfig().size() == 1 ? (ISootInitializeHandler)CollectionsKt.first((List)enableDefinitions.getSootConfig()) : (ISootInitializeHandler)new /* Unavailable Anonymous Inner Class!! */;
        Iterable iterable = defs.getCheckTypeDefinition(CheckType.class);
        GLB gLB = GLB.INSTANCE;
        boolean $i$f$map = false;
        void var7_8 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            PluginDefinitions.CheckTypeDefinition checkTypeDefinition = (PluginDefinitions.CheckTypeDefinition)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getSingleton());
        }
        gLB.plusAssign((Collection)((List)destination$iv$iv));
        return new SaConfig(this.builtinAnalysisConfig, this.preAnalysisConfig, (Set)ExtensionsKt.toPersistentSet((Iterable)CollectionsKt.plus((Collection)enableDefinitions.getPreAnalysisUnits(), (Iterable)enableDefinitions.getAiAnalysisUnits())), sootConfigMerge2, CollectionsKt.toSet((Iterable)enableDefinitions.getCheckTypes()));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void serialize(@NotNull SerializersModule serializersModule, @NotNull IResFile out) {
        Intrinsics.checkNotNullParameter((Object)serializersModule, (String)"serializersModule");
        Intrinsics.checkNotNullParameter((Object)out, (String)"out");
        Yaml yml = new Yaml(serializersModule, MainConfigKt.getYamlConfiguration());
        try {
            OpenOption[] openOptionArray = new OpenOption[]{};
            OutputStream outputStream = Files.newOutputStream(out.getPath(), Arrays.copyOf(openOptionArray, openOptionArray.length));
            Intrinsics.checkNotNullExpressionValue((Object)outputStream, (String)"newOutputStream(...)");
            Closeable closeable = outputStream;
            Throwable throwable = null;
            try {
                OutputStream it = (OutputStream)closeable;
                boolean bl = false;
                Yaml.encodeToStream$default((Yaml)yml, (SerializationStrategy)((SerializationStrategy)Companion.serializer()), (Object)this, (OutputStream)it, null, (int)8, null);
                Unit unit = Unit.INSTANCE;
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
            }
        }
        catch (Exception e) {
            Files.delete(out.getPath());
            throw e;
        }
    }

    @Transient
    private static /* synthetic */ void getRelatedMap$annotations() {
    }

    @Transient
    private static /* synthetic */ void getDisabled$annotations() {
    }

    public final boolean supplementAndMerge(@NotNull PluginDefinitions defs, @Nullable String ymlPath) {
        int hashNew;
        Intrinsics.checkNotNullParameter((Object)defs, (String)"defs");
        int hashOld = this.hashCode();
        SAConfiguration sAConfiguration = Companion.getDefaultConfig(defs);
        Lazy head = LazyKt.lazy(SAConfiguration::supplementAndMerge$lambda$26);
        new /* Unavailable Anonymous Inner Class!! */.compare(sAConfiguration);
        new /* Unavailable Anonymous Inner Class!! */.compare(this);
        if (head.isInitialized()) {
            logger.warn(SAConfiguration::supplementAndMerge$lambda$30);
        }
        return (hashNew = this.hashCode()) != hashOld;
    }

    private final BuiltinAnalysisConfig component1() {
        return this.builtinAnalysisConfig;
    }

    private final PreAnalysisConfig component2() {
        return this.preAnalysisConfig;
    }

    private final LinkedHashMap<String, LinkedHashSet<ConfigSerializable>> component3() {
        return this.configurations;
    }

    private final LinkedHashSet<CheckersConfig> component4() {
        return this.checkers;
    }

    @NotNull
    public final SAConfiguration copy(@NotNull BuiltinAnalysisConfig builtinAnalysisConfig, @NotNull PreAnalysisConfig preAnalysisConfig, @NotNull LinkedHashMap<String, LinkedHashSet<ConfigSerializable>> configurations, @NotNull LinkedHashSet<CheckersConfig> checkers) {
        Intrinsics.checkNotNullParameter((Object)builtinAnalysisConfig, (String)"builtinAnalysisConfig");
        Intrinsics.checkNotNullParameter((Object)preAnalysisConfig, (String)"preAnalysisConfig");
        Intrinsics.checkNotNullParameter(configurations, (String)"configurations");
        Intrinsics.checkNotNullParameter(checkers, (String)"checkers");
        return new SAConfiguration(builtinAnalysisConfig, preAnalysisConfig, configurations, checkers);
    }

    public static /* synthetic */ SAConfiguration copy$default(SAConfiguration sAConfiguration, BuiltinAnalysisConfig builtinAnalysisConfig, PreAnalysisConfig preAnalysisConfig, LinkedHashMap linkedHashMap, LinkedHashSet linkedHashSet, int n, Object object) {
        if ((n & 1) != 0) {
            builtinAnalysisConfig = sAConfiguration.builtinAnalysisConfig;
        }
        if ((n & 2) != 0) {
            preAnalysisConfig = sAConfiguration.preAnalysisConfig;
        }
        if ((n & 4) != 0) {
            linkedHashMap = sAConfiguration.configurations;
        }
        if ((n & 8) != 0) {
            linkedHashSet = sAConfiguration.checkers;
        }
        return sAConfiguration.copy(builtinAnalysisConfig, preAnalysisConfig, linkedHashMap, linkedHashSet);
    }

    @NotNull
    public String toString() {
        return "SAConfiguration(builtinAnalysisConfig=" + this.builtinAnalysisConfig + ", preAnalysisConfig=" + this.preAnalysisConfig + ", configurations=" + this.configurations + ", checkers=" + this.checkers + ")";
    }

    public int hashCode() {
        int result = this.builtinAnalysisConfig.hashCode();
        result = result * 31 + this.preAnalysisConfig.hashCode();
        result = result * 31 + this.configurations.hashCode();
        result = result * 31 + this.checkers.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SAConfiguration)) {
            return false;
        }
        SAConfiguration sAConfiguration = (SAConfiguration)other;
        if (!Intrinsics.areEqual((Object)this.builtinAnalysisConfig, (Object)sAConfiguration.builtinAnalysisConfig)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.preAnalysisConfig, (Object)sAConfiguration.preAnalysisConfig)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.configurations, (Object)sAConfiguration.configurations)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.checkers, (Object)sAConfiguration.checkers);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(SAConfiguration self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArray = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) ? true : !Intrinsics.areEqual((Object)self.builtinAnalysisConfig, (Object)new BuiltinAnalysisConfig(null, null, 0, 0, 15, null))) {
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)BuiltinAnalysisConfig$.serializer.INSTANCE, (Object)self.builtinAnalysisConfig);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : !Intrinsics.areEqual((Object)self.preAnalysisConfig, (Object)new PreAnalysisConfig(0, 0, 0, null, 0, 31, null))) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)PreAnalysisConfig$.serializer.INSTANCE, (Object)self.preAnalysisConfig);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : !Intrinsics.areEqual((Object)self.configurations, new LinkedHashMap())) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)kSerializerArray[2], (Object)self.configurations);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : !Intrinsics.areEqual((Object)self.checkers, new LinkedHashSet())) {
            output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy)kSerializerArray[3], (Object)self.checkers);
        }
    }

    public /* synthetic */ SAConfiguration(int seen0, BuiltinAnalysisConfig builtinAnalysisConfig, PreAnalysisConfig preAnalysisConfig, LinkedHashMap configurations, LinkedHashSet checkers, SerializationConstructorMarker serializationConstructorMarker) {
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)0, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.builtinAnalysisConfig = (seen0 & 1) == 0 ? new BuiltinAnalysisConfig(null, null, 0, 0, 15, null) : builtinAnalysisConfig;
        this.preAnalysisConfig = (seen0 & 2) == 0 ? new PreAnalysisConfig(0, 0, 0, null, 0, 31, null) : preAnalysisConfig;
        this.configurations = (seen0 & 4) == 0 ? new LinkedHashMap() : configurations;
        this.checkers = (seen0 & 8) == 0 ? new LinkedHashSet() : checkers;
        this.relatedMap = new IdentityHashMap();
        this.disabled = new IdentityHashMap();
    }

    private static final Object getCheckers$lambda$9(List $notExistsCheckerNames) {
        return "\nThese check types named " + $notExistsCheckerNames + " cannot be found in analysis-config\n";
    }

    private static final Object getCheckers$lambda$12(List $disabledCheckers) {
        return "\nThese check types " + $disabledCheckers + " are not enabled\n";
    }

    private static final Object filter$lambda$19(EnablesConfig $enableDefinitions, PluginDefinitions $defs) {
        return "Num of effective PreAnalysisUnit is " + $enableDefinitions.getPreAnalysisUnits().size() + "/" + $defs.getPreAnalysisUnit(PreAnalysisUnit.class).size();
    }

    private static final Object filter$lambda$20(EnablesConfig $enableDefinitions, PluginDefinitions $defs) {
        return "Num of effective AIAnalysisUnit is " + $enableDefinitions.getAiAnalysisUnits().size() + "/" + $defs.getAIAnalysisUnit(AIAnalysisUnit.class).size();
    }

    private static final Object filter$lambda$21(EnablesConfig $enableDefinitions, PluginDefinitions $defs) {
        return "Num of effective ISootInitializeHandler is " + $enableDefinitions.getSootConfig().size() + "/" + $defs.getISootInitializeHandlerDefinition(ISootInitializeHandler.class).size();
    }

    private static final Object filter$lambda$22(EnablesConfig $enableDefinitions, PluginDefinitions $defs) {
        return "Num of effective CheckType is " + $enableDefinitions.getCheckTypes().size() + "/" + $defs.getCheckTypeDefinition(CheckType.class).size();
    }

    private static final Object supplementAndMerge$lambda$26$lambda$25() {
        return "/--------------------- config information view ---------------------";
    }

    private static final Unit supplementAndMerge$lambda$26() {
        logger.warn(SAConfiguration::supplementAndMerge$lambda$26$lambda$25);
        return Unit.INSTANCE;
    }

    private static final Map<PluginDefinitions.Definition<?>, IConfig> supplementAndMerge$getAndRelate(PluginDefinitions $defs, SAConfiguration this$0, IConfig self, IConfig thatConfig) {
        Map $this$filterKeys$iv = $defs.getDefaultConfigs();
        boolean $i$f$filterKeys = false;
        LinkedHashMap result$iv = new LinkedHashMap();
        for (Map.Entry entry$iv : $this$filterKeys$iv.entrySet()) {
            PluginDefinitions.Definition it = (PluginDefinitions.Definition)entry$iv.getKey();
            boolean bl = false;
            if (!(it.getDefaultConfig() == thatConfig)) continue;
            result$iv.put(entry$iv.getKey(), entry$iv.getValue());
        }
        Map definitions = result$iv;
        if (!(!definitions.isEmpty())) {
            boolean $i$a$-check-SAConfiguration$supplementAndMerge$getAndRelate$32 = false;
            String $i$a$-check-SAConfiguration$supplementAndMerge$getAndRelate$32 = "internal error. empty definition. config: " + self + " and " + thatConfig;
            throw new IllegalStateException($i$a$-check-SAConfiguration$supplementAndMerge$getAndRelate$32.toString());
        }
        if (!(definitions.size() == 1)) {
            boolean bl = false;
            String string = "internal error. multiple definitions: " + definitions + ". config: " + self + " and " + thatConfig;
            throw new IllegalStateException(string.toString());
        }
        ((Map)this$0.relatedMap).put(CollectionsKt.first((Iterable)definitions.keySet()), self);
        return definitions;
    }

    private static final Object supplementAndMerge$lambda$30() {
        return "\\--------------------- config information view ---------------------";
    }

    private static final Unit logger$lambda$31() {
        return Unit.INSTANCE;
    }

    public SAConfiguration() {
        this(null, null, null, null, 15, null);
    }

    public static final /* synthetic */ LinkedHashMap access$getConfigurations$p(SAConfiguration $this) {
        return $this.configurations;
    }

    public static final /* synthetic */ LinkedHashSet access$getCheckers$p(SAConfiguration $this) {
        return $this.checkers;
    }

    public static final /* synthetic */ Map access$supplementAndMerge$getAndRelate(PluginDefinitions $defs, SAConfiguration this$0, IConfig self, IConfig thatConfig) {
        return SAConfiguration.supplementAndMerge$getAndRelate((PluginDefinitions)$defs, (SAConfiguration)this$0, (IConfig)self, (IConfig)thatConfig);
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{null, null, new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)new LinkedHashSetSerializer(ConfigSerializable.Companion.serializer())), new LinkedHashSetSerializer((KSerializer)CheckersConfig$.serializer.INSTANCE)};
        $childSerializers = kSerializerArray;
        logger = KotlinLogging.INSTANCE.logger(SAConfiguration::logger$lambda$31);
    }
}

