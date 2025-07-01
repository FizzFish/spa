package cn.sast.framework.plugin;

import cn.sast.api.config.SaConfig;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.Resource;
import cn.sast.framework.plugin.CheckerFilterByName;
import cn.sast.framework.plugin.PluginDefinitions;
import cn.sast.framework.plugin.SAConfiguration;
import com.feysh.corax.config.api.IConfigPluginExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.pf4j.ClassLoadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class ConfigPluginLoader {
    private static final Logger logger = LoggerFactory.getLogger(ConfigPluginLoader.class);

    @NotNull
    private final List<IResource> configDirs;
    @NotNull
    private final List<IResDirectory> pluginsDirs;
    @NotNull
    private final PluginManager pluginManager;
    @NotNull
    private final SerializersModule serializersModule;

    public ConfigPluginLoader(@NotNull List<? extends IResource> configDirs, @NotNull List<? extends IResDirectory> pluginsDirs) {
        if (configDirs == null) throw new IllegalArgumentException("configDirs cannot be null");
        if (pluginsDirs == null) throw new IllegalArgumentException("pluginsDirs cannot be null");
        this.configDirs = Collections.unmodifiableList(new ArrayList<>(configDirs));
        this.pluginsDirs = Collections.unmodifiableList(new ArrayList<>(pluginsDirs));
        this.pluginManager = loadPlugin();
        this.serializersModule = PluginDefinitions.getSerializersModule(pluginManager);
    }

    @NotNull
    public List<IResource> getConfigDirs() {
        return configDirs;
    }

    @NotNull
    public PluginManager getPluginManager() {
        return pluginManager;
    }

    private List<IConfigPluginExtension> getConfigExtensions(String pluginId) {
        List<IConfigPluginExtension> configExtensions = pluginId != null 
            ? pluginManager.getExtensions(IConfigPluginExtension.class, pluginId)
            : pluginManager.getExtensions(IConfigPluginExtension.class);
        
        logger.info("Found {} extensions for extension point '{}'", 
            configExtensions.size(), IConfigPluginExtension.class.getName());
        return configExtensions;
    }

    @NotNull
    public SaConfig loadFromName(@Nullable String pluginId, @Nullable String name) {
        if (name == null) {
            logger.info("Automatically search for the SA-Config under path '{}', with the requirement that there can only exist one config.", pluginsDirs);
        }

        List<IConfigPluginExtension> configExtensions = getConfigExtensions(pluginId);
        if (configExtensions.isEmpty()) {
            throw new IllegalStateException("not found IConfigPluginExtension in: " + pluginsDirs);
        }

        String ps = pluginsDirs.stream()
            .map(IResDirectory::getPath)
            .collect(Collectors.joining(File.pathSeparator));

        IConfigPluginExtension config;
        if (name == null) {
            if (configExtensions.size() != 1) {
                String options = configExtensions.stream()
                    .map(ext -> ext.getName() + "@" + ps)
                    .collect(Collectors.joining(",\n\t"));
                throw new IllegalStateException("you need choose which one of names: [ \n\t" + options + " ]");
            }
            config = configExtensions.get(0);
        } else {
            List<IConfigPluginExtension> matching = configExtensions.stream()
                .filter(ext -> name.equals(ext.getName()))
                .collect(Collectors.toList());
            
            if (matching.isEmpty()) {
                throw new IllegalStateException("your choose: " + name + " not found in plugins dir: " + ps);
            }
            if (matching.size() > 1) {
                throw new IllegalStateException("dup choose: " + name + " in plugins dir: " + ps + ". choose: " + matching);
            }
            config = matching.get(0);
        }

        logger.info("use config method for entry: {} in {}", config.getName(), Resource.locateAllClass(config.getClass()));
        return new SaConfig(null, null, Set.copyOf(config.getUnits()), config.getSootConfig(), null);
    }

    @NotNull
    public SaConfig searchCheckerUnits(@NotNull IResFile ymlConfig, @Nullable CheckerFilterByName checkerFilter) {
        if (ymlConfig == null) throw new IllegalArgumentException("ymlConfig cannot be null");
        
        SAConfiguration configFromYml = SAConfiguration.deserialize(serializersModule, ymlConfig);
        boolean needNormalize = configFromYml.sort();
        
        PluginDefinitions defs = PluginDefinitions.load(pluginManager);
        boolean hasChange = configFromYml.supplementAndMerge(defs, ymlConfig.toString());
        
        IResource dir = ymlConfig.getParent();
        if (dir != null && (needNormalize || hasChange)) {
            String baseName = ymlConfig.getName().substring(0, ymlConfig.getName().lastIndexOf('.'));
            IResFile normalizedConfig = dir.resolve(baseName + ".normalize.yml").toFile();
            configFromYml.sort();
            configFromYml.serialize(serializersModule, normalizedConfig);
            logger.info("Serialized a normalized SA-Configuration yml file: {}", normalizedConfig);
        }
        
        return configFromYml.filter(defs, checkerFilter);
    }

    public void makeTemplateYml(@NotNull IResFile tempFile) {
        if (tempFile == null) throw new IllegalArgumentException("tempFile cannot be null");
        
        PluginDefinitions defs = PluginDefinitions.load(pluginManager);
        SAConfiguration emptyYaml = new SAConfiguration();
        emptyYaml.supplementAndMerge(defs, null);
        emptyYaml.sort();
        emptyYaml.serialize(serializersModule, tempFile);
        logger.info("Serialized template SA-Configuration file: {}", tempFile);
    }

    private PluginManager loadPlugin() {
        logger.info("Plugin directory: {}", pluginsDirs);
        
        List<String> pluginPaths = pluginsDirs.stream()
            .map(IResDirectory::getPath)
            .collect(Collectors.toList());
        
        PluginManager pluginManager = new PluginManager(pluginPaths, null, 2);
        pluginManager.loadPlugins();
        pluginManager.startPlugins();
        
        if (pluginManager.getPlugins().isEmpty()) {
            throw new IllegalStateException("no config plugin found");
        }
        return pluginManager;
    }

    public static class PluginManager {
        private final List<String> pluginPaths;
        private final ClassLoadingStrategy classLoadingStrategy;
        
        public PluginManager(List<String> pluginPaths, ClassLoadingStrategy classLoadingStrategy, int flags) {
            this.pluginPaths = pluginPaths;
            this.classLoadingStrategy = classLoadingStrategy;
        }

        public void loadPlugins() {
            // Implementation omitted
        }

        public void startPlugins() {
            // Implementation omitted
        }

        public List<Object> getPlugins() {
            // Implementation omitted
            return Collections.emptyList();
        }

        public <T> List<T> getExtensions(Class<T> type) {
            // Implementation omitted
            return Collections.emptyList();
        }

        public <T> List<T> getExtensions(Class<T> type, String pluginId) {
            // Implementation omitted
            return Collections.emptyList();
        }
    }
}
