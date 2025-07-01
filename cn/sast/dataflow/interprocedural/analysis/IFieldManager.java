/*
 * Copyright (c) 2022, SAPST
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.PhantomField;
import org.jetbrains.annotations.NotNull;
import java.util.Map;
import kotlinx.collections.immutable.PersistentList;

public interface IFieldManager<V extends IValue> extends IValue {
    @NotNull
    Map<PersistentList<JFieldType>, PhantomField<V>> getPhantomFieldMap();

    @NotNull
    PhantomField<V> getPhantomField(@NotNull JFieldType field);

    @NotNull
    PhantomField<V> getPhantomField(@NotNull PersistentList<? extends JFieldType> ap);
}