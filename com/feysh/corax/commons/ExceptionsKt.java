/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.commons;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2={"checkCritical", "", "", "corax-config-api"})
public final class ExceptionsKt {
    public static final void checkCritical(@NotNull Throwable $this$checkCritical) {
        Intrinsics.checkNotNullParameter((Object)$this$checkCritical, (String)"<this>");
        Throwable throwable = $this$checkCritical;
        if (throwable instanceof IOException) {
            String string = $this$checkCritical.getMessage();
            boolean bl = string != null ? StringsKt.contains((CharSequence)string, (CharSequence)"no space left", (boolean)true) : false;
            if (bl) {
                $this$checkCritical.printStackTrace(System.err);
                System.exit(2);
                throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
            }
        } else if (throwable instanceof OutOfMemoryError) {
            $this$checkCritical.printStackTrace(System.err);
            System.exit(10);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }
}

