package cn.sast.dataflow.util;

import com.feysh.corax.config.api.AIAnalysisApi;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class ConfigInfoLogger implements AIAnalysisApi.Error {
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(ConfigInfoLogger.class.getName());
    
    @NotNull
    private final List<String> errors = new ArrayList<>();
    @NotNull
    private final List<String> warnings = new ArrayList<>();

    @NotNull
    public List<String> getErrors() {
        return errors;
    }

    @NotNull
    public List<String> getWarnings() {
        return warnings;
    }

    @Override
    public void error(@NotNull String msg) {
        logger.error(msg);
        errors.add(msg);
    }

    @Override
    public void warning(@NotNull String msg) {
        logger.warn(msg);
        warnings.add(msg);
    }

    @NotNull
    public KLogger getLogger() {
        return logger;
    }
}