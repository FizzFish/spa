/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lcom/feysh/corax/config/api/Language;", "", "<init>", "(Ljava/lang/String;I)V", "ZH", "EN", "corax-config-api"})
public final class Language
extends Enum<Language> {
    public static final /* enum */ Language ZH = new Language();
    public static final /* enum */ Language EN = new Language();
    private static final /* synthetic */ Language[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static Language[] values() {
        return (Language[])$VALUES.clone();
    }

    public static Language valueOf(String value) {
        return Enum.valueOf(Language.class, value);
    }

    @NotNull
    public static EnumEntries<Language> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = languageArray = new Language[]{Language.ZH, Language.EN};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

