/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.SootUtilsKt
 *  cn.sast.dataflow.interprocedural.check.ModelingStmtInfo
 *  cn.sast.dataflow.interprocedural.check.PrevCallStmtInfo
 *  com.feysh.corax.config.api.IStmt
 *  com.feysh.corax.config.api.MLocal
 *  com.feysh.corax.config.api.MParameter
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Body
 *  soot.Local
 *  soot.SootMethod
 *  soot.tagkit.ParamNamesTag
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.api.util.SootUtilsKt;
import cn.sast.dataflow.interprocedural.check.ModelingStmtInfo;
import com.feysh.corax.config.api.IStmt;
import com.feysh.corax.config.api.MLocal;
import com.feysh.corax.config.api.MParameter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Body;
import soot.Local;
import soot.SootMethod;
import soot.tagkit.ParamNamesTag;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2={"Lcn/sast/dataflow/interprocedural/check/PrevCallStmtInfo;", "Lcn/sast/dataflow/interprocedural/check/ModelingStmtInfo;", "stmt", "Lcom/feysh/corax/config/api/IStmt;", "method", "Lsoot/SootMethod;", "<init>", "(Lcom/feysh/corax/config/api/IStmt;Lsoot/SootMethod;)V", "getMethod", "()Lsoot/SootMethod;", "getParameterNameByIndex", "", "index", "Lcom/feysh/corax/config/api/MLocal;", "filter", "Lkotlin/Function1;", "", "", "", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nPathCompanion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathCompanion.kt\ncn/sast/dataflow/interprocedural/check/PrevCallStmtInfo\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,994:1\n808#2,11:995\n1#3:1006\n*S KotlinDebug\n*F\n+ 1 PathCompanion.kt\ncn/sast/dataflow/interprocedural/check/PrevCallStmtInfo\n*L\n472#1:995,11\n*E\n"})
public final class PrevCallStmtInfo
extends ModelingStmtInfo {
    @NotNull
    private final SootMethod method;

    public PrevCallStmtInfo(@NotNull IStmt stmt, @NotNull SootMethod method) {
        Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        super(stmt);
        this.method = method;
    }

    @NotNull
    public final SootMethod getMethod() {
        return this.method;
    }

    @Nullable
    public Object getParameterNameByIndex(@NotNull MLocal index, @NotNull Function1<Object, Boolean> filter2) {
        String string;
        Intrinsics.checkNotNullParameter((Object)index, (String)"index");
        Intrinsics.checkNotNullParameter(filter2, (String)"filter");
        if (index instanceof MParameter) {
            String string2 = this.getParameterNameByIndex(((MParameter)index).getIndex());
            if (string2 != null) {
                String string3;
                String it = string3 = string2;
                boolean bl = false;
                if (this.getFirstParamIndex() == null) {
                    this.setFirstParamIndex(Integer.valueOf(((MParameter)index).getIndex()));
                }
                string = ((Boolean)filter2.invoke((Object)string3)).booleanValue() ? string3 : null;
            } else {
                string = null;
            }
        } else {
            MLocal mLocal = index;
            string = String.valueOf((Boolean)filter2.invoke((Object)mLocal) != false ? mLocal : null);
        }
        return string;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public String getParameterNameByIndex(int index) {
        if (index == -1) {
            return this.method.getDeclaringClass().getShortName() + ".this";
        }
        if (index >= 0 && index < this.method.getParameterCount()) {
            Object names;
            String string;
            void $this$filterIsInstanceTo$iv$iv;
            List list = this.method.getTags();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getTags(...)");
            Iterable $this$filterIsInstance$iv = list;
            boolean $i$f$filterIsInstance = false;
            Iterable iterable = $this$filterIsInstance$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterIsInstanceTo = false;
            for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
                if (!(element$iv$iv instanceof ParamNamesTag)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Object object = (ParamNamesTag)CollectionsKt.firstOrNull((List)((List)destination$iv$iv));
            if (object == null || (object = object.getNames()) == null) {
                object = CollectionsKt.emptyList();
            }
            if ((string = (String)CollectionsKt.getOrNull((List)(names = object), (int)index)) == null) {
                String string2;
                try {
                    String string3;
                    Body body = SootUtilsKt.getActiveBodyOrNull((SootMethod)this.method);
                    if (body != null && (body = body.getParameterLocal(index)) != null) {
                        Body it = body;
                        boolean bl = false;
                        string3 = "local var " + (Local)it;
                    } else {
                        string3 = null;
                    }
                    string2 = string3;
                }
                catch (RuntimeException ignore) {
                    string2 = null;
                }
                string = string2;
            }
            return string;
        }
        return null;
    }
}

