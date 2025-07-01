package cn.sast.framework.report.sarif;

import com.fasterxml.jackson.annotation.JsonValue;
import org.jetbrains.annotations.NotNull;

public enum Level {
    None("none"),
    Note("note"),
    Warning("warning"),
    Error("error");

    @NotNull
    private final String value;

    Level(@NotNull String value) {
        this.value = value;
    }

    @JsonValue
    @NotNull
    public String getValue() {
        return value;
    }
}