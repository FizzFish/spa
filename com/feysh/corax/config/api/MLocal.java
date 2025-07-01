package com.feysh.corax.config.api;

public abstract class MLocal {
    private MLocal() {}

    public static final class MGlobal extends MLocal {
        public MGlobal() {}
    }

    public static final class MParameter extends MLocal {
        public MParameter() {}
    }

    public static final class MReturn extends MLocal {
        public MReturn() {}
    }
}