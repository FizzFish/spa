/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.XDecl;
import java.util.Collection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H&J\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u00a6\u0004J!\u0010\u0005\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u00a6\u0004\u00a8\u0006\n"}, d2={"Lcom/feysh/corax/config/api/IAnalysisDepends;", "", "toDecl", "Lcom/feysh/corax/config/api/XDecl;", "target", "dependsOn", "", "dep", "", "deps", "corax-config-api"})
public interface IAnalysisDepends {
    @NotNull
    public XDecl toDecl(@NotNull Object var1);

    public void dependsOn(@NotNull XDecl var1, @NotNull XDecl var2);

    public void dependsOn(@NotNull Collection<? extends XDecl> var1, @NotNull Collection<? extends XDecl> var2);
}

