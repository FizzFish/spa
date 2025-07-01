package cn.sast.framework.report;

import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.ResourceKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public final class EmptyWrapperFileGenerator implements IWrapperFileGenerator {
    @NotNull
    public static final EmptyWrapperFileGenerator INSTANCE = new EmptyWrapperFileGenerator();
    private static final Logger logger = LoggerFactory.getLogger(EmptyWrapperFileGenerator.class);

    private EmptyWrapperFileGenerator() {
    }

    @Override
    @NotNull
    public String getName() {
        return "empty";
    }

    private String makeWrapperFileContent(IBugResInfo resInfo) {
        if (resInfo instanceof ClassResInfo) {
            int maxLine = ((ClassResInfo) resInfo).getMaxLine();
            if (maxLine > 8000) {
                maxLine = 8000;
            }
            return "\n".repeat(maxLine);
        }
        return "\n";
    }

    @Override
    @Nullable
    public IResFile makeWrapperFile(@NotNull IResDirectory fileWrapperOutPutDir, @NotNull IBugResInfo resInfo) {
        if (fileWrapperOutPutDir == null) {
            throw new IllegalArgumentException("fileWrapperOutPutDir cannot be null");
        }
        if (resInfo == null) {
            throw new IllegalArgumentException("resInfo cannot be null");
        }

        String fileName = getInternalFileName(resInfo);
        IResFile missingSourceFile = fileWrapperOutPutDir.resolve(getName()).resolve(fileName).toFile();

        if (missingSourceFile.getExists()) {
            if (missingSourceFile.isFile()) {
                return missingSourceFile;
            }
            logger.error("duplicate folder exists {}", missingSourceFile);
            return null;
        }

        String content = makeWrapperFileContent(resInfo);
        try {
            IResource parent = missingSourceFile.getParent();
            if (parent != null) {
                parent.mkdirs();
            }
            ResourceKt.writeText(missingSourceFile, content);
        } catch (IOException e) {
            logger.error("Failed to create wrapper file", e);
            return null;
        }
        return missingSourceFile.toFile();
    }

    @Override
    @NotNull
    public String getInternalFileName(@NotNull IBugResInfo resInfo) {
        return IWrapperFileGenerator.super.getInternalFileName(resInfo);
    }
}
