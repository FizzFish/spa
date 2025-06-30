/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IAnalysisDepends;
import com.feysh.corax.config.api.XDecl;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0015\u0010\b\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0096\u0004J!\u0010\b\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00050\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0096\u0004\u00a8\u0006\r"}, d2={"Lcom/feysh/corax/config/api/PhantomAnalysisDepends;", "Lcom/feysh/corax/config/api/IAnalysisDepends;", "<init>", "()V", "toDecl", "Lcom/feysh/corax/config/api/XDecl;", "target", "", "dependsOn", "", "dep", "", "deps", "corax-config-api"})
public final class PhantomAnalysisDepends
implements IAnalysisDepends {
    @NotNull
    public static final PhantomAnalysisDepends INSTANCE = new PhantomAnalysisDepends();

    private PhantomAnalysisDepends() {
    }

    @Override
    @NotNull
    public XDecl toDecl(@NotNull Object target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        return new XDecl(){};
    }

    @Override
    public void dependsOn(@NotNull XDecl $this$dependsOn, @NotNull XDecl dep) {
        Intrinsics.checkNotNullParameter((Object)$this$dependsOn, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)dep, (String)"dep");
    }

    @Override
    public void dependsOn(@NotNull Collection<? extends XDecl> $this$dependsOn, @NotNull Collection<? extends XDecl> deps) {
        Intrinsics.checkNotNullParameter($this$dependsOn, (String)"<this>");
        Intrinsics.checkNotNullParameter(deps, (String)"deps");
    }
}

