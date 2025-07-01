package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public final class RuleSetInfo {
    @NotNull
    private final String name;
    @NotNull
    private final String language;
    @Nullable
    private final String description;
    @Nullable
    private final String prefix;
    @Nullable
    private final String idPattern;
    @Nullable
    private final Long sectionLevel;
    @NotNull
    private final String version;
    @NotNull
    private final String revision;

    public RuleSetInfo(@NotNull String name, @NotNull String language, @Nullable String description,
                      @Nullable String prefix, @Nullable String idPattern, @Nullable Long sectionLevel,
                      @NotNull String version, @NotNull String revision) {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(language, "language must not be null");
        Objects.requireNonNull(version, "version must not be null");
        Objects.requireNonNull(revision, "revision must not be null");
        this.name = name;
        this.language = language;
        this.description = description;
        this.prefix = prefix;
        this.idPattern = idPattern;
        this.sectionLevel = sectionLevel;
        this.version = version;
        this.revision = revision;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getLanguage() {
        return language;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Nullable
    public String getPrefix() {
        return prefix;
    }

    @Nullable
    public String getIdPattern() {
        return idPattern;
    }

    @Nullable
    public Long getSectionLevel() {
        return sectionLevel;
    }

    @NotNull
    public String getVersion() {
        return version;
    }

    @NotNull
    public String getRevision() {
        return revision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RuleSetInfo)) return false;
        RuleSetInfo that = (RuleSetInfo) o;
        return name.equals(that.name) &&
                language.equals(that.language) &&
                Objects.equals(description, that.description) &&
                Objects.equals(prefix, that.prefix) &&
                Objects.equals(idPattern, that.idPattern) &&
                Objects.equals(sectionLevel, that.sectionLevel) &&
                version.equals(that.version) &&
                revision.equals(that.revision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, language, description, prefix, idPattern, sectionLevel, version, revision);
    }

    @Override
    public String toString() {
        return "RuleSetInfo{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                ", prefix='" + prefix + '\'' +
                ", idPattern='" + idPattern + '\'' +
                ", sectionLevel=" + sectionLevel +
                ", version='" + version + '\'' +
                ", revision='" + revision + '\'' +
                '}';
    }

    @NotNull
    public RuleSetInfo copy(@NotNull String name, @NotNull String language, @Nullable String description,
                          @Nullable String prefix, @Nullable String idPattern, @Nullable Long sectionLevel,
                          @NotNull String version, @NotNull String revision) {
        return new RuleSetInfo(
                Objects.requireNonNull(name, "name must not be null"),
                Objects.requireNonNull(language, "language must not be null"),
                description,
                prefix,
                idPattern,
                sectionLevel,
                Objects.requireNonNull(version, "version must not be null"),
                Objects.requireNonNull(revision, "revision must not be null")
        );
    }
}