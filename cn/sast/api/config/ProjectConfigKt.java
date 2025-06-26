/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ProjectConfigKt
 *  com.feysh.corax.config.api.rules.ProcessRule$ErrorCommit
 *  com.feysh.corax.config.api.rules.ProcessRule$IMatchItem
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.api.config;

import com.feysh.corax.config.api.rules.ProcessRule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004\u00a8\u0006\u0005"}, d2={"validate", "", "", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchItem;", "Lcom/feysh/corax/config/api/rules/ProcessRulesType;", "corax-api"})
@SourceDebugExtension(value={"SMAP\nProjectConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProjectConfig.kt\ncn/sast/api/config/ProjectConfigKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,45:1\n1863#2,2:46\n*S KotlinDebug\n*F\n+ 1 ProjectConfig.kt\ncn/sast/api/config/ProjectConfigKt\n*L\n9#1:46,2\n*E\n"})
public final class ProjectConfigKt {
    public static final void validate(@NotNull List<? extends ProcessRule.IMatchItem> $this$validate) {
        Intrinsics.checkNotNullParameter($this$validate, (String)"<this>");
        Iterable $this$forEach$iv = $this$validate;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ProcessRule.IMatchItem e = (ProcessRule.IMatchItem)element$iv;
            boolean bl = false;
            Object object = e instanceof ProcessRule.ErrorCommit ? (ProcessRule.ErrorCommit)e : null;
            if (object == null || (object = object.getError()) == null) continue;
            Object it = object;
            boolean bl2 = false;
            throw new IllegalStateException(("Invalid process-regex: `" + e + "`, error: " + (String)it).toString());
        }
    }
}

