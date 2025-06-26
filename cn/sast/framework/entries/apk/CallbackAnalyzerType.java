/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.entries.apk.CallbackAnalyzerType
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.entries.apk;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lcn/sast/framework/entries/apk/CallbackAnalyzerType;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "Fast", "corax-framework"})
public final class CallbackAnalyzerType
extends Enum<CallbackAnalyzerType> {
    public static final /* enum */ CallbackAnalyzerType Default = new CallbackAnalyzerType("Default", 0);
    public static final /* enum */ CallbackAnalyzerType Fast = new CallbackAnalyzerType("Fast", 1);
    private static final /* synthetic */ CallbackAnalyzerType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static CallbackAnalyzerType[] values() {
        return (CallbackAnalyzerType[])$VALUES.clone();
    }

    public static CallbackAnalyzerType valueOf(String value) {
        return Enum.valueOf(CallbackAnalyzerType.class, value);
    }

    @NotNull
    public static EnumEntries<CallbackAnalyzerType> getEntries() {
        return $ENTRIES;
    }

    private static final /* synthetic */ CallbackAnalyzerType[] $values() {
        CallbackAnalyzerType[] callbackAnalyzerTypeArray = new CallbackAnalyzerType[]{Default, Fast};
        return callbackAnalyzerTypeArray;
    }

    static {
        $VALUES = CallbackAnalyzerType.$values();
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])((Enum[])$VALUES));
    }
}

