/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.SrcPrecedence
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
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0013"}, d2={"Lcn/sast/api/config/SrcPrecedence;", "", "sootFlag", "", "<init>", "(Ljava/lang/String;II)V", "getSootFlag", "()I", "prec_class", "prec_only_class", "prec_jimple", "prec_java", "prec_java_soot", "prec_apk", "prec_apk_class_jimple", "prec_dotnet", "isSootJavaSourcePrec", "", "()Z", "corax-api"})
public final class SrcPrecedence
extends Enum<SrcPrecedence> {
    private final int sootFlag;
    public static final /* enum */ SrcPrecedence prec_class = new SrcPrecedence("prec_class", 0, 1);
    public static final /* enum */ SrcPrecedence prec_only_class = new SrcPrecedence("prec_only_class", 1, 2);
    public static final /* enum */ SrcPrecedence prec_jimple = new SrcPrecedence("prec_jimple", 2, 3);
    public static final /* enum */ SrcPrecedence prec_java = new SrcPrecedence("prec_java", 3, 6);
    public static final /* enum */ SrcPrecedence prec_java_soot = new SrcPrecedence("prec_java_soot", 4, 4);
    public static final /* enum */ SrcPrecedence prec_apk = new SrcPrecedence("prec_apk", 5, 5);
    public static final /* enum */ SrcPrecedence prec_apk_class_jimple = new SrcPrecedence("prec_apk_class_jimple", 6, 6);
    public static final /* enum */ SrcPrecedence prec_dotnet = new SrcPrecedence("prec_dotnet", 7, 7);
    private static final /* synthetic */ SrcPrecedence[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private SrcPrecedence(int sootFlag) {
        this.sootFlag = sootFlag;
    }

    public final int getSootFlag() {
        return this.sootFlag;
    }

    public final boolean isSootJavaSourcePrec() {
        return this == prec_java_soot;
    }

    public static SrcPrecedence[] values() {
        return (SrcPrecedence[])$VALUES.clone();
    }

    public static SrcPrecedence valueOf(String value) {
        return Enum.valueOf(SrcPrecedence.class, value);
    }

    @NotNull
    public static EnumEntries<SrcPrecedence> getEntries() {
        return $ENTRIES;
    }

    private static final /* synthetic */ SrcPrecedence[] $values() {
        SrcPrecedence[] srcPrecedenceArray = new SrcPrecedence[]{prec_class, prec_only_class, prec_jimple, prec_java, prec_java_soot, prec_apk, prec_apk_class_jimple, prec_dotnet};
        return srcPrecedenceArray;
    }

    static {
        $VALUES = SrcPrecedence.$values();
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])((Enum[])$VALUES));
    }
}

