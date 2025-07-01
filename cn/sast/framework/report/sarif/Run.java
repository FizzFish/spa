package cn.sast.framework.report.sarif;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public final class Run {
    @NotNull private final Tool tool;
    @NotNull private final Map<String, UriBase> originalUriBaseIds;
    @NotNull private final List<Result> results;
    @NotNull private final List<TranslationToolComponent> translations;

    public Run(@NotNull Tool tool, 
               @NotNull Map<String, UriBase> originalUriBaseIds,
               @NotNull List<Result> results,
               @NotNull List<TranslationToolComponent> translations) {
        if (tool == null) throw new IllegalArgumentException("tool cannot be null");
        if (originalUriBaseIds == null) throw new IllegalArgumentException("originalUriBaseIds cannot be null");
        if (results == null) throw new IllegalArgumentException("results cannot be null");
        if (translations == null) throw new IllegalArgumentException("translations cannot be null");

        this.tool = tool;
        this.originalUriBaseIds = originalUriBaseIds;
        this.results = results;
        this.translations = translations;
    }

    public Run(@NotNull Tool tool, @NotNull List<Result> results, @NotNull List<TranslationToolComponent> translations) {
        this(tool, Collections.emptyMap(), results, translations);
    }

    @NotNull
    public Tool getTool() {
        return tool;
    }

    @NotNull
    public Map<String, UriBase> getOriginalUriBaseIds() {
        return originalUriBaseIds;
    }

    @NotNull
    public List<Result> getResults() {
        return results;
    }

    @NotNull
    public List<TranslationToolComponent> getTranslations() {
        return translations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Run)) return false;
        Run run = (Run) o;
        return tool.equals(run.tool) &&
               originalUriBaseIds.equals(run.originalUriBaseIds) &&
               results.equals(run.results) &&
               translations.equals(run.translations);
    }

    @Override
    public int hashCode() {
        int result = tool.hashCode();
        result = 31 * result + originalUriBaseIds.hashCode();
        result = 31 * result + results.hashCode();
        result = 31 * result + translations.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Run(tool=" + tool + 
               ", originalUriBaseIds=" + originalUriBaseIds + 
               ", results=" + results + 
               ", translations=" + translations + ")";
    }

    public static class Builder {
        private Tool tool;
        private Map<String, UriBase> originalUriBaseIds = Collections.emptyMap();
        private List<Result> results;
        private List<TranslationToolComponent> translations;

        public Builder(@NotNull Tool tool) {
            this.tool = tool;
        }

        public Builder originalUriBaseIds(@NotNull Map<String, UriBase> originalUriBaseIds) {
            this.originalUriBaseIds = originalUriBaseIds;
            return this;
        }

        public Builder results(@NotNull List<Result> results) {
            this.results = results;
            return this;
        }

        public Builder translations(@NotNull List<TranslationToolComponent> translations) {
            this.translations = translations;
            return this;
        }

        public Run build() {
            return new Run(tool, originalUriBaseIds, results, translations);
        }
    }
}