package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;
import java.util.List;

public enum Language {
    ZH,
    EN;

    private static final Language[] VALUES = values();
    private static final List<Language> ENTRIES = List.of(VALUES);

    @NotNull
    public static List<Language> getEntries() {
        return ENTRIES;
    }
}