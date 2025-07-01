package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.Transacter;
import org.jetbrains.annotations.NotNull;

public interface Database extends Transacter {
    @NotNull AbsoluteFilePathQueries getAbsoluteFilePathQueries();
    @NotNull AnalyzeResultFileQueries getAnalyzeResultFileQueries();
    @NotNull AnalyzerStatisticsQueries getAnalyzerStatisticsQueries();
    @NotNull ControlFlowQueries getControlFlowQueries();
    @NotNull ControlFlowPathQueries getControlFlowPathQueries();
    @NotNull DiagnosticQueries getDiagnosticQueries();
    @NotNull DiagnosticExtQueries getDiagnosticExtQueries();
    @NotNull FileQueries getFileQueries();
    @NotNull MacroExpansionQueries getMacroExpansionQueries();
    @NotNull NoteQueries getNoteQueries();
    @NotNull NoteExtQueries getNoteExtQueries();
    @NotNull NotePathQueries getNotePathQueries();
    @NotNull RegionQueries getRegionQueries();
    @NotNull RuleQueries getRuleQueries();
    @NotNull RuleMappingQueries getRuleMappingQueries();
    @NotNull RuleSetInfoQueries getRuleSetInfoQueries();
    @NotNull SchemaInfoQueries getSchemaInfoQueries();
}