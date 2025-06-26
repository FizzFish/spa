/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.FileSystemsOperations
 *  cn.sast.common.FileSystemsOperations$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.common;

import cn.sast.common.FileSystemsOperations;
import java.nio.file.Path;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2={"Lcn/sast/common/FileSystemsOperations;", "", "<init>", "()V", "Companion", "corax-api"})
public final class FileSystemsOperations {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    private static final Path copyPath(Path it, Path src, Path dest) {
        return Companion.access$copyPath((Companion)Companion, (Path)it, (Path)src, (Path)dest);
    }

    @JvmStatic
    private static final Path mapToDestination(Path path, Path srcDir, Path destDir) {
        return Companion.access$mapToDestination((Companion)Companion, (Path)path, (Path)srcDir, (Path)destDir);
    }

    @JvmStatic
    public static final void copyDirRecursivelyToDirInDifferentFileSystem(@NotNull Path dir, @NotNull Path dest) {
        Companion.copyDirRecursivelyToDirInDifferentFileSystem(dir, dest);
    }

    @JvmStatic
    public static final void copyDirContentsRecursivelyToDirInDifferentFileSystem(@NotNull Path dir, @NotNull Path dest) {
        Companion.copyDirContentsRecursivelyToDirInDifferentFileSystem(dir, dest);
    }

    @JvmStatic
    public static final void copyFilesToDirInDifferentFileSystem(@NotNull List<? extends Path> files2, @NotNull Path dest) {
        Companion.copyFilesToDirInDifferentFileSystem(files2, dest);
    }

    @JvmStatic
    public static final void copyDirContentsRecursivelyToDirInSameFileSystem(@NotNull Path dir, @NotNull Path dest) {
        Companion.copyDirContentsRecursivelyToDirInSameFileSystem(dir, dest);
    }
}

