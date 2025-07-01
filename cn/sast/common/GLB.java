package cn.sast.common;

import com.feysh.corax.config.api.CheckType;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public final class GLB {
    @NotNull
    public static final GLB INSTANCE = new GLB();
    @NotNull
    private static final Set<CheckType> allTypes = new LinkedHashSet<>();

    private GLB() {
    }

    public void plusAssign(@NotNull CheckType t) {
        if (t == null) {
            throw new IllegalArgumentException("t cannot be null");
        }
        synchronized (allTypes) {
            allTypes.add(t);
        }
    }

    public void plusAssign(@NotNull Collection<? extends CheckType> t) {
        if (t == null) {
            throw new IllegalArgumentException("t cannot be null");
        }
        synchronized (allTypes) {
            allTypes.addAll(t);
        }
    }

    @NotNull
    public Set<CheckType> get() {
        return allTypes;
    }
}