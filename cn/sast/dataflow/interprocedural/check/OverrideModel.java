/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.OverrideModel
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.check;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lcn/sast/dataflow/interprocedural/check/OverrideModel;", "", "<init>", "(Ljava/lang/String;I)V", "HashMap", "ArrayList", "corax-data-flow"})
public final class OverrideModel
extends Enum<OverrideModel> {
    public static final /* enum */ OverrideModel HashMap = new OverrideModel("HashMap", 0);
    public static final /* enum */ OverrideModel ArrayList = new OverrideModel("ArrayList", 1);
    private static final /* synthetic */ OverrideModel[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static OverrideModel[] values() {
        return (OverrideModel[])$VALUES.clone();
    }

    public static OverrideModel valueOf(String value) {
        return Enum.valueOf(OverrideModel.class, value);
    }

    @NotNull
    public static EnumEntries<OverrideModel> getEntries() {
        return $ENTRIES;
    }

    private static final /* synthetic */ OverrideModel[] $values() {
        OverrideModel[] overrideModelArray = new OverrideModel[]{HashMap, ArrayList};
        return overrideModelArray;
    }

    static {
        $VALUES = OverrideModel.$values();
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])((Enum[])$VALUES));
    }
}

