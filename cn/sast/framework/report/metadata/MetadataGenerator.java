package cn.sast.framework.report.metadata;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.OS;
import cn.sast.common.Resource;
import cn.sast.coroutines.MultiWorkerQueue;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.metadata.AnalysisMetadata;
import cn.sast.framework.report.metadata.Analyzer;
import cn.sast.framework.report.metadata.AnalyzerStatistics;
import cn.sast.framework.report.metadata.Counter;
import cn.sast.framework.report.metadata.Tool;
import org.jacoco.core.analysis.ICounter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.Scene;
import soot.SootClass;
import soot.jimple.infoflow.collect.ConcurrentHashSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class MetadataGenerator {
    private static final Logger logger = LoggerFactory.getLogger(MetadataGenerator.class);

    @Nullable
    private final String projectRoot;
    @NotNull
    private final List<String> multipleProjectRoot;
    @NotNull
    private final IResDirectory outputPath;
    @NotNull
    private final List<String> sourcePaths;
    @NotNull
    private final ICounter coveredCounter;
    @NotNull
    private final Set<IResFile> successfulFiles;
    @NotNull
    private final Set<IResFile> failedFiles;
    @NotNull
    private Map<String, String> resultSourceFiles = new LinkedHashMap<>();

    public MetadataGenerator(@Nullable String projectRoot, @NotNull List<String> multipleProjectRoot,
                           @NotNull IResDirectory outputPath, @NotNull List<String> sourcePaths,
                           @NotNull ICounter coveredCounter, @NotNull Set<IResFile> successfulFiles,
                           @NotNull Set<IResFile> failedFiles) {
        this.projectRoot = projectRoot;
        this.multipleProjectRoot = multipleProjectRoot;
        this.outputPath = outputPath;
        this.sourcePaths = sourcePaths;
        this.coveredCounter = coveredCounter;
        this.successfulFiles = successfulFiles;
        this.failedFiles = failedFiles;
    }

    public void updateResultSourceMapping(@NotNull String result, @NotNull String source) {
        resultSourceFiles.put(outputPath.resolve(result).getAbsolute().getNormalize().getPath().toString(), source);
    }

    @NotNull
    public AnalysisMetadata getMetadata(@NotNull IProjectFileLocator locator) {
        AtomicInteger fileCount = new AtomicInteger(0);
        AtomicInteger lineCount = new AtomicInteger(0);
        Set<SootClass> visited = new ConcurrentHashSet<>();

        MultiWorkerQueue task = new MultiWorkerQueue("Metadata", OS.getMaxThreadNum(), (clazz, worker) -> {
            if (!Scene.v().isExcluded(clazz)) {
                // Process class logic here
            }
        });

        for (SootClass appClass : Scene.v().getApplicationClasses()) {
            if (!Scene.v().isExcluded(appClass)) {
                task.dispatch(appClass);
            }
        }

        task.join();
        task.close();
        logger.info("Metadata: Java executable file path: {}", OS.getJavaExecutableFilePath());

        return generateMetaData(fileCount.get(), lineCount.get());
    }

    @NotNull
    public AnalysisMetadata generateFailedMetaData() {
        return generateMetaData(0, 0);
    }

    private AnalysisMetadata generateMetaData(int fileCount, int lineCount) {
        Counter counter = new Counter(coveredCounter.getMissedCount(), coveredCounter.getCoveredCount());
        List<String> sortedSourcePaths = new ArrayList<>(sourcePaths);
        Collections.sort(sortedSourcePaths);

        String osName = System.getProperty("os.name").toLowerCase(Locale.ROOT);

        List<String> failedFilePaths = failedFiles.stream()
                .map(file -> Resource.getOriginFileFromExpandPath(file).getPathString())
                .sorted()
                .collect(Collectors.toList());

        List<String> successfulFilePaths = successfulFiles.stream()
                .map(file -> Resource.getOriginFileFromExpandPath(file).getPathString())
                .sorted()
                .collect(Collectors.toList());

        AnalyzerStatistics analyzerStats = new AnalyzerStatistics(
                failedFiles.size(), failedFilePaths,
                successfulFiles.size(), successfulFilePaths, "");

        Map<String, Analyzer> analyzers = Map.of("corax", new Analyzer(analyzerStats, Collections.emptyMap()));

        List<String> commandLine = OS.getCommandLine();
        if (commandLine == null) {
            String javaHome = System.getProperty("java.home");
            commandLine = javaHome != null ? List.of(javaHome) : Collections.emptyList();
        }

        String outputPathStr = outputPath.getAbsolute().getNormalize().getPath().toString();
        String projectRootStr = projectRoot != null ? projectRoot : "";
        Map<String, String> sortedSourceMappings = new LinkedHashMap<>(resultSourceFiles);
        String userDir = System.getProperty("user.dir");

        Tool tool = new Tool(
                analyzers,
                commandLine,
                "corax",
                outputPathStr,
                projectRootStr,
                multipleProjectRoot,
                sortedSourceMappings,
                userDir
        );

        return new AnalysisMetadata(
                fileCount,
                lineCount,
                counter,
                1,
                sortedSourcePaths,
                osName,
                List.of(tool)
        );
    }
}
