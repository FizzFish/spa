package com.feysh.corax.config.api.baseimpl;

import org.jetbrains.annotations.NotNull;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;

public final class QualifiedRefTypeKt {
    @NotNull
    public static Map.Entry<String, String> splitPackage(@NotNull String qualifiedName) {
        if (qualifiedName == null) {
            throw new NullPointerException("qualifiedName cannot be null");
        }

        int lastDotIndex = qualifiedName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return new SimpleEntry<>("", qualifiedName);
        }

        String packageName = qualifiedName.substring(0, lastDotIndex);
        String className = qualifiedName.substring(lastDotIndex + 1);
        return new SimpleEntry<>(packageName, className);
    }
}