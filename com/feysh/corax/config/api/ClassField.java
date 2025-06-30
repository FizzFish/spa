/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007B\u0015\b\u0016\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t\u00a2\u0006\u0004\b\u0006\u0010\nJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J+\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u001a"}, d2={"Lcom/feysh/corax/config/api/ClassField;", "Lcom/feysh/corax/config/api/IClassField;", "declaringClassType", "", "fieldName", "fieldType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "field", "Lkotlin/reflect/KProperty;", "(Lkotlin/reflect/KProperty;)V", "getDeclaringClassType", "()Ljava/lang/String;", "getFieldName", "getFieldType", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "corax-config-api"})
public final class ClassField
implements IClassField {
    @Nullable
    private final String declaringClassType;
    @NotNull
    private final String fieldName;
    @Nullable
    private final String fieldType;

    public ClassField(@Nullable String declaringClassType, @NotNull String fieldName, @Nullable String fieldType) {
        Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
        this.declaringClassType = declaringClassType;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }

    @Nullable
    public final String getDeclaringClassType() {
        return this.declaringClassType;
    }

    @NotNull
    public final String getFieldName() {
        return this.fieldName;
    }

    @Nullable
    public final String getFieldType() {
        return this.fieldType;
    }

    public ClassField(@NotNull KProperty<?> field) {
        Intrinsics.checkNotNullParameter(field, (String)"field");
        this(UtilsKt.getDeclaringClassName((KCallable)field), field.getName(), UtilsKt.getSootTypeName(field));
    }

    @NotNull
    public String toString() {
        String string = this.declaringClassType;
        if (string == null) {
            string = "*";
        }
        return "<" + string + ": " + this.fieldType + " " + this.fieldName + ">";
    }

    @Nullable
    public final String component1() {
        return this.declaringClassType;
    }

    @NotNull
    public final String component2() {
        return this.fieldName;
    }

    @Nullable
    public final String component3() {
        return this.fieldType;
    }

    @NotNull
    public final ClassField copy(@Nullable String declaringClassType, @NotNull String fieldName, @Nullable String fieldType) {
        Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
        return new ClassField(declaringClassType, fieldName, fieldType);
    }

    public static /* synthetic */ ClassField copy$default(ClassField classField, String string, String string2, String string3, int n, Object object) {
        if ((n & 1) != 0) {
            string = classField.declaringClassType;
        }
        if ((n & 2) != 0) {
            string2 = classField.fieldName;
        }
        if ((n & 4) != 0) {
            string3 = classField.fieldType;
        }
        return classField.copy(string, string2, string3);
    }

    public int hashCode() {
        int result = this.declaringClassType == null ? 0 : this.declaringClassType.hashCode();
        result = result * 31 + this.fieldName.hashCode();
        result = result * 31 + (this.fieldType == null ? 0 : this.fieldType.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClassField)) {
            return false;
        }
        ClassField classField = (ClassField)other;
        if (!Intrinsics.areEqual((Object)this.declaringClassType, (Object)classField.declaringClassType)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.fieldName, (Object)classField.fieldName)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.fieldType, (Object)classField.fieldType);
    }
}

