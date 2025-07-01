package cn.sast.framework.metrics;

import cn.sast.api.config.MainConfigKt;
import cn.sast.api.report.ProjectMetrics;
import cn.sast.api.report.Report;
import cn.sast.api.util.IMonitor;
import cn.sast.api.util.PhaseIntervalTimerKt;
import cn.sast.api.util.Timer;
import cn.sast.common.CustomRepeatingTimer;
import cn.sast.common.IResDirectory;
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
import org.eclipse.microprofile.metrics.Gauge;
import org.jetbrains.annotations.NotNull;

public final class MetricsMonitor implements IMonitor {
    private static final Yaml yamlFormat;
    private static final KSerializer<Object>[] childSerializers;

    static {
        SerializersModuleBuilder builder = new SerializersModuleBuilder();
        builder.contextual(Object.class, new DynamicLookupSerializer());
        yamlFormat = new Yaml(builder.build(), MainConfigKt.getYamlConfiguration());
        
        childSerializers = new KSerializer[]{
            null, null, null, null, null, null, null, null, null,
            new ArrayListSerializer(PhaseTimer.serializer()),
            new LinkedHashMapSerializer(StringSerializer.INSTANCE, new ContextualSerializer(Object.class)),
            new ArrayListSerializer(ReportKey.serializer()),
            new ArrayListSerializer(MetricsSnapshot.serializer())
        };
    }

    @NotNull
    private String beginDate = "";
    private final long beginMillis = System.currentTimeMillis();
    private double elapsedSeconds = -1.0;
    @NotNull
    private String elapsedTime = "";
    @NotNull
    private String endDate = "";
    private long endTime;
    private double jvmMemoryUsedMax = -1.0;
    private final double jvmMemoryMax;
    @NotNull
    private final ProjectMetrics projectMetrics = new ProjectMetrics();
    @NotNull
    private final List<PhaseTimer> phaseTimer = new ArrayList<>();
    @NotNull
    private final Map<String, Object> finalValues = new LinkedHashMap<>();
    @NotNull
    private final List<ReportKey> reports = new ArrayList<>();
    @NotNull
    private final List<MetricsSnapshot> snapshot = new ArrayList<>();
    private final long beginNanoTime = PhaseIntervalTimerKt.currentNanoTime();
    @NotNull
    private final ConcurrentHashMap<String, Timer> allPhaseTimer = new ConcurrentHashMap<>();
    @NotNull
    private final List<Thread> analyzeFinishHook = new ArrayList<>();
    @NotNull
    private final AtomicLong maxUsedMemory = new AtomicLong(0L);
    @NotNull
    private final CustomRepeatingTimer timer;

    public MetricsMonitor() {
        Gauge<Long> gauge = UsefulMetrics.Companion.getMetrics().getJvmMemoryMax();
        this.jvmMemoryMax = gauge != null ? toGB(gauge.getValue()) : -1.0;
        
        this.timer = new CustomRepeatingTimer(2000L, this::record);
        this.timer.setRepeats(true);
        this.record();
    }

    public long getBeginMillis() {
        return beginMillis;
    }

    @NotNull
    public ProjectMetrics getProjectMetrics() {
        return projectMetrics;
    }

    public long getBeginNanoTime() {
        return beginNanoTime;
    }

    @NotNull
    public Timer timer(@NotNull String phase) {
        return allPhaseTimer.computeIfAbsent(phase, Timer::new);
    }

    @NotNull
    public AtomicLong getMaxUsedMemory() {
        return maxUsedMemory;
    }

    public synchronized void record() {
        UsefulMetrics metrics = UsefulMetrics.Companion.getMetrics();
        
        Gauge<Long> memoryUsed = metrics.getJvmMemoryUsed();
        if (memoryUsed != null && memoryUsed.getValue() != null) {
            long usedMemory = memoryUsed.getValue();
            maxUsedMemory.updateAndGet(prev -> Math.max(prev, usedMemory));
        }

        double timeSec = PhaseIntervalTimerKt.nanoTimeInSeconds(PhaseIntervalTimerKt.currentNanoTime() - beginNanoTime);
        double memUsedGB = toGB(memoryUsed != null ? memoryUsed.getValue() : null);
        double maxMemGB = toGB(maxUsedMemory.get());
        double memCommittedGB = toGB(metrics.getJvmMemoryCommitted() != null ? 
            metrics.getJvmMemoryCommitted().getValue() : null);
        double freePhysGB = toGB(metrics.getFreePhysicalSize() != null ? 
            metrics.getFreePhysicalSize().getValue() : null);
        
        Double cpuLoad = null;
        Gauge<Double> cpuGauge = metrics.getCpuSystemCpuLoad();
        if (cpuGauge != null && cpuGauge.getValue() != null) {
            cpuLoad = PhaseIntervalTimerKt.retainDecimalPlaces(cpuGauge.getValue(), 2);
        }

        snapshot.add(new MetricsSnapshot(timeSec, memUsedGB, maxMemGB, memCommittedGB, freePhysGB, cpuLoad));
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public synchronized <T extends Number> void putNumber(@NotNull String name, @NotNull T value) {
        finalValues.put(name, value);
    }

    public synchronized void put(@NotNull String name, @NotNull String value) {
        finalValues.put(name, value);
    }

    public synchronized void take(@NotNull ResultCollector result) {
        projectMetrics.setSerializedReports(result.getReports().size());
        
        Map<ReportKey, List<Report>> grouped = new LinkedHashMap<>();
        for (Report report : result.getReports()) {
            ReportKey key = new ReportKey(report.getCategory(), report.getType());
            grouped.computeIfAbsent(key, k -> new ArrayList<>()).add(report);
        }
        
        for (Map.Entry<ReportKey, List<Report>> entry : grouped.entrySet()) {
            ReportKey key = entry.getKey();
            key.setSize(entry.getValue().size());
            reports.add(key);
        }

        ResultCounter counter = result.getCollectors().stream()
            .filter(ResultCounter.class::isInstance)
            .map(ResultCounter.class::cast)
            .findFirst()
            .orElse(null);
            
        if (counter != null) {
            putNumber("infoflow.results", counter.getInfoflowResCount().get());
            putNumber("infoflow.abstraction", counter.getInfoflowAbsAtSinkCount().get());
            putNumber("symbolic.execution", counter.getSymbolicUTbotCount().get());
            putNumber("PreAnalysis.results", counter.getPreAnalysisResultCount().get());
            putNumber("built-in.Analysis.results", counter.getBuiltInAnalysisCount().get());
            putNumber("AbstractInterpretationAnalysis.results", counter.getDataFlowCount().get());
        }
    }

    public synchronized void serialize(@NotNull IResDirectory out) throws IOException {
        stop();
        Path file = out.resolve("metrics.yml").getPath();
        
        projectMetrics.process();
        beginDate = MetricsMonitorKt.getDateStringFromMillis(beginMillis);
        
        for (Map.Entry<String, Timer> entry : allPhaseTimer.entrySet()) {
            String phaseName = entry.getKey();
            Timer timer = entry.getValue();
            phaseTimer.add(new PhaseTimer(
                phaseName,
                PhaseIntervalTimerKt.nanoTimeInSeconds(timer.getStartTime() - beginNanoTime),
                PhaseIntervalTimerKt.nanoTimeInSeconds(timer.getElapsedTime()),
                timer.getPhaseStartCount().getValue(),
                PhaseIntervalTimerKt.nanoTimeInSeconds(timer.getPhaseAverageElapsedTime(), 6),
                PhaseIntervalTimerKt.nanoTimeInSeconds(timer.getEndTime() - beginNanoTime)
            ));
        }
        
        phaseTimer.sort(Comparator.comparing(PhaseTimer::getStartTime));
        
        endTime = PhaseIntervalTimerKt.currentNanoTime();
        long elapsed = endTime - beginNanoTime;
        endDate = MetricsMonitorKt.getDateStringFromMillis(System.currentTimeMillis());
        elapsedSeconds = PhaseIntervalTimerKt.nanoTimeInSeconds(elapsed);
        elapsedTime = Duration.toString(Duration.ofNanos(elapsed));
        jvmMemoryUsedMax = toGB(maxUsedMemory.get());
        
        try (OutputStream output = Files.newOutputStream(file)) {
            yamlFormat.encodeToStream(MetricsMonitor.serializer(), this, output);
        }
        
        phaseTimer.clear();
    }

    public void addAnalyzeFinishHook(@NotNull Thread thread) {
        analyzeFinishHook.add(thread);
    }

    public synchronized void runAnalyzeFinishHook() throws InterruptedException {
        for (Thread thread : analyzeFinishHook) {
            thread.start();
            thread.join();
        }
        analyzeFinishHook.clear();
    }

    private double toGB(Long bytes) {
        return bytes != null && bytes >= 0 ? bytes / 1024.0 / 1024.0 / 1024.0 : -1.0;
    }

    private double toGB(Gauge<Long> gauge) {
        return gauge != null ? toGB(gauge.getValue()) : -1.0;
    }

    public static final class Companion {
        private Companion() {}
    }
}
