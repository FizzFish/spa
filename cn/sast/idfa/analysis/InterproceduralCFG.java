/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.idfa.analysis.InterproceduralCFG
 *  cn.sast.idfa.analysis.ProgramRepresentation
 *  cn.sast.idfa.analysis.SummaryControlFlowUnitGraph
 *  com.github.benmanes.caffeine.cache.CacheLoader
 *  com.github.benmanes.caffeine.cache.Caffeine
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Body
 *  soot.Local
 *  soot.Scene
 *  soot.SootMethod
 *  soot.Unit
 *  soot.Value
 *  soot.ValueBox
 *  soot.jimple.IdentityStmt
 *  soot.jimple.LookupSwitchStmt
 *  soot.jimple.Stmt
 *  soot.jimple.ThisRef
 *  soot.jimple.toolkits.ide.icfg.AbstractJimpleBasedICFG
 *  soot.jimple.toolkits.ide.icfg.JimpleBasedInterproceduralCFG
 *  soot.toolkits.graph.DirectedBodyGraph
 *  soot.toolkits.graph.DirectedGraph
 *  soot.toolkits.scalar.LiveLocals
 *  soot.toolkits.scalar.SimpleLiveLocals
 */
package cn.sast.idfa.analysis;

import cn.sast.idfa.analysis.ProgramRepresentation;
import cn.sast.idfa.analysis.SummaryControlFlowUnitGraph;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Body;
import soot.Local;
import soot.Scene;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.IdentityStmt;
import soot.jimple.LookupSwitchStmt;
import soot.jimple.Stmt;
import soot.jimple.ThisRef;
import soot.jimple.toolkits.ide.icfg.AbstractJimpleBasedICFG;
import soot.jimple.toolkits.ide.icfg.JimpleBasedInterproceduralCFG;
import soot.toolkits.graph.DirectedBodyGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.scalar.LiveLocals;
import soot.toolkits.scalar.SimpleLiveLocals;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0003J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0002H\u0016J\u001e\u0010 \u001a\u00020!2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0016\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003J\u000e\u0010*\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0003J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020+2\u0006\u0010(\u001a\u00020\u0003J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030-2\u0006\u0010(\u001a\u00020\u0003J\u000e\u0010.\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u00032\u0006\u0010(\u001a\u00020\u0003J\u000e\u00100\u001a\u0002012\u0006\u0010\u0016\u001a\u00020\u0002J\u0010\u00102\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\"\u00103\u001a\b\u0012\u0004\u0012\u0002040-2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010(\u001a\u00020\u0003R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u00066"}, d2={"Lcn/sast/idfa/analysis/InterproceduralCFG;", "Lcn/sast/idfa/analysis/ProgramRepresentation;", "Lsoot/SootMethod;", "Lsoot/Unit;", "<init>", "()V", "unitToOwner", "", "cfgCacheSummary", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "Lsoot/toolkits/graph/DirectedGraph;", "cfgCache", "liveLocalCache", "Lsoot/toolkits/graph/DirectedBodyGraph;", "Lsoot/toolkits/scalar/LiveLocals;", "delegateICFG", "Lsoot/jimple/toolkits/ide/icfg/AbstractJimpleBasedICFG;", "getDelegateICFG", "()Lsoot/jimple/toolkits/ide/icfg/AbstractJimpleBasedICFG;", "delegateICFG$delegate", "Lkotlin/Lazy;", "getControlFlowGraph", "method", "getSummaryControlFlowGraph", "isCall", "", "node", "getCalleesOfCallAt", "", "callerMethod", "callNode", "getMethodOf", "setOwnerStatement", "", "u", "owner", "g", "", "isAnalyzable", "isFallThroughSuccessor", "unit", "succ", "isCallStmt", "", "getPredsOf", "", "hasPredAsLookupSwitchStmt", "getPredAsLookupSwitchStmt", "getIdentityStmt", "Lsoot/jimple/IdentityStmt;", "isSkipCall", "getNonLiveLocals", "Lsoot/Local;", "ug", "corax-idfa-framework"})
@SourceDebugExtension(value={"SMAP\nInterproceduralCFG.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InterproceduralCFG.kt\ncn/sast/idfa/analysis/InterproceduralCFG\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,246:1\n1619#2:247\n1863#2:248\n1864#2:251\n1620#2:252\n1#3:249\n1#3:250\n*S KotlinDebug\n*F\n+ 1 InterproceduralCFG.kt\ncn/sast/idfa/analysis/InterproceduralCFG\n*L\n244#1:247\n244#1:248\n244#1:251\n244#1:252\n244#1:250\n*E\n"})
public final class InterproceduralCFG
implements ProgramRepresentation<SootMethod, Unit> {
    @NotNull
    private final Map<Unit, SootMethod> unitToOwner = new ConcurrentHashMap();
    @NotNull
    private final LoadingCache<SootMethod, DirectedGraph<Unit>> cfgCacheSummary;
    @NotNull
    private final LoadingCache<SootMethod, DirectedGraph<Unit>> cfgCache;
    @NotNull
    private final LoadingCache<DirectedBodyGraph<Unit>, LiveLocals> liveLocalCache;
    @NotNull
    private final Lazy delegateICFG$delegate = LazyKt.lazy(InterproceduralCFG::delegateICFG_delegate$lambda$0);

    public InterproceduralCFG() {
        int initialCapacity = Math.max(Scene.v().getClasses().size() / 100, Scene.v().getClasses().size() + 100);
        Caffeine cacheBuilderSummary = Caffeine.newBuilder().initialCapacity(initialCapacity);
        Function1 function1 = arg_0 -> InterproceduralCFG._init_$lambda$1(this, arg_0);
        this.cfgCacheSummary = cacheBuilderSummary.build((CacheLoader)new /* Unavailable Anonymous Inner Class!! */);
        Caffeine cacheBuilder = Caffeine.newBuilder().expireAfterAccess(30000L, TimeUnit.MINUTES).initialCapacity(initialCapacity).maximumSize((long)(initialCapacity * 2)).softValues();
        Function1 function12 = arg_0 -> InterproceduralCFG._init_$lambda$2(this, arg_0);
        this.cfgCache = cacheBuilder.build((CacheLoader)new /* Unavailable Anonymous Inner Class!! */);
        function12 = InterproceduralCFG::_init_$lambda$3;
        this.liveLocalCache = cacheBuilder.build((CacheLoader)new /* Unavailable Anonymous Inner Class!! */);
    }

    @NotNull
    public final AbstractJimpleBasedICFG getDelegateICFG() {
        Lazy lazy = this.delegateICFG$delegate;
        return (AbstractJimpleBasedICFG)lazy.getValue();
    }

    @NotNull
    public DirectedGraph<Unit> getControlFlowGraph(@NotNull SootMethod method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Object object = this.cfgCache.get((Object)method);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        return (DirectedGraph)object;
    }

    @NotNull
    public DirectedGraph<Unit> getSummaryControlFlowGraph(@NotNull SootMethod method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Object object = this.cfgCacheSummary.get((Object)method);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        return (DirectedGraph)object;
    }

    public boolean isCall(@NotNull Unit node) {
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        return ((Stmt)node).containsInvokeExpr();
    }

    @NotNull
    public Set<SootMethod> getCalleesOfCallAt(@NotNull SootMethod callerMethod, @NotNull Unit callNode) {
        Intrinsics.checkNotNullParameter((Object)callerMethod, (String)"callerMethod");
        Intrinsics.checkNotNullParameter((Object)callNode, (String)"callNode");
        Collection collection = this.getDelegateICFG().getCalleesOfCallAt((Object)callNode);
        Intrinsics.checkNotNullExpressionValue((Object)collection, (String)"getCalleesOfCallAt(...)");
        return CollectionsKt.toSet((Iterable)collection);
    }

    @NotNull
    public final SootMethod getMethodOf(@NotNull Unit node) {
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        SootMethod sootMethod = (SootMethod)this.unitToOwner.get(node);
        if (sootMethod == null) {
            SootMethod sootMethod2 = this.getDelegateICFG().getMethodOf(node);
            sootMethod = sootMethod2;
            Intrinsics.checkNotNullExpressionValue((Object)sootMethod2, (String)"getMethodOf(...)");
        }
        return sootMethod;
    }

    public void setOwnerStatement(@NotNull Unit u, @NotNull SootMethod owner) {
        Intrinsics.checkNotNullParameter((Object)u, (String)"u");
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        this.unitToOwner.put(u, owner);
    }

    public void setOwnerStatement(@NotNull Iterable<? extends Unit> g2, @NotNull SootMethod owner) {
        Intrinsics.checkNotNullParameter(g2, (String)"g");
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        for (Unit unit : g2) {
            this.unitToOwner.put(unit, owner);
        }
    }

    public boolean isAnalyzable(@NotNull SootMethod method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        return method.hasActiveBody();
    }

    public final boolean isFallThroughSuccessor(@NotNull Unit unit, @NotNull Unit succ) {
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        Intrinsics.checkNotNullParameter((Object)succ, (String)"succ");
        return this.getDelegateICFG().isFallThroughSuccessor(unit, succ);
    }

    public final boolean isCallStmt(@NotNull Unit unit) {
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        return this.getDelegateICFG().isCallStmt(unit);
    }

    @NotNull
    public final Collection<SootMethod> getCalleesOfCallAt(@NotNull Unit unit) {
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        Collection collection = this.getDelegateICFG().getCalleesOfCallAt((Object)unit);
        Intrinsics.checkNotNullExpressionValue((Object)collection, (String)"getCalleesOfCallAt(...)");
        return collection;
    }

    @NotNull
    public final List<Unit> getPredsOf(@NotNull Unit unit) {
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        List list = this.getDelegateICFG().getPredsOf(unit);
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getPredsOf(...)");
        return list;
    }

    public final boolean hasPredAsLookupSwitchStmt(@NotNull Unit unit) {
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        for (Unit pred : this.getDelegateICFG().getPredsOf(unit)) {
            if (!(pred instanceof LookupSwitchStmt)) continue;
            return true;
        }
        return false;
    }

    @Nullable
    public final Unit getPredAsLookupSwitchStmt(@NotNull Unit unit) {
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        for (Unit pred : this.getDelegateICFG().getPredsOf(unit)) {
            if (!(pred instanceof LookupSwitchStmt)) continue;
            return pred;
        }
        return null;
    }

    @NotNull
    public final IdentityStmt getIdentityStmt(@NotNull SootMethod method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Iterator iterator2 = method.getActiveBody().getUnits().iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"iterator(...)");
        Iterator iterator3 = iterator2;
        while (iterator3.hasNext()) {
            Unit s = (Unit)iterator3.next();
            if (!(s instanceof IdentityStmt) || !(((IdentityStmt)s).getRightOp() instanceof ThisRef)) continue;
            return (IdentityStmt)s;
        }
        throw new RuntimeException("couldn't find identityref! in " + method);
    }

    public boolean isSkipCall(@NotNull Unit node) {
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        if (!(node instanceof Stmt) || ((Stmt)node).containsInvokeExpr()) {
            // empty if block
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<Local> getNonLiveLocals(@NotNull DirectedBodyGraph<Unit> ug, @NotNull Unit unit) {
        void destination$iv;
        void $this$mapNotNullTo$iv;
        Intrinsics.checkNotNullParameter(ug, (String)"ug");
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        Object object = this.liveLocalCache.get(ug);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        LiveLocals sll = (LiveLocals)object;
        List liveLocals = sll.getLiveLocalsAfter(unit);
        List list = unit.getUseBoxes();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getUseBoxes(...)");
        Iterable iterable = list;
        Collection collection = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv = $this$mapNotNullTo$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Value it$iv;
            Object element$iv$iv;
            Object element$iv = element$iv$iv = iterator2.next();
            boolean bl = false;
            ValueBox it = (ValueBox)element$iv;
            boolean bl2 = false;
            Value value = it.getValue();
            Value live = value = value instanceof Local ? (Local)value : null;
            boolean bl3 = false;
            if ((!liveLocals.contains(live) ? value : null) == null) continue;
            it$iv = it$iv;
            boolean bl4 = false;
            destination$iv.add(it$iv);
        }
        return (List)destination$iv;
    }

    private static final JimpleBasedInterproceduralCFG delegateICFG_delegate$lambda$0() {
        return new JimpleBasedInterproceduralCFG(true);
    }

    private static final DirectedGraph _init_$lambda$1(InterproceduralCFG this$0, SootMethod key2) {
        Intrinsics.checkNotNullParameter((Object)key2, (String)"key");
        return (DirectedGraph)new SummaryControlFlowUnitGraph(key2, this$0);
    }

    private static final DirectedGraph _init_$lambda$2(InterproceduralCFG this$0, SootMethod key2) {
        Intrinsics.checkNotNullParameter((Object)key2, (String)"key");
        Body b = key2.getActiveBody();
        return this$0.getDelegateICFG().getOrCreateUnitGraph(b);
    }

    private static final LiveLocals _init_$lambda$3(DirectedBodyGraph g2) {
        Intrinsics.checkNotNullParameter((Object)g2, (String)"g");
        return (LiveLocals)new SimpleLiveLocals(g2);
    }
}

