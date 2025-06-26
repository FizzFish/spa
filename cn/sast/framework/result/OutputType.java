/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.result.OutputType
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.result;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2={"Lcn/sast/framework/result/OutputType;", "", "displayName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "PLIST", "SARIF", "SQLITE", "SarifPackSrc", "SarifCopySrc", "Coverage", "corax-framework"})
public final class OutputType
extends Enum<OutputType> {
    @NotNull
    private final String displayName;
    public static final /* enum */ OutputType PLIST = new OutputType("PLIST", 0, "plist");
    public static final /* enum */ OutputType SARIF = new OutputType("SARIF", 1, "sarif");
    public static final /* enum */ OutputType SQLITE = new OutputType("SQLITE", 2, "sqlite");
    public static final /* enum */ OutputType SarifPackSrc = new OutputType("SarifPackSrc", 3, "sarif-pack");
    public static final /* enum */ OutputType SarifCopySrc = new OutputType("SarifCopySrc", 4, "sarif-copy");
    public static final /* enum */ OutputType Coverage = new OutputType("Coverage", 5, "coverage");
    private static final /* synthetic */ OutputType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private OutputType(String displayName) {
        this.displayName = displayName;
    }

    @NotNull
    public final String getDisplayName() {
        return this.displayName;
    }

    public static OutputType[] values() {
        return (OutputType[])$VALUES.clone();
    }

    public static OutputType valueOf(String value) {
        return Enum.valueOf(OutputType.class, value);
    }

    @NotNull
    public static EnumEntries<OutputType> getEntries() {
        return $ENTRIES;
    }

    private static final /* synthetic */ OutputType[] $values() {
        OutputType[] outputTypeArray = new OutputType[]{PLIST, SARIF, SQLITE, SarifPackSrc, SarifCopySrc, Coverage};
        return outputTypeArray;
    }

    static {
        $VALUES = OutputType.$values();
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])((Enum[])$VALUES));
    }
}

