package cn.sast.dataflow.interprocedural.check;

import org.apache.commons.text.StringEscapeUtils;
import org.jetbrains.annotations.NotNull;
import soot.jimple.Stmt;
import soot.jimple.infoflow.data.Abstraction;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;

public final class AbstractionGraphKt {
    @NotNull
    public static String getLabel(@NotNull Abstraction abstraction, @NotNull IInfoflowCFG cfg) {
        StringBuffer sb = new StringBuffer("\"");

        Stmt callSite = abstraction.getCorrespondingCallSite();
        if (callSite != null) {
            sb.append(StringEscapeUtils.escapeHtml4("callSite: " + callSite.getJavaSourceStartLineNumber() + " " + callSite));
        } else {
            sb.append("correspondingCallSite null");
        }

        sb.append("\n");

        Stmt currentStmt = abstraction.getCurrentStmt();
        if (currentStmt != null) {
            sb.append(StringEscapeUtils.escapeHtml4(abstraction.getAccessPath() + "  " + currentStmt.getJavaSourceStartLineNumber() + " " + currentStmt));
        } else {
            sb.append(StringEscapeUtils.escapeHtml4(abstraction.getAccessPath() + "  currentStmt: null"));
        }

        return sb + "\"";
    }
}
