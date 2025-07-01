package cn.sast.framework.engine;

import cn.sast.api.report.IBugResInfo;
import com.feysh.corax.config.api.BugMessage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PreAnalysisReportEnv {
    @NotNull
    private final IBugResInfo file;
    @NotNull
    private final BugMessage.Env env;

    public PreAnalysisReportEnv(@NotNull IBugResInfo file, @NotNull BugMessage.Env env) {
        if (file == null) {
            throw new IllegalArgumentException("file cannot be null");
        }
        if (env == null) {
            throw new IllegalArgumentException("env cannot be null");
        }
        this.file = file;
        this.env = env;
    }

    @NotNull
    public IBugResInfo getFile() {
        return file;
    }

    @NotNull
    public BugMessage.Env getEnv() {
        return env;
    }

    @NotNull
    public PreAnalysisReportEnv copy(@NotNull IBugResInfo file, @NotNull BugMessage.Env env) {
        if (file == null) {
            throw new IllegalArgumentException("file cannot be null");
        }
        if (env == null) {
            throw new IllegalArgumentException("env cannot be null");
        }
        return new PreAnalysisReportEnv(file, env);
    }

    @Override
    public String toString() {
        return "PreAnalysisReportEnv(file=" + file + ", env=" + env + ")";
    }

    @Override
    public int hashCode() {
        int result = file.hashCode();
        result = 31 * result + env.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreAnalysisReportEnv)) {
            return false;
        }
        PreAnalysisReportEnv that = (PreAnalysisReportEnv) other;
        return file.equals(that.file) && env.equals(that.env);
    }
}