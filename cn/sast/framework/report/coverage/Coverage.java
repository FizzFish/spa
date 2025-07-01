package cn.sast.framework.report.coverage;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.coverage.ClassSourceInfo;
import cn.sast.framework.report.coverage.ClassSourceOfSCKey;
import cn.sast.framework.report.coverage.JacocoSourceLocator;
import cn.sast.framework.report.coverage.SourceCoverage;
import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisKey;
import com.github.benmanes.caffeine.cache.AsyncCacheLoader;
import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.analysis.IBundleCoverage;
import org.jacoco.core.analysis.ICoverageVisitor;
import org.jacoco.core.analysis.ISourceFileCoverage;
import org.jacoco.core.data.ExecutionData;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.core.data.SessionInfo;
import org.jacoco.core.data.SessionInfoStore;
import org.jacoco.core.internal.analysis.ClassAnalyzer;
import org.jacoco.core.internal.analysis.ClassCoverageImpl;
import org.jacoco.core.internal.analysis.StringPool;
import org.jacoco.core.internal.flow.ClassProbesAdapter;
import org.jacoco.core.internal.flow.ClassProbesVisitor;
import org.jacoco.report.DirectorySourceFileLocator;
import org.jacoco.report.ISourceFileLocator;
import org.jacoco.report.InputStreamSourceFileLocator;
import org.jacoco.report.MultiSourceFileLocator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.ClassVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.jimple.infoflow.collect.ConcurrentHashSet;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class Coverage {
    public static final Companion Companion = new Companion();
    private static final Logger logger = LoggerFactory.getLogger(Coverage.class);

    @Nullable
    private Instant startTimestamp;
    @NotNull
    private final StringPool stringPool = new StringPool();
    @NotNull
    private final Map<String, ClassCoverage> classCoverageMap = new ConcurrentHashMap<>(1000);
    @NotNull
    private final ConcurrentHashSet<JacocoCover> coverQueue = new ConcurrentHashSet<>();
    @NotNull
    private final AsyncLoadingCache<ClassSourceInfo, ClassCoverage> cache;
    @Nullable
    private Pair<ExecutionDataStore, ? extends CoverageBuilder> coverageBuilderPair;

    public Coverage() {
        this.cache = Caffeine.newBuilder()
                .buildAsync((key, executor) -> createClassCoverageFuture(key, executor));
    }

    private CompletableFuture<ClassCoverage> createClassCoverageFuture(ClassSourceInfo source, Executor executor) {
        String className = source.getClassName();
        long classId = source.getJacocoClassId();
        ClassCoverage classCoverage = new ClassCoverage(className, source.getByteArray(), classId);
        return CompletableFuture.supplyAsync(() -> {
            ClassVisitor visitor = createAnalyzingVisitor(classCoverage, classId, className);
            // Additional processing would go here
            return classCoverage;
        }, executor);
    }

    @NotNull
    public StringPool getStringPool() {
        return stringPool;
    }

    @NotNull
    public Map<String, ClassCoverage> getClassCoverageMap() {
        return classCoverageMap;
    }

    public void cover(@NotNull ClassSourceInfo clazz, int line) {
        ClassCoverage coverage = analyzeClass(clazz);
        if (coverage != null) {
            coverage.cover(line);
        }
    }

    public void cover(@NotNull String className, int line) {
        ClassSourceInfo source = AnalysisCache.G.INSTANCE.get(new ClassSourceOfSCKey(className));
        if (source != null) {
            cover(source, line);
        }
    }

    public void cover(@NotNull byte[] clazz, int line) {
        cover(ClassSourceInfo.Companion.invoke(clazz), line);
    }

    public void coverByQueue(@NotNull String className, int line) {
        coverQueue.add(new JacocoCover(className, line));
    }

    private ClassVisitor createAnalyzingVisitor(ClassCoverage classCoverage, long classId, String className) {
        ClassCoverageImpl coverage = new ClassCoverageImpl(className, classId, false);
        ClassAnalyzer analyzer = new ClassAnalyzer(coverage, stringPool, null);
        return new ClassProbesAdapter(analyzer, false);
    }

    @Nullable
    public ClassCoverage analyzeClass(@NotNull ClassSourceInfo source) {
        if (startTimestamp == null) {
            startTimestamp = Instant.now();
        }

        ClassCoverage existing = classCoverageMap.get(source.getClassName());
        if (existing != null) {
            return existing;
        }

        try {
            ClassCoverage coverage = cache.get(source).get();
            classCoverageMap.put(source.getClassName(), coverage);
            return coverage;
        } catch (Exception e) {
            logger.error("Failed to analyze class: " + source.getClassName(), e);
            return null;
        }
    }

    @NotNull
    public SessionInfo getSessionInfo() {
        Instant timestamp = startTimestamp != null ? startTimestamp : Instant.now();
        return new SessionInfo(UUID.randomUUID().toString(), timestamp.getEpochSecond(), Instant.now().getEpochSecond());
    }

    @NotNull
    public SessionInfoStore getSessionInfoStore() {
        SessionInfoStore store = new SessionInfoStore();
        store.visitSessionInfo(getSessionInfo());
        return store;
    }

    public void flushExecutionDataFile(@NotNull SessionInfoStore sessionInfoStore, 
                                     @NotNull ExecutionDataStore executionDataStore, 
                                     @NotNull IResFile dumpFile) throws IOException {
        dumpFile.mkdirs();
        // Implementation would write data to file
    }

    public boolean processCoverQueueData() {
        if (coverQueue.isEmpty()) {
            return false;
        }

        coverQueue.forEach(cover -> cover(cover.getClassName(), cover.getLine()));
        coverQueue.clear();
        return false;
    }

    @Nullable
    public Pair<ExecutionDataStore, ? extends CoverageBuilder> getCoverageBuilderPair() {
        return coverageBuilderPair;
    }

    public void setCoverageBuilderPair(@Nullable Pair<ExecutionDataStore, ? extends CoverageBuilder> pair) {
        this.coverageBuilderPair = pair;
    }

    @NotNull
    public Pair<ExecutionDataStore, CoverageBuilder> computeCoverageBuilder() {
        if (coverageBuilderPair != null && !processCoverQueueData()) {
            return coverageBuilderPair;
        }

        ExecutionDataStore executionDataStore = new ExecutionDataStore();
        CoverageBuilder coverageBuilder = makeCoverageBuilder(executionDataStore);

        classCoverageMap.values().forEach(classCoverage -> {
            boolean[] probes = new boolean[classCoverage.getCount()];
            classCoverage.getProbes().forEach(line -> probes[line] = true);
            
            try {
                String className = classCoverage.getClassName().replace(".", "/");
                executionDataStore.put(new ExecutionData(classCoverage.getClassId(), className, probes));
            } catch (Exception e) {
                logger.error("Error processing class: " + classCoverage.getClassName(), e);
            }
        });

        coverageBuilderPair = new Pair<>(executionDataStore, coverageBuilder);
        return coverageBuilderPair;
    }

    public void createReport(@NotNull CoverageBuilder coverageBuilder,
                           @NotNull SessionInfoStore sessionInfoStore,
                           @NotNull ExecutionDataStore executionDataStore,
                           @NotNull MultiSourceFileLocator mLocator,
                           @NotNull IResDirectory reportDirectory) throws IOException {
        IBundleCoverage bundle = coverageBuilder.getBundle("CoraxCoverage");
        createReport(sessionInfoStore, executionDataStore, bundle, mLocator, reportDirectory.getFile());
    }

    public void createReport(@NotNull SessionInfoStore sessionInfoStore,
                           @NotNull ExecutionDataStore executionDataStore,
                           @NotNull IBundleCoverage bundleCoverage,
                           @NotNull ISourceFileLocator locator,
                           @NotNull File reportDirectory) throws IOException {
        if (!reportDirectory.exists()) {
            reportDirectory.mkdir();
        }
        // Implementation would generate the actual report
        logger.info("Jacoco coverage html reports: {}", reportDirectory.getAbsolutePath());
    }

    @NotNull
    public CoverageBuilder makeCoverageBuilder(@NotNull ExecutionDataStore executionDataStore) {
        CoverageBuilder builder = new CoverageBuilder();
        Analyzer analyzer = new Analyzer(executionDataStore, builder);
        
        classCoverageMap.values().forEach(coverage -> 
            analyzer.analyzeClass(coverage.getByteArray(), coverage.getClassName()));
        
        return builder;
    }

    @NotNull
    public MultiSourceFileLocator getMultiSourceFileLocator(@NotNull IProjectFileLocator locator,
                                                          @NotNull Charset encoding) {
        List<ISourceFileLocator> locators = Arrays.asList(
            new DirectorySourceFileLocator(new File("."), encoding.name(), 4),
            new JacocoSourceLocator(locator, null, 0, 6, null)
        );
        
        MultiSourceFileLocator multiLocator = new MultiSourceFileLocator(4);
        locators.forEach(multiLocator::add);
        return multiLocator;
    }

    public void flushCoverage(@NotNull IProjectFileLocator locator,
                            @NotNull IResDirectory outputDir,
                            @NotNull Charset encoding) throws IOException {
        outputDir.deleteDirectoryRecursively();
        outputDir.mkdirs();
        
        Pair<ExecutionDataStore, CoverageBuilder> pair = computeCoverageBuilder();
        SessionInfoStore sessionInfoStore = getSessionInfoStore();
        
        flushExecutionDataFile(sessionInfoStore, pair.getFirst(), outputDir.resolve("jacoco.exec").toFile());
        
        MultiSourceFileLocator mLocator = getMultiSourceFileLocator(locator, encoding);
        createReport(pair.getSecond(), sessionInfoStore, pair.getFirst(), mLocator, outputDir);
    }

    @NotNull
    public SourceCoverage calculateSourceCoverage(@NotNull CoverageBuilder coverage,
                                                @NotNull MultiSourceFileLocator mLocator) {
        Map<String, SourceCoverage.JavaSourceCoverage> sourceCoverage = new LinkedHashMap<>();
        
        for (ISourceFileCoverage srcCov : coverage.getSourceFiles()) {
            String sourceKey = srcCov.getPackageName() + "/" + srcCov.getName();
            try (Reader reader = mLocator.getSourceFile(srcCov.getPackageName(), srcCov.getName())) {
                if (reader == null) continue;
                
                int lineCount = reader.lines().collect(Collectors.toList()).size();
                sourceCoverage.put(sourceKey, new SourceCoverage.JavaSourceCoverage(lineCount, srcCov));
            } catch (Exception e) {
                logger.error("Source file {} cannot be read!", sourceKey, e);
            }
        }
        
        return new SourceCoverage(sourceCoverage);
    }

    @NotNull
    public SourceCoverage calculateSourceCoverage(@NotNull IProjectFileLocator locator,
                                                @NotNull Charset encoding) {
        Pair<ExecutionDataStore, CoverageBuilder> pair = computeCoverageBuilder();
        MultiSourceFileLocator mLocator = getMultiSourceFileLocator(locator, encoding);
        return calculateSourceCoverage(pair.getSecond(), mLocator);
    }

    public static class Companion {
        private Companion() {}
    }

    public static class JacocoCover {
        private final String className;
        private final int line;

        public JacocoCover(String className, int line) {
            this.className = className;
            this.line = line;
        }

        public String getClassName() {
            return className;
        }

        public int getLine() {
            return line;
        }
    }

    public static class ClassCoverage {
        private final String className;
        private final byte[] byteArray;
        private final long classId;
        
        public ClassCoverage(String className, byte[] byteArray, long classId) {
            this.className = className;
            this.byteArray = byteArray;
            this.classId = classId;
        }
        
        // Other methods would be implemented here
    }

    public static class Pair<A, B> {
        private final A first;
        private final B second;
        
        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
        
        public A getFirst() {
            return first;
        }
        
        public B getSecond() {
            return second;
        }
    }
}
