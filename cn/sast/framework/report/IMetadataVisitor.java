/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.IMetadataVisitor
 *  cn.sast.framework.report.metadata.AnalysisMetadata
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report;

import cn.sast.framework.report.metadata.AnalysisMetadata;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2={"Lcn/sast/framework/report/IMetadataVisitor;", "", "visit", "", "analysisMetadata", "Lcn/sast/framework/report/metadata/AnalysisMetadata;", "corax-framework"})
public interface IMetadataVisitor {
    public void visit(@NotNull AnalysisMetadata var1);
}

