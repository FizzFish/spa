/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.CgAlgorithmProvider
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lcn/sast/framework/CgAlgorithmProvider;", "", "<init>", "(Ljava/lang/String;I)V", "Soot", "QiLin", "corax-framework"})
public final class CgAlgorithmProvider
extends Enum<CgAlgorithmProvider> {
    public static final /* enum */ CgAlgorithmProvider Soot = new CgAlgorithmProvider("Soot", 0);
    public static final /* enum */ CgAlgorithmProvider QiLin = new CgAlgorithmProvider("QiLin", 1);
    private static final /* synthetic */ CgAlgorithmProvider[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static CgAlgorithmProvider[] values() {
        return (CgAlgorithmProvider[])$VALUES.clone();
    }

    public static CgAlgorithmProvider valueOf(String value) {
        return Enum.valueOf(CgAlgorithmProvider.class, value);
    }

    @NotNull
    public static EnumEntries<CgAlgorithmProvider> getEntries() {
        return $ENTRIES;
    }

    private static final /* synthetic */ CgAlgorithmProvider[] $values() {
        CgAlgorithmProvider[] cgAlgorithmProviderArray = new CgAlgorithmProvider[]{Soot, QiLin};
        return cgAlgorithmProviderArray;
    }

    static {
        $VALUES = CgAlgorithmProvider.$values();
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])((Enum[])$VALUES));
    }
}

