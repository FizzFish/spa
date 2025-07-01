package cn.sast.framework.report.sqldelight.coraxframework;

import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlDriver;
import cn.sast.framework.report.sqldelight.*;
import org.jetbrains.annotations.NotNull;

final class DatabaseImpl extends TransacterImpl implements Database {
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

    @Override @NotNull
    public AbsoluteFilePathQueries getAbsoluteFilePathQueries() {
        return absoluteFilePathQueries;
    }

    @Override @NotNull
    public AnalyzeResultFileQueries getAnalyzeResultFileQueries() {
        return analyzeResultFileQueries;
    }

    @Override @NotNull
    public AnalyzerStatisticsQueries getAnalyzerStatisticsQueries() {
        return analyzerStatisticsQueries;
    }

    @Override @NotNull
    public ControlFlowQueries getControlFlowQueries() {
        return controlFlowQueries;
    }

    @Override @NotNull
    public ControlFlowPathQueries getControlFlowPathQueries() {
        return controlFlowPathQueries;
    }

    @Override @NotNull
    public DiagnosticQueries getDiagnosticQueries() {
        return diagnosticQueries;
    }

    @Override @NotNull
    public DiagnosticExtQueries getDiagnosticExtQueries() {
        return diagnosticExtQueries;
    }

    @Override @NotNull
    public FileQueries getFileQueries() {
        return fileQueries;
    }

    @Override @NotNull
    public MacroExpansionQueries getMacroExpansionQueries() {
        return macroExpansionQueries;
    }

    @Override @NotNull
    public NoteQueries getNoteQueries() {
        return noteQueries;
    }

    @Override @NotNull
    public NoteExtQueries getNoteExtQueries() {
        return noteExtQueries;
    }

    @Override @NotNull
    public NotePathQueries getNotePathQueries() {
        return notePathQueries;
    }

    @Override @NotNull
    public RegionQueries getRegionQueries() {
        return regionQueries;
    }

    @Override @NotNull
    public RuleQueries getRuleQueries() {
        return ruleQueries;
    }

    @Override @NotNull
    public RuleMappingQueries getRuleMappingQueries() {
        return ruleMappingQueries;
    }

    @Override @NotNull
    public RuleSetInfoQueries getRuleSetInfoQueries() {
        return ruleSetInfoQueries;
    }

    @Override @NotNull
    public SchemaInfoQueries getSchemaInfoQueries() {
        return schemaInfoQueries;
    }
}