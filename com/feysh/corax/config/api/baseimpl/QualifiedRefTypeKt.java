/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.baseimpl;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0002H\u0000\u00a8\u0006\u0003"}, d2={"splitPackage", "Lkotlin/Pair;", "", "corax-config-api"})
public final class QualifiedRefTypeKt {
    @NotNull
    public static final Pair<String, String> splitPackage(@NotNull String $this$splitPackage) {
        Pair pair;
        Intrinsics.checkNotNullParameter((Object)$this$splitPackage, (String)"<this>");
        int index = StringsKt.lastIndexOf$default((CharSequence)$this$splitPackage, (String)".", (int)0, (boolean)false, (int)6, null);
        if (index == -1) {
            pair = TuplesKt.to((Object)"", (Object)$this$splitPackage);
        } else {
            String string = $this$splitPackage.substring(0, index);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"substring(...)");
            String string2 = $this$splitPackage.substring(index + 1);
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"substring(...)");
            pair = TuplesKt.to((Object)string, (Object)string2);
        }
        return pair;
    }
}

