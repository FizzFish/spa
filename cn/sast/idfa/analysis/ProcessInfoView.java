package cn.sast.idfa.analysis;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongUnaryOperator;
import org.jetbrains.annotations.NotNull;

public class ProcessInfoView {
    private static final ProcessInfoView globalProcessInfo = new ProcessInfoView();
    
    @NotNull
    private final UsefulMetrics metrics;
    @NotNull
    private final AtomicLong maxUsedMemory;

    public ProcessInfoView(@NotNull UsefulMetrics metrics) {
        if (metrics == null) {
            throw new IllegalArgumentException("metrics cannot be null");
        }
        this.metrics = metrics;
        this.maxUsedMemory = new AtomicLong(0L);
    }

    public ProcessInfoView() {
        this(UsefulMetrics.getMetrics());
    }

    @NotNull
    public UsefulMetrics getMetrics() {
        return metrics;
    }

    @NotNull
    public AtomicLong getMaxUsedMemory() {
        return maxUsedMemory;
    }

    @NotNull
    public String getMemFmt(long bytes) {
        return String.format("%.1f", bytes / 1024.0 / 1024 / 1024);
    }

    public void updateStat() {
        Long usedMemory = metrics.getJvmMemoryUsed().getValue();
        if (usedMemory != null) {
            maxUsedMemory.updateAndGet(current -> Math.max(current, usedMemory));
        }
    }

    @NotNull
    public String getJvmMemoryUsedText() {
        updateStat();
        String memFmt = metrics.getMemFmt(metrics.getJvmMemoryUsed());
        return memFmt + 
               (metrics.isLongTermThresholdTriggered() ? "(JVM mem)" : "") + 
               (metrics.isMemoryThresholdTriggered() ? "!" : "");
    }

    @NotNull
    public String getMaxUsedMemoryText() {
        return getMemFmt(maxUsedMemory.get());
    }

    @NotNull
    public String getJvmMemoryCommittedText() {
        return metrics.getMemFmt(metrics.getJvmMemoryCommitted());
    }

    @NotNull
    public String getJvmMemoryMaxText() {
        return metrics.getMemFmt(metrics.getJvmMemoryMax()) + "G";
    }

    @NotNull
    public String getJvmMemoryUsageText() {
        return getJvmMemoryUsedText() + "/" + 
               getMaxUsedMemoryText() + "/" + 
               getJvmMemoryCommittedText() + "/" + 
               getJvmMemoryMaxText();
    }

    @NotNull
    public String getFreeMemoryText() {
        Long phy = metrics.getMemSize(metrics.getFreePhysicalSize());
        String memStr = phy != null ? getMemFmt(phy) + "G" : null;
        return "free:" + memStr + 
               (phy != null && phy < 805306368L ? "(low memory warning!)" : "");
    }

    @NotNull
    public String getCpuLoadText() {
        return "cpu:" + metrics.getLoadFmt(metrics.getCpuSystemCpuLoad());
    }

    @NotNull
    public String getProcessInfoText() {
        return getJvmMemoryUsageText() + " " + getFreeMemoryText();
    }

    public static ProcessInfoView getGlobalProcessInfo() {
        return globalProcessInfo;
    }
}