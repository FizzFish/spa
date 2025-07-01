package cn.sast.common;

import com.google.common.io.MoreFiles;
import com.google.common.io.RecursiveDeleteOption;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.io.FilenameUtils;
import org.jetbrains.annotations.NotNull;

public final class PathExtensionsKt {
    private PathExtensionsKt() {}

    @NotNull
    public static Path resolveDir(@NotNull Path baseDir, @NotNull String dir) {
        if (baseDir == null) throw new NullPointerException("baseDir is null");
        if (dir == null) throw new NullPointerException("dir is null");
        
        if (!isDirectory(baseDir)) {
            throw new IllegalStateException("Failed check: baseDir.isDirectory, where baseDir is: " + baseDir);
        }
        if (dir.isEmpty()) {
            throw new IllegalStateException("Failed check: dir.length > 0, where dir is: '" + dir + "'");
        }
        
        Path resolvedDir = baseDir.resolve(dir);
        if (!isDirectory(resolvedDir)) {
            throw new IllegalStateException("Failed check: resolvedDir.isDirectory, where resolvedDir is: " + resolvedDir);
        }
        return resolvedDir;
    }

    public static boolean isRegularFile(@NotNull Path path) {
        if (path == null) throw new NullPointerException("path is null");
        return Files.isRegularFile(path);
    }

    public static boolean isDirectory(@NotNull Path path) {
        if (path == null) throw new NullPointerException("path is null");
        return Files.isDirectory(path);
    }

    @NotNull
    public static List<Path> getFiles(@NotNull Path directory) {
        if (directory == null) throw new NullPointerException("directory is null");
        if (!isDirectory(directory)) {
            throw new IllegalStateException("Check failed.");
        }
        return Files.list(directory)
            .filter(Files::isRegularFile)
            .collect(Collectors.toList());
    }

    public static void replaceText(@NotNull Path file, @NotNull String sourceText, @NotNull String replacementText) throws IOException {
        if (file == null) throw new NullPointerException("file is null");
        if (sourceText == null) throw new NullPointerException("sourceText is null");
        if (replacementText == null) throw new NullPointerException("replacementText is null");
        
        String content = getText(file).replace(sourceText, replacementText);
        Files.writeString(file, content);
    }

    @NotNull
    public static String getText(@NotNull Path file) throws IOException {
        if (file == null) throw new NullPointerException("file is null");
        if (!isRegularFile(file)) {
            throw new IllegalStateException("Check failed.");
        }
        return String.join(System.lineSeparator(), Files.readAllLines(file));
    }

    @NotNull
    public static String getExtension(@NotNull Path path) {
        if (path == null) throw new NullPointerException("path is null");
        return FilenameUtils.getExtension(path.getFileName().toString());
    }

    public static void deleteDirectoryRecursively(@NotNull Path directory) throws IOException {
        if (directory == null) throw new NullPointerException("directory is null");
        if (!Files.exists(directory)) return;
        MoreFiles.deleteRecursively(directory, RecursiveDeleteOption.ALLOW_INSECURE);
    }

    public static void deleteDirectoryContents(@NotNull Path directory) throws IOException {
        if (directory == null) throw new NullPointerException("directory is null");
        if (!Files.exists(directory)) return;
        MoreFiles.deleteDirectoryContents(directory, RecursiveDeleteOption.ALLOW_INSECURE);
    }
}