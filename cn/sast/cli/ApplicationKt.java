package cn.sast.cli;

import cn.sast.cli.command.FySastCli;
import cn.sast.common.OS;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ApplicationKt {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    @Nullable
    private static byte[] lastResort = new byte[0x1400000];

    @NotNull
    public static String getVersion() throws IOException {
        Properties prop = new Properties();
        try (InputStream stream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("version.properties")) {
            if (stream == null) {
                throw new IOException("version.properties not found");
            }
            prop.load(stream);
        }
        String version = prop.getProperty("version");
        if (version == null) {
            throw new IOException("version property not found");
        }
        return version;
    }

    public static void main(@NotNull String[] args) {
        if (args == null) {
            throw new IllegalArgumentException("args cannot be null");
        }
        
        OS.INSTANCE.setArgs(args);
        Thread.setDefaultUncaughtExceptionHandler((thread, ex) -> {
            logger.error("Uncaught exception in thread: " + thread.getName(), ex);
            System.exit(1);
        });

        try {
            new FySastCli().main(args);
            System.exit(0);
        } catch (Throwable t) {
            logger.error("An error occurred: " + t, t);
            System.exit(1);
        }
    }

    @Nullable
    public static byte[] getLastResort() {
        return lastResort;
    }

    public static void setLastResort(@Nullable byte[] lastResort) {
        Application.lastResort = lastResort;
    }
}