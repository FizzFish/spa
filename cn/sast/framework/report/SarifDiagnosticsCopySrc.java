package cn.sast.framework.report;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.ReportConsumer;
import cn.sast.framework.report.SarifDiagnostics;
import cn.sast.framework.report.sarif.Description;
import cn.sast.framework.report.sarif.UriBase;
import cn.sast.framework.result.OutputType;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;

import java.io.Closeable;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class SarifDiagnosticsCopySrc extends SarifDiagnostics implements Closeable {
    public static final Companion Companion = new Companion();
    private static final KLogger logger = KotlinLogging.INSTANCE.logger("SarifDiagnosticsCopySrc");

    @NotNull
    private final String sourceJarRootMapKey;
    @NotNull
    private final String sourceJarFileName;
    @NotNull
    private final IResDirectory sourceRoot;
    @NotNull
    private final Map<String, UriBase> originalUriBaseIds;
    @NotNull
    private final ConcurrentHashMap<String, IResFile> entriesMap;

    public SarifDiagnosticsCopySrc(
            @NotNull IResDirectory outputDir,
            @NotNull String sourceJarRootMapKey,
            @NotNull String sourceJarRootMapValue,
            @NotNull String sourceJarFileName,
            @NotNull OutputType type
    ) {
        super(outputDir, type);
        this.sourceJarRootMapKey = sourceJarRootMapKey;
        this.sourceJarFileName = sourceJarFileName;
        this.sourceRoot = outputDir.resolve(this.sourceJarFileName).toDirectory();
        this.originalUriBaseIds = Map.of(
                this.sourceJarRootMapKey,
                new UriBase(
                        sourceJarRootMapValue,
                        new Description("The path " + sourceJarRootMapValue + " should be replaced with path where be mapped to the virtual path " + this.sourceRoot.getPath().toUri())
                )
        );
        this.entriesMap = new ConcurrentHashMap<>();
    }

    @NotNull
    public Map<String, UriBase> getOriginalUriBaseIds() {
        return originalUriBaseIds;
    }

    @NotNull
    public ConcurrentHashMap<String, IResFile> getEntriesMap() {
        return entriesMap;
    }

    @Override
    @NotNull
    public SarifDiagnostics.SarifDiagnosticsImpl getSarifDiagnosticsImpl(
            @NotNull ReportConsumer.MetaData metadata,
            @NotNull IProjectFileLocator locator
    ) {
        return new SarifDiagnosticsPackImpl(this, metadata, locator);
    }

    @Override
    public void close() {
        logger.info(() -> getType() + ": copying ...");
        LocalDateTime startTime = LocalDateTime.now();
        int errorCnt = 0;

        try {
            for (Map.Entry<String, IResFile> entry : entriesMap.entrySet()) {
                String relativePath = entry.getKey();
                IResFile file = entry.getValue();
                Path target = sourceRoot.resolve(relativePath).getPath();

                try {
                    Path parent = target.getParent();
                    if (parent == null) {
                        throw new IllegalStateException("output not allow here: " + target);
                    }
                    if (!Files.exists(parent, LinkOption.NOFOLLOW_LINKS)) {
                        Files.createDirectories(parent);
                    }
                    Files.copy(file.getPath(), target);
                } catch (Exception e) {
                    errorCnt++;
                    if (errorCnt < 5) {
                        logger.warn("An error occurred", e);
                    }
                }
            }
            logger.info(() -> getType() + ": copying completed in " + java.time.Duration.between(startTime, LocalDateTime.now()));
        } catch (Throwable t) {
            logger.error(() -> getType() + ": copying failed after " + java.time.Duration.between(startTime, LocalDateTime.now()), t);
            throw t;
        }

        if (errorCnt > 0) {
            logger.warn(() -> getType() + ": A total of " + errorCnt + " errors were generated");
        }
    }

    public static final class Companion {
        private Companion() {}
    }

    private static final class SarifDiagnosticsPackImpl extends SarifDiagnostics.SarifDiagnosticsImpl {
        public SarifDiagnosticsPackImpl(
                SarifDiagnosticsCopySrc diagnostics,
                ReportConsumer.MetaData metadata,
                IProjectFileLocator locator
        ) {
            super(diagnostics, metadata, locator);
        }
    }
}
