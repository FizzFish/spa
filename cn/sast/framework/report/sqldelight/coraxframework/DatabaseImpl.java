/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.TransacterImpl
 *  app.cash.sqldelight.db.SqlDriver
 *  cn.sast.framework.report.sqldelight.AbsoluteFilePathQueries
 *  cn.sast.framework.report.sqldelight.AnalyzeResultFileQueries
 *  cn.sast.framework.report.sqldelight.AnalyzerStatisticsQueries
 *  cn.sast.framework.report.sqldelight.ControlFlowPathQueries
 *  cn.sast.framework.report.sqldelight.ControlFlowQueries
 *  cn.sast.framework.report.sqldelight.Database
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
 *  cn.sast.framework.report.sqldelight.coraxframework.DatabaseImpl
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report.sqldelight.coraxframework;

import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlDriver;
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
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001KB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u000200X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0014\u00103\u001a\u000204X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u000208X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020<X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020@X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020DX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020HX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010J\u00a8\u0006L"}, d2={"Lcn/sast/framework/report/sqldelight/coraxframework/DatabaseImpl;", "Lapp/cash/sqldelight/TransacterImpl;", "Lcn/sast/framework/report/sqldelight/Database;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "absoluteFilePathQueries", "Lcn/sast/framework/report/sqldelight/AbsoluteFilePathQueries;", "getAbsoluteFilePathQueries", "()Lcn/sast/framework/report/sqldelight/AbsoluteFilePathQueries;", "analyzeResultFileQueries", "Lcn/sast/framework/report/sqldelight/AnalyzeResultFileQueries;", "getAnalyzeResultFileQueries", "()Lcn/sast/framework/report/sqldelight/AnalyzeResultFileQueries;", "analyzerStatisticsQueries", "Lcn/sast/framework/report/sqldelight/AnalyzerStatisticsQueries;", "getAnalyzerStatisticsQueries", "()Lcn/sast/framework/report/sqldelight/AnalyzerStatisticsQueries;", "controlFlowQueries", "Lcn/sast/framework/report/sqldelight/ControlFlowQueries;", "getControlFlowQueries", "()Lcn/sast/framework/report/sqldelight/ControlFlowQueries;", "controlFlowPathQueries", "Lcn/sast/framework/report/sqldelight/ControlFlowPathQueries;", "getControlFlowPathQueries", "()Lcn/sast/framework/report/sqldelight/ControlFlowPathQueries;", "diagnosticQueries", "Lcn/sast/framework/report/sqldelight/DiagnosticQueries;", "getDiagnosticQueries", "()Lcn/sast/framework/report/sqldelight/DiagnosticQueries;", "diagnosticExtQueries", "Lcn/sast/framework/report/sqldelight/DiagnosticExtQueries;", "getDiagnosticExtQueries", "()Lcn/sast/framework/report/sqldelight/DiagnosticExtQueries;", "fileQueries", "Lcn/sast/framework/report/sqldelight/FileQueries;", "getFileQueries", "()Lcn/sast/framework/report/sqldelight/FileQueries;", "macroExpansionQueries", "Lcn/sast/framework/report/sqldelight/MacroExpansionQueries;", "getMacroExpansionQueries", "()Lcn/sast/framework/report/sqldelight/MacroExpansionQueries;", "noteQueries", "Lcn/sast/framework/report/sqldelight/NoteQueries;", "getNoteQueries", "()Lcn/sast/framework/report/sqldelight/NoteQueries;", "noteExtQueries", "Lcn/sast/framework/report/sqldelight/NoteExtQueries;", "getNoteExtQueries", "()Lcn/sast/framework/report/sqldelight/NoteExtQueries;", "notePathQueries", "Lcn/sast/framework/report/sqldelight/NotePathQueries;", "getNotePathQueries", "()Lcn/sast/framework/report/sqldelight/NotePathQueries;", "regionQueries", "Lcn/sast/framework/report/sqldelight/RegionQueries;", "getRegionQueries", "()Lcn/sast/framework/report/sqldelight/RegionQueries;", "ruleQueries", "Lcn/sast/framework/report/sqldelight/RuleQueries;", "getRuleQueries", "()Lcn/sast/framework/report/sqldelight/RuleQueries;", "ruleMappingQueries", "Lcn/sast/framework/report/sqldelight/RuleMappingQueries;", "getRuleMappingQueries", "()Lcn/sast/framework/report/sqldelight/RuleMappingQueries;", "ruleSetInfoQueries", "Lcn/sast/framework/report/sqldelight/RuleSetInfoQueries;", "getRuleSetInfoQueries", "()Lcn/sast/framework/report/sqldelight/RuleSetInfoQueries;", "schemaInfoQueries", "Lcn/sast/framework/report/sqldelight/SchemaInfoQueries;", "getSchemaInfoQueries", "()Lcn/sast/framework/report/sqldelight/SchemaInfoQueries;", "Schema", "corax-framework"})
final class DatabaseImpl
extends TransacterImpl
implements Database {
    @NotNull
    private final AbsoluteFilePathQueries absoluteFilePathQueries;
    @NotNull
    private final AnalyzeResultFileQueries analyzeResultFileQueries;
    @NotNull
    private final AnalyzerStatisticsQueries analyzerStatisticsQueries;
    @NotNull
    private final ControlFlowQueries controlFlowQueries;
    @NotNull
    private final ControlFlowPathQueries controlFlowPathQueries;
    @NotNull
    private final DiagnosticQueries diagnosticQueries;
    @NotNull
    private final DiagnosticExtQueries diagnosticExtQueries;
    @NotNull
    private final FileQueries fileQueries;
    @NotNull
    private final MacroExpansionQueries macroExpansionQueries;
    @NotNull
    private final NoteQueries noteQueries;
    @NotNull
    private final NoteExtQueries noteExtQueries;
    @NotNull
    private final NotePathQueries notePathQueries;
    @NotNull
    private final RegionQueries regionQueries;
    @NotNull
    private final RuleQueries ruleQueries;
    @NotNull
    private final RuleMappingQueries ruleMappingQueries;
    @NotNull
    private final RuleSetInfoQueries ruleSetInfoQueries;
    @NotNull
    private final SchemaInfoQueries schemaInfoQueries;

    public DatabaseImpl(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
        this.absoluteFilePathQueries = new AbsoluteFilePathQueries(driver);
        this.analyzeResultFileQueries = new AnalyzeResultFileQueries(driver);
        this.analyzerStatisticsQueries = new AnalyzerStatisticsQueries(driver);
        this.controlFlowQueries = new ControlFlowQueries(driver);
        this.controlFlowPathQueries = new ControlFlowPathQueries(driver);
        this.diagnosticQueries = new DiagnosticQueries(driver);
        this.diagnosticExtQueries = new DiagnosticExtQueries(driver);
        this.fileQueries = new FileQueries(driver);
        this.macroExpansionQueries = new MacroExpansionQueries(driver);
        this.noteQueries = new NoteQueries(driver);
        this.noteExtQueries = new NoteExtQueries(driver);
        this.notePathQueries = new NotePathQueries(driver);
        this.regionQueries = new RegionQueries(driver);
        this.ruleQueries = new RuleQueries(driver);
        this.ruleMappingQueries = new RuleMappingQueries(driver);
        this.ruleSetInfoQueries = new RuleSetInfoQueries(driver);
        this.schemaInfoQueries = new SchemaInfoQueries(driver);
    }

    @NotNull
    public AbsoluteFilePathQueries getAbsoluteFilePathQueries() {
        return this.absoluteFilePathQueries;
    }

    @NotNull
    public AnalyzeResultFileQueries getAnalyzeResultFileQueries() {
        return this.analyzeResultFileQueries;
    }

    @NotNull
    public AnalyzerStatisticsQueries getAnalyzerStatisticsQueries() {
        return this.analyzerStatisticsQueries;
    }

    @NotNull
    public ControlFlowQueries getControlFlowQueries() {
        return this.controlFlowQueries;
    }

    @NotNull
    public ControlFlowPathQueries getControlFlowPathQueries() {
        return this.controlFlowPathQueries;
    }

    @NotNull
    public DiagnosticQueries getDiagnosticQueries() {
        return this.diagnosticQueries;
    }

    @NotNull
    public DiagnosticExtQueries getDiagnosticExtQueries() {
        return this.diagnosticExtQueries;
    }

    @NotNull
    public FileQueries getFileQueries() {
        return this.fileQueries;
    }

    @NotNull
    public MacroExpansionQueries getMacroExpansionQueries() {
        return this.macroExpansionQueries;
    }

    @NotNull
    public NoteQueries getNoteQueries() {
        return this.noteQueries;
    }

    @NotNull
    public NoteExtQueries getNoteExtQueries() {
        return this.noteExtQueries;
    }

    @NotNull
    public NotePathQueries getNotePathQueries() {
        return this.notePathQueries;
    }

    @NotNull
    public RegionQueries getRegionQueries() {
        return this.regionQueries;
    }

    @NotNull
    public RuleQueries getRuleQueries() {
        return this.ruleQueries;
    }

    @NotNull
    public RuleMappingQueries getRuleMappingQueries() {
        return this.ruleMappingQueries;
    }

    @NotNull
    public RuleSetInfoQueries getRuleSetInfoQueries() {
        return this.ruleSetInfoQueries;
    }

    @NotNull
    public SchemaInfoQueries getSchemaInfoQueries() {
        return this.schemaInfoQueries;
    }
}

