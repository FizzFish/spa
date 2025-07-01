package com.feysh.corax.config.api;

import soot.SootClass;
import soot.SootMethod;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface ISootClassDecl extends IClassDecl {
    @NotNull
    SootClass getSootClass();

    default @NotNull String getClazzName() {
        return getSootClass().getName();
    }

    default @NotNull List<Tag> getClassTags() {
        return getSootClass().getTags();
    }

    default @NotNull List<AnnotationTag> getClassAnnotationTags() {
        List<AnnotationTag> result = new ArrayList<>();
        for (Tag tag : getClassTags()) {
            if (tag instanceof AnnotationTag) {
                result.add((AnnotationTag) tag);
            }
        }
        return result;
    }

    default @NotNull List<SootMethod> getDeclaringSootMethods() {
        return getSootClass().getMethods();
    }

    void eachDeclaringMethod(@NotNull Function<ISootMethodDecl<?>, Void> block);

    @NotNull
    <R> ISootMethodDecl<R> sootDeclaringMethod(@NotNull SootMethod method);

    void eachDeclaringField(@NotNull Function<ISootFieldDecl<?, ?>, Void> block);

    boolean anySuperClass(@NotNull Predicate<SootClass> predicate);
}