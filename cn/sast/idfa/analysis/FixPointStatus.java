/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.idfa.analysis.FixPointStatus
 *  cn.sast.idfa.analysis.FixPointStatus$Companion
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.idfa.analysis;

import cn.sast.idfa.analysis.FixPointStatus;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\b"}, d2={"Lcn/sast/idfa/analysis/FixPointStatus;", "", "<init>", "(Ljava/lang/String;I)V", "HasChange", "Fixpoint", "NeedWideningOperators", "Companion", "corax-idfa-framework"})
public final class FixPointStatus
extends Enum<FixPointStatus> {
    @NotNull
    public static final Companion Companion;
    public static final /* enum */ FixPointStatus HasChange;
    public static final /* enum */ FixPointStatus Fixpoint;
    public static final /* enum */ FixPointStatus NeedWideningOperators;
    private static final /* synthetic */ FixPointStatus[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static FixPointStatus[] values() {
        return (FixPointStatus[])$VALUES.clone();
    }

    public static FixPointStatus valueOf(String value) {
        return Enum.valueOf(FixPointStatus.class, value);
    }

    @NotNull
    public static EnumEntries<FixPointStatus> getEntries() {
        return $ENTRIES;
    }

    private static final /* synthetic */ FixPointStatus[] $values() {
        FixPointStatus[] fixPointStatusArray = new FixPointStatus[]{HasChange, Fixpoint, NeedWideningOperators};
        return fixPointStatusArray;
    }

    static {
        HasChange = new FixPointStatus("HasChange", 0);
        Fixpoint = new FixPointStatus("Fixpoint", 1);
        NeedWideningOperators = new FixPointStatus("NeedWideningOperators", 2);
        $VALUES = FixPointStatus.$values();
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])((Enum[])$VALUES));
        Companion = new Companion(null);
    }
}

