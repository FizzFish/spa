/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.IResultCollector
 *  cn.sast.framework.engine.PreAnalysisReportEnv
 *  cn.sast.framework.result.IPreAnalysisResultCollector
 *  com.feysh.corax.config.api.CheckType
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.result;

import cn.sast.api.report.IResultCollector;
import cn.sast.framework.engine.PreAnalysisReportEnv;
import com.feysh.corax.config.api.CheckType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2={"Lcn/sast/framework/result/IPreAnalysisResultCollector;", "Lcn/sast/api/report/IResultCollector;", "report", "", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "info", "Lcn/sast/framework/engine/PreAnalysisReportEnv;", "corax-framework"})
public interface IPreAnalysisResultCollector
extends IResultCollector {
    public void report(@NotNull CheckType var1, @NotNull PreAnalysisReportEnv var2);
}

