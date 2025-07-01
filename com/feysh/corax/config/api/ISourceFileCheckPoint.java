package com.feysh.corax.config.api;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ISourceFileCheckPoint extends ICheckPoint {
    @NotNull
    Path getPath();

    @NotNull
    URI getUri();

    default @NotNull String getFilename() {
        return getPath().getFileName().toString();
    }

    @Nullable
    Path getArchiveFile();

    @NotNull
    IRelativePath getRelativePath();

    @Nullable
    Object readAllBytes(@NotNull Continuation<? super byte[]> continuation) throws IOException;

    @Nullable
    Object text(@NotNull Continuation<? super String> continuation);

    @Nullable
    Object lines(@NotNull Continuation<? super List<IndexedValue<String>>> continuation);
}