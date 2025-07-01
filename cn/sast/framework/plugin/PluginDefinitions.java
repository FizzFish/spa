package cn.sast.framework.plugin;

import cn.sast.common.Resource;
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
import org.jetbrains.annotations.NotNull;
import org.pf4j.PluginWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public final class PluginDefinitions {
    private static final Logger logger = LoggerFactory.getLogger(PluginDefinitions.class);
    private static final Set<String> commercialKeywords = Set.of("commercial", "business");

    private final Set<Definition<?>> definitions = new LinkedHashSet<>();
    private final Map<String, Definition<?>> identifiers = new LinkedHashMap<>();
    private final Map<Definition<?>, String> identifiersReverse = new LinkedHashMap<>();

    public PluginDefinitions() {
        register("builtin", ISootInitializeHandler.class, DefaultSootConfiguration.class);
        register("builtin", ISootInitializeHandler.class, EmptySootConfiguration.class);
        register("builtin", CheckType.class, DefineUnusedChecker.UrfUnreadField.INSTANCE);
        register("builtin", CheckType.class, DefineUnusedChecker.UnusedMethod.INSTANCE);
        register("builtin", CheckType.class, DeadCodeChecker.DeadCode.INSTANCE);
        register("builtin", CheckType.class, DeadCodeChecker.UnreachableBranch.INSTANCE);
        register("builtin", CheckType.class, DeadStoreChecker.DeadLocalStore.INSTANCE);
    }

    @NotNull
    public Set<ISootInitializeHandlerDefinition> getISootInitializeHandlerDefinition(@NotNull Class<ISootInitializeHandler> clz) {
        return definitions.stream()
                .filter(ISootInitializeHandlerDefinition.class::isInstance)
                .map(ISootInitializeHandlerDefinition.class::cast)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @NotNull
    public Set<CheckTypeDefinition> getCheckTypeDefinition(@NotNull Class<CheckType> clz) {
        return definitions.stream()
                .filter(CheckTypeDefinition.class::isInstance)
                .map(CheckTypeDefinition.class::cast)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @NotNull
    public Set<CheckerUnitDefinition> getCheckerUnitDefinition(@NotNull Class<CheckerUnit> clz) {
        return definitions.stream()
                .filter(CheckerUnitDefinition.class::isInstance)
                .map(CheckerUnitDefinition.class::cast)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @NotNull
    public Set<CheckerUnitDefinition> getPreAnalysisUnit(@NotNull Class<PreAnalysisUnit> clz) {
        return getCheckerUnitDefinition(CheckerUnit.class).stream()
                .filter(def -> def.getType().equals(clz))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @NotNull
    public Set<CheckerUnitDefinition> getAIAnalysisUnit(@NotNull Class<AIAnalysisUnit> clz) {
        return getCheckerUnitDefinition(CheckerUnit.class).stream()
                .filter(def -> def.getType().equals(clz))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @NotNull
    public Map<Definition<?>, IConfig> getDefaultConfigs() {
        return definitions.stream()
                .collect(Collectors.toMap(
                        def -> def,
                        Definition::getDefaultConfig,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }

    private void register(String prefix, Class<?> type, Class<?> definition) {
        register(prefix, type, Definition.singleton(definition));
    }

    private void register(String prefix, Class<?> type, Object singleton) {
        if (singleton == null) {
            return;
        }

        Definition<?> def = Definition.create(prefix, type, singleton);
        String identifier = prefix + ":" + UtilsKt.getSootTypeName(type) + UtilsKt.getSootTypeName(singleton.getClass());

        Definition<?> existing = identifiers.get(identifier);
        if (existing != null) {
            Object existingSingleton = existing.getSingleton();
            Class<?> existingClass = existingSingleton != null ? existingSingleton.getClass() : null;
            URL newUrl = Resource.INSTANCE.locateClass(singleton.getClass());
            URL existingUrl = Resource.INSTANCE.locateClass(existingClass);

            throw new IllegalStateException("When adding " + UtilsKt.getSootTypeName(singleton.getClass()) + 
                    ": " + newUrl + ", there is already a " + existingClass + " " + existingUrl + " with the same name.");
        }

        if (!type.isInstance(singleton)) {
            logger.error("{}: {} is not instance of type: {}", 
                    singleton.getClass(), singleton, type);
            return;
        }

        identifiers.put(identifier, def);
        identifiersReverse.put(def, identifier);
        definitions.add(def);
    }

    public void register(@NotNull PluginWrapper plugin, @NotNull Class<?> type, @NotNull Class<?> definition) {
        Objects.requireNonNull(plugin, "plugin");
        Objects.requireNonNull(type, "type");
        Objects.requireNonNull(definition, "definition");
        register(plugin.getPluginId(), type, definition);
    }

    public static class Definition<T> {
        public static <T> Definition<T> create(String prefix, Class<?> type, T singleton) {
            return new Definition<>(prefix, type, singleton);
        }

        public static <T> T singleton(Class<T> clazz) {
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Failed to create singleton for " + clazz.getName(), e);
            }
        }

        private final String prefix;
        private final Class<?> type;
        private final T singleton;

        private Definition(String prefix, Class<?> type, T singleton) {
            this.prefix = prefix;
            this.type = type;
            this.singleton = singleton;
        }

        public String getPrefix() {
            return prefix;
        }

        public Class<?> getType() {
            return type;
        }

        public T getSingleton() {
            return singleton;
        }

        public IConfig getDefaultConfig() {
            return null; // Implementation omitted for brevity
        }
    }

    public static class ISootInitializeHandlerDefinition extends Definition<ISootInitializeHandler> {
        public ISootInitializeHandlerDefinition(String prefix, Class<?> type, ISootInitializeHandler singleton) {
            super(prefix, type, singleton);
        }
    }

    public static class CheckTypeDefinition extends Definition<CheckType> {
        public CheckTypeDefinition(String prefix, Class<?> type, CheckType singleton) {
            super(prefix, type, singleton);
        }
    }

    public static class CheckerUnitDefinition extends Definition<CheckerUnit> {
        public CheckerUnitDefinition(String prefix, Class<?> type, CheckerUnit singleton) {
            super(prefix, type, singleton);
        }
    }
}
