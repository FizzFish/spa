/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.tagkit.VisibilityAnnotationTag
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IClassMemberCheckPoint;
import com.feysh.corax.config.api.IUnitCheckPoint;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.tagkit.VisibilityAnnotationTag;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J!\u0010\n\u001a\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\u0002\b\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2={"Lcom/feysh/corax/config/api/IMethodCheckPoint;", "Lcom/feysh/corax/config/api/IClassMemberCheckPoint;", "sootMethod", "Lsoot/SootMethod;", "getSootMethod", "()Lsoot/SootMethod;", "visibilityAnnotationTag", "Lsoot/tagkit/VisibilityAnnotationTag;", "getVisibilityAnnotationTag", "()Lsoot/tagkit/VisibilityAnnotationTag;", "eachUnit", "", "block", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/IUnitCheckPoint;", "Lkotlin/ExtensionFunctionType;", "corax-config-api"})
public interface IMethodCheckPoint
extends IClassMemberCheckPoint {
    @NotNull
    public SootMethod getSootMethod();

    @Nullable
    public VisibilityAnnotationTag getVisibilityAnnotationTag();

    public void eachUnit(@NotNull Function1<? super IUnitCheckPoint, Unit> var1);
}

