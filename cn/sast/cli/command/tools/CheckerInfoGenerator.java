package cn.sast.cli.command.tools;

import cn.sast.api.config.ChapterFlat;
import cn.sast.api.config.CheckerInfo;
import cn.sast.api.config.CheckerInfoGenResult;
import cn.sast.api.config.CheckerPriorityConfig;
import cn.sast.api.config.MainConfigKt;
import cn.sast.api.config.Tag;
import cn.sast.cli.command.tools.CheckerInfoGeneratorKt;
import cn.sast.common.Resource;
import cn.sast.framework.plugin.PluginDefinitions;
import cn.sast.framework.report.RuleAndRuleMapping;
import cn.sast.framework.report.SQLiteDB;
import cn.sast.framework.report.SqliteDiagnostics;
import com.charleskorn.kaml.Yaml;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.Language;
import com.github.ajalt.mordant.rendering.Theme;
import com.github.doyaaaaaken.kotlincsv.client.CsvFileReader;
import com.github.doyaaaaaken.kotlincsv.client.CsvReader;
import com.github.doyaaaaaken.kotlincsv.dsl.CsvReaderDslKt;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.path.PathsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JvmStreamsKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class CheckerInfoGenerator {
    public enum HintEnum {
        MARKDOWN, ABSTRACT, PHANTOM_MARKDOWN, PHANTOM_ABSTRACT
    }

    @NotNull
    private final List<String> language;
    @NotNull
    private final Path output;
    @NotNull
    private final Path checkerInfoResRoot;
    @NotNull
    private final PluginDefinitions pluginDefinitions;
    @NotNull
    private final List<Object> errors = new ArrayList<>();
    @NotNull
    private final List<Object> warnings = new ArrayList<>();

    private static final KLogger logger = KotlinLogging.INSTANCE.logger("CheckerInfoGenerator");
    private static final Json jsonFormat = JsonKt.Json(builder -> {
        builder.setUseArrayPolymorphism(true);
        builder.setPrettyPrint(true);
        return Unit.INSTANCE;
    });
    private static final Yaml yamlFormat = new Yaml(null, MainConfigKt.getYamlConfiguration(), 1, null);
    private static final KSerializer<List<CheckerInfo>> infoSerializer = BuiltinSerializersKt.ListSerializer(CheckerInfo.Companion.serializer());

    public CheckerInfoGenerator(@NotNull List<String> language, @NotNull Path output, 
                              @NotNull Path checkerInfoResRoot, @NotNull PluginDefinitions pluginDefinitions) {
        this.language = language;
        this.output = output;
        this.checkerInfoResRoot = checkerInfoResRoot;
        this.pluginDefinitions = pluginDefinitions;
    }

    private Path getCheckerInfoJsonOutPath() {
        return checkerInfoResRoot.resolve("checker_info.json").normalize();
    }

    private Path getCheckerInfoSqliteDBOutPath() {
        return checkerInfoResRoot.resolve("checker_info.db").normalize();
    }

    private Path getRuleChaptersYamlOutPath() {
        return checkerInfoResRoot.resolve("rule_chapters.yaml").normalize();
    }

    private Path getRuleChaptersSortNumberYamlOutPath() {
        return checkerInfoResRoot.resolve("rule_chapters_sort_number.yaml").normalize();
    }

    private Path getDescriptionsPath() {
        return checkerInfoResRoot.resolve("descriptions");
    }

    private Path getCheckerInfoCsvPath() {
        return checkerInfoResRoot.resolve("checker_info.csv");
    }

    private Path getCategoryLanguageMapCsv() {
        return checkerInfoResRoot.resolve("category.translation.csv");
    }

    private Path getStandardNameMappingJson() {
        return checkerInfoResRoot.resolve("checker_info_ruleset_to_server_standard_name_mapping.json");
    }

    @NotNull
    public Path getRuleSortPath() {
        return checkerInfoResRoot.resolve("rule_sort.yaml").normalize();
    }

    private String getSuffixOfLang(String lang) {
        return "." + lang;
    }

    private Path getMarkdown(String checkerId, String lang) {
        return getDescriptionsPath().resolve(checkerId + getSuffixOfLang(lang) + ".md");
    }

    private Path getAbstraction(String checkerId, String lang) {
        return getDescriptionsPath().resolve(checkerId + getSuffixOfLang(lang) + ".txt");
    }

    private void dumpExistsCheckerIds(List<String> existsCheckerIds) {
        Path path = output.resolve("exists-checker-id.json");
        try (OutputStream outputStream = Files.newOutputStream(path)) {
            JvmStreamsKt.encodeToStream(jsonFormat, 
                BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(String.class)),
                existsCheckerIds, outputStream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to write exists-checker-id.json", e);
        }
    }

    private void validateBugMessageLanguage(List<? extends CheckType> checkTypes) {
        for (CheckType checkType : checkTypes) {
            if (!checkType.getBugMessage().containsKey(Language.EN) || 
                !checkType.getBugMessage().containsKey(Language.ZH)) {
                throw new IllegalStateException("Missing language ZH or EN: " + checkType);
            }
        }
    }

    private String getMessage(String lang, HintEnum msg) {
        switch (msg) {
            case MARKDOWN:
                return lang.equals("zh-CN") ? 
                    "请添加此规则对应的描述或修复建议到" : 
                    "Please add a description or remediation suggestion for this rule at";
            case ABSTRACT:
                return lang.equals("zh-CN") ? 
                    "请添加此规则对应的规则的摘要" : 
                    "Please add a abstract short-description of the rule";
            case PHANTOM_MARKDOWN:
                return lang.equals("zh-CN") ? 
                    "规则的markdown格式的漏洞描述文档" : 
                    "Description & Fix Suggestions for Vulnerabilities in Markdown Format";
            case PHANTOM_ABSTRACT:
                return lang.equals("zh-CN") ? 
                    "规则的摘要描述" : 
                    "Abstract Short-Description of Rule";
            default:
                throw new IllegalStateException("Unexpected hint enum: " + msg);
        }
    }

    // ... (other methods similarly refactored)

    @NotNull
    public CheckerInfoGenResult getCheckerInfo(boolean abortOnError) {
        List<CheckType> checkTypes = pluginDefinitions.getCheckTypeDefinition(CheckType.class).stream()
            .map(PluginDefinitions.CheckTypeDefinition::getSingleton)
            .sorted(Comparator.comparing(CheckerInfoGeneratorKt::getId))
            .collect(Collectors.toList());

        validateBugMessageLanguage(checkTypes);

        LinkedHashSet<String> existsCheckerIds = checkTypes.stream()
            .map(CheckerInfoGeneratorKt::getId)
            .collect(Collectors.toCollection(LinkedHashSet::new));

        logger.info(() -> "Found " + existsCheckerIds.size() + " CheckTypes");

        for (String lang : language) {
            validateDescription(lang, getSuffixOfLang(lang) + ".md", checkTypes, HintEnum.MARKDOWN, HintEnum.PHANTOM_MARKDOWN);
            validateDescription(lang, getSuffixOfLang(lang) + ".txt", checkTypes, HintEnum.ABSTRACT, HintEnum.PHANTOM_ABSTRACT);
        }

        checkAndAbort(abortOnError);

        Pair<LinkedHashSet<CheckerInfo>, LinkedHashSet<String>> pair = getCheckerInfoList(existsCheckerIds);
        LinkedHashSet<CheckerInfo> checkerInfoList = pair.getFirst();
        LinkedHashSet<String> checkerIdInCsv = pair.getSecond();

        checkAndAbort(abortOnError);
        validateCheckerIdAliasName(existsCheckerIds);
        checkAndAbort(abortOnError);

        return new CheckerInfoGenResult(checkerInfoList, new LinkedHashSet<>(checkTypes), existsCheckerIds, checkerIdInCsv);
    }

    // ... (remaining methods similarly refactored)
}
