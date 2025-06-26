/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.ListSuffixRelation
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Lcn/sast/framework/report/ListSuffixRelation;", "", "neitherSuffix", "", "<init>", "(Ljava/lang/String;IZ)V", "getNeitherSuffix", "()Z", "Equals", "AIsSuffixOfB", "BIsSuffixOfA", "NeitherSuffix", "corax-framework"})
public final class ListSuffixRelation
extends Enum<ListSuffixRelation> {
    private final boolean neitherSuffix;
    public static final /* enum */ ListSuffixRelation Equals = new ListSuffixRelation("Equals", 0, false);
    public static final /* enum */ ListSuffixRelation AIsSuffixOfB = new ListSuffixRelation("AIsSuffixOfB", 1, false);
    public static final /* enum */ ListSuffixRelation BIsSuffixOfA = new ListSuffixRelation("BIsSuffixOfA", 2, false);
    public static final /* enum */ ListSuffixRelation NeitherSuffix = new ListSuffixRelation("NeitherSuffix", 3, true);
    private static final /* synthetic */ ListSuffixRelation[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private ListSuffixRelation(boolean neitherSuffix) {
        this.neitherSuffix = neitherSuffix;
    }

    public final boolean getNeitherSuffix() {
        return this.neitherSuffix;
    }

    public static ListSuffixRelation[] values() {
        return (ListSuffixRelation[])$VALUES.clone();
    }

    public static ListSuffixRelation valueOf(String value) {
        return Enum.valueOf(ListSuffixRelation.class, value);
    }

    @NotNull
    public static EnumEntries<ListSuffixRelation> getEntries() {
        return $ENTRIES;
    }

    private static final /* synthetic */ ListSuffixRelation[] $values() {
        ListSuffixRelation[] listSuffixRelationArray = new ListSuffixRelation[]{Equals, AIsSuffixOfB, BIsSuffixOfA, NeitherSuffix};
        return listSuffixRelationArray;
    }

    static {
        $VALUES = ListSuffixRelation.$values();
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])((Enum[])$VALUES));
    }
}

