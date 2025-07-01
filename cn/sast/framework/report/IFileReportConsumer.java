package cn.sast.framework.report;

import cn.sast.api.report.Report;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.IReportConsumer;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IFileReportConsumer extends IReportConsumer {
    @Nullable
    Object flush(@NotNull List<Report> reports, @NotNull String filename, 
                 @NotNull IProjectFileLocator locator, @NotNull Continuation<? super Unit> continuation);
}