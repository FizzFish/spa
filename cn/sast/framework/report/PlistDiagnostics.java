package cn.sast.framework.report;

import cn.sast.api.config.MainConfig;
import cn.sast.api.report.IReportHashCalculator;
import cn.sast.api.report.Report;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.ResourceKt;
import cn.sast.framework.report.IFileReportConsumer;
import cn.sast.framework.report.IMetadataVisitor;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.ReportConsumer;
import cn.sast.framework.report.metadata.AnalysisMetadata;
import cn.sast.framework.result.OutputType;
import com.feysh.corax.cache.analysis.SootInfoCache;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public final class PlistDiagnostics extends ReportConsumer implements IFileReportConsumer, IMetadataVisitor {
    private static final FileTime hardcodeModifiedTime;
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PlistDiagnostics.class);

    static {
        SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
        try {
            hardcodeModifiedTime = FileTime.from(sdf.parse("10/10/2100").toInstant());
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize hardcoded modified time", e);
        }
    }

    @NotNull
    private final MainConfig mainConfig;
    @Nullable
    private final SootInfoCache info;
    @NotNull
    private final IReportHashCalculator hashCalculator;

    public PlistDiagnostics(@NotNull MainConfig mainConfig, @Nullable SootInfoCache info, @NotNull IResDirectory outputDir) {
        super(OutputType.PLIST, outputDir);
        this.mainConfig = mainConfig;
        this.info = info;
        this.hashCalculator = createHashCalculator();
    }

    @NotNull
    public MainConfig getMainConfig() {
        return mainConfig;
    }

    @Nullable
    public SootInfoCache getInfo() {
        return info;
    }

    @NotNull
    @Override
    public ReportConsumer.MetaData getMetadata() {
        return new ReportConsumer.MetaData("CoraxJava plist report", "1.0", "CoraxJava");
    }

    @NotNull
    public IReportHashCalculator getHashCalculator() {
        return hashCalculator;
    }

    @Override
    public void flush(@NotNull List<Report> reports, @NotNull String filename, @NotNull IProjectFileLocator locator) {
        String outputFileName = getReportFileName(filename);
        IResource fullPath = getOutputDir().resolve(outputFileName);

        PlistDiagnosticImpl diagnostic = new PlistDiagnosticImpl(this, getMetadata(), locator);
        String content = diagnostic.getRoot(reports);
        if (content != null) {
            try {
                ResourceKt.writeText(fullPath.toFile(), content);
                Files.setLastModifiedTime(fullPath.getPath(), hardcodeModifiedTime);
                logger.trace("Create/modify plist file: '{}'", fullPath);
            } catch (IOException e) {
                logger.warn("Failed to update plist file modification time", e);
            }
        }
    }

    @Override
    public void visit(@NotNull AnalysisMetadata analysisMetadata) {
        IResFile metadataFilePath = getOutputDir().resolve("metadata.json").toFile();
        ResourceKt.writeText(metadataFilePath, analysisMetadata.toJson());
    }

    private String getReportFileName(String fileName) {
        String analyzerName = getMetadata().getAnalyzerName().toLowerCase(Locale.getDefault());
        return fileName + "_" + analyzerName + ".plist";
    }

    @Override
    public void close() {
        // No resources to close
    }

    private IReportHashCalculator createHashCalculator() {
        return new IReportHashCalculator() {
            // Implementation of hash calculator
        };
    }

    public static final class PlistDiagnosticImpl {
        // Implementation of PlistDiagnosticImpl
    }

    public static final class Companion {
        private Companion() {}
    }
}
