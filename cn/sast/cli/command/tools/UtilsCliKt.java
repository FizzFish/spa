package cn.sast.cli.command.tools;

import cn.sast.common.OS;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;

public final class UtilsCliMain {
    private static final KLogger logger = KotlinLogging.logger(UtilsCliMain.class);

    public static void main(@NotNull String[] args) {
        if (args == null) {
            throw new IllegalArgumentException("args cannot be null");
        }

        OS.setArgs(args);
        try {
            new UtilsCli().main(args);
            System.exit(0);
        } catch (Throwable t) {
            logger.error(t, () -> "An error occurred: " + t);
            System.exit(1);
        }
    }
}