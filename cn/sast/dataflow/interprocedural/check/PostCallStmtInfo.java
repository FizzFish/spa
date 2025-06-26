/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.ModelingStmtInfo
 *  cn.sast.dataflow.interprocedural.check.PostCallStmtInfo
 *  com.feysh.corax.config.api.IStmt
 *  com.feysh.corax.config.api.MLocal
 *  com.feysh.corax.config.api.MParameter
 *  com.feysh.corax.config.api.MReturn
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Unit
 *  soot.Value
 *  soot.jimple.DefinitionStmt
 *  soot.jimple.InstanceInvokeExpr
 *  soot.jimple.InvokeExpr
 *  soot.jimple.Stmt
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.check.ModelingStmtInfo;
import com.feysh.corax.config.api.IStmt;
import com.feysh.corax.config.api.MLocal;
import com.feysh.corax.config.api.MParameter;
import com.feysh.corax.config.api.MReturn;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;
import soot.Value;
import soot.jimple.DefinitionStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2={"Lcn/sast/dataflow/interprocedural/check/PostCallStmtInfo;", "Lcn/sast/dataflow/interprocedural/check/ModelingStmtInfo;", "stmt", "Lcom/feysh/corax/config/api/IStmt;", "node", "Lsoot/Unit;", "<init>", "(Lcom/feysh/corax/config/api/IStmt;Lsoot/Unit;)V", "getNode", "()Lsoot/Unit;", "getParameterNameByIndex", "", "index", "Lcom/feysh/corax/config/api/MLocal;", "filter", "Lkotlin/Function1;", "", "Lsoot/Value;", "", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nPathCompanion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathCompanion.kt\ncn/sast/dataflow/interprocedural/check/PostCallStmtInfo\n+ 2 SootUtils.kt\ncn/sast/api/util/SootUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,994:1\n310#2:995\n303#2:996\n1#3:997\n*S KotlinDebug\n*F\n+ 1 PathCompanion.kt\ncn/sast/dataflow/interprocedural/check/PostCallStmtInfo\n*L\n495#1:995\n503#1:996\n503#1:997\n*E\n"})
public final class PostCallStmtInfo
extends ModelingStmtInfo {
    @NotNull
    private final Unit node;

    public PostCallStmtInfo(@NotNull IStmt stmt, @NotNull Unit node) {
        Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        super(stmt);
        this.node = node;
    }

    @NotNull
    public final Unit getNode() {
        return this.node;
    }

    @Nullable
    public Object getParameterNameByIndex(@NotNull MLocal index, @NotNull Function1<Object, Boolean> filter2) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter((Object)index, (String)"index");
        Intrinsics.checkNotNullParameter(filter2, (String)"filter");
        MLocal mLocal = index;
        if (mLocal instanceof MParameter) {
            Value value;
            Value value2;
            Value value3 = this.getParameterNameByIndex(((MParameter)index).getIndex());
            if (value3 != null && (value3 = (Boolean)filter2.invoke((Object)(value2 = value3)) != false ? value2 : null) != null) {
                Value it = value2 = value3;
                boolean bl = false;
                if (this.getFirstParamIndex() == null) {
                    this.setFirstParamIndex(Integer.valueOf(((MParameter)index).getIndex()));
                }
                value = value2;
            } else {
                value = null;
            }
            serializable = (Serializable)value;
        } else {
            if (mLocal instanceof MReturn) {
                Value value;
                Unit $this$leftOp$iv = this.node;
                boolean $i$f$getLeftOp = false;
                DefinitionStmt definitionStmt = $this$leftOp$iv instanceof DefinitionStmt ? (DefinitionStmt)$this$leftOp$iv : null;
                Object object = definitionStmt != null ? definitionStmt.getLeftOp() : null;
                return object != null ? (((Boolean)filter2.invoke((Object)(value = object))).booleanValue() ? value : null) : null;
            }
            MLocal mLocal2 = index;
            serializable = (Serializable)((Object)String.valueOf((Boolean)filter2.invoke((Object)mLocal2) != false ? mLocal2 : null));
        }
        return serializable;
    }

    @Nullable
    public Value getParameterNameByIndex(int index) {
        InvokeExpr invokeExpr;
        Unit $this$invokeExprOrNull$iv = this.node;
        boolean $i$f$getInvokeExprOrNull = false;
        Stmt stmt = $this$invokeExprOrNull$iv instanceof Stmt ? (Stmt)$this$invokeExprOrNull$iv : null;
        if (stmt != null) {
            Stmt it$iv = stmt;
            boolean bl = false;
            invokeExpr = ((Stmt)$this$invokeExprOrNull$iv).containsInvokeExpr() ? ((Stmt)$this$invokeExprOrNull$iv).getInvokeExpr() : null;
        } else {
            invokeExpr = null;
        }
        if (invokeExpr == null) {
            return null;
        }
        InvokeExpr iee = invokeExpr;
        List names = iee.getArgs();
        if (index == -1 && iee instanceof InstanceInvokeExpr) {
            return ((InstanceInvokeExpr)iee).getBase();
        }
        if (index >= 0 && index < names.size()) {
            return (Value)names.get(index);
        }
        return null;
    }
}

