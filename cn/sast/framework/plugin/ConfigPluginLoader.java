/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.SaConfig
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.common.Resource
 *  cn.sast.framework.plugin.CheckerFilterByName
 *  cn.sast.framework.plugin.ConfigPluginLoader
 *  cn.sast.framework.plugin.ConfigPluginLoader$Companion
 *  cn.sast.framework.plugin.ConfigPluginLoader$PluginManager
 *  cn.sast.framework.plugin.PluginDefinitions
 *  cn.sast.framework.plugin.SAConfiguration
 *  com.feysh.corax.config.api.IConfigPluginExtension
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.serialization.modules.SerializersModule
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.pf4j.ClassLoadingStrategy
 */
package cn.sast.framework.plugin;

import cn.sast.api.config.SaConfig;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.Resource;
import cn.sast.framework.plugin.CheckerFilterByName;
import cn.sast.framework.plugin.ConfigPluginLoader;
import cn.sast.framework.plugin.PluginDefinitions;
import cn.sast.framework.plugin.SAConfiguration;
import com.feysh.corax.config.api.IConfigPluginExtension;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.serialization.modules.SerializersModule;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.pf4j.ClassLoadingStrategy;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0002&'B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019J\u0018\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001fJ\b\u0010%\u001a\u00020\fH\u0002R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006("}, d2={"Lcn/sast/framework/plugin/ConfigPluginLoader;", "", "configDirs", "", "Lcn/sast/common/IResource;", "pluginsDirs", "Lcn/sast/common/IResDirectory;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getConfigDirs", "()Ljava/util/List;", "pluginManager", "Lcn/sast/framework/plugin/ConfigPluginLoader$PluginManager;", "getPluginManager", "()Lcn/sast/framework/plugin/ConfigPluginLoader$PluginManager;", "pluginManager$delegate", "Lkotlin/Lazy;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule$delegate", "getConfigExtensions", "Lcom/feysh/corax/config/api/IConfigPluginExtension;", "pluginId", "", "loadFromName", "Lcn/sast/api/config/SaConfig;", "name", "searchCheckerUnits", "ymlConfig", "Lcn/sast/common/IResFile;", "checkerFilter", "Lcn/sast/framework/plugin/CheckerFilterByName;", "makeTemplateYml", "", "tempFile", "loadPlugin", "Companion", "PluginManager", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nConfigPluginLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConfigPluginLoader.kt\ncn/sast/framework/plugin/ConfigPluginLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,197:1\n1#2:198\n774#3:199\n865#3,2:200\n1557#3:202\n1628#3,3:203\n*S KotlinDebug\n*F\n+ 1 ConfigPluginLoader.kt\ncn/sast/framework/plugin/ConfigPluginLoader\n*L\n133#1:199\n133#1:200,2\n180#1:202\n180#1:203,3\n*E\n"})
public final class ConfigPluginLoader {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<IResource> configDirs;
    @NotNull
    private final List<IResDirectory> pluginsDirs;
    @NotNull
    private final Lazy pluginManager$delegate;
    @NotNull
    private final Lazy serializersModule$delegate;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(ConfigPluginLoader::logger$lambda$13);

    public ConfigPluginLoader(@NotNull List<? extends IResource> configDirs, @NotNull List<? extends IResDirectory> pluginsDirs) {
        Intrinsics.checkNotNullParameter(configDirs, (String)"configDirs");
        Intrinsics.checkNotNullParameter(pluginsDirs, (String)"pluginsDirs");
        this.configDirs = configDirs;
        this.pluginsDirs = pluginsDirs;
        this.pluginManager$delegate = LazyKt.lazy(() -> ConfigPluginLoader.pluginManager_delegate$lambda$0(this));
        this.serializersModule$delegate = LazyKt.lazy(() -> ConfigPluginLoader.serializersModule_delegate$lambda$1(this));
    }

    @NotNull
    public final List<IResource> getConfigDirs() {
        return this.configDirs;
    }

    @NotNull
    public final PluginManager getPluginManager() {
        Lazy lazy = this.pluginManager$delegate;
        return (PluginManager)lazy.getValue();
    }

    private final SerializersModule getSerializersModule() {
        Lazy lazy = this.serializersModule$delegate;
        return (SerializersModule)lazy.getValue();
    }

    private final List<IConfigPluginExtension> getConfigExtensions(String pluginId) {
        List list;
        if (pluginId != null) {
            List list2 = this.getPluginManager().getExtensions(IConfigPluginExtension.class, pluginId);
            list = list2;
            Intrinsics.checkNotNullExpressionValue((Object)list2, (String)"getExtensions(...)");
        } else {
            List list3 = this.getPluginManager().getExtensions(IConfigPluginExtension.class);
            list = list3;
            Intrinsics.checkNotNullExpressionValue((Object)list3, (String)"getExtensions(...)");
        }
        List configExtensions = list;
        logger.info(() -> ConfigPluginLoader.getConfigExtensions$lambda$2(configExtensions));
        return configExtensions;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @NotNull
    public final SaConfig loadFromName(@Nullable String pluginId, @Nullable String name) {
        IConfigPluginExtension iConfigPluginExtension;
        List configExtensions;
        if (name == null) {
            logger.info(() -> ConfigPluginLoader.loadFromName$lambda$3(this));
        }
        if (!(!((Collection)(configExtensions = this.getConfigExtensions(pluginId))).isEmpty())) {
            boolean $i$a$-check-ConfigPluginLoader$loadFromName$32 = false;
            String $i$a$-check-ConfigPluginLoader$loadFromName$32 = "not found IConfigPluginExtension in: " + this.pluginsDirs;
            throw new IllegalStateException($i$a$-check-ConfigPluginLoader$loadFromName$32.toString());
        }
        Iterable iterable = this.pluginsDirs;
        String string = File.pathSeparator;
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"pathSeparator");
        String ps = CollectionsKt.joinToString$default((Iterable)iterable, (CharSequence)string, null, null, (int)0, null, null, (int)62, null);
        if (name == null) {
            if (configExtensions.size() != 1) throw new IllegalStateException(("you need choose which one of names: [ \n\t" + CollectionsKt.joinToString$default((Iterable)configExtensions, (CharSequence)",\n\t", null, null, (int)0, null, arg_0 -> ConfigPluginLoader.loadFromName$lambda$5(ps, arg_0), (int)30, null) + " ]").toString());
            iConfigPluginExtension = (IConfigPluginExtension)CollectionsKt.first((List)configExtensions);
        } else {
            void $this$filterTo$iv$iv;
            Iterable $this$filter$iv = configExtensions;
            boolean $i$f$filter = false;
            Iterable iterable2 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                IConfigPluginExtension it = (IConfigPluginExtension)element$iv$iv;
                boolean bl = false;
                if (!Intrinsics.areEqual((Object)it.getName(), (Object)name)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            List choose = (List)destination$iv$iv;
            if (choose.isEmpty()) {
                throw new IllegalStateException(("your choose: " + name + " not found in plugins dir: " + ps).toString());
            }
            if (choose.size() != 1) {
                throw new IllegalStateException(("dup choose: " + name + " in plugins dir: " + ps + ". choose: " + choose).toString());
            }
            iConfigPluginExtension = (IConfigPluginExtension)CollectionsKt.first((List)choose);
        }
        IConfigPluginExtension config = iConfigPluginExtension;
        logger.info(() -> ConfigPluginLoader.loadFromName$lambda$7(config));
        return new SaConfig(null, null, (Set)ExtensionsKt.toImmutableSet((Iterable)config.getUnits()), config.getSootConfig(), null, 3, null);
    }

    @NotNull
    public final SaConfig searchCheckerUnits(@NotNull IResFile ymlConfig, @Nullable CheckerFilterByName checkerFilter) {
        PluginDefinitions defs;
        SAConfiguration configFromYml;
        block1: {
            Intrinsics.checkNotNullParameter((Object)ymlConfig, (String)"ymlConfig");
            configFromYml = SAConfiguration.Companion.deserialize(this.getSerializersModule(), ymlConfig);
            boolean needNormalize = configFromYml.sort();
            defs = PluginDefinitions.Companion.load(this.getPluginManager());
            boolean hasChange = configFromYml.supplementAndMerge(defs, ymlConfig.toString());
            IResource iResource = ymlConfig.getParent();
            if (iResource == null) break block1;
            IResource dir = iResource;
            boolean bl = false;
            if (needNormalize || hasChange) {
                String name = StringsKt.dropLast((String)StringsKt.substringBeforeLast$default((String)ymlConfig.getName(), (String)ymlConfig.getExtension(), null, (int)2, null), (int)1);
                IResFile normalizedConfig = dir.resolve(name + ".normalize.yml").toFile();
                configFromYml.sort();
                configFromYml.serialize(this.getSerializersModule(), normalizedConfig);
                logger.info(() -> ConfigPluginLoader.searchCheckerUnits$lambda$9$lambda$8(normalizedConfig));
            }
        }
        return configFromYml.filter(defs, checkerFilter);
    }

    public final void makeTemplateYml(@NotNull IResFile tempFile) {
        Intrinsics.checkNotNullParameter((Object)tempFile, (String)"tempFile");
        PluginDefinitions defs = PluginDefinitions.Companion.load(this.getPluginManager());
        SAConfiguration emptyYaml = new SAConfiguration(null, null, null, null, 15, null);
        emptyYaml.supplementAndMerge(defs, null);
        emptyYaml.sort();
        emptyYaml.serialize(this.getSerializersModule(), tempFile);
        logger.info(() -> ConfigPluginLoader.makeTemplateYml$lambda$10(tempFile));
    }

    /*
     * WARNING - void declaration
     */
    private final PluginManager loadPlugin() {
        void $this$mapTo$iv$iv;
        logger.info(() -> ConfigPluginLoader.loadPlugin$lambda$11(this));
        Iterable $this$map$iv = this.pluginsDirs;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            IResDirectory iResDirectory = (IResDirectory)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getPath());
        }
        DefaultConstructorMarker defaultConstructorMarker = null;
        int n = 2;
        ClassLoadingStrategy classLoadingStrategy = null;
        List list = (List)destination$iv$iv;
        PluginManager pluginManager = new PluginManager(list, classLoadingStrategy, n, defaultConstructorMarker);
        pluginManager.loadPlugins();
        pluginManager.startPlugins();
        List plugins = pluginManager.getPlugins();
        if (plugins.isEmpty()) {
            throw new IllegalStateException("no config plugin found".toString());
        }
        return pluginManager;
    }

    private static final PluginManager pluginManager_delegate$lambda$0(ConfigPluginLoader this$0) {
        return this$0.loadPlugin();
    }

    private static final SerializersModule serializersModule_delegate$lambda$1(ConfigPluginLoader this$0) {
        return PluginDefinitions.Companion.getSerializersModule(this$0.getPluginManager());
    }

    private static final Object getConfigExtensions$lambda$2(List $configExtensions) {
        String string = "Found %d extensions for extension point '%s'";
        Object[] objectArray = new Object[]{$configExtensions.size(), IConfigPluginExtension.class.getName()};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
        return string2;
    }

    private static final Object loadFromName$lambda$3(ConfigPluginLoader this$0) {
        return "Automatically search for the SA-Config under path '" + this$0.pluginsDirs + "', with the requirement that there can only exist one config.";
    }

    private static final CharSequence loadFromName$lambda$5(String $ps, IConfigPluginExtension it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getName() + "@" + $ps;
    }

    private static final Object loadFromName$lambda$7(IConfigPluginExtension $config) {
        return "use config method for entry: " + $config.getName() + " in " + Resource.INSTANCE.locateAllClass($config.getClass());
    }

    private static final Object searchCheckerUnits$lambda$9$lambda$8(IResFile $normalizedConfig) {
        return "Serialized a normalized SA-Configuration yml file: " + $normalizedConfig;
    }

    private static final Object makeTemplateYml$lambda$10(IResFile $tempFile) {
        return "Serialized template SA-Configuration file: " + $tempFile;
    }

    private static final Object loadPlugin$lambda$11(ConfigPluginLoader this$0) {
        return "Plugin directory: " + this$0.pluginsDirs;
    }

    private static final Unit logger$lambda$13() {
        return Unit.INSTANCE;
    }
}

