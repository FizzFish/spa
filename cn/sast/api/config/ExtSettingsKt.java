package cn.sast.api.config;

import cn.sast.common.OS;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class ExtSettingsKt {
    public static final KLogger logger = KotlinLogging.INSTANCE.logger(String.valueOf(ExtSettingsKt.class));
    private static final String SETTING_FILE_NAME = "settings.properties";
    public static final String defaultKeyForSettingsPath = "corax.settings.path";
    private static final String coraxHomePath = System.getProperty("user.home") + File.separatorChar + ".corax";
    private static final String defaultSettingsPath;

    @NotNull
    public static String getCoraxHomePath() {
        return coraxHomePath;
    }

    static {
        Path foundPath = null;
        List<Path> searchPaths = List.of(
            Paths.get("."),
            Objects.requireNonNullElse(OS.INSTANCE.getJarBinPath(), Paths.get(".")).getParent()
        );

        for (Path dir : searchPaths) {
            Path settingsPath = dir.resolve(SETTING_FILE_NAME);
            if (Files.exists(settingsPath, LinkOption.NOFOLLOW_LINKS)) {
                foundPath = settingsPath;
                break;
            }
        }

        if (foundPath != null) {
            defaultSettingsPath = foundPath.toString();
        } else {
            Path fallbackPath = Paths.get(coraxHomePath).resolve(SETTING_FILE_NAME);
            defaultSettingsPath = fallbackPath.toString();
        }
    }
}
