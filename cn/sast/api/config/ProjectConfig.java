package cn.sast.api.config;

import java.io.File;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
public final class ProjectConfig {
    public static final String RECORD_FILE_NAME = "scan-classifier-info.json";
    
    @NotNull
    private final ProcessRegex processRegex;
    
    @Nullable
    private File ymlFile;

    public ProjectConfig(@NotNull ProcessRegex processRegex) {
        if (processRegex == null) {
            throw new IllegalArgumentException("processRegex cannot be null");
        }
        this.processRegex = processRegex;
    }

    public ProjectConfig() {
        this(new ProcessRegex(null, null, null));
    }

    @NotNull
    public ProcessRegex getProcessRegex() {
        return processRegex;
    }

    @Nullable
    public File getYmlFile() {
        return ymlFile;
    }

    public void setYmlFile(@Nullable File ymlFile) {
        this.ymlFile = ymlFile;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof ProjectConfig)) return false;
        ProjectConfig that = (ProjectConfig) other;
        return processRegex.equals(that.processRegex);
    }

    @Override
    public int hashCode() {
        return processRegex.hashCode();
    }

    @Override
    public String toString() {
        return "ProjectConfig(processRegex=" + processRegex + ")";
    }

    @NotNull
    public ProjectConfig copy(@NotNull ProcessRegex processRegex) {
        if (processRegex == null) {
            throw new IllegalArgumentException("processRegex cannot be null");
        }
        return new ProjectConfig(processRegex);
    }
}