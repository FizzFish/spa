package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.CompanionValueOfConst;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.MergePath;
import cn.sast.dataflow.interprocedural.check.PathCompanionV;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class PathCompanionKt {

    @NotNull
    public static IValue getBindDelegate(@NotNull CompanionV<IValue> companion) {
        if (companion == null) {
            throw new IllegalArgumentException("<this> cannot be null");
        }
        return companion instanceof CompanionValueOfConst 
            ? ((CompanionValueOfConst) companion).getAttr() 
            : companion.getValue();
    }

    private static <K, V> Map<K, V> getShort(Map<K, ? extends V> map) {
        int size = map.size();
        switch (size) {
            case 0:
                return Collections.emptyMap();
            case 1:
                Map.Entry<K, V> entry = map.entrySet().iterator().next();
                return Collections.singletonMap(entry.getKey(), entry.getValue());
            default:
                return map;
        }
    }

    private static <E> Set<E> getShort(Set<? extends E> set) {
        int size = set.size();
        switch (size) {
            case 0:
                return Collections.emptySet();
            case 1:
                return Collections.singleton(set.iterator().next());
            default:
                return set;
        }
    }

    @NotNull
    public static IPath path(@NotNull IHeapValues<IValue> heapValues, @NotNull HeapValuesEnv env) {
        if (heapValues == null) {
            throw new IllegalArgumentException("<this> cannot be null");
        }
        if (env == null) {
            throw new IllegalArgumentException("env cannot be null");
        }

        Set<PathCompanionV> companions = new HashSet<>(heapValues.getValuesCompanion().size());
        for (CompanionV<IValue> companion : heapValues.getValuesCompanion()) {
            companions.add(((PathCompanionV) companion).getPath());
        }
        return MergePath.Companion.v(env, companions);
    }

    static Map access$getShort(Map map) {
        return getShort(map);
    }
}