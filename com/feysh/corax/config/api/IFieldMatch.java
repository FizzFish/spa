/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Scene
 *  soot.SootField
 */
package com.feysh.corax.config.api;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootField;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0012"}, d2={"Lcom/feysh/corax/config/api/IFieldMatch;", "", "declaringClassType", "", "getDeclaringClassType", "()Ljava/lang/String;", "fieldName", "getFieldName", "fieldType", "getFieldType", "isStatic", "", "()Ljava/lang/Boolean;", "matched", "", "Lsoot/SootField;", "scene", "Lsoot/Scene;", "corax-config-api"})
public interface IFieldMatch {
    @NotNull
    public String getDeclaringClassType();

    @NotNull
    public String getFieldName();

    @Nullable
    public String getFieldType();

    @Nullable
    public Boolean isStatic();

    @NotNull
    public List<SootField> matched(@NotNull Scene var1);
}

