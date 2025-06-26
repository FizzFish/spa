/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.ICalculator
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.CalculatorBase
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.RefType
 *  soot.Type
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.ICalculator;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.RefType;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0018H\u0016J\u0018\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020(H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u000fX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001cX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006)"}, d2={"Lcn/sast/dataflow/interprocedural/check/CalculatorBase;", "Lcn/sast/dataflow/interprocedural/analysis/ICalculator;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "cf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;)V", "getEnv", "()Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "getCf", "()Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "count", "", "getCount", "()I", "setCount", "(I)V", "calculateLimit", "getCalculateLimit", "unHandle", "", "", "getUnHandle", "()Ljava/util/Set;", "res", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "getRes", "()Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "setRes", "(Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;)V", "putSummaryIfNotConcrete", "", "type", "Lsoot/Type;", "special", "putSummaryValue", "isFullySimplified", "", "corax-data-flow"})
public abstract class CalculatorBase
implements ICalculator<IValue> {
    @NotNull
    private final HeapValuesEnv env;
    @NotNull
    private final AbstractHeapFactory<IValue> cf;
    private int count;
    private final int calculateLimit;
    @NotNull
    private final Set<Object> unHandle;
    @NotNull
    private IHeapValues.Builder<IValue> res;

    public CalculatorBase(@NotNull HeapValuesEnv env, @NotNull AbstractHeapFactory<IValue> cf) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(cf, (String)"cf");
        this.env = env;
        this.cf = cf;
        this.calculateLimit = 24;
        this.unHandle = new LinkedHashSet();
        this.res = this.cf.empty().builder();
    }

    @NotNull
    public final HeapValuesEnv getEnv() {
        return this.env;
    }

    @NotNull
    public final AbstractHeapFactory<IValue> getCf() {
        return this.cf;
    }

    public final int getCount() {
        return this.count;
    }

    public final void setCount(int n) {
        this.count = n;
    }

    public final int getCalculateLimit() {
        return this.calculateLimit;
    }

    @NotNull
    public final Set<Object> getUnHandle() {
        return this.unHandle;
    }

    @NotNull
    public IHeapValues.Builder<IValue> getRes() {
        return this.res;
    }

    public void setRes(@NotNull IHeapValues.Builder<IValue> builder2) {
        Intrinsics.checkNotNullParameter(builder2, (String)"<set-?>");
        this.res = builder2;
    }

    public void putSummaryIfNotConcrete(@NotNull Type type, @NotNull Object special) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)special, (String)"special");
        if (!this.isFullySimplified()) {
            this.putSummaryValue(type, special);
        }
    }

    public void putSummaryValue(@NotNull Type type, @NotNull Object special) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)special, (String)"special");
        if (type instanceof RefType) {
            this.getRes().add(this.cf.push(this.env, this.cf.getNullConst()).markOfCantCalcAbstractResultValue().pop());
        }
        CompanionV summary = this.cf.push(this.env, this.cf.newSummaryVal(this.env, type, special)).markOfCantCalcAbstractResultValue().pop();
        this.getRes().add(summary);
    }

    public boolean isFullySimplified() {
        return this.count < this.calculateLimit && this.unHandle.isEmpty();
    }
}

