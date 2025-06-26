/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.OS
 *  cn.sast.dataflow.infoflow.svfa.AP
 *  cn.sast.dataflow.infoflow.svfa.ILocalDFA
 *  cn.sast.dataflow.infoflow.svfa.gcSolver.CacheFlowGuide
 *  com.google.common.cache.CacheBuilder
 *  com.google.common.cache.CacheLoader
 *  com.google.common.cache.LoadingCache
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.Scene
 *  soot.Unit
 *  soot.toolkits.graph.UnitGraph
 */
package cn.sast.dataflow.infoflow.svfa.gcSolver;

import cn.sast.common.OS;
import cn.sast.dataflow.infoflow.svfa.AP;
import cn.sast.dataflow.infoflow.svfa.ILocalDFA;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.Unit;
import soot.toolkits.graph.UnitGraph;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bRP\u0010\f\u001aB\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00010\u0001 \u000e* \u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\r0\rX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000fRP\u0010\u0010\u001aB\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00120\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00130\u0013 \u000e* \u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00120\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00130\u0013\u0018\u00010\u00110\u0011X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0014\u00a8\u0006\u001d"}, d2={"Lcn/sast/dataflow/infoflow/svfa/gcSolver/CacheFlowGuide;", "", "trackControlFlowDependencies", "", "<init>", "(Z)V", "getTrackControlFlowDependencies", "()Z", "initialCapacity", "", "getInitialCapacity", "()I", "flowCacheBuilder", "Lcom/google/common/cache/CacheBuilder;", "kotlin.jvm.PlatformType", "Lcom/google/common/cache/CacheBuilder;", "cache", "Lcom/google/common/cache/LoadingCache;", "Lsoot/toolkits/graph/UnitGraph;", "Lcn/sast/dataflow/infoflow/svfa/ILocalDFA;", "Lcom/google/common/cache/LoadingCache;", "getSuccess", "", "Lsoot/Unit;", "isForward", "ap", "Lcn/sast/dataflow/infoflow/svfa/AP;", "unit", "unitGraph", "corax-data-flow"})
public final class CacheFlowGuide {
    private final boolean trackControlFlowDependencies;
    private final CacheBuilder<Object, Object> flowCacheBuilder;
    private final LoadingCache<UnitGraph, ILocalDFA> cache;

    public CacheFlowGuide(boolean trackControlFlowDependencies) {
        this.trackControlFlowDependencies = trackControlFlowDependencies;
        this.flowCacheBuilder = CacheBuilder.newBuilder().concurrencyLevel(OS.INSTANCE.getMaxThreadNum()).initialCapacity(this.getInitialCapacity()).maximumSize((long)(this.getInitialCapacity() * 2)).softValues();
        this.cache = this.flowCacheBuilder.build((CacheLoader)new /* Unavailable Anonymous Inner Class!! */);
    }

    public final boolean getTrackControlFlowDependencies() {
        return this.trackControlFlowDependencies;
    }

    private final int getInitialCapacity() {
        return Math.max(Scene.v().getClasses().size() * 10, 500);
    }

    @NotNull
    public final List<Unit> getSuccess(boolean isForward, @NotNull AP ap, @NotNull Unit unit, @NotNull UnitGraph unitGraph) {
        Intrinsics.checkNotNullParameter((Object)ap, (String)"ap");
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        Intrinsics.checkNotNullParameter((Object)unitGraph, (String)"unitGraph");
        ILocalDFA lu = (ILocalDFA)this.cache.getUnchecked((Object)unitGraph);
        return isForward ? lu.getUsesOfAt(ap, unit) : lu.getDefUsesOfAt(ap, unit);
    }
}

