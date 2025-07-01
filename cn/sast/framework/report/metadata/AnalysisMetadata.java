package cn.sast.framework.report.metadata;

import cn.sast.framework.report.metadata.Counter;
import cn.sast.framework.report.metadata.Tool;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Serializable
public final class AnalysisMetadata {
    private final int fileCount;
    private final int lineCount;
    @NotNull
    private final Counter codeCoverage;
    private final int numOfReportDir;
    @NotNull
    private final List<String> sourcePaths;
    @NotNull
    private final String osName;
    @NotNull
    private final List<Tool> tools;

    public AnalysisMetadata(
            int fileCount,
            int lineCount,
            @NotNull Counter codeCoverage,
            int numOfReportDir,
            @NotNull List<String> sourcePaths,
            @NotNull String osName,
            @NotNull List<Tool> tools
    ) {
        if (codeCoverage == null) throw new IllegalArgumentException("codeCoverage cannot be null");
        if (sourcePaths == null) throw new IllegalArgumentException("sourcePaths cannot be null");
        if (osName == null) throw new IllegalArgumentException("osName cannot be null");
        if (tools == null) throw new IllegalArgumentException("tools cannot be null");

        this.fileCount = fileCount;
        this.lineCount = lineCount;
        this.codeCoverage = codeCoverage;
        this.numOfReportDir = numOfReportDir;
        this.sourcePaths = sourcePaths;
        this.osName = osName;
        this.tools = tools;
    }

    @SerialName("file_count")
    public int getFileCount() {
        return fileCount;
    }

    @SerialName("line_count")
    public int getLineCount() {
        return lineCount;
    }

    @SerialName("code_coverage")
    @NotNull
    public Counter getCodeCoverage() {
        return codeCoverage;
    }

    @SerialName("num_of_report_dir")
    public int getNumOfReportDir() {
        return numOfReportDir;
    }

    @SerialName("source_paths")
    @NotNull
    public List<String> getSourcePaths() {
        return sourcePaths;
    }

    @SerialName("os_name")
    @NotNull
    public String getOsName() {
        return osName;
    }

    @NotNull
    public List<Tool> getTools() {
        return tools;
    }

    @NotNull
    public String toJson() {
        return Json.Default.encodeToString(serializer(), this);
    }

    @NotNull
    public AnalysisMetadata copy(
            int fileCount,
            int lineCount,
            @NotNull Counter codeCoverage,
            int numOfReportDir,
            @NotNull List<String> sourcePaths,
            @NotNull String osName,
            @NotNull List<Tool> tools
    ) {
        if (codeCoverage == null) throw new IllegalArgumentException("codeCoverage cannot be null");
        if (sourcePaths == null) throw new IllegalArgumentException("sourcePaths cannot be null");
        if (osName == null) throw new IllegalArgumentException("osName cannot be null");
        if (tools == null) throw new IllegalArgumentException("tools cannot be null");

        return new AnalysisMetadata(
                fileCount,
                lineCount,
                codeCoverage,
                numOfReportDir,
                sourcePaths,
                osName,
                tools
        );
    }

    @Override
    public String toString() {
        return "AnalysisMetadata(fileCount=" + fileCount +
                ", lineCount=" + lineCount +
                ", codeCoverage=" + codeCoverage +
                ", numOfReportDir=" + numOfReportDir +
                ", sourcePaths=" + sourcePaths +
                ", osName=" + osName +
                ", tools=" + tools + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof AnalysisMetadata)) return false;
        
        AnalysisMetadata that = (AnalysisMetadata) other;
        return fileCount == that.fileCount &&
                lineCount == that.lineCount &&
                codeCoverage.equals(that.codeCoverage) &&
                numOfReportDir == that.numOfReportDir &&
                sourcePaths.equals(that.sourcePaths) &&
                osName.equals(that.osName) &&
                tools.equals(that.tools);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(fileCount);
        result = 31 * result + Integer.hashCode(lineCount);
        result = 31 * result + codeCoverage.hashCode();
        result = 31 * result + Integer.hashCode(numOfReportDir);
        result = 31 * result + sourcePaths.hashCode();
        result = 31 * result + osName.hashCode();
        result = 31 * result + tools.hashCode();
        return result;
    }

    public static final class Companion {
        @NotNull
        public static final KSerializer<AnalysisMetadata> serializer() {
            return serializer;
        }

        private static final KSerializer<AnalysisMetadata> serializer = new AnalysisMetadata$$serializer();
    }

    private static final Json jsonFormat = JsonKt.Json(Json.Default, builder -> {
        builder.setUseArrayPolymorphism(true);
        builder.setPrettyPrint(true);
        builder.setEncodeDefaults(false);
        return null;
    });
}
