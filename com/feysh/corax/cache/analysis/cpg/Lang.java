/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.fraunhofer.aisec.cpg.frontends.Language
 *  de.fraunhofer.aisec.cpg.frontends.java.JavaLanguage
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.cache.analysis.cpg;

import de.fraunhofer.aisec.cpg.frontends.Language;
import de.fraunhofer.aisec.cpg.frontends.java.JavaLanguage;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\b\u0002\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b\u00a8\u0006\t"}, d2={"Lcom/feysh/corax/cache/analysis/cpg/Lang;", "", "language", "Lde/fraunhofer/aisec/cpg/frontends/Language;", "<init>", "(Ljava/lang/String;ILde/fraunhofer/aisec/cpg/frontends/Language;)V", "getLanguage", "()Lde/fraunhofer/aisec/cpg/frontends/Language;", "JAVA", "corax-config-api"})
public final class Lang
extends Enum<Lang> {
    @NotNull
    private final Language<?> language;
    public static final /* enum */ Lang JAVA = new Lang((Language)new JavaLanguage());
    private static final /* synthetic */ Lang[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private Lang(Language<?> language) {
        this.language = language;
    }

    @NotNull
    public final Language<?> getLanguage() {
        return this.language;
    }

    public static Lang[] values() {
        return (Lang[])$VALUES.clone();
    }

    public static Lang valueOf(String value) {
        return Enum.valueOf(Lang.class, value);
    }

    @NotNull
    public static EnumEntries<Lang> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = langArray = new Lang[]{Lang.JAVA};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

