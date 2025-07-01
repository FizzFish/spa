package cn.sast.framework.entries.apk;

import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration;

public final class ApkLifeCycleComponentKt {
    @NotNull
    public static CallbackAnalyzerType getConvert(@NotNull InfoflowAndroidConfiguration.CallbackAnalyzer callbackAnalyzer) {
        if (callbackAnalyzer == null) {
            throw new IllegalArgumentException("callbackAnalyzer cannot be null");
        }
        
        switch (callbackAnalyzer) {
            case Default:
                return CallbackAnalyzerType.Default;
            case Fast:
                return CallbackAnalyzerType.Fast;
            default:
                throw new IllegalArgumentException("Unknown CallbackAnalyzer type");
        }
    }

    @NotNull
    public static InfoflowAndroidConfiguration.CallbackAnalyzer getConvert(@NotNull CallbackAnalyzerType callbackAnalyzerType) {
        if (callbackAnalyzerType == null) {
            throw new IllegalArgumentException("callbackAnalyzerType cannot be null");
        }
        
        switch (callbackAnalyzerType) {
            case Default:
                return InfoflowAndroidConfiguration.CallbackAnalyzer.Default;
            case Fast:
                return InfoflowAndroidConfiguration.CallbackAnalyzer.Fast;
            default:
                throw new IllegalArgumentException("Unknown CallbackAnalyzerType");
        }
    }
}