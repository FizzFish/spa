package cn.sast.dataflow.interprocedural.analysis.heapimpl;

import org.jetbrains.annotations.Nullable;

public final class ArrayHeapKVKt {
    @Nullable
    public static Boolean isValidKey(@Nullable Integer key, @Nullable Integer size) {
        if (key == null) {
            return null;
        }
        if (size != null) {
            return key >= size ? false : key >= 0;
        }
        return key >= 0 ? true : null;
    }
}