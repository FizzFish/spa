package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public final class Rule {
    @NotNull
    private final String name;
    @NotNull
    private final String shortDescriptionEn;
    @NotNull
    private final String shortDescriptionZh;
    @Nullable
    private final String severity;
    @Nullable
    private final String priority;
    @NotNull
    private final String language;
    @Nullable
    private final String precision;
    @Nullable
    private final String recall;
    @Nullable
    private final String likelihood;
    @Nullable
    private final String impact;
    @Nullable
    private final String technique;
    @Nullable
    private final String analysisScope;
    @Nullable
    private final String performance;
    @Nullable
    private final Long configurable;
    @Nullable
    private final Long implemented;
    @Nullable
    private final String staticAnalyzability;
    @Nullable
    private final String cAllocatedTarget;
    @NotNull
    private final String categoryEn;
    @NotNull
    private final String categoryZh;
    @Nullable
    private final Long ruleSortNumber;
    @Nullable
    private final String chapterName1;
    @Nullable
    private final String chapterName2;
    @Nullable
    private final String chapterName3;
    @Nullable
    private final String chapterName4;
    @NotNull
    private final String descriptionEn;
    @Nullable
    private final String descriptionZh;
    @NotNull
    private final String documentEn;
    @NotNull
    private final String documentZh;

    public Rule(@NotNull String name, @NotNull String shortDescriptionEn, @NotNull String shortDescriptionZh, 
                @Nullable String severity, @Nullable String priority, @NotNull String language, 
                @Nullable String precision, @Nullable String recall, @Nullable String likelihood, 
                @Nullable String impact, @Nullable String technique, @Nullable String analysisScope, 
                @Nullable String performance, @Nullable Long configurable, @Nullable Long implemented, 
                @Nullable String staticAnalyzability, @Nullable String cAllocatedTarget, @NotNull String categoryEn, 
                @NotNull String categoryZh, @Nullable Long ruleSortNumber, @Nullable String chapterName1, 
                @Nullable String chapterName2, @Nullable String chapterName3, @Nullable String chapterName4, 
                @NotNull String descriptionEn, @Nullable String descriptionZh, @NotNull String documentEn, 
                @NotNull String documentZh) {
        this.name = Objects.requireNonNull(name, "name");
        this.shortDescriptionEn = Objects.requireNonNull(shortDescriptionEn, "shortDescriptionEn");
        this.shortDescriptionZh = Objects.requireNonNull(shortDescriptionZh, "shortDescriptionZh");
        this.language = Objects.requireNonNull(language, "language");
        this.categoryEn = Objects.requireNonNull(categoryEn, "categoryEn");
        this.categoryZh = Objects.requireNonNull(categoryZh, "categoryZh");
        this.descriptionEn = Objects.requireNonNull(descriptionEn, "descriptionEn");
        this.documentEn = Objects.requireNonNull(documentEn, "documentEn");
        this.documentZh = Objects.requireNonNull(documentZh, "documentZh");
        
        this.severity = severity;
        this.priority = priority;
        this.precision = precision;
        this.recall = recall;
        this.likelihood = likelihood;
        this.impact = impact;
        this.technique = technique;
        this.analysisScope = analysisScope;
        this.performance = performance;
        this.configurable = configurable;
        this.implemented = implemented;
        this.staticAnalyzability = staticAnalyzability;
        this.cAllocatedTarget = cAllocatedTarget;
        this.ruleSortNumber = ruleSortNumber;
        this.chapterName1 = chapterName1;
        this.chapterName2 = chapterName2;
        this.chapterName3 = chapterName3;
        this.chapterName4 = chapterName4;
        this.descriptionZh = descriptionZh;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getShortDescriptionEn() {
        return shortDescriptionEn;
    }

    @NotNull
    public String getShortDescriptionZh() {
        return shortDescriptionZh;
    }

    @Nullable
    public String getSeverity() {
        return severity;
    }

    @Nullable
    public String getPriority() {
        return priority;
    }

    @NotNull
    public String getLanguage() {
        return language;
    }

    @Nullable
    public String getPrecision() {
        return precision;
    }

    @Nullable
    public String getRecall() {
        return recall;
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
    public String getPerformance() {
        return performance;
    }

    @Nullable
    public Long getConfigurable() {
        return configurable;
    }

    @Nullable
    public Long getImplemented() {
        return implemented;
    }

    @Nullable
    public String getStaticAnalyzability() {
        return staticAnalyzability;
    }

    @Nullable
    public String getCAllocatedTarget() {
        return cAllocatedTarget;
    }

    @NotNull
    public String getCategoryEn() {
        return categoryEn;
    }

    @NotNull
    public String getCategoryZh() {
        return categoryZh;
    }

    @Nullable
    public Long getRuleSortNumber() {
        return ruleSortNumber;
    }

    @Nullable
    public String getChapterName1() {
        return chapterName1;
    }

    @Nullable
    public String getChapterName2() {
        return chapterName2;
    }

    @Nullable
    public String getChapterName3() {
        return chapterName3;
    }

    @Nullable
    public String getChapterName4() {
        return chapterName4;
    }

    @NotNull
    public String getDescriptionEn() {
        return descriptionEn;
    }

    @Nullable
    public String getDescriptionZh() {
        return descriptionZh;
    }

    @NotNull
    public String getDocumentEn() {
        return documentEn;
    }

    @NotNull
    public String getDocumentZh() {
        return documentZh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rule rule = (Rule) o;
        return name.equals(rule.name) &&
                shortDescriptionEn.equals(rule.shortDescriptionEn) &&
                shortDescriptionZh.equals(rule.shortDescriptionZh) &&
                Objects.equals(severity, rule.severity) &&
                Objects.equals(priority, rule.priority) &&
                language.equals(rule.language) &&
                Objects.equals(precision, rule.precision) &&
                Objects.equals(recall, rule.recall) &&
                Objects.equals(likelihood, rule.likelihood) &&
                Objects.equals(impact, rule.impact) &&
                Objects.equals(technique, rule.technique) &&
                Objects.equals(analysisScope, rule.analysisScope) &&
                Objects.equals(performance, rule.performance) &&
                Objects.equals(configurable, rule.configurable) &&
                Objects.equals(implemented, rule.implemented) &&
                Objects.equals(staticAnalyzability, rule.staticAnalyzability) &&
                Objects.equals(cAllocatedTarget, rule.cAllocatedTarget) &&
                categoryEn.equals(rule.categoryEn) &&
                categoryZh.equals(rule.categoryZh) &&
                Objects.equals(ruleSortNumber, rule.ruleSortNumber) &&
                Objects.equals(chapterName1, rule.chapterName1) &&
                Objects.equals(chapterName2, rule.chapterName2) &&
                Objects.equals(chapterName3, rule.chapterName3) &&
                Objects.equals(chapterName4, rule.chapterName4) &&
                descriptionEn.equals(rule.descriptionEn) &&
                Objects.equals(descriptionZh, rule.descriptionZh) &&
                documentEn.equals(rule.documentEn) &&
                documentZh.equals(rule.documentZh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, shortDescriptionEn, shortDescriptionZh, severity, priority, language, 
                precision, recall, likelihood, impact, technique, analysisScope, performance, 
                configurable, implemented, staticAnalyzability, cAllocatedTarget, categoryEn, 
                categoryZh, ruleSortNumber, chapterName1, chapterName2, chapterName3, chapterName4, 
                descriptionEn, descriptionZh, documentEn, documentZh);
    }

    @Override
    public String toString() {
        return "Rule{" +
                "name='" + name + '\'' +
                ", shortDescriptionEn='" + shortDescriptionEn + '\'' +
                ", shortDescriptionZh='" + shortDescriptionZh + '\'' +
                ", severity='" + severity + '\'' +
                ", priority='" + priority + '\'' +
                ", language='" + language + '\'' +
                ", precision='" + precision + '\'' +
                ", recall='" + recall + '\'' +
                ", likelihood='" + likelihood + '\'' +
                ", impact='" + impact + '\'' +
                ", technique='" + technique + '\'' +
                ", analysisScope='" + analysisScope + '\'' +
                ", performance='" + performance + '\'' +
                ", configurable=" + configurable +
                ", implemented=" + implemented +
                ", staticAnalyzability='" + staticAnalyzability + '\'' +
                ", cAllocatedTarget='" + cAllocatedTarget + '\'' +
                ", categoryEn='" + categoryEn + '\'' +
                ", categoryZh='" + categoryZh + '\'' +
                ", ruleSortNumber=" + ruleSortNumber +
                ", chapterName1='" + chapterName1 + '\'' +
                ", chapterName2='" + chapterName2 + '\'' +
                ", chapterName3='" + chapterName3 + '\'' +
                ", chapterName4='" + chapterName4 + '\'' +
                ", descriptionEn='" + descriptionEn + '\'' +
                ", descriptionZh='" + descriptionZh + '\'' +
                ", documentEn='" + documentEn + '\'' +
                ", documentZh='" + documentZh + '\'' +
                '}';
    }

    public Rule copy(@NotNull String name, @NotNull String shortDescriptionEn, @NotNull String shortDescriptionZh, 
                    @Nullable String severity, @Nullable String priority, @NotNull String language, 
                    @Nullable String precision, @Nullable String recall, @Nullable String likelihood, 
                    @Nullable String impact, @Nullable String technique, @Nullable String analysisScope, 
                    @Nullable String performance, @Nullable Long configurable, @Nullable Long implemented, 
                    @Nullable String staticAnalyzability, @Nullable String cAllocatedTarget, @NotNull String categoryEn, 
                    @NotNull String categoryZh, @Nullable Long ruleSortNumber, @Nullable String chapterName1, 
                    @Nullable String chapterName2, @Nullable String chapterName3, @Nullable String chapterName4, 
                    @NotNull String descriptionEn, @Nullable String descriptionZh, @NotNull String documentEn, 
                    @NotNull String documentZh) {
        return new Rule(name, shortDescriptionEn, shortDescriptionZh, severity, priority, language, 
                precision, recall, likelihood, impact, technique, analysisScope, performance, 
                configurable, implemented, staticAnalyzability, cAllocatedTarget, categoryEn, 
                categoryZh, ruleSortNumber, chapterName1, chapterName2, chapterName3, chapterName4, 
                descriptionEn, descriptionZh, documentEn, documentZh);
    }
}