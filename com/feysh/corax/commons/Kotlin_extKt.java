package com.feysh.corax.commons;

import kotlin.properties.PropertyDelegateProvider;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;

public final class KotlinExtKt {
    @NotNull
    public static <T> PropertyDelegateProvider<Object, ReadWriteProperty<Object, T>> delegateField(
            @NotNull Object instance,
            @Nullable Class<?> clazz) {
        if (instance == null) {
            throw new IllegalArgumentException("<this> cannot be null");
        }
        return new FieldDelegateProvider<>(instance, clazz);
    }

    private static class FieldDelegateProvider<T> implements PropertyDelegateProvider<Object, ReadWriteProperty<Object, T>> {
        private final Object instance;
        private final Class<?> clazz;

        FieldDelegateProvider(Object instance, Class<?> clazz) {
            this.instance = instance;
            this.clazz = clazz;
        }

        @Override
        public ReadWriteProperty<Object, T> provideDelegate(Object thisRef, KProperty<?> property) {
            if (property == null) {
                throw new IllegalArgumentException("property cannot be null");
            }
            return new FieldDelegate<>(clazz != null ? clazz : instance.getClass(), instance, property.getName());
        }
    }

    private static class FieldDelegate<T> implements ReadWriteProperty<Object, T> {
        private final Class<?> clazz;
        private final Object instance;
        private final String fieldName;
        private Field field;

        FieldDelegate(Class<?> clazz, Object instance, String fieldName) {
            this.clazz = clazz;
            this.instance = instance;
            this.fieldName = fieldName;
        }

        private Field getField() throws NoSuchFieldException {
            if (field == null) {
                field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
            }
            return field;
        }

        @Override
        public T getValue(Object thisRef, KProperty<?> property) {
            try {
                return (T) getField().get(instance);
            } catch (Exception e) {
                throw new RuntimeException("Failed to get field value", e);
            }
        }

        @Override
        public void setValue(Object thisRef, KProperty<?> property, T value) {
            try {
                getField().set(instance, value);
            } catch (Exception e) {
                throw new RuntimeException("Failed to set field value", e);
            }
        }
    }

    public static <T extends Comparable<? super T>> int compareToNullable(@Nullable T first, @Nullable T second) {
        if (first == null && second == null) {
            return 0;
        }
        if (first == null) {
            return 1;
        }
        if (second == null) {
            return -1;
        }
        return first.compareTo(second);
    }
}