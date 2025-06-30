/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.cache;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 \t*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lcom/feysh/corax/cache/XOptional;", "T", "", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "Companion", "corax-config-api"})
public final class XOptional<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final T value;

    private XOptional(T value) {
        this.value = value;
    }

    public final T getValue() {
        return this.value;
    }

    public /* synthetic */ XOptional(Object value, DefaultConstructorMarker $constructor_marker) {
        this(value);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2={"Lcom/feysh/corax/cache/XOptional$Companion;", "", "<init>", "()V", "of", "Lcom/feysh/corax/cache/XOptional;", "T", "value", "(Ljava/lang/Object;)Lcom/feysh/corax/cache/XOptional;", "corax-config-api"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final <T> XOptional<T> of(T value) {
            return new XOptional(value, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

