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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lcom/feysh/corax/config/api/QOp;", "", "<init>", "(Ljava/lang/String;I)V", "corax-config-api"})
public final class QOp
extends Enum<QOp> {
    private static final /* synthetic */ QOp[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static QOp[] values() {
        return (QOp[])$VALUES.clone();
    }

    public static QOp valueOf(String value) {
        return Enum.valueOf(QOp.class, value);
    }

    @NotNull
    public static EnumEntries<QOp> getEntries() {
        return $ENTRIES;
    }

    private static final /* synthetic */ QOp[] $values() {
        return new QOp[0];
    }

    static {
        $VALUES = QOp.$values();
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

