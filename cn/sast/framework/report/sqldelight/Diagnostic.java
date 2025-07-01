package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public final class Diagnostic {
    private final long id;
    @NotNull
    private final String ruleName;
    @Nullable
    private final String ruleShortDescriptionZh;
    @Nullable
    private final Long fileId;
    @NotNull
    private final String fileAbsPath;
    private final long line;
    private final long column;
    @NotNull
    private final String messageEn;
    @NotNull
    private final String messageZh;
    @Nullable
    private final String severity;
    @Nullable
    private final String precision;
    @Nullable
    private final String likelihood;
    @Nullable
    private final String impact;
    @Nullable
    private final String technique;
    @Nullable
    private final String analysisScope;
    @Nullable
    private final String lineContent;
    private final long noteArrayHashId;
    @Nullable
    private final Long controlFlowArrayHashId;
    @Nullable
    private final Long macroNoteSetHashId;

    public Diagnostic(long id, @NotNull String ruleName, @Nullable String ruleShortDescriptionZh, 
            @Nullable Long fileId, @NotNull String fileAbsPath, long line, long column, 
            @NotNull String messageEn, @NotNull String messageZh, @Nullable String severity, 
            @Nullable String precision, @Nullable String likelihood, @Nullable String impact, 
            @Nullable String technique, @Nullable String analysisScope, @Nullable String lineContent, 
            long noteArrayHashId, @Nullable Long controlFlowArrayHashId, @Nullable Long macroNoteSetHashId) {
        Objects.requireNonNull(ruleName, "ruleName cannot be null");
        Objects.requireNonNull(fileAbsPath, "fileAbsPath cannot be null");
        Objects.requireNonNull(messageEn, "messageEn cannot be null");
        Objects.requireNonNull(messageZh, "messageZh cannot be null");
        
        this.id = id;
        this.ruleName = ruleName;
        this.ruleShortDescriptionZh = ruleShortDescriptionZh;
        this.fileId = fileId;
        this.fileAbsPath = fileAbsPath;
        this.line = line;
        this.column = column;
        this.messageEn = messageEn;
        this.messageZh = messageZh;
        this.severity = severity;
        this.precision = precision;
        this.likelihood = likelihood;
        this.impact = impact;
        this.technique = technique;
        this.analysisScope = analysisScope;
        this.lineContent = lineContent;
        this.noteArrayHashId = noteArrayHashId;
        this.controlFlowArrayHashId = controlFlowArrayHashId;
        this.macroNoteSetHashId = macroNoteSetHashId;
    }

    public long getId() {
        return id;
    }

    @NotNull
    public String getRuleName() {
        return ruleName;
    }

    @Nullable
    public String getRuleShortDescriptionZh() {
        return ruleShortDescriptionZh;
    }

    @Nullable
    public Long getFileId() {
        return fileId;
    }

    @NotNull
    public String getFileAbsPath() {
        return fileAbsPath;
    }

    public long getLine() {
        return line;
    }

    public long getColumn() {
        return column;
    }

    @NotNull
    public String getMessageEn() {
        return messageEn;
    }

    @NotNull
    public String getMessageZh() {
        return messageZh;
    }

    @Nullable
    public String getSeverity() {
        return severity;
    }

    @Nullable
    public String getPrecision() {
        return precision;
    }

    @Nullable
    public String getLikelihood() {
        return likelihood;
    }

    @Nullable
    public String getImpact() {
        return impact;
    }

    @Nullable
    public String getTechnique() {
        return technique;
    }

    @Nullable
    public String getAnalysisScope() {
        return analysisScope;
    }

    @Nullable
    public String getLineContent() {
        return lineContent;
    }

    public long getNoteArrayHashId() {
        return noteArrayHashId;
    }

    @Nullable
    public Long getControlFlowArrayHashId() {
        return controlFlowArrayHashId;
    }

    @Nullable
    public Long getMacroNoteSetHashId() {
        return macroNoteSetHashId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnostic that = (Diagnostic) o;
        return id == that.id && 
                line == that.line && 
                column == that.column && 
                noteArrayHashId == that.noteArrayHashId && 
                Objects.equals(ruleName, that.ruleName) && 
                Objects.equals(ruleShortDescriptionZh, that.ruleShortDescriptionZh) && 
                Objects.equals(fileId, that.fileId) && 
                Objects.equals(fileAbsPath, that.fileAbsPath) && 
                Objects.equals(messageEn, that.messageEn) && 
                Objects.equals(messageZh, that.messageZh) && 
                Objects.equals(severity, that.severity) && 
                Objects.equals(precision, that.precision) && 
                Objects.equals(likelihood, that.likelihood) && 
                Objects.equals(impact, that.impact) && 
                Objects.equals(technique, that.technique) && 
                Objects.equals(analysisScope, that.analysisScope) && 
                Objects.equals(lineContent, that.lineContent) && 
                Objects.equals(controlFlowArrayHashId, that.controlFlowArrayHashId) && 
                Objects.equals(macroNoteSetHashId, that.macroNoteSetHashId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ruleName, ruleShortDescriptionZh, fileId, fileAbsPath, line, column, 
                messageEn, messageZh, severity, precision, likelihood, impact, technique, 
                analysisScope, lineContent, noteArrayHashId, controlFlowArrayHashId, macroNoteSetHashId);
    }

    @Override
    public String toString() {
        return "Diagnostic{" +
                "id=" + id +
                ", ruleName='" + ruleName + '\'' +
                ", ruleShortDescriptionZh='" + ruleShortDescriptionZh + '\'' +
                ", fileId=" + fileId +
                ", fileAbsPath='" + fileAbsPath + '\'' +
                ", line=" + line +
                ", column=" + column +
                ", messageEn='" + messageEn + '\'' +
                ", messageZh='" + messageZh + '\'' +
                ", severity='" + severity + '\'' +
                ", precision='" + precision + '\'' +
                ", likelihood='" + likelihood + '\'' +
                ", impact='" + impact + '\'' +
                ", technique='" + technique + '\'' +
                ", analysisScope='" + analysisScope + '\'' +
                ", lineContent='" + lineContent + '\'' +
                ", noteArrayHashId=" + noteArrayHashId +
                ", controlFlowArrayHashId=" + controlFlowArrayHashId +
                ", macroNoteSetHashId=" + macroNoteSetHashId +
                '}';
    }
}