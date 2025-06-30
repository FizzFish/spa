/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootField
 *  soot.Type
 *  soot.util.Chain
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IFieldMatch;
import com.feysh.corax.config.api.utils.UtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.Type;
import soot.util.Chain;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\b\u0010\fB\u0015\b\u0016\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\r\u00a2\u0006\u0004\b\b\u0010\u000eJ\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0006\u0010\u0013\u00a8\u0006\u001c"}, d2={"Lcom/feysh/corax/config/api/baseimpl/SootFieldSignatureMatch;", "Lcom/feysh/corax/config/api/IFieldMatch;", "declaringClassType", "", "fieldName", "fieldType", "isStatic", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "sf", "Lsoot/SootField;", "(Lsoot/SootField;)V", "Lkotlin/reflect/KProperty;", "(Lkotlin/reflect/KProperty;)V", "getDeclaringClassType", "()Ljava/lang/String;", "getFieldName", "getFieldType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "matched", "", "scene", "Lsoot/Scene;", "match", "field", "toString", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nMatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Matchers.kt\ncom/feysh/corax/config/api/baseimpl/SootFieldSignatureMatch\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,243:1\n1454#2,2:244\n774#2:246\n865#2,2:247\n1456#2,3:249\n*S KotlinDebug\n*F\n+ 1 Matchers.kt\ncom/feysh/corax/config/api/baseimpl/SootFieldSignatureMatch\n*L\n46#1:244,2\n47#1:246\n47#1:247,2\n46#1:249,3\n*E\n"})
public final class SootFieldSignatureMatch
implements IFieldMatch {
    @NotNull
    private final String declaringClassType;
    @NotNull
    private final String fieldName;
    @Nullable
    private final String fieldType;
    @Nullable
    private final Boolean isStatic;

    public SootFieldSignatureMatch(@NotNull String declaringClassType, @NotNull String fieldName, @Nullable String fieldType, @Nullable Boolean isStatic) {
        Intrinsics.checkNotNullParameter((Object)declaringClassType, (String)"declaringClassType");
        Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
        this.declaringClassType = declaringClassType;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.isStatic = isStatic;
    }

    @Override
    @NotNull
    public String getDeclaringClassType() {
        return this.declaringClassType;
    }

    @Override
    @NotNull
    public String getFieldName() {
        return this.fieldName;
    }

    @Override
    @Nullable
    public String getFieldType() {
        return this.fieldType;
    }

    @Override
    @Nullable
    public Boolean isStatic() {
        return this.isStatic;
    }

    public SootFieldSignatureMatch(@NotNull SootField sf) {
        Intrinsics.checkNotNullParameter((Object)sf, (String)"sf");
        String string = sf.getDeclaringClass().getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        String string2 = sf.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getName(...)");
        Type type = sf.getType();
        Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
        String string3 = UtilsKt.getTypename(type);
        if (string3 == null) {
            string3 = "unknown";
        }
        this(string, string2, string3, sf.isStatic());
    }

    public SootFieldSignatureMatch(@NotNull KProperty<?> sf) {
        Intrinsics.checkNotNullParameter(sf, (String)"sf");
        String string = UtilsKt.getDeclaringClass((KCallable)sf).getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        this(string, sf.getName(), UtilsKt.getSootTypeName(sf), null);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<SootField> matched(@NotNull Scene scene) {
        void destination$iv;
        void $this$flatMapTo$iv;
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        Object $this$matched_u24lambda_u240 = this;
        boolean bl = false;
        SootClass sootClass = scene.getSootClassUnsafe(((SootFieldSignatureMatch)$this$matched_u24lambda_u240).getDeclaringClassType(), false);
        if (sootClass == null) {
            return CollectionsKt.emptyList();
        }
        SootClass cl = sootClass;
        List classes = CollectionsKt.listOf((Object)cl);
        Iterable iterable = classes;
        $this$matched_u24lambda_u240 = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv : $this$flatMapTo$iv) {
            void $this$filterTo$iv$iv;
            SootClass sc = (SootClass)element$iv;
            boolean bl2 = false;
            Chain chain = sc.getFields();
            Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getFields(...)");
            Iterable $this$filter$iv = (Iterable)chain;
            boolean $i$f$filter = false;
            Iterable iterable2 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                SootField sm = (SootField)element$iv$iv;
                boolean bl3 = false;
                Intrinsics.checkNotNull((Object)sm);
                if (!this.match(sm)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Iterable list$iv = (List)destination$iv$iv;
            CollectionsKt.addAll((Collection)destination$iv, (Iterable)list$iv);
        }
        return (List)destination$iv;
    }

    private final boolean match(SootField field) {
        if (!Intrinsics.areEqual((Object)this.getFieldName(), (Object)field.getName())) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.getDeclaringClassType(), (Object)field.getDeclaringClass().getName())) {
            return false;
        }
        if (this.isStatic() != null && !Intrinsics.areEqual((Object)this.isStatic(), (Object)field.isStatic())) {
            return false;
        }
        if (this.getFieldType() != null) {
            String string = this.getFieldType();
            Type type = field.getType();
            Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
            if (!Intrinsics.areEqual((Object)string, (Object)UtilsKt.getTypename(type))) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public String toString() {
        return "<" + this.getDeclaringClassType() + ": " + this.getFieldType() + " " + this.getFieldName() + ">";
    }
}

