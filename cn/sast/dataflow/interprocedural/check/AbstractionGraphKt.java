/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.AbstractionGraphKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.apache.commons.text.StringEscapeUtils
 *  org.jetbrains.annotations.NotNull
 *  soot.jimple.Stmt
 *  soot.jimple.infoflow.data.Abstraction
 *  soot.jimple.infoflow.solver.cfg.IInfoflowCFG
 */
package cn.sast.dataflow.interprocedural.check;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.text.StringEscapeUtils;
import org.jetbrains.annotations.NotNull;
import soot.jimple.Stmt;
import soot.jimple.infoflow.data.Abstraction;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2={"getLabel", "", "Lsoot/jimple/infoflow/data/Abstraction;", "cfg", "Lsoot/jimple/infoflow/solver/cfg/IInfoflowCFG;", "corax-data-flow"})
public final class AbstractionGraphKt {
    @NotNull
    public static final String getLabel(@NotNull Abstraction $this$getLabel, @NotNull IInfoflowCFG cfg) {
        StringBuffer sb;
        block7: {
            Object object;
            block6: {
                Stmt it;
                block5: {
                    Object object2;
                    block4: {
                        Intrinsics.checkNotNullParameter((Object)$this$getLabel, (String)"<this>");
                        Intrinsics.checkNotNullParameter((Object)cfg, (String)"cfg");
                        sb = new StringBuffer("\"");
                        object2 = $this$getLabel.getCorrespondingCallSite();
                        if (object2 == null) break block4;
                        it = object2;
                        boolean bl = false;
                        StringBuffer stringBuffer = sb.append(StringEscapeUtils.escapeHtml4((String)("callSite: " + it.getJavaSourceStartLineNumber() + " " + it)));
                        object2 = stringBuffer;
                        if (stringBuffer != null) break block5;
                    }
                    object2 = sb.append("correspondingCallSite null");
                }
                sb.append("\n");
                object = $this$getLabel.getCurrentStmt();
                if (object == null) break block6;
                it = object;
                boolean bl = false;
                StringBuffer stringBuffer = sb.append(StringEscapeUtils.escapeHtml4((String)($this$getLabel.getAccessPath() + "  " + it.getJavaSourceStartLineNumber() + " " + it)));
                object = stringBuffer;
                if (stringBuffer != null) break block7;
            }
            object = sb.append(StringEscapeUtils.escapeHtml4((String)($this$getLabel.getAccessPath() + "  currentStmt: null")));
        }
        return sb + "\"";
    }
}

