package cn.sast.framework.report;

import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.result.OutputType;
import java.io.Closeable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IReportConsumer extends Closeable {
    @NotNull
    OutputType getType();

    @Nullable
    Object init(@NotNull Continuation<? super Void> continuation);

    @Nullable
    Object run(@NotNull IProjectFileLocator locator, @NotNull Continuation<? super Void> continuation);
}