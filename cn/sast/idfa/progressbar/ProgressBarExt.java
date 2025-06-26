/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.idfa.progressbar.ProgressBarExt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  me.tongfei.progressbar.ProgressBar
 *  me.tongfei.progressbar.ProgressBarBuilder
 *  me.tongfei.progressbar.ProgressBarStyle
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.idfa.progressbar;

import java.text.DecimalFormat;
import java.time.temporal.ChronoUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import me.tongfei.progressbar.ProgressBarStyle;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J;\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016\u00a2\u0006\u0002\b\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n\u00a8\u0006\u001b"}, d2={"Lcn/sast/idfa/progressbar/ProgressBarExt;", "", "updateIntervalMillis", "", "maxProgressLength", "<init>", "(II)V", "getUpdateIntervalMillis", "()I", "setUpdateIntervalMillis", "(I)V", "getMaxProgressLength", "setMaxProgressLength", "getProgressBar", "Lme/tongfei/progressbar/ProgressBar;", "unitName", "", "initialMax", "", "style", "Lme/tongfei/progressbar/ProgressBarStyle;", "builder", "Lkotlin/Function1;", "Lme/tongfei/progressbar/ProgressBarBuilder;", "", "Lkotlin/ExtensionFunctionType;", "DefaultProcessInfoRenderer", "corax-idfa-framework"})
public final class ProgressBarExt {
    private int updateIntervalMillis;
    private int maxProgressLength;

    public ProgressBarExt(int updateIntervalMillis, int maxProgressLength) {
        this.updateIntervalMillis = updateIntervalMillis;
        this.maxProgressLength = maxProgressLength;
    }

    public /* synthetic */ ProgressBarExt(int n, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            n = 500;
        }
        if ((n3 & 2) != 0) {
            n2 = 120;
        }
        this(n, n2);
    }

    public final int getUpdateIntervalMillis() {
        return this.updateIntervalMillis;
    }

    public final void setUpdateIntervalMillis(int n) {
        this.updateIntervalMillis = n;
    }

    public final int getMaxProgressLength() {
        return this.maxProgressLength;
    }

    public final void setMaxProgressLength(int n) {
        this.maxProgressLength = n;
    }

    @NotNull
    public final ProgressBar getProgressBar(@NotNull String unitName, long initialMax, @NotNull ProgressBarStyle style, @NotNull Function1<? super ProgressBarBuilder, Unit> builder2) {
        Intrinsics.checkNotNullParameter((Object)unitName, (String)"unitName");
        Intrinsics.checkNotNullParameter((Object)style, (String)"style");
        Intrinsics.checkNotNullParameter(builder2, (String)"builder");
        ProgressBarBuilder progressBarBuilder = new ProgressBarBuilder().setTaskName(">").showSpeed(new DecimalFormat("#.##")).setStyle(style).showSpeed().setInitialMax(initialMax).setUnit(unitName, 1L).setSpeedUnit(ChronoUnit.SECONDS).setMaxRenderedLength(this.maxProgressLength).continuousUpdate().setUpdateIntervalMillis(this.updateIntervalMillis);
        builder2.invoke((Object)progressBarBuilder);
        ProgressBarBuilder pbb = progressBarBuilder;
        ProgressBar progressBar = pbb.build();
        Intrinsics.checkNotNullExpressionValue((Object)progressBar, (String)"build(...)");
        return progressBar;
    }

    public static /* synthetic */ ProgressBar getProgressBar$default(ProgressBarExt progressBarExt, String string, long l, ProgressBarStyle progressBarStyle, Function1 function1, int n, Object object) {
        if ((n & 4) != 0) {
            progressBarStyle = ProgressBarStyle.COLORFUL_UNICODE_BLOCK;
        }
        if ((n & 8) != 0) {
            function1 = ProgressBarExt::getProgressBar$lambda$0;
        }
        return progressBarExt.getProgressBar(string, l, progressBarStyle, function1);
    }

    private static final Unit getProgressBar$lambda$0(ProgressBarBuilder progressBarBuilder) {
        Intrinsics.checkNotNullParameter((Object)progressBarBuilder, (String)"<this>");
        return Unit.INSTANCE;
    }

    public ProgressBarExt() {
        this(0, 0, 3, null);
    }
}

