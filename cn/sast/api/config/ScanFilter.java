package cn.sast.api.config;

import cn.sast.common.IResDirectory;
import com.feysh.corax.config.api.rules.ProcessRule;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlin.Pair;


public final class ScanFilter implements MatchContentProvider {
    public static final class Companion {
        private Companion() {}
    }

    public static final Companion Companion = new Companion();
    private static final Json jsonFormat = JsonKt.Json$default(null, ScanFilter::jsonFormat$lambda$3, 1, null);

    private final MainConfig mainConfig;
    private final MatchContentProvider matchContentProvider;
    private ProcessRegex processRegex;
    private final ConcurrentHashMap<String, Set<String>> filterDiagnostics = new ConcurrentHashMap<>();

    public ScanFilter(@NotNull MainConfig mainConfig, @NotNull MatchContentProvider matchContentProvider) {
        if (mainConfig == null) throw new IllegalArgumentException("mainConfig cannot be null");
        if (matchContentProvider == null) throw new IllegalArgumentException("matchContentProvider cannot be null");
        this.mainConfig = mainConfig;
        this.matchContentProvider = matchContentProvider;
    }

    public ScanFilter(@NotNull MainConfig mainConfig) {
        this(mainConfig, new MatchContentProviderImpl(mainConfig));
    }

    public @NotNull MainConfig getMainConfig() {
        return mainConfig;
    }

    public @NotNull ProcessRegex getProcessRegex() {
        if (processRegex == null) throw new IllegalStateException("processRegex not initialized");
        return processRegex;
    }

    public void setProcessRegex(@NotNull ProcessRegex processRegex) {
        if (processRegex == null) throw new IllegalArgumentException("processRegex cannot be null");
        this.processRegex = processRegex;
    }

    public void update(@NotNull ProjectConfig value) {
        if (value == null) throw new IllegalArgumentException("value cannot be null");
        setProcessRegex(value.getProcessRegex());
    }

    private String getShow(ProcessRule.IMatchItem item) {
        return item != null ? item.toString() : "{no matched rule}";
    }

    public @NotNull ProcessRule.ScanAction getActionOf(
            @NotNull List<? extends ProcessRule.IMatchItem> rule,
            @Nullable String origAction,
            @NotNull ProcessRule.IMatchTarget matchTarget,
            @Nullable String prefix) {
        if (rule == null) throw new IllegalArgumentException("rule cannot be null");
        if (matchTarget == null) throw new IllegalArgumentException("matchTarget cannot be null");

        Pair<ProcessRule.IMatchItem, ProcessRule.ScanAction> pair = ProcessRule.INSTANCE.matches(rule, matchTarget);
        ProcessRule.IMatchItem matchedRule = pair.getFirst();
        ProcessRule.ScanAction finalAction = pair.getSecond();

        if (origAction != null) {
            String message = origAction + " -> " + finalAction + ". rule= " + getShow(matchedRule);
            String op = matchedRule != null && matchedRule.getOp() != null ? matchedRule.getOp() : "Keep";
            String pfx = prefix != null ? prefix : "";
            add(message, op + ": " + pfx + " " + matchTarget);
        }

        return finalAction;
    }

    public @NotNull ProcessRule.ScanAction getActionOfClassPath(
            @Nullable String origAction,
            @NotNull Path classpath,
            @Nullable String prefix) {
        if (classpath == null) throw new IllegalArgumentException("classpath cannot be null");
        return getActionOf(getProcessRegex().getClasspathRules(), origAction, getClassPath(classpath), prefix);
    }

    public @NotNull ProcessRule.ScanAction getActionOf(
            @Nullable String origAction,
            @NotNull Path file,
            @Nullable String prefix) {
        if (file == null) throw new IllegalArgumentException("file cannot be null");
        return getActionOf(getProcessRegex().getFileRules(), origAction, get(file), prefix);
    }

    public @NotNull ProcessRule.ScanAction getActionOf(
            @Nullable String origAction,
            @NotNull SootClass sc,
            @Nullable String prefix) {
        if (sc == null) throw new IllegalArgumentException("sc cannot be null");
        return getActionOf(getProcessRegex().getClazzRules(), origAction, get(sc), prefix);
    }

    public @NotNull ProcessRule.ScanAction getActionOf(
            @Nullable String origAction,
            @NotNull SootMethod sm,
            @Nullable String prefix) {
        if (sm == null) throw new IllegalArgumentException("sm cannot be null");
        return getActionOf(getProcessRegex().getClazzRules(), origAction, get(sm), prefix);
    }

    public @NotNull ProcessRule.ScanAction getActionOf(
            @Nullable String origAction,
            @NotNull SootField sf,
            @Nullable String prefix) {
        if (sf == null) throw new IllegalArgumentException("sf cannot be null");
        return getActionOf(getProcessRegex().getClazzRules(), origAction, get(sf), prefix);
    }

    public void add(@NotNull String key, @NotNull String item) {
        if (key == null) throw new IllegalArgumentException("key cannot be null");
        if (item == null) throw new IllegalArgumentException("item cannot be null");

        filterDiagnostics.computeIfAbsent(key, k -> Collections.synchronizedSet(new TreeSet<>()))
                        .add(item);
    }

    public void dump(@NotNull IResDirectory dir) throws IOException {
        if (dir == null) throw new IllegalArgumentException("dir cannot be null");
        
        dir.mkdirs();
        Path outputPath = dir.resolve("scan-classifier-info.json").getPath();
        try (OutputStream outputStream = Files.newOutputStream(outputPath)) {
            JvmStreamsKt.encodeToStream(
                jsonFormat,
                ClassFilerRecord.Companion.serializer(),
                new ClassFilerRecord(new TreeMap<>(filterDiagnostics)),
                outputStream
            );
        }
    }

    @Override
    public @NotNull ProcessRule.FileMatch.MatchTarget get(@NotNull Path file) {
        if (file == null) throw new IllegalArgumentException("file cannot be null");
        return matchContentProvider.get(file);
    }

    @Override
    public @NotNull ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootField sf) {
        if (sf == null) throw new IllegalArgumentException("sf cannot be null");
        return matchContentProvider.get(sf);
    }

    @Override
    public @NotNull ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootMethod sm) {
        if (sm == null) throw new IllegalArgumentException("sm cannot be null");
        return matchContentProvider.get(sm);
    }

    @Override
    public @NotNull ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootClass sc) {
        if (sc == null) throw new IllegalArgumentException("sc cannot be null");
        return matchContentProvider.get(sc);
    }

    @Override
    public @NotNull ProcessRule.ClassPathMatch.MatchTarget getClassPath(@NotNull Path classpath) {
        if (classpath == null) throw new IllegalArgumentException("classpath cannot be null");
        return matchContentProvider.getClassPath(classpath);
    }

    private static Unit jsonFormat$lambda$3(JsonBuilder builder) {
        if (builder == null) throw new IllegalArgumentException("builder cannot be null");
        builder.setUseArrayPolymorphism(true);
        builder.setPrettyPrint(true);
        return Unit.INSTANCE;
    }

    public static final class ClassFilerRecord {
        public static final class Companion {
            private Companion() {}
            public static SerializationStrategy<ClassFilerRecord> serializer() {
                // Implementation omitted
            }
        }

        public static final Companion Companion = new Companion();
        private final Map<String, Set<String>> diagnostics;

        public ClassFilerRecord(Map<String, Set<String>> diagnostics) {
            this.diagnostics = diagnostics;
        }

        public Map<String, Set<String>> getDiagnostics() {
            return diagnostics;
        }
    }
}
