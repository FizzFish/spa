package cn.sast.framework.report.coverage;

import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.common.IResFile;
import cn.sast.common.ResourceKt;
import cn.sast.framework.report.AbstractFileIndexer;
import cn.sast.framework.report.IProjectFileLocator;
import org.apache.commons.io.FilenameUtils;
import org.jacoco.report.InputStreamSourceFileLocator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootClass;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Arrays;

public final class JacocoSourceLocator extends InputStreamSourceFileLocator {
    private final IProjectFileLocator sourceLocator;

    public JacocoSourceLocator(@NotNull IProjectFileLocator sourceLocator, @NotNull String encoding, int tabWidth) {
        super(encoding, tabWidth);
        this.sourceLocator = sourceLocator;
    }

    public JacocoSourceLocator(IProjectFileLocator sourceLocator) {
        this(sourceLocator, "utf-8", 4);
    }

    @Nullable
    protected InputStream getSourceStream(@NotNull String path) {
        char[] separators = new char[]{'/', '\\'};
        IResFile resFile = sourceLocator.findFromFileIndexMap(
            Arrays.asList(path.split(new String(separators))), 
            AbstractFileIndexer.getDefaultClassCompareMode()
        ).stream().findFirst().orElse(null);

        if (resFile != null) {
            return Files.newInputStream(resFile.getPath());
        }

        String ext = FilenameUtils.getExtension(path);
        if (ResourceKt.getJavaExtensions().contains(ext)) {
            String mayClassName = path.replace("/", ".")
                                    .replace("\\", ".")
                                    .replace("." + ext, "");
            
            SootClass sc = Scene.v().getSootClassUnsafe(mayClassName, false);
            if (sc != null) {
                IResFile src = sourceLocator.get(ClassResInfo.of(sc));
                if (src != null) {
                    return Files.newInputStream(src.getPath());
                }
            }
        }
        return null;
    }
}
