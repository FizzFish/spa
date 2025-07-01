package cn.sast.dataflow.interprocedural.check.checker;

import cn.sast.api.report.DefaultEnv;
import cn.sast.api.report.IBugResInfo;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.report.Region;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.Stmt;

public abstract class ProgramStateContext extends DefaultEnv {
    @NotNull
    private final IBugResInfo resInfo;
    @NotNull
    private final Stmt callSiteStmt;
    @NotNull
    private final SootMethod container1;
    @NotNull
    private final SootMethod callee1;
    @NotNull
    private final IExpr guard;
    @Nullable
    private Unit callSite;
    @Nullable
    private SootMethod container;

    public ProgramStateContext(@NotNull Region.Mutable region, 
                             @NotNull IBugResInfo resInfo, 
                             @NotNull Stmt callSiteStmt, 
                             @NotNull SootMethod container1, 
                             @NotNull SootMethod callee1, 
                             @NotNull IExpr guard) {
        super(region, null, null, null, null, null, null, null, null, 510, null);
        this.resInfo = resInfo;
        this.callSiteStmt = callSiteStmt;
        this.container1 = container1;
        this.callee1 = callee1;
        this.guard = guard;
        this.callSite = callSiteStmt;
        this.container = container1;
    }

    @NotNull
    public final IBugResInfo getResInfo() {
        return resInfo;
    }

    @NotNull
    public final Stmt getCallSiteStmt() {
        return callSiteStmt;
    }

    @NotNull
    public final SootMethod getContainer1() {
        return container1;
    }

    @NotNull
    public final SootMethod getCallee1() {
        return callee1;
    }

    @NotNull
    public final IExpr getGuard() {
        return guard;
    }

    @Nullable
    public Unit getCallSite() {
        return callSite;
    }

    public void setCallSite(@Nullable Unit callSite) {
        this.callSite = callSite;
    }

    @Nullable
    public SootMethod getContainer() {
        return container;
    }

    public void setContainer(@Nullable SootMethod container) {
        this.container = container;
    }
}