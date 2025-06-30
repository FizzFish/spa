/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.properties.ReadWriteProperty
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.commons;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0014B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0096\u0002\u00a2\u0006\u0002\u0010\rJ*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lcom/feysh/corax/commons/NullableLateinit;", "T", "Lkotlin/properties/ReadWriteProperty;", "", "errorMessage", "", "<init>", "(Ljava/lang/String;)V", "value", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "uninitialized", "isUninitialized", "", "UNINITIALIZED", "corax-config-api"})
public final class NullableLateinit<T>
implements ReadWriteProperty<Object, T> {
    @NotNull
    private final String errorMessage;
    @Nullable
    private Object value;

    public NullableLateinit(@NotNull String errorMessage) {
        Intrinsics.checkNotNullParameter((Object)errorMessage, (String)"errorMessage");
        this.errorMessage = errorMessage;
        this.value = UNINITIALIZED.INSTANCE;
    }

    public T getValue(@NotNull Object thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter((Object)thisRef, (String)"thisRef");
        Intrinsics.checkNotNullParameter(property, (String)"property");
        if (this.value == UNINITIALIZED.INSTANCE) {
            throw new IllegalStateException(this.errorMessage);
        }
        try {
            return (T)this.value;
        }
        catch (ClassCastException e) {
            throw new IllegalStateException(this.errorMessage);
        }
    }

    public void setValue(@NotNull Object thisRef, @NotNull KProperty<?> property, T value) {
        Intrinsics.checkNotNullParameter((Object)thisRef, (String)"thisRef");
        Intrinsics.checkNotNullParameter(property, (String)"property");
        this.value = value;
    }

    public final void uninitialized() {
        this.value = UNINITIALIZED.INSTANCE;
    }

    public final boolean isUninitialized() {
        return Intrinsics.areEqual((Object)this.value, (Object)UNINITIALIZED.INSTANCE);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lcom/feysh/corax/commons/NullableLateinit$UNINITIALIZED;", "", "<init>", "()V", "corax-config-api"})
    private static final class UNINITIALIZED {
        @NotNull
        public static final UNINITIALIZED INSTANCE = new UNINITIALIZED();

        private UNINITIALIZED() {
        }
    }
}

