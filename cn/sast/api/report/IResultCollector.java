package cn.sast.api.report;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IResultCollector {
    @Nullable
    Object flush(@NotNull Continuation<?> continuation);
}