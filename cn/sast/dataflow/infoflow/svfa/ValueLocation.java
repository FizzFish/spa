/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.svfa.ValueLocation
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.infoflow.svfa;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2={"Lcn/sast/dataflow/infoflow/svfa/ValueLocation;", "", "<init>", "(Ljava/lang/String;I)V", "ParamAndThis", "Left", "Right", "Arg", "corax-data-flow"})
public final class ValueLocation
extends Enum<ValueLocation> {
    public static final /* enum */ ValueLocation ParamAndThis = new ValueLocation("ParamAndThis", 0);
    public static final /* enum */ ValueLocation Left = new ValueLocation("Left", 1);
    public static final /* enum */ ValueLocation Right = new ValueLocation("Right", 2);
    public static final /* enum */ ValueLocation Arg = new ValueLocation("Arg", 3);
    private static final /* synthetic */ ValueLocation[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static ValueLocation[] values() {
        return (ValueLocation[])$VALUES.clone();
    }

    public static ValueLocation valueOf(String value) {
        return Enum.valueOf(ValueLocation.class, value);
    }

    @NotNull
    public static EnumEntries<ValueLocation> getEntries() {
        return $ENTRIES;
    }

    private static final /* synthetic */ ValueLocation[] $values() {
        ValueLocation[] valueLocationArray = new ValueLocation[]{ParamAndThis, Left, Right, Arg};
        return valueLocationArray;
    }

    static {
        $VALUES = ValueLocation.$values();
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])((Enum[])$VALUES));
    }
}

