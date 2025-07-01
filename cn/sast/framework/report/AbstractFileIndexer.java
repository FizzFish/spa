package cn.sast.framework.report;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractFileIndexer<PathType> {
    private boolean errorMsgShow;
    private static CompareMode defaultClassCompareMode = CompareMode.Class;

    public abstract @NotNull List<String> getNames(PathType path, @NotNull CompareMode mode);

    public abstract @NotNull Collection<PathType> getPathsByName(@NotNull String name);

    private boolean hasDot(List<String> pathParts) {
        if (pathParts.size() <= 1) {
            return false;
        }

        int lastIndex = pathParts.size() - 1;
        for (int i = 0; i < pathParts.size(); i++) {
            String part = pathParts.get(i);
            if (i != lastIndex && part.contains(".")) {
                return true;
            }
        }
        return false;
    }

    private List<String> normalizePathParts(List<String> pathParts, CompareMode mode) {
        if (mode.isClass() && hasDot(pathParts)) {
            int lastIndex = pathParts.size() - 1;
            List<String> normalized = new ArrayList<>(pathParts.size() + 2);
            
            for (int i = 0; i < pathParts.size(); i++) {
                String part = pathParts.get(i);
                if (i != lastIndex && part.contains(".")) {
                    for (String splitPart : part.split("\\.")) {
                        normalized.add(splitPart);
                    }
                } else {
                    normalized.add(part);
                }
            }
            return normalized;
        }
        return pathParts;
    }

    public @NotNull Sequence<PathType> findFromFileIndexMap(@NotNull List<String> toFindNames, @NotNull CompareMode mode) {
        Objects.requireNonNull(toFindNames, "toFindNames cannot be null");
        Objects.requireNonNull(mode, "mode cannot be null");
        
        return Stream.generate(() -> {
            List<String> normalized = normalizePathParts(toFindNames, mode);
            // Implementation of actual finding logic would go here
            return null; // Placeholder
        }).iterator();
    }

    public @NotNull Sequence<PathType> findFromFileIndexMap(PathType find, @NotNull CompareMode mode) {
        Objects.requireNonNull(mode, "mode cannot be null");
        return findFromFileIndexMap(getNames(find, mode), mode);
    }

    public @NotNull List<PathType> findFiles(@NotNull Collection<String> fileNames, @NotNull CompareMode mode) {
        Objects.requireNonNull(fileNames, "fileNames cannot be null");
        Objects.requireNonNull(mode, "mode cannot be null");

        return fileNames.stream()
            .peek(s -> {
                if (s.contains("\\")) {
                    throw new IllegalArgumentException("invalid source file name: " + s);
                }
            })
            .flatMap(s -> findFromFileIndexMap(List.of(s.split("/")), mode).stream())
            .collect(Collectors.toList());
    }

    public @Nullable PathType findAnyFile(@NotNull Collection<String> fileNames, @NotNull CompareMode mode) {
        Objects.requireNonNull(fileNames, "fileNames cannot be null");
        Objects.requireNonNull(mode, "mode cannot be null");

        for (String s : fileNames) {
            if (s.contains("\\")) {
                throw new IllegalArgumentException("invalid source file name: " + s + " in " + fileNames);
            }

            PathType found = findFromFileIndexMap(List.of(s.split("/")), mode)
                .findFirst()
                .orElse(null);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    public enum CompareMode {
        Path(false),
        Class(true);

        private final boolean isClass;

        CompareMode(boolean isClass) {
            this.isClass = isClass;
        }

        public boolean isClass() {
            return isClass;
        }
    }

    public static final class Companion {
        private Companion() {}

        public CompareMode getDefaultClassCompareMode() {
            return defaultClassCompareMode;
        }

        public void setDefaultClassCompareMode(CompareMode mode) {
            defaultClassCompareMode = mode;
        }
    }
}