package cn.sast.framework.compiler;

import cn.sast.common.IResource;
import org.eclipse.jdt.core.compiler.CompilationProgress;
import org.eclipse.jdt.internal.compiler.batch.FileSystem;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class EcjCompiler extends Main {
    private static final Logger logger = LoggerFactory.getLogger(EcjCompiler.class);
    
    @NotNull private final Set<IResource> sourcePath;
    @NotNull private final Set<String> classpath;
    @NotNull private final IResource classOpt;
    @NotNull private final List<String> customOptions;
    private final boolean useDefaultJava;
    @NotNull private final Set<String> collectClassPath = new LinkedHashSet<>();
    @NotNull private final Set<String> currentClasspathNameHack = new LinkedHashSet<>();

    public EcjCompiler(@NotNull Set<? extends IResource> sourcePath,
                      @NotNull Set<String> classpath,
                      @NotNull IResource classOpt,
                      @NotNull List<String> customOptions,
                      boolean useDefaultJava,
                      @NotNull PrintWriter outWriter,
                      @NotNull PrintWriter errWriter,
                      boolean systemExitWhenFinished,
                      @Nullable Map<String, String> customDefaultOptions,
                      @Nullable CompilationProgress compilationProgress) {
        super(outWriter, errWriter, systemExitWhenFinished, customDefaultOptions, compilationProgress);
        this.sourcePath = Set.copyOf(sourcePath);
        this.classpath = Set.copyOf(classpath);
        this.classOpt = classOpt;
        this.customOptions = List.copyOf(customOptions);
        this.useDefaultJava = useDefaultJava;
    }

    @NotNull
    public Set<IResource> getSourcePath() {
        return sourcePath;
    }

    @NotNull
    public Set<String> getClasspath() {
        return classpath;
    }

    @NotNull
    public IResource getClassOpt() {
        return classOpt;
    }

    @NotNull
    public List<String> getCustomOptions() {
        return customOptions;
    }

    public boolean isUseDefaultJava() {
        return useDefaultJava;
    }

    @NotNull
    public Set<String> getCollectClassPath() {
        return collectClassPath;
    }

    private ArrayList<FileSystem.Classpath> getDefaultClasspath() {
        return super.handleClasspath(null, null);
    }

    @Override
    protected void addNewEntry(@Nullable ArrayList<FileSystem.Classpath> paths,
                             @NotNull String currentClasspathName,
                             @Nullable ArrayList<String> currentRuleSpecs,
                             @Nullable String customEncoding,
                             @Nullable String destPath,
                             boolean isSourceOnly,
                             boolean rejectDestinationPathOnJars) {
        currentClasspathNameHack.add(currentClasspathName);
        super.addNewEntry(paths, currentClasspathName, currentRuleSpecs, customEncoding, destPath, isSourceOnly, rejectDestinationPathOnJars);
    }

    private ArrayList<FileSystem.Classpath> getPathsFrom(String path) {
        currentClasspathNameHack.clear();
        ArrayList<FileSystem.Classpath> paths = new ArrayList<>();
        try {
            processPathEntries(4, paths, path, null, false, false);
        } catch (IllegalArgumentException e) {
            return null;
        }
        return paths;
    }

    private List<String> replace(String ecjClasspathName) {
        ArrayList<FileSystem.Classpath> path = getPathsFrom(ecjClasspathName);
        if (currentClasspathNameHack.size() != 1 || path == null || path.size() != 1) {
            collectClassPath.add(ecjClasspathName);
            return List.of(ecjClasspathName);
        }

        String origClassPathFileName = currentClasspathNameHack.iterator().next();
        List<String> res = new ArrayList<>();
        
        if (!origClassPathFileName.isEmpty()) {
            File cpf = new File(origClassPathFileName);
            if (!cpf.exists()) {
                Path parentPath = cpf.getParentFile().toPath();
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(parentPath, cpf.getName())) {
                    for (Path subClasspathName : stream) {
                        res.add(ecjClasspathName.replace(origClassPathFileName, subClasspathName.toString()));
                        collectClassPath.add(subClasspathName.toString());
                    }
                    return res;
                } catch (Exception e) {
                    logger.warn("Failed to process directory", e);
                }
            }
        }
        
        collectClassPath.add(ecjClasspathName);
        return List.of(ecjClasspathName);
    }

    public boolean compile() {
        List<String> args = new ArrayList<>();
        
        if (customOptions.isEmpty()) {
            Set<String> classpathSet = new LinkedHashSet<>(classpath);
            args.addAll(List.of("-source", "11", "-target", "11", "-proceedOnError", "-warn:none", 
                              "-g:lines,vars,source", "-preserveAllLocals"));
            
            if (!classpathSet.isEmpty()) {
                Map<String, List<String>> replacedClassPathNames = new LinkedHashMap<>();
                for (String path : classpathSet) {
                    replacedClassPathNames.put(path, replace(path));
                }
                
                List<String> classPathRule = new ArrayList<>();
                for (List<String> paths : replacedClassPathNames.values()) {
                    classPathRule.addAll(paths);
                }
                
                if (useDefaultJava) {
                    for (FileSystem.Classpath cp : getDefaultClasspath()) {
                        classPathRule.add(cp.getPath());
                    }
                }
                
                for (String path : classPathRule) {
                    args.add("-classpath");
                    args.add(path);
                }
            }
            
            args.addAll(List.of("-d", classOpt.toString()));
            
            for (IResource resource : sourcePath) {
                args.add(resource.getFile().getPath());
            }
            
            logger.info("ecj cmd args:\n[ {}\n]", String.join("\n", args));
        } else {
            if (!sourcePath.isEmpty()) {
                throw new IllegalStateException("sourcePath must be empty while using customOptions");
            }
            if (!classpath.isEmpty()) {
                throw new IllegalStateException("classpath must be empty while using customOptions");
            }
            args.addAll(customOptions);
        }

        LocalDateTime startTime = LocalDateTime.now();
        try {
            logger.info("compile java source - started at {}", startTime);
            boolean result = super.compile(args.toArray(new String[0]));
            logger.info("compile java source - completed in {}", java.time.Duration.between(startTime, LocalDateTime.now()));
            return result;
        } catch (Exception e) {
            logger.error("compile java source - failed after {}", java.time.Duration.between(startTime, LocalDateTime.now()), e);
            throw e;
        }
    }
}
