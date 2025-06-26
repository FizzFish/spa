/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfigKt
 *  cn.sast.api.report.ProjectMetrics
 *  cn.sast.api.report.ProjectMetrics$$serializer
 *  cn.sast.api.report.Report
 *  cn.sast.api.util.IMonitor
 *  cn.sast.api.util.PhaseIntervalTimerKt
 *  cn.sast.api.util.Timer
 *  cn.sast.common.CustomRepeatingTimer
 *  cn.sast.common.IResDirectory
 *  cn.sast.framework.metrics.DynamicLookupSerializer
 *  cn.sast.framework.metrics.MetricsMonitor
 *  cn.sast.framework.metrics.MetricsMonitor$$serializer
 *  cn.sast.framework.metrics.MetricsMonitor$Companion
 *  cn.sast.framework.metrics.MetricsMonitor$MetricsSnapshot
 *  cn.sast.framework.metrics.MetricsMonitor$MetricsSnapshot$$serializer
 *  cn.sast.framework.metrics.MetricsMonitor$PhaseTimer
 *  cn.sast.framework.metrics.MetricsMonitor$PhaseTimer$$serializer
 *  cn.sast.framework.metrics.MetricsMonitorKt
 *  cn.sast.framework.metrics.ReportKey
 *  cn.sast.framework.metrics.ReportKey$$serializer
 *  cn.sast.framework.result.ResultCollector
 *  cn.sast.framework.result.ResultCounter
 *  cn.sast.idfa.analysis.UsefulMetrics
 *  com.charleskorn.kaml.Yaml
 *  com.charleskorn.kaml.YamlConfiguration
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.time.Duration
 *  kotlin.time.DurationKt
 *  kotlin.time.DurationUnit
 *  kotlinx.serialization.ContextualSerializer
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.Transient
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  kotlinx.serialization.modules.SerializersModule
 *  kotlinx.serialization.modules.SerializersModuleBuilder
 *  org.eclipse.microprofile.metrics.Gauge
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.metrics;

import cn.sast.api.config.MainConfigKt;
import cn.sast.api.report.ProjectMetrics;
import cn.sast.api.report.ProjectMetrics$;
import cn.sast.api.report.Report;
import cn.sast.api.util.IMonitor;
import cn.sast.api.util.PhaseIntervalTimerKt;
import cn.sast.api.util.Timer;
import cn.sast.common.CustomRepeatingTimer;
import cn.sast.common.IResDirectory;
import cn.sast.framework.metrics.DynamicLookupSerializer;
import cn.sast.framework.metrics.MetricsMonitor;
import cn.sast.framework.metrics.MetricsMonitor$;
import cn.sast.framework.metrics.MetricsMonitor$MetricsSnapshot$;
import cn.sast.framework.metrics.MetricsMonitor$PhaseTimer$;
import cn.sast.framework.metrics.MetricsMonitorKt;
import cn.sast.framework.metrics.ReportKey;
import cn.sast.framework.result.ResultCollector;
import cn.sast.framework.result.ResultCounter;
import cn.sast.idfa.analysis.UsefulMetrics;
import com.charleskorn.kaml.Yaml;
import com.charleskorn.kaml.YamlConfiguration;
import java.io.Closeable;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongUnaryOperator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;
import org.eclipse.microprofile.metrics.Gauge;
import org.jetbrains.annotations.NotNull;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 Z2\u00020\u0001:\u0004XYZ[B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003B\u00b1\u0001\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0014\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0014\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\u0002\u0010\u001fJ\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u0007H\u0016J\u0006\u0010;\u001a\u00020<J\u0006\u0010?\u001a\u00020<J\u0006\u0010@\u001a\u00020<J)\u0010A\u001a\u00020<\"\b\b\u0000\u0010B*\u00020C2\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u0002HBH\u0007\u00a2\u0006\u0004\bF\u0010GJ\u0016\u0010A\u001a\u00020<2\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0007J\u000e\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020JJ\u000e\u0010K\u001a\u00020<2\u0006\u0010L\u001a\u00020MJ\u000e\u0010N\u001a\u00020<2\u0006\u0010O\u001a\u00020/J\u0006\u0010P\u001a\u00020<J%\u0010Q\u001a\u00020<2\u0006\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0001\u00a2\u0006\u0002\bWR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\t\u0012\u00070\u0018\u00a2\u0006\u0002\b$0\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010!R\"\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020*0)8\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b+\u0010\u0003R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00148\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b0\u0010\u0003R\u0018\u00101\u001a\u00020\u000b*\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00103R \u00101\u001a\u00020\u000b*\n\u0012\u0004\u0012\u00020\t\u0018\u0001048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00105R\u001c\u00106\u001a\u0002078\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\u0003\u001a\u0004\b9\u0010:R\u0016\u0010,\u001a\u00020=8\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b>\u0010\u0003\u00a8\u0006\\"}, d2={"Lcn/sast/framework/metrics/MetricsMonitor;", "Lcn/sast/api/util/IMonitor;", "<init>", "()V", "seen0", "", "beginDate", "", "beginMillis", "", "elapsedSeconds", "", "elapsedTime", "endDate", "endTime", "jvmMemoryUsedMax", "jvmMemoryMax", "projectMetrics", "Lcn/sast/api/report/ProjectMetrics;", "phaseTimer", "", "Lcn/sast/framework/metrics/MetricsMonitor$PhaseTimer;", "final", "", "", "reports", "Lcn/sast/framework/metrics/ReportKey;", "snapshot", "Lcn/sast/framework/metrics/MetricsMonitor$MetricsSnapshot;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JDLjava/lang/String;Ljava/lang/String;JDDLcn/sast/api/report/ProjectMetrics;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBeginMillis", "()J", "getProjectMetrics", "()Lcn/sast/api/report/ProjectMetrics;", "Lkotlinx/serialization/Contextual;", "beginNanoTime", "getBeginNanoTime$annotations", "getBeginNanoTime", "allPhaseTimer", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcn/sast/api/util/Timer;", "getAllPhaseTimer$annotations", "timer", "phase", "analyzeFinishHook", "Ljava/lang/Thread;", "getAnalyzeFinishHook$annotations", "g", "getG", "(J)D", "Lorg/eclipse/microprofile/metrics/Gauge;", "(Lorg/eclipse/microprofile/metrics/Gauge;)D", "maxUsedMemory", "Ljava/util/concurrent/atomic/AtomicLong;", "getMaxUsedMemory$annotations", "getMaxUsedMemory", "()Ljava/util/concurrent/atomic/AtomicLong;", "record", "", "Lcn/sast/common/CustomRepeatingTimer;", "getTimer$annotations", "start", "stop", "put", "T", "", "name", "value", "putNumber", "(Ljava/lang/String;Ljava/lang/Number;)V", "take", "result", "Lcn/sast/framework/result/ResultCollector;", "serialize", "out", "Lcn/sast/common/IResDirectory;", "addAnalyzeFinishHook", "t", "runAnalyzeFinishHook", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "MetricsSnapshot", "PhaseTimer", "Companion", "$serializer", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nMetricsMonitor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MetricsMonitor.kt\ncn/sast/framework/metrics/MetricsMonitor\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 6 SerializersModuleBuilders.kt\nkotlinx/serialization/modules/SerializersModuleBuildersKt\n*L\n1#1,249:1\n72#2,2:250\n1#3:252\n1#3:253\n1485#4:254\n1510#4,3:255\n1513#4,3:265\n1246#4,4:270\n1246#4,4:276\n808#4,11:280\n1863#4,2:291\n381#5,7:258\n462#5:268\n412#5:269\n477#5:274\n423#5:275\n31#6,3:293\n*S KotlinDebug\n*F\n+ 1 MetricsMonitor.kt\ncn/sast/framework/metrics/MetricsMonitor\n*L\n92#1:250,2\n92#1:252\n159#1:254\n159#1:255,3\n159#1:265,3\n159#1:270,4\n160#1:276,4\n165#1:280,11\n218#1:291,2\n159#1:258,7\n159#1:268\n159#1:269\n160#1:274\n160#1:275\n228#1:293,3\n*E\n"})
public final class MetricsMonitor
implements IMonitor {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private String beginDate;
    private final long beginMillis;
    private double elapsedSeconds;
    @NotNull
    private String elapsedTime;
    @NotNull
    private String endDate;
    private long endTime;
    private double jvmMemoryUsedMax;
    private final double jvmMemoryMax;
    @NotNull
    private final ProjectMetrics projectMetrics;
    @NotNull
    private final List<PhaseTimer> phaseTimer;
    @NotNull
    private final Map<String, Object> final;
    @NotNull
    private final List<ReportKey> reports;
    @NotNull
    private final List<MetricsSnapshot> snapshot;
    private final long beginNanoTime;
    @NotNull
    private final ConcurrentHashMap<String, Timer> allPhaseTimer;
    @NotNull
    private final List<Thread> analyzeFinishHook;
    @NotNull
    private final AtomicLong maxUsedMemory;
    @NotNull
    private final CustomRepeatingTimer timer;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;
    @NotNull
    private static final Yaml yamlFormat;

    /*
     * WARNING - void declaration
     */
    public MetricsMonitor() {
        void $this$timer_u24lambda_u246;
        CustomRepeatingTimer customRepeatingTimer;
        this.beginDate = "";
        this.beginMillis = System.currentTimeMillis();
        this.elapsedSeconds = -1.0;
        this.elapsedTime = "";
        this.endDate = "";
        this.jvmMemoryUsedMax = -1.0;
        Gauge gauge = UsefulMetrics.Companion.getMetrics().getJvmMemoryMax();
        this.jvmMemoryMax = MetricsMonitorKt.inMemGB$default((Number)(gauge != null ? Double.valueOf(this.getG(gauge)) : null), (int)0, (int)1, null);
        this.projectMetrics = new ProjectMetrics(null, null, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0.0f, 0, 0, 0, 0L, 0L, 0L, 0, 0, 0, 0.0f, 0, 0.0f, 0, 0xFFFFFF, null);
        this.phaseTimer = new ArrayList();
        this.final = new LinkedHashMap();
        this.reports = new ArrayList();
        this.snapshot = new ArrayList();
        this.beginNanoTime = PhaseIntervalTimerKt.currentNanoTime();
        this.allPhaseTimer = new ConcurrentHashMap();
        this.analyzeFinishHook = new ArrayList();
        this.maxUsedMemory = new AtomicLong(0L);
        CustomRepeatingTimer customRepeatingTimer2 = customRepeatingTimer = new CustomRepeatingTimer(2000L, () -> MetricsMonitor.timer$lambda$5(this));
        MetricsMonitor metricsMonitor = this;
        boolean bl = false;
        $this$timer_u24lambda_u246.setRepeats(true);
        this.record();
        metricsMonitor.timer = customRepeatingTimer;
    }

    public final long getBeginMillis() {
        return this.beginMillis;
    }

    @NotNull
    public ProjectMetrics getProjectMetrics() {
        return this.projectMetrics;
    }

    public final long getBeginNanoTime() {
        return this.beginNanoTime;
    }

    @Transient
    public static /* synthetic */ void getBeginNanoTime$annotations() {
    }

    @Transient
    private static /* synthetic */ void getAllPhaseTimer$annotations() {
    }

    @NotNull
    public Timer timer(@NotNull String phase) {
        Intrinsics.checkNotNullParameter((Object)phase, (String)"phase");
        ConcurrentMap $this$getOrPut$iv = this.allPhaseTimer;
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(phase);
        if (object == null) {
            boolean bl = false;
            Timer default$iv = new Timer(phase);
            boolean bl2 = false;
            object = $this$getOrPut$iv.putIfAbsent(phase, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        Intrinsics.checkNotNullExpressionValue(object, (String)"getOrPut(...)");
        return (Timer)object;
    }

    @Transient
    private static /* synthetic */ void getAnalyzeFinishHook$annotations() {
    }

    private final double getG(long $this$g) {
        return (double)$this$g / 1024.0 / 1024.0 / 1024.0;
    }

    private final double getG(Gauge<Long> $this$g) {
        if ($this$g == null) {
            return -1.0;
        }
        Object object = $this$g.getValue();
        Long it = (Long)object;
        boolean bl = false;
        Long l = (Long)(it >= 0L ? object : null);
        if (l == null) {
            return -1.0;
        }
        long v = l;
        return this.getG(v);
    }

    @NotNull
    public final AtomicLong getMaxUsedMemory() {
        return this.maxUsedMemory;
    }

    @Transient
    public static /* synthetic */ void getMaxUsedMemory$annotations() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public final void record() {
        UsefulMetrics m = UsefulMetrics.Companion.getMetrics();
        MetricsMonitor metricsMonitor = this;
        synchronized (metricsMonitor) {
            Double d;
            boolean bl = false;
            Object object = m.getJvmMemoryUsed();
            if (object != null && (object = (Long)object.getValue()) != null) {
                long usedMemory = ((Number)object).longValue();
                boolean bl2 = false;
                this.maxUsedMemory.updateAndGet((LongUnaryOperator)new /* Unavailable Anonymous Inner Class!! */);
            }
            Collection collection = this.snapshot;
            double d2 = PhaseIntervalTimerKt.nanoTimeInSeconds$default((Number)MetricsMonitorKt.timeSub((Long)PhaseIntervalTimerKt.currentNanoTime(), (long)this.beginNanoTime), (int)0, (int)1, null);
            Gauge gauge = m.getJvmMemoryUsed();
            Double d3 = MetricsMonitorKt.inMemGB$default((Number)(gauge != null ? Double.valueOf(this.getG(gauge)) : null), (int)0, (int)1, null);
            Double d4 = MetricsMonitorKt.inMemGB$default((Number)this.getG(this.maxUsedMemory.get()), (int)0, (int)1, null);
            Gauge gauge2 = m.getJvmMemoryCommitted();
            Double d5 = MetricsMonitorKt.inMemGB$default((Number)(gauge2 != null ? Double.valueOf(this.getG(gauge2)) : null), (int)0, (int)1, null);
            Gauge gauge3 = m.getFreePhysicalSize();
            Double d6 = MetricsMonitorKt.inMemGB$default((Number)(gauge3 != null ? Double.valueOf(this.getG(gauge3)) : null), (int)0, (int)1, null);
            Object object2 = m.getCpuSystemCpuLoad();
            if (object2 != null && (object2 = (Double)object2.getValue()) != null) {
                void it;
                double d7 = ((Number)object2).doubleValue();
                Double d8 = d6;
                Double d9 = d5;
                Double d10 = d4;
                Double d11 = d3;
                double d12 = d2;
                boolean bl3 = false;
                Double d13 = PhaseIntervalTimerKt.retainDecimalPlaces$default((double)it, (int)2, null, (int)4, null);
                d2 = d12;
                d3 = d11;
                d4 = d10;
                d5 = d9;
                d6 = d8;
                d = d13;
            } else {
                d = null;
            }
            Double d14 = d;
            Double d15 = d6;
            Double d16 = d5;
            Double d17 = d4;
            Double d18 = d3;
            double d19 = d2;
            collection.add(new MetricsSnapshot(d19, d18, d17, d16, d15, d14));
            Unit unit = Unit.INSTANCE;
        }
    }

    @Transient
    private static /* synthetic */ void getTimer$annotations() {
    }

    public final void start() {
        this.timer.start();
    }

    public final void stop() {
        this.timer.stop();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @JvmName(name="putNumber")
    public final <T extends Number> void putNumber(@NotNull String name, @NotNull T value) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(value, (String)"value");
        MetricsMonitor metricsMonitor = this;
        synchronized (metricsMonitor) {
            boolean bl = false;
            Map map = this.final;
            Pair pair = TuplesKt.to((Object)name, value);
            map.put(pair.getFirst(), pair.getSecond());
            Unit unit = Unit.INSTANCE;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void put(@NotNull String name, @NotNull String value) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        MetricsMonitor metricsMonitor = this;
        synchronized (metricsMonitor) {
            boolean bl = false;
            Map map = this.final;
            Pair pair = TuplesKt.to((Object)name, (Object)value);
            map.put(pair.getFirst(), pair.getSecond());
            Unit unit = Unit.INSTANCE;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public final void take(@NotNull ResultCollector result) {
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
        MetricsMonitor metricsMonitor = this;
        synchronized (metricsMonitor) {
            void $this$filterIsInstanceTo$iv$iv;
            Iterable $this$mapKeysTo$iv$iv;
            Iterable $this$mapKeys$iv;
            Map map;
            Map.Entry it$iv$iv;
            void $this$mapValuesTo$iv$iv;
            Map $this$mapValues$iv;
            Object value$iv$iv$iv;
            Map $this$getOrPut$iv$iv$iv;
            Object key$iv$iv;
            void $this$groupByTo$iv$iv;
            boolean bl = false;
            this.getProjectMetrics().setSerializedReports(result.getReports().size());
            Collection collection = this.reports;
            Object $this$groupBy$iv = result.getReports();
            boolean $i$f$groupBy = false;
            Iterable iterable = $this$groupBy$iv;
            Object destination$iv$iv = new LinkedHashMap();
            boolean $i$f$groupByTo = false;
            for (Object element$iv$iv : $this$groupByTo$iv$iv) {
                Object object;
                Report it = (Report)element$iv$iv;
                boolean bl2 = false;
                key$iv$iv = new ReportKey(it.getCategory(), it.getType(), 0, 4, null);
                $this$getOrPut$iv$iv$iv = destination$iv$iv;
                boolean $i$f$getOrPut = false;
                value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
                if (value$iv$iv$iv == null) {
                    boolean bl3 = false;
                    List answer$iv$iv$iv = new ArrayList();
                    $this$getOrPut$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                    object = answer$iv$iv$iv;
                } else {
                    object = value$iv$iv$iv;
                }
                List list$iv$iv = (List)object;
                list$iv$iv.add(element$iv$iv);
            }
            $this$groupBy$iv = destination$iv$iv;
            boolean $i$f$mapValues = false;
            $this$groupByTo$iv$iv = $this$mapValues$iv;
            destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity((int)$this$mapValues$iv.size()));
            boolean $i$f$mapValuesTo = false;
            Iterable $this$associateByTo$iv$iv$iv = $this$mapValuesTo$iv$iv.entrySet();
            boolean $i$f$associateByTo = false;
            for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
                void it;
                key$iv$iv = (Map.Entry)element$iv$iv$iv;
                $this$getOrPut$iv$iv$iv = destination$iv$iv;
                boolean bl4 = false;
                value$iv$iv$iv = (Map.Entry)element$iv$iv$iv;
                Object k = it$iv$iv.getKey();
                map = $this$getOrPut$iv$iv$iv;
                boolean bl5 = false;
                Integer n = ((Collection)it.getValue()).size();
                map.put(k, n);
            }
            $this$mapValues$iv = destination$iv$iv;
            boolean $i$f$mapKeys = false;
            $this$mapValuesTo$iv$iv = $this$mapKeys$iv;
            destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity((int)$this$mapKeys$iv.size()));
            boolean $i$f$mapKeysTo = false;
            $this$associateByTo$iv$iv$iv = $this$mapKeysTo$iv$iv.entrySet();
            $i$f$associateByTo = false;
            for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
                void it$iv$iv2;
                void it;
                it$iv$iv = (Map.Entry)element$iv$iv$iv;
                map = destination$iv$iv;
                boolean bl6 = false;
                ((ReportKey)it.getKey()).setSize(((Number)it.getValue()).intValue());
                Map.Entry bl4 = (Map.Entry)element$iv$iv$iv;
                ReportKey reportKey = (ReportKey)it.getKey();
                Map map2 = map;
                boolean bl7 = false;
                Object v = it$iv$iv2.getValue();
                map2.put(reportKey, v);
            }
            $this$mapKeys$iv = destination$iv$iv.keySet();
            CollectionsKt.addAll((Collection)collection, (Iterable)$this$mapKeys$iv);
            Iterable $this$filterIsInstance$iv = result.getCollectors();
            boolean $i$f$filterIsInstance = false;
            $this$mapKeysTo$iv$iv = $this$filterIsInstance$iv;
            destination$iv$iv = new ArrayList();
            boolean $i$f$filterIsInstanceTo = false;
            for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
                if (!(element$iv$iv instanceof ResultCounter)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            ResultCounter counter = (ResultCounter)CollectionsKt.firstOrNull((List)((List)destination$iv$iv));
            if (counter != null) {
                this.putNumber("infoflow.results", (Number)counter.getInfoflowResCount().get());
                this.putNumber("infoflow.abstraction", (Number)counter.getInfoflowAbsAtSinkCount().get());
                this.putNumber("symbolic.execution", (Number)counter.getSymbolicUTbotCount().get());
                this.putNumber("PreAnalysis.results", (Number)counter.getPreAnalysisResultCount().get());
                this.putNumber("built-in.Analysis.results", (Number)counter.getBuiltInAnalysisCount().get());
                this.putNumber("AbstractInterpretationAnalysis.results", (Number)counter.getDataFlowCount().get());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void serialize(@NotNull IResDirectory out) {
        Intrinsics.checkNotNullParameter((Object)out, (String)"out");
        this.stop();
        Path file = out.resolve("metrics.yml").getPath();
        MetricsMonitor metricsMonitor = this;
        synchronized (metricsMonitor) {
            boolean bl = false;
            this.getProjectMetrics().process();
            this.beginDate = MetricsMonitorKt.getDateStringFromMillis((long)this.beginMillis);
            for (Map.Entry object2 : ((Map)this.allPhaseTimer).entrySet()) {
                String phaseName = (String)object2.getKey();
                Timer t = (Timer)object2.getValue();
                this.phaseTimer.add(new PhaseTimer(phaseName, PhaseIntervalTimerKt.nanoTimeInSeconds$default((Number)MetricsMonitorKt.timeSub((Long)t.getStartTime(), (long)this.beginNanoTime), (int)0, (int)1, null), PhaseIntervalTimerKt.nanoTimeInSeconds$default((Number)t.getElapsedTime(), (int)0, (int)1, null), t.getPhaseStartCount().getValue(), PhaseIntervalTimerKt.nanoTimeInSeconds((Number)t.getPhaseAverageElapsedTime(), (int)6), PhaseIntervalTimerKt.nanoTimeInSeconds$default((Number)MetricsMonitorKt.timeSub((Long)t.getEndTime(), (long)this.beginNanoTime), (int)0, (int)1, null)));
            }
            CollectionsKt.sortWith((List)this.phaseTimer, (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */));
            this.endTime = PhaseIntervalTimerKt.currentNanoTime();
            Long elapsed = MetricsMonitorKt.timeSub((Long)this.endTime, (long)this.beginNanoTime);
            this.endDate = MetricsMonitorKt.getDateStringFromMillis((long)System.currentTimeMillis());
            this.elapsedSeconds = PhaseIntervalTimerKt.nanoTimeInSeconds$default((Number)elapsed, (int)0, (int)1, null);
            Object object = elapsed;
            if (object == null || (object = Duration.toString-impl((long)DurationKt.toDuration((long)((Long)object), (DurationUnit)DurationUnit.NANOSECONDS))) == null) {
                object = "invalid";
            }
            this.elapsedTime = object;
            this.jvmMemoryUsedMax = MetricsMonitorKt.inMemGB$default((Number)this.getG(this.maxUsedMemory.get()), (int)0, (int)1, null);
            OpenOption[] openOptionArray = new OpenOption[]{};
            OutputStream outputStream = Files.newOutputStream(file, Arrays.copyOf(openOptionArray, openOptionArray.length));
            Intrinsics.checkNotNullExpressionValue((Object)outputStream, (String)"newOutputStream(...)");
            Closeable closeable = outputStream;
            Throwable throwable = null;
            try {
                OutputStream it = (OutputStream)closeable;
                boolean bl2 = false;
                Yaml.encodeToStream$default((Yaml)yamlFormat, (SerializationStrategy)((SerializationStrategy)Companion.serializer()), (Object)this, (OutputStream)it, null, (int)8, null);
                Unit throwable2 = Unit.INSTANCE;
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
            }
            this.phaseTimer.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void addAnalyzeFinishHook(@NotNull Thread t) {
        Intrinsics.checkNotNullParameter((Object)t, (String)"t");
        ((Collection)this.analyzeFinishHook).add(t);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void runAnalyzeFinishHook() {
        List list = this.analyzeFinishHook;
        synchronized (list) {
            boolean bl = false;
            Iterable $this$forEach$iv = this.analyzeFinishHook;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Thread it = (Thread)element$iv;
                boolean bl2 = false;
                it.start();
                it.join();
            }
            this.analyzeFinishHook.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(MetricsMonitor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Gauge gauge;
        KSerializer[] kSerializerArray = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) ? true : !Intrinsics.areEqual((Object)self.beginDate, (Object)"")) {
            output.encodeStringElement(serialDesc, 0, self.beginDate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : self.beginMillis != System.currentTimeMillis()) {
            output.encodeLongElement(serialDesc, 1, self.beginMillis);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : Double.compare(self.elapsedSeconds, -1.0) != 0) {
            output.encodeDoubleElement(serialDesc, 2, self.elapsedSeconds);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : !Intrinsics.areEqual((Object)self.elapsedTime, (Object)"")) {
            output.encodeStringElement(serialDesc, 3, self.elapsedTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : !Intrinsics.areEqual((Object)self.endDate, (Object)"")) {
            output.encodeStringElement(serialDesc, 4, self.endDate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) ? true : self.endTime != 0L) {
            output.encodeLongElement(serialDesc, 5, self.endTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) ? true : Double.compare(self.jvmMemoryUsedMax, -1.0) != 0) {
            output.encodeDoubleElement(serialDesc, 6, self.jvmMemoryUsedMax);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) ? true : Double.compare(self.jvmMemoryMax, MetricsMonitorKt.inMemGB$default((Number)((gauge = UsefulMetrics.Companion.getMetrics().getJvmMemoryMax()) != null ? Double.valueOf(self.getG(gauge)) : null), (int)0, (int)1, null)) != 0) {
            output.encodeDoubleElement(serialDesc, 7, self.jvmMemoryMax);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) ? true : !Intrinsics.areEqual((Object)self.getProjectMetrics(), (Object)new ProjectMetrics(null, null, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0.0f, 0, 0, 0, 0L, 0L, 0L, 0, 0, 0, 0.0f, 0, 0.0f, 0, 0xFFFFFF, null))) {
            output.encodeSerializableElement(serialDesc, 8, (SerializationStrategy)ProjectMetrics$.serializer.INSTANCE, (Object)self.getProjectMetrics());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) ? true : !Intrinsics.areEqual((Object)self.phaseTimer, (Object)new ArrayList())) {
            output.encodeSerializableElement(serialDesc, 9, (SerializationStrategy)kSerializerArray[9], (Object)self.phaseTimer);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) ? true : !Intrinsics.areEqual((Object)self.final, (Object)new LinkedHashMap())) {
            output.encodeSerializableElement(serialDesc, 10, (SerializationStrategy)kSerializerArray[10], (Object)self.final);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) ? true : !Intrinsics.areEqual((Object)self.reports, (Object)new ArrayList())) {
            output.encodeSerializableElement(serialDesc, 11, (SerializationStrategy)kSerializerArray[11], (Object)self.reports);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) ? true : !Intrinsics.areEqual((Object)self.snapshot, (Object)new ArrayList())) {
            output.encodeSerializableElement(serialDesc, 12, (SerializationStrategy)kSerializerArray[12], (Object)self.snapshot);
        }
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ MetricsMonitor(int seen0, String beginDate, long beginMillis, double elapsedSeconds, String elapsedTime, String endDate, long endTime, double jvmMemoryUsedMax, double jvmMemoryMax2, ProjectMetrics projectMetrics, List phaseTimer, Map map, List reports, List snapshot, SerializationConstructorMarker serializationConstructorMarker) {
        void $this$_init__u24lambda_u2419;
        CustomRepeatingTimer customRepeatingTimer;
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)0, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.beginDate = (seen0 & 1) == 0 ? "" : beginDate;
        this.beginMillis = (seen0 & 2) == 0 ? System.currentTimeMillis() : beginMillis;
        this.elapsedSeconds = (seen0 & 4) == 0 ? -1.0 : elapsedSeconds;
        this.elapsedTime = (seen0 & 8) == 0 ? "" : elapsedTime;
        this.endDate = (seen0 & 0x10) == 0 ? "" : endDate;
        this.endTime = (seen0 & 0x20) == 0 ? 0L : endTime;
        this.jvmMemoryUsedMax = (seen0 & 0x40) == 0 ? -1.0 : jvmMemoryUsedMax;
        if ((seen0 & 0x80) == 0) {
            Gauge gauge = UsefulMetrics.Companion.getMetrics().getJvmMemoryMax();
            this.jvmMemoryMax = MetricsMonitorKt.inMemGB$default((Number)(gauge != null ? Double.valueOf(this.getG(gauge)) : null), (int)0, (int)1, null);
        } else {
            this.jvmMemoryMax = jvmMemoryMax2;
        }
        this.projectMetrics = (seen0 & 0x100) == 0 ? new ProjectMetrics(null, null, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0.0f, 0, 0, 0, 0L, 0L, 0L, 0, 0, 0, 0.0f, 0, 0.0f, 0, 0xFFFFFF, null) : projectMetrics;
        this.phaseTimer = (seen0 & 0x200) == 0 ? (List)new ArrayList() : phaseTimer;
        this.final = (seen0 & 0x400) == 0 ? (Map)new LinkedHashMap() : map;
        this.reports = (seen0 & 0x800) == 0 ? (List)new ArrayList() : reports;
        this.snapshot = (seen0 & 0x1000) == 0 ? (List)new ArrayList() : snapshot;
        this.beginNanoTime = PhaseIntervalTimerKt.currentNanoTime();
        this.allPhaseTimer = new ConcurrentHashMap();
        this.analyzeFinishHook = new ArrayList();
        this.maxUsedMemory = new AtomicLong(0L);
        CustomRepeatingTimer customRepeatingTimer2 = customRepeatingTimer = new CustomRepeatingTimer(2000L, () -> MetricsMonitor._init_$lambda$18(this));
        MetricsMonitor metricsMonitor = this;
        boolean bl = false;
        $this$_init__u24lambda_u2419.setRepeats(true);
        this.record();
        metricsMonitor.timer = customRepeatingTimer;
    }

    private static final Unit timer$lambda$5(MetricsMonitor this$0) {
        this$0.record();
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$18(MetricsMonitor this$0) {
        this$0.record();
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Yaml access$getYamlFormat$cp() {
        return yamlFormat;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        SerializersModuleBuilder builder$iv;
        Companion = new Companion(null);
        KSerializer[] kSerializerArray = new KSerializer[]{null, null, null, null, null, null, null, null, null, new ArrayListSerializer((KSerializer)PhaseTimer$$serializer.INSTANCE), new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)new ContextualSerializer(Reflection.getOrCreateKotlinClass(Object.class), null, new KSerializer[0])), new ArrayListSerializer((KSerializer)ReportKey.$serializer.INSTANCE), new ArrayListSerializer((KSerializer)MetricsSnapshot$$serializer.INSTANCE)};
        $childSerializers = kSerializerArray;
        boolean $i$f$SerializersModule = false;
        SerializersModuleBuilder $this$yamlFormat_u24lambda_u2420 = builder$iv = new SerializersModuleBuilder();
        boolean bl = false;
        $this$yamlFormat_u24lambda_u2420.contextual(Reflection.getOrCreateKotlinClass(Object.class), (KSerializer)new DynamicLookupSerializer());
        YamlConfiguration yamlConfiguration = MainConfigKt.getYamlConfiguration();
        SerializersModule serializersModule = builder$iv.build();
        yamlFormat = new Yaml(serializersModule, yamlConfiguration);
    }
}

