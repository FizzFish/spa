/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ChapterFlat
 *  cn.sast.api.config.CheckerInfo
 *  cn.sast.api.config.CheckerInfoGenResult
 *  cn.sast.api.config.CheckerPriorityConfig
 *  cn.sast.api.config.MainConfigKt
 *  cn.sast.api.config.Tag
 *  cn.sast.cli.command.tools.CheckerInfoGenerator
 *  cn.sast.cli.command.tools.CheckerInfoGenerator$Companion
 *  cn.sast.cli.command.tools.CheckerInfoGenerator$HintEnum
 *  cn.sast.cli.command.tools.CheckerInfoGenerator$WhenMappings
 *  cn.sast.cli.command.tools.CheckerInfoGeneratorKt
 *  cn.sast.common.Resource
 *  cn.sast.framework.plugin.PluginDefinitions
 *  cn.sast.framework.plugin.PluginDefinitions$CheckTypeDefinition
 *  cn.sast.framework.report.RuleAndRuleMapping
 *  cn.sast.framework.report.SQLiteDB
 *  cn.sast.framework.report.SqliteDiagnostics
 *  cn.sast.framework.report.SqliteDiagnostics$Companion
 *  com.charleskorn.kaml.Yaml
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.api.Language
 *  com.github.ajalt.mordant.rendering.Theme
 *  com.github.doyaaaaaken.kotlincsv.client.CsvFileReader
 *  com.github.doyaaaaaken.kotlincsv.client.CsvReader
 *  com.github.doyaaaaaken.kotlincsv.dsl.CsvReaderDslKt
 *  com.google.gson.Gson
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IndexedValue
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.io.CloseableKt
 *  kotlin.io.path.PathsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.StringCompanionObject
 *  kotlin.ranges.RangesKt
 *  kotlin.sequences.Sequence
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  kotlinx.serialization.DeserializationStrategy
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.builtins.BuiltinSerializersKt
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.IntSerializer
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.StringSerializer
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JsonBuilder
 *  kotlinx.serialization.json.JsonKt
 *  kotlinx.serialization.json.JvmStreamsKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.cli.command.tools;

import cn.sast.api.config.ChapterFlat;
import cn.sast.api.config.CheckerInfo;
import cn.sast.api.config.CheckerInfoGenResult;
import cn.sast.api.config.CheckerPriorityConfig;
import cn.sast.api.config.MainConfigKt;
import cn.sast.api.config.Tag;
import cn.sast.cli.command.tools.CheckerInfoGenerator;
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
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.invoke.CallSite;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.io.path.PathsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
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

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Z2\u00020\u0001:\u0002YZB-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0018\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0018\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0016\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0016\u0010+\u001a\u00020)2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0003H\u0002J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010/\u001a\u000200H\u0002J6\u00101\u001a\u00020)2\u0006\u0010$\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\f\u0010*\u001a\b\u0012\u0004\u0012\u00020-0\u00032\u0006\u00103\u001a\u0002002\u0006\u00104\u001a\u000200H\u0002J$\u00105\u001a\u0002062\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004082\u0006\u00109\u001a\u00020\u0004H\u0002J,\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u00012\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004082\u0006\u00109\u001a\u00020\u0004H\u0002JB\u0010<\u001a\u0004\u0018\u00010\u00042\u0006\u0010;\u001a\u00020\u00012\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004082\u0006\u00109\u001a\u00020\u00042\u0012\b\u0002\u0010=\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010>H\u0002JJ\u0010?\u001a.\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020B0Aj\b\u0012\u0004\u0012\u00020B`C\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040Aj\b\u0012\u0004\u0012\u00020\u0004`C0@2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00040Aj\b\u0012\u0004\u0012\u00020\u0004`CJ.\u0010D\u001a\u00020)2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040F2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00040Aj\b\u0012\u0004\u0012\u00020\u0004`CH\u0002J\u0019\u0010G\u001a\u0004\u0018\u0001062\b\u0010H\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0002\u0010IJ,\u0010J\u001a\u00020)2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004082\u0006\u0010&\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0004H\u0002J\u0010\u0010L\u001a\u0002062\u0006\u0010M\u001a\u00020\u0004H\u0002J\u0010\u0010N\u001a\u00020)2\u0006\u0010O\u001a\u000206H\u0002J\u000e\u0010P\u001a\u00020)2\u0006\u0010Q\u001a\u00020RJ\u0018\u0010S\u001a\u00020)2\u0006\u0010T\u001a\u00020R2\b\b\u0002\u0010O\u001a\u000206J\u001e\u0010U\u001a\u00020)2\u0006\u0010T\u001a\u00020R2\u000e\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010FJ\u0010\u0010W\u001a\u00020R2\b\b\u0002\u0010O\u001a\u000206J\u0016\u0010X\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040FH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\n \r*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\n \r*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u001c\u0010\u0018\u001a\n \r*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u001a\u001a\n \r*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u001c\u001a\n \r*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u000fR\u0011\u0010\u001e\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u000fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010!X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006[\u00b2\u0006\u0010\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0003X\u008a\u0084\u0002\u00b2\u0006\u001a\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00040Aj\b\u0012\u0004\u0012\u00020\u0004`CX\u008a\u0084\u0002"}, d2={"Lcn/sast/cli/command/tools/CheckerInfoGenerator;", "", "language", "", "", "output", "Ljava/nio/file/Path;", "checkerInfoResRoot", "pluginDefinitions", "Lcn/sast/framework/plugin/PluginDefinitions;", "<init>", "(Ljava/util/List;Ljava/nio/file/Path;Ljava/nio/file/Path;Lcn/sast/framework/plugin/PluginDefinitions;)V", "checkerInfoJsonOutPath", "kotlin.jvm.PlatformType", "getCheckerInfoJsonOutPath", "()Ljava/nio/file/Path;", "checkerInfoSqliteDBOutPath", "getCheckerInfoSqliteDBOutPath", "ruleChaptersYamlOutPath", "getRuleChaptersYamlOutPath", "ruleChaptersSortNumberYamlOutPath", "getRuleChaptersSortNumberYamlOutPath", "descriptionsPath", "getDescriptionsPath", "checkerInfoCsvPath", "getCheckerInfoCsvPath", "categoryLanguageMapCsv", "getCategoryLanguageMapCsv", "standardNameMappingJson", "getStandardNameMappingJson", "ruleSortPath", "getRuleSortPath", "errors", "", "warnings", "getSuffixOfLang", "lang", "getMarkdown", "checkerId", "getAbstraction", "dumpExistsCheckerIds", "", "existsCheckerIds", "validateBugMessageLanguage", "checkTypes", "Lcom/feysh/corax/config/api/CheckType;", "getMessage", "msg", "Lcn/sast/cli/command/tools/CheckerInfoGenerator$HintEnum;", "validateDescription", "suffix", "kind", "phantom", "isValid", "", "row", "", "key", "getValueFromRow", "file", "getValueFromRowOrNull", "defaultValue", "Lkotlin/Function0;", "getCheckerInfoList", "Lkotlin/Pair;", "Ljava/util/LinkedHashSet;", "Lcn/sast/api/config/CheckerInfo;", "Lkotlin/collections/LinkedHashSet;", "dumpCheckerInfoJsonFile", "checkerIdInCsv", "", "toBoolean", "value", "(Ljava/lang/String;)Ljava/lang/Boolean;", "validateLanguageMapToContext", "map", "containsChinese", "context", "checkAndAbort", "abortOnError", "dumpRuleChaptersYaml", "checkerInfoGenResult", "Lcn/sast/api/config/CheckerInfoGenResult;", "dumpCheckerInfoJson", "checkerInfo", "dumpRuleAndRuleMappingDB", "rules", "getCheckerInfo", "validateCheckerIdAliasName", "HintEnum", "Companion", "corax-cli"})
@SourceDebugExtension(value={"SMAP\nCheckerInfoGenerator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckerInfoGenerator.kt\ncn/sast/cli/command/tools/CheckerInfoGenerator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 6 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,476:1\n1863#2:477\n1864#2:479\n1202#2,2:480\n1230#2,4:482\n1279#2,2:486\n1293#2,4:488\n1628#2,3:505\n1557#2:515\n1628#2,3:516\n1557#2:519\n1628#2,3:520\n774#2:523\n865#2,2:524\n774#2:526\n865#2,2:527\n1557#2:529\n1628#2,3:530\n1557#2:533\n1628#2,3:534\n1863#2,2:537\n1187#2,2:539\n1261#2,4:541\n1279#2,2:566\n1293#2,4:568\n1279#2,2:572\n1293#2,4:574\n1279#2,2:578\n1293#2,4:580\n1279#2,2:584\n1293#2,4:586\n1611#2,9:593\n1863#2:602\n1864#2:604\n1620#2:605\n1557#2:606\n1628#2,3:607\n1557#2:614\n1628#2,3:615\n1053#2:618\n1628#2,3:619\n1#3:478\n1#3:603\n77#4:492\n97#4,5:493\n126#4:552\n153#4,3:553\n77#4:590\n97#4,2:591\n99#4,3:610\n535#5:498\n520#5,6:499\n535#5:508\n520#5,6:509\n535#5:545\n520#5,6:546\n381#5,7:557\n1317#6:556\n1318#6:564\n1317#6:565\n1318#6:613\n*S KotlinDebug\n*F\n+ 1 CheckerInfoGenerator.kt\ncn/sast/cli/command/tools/CheckerInfoGenerator\n*L\n77#1:477\n77#1:479\n115#1:480,2\n115#1:482,4\n117#1:486,2\n117#1:488,4\n121#1:505,3\n129#1:515\n129#1:516,3\n142#1:519\n142#1:520,3\n285#1:523\n285#1:524,2\n286#1:526\n286#1:527,2\n287#1:529\n287#1:530,3\n288#1:533\n288#1:534,3\n315#1:537,2\n352#1:539,2\n352#1:541,4\n191#1:566,2\n191#1:568,4\n200#1:572,2\n200#1:574,4\n206#1:578,2\n206#1:580,4\n216#1:584,2\n216#1:586,4\n246#1:593,9\n246#1:602\n246#1:604\n246#1:605\n246#1:606\n246#1:607,3\n389#1:614\n389#1:615,3\n389#1:618\n393#1:619,3\n246#1:603\n118#1:492\n118#1:493,5\n439#1:552\n439#1:553,3\n226#1:590\n226#1:591,2\n226#1:610,3\n120#1:498\n120#1:499,6\n122#1:508\n122#1:509,6\n434#1:545\n434#1:546,6\n168#1:557,7\n166#1:556\n166#1:564\n180#1:565\n180#1:613\n*E\n"})
public final class CheckerInfoGenerator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<String> language;
    @NotNull
    private final Path output;
    @NotNull
    private final Path checkerInfoResRoot;
    @NotNull
    private final PluginDefinitions pluginDefinitions;
    @NotNull
    private final List<Object> errors;
    @NotNull
    private final List<Object> warnings;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(CheckerInfoGenerator::logger$lambda$66);
    @NotNull
    private static final Json jsonFormat = JsonKt.Json$default(null, CheckerInfoGenerator::jsonFormat$lambda$67, (int)1, null);
    @NotNull
    private static final Yaml yamlFormat = new Yaml(null, MainConfigKt.getYamlConfiguration(), 1, null);
    @NotNull
    private static final KSerializer<List<CheckerInfo>> infoSerializer = BuiltinSerializersKt.ListSerializer((KSerializer)CheckerInfo.Companion.serializer());

    public CheckerInfoGenerator(@NotNull List<String> language, @NotNull Path output, @NotNull Path checkerInfoResRoot, @NotNull PluginDefinitions pluginDefinitions) {
        Intrinsics.checkNotNullParameter(language, (String)"language");
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter((Object)checkerInfoResRoot, (String)"checkerInfoResRoot");
        Intrinsics.checkNotNullParameter((Object)pluginDefinitions, (String)"pluginDefinitions");
        this.language = language;
        this.output = output;
        this.checkerInfoResRoot = checkerInfoResRoot;
        this.pluginDefinitions = pluginDefinitions;
        this.errors = new ArrayList();
        this.warnings = new ArrayList();
    }

    private final Path getCheckerInfoJsonOutPath() {
        return this.checkerInfoResRoot.resolve("checker_info.json").normalize();
    }

    private final Path getCheckerInfoSqliteDBOutPath() {
        return this.checkerInfoResRoot.resolve("checker_info.db").normalize();
    }

    private final Path getRuleChaptersYamlOutPath() {
        return this.checkerInfoResRoot.resolve("rule_chapters.yaml").normalize();
    }

    private final Path getRuleChaptersSortNumberYamlOutPath() {
        return this.checkerInfoResRoot.resolve("rule_chapters_sort_number.yaml").normalize();
    }

    private final Path getDescriptionsPath() {
        return this.checkerInfoResRoot.resolve("descriptions");
    }

    private final Path getCheckerInfoCsvPath() {
        return this.checkerInfoResRoot.resolve("checker_info.csv");
    }

    private final Path getCategoryLanguageMapCsv() {
        return this.checkerInfoResRoot.resolve("category.translation.csv");
    }

    private final Path getStandardNameMappingJson() {
        return this.checkerInfoResRoot.resolve("checker_info_ruleset_to_server_standard_name_mapping.json");
    }

    @NotNull
    public final Path getRuleSortPath() {
        Path path = this.checkerInfoResRoot.resolve("rule_sort.yaml").normalize();
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"normalize(...)");
        return path;
    }

    private final String getSuffixOfLang(String lang) {
        return "." + lang;
    }

    private final Path getMarkdown(String checkerId, String lang) {
        Path path = this.getDescriptionsPath().resolve(checkerId + this.getSuffixOfLang(lang) + ".md");
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"resolve(...)");
        return path;
    }

    private final Path getAbstraction(String checkerId, String lang) {
        Path path = this.getDescriptionsPath().resolve(checkerId + this.getSuffixOfLang(lang) + ".txt");
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"resolve(...)");
        return path;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void dumpExistsCheckerIds(List<String> existsCheckerIds) {
        Path path = this.output.resolve("exists-checker-id.json");
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"resolve(...)");
        Object object = path;
        Object object2 = new OpenOption[]{};
        OutputStream outputStream = Files.newOutputStream((Path)object, Arrays.copyOf(object2, ((OpenOption[])object2).length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream, (String)"newOutputStream(...)");
        object = outputStream;
        object2 = null;
        try {
            OutputStream outputStream2 = (OutputStream)object;
            boolean bl = false;
            JvmStreamsKt.encodeToStream((Json)jsonFormat, (SerializationStrategy)((SerializationStrategy)BuiltinSerializersKt.ListSerializer((KSerializer)BuiltinSerializersKt.serializer((StringCompanionObject)StringCompanionObject.INSTANCE))), existsCheckerIds, (OutputStream)outputStream2);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            object2 = throwable;
            throw throwable;
        }
        finally {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        }
    }

    private final void validateBugMessageLanguage(List<? extends CheckType> checkTypes) {
        Iterable $this$forEach$iv = checkTypes;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            CheckType it = (CheckType)element$iv;
            boolean bl = false;
            if (it.getBugMessage().containsKey(Language.EN) && it.getBugMessage().containsKey(Language.ZH)) continue;
            boolean bl2 = false;
            String string = "Missing language ZH or EN: " + it;
            throw new IllegalStateException(string.toString());
        }
    }

    private final String getMessage(String lang, HintEnum msg) {
        return switch (WhenMappings.$EnumSwitchMapping$0[msg.ordinal()]) {
            case 1 -> {
                if (Intrinsics.areEqual((Object)lang, (Object)"zh-CN")) {
                    yield "\u8bf7\u6dfb\u52a0\u6b64\u89c4\u5219\u5bf9\u5e94\u7684\u63cf\u8ff0\u6216\u4fee\u590d\u5efa\u8bae\u5230";
                }
                yield "Please add a description or remediation suggestion for this rule at";
            }
            case 2 -> {
                if (Intrinsics.areEqual((Object)lang, (Object)"zh-CN")) {
                    yield "\u8bf7\u6dfb\u52a0\u6b64\u89c4\u5219\u5bf9\u5e94\u7684\u89c4\u5219\u7684\u6458\u8981";
                }
                yield "Please add a abstract short-description of the rule";
            }
            case 3 -> {
                if (Intrinsics.areEqual((Object)lang, (Object)"zh-CN")) {
                    yield "\u89c4\u5219\u7684markdown\u683c\u5f0f\u7684\u6f0f\u6d1e\u63cf\u8ff0\u6587\u6863";
                }
                yield "Description & Fix Suggestions for Vulnerabilities in Markdown Format";
            }
            case 4 -> {
                if (Intrinsics.areEqual((Object)lang, (Object)"zh-CN")) {
                    yield "\u89c4\u5219\u7684\u6458\u8981\u63cf\u8ff0";
                }
                yield "Abstract Short-Description of Rule";
            }
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    private final void validateDescription(String lang, String suffix, List<? extends CheckType> existsCheckerIds, HintEnum kind, HintEnum phantom) {
        Object lackFilePath;
        void $this$mapTo$iv$iv;
        void $this$filterTo$iv$iv;
        void destination$iv;
        void $this$mapTo$iv;
        Collection $this$filterTo$iv$iv2;
        void $this$flatMapTo$iv$iv;
        Map checkTypeToAllPossibleIds;
        Object object;
        Object element$iv$iv;
        boolean bl;
        Object object2;
        void $this$associateByTo$iv$iv;
        Path markdown = this.getDescriptionsPath();
        Intrinsics.checkNotNull((Object)markdown);
        Iterable $this$associateBy$iv = PathsKt.listDirectoryEntries((Path)markdown, (String)("*" + suffix));
        boolean $i$f$associateBy = false;
        int capacity$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateBy$iv, (int)10)), (int)16);
        Iterable iterable = $this$associateBy$iv;
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv2 : $this$associateByTo$iv$iv) {
            Path path = (Path)element$iv$iv2;
            object2 = destination$iv$iv;
            bl = false;
            object2.put(PathsKt.getName((Path)path), element$iv$iv2);
        }
        SortedMap existsMarkdowns = MapsKt.toSortedMap((Map)destination$iv$iv);
        Iterable $this$associateWith$iv = existsCheckerIds;
        boolean $i$f$associateWith = false;
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv, (int)10)), (int)16));
        Object $this$associateWithTo$iv$iv = $this$associateWith$iv;
        boolean $i$f$associateWithTo = false;
        Iterator iterator2 = $this$associateWithTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            element$iv$iv = iterator2.next();
            CheckType checkType = (CheckType)element$iv$iv;
            object = element$iv$iv;
            object2 = result$iv;
            bl = false;
            List list = CollectionsKt.listOf((Object)CheckerInfoGeneratorKt.getId((CheckType)checkType));
            object2.put(object, list);
        }
        Map $this$flatMap$iv = checkTypeToAllPossibleIds = (Map)result$iv;
        boolean $i$f$flatMap = false;
        $this$associateWithTo$iv$iv = $this$flatMap$iv;
        Object destination$iv$iv2 = new ArrayList();
        boolean $i$f$flatMapTo = false;
        element$iv$iv = $this$flatMapTo$iv$iv.entrySet().iterator();
        while (element$iv$iv.hasNext()) {
            Map.Entry entry;
            Map.Entry it2 = entry = (Map.Entry)element$iv$iv.next();
            boolean bl2 = false;
            Iterable list$iv$iv = (Iterable)it2.getValue();
            CollectionsKt.addAll((Collection)destination$iv$iv2, (Iterable)list$iv$iv);
        }
        List allPossibleIds = (List)destination$iv$iv2;
        Map $this$filter$iv = existsMarkdowns;
        boolean $i$f$filter232 = false;
        destination$iv$iv2 = $this$filter$iv;
        Map destination$iv$iv3 = new LinkedHashMap();
        boolean $i$f$filterTo232 = false;
        Iterator iterator3 = $this$filterTo$iv$iv2.entrySet().iterator();
        while (iterator3.hasNext()) {
            Map.Entry element$iv$iv4;
            Map.Entry it3 = element$iv$iv4 = iterator3.next();
            boolean bl3 = false;
            Object k = it3.getKey();
            Intrinsics.checkNotNullExpressionValue(k, (String)"<get-key>(...)");
            if (!(!allPossibleIds.contains(StringsKt.removeSuffix((String)((String)k), (CharSequence)suffix)))) continue;
            destination$iv$iv3.put(element$iv$iv4.getKey(), element$iv$iv4.getValue());
        }
        Set redundancy = destination$iv$iv3.keySet();
        Set set = existsMarkdowns.keySet();
        Intrinsics.checkNotNullExpressionValue(set, (String)"<get-keys>(...)");
        Iterable $i$f$filter232 = set;
        $this$filterTo$iv$iv2 = new LinkedHashSet();
        boolean $i$f$mapTo = false;
        for (Object t : $this$mapTo$iv) {
            void it4;
            String element$iv$iv4 = (String)t;
            object2 = destination$iv;
            boolean bl4 = false;
            Intrinsics.checkNotNull((Object)it4);
            object2.add(StringsKt.removeSuffix((String)it4, (CharSequence)suffix));
        }
        Set existsCheckerIdFromDescFiles = (Set)destination$iv;
        Map $this$filter$iv2 = checkTypeToAllPossibleIds;
        boolean $i$f$filter332 = false;
        Map $i$f$filterTo232 = $this$filter$iv2;
        Map map = new LinkedHashMap();
        boolean $i$f$filterTo = false;
        Iterator bl4 = $this$filterTo$iv$iv.entrySet().iterator();
        while (bl4.hasNext()) {
            Map.Entry element$iv$iv5;
            Map.Entry it5 = element$iv$iv5 = bl4.next();
            boolean bl2 = false;
            if (!CollectionsKt.intersect((Iterable)((Iterable)it5.getValue()), (Iterable)existsCheckerIdFromDescFiles).isEmpty()) continue;
            map.put(element$iv$iv5.getKey(), element$iv$iv5.getValue());
        }
        Set lack = CollectionsKt.toSet((Iterable)map.keySet());
        Object it6 = $i$f$filter332 = this.output.resolve("descriptions");
        boolean bl5 = false;
        Intrinsics.checkNotNull((Object)it6);
        LinkOption[] linkOptionArray = new LinkOption[]{};
        if (!Files.exists((Path)it6, Arrays.copyOf(linkOptionArray, linkOptionArray.length))) {
            Files.createDirectories((Path)it6, new FileAttribute[0]);
        }
        OpenOption[] out = $i$f$filter332;
        Path path = out.resolve("redundancy_md.json");
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"resolve(...)");
        Object $i$f$filter332 = path;
        it6 = new OpenOption[]{};
        OutputStream outputStream = Files.newOutputStream((Path)$i$f$filter332, Arrays.copyOf(it6, ((OpenOption[])it6).length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream, (String)"newOutputStream(...)");
        $i$f$filter332 = outputStream;
        it6 = null;
        try {
            OutputStream outputStream2 = (OutputStream)$i$f$filter332;
            boolean bl42 = false;
            JvmStreamsKt.encodeToStream((Json)jsonFormat, (SerializationStrategy)((SerializationStrategy)BuiltinSerializersKt.SetSerializer((KSerializer)BuiltinSerializersKt.serializer((StringCompanionObject)StringCompanionObject.INSTANCE))), redundancy, (OutputStream)outputStream2);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            it6 = throwable;
            throw throwable;
        }
        finally {
            CloseableKt.closeFinally((Closeable)$i$f$filter332, (Throwable)it6);
        }
        Object $this$map$iv = lack;
        boolean bl6 = false;
        Iterable bl42 = $this$map$iv;
        Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo222 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it7;
            CheckType checkType = (CheckType)item$iv$iv;
            object2 = destination$iv$iv5;
            boolean bl52 = false;
            object2.add(CheckerInfoGeneratorKt.getId((CheckType)it7) + suffix);
        }
        List lackDescriptionFile = (List)destination$iv$iv5;
        Path path2 = out.resolve("lack_md.json");
        Intrinsics.checkNotNullExpressionValue((Object)path2, (String)"resolve(...)");
        $this$map$iv = path2;
        OpenOption[] openOptionArray = new OpenOption[]{};
        OutputStream outputStream3 = Files.newOutputStream((Path)$this$map$iv, Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream3, (String)"newOutputStream(...)");
        $this$map$iv = outputStream3;
        Throwable throwable = null;
        try {
            OutputStream outputStream4 = (OutputStream)$this$map$iv;
            boolean bl62 = false;
            JvmStreamsKt.encodeToStream((Json)jsonFormat, (SerializationStrategy)((SerializationStrategy)BuiltinSerializersKt.ListSerializer((KSerializer)BuiltinSerializersKt.serializer((StringCompanionObject)StringCompanionObject.INSTANCE))), (Object)lackDescriptionFile, (OutputStream)outputStream4);
            outputStream4 = Unit.INSTANCE;
        }
        catch (Throwable outputStream4) {
            Throwable throwable2 = outputStream4;
            throw outputStream4;
        }
        finally {
            CloseableKt.closeFinally((Closeable)$this$map$iv, throwable);
        }
        for (String string : lackDescriptionFile) {
            Path path3 = this.getDescriptionsPath().resolve(string);
            Intrinsics.checkNotNullExpressionValue((Object)path3, (String)"resolve(...)");
            Path path4 = path3.toAbsolutePath();
            Intrinsics.checkNotNullExpressionValue((Object)path4, (String)"toAbsolutePath(...)");
            lackFilePath = path4.normalize();
            this.errors.add("Required: The necessary file for \"" + this.getMessage(lang, kind) + "\" do not exist: " + (Path)lackFilePath);
            Path desc = out.resolve(string);
            Intrinsics.checkNotNull((Object)desc);
            LinkOption[] linkOptionArray2 = new LinkOption[]{};
            if (Files.exists(desc, Arrays.copyOf(linkOptionArray2, linkOptionArray2.length))) continue;
            Object $i$f$mapTo222 = desc;
            Object object3 = Charsets.UTF_8;
            OpenOption[] item$iv$iv = new OpenOption[]{};
            $i$f$mapTo222 = new OutputStreamWriter(Files.newOutputStream((Path)$i$f$mapTo222, Arrays.copyOf(item$iv$iv, item$iv$iv.length)), (Charset)object3);
            object3 = null;
            try {
                OutputStreamWriter it8 = (OutputStreamWriter)$i$f$mapTo222;
                boolean bl72 = false;
                it8.write(this.getMessage(lang, phantom) + "\n\nRequired: " + (Path)lackFilePath + "\n");
                it8 = Unit.INSTANCE;
            }
            catch (Throwable it8) {
                object3 = it8;
                throw it8;
            }
            finally {
                CloseableKt.closeFinally((Closeable)$i$f$mapTo222, (Throwable)object3);
            }
        }
        $this$map$iv = redundancy;
        object2 = this.warnings;
        boolean bl7 = false;
        lackFilePath = $this$map$iv;
        Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo3 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it9;
            String bl72 = (String)item$iv$iv;
            object = destination$iv$iv4;
            boolean bl8 = false;
            object.add((CallSite)((Object)("Redundant \"" + this.getMessage(lang, kind) + "\": " + (String)it9)));
        }
        object2.addAll((List)destination$iv$iv4);
    }

    private final boolean isValid(Map<String, String> row, String key2) {
        String it = row.get(key2);
        boolean bl = false;
        CharSequence charSequence = it;
        return !(charSequence == null || charSequence.length() == 0) && ((CharSequence)((Object)StringsKt.trim((CharSequence)it)).toString()).length() > 0;
    }

    private final String getValueFromRow(Object file, Map<String, String> row, String key2) {
        if (!this.isValid(row, key2)) {
            throw new IllegalStateException(("failed to get a value of attribute '" + key2 + "' in " + row + " at " + file).toString());
        }
        String string = row.get(key2);
        Intrinsics.checkNotNull((Object)string);
        return string;
    }

    private final String getValueFromRowOrNull(Object file, Map<String, String> row, String key2, Function0<String> defaultValue) {
        if (!this.isValid(row, key2)) {
            if (defaultValue != null) {
                return (String)defaultValue.invoke();
            }
            this.warnings.add("failed to get a value of attribute '" + key2 + "' in " + row + " at " + file);
            return null;
        }
        String string = row.get(key2);
        Intrinsics.checkNotNull((Object)string);
        return string;
    }

    static /* synthetic */ String getValueFromRowOrNull$default(CheckerInfoGenerator checkerInfoGenerator, Object object, Map map, String string, Function0 function0, int n, Object object2) {
        if ((n & 8) != 0) {
            function0 = null;
        }
        return checkerInfoGenerator.getValueFromRowOrNull(object, map, string, function0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public final Pair<LinkedHashSet<CheckerInfo>, LinkedHashSet<String>> getCheckerInfoList(@NotNull LinkedHashSet<String> existsCheckerIds) {
        Intrinsics.checkNotNullParameter(existsCheckerIds, (String)"existsCheckerIds");
        Map categoryLanguageMap = new LinkedHashMap();
        CsvReader csvReader = CsvReaderDslKt.csvReader$default(null, (int)1, null);
        File file = this.getCategoryLanguageMapCsv().toFile();
        Intrinsics.checkNotNullExpressionValue((Object)file, (String)"toFile(...)");
        csvReader.open(file, arg_0 -> CheckerInfoGenerator.getCheckerInfoList$lambda$18(this, categoryLanguageMap, arg_0));
        Path path = this.getStandardNameMappingJson();
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"<get-standardNameMappingJson>(...)");
        Object object = path;
        Object object2 = new OpenOption[]{};
        InputStream inputStream = Files.newInputStream((Path)object, Arrays.copyOf(object2, ((OpenOption[])object2).length));
        Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"newInputStream(...)");
        object = inputStream;
        object2 = null;
        try {
            Object i = (InputStream)object;
            boolean bl = false;
            i = (Map)JvmStreamsKt.decodeFromStream((Json)jsonFormat, (DeserializationStrategy)((DeserializationStrategy)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE)), (InputStream)i);
        }
        catch (Throwable i) {
            object2 = i;
            throw i;
        }
        finally {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        }
        Object standardNames = i;
        LinkedHashSet checkerIdInCsv = new LinkedHashSet();
        LinkedHashSet checkerInfos = new LinkedHashSet();
        Set standardCheckExists = new LinkedHashSet();
        CsvReader csvReader2 = CsvReaderDslKt.csvReader$default(null, (int)1, null);
        File file2 = this.getCheckerInfoCsvPath().toFile();
        Intrinsics.checkNotNullExpressionValue((Object)file2, (String)"toFile(...)");
        csvReader2.open(file2, arg_0 -> CheckerInfoGenerator.getCheckerInfoList$lambda$33(standardCheckExists, this, checkerIdInCsv, existsCheckerIds, (Map)standardNames, checkerInfos, categoryLanguageMap, arg_0));
        Set notExistsStandardName = SetsKt.minus(standardNames.keySet(), (Iterable)standardCheckExists);
        if (!notExistsStandardName.isEmpty()) {
            boolean bl = false;
            String string = "The rule set names in JSON file '" + this.getStandardNameMappingJson() + "': " + notExistsStandardName + " are missing from the '" + this.getCheckerInfoCsvPath() + "' and need to be added.";
            throw new IllegalStateException(string.toString());
        }
        return TuplesKt.to(checkerInfos, checkerIdInCsv);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    private final void dumpCheckerInfoJsonFile(Set<String> checkerIdInCsv, LinkedHashSet<String> existsCheckerIds) {
        OutputStream outputStream3;
        Collection collection;
        Iterable $this$mapTo$iv$iv;
        Iterable $this$map$iv;
        void $this$filterTo$iv$iv;
        void $this$filterTo$iv$iv2;
        Iterable $this$filter$iv = checkerIdInCsv;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Iterable destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv2) {
            String it = (String)element$iv$iv;
            boolean bl = false;
            if (!(!existsCheckerIds.contains(it))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List redundancyIdInCsv = (List)destination$iv$iv;
        Iterable $this$filter$iv2 = existsCheckerIds;
        boolean $i$f$filter2 = false;
        destination$iv$iv = $this$filter$iv2;
        Collection destination$iv$iv2 = new ArrayList();
        boolean $i$f$filterTo2 = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            String it = (String)element$iv$iv;
            boolean bl = false;
            if (!(!checkerIdInCsv.contains(it))) continue;
            destination$iv$iv2.add(element$iv$iv);
        }
        List lackIdInCsv = (List)destination$iv$iv2;
        $this$filter$iv2 = redundancyIdInCsv;
        List list = this.warnings;
        boolean $i$f$map = false;
        $this$filterTo$iv$iv = $this$map$iv;
        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            String it = (String)item$iv$iv;
            collection = destination$iv$iv2;
            boolean bl = false;
            collection.add("Redundant rule '" + it + "' in checker_info.csv that not define in the plugin");
        }
        list.addAll((List)destination$iv$iv2);
        $this$map$iv = lackIdInCsv;
        list = this.errors;
        $i$f$map = false;
        $this$mapTo$iv$iv = $this$map$iv;
        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            String it = (String)item$iv$iv;
            collection = destination$iv$iv2;
            boolean bl = false;
            collection.add("Rule '" + it + "' define in the plugin that not declare in the checker_info.csv");
        }
        list.addAll((List)destination$iv$iv2);
        Path path = this.output.resolve("redundancy_checker_csv_row.json");
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"resolve(...)");
        Object object = path;
        Object object2 = new OpenOption[]{};
        OutputStream outputStream2 = Files.newOutputStream((Path)object, Arrays.copyOf(object2, ((OpenOption[])object2).length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream2, (String)"newOutputStream(...)");
        object = outputStream2;
        object2 = null;
        try {
            outputStream3 = (OutputStream)object;
            boolean bl = false;
            JvmStreamsKt.encodeToStream((Json)jsonFormat, (SerializationStrategy)((SerializationStrategy)BuiltinSerializersKt.ListSerializer((KSerializer)BuiltinSerializersKt.serializer((StringCompanionObject)StringCompanionObject.INSTANCE))), (Object)redundancyIdInCsv, (OutputStream)outputStream3);
            outputStream3 = Unit.INSTANCE;
        }
        catch (Throwable outputStream3) {
            object2 = outputStream3;
            throw outputStream3;
        }
        finally {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        }
        Path path2 = this.output.resolve("lack_checker_csv_row.json");
        Intrinsics.checkNotNullExpressionValue((Object)path2, (String)"resolve(...)");
        object = path2;
        object2 = new OpenOption[]{};
        OutputStream outputStream4 = Files.newOutputStream((Path)object, Arrays.copyOf(object2, ((OpenOption[])object2).length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream4, (String)"newOutputStream(...)");
        object = outputStream4;
        object2 = null;
        try {
            outputStream3 = (OutputStream)object;
            boolean bl = false;
            JvmStreamsKt.encodeToStream((Json)jsonFormat, (SerializationStrategy)((SerializationStrategy)BuiltinSerializersKt.ListSerializer((KSerializer)BuiltinSerializersKt.serializer((StringCompanionObject)StringCompanionObject.INSTANCE))), (Object)lackIdInCsv, (OutputStream)outputStream3);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            object2 = throwable;
            throw throwable;
        }
        finally {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private final Boolean toBoolean(String value) {
        Boolean bl;
        block8: {
            block7: {
                if (value == null) {
                    return null;
                }
                if (Intrinsics.areEqual((Object)value, (Object)"\u65e0")) return null;
                String string = value.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toUpperCase(...)");
                if (Intrinsics.areEqual((Object)string, (Object)"NONE")) {
                    return null;
                }
                if (Intrinsics.areEqual((Object)value, (Object)"\u5426")) break block7;
                String string2 = value.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toUpperCase(...)");
                if (!Intrinsics.areEqual((Object)string2, (Object)"FALSE")) break block8;
            }
            bl = false;
            return bl;
        }
        if (!Intrinsics.areEqual((Object)value, (Object)"\u662f")) {
            String string = value.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toUpperCase(...)");
            if (!Intrinsics.areEqual((Object)string, (Object)"TRUE")) {
                return null;
            }
        }
        bl = true;
        return bl;
    }

    private final void validateLanguageMapToContext(Map<String, String> map, String checkerId, String key2) {
        Iterable $this$forEach$iv = map.entrySet();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Map.Entry entry = (Map.Entry)element$iv;
            boolean bl = false;
            String lang = (String)entry.getKey();
            String context = (String)entry.getValue();
            if (Intrinsics.areEqual((Object)"en-US", (Object)lang) && this.containsChinese(context)) {
                this.warnings.add("The " + key2 + " of checker with id: " + checkerId + " is invalid in en-US context!");
            }
            if (!Intrinsics.areEqual((Object)"zh-CN", (Object)lang) || this.containsChinese(context)) continue;
            this.warnings.add("The " + key2 + " of checker with id: " + checkerId + " is invalid in zh-CN context!");
        }
    }

    private final boolean containsChinese(String context) {
        String chineseRegex = "[\\u4e00-\\u9fa5]";
        return Pattern.compile(chineseRegex).matcher(context).find();
    }

    private final void checkAndAbort(boolean abortOnError) {
        if (!abortOnError) {
            return;
        }
        if (!((Collection)this.warnings).isEmpty()) {
            logger.warn(() -> CheckerInfoGenerator.checkAndAbort$lambda$43(this));
        }
        if (!(!((Collection)this.errors).isEmpty())) {
            this.warnings.clear();
            this.errors.clear();
            return;
        }
        logger.error(() -> CheckerInfoGenerator.checkAndAbort$lambda$45(this));
        System.exit(5);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public final void dumpRuleChaptersYaml(@NotNull CheckerInfoGenResult checkerInfoGenResult) {
        OutputStream it3;
        void $this$associateTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)checkerInfoGenResult, (String)"checkerInfoGenResult");
        CheckerPriorityConfig checkerPriorityConfig = CheckerPriorityConfig.Companion.deserialize(Resource.INSTANCE.fileOf(this.getRuleSortPath()));
        List chapters = checkerInfoGenResult.getChapters();
        Map chapterTree = checkerPriorityConfig.getSortTree(chapters);
        Iterable $this$associate$iv = checkerPriorityConfig.getRuleWithSortNumber(chapters);
        boolean $i$f$associate = false;
        int capacity$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associate$iv, (int)10)), (int)16);
        Iterable iterable = $this$associate$iv;
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateTo = false;
        for (Object element$iv$iv : $this$associateTo$iv$iv) {
            Map map = destination$iv$iv;
            IndexedValue it2 = (IndexedValue)element$iv$iv;
            boolean bl = false;
            Pair pair = TuplesKt.to((Object)it2.getIndex(), (Object)((ChapterFlat)it2.getValue()).toString());
            map.put(pair.getFirst(), pair.getSecond());
        }
        Map chaptersWithSortNumber = destination$iv$iv;
        Path path = this.getRuleChaptersYamlOutPath();
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"<get-ruleChaptersYamlOutPath>(...)");
        Object object = path;
        Object object2 = new OpenOption[]{};
        OutputStream outputStream = Files.newOutputStream((Path)object, Arrays.copyOf(object2, ((OpenOption[])object2).length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream, (String)"newOutputStream(...)");
        object = outputStream;
        object2 = null;
        try {
            it3 = (OutputStream)object;
            boolean bl = false;
            Yaml.encodeToStream$default((Yaml)yamlFormat, (SerializationStrategy)((SerializationStrategy)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE)))), (Object)chapterTree, (OutputStream)it3, null, (int)8, null);
            it3 = Unit.INSTANCE;
        }
        catch (Throwable it3) {
            object2 = it3;
            throw it3;
        }
        finally {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        }
        Path path2 = this.getRuleChaptersSortNumberYamlOutPath();
        Intrinsics.checkNotNullExpressionValue((Object)path2, (String)"<get-ruleChaptersSortNumberYamlOutPath>(...)");
        object = path2;
        object2 = new OpenOption[]{};
        OutputStream outputStream2 = Files.newOutputStream((Path)object, Arrays.copyOf(object2, ((OpenOption[])object2).length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream2, (String)"newOutputStream(...)");
        object = outputStream2;
        object2 = null;
        try {
            it3 = (OutputStream)object;
            boolean bl = false;
            Yaml.encodeToStream$default((Yaml)yamlFormat, (SerializationStrategy)((SerializationStrategy)new LinkedHashMapSerializer((KSerializer)IntSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE)), (Object)chaptersWithSortNumber, (OutputStream)it3, null, (int)8, null);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            object2 = throwable;
            throw throwable;
        }
        finally {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        }
        logger.info(() -> CheckerInfoGenerator.dumpRuleChaptersYaml$lambda$49(this));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void dumpCheckerInfoJson(@NotNull CheckerInfoGenResult checkerInfo, boolean abortOnError) {
        Intrinsics.checkNotNullParameter((Object)checkerInfo, (String)"checkerInfo");
        this.dumpExistsCheckerIds(CollectionsKt.toList((Iterable)checkerInfo.getExistsCheckerIds()));
        this.dumpCheckerInfoJsonFile((Set)checkerInfo.getCheckerIdInCsv(), checkerInfo.getExistsCheckerIds());
        Path path = this.getCheckerInfoJsonOutPath();
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"<get-checkerInfoJsonOutPath>(...)");
        Object object = path;
        Object object2 = new OpenOption[]{};
        OutputStream outputStream = Files.newOutputStream((Path)object, Arrays.copyOf(object2, ((OpenOption[])object2).length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream, (String)"newOutputStream(...)");
        object = outputStream;
        object2 = null;
        try {
            OutputStream outputStream2 = (OutputStream)object;
            boolean bl = false;
            JvmStreamsKt.encodeToStream((Json)jsonFormat, (SerializationStrategy)((SerializationStrategy)infoSerializer), (Object)CollectionsKt.toList((Iterable)checkerInfo.getCheckerInfoList()), (OutputStream)outputStream2);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            object2 = throwable;
            throw throwable;
        }
        finally {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        }
        this.dumpRuleChaptersYaml(checkerInfo);
        this.checkAndAbort(abortOnError);
        logger.info(() -> CheckerInfoGenerator.dumpCheckerInfoJson$lambda$51(this));
    }

    public static /* synthetic */ void dumpCheckerInfoJson$default(CheckerInfoGenerator checkerInfoGenerator, CheckerInfoGenResult checkerInfoGenResult, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        checkerInfoGenerator.dumpCheckerInfoJson(checkerInfoGenResult, bl);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void dumpRuleAndRuleMappingDB(@NotNull CheckerInfoGenResult checkerInfo, @Nullable Set<String> rules2) {
        Intrinsics.checkNotNullParameter((Object)checkerInfo, (String)"checkerInfo");
        Path dbPath = this.getCheckerInfoSqliteDBOutPath();
        Intrinsics.checkNotNull((Object)dbPath);
        Files.deleteIfExists(dbPath);
        RuleAndRuleMapping ruleAndRuleMapping = new RuleAndRuleMapping(checkerInfo, this.getRuleSortPath());
        Closeable closeable = (Closeable)SqliteDiagnostics.Companion.openDataBase$default((SqliteDiagnostics.Companion)SqliteDiagnostics.Companion, (String)((Object)dbPath).toString(), null, (int)2, null);
        Throwable throwable = null;
        try {
            SQLiteDB it = (SQLiteDB)closeable;
            boolean bl = false;
            it.createSchema();
            ruleAndRuleMapping.insert(it.getDatabase(), rules2);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
        logger.info(() -> CheckerInfoGenerator.dumpRuleAndRuleMappingDB$lambda$53(dbPath));
    }

    @NotNull
    public final CheckerInfoGenResult getCheckerInfo(boolean abortOnError) {
        Lazy checkTypes$delegate = LazyKt.lazy(() -> CheckerInfoGenerator.getCheckerInfo$lambda$56(this));
        Lazy existsCheckerIds$delegate = LazyKt.lazy(() -> CheckerInfoGenerator.getCheckerInfo$lambda$61(checkTypes$delegate));
        this.validateBugMessageLanguage(CheckerInfoGenerator.getCheckerInfo$lambda$57((Lazy)checkTypes$delegate));
        for (String lang : this.language) {
            this.validateDescription(lang, this.getSuffixOfLang(lang) + ".md", CheckerInfoGenerator.getCheckerInfo$lambda$57((Lazy)checkTypes$delegate), HintEnum.MARKDOWN, HintEnum.PHANTOM_MARKDOWN);
            this.validateDescription(lang, this.getSuffixOfLang(lang) + ".txt", CheckerInfoGenerator.getCheckerInfo$lambda$57((Lazy)checkTypes$delegate), HintEnum.ABSTRACT, HintEnum.PHANTOM_ABSTRACT);
        }
        this.checkAndAbort(abortOnError);
        Pair pair = this.getCheckerInfoList(CheckerInfoGenerator.getCheckerInfo$lambda$62((Lazy)existsCheckerIds$delegate));
        LinkedHashSet checkerInfoList = (LinkedHashSet)pair.component1();
        LinkedHashSet checkerIdInCsv = (LinkedHashSet)pair.component2();
        this.checkAndAbort(abortOnError);
        this.validateCheckerIdAliasName((Set)CheckerInfoGenerator.getCheckerInfo$lambda$62((Lazy)existsCheckerIds$delegate));
        this.checkAndAbort(abortOnError);
        return new CheckerInfoGenResult(checkerInfoList, new LinkedHashSet(CheckerInfoGenerator.getCheckerInfo$lambda$57((Lazy)checkTypes$delegate)), CheckerInfoGenerator.getCheckerInfo$lambda$62((Lazy)existsCheckerIds$delegate), checkerIdInCsv);
    }

    public static /* synthetic */ CheckerInfoGenResult getCheckerInfo$default(CheckerInfoGenerator checkerInfoGenerator, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = true;
        }
        return checkerInfoGenerator.getCheckerInfo(bl);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    private final void validateCheckerIdAliasName(Set<String> existsCheckerIds) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        OutputStream outputStream3;
        Map.Entry it;
        void $this$filterTo$iv$iv;
        Gson gson = new Gson();
        Path path = this.checkerInfoResRoot.resolve("checker_name_mapping.json");
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"resolve(...)");
        Object object = gson.fromJson(PathsKt.readText((Path)path, (Charset)Charsets.UTF_8), new /* Unavailable Anonymous Inner Class!! */.getType());
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromJson(...)");
        Map renameMap2 = (Map)object;
        Object $this$filter$iv = renameMap2;
        boolean $i$f$filter22 = false;
        Map map = $this$filter$iv;
        Map destination$iv$iv = new LinkedHashMap();
        boolean $i$f$filterTo = false;
        Iterator iterator2 = $this$filterTo$iv$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv$iv;
            it = element$iv$iv = iterator2.next();
            boolean bl = false;
            if (!(!existsCheckerIds.contains(it.getValue()))) continue;
            destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
        }
        Map missing = destination$iv$iv;
        Path path2 = this.output.resolve(StringsKt.substringBeforeLast$default((String)"checker_name_mapping.json", (String)".", null, (int)2, null) + ".no-such-alias-names.json");
        Intrinsics.checkNotNullExpressionValue((Object)path2, (String)"resolve(...)");
        $this$filter$iv = path2;
        Object $i$f$filter22 = new OpenOption[]{};
        OutputStream outputStream2 = Files.newOutputStream((Path)$this$filter$iv, Arrays.copyOf($i$f$filter22, ((OpenOption[])$i$f$filter22).length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream2, (String)"newOutputStream(...)");
        $this$filter$iv = outputStream2;
        $i$f$filter22 = null;
        try {
            outputStream3 = (OutputStream)$this$filter$iv;
            boolean bl = false;
            JvmStreamsKt.encodeToStream((Json)jsonFormat, (SerializationStrategy)((SerializationStrategy)BuiltinSerializersKt.MapSerializer((KSerializer)BuiltinSerializersKt.serializer((StringCompanionObject)StringCompanionObject.INSTANCE), (KSerializer)BuiltinSerializersKt.serializer((StringCompanionObject)StringCompanionObject.INSTANCE))), (Object)missing, (OutputStream)outputStream3);
            outputStream3 = Unit.INSTANCE;
        }
        catch (Throwable outputStream3) {
            $i$f$filter22 = outputStream3;
            throw outputStream3;
        }
        finally {
            CloseableKt.closeFinally((Closeable)$this$filter$iv, (Throwable)$i$f$filter22);
        }
        $this$filter$iv = missing;
        List list = this.warnings;
        boolean $i$f$map = false;
        outputStream3 = $this$map$iv;
        Collection destination$iv$iv2 = new ArrayList($this$map$iv.size());
        boolean $i$f$mapTo = false;
        for (Map.Entry item$iv$iv : $this$mapTo$iv$iv.entrySet()) {
            it = item$iv$iv;
            Collection collection = destination$iv$iv2;
            boolean bl = false;
            collection.add("checker_id alias " + it.getKey() + " -> " + it.getValue() + ". the target " + it.getValue() + " is not exists. check: checker_name_mapping.json");
        }
        list.addAll((List)destination$iv$iv2);
    }

    private static final Unit getCheckerInfoList$lambda$18(CheckerInfoGenerator this$0, Map $categoryLanguageMap, CsvFileReader $this$open) {
        Intrinsics.checkNotNullParameter((Object)$this$open, (String)"$this$open");
        Sequence $this$forEach$iv = $this$open.readAllWithHeaderAsSequence();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Object object;
            Map row = (Map)element$iv;
            boolean bl = false;
            Path path = this$0.getCategoryLanguageMapCsv();
            Intrinsics.checkNotNullExpressionValue((Object)path, (String)"<get-categoryLanguageMapCsv>(...)");
            String lang = this$0.getValueFromRow((Object)path, row, "lang");
            Map $this$getOrPut$iv = $categoryLanguageMap;
            boolean $i$f$getOrPut = false;
            Object value$iv = $this$getOrPut$iv.get(lang);
            if (value$iv == null) {
                boolean bl2 = false;
                Map answer$iv = new LinkedHashMap();
                $this$getOrPut$iv.put(lang, answer$iv);
                object = answer$iv;
            } else {
                object = value$iv;
            }
            ((Map)object).putAll(row);
        }
        return Unit.INSTANCE;
    }

    private static final String getCheckerInfoList$lambda$33$lambda$32$lambda$30() {
        return null;
    }

    private static final String getCheckerInfoList$lambda$33$lambda$32$lambda$31() {
        return null;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static final Unit getCheckerInfoList$lambda$33(Set $standardCheckExists, CheckerInfoGenerator this$0, LinkedHashSet $checkerIdInCsv, LinkedHashSet $existsCheckerIds, Map $standardNames, LinkedHashSet $checkerInfos, Map $categoryLanguageMap, CsvFileReader $this$open) {
        Intrinsics.checkNotNullParameter((Object)$this$open, (String)"$this$open");
        Sequence $this$forEach$iv = $this$open.readAllWithHeaderAsSequence();
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.iterator();
        block0: while (iterator2.hasNext()) {
            void $this$flatMapTo$iv$iv;
            String string;
            Map map;
            Object element$iv$iv2;
            Object element$iv = iterator2.next();
            Map row = (Map)element$iv;
            boolean bl = false;
            CollectionsKt.addAll((Collection)$standardCheckExists, (Iterable)row.keySet());
            Path path = this$0.getCheckerInfoCsvPath();
            Intrinsics.checkNotNullExpressionValue((Object)path, (String)"<get-checkerInfoCsvPath>(...)");
            String checkerId = this$0.getValueFromRow((Object)path, row, "checker_id");
            if (!$checkerIdInCsv.add(checkerId)) {
                this$0.errors.add("Duplication rule " + checkerId + " is already in csv");
            }
            if (!$existsCheckerIds.contains(checkerId)) continue;
            Iterable $this$associateWith$iv = this$0.language;
            boolean $i$f$associateWith = false;
            LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv, (int)10)), (int)16));
            Iterable $this$associateWithTo$iv$iv = $this$associateWith$iv;
            boolean $i$f$associateWithTo = false;
            for (Object element$iv$iv2 : $this$associateWithTo$iv$iv) {
                String string2;
                Map categoryTranslateMap;
                void lang;
                String string3 = (String)element$iv$iv2;
                Object t = element$iv$iv2;
                map = result$iv;
                boolean bl2 = false;
                if ((Map)$categoryLanguageMap.get(lang) == null) {
                    throw new IllegalStateException(("'" + (String)lang + "' is not exists in " + this$0.getCategoryLanguageMapCsv()).toString());
                }
                Path path2 = this$0.getCheckerInfoCsvPath();
                Intrinsics.checkNotNullExpressionValue((Object)path2, (String)"<get-checkerInfoCsvPath>(...)");
                String category = this$0.getValueFromRow((Object)path2, row, "category");
                if ((String)categoryTranslateMap.get(category) == null) {
                    throw new IllegalStateException(((String)lang + " category for '" + category + "' is not exists in " + this$0.getCategoryLanguageMapCsv()).toString());
                }
                String it = string2;
                boolean bl3 = false;
                if (!(((CharSequence)((Object)StringsKt.trim((CharSequence)it)).toString()).length() > 0)) {
                    boolean $i$a$-check-CheckerInfoGenerator$getCheckerInfoList$2$1$category$1$1$22 = false;
                    String $i$a$-check-CheckerInfoGenerator$getCheckerInfoList$2$1$category$1$1$22 = "invalid translation of category: " + category + " and it is empty in " + this$0.getCategoryLanguageMapCsv();
                    throw new IllegalStateException($i$a$-check-CheckerInfoGenerator$getCheckerInfoList$2$1$category$1$1$22.toString());
                }
                string = string2;
                map.put(t, string);
            }
            Map category = result$iv;
            this$0.validateLanguageMapToContext(category, checkerId, "category");
            Iterable $this$associateWith$iv2 = this$0.language;
            boolean $i$f$associateWith2 = false;
            LinkedHashMap result$iv2 = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv2, (int)10)), (int)16));
            Iterable $this$associateWithTo$iv$iv2 = $this$associateWith$iv2;
            boolean $i$f$associateWithTo2 = false;
            element$iv$iv2 = $this$associateWithTo$iv$iv2.iterator();
            while (element$iv$iv2.hasNext()) {
                void lang;
                Object element$iv$iv3 = element$iv$iv2.next();
                String bl2 = (String)element$iv$iv3;
                Object e = element$iv$iv3;
                map = result$iv2;
                boolean bl4 = false;
                String nameWithLang = "name-" + StringsKt.substringBefore$default((String)lang, (String)"-", null, (int)2, null);
                Path path3 = this$0.getCheckerInfoCsvPath();
                Intrinsics.checkNotNullExpressionValue((Object)path3, (String)"<get-checkerInfoCsvPath>(...)");
                string = this$0.getValueFromRow((Object)path3, row, nameWithLang);
                map.put(e, string);
            }
            Map name = result$iv2;
            this$0.validateLanguageMapToContext(name, checkerId, "name");
            Iterable $this$associateWith$iv3 = this$0.language;
            boolean $i$f$associateWith3 = false;
            LinkedHashMap result$iv3 = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv3, (int)10)), (int)16));
            Iterable $this$associateWithTo$iv$iv3 = $this$associateWith$iv3;
            boolean $i$f$associateWithTo3 = false;
            for (Object element$iv$iv4 : $this$associateWithTo$iv$iv3) {
                String string4;
                void lang;
                String bl4 = (String)element$iv$iv4;
                Object e = element$iv$iv4;
                map = result$iv3;
                boolean bl5 = false;
                Path abs = this$0.getAbstraction(checkerId, (String)lang);
                LinkOption[] linkOptionArray = new LinkOption[]{};
                if (!Files.exists(abs, Arrays.copyOf(linkOptionArray, linkOptionArray.length))) {
                    this$0.errors.add("Required: A short rule description file: '" + abs + "' is not exists.");
                    string4 = "error: no such abstract file!";
                } else {
                    string4 = StringsKt.replace$default((String)PathsKt.readText((Path)abs, (Charset)Charsets.UTF_8), (String)"\r\n", (String)"\n", (boolean)false, (int)4, null);
                }
                string = string4;
                map.put(e, string);
            }
            Map map2 = result$iv3;
            this$0.validateLanguageMapToContext(map2, checkerId, "abstract");
            Iterable $this$associateWith$iv4 = this$0.language;
            boolean $i$f$associateWith4 = false;
            LinkedHashMap result$iv4 = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv4, (int)10)), (int)16));
            Object $this$associateWithTo$iv$iv4 = $this$associateWith$iv4;
            boolean $i$f$associateWithTo4 = false;
            Iterator element$iv$iv4 = $this$associateWithTo$iv$iv4.iterator();
            while (element$iv$iv4.hasNext()) {
                String string5;
                void lang;
                Object element$iv$iv5 = element$iv$iv4.next();
                String bl5 = (String)element$iv$iv5;
                Object t = element$iv$iv5;
                map = result$iv4;
                boolean bl6 = false;
                Path md = this$0.getMarkdown(checkerId, (String)lang);
                LinkOption[] linkOptionArray = new LinkOption[]{};
                if (!Files.exists(md, Arrays.copyOf(linkOptionArray, linkOptionArray.length))) {
                    this$0.errors.add("Required: A markdown file that detailing rule descriptions & defect repair recommendations: '" + md + "' is not exists.");
                    string5 = "error: no such abstract file!";
                } else {
                    string5 = StringsKt.replace$default((String)PathsKt.readText((Path)md, (Charset)Charsets.UTF_8), (String)"\r\n", (String)"\n", (boolean)false, (int)4, null);
                }
                string = string5;
                map.put(t, string);
            }
            Map description = result$iv4;
            this$0.validateLanguageMapToContext(description, checkerId, "description");
            Map $this$flatMap$iv = $standardNames;
            boolean $i$f$flatMap = false;
            $this$associateWithTo$iv$iv4 = $this$flatMap$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$flatMapTo = false;
            Iterator iterator3 = $this$flatMapTo$iv$iv.entrySet().iterator();
            while (true) {
                Iterable iterable;
                block19: {
                    void $this$mapTo$iv$iv;
                    void $this$map$iv;
                    Object object;
                    void $this$mapNotNullTo$iv$iv;
                    Collection destination$iv$iv2;
                    Iterable $this$mapNotNull$iv;
                    String stNameInJson;
                    block27: {
                        block17: {
                            String rule;
                            block26: {
                                block25: {
                                    block24: {
                                        block23: {
                                            block22: {
                                                block21: {
                                                    block20: {
                                                        String stNameInCsv;
                                                        block18: {
                                                            Map.Entry element$iv$iv6;
                                                            if (!iterator3.hasNext()) break block17;
                                                            Map.Entry bl6 = element$iv$iv6 = iterator3.next();
                                                            boolean bl7 = false;
                                                            stNameInCsv = (String)bl6.getKey();
                                                            stNameInJson = (String)bl6.getValue();
                                                            if (this$0.isValid(row, stNameInCsv)) break block18;
                                                            iterable = CollectionsKt.emptyList();
                                                            break block19;
                                                        }
                                                        Path path4 = this$0.getCheckerInfoCsvPath();
                                                        Intrinsics.checkNotNullExpressionValue((Object)path4, (String)"<get-checkerInfoCsvPath>(...)");
                                                        rule = ((Object)StringsKt.trim((CharSequence)this$0.getValueFromRow((Object)path4, row, stNameInCsv))).toString();
                                                        if (!(((CharSequence)rule).length() == 0)) break block20;
                                                        iterable = CollectionsKt.emptyList();
                                                        break block19;
                                                    }
                                                    if (Intrinsics.areEqual((Object)rule, (Object)"\u65e0")) break block21;
                                                    String string6 = rule.toUpperCase(Locale.ROOT);
                                                    Intrinsics.checkNotNullExpressionValue((Object)string6, (String)"toUpperCase(...)");
                                                    if (!Intrinsics.areEqual((Object)string6, (Object)"NONE")) break block22;
                                                }
                                                iterable = CollectionsKt.emptyList();
                                                break block19;
                                            }
                                            if (Intrinsics.areEqual((Object)rule, (Object)"\u5426")) break block23;
                                            String string7 = rule.toUpperCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue((Object)string7, (String)"toUpperCase(...)");
                                            if (!Intrinsics.areEqual((Object)string7, (Object)"FALSE")) break block24;
                                        }
                                        iterable = CollectionsKt.emptyList();
                                        break block19;
                                    }
                                    if (Intrinsics.areEqual((Object)rule, (Object)"\u662f")) break block25;
                                    String string8 = rule.toUpperCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue((Object)string8, (String)"toUpperCase(...)");
                                    if (!Intrinsics.areEqual((Object)string8, (Object)"TRUE")) break block26;
                                }
                                iterable = CollectionsKt.listOf((Object)new Tag(stNameInJson, ""));
                                break block19;
                            }
                            String[] stringArray = new String[]{","};
                            $this$mapNotNull$iv = StringsKt.split$default((CharSequence)rule, (String[])stringArray, (boolean)false, (int)0, (int)6, null);
                            boolean $i$f$mapNotNull = false;
                            Iterable iterable2 = $this$mapNotNull$iv;
                            destination$iv$iv2 = new ArrayList();
                            boolean $i$f$mapNotNullTo = false;
                            void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                            boolean $i$f$forEach2 = false;
                            object = $this$forEach$iv$iv$iv.iterator();
                            break block27;
                        }
                        List tags = (List)destination$iv$iv;
                        Path path5 = this$0.getCheckerInfoCsvPath();
                        Intrinsics.checkNotNullExpressionValue((Object)path5, (String)"<get-checkerInfoCsvPath>(...)");
                        String string9 = this$0.getValueFromRow((Object)path5, row, "severity");
                        Map map3 = MapsKt.toMutableMap((Map)description);
                        Path path6 = this$0.getCheckerInfoCsvPath();
                        Intrinsics.checkNotNullExpressionValue((Object)path6, (String)"<get-checkerInfoCsvPath>(...)");
                        String string10 = this$0.getValueFromRowOrNull((Object)path6, row, "\u5f71\u54cd\u7a0b\u5ea6", CheckerInfoGenerator::getCheckerInfoList$lambda$33$lambda$32$lambda$30);
                        Path path7 = this$0.getCheckerInfoCsvPath();
                        Intrinsics.checkNotNullExpressionValue((Object)path7, (String)"<get-checkerInfoCsvPath>(...)");
                        String string11 = this$0.getValueFromRowOrNull((Object)path7, row, "\u53ef\u5229\u7528\u6027", CheckerInfoGenerator::getCheckerInfoList$lambda$33$lambda$32$lambda$31);
                        Path path8 = this$0.getCheckerInfoCsvPath();
                        Intrinsics.checkNotNullExpressionValue((Object)path8, (String)"<get-checkerInfoCsvPath>(...)");
                        String string12 = CheckerInfoGenerator.getValueFromRowOrNull$default((CheckerInfoGenerator)this$0, (Object)path8, (Map)row, (String)"\u7cbe\u786e\u7387", null, (int)8, null);
                        Path path9 = this$0.getCheckerInfoCsvPath();
                        Intrinsics.checkNotNullExpressionValue((Object)path9, (String)"<get-checkerInfoCsvPath>(...)");
                        String string13 = CheckerInfoGenerator.getValueFromRowOrNull$default((CheckerInfoGenerator)this$0, (Object)path9, (Map)row, (String)"\u53ec\u56de\u7387", null, (int)8, null);
                        Path path10 = this$0.getCheckerInfoCsvPath();
                        Intrinsics.checkNotNullExpressionValue((Object)path10, (String)"<get-checkerInfoCsvPath>(...)");
                        String string14 = CheckerInfoGenerator.getValueFromRowOrNull$default((CheckerInfoGenerator)this$0, (Object)path10, (Map)row, (String)"impl", null, (int)8, null);
                        Path path11 = this$0.getCheckerInfoCsvPath();
                        Intrinsics.checkNotNullExpressionValue((Object)path11, (String)"<get-checkerInfoCsvPath>(...)");
                        $checkerInfos.add(new CheckerInfo("Corax Checker", "1", "Java(canary)", "Java", checkerId, string9, category, name, map2, map3, tags, string10, string11, string12, string13, string14, this$0.toBoolean(CheckerInfoGenerator.getValueFromRowOrNull$default((CheckerInfoGenerator)this$0, (Object)path11, (Map)row, (String)"\u662f\u5426\u6709\u5b9e\u73b0", null, (int)8, null))));
                        continue block0;
                    }
                    while (object.hasNext()) {
                        String it$iv$iv;
                        String string15;
                        Object element$iv$iv$iv;
                        Object element$iv$iv7 = element$iv$iv$iv = object.next();
                        boolean bl8 = false;
                        String s = (String)element$iv$iv7;
                        boolean bl9 = false;
                        String it = string15 = ((Object)StringsKt.trim((CharSequence)s)).toString();
                        boolean bl10 = false;
                        if ((!StringsKt.isBlank((CharSequence)it) ? string15 : null) == null) continue;
                        it$iv$iv = it$iv$iv;
                        boolean bl11 = false;
                        destination$iv$iv2.add(it$iv$iv);
                    }
                    $this$mapNotNull$iv = (List)destination$iv$iv2;
                    boolean $i$f$map = false;
                    $this$mapNotNullTo$iv$iv = $this$map$iv;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                    boolean $i$f$mapTo = false;
                    for (Object item$iv$iv : $this$mapTo$iv$iv) {
                        void it;
                        object = (String)item$iv$iv;
                        Collection collection = destination$iv$iv2;
                        boolean bl12 = false;
                        collection.add(new Tag(stNameInJson, (String)it));
                    }
                    iterable = (List)destination$iv$iv2;
                }
                Iterable list$iv$iv = iterable;
                CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
            }
            break;
        }
        return Unit.INSTANCE;
    }

    private static final CharSequence checkAndAbort$lambda$43$lambda$42(Object it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Theme.Companion.getDefault().getWarning().invoke("W: " + it);
    }

    private static final Object checkAndAbort$lambda$43(CheckerInfoGenerator this$0) {
        return "\u53d1\u73b0 " + Theme.Companion.getDefault().getWarning().invoke(String.valueOf(this$0.warnings.size())) + " \u4e2a\u95ee\u9898, \n\t" + CollectionsKt.joinToString$default((Iterable)this$0.warnings, (CharSequence)"\n\t", null, null, (int)0, null, CheckerInfoGenerator::checkAndAbort$lambda$43$lambda$42, (int)30, null);
    }

    private static final CharSequence checkAndAbort$lambda$45$lambda$44(Object it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Theme.Companion.getDefault().getDanger().invoke("E: " + it);
    }

    private static final Object checkAndAbort$lambda$45(CheckerInfoGenerator this$0) {
        return "\u53d1\u73b0 " + Theme.Companion.getDefault().getDanger().invoke(String.valueOf(this$0.errors.size())) + " \u4e2a\u4e25\u91cd\u9519\u8bef, \n\t" + CollectionsKt.joinToString$default((Iterable)this$0.errors, (CharSequence)"\n\t", null, null, (int)0, null, CheckerInfoGenerator::checkAndAbort$lambda$45$lambda$44, (int)30, null);
    }

    private static final Object dumpRuleChaptersYaml$lambda$49(CheckerInfoGenerator this$0) {
        return "Successfully! File: " + this$0.getRuleChaptersYamlOutPath() + " has been generated.";
    }

    private static final Object dumpCheckerInfoJson$lambda$51(CheckerInfoGenerator this$0) {
        return "Successfully! File: " + this$0.getCheckerInfoJsonOutPath() + " has been generated.";
    }

    private static final Object dumpRuleAndRuleMappingDB$lambda$53(Path $dbPath) {
        return "Successfully! File: " + $dbPath + " has been generated.";
    }

    /*
     * WARNING - void declaration
     */
    private static final List getCheckerInfo$lambda$56(CheckerInfoGenerator this$0) {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = this$0.pluginDefinitions.getCheckTypeDefinition(CheckType.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            PluginDefinitions.CheckTypeDefinition checkTypeDefinition = (PluginDefinitions.CheckTypeDefinition)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getSingleton());
        }
        Iterable $this$sortedBy$iv = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        return CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */));
    }

    private static final List<CheckType> getCheckerInfo$lambda$57(Lazy<? extends List<? extends CheckType>> $checkTypes$delegate) {
        Lazy<? extends List<? extends CheckType>> lazy = $checkTypes$delegate;
        return (List)lazy.getValue();
    }

    private static final Object getCheckerInfo$lambda$61$lambda$60(LinkedHashSet $existsCheckerIds) {
        return "Found " + $existsCheckerIds.size() + " CheckTypes";
    }

    /*
     * WARNING - void declaration
     */
    private static final LinkedHashSet getCheckerInfo$lambda$61(Lazy $checkTypes$delegate) {
        void $this$mapTo$iv;
        Iterable iterable = CheckerInfoGenerator.getCheckerInfo$lambda$57((Lazy)$checkTypes$delegate);
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            CheckType checkType = (CheckType)item$iv;
            Collection collection = destination$iv;
            boolean bl = false;
            collection.add(CheckerInfoGeneratorKt.getId((CheckType)it));
        }
        LinkedHashSet existsCheckerIds = (LinkedHashSet)destination$iv;
        if (!(!((Collection)existsCheckerIds).isEmpty())) {
            boolean bl = false;
            String string = "Internal error! Failed to find any CheckType";
            throw new IllegalStateException(string.toString());
        }
        logger.info(() -> CheckerInfoGenerator.getCheckerInfo$lambda$61$lambda$60(existsCheckerIds));
        return existsCheckerIds;
    }

    private static final LinkedHashSet<String> getCheckerInfo$lambda$62(Lazy<? extends LinkedHashSet<String>> $existsCheckerIds$delegate) {
        Lazy<? extends LinkedHashSet<String>> lazy = $existsCheckerIds$delegate;
        return (LinkedHashSet)lazy.getValue();
    }

    private static final Unit logger$lambda$66() {
        return Unit.INSTANCE;
    }

    private static final Unit jsonFormat$lambda$67(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter((Object)$this$Json, (String)"$this$Json");
        $this$Json.setUseArrayPolymorphism(true);
        $this$Json.setPrettyPrint(true);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Json access$getJsonFormat$cp() {
        return jsonFormat;
    }

    public static final /* synthetic */ Yaml access$getYamlFormat$cp() {
        return yamlFormat;
    }

    public static final /* synthetic */ KSerializer access$getInfoSerializer$cp() {
        return infoSerializer;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }
}

