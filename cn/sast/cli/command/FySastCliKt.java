package cn.sast.cli.command;

import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FySastCliKt {
    @NotNull
    public static final String defaultConfigPathName = "CORAX_CONFIG_DEFAULT_DIR";
    @NotNull
    private static final String ANCHOR_POINT_FILE = ".corax" + File.separator + "anchor_point";
    @NotNull
    public static final String MAPPING_FILE_NAME = "checker_name_mapping.json";

    @Nullable
    public static String getDefaultConfigDir() {
        String configDir = System.getenv(defaultConfigPathName);
        if (configDir == null) {
            configDir = System.getProperty(defaultConfigPathName);
        }
        return configDir;
    }

    @NotNull
    public static String getANCHOR_POINT_FILE() {
        return ANCHOR_POINT_FILE;
    }
}