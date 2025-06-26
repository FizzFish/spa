/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0005J\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "V", "", "checkNeedReplace", "old", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "c", "context", "value", "corax-data-flow"})
public interface IReNew<V> {
    @Nullable
    public V checkNeedReplace(V var1);

    @Nullable
    public CompanionV<V> checkNeedReplace(@NotNull CompanionV<V> var1);

    @NotNull
    public IReNew<V> context(@NotNull Object var1);
}

