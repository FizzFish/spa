/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.IFieldManager
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.analysis.PhantomField
 *  kotlin.Metadata
 *  kotlinx.collections.immutable.PersistentList
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.PhantomField;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.collections.immutable.PersistentList;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J \u0010\u0003\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0004H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016\u00a8\u0006\u000b"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/IFieldManager;", "V", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "getPhantomFieldMap", "", "Lkotlinx/collections/immutable/PersistentList;", "Lcn/sast/dataflow/interprocedural/analysis/JFieldType;", "Lcn/sast/dataflow/interprocedural/analysis/PhantomField;", "getPhantomField", "field", "ap", "corax-data-flow"})
public interface IFieldManager<V extends IValue>
extends IValue {
    @NotNull
    public Map<PersistentList<JFieldType>, PhantomField<V>> getPhantomFieldMap();

    @NotNull
    public PhantomField<V> getPhantomField(@NotNull JFieldType var1);

    @NotNull
    public PhantomField<V> getPhantomField(@NotNull PersistentList<? extends JFieldType> var1);
}

