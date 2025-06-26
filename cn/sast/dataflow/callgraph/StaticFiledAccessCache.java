/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.OS
 *  cn.sast.dataflow.callgraph.StaticFiledAccessCache
 *  com.google.common.cache.CacheBuilder
 *  com.google.common.cache.CacheLoader
 *  com.google.common.cache.LoadingCache
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.Unit
 *  soot.UnitPatchingChain
 *  soot.jimple.FieldRef
 *  soot.jimple.StaticFieldRef
 *  soot.jimple.Stmt
 *  soot.jimple.toolkits.callgraph.CallGraph
 */
package cn.sast.dataflow.callgraph;

import cn.sast.common.OS;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.UnitPatchingChain;
import soot.jimple.FieldRef;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.CallGraph;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bRP\u0010\f\u001aB\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00010\u0001 \u000e* \u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\r0\rX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u0080\u0001\u0010\u0010\u001ar\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013 \u000e*\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00120\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00140\u0014 \u000e*8\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013 \u000e*\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00120\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00140\u0014\u0018\u00010\u00110\u0011X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0015R-\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00190\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2={"Lcn/sast/dataflow/callgraph/StaticFiledAccessCache;", "", "cg", "Lsoot/jimple/toolkits/callgraph/CallGraph;", "<init>", "(Lsoot/jimple/toolkits/callgraph/CallGraph;)V", "getCg", "()Lsoot/jimple/toolkits/callgraph/CallGraph;", "initialCapacity", "", "getInitialCapacity", "()I", "cacheBuilder", "Lcom/google/common/cache/CacheBuilder;", "kotlin.jvm.PlatformType", "Lcom/google/common/cache/CacheBuilder;", "cache", "Lcom/google/common/cache/LoadingCache;", "Lkotlin/Pair;", "Lsoot/SootMethod;", "", "Lcom/google/common/cache/LoadingCache;", "staticFieldRefToSootMethod", "", "Lsoot/jimple/StaticFieldRef;", "", "getStaticFieldRefToSootMethod", "()Ljava/util/Map;", "staticFieldRefToSootMethod$delegate", "Lkotlin/Lazy;", "isAccessible", "entry", "fieldRef", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nReachableStmtSequence.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReachableStmtSequence.kt\ncn/sast/dataflow/callgraph/StaticFiledAccessCache\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,113:1\n381#2,7:114\n*S KotlinDebug\n*F\n+ 1 ReachableStmtSequence.kt\ncn/sast/dataflow/callgraph/StaticFiledAccessCache\n*L\n94#1:114,7\n*E\n"})
public final class StaticFiledAccessCache {
    @NotNull
    private final CallGraph cg;
    private final CacheBuilder<Object, Object> cacheBuilder;
    private final LoadingCache<Pair<SootMethod, SootMethod>, Boolean> cache;
    @NotNull
    private final Lazy staticFieldRefToSootMethod$delegate;

    public StaticFiledAccessCache(@NotNull CallGraph cg) {
        Intrinsics.checkNotNullParameter((Object)cg, (String)"cg");
        this.cg = cg;
        this.cacheBuilder = CacheBuilder.newBuilder().concurrencyLevel(OS.INSTANCE.getMaxThreadNum()).initialCapacity(this.getInitialCapacity()).maximumSize((long)(this.getInitialCapacity() * 2)).softValues();
        this.cache = this.cacheBuilder.build((CacheLoader)new /* Unavailable Anonymous Inner Class!! */);
        this.staticFieldRefToSootMethod$delegate = LazyKt.lazy(StaticFiledAccessCache::staticFieldRefToSootMethod_delegate$lambda$1);
    }

    @NotNull
    public final CallGraph getCg() {
        return this.cg;
    }

    private final int getInitialCapacity() {
        return Math.max(Scene.v().getClasses().size() * 10, Scene.v().getClasses().size() + 1000);
    }

    private final Map<StaticFieldRef, Set<SootMethod>> getStaticFieldRefToSootMethod() {
        Lazy lazy = this.staticFieldRefToSootMethod$delegate;
        return (Map)lazy.getValue();
    }

    public final boolean isAccessible(@NotNull SootMethod entry, @NotNull StaticFieldRef fieldRef) {
        Intrinsics.checkNotNullParameter((Object)entry, (String)"entry");
        Intrinsics.checkNotNullParameter((Object)fieldRef, (String)"fieldRef");
        Set set = (Set)this.getStaticFieldRefToSootMethod().get(fieldRef);
        if (set == null) {
            return false;
        }
        Set methodsHaveAccess = set;
        for (SootMethod sm : methodsHaveAccess) {
            if (!((Boolean)this.cache.get((Object)TuplesKt.to((Object)entry, (Object)sm))).booleanValue()) continue;
            return true;
        }
        return false;
    }

    private static final Map staticFieldRefToSootMethod_delegate$lambda$1() {
        Map res = new LinkedHashMap();
        Iterator iterator2 = Scene.v().getClasses().iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"iterator(...)");
        Iterator iterator3 = iterator2;
        while (iterator3.hasNext()) {
            SootClass sc = (SootClass)iterator3.next();
            for (SootMethod sm : sc.getMethods()) {
                Iterator iterator4;
                UnitPatchingChain units;
                if (!sm.hasActiveBody()) continue;
                Intrinsics.checkNotNullExpressionValue((Object)sm.getActiveBody().getUnits(), (String)"getUnits(...)");
                Intrinsics.checkNotNullExpressionValue((Object)units.iterator(), (String)"iterator(...)");
                while (iterator4.hasNext()) {
                    Object object;
                    Unit u = (Unit)iterator4.next();
                    Intrinsics.checkNotNull((Object)u, (String)"null cannot be cast to non-null type soot.jimple.Stmt");
                    Stmt stmt = (Stmt)u;
                    if (!stmt.containsFieldRef() || !(stmt.getFieldRef() instanceof StaticFieldRef)) continue;
                    FieldRef fieldRef = stmt.getFieldRef();
                    Intrinsics.checkNotNull((Object)fieldRef, (String)"null cannot be cast to non-null type soot.jimple.StaticFieldRef");
                    StaticFieldRef sf = (StaticFieldRef)fieldRef;
                    Map $this$getOrPut$iv = res;
                    boolean $i$f$getOrPut = false;
                    Object value$iv = $this$getOrPut$iv.get(sf);
                    if (value$iv == null) {
                        boolean bl = false;
                        Set answer$iv = new LinkedHashSet();
                        $this$getOrPut$iv.put(sf, answer$iv);
                        object = answer$iv;
                    } else {
                        object = value$iv;
                    }
                    Set set = (Set)object;
                    Intrinsics.checkNotNull((Object)sm);
                    set.add(sm);
                }
            }
        }
        return res;
    }
}

