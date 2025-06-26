/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.framework.SootCtx
 *  cn.sast.framework.SootCtxKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.Scene
 */
package cn.sast.framework;

import cn.sast.api.config.MainConfig;
import cn.sast.framework.SootCtx;
import java.lang.reflect.Field;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.Scene;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"excludedPackages", "Ljava/util/LinkedList;", "", "Lsoot/Scene;", "getExcludedPackages", "(Lsoot/Scene;)Ljava/util/LinkedList;", "sootCtx", "Lcn/sast/framework/SootCtx;", "Lcn/sast/api/config/MainConfig;", "getSootCtx", "(Lcn/sast/api/config/MainConfig;)Lcn/sast/framework/SootCtx;", "corax-framework"})
public final class SootCtxKt {
    private static final LinkedList<String> getExcludedPackages(Scene $this$excludedPackages) {
        Field field = $this$excludedPackages.getClass().getDeclaredField("excludedPackages");
        boolean bl = false;
        field.setAccessible(true);
        Object object = field.get($this$excludedPackages);
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type java.util.LinkedList<kotlin.String>");
        return (LinkedList)object;
    }

    @NotNull
    public static final SootCtx getSootCtx(@NotNull MainConfig $this$sootCtx) {
        Intrinsics.checkNotNullParameter((Object)$this$sootCtx, (String)"<this>");
        return new SootCtx($this$sootCtx);
    }

    public static final /* synthetic */ LinkedList access$getExcludedPackages(Scene $receiver) {
        return SootCtxKt.getExcludedPackages((Scene)$receiver);
    }
}

