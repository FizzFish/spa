/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.entries.apk.ApkLifeCycleComponentKt
 *  cn.sast.framework.entries.apk.ApkLifeCycleComponentKt$WhenMappings
 *  cn.sast.framework.entries.apk.CallbackAnalyzerType
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.jimple.infoflow.android.InfoflowAndroidConfiguration$CallbackAnalyzer
 */
package cn.sast.framework.entries.apk;

import cn.sast.framework.entries.apk.ApkLifeCycleComponentKt;
import cn.sast.framework.entries.apk.CallbackAnalyzerType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0000\u001a\u00020\u0002*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\u0006"}, d2={"convert", "Lcn/sast/framework/entries/apk/CallbackAnalyzerType;", "Lsoot/jimple/infoflow/android/InfoflowAndroidConfiguration$CallbackAnalyzer;", "getConvert", "(Lsoot/jimple/infoflow/android/InfoflowAndroidConfiguration$CallbackAnalyzer;)Lcn/sast/framework/entries/apk/CallbackAnalyzerType;", "(Lcn/sast/framework/entries/apk/CallbackAnalyzerType;)Lsoot/jimple/infoflow/android/InfoflowAndroidConfiguration$CallbackAnalyzer;", "corax-framework"})
public final class ApkLifeCycleComponentKt {
    @NotNull
    public static final CallbackAnalyzerType getConvert(@NotNull InfoflowAndroidConfiguration.CallbackAnalyzer $this$convert) {
        Intrinsics.checkNotNullParameter((Object)$this$convert, (String)"<this>");
        return switch (WhenMappings.$EnumSwitchMapping$0[$this$convert.ordinal()]) {
            case 1 -> CallbackAnalyzerType.Default;
            case 2 -> CallbackAnalyzerType.Fast;
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    @NotNull
    public static final InfoflowAndroidConfiguration.CallbackAnalyzer getConvert(@NotNull CallbackAnalyzerType $this$convert) {
        Intrinsics.checkNotNullParameter((Object)$this$convert, (String)"<this>");
        return switch (WhenMappings.$EnumSwitchMapping$1[$this$convert.ordinal()]) {
            case 1 -> InfoflowAndroidConfiguration.CallbackAnalyzer.Default;
            case 2 -> InfoflowAndroidConfiguration.CallbackAnalyzer.Fast;
            default -> throw new NoWhenBranchMatchedException();
        };
    }
}

