/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.interner.InternerEquiv
 *  com.google.common.base.Equivalence
 *  com.google.common.base.InternerEquals
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.google.common.base;

import cn.sast.common.interner.InternerEquiv;
import com.google.common.base.Equivalence;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lcom/google/common/base/InternerEquals;", "T", "Lcn/sast/common/interner/InternerEquiv;", "Lcom/google/common/base/Equivalence;", "<init>", "()V", "doEquivalent", "", "a", "b", "(Lcn/sast/common/interner/InternerEquiv;Lcn/sast/common/interner/InternerEquiv;)Z", "doHash", "", "o", "(Lcn/sast/common/interner/InternerEquiv;)I", "corax-api"})
public final class InternerEquals<T extends InternerEquiv>
extends Equivalence<T> {
    protected boolean doEquivalent(@NotNull T a, @NotNull T b) {
        Intrinsics.checkNotNullParameter(a, (String)"a");
        Intrinsics.checkNotNullParameter(b, (String)"b");
        return a.equivTo(b);
    }

    protected int doHash(@NotNull T o) {
        Intrinsics.checkNotNullParameter(o, (String)"o");
        return o.equivHashCode();
    }
}

