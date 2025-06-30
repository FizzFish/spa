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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2={"Lcom/feysh/corax/config/api/UnOp;", "", "<init>", "(Ljava/lang/String;I)V", "GetSet", "GetBoolean", "GetInt", "GetLong", "GetString", "GetEnumName", "ToLowerCase", "Not", "IsConstant", "corax-config-api"})
public final class UnOp
extends Enum<UnOp> {
    public static final /* enum */ UnOp GetSet = new UnOp();
    public static final /* enum */ UnOp GetBoolean = new UnOp();
    public static final /* enum */ UnOp GetInt = new UnOp();
    public static final /* enum */ UnOp GetLong = new UnOp();
    public static final /* enum */ UnOp GetString = new UnOp();
    public static final /* enum */ UnOp GetEnumName = new UnOp();
    public static final /* enum */ UnOp ToLowerCase = new UnOp();
    public static final /* enum */ UnOp Not = new UnOp();
    public static final /* enum */ UnOp IsConstant = new UnOp();
    private static final /* synthetic */ UnOp[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static UnOp[] values() {
        return (UnOp[])$VALUES.clone();
    }

    public static UnOp valueOf(String value) {
        return Enum.valueOf(UnOp.class, value);
    }

    @NotNull
    public static EnumEntries<UnOp> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = unOpArray = new UnOp[]{UnOp.GetSet, UnOp.GetBoolean, UnOp.GetInt, UnOp.GetLong, UnOp.GetString, UnOp.GetEnumName, UnOp.ToLowerCase, UnOp.Not, UnOp.IsConstant};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

