package cn.sast.api.config;

import com.feysh.corax.config.api.rules.ProcessRule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class ProcessRegex {
    @NotNull
    private final List<ProcessRule.ClassMemberMatch> clazzRules;
    @NotNull
    private final List<ProcessRule.ClassPathMatch> classpathRules;
    @NotNull
    private final List<ProcessRule.FileMatch> fileRules;

    public ProcessRegex(
            @NotNull List<ProcessRule.ClassMemberMatch> clazzRules,
            @NotNull List<ProcessRule.ClassPathMatch> classpathRules,
            @NotNull List<ProcessRule.FileMatch> fileRules) {
        if (clazzRules == null) throw new IllegalArgumentException("clazzRules cannot be null");
        if (classpathRules == null) throw new IllegalArgumentException("classpathRules cannot be null");
        if (fileRules == null) throw new IllegalArgumentException("fileRules cannot be null");

        this.clazzRules = clazzRules;
        this.classpathRules = classpathRules;
        this.fileRules = fileRules;

        ProjectConfigKt.validate(this.clazzRules);
        ProjectConfigKt.validate(this.classpathRules);
        ProjectConfigKt.validate(this.fileRules);
    }

    public ProcessRegex() {
        this(Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    @NotNull
    public List<ProcessRule.ClassMemberMatch> getClazzRules() {
        return clazzRules;
    }

    @NotNull
    public List<ProcessRule.ClassPathMatch> getClasspathRules() {
        return classpathRules;
    }

    @NotNull
    public List<ProcessRule.FileMatch> getFileRules() {
        return fileRules;
    }

    @NotNull
    public ProcessRegex copy(
            @NotNull List<ProcessRule.ClassMemberMatch> clazzRules,
            @NotNull List<ProcessRule.ClassPathMatch> classpathRules,
            @NotNull List<ProcessRule.FileMatch> fileRules) {
        return new ProcessRegex(clazzRules, classpathRules, fileRules);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof ProcessRegex)) return false;
        ProcessRegex that = (ProcessRegex) other;
        return clazzRules.equals(that.clazzRules) &&
               classpathRules.equals(that.classpathRules) &&
               fileRules.equals(that.fileRules);
    }

    @Override
    public int hashCode() {
        int result = clazzRules.hashCode();
        result = 31 * result + classpathRules.hashCode();
        result = 31 * result + fileRules.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProcessRegex(clazzRules=" + clazzRules + 
               ", classpathRules=" + classpathRules + 
               ", fileRules=" + fileRules + ")";
    }
}
