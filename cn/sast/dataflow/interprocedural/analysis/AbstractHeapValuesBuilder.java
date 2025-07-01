package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapValues;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.ReferenceContext;
import cn.sast.dataflow.util.Printer;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractHeapValuesBuilder<V> implements IHeapValues.Builder<V> {
    @NotNull
    private final AbstractHeapValues<V> orig;
    @NotNull
    private final Map<V, CompanionV<V>> map;

    protected AbstractHeapValuesBuilder(@NotNull AbstractHeapValues<V> orig, @NotNull Map<V, CompanionV<V>> map) {
        this.orig = orig;
        this.map = map;
    }

    @NotNull
    public AbstractHeapValues<V> getOrig() {
        return this.orig;
    }

    @NotNull
    public final Map<V, CompanionV<V>> getMap() {
        return this.map;
    }

    public boolean isNotEmpty() {
        return !map.isEmpty();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    @NotNull
    public IHeapValues.Builder<V> add(@NotNull IHeapValues<V> elements) {
        if (elements instanceof AbstractHeapValues) {
            for (CompanionV<V> e : (AbstractHeapValues<V>) elements) {
                add(e);
            }
        }
        return this;
    }

    @NotNull
    public IHeapValues.Builder<V> add(@NotNull CompanionV<V> element) {
        V k = element.getValue();
        CompanionV<V> existV = map.get(k);
        if (existV == null) {
            map.put(k, element);
        } else {
            map.put(k, existV.union(element));
        }
        return this;
    }

    public void cloneAndReNewObjects(@NotNull IReNew<V> re) {
        Map<V, CompanionV<V>> old = Map.copyOf(map);
        for (Map.Entry<V, CompanionV<V>> entry : old.entrySet()) {
            V k = entry.getKey();
            CompanionV<V> v = entry.getValue();
            
            V newKey = re.checkNeedReplace(k);
            if (newKey == null) {
                newKey = k;
            }
            
            CompanionV<V> newValue = re.context(new ReferenceContext.ObjectValues(k)).checkNeedReplace(v);
            if (newValue == null) {
                newValue = v;
            }
            
            if (k.equals(newKey) && newValue == v) {
                continue;
            }
            
            if (!newValue.getValue().equals(newKey)) {
                newValue = newValue.copy(newKey);
            }
            
            map.put(newKey, newValue);
            if (!k.equals(newKey)) {
                map.remove(k);
            }
        }
    }

    @NotNull
    public String toString() {
        return Printer.nodes2String(map.values());
    }
}