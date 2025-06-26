/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.IValue$Kind
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Type
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.IValue;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0017\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u0000H\u0016\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0000H\u0016J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0012"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/IValue;", "", "type", "Lsoot/Type;", "getType", "()Lsoot/Type;", "typeIsConcrete", "", "isNullConstant", "getKind", "Lcn/sast/dataflow/interprocedural/analysis/IValue$Kind;", "isNormal", "objectEqual", "b", "(Lcn/sast/dataflow/interprocedural/analysis/IValue;)Ljava/lang/Boolean;", "clone", "copy", "Kind", "corax-data-flow"})
public interface IValue {
    @NotNull
    public Type getType();

    public boolean typeIsConcrete();

    public boolean isNullConstant();

    @NotNull
    public Kind getKind();

    public boolean isNormal();

    @Nullable
    public Boolean objectEqual(@NotNull IValue var1);

    @NotNull
    public IValue clone();

    @NotNull
    public IValue copy(@NotNull Type var1);
}

