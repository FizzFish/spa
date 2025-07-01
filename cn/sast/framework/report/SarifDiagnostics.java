package cn.sast.framework.report;

import cn.sast.api.report.Report;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResource;
import cn.sast.framework.report.IFileReportConsumer;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.ReportConsumer;
import cn.sast.framework.result.OutputType;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

public class SarifDiagnostics extends ReportConsumer implements IFileReportConsumer {
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(SarifDiagnostics.class);

    public SarifDiagnostics(@NotNull IResDirectory outputDir, @NotNull OutputType type) {
        super(type, outputDir);
    }

    public SarifDiagnostics(@NotNull IResDirectory outputDir) {
        this(outputDir, OutputType.SARIF);
    }

    @Override
    @NotNull
    public ReportConsumer.MetaData getMetadata() {
        return new ReportConsumer.MetaData("corax", "1.0", "CoraxJava");
    }

    @NotNull
    public SarifDiagnosticsImpl getSarifDiagnosticsImpl(@NotNull ReportConsumer.MetaData metadata, 
                                                      @NotNull IProjectFileLocator locator) {
        return new SarifDiagnosticsImpl(this, metadata, locator);
    }

    public CompletableFuture<Void> flush(@NotNull List<Report> reports, 
                                        @NotNull String filename, 
                                        @NotNull IProjectFileLocator locator) {
        String outputFileName = getReportFileName(filename);
        IResource fullPath = getOutputDir().resolve(outputFileName);

        return CompletableFuture.runAsync(() -> {
            logger.trace(() -> "Create/modify plist file: '" + fullPath + "'");
        });
    }

    private String getReportFileName(String fileName) {
        String analyzerName = getMetadata().getAnalyzerName().toLowerCase(Locale.getDefault());
        return fileName + "_" + analyzerName + ".sarif";
    }

    @Override
    public void close() {
        // No resources to close
    }

    public static final class SarifDiagnosticsImpl {
        private final SarifDiagnostics diagnostics;
        private final ReportConsumer.MetaData metadata;
        private final IProjectFileLocator locator;

        public SarifDiagnosticsImpl(SarifDiagnostics diagnostics, 
                                  ReportConsumer.MetaData metadata, 
                                  IProjectFileLocator locator) {
            this.diagnostics = diagnostics;
            this.metadata = metadata;
            this.locator = locator;
        }
    }
}