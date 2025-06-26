/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.CheckType2StringKind
 *  cn.sast.api.report.CheckType2StringKind$Companion
 *  com.feysh.corax.config.api.CheckType
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.api.report;

import cn.sast.api.report.CheckType2StringKind;
import com.feysh.corax.config.api.CheckType;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B,\b\u0002\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\u0004\b\t\u0010\nR,\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0011"}, d2={"Lcn/sast/api/report/CheckType2StringKind;", "", "convert", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/CheckType;", "Lkotlin/ParameterName;", "name", "type", "", "<init>", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "getConvert", "()Lkotlin/jvm/functions/Function1;", "RuleDotTYName", "RuleDotTYName2", "RuleName", "Companion", "corax-api"})
@SourceDebugExtension(value={"SMAP\nReport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Report.kt\ncn/sast/api/report/CheckType2StringKind\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,451:1\n1#2:452\n*E\n"})
public final class CheckType2StringKind
extends Enum<CheckType2StringKind> {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Function1<CheckType, String> convert;
    @NotNull
    private static final String ruleNameKindEnv = "REPORT_RULE_KIND";
    @NotNull
    private static final CheckType2StringKind checkType2StringKind;
    public static final /* enum */ CheckType2StringKind RuleDotTYName;
    public static final /* enum */ CheckType2StringKind RuleDotTYName2;
    public static final /* enum */ CheckType2StringKind RuleName;
    private static final /* synthetic */ CheckType2StringKind[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private CheckType2StringKind(Function1<? super CheckType, String> convert2) {
        this.convert = convert2;
    }

    @NotNull
    public final Function1<CheckType, String> getConvert() {
        return this.convert;
    }

    public static CheckType2StringKind[] values() {
        return (CheckType2StringKind[])$VALUES.clone();
    }

    public static CheckType2StringKind valueOf(String value) {
        return Enum.valueOf(CheckType2StringKind.class, value);
    }

    @NotNull
    public static EnumEntries<CheckType2StringKind> getEntries() {
        return $ENTRIES;
    }

    private static final String _init_$lambda$0(CheckType t) {
        Intrinsics.checkNotNullParameter((Object)t, (String)"t");
        return t.getReport().getRealName() + "." + t.getClass().getSimpleName();
    }

    private static final String _init_$lambda$1(CheckType t) {
        Intrinsics.checkNotNullParameter((Object)t, (String)"t");
        String string = t.getReport().getRealName();
        String string2 = t.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getSimpleName(...)");
        String string3 = string2;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"getDefault(...)");
        String string4 = string3.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"toLowerCase(...)");
        return string + "." + string4;
    }

    private static final String _init_$lambda$2(CheckType t) {
        Intrinsics.checkNotNullParameter((Object)t, (String)"t");
        return t.getReport().getRealName();
    }

    private static final /* synthetic */ CheckType2StringKind[] $values() {
        CheckType2StringKind[] checkType2StringKindArray = new CheckType2StringKind[]{RuleDotTYName, RuleDotTYName2, RuleName};
        return checkType2StringKindArray;
    }

    public static final /* synthetic */ CheckType2StringKind access$getCheckType2StringKind$cp() {
        return checkType2StringKind;
    }

    static {
        String string;
        block5: {
            block4: {
                RuleDotTYName = new CheckType2StringKind("RuleDotTYName", 0, CheckType2StringKind::_init_$lambda$0);
                RuleDotTYName2 = new CheckType2StringKind("RuleDotTYName2", 1, CheckType2StringKind::_init_$lambda$1);
                RuleName = new CheckType2StringKind("RuleName", 2, CheckType2StringKind::_init_$lambda$2);
                $VALUES = CheckType2StringKind.$values();
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])((Enum[])$VALUES));
                Companion = new Companion(null);
                String string2 = System.getenv("REPORT_RULE_KIND");
                if (string2 == null) {
                    string2 = string = System.getProperty("REPORT_RULE_KIND");
                }
                if (string2 == null) break block4;
                String it = string;
                boolean bl = false;
                CheckType2StringKind checkType2StringKind = CheckType2StringKind.valueOf((String)it);
                string = checkType2StringKind;
                if (checkType2StringKind != null) break block5;
            }
            string = RuleDotTYName;
        }
        checkType2StringKind = string;
    }
}

