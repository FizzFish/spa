/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.idfa.analysis.ProcessInfoView
 *  cn.sast.idfa.analysis.ProcessInfoView$Companion
 *  cn.sast.idfa.analysis.UsefulMetrics
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.idfa.analysis;

import cn.sast.idfa.analysis.ProcessInfoView;
import cn.sast.idfa.analysis.UsefulMetrics;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongUnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001$B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\r*\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u0014\u0010 \u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0015R\u0014\u0010\"\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0015\u00a8\u0006%"}, d2={"Lcn/sast/idfa/analysis/ProcessInfoView;", "", "metrics", "Lcn/sast/idfa/analysis/UsefulMetrics;", "<init>", "(Lcn/sast/idfa/analysis/UsefulMetrics;)V", "getMetrics", "()Lcn/sast/idfa/analysis/UsefulMetrics;", "maxUsedMemory", "Ljava/util/concurrent/atomic/AtomicLong;", "getMaxUsedMemory", "()Ljava/util/concurrent/atomic/AtomicLong;", "memFmt", "", "", "getMemFmt", "(J)Ljava/lang/String;", "updateStat", "", "jvmMemoryUsedText", "getJvmMemoryUsedText", "()Ljava/lang/String;", "maxUsedMemoryText", "getMaxUsedMemoryText", "jvmMemoryCommittedText", "getJvmMemoryCommittedText", "jvmMemoryMaxText", "getJvmMemoryMaxText", "jvmMemoryUsageText", "getJvmMemoryUsageText", "freeMemoryText", "getFreeMemoryText", "cpuLoadText", "getCpuLoadText", "processInfoText", "getProcessInfoText", "Companion", "corax-idfa-framework"})
@SourceDebugExtension(value={"SMAP\nProcessInfoView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessInfoView.kt\ncn/sast/idfa/analysis/ProcessInfoView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
public class ProcessInfoView {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final UsefulMetrics metrics;
    @NotNull
    private final AtomicLong maxUsedMemory;
    @NotNull
    private static final ProcessInfoView globalProcessInfo = new ProcessInfoView(null, 1, null);

    public ProcessInfoView(@NotNull UsefulMetrics metrics) {
        Intrinsics.checkNotNullParameter((Object)metrics, (String)"metrics");
        this.metrics = metrics;
        this.maxUsedMemory = new AtomicLong(0L);
    }

    public /* synthetic */ ProcessInfoView(UsefulMetrics usefulMetrics, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            usefulMetrics = UsefulMetrics.Companion.getMetrics();
        }
        this(usefulMetrics);
    }

    @NotNull
    public final UsefulMetrics getMetrics() {
        return this.metrics;
    }

    @NotNull
    public final AtomicLong getMaxUsedMemory() {
        return this.maxUsedMemory;
    }

    @NotNull
    public String getMemFmt(long $this$memFmt) {
        String string = "%.1f";
        Object[] objectArray = new Object[]{(double)$this$memFmt / 1024.0 / (double)1024 / (double)1024};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
        return string2;
    }

    public final void updateStat() {
        block0: {
            Object object = this.metrics.getJvmMemoryUsed();
            if (object == null || (object = (Long)object.getValue()) == null) break block0;
            long usedMemory = ((Number)object).longValue();
            boolean bl = false;
            this.maxUsedMemory.updateAndGet((LongUnaryOperator)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    @NotNull
    public String getJvmMemoryUsedText() {
        this.updateStat();
        UsefulMetrics $this$_get_jvmMemoryUsedText__u24lambda_u241 = this.metrics;
        boolean bl = false;
        return $this$_get_jvmMemoryUsedText__u24lambda_u241.getMemFmt($this$_get_jvmMemoryUsedText__u24lambda_u241.getJvmMemoryUsed()) + (this.metrics.isLongTermThresholdTriggered() ? "(JVM mem)" : "") + (this.metrics.isMemoryThresholdTriggered() ? "!" : "");
    }

    @NotNull
    public String getMaxUsedMemoryText() {
        return this.getMemFmt(this.maxUsedMemory.get());
    }

    @NotNull
    public String getJvmMemoryCommittedText() {
        UsefulMetrics $this$_get_jvmMemoryCommittedText__u24lambda_u242 = this.metrics;
        boolean bl = false;
        return $this$_get_jvmMemoryCommittedText__u24lambda_u242.getMemFmt($this$_get_jvmMemoryCommittedText__u24lambda_u242.getJvmMemoryCommitted());
    }

    @NotNull
    public String getJvmMemoryMaxText() {
        UsefulMetrics $this$_get_jvmMemoryMaxText__u24lambda_u243 = this.metrics;
        boolean bl = false;
        return $this$_get_jvmMemoryMaxText__u24lambda_u243.getMemFmt($this$_get_jvmMemoryMaxText__u24lambda_u243.getJvmMemoryMax()) + "G";
    }

    @NotNull
    public String getJvmMemoryUsageText() {
        return this.getJvmMemoryUsedText() + "/" + this.getMaxUsedMemoryText() + "/" + this.getJvmMemoryCommittedText() + "/" + this.getJvmMemoryMaxText();
    }

    @NotNull
    public String getFreeMemoryText() {
        String string;
        UsefulMetrics $this$_get_freeMemoryText__u24lambda_u244 = this.metrics;
        boolean bl = false;
        Long phy = $this$_get_freeMemoryText__u24lambda_u244.getMemSize($this$_get_freeMemoryText__u24lambda_u244.getFreePhysicalSize());
        Object object = phy;
        if (object != null && (object = this.getMemFmt(((Long)object).longValue())) != null) {
            Object m = object;
            boolean bl2 = false;
            string = (String)m + "G";
        } else {
            string = null;
        }
        return "free:" + string + (phy != null && (double)phy.longValue() < 8.05306368E8 ? "(low memory warning!)" : "");
    }

    @NotNull
    public String getCpuLoadText() {
        UsefulMetrics $this$_get_cpuLoadText__u24lambda_u246 = this.metrics;
        boolean bl = false;
        String value = $this$_get_cpuLoadText__u24lambda_u246.getLoadFmt($this$_get_cpuLoadText__u24lambda_u246.getCpuSystemCpuLoad());
        return "cpu:" + value;
    }

    @NotNull
    public String getProcessInfoText() {
        return this.getJvmMemoryUsageText() + " " + this.getFreeMemoryText();
    }

    public ProcessInfoView() {
        this(null, 1, null);
    }

    public static final /* synthetic */ ProcessInfoView access$getGlobalProcessInfo$cp() {
        return globalProcessInfo;
    }
}

