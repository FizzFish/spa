/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.idfa.analysis.UsefulMetrics
 *  cn.sast.idfa.analysis.UsefulMetrics$Companion
 *  io.quarkus.runtime.ShutdownContext
 *  io.quarkus.runtime.StartupContext
 *  io.quarkus.smallrye.metrics.runtime.SmallRyeMetricsRecorder
 *  io.smallrye.metrics.MetricRegistries
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.eclipse.microprofile.metrics.Gauge
 *  org.eclipse.microprofile.metrics.Metric
 *  org.eclipse.microprofile.metrics.MetricID
 *  org.eclipse.microprofile.metrics.MetricRegistry
 *  org.eclipse.microprofile.metrics.MetricRegistry$Type
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.jimple.infoflow.util.ThreadUtils
 */
package cn.sast.idfa.analysis;

import cn.sast.idfa.analysis.UsefulMetrics;
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
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import mu.KLogger;
import mu.KotlinLogging;
import org.eclipse.microprofile.metrics.Gauge;
import org.eclipse.microprofile.metrics.Metric;
import org.eclipse.microprofile.metrics.MetricID;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.jimple.infoflow.util.ThreadUtils;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u0004\u0018\u00010\u000bJ\u0006\u0010;\u001a\u00020<J\u000e\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0019\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\"\u0010!\u001a\u0004\u0018\u00010\u0010*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0018\u0010$\u001a\u00020%*\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R \u0010$\u001a\u00020%*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010(R \u0010)\u001a\u00020%*\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010(R\u001e\u0010,\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001e\u00100\u001a\u00020/2\u0006\u0010+\u001a\u00020/@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001e\u00103\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010.R\u001e\u00106\u001a\u0002052\u0006\u0010+\u001a\u000205@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001e\u00108\u001a\u0002052\u0006\u0010+\u001a\u000205@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00107R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2={"Lcn/sast/idfa/analysis/UsefulMetrics;", "", "<init>", "()V", "registryBASE", "Lorg/eclipse/microprofile/metrics/MetricRegistry;", "getRegistryBASE", "()Lorg/eclipse/microprofile/metrics/MetricRegistry;", "registryVENDOR", "getRegistryVENDOR", "tenuredGenPool", "Ljava/lang/management/MemoryPoolMXBean;", "getTenuredGenPool", "()Ljava/lang/management/MemoryPoolMXBean;", "jvmMemoryUsed", "Lorg/eclipse/microprofile/metrics/Gauge;", "", "getJvmMemoryUsed", "()Lorg/eclipse/microprofile/metrics/Gauge;", "jvmMemoryCommitted", "getJvmMemoryCommitted", "jvmMemoryMax", "getJvmMemoryMax", "freePhysicalSize", "getFreePhysicalSize", "cpuSystemCpuLoad", "", "getCpuSystemCpuLoad", "getMetricAndTestGauge", "Lorg/eclipse/microprofile/metrics/Metric;", "metricID", "Lorg/eclipse/microprofile/metrics/MetricID;", "findTenuredGenPool", "memSize", "getMemSize", "(Lorg/eclipse/microprofile/metrics/Gauge;)Ljava/lang/Long;", "memFmt", "", "getMemFmt", "(J)Ljava/lang/String;", "(Lorg/eclipse/microprofile/metrics/Gauge;)Ljava/lang/String;", "loadFmt", "getLoadFmt", "value", "warningThreshold", "getWarningThreshold", "()J", "", "memoryThresholdExceededPercentage", "getMemoryThresholdExceededPercentage", "()F", "memoryUsed", "getMemoryUsed", "", "isMemoryThresholdTriggered", "()Z", "isLongTermThresholdTriggered", "thread", "Ljava/lang/Thread;", "reset", "", "setWarningThreshold", "percentage", "Companion", "corax-idfa-framework"})
@SourceDebugExtension(value={"SMAP\nUsefulMetrics.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UsefulMetrics.kt\ncn/sast/idfa/analysis/UsefulMetrics\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,207:1\n1#2:208\n*E\n"})
public final class UsefulMetrics {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final MetricRegistry registryBASE = MetricRegistries.get((MetricRegistry.Type)MetricRegistry.Type.BASE);
    @Nullable
    private final MetricRegistry registryVENDOR = MetricRegistries.get((MetricRegistry.Type)MetricRegistry.Type.VENDOR);
    @Nullable
    private final MemoryPoolMXBean tenuredGenPool = this.findTenuredGenPool();
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
    private volatile long warningThreshold;
    private volatile float memoryThresholdExceededPercentage;
    private volatile long memoryUsed;
    private volatile boolean isMemoryThresholdTriggered;
    private volatile boolean isLongTermThresholdTriggered;
    @Nullable
    private Thread thread;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(UsefulMetrics::logger$lambda$8);
    @NotNull
    private static final UsefulMetrics metrics;

    public UsefulMetrics() {
        Gauge gauge;
        Gauge gauge2;
        Gauge gauge3;
        MemoryPoolMXBean it;
        UsefulMetrics usefulMetrics;
        UsefulMetrics usefulMetrics2 = this;
        MemoryPoolMXBean memoryPoolMXBean = this.tenuredGenPool;
        if (memoryPoolMXBean != null) {
            MemoryPoolMXBean memoryPoolMXBean2 = memoryPoolMXBean;
            usefulMetrics = usefulMetrics2;
            boolean bl = false;
            gauge3 = (Gauge)new /* Unavailable Anonymous Inner Class!! */;
            usefulMetrics2 = usefulMetrics;
        } else {
            gauge3 = null;
        }
        usefulMetrics2.jvmMemoryUsed = gauge3;
        UsefulMetrics usefulMetrics3 = this;
        MemoryPoolMXBean memoryPoolMXBean3 = this.tenuredGenPool;
        if (memoryPoolMXBean3 != null) {
            it = memoryPoolMXBean3;
            usefulMetrics = usefulMetrics3;
            boolean bl = false;
            gauge2 = (Gauge)new /* Unavailable Anonymous Inner Class!! */;
            usefulMetrics3 = usefulMetrics;
        } else {
            gauge2 = null;
        }
        usefulMetrics3.jvmMemoryCommitted = gauge2;
        UsefulMetrics usefulMetrics4 = this;
        MemoryPoolMXBean memoryPoolMXBean4 = this.tenuredGenPool;
        if (memoryPoolMXBean4 != null) {
            it = memoryPoolMXBean4;
            usefulMetrics = usefulMetrics4;
            boolean bl = false;
            gauge = (Gauge)new /* Unavailable Anonymous Inner Class!! */;
            usefulMetrics4 = usefulMetrics;
        } else {
            gauge = null;
        }
        usefulMetrics4.jvmMemoryMax = gauge;
        MetricRegistry metricRegistry = this.registryVENDOR;
        Metric metric = metricRegistry != null ? this.getMetricAndTestGauge(metricRegistry, new MetricID("memory.freePhysicalSize")) : null;
        this.freePhysicalSize = metric instanceof Gauge ? (Gauge)metric : null;
        MetricRegistry metricRegistry2 = this.registryVENDOR;
        metric = metricRegistry2 != null ? this.getMetricAndTestGauge(metricRegistry2, new MetricID("cpu.systemCpuLoad")) : null;
        this.cpuSystemCpuLoad = metric instanceof Gauge ? (Gauge)metric : null;
        this.warningThreshold = -1L;
        this.memoryThresholdExceededPercentage = -1.0f;
        this.memoryUsed = -1L;
    }

    @Nullable
    public final MetricRegistry getRegistryBASE() {
        return this.registryBASE;
    }

    @Nullable
    public final MetricRegistry getRegistryVENDOR() {
        return this.registryVENDOR;
    }

    @Nullable
    public final MemoryPoolMXBean getTenuredGenPool() {
        return this.tenuredGenPool;
    }

    @Nullable
    public final Gauge<Long> getJvmMemoryUsed() {
        return this.jvmMemoryUsed;
    }

    @Nullable
    public final Gauge<Long> getJvmMemoryCommitted() {
        return this.jvmMemoryCommitted;
    }

    @Nullable
    public final Gauge<Long> getJvmMemoryMax() {
        return this.jvmMemoryMax;
    }

    @Nullable
    public final Gauge<Long> getFreePhysicalSize() {
        return this.freePhysicalSize;
    }

    @Nullable
    public final Gauge<Double> getCpuSystemCpuLoad() {
        return this.cpuSystemCpuLoad;
    }

    @Nullable
    public final Metric getMetricAndTestGauge(@NotNull MetricRegistry $this$getMetricAndTestGauge, @NotNull MetricID metricID) {
        Intrinsics.checkNotNullParameter((Object)$this$getMetricAndTestGauge, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)metricID, (String)"metricID");
        Metric metric = $this$getMetricAndTestGauge.getMetric(metricID);
        if (metric == null || !(metric instanceof Gauge)) {
            return null;
        }
        try {
            ((Gauge)metric).getValue();
            return metric;
        }
        catch (Error e) {
            logger.error("Accessing Metric " + metricID + " throw an Error:", (Throwable)e);
            return null;
        }
        catch (Exception e) {
            logger.error("Accessing Metric " + metricID + " throw an Exception:", (Throwable)e);
            return null;
        }
    }

    @Nullable
    public final MemoryPoolMXBean findTenuredGenPool() {
        List usablePools = new ArrayList();
        for (MemoryPoolMXBean pool : ManagementFactory.getMemoryPoolMXBeans()) {
            if (pool.getType() != MemoryType.HEAP || !pool.isUsageThresholdSupported()) continue;
            if (Intrinsics.areEqual((Object)pool.getName(), (Object)"Tenured Gen")) {
                Intrinsics.checkNotNull((Object)pool);
                usablePools.add(0, pool);
                continue;
            }
            Intrinsics.checkNotNull((Object)pool);
            usablePools.add(pool);
        }
        if (!((Collection)usablePools).isEmpty()) {
            for (MemoryPoolMXBean pool : usablePools) {
                try {
                    MemoryUsage it = pool.getUsage();
                    boolean bl = false;
                    it.getInit();
                    it.getUsed();
                    it.getCommitted();
                    it.getMax();
                    return pool;
                }
                catch (Error e) {
                    logger.error("Getting MemoryUsage from " + pool.getName() + " throw an Error", (Throwable)e);
                }
                catch (Exception e) {
                    logger.error("Getting MemoryUsage from " + pool.getName() + " throw an Exception", (Throwable)e);
                }
            }
        }
        logger.error("Could not find tenured space");
        return null;
    }

    @Nullable
    public Long getMemSize(@Nullable Gauge<Long> $this$memSize) {
        if ($this$memSize == null) {
            return null;
        }
        Object object = $this$memSize.getValue();
        Long it = (Long)object;
        boolean bl = false;
        return (Long)(it >= 0L ? object : null);
    }

    @NotNull
    public String getMemFmt(long $this$memFmt) {
        String string = "%.1f";
        Object[] objectArray = new Object[]{(double)$this$memFmt / 1024.0 / (double)1024 / (double)1024};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
        return string2;
    }

    @NotNull
    public String getMemFmt(@Nullable Gauge<Long> $this$memFmt) {
        Object object = this.getMemSize($this$memFmt);
        if (object == null || (object = this.getMemFmt(((Long)object).longValue())) == null) {
            object = "?";
        }
        return object;
    }

    @NotNull
    public String getLoadFmt(@Nullable Gauge<Double> $this$loadFmt) {
        if ($this$loadFmt == null) {
            return "?";
        }
        Object object = $this$loadFmt.getValue();
        Double it = (Double)object;
        boolean bl = false;
        Double d = (Double)(it >= 0.0 ? object : null);
        if (d == null) {
            return "?";
        }
        double v = d;
        object = "%3.0f%%";
        Object[] objectArray = new Object[]{v * (double)100};
        String string = String.format((String)object, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"format(...)");
        return string;
    }

    public final long getWarningThreshold() {
        return this.warningThreshold;
    }

    public final float getMemoryThresholdExceededPercentage() {
        return this.memoryThresholdExceededPercentage;
    }

    public final long getMemoryUsed() {
        return this.memoryUsed;
    }

    public final boolean isMemoryThresholdTriggered() {
        return this.isMemoryThresholdTriggered;
    }

    public final boolean isLongTermThresholdTriggered() {
        return this.isLongTermThresholdTriggered;
    }

    public final void reset() {
        Thread thread = this.thread;
        if (thread != null) {
            Thread it = thread;
            boolean bl = false;
            this.thread = null;
            if (!it.isInterrupted()) {
                it.interrupt();
            }
        }
        this.warningThreshold = -1L;
        this.memoryThresholdExceededPercentage = -1.0f;
        this.memoryUsed = -1L;
        this.isMemoryThresholdTriggered = false;
        this.isLongTermThresholdTriggered = false;
    }

    /*
     * WARNING - void declaration
     */
    public final void setWarningThreshold(double percentage) {
        void it;
        Thread thread;
        if (this.thread != null || percentage < 0.01) {
            this.reset();
            return;
        }
        Gauge gauge = this.jvmMemoryUsed;
        if (gauge == null) {
            return;
        }
        Gauge jvmMemoryUsed2 = gauge;
        Gauge gauge2 = this.jvmMemoryMax;
        if (gauge2 == null) {
            return;
        }
        Gauge jvmMemoryMax2 = gauge2;
        Long maxMemory = (Long)jvmMemoryMax2.getValue();
        this.warningThreshold = (long)((double)maxMemory.longValue() * percentage);
        AtomicLong memoryThresholdReachedPrevNanoTime = new AtomicLong(-1L);
        Thread thread2 = thread = ThreadUtils.createGenericThread((Runnable)((Runnable)new /* Unavailable Anonymous Inner Class!! */), (String)"Low memory monitor", (boolean)true);
        UsefulMetrics usefulMetrics = this;
        boolean bl = false;
        it.setPriority(1);
        it.start();
        usefulMetrics.thread = thread;
    }

    private static final Unit logger$lambda$8() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$setMemoryUsed$p(UsefulMetrics $this, long l) {
        $this.memoryUsed = l;
    }

    public static final /* synthetic */ void access$setMemoryThresholdTriggered$p(UsefulMetrics $this, boolean bl) {
        $this.isMemoryThresholdTriggered = bl;
    }

    public static final /* synthetic */ void access$setMemoryThresholdExceededPercentage$p(UsefulMetrics $this, float f) {
        $this.memoryThresholdExceededPercentage = f;
    }

    public static final /* synthetic */ void access$setLongTermThresholdTriggered$p(UsefulMetrics $this, boolean bl) {
        $this.isLongTermThresholdTriggered = bl;
    }

    public static final /* synthetic */ UsefulMetrics access$getMetrics$cp() {
        return metrics;
    }

    static {
        SmallRyeMetricsRecorder recorder = new SmallRyeMetricsRecorder();
        StartupContext startUp = new StartupContext();
        Object object = startUp.getValue("io.quarkus.runtime.ShutdownContext");
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type io.quarkus.runtime.ShutdownContext");
        ShutdownContext shutdown = (ShutdownContext)object;
        recorder.registerMicrometerJvmMetrics(shutdown);
        recorder.registerBaseMetrics();
        recorder.registerVendorMetrics();
        metrics = new UsefulMetrics();
    }
}

