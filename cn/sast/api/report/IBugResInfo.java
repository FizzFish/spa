package cn.sast.api.report;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class IBugResInfo implements Comparable<IBugResInfo>, IReportHashAble {
    protected IBugResInfo() {
    }

    @Nullable
    public abstract String getReportFileName();

    @NotNull
    public abstract String getPath();
}