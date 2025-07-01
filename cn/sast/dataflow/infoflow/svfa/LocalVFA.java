package cn.sast.dataflow.infoflow.svfa;

import soot.Unit;
import soot.Value;
import soot.Type;
import soot.NullType;
import soot.jimple.internal.JimpleLocal;
import soot.toolkits.graph.DirectedGraph;
import soot.Timers;
import soot.options.Options;
import soot.jimple.Stmt;
import soot.jimple.AssignStmt;
import soot.jimple.ArrayRef;
import soot.jimple.IdentityStmt;
import soot.jimple.ParameterRef;
import soot.jimple.ThisRef;
import soot.jimple.IfStmt;
import soot.jimple.BinopExpr;
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.InvokeStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.infoflow.util.BaseSelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public final class LocalVFA implements ILocalDFA {
    private static final Value returnVoidFake = new JimpleLocal("returnVoidFake", NullType.v());
    private static final Value entryFake = new JimpleLocal("entryFake", NullType.v());
    private final boolean trackControlFlowDependencies;
    private final Map<Unit, FlowFact> uses;
    private final Map<Unit, FlowFact> defuses;

    public LocalVFA(@NotNull DirectedGraph<Unit> graph, boolean trackControlFlowDependencies) {
        if (graph == null) {
            throw new IllegalArgumentException("graph cannot be null");
        }
        this.trackControlFlowDependencies = trackControlFlowDependencies;
        
        boolean time = Options.v().time();
        if (time) {
            Timers.v().defsTimer.start();
        }
        
        Pair<Map<Unit, FlowFact>, Map<Unit, FlowFact>> pair = init(graph);
        this.uses = pair.getFirst();
        this.defuses = pair.getSecond();
        
        if (time) {
            Timers.v().defsTimer.end();
        }
    }

    public boolean getTrackControlFlowDependencies() {
        return trackControlFlowDependencies;
    }

    private <R> void traverse(Expr expr) {
        // Implementation not provided in original code
    }

    private <R> void collectStmtInfo(Stmt stmt, BiFunction<Value, ValueLocation, R> addValueToInfoMap) {
        if (stmt instanceof AssignStmt) {
            Value left = ((AssignStmt) stmt).getLeftOp();
            Value right = ((AssignStmt) stmt).getRightOp();
            Value[] rightValues = BaseSelector.selectBaseList(right, true);
            
            if (left instanceof ArrayRef) {
                Value value = ((ArrayRef) left).getBase();
                addValueToInfoMap.apply(value, ValueLocation.Right);
            } else {
                addValueToInfoMap.apply(left, ValueLocation.Left);
            }
            
            for (Value it : rightValues) {
                addValueToInfoMap.apply(it, ValueLocation.Right);
            }
        } else if (stmt instanceof IdentityStmt) {
            Value left = ((IdentityStmt) stmt).getRightOp();
            if (left instanceof ParameterRef || left instanceof ThisRef) {
                Value value = ((IdentityStmt) stmt).getLeftOp();
                addValueToInfoMap.apply(value, ValueLocation.ParamAndThis);
            }
        } else if (stmt instanceof IfStmt && trackControlFlowDependencies) {
            BinopExpr cond = (BinopExpr) ((IfStmt) stmt).getCondition();
            addValueToInfoMap.apply(cond.getOp1(), ValueLocation.Right);
            addValueToInfoMap.apply(cond.getOp2(), ValueLocation.Right);
        } else if (stmt instanceof ReturnStmt) {
            Value value = ((ReturnStmt) stmt).getOp();
            addValueToInfoMap.apply(value, ValueLocation.Right);
        } else if (stmt instanceof ReturnVoidStmt) {
            addValueToInfoMap.apply(returnVoidFake, ValueLocation.Right);
        } else if (stmt.containsInvokeExpr()) {
            InvokeExpr ie = stmt.getInvokeExpr();
            if (ie instanceof InstanceInvokeExpr) {
                Value value = ((InstanceInvokeExpr) ie).getBase();
                addValueToInfoMap.apply(value, ValueLocation.Arg);
            }
            for (int i = 0; i < ie.getArgCount(); i++) {
                Value value = ie.getArg(i);
                addValueToInfoMap.apply(value, ValueLocation.Arg);
            }
        }
    }

    private Pair<Map<Unit, FlowFact>, Map<Unit, FlowFact>> init(DirectedGraph<Unit> graph) {
        Set<Value> paramAndThis = new LinkedHashSet<>();
        Map<Unit, Set<Pair<AP, ValueLocation>>> unit2locals = new LinkedHashMap<>();
        
        for (Unit unit : graph) {
            if (!(unit instanceof Stmt)) continue;
            
            Stmt stmt = (Stmt) unit;
            Set<Pair<AP, ValueLocation>> apAndLoc = new LinkedHashSet<>();
            collectStmtInfo(stmt, (value, loc) -> {
                AP ap = AP.Companion.get(value);
                if (ap != null) {
                    if (loc == ValueLocation.ParamAndThis) {
                        paramAndThis.add(ap.getValue());
                    }
                    apAndLoc.add(new Pair<>(ap, loc));
                }
                return null;
            });
            unit2locals.put(unit, apAndLoc);
        }
        
        FlowAssignment flowAssignment = new FlowAssignment(graph, paramAndThis, unit2locals);
        BackAssignment backAssignment = new BackAssignment(graph, paramAndThis, unit2locals);
        return new Pair<>(flowAssignment.getBefore(), backAssignment.getAfter());
    }

    @NotNull
    public List<Unit> getDefUsesOfAt(@NotNull AP ap, @NotNull Unit stmt) {
        if (ap == null) throw new IllegalArgumentException("ap cannot be null");
        if (stmt == null) throw new IllegalArgumentException("stmt cannot be null");
        
        FlowFact fact = defuses.get(stmt);
        if (fact == null) {
            return new ArrayList<>();
        }
        
        Set<VFNode> use = fact.getData().get(ap.getValue());
        if (use == null) {
            return new ArrayList<>();
        }
        
        List<Unit> result = new ArrayList<>(use.size());
        for (VFNode node : use) {
            result.add(node.getStmt());
        }
        return result;
    }

    @NotNull
    public List<Unit> getUsesOfAt(@NotNull AP ap, @NotNull Unit stmt) {
        if (ap == null) throw new IllegalArgumentException("ap cannot be null");
        if (stmt == null) throw new IllegalArgumentException("stmt cannot be null");
        
        FlowFact fact = uses.get(stmt);
        if (fact == null) {
            return new ArrayList<>();
        }
        
        Set<VFNode> use = fact.getData().get(ap.getValue());
        if (use == null) {
            return new ArrayList<>();
        }
        
        List<Unit> result = new ArrayList<>(use.size());
        for (VFNode node : use) {
            result.add(node.getStmt());
        }
        return result;
    }

    public static Value getReturnVoidFake() {
        return returnVoidFake;
    }

    public static Value getEntryFake() {
        return entryFake;
    }
}
