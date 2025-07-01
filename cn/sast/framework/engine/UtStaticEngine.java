package cn.sast.framework.engine;

import cn.sast.api.config.MainConfig;
import cn.sast.common.IResource;
import cn.sast.framework.SootCtx;
import cn.sast.framework.engine.UtStaticEngineConfiguration;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.result.IUTBotResultCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.framework.codegen.CodeGenerator;
import org.utbot.framework.codegen.domain.DomainKt;
import org.utbot.framework.codegen.domain.ForceStaticMocking;
import org.utbot.framework.codegen.domain.NoStaticMocking;
import org.utbot.framework.codegen.domain.StaticsMocking;
import org.utbot.framework.codegen.domain.TestFramework;
import org.utbot.framework.plugin.api.ClassId;
import org.utbot.framework.plugin.api.CodegenLanguage;
import org.utbot.framework.plugin.api.MockStrategyApi;
import org.utbot.framework.plugin.api.TestCaseGenerator;
import org.utbot.framework.plugin.api.TreatOverflowAsError;
import org.utbot.framework.plugin.api.UtMethodTestSet;
import org.utbot.framework.plugin.api.util.UtContext;
import org.utbot.framework.plugin.services.JdkInfo;
import org.utbot.framework.plugin.services.JdkInfoDefaultProvider;
import org.utbot.framework.util.EngineUtilsKt;
import org.utbot.framework.util.SootUtilsKt;
import org.utbot.framework.UtSettings;
import org.utbot.engine.Mocker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class UtStaticEngine {
    private static final Logger logger = LoggerFactory.getLogger(UtStaticEngine.class);
    
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final UtStaticEngineConfiguration utConfig;
    @NotNull
    private Set<String> classesToMockAlways;
    private URLClassLoader classLoader;

    public UtStaticEngine(@NotNull MainConfig mainConfig, @NotNull UtStaticEngineConfiguration utConfig) {
        if (mainConfig == null) throw new IllegalArgumentException("mainConfig cannot be null");
        if (utConfig == null) throw new IllegalArgumentException("utConfig cannot be null");
        
        this.mainConfig = mainConfig;
        this.utConfig = utConfig;
        this.classesToMockAlways = utConfig.getClassesToMockAlways();
    }

    @NotNull
    public MainConfig getMainConfig() {
        return mainConfig;
    }

    @NotNull
    public UtStaticEngineConfiguration getUtConfig() {
        return utConfig;
    }

    @NotNull
    public Set<String> getClassesToMockAlways() {
        return classesToMockAlways;
    }

    public void setClassesToMockAlways(@NotNull Set<String> fullyQualifiedNames) {
        if (fullyQualifiedNames == null) throw new IllegalArgumentException("fullyQualifiedNames cannot be null");
        
        for (String fullyQualifiedName : fullyQualifiedNames) {
            try {
                Class.forName(fullyQualifiedName, false, getClassLoader());
            } catch (ClassNotFoundException e) {
                logger.error("Failed to load class: " + fullyQualifiedName, e);
            }
        }
        this.classesToMockAlways = fullyQualifiedNames;
    }

    @NotNull
    public Set<IResource> getClasspath() {
        return mainConfig.get_expand_class_path();
    }

    public boolean getUseDefaultJavaClassPath() {
        return mainConfig.getUseDefaultJavaClassPath();
    }

    @NotNull
    public synchronized URLClassLoader getClassLoader() {
        if (classLoader == null) {
            List<URL> urls = new ArrayList<>();
            for (IResource resource : getClasspath()) {
                urls.add(resource.getUrl());
            }
            for (IResource resource : mainConfig.getProcessDir()) {
                urls.add(resource.getUrl());
            }
            
            classLoader = getUseDefaultJavaClassPath() 
                ? new URLClassLoader(urls.toArray(new URL[0]), ClassLoader.getSystemClassLoader())
                : new URLClassLoader(urls.toArray(new URL[0]), null);
        }
        return classLoader;
    }

    @NotNull
    public String getDependencyPaths() {
        return System.getProperty("java.class.path");
    }

    public void saveToFile(@NotNull String snippet, @Nullable String outputPath) {
        if (snippet == null) throw new IllegalArgumentException("snippet cannot be null");
        if (outputPath != null) {
            Files.write(Paths.get(outputPath), List.of(snippet));
        }
    }

    private CodeGenerator initializeCodeGenerator(String testFramework, ClassId classUnderTest) {
        boolean generateWarningsForStaticMocking = utConfig.getForceStaticMocking() == ForceStaticMocking.FORCE 
            && utConfig.getStaticsMocking() instanceof NoStaticMocking;
        
        return new CodeGenerator(
            classUnderTest, 
            null, 
            false, 
            DomainKt.testFrameworkByName(testFramework),
            null,
            utConfig.getStaticsMocking(),
            utConfig.getForceStaticMocking(),
            generateWarningsForStaticMocking,
            utConfig.getCodegenLanguage(),
            null, null, null, false, null, 15894, null
        );
    }

    @NotNull
    public String generateTest(@NotNull ClassId classUnderTest, @NotNull String testClassname, @NotNull List<UtMethodTestSet> testCases) {
        if (classUnderTest == null) throw new IllegalArgumentException("classUnderTest cannot be null");
        if (testClassname == null) throw new IllegalArgumentException("testClassname cannot be null");
        if (testCases == null) throw new IllegalArgumentException("testCases cannot be null");
        
        return initializeCodeGenerator(utConfig.getTestFramework(), classUnderTest)
            .generateAsString(testCases, testClassname);
    }

    public void generateTestsForClass(@NotNull ClassId classIdUnderTest, @NotNull List<UtMethodTestSet> testCases, @NotNull IResource output) {
        if (classIdUnderTest == null) throw new IllegalArgumentException("classIdUnderTest cannot be null");
        if (testCases == null) throw new IllegalArgumentException("testCases cannot be null");
        if (output == null) throw new IllegalArgumentException("output cannot be null");
        
        String testClassName = classIdUnderTest.getSimpleName() + "Test";
        String testClassBody = generateTest(classIdUnderTest, testClassName, testCases);
        
        if (logger.isTraceEnabled()) {
            logger.info(testClassBody);
        }
        
        File outputDir = output.getFile();
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        
        String[] packageParts = classIdUnderTest.getJvmName().split("\\.");
        Path packagePath = Paths.get(outputDir.getPath(), 
            String.join(File.separator, Arrays.copyOf(packageParts, packageParts.length - 1));
        
        packagePath.toFile().mkdirs();
        saveToFile(testClassBody, 
            packagePath.resolve(testClassName + ".java").toString());
    }

    protected TestCaseGenerator initializeGenerator() {
        UtSettings.INSTANCE.setTreatOverflowAsError(
            utConfig.getTreatOverflowAsError() == TreatOverflowAsError.AS_ERROR);
        
        JdkInfo jdkInfo = new JdkInfoDefaultProvider().getInfo();
        List<String> processDirs = new ArrayList<>();
        for (IResource resource : mainConfig.getProcessDir()) {
            processDirs.add(resource.getPath());
        }
        
        List<String> classpath = new ArrayList<>();
        for (IResource resource : getClasspath()) {
            classpath.add(resource.getAbsolutePath());
        }
        
        return new TestCaseGenerator(
            processDirs,
            String.join(File.pathSeparator, classpath),
            getDependencyPaths(),
            jdkInfo,
            null, null, false, false, 112, null
        );
    }

    public void runTest(@NotNull SootCtx soot, @NotNull TestCaseGenerator test, 
            @NotNull Set<? extends SootMethod> entries, @NotNull IUTBotResultCollector result) {
        if (soot == null) throw new IllegalArgumentException("soot cannot be null");
        if (test == null) throw new IllegalArgumentException("test cannot be null");
        if (entries == null) throw new IllegalArgumentException("entries cannot be null");
        if (result == null) throw new IllegalArgumentException("result cannot be null");
        
        List<Object> targetMethods = new ArrayList<>();
        for (SootMethod method : entries) {
            targetMethods.add(EngineUtilsKt.getExecutableId(method));
        }
        
        try (UtContext ignored = new UtContext(getClassLoader())) {
            MockStrategyApi mockStrategy = MockStrategyApi.NO_MOCKS;
            Set<ClassId> chosenClassesToMockAlways = new LinkedHashSet<>();
            for (String className : classesToMockAlways) {
                chosenClassesToMockAlways.add(new ClassId(className, null, false, 6, null));
            }
            
            List<?> testCases = TestCaseGenerator.generate(
                test, targetMethods, mockStrategy, chosenClassesToMockAlways, 0L, null);
            
            logger.info("symbolic result: " + testCases.size());
        } catch (Exception e) {
            logger.error("Error during test execution", e);
            throw e;
        }
    }

    public void initUt(@NotNull SootCtx soot) {
        if (soot == null) throw new IllegalArgumentException("soot cannot be null");
        
        UtSettings.INSTANCE.setUseFuzzing(false);
        UtSettings.INSTANCE.setUseSandbox(false);
        UtSettings.INSTANCE.setUseConcreteExecution(false);
        UtSettings.INSTANCE.setUseCustomJavaDocTags(false);
        UtSettings.INSTANCE.setEnableSummariesGeneration(false);
        UtSettings.INSTANCE.setCheckNpeInNestedNotPrivateMethods(true);
        UtSettings.INSTANCE.setPreferredCexOption(false);
        UtSettings.INSTANCE.setUseAssembleModelGenerator(false);
        
        String isolatedClassPath = FileUtil.isolateClassFiles(SootUtilsKt.getClassesToLoad()).getCanonicalPath();
        mainConfig.setClasspath(mainConfig.getClasspath().add(isolatedClassPath));
        
        Scene scene = Scene.v();
        scene.setSootClassPath(null);
        soot.configureSootClassPath(Options.v());
        
        for (Class<?> clazz : SootUtilsKt.getClassesToLoad()) {
            SootClass sootClass = scene.forceResolve(clazz.getName(), 3);
            sootClass.setApplicationClass();
        }
    }
}
