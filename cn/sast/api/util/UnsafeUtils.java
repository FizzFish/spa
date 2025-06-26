/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.UnsafeProvider
 *  cn.sast.api.util.UnsafeUtils
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.objectweb.asm.ClassWriter
 */
package cn.sast.api.util;

import cn.sast.api.util.UnsafeProvider;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.ClassWriter;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\u00a8\u0006\b"}, d2={"Lcn/sast/api/util/UnsafeUtils;", "", "<init>", "()V", "defineAnonymousConcreteSubclass", "Ljava/lang/Class;", "T", "abstractClass", "corax-api"})
@SourceDebugExtension(value={"SMAP\nUnsafeUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnsafeUtils.kt\ncn/sast/api/util/UnsafeUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
public final class UnsafeUtils {
    @NotNull
    public static final UnsafeUtils INSTANCE = new UnsafeUtils();

    private UnsafeUtils() {
    }

    @NotNull
    public final <T> Class<? extends T> defineAnonymousConcreteSubclass(@NotNull Class<T> abstractClass) {
        Class clazz;
        Intrinsics.checkNotNullParameter(abstractClass, (String)"abstractClass");
        if (!Modifier.isAbstract(abstractClass.getModifiers())) {
            boolean $i$a$-require-UnsafeUtils$defineAnonymousConcreteSubclass$22 = false;
            String $i$a$-require-UnsafeUtils$defineAnonymousConcreteSubclass$22 = abstractClass + " is not abstract";
            throw new IllegalArgumentException($i$a$-require-UnsafeUtils$defineAnonymousConcreteSubclass$22.toString());
        }
        ClassWriter cw = new ClassWriter(0);
        String string = abstractClass.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        String superClassName = StringsKt.replace$default((String)string, (char)'.', (char)'/', (boolean)false, (int)4, null);
        String string2 = UnsafeUtils.class.getPackage().getName();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getName(...)");
        String className = StringsKt.replace$default((String)string2, (char)'.', (char)'/', (boolean)false, (int)4, null) + "/Anonymous";
        cw.visit(52, 0, className, null, superClassName, null);
        cw.visitEnd();
        try {
            Class clazz2;
            Function1 function1 = UnsafeUtils::defineAnonymousConcreteSubclass$lambda$1;
            Optional<Method> defineHiddenClass = Arrays.stream(MethodHandles.Lookup.class.getMethods()).filter((Predicate)new /* Unavailable Anonymous Inner Class!! */).findFirst();
            Object object = UnsafeUtils::defineAnonymousConcreteSubclass$lambda$2;
            Optional<Class<?>> classOption = Arrays.stream(MethodHandles.Lookup.class.getClasses()).filter((Predicate)new /* Unavailable Anonymous Inner Class!! */).findFirst();
            if (defineHiddenClass.isPresent() && classOption.isPresent()) {
                var8_13 = new Object[]{cw.toByteArray(), true, Array.newInstance(classOption.get(), 0)};
                Object object2 = defineHiddenClass.get().invoke(MethodHandles.lookup(), var8_13);
                Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type java.lang.invoke.MethodHandles.Lookup");
                clazz2 = ((MethodHandles.Lookup)object2).lookupClass().asSubclass(abstractClass);
            } else {
                var8_13 = new Class[]{Class.class, byte[].class, Object[].class};
                Method method = UnsafeProvider.INSTANCE.getUnsafe().getClass().getMethod("defineAnonymousClass", (Class<?>[])var8_13);
                var8_13 = new Object[]{UnsafeUtils.class, cw.toByteArray(), null};
                object = method.invoke(UnsafeProvider.INSTANCE.getUnsafe(), var8_13);
                Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type java.lang.Class<out T of cn.sast.api.util.UnsafeUtils.defineAnonymousConcreteSubclass>");
                clazz2 = (Class)object;
            }
            clazz = clazz2;
        }
        catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
        catch (InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
        catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
        return clazz;
    }

    private static final boolean defineAnonymousConcreteSubclass$lambda$1(Method method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        return Intrinsics.areEqual((Object)method.getName(), (Object)"defineHiddenClass");
    }

    private static final boolean defineAnonymousConcreteSubclass$lambda$2(Class clazz) {
        Intrinsics.checkNotNullParameter((Object)clazz, (String)"clazz");
        return Intrinsics.areEqual((Object)clazz.getSimpleName(), (Object)"ClassOption");
    }
}

