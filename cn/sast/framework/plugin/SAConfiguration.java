package cn.sast.framework.plugin;

import cn.sast.api.config.BuiltinAnalysisConfig;
import cn.sast.api.config.PreAnalysisConfig;
import cn.sast.api.config.SaConfig;
import cn.sast.common.GLB;
import cn.sast.common.IResFile;
import cn.sast.framework.plugin.CheckerFilterByName;
import cn.sast.framework.plugin.CheckersConfig;
import cn.sast.framework.plugin.ConfigSerializable;
import cn.sast.framework.plugin.IConfig;
import cn.sast.framework.plugin.IOptional;
import cn.sast.framework.plugin.PluginDefinitions;
import com.feysh.corax.config.api.AIAnalysisUnit;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.CheckerUnit;
import com.feysh.corax.config.api.ISootInitializeHandler;
import com.feysh.corax.config.api.PreAnalysisUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public final class SAConfiguration {
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

    public SAConfiguration(@NotNull BuiltinAnalysisConfig builtinAnalysisConfig, 
                          @NotNull PreAnalysisConfig preAnalysisConfig,
                          @NotNull LinkedHashMap<String, LinkedHashSet<ConfigSerializable>> configurations,
                          @NotNull LinkedHashSet<CheckersConfig> checkers) {
        this.builtinAnalysisConfig = Objects.requireNonNull(builtinAnalysisConfig);
        this.preAnalysisConfig = Objects.requireNonNull(preAnalysisConfig);
        this.configurations = Objects.requireNonNull(configurations);
        this.checkers = Objects.requireNonNull(checkers);
        this.relatedMap = new IdentityHashMap<>();
        this.disabled = new IdentityHashMap<>();
    }

    public boolean sort() {
        int oldHash = hashCode();
        
        configurations = configurations.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> e.getValue().stream()
                    .sorted(Comparator.comparing(ConfigSerializable::getName))
                    .collect(Collectors.toCollection(LinkedHashSet::new)),
                (oldVal, newVal) -> oldVal,
                LinkedHashMap::new));

        checkers = checkers.stream()
            .sorted(Comparator.comparing(CheckersConfig::getName))
            .collect(Collectors.toCollection(LinkedHashSet::new));

        return hashCode() != oldHash;
    }

    private <T> T getInstance(PluginDefinitions.Definition<?> definition, Class<T> clz) {
        Object singleton = definition.getSingleton();
        return clz.isInstance(singleton) ? clz.cast(singleton) : null;
    }

    private IConfig relateConfig(PluginDefinitions.Definition<?> definition) {
        IConfig config = relatedMap.get(definition);
        if (config == null) {
            throw new IllegalStateException(definition + " not relate to a config");
        }
        return config;
    }

    private <T> T get(PluginDefinitions.Definition<?> definition, Class<T> clz) {
        IConfig config = relateConfig(definition);
        if (config instanceof IOptional && !((IOptional) config).getEnable()) {
            disabled.put(definition, config);
            return null;
        }

        if (definition instanceof PluginDefinitions.CheckTypeDefinition) {
            String checkerName = ((PluginDefinitions.CheckTypeDefinition) definition).getSingleton().getChecker();
            CheckersConfig checkerConfig = checkers.stream()
                .filter(c -> c.getName().equals(checkerName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No checker found for " + checkerName));

            if (!checkerConfig.getEnable()) {
                return null;
            }
        }

        return getInstance(definition, clz);
    }

    private EnablesConfig getCheckers(PluginDefinitions defs, CheckerFilterByName checkerFilter) {
        EnablesConfig res = new EnablesConfig();
        
        Set<String> enableCheckers = checkerFilter != null ? checkerFilter.getEnables() : null;
        Set<String> oldNames = checkerFilter != null ? checkerFilter.getRenameMap().keySet() : Collections.emptySet();

        if (checkerFilter != null) {
            Set<String> existsCheckerNames = defs.getCheckTypeDefinition(CheckType.class).stream()
                .map(d -> d.getDefaultConfig().getCheckType())
                .collect(Collectors.toSet());

            List<String> notExistsCheckerNames = enableCheckers.stream()
                .filter(name -> !existsCheckerNames.contains(name) && !oldNames.contains(name))
                .collect(Collectors.toList());

            if (!notExistsCheckerNames.isEmpty()) {
                logger.warn("These check types named " + notExistsCheckerNames + " cannot be found in analysis-config");
                
                if (enableCheckers.stream().noneMatch(existsCheckerNames::contains)) {
                    throw new IllegalStateException("No checker type are enabled");
                }
            }

            List<String> disabledCheckers = existsCheckerNames.stream()
                .filter(name -> !enableCheckers.contains(name))
                .collect(Collectors.toList());
            
            logger.debug("These check types " + disabledCheckers + " are not enabled");
        }

        // Populate pre-analysis, AI analysis, soot config and check types
        populateEnabledDefinitions(defs, res, enableCheckers);
        
        // Create mapping between definitions and configs
        createDefinitionConfigMappings(defs, res);

        return res;
    }

    @NotNull
    public SaConfig filter(@NotNull PluginDefinitions defs, @Nullable CheckerFilterByName checkerFilter) {
        EnablesConfig enableDefinitions = getCheckers(defs, checkerFilter);
        
        logger.info("Num of effective PreAnalysisUnit is " + enableDefinitions.getPreAnalysisUnits().size() + 
                   "/" + defs.getPreAnalysisUnit(PreAnalysisUnit.class).size());
        // ... similar logging for other types

        ISootInitializeHandler sootConfigMerge = enableDefinitions.getSootConfig().size() == 1 ? 
            enableDefinitions.getSootConfig().get(0) : 
            new CompositeSootHandler(enableDefinitions.getSootConfig());

        Set<CheckType> enabledCheckTypes = new HashSet<>(enableDefinitions.getCheckTypes());
        GLB.INSTANCE.addAll(defs.getCheckTypeDefinition(CheckType.class).stream()
            .map(PluginDefinitions.CheckTypeDefinition::getSingleton)
            .collect(Collectors.toList()));

        return new SaConfig(
            builtinAnalysisConfig,
            preAnalysisConfig,
            new LinkedHashSet<>(enableDefinitions.getPreAnalysisUnits()),
            sootConfigMerge,
            enabledCheckTypes
        );
    }

    public void serialize(@NotNull SerializersModule serializersModule, @NotNull IResFile out) throws IOException {
        Objects.requireNonNull(serializersModule);
        Objects.requireNonNull(out);
        
        Yaml yml = new Yaml(serializersModule, MainConfigKt.getYamlConfiguration());
        Path path = out.getPath();
        
        try (OutputStream outputStream = Files.newOutputStream(path)) {
            yml.encodeToStream(Companion.serializer(), this, outputStream);
        } catch (Exception e) {
            Files.deleteIfExists(path);
            throw e;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SAConfiguration)) return false;
        SAConfiguration that = (SAConfiguration) o;
        return builtinAnalysisConfig.equals(that.builtinAnalysisConfig) &&
               preAnalysisConfig.equals(that.preAnalysisConfig) &&
               configurations.equals(that.configurations) &&
               checkers.equals(that.checkers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(builtinAnalysisConfig, preAnalysisConfig, configurations, checkers);
    }

    @Override
    public String toString() {
        return "SAConfiguration{" +
               "builtinAnalysisConfig=" + builtinAnalysisConfig +
               ", preAnalysisConfig=" + preAnalysisConfig +
               ", configurations=" + configurations +
               ", checkers=" + checkers +
               '}';
    }

    private static class CompositeSootHandler implements ISootInitializeHandler {
        private final List<ISootInitializeHandler> handlers;

        CompositeSootHandler(List<ISootInitializeHandler> handlers) {
            this.handlers = handlers;
        }

        @Override
        public void initialize() {
            handlers.forEach(ISootInitializeHandler::initialize);
        }
    }
}
