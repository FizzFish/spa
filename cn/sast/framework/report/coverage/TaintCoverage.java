package cn.sast.framework.report.coverage;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.framework.report.IProjectFileLocator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public final class TaintCoverage extends Coverage {

    private void copyResource(String name, IResFile to) throws IOException {
        OpenOption[] openOptions = new OpenOption[0];
        try (OutputStream outputStream = Files.newOutputStream(to.getPath(), Arrays.copyOf(openOptions, openOptions.length));
             InputStream inputStream = getClass().getResourceAsStream(name)) {
            if (inputStream == null) {
                throw new IOException("Resource not found: " + name);
            }
            inputStream.transferTo(outputStream);
        }
    }

    public void changeColor(@NotNull IResDirectory reportOutputRoot) {
        if (reportOutputRoot == null) {
            throw new IllegalArgumentException("reportOutputRoot cannot be null");
        }
        try {
            IResDirectory resourcesDir = reportOutputRoot.resolve("jacoco-resources");
            copyResource("/jacoco/taint-report.css", resourcesDir.resolve("report.css").toFile());
            copyResource("/jacoco/greenbar.gif", resourcesDir.resolve("redbar.gif").toFile());
            copyResource("/jacoco/redbar.gif", resourcesDir.resolve("greenbar.gif").toFile());
        } catch (IOException e) {
            throw new RuntimeException("Failed to copy color resources", e);
        }
    }

    @Override
    public void flushCoverage(@NotNull IProjectFileLocator locator, 
                            @NotNull IResDirectory outputDir, 
                            @NotNull Charset encoding) {
        if (locator == null || outputDir == null || encoding == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        super.flushCoverage(locator, outputDir, encoding);
        changeColor(outputDir);
    }
}
