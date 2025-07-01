package cn.sast.framework;

import cn.sast.api.AnalyzerEnv;
import cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles;
import cn.sast.api.util.IMonitor;
import cn.sast.api.util.PhaseIntervalTimer;
import cn.sast.api.util.Timer;
import cn.sast.framework.SootCtx;
import cn.sast.framework.entries.IEntryPointProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class AnalyzeTaskRunner {
    private static final Logger logger = LoggerFactory.getLogger(AnalyzeTaskRunner.class);
    private static final int MASK = 65576;

    private final int numThreads;
    private final SootCtx sootCtx;
    private final IMonitor monitor;
    private final Map<IEntryPointProvider, List<Analysis>> analysisPasses = new LinkedHashMap<>();

    public AnalyzeTaskRunner(int numThreads, @NotNull SootCtx sootCtx, @NotNull IMonitor monitor) {
        if (sootCtx == null) throw new IllegalArgumentException("sootCtx cannot be null");
        if (monitor == null) throw new IllegalArgumentException("monitor cannot be null");
        this.numThreads = numThreads;
        this.sootCtx = sootCtx;
        this.monitor = monitor;
    }

    public int getNumThreads() {
        return numThreads;
    }

    @NotNull
    public SootCtx getSootCtx() {
        return sootCtx;
    }

    @NotNull
    public IMonitor getMonitor() {
        return monitor;
    }

    @NotNull
    public Map<IEntryPointProvider, List<Analysis>> getAnalysisPasses() {
        return analysisPasses;
    }

    public void registerAnalysis(@NotNull String phaseName, @NotNull IEntryPointProvider provider,
                               @Nullable Runnable before, @Nullable AnalysisFunction analysis,
                               @Nullable Runnable after) {
        if (phaseName == null) throw new IllegalArgumentException("phaseName cannot be null");
        if (provider == null) throw new IllegalArgumentException("provider cannot be null");

        if (AnalyzerEnv.getInstance().shouldV3r14y() && 
            AnalyzerEnv.getInstance().getBvs1n3ss().get() != 0 && 
            (getMask() & 0x10028) != MASK) {
            return;
        }

        analysisPasses.computeIfAbsent(provider, k -> new ArrayList<>())
                      .add(new Analysis(phaseName, before, analysis, after));
    }

    public void run() {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        try {
            // Pre-analysis phase
            Timer preTimer = monitor.timer("AnalyzeTaskRunner.analysis.pre");
            preTimer.start();
            List<CompletableFuture<Void>> preFutures = new ArrayList<>();
            for (Analysis analysis : getAllAnalyses()) {
                if (analysis.getBefore() != null) {
                    preFutures.add(CompletableFuture.runAsync(analysis.getBefore(), executor));
                }
            }
            CompletableFuture.allOf(preFutures.toArray(new CompletableFuture[0])).join();
            preTimer.stop();

            // Main analysis phase
            Timer processTimer = monitor.timer("AnalyzeTaskRunner.analysis.process");
            processTimer.start();
            for (Map.Entry<IEntryPointProvider, List<Analysis>> entry : analysisPasses.entrySet()) {
                IEntryPointProvider provider = entry.getKey();
                logger.info("do analysis with provider: {}", provider);
                
                provider.getIterator().forEach(item -> {
                    for (Analysis analysis : entry.getValue()) {
                        if (analysis.getAnalysis() != null) {
                            analysis.getAnalysis().accept(new Env(item, provider));
                        }
                    }
                });
            }
            processTimer.stop();

            // Post-analysis phase
            Timer afterTimer = monitor.timer("AnalyzeTaskRunner.analysis.after");
            afterTimer.start();
            List<CompletableFuture<Void>> afterFutures = new ArrayList<>();
            for (Analysis analysis : getAllAnalyses()) {
                if (analysis.getAfter() != null) {
                    afterFutures.add(CompletableFuture.runAsync(analysis.getAfter(), executor));
                }
            }
            CompletableFuture.allOf(afterFutures.toArray(new CompletableFuture[0])).join();
            afterTimer.stop();
        } finally {
            executor.shutdown();
        }
    }

    private List<Analysis> getAllAnalyses() {
        List<Analysis> all = new ArrayList<>();
        for (List<Analysis> analyses : analysisPasses.values()) {
            all.addAll(analyses);
        }
        return all;
    }

    private static int getMask() {
        return MASK;
    }

    public static final class Analysis {
        private final String phaseName;
        private final Runnable before;
        private final AnalysisFunction analysis;
        private final Runnable after;

        public Analysis(String phaseName, Runnable before, AnalysisFunction analysis, Runnable after) {
            this.phaseName = phaseName;
            this.before = before;
            this.analysis = analysis;
            this.after = after;
        }

        public String getPhaseName() {
            return phaseName;
        }

        public Runnable getBefore() {
            return before;
        }

        public AnalysisFunction getAnalysis() {
            return analysis;
        }

        public Runnable getAfter() {
            return after;
        }
    }

    public static final class Env {
        private final Object item;
        private final IEntryPointProvider provider;

        public Env(Object item, IEntryPointProvider provider) {
            this.item = item;
            this.provider = provider;
        }

        public Object getItem() {
            return item;
        }

        public IEntryPointProvider getProvider() {
            return provider;
        }
    }

    @FunctionalInterface
    public interface AnalysisFunction {
        void accept(Env env);
    }
}
