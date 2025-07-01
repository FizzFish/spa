package cn.sast.api.config;

import java.util.List;
import java.util.Map;

import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
public final class CheckerInfo {
    @NotNull
    private final String type;
    @NotNull
    private final String formatVersion;
    @NotNull
    private final String analyzer;
    @NotNull
    private final String language;
    @NotNull
    private final String checkerId;
    @NotNull
    private final String severity;
    @NotNull
    private final Map<String, String> category;
    @NotNull
    private final Map<String, String> name;
    @NotNull
    private final Map<String, String> abstractDesc;
    @NotNull
    private final Map<String, String> description;
    @NotNull
    private final List<Tag> tags;
    @Nullable
    private final String impact;
    @Nullable
    private final String likelihood;
    @Nullable
    private final String precision;
    @Nullable
    private final String reCall;
    @Nullable
    private final String impl;
    @Nullable
    private final Boolean implemented;

    public CheckerInfo(
            @NotNull String type,
            @NotNull String formatVersion,
            @NotNull String analyzer,
            @NotNull String language,
            @NotNull String checkerId,
            @NotNull String severity,
            @NotNull Map<String, String> category,
            @NotNull Map<String, String> name,
            @NotNull Map<String, String> abstractDesc,
            @NotNull Map<String, String> description,
            @NotNull List<Tag> tags,
            @Nullable String impact,
            @Nullable String likelihood,
            @Nullable String precision,
            @Nullable String reCall,
            @Nullable String impl,
            @Nullable Boolean implemented) {
        this.type = type;
        this.formatVersion = formatVersion;
        this.analyzer = analyzer;
        this.language = language;
        this.checkerId = checkerId;
        this.severity = severity;
        this.category = category;
        this.name = name;
        this.abstractDesc = abstractDesc;
        this.description = description;
        this.tags = tags;
        this.impact = impact;
        this.likelihood = likelihood;
        this.precision = precision;
        this.reCall = reCall;
        this.impl = impl;
        this.implemented = implemented;
    }

    @NotNull
    public String getType() {
        return type;
    }

    @NotNull
    public String getFormatVersion() {
        return formatVersion;
    }

    @NotNull
    public String getAnalyzer() {
        return analyzer;
    }

    @NotNull
    public String getLanguage() {
        return language;
    }

    @NotNull
    public String getCheckerId() {
        return checkerId;
    }

    @NotNull
    public String getSeverity() {
        return severity;
    }

    @NotNull
    public Map<String, String> getCategory() {
        return category;
    }

    @NotNull
    public Map<String, String> getName() {
        return name;
    }

    @NotNull
    public Map<String, String> getAbstractDesc() {
        return abstractDesc;
    }

    @NotNull
    public Map<String, String> getDescription() {
        return description;
    }

    @NotNull
    public List<Tag> getTags() {
        return tags;
    }

    @Nullable
    public String getImpact() {
        return impact;
    }

    @Nullable
    public String getLikelihood() {
        return likelihood;
    }

    @Nullable
    public String getPrecision() {
        return precision;
    }

    @Nullable
    public String getReCall() {
        return reCall;
    }

    @Nullable
    public String getImpl() {
        return impl;
    }

    @Nullable
    public Boolean getImplemented() {
        return implemented;
    }

    @Nullable
    public ChapterFlat getChapterFlat() {
        String categoryZh = category.get("zh-CN");
        return categoryZh != null ? new ChapterFlat(categoryZh, severity, checkerId) : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckerInfo)) return false;
        CheckerInfo that = (CheckerInfo) o;
        return type.equals(that.type) &&
                formatVersion.equals(that.formatVersion) &&
                analyzer.equals(that.analyzer) &&
                language.equals(that.language) &&
                checkerId.equals(that.checkerId) &&
                severity.equals(that.severity) &&
                category.equals(that.category) &&
                name.equals(that.name) &&
                abstractDesc.equals(that.abstractDesc) &&
                description.equals(that.description) &&
                tags.equals(that.tags) &&
                (impact != null ? impact.equals(that.impact) : that.impact == null) &&
                (likelihood != null ? likelihood.equals(that.likelihood) : that.likelihood == null) &&
                (precision != null ? precision.equals(that.precision) : that.precision == null) &&
                (reCall != null ? reCall.equals(that.reCall) : that.reCall == null) &&
                (impl != null ? impl.equals(that.impl) : that.impl == null) &&
                (implemented != null ? implemented.equals(that.implemented) : that.implemented == null);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + formatVersion.hashCode();
        result = 31 * result + analyzer.hashCode();
        result = 31 * result + language.hashCode();
        result = 31 * result + checkerId.hashCode();
        result = 31 * result + severity.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + abstractDesc.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + tags.hashCode();
        result = 31 * result + (impact != null ? impact.hashCode() : 0);
        result = 31 * result + (likelihood != null ? likelihood.hashCode() : 0);
        result = 31 * result + (precision != null ? precision.hashCode() : 0);
        result = 31 * result + (reCall != null ? reCall.hashCode() : 0);
        result = 31 * result + (impl != null ? impl.hashCode() : 0);
        result = 31 * result + (implemented != null ? implemented.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CheckerInfo{" +
                "type='" + type + '\'' +
                ", formatVersion='" + formatVersion + '\'' +
                ", analyzer='" + analyzer + '\'' +
                ", language='" + language + '\'' +
                ", checkerId='" + checkerId + '\'' +
                ", severity='" + severity + '\'' +
                ", category=" + category +
                ", name=" + name +
                ", abstractDesc=" + abstractDesc +
                ", description=" + description +
                ", tags=" + tags +
                ", impact='" + impact + '\'' +
                ", likelihood='" + likelihood + '\'' +
                ", precision='" + precision + '\'' +
                ", reCall='" + reCall + '\'' +
                ", impl='" + impl + '\'' +
                ", implemented=" + implemented +
                '}';
    }

    public static final class Companion {
        private Companion() {}
    }
}
