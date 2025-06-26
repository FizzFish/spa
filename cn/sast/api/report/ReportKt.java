/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.report.ReportKt
 *  com.feysh.corax.config.api.BugMessage
 *  com.feysh.corax.config.api.BugMessage$Env
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.api.Language
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.text.Charsets
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.api.report;

import cn.sast.api.config.MainConfig;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.Language;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\n\u0010\t\u001a\u00020\b*\u00020\u0006\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0006\u001a\u001a\u0010\f\u001a\u00020\b*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u001e\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u0012*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011\u001a/\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u0017*\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\u00170\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0019\u00a2\u0006\u0002\u0010\u001a\"\u0015\u0010\u0013\u001a\u00020\b*\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015*0\u0010\u0000\"\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001\u00a2\u0006\u0002\b\u00042\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001\u00a2\u0006\u0002\b\u0004\u00a8\u0006\u001b"}, d2={"BugPathEventLazyGen", "Lkotlin/Function1;", "Lcn/sast/api/report/BugPathEventEnvironment;", "Lcn/sast/api/report/BugPathEvent;", "Lkotlin/ExtensionFunctionType;", "md5", "", "str", "", "toHex", "xor2Int", "", "bugMessage", "Lcom/feysh/corax/config/api/CheckType;", "lang", "Lcom/feysh/corax/config/api/Language;", "env", "Lcom/feysh/corax/config/api/BugMessage$Env;", "", "perfectName", "getPerfectName", "(Lcom/feysh/corax/config/api/CheckType;)Ljava/lang/String;", "preferredMessage", "T", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "corax-api"})
@SourceDebugExtension(value={"SMAP\nReport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Report.kt\ncn/sast/api/report/ReportKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,451:1\n12834#2,3:452\n9326#2,2:456\n9476#2,4:458\n1#3:455\n*S KotlinDebug\n*F\n+ 1 Report.kt\ncn/sast/api/report/ReportKt\n*L\n236#1:452,3\n410#1:456,2\n410#1:458,4\n*E\n"})
public final class ReportKt {
    @NotNull
    public static final byte[] md5(@NotNull String str) {
        Intrinsics.checkNotNullParameter((Object)str, (String)"str");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] byArray = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getBytes(...)");
        byte[] byArray2 = messageDigest.digest(byArray);
        Intrinsics.checkNotNullExpressionValue((Object)byArray2, (String)"digest(...)");
        return byArray2;
    }

    @NotNull
    public static final String toHex(@NotNull byte[] $this$toHex) {
        Intrinsics.checkNotNullParameter((Object)$this$toHex, (String)"<this>");
        return ArraysKt.joinToString$default((byte[])$this$toHex, (CharSequence)"", null, null, (int)0, null, ReportKt::toHex$lambda$0, (int)30, null);
    }

    /*
     * WARNING - void declaration
     */
    public static final int xor2Int(@NotNull byte[] $this$xor2Int) {
        void $this$fold$iv;
        Intrinsics.checkNotNullParameter((Object)$this$xor2Int, (String)"<this>");
        byte[] byArray = $this$xor2Int;
        int initial$iv = 123;
        boolean $i$f$fold = false;
        int accumulator$iv = initial$iv;
        int n = ((void)$this$fold$iv).length;
        for (int i = 0; i < n; ++i) {
            void c;
            void element$iv;
            void var8_8 = element$iv = $this$fold$iv[i];
            int acc = accumulator$iv;
            boolean bl = false;
            accumulator$iv = acc << 8 ^ c;
        }
        return accumulator$iv;
    }

    @NotNull
    public static final String bugMessage(@NotNull CheckType $this$bugMessage, @NotNull Language lang, @NotNull BugMessage.Env env) {
        Object object;
        block3: {
            block2: {
                Intrinsics.checkNotNullParameter((Object)$this$bugMessage, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)lang, (String)"lang");
                Intrinsics.checkNotNullParameter((Object)env, (String)"env");
                object = (BugMessage)$this$bugMessage.getBugMessage().get(lang);
                if (object == null || (object = object.getMsg()) == null) break block2;
                BugMessage it = object;
                boolean bl = false;
                String string = (String)it.invoke((Object)env);
                object = string;
                if (string != null) break block3;
            }
            object = lang + " not exists of checkType: " + $this$bugMessage;
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Map<Language, String> bugMessage(@NotNull CheckType $this$bugMessage, @NotNull BugMessage.Env env) {
        Intrinsics.checkNotNullParameter((Object)$this$bugMessage, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Language[] $this$associateWith$iv = Language.values();
        boolean $i$f$associateWith = false;
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)$this$associateWith$iv.length), (int)16));
        Language[] $this$associateWithTo$iv$iv = $this$associateWith$iv;
        boolean $i$f$associateWithTo = false;
        int n = $this$associateWithTo$iv$iv.length;
        for (int i = 0; i < n; ++i) {
            void it;
            Language element$iv$iv;
            Language language = element$iv$iv = $this$associateWithTo$iv$iv[i];
            Language language2 = element$iv$iv;
            Map map = result$iv;
            boolean bl = false;
            String string = ReportKt.bugMessage((CheckType)$this$bugMessage, (Language)it, (BugMessage.Env)env);
            map.put(language2, string);
        }
        return result$iv;
    }

    @NotNull
    public static final String getPerfectName(@NotNull CheckType $this$perfectName) {
        Intrinsics.checkNotNullParameter((Object)$this$perfectName, (String)"<this>");
        return $this$perfectName.getChecker().getClass().getSimpleName() + "." + $this$perfectName.getClass().getSimpleName();
    }

    public static final <T> T preferredMessage(@NotNull Map<Language, ? extends T> $this$preferredMessage, @NotNull Function0<? extends T> defaultValue) {
        Object object;
        Object object2;
        block2: {
            Intrinsics.checkNotNullParameter($this$preferredMessage, (String)"<this>");
            Intrinsics.checkNotNullParameter(defaultValue, (String)"defaultValue");
            for (Language it : (Iterable)MainConfig.Companion.getPreferredLanguages()) {
                boolean bl = false;
                T t = $this$preferredMessage.get(it);
                if (t == null) continue;
                object2 = t;
                break block2;
            }
            object2 = object = null;
        }
        if (object2 == null) {
            object = defaultValue.invoke();
        }
        return (T)object;
    }

    private static final CharSequence toHex$lambda$0(byte by) {
        String string = "%02x";
        Object[] objectArray = new Object[]{by};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
        return string2;
    }
}

