package cn.sast.common;

import java.nio.file.Path;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class WalkFileTreeResult {
    @NotNull
    private final Path root;
    @NotNull
    private final List<Path> files;
    @NotNull
    private final List<Path> dirs;

    public WalkFileTreeResult(@NotNull Path root, @NotNull List<? extends Path> files, @NotNull List<? extends Path> dirs) {
        if (root == null) throw new NullPointerException("root");
        if (files == null) throw new NullPointerException("files");
        if (dirs == null) throw new NullPointerException("dirs");
        this.root = root;
        this.files = files;
        this.dirs = dirs;
    }

    @NotNull
    public Path getRoot() {
        return root;
    }

    @NotNull
    public List<Path> getFiles() {
        return files;
    }

    @NotNull
    public List<Path> getDirs() {
        return dirs;
    }
}