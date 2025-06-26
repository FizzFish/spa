/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.idfa.progressbar.ProgressBarExt$DefaultProcessInfoRenderer
 *  cn.sast.idfa.progressbar.ProgressBarExtKt
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  me.tongfei.progressbar.ProgressBar
 *  me.tongfei.progressbar.ProgressBarRenderer
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.idfa.progressbar;

import cn.sast.idfa.progressbar.ProgressBarExt;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarRenderer;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aQ\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u000326\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u0002H\u00010\u0005\u00a2\u0006\u0002\u0010\n\u001a\n\u0010\u0000\u001a\u00020\u000b*\u00020\u0003\u00a8\u0006\f"}, d2={"wrapper", "Render", "Lme/tongfei/progressbar/ProgressBarRenderer;", "Lme/tongfei/progressbar/ProgressBar;", "newRenderWrapper", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "processBar", "render", "(Lme/tongfei/progressbar/ProgressBar;Lkotlin/jvm/functions/Function2;)Lme/tongfei/progressbar/ProgressBarRenderer;", "Lcn/sast/idfa/progressbar/ProgressBarExt$DefaultProcessInfoRenderer;", "corax-idfa-framework"})
public final class ProgressBarExtKt {
    @NotNull
    public static final <Render extends ProgressBarRenderer> Render wrapper(@NotNull ProgressBar $this$wrapper, @NotNull Function2<? super ProgressBar, ? super ProgressBarRenderer, ? extends Render> newRenderWrapper) {
        Intrinsics.checkNotNullParameter((Object)$this$wrapper, (String)"<this>");
        Intrinsics.checkNotNullParameter(newRenderWrapper, (String)"newRenderWrapper");
        ProgressBar processBar = $this$wrapper;
        Field it = ProgressBar.class.getDeclaredField("action");
        boolean bl = false;
        it.setAccessible(true);
        Object action = it.get(processBar);
        Field field = action.getClass().getDeclaredField("renderer");
        boolean bl2 = false;
        field.setAccessible(true);
        Object object = field.get(action);
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type me.tongfei.progressbar.ProgressBarRenderer");
        ProgressBarRenderer render = (ProgressBarRenderer)object;
        ProgressBarRenderer newRender = (ProgressBarRenderer)newRenderWrapper.invoke((Object)processBar, (Object)render);
        field.set(action, newRender);
        return (Render)newRender;
    }

    @NotNull
    public static final ProgressBarExt.DefaultProcessInfoRenderer wrapper(@NotNull ProgressBar $this$wrapper) {
        Intrinsics.checkNotNullParameter((Object)$this$wrapper, (String)"<this>");
        return (ProgressBarExt.DefaultProcessInfoRenderer)ProgressBarExtKt.wrapper((ProgressBar)$this$wrapper, ProgressBarExtKt::wrapper$lambda$2);
    }

    private static final ProgressBarExt.DefaultProcessInfoRenderer wrapper$lambda$2(ProgressBar processBar, ProgressBarRenderer render) {
        Intrinsics.checkNotNullParameter((Object)processBar, (String)"processBar");
        Intrinsics.checkNotNullParameter((Object)render, (String)"render");
        return new ProgressBarExt.DefaultProcessInfoRenderer(processBar, render);
    }
}

