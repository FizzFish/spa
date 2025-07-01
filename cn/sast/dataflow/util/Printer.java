package cn.sast.dataflow.util;

import org.jetbrains.annotations.NotNull;

public final class Printer {
    private Printer() {}

    public static final class Companion {
        private Companion() {}

        public static Companion getInstance() {
            return INSTANCE;
        }

        private static final Companion INSTANCE = new Companion();
    }

    @NotNull
    public static final Companion getCompanion() {
        return Companion.getInstance();
    }
}