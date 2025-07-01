package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IFieldDecl;
import com.feysh.corax.config.api.ISootClassDecl;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;

public interface ISootFieldDecl<This, T> extends IFieldDecl<This, T> {
    @NotNull
    ISootClassDecl getClazz();

    @NotNull
    SootField getSootField();

    @Nullable
    default VisibilityAnnotationTag getVisibilityAnnotationTag() {
        return (VisibilityAnnotationTag) getSootField().getTag("VisibilityAnnotationTag");
    }

    @NotNull
    default List<Tag> getTags() {
        return getSootField().getTags();
    }

    @Nullable
    default AnnotationTag getAnnotations() {
        return (AnnotationTag) getSootField().getTag("AnnotationTag");
    }
}