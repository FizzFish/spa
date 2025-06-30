/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.baseimpl;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Lcom/feysh/corax/config/api/baseimpl/ConfigException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "value", "", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "toString", "", "corax-config-api"})
public final class ConfigException
extends Exception {
    @NotNull
    private final Object value;

    public ConfigException(@NotNull Object value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        this.value = value;
    }

    @NotNull
    public final Object getValue() {
        return this.value;
    }

    @Override
    @NotNull
    public String toString() {
        StackTraceElement[] stackTraceElementArray = this.getStackTrace();
        Intrinsics.checkNotNullExpressionValue((Object)stackTraceElementArray, (String)"getStackTrace(...)");
        return ArraysKt.firstOrNull((Object[])stackTraceElementArray) + " `" + this.value + "` is incorrect";
    }
}

