package cn.sast.dataflow.interprocedural.check;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class PathGeneratorKt {
    @NotNull
    public static <E> List<E> getRemoveAdjacentDuplicates(@NotNull List<? extends E> list) {
        if (list.isEmpty()) {
            return list;
        }

        List<E> result = new ArrayList<>();
        E prev = null;
        
        for (E current : list) {
            if (!current.equals(prev)) {
                result.add(current);
                prev = current;
            }
        }
        
        return result;
    }
}
