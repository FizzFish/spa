package cn.sast.framework.report;

import cn.sast.api.report.IBugResInfo;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NullWrapperFileGenerator implements IWrapperFileGenerator {
    @NotNull
    public static final NullWrapperFileGenerator INSTANCE = new NullWrapperFileGenerator();

    private NullWrapperFileGenerator() {
    }

    @Override
    @NotNull
    public String getName() {
        return "null";
    }

    @Override
    @Nullable
    public IResFile makeWrapperFile(@NotNull IResDirectory fileWrapperOutPutDir, @NotNull IBugResInfo resInfo) {
        return null;
    }

    @Override
    @NotNull
    public String getInternalFileName(@NotNull IBugResInfo resInfo) {
        return "";
    }
}