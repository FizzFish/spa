package cn.sast.framework.report;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.JarMerger;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.ReportConsumer;
import cn.sast.framework.report.SarifDiagnostics;
import cn.sast.framework.report.sarif.Description;
import cn.sast.framework.report.sarif.UriBase;
import cn.sast.framework.result.OutputType;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class SarifDiagnosticsPack extends SarifDiagnostics implements Closeable {
    private static final Logger logger = LoggerFactory.getLogger(SarifDiagnosticsPack.class);
    private static final String DEFAULT_SOURCE_JAR_ROOT_MAP_KEY = "SRCROOT";
    private static final String DEFAULT_SOURCE_JAR_ROOT_MAP_VALUE = "%SRCROOT%";
    private static final String DEFAULT_SOURCE_JAR_FILE_NAME = "src_root";

    @NotNull
    private final String sourceJarRootMapKey;
    @NotNull
    private final String sourceJarFileName;
    private IResFile sourceJarPath;
    private JarMerger sourceJar;
    @NotNull
    private final Map<String, UriBase> originalUriBaseIds;
    @NotNull
    private final ConcurrentHashMap<String, IResFile> entriesMap;

    public SarifDiagnosticsPack(@NotNull IResDirectory outputDir, 
                               @NotNull String sourceJarRootMapKey,
                               @NotNull String sourceJarRootMapValue,
                               @NotNull String sourceJarFileName,
                               @NotNull OutputType type) {
        super(outputDir, type);
        this.sourceJarRootMapKey = sourceJarRootMapKey;
        this.sourceJarFileName = sourceJarFileName;
        this.originalUriBaseIds = Map.of(
            sourceJarRootMapKey, 
            new UriBase(sourceJarRootMapValue, 
                new Description("Should replace " + sourceJarRootMapValue + 
                    " with file:///{absolute-uncompressed-path-of-" + 
                    sourceJarFileName + ".jar}/" + sourceJarFileName + "/"))
        );
        this.entriesMap = new ConcurrentHashMap<>();
    }

    public SarifDiagnosticsPack(@NotNull IResDirectory outputDir) {
        this(outputDir, DEFAULT_SOURCE_JAR_ROOT_MAP_KEY, 
            DEFAULT_SOURCE_JAR_ROOT_MAP_VALUE, 
            DEFAULT_SOURCE_JAR_FILE_NAME, 
            OutputType.SarifPackSrc);
    }

    @Override
    public void init() throws Exception {
        super.init();
        sourceJarPath = getOutputDir().resolve(sourceJarFileName + ".jar").toFile();
        Files.deleteIfExists(sourceJarPath.getPath());
        sourceJar = new JarMerger(sourceJarPath.getPath());
    }

    @NotNull
    public Map<String, UriBase> getOriginalUriBaseIds() {
        return Collections.unmodifiableMap(originalUriBaseIds);
    }

    @NotNull
    public ConcurrentHashMap<String, IResFile> getEntriesMap() {
        return entriesMap;
    }

    @Override
    @NotNull
    public SarifDiagnostics.SarifDiagnosticsImpl getSarifDiagnosticsImpl(
            @NotNull ReportConsumer.MetaData metadata,
            @NotNull IProjectFileLocator locator) {
        return new SarifDiagnosticsPackImpl(this, metadata, locator);
    }

    @Override
    public void close() throws IOException {
        int errorCnt = 0;
        LocalDateTime startTime = LocalDateTime.now();
        logger.info("{}: Compressing ...", getType());

        try {
            for (Map.Entry<String, IResFile> entry : entriesMap.entrySet()) {
                try {
                    sourceJar.addFile(entry.getKey(), entry.getValue().getPath());
                } catch (Exception e) {
                    errorCnt++;
                    if (errorCnt < 5) {
                        logger.warn("An error occurred", e);
                    }
                }
            }
            logger.info("{}: Compression completed in {}", getType(), 
                java.time.Duration.between(startTime, LocalDateTime.now()));
        } catch (Throwable t) {
            logger.error("{}: Compression failed", getType(), t);
            throw t;
        }

        if (errorCnt > 0) {
            logger.warn("{}: A total of {} errors were generated", getType(), errorCnt);
        }

        if (sourceJar != null) {
            sourceJar.close();
        }
    }
}
