package com.feysh.corax.config.api.utils;

import java.util.List;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.jetbrains.annotations.NotNull;
import soot.FastHierarchy;
import soot.Hierarchy;
import soot.RefLikeType;
import soot.SootClass;

public final class HierarchyExtKt {
    public static List<SootClass> getSubclassesOrImplementersOf(@NotNull Hierarchy hierarchy, @NotNull SootClass sootClass) {
        if (hierarchy == null) {
            throw new NullPointerException("<this> is null");
        }
        if (sootClass == null) {
            throw new NullPointerException("sootClass is null");
        }
        return sootClass.isInterface() 
            ? hierarchy.getImplementersOf(sootClass) 
            : hierarchy.getSubclassesOf(sootClass);
    }

    @Deprecated(forRemoval = false, since = "Scene.v().activeHierarchy().getSubclassesOf()")
    public static @NotNull Stream<SootClass> getAllSubclasses(@NotNull FastHierarchy hierarchy, @NotNull SootClass sootClass) {
        if (hierarchy == null) {
            throw new NullPointerException("<this> is null");
        }
        if (sootClass == null) {
            throw new NullPointerException("sootClass is null");
        }
        if (!(sootClass.getType() instanceof RefLikeType)) {
            return Stream.empty();
        }
        
        return Stream.concat(
            hierarchy.getSubclassesOf(sootClass).stream(),
            hierarchy.getSubclassesOf(sootClass).stream()
                .flatMap(subClass -> getAllSubclasses(hierarchy, subClass))
        );
    }
}
