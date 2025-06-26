/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapKVKt
 *  kotlin.Metadata
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.analysis.heapimpl;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0000\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2={"isValidKey", "", "key", "", "size", "(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/Boolean;", "corax-data-flow"})
public final class ArrayHeapKVKt {
    @Nullable
    public static final Boolean isValidKey(@Nullable Integer key2, @Nullable Integer size) {
        if (key2 != null) {
            if (size != null) {
                return key2 >= size ? Boolean.valueOf(false) : Boolean.valueOf(key2 >= 0);
            }
            if (key2 < 0) {
                return false;
            }
        }
        return null;
    }
}

