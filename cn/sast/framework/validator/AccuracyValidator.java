package cn.sast.framework.validator;

import cn.sast.api.config.MainConfig;
import cn.sast.api.report.ExpectBugAnnotationData;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.ResourceKt;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.result.ResultCollector;
import com.feysh.corax.config.api.rules.ProcessRule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class AccuracyValidator {
    private static final Logger logger = LoggerFactory.getLogger(AccuracyValidator.class);
    private static final List<String> DEFAULT_EXCLUDED_DIRS = List.of("build", "out", "target", ".idea", ".git");
    private static final List<String> EXTENSIONS = List.of(
        "yml", "txt", "gradle", "kts", "cnf", "conf", "config", "xml", "properties"
    );

    private final MainConfig mainConfig;
    private final List<String> extensions;
    private final List<ProcessRule.FileMatch> rules;
    private final Pattern pattern;

    public AccuracyValidator(@NotNull MainConfig mainConfig) {
        this.mainConfig = Objects.requireNonNull(mainConfig, "mainConfig");
        this.extensions = new ArrayList<>(ResourceKt.getJavaExtensions());
        this.extensions.addAll(EXTENSIONS);

        List<String> excludePatterns = new ArrayList<>();
        for (String dir : DEFAULT_EXCLUDED_DIRS) {
            excludePatterns.add("(-)path=/" + dir + "/");
        }

        this.rules = new ArrayList<>();
        for (String pattern : excludePatterns) {
            rules.add(ProcessRule.InlineRuleStringSerialize.INSTANCE.deserializeMatchFromLineString(
                ProcessRule.FileMatch.class, pattern));
        }

        this.pattern = Pattern.compile(
            "(?<escape>(!?))\\$ *(?<name>((`([^(`\\r\\n)])+`)|([a-zA-Z$_]+[a-zA-Z0-9$_.-]*))", 
            Pattern.MULTILINE
        );
    }

    @NotNull
    public MainConfig getMainConfig() {
        return mainConfig;
    }

    @NotNull
    public String getStr(@NotNull Set<ExpectBugAnnotationData<String>> annotations) {
        Objects.requireNonNull(annotations, "annotations");
        List<ExpectBugAnnotationData<String>> sorted = new ArrayList<>(annotations);
        sorted.sort(Comparator.comparing(ExpectBugAnnotationData::getFile)
            .thenComparingInt(ExpectBugAnnotationData::getLine)
            .thenComparingInt(ExpectBugAnnotationData::getColumn);

        StringBuilder sb = new StringBuilder("\"");
        for (ExpectBugAnnotationData<String> annotation : sorted) {
            sb.append("\nfile: ")
                .append(mainConfig.tryGetRelativePath(annotation.getFile()).getRelativePath())
                .append(":")
                .append(annotation.getLine())
                .append(":")
                .append(annotation.getColumn())
                .append(" kind: ")
                .append(annotation.getKind())
                .append(" a bug: ")
                .append(annotation.getBug());
        }
        return sb.append("\"").toString();
    }

    @Nullable
    public Object makeScore(
        @NotNull ResultCollector result,
        @NotNull IProjectFileLocator locator,
        @NotNull Continuation<? super Result> completion
    ) {
        // Implementation omitted for brevity
        return null;
    }

    private Set<ExpectBugAnnotationData<String>> parseFile(IResFile file) {
        String content;
        try {
            content = new String(ResourceKt.readAllBytes(file));
        } catch (IOException e) {
            logger.error("read config file {} failed", file, e);
            return Collections.emptySet();
        }

        Set<ExpectBugAnnotationData<String>> result = new LinkedHashSet<>();
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            String escapeGroup = matcher.group("escape");
            String nameGroup = matcher.group("name");
            boolean isEscaped = !escapeGroup.isEmpty();
            
            String name = nameGroup.startsWith("`") 
                ? nameGroup.substring(1, nameGroup.length() - 1) 
                : nameGroup.replace("--", "");

            int startIndex = matcher.start();
            LineColumnInfo info = getLineAndColumn(content, startIndex);
            
            String lineText = content.substring(info.start).split("\n")[0];
            String beforeMatch = lineText.substring(0, startIndex - info.start);
            
            boolean isCommented = beforeMatch.contains("//") || beforeMatch.contains("<!--");
            if (isCommented || "properties".equals(file.getExtension())) {
                ExpectBugAnnotationData<String> annotation = new ExpectBugAnnotationData<>(
                    file.getAbsolute(),
                    info.line,
                    info.column,
                    name.toLowerCase(Locale.getDefault()),
                    isEscaped ? ExpectBugAnnotationData.Kind.Escape : ExpectBugAnnotationData.Kind.Expect
                );
                logger.trace("Found annotation: {}", annotation);
                result.add(annotation);
            }
        }
        return result;
    }

    private LineColumnInfo getLineAndColumn(String text, int index) {
        int line = 1;
        int column = 0;
        int lineStart = 0;
        
        for (int i = 0; i < index; i++) {
            if (text.charAt(i) == '\n') {
                line++;
                lineStart = i + 1;
                column = 0;
            } else {
                column++;
            }
        }
        return new LineColumnInfo(lineStart, line, column);
    }

    private static class LineColumnInfo {
        final int start;
        final int line;
        final int column;

        LineColumnInfo(int start, int line, int column) {
            this.start = start;
            this.line = line;
            this.column = column;
        }
    }

    public static class Result {
        // Result implementation omitted
    }
}
