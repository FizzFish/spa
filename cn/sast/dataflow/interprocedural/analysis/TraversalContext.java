package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import soot.jimple.ReturnStmt;
import soot.jimple.Stmt;
import soot.jimple.SwitchStmt;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.internal.JIdentityStmt;
import soot.jimple.internal.JIfStmt;
import soot.jimple.internal.JInvokeStmt;
import soot.jimple.internal.JThrowStmt;

public interface TraversalContext<V, A> {
    V getVoidValue();

    void traverseAssignStmt(@NotNull JAssignStmt current);

    void traverseIdentityStmt(@NotNull JIdentityStmt current);

    void traverseIfStmt(@NotNull JIfStmt current);

    void traverseInvokeStmt(@NotNull JInvokeStmt current);

    void traverseSwitchStmt(@NotNull SwitchStmt current);

    void traverseThrowStmt(@NotNull JThrowStmt current);

    void processResult(@NotNull MethodResult<V> current);

    @NotNull
    MethodResult<V> symbolicSuccess(@NotNull ReturnStmt stmt);

    void offerState(A state);

    void traverseStmt(@NotNull Stmt current);
}