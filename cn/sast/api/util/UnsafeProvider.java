package cn.sast.api.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

public final class UnsafeProvider {
    @NotNull
    public static final UnsafeProvider INSTANCE = new UnsafeProvider();
    @NotNull
    private static final Unsafe unsafe = INSTANCE.getUnsafeInternal();

    private UnsafeProvider() {
    }

    @NotNull
    public Unsafe getUnsafe() {
        return unsafe;
    }

    private Unsafe getUnsafeInternal() {
        try {
            return Unsafe.getUnsafe();
        } catch (Throwable unused) {
            for (Field f : Unsafe.class.getDeclaredFields()) {
                if (!f.getType().equals(Unsafe.class)) {
                    continue;
                }
                f.setAccessible(true);
                try {
                    return (Unsafe) f.get(null);
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException("Failed to access Unsafe member on Unsafe class", e);
                }
            }
            throw new IllegalStateException("Failed to find Unsafe member on Unsafe class, have: " 
                + Arrays.deepToString(Unsafe.class.getDeclaredFields()));
        }
    }
}