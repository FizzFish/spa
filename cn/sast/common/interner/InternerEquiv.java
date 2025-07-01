package cn.sast.common.interner;

import org.jetbrains.annotations.Nullable;

public interface InternerEquiv {
    boolean equivTo(@Nullable Object other);

    int equivHashCode();
}