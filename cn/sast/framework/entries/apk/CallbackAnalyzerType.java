package cn.sast.framework.entries.apk;

import org.jetbrains.annotations.NotNull;

public enum CallbackAnalyzerType {
    Default,
    Fast;

    @NotNull
    public static CallbackAnalyzerType[] getEntries() {
        return values();
    }
}