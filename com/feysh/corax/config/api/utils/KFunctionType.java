package com.feysh.corax.config.api.utils;

import org.jetbrains.annotations.NotNull;
import java.util.List;

public enum KFunctionType {
    Constructor,
    InstanceMethod,
    StaticMethod;

    private static final List<KFunctionType> VALUES = List.of(values());
    private static final EnumEntries<KFunctionType> ENTRIES = EnumEntriesKt.enumEntries(VALUES.toArray(new KFunctionType[0]));

    @NotNull
    public static EnumEntries<KFunctionType> getEntries() {
        return ENTRIES;
    }
}