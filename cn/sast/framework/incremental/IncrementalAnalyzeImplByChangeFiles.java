package cn.sast.framework.incremental;

import cn.sast.api.config.MainConfig;
import cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles;
import cn.sast.api.incremental.ModifyInfoFactory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.framework.report.AbstractFileIndexer;
import cn.sast.framework.report.ProjectFileLocator;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.patch.FileHeader;
import org.eclipse.jgit.patch.Patch;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.Scene;
import soot.SootClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.*;
import java.util.function.Consumer;

public final class IncrementalAnalyzeImplByChangeFiles implements IncrementalAnalyzeByChangeFiles {
    private static final Logger logger = LoggerFactory.getLogger(IncrementalAnalyzeImplByChangeFiles.class);

    private final MainConfig mainConfig;
    private final boolean mappingDiffInArchive;
    private final ModifyInfoFactory factory;
    private final IncrementalAnalyzeByChangeFiles.SimpleDeclAnalysisDependsGraph simpleDeclAnalysisDependsGraph;
    private final IncrementalAnalyzeByChangeFiles.InterProceduralAnalysisDependsGraph interProceduralAnalysisDependsGraph;
    private final Set<String> modifyFiles = new LinkedHashSet<>();
    private final Map<String, DiffEntry> oldPath2Header = new LinkedHashMap<>();
    private final Map<String, FileHeader> newPath2Header = new LinkedHashMap<>();
    private final Set<String> pathsInPatch = new LinkedHashSet<>();
    private final Map<String, Set<String>> name2Path = new HashMap<>();
    private boolean ignoreCase;

    public IncrementalAnalyzeImplByChangeFiles(
            @NotNull MainConfig mainConfig,
            boolean mappingDiffInArchive,
            @NotNull ModifyInfoFactory factory,
            @NotNull IncrementalAnalyzeByChangeFiles.SimpleDeclAnalysisDependsGraph simpleDeclAnalysisDependsGraph,
            @NotNull IncrementalAnalyzeByChangeFiles.InterProceduralAnalysisDependsGraph interProceduralAnalysisDependsGraph) {
        this.mainConfig = Objects.requireNonNull(mainConfig, "mainConfig");
        this.mappingDiffInArchive = mappingDiffInArchive;
        this.factory = Objects.requireNonNull(factory, "factory");
        this.simpleDeclAnalysisDependsGraph = Objects.requireNonNull(simpleDeclAnalysisDependsGraph, "simpleDeclAnalysisDependsGraph");
        this.interProceduralAnalysisDependsGraph = Objects.requireNonNull(interProceduralAnalysisDependsGraph, "interProceduralAnalysisDependsGraph");
    }

    @Override
    public @NotNull IncrementalAnalyzeByChangeFiles.SimpleDeclAnalysisDependsGraph getSimpleDeclAnalysisDependsGraph() {
        return simpleDeclAnalysisDependsGraph;
    }

    @Override
    public @NotNull IncrementalAnalyzeByChangeFiles.InterProceduralAnalysisDependsGraph getInterProceduralAnalysisDependsGraph() {
        return interProceduralAnalysisDependsGraph;
    }

    private void visitChangedDecl(Object target, String diffPath, DiffEntry diff) {
        if (!pathsInPatch.contains(diffPath)) {
            throw new IllegalStateException("Check failed.");
        }
        Collection<?> changed = factory.getPatchedDeclsByDiff(target, diff);
        simpleDeclAnalysisDependsGraph.visitChangedDecl(diffPath, changed);
        interProceduralAnalysisDependsGraph.visitChangedDecl(diffPath, changed);
    }

    public void update(@NotNull Scene scene, @Nullable ProjectFileLocator locator) {
        Objects.requireNonNull(scene, "scene");
        
        for (SootClass clazz : scene.getClasses()) {
            Pair<DiffEntry, DiffEntry> changeType = getChangeTypeOfClass(clazz);
            DiffEntry old = changeType.getFirst();
            DiffEntry diffEntry = changeType.getSecond();
            
            if (old != null) {
                visitChangedDecl(clazz, old.getOldPath(), old);
            }
            if (diffEntry != null) {
                visitChangedDecl(clazz, diffEntry.getNewPath(), diffEntry);
            }
        }

        if (locator != null) {
            for (String p : pathsInPatch) {
                locator.findFromFileIndexMap(p.split("/"), AbstractFileIndexer.CompareMode.Path)
                    .forEach(it -> {
                        if (!mappingDiffInArchive && MainConfig.skipResourceInArchive(mainConfig, it)) {
                            return;
                        }
                        
                        DiffEntry old = oldPath2Header.get(p);
                        FileHeader fileHeader = newPath2Header.get(p);
                        
                        if (old != null) {
                            visitChangedDecl(it, p, old);
                        }
                        if (fileHeader != null) {
                            visitChangedDecl(it, p, (DiffEntry)fileHeader);
                        }
                    });
            }
        }
    }

    private Pair<DiffEntry, DiffEntry> getChangeType(Collection<String> possibleSourceFiles, AbstractFileIndexer.CompareMode mode) {
        // Implementation simplified for brevity
        return new Pair<>(null, null);
    }

    @Override
    public @NotNull Pair<DiffEntry, DiffEntry> getChangeTypeOfClass(@NotNull SootClass cls) {
        Objects.requireNonNull(cls, "cls");
        return getChangeType(SootUtils.getPossibleSourceFiles(cls), AbstractFileIndexer.getDefaultClassCompareMode());
    }

    @Override
    public @NotNull Pair<DiffEntry, DiffEntry> getChangeTypeOfFile(@NotNull String file) {
        Objects.requireNonNull(file, "file");
        return getChangeType(Collections.singletonList(file), AbstractFileIndexer.CompareMode.Path);
    }

    public void parseIncrementBaseFile(@NotNull IResource base) {
        Objects.requireNonNull(base, "base");
        
        if (!base.getExists()) {
            throw new IllegalStateException("The incremental base file: `" + base + "` not exists");
        }
        if (!base.isFile()) {
            throw new IllegalStateException("The incremental base file: `" + base + "` is not a file");
        }
        
        IResFile file = base.toFile();
        switch (file.getExtension()) {
            case "txt":
                parseChangeFiles(file);
                break;
            case "patch":
            case "diff":
                parseGitDiff(file);
                break;
            default:
                throw new IllegalStateException("The incremental base file: `" + base + 
                    "` with a unsupported extension. Now only support .diff/.patch/.txt");
        }
    }

    private void addOnePath(String p) {
        if (p.contains("\\")) {
            throw new IllegalStateException("Check failed.");
        }
        pathsInPatch.add(p);
        String name = p.replaceAll("/$", "").replaceAll(".*/", "");
        name2Path.computeIfAbsent(name, k -> new LinkedHashSet<>()).add(p);
    }

    private String normalizePath(String p) {
        String normalized = p.replace("\\", "/").replace("//", "/").replace("\r", "");
        if (ignoreCase) {
            normalized = normalized.toLowerCase(Locale.getDefault());
        }
        return normalized;
    }

    private void parseChangeFiles(IResFile diffFilePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Files.newInputStream(diffFilePath.getPath()), 8192)) {
            reader.lines()
                .map(line -> line.replace("\n", ""))
                .filter(line -> !line.isEmpty())
                .forEach(line -> {
                    String file = normalizePath(line);
                    modifyFiles.add(file);
                    addOnePath(file);
                    oldPath2Header.put(file, new DiffEntry());
                });
        }
    }

    private void parseGitDiff(IResFile diffFilePath) throws IOException {
        Patch p = new Patch();
        try (InputStream stream = Files.newInputStream(diffFilePath.getPath())) {
            p.parse(stream);
        }
        
        if (p.getFiles().isEmpty()) {
            logger.error("The patch file {} has no any change files", diffFilePath);
            return;
        }
        
        for (FileHeader handler : p.getFiles()) {
            if (handler.getOldPath() != null) {
                String oldPath = normalizePath(handler.getOldPath());
                oldPath2Header.put(oldPath, handler);
                addOnePath(oldPath);
            }
            if (handler.getNewPath() != null) {
                String newPath = normalizePath(handler.getNewPath());
                newPath2Header.put(newPath, handler);
                addOnePath(newPath);
            }
        }
    }
}
