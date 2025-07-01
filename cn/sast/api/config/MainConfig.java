package cn.sast.api.config;

import cn.sast.api.config.CheckerInfoGenResult;
import cn.sast.api.config.SaConfig;
import cn.sast.api.config.ScanFilter;
import cn.sast.api.config.SrcPrecedence;
import cn.sast.api.config.StaticFieldTrackingMode;
import cn.sast.api.incremental.IncrementalAnalyze;
import cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles;
import cn.sast.api.util.IMonitor;
import cn.sast.common.FileSystemLocator;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.OS;
import cn.sast.common.Resource;
import cn.sast.common.ResourceImplKt;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.rules.ProcessRule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.Scene;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public final class MainConfig {
    public static final String CHECKER_INFO_CSV_NAME = "checker_info.csv";
    public static final String RULE_SORT_YAML = "rule_sort.yaml";
    
    private static final List<Language> preferredLanguages = List.of(Language.ZH, Language.EN);
    private static final Set<String> excludeFiles = Set.of("classes-header.jar", "classes-turbine.jar");
    private static final Logger logger = LoggerFactory.getLogger(MainConfig.class);

    @NotNull private final Charset sourceEncoding;
    @Nullable private IMonitor monitor;
    @Nullable private SaConfig saConfig;
    @NotNull private IResDirectory output_dir;
    private boolean dumpSootScene;
    private boolean use_wrapper;
    private boolean hideNoSource;
    @NotNull private FileSystemLocator.TraverseMode traverseMode;
    private boolean useDefaultJavaClassPath;
    @NotNull private Set<IResource> processDir;
    @NotNull private Set<String> classpath;
    @NotNull private Set<IResource> projectRoot;
    @NotNull private Set<IResource> autoAppClasses;
    @NotNull private FileSystemLocator.TraverseMode autoAppTraverseMode;
    private boolean autoAppSrcInZipScheme;
    private boolean skipClass;
    @Nullable private IncrementalAnalyze incrementAnalyze;
    private boolean enableLineNumbers;
    private boolean enableOriginalNames;
    private int output_format;
    private int throw_analysis;
    private boolean process_multiple_dex;
    @NotNull private Set<String> appClasses;
    @NotNull private SrcPrecedence src_precedence;
    @NotNull private List<String> ecj_options;
    @Nullable private String sunBootClassPath;
    @Nullable private String javaExtDirs;
    private boolean hashAbspathInPlist;
    private boolean deCompileIfNotExists;
    private boolean enableCodeMetrics;
    private boolean prepend_classpath;
    private boolean whole_program;
    private boolean no_bodies_for_excluded;
    private boolean allow_phantom_refs;
    private boolean enableReflection;
    @NotNull private StaticFieldTrackingMode staticFieldTrackingMode;
    private double memoryThreshold;
    @Nullable private String version;
    @Nullable private CheckerInfoGenResult checkerInfo;
    @NotNull private final List<IResource> configDirs = new ArrayList<>();
    private boolean apponly;
    @NotNull private Set<IResource> sourcePath = new HashSet<>();
    @NotNull private Set<FileSystem> sourcePathZFS = new HashSet<>();
    @NotNull private List<IResource> rootPathsForConvertRelativePath = List.of();
    @NotNull private List<String> allResourcePathNormalized = List.of();
    @NotNull private String callGraphAlgorithm;
    @NotNull private String callGraphAlgorithmBuiltIn;
    @Nullable private Boolean isAndroidScene;
    private int parallelsNum;
    @Nullable private Boolean forceAndroidJar;
    @Nullable private String androidPlatformDir;
    @NotNull private ScanFilter scanFilter;
    @NotNull private ProjectConfig projectConfig;

    public MainConfig(
            @NotNull Charset sourceEncoding,
            @Nullable IMonitor monitor,
            @Nullable SaConfig saConfig,
            @NotNull IResDirectory output_dir,
            boolean dumpSootScene,
            @Nullable String androidPlatformDir,
            boolean use_wrapper,
            boolean hideNoSource,
            @NotNull FileSystemLocator.TraverseMode traverseMode,
            boolean useDefaultJavaClassPath,
            @NotNull Set<IResource> processDir,
            @NotNull Set<String> classpath,
            @NotNull Set<IResource> sourcePath,
            @NotNull Set<IResource> projectRoot,
            @NotNull Set<IResource> autoAppClasses,
            @NotNull FileSystemLocator.TraverseMode autoAppTraverseMode,
            boolean autoAppSrcInZipScheme,
            boolean skipClass,
            @Nullable IncrementalAnalyze incrementAnalyze,
            boolean enableLineNumbers,
            boolean enableOriginalNames,
            int output_format,
            int throw_analysis,
            boolean process_multiple_dex,
            @NotNull Set<String> appClasses,
            @NotNull SrcPrecedence src_precedence,
            @NotNull List<String> ecj_options,
            @Nullable String sunBootClassPath,
            @Nullable String javaExtDirs,
            boolean hashAbspathInPlist,
            boolean deCompileIfNotExists,
            boolean enableCodeMetrics,
            boolean prepend_classpath,
            boolean whole_program,
            boolean no_bodies_for_excluded,
            boolean allow_phantom_refs,
            boolean enableReflection,
            @NotNull StaticFieldTrackingMode staticFieldTrackingMode,
            @NotNull String callGraphAlgorithm,
            @NotNull String callGraphAlgorithmBuiltIn,
            double memoryThreshold) {
        this.sourceEncoding = sourceEncoding;
        this.monitor = monitor;
        this.saConfig = saConfig;
        this.output_dir = output_dir;
        this.dumpSootScene = dumpSootScene;
        this.use_wrapper = use_wrapper;
        this.hideNoSource = hideNoSource;
        this.traverseMode = traverseMode;
        this.useDefaultJavaClassPath = useDefaultJavaClassPath;
        this.processDir = new HashSet<>(processDir);
        this.classpath = new HashSet<>(classpath);
        this.projectRoot = new HashSet<>(projectRoot);
        this.autoAppClasses = new HashSet<>(autoAppClasses);
        this.autoAppTraverseMode = autoAppTraverseMode;
        this.autoAppSrcInZipScheme = autoAppSrcInZipScheme;
        this.skipClass = skipClass;
        this.incrementAnalyze = incrementAnalyze;
        this.enableLineNumbers = enableLineNumbers;
        this.enableOriginalNames = enableOriginalNames;
        this.output_format = output_format;
        this.throw_analysis = throw_analysis;
        this.process_multiple_dex = process_multiple_dex;
        this.appClasses = new HashSet<>(appClasses);
        this.src_precedence = src_precedence;
        this.ecj_options = new ArrayList<>(ecj_options);
        this.sunBootClassPath = sunBootClassPath;
        this.javaExtDirs = javaExtDirs;
        this.hashAbspathInPlist = hashAbspathInPlist;
        this.deCompileIfNotExists = deCompileIfNotExists;
        this.enableCodeMetrics = enableCodeMetrics;
        this.prepend_classpath = prepend_classpath;
        this.whole_program = whole_program;
        this.no_bodies_for_excluded = no_bodies_for_excluded;
        this.allow_phantom_refs = allow_phantom_refs;
        this.enableReflection = enableReflection;
        this.staticFieldTrackingMode = staticFieldTrackingMode;
        this.memoryThreshold = memoryThreshold;
        this.callGraphAlgorithm = callGraphAlgorithm.toLowerCase(Locale.getDefault());
        this.callGraphAlgorithmBuiltIn = callGraphAlgorithmBuiltIn.toLowerCase(Locale.getDefault());
        this.isAndroidScene = false;
        this.parallelsNum = Math.max(OS.INSTANCE.getMaxThreadNum() - 1, 1);
        this.androidPlatformDir = androidPlatformDir;
        this.scanFilter = new ScanFilter(this, null);
        this.projectConfig = new ProjectConfig();
        setSourcePath(sourcePath);
        this.scanFilter.update(this.projectConfig);
    }

    // Getters and setters for all fields
    @NotNull public Charset getSourceEncoding() { return sourceEncoding; }
    @Nullable public IMonitor getMonitor() { return monitor; }
    public void setMonitor(@Nullable IMonitor monitor) { this.monitor = monitor; }
    @Nullable public SaConfig getSaConfig() { return saConfig; }
    public void setSaConfig(@Nullable SaConfig saConfig) { this.saConfig = saConfig; }
    @NotNull public IResDirectory getOutput_dir() { return output_dir; }
    public void setOutput_dir(@NotNull IResDirectory output_dir) { this.output_dir = output_dir; }
    public boolean getDumpSootScene() { return dumpSootScene; }
    public void setDumpSootScene(boolean dumpSootScene) { this.dumpSootScene = dumpSootScene; }
    // ... (similar for all other fields)
    public final IncrementalAnalyze getIncrementAnalyze() {
        return this.incrementAnalyze;
    }


    public void setSourcePath(@NotNull Set<IResource> value) {
        this.sourcePath = new HashSet<>(value);
        this.sourcePathZFS = value.stream()
                .filter(IResource::getZipLike)
                .map(res -> {
                    try {
                        return Resource.INSTANCE.getZipFileSystem(res.getPath());
                    } catch (Exception e) {
                        return null;
                    }
                })
                .filter(java.util.Objects::nonNull)
                .collect(Collectors.toSet());
    }

    @NotNull
    public Set<String> skipInvalidClassPaths(@NotNull Collection<String> paths) {
        return paths.stream()
                .filter(path -> {
                    if (isSkipClassSource(path)) {
                        logger.info("Exclude class path: " + path);
                        return false;
                    }
                    try {
                        IResource res = Resource.INSTANCE.of(path);
                        if (res.isFile() && res.getZipLike()) {
                            try {
                                Resource.INSTANCE.getEntriesUnsafe(res.getPath());
                                return true;
                            } catch (Exception e) {
                                logger.error("skip the invalid archive file: " + res + " e: " + e.getMessage());
                                return false;
                            }
                        }
                        return true;
                    } catch (Exception e) {
                        return true;
                    }
                })
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public boolean isSkipClassSource(@NotNull Path path) {
        return scanFilter.getActionOfClassPath("Process", path, null) == ProcessRule.ScanAction.Skip;
    }

    public boolean isSkipClassSource(@NotNull String path) {
        try {
            Path p = Path.of(path);
            if (!Files.exists(p)) return false;
            return isSkipClassSource(p);
        } catch (Exception ignore) {
            return false;
        }
    }

    @NotNull
    public Set<String> getSoot_process_dir() {
        Set<IResource> allResources = new HashSet<>(processDir);
        allResources.addAll(autoAppClasses);
        return skipInvalidClassPaths(allResources.stream()
                .map(res -> res.expandRes(output_dir).getAbsolutePath())
                .collect(Collectors.toList()));
    }

    @NotNull
    public IResource getSoot_output_dir() {
        return output_dir.resolve("sootOutPut");
    }

    @Nullable
    public Boolean getForceAndroidJar() {
        if (forceAndroidJar == null) {
            String platformDir = getAndroidPlatformDir();
            if (platformDir == null || platformDir.isEmpty()) {
                return null;
            }
            File f = new File(platformDir);
            if (!f.exists()) {
                throw new IllegalArgumentException("androidPlatformDir not exist");
            }
            forceAndroidJar = f.isFile();
        }
        return forceAndroidJar;
    }

    public void validate() {
        if (classpath.stream().anyMatch(String::isEmpty)) {
            throw new IllegalStateException("classpath has empty string");
        }
        if (processDir.stream().anyMatch(res -> res.toString().isEmpty())) {
            throw new IllegalStateException("processDir has empty string");
        }
        if (sourcePath.stream().anyMatch(res -> res.toString().isEmpty())) {
            throw new IllegalStateException("sourcePath has empty string");
        }
    }

    public boolean isEnable(@NotNull CheckType type) {
        return saConfig == null || saConfig.isEnable(type);
    }

    public boolean isAnyEnable(CheckType... type) {
        return Arrays.stream(type).anyMatch(this::isEnable);
    }

    public static class RelativePath {
        private final String base;
        private final String path;

        public RelativePath(String base, String path) {
            this.base = base;
            this.path = path;
        }

        public String getBase() { return base; }
        public String getPath() { return path; }
    }

    @NotNull
    public RelativePath tryGetRelativePathFromAbsolutePath(@NotNull String abs) {
        for (String src : allResourcePathNormalized) {
            if (abs.startsWith(src)) {
                String normalizedSrc = src.replace("\\", "/").replace("//", "/");
                if (normalizedSrc.endsWith("/")) {
                    normalizedSrc = normalizedSrc.substring(0, normalizedSrc.length() - 1);
                }
                return new RelativePath(normalizedSrc, getRelativePathString(src, abs));
            }
        }
        return new RelativePath("", abs.replace("\\", "/").replace("//", "/"));
    }

    private String getRelativePathString(String src, String path) {
        String relative = path.substring(src.length());
        relative = relative.replace("\\", "/").replace("//", "/");
        if (relative.startsWith("!/")) {
            relative = relative.substring(1);
        } else if (!relative.startsWith("/")) {
            relative = "/" + relative;
        }
        return relative;
    }

    @NotNull
    public <E> Collection<E> simpleDeclIncrementalAnalysisFilter(@NotNull Collection<? extends E> targets) {
        if (!(incrementAnalyze instanceof IncrementalAnalyzeByChangeFiles)) {
            return new ArrayList<>(targets);
        }
        IncrementalAnalyzeByChangeFiles incAnalysis = (IncrementalAnalyzeByChangeFiles) incrementAnalyze;
        if (incAnalysis.getSimpleDeclAnalysisDependsGraph() == null) {
            return new ArrayList<>(targets);
        }
        return targets.stream()
                .filter(target -> incAnalysis.getSimpleDeclAnalysisDependsGraph().shouldReAnalyzeTarget(target) != ProcessRule.ScanAction.Skip)
                .collect(Collectors.toList());
    }
}
