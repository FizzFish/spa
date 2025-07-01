package cn.sast.framework.report;

import cn.sast.common.IResDirectory;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.IReportConsumer;
import cn.sast.framework.result.OutputType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ReportConsumer implements IReportConsumer {
    @NotNull
    private final OutputType type;
    @NotNull
    private final IResDirectory outputDir;

    public ReportConsumer(@NotNull OutputType type, @NotNull IResDirectory outputDir) {
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        if (outputDir == null) {
            throw new IllegalArgumentException("outputDir cannot be null");
        }
        this.type = type;
        this.outputDir = outputDir;
        this.outputDir.mkdirs();
    }

    @NotNull
    @Override
    public OutputType getType() {
        return type;
    }

    @NotNull
    public final IResDirectory getOutputDir() {
        return outputDir;
    }

    @NotNull
    public abstract MetaData getMetadata();

    @Nullable
    @Override
    public Object init(@NotNull Continuation<? super Unit> completion) {
        outputDir.deleteDirectoryContents();
        outputDir.mkdirs();
        return Unit.INSTANCE;
    }

    @Nullable
    @Override
    public Object run(@NotNull IProjectFileLocator locator, @NotNull Continuation<? super Unit> completion) {
        // Default implementation from interface
        return null;
    }

    public static abstract class MetaData {
        // Metadata class implementation if needed
    }
}