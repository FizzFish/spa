/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.CompanionValueImpl1
 *  cn.sast.dataflow.interprocedural.check.HeapValuesEnvImpl
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  cn.sast.dataflow.interprocedural.check.MergePath
 *  cn.sast.dataflow.interprocedural.check.PathCompanionV
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.HeapValuesEnvImpl;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.MergePath;
import cn.sast.dataflow.interprocedural.check.PathCompanionV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u00020\u0004B\u001b\u0012\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ$\u0010\f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0010\u0010\r\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001e\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2={"Lcn/sast/dataflow/interprocedural/check/CompanionValueImpl1;", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "Lcn/sast/dataflow/interprocedural/check/PathCompanionV;", "value", "path", "Lcn/sast/dataflow/interprocedural/check/IPath;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/IValue;Lcn/sast/dataflow/interprocedural/check/IPath;)V", "getPath", "()Lcn/sast/dataflow/interprocedural/check/IPath;", "union", "other", "toString", "", "copy", "updateValue", "corax-data-flow"})
public final class CompanionValueImpl1
extends CompanionV<IValue>
implements PathCompanionV {
    @NotNull
    private final IPath path;

    public CompanionValueImpl1(@NotNull IValue value, @NotNull IPath path) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        super((Object)value);
        this.path = path;
    }

    @NotNull
    public IPath getPath() {
        return this.path;
    }

    @NotNull
    public CompanionV<IValue> union(@NotNull CompanionV<IValue> other) {
        Intrinsics.checkNotNullParameter(other, (String)"other");
        if (!Intrinsics.areEqual((Object)this.getValue(), (Object)other.getValue())) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        IPath path = MergePath.Companion.v((HeapValuesEnv)new HeapValuesEnvImpl(this.getPath()), this.getPath(), ((PathCompanionV)other).getPath());
        return (CompanionV)new CompanionValueImpl1((IValue)this.getValue(), path);
    }

    @NotNull
    public String toString() {
        return "<" + this.getValue() + ">";
    }

    @NotNull
    public CompanionV<IValue> copy(@NotNull IValue updateValue) {
        Intrinsics.checkNotNullParameter((Object)updateValue, (String)"updateValue");
        return (CompanionV)new CompanionValueImpl1(updateValue, this.getPath());
    }
}

