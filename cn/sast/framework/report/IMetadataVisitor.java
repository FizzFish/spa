package cn.sast.framework.report;

import cn.sast.framework.report.metadata.AnalysisMetadata;
import org.jetbrains.annotations.NotNull;

public interface IMetadataVisitor {
    void visit(@NotNull AnalysisMetadata analysisMetadata);
}