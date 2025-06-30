/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lcom/feysh/corax/config/api/utils/KFunctionType;", "", "<init>", "(Ljava/lang/String;I)V", "Constructor", "InstanceMethod", "StaticMethod", "corax-config-api"})
public final class KFunctionType
extends Enum<KFunctionType> {
    public static final /* enum */ KFunctionType Constructor = new KFunctionType();
    public static final /* enum */ KFunctionType InstanceMethod = new KFunctionType();
    public static final /* enum */ KFunctionType StaticMethod = new KFunctionType();
    private static final /* synthetic */ KFunctionType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static KFunctionType[] values() {
        return (KFunctionType[])$VALUES.clone();
    }

    public static KFunctionType valueOf(String value) {
        return Enum.valueOf(KFunctionType.class, value);
    }

    @NotNull
    public static EnumEntries<KFunctionType> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = kFunctionTypeArray = new KFunctionType[]{KFunctionType.Constructor, KFunctionType.InstanceMethod, KFunctionType.StaticMethod};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

