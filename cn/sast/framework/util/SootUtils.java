package cn.sast.framework.util;

import cn.sast.common.IResFile;
import cn.sast.common.JarMerger;
import cn.sast.common.Resource;
import cn.sast.common.ResourceImplKt;
import cn.sast.common.ResourceKt;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.googlecode.d2j.dex.Dex2jar;
import com.googlecode.d2j.dex.DexExceptionHandler;
import com.googlecode.d2j.reader.BaseDexFileReader;
import com.googlecode.d2j.reader.MultiDexFileReader;
import com.googlecode.dex2jar.tools.BaksmaliBaseDexExceptionHandler;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.common.LoggerWithLogMethod;
import org.utbot.common.LoggingKt;
import org.utbot.common.Maybe;
import soot.ClassSource;
import soot.DexClassSource;
import soot.FoundFile;
import soot.IFoundFile;
import soot.ModuleUtil;
import soot.SourceLocator;
import soot.asm.AsmClassSource;

public final class SootUtils {
    public static final SootUtils INSTANCE = new SootUtils();
    private static final LoadingCache<Path, Optional<Path>> sootClass2classFileCache;
    private static final KLogger logger;

    private SootUtils() {
    }

    @NotNull
    public Path dex2jar(@NotNull Path dexSource, @NotNull Path output, boolean notHandleException, boolean reuseReg, 
                       boolean debugInfo, boolean optimizeSynchronized, boolean printIR, boolean noCode, 
                       boolean skipExceptions, boolean dontSanitizeNames, boolean computeFrames, 
                       boolean topoLogicalSort) throws Exception {
        ResourceKt.findCacheFromDeskOrCreate(dexSource, output, () -> 
            convertDexToJar(dexSource, output, notHandleException, reuseReg, debugInfo, optimizeSynchronized, 
                          printIR, noCode, skipExceptions, dontSanitizeNames, computeFrames, topoLogicalSort));
        return output;
    }

    @NotNull
    public Path dex2jar(@NotNull Set<? extends Path> dexSource, @NotNull Path output) throws Exception {
        if (dexSource.size() == 1) {
            try (InputStream inputStream = Files.newInputStream(dexSource.iterator().next())) {
                Dex2jar.from(inputStream).to(output);
            }
        } else {
            try (JarMerger merger = new JarMerger(output)) {
                for (Path path : dexSource) {
                    Path part = Files.createTempFile(ResourceImplKt.getSAstTempDirectory(), 
                            path.getFileName().toString(), ".jar");
                    Path jar = dex2jar(path, part, false, false, false, false, false, false, false, true, false, false);
                    merger.addJar(jar);
                    Files.deleteIfExists(part);
                }
            }
        }
        return output;
    }

    @Nullable
    public IResFile getClassSourceFromSoot(@NotNull String className) {
        ClassSource classSource = SourceLocator.v().getClassSource(className);
        if (classSource == null) {
            return null;
        }

        if (classSource instanceof AsmClassSource) {
            try {
                Field foundFileField = classSource.getClass().getDeclaredField("foundFile");
                foundFileField.setAccessible(true);
                IFoundFile iFoundFile = (IFoundFile) foundFileField.get(classSource);
                
                if (!(iFoundFile instanceof FoundFile)) {
                    return null;
                }
                
                FoundFile foundFile = (FoundFile) iFoundFile;
                Field pathField = foundFile.getClass().getDeclaredField("path");
                pathField.setAccessible(true);
                Path path = (Path) pathField.get(foundFile);
                
                if (path != null) {
                    return Resource.INSTANCE.of(path).toFile();
                }
                
                Field fileField = foundFile.getClass().getDeclaredField("file");
                fileField.setAccessible(true);
                File zipFile = (File) fileField.get(foundFile);
                
                Field entryNameField = foundFile.getClass().getDeclaredField("entryName");
                entryNameField.setAccessible(true);
                String entryName = (String) entryNameField.get(foundFile);
                
                if (zipFile != null && entryName != null) {
                    return Resource.INSTANCE.fileOf(zipFile.toPath()).resolve(entryName).toFile();
                }
            } catch (Exception e) {
                return null;
            }
        } else if (classSource instanceof DexClassSource) {
            if (ModuleUtil.module_mode()) {
                return null;
            }
            
            try {
                String clsFile = className.replace('.', '/') + ".class";
                Field pathField = classSource.getClass().getDeclaredField("path");
                pathField.setAccessible(true);
                File file = (File) pathField.get(classSource);
                
                if (file == null) {
                    return null;
                }
                
                Path path = file.toPath().toAbsolutePath().normalize();
                Path jar = sootClass2classFileCache.get(path).orElse(null);
                
                if (jar != null) {
                    return lookupInArchive(Resource.INSTANCE.fileOf(jar), clsFile);
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public void cleanUp() {
        sootClass2classFileCache.cleanUp();
    }

    private IResFile lookupInArchive(IResFile archivePath, String fileName) {
        return archivePath.getEntries().contains(fileName) ? 
               Resource.INSTANCE.fileOf(Resource.INSTANCE.archivePath(archivePath.getPath(), fileName)) : 
               null;
    }

    private static Unit convertDexToJar(Path dexSource, Path output, boolean notHandleException, boolean reuseReg,
                                      boolean debugInfo, boolean optimizeSynchronized, boolean printIR, boolean noCode,
                                      boolean skipExceptions, boolean dontSanitizeNames, boolean computeFrames,
                                      boolean topoLogicalSort) throws IOException {
        LoggerWithLogMethod logger = LoggingKt.info(SootUtils.logger);
        LocalDateTime startTime = LocalDateTime.now();
        
        try {
            BaseDexFileReader reader = MultiDexFileReader.open(Files.readAllBytes(dexSource));
            Dex2jar dex2jar = Dex2jar.from(reader)
                .withExceptionHandler(notHandleException ? null : new BaksmaliBaseDexExceptionHandler())
                .reUseReg(reuseReg);
            
            if (topoLogicalSort) {
                dex2jar.topoLogicalSort();
            }
            
            dex2jar.skipDebug(!debugInfo)
                  .optimizeSynchronized(optimizeSynchronized)
                  .printIR(printIR)
                  .noCode(noCode)
                  .skipExceptions(skipExceptions)
                  .dontSanitizeNames(dontSanitizeNames)
                  .computeFrames(computeFrames)
                  .to(output);
            
            logger.getLogMethod().invoke("Successfully converted dex to jar in " + 
                java.time.Duration.between(startTime, LocalDateTime.now()).toMillis() + "ms");
            return Unit.INSTANCE;
        } catch (Exception e) {
            logger.getLogMethod().invoke("Failed to convert dex to jar: " + e.getMessage());
            throw e;
        }
    }

    static {
        sootClass2classFileCache = Caffeine.newBuilder().build(new CacheLoader<Path, Optional<Path>>() {
            @Override
            public Optional<Path> load(Path dexSource) throws Exception {
                try {
                    Path output = Resource.INSTANCE.getZipExtractOutputDir().resolve("dex2jar")
                        .resolve(dexSource.getFileName().toString().replaceFirst("\\.dex$", "") + 
                        "-" + Math.abs(dexSource.toString().hashCode() + 1) + ".jar");
                    return Optional.of(INSTANCE.dex2jar(dexSource, output, false, false, false, 
                        false, false, false, false, false, false, false));
                } catch (Exception e) {
                    logger.warn("Failed to convert dex: " + dexSource + " to jar file.", e);
                    return Optional.empty();
                }
            }
        });
        logger = KotlinLogging.INSTANCE.logger(SootUtils.class.getName());
    }
}
