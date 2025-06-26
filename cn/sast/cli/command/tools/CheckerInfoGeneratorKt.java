/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.CheckType2StringKind
 *  cn.sast.cli.command.tools.CheckerInfoGeneratorKt
 *  com.feysh.corax.config.api.CheckType
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.cli.command.tools;

import cn.sast.api.report.CheckType2StringKind;
import com.feysh.corax.config.api.CheckType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"id", "", "Lcom/feysh/corax/config/api/CheckType;", "getId", "(Lcom/feysh/corax/config/api/CheckType;)Ljava/lang/String;", "corax-cli"})
public final class CheckerInfoGeneratorKt {
    @NotNull
    public static final String getId(@NotNull CheckType $this$id) {
        Intrinsics.checkNotNullParameter((Object)$this$id, (String)"<this>");
        return (String)CheckType2StringKind.Companion.getCheckType2StringKind().getConvert().invoke((Object)$this$id);
    }
}

