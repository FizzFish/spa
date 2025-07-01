package cn.sast.framework;

import cn.sast.api.config.MainConfig;
import soot.Scene;
import org.jetbrains.annotations.NotNull;
import java.lang.reflect.Field;
import java.util.LinkedList;

public final class SootCtxKt {
    private static LinkedList<String> getExcludedPackages(Scene scene) {
        try {
            Field field = scene.getClass().getDeclaredField("excludedPackages");
            field.setAccessible(true);
            return (LinkedList<String>) field.get(scene);
        } catch (Exception e) {
            throw new RuntimeException("Failed to access excludedPackages", e);
        }
    }

    @NotNull
    public static SootCtx getSootCtx(@NotNull MainConfig config) {
        if (config == null) {
            throw new IllegalArgumentException("Config cannot be null");
        }
        return new SootCtx(config);
    }
}