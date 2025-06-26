/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.printer.EventPrinterKt
 *  com.feysh.corax.config.api.utils.UtilsKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  soot.Type
 */
package cn.sast.dataflow.interprocedural.check.printer;

import com.feysh.corax.config.api.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"pname", "", "Lsoot/Type;", "getPname", "(Lsoot/Type;)Ljava/lang/String;", "corax-data-flow"})
public final class EventPrinterKt {
    @NotNull
    public static final String getPname(@NotNull Type $this$pname) {
        Intrinsics.checkNotNullParameter((Object)$this$pname, (String)"<this>");
        String string = UtilsKt.getTypename((Type)$this$pname);
        if (string == null) {
            String string2 = $this$pname.toString();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toString(...)");
            return string2;
        }
        String name = string;
        return StringsKt.removePrefix((String)name, (CharSequence)"java.lang.");
    }
}

