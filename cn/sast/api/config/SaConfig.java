package cn.sast.api.config;

import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.CheckerUnit;
import com.feysh.corax.config.api.ISootInitializeHandler;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SaConfig {
    @NotNull
    private final BuiltinAnalysisConfig builtinAnalysisConfig;
    @NotNull
    private final PreAnalysisConfig preAnalysisConfig;
    @NotNull
    private final Set<CheckerUnit> checkers;
    @NotNull
    private final ISootInitializeHandler sootConfig;
    @Nullable
    private final Set<CheckType> enableCheckTypes;

    public SaConfig(
            @NotNull BuiltinAnalysisConfig builtinAnalysisConfig,
            @NotNull PreAnalysisConfig preAnalysisConfig,
            @NotNull Set<? extends CheckerUnit> checkers,
            @NotNull ISootInitializeHandler sootConfig,
            @Nullable Set<? extends CheckType> enableCheckTypes) {
        Objects.requireNonNull(builtinAnalysisConfig, "builtinAnalysisConfig");
        Objects.requireNonNull(preAnalysisConfig, "preAnalysisConfig");
        Objects.requireNonNull(checkers, "checkers");
        Objects.requireNonNull(sootConfig, "sootConfig");
        this.builtinAnalysisConfig = builtinAnalysisConfig;
        this.preAnalysisConfig = preAnalysisConfig;
        this.checkers = Set.copyOf(checkers);
        this.sootConfig = sootConfig;
        this.enableCheckTypes = enableCheckTypes != null ? Set.copyOf(enableCheckTypes) : null;
    }

    @NotNull
    public BuiltinAnalysisConfig getBuiltinAnalysisConfig() {
        return builtinAnalysisConfig;
    }

    @NotNull
    public PreAnalysisConfig getPreAnalysisConfig() {
        return preAnalysisConfig;
    }

    @NotNull
    public Set<CheckerUnit> getCheckers() {
        return checkers;
    }

    @NotNull
    public ISootInitializeHandler getSootConfig() {
        return sootConfig;
    }

    @Nullable
    public Set<CheckType> getEnableCheckTypes() {
        return enableCheckTypes;
    }

    public boolean isEnable(@NotNull CheckType checkType) {
        Objects.requireNonNull(checkType, "checkType");
        return enableCheckTypes == null || enableCheckTypes.contains(checkType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaConfig)) return false;
        SaConfig saConfig = (SaConfig) o;
        return builtinAnalysisConfig.equals(saConfig.builtinAnalysisConfig) &&
                preAnalysisConfig.equals(saConfig.preAnalysisConfig) &&
                checkers.equals(saConfig.checkers) &&
                sootConfig.equals(saConfig.sootConfig) &&
                Objects.equals(enableCheckTypes, saConfig.enableCheckTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                builtinAnalysisConfig,
                preAnalysisConfig,
                checkers,
                sootConfig,
                enableCheckTypes
        );
    }

    @Override
    public String toString() {
        return "SaConfig{" +
                "builtinAnalysisConfig=" + builtinAnalysisConfig +
                ", preAnalysisConfig=" + preAnalysisConfig +
                ", checkers=" + checkers +
                ", sootConfig=" + sootConfig +
                ", enableCheckTypes=" + enableCheckTypes +
                '}';
    }
}