package cn.sast.framework.report;

import cn.sast.api.report.IBugResInfo;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IWrapperFileGenerator {
    @NotNull
    String getName();

    @Nullable
    IResFile makeWrapperFile(@NotNull IResDirectory fileWrapperOutPutDir, @NotNull IBugResInfo resInfo);

    @NotNull
    default String getInternalFileName(@NotNull IBugResInfo resInfo) {
        return "";
    }
}