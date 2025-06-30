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

import com.feysh.corax.config.api.IClassMatch;
import com.feysh.corax.config.api.baseimpl.RawSignatureMatch;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2={"method", "Lcom/feysh/corax/config/api/baseimpl/RawSignatureMatch;", "Lcom/feysh/corax/config/api/IClassMatch;", "methodName", "", "", "(Lcom/feysh/corax/config/api/IClassMatch;[Ljava/lang/String;)Lcom/feysh/corax/config/api/baseimpl/RawSignatureMatch;", "corax-config-api"})
public final class MatchersKt {
    @NotNull
    public static final RawSignatureMatch method(@NotNull IClassMatch $this$method, String ... methodName) {
        Intrinsics.checkNotNullParameter((Object)$this$method, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)methodName, (String)"methodName");
        return new RawSignatureMatch($this$method, ArraysKt.toList((Object[])methodName), null, null, null, 16, null);
    }
}

