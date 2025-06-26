/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.MethodResult
 *  cn.sast.dataflow.interprocedural.analysis.TraversalContext
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  soot.jimple.ReturnStmt
 *  soot.jimple.Stmt
 *  soot.jimple.SwitchStmt
 *  soot.jimple.internal.JAssignStmt
 *  soot.jimple.internal.JIdentityStmt
 *  soot.jimple.internal.JIfStmt
 *  soot.jimple.internal.JInvokeStmt
 *  soot.jimple.internal.JThrowStmt
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.MethodResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import soot.jimple.ReturnStmt;
import soot.jimple.Stmt;
import soot.jimple.SwitchStmt;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.internal.JIdentityStmt;
import soot.jimple.internal.JIfStmt;
import soot.jimple.internal.JInvokeStmt;
import soot.jimple.internal.JThrowStmt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0014H&J\u0016\u0010\u0015\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H&J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0015\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00028\u0001H&\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001eH\u0016R\u0012\u0010\u0004\u001a\u00028\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u001f"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/TraversalContext;", "V", "A", "", "voidValue", "getVoidValue", "()Ljava/lang/Object;", "traverseAssignStmt", "", "current", "Lsoot/jimple/internal/JAssignStmt;", "traverseIdentityStmt", "Lsoot/jimple/internal/JIdentityStmt;", "traverseIfStmt", "Lsoot/jimple/internal/JIfStmt;", "traverseInvokeStmt", "Lsoot/jimple/internal/JInvokeStmt;", "traverseSwitchStmt", "Lsoot/jimple/SwitchStmt;", "traverseThrowStmt", "Lsoot/jimple/internal/JThrowStmt;", "processResult", "Lcn/sast/dataflow/interprocedural/analysis/MethodResult;", "symbolicSuccess", "stmt", "Lsoot/jimple/ReturnStmt;", "offerState", "state", "(Ljava/lang/Object;)V", "traverseStmt", "Lsoot/jimple/Stmt;", "corax-data-flow"})
public interface TraversalContext<V, A> {
    public V getVoidValue();

    public void traverseAssignStmt(@NotNull JAssignStmt var1);

    public void traverseIdentityStmt(@NotNull JIdentityStmt var1);

    public void traverseIfStmt(@NotNull JIfStmt var1);

    public void traverseInvokeStmt(@NotNull JInvokeStmt var1);

    public void traverseSwitchStmt(@NotNull SwitchStmt var1);

    public void traverseThrowStmt(@NotNull JThrowStmt var1);

    public void processResult(@NotNull MethodResult<V> var1);

    @NotNull
    public MethodResult<V> symbolicSuccess(@NotNull ReturnStmt var1);

    public void offerState(A var1);

    public void traverseStmt(@NotNull Stmt var1);
}

