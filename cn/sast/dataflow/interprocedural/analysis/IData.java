/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IData$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IDiffAble
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IDiffAble;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import java.util.Collection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u000eJ\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&J\b\u0010\t\u001a\u00020\nH&J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH&\u00a8\u0006\u000f"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/IData;", "V", "Lcn/sast/dataflow/interprocedural/analysis/IDiffAble;", "reference", "", "res", "", "builder", "Lcn/sast/dataflow/interprocedural/analysis/IData$Builder;", "computeHash", "", "cloneAndReNewObjects", "re", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "Builder", "corax-data-flow"})
public interface IData<V>
extends IDiffAble<V> {
    public void reference(@NotNull Collection<V> var1);

    @NotNull
    public Builder<V> builder();

    public int computeHash();

    @NotNull
    public IData<V> cloneAndReNewObjects(@NotNull IReNew<V> var1);
}

