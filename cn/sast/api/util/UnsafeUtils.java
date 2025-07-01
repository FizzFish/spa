package cn.sast.api.util;

import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.ClassWriter;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public final class UnsafeUtils {
    public static final UnsafeUtils INSTANCE = new UnsafeUtils();

    private UnsafeUtils() {
    }

    @NotNull
    public <T> Class<? extends T> defineAnonymousConcreteSubclass(@NotNull Class<T> abstractClass) {
        if (abstractClass == null) {
            throw new IllegalArgumentException("abstractClass cannot be null");
        }
        if (!Modifier.isAbstract(abstractClass.getModifiers())) {
            throw new IllegalArgumentException(abstractClass + " is not abstract");
        }

        ClassWriter cw = new ClassWriter(0);
        String superClassName = abstractClass.getName().replace('.', '/');
        String className = UnsafeUtils.class.getPackage().getName().replace('.', '/') + "/Anonymous";
        cw.visit(52, 0, className, null, superClassName, null);
        cw.visitEnd();

        try {
            Predicate<Method> methodPredicate = method -> "defineHiddenClass".equals(method.getName());
            Predicate<Class<?>> classPredicate = clazz -> "ClassOption".equals(clazz.getSimpleName());

            Optional<Method> defineHiddenClass = Arrays.stream(MethodHandles.Lookup.class.getMethods())
                    .filter(methodPredicate)
                    .findFirst();

            Optional<Class<?>> classOption = Arrays.stream(MethodHandles.Lookup.class.getClasses())
                    .filter(classPredicate)
                    .findFirst();

            if (defineHiddenClass.isPresent() && classOption.isPresent()) {
                Object[] args = {cw.toByteArray(), true, Array.newInstance(classOption.get(), 0)};
                MethodHandles.Lookup lookup = (MethodHandles.Lookup) defineHiddenClass.get()
                        .invoke(MethodHandles.lookup(), args);
                return lookup.lookupClass().asSubclass(abstractClass);
            } else {
                Method method = UnsafeProvider.INSTANCE.getUnsafe()
                        .getClass()
                        .getMethod("defineAnonymousClass", Class.class, byte[].class, Object[].class);
                Class<?> clazz = (Class<?>) method.invoke(
                        UnsafeProvider.INSTANCE.getUnsafe(),
                        UnsafeUtils.class,
                        cw.toByteArray(),
                        null
                );
                return clazz.asSubclass(abstractClass);
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
    }
}
