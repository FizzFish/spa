import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import soot.Body;
import soot.Local;
import soot.LocalGenerator;
import soot.RefType;
import soot.Scene;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.Unit;
import soot.UnitPatchingChain;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.InvokeStmt;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.StringConstant;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraphFactory;
import soot.toolkits.graph.UnitGraph;
import soot.util.Chain;

public class SummaryControlFlowUnitGraph implements DirectedGraph<Unit> {
    @NotNull
    private final SootMethod method;
    @NotNull
    private final InterproceduralCFG icfg;
    @NotNull
    private final Jimple jimp;
    private final JimpleBody body;
    @NotNull
    private UnitGraph graph;

    public SummaryControlFlowUnitGraph(@NotNull SootMethod method, @NotNull InterproceduralCFG icfg) {
        if (method == null) throw new IllegalArgumentException("method cannot be null");
        if (icfg == null) throw new IllegalArgumentException("icfg cannot be null");
        
        this.method = method;
        this.icfg = icfg;
        this.jimp = Jimple.v();
        this.body = this.jimp.newBody(this.method);

        if (this.method.hasActiveBody()) {
            throw new IllegalStateException(this.method + " hasActiveBody");
        }

        UnitPatchingChain units = this.body.getUnits();
        LocalGenerator lg = Scene.v().createLocalGenerator(this.body);
        RefType runtimeExceptionType = RefType.v("java.lang.Error");
        Local exceptionLocal = lg.generateLocal(runtimeExceptionType);

        AssignStmt assignStmt = this.jimp.newAssignStmt(exceptionLocal, this.jimp.newNewExpr(runtimeExceptionType));
        units.add(assignStmt);

        SootMethodRef cref = runtimeExceptionType.getSootClass()
            .getMethod("<init>", List.of(RefType.v("java.lang.String")))
            .makeRef();
        
        InvokeStmt invokeStmt = this.jimp.newInvokeStmt(
            this.jimp.newSpecialInvokeExpr(exceptionLocal, cref, StringConstant.v("phantom method body")));
        units.insertAfter(invokeStmt, assignStmt);
        units.insertAfter(this.jimp.newThrowStmt(exceptionLocal), invokeStmt);

        Chain chain = units.getNonPatchingChain();
        for (Unit unit : chain) {
            this.icfg.setOwnerStatement(unit, this.method);
        }

        this.graph = ExceptionalUnitGraphFactory.createExceptionalUnitGraph(this.body);
    }

    @NotNull
    public SootMethod getMethod() {
        return method;
    }

    @NotNull
    public InterproceduralCFG getIcfg() {
        return icfg;
    }

    @NotNull
    public Jimple getJimp() {
        return jimp;
    }

    public JimpleBody getBody() {
        return body;
    }

    @NotNull
    public UnitGraph getGraph() {
        return graph;
    }

    public void setGraph(@NotNull UnitGraph graph) {
        if (graph == null) throw new IllegalArgumentException("graph cannot be null");
        this.graph = graph;
    }

    @Override
    @NotNull
    public Iterator<Unit> iterator() {
        return graph.iterator();
    }

    @Override
    @NotNull
    public List<Unit> getHeads() {
        return graph.getHeads();
    }

    @Override
    @NotNull
    public List<Unit> getTails() {
        return graph.getTails();
    }

    @Override
    @NotNull
    public List<Unit> getPredsOf(@NotNull Unit s) {
        if (s == null) throw new IllegalArgumentException("s cannot be null");
        return graph.getPredsOf(s);
    }

    @Override
    @NotNull
    public List<Unit> getSuccsOf(@NotNull Unit s) {
        if (s == null) throw new IllegalArgumentException("s cannot be null");
        return graph.getSuccsOf(s);
    }

    @Override
    public int size() {
        return graph.size();
    }
}