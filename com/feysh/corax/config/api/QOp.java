package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;
import java.util.List;

public enum QOp {
    ;

    private static final QOp[] $VALUES = values();
    private static final List<QOp> ENTRIES = List.of(values());

    @NotNull
    public static List<QOp> getEntries() {
        return ENTRIES;
    }
}