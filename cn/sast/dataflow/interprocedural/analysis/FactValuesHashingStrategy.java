/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AnyNewValue
 *  cn.sast.dataflow.interprocedural.analysis.ConstVal
 *  cn.sast.dataflow.interprocedural.analysis.EntryParam
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesHashingStrategy
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesHashingStrategy$Companion
 *  cn.sast.dataflow.interprocedural.analysis.GlobalStaticObject
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.PhantomField
 *  cn.sast.dataflow.interprocedural.analysis.SummaryValue
 *  gnu.trove.strategy.HashingStrategy
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AnyNewValue;
import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.EntryParam;
import cn.sast.dataflow.interprocedural.analysis.FactValuesHashingStrategy;
import cn.sast.dataflow.interprocedural.analysis.GlobalStaticObject;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.PhantomField;
import cn.sast.dataflow.interprocedural.analysis.SummaryValue;
import gnu.trove.strategy.HashingStrategy;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\r"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/FactValuesHashingStrategy;", "Lgnu/trove/strategy/HashingStrategy;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "<init>", "()V", "computeHashCode", "", "v", "equals", "", "a", "b", "Companion", "corax-data-flow"})
public class FactValuesHashingStrategy
implements HashingStrategy<IValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final FactValuesHashingStrategy INSTANCE = new FactValuesHashingStrategy();

    public int computeHashCode(@NotNull IValue v) {
        int n;
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        IValue iValue = v;
        if (iValue instanceof AnyNewValue) {
            Object[] objectArray = new Object[]{((AnyNewValue)v).getNewExpr()};
            n = Objects.hash(objectArray);
        } else if (iValue instanceof ConstVal) {
            Object[] objectArray = new Object[]{((ConstVal)v).getV()};
            n = Objects.hash(objectArray);
        } else if (iValue instanceof SummaryValue) {
            Object[] objectArray = new Object[]{((SummaryValue)v).getType(), ((SummaryValue)v).getUnit(), ((SummaryValue)v).getSpecial()};
            n = Objects.hash(objectArray);
        } else if (iValue instanceof EntryParam) {
            Object[] objectArray = new Object[]{((EntryParam)v).getMethod(), ((EntryParam)v).getParamIndex()};
            n = Objects.hash(objectArray);
        } else if (iValue instanceof GlobalStaticObject) {
            n = ((GlobalStaticObject)v).hashCode();
        } else if (iValue instanceof PhantomField) {
            Object[] objectArray = new Object[]{this.computeHashCode((IValue)((PhantomField)v).getBase()), ((PhantomField)v).getAccessPath()};
            n = Objects.hash(objectArray);
        } else {
            throw new IllegalStateException(("error type of " + v.getClass() + ": " + v).toString());
        }
        return n;
    }

    public boolean equals(@NotNull IValue a, @NotNull IValue b) {
        Intrinsics.checkNotNullParameter((Object)a, (String)"a");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        if (a == b) {
            return true;
        }
        if (this.computeHashCode(a) != this.computeHashCode(b)) {
            return false;
        }
        if (a instanceof AnyNewValue && b instanceof AnyNewValue) {
            return Intrinsics.areEqual((Object)((AnyNewValue)a).getNewExpr(), (Object)((AnyNewValue)b).getNewExpr());
        }
        if (a instanceof ConstVal && b instanceof ConstVal) {
            return Intrinsics.areEqual((Object)((ConstVal)a).getV(), (Object)((ConstVal)b).getV());
        }
        if (a instanceof SummaryValue && b instanceof SummaryValue) {
            return Intrinsics.areEqual((Object)((SummaryValue)a).getType(), (Object)((SummaryValue)b).getType()) && Intrinsics.areEqual((Object)((SummaryValue)a).getUnit(), (Object)((SummaryValue)b).getUnit()) && Intrinsics.areEqual((Object)((SummaryValue)a).getSpecial(), (Object)((SummaryValue)b).getSpecial());
        }
        if (a instanceof EntryParam && b instanceof EntryParam) {
            return Intrinsics.areEqual((Object)((EntryParam)a).getMethod(), (Object)((EntryParam)b).getMethod()) && ((EntryParam)a).getParamIndex() == ((EntryParam)b).getParamIndex();
        }
        if (a instanceof GlobalStaticObject && b instanceof GlobalStaticObject) {
            return Intrinsics.areEqual((Object)a, (Object)b);
        }
        if (a instanceof PhantomField && b instanceof PhantomField) {
            return this.equals((IValue)((PhantomField)a).getBase(), (IValue)((PhantomField)b).getBase()) && Intrinsics.areEqual((Object)((PhantomField)a).getAccessPath(), (Object)((PhantomField)b).getAccessPath());
        }
        throw new IllegalStateException(("error type of a: \n" + a.getClass() + ": " + a + "    b:\n" + b.getClass() + ": " + b).toString());
    }

    public static final /* synthetic */ FactValuesHashingStrategy access$getINSTANCE$cp() {
        return INSTANCE;
    }
}

