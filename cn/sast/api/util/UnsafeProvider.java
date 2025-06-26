/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.UnsafeProvider
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.ArrayIteratorKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.api.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\n"}, d2={"Lcn/sast/api/util/UnsafeProvider;", "", "<init>", "()V", "unsafe", "Lsun/misc/Unsafe;", "getUnsafe", "()Lsun/misc/Unsafe;", "unsafeInternal", "getUnsafeInternal", "corax-api"})
public final class UnsafeProvider {
    @NotNull
    public static final UnsafeProvider INSTANCE = new UnsafeProvider();
    @NotNull
    private static final Unsafe unsafe = INSTANCE.getUnsafeInternal();

    private UnsafeProvider() {
    }

    @NotNull
    public final Unsafe getUnsafe() {
        return unsafe;
    }

    private final Unsafe getUnsafeInternal() {
        try {
            Unsafe unsafe = Unsafe.getUnsafe();
            Intrinsics.checkNotNullExpressionValue((Object)unsafe, (String)"getUnsafe(...)");
            return unsafe;
        }
        catch (Throwable unused) {
            Iterator iterator2 = ArrayIteratorKt.iterator((Object[])Unsafe.class.getDeclaredFields());
            while (iterator2.hasNext()) {
                Unsafe unsafe;
                Field f = (Field)iterator2.next();
                if (!Intrinsics.areEqual(f.getType(), Unsafe.class)) continue;
                f.setAccessible(true);
                try {
                    Object object = f.get(null);
                    Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type sun.misc.Unsafe");
                    unsafe = (Unsafe)object;
                }
                catch (IllegalAccessException e) {
                    throw new IllegalStateException("Failed to access Unsafe member on Unsafe class", e);
                }
                return unsafe;
            }
            Object object = Unsafe.class.getDeclaredFields();
            object = "Failed to find Unsafe member on Unsafe class, have: " + ArraysKt.contentDeepToString((Object[])object);
            Object[] objectArray = new Object[]{};
            String string = String.format((String)object, Arrays.copyOf(objectArray, objectArray.length));
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"format(...)");
            throw new IllegalStateException(string);
        }
    }
}

