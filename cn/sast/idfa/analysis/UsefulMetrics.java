package cn.sast.idfa.analysis;

import io.quarkus.runtime.ShutdownContext;
import io.quarkus.runtime.StartupContext;
import io.quarkus.smallrye.metrics.runtime.SmallRyeMetricsRecorder;
import io.smallrye.metrics.MetricRegistries;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.microprofile.metrics.Gauge;
import org.eclipse.microprofile.metrics.Metric;
import org.eclipse.microprofile.metrics.MetricID;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.MetricRegistry.Type;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.jimple.infoflow.util.ThreadUtils;

public final class UsefulMetrics {
    private static final Logger logger = LoggerFactory.getLogger(UsefulMetrics.class);
    private static final UsefulMetrics metrics;

    @Nullable
    private final MetricRegistry registryBASE = MetricRegistries.get(Type.BASE);
    @Nullable
    private final MetricRegistry registryVENDOR = MetricRegistries.get(Type.VENDOR);
    @Nullable
    private final MemoryPoolMXBean tenuredGenPool = findTenuredGenPool();
    @Nullable
    private final Gauge<Long> jvmMemoryUsed;
    @Nullable
    private final Gauge<Long> jvmMemoryCommitted;
    @Nullable
    private final Gauge<Long> jvmMemoryMax;
    @Nullable
    private final Gauge<Long> freePhysicalSize;
    @Nullable
    private final Gauge<Double> cpuSystemCpuLoad;
    
    private volatile long warningThreshold = -1L;
    private volatile float memoryThresholdExceededPercentage = -1.0f;
    private volatile long memoryUsed = -1L;
    private volatile boolean isMemoryThresholdTriggered;
    private volatile boolean isLongTermThresholdTriggered;
    @Nullable
    private Thread thread;

    public UsefulMetrics() {
        this.jvmMemoryUsed = createMemoryGauge(bean -> bean.getUsage().getUsed());
        this.jvmMemoryCommitted = createMemoryGauge(bean -> bean.getUsage().getCommitted());
        this.jvmMemoryMax = createMemoryGauge(bean -> bean.getUsage().getMax());

        this.freePhysicalSize = getGaugeFromRegistry(registryVENDOR, "memory.freePhysicalSize");
        this.cpuSystemCpuLoad = getGaugeFromRegistry(registryVENDOR, "cpu.systemCpuLoad");
    }

    @Nullable
    private Gauge<Long> createMemoryGauge(java.util.function.Function<MemoryPoolMXBean, Long> getter) {
        if (tenuredGenPool == null) return null;
        return () -> getter.apply(tenuredGenPool);
    }

    @Nullable
    @SuppressWarnings("unchecked")
    private <T> Gauge<T> getGaugeFromRegistry(@Nullable MetricRegistry registry, String metricName) {
        if (registry == null) return null;
        Metric metric = getMetricAndTestGauge(registry, new MetricID(metricName));
        return metric instanceof Gauge ? (Gauge<T>) metric : null;
    }

    @Nullable
    public final MetricRegistry getRegistryBASE() {
        return registryBASE;
    }

    @Nullable
    public final MetricRegistry getRegistryVENDOR() {
        return registryVENDOR;
    }

    @Nullable
    public final MemoryPoolMXBean getTenuredGenPool() {
        return tenuredGenPool;
    }

    @Nullable
    public final Gauge<Long> getJvmMemoryUsed() {
        return jvmMemoryUsed;
    }

    @Nullable
    public final Gauge<Long> getJvmMemoryCommitted() {
        return jvmMemoryCommitted;
    }

    @Nullable
    public final Gauge<Long> getJvmMemoryMax() {
        return jvmMemoryMax;
    }

    @Nullable
    public final Gauge<Long> getFreePhysicalSize() {
        return freePhysicalSize;
    }

    @Nullable
    public final Gauge<Double> getCpuSystemCpuLoad() {
        return cpuSystemCpuLoad;
    }

    @Nullable
    public final Metric getMetricAndTestGauge(@NotNull MetricRegistry registry, @NotNull MetricID metricID) {
        Metric metric = registry.getMetric(metricID);
        if (!(metric instanceof Gauge)) return null;
        
        try {
            ((Gauge<?>) metric).getValue();
            return metric;
        } catch (Exception e) {
            logger.error("Accessing Metric {} threw an exception:", metricID, e);
            return null;
        }
    }

    @Nullable
    public final MemoryPoolMXBean findTenuredGenPool() {
        List<MemoryPoolMXBean> usablePools = new ArrayList<>();
        for (MemoryPoolMXBean pool : ManagementFactory.getMemoryPoolMXBeans()) {
            if (pool.getType() != MemoryType.HEAP || !pool.isUsageThresholdSupported()) continue;
            
            if ("Tenured Gen".equals(pool.getName())) {
                usablePools.add(0, pool);
            } else {
                usablePools.add(pool);
            }
        }

        for (MemoryPoolMXBean pool : usablePools) {
            try {
                MemoryUsage usage = pool.getUsage();
                usage.getInit();
                usage.getUsed();
                usage.getCommitted();
                usage.getMax();
                return pool;
            } catch (Exception e) {
                logger.error("Getting MemoryUsage from {} threw an exception", pool.getName(), e);
            }
        }

        logger.error("Could not find tenured space");
        return null;
    }

    @Nullable
    public Long getMemSize(@Nullable Gauge<Long> gauge) {
        if (gauge == null) return null;
        Long value = gauge.getValue();
        return value != null && value >= 0 ? value : null;
    }

    @NotNull
    public String getMemFmt(long bytes) {
        return String.format("%.1f", bytes / 1024.0 / 1024 / 1024);
    }

    @NotNull
    public String getMemFmt(@Nullable Gauge<Long> gauge) {
        Long value = getMemSize(gauge);
        return value != null ? getMemFmt(value) : "?";
    }

    @NotNull
    public String getLoadFmt(@Nullable Gauge<Double> gauge) {
        if (gauge == null) return "?";
        Double value = gauge.getValue();
        if (value == null || value < 0) return "?";
        return String.format("%3.0f%%", value * 100);
    }

    public final long getWarningThreshold() {
        return warningThreshold;
    }

    public final float getMemoryThresholdExceededPercentage() {
        return memoryThresholdExceededPercentage;
    }

    public final long getMemoryUsed() {
        return memoryUsed;
    }

    public final boolean isMemoryThresholdTriggered() {
        return isMemoryThresholdTriggered;
    }

    public final boolean isLongTermThresholdTriggered() {
        return isLongTermThresholdTriggered;
    }

    public final void reset() {
        if (thread != null) {
            thread.interrupt();
            thread = null;
        }
        warningThreshold = -1L;
        memoryThresholdExceededPercentage = -1.0f;
        memoryUsed = -1L;
        isMemoryThresholdTriggered = false;
        isLongTermThresholdTriggered = false;
    }

    public final void setWarningThreshold(double percentage) {
        if (thread != null || percentage < 0.01) {
            reset();
            return;
        }
        if (jvmMemoryUsed == null || jvmMemoryMax == null) return;

        Long maxMemory = jvmMemoryMax.getValue();
        if (maxMemory == null) return;

        warningThreshold = (long) (maxMemory * percentage);
        AtomicLong memoryThresholdReachedPrevNanoTime = new AtomicLong(-1L);

        thread = ThreadUtils.createGenericThread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Long used = jvmMemoryUsed.getValue();
                    if (used != null) {
                        memoryUsed = used;
                        if (used > warningThreshold) {
                            float exceeded = (float) (used - warningThreshold) / warningThreshold;
                            memoryThresholdExceededPercentage = exceeded;
                            isMemoryThresholdTriggered = true;
                            
                            long now = System.nanoTime();
                            long prev = memoryThresholdReachedPrevNanoTime.get();
                            if (prev > 0 && now - prev > 60_000_000_000L) {
                                isLongTermThresholdTriggered = true;
                            }
                            memoryThresholdReachedPrevNanoTime.set(now);
                        } else {
                            isMemoryThresholdTriggered = false;
                            isLongTermThresholdTriggered = false;
                        }
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
        }, "Low memory monitor", true);

        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }

    static {
        SmallRyeMetricsRecorder recorder = new SmallRyeMetricsRecorder();
        StartupContext startUp = new StartupContext();
        ShutdownContext shutdown = (ShutdownContext) startUp.getValue("io.quarkus.runtime.ShutdownContext");
        recorder.registerMicrometerJvmMetrics(shutdown);
        recorder.registerBaseMetrics();
        recorder.registerVendorMetrics();
        metrics = new UsefulMetrics();
    }
}
