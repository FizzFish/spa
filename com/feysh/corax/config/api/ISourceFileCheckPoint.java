/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.IndexedValue
 *  kotlin.coroutines.Continuation
 *  kotlin.io.path.PathsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.ICheckPoint;
import com.feysh.corax.config.api.IRelativePath;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.io.path.PathsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0014\u001a\u00020\u0015H\u00a6@\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u00a6@\u00a2\u0006\u0002\u0010\u0016J\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001a0\u0019H\u00a6@\u00a2\u0006\u0002\u0010\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u0011X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2={"Lcom/feysh/corax/config/api/ISourceFileCheckPoint;", "Lcom/feysh/corax/config/api/ICheckPoint;", "path", "Ljava/nio/file/Path;", "getPath", "()Ljava/nio/file/Path;", "uri", "Ljava/net/URI;", "getUri", "()Ljava/net/URI;", "filename", "", "getFilename", "()Ljava/lang/String;", "archiveFile", "getArchiveFile", "relativePath", "Lcom/feysh/corax/config/api/IRelativePath;", "getRelativePath", "()Lcom/feysh/corax/config/api/IRelativePath;", "readAllBytes", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "text", "lines", "", "Lkotlin/collections/IndexedValue;", "corax-config-api"})
public interface ISourceFileCheckPoint
extends ICheckPoint {
    @NotNull
    public Path getPath();

    @NotNull
    public URI getUri();

    @NotNull
    public String getFilename();

    @Nullable
    public Path getArchiveFile();

    @NotNull
    public IRelativePath getRelativePath();

    @Nullable
    public Object readAllBytes(@NotNull Continuation<? super byte[]> var1) throws IOException;

    @Nullable
    public Object text(@NotNull Continuation<? super String> var1);

    @Nullable
    public Object lines(@NotNull Continuation<? super List<IndexedValue<String>>> var1);

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @NotNull
        public static String getFilename(@NotNull ISourceFileCheckPoint $this) {
            return PathsKt.getName((Path)$this.getPath());
        }
    }
}

