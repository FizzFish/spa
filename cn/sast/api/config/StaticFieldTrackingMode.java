/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.StaticFieldTrackingMode
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.api.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lcn/sast/api/config/StaticFieldTrackingMode;", "", "<init>", "(Ljava/lang/String;I)V", "ContextFlowSensitive", "ContextFlowInsensitive", "None", "corax-api"})
public final class StaticFieldTrackingMode
extends Enum<StaticFieldTrackingMode> {
    public static final /* enum */ StaticFieldTrackingMode ContextFlowSensitive = new StaticFieldTrackingMode("ContextFlowSensitive", 0);
    public static final /* enum */ StaticFieldTrackingMode ContextFlowInsensitive = new StaticFieldTrackingMode("ContextFlowInsensitive", 1);
    public static final /* enum */ StaticFieldTrackingMode None = new StaticFieldTrackingMode("None", 2);
    private static final /* synthetic */ StaticFieldTrackingMode[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static StaticFieldTrackingMode[] values() {
        return (StaticFieldTrackingMode[])$VALUES.clone();
    }

    public static StaticFieldTrackingMode valueOf(String value) {
        return Enum.valueOf(StaticFieldTrackingMode.class, value);
    }

    @NotNull
    public static EnumEntries<StaticFieldTrackingMode> getEntries() {
        return $ENTRIES;
    }

    private static final /* synthetic */ StaticFieldTrackingMode[] $values() {
        StaticFieldTrackingMode[] staticFieldTrackingModeArray = new StaticFieldTrackingMode[]{ContextFlowSensitive, ContextFlowInsensitive, None};
        return staticFieldTrackingModeArray;
    }

    static {
        $VALUES = StaticFieldTrackingMode.$values();
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])((Enum[])$VALUES));
    }
}

