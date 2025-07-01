package cn.sast.framework.report;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.ScanFilter;
import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.api.report.Report;
import cn.sast.api.util.IMonitor;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.ResourceKt;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.IReportConsumer;
import cn.sast.framework.report.IWrapperFileGenerator;
import cn.sast.framework.report.NullWrapperFileGenerator;
import cn.sast.framework.report.coverage.JacocoCompoundCoverage;
import cn.sast.idfa.progressbar.ProgressBarExt;
import com.feysh.corax.config.api.rules.ProcessRule;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.Scene;
import soot.SootClass;
import soot.util.Chain;

public final class ReportConverter {
    private static final Logger logger = LoggerFactory.getLogger(ReportConverter.class);
    
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final ProgressBarExt progressBarExt;

    public ReportConverter(@NotNull MainConfig mainConfig, @NotNull ProgressBarExt progressBarExt) {
        if (mainConfig == null) throw new IllegalArgumentException("mainConfig cannot be null");
        if (progressBarExt == null) throw new IllegalArgumentException("progressBarExt cannot be null");
        this.mainConfig = mainConfig;
        this.progressBarExt = progressBarExt;
    }

    public ReportConverter(@NotNull MainConfig mainConfig) {
        this(mainConfig, new ProgressBarExt());
    }

    @NotNull
    public MainConfig getMainConfig() {
        return mainConfig;
    }

    private Set<IResFile> filterSourceFiles(Collection<? extends IResFile> sources) {
        return sources.stream()
            .filter(file -> file != null)
            .filter(file -> {
                if ("kts".equals(file.getExtension()) && file.getName().contains("gradle")) {
                    return false;
                }
                if (file.getName().contains("package-info")) {
                    return false;
                }
                return mainConfig.getScanFilter().getActionOf(file.getPath()) != ProcessRule.ScanAction.Skip;
            })
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private Pair<Set<IResFile>, Set<IResFile>> reportSourceFileWhichClassNotFound(
            Set<? extends IResFile> allSourceFiles, 
            IResDirectory outputDir, 
            IProjectFileLocator locator) {
        
        IMonitor monitor = mainConfig.getMonitor();
        if (monitor != null && monitor.getProjectMetrics() != null) {
            monitor.getProjectMetrics().setTotalSourceFileNum(allSourceFiles.size());
        }

        Chain appClasses = Scene.v().getApplicationClasses();
        Chain libClasses = Scene.v().getLibraryClasses();
        List<SootClass> allNonPhantomClasses = new ArrayList<>();
        appClasses.forEach(cls -> {
            if (!cls.isPhantom()) allNonPhantomClasses.add(cls);
        });
        libClasses.forEach(cls -> {
            if (!cls.isPhantom()) allNonPhantomClasses.add(cls);
        });

        Map<SootClass, IResFile> foundSourceCodes = new LinkedHashMap<>();
        for (SootClass cls : allNonPhantomClasses) {
            IResFile file = locator.get(new ClassResInfo(cls), NullWrapperFileGenerator.INSTANCE);
            if (file != null) {
                foundSourceCodes.put(cls, file);
            }
        }

        Set<IResFile> classFoundSourceFiles = new LinkedHashSet<>(foundSourceCodes.values());
        Set<IResFile> classNotFoundSourceFile = new LinkedHashSet<>(allSourceFiles);
        classNotFoundSourceFile.removeAll(classFoundSourceFiles);

        IResFile nfd = outputDir.resolve("source_files_which_class_not_found.txt").toFile();
        if (!classNotFoundSourceFile.isEmpty()) {
            logger.warn("Incomplete analysis! {} source files not found any class!!! check: {}", 
                classNotFoundSourceFile.size(), nfd.getAbsolute().getNormalize());
            
            try (OutputStreamWriter writer = new OutputStreamWriter(
                    Files.newOutputStream(nfd.getPath()), StandardCharsets.UTF_8)) {
                
                classNotFoundSourceFile.stream()
                    .sorted(Comparator.comparing(IResFile::getName))
                    .forEach(file -> {
                        try {
                            writer.write(file + "\n");
                        } catch (IOException e) {
                            logger.error("Failed to write source file", e);
                        }
                    });
            } catch (IOException e) {
                logger.error("Failed to create report of missing source files", e);
            }
        } else {
            try {
                Files.deleteIfExists(nfd.getPath());
            } catch (IOException e) {
                logger.error("Failed to delete empty report file", e);
            }
        }

        return new Pair<>(classFoundSourceFiles, classNotFoundSourceFile);
    }

    public void flush(
            @NotNull MainConfig mainConfig,
            @NotNull IProjectFileLocator locator,
            @NotNull JacocoCompoundCoverage coverage,
            @NotNull List<? extends IReportConsumer> consumers,
            @NotNull Collection<Report> reports,
            @NotNull IResDirectory outputDir) {
        
        // Implementation of coroutine scope would go here
        // Simplified for Java version without coroutines
    }
}
