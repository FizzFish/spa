package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;
import java.util.List;

public enum UnOp {
    GetSet,
    GetBoolean,
    GetInt,
    GetLong,
    GetString,
    GetEnumName,
    ToLowerCase,
    Not,
    IsConstant;

    private static final UnOp[] VALUES = values();
    private static final List<UnOp> ENTRIES = List.of(VALUES);

    @NotNull
    public static List<UnOp> getEntries() {
        return ENTRIES;
    }
}