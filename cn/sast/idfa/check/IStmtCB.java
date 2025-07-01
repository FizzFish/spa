package cn.sast.idfa.check;

import org.jetbrains.annotations.NotNull;
import soot.jimple.Stmt;

public interface IStmtCB {
    @NotNull
    Stmt getStmt();
}