/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.ConstVal
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.CompanionValueOfConst
 *  cn.sast.dataflow.interprocedural.check.HeapValuesEnvImpl
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  cn.sast.dataflow.interprocedural.check.MergePath
 *  cn.sast.dataflow.interprocedural.check.PathCompanionV
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.HeapValuesEnvImpl;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.MergePath;
import cn.sast.dataflow.interprocedural.check.PathCompanionV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u00020\u0004B'\u0012\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003H\u0016J$\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\b\u001a\u00060\u0002j\u0002`\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2={"Lcn/sast/dataflow/interprocedural/check/CompanionValueOfConst;", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "Lcn/sast/dataflow/interprocedural/check/PathCompanionV;", "value", "path", "Lcn/sast/dataflow/interprocedural/check/IPath;", "attr", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/IValue;Lcn/sast/dataflow/interprocedural/check/IPath;Lcn/sast/dataflow/interprocedural/analysis/IValue;)V", "getPath", "()Lcn/sast/dataflow/interprocedural/check/IPath;", "getAttr", "()Lcn/sast/dataflow/interprocedural/analysis/IValue;", "copy", "updateValue", "union", "other", "toString", "", "equals", "", "", "computeHash", "", "hashCode", "corax-data-flow"})
public final class CompanionValueOfConst
extends CompanionV<IValue>
implements PathCompanionV {
    @NotNull
    private final IPath path;
    @NotNull
    private final IValue attr;

    public CompanionValueOfConst(@NotNull IValue value, @NotNull IPath path, @NotNull IValue attr) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter((Object)attr, (String)"attr");
        super((Object)value);
        this.path = path;
        this.attr = attr;
        if (!(value instanceof ConstVal)) {
            boolean bl = false;
            throw new IllegalStateException(String.valueOf(value).toString());
        }
    }

    @NotNull
    public IPath getPath() {
        return this.path;
    }

    @NotNull
    public final IValue getAttr() {
        return this.attr;
    }

    @NotNull
    public CompanionV<IValue> copy(@NotNull IValue updateValue) {
        Intrinsics.checkNotNullParameter((Object)updateValue, (String)"updateValue");
        return (CompanionV)new CompanionValueOfConst(updateValue, this.getPath(), this.attr);
    }

    @NotNull
    public CompanionV<IValue> union(@NotNull CompanionV<IValue> other) {
        Intrinsics.checkNotNullParameter(other, (String)"other");
        if (!Intrinsics.areEqual((Object)this.getValue(), (Object)other.getValue())) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        IPath path = MergePath.Companion.v((HeapValuesEnv)new HeapValuesEnvImpl(this.getPath()), this.getPath(), ((PathCompanionV)other).getPath());
        return (CompanionV)new CompanionValueOfConst((IValue)this.getValue(), path, this.attr);
    }

    @NotNull
    public String toString() {
        return "<v=" + this.getValue() + ", attr=" + this.attr + ">";
    }

    public boolean equals(@Nullable Object other) {
        if (!super.equals(other)) {
            return false;
        }
        if (!(other instanceof CompanionValueOfConst)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.attr, (Object)((CompanionValueOfConst)other).attr);
    }

    public int computeHash() {
        int result = super.computeHash();
        result = 31 * result + this.attr.hashCode();
        return result;
    }

    public int hashCode() {
        return super.hashCode();
    }
}

