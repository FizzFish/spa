package cn.sast.framework.result;

import org.jetbrains.annotations.NotNull;

public enum OutputType {
    PLIST("plist"),
    SARIF("sarif"),
    SQLITE("sqlite"),
    SarifPackSrc("sarif-pack"),
    SarifCopySrc("sarif-copy"),
    Coverage("coverage");

    @NotNull
    private final String displayName;

    OutputType(@NotNull String displayName) {
        this.displayName = displayName;
    }

    @NotNull
    public String getDisplayName() {
        return displayName;
    }
}