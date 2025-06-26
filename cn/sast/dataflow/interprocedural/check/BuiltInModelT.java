/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.BuiltInModelT
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
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2={"Lcn/sast/dataflow/interprocedural/check/BuiltInModelT;", "", "<init>", "(Ljava/lang/String;I)V", "Field", "Array", "Element", "MapKeys", "MapValues", "corax-data-flow"})
public final class BuiltInModelT
extends Enum<BuiltInModelT> {
    public static final /* enum */ BuiltInModelT Field = new BuiltInModelT("Field", 0);
    public static final /* enum */ BuiltInModelT Array = new BuiltInModelT("Array", 1);
    public static final /* enum */ BuiltInModelT Element = new BuiltInModelT("Element", 2);
    public static final /* enum */ BuiltInModelT MapKeys = new BuiltInModelT("MapKeys", 3);
    public static final /* enum */ BuiltInModelT MapValues = new BuiltInModelT("MapValues", 4);
    private static final /* synthetic */ BuiltInModelT[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static BuiltInModelT[] values() {
        return (BuiltInModelT[])$VALUES.clone();
    }

    public static BuiltInModelT valueOf(String value) {
        return Enum.valueOf(BuiltInModelT.class, value);
    }

    @NotNull
    public static EnumEntries<BuiltInModelT> getEntries() {
        return $ENTRIES;
    }

    private static final /* synthetic */ BuiltInModelT[] $values() {
        BuiltInModelT[] builtInModelTArray = new BuiltInModelT[]{Field, Array, Element, MapKeys, MapValues};
        return builtInModelTArray;
    }

    static {
        $VALUES = BuiltInModelT.$values();
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])((Enum[])$VALUES));
    }
}

