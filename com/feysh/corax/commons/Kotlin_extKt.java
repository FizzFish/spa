/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.properties.PropertyDelegateProvider
 *  kotlin.properties.ReadWriteProperty
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.commons;

import com.feysh.corax.commons.Kotlin_extKt;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.PropertyDelegateProvider;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000f\n\u0002\b\u0003\u001a<\u0010\u0000\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\u0004\b\u0000\u0010\u0004*\u00020\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006\u001a+\u0010\u0007\u001a\u00020\b\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\t*\u0004\u0018\u0001H\u00042\b\u0010\n\u001a\u0004\u0018\u0001H\u0004\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"delegateField", "Lkotlin/properties/PropertyDelegateProvider;", "", "Lkotlin/properties/ReadWriteProperty;", "T", "clazz", "Ljava/lang/Class;", "compareToNullable", "", "", "other", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nkotlin-ext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 kotlin-ext.kt\ncom/feysh/corax/commons/Kotlin_extKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,62:1\n1#2:63\n*E\n"})
public final class Kotlin_extKt {
    @NotNull
    public static final <T> PropertyDelegateProvider<Object, ReadWriteProperty<Object, T>> delegateField(@NotNull Object $this$delegateField, @Nullable Class<?> clazz) {
        Intrinsics.checkNotNullParameter((Object)$this$delegateField, (String)"<this>");
        return new PropertyDelegateProvider<Object, ReadWriteProperty<? super Object, T>>($this$delegateField, clazz){
            private final Object instance;
            final /* synthetic */ Class<?> $clazz;
            {
                this.$clazz = $clazz;
                this.instance = $receiver;
            }

            public final Object getInstance() {
                return this.instance;
            }

            public ReadWriteProperty<Object, T> provideDelegate(Object thisRef, KProperty<?> property) {
                Intrinsics.checkNotNullParameter(property, (String)"property");
                return (ReadWriteProperty)new ReadWriteProperty<Object, T>(this.$clazz, this, property){
                    final /* synthetic */ Class<?> $clazz;
                    final /* synthetic */ delegateField.1 this$0;
                    final /* synthetic */ KProperty<?> $property;
                    {
                        this.$clazz = $clazz;
                        this.this$0 = $receiver;
                        this.$property = $property;
                    }

                    public final Field getField() {
                        Field field;
                        Class<?> clazz = this.$clazz;
                        if (clazz == null) {
                            clazz = this.this$0.getInstance().getClass();
                        }
                        Field it = field = clazz.getDeclaredField(this.$property.getName());
                        boolean bl = false;
                        it.setAccessible(true);
                        return field;
                    }

                    public T getValue(Object thisRef, KProperty<?> property) {
                        Intrinsics.checkNotNullParameter(property, (String)"property");
                        return (T)this.getField().get(this.this$0.getInstance());
                    }

                    public void setValue(Object thisRef, KProperty<?> property, T value) {
                        Intrinsics.checkNotNullParameter(property, (String)"property");
                        this.getField().set(this.this$0.getInstance(), value);
                    }
                };
            }
        };
    }

    public static /* synthetic */ PropertyDelegateProvider delegateField$default(Object object, Class clazz, int n, Object object2) {
        if ((n & 1) != 0) {
            clazz = null;
        }
        return Kotlin_extKt.delegateField(object, clazz);
    }

    public static final <T extends Comparable<? super T>> int compareToNullable(@Nullable T $this$compareToNullable, @Nullable T other) {
        Integer n;
        if ($this$compareToNullable == null && other == null) {
            return 0;
        }
        if ($this$compareToNullable == null) {
            return 1;
        }
        if (other == null) {
            return -1;
        }
        Integer n2 = $this$compareToNullable.compareTo(other);
        int it = ((Number)n2).intValue();
        boolean bl = false;
        Integer n3 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl2 = false;
            return it;
        }
        return 0;
    }
}

