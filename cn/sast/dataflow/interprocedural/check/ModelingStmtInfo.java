/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.ModelingStmtInfo
 *  cn.sast.dataflow.interprocedural.check.ModelingStmtInfo$getParameterNames$visitor$1
 *  com.feysh.corax.config.api.IModelStmtVisitor
 *  com.feysh.corax.config.api.IStmt
 *  com.feysh.corax.config.api.MLocal
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Local
 *  soot.Unit
 *  soot.ValueBox
 *  soot.jimple.Constant
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.check.ModelingStmtInfo;
import com.feysh.corax.config.api.IModelStmtVisitor;
import com.feysh.corax.config.api.IStmt;
import com.feysh.corax.config.api.MLocal;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Local;
import soot.Unit;
import soot.ValueBox;
import soot.jimple.Constant;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\tH&J&\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0013H&J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018J \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u001a"}, d2={"Lcn/sast/dataflow/interprocedural/check/ModelingStmtInfo;", "", "stmt", "Lcom/feysh/corax/config/api/IStmt;", "<init>", "(Lcom/feysh/corax/config/api/IStmt;)V", "getStmt", "()Lcom/feysh/corax/config/api/IStmt;", "firstParamIndex", "", "getFirstParamIndex", "()Ljava/lang/Integer;", "setFirstParamIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getParameterNameByIndex", "index", "Lcom/feysh/corax/config/api/MLocal;", "filter", "Lkotlin/Function1;", "", "getParameterNamesInUnitDefUse", "", "unit", "Lsoot/Unit;", "getParameterNames", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nPathCompanion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathCompanion.kt\ncn/sast/dataflow/interprocedural/check/ModelingStmtInfo\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,994:1\n1628#2,3:995\n1053#2:998\n*S KotlinDebug\n*F\n+ 1 PathCompanion.kt\ncn/sast/dataflow/interprocedural/check/ModelingStmtInfo\n*L\n362#1:995,3\n447#1:998\n*E\n"})
public abstract class ModelingStmtInfo {
    @NotNull
    private final IStmt stmt;
    @Nullable
    private Integer firstParamIndex;

    public ModelingStmtInfo(@NotNull IStmt stmt) {
        Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
        this.stmt = stmt;
    }

    @NotNull
    public final IStmt getStmt() {
        return this.stmt;
    }

    @Nullable
    public final Integer getFirstParamIndex() {
        return this.firstParamIndex;
    }

    public final void setFirstParamIndex(@Nullable Integer n) {
        this.firstParamIndex = n;
    }

    @Nullable
    public abstract Object getParameterNameByIndex(int var1);

    @Nullable
    public abstract Object getParameterNameByIndex(@NotNull MLocal var1, @NotNull Function1<Object, Boolean> var2);

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<Object> getParameterNamesInUnitDefUse(@NotNull Unit unit) {
        void destination$iv;
        void $this$mapTo$iv;
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        List list = unit.getUseAndDefBoxes();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getUseAndDefBoxes(...)");
        Iterable iterable = list;
        Collection collection = new LinkedHashSet();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            ValueBox valueBox = (ValueBox)item$iv;
            void var10_9 = destination$iv;
            boolean bl = false;
            var10_9.add(it.getValue());
        }
        Set useDef = (Set)destination$iv;
        return this.getParameterNames(arg_0 -> ModelingStmtInfo.getParameterNamesInUnitDefUse$lambda$1(useDef, arg_0));
    }

    @NotNull
    public final List<Object> getParameterNames(@NotNull Function1<Object, Boolean> filter2) {
        Intrinsics.checkNotNullParameter(filter2, (String)"filter");
        getParameterNames.visitor.1 visitor2 = new /* Unavailable Anonymous Inner Class!! */;
        this.stmt.accept((IModelStmtVisitor)visitor2);
        Iterable $this$sortedBy$iv = visitor2.getResult();
        boolean $i$f$sortedBy = false;
        return CollectionsKt.toList((Iterable)CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */)));
    }

    private static final boolean getParameterNamesInUnitDefUse$lambda$1(Set $useDef, Object it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it instanceof Local ? $useDef.contains(it) : !(it instanceof Constant);
    }
}

