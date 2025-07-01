package cn.sast.idfa.analysis;

import cn.sast.idfa.analysis.ProgramRepresentation;
import cn.sast.idfa.analysis.SummaryControlFlowUnitGraph;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
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

public final class InterproceduralCFG implements ProgramRepresentation<SootMethod, Unit> {
    private final Map<Unit, SootMethod> unitToOwner = new ConcurrentHashMap<>();
    private final Cache<SootMethod, DirectedGraph<Unit>> cfgCacheSummary;
    private final Cache<SootMethod, DirectedGraph<Unit>> cfgCache;
    private final Cache<DirectedBodyGraph<Unit>, LiveLocals> liveLocalCache;
    private final AbstractJimpleBasedICFG delegateICFG = new JimpleBasedInterproceduralCFG(true);

    public InterproceduralCFG() {
        int initialCapacity = Math.max(Scene.v().getClasses().size() / 100, Scene.v().getClasses().size() + 100);
        
        this.cfgCacheSummary = Caffeine.newBuilder()
            .initialCapacity(initialCapacity)
            .build(key -> new SummaryControlFlowUnitGraph(key, this));
            
        this.cfgCache = Caffeine.newBuilder()
            .expireAfterAccess(30, TimeUnit.MINUTES)
            .initialCapacity(initialCapacity)
            .maximumSize(initialCapacity * 2L)
            .softValues()
            .build(key -> {
                Body b = key.getActiveBody();
                return delegateICFG.getOrCreateUnitGraph(b);
            });
            
        this.liveLocalCache = Caffeine.newBuilder()
            .build(g -> new SimpleLiveLocals(g));
    }

    public AbstractJimpleBasedICFG getDelegateICFG() {
        return delegateICFG;
    }

    @Override
    public DirectedGraph<Unit> getControlFlowGraph(@NotNull SootMethod method) {
        return cfgCache.get(method);
    }

    @Override
    public DirectedGraph<Unit> getSummaryControlFlowGraph(@NotNull SootMethod method) {
        return cfgCacheSummary.get(method);
    }

    @Override
    public boolean isCall(@NotNull Unit node) {
        return ((Stmt)node).containsInvokeExpr();
    }

    @Override
    public Set<SootMethod> getCalleesOfCallAt(@NotNull SootMethod callerMethod, @NotNull Unit callNode) {
        return new HashSet<>(delegateICFG.getCalleesOfCallAt(callNode));
    }

    public SootMethod getMethodOf(@NotNull Unit node) {
        SootMethod method = unitToOwner.get(node);
        return method != null ? method : delegateICFG.getMethodOf(node);
    }

    public void setOwnerStatement(@NotNull Unit u, @NotNull SootMethod owner) {
        unitToOwner.put(u, owner);
    }

    public void setOwnerStatement(@NotNull Iterable<? extends Unit> units, @NotNull SootMethod owner) {
        for (Unit unit : units) {
            unitToOwner.put(unit, owner);
        }
    }

    @Override
    public boolean isAnalyzable(@NotNull SootMethod method) {
        return method.hasActiveBody();
    }

    public boolean isFallThroughSuccessor(@NotNull Unit unit, @NotNull Unit succ) {
        return delegateICFG.isFallThroughSuccessor(unit, succ);
    }

    public boolean isCallStmt(@NotNull Unit unit) {
        return delegateICFG.isCallStmt(unit);
    }

    public Collection<SootMethod> getCalleesOfCallAt(@NotNull Unit unit) {
        return delegateICFG.getCalleesOfCallAt(unit);
    }

    public List<Unit> getPredsOf(@NotNull Unit unit) {
        return delegateICFG.getPredsOf(unit);
    }

    public boolean hasPredAsLookupSwitchStmt(@NotNull Unit unit) {
        for (Unit pred : delegateICFG.getPredsOf(unit)) {
            if (pred instanceof LookupSwitchStmt) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public Unit getPredAsLookupSwitchStmt(@NotNull Unit unit) {
        for (Unit pred : delegateICFG.getPredsOf(unit)) {
            if (pred instanceof LookupSwitchStmt) {
                return pred;
            }
        }
        return null;
    }

    @NotNull
    public IdentityStmt getIdentityStmt(@NotNull SootMethod method) {
        for (Unit s : method.getActiveBody().getUnits()) {
            if (s instanceof IdentityStmt && ((IdentityStmt)s).getRightOp() instanceof ThisRef) {
                return (IdentityStmt)s;
            }
        }
        throw new RuntimeException("couldn't find identityref! in " + method);
    }

    @Override
    public boolean isSkipCall(@NotNull Unit node) {
        return false;
    }

    @NotNull
    public List<Local> getNonLiveLocals(@NotNull DirectedBodyGraph<Unit> ug, @NotNull Unit unit) {
        LiveLocals sll = liveLocalCache.get(ug);
        List<Local> liveLocals = sll.getLiveLocalsAfter(unit);
        List<Local> nonLiveLocals = new ArrayList<>();
        
        for (ValueBox box : unit.getUseBoxes()) {
            Value value = box.getValue();
            if (value instanceof Local && !liveLocals.contains(value)) {
                nonLiveLocals.add((Local)value);
            }
        }
        return nonLiveLocals;
    }
}
