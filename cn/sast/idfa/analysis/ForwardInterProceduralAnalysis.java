package cn.sast.idfa.analysis;

import cn.sast.api.config.ExtSettings;
import cn.sast.api.config.StaticFieldTrackingMode;
import cn.sast.common.OS;
import cn.sast.coroutines.caffine.impl.FastCacheImpl;
import cn.sast.graph.HashMutableDirectedGraph;
import cn.sast.idfa.analysis.Context;
import cn.sast.idfa.analysis.FixPointStatus;
import cn.sast.idfa.analysis.InterProceduralAnalysis;
import cn.sast.idfa.analysis.ProcessInfoView;
import cn.sast.idfa.analysis.UsefulMetrics;
import cn.sast.idfa.progressbar.ProgressBarExt;
import cn.sast.idfa.progressbar.ProgressBarExtKt;
import com.feysh.corax.cache.coroutines.RecCoroutineLoadingCache;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.infoflow.collect.ConcurrentHashSet;
import soot.jimple.infoflow.solver.executors.InterruptableExecutor;
import soot.toolkits.graph.DirectedGraph;

public abstract class ForwardInterProceduralAnalysis<M, N, A, R, CTX extends Context<M, N, A>> 
    extends InterProceduralAnalysis<M, N, A> {

    @NotNull
    private final String name;
    @Nullable
    private Stopwatch stopWatch;
    private long timeOutDuration;
    private boolean timeOutOn;
    private double usedTime;
    private boolean isTimeout;
    private boolean limitedAnalytics;
    @NotNull
    private final ProgressBarExt progressBarExt;
    private int numberThreads;
    @NotNull
    private StaticFieldTrackingMode staticFieldTrackingMode;
    @NotNull
    private final ConcurrentHashSet<M> reachableMethods;
    @Nullable
    private HashMutableDirectedGraph<M> directedGraph;
    private final int progressBarVolume;
    @NotNull
    private final AtomicLong contextStateId;
    public RecCoroutineLoadingCache<FactKey<M, N, A>, CTX> cache;
    private int dataFlowInterProceduralCalleeTimeOut;
    private long dataFlowInterProceduralCalleeDepChainMaxNum;
    @NotNull
    private AtomicInteger transformStmtTotalCount;
    @NotNull
    private final Set<M> curAnalysingMethods;

    public ForwardInterProceduralAnalysis(@NotNull String name) {
        super(false);
        this.name = name;
        this.progressBarExt = new ProgressBarExt(0, 0, 3, null);
        this.numberThreads = OS.getMaxThreadNum();
        this.staticFieldTrackingMode = StaticFieldTrackingMode.ContextFlowSensitive;
        this.reachableMethods = new ConcurrentHashSet<>();
        this.progressBarVolume = 100;
        this.contextStateId = new AtomicLong(0L);
        this.dataFlowInterProceduralCalleeTimeOut = -1;
        this.dataFlowInterProceduralCalleeDepChainMaxNum = -1L;
        this.transformStmtTotalCount = new AtomicInteger();
        this.curAnalysingMethods = Sets.newConcurrentHashSet();
    }

    @NotNull
    public final String getName() {
        return name;
    }

    protected final long getTimeOutDuration() {
        return timeOutDuration;
    }

    protected final void setTimeOutDuration(long timeOutDuration) {
        this.timeOutDuration = timeOutDuration;
    }

    protected final boolean getTimeOutOn() {
        return timeOutOn;
    }

    protected final void setTimeOutOn(boolean timeOutOn) {
        this.timeOutOn = timeOutOn;
    }

    public final boolean isTimeout() {
        return isTimeout;
    }

    @NotNull
    public final ProgressBarExt getProgressBarExt() {
        return progressBarExt;
    }

    public int getNumberThreads() {
        return numberThreads;
    }

    public void setNumberThreads(int numberThreads) {
        this.numberThreads = numberThreads;
    }

    @NotNull
    public StaticFieldTrackingMode getStaticFieldTrackingMode() {
        return staticFieldTrackingMode;
    }

    public void setStaticFieldTrackingMode(@NotNull StaticFieldTrackingMode staticFieldTrackingMode) {
        this.staticFieldTrackingMode = staticFieldTrackingMode;
    }

    @NotNull
    public final ConcurrentHashSet<M> getReachableMethods() {
        return reachableMethods;
    }

    @Nullable
    public final HashMutableDirectedGraph<M> getDirectedGraph() {
        return directedGraph;
    }

    public final void setDirectedGraph(@Nullable HashMutableDirectedGraph<M> directedGraph) {
        this.directedGraph = directedGraph;
    }

    public void cacheConfig() {
    }

    public int getProgressBarVolume() {
        return progressBarVolume;
    }

    @NotNull
    public abstract CTX makeContext(M method, @NotNull DirectedGraph<N> cfg, A entryValue, 
                                  boolean reverse, boolean isAnalyzable);

    @NotNull
    public CTX newContext(@NotNull DirectedGraph<N> cfg, M method, A entryValue, boolean isAnalyzable) {
        programRepresentation().setOwnerStatement(cfg, method);
        Context context = makeContext(method, cfg, entryValue, false, isAnalyzable);
        context.setBottomValue(bottomValue());
        
        List heads = cfg.getHeads();
        for (Object node : cfg) {
            if (heads.contains(node)) {
                context.setValueBefore(node, context.getEntryValue());
            } else {
                context.setValueBefore(node, bottomValue());
            }
        }
        
        context.initworklist();
        context.setExitValue(bottomValue());
        return (CTX)context;
    }

    public A computeExitValue(@NotNull CTX context) {
        DirectedGraph cfg = context.getControlFlowGraph();
        A exitValue = bottomValue();
        for (Object tailNode : cfg.getTails()) {
            A tailOut = context.getEdgeValue(tailNode, tailNode);
            exitValue = meet(exitValue, tailOut);
        }
        return exitValue;
    }

    public A initCallEdgeValue(@NotNull CTX currentContext, N node, M callee, A callSiteValue, A inValue) {
        return inValue;
    }

    @NotNull
    public abstract InvokeResult<M, A, R> recursiveCallFlowFunction(@NotNull CTX context, M callee, 
                                                                  N node, N succ, A inValue, 
                                                                  A siteValue, boolean isAnalyzable);

    @NotNull
    public abstract InvokeResult<M, A, R> failedInvokeResult(@NotNull CTX context, M callee, 
                                                            N node, N succ, A inValue, 
                                                            A siteValue, boolean isAnalyzable);

    @NotNull
    public final RecCoroutineLoadingCache<FactKey<M, N, A>, CTX> getCache() {
        if (cache == null) {
            throw new IllegalStateException("cache not initialized");
        }
        return cache;
    }

    public final void setCache(@NotNull RecCoroutineLoadingCache<FactKey<M, N, A>, CTX> cache) {
        this.cache = cache;
    }

    public final int getDataFlowInterProceduralCalleeTimeOut() {
        return dataFlowInterProceduralCalleeTimeOut;
    }

    public final void setDataFlowInterProceduralCalleeTimeOut(int timeout) {
        this.dataFlowInterProceduralCalleeTimeOut = timeout;
    }

    public final long getDataFlowInterProceduralCalleeDepChainMaxNum() {
        return dataFlowInterProceduralCalleeDepChainMaxNum;
    }

    public final void setDataFlowInterProceduralCalleeDepChainMaxNum(long maxNum) {
        this.dataFlowInterProceduralCalleeDepChainMaxNum = maxNum;
    }

    public abstract void skip(M method);

    public A callLocalFlowFunction(@NotNull Context<SootMethod, Unit, A> context, 
                                 @NotNull Unit node, @NotNull Unit succ, A callSiteValue) {
        return bottomValue();
    }

    public abstract A callEntryFlowFunction(@NotNull CTX context, M callee, N node, N succ, A inValue);

    @NotNull
    public abstract InvokeResult<M, A, R> callExitFlowFunction(@NotNull CTX context, A inValue, 
                                                              M callee, A siteValue, 
                                                              @NotNull CTX calleeCtx, 
                                                              N node, N succ, boolean isAnalyzable);

    @Nullable
    public A wideningFunction(@NotNull CTX context, N node, N succ, A in) {
        return null;
    }

    @NotNull
    public FixPointStatus hasChange(@NotNull CTX context, N node, N succ, A old, A a) {
        return old.equals(a) ? FixPointStatus.Fixpoint : FixPointStatus.HasChange;
    }

    public abstract boolean isAnalyzable(M method, A value);

    @NotNull
    public Set<M> resolveTargets(M callerMethod, N node) {
        return programRepresentation().getCalleesOfCallAt(callerMethod, node);
    }

    @NotNull
    public abstract DirectedGraph<N> getCfg(M method, boolean reverse);

    public static class FactKey<M, N, A> {
        // FactKey implementation
    }

    public static class InvokeResult<M, A, R> {
        // InvokeResult implementation
    }
}
