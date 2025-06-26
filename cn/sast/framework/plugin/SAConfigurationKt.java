/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.CheckType2StringKind
 *  cn.sast.framework.plugin.ConfigSerializable
 *  cn.sast.framework.plugin.SAConfigurationKt
 *  com.feysh.corax.config.api.CheckType
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.plugin;

import cn.sast.api.report.CheckType2StringKind;
import cn.sast.framework.plugin.ConfigSerializable;
import com.feysh.corax.config.api.CheckType;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\"$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"get1to1SpecialIdentifier", "", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "sort", "Ljava/util/LinkedHashSet;", "Lcn/sast/framework/plugin/ConfigSerializable;", "getSort", "(Ljava/util/LinkedHashSet;)Ljava/util/LinkedHashSet;", "corax-framework"})
public final class SAConfigurationKt {
    @NotNull
    public static final String get1to1SpecialIdentifier(@NotNull CheckType checkType) {
        Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
        return (String)CheckType2StringKind.Companion.getCheckType2StringKind().getConvert().invoke((Object)checkType);
    }

    private static final LinkedHashSet<ConfigSerializable> getSort(LinkedHashSet<ConfigSerializable> $this$sort) {
        return (LinkedHashSet)CollectionsKt.toCollection((Iterable)CollectionsKt.sorted((Iterable)$this$sort), (Collection)new LinkedHashSet());
    }

    public static final /* synthetic */ LinkedHashSet access$getSort(LinkedHashSet $receiver) {
        return SAConfigurationKt.getSort((LinkedHashSet)$receiver);
    }
}

