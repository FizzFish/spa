/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sarif.Level
 *  com.fasterxml.jackson.annotation.JsonValue
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report.sarif;

import com.fasterxml.jackson.annotation.JsonValue;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u00020\u00038G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Lcn/sast/framework/report/sarif/Level;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "None", "Note", "Warning", "Error", "corax-framework"})
public final class Level
extends Enum<Level> {
    @NotNull
    private final String value;
    public static final /* enum */ Level None = new Level("None", 0, "none");
    public static final /* enum */ Level Note = new Level("Note", 1, "note");
    public static final /* enum */ Level Warning = new Level("Warning", 2, "warning");
    public static final /* enum */ Level Error = new Level("Error", 3, "error");
    private static final /* synthetic */ Level[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private Level(String value) {
        this.value = value;
    }

    @JsonValue
    @NotNull
    public final String getValue() {
        return this.value;
    }

    public static Level[] values() {
        return (Level[])$VALUES.clone();
    }

    public static Level valueOf(String value) {
        return Enum.valueOf(Level.class, value);
    }

    @NotNull
    public static EnumEntries<Level> getEntries() {
        return $ENTRIES;
    }

    private static final /* synthetic */ Level[] $values() {
        Level[] levelArray = new Level[]{None, Note, Warning, Error};
        return levelArray;
    }

    static {
        $VALUES = Level.$values();
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])((Enum[])$VALUES));
    }
}

