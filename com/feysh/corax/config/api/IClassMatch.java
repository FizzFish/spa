/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  soot.Scene
 *  soot.SootClass
 */
package com.feysh.corax.config.api;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootClass;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lcom/feysh/corax/config/api/IClassMatch;", "", "matched", "", "Lsoot/SootClass;", "scene", "Lsoot/Scene;", "simpleName", "", "getSimpleName", "()Ljava/util/List;", "corax-config-api"})
public interface IClassMatch {
    @NotNull
    public List<SootClass> matched(@NotNull Scene var1);

    @NotNull
    public List<String> getSimpleName();
}

