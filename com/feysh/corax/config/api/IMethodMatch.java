/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Scene
 *  soot.SootMethod
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00060\u000bj\u0002`\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2={"Lcom/feysh/corax/config/api/IMethodMatch;", "", "actualType", "Lcom/feysh/corax/config/api/utils/KFunctionType;", "getActualType", "()Lcom/feysh/corax/config/api/utils/KFunctionType;", "argumentCnt", "", "getArgumentCnt", "()Ljava/lang/Integer;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getException", "()Ljava/lang/Exception;", "matched", "", "Lsoot/SootMethod;", "scene", "Lsoot/Scene;", "corax-config-api"})
public interface IMethodMatch {
    @Nullable
    public KFunctionType getActualType();

    @Nullable
    public Integer getArgumentCnt();

    @NotNull
    public Exception getException();

    @NotNull
    public List<SootMethod> matched(@NotNull Scene var1);
}

