package cn.sast.framework.report;

import app.cash.sqldelight.ExecutableQuery;
import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.TransactionWithoutReturn;
import cn.sast.api.AnalyzerEnv;
import cn.sast.api.config.CheckerInfoGenResult;
import cn.sast.api.config.ExtSettings;
import cn.sast.api.config.MainConfig;
import cn.sast.api.report.BugPathEvent;
import cn.sast.api.report.CheckType2StringKind;
import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.api.report.Report;
import cn.sast.api.util.PhaseIntervalTimerKt;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.Resource;
import cn.sast.common.ResourceImplKt;
import cn.sast.common.ResourceKt;
import cn.sast.framework.metrics.MetricsMonitor;
import cn.sast.framework.metrics.MetricsMonitorKt;
import cn.sast.framework.report.EmptyWrapperFileGenerator;
import cn.sast.framework.report.FileID;
import cn.sast.framework.report.FileX;
import cn.sast.framework.report.IFileReportConsumer;
import cn.sast.framework.report.IMetadataVisitor;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.IWrapperFileGenerator;
import cn.sast.framework.report.ReportConsumer;
import cn.sast.framework.report.RuleAndRuleMapping;
import cn.sast.framework.report.SQLiteDB;
import cn.sast.framework.report.ValueWithId;
import cn.sast.framework.report.metadata.AnalysisMetadata;
import cn.sast.framework.report.metadata.Analyzer;
import cn.sast.framework.report.metadata.AnalyzerStatistics;
import cn.sast.framework.report.metadata.Tool;
import cn.sast.framework.report.sqldelight.AnalyzerResultFile;
import cn.sast.framework.report.sqldelight.ControlFlow;
import cn.sast.framework.report.sqldelight.ControlFlowPath;
import cn.sast.framework.report.sqldelight.Database;
import cn.sast.framework.report.sqldelight.Diagnostic;
import cn.sast.framework.report.sqldelight.File;
import cn.sast.framework.report.sqldelight.Note;
import cn.sast.framework.report.sqldelight.NotePath;
import cn.sast.framework.report.sqldelight.Region;
import cn.sast.framework.report.sqldelight.Rule;
import cn.sast.framework.result.OutputType;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.cache.analysis.SootLineToMethodMapFactory;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.report.Region;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.javaparser.ast.body.BodyDeclaration;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SqliteDiagnostics extends ReportConsumer implements IFileReportConsumer, IMetadataVisitor {
    private static final Logger logger = LoggerFactory.getLogger(SqliteDiagnostics.class);
    private static final Json jsonFormat = Json.Default;

    private final MainConfig mainConfig;
    private final SootInfoCache info;
    private final MetricsMonitor monitor;
    private SQLiteDB sqLiteDB;
    private IResFile sqliteReportDb;
    private final ExecutorCoroutineDispatcher writeDispatcher;
    private RuleAndRuleMapping ruleAndRuleMapping;
    private final Map<IResFile, FileID> fileIdMap = Collections.synchronizedMap(new LinkedHashMap<>());
    private final LoadingCache<IResFile, Optional<FileX>> fileCache;
    private final Map<String, Long> noteHashIdAutoIncrement = new ConcurrentHashMap<>();
    private final Map<String, Long> ctrlFlowHashIdAutoIncrement = new ConcurrentHashMap<>();

    public SqliteDiagnostics(@NotNull MainConfig mainConfig, @Nullable SootInfoCache info, 
                           @NotNull IResDirectory outputDir, @Nullable MetricsMonitor monitor, 
                           @NotNull OutputType type) {
        super(type, outputDir);
        this.mainConfig = mainConfig;
        this.info = info;
        this.monitor = monitor;
        this.sqliteReportDb = mainConfig.getSqlite_report_db();
        
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        this.writeDispatcher = ExecutorsKt.from(executorService);
        
        this.fileCache = Caffeine.newBuilder()
            .initialCapacity(1000)
            .softValues()
            .build(key -> Optional.ofNullable(createFile(key)));
    }

    public @NotNull MainConfig getMainConfig() {
        return mainConfig;
    }

    public @Nullable SootInfoCache getInfo() {
        return info;
    }

    public @Nullable MetricsMonitor getMonitor() {
        return monitor;
    }

    private Database getDatabase() {
        return sqLiteDB.getDatabase();
    }

    public @NotNull ReportConsumer.MetaData getMetadata() {
        return new ReportConsumer.MetaData("CoraxJava sqlite report", "1.0", "CoraxJava");
    }

    public @NotNull Charset getSourceEncoding(@NotNull IResFile file) {
        return StandardCharsets.UTF_8;
    }

    private String getId(CheckType checkType) {
        return CheckType2StringKind.Companion.getCheckType2StringKind().getConvert().invoke(checkType);
    }

    public void open(@NotNull String journalMode) {
        sqliteReportDb.mkdirs();
        this.sqLiteDB = Companion.openDataBase(sqliteReportDb.getPathString(), journalMode);
        this.sqLiteDB.createSchema();
    }

    private void createRuleAndRuleMapping() {
        IResFile ruleSortYaml = mainConfig.getRule_sort_yaml();
        CheckerInfoGenResult checkerInfo = mainConfig.getCheckerInfo() != null ? 
            mainConfig.getCheckerInfo().getValue() : null;

        if (ruleSortYaml == null || checkerInfo == null) {
            logger.warn("rule_sort.yaml is not exists");
            return;
        }

        this.ruleAndRuleMapping = new RuleAndRuleMapping(checkerInfo, ruleSortYaml.getPath());
        this.ruleAndRuleMapping.insert(getDatabase());
    }

    private void verify(ExecutableQuery<?> query, String name) {
        List<?> result = query.executeAsList();
        if (!result.isEmpty()) {
            logger.error("reference of {}: {} is not exists in the parent table", name, result);
        }
    }

    public void verify() {
        Database db = getDatabase();
        verify(db.getRuleMappingQueries().verify_rule_name(), "RuleMapping.rule_name");
        verify(db.getDiagnosticQueries().verify_rule_name(), "diagnostic.rule_name");
        verify(db.getDiagnosticQueries().verify_file(), "diagnostic.__file_id");
        verify(db.getDiagnosticQueries().verify_note_path(), "diagnostic.__note_array_hash_id");
        verify(db.getDiagnosticQueries().verify_control_flow_path(), "diagnostic.__control_flow_array_hash_id");
        verify(db.getDiagnosticQueries().verify_macro(), "diagnostic.__macro_note_set_hash_id");
        verify(db.getNotePathQueries().verify_note(), "NotePath.__note_id");
        verify(db.getControlFlowPathQueries().verify_control_flow(), "ControlFlowPath.__control_flow_id");
        verify(db.getMacroExpansionQueries().verify_note(), "MacroExpansion.__macro_note_id");
        verify(db.getControlFlowQueries().verify_file(), "ControlFlow.__file_id");
        verify(db.getNoteQueries().verify_file(), "Note.__file_id");
        verify(db.getAnalyzeResultFileQueries().verify_file(), "AnalyzeResultFile.__file_id");
        verify(db.getAbsoluteFilePathQueries().verify_absolute_file_path(), "AbsoluteFilePath.__file_id");
    }

    public void close() {
        verify();
        sqLiteDB.close();
        sqLiteDB = null;
        noteHashIdAutoIncrement.clear();
        ctrlFlowHashIdAutoIncrement.clear();
        fileCache.cleanUp();
        fileIdMap.clear();
    }

    private FileX createFile(IResFile absFile) {
        byte[] bytesContent = ResourceKt.readAllBytes(absFile);
        String hash = ResourceImplKt.calculate(bytesContent, "sha256");
        Charset encoding = getSourceEncoding(absFile);
        List<String> lines = Arrays.asList(new String(bytesContent, encoding).split("\n"));
        IResource original = Resource.INSTANCE.getOriginFileFromExpandAbsPath(absFile);
        MainConfig.RelativePath relativePath = mainConfig.tryGetRelativePathFromAbsolutePath(original);
        String relativePathStr = relativePath.getRelativePath().replaceFirst("/", "");
        
        return new FileX(
            new File(-1L, hash, relativePathStr, lines.size(), 
                   encoding.name().toLowerCase(Locale.getDefault()), bytesContent.length, bytesContent),
            relativePath, absFile, lines
        );
    }

    private Rule getAssociateChecker(Report report) {
        return ruleAndRuleMapping != null ? 
            ruleAndRuleMapping.getId2checkerMap().get(report.getCheck_name()) : null;
    }

    private static class Companion {
        private Companion() {}
        
        public SQLiteDB openDataBase(String path, String journalMode) {
            return new SQLiteDB(path, journalMode);
        }
    }
}
