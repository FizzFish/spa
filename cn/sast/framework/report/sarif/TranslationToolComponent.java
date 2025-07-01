package cn.sast.framework.report.sarif;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TranslationToolComponent {
    @NotNull private final String language;
    @NotNull private final String name;
    @NotNull private final List<Rule> rules;

    public TranslationToolComponent(@NotNull String language, @NotNull String name, @NotNull List<Rule> rules) {
        if (language == null) throw new IllegalArgumentException("language cannot be null");
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        if (rules == null) throw new IllegalArgumentException("rules cannot be null");
        this.language = language;
        this.name = name;
        this.rules = rules;
    }

    @NotNull
    public String getLanguage() {
        return language;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public List<Rule> getRules() {
        return rules;
    }

    @NotNull
    public TranslationToolComponent copy(@NotNull String language, @NotNull String name, @NotNull List<Rule> rules) {
        if (language == null) throw new IllegalArgumentException("language cannot be null");
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        if (rules == null) throw new IllegalArgumentException("rules cannot be null");
        return new TranslationToolComponent(language, name, rules);
    }

    @Override
    public String toString() {
        return "TranslationToolComponent(language=" + language + ", name=" + name + ", rules=" + rules + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof TranslationToolComponent)) return false;
        TranslationToolComponent that = (TranslationToolComponent) other;
        return language.equals(that.language) && 
               name.equals(that.name) && 
               rules.equals(that.rules);
    }

    @Override
    public int hashCode() {
        int result = language.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + rules.hashCode();
        return result;
    }
}