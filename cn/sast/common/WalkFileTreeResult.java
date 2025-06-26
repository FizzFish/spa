/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.WalkFileTreeResult
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.common;

import java.nio.file.Path;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u000e"}, d2={"Lcn/sast/common/WalkFileTreeResult;", "", "root", "Ljava/nio/file/Path;", "files", "", "dirs", "<init>", "(Ljava/nio/file/Path;Ljava/util/List;Ljava/util/List;)V", "getRoot", "()Ljava/nio/file/Path;", "getFiles", "()Ljava/util/List;", "getDirs", "corax-api"})
public final class WalkFileTreeResult {
    @NotNull
    private final Path root;
    @NotNull
    private final List<Path> files;
    @NotNull
    private final List<Path> dirs;

    public WalkFileTreeResult(@NotNull Path root, @NotNull List<? extends Path> files2, @NotNull List<? extends Path> dirs) {
        Intrinsics.checkNotNullParameter((Object)root, (String)"root");
        Intrinsics.checkNotNullParameter(files2, (String)"files");
        Intrinsics.checkNotNullParameter(dirs, (String)"dirs");
        this.root = root;
        this.files = files2;
        this.dirs = dirs;
    }

    @NotNull
    public final Path getRoot() {
        return this.root;
    }

    @NotNull
    public final List<Path> getFiles() {
        return this.files;
    }

    @NotNull
    public final List<Path> getDirs() {
        return this.dirs;
    }
}

