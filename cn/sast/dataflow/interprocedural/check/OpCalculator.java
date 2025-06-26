/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.CalculatorBase
 *  cn.sast.dataflow.interprocedural.check.OpCalculator
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.CalculatorBase;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002BM\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\b\u0012*\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u000b0\n\"\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\f\u0010\rJy\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00022e\u0010\u0012\u001aa\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002\u0012\u001d\u0012\u001b\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012#\u0012!\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00180\n\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0013\u00a2\u0006\u0002\b\u001bH\u0016R'\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u000b0\n\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2={"Lcn/sast/dataflow/interprocedural/check/OpCalculator;", "Lcn/sast/dataflow/interprocedural/check/CalculatorBase;", "Lcn/sast/dataflow/interprocedural/analysis/IOpCalculator;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "cf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "ops", "", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;[Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;)V", "getOps", "()[Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "[Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "resolve", "fx", "Lkotlin/Function3;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "Lkotlin/ParameterName;", "name", "res", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "op", "", "Lkotlin/ExtensionFunctionType;", "corax-data-flow"})
public final class OpCalculator
extends CalculatorBase
implements IOpCalculator<IValue> {
    @NotNull
    private final IHeapValues<IValue>[] ops;

    public OpCalculator(@NotNull HeapValuesEnv env, @NotNull AbstractHeapFactory<IValue> cf, IHeapValues<IValue> ... ops) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(cf, (String)"cf");
        Intrinsics.checkNotNullParameter(ops, (String)"ops");
        super(env, cf);
        this.ops = ops;
    }

    @NotNull
    public final IHeapValues<IValue>[] getOps() {
        return this.ops;
    }

    @NotNull
    public IOpCalculator<IValue> resolve(@NotNull Function3<? super IOpCalculator<IValue>, ? super IHeapValues.Builder<IValue>, ? super CompanionV<IValue>[], Boolean> fx) {
        int sz222;
        int n112;
        Intrinsics.checkNotNullParameter(fx, (String)"fx");
        int sz = this.ops.length;
        int n2 = 0;
        Integer[] integerArray = new Integer[sz];
        while (n2 < sz) {
            int n3 = n2++;
            IHeapValues iHeapValues = this.ops[n3];
            if (iHeapValues == null) {
                return (IOpCalculator)this;
            }
            Integer n4 = iHeapValues.getSize();
            int n5 = ((Number)n4).intValue();
            int n6 = n3;
            Integer[] integerArray2 = integerArray;
            n112 = 0;
            if (sz222 == 0) {
                return (IOpCalculator)this;
            }
            Unit unit = Unit.INSTANCE;
            integerArray2[n6] = n4;
        }
        Integer[] sizeArray = integerArray;
        int n7 = 0;
        CompanionV[][] companionVArrayArray = new CompanionV[sz][];
        while (n7 < sz) {
            int n8 = n7++;
            companionVArrayArray[n8] = new CompanionV[sizeArray[n8].intValue()];
        }
        CompanionV[][] valueArray = companionVArrayArray;
        int n9 = 0;
        Iterator[] iteratorArray = new Iterator[sz];
        while (n9 < sz) {
            sz222 = n9++;
            IHeapValues iHeapValues = this.ops[sz222];
            Intrinsics.checkNotNull((Object)iHeapValues);
            iteratorArray[sz222] = iHeapValues.iterator();
        }
        Iterator[] iter = iteratorArray;
        int n10 = 0;
        Integer[] sz222 = new Integer[sz];
        while (n10 < sz) {
            n112 = n10++;
            sz222[n112] = 0;
        }
        Integer[] counter = sz222;
        int sz222 = 0;
        CompanionV[] n112 = new CompanionV[sz];
        while (sz222 < sz) {
            CompanionV v;
            int n12 = sz222++;
            valueArray[n12][0] = v = (CompanionV)iter[n12].next();
            n112[n12] = v;
        }
        CompanionV[] op = n112;
        while (this.getCount() < this.getCalculateLimit()) {
            boolean ok = (Boolean)fx.invoke((Object)this, (Object)this.getRes(), (Object)op);
            int n112 = this.getCount();
            this.setCount(n112 + 1);
            if (!ok) {
                this.getUnHandle().add(op);
            }
            int i = 0;
            do {
                if (counter[i] != sizeArray[i] - 1) {
                    int v = i;
                    counter[v] = counter[v] + 1;
                    int x = counter[v];
                    CompanionV value = valueArray[i][x];
                    if (value == null) {
                        valueArray[i][x] = value = (CompanionV)iter[i].next();
                    }
                    op[i] = value;
                    break;
                }
                counter[i] = 0;
                Intrinsics.checkNotNull((Object)valueArray[i][0]);
            } while (++i != sz);
            if (i != sz) continue;
            break;
        }
        return (IOpCalculator)this;
    }
}

