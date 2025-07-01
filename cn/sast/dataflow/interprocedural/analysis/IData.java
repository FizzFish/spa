package cn.sast.dataflow.interprocedural.analysis;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;

public interface IData<V> extends IDiffAble<V> {
    void reference(@NotNull Collection<V> res);
    
    @NotNull
    Builder<V> builder();
    
    int computeHash();
    
    @NotNull
    IData<V> cloneAndReNewObjects(@NotNull IReNew<V> re);
    
    interface Builder<V> {
    }
}