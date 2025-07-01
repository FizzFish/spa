package cn.sast.common;

import java.nio.file.Path;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class FileSystemsOperations {
    private FileSystemsOperations() {}

    private static Path copyPath(Path it, Path src, Path dest) {
        return copyPathImpl(it, src, dest);
    }

    private static Path mapToDestination(Path path, Path srcDir, Path destDir) {
        return mapToDestinationImpl(path, srcDir, destDir);
    }

    public static void copyDirRecursivelyToDirInDifferentFileSystem(@NotNull Path dir, @NotNull Path dest) {
        copyDirRecursivelyToDirInDifferentFileSystemImpl(dir, dest);
    }

    public static void copyDirContentsRecursivelyToDirInDifferentFileSystem(@NotNull Path dir, @NotNull Path dest) {
        copyDirContentsRecursivelyToDirInDifferentFileSystemImpl(dir, dest);
    }

    public static void copyFilesToDirInDifferentFileSystem(@NotNull List<? extends Path> files, @NotNull Path dest) {
        copyFilesToDirInDifferentFileSystemImpl(files, dest);
    }

    public static void copyDirContentsRecursivelyToDirInSameFileSystem(@NotNull Path dir, @NotNull Path dest) {
        copyDirContentsRecursivelyToDirInSameFileSystemImpl(dir, dest);
    }

    // Implementation methods - would be defined elsewhere
    private static native Path copyPathImpl(Path it, Path src, Path dest);
    private static native Path mapToDestinationImpl(Path path, Path srcDir, Path destDir);
    private static native void copyDirRecursivelyToDirInDifferentFileSystemImpl(Path dir, Path dest);
    private static native void copyDirContentsRecursivelyToDirInDifferentFileSystemImpl(Path dir, Path dest);
    private static native void copyFilesToDirInDifferentFileSystemImpl(List<? extends Path> files, Path dest);
    private static native void copyDirContentsRecursivelyToDirInSameFileSystemImpl(Path dir, Path dest);
}