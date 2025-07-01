package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public final class AnalyzerStatistics {
    @NotNull
    private final String name;
    @NotNull
    private final String coraxProbeVersion;
    @NotNull
    private final String analyzerVersion;
    @NotNull
    private final String analysisBeginDate;
    private final long analysisBeginTimestamp;
    private final long analysisEscapeSeconds;
    @NotNull
    private final String analysisEscapeTime;
    @NotNull
    private final String analysisEndDate;
    private final long analysisEndTimestamp;
    private final long fileCount;
    private final long lineCount;
    @Nullable
    private final Long codeCoverageCovered;
    @Nullable
    private final Long codeCoverageMissed;
    @Nullable
    private final Long numOfReportDir;
    @NotNull
    private final String sourcePaths;
    @NotNull
    private final String osName;
    @NotNull
    private final String commandJson;
    @NotNull
    private final String workingDirectory;
    @NotNull
    private final String outputPath;
    @NotNull
    private final String projectRoot;
    @NotNull
    private final String logFile;
    @NotNull
    private final String enableRules;
    @NotNull
    private final String disableRules;
    @NotNull
    private final String failedSources;
    private final long failedSourcesNum;
    @NotNull
    private final String successfulSources;
    private final long successfulSourcesNum;
    @NotNull
    private final String skippedSources;
    private final long skippedSourcesNum;

    public AnalyzerStatistics(
            @NotNull String name,
            @NotNull String coraxProbeVersion,
            @NotNull String analyzerVersion,
            @NotNull String analysisBeginDate,
            long analysisBeginTimestamp,
            long analysisEscapeSeconds,
            @NotNull String analysisEscapeTime,
            @NotNull String analysisEndDate,
            long analysisEndTimestamp,
            long fileCount,
            long lineCount,
            @Nullable Long codeCoverageCovered,
            @Nullable Long codeCoverageMissed,
            @Nullable Long numOfReportDir,
            @NotNull String sourcePaths,
            @NotNull String osName,
            @NotNull String commandJson,
            @NotNull String workingDirectory,
            @NotNull String outputPath,
            @NotNull String projectRoot,
            @NotNull String logFile,
            @NotNull String enableRules,
            @NotNull String disableRules,
            @NotNull String failedSources,
            long failedSourcesNum,
            @NotNull String successfulSources,
            long successfulSourcesNum,
            @NotNull String skippedSources,
            long skippedSourcesNum) {
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(coraxProbeVersion, "coraxProbeVersion");
        Objects.requireNonNull(analyzerVersion, "analyzerVersion");
        Objects.requireNonNull(analysisBeginDate, "analysisBeginDate");
        Objects.requireNonNull(analysisEscapeTime, "analysisEscapeTime");
        Objects.requireNonNull(analysisEndDate, "analysisEndDate");
        Objects.requireNonNull(sourcePaths, "sourcePaths");
        Objects.requireNonNull(osName, "osName");
        Objects.requireNonNull(commandJson, "commandJson");
        Objects.requireNonNull(workingDirectory, "workingDirectory");
        Objects.requireNonNull(outputPath, "outputPath");
        Objects.requireNonNull(projectRoot, "projectRoot");
        Objects.requireNonNull(logFile, "logFile");
        Objects.requireNonNull(enableRules, "enableRules");
        Objects.requireNonNull(disableRules, "disableRules");
        Objects.requireNonNull(failedSources, "failedSources");
        Objects.requireNonNull(successfulSources, "successfulSources");
        Objects.requireNonNull(skippedSources, "skippedSources");

        this.name = name;
        this.coraxProbeVersion = coraxProbeVersion;
        this.analyzerVersion = analyzerVersion;
        this.analysisBeginDate = analysisBeginDate;
        this.analysisBeginTimestamp = analysisBeginTimestamp;
        this.analysisEscapeSeconds = analysisEscapeSeconds;
        this.analysisEscapeTime = analysisEscapeTime;
        this.analysisEndDate = analysisEndDate;
        this.analysisEndTimestamp = analysisEndTimestamp;
        this.fileCount = fileCount;
        this.lineCount = lineCount;
        this.codeCoverageCovered = codeCoverageCovered;
        this.codeCoverageMissed = codeCoverageMissed;
        this.numOfReportDir = numOfReportDir;
        this.sourcePaths = sourcePaths;
        this.osName = osName;
        this.commandJson = commandJson;
        this.workingDirectory = workingDirectory;
        this.outputPath = outputPath;
        this.projectRoot = projectRoot;
        this.logFile = logFile;
        this.enableRules = enableRules;
        this.disableRules = disableRules;
        this.failedSources = failedSources;
        this.failedSourcesNum = failedSourcesNum;
        this.successfulSources = successfulSources;
        this.successfulSourcesNum = successfulSourcesNum;
        this.skippedSources = skippedSources;
        this.skippedSourcesNum = skippedSourcesNum;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getCoraxProbeVersion() {
        return coraxProbeVersion;
    }

    @NotNull
    public String getAnalyzerVersion() {
        return analyzerVersion;
    }

    @NotNull
    public String getAnalysisBeginDate() {
        return analysisBeginDate;
    }

    public long getAnalysisBeginTimestamp() {
        return analysisBeginTimestamp;
    }

    public long getAnalysisEscapeSeconds() {
        return analysisEscapeSeconds;
    }

    @NotNull
    public String getAnalysisEscapeTime() {
        return analysisEscapeTime;
    }

    @NotNull
    public String getAnalysisEndDate() {
        return analysisEndDate;
    }

    public long getAnalysisEndTimestamp() {
        return analysisEndTimestamp;
    }

    public long getFileCount() {
        return fileCount;
    }

    public long getLineCount() {
        return lineCount;
    }

    @Nullable
    public Long getCodeCoverageCovered() {
        return codeCoverageCovered;
    }

    @Nullable
    public Long getCodeCoverageMissed() {
        return codeCoverageMissed;
    }

    @Nullable
    public Long getNumOfReportDir() {
        return numOfReportDir;
    }

    @NotNull
    public String getSourcePaths() {
        return sourcePaths;
    }

    @NotNull
    public String getOsName() {
        return osName;
    }

    @NotNull
    public String getCommandJson() {
        return commandJson;
    }

    @NotNull
    public String getWorkingDirectory() {
        return workingDirectory;
    }

    @NotNull
    public String getOutputPath() {
        return outputPath;
    }

    @NotNull
    public String getProjectRoot() {
        return projectRoot;
    }

    @NotNull
    public String getLogFile() {
        return logFile;
    }

    @NotNull
    public String getEnableRules() {
        return enableRules;
    }

    @NotNull
    public String getDisableRules() {
        return disableRules;
    }

    @NotNull
    public String getFailedSources() {
        return failedSources;
    }

    public long getFailedSourcesNum() {
        return failedSourcesNum;
    }

    @NotNull
    public String getSuccessfulSources() {
        return successfulSources;
    }

    public long getSuccessfulSourcesNum() {
        return successfulSourcesNum;
    }

    @NotNull
    public String getSkippedSources() {
        return skippedSources;
    }

    public long getSkippedSourcesNum() {
        return skippedSourcesNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnalyzerStatistics that = (AnalyzerStatistics) o;
        return analysisBeginTimestamp == that.analysisBeginTimestamp &&
                analysisEscapeSeconds == that.analysisEscapeSeconds &&
                analysisEndTimestamp == that.analysisEndTimestamp &&
                fileCount == that.fileCount &&
                lineCount == that.lineCount &&
                failedSourcesNum == that.failedSourcesNum &&
                successfulSourcesNum == that.successfulSourcesNum &&
                skippedSourcesNum == that.skippedSourcesNum &&
                name.equals(that.name) &&
                coraxProbeVersion.equals(that.coraxProbeVersion) &&
                analyzerVersion.equals(that.analyzerVersion) &&
                analysisBeginDate.equals(that.analysisBeginDate) &&
                analysisEscapeTime.equals(that.analysisEscapeTime) &&
                analysisEndDate.equals(that.analysisEndDate) &&
                Objects.equals(codeCoverageCovered, that.codeCoverageCovered) &&
                Objects.equals(codeCoverageMissed, that.codeCoverageMissed) &&
                Objects.equals(numOfReportDir, that.numOfReportDir) &&
                sourcePaths.equals(that.sourcePaths) &&
                osName.equals(that.osName) &&
                commandJson.equals(that.commandJson) &&
                workingDirectory.equals(that.workingDirectory) &&
                outputPath.equals(that.outputPath) &&
                projectRoot.equals(that.projectRoot) &&
                logFile.equals(that.logFile) &&
                enableRules.equals(that.enableRules) &&
                disableRules.equals(that.disableRules) &&
                failedSources.equals(that.failedSources) &&
                successfulSources.equals(that.successfulSources) &&
                skippedSources.equals(that.skippedSources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name,
                coraxProbeVersion,
                analyzerVersion,
                analysisBeginDate,
                analysisBeginTimestamp,
                analysisEscapeSeconds,
                analysisEscapeTime,
                analysisEndDate,
                analysisEndTimestamp,
                fileCount,
                lineCount,
                codeCoverageCovered,
                codeCoverageMissed,
                numOfReportDir,
                sourcePaths,
                osName,
                commandJson,
                workingDirectory,
                outputPath,
                projectRoot,
                logFile,
                enableRules,
                disableRules,
                failedSources,
                failedSourcesNum,
                successfulSources,
                successfulSourcesNum,
                skippedSources,
                skippedSourcesNum);
    }

    @Override
    public String toString() {
        return "AnalyzerStatistics{" +
                "name='" + name + '\'' +
                ", coraxProbeVersion='" + coraxProbeVersion + '\'' +
                ", analyzerVersion='" + analyzerVersion + '\'' +
                ", analysisBeginDate='" + analysisBeginDate + '\'' +
                ", analysisBeginTimestamp=" + analysisBeginTimestamp +
                ", analysisEscapeSeconds=" + analysisEscapeSeconds +
                ", analysisEscapeTime='" + analysisEscapeTime + '\'' +
                ", analysisEndDate='" + analysisEndDate + '\'' +
                ", analysisEndTimestamp=" + analysisEndTimestamp +
                ", fileCount=" + fileCount +
                ", lineCount=" + lineCount +
                ", codeCoverageCovered=" + codeCoverageCovered +
                ", codeCoverageMissed=" + codeCoverageMissed +
                ", numOfReportDir=" + numOfReportDir +
                ", sourcePaths='" + sourcePaths + '\'' +
                ", osName='" + osName + '\'' +
                ", commandJson='" + commandJson + '\'' +
                ", workingDirectory='" + workingDirectory + '\'' +
                ", outputPath='" + outputPath + '\'' +
                ", projectRoot='" + projectRoot + '\'' +
                ", logFile='" + logFile + '\'' +
                ", enableRules='" + enableRules + '\'' +
                ", disableRules='" + disableRules + '\'' +
                ", failedSources='" + failedSources + '\'' +
                ", failedSourcesNum=" + failedSourcesNum +
                ", successfulSources='" + successfulSources + '\'' +
                ", successfulSourcesNum=" + successfulSourcesNum +
                ", skippedSources='" + skippedSources + '\'' +
                ", skippedSourcesNum=" + skippedSourcesNum +
                '}';
    }
}