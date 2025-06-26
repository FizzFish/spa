/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.Resource
 *  cn.sast.framework.plugin.IConfig
 *  cn.sast.framework.plugin.PluginDefinitions
 *  cn.sast.framework.plugin.PluginDefinitions$CheckTypeDefinition
 *  cn.sast.framework.plugin.PluginDefinitions$CheckerUnitDefinition
 *  cn.sast.framework.plugin.PluginDefinitions$Companion
 *  cn.sast.framework.plugin.PluginDefinitions$Definition
 *  cn.sast.framework.plugin.PluginDefinitions$ISootInitializeHandlerDefinition
 *  com.feysh.corax.config.api.AIAnalysisUnit
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.api.CheckerUnit
 *  com.feysh.corax.config.api.ISootInitializeHandler
 *  com.feysh.corax.config.api.PreAnalysisUnit
 *  com.feysh.corax.config.api.utils.UtilsKt
 *  com.feysh.corax.config.builtin.checkers.DeadCodeChecker$DeadCode
 *  com.feysh.corax.config.builtin.checkers.DeadCodeChecker$UnreachableBranch
 *  com.feysh.corax.config.builtin.checkers.DeadStoreChecker$DeadLocalStore
 *  com.feysh.corax.config.builtin.checkers.DefineUnusedChecker$UnusedMethod
 *  com.feysh.corax.config.builtin.checkers.DefineUnusedChecker$UrfUnreadField
 *  com.feysh.corax.config.builtin.soot.DefaultSootConfiguration
 *  com.feysh.corax.config.builtin.soot.EmptySootConfiguration
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.pf4j.PluginWrapper
 */
package cn.sast.framework.plugin;

import cn.sast.common.Resource;
import cn.sast.framework.plugin.IConfig;
import cn.sast.framework.plugin.PluginDefinitions;
import com.feysh.corax.config.api.AIAnalysisUnit;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.CheckerUnit;
import com.feysh.corax.config.api.ISootInitializeHandler;
import com.feysh.corax.config.api.PreAnalysisUnit;
import com.feysh.corax.config.api.utils.UtilsKt;
import com.feysh.corax.config.builtin.checkers.DeadCodeChecker;
import com.feysh.corax.config.builtin.checkers.DeadStoreChecker;
import com.feysh.corax.config.builtin.checkers.DefineUnusedChecker;
import com.feysh.corax.config.builtin.soot.DefaultSootConfiguration;
import com.feysh.corax.config.builtin.soot.EmptySootConfiguration;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.pf4j.PluginWrapper;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0005()*+,B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J+\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0005j\b\u0012\u0004\u0012\u00020\u000e`\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0007\u00a2\u0006\u0002\b\u0012J+\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0005j\b\u0012\u0004\u0012\u00020\u0013`\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010H\u0007\u00a2\u0006\u0002\b\u0015J+\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0005j\b\u0012\u0004\u0012\u00020\u0016`\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00170\u0010H\u0007\u00a2\u0006\u0002\b\u0018J+\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0005j\b\u0012\u0004\u0012\u00020\u0016`\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010H\u0007\u00a2\u0006\u0002\b\u001aJ+\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0005j\b\u0012\u0004\u0012\u00020\u0016`\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0010H\u0007\u00a2\u0006\u0002\b\u001cJ\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u001f0\u001eJ(\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\u00102\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002J&\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\u00102\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002J&\u0010 \u001a\u00020!2\u0006\u0010&\u001a\u00020'2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\u00102\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u0010R&\u0010\u0004\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006`\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R2\u0010\b\u001a&\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\tj\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006`\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R2\u0010\f\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\n0\tj\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2={"Lcn/sast/framework/plugin/PluginDefinitions;", "", "<init>", "()V", "definitions", "Ljava/util/LinkedHashSet;", "Lcn/sast/framework/plugin/PluginDefinitions$Definition;", "Lkotlin/collections/LinkedHashSet;", "identifiers", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "identifiersReverse", "get", "Lcn/sast/framework/plugin/PluginDefinitions$ISootInitializeHandlerDefinition;", "clz", "Ljava/lang/Class;", "Lcom/feysh/corax/config/api/ISootInitializeHandler;", "getISootInitializeHandlerDefinition", "Lcn/sast/framework/plugin/PluginDefinitions$CheckTypeDefinition;", "Lcom/feysh/corax/config/api/CheckType;", "getCheckTypeDefinition", "Lcn/sast/framework/plugin/PluginDefinitions$CheckerUnitDefinition;", "Lcom/feysh/corax/config/api/CheckerUnit;", "getCheckerUnitDefinition", "Lcom/feysh/corax/config/api/PreAnalysisUnit;", "getPreAnalysisUnit", "Lcom/feysh/corax/config/api/AIAnalysisUnit;", "getAIAnalysisUnit", "getDefaultConfigs", "", "Lcn/sast/framework/plugin/IConfig;", "register", "", "prefix", "type", "definition", "singleton", "plugin", "Lorg/pf4j/PluginWrapper;", "Definition", "CheckerUnitDefinition", "ISootInitializeHandlerDefinition", "CheckTypeDefinition", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nPluginDefinitions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginDefinitions.kt\ncn/sast/framework/plugin/PluginDefinitions\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,302:1\n817#2,2:303\n817#2,2:305\n817#2,2:307\n865#2,2:309\n865#2,2:311\n1279#2,2:313\n1293#2,4:315\n1#3:319\n*S KotlinDebug\n*F\n+ 1 PluginDefinitions.kt\ncn/sast/framework/plugin/PluginDefinitions\n*L\n152#1:303,2\n157#1:305,2\n162#1:307,2\n168#1:309,2\n174#1:311,2\n178#1:313,2\n178#1:315,4\n*E\n"})
public final class PluginDefinitions {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private LinkedHashSet<Definition<?>> definitions = new LinkedHashSet();
    @NotNull
    private LinkedHashMap<String, Definition<?>> identifiers = new LinkedHashMap();
    @NotNull
    private LinkedHashMap<Definition<?>, String> identifiersReverse = new LinkedHashMap();
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(PluginDefinitions::logger$lambda$5);
    @NotNull
    private static final Set<String> commercialKeywords;

    public PluginDefinitions() {
        this.register("builtin", ISootInitializeHandler.class, DefaultSootConfiguration.class);
        this.register("builtin", ISootInitializeHandler.class, EmptySootConfiguration.class);
        this.register("builtin", CheckType.class, (Object)DefineUnusedChecker.UrfUnreadField.INSTANCE);
        this.register("builtin", CheckType.class, (Object)DefineUnusedChecker.UnusedMethod.INSTANCE);
        this.register("builtin", CheckType.class, (Object)DeadCodeChecker.DeadCode.INSTANCE);
        this.register("builtin", CheckType.class, (Object)DeadCodeChecker.UnreachableBranch.INSTANCE);
        this.register("builtin", CheckType.class, (Object)DeadStoreChecker.DeadLocalStore.INSTANCE);
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="getISootInitializeHandlerDefinition")
    @NotNull
    public final LinkedHashSet<ISootInitializeHandlerDefinition> getISootInitializeHandlerDefinition(@NotNull Class<ISootInitializeHandler> clz) {
        void var3_3;
        void $this$filterIsInstanceTo$iv;
        Intrinsics.checkNotNullParameter(clz, (String)"clz");
        Iterable iterable = this.definitions;
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv : $this$filterIsInstanceTo$iv) {
            if (!(element$iv instanceof ISootInitializeHandlerDefinition)) continue;
            destination$iv.add(element$iv);
        }
        return (LinkedHashSet)var3_3;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="getCheckTypeDefinition")
    @NotNull
    public final LinkedHashSet<CheckTypeDefinition> getCheckTypeDefinition(@NotNull Class<CheckType> clz) {
        void var3_3;
        void $this$filterIsInstanceTo$iv;
        Intrinsics.checkNotNullParameter(clz, (String)"clz");
        Iterable iterable = this.definitions;
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv : $this$filterIsInstanceTo$iv) {
            if (!(element$iv instanceof CheckTypeDefinition)) continue;
            destination$iv.add(element$iv);
        }
        return (LinkedHashSet)var3_3;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="getCheckerUnitDefinition")
    @NotNull
    public final LinkedHashSet<CheckerUnitDefinition> getCheckerUnitDefinition(@NotNull Class<CheckerUnit> clz) {
        void var3_3;
        void $this$filterIsInstanceTo$iv;
        Intrinsics.checkNotNullParameter(clz, (String)"clz");
        Iterable iterable = this.definitions;
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv : $this$filterIsInstanceTo$iv) {
            if (!(element$iv instanceof CheckerUnitDefinition)) continue;
            destination$iv.add(element$iv);
        }
        return (LinkedHashSet)var3_3;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="getPreAnalysisUnit")
    @NotNull
    public final LinkedHashSet<CheckerUnitDefinition> getPreAnalysisUnit(@NotNull Class<PreAnalysisUnit> clz) {
        void var3_3;
        void $this$filterTo$iv;
        Intrinsics.checkNotNullParameter(clz, (String)"clz");
        Iterable iterable = this.getCheckerUnitDefinition(CheckerUnit.class);
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$filterTo = false;
        for (Object element$iv : $this$filterTo$iv) {
            CheckerUnitDefinition it = (CheckerUnitDefinition)element$iv;
            boolean bl = false;
            if (!Intrinsics.areEqual((Object)it.getType(), clz)) continue;
            destination$iv.add(element$iv);
        }
        return (LinkedHashSet)var3_3;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="getAIAnalysisUnit")
    @NotNull
    public final LinkedHashSet<CheckerUnitDefinition> getAIAnalysisUnit(@NotNull Class<AIAnalysisUnit> clz) {
        void var3_3;
        void $this$filterTo$iv;
        Intrinsics.checkNotNullParameter(clz, (String)"clz");
        Iterable iterable = this.getCheckerUnitDefinition(CheckerUnit.class);
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$filterTo = false;
        for (Object element$iv : $this$filterTo$iv) {
            CheckerUnitDefinition it = (CheckerUnitDefinition)element$iv;
            boolean bl = false;
            if (!Intrinsics.areEqual((Object)it.getType(), clz)) continue;
            destination$iv.add(element$iv);
        }
        return (LinkedHashSet)var3_3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Map<Definition<?>, IConfig> getDefaultConfigs() {
        Iterable $this$associateWith$iv = this.definitions;
        boolean $i$f$associateWith = false;
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv, (int)10)), (int)16));
        Iterable $this$associateWithTo$iv$iv = $this$associateWith$iv;
        boolean $i$f$associateWithTo = false;
        for (Object element$iv$iv : $this$associateWithTo$iv$iv) {
            void it;
            Definition definition = (Definition)element$iv$iv;
            Object t = element$iv$iv;
            Map map = result$iv;
            boolean bl = false;
            IConfig iConfig = it.getDefaultConfig();
            map.put(t, iConfig);
        }
        return result$iv;
    }

    private final void register(String prefix, Class<?> type, Class<?> definition) {
        this.register(prefix, type, Companion.singleton(definition));
    }

    /*
     * WARNING - void declaration
     */
    private final void register(String prefix, Class<?> type, Object singleton) {
        if (singleton == null) {
            return;
        }
        Definition def = Definition.Companion.invoke(prefix, type, singleton);
        String identifier = prefix + ":" + UtilsKt.getSootTypeName(type) + UtilsKt.getSootTypeName(singleton.getClass());
        Definition exists = (Definition)this.identifiers.get(identifier);
        if (exists != null) {
            void it;
            Object object = exists.getSingleton();
            Object object2 = exists.getSingleton();
            Class<?> clazz = object != null ? object.getClass() : null;
            URL uRL = Resource.INSTANCE.locateClass(singleton.getClass());
            String string = UtilsKt.getSootTypeName(singleton.getClass());
            boolean bl = false;
            URL uRL2 = Resource.INSTANCE.locateClass(it.getClass());
            String string2 = "When adding " + string + ": " + uRL + ", there is already a " + clazz + " " + uRL2 + " with the same name.";
            throw new IllegalStateException(string2.toString());
        }
        if (!type.isInstance(singleton)) {
            logger.error(() -> PluginDefinitions.register$lambda$4(singleton, type));
            return;
        }
        ((Map)this.identifiers).put(identifier, def);
        ((Map)this.identifiersReverse).put(def, identifier);
        this.definitions.add(def);
    }

    public final void register(@NotNull PluginWrapper plugin, @NotNull Class<?> type, @NotNull Class<?> definition) {
        Intrinsics.checkNotNullParameter((Object)plugin, (String)"plugin");
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter(definition, (String)"definition");
        String string = plugin.getPluginId();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPluginId(...)");
        this.register(string, type, definition);
    }

    private static final Object register$lambda$4(Object $singleton, Class $type) {
        return $singleton.getClass() + ": " + $singleton + " is not instance of type: " + $type;
    }

    private static final Unit logger$lambda$5() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }

    public static final /* synthetic */ Set access$getCommercialKeywords$cp() {
        return commercialKeywords;
    }

    static {
        Object[] objectArray = new String[]{"commercial", "business"};
        commercialKeywords = SetsKt.setOf((Object[])objectArray);
    }
}

