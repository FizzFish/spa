/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.DefaultEnv
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.dataflow.interprocedural.check.checker.ProgramStateContext
 *  com.feysh.corax.config.api.IExpr
 *  com.feysh.corax.config.api.report.Region$Mutable
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.Unit
 *  soot.jimple.Stmt
 */
package cn.sast.dataflow.interprocedural.check.checker;

import cn.sast.api.report.DefaultEnv;
import cn.sast.api.report.IBugResInfo;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.report.Region;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.Stmt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\tX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010!\u00a8\u0006\""}, d2={"Lcn/sast/dataflow/interprocedural/check/checker/ProgramStateContext;", "Lcn/sast/api/report/DefaultEnv;", "region", "Lcom/feysh/corax/config/api/report/Region$Mutable;", "resInfo", "Lcn/sast/api/report/IBugResInfo;", "callSiteStmt", "Lsoot/jimple/Stmt;", "container1", "Lsoot/SootMethod;", "callee1", "guard", "Lcom/feysh/corax/config/api/IExpr;", "<init>", "(Lcom/feysh/corax/config/api/report/Region$Mutable;Lcn/sast/api/report/IBugResInfo;Lsoot/jimple/Stmt;Lsoot/SootMethod;Lsoot/SootMethod;Lcom/feysh/corax/config/api/IExpr;)V", "getResInfo", "()Lcn/sast/api/report/IBugResInfo;", "getCallSiteStmt", "()Lsoot/jimple/Stmt;", "getContainer1", "()Lsoot/SootMethod;", "getCallee1", "getGuard", "()Lcom/feysh/corax/config/api/IExpr;", "callSite", "Lsoot/Unit;", "getCallSite", "()Lsoot/Unit;", "setCallSite", "(Lsoot/Unit;)V", "container", "getContainer", "setContainer", "(Lsoot/SootMethod;)V", "corax-data-flow"})
public abstract class ProgramStateContext
extends DefaultEnv {
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

    public ProgramStateContext(@NotNull Region.Mutable region, @NotNull IBugResInfo resInfo, @NotNull Stmt callSiteStmt, @NotNull SootMethod container1, @NotNull SootMethod callee1, @NotNull IExpr guard) {
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        Intrinsics.checkNotNullParameter((Object)resInfo, (String)"resInfo");
        Intrinsics.checkNotNullParameter((Object)callSiteStmt, (String)"callSiteStmt");
        Intrinsics.checkNotNullParameter((Object)container1, (String)"container1");
        Intrinsics.checkNotNullParameter((Object)callee1, (String)"callee1");
        Intrinsics.checkNotNullParameter((Object)guard, (String)"guard");
        super(region, null, null, null, null, null, null, null, null, 510, null);
        this.resInfo = resInfo;
        this.callSiteStmt = callSiteStmt;
        this.container1 = container1;
        this.callee1 = callee1;
        this.guard = guard;
        this.callSite = (Unit)this.callSiteStmt;
        this.container = this.container1;
    }

    @NotNull
    public final IBugResInfo getResInfo() {
        return this.resInfo;
    }

    @NotNull
    public final Stmt getCallSiteStmt() {
        return this.callSiteStmt;
    }

    @NotNull
    public final SootMethod getContainer1() {
        return this.container1;
    }

    @NotNull
    public final SootMethod getCallee1() {
        return this.callee1;
    }

    @NotNull
    public final IExpr getGuard() {
        return this.guard;
    }

    @Nullable
    public Unit getCallSite() {
        return this.callSite;
    }

    public void setCallSite(@Nullable Unit unit) {
        this.callSite = unit;
    }

    @Nullable
    public SootMethod getContainer() {
        return this.container;
    }

    public void setContainer(@Nullable SootMethod sootMethod) {
        this.container = sootMethod;
    }
}

