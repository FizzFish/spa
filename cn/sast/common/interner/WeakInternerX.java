package cn.sast.common.interner;

import com.google.common.base.Equivalence;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners;
import org.jetbrains.annotations.NotNull;

public final class WeakInternerX {
    private final Interner<InternerEquiv> interner;

    public WeakInternerX() {
        this.interner = Interners.newWeakInterner();
    }

    @NotNull
    public final <E extends InternerEquiv> E intern(@NotNull E value) {
        if (value == null) {
            throw new NullPointerException("value");
        }
        return (E) interner.intern(value);
    }
}