/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.Transacter
 *  cn.sast.framework.report.sqldelight.AbsoluteFilePathQueries
 *  cn.sast.framework.report.sqldelight.AnalyzeResultFileQueries
 *  cn.sast.framework.report.sqldelight.AnalyzerStatisticsQueries
 *  cn.sast.framework.report.sqldelight.ControlFlowPathQueries
 *  cn.sast.framework.report.sqldelight.ControlFlowQueries
 *  cn.sast.framework.report.sqldelight.Database
 *  cn.sast.framework.report.sqldelight.Database$Companion
 *  cn.sast.framework.report.sqldelight.DiagnosticExtQueries
 *  cn.sast.framework.report.sqldelight.DiagnosticQueries
 *  cn.sast.framework.report.sqldelight.FileQueries
 *  cn.sast.framework.report.sqldelight.MacroExpansionQueries
 *  cn.sast.framework.report.sqldelight.NoteExtQueries
 *  cn.sast.framework.report.sqldelight.NotePathQueries
 *  cn.sast.framework.report.sqldelight.NoteQueries
 *  cn.sast.framework.report.sqldelight.RegionQueries
 *  cn.sast.framework.report.sqldelight.RuleMappingQueries
 *  cn.sast.framework.report.sqldelight.RuleQueries
 *  cn.sast.framework.report.sqldelight.RuleSetInfoQueries
 *  cn.sast.framework.report.sqldelight.SchemaInfoQueries
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.Transacter;
import cn.sast.framework.report.sqldelight.AbsoluteFilePathQueries;
import cn.sast.framework.report.sqldelight.AnalyzeResultFileQueries;
import cn.sast.framework.report.sqldelight.AnalyzerStatisticsQueries;
import cn.sast.framework.report.sqldelight.ControlFlowPathQueries;
import cn.sast.framework.report.sqldelight.ControlFlowQueries;
import cn.sast.framework.report.sqldelight.Database;
import cn.sast.framework.report.sqldelight.DiagnosticExtQueries;
import cn.sast.framework.report.sqldelight.DiagnosticQueries;
import cn.sast.framework.report.sqldelight.FileQueries;
import cn.sast.framework.report.sqldelight.MacroExpansionQueries;
import cn.sast.framework.report.sqldelight.NoteExtQueries;
import cn.sast.framework.report.sqldelight.NotePathQueries;
import cn.sast.framework.report.sqldelight.NoteQueries;
import cn.sast.framework.report.sqldelight.RegionQueries;
import cn.sast.framework.report.sqldelight.RuleMappingQueries;
import cn.sast.framework.report.sqldelight.RuleQueries;
import cn.sast.framework.report.sqldelight.RuleSetInfoQueries;
import cn.sast.framework.report.sqldelight.SchemaInfoQueries;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 F2\u00020\u0001:\u0001FR\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020#X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0012\u0010*\u001a\u00020+X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u0012\u0010.\u001a\u00020/X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0012\u00102\u001a\u000203X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0012\u00106\u001a\u000207X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109R\u0012\u0010:\u001a\u00020;X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=R\u0012\u0010>\u001a\u00020?X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010AR\u0012\u0010B\u001a\u00020CX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u0010E\u00a8\u0006G"}, d2={"Lcn/sast/framework/report/sqldelight/Database;", "Lapp/cash/sqldelight/Transacter;", "absoluteFilePathQueries", "Lcn/sast/framework/report/sqldelight/AbsoluteFilePathQueries;", "getAbsoluteFilePathQueries", "()Lcn/sast/framework/report/sqldelight/AbsoluteFilePathQueries;", "analyzeResultFileQueries", "Lcn/sast/framework/report/sqldelight/AnalyzeResultFileQueries;", "getAnalyzeResultFileQueries", "()Lcn/sast/framework/report/sqldelight/AnalyzeResultFileQueries;", "analyzerStatisticsQueries", "Lcn/sast/framework/report/sqldelight/AnalyzerStatisticsQueries;", "getAnalyzerStatisticsQueries", "()Lcn/sast/framework/report/sqldelight/AnalyzerStatisticsQueries;", "controlFlowQueries", "Lcn/sast/framework/report/sqldelight/ControlFlowQueries;", "getControlFlowQueries", "()Lcn/sast/framework/report/sqldelight/ControlFlowQueries;", "controlFlowPathQueries", "Lcn/sast/framework/report/sqldelight/ControlFlowPathQueries;", "getControlFlowPathQueries", "()Lcn/sast/framework/report/sqldelight/ControlFlowPathQueries;", "diagnosticQueries", "Lcn/sast/framework/report/sqldelight/DiagnosticQueries;", "getDiagnosticQueries", "()Lcn/sast/framework/report/sqldelight/DiagnosticQueries;", "diagnosticExtQueries", "Lcn/sast/framework/report/sqldelight/DiagnosticExtQueries;", "getDiagnosticExtQueries", "()Lcn/sast/framework/report/sqldelight/DiagnosticExtQueries;", "fileQueries", "Lcn/sast/framework/report/sqldelight/FileQueries;", "getFileQueries", "()Lcn/sast/framework/report/sqldelight/FileQueries;", "macroExpansionQueries", "Lcn/sast/framework/report/sqldelight/MacroExpansionQueries;", "getMacroExpansionQueries", "()Lcn/sast/framework/report/sqldelight/MacroExpansionQueries;", "noteQueries", "Lcn/sast/framework/report/sqldelight/NoteQueries;", "getNoteQueries", "()Lcn/sast/framework/report/sqldelight/NoteQueries;", "noteExtQueries", "Lcn/sast/framework/report/sqldelight/NoteExtQueries;", "getNoteExtQueries", "()Lcn/sast/framework/report/sqldelight/NoteExtQueries;", "notePathQueries", "Lcn/sast/framework/report/sqldelight/NotePathQueries;", "getNotePathQueries", "()Lcn/sast/framework/report/sqldelight/NotePathQueries;", "regionQueries", "Lcn/sast/framework/report/sqldelight/RegionQueries;", "getRegionQueries", "()Lcn/sast/framework/report/sqldelight/RegionQueries;", "ruleQueries", "Lcn/sast/framework/report/sqldelight/RuleQueries;", "getRuleQueries", "()Lcn/sast/framework/report/sqldelight/RuleQueries;", "ruleMappingQueries", "Lcn/sast/framework/report/sqldelight/RuleMappingQueries;", "getRuleMappingQueries", "()Lcn/sast/framework/report/sqldelight/RuleMappingQueries;", "ruleSetInfoQueries", "Lcn/sast/framework/report/sqldelight/RuleSetInfoQueries;", "getRuleSetInfoQueries", "()Lcn/sast/framework/report/sqldelight/RuleSetInfoQueries;", "schemaInfoQueries", "Lcn/sast/framework/report/sqldelight/SchemaInfoQueries;", "getSchemaInfoQueries", "()Lcn/sast/framework/report/sqldelight/SchemaInfoQueries;", "Companion", "corax-framework"})
public interface Database
extends Transacter {
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @NotNull
    public AbsoluteFilePathQueries getAbsoluteFilePathQueries();

    @NotNull
    public AnalyzeResultFileQueries getAnalyzeResultFileQueries();

    @NotNull
    public AnalyzerStatisticsQueries getAnalyzerStatisticsQueries();

    @NotNull
    public ControlFlowQueries getControlFlowQueries();

    @NotNull
    public ControlFlowPathQueries getControlFlowPathQueries();

    @NotNull
    public DiagnosticQueries getDiagnosticQueries();

    @NotNull
    public DiagnosticExtQueries getDiagnosticExtQueries();

    @NotNull
    public FileQueries getFileQueries();

    @NotNull
    public MacroExpansionQueries getMacroExpansionQueries();

    @NotNull
    public NoteQueries getNoteQueries();

    @NotNull
    public NoteExtQueries getNoteExtQueries();

    @NotNull
    public NotePathQueries getNotePathQueries();

    @NotNull
    public RegionQueries getRegionQueries();

    @NotNull
    public RuleQueries getRuleQueries();

    @NotNull
    public RuleMappingQueries getRuleMappingQueries();

    @NotNull
    public RuleSetInfoQueries getRuleSetInfoQueries();

    @NotNull
    public SchemaInfoQueries getSchemaInfoQueries();
}

