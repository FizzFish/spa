/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.tagkit.AnnotationTag
 *  soot.tagkit.Tag
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IClassDecl;
import com.feysh.corax.config.api.ISootFieldDecl;
import com.feysh.corax.config.api.ISootMethodDecl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootMethod;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J1\u0010\u0015\u001a\u00020\u00162'\u0010\u0017\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00160\u0018H&J\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u0019\"\u0004\b\u0000\u0010\u001f2\u0006\u0010\u001d\u001a\u00020\u0013H&J7\u0010 \u001a\u00020\u00162-\u0010\u0017\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0!\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00160\u0018H&J\u001c\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$0\u0018H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e\u00a8\u0006&"}, d2={"Lcom/feysh/corax/config/api/ISootClassDecl;", "Lcom/feysh/corax/config/api/IClassDecl;", "sootClass", "Lsoot/SootClass;", "getSootClass", "()Lsoot/SootClass;", "clazzName", "", "getClazzName", "()Ljava/lang/String;", "classTags", "", "Lsoot/tagkit/Tag;", "getClassTags", "()Ljava/util/List;", "classAnnotationTags", "Lsoot/tagkit/AnnotationTag;", "getClassAnnotationTags", "declaringSootMethods", "Lsoot/SootMethod;", "getDeclaringSootMethods", "eachDeclaringMethod", "", "block", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/ISootMethodDecl;", "", "Lkotlin/ParameterName;", "name", "method", "sootDeclaringMethod", "R", "eachDeclaringField", "Lcom/feysh/corax/config/api/ISootFieldDecl;", "field", "anySuperClass", "", "predicate", "corax-config-api"})
public interface ISootClassDecl
extends IClassDecl {
    @NotNull
    public SootClass getSootClass();

    @NotNull
    public String getClazzName();

    @NotNull
    public List<Tag> getClassTags();

    @NotNull
    public List<AnnotationTag> getClassAnnotationTags();

    @NotNull
    public List<SootMethod> getDeclaringSootMethods();

    public void eachDeclaringMethod(@NotNull Function1<? super ISootMethodDecl<Object>, Unit> var1);

    @NotNull
    public <R> ISootMethodDecl<R> sootDeclaringMethod(@NotNull SootMethod var1);

    public void eachDeclaringField(@NotNull Function1<? super ISootFieldDecl<Object, Object>, Unit> var1);

    public boolean anySuperClass(@NotNull Function1<? super SootClass, Boolean> var1);

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    @SourceDebugExtension(value={"SMAP\nAIAnalysisApi.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIAnalysisApi.kt\ncom/feysh/corax/config/api/ISootClassDecl$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,839:1\n808#2,11:840\n*S KotlinDebug\n*F\n+ 1 AIAnalysisApi.kt\ncom/feysh/corax/config/api/ISootClassDecl$DefaultImpls\n*L\n492#1:840,11\n*E\n"})
    public static final class DefaultImpls {
        @NotNull
        public static String getClazzName(@NotNull ISootClassDecl $this) {
            String string = $this.getSootClass().getName();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
            return string;
        }

        @NotNull
        public static List<Tag> getClassTags(@NotNull ISootClassDecl $this) {
            List list = $this.getSootClass().getTags();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getTags(...)");
            return list;
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public static List<AnnotationTag> getClassAnnotationTags(@NotNull ISootClassDecl $this) {
            void $this$filterIsInstanceTo$iv$iv;
            Iterable $this$filterIsInstance$iv = $this.getClassTags();
            boolean $i$f$filterIsInstance = false;
            Iterable iterable = $this$filterIsInstance$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterIsInstanceTo = false;
            for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
                if (!(element$iv$iv instanceof AnnotationTag)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            return (List)destination$iv$iv;
        }

        @NotNull
        public static List<SootMethod> getDeclaringSootMethods(@NotNull ISootClassDecl $this) {
            List list = $this.getSootClass().getMethods();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getMethods(...)");
            return list;
        }
    }
}

