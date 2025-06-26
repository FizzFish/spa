/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorHV
 *  cn.sast.dataflow.interprocedural.check.AssignLocalPath
 *  cn.sast.dataflow.interprocedural.check.GetEdgePath
 *  cn.sast.dataflow.interprocedural.check.GetEdgePath$Companion
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  cn.sast.dataflow.interprocedural.check.JOperatorHVImpl
 *  cn.sast.dataflow.interprocedural.check.PathCompanionV
 *  cn.sast.dataflow.interprocedural.check.PathFactory
 *  cn.sast.dataflow.interprocedural.check.SetEdgePath
 *  cn.sast.dataflow.interprocedural.check.SetEdgePath$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JOperatorHV;
import cn.sast.dataflow.interprocedural.check.AssignLocalPath;
import cn.sast.dataflow.interprocedural.check.GetEdgePath;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.PathCompanionV;
import cn.sast.dataflow.interprocedural.check.PathFactory;
import cn.sast.dataflow.interprocedural.check.SetEdgePath;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B3\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0010\u0010\b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\tH\u0016JE\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001\"\u0004\b\u0000\u0010\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\u0010\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001b2\b\u0010\u001c\u001a\u0004\u0018\u0001H\u0016H\u0016\u00a2\u0006\u0002\u0010\u001dJE\u0010\u001e\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001\"\u0004\b\u0000\u0010\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\u0010\u0010\u001f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001b2\b\u0010\u001c\u001a\u0004\u0018\u0001H\u0016H\u0016\u00a2\u0006\u0002\u0010\u001dJ,\u0010 \u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0006\u0010\u001a\u001a\u00020\u00182\u0010\u0010!\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\tH\u0016J$\u0010\"\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0010\u0010\u001f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001bH\u0016J \u0010#\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\u0013\u0010%\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0007H\u00c6\u0003J\u0013\u0010'\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\tH\u00c2\u0003J;\u0010(\u001a\u00020\u00002\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\tH\u00c6\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003J\t\u0010,\u001a\u00020-H\u00d6\u0001J\t\u0010.\u001a\u00020/H\u00d6\u0001R\u001b\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u00060"}, d2={"Lcn/sast/dataflow/interprocedural/check/JOperatorHVImpl;", "Lcn/sast/dataflow/interprocedural/analysis/JOperatorHV;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "heapFactory", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "value", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;)V", "getHeapFactory", "()Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "getEnv", "()Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "pf", "Lcn/sast/dataflow/interprocedural/check/PathFactory;", "getPf", "()Lcn/sast/dataflow/interprocedural/check/PathFactory;", "pop", "setKVValue", "K", "mt", "", "Lcn/sast/dataflow/interprocedural/check/ModelT;", "lhs", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "key", "(Ljava/lang/Object;Lcn/sast/dataflow/interprocedural/analysis/CompanionV;Ljava/lang/Object;)Lcn/sast/dataflow/interprocedural/analysis/JOperatorHV;", "getKVValue", "rhs", "assignLocal", "rhsValue", "markOfArrayLength", "dataElementCopyToSequenceElement", "sourceElement", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "corax-data-flow"})
public final class JOperatorHVImpl
implements JOperatorHV<IValue> {
    @NotNull
    private final AbstractHeapFactory<IValue> heapFactory;
    @NotNull
    private final HeapValuesEnv env;
    @NotNull
    private final IHeapValues<IValue> value;
    @NotNull
    private final PathFactory<IValue> pf;

    public JOperatorHVImpl(@NotNull AbstractHeapFactory<IValue> heapFactory, @NotNull HeapValuesEnv env, @NotNull IHeapValues<IValue> value) {
        Intrinsics.checkNotNullParameter(heapFactory, (String)"heapFactory");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(value, (String)"value");
        this.heapFactory = heapFactory;
        this.env = env;
        this.value = value;
        this.pf = this.heapFactory.getPathFactory();
    }

    @NotNull
    public final AbstractHeapFactory<IValue> getHeapFactory() {
        return this.heapFactory;
    }

    @NotNull
    public final HeapValuesEnv getEnv() {
        return this.env;
    }

    @NotNull
    public final PathFactory<IValue> getPf() {
        return this.pf;
    }

    @NotNull
    public IHeapValues<IValue> pop() {
        return this.value;
    }

    @NotNull
    public <K> JOperatorHV<IValue> setKVValue(@NotNull Object mt, @NotNull CompanionV<IValue> lhs, @Nullable K key2) {
        Intrinsics.checkNotNullParameter((Object)mt, (String)"mt");
        Intrinsics.checkNotNullParameter(lhs, (String)"lhs");
        return (JOperatorHV)JOperatorHVImpl.copy$default((JOperatorHVImpl)this, null, null, (IHeapValues)this.pf.updatePath(this.env, this.value, (arg_0, arg_1) -> JOperatorHVImpl.setKVValue$lambda$0(this, lhs, mt, key2, arg_0, arg_1)), (int)3, null);
    }

    @NotNull
    public <K> JOperatorHV<IValue> getKVValue(@NotNull Object mt, @NotNull CompanionV<IValue> rhs, @Nullable K key2) {
        Intrinsics.checkNotNullParameter((Object)mt, (String)"mt");
        Intrinsics.checkNotNullParameter(rhs, (String)"rhs");
        return (JOperatorHV)JOperatorHVImpl.copy$default((JOperatorHVImpl)this, null, null, (IHeapValues)this.pf.updatePath(this.env, this.value, (arg_0, arg_1) -> JOperatorHVImpl.getKVValue$lambda$1(this, rhs, mt, key2, arg_0, arg_1)), (int)3, null);
    }

    @NotNull
    public JOperatorHV<IValue> assignLocal(@NotNull Object lhs, @NotNull IHeapValues<IValue> rhsValue) {
        Intrinsics.checkNotNullParameter((Object)lhs, (String)"lhs");
        Intrinsics.checkNotNullParameter(rhsValue, (String)"rhsValue");
        return (JOperatorHV)JOperatorHVImpl.copy$default((JOperatorHVImpl)this, null, null, (IHeapValues)this.pf.updatePath(this.env, this.value, (arg_0, arg_1) -> JOperatorHVImpl.assignLocal$lambda$2(this, lhs, arg_0, arg_1)), (int)3, null);
    }

    @NotNull
    public JOperatorHV<IValue> markOfArrayLength(@NotNull CompanionV<IValue> rhs) {
        Intrinsics.checkNotNullParameter(rhs, (String)"rhs");
        return (JOperatorHV)this;
    }

    @NotNull
    public JOperatorHV<IValue> dataElementCopyToSequenceElement(@NotNull IHeapValues<IValue> sourceElement) {
        Intrinsics.checkNotNullParameter(sourceElement, (String)"sourceElement");
        return (JOperatorHV)this;
    }

    @NotNull
    public final AbstractHeapFactory<IValue> component1() {
        return this.heapFactory;
    }

    @NotNull
    public final HeapValuesEnv component2() {
        return this.env;
    }

    private final IHeapValues<IValue> component3() {
        return this.value;
    }

    @NotNull
    public final JOperatorHVImpl copy(@NotNull AbstractHeapFactory<IValue> heapFactory, @NotNull HeapValuesEnv env, @NotNull IHeapValues<IValue> value) {
        Intrinsics.checkNotNullParameter(heapFactory, (String)"heapFactory");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(value, (String)"value");
        return new JOperatorHVImpl(heapFactory, env, value);
    }

    public static /* synthetic */ JOperatorHVImpl copy$default(JOperatorHVImpl jOperatorHVImpl, AbstractHeapFactory abstractHeapFactory, HeapValuesEnv heapValuesEnv, IHeapValues iHeapValues, int n, Object object) {
        if ((n & 1) != 0) {
            abstractHeapFactory = jOperatorHVImpl.heapFactory;
        }
        if ((n & 2) != 0) {
            heapValuesEnv = jOperatorHVImpl.env;
        }
        if ((n & 4) != 0) {
            iHeapValues = jOperatorHVImpl.value;
        }
        return jOperatorHVImpl.copy(abstractHeapFactory, heapValuesEnv, iHeapValues);
    }

    @NotNull
    public String toString() {
        return "JOperatorHVImpl(heapFactory=" + this.heapFactory + ", env=" + this.env + ", value=" + this.value + ")";
    }

    public int hashCode() {
        int result = this.heapFactory.hashCode();
        result = result * 31 + this.env.hashCode();
        result = result * 31 + this.value.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JOperatorHVImpl)) {
            return false;
        }
        JOperatorHVImpl jOperatorHVImpl = (JOperatorHVImpl)other;
        if (!Intrinsics.areEqual((Object)this.heapFactory, (Object)jOperatorHVImpl.heapFactory)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.env, (Object)jOperatorHVImpl.env)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.value, (Object)jOperatorHVImpl.value);
    }

    private static final IPath setKVValue$lambda$0(JOperatorHVImpl this$0, CompanionV $lhs, Object $mt, Object $key, IValue v, IPath valuePath) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Intrinsics.checkNotNullParameter((Object)valuePath, (String)"valuePath");
        HeapValuesEnv heapValuesEnv = this$0.env;
        IValue iValue = (IValue)$lhs.getValue();
        Intrinsics.checkNotNull((Object)$lhs, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.check.PathCompanionV");
        return (IPath)SetEdgePath.Companion.v$default((SetEdgePath.Companion)SetEdgePath.Companion, (HeapValuesEnv)heapValuesEnv, (IValue)iValue, (IPath)((PathCompanionV)$lhs).getPath(), (Object)$mt, (Object)$key, (IValue)v, (IPath)valuePath, null, (int)128, null);
    }

    private static final IPath getKVValue$lambda$1(JOperatorHVImpl this$0, CompanionV $rhs, Object $mt, Object $key, IValue v, IPath valuePath) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Intrinsics.checkNotNullParameter((Object)valuePath, (String)"valuePath");
        HeapValuesEnv heapValuesEnv = this$0.env;
        IValue iValue = (IValue)$rhs.getValue();
        Intrinsics.checkNotNull((Object)$rhs, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.check.PathCompanionV");
        return (IPath)GetEdgePath.Companion.v$default((GetEdgePath.Companion)GetEdgePath.Companion, (HeapValuesEnv)heapValuesEnv, (IValue)iValue, (IPath)((PathCompanionV)$rhs).getPath(), (Object)$mt, (Object)$key, (IValue)v, (IPath)valuePath, null, (int)128, null);
    }

    private static final IPath assignLocal$lambda$2(JOperatorHVImpl this$0, Object $lhs, IValue v, IPath valuePath) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Intrinsics.checkNotNullParameter((Object)valuePath, (String)"valuePath");
        return (IPath)AssignLocalPath.Companion.v(this$0.env, $lhs, v, valuePath);
    }
}

