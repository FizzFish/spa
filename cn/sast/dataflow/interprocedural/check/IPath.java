package cn.sast.dataflow.interprocedural.check;

import cn.sast.common.interner.InternerEquiv;
import cn.sast.common.interner.WeakInternerX;
import com.github.benmanes.caffeine.cache.Interner;
import org.jetbrains.annotations.NotNull;
import soot.Unit;

public abstract class IPath implements InternerEquiv {
    private static final Interner<Object> specialWeakInterner = Interner.newWeakInterner();
    private static final WeakInternerX weakInterner = new WeakInternerX();

    protected IPath() {
    }

    @NotNull
    public abstract Unit getNode();

    public static Interner<Object> getSpecialWeakInterner() {
        return specialWeakInterner;
    }

    public static WeakInternerX getWeakInterner() {
        return weakInterner;
    }

    public static final class Companion {
        private Companion() {
        }
    }
}