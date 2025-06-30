/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootField
 *  soot.tagkit.AnnotationTag
 *  soot.tagkit.Tag
 *  soot.tagkit.VisibilityAnnotationTag
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IFieldDecl;
import com.feysh.corax.config.api.ISootClassDecl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2={"Lcom/feysh/corax/config/api/ISootFieldDecl;", "This", "T", "Lcom/feysh/corax/config/api/IFieldDecl;", "clazz", "Lcom/feysh/corax/config/api/ISootClassDecl;", "getClazz", "()Lcom/feysh/corax/config/api/ISootClassDecl;", "sootField", "Lsoot/SootField;", "getSootField", "()Lsoot/SootField;", "visibilityAnnotationTag", "Lsoot/tagkit/VisibilityAnnotationTag;", "getVisibilityAnnotationTag", "()Lsoot/tagkit/VisibilityAnnotationTag;", "tags", "", "Lsoot/tagkit/Tag;", "getTags", "()Ljava/util/List;", "annotations", "Lsoot/tagkit/AnnotationTag;", "getAnnotations", "()Lsoot/tagkit/AnnotationTag;", "corax-config-api"})
public interface ISootFieldDecl<This, T>
extends IFieldDecl<This, T> {
    @NotNull
    public ISootClassDecl getClazz();

    @NotNull
    public SootField getSootField();

    @Nullable
    public VisibilityAnnotationTag getVisibilityAnnotationTag();

    @NotNull
    public List<Tag> getTags();

    @Nullable
    public AnnotationTag getAnnotations();

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Nullable
        public static <This, T> VisibilityAnnotationTag getVisibilityAnnotationTag(@NotNull ISootFieldDecl<This, T> $this) {
            return (VisibilityAnnotationTag)$this.getSootField().getTag("VisibilityAnnotationTag");
        }

        @NotNull
        public static <This, T> List<Tag> getTags(@NotNull ISootFieldDecl<This, T> $this) {
            List list = $this.getSootField().getTags();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getTags(...)");
            return list;
        }

        @Nullable
        public static <This, T> AnnotationTag getAnnotations(@NotNull ISootFieldDecl<This, T> $this) {
            return (AnnotationTag)$this.getSootField().getTag("AnnotationTag");
        }
    }
}

