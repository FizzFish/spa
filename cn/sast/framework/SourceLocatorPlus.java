package cn.sast.framework;

import cn.sast.api.config.MainConfig;
import cn.sast.common.FileSystemLocator;
import cn.sast.common.IResFile;
import cn.sast.common.Resource;
import cn.sast.framework.report.AbstractFileIndexer;
import cn.sast.framework.report.ProjectFileLocator;
import com.feysh.corax.cache.XOptional;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.FoundFile;
import soot.IFoundFile;
import soot.SourceLocator;

public final class SourceLocatorPlus extends SourceLocator {
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final LoadingCache<Path, String> cacheClassNameMap;
    @NotNull
    private final LoadingCache<String, XOptional<FoundFile>> cacheClassLookMap;
    private final ProjectFileLocator locator;

    public SourceLocatorPlus(@NotNull MainConfig mainConfig) {
        super(null);
        this.mainConfig = mainConfig;
        
        this.cacheClassNameMap = Caffeine.newBuilder()
            .softValues()
            .initialCapacity(5000)
            .build(this::loadClassName);
            
        this.cacheClassLookMap = Caffeine.newBuilder()
            .softValues()
            .initialCapacity(5000)
            .build(this::lookupClass);
            
        Set<Resource> resources = new LinkedHashSet<>();
        for (String dir : mainConfig.getSoot_process_dir()) {
            resources.add(Resource.of(dir));
        }
        
        Set<String> classPaths = SourceLocatorPlusKt.sootClassPathsCvt(resources);
        this.locator = new ProjectFileLocator(
            mainConfig.getMonitor(), 
            classPaths, 
            null, 
            FileSystemLocator.TraverseMode.IndexArchive, 
            false
        );
        this.locator.update();
    }

    @NotNull
    public MainConfig getMainConfig() {
        return mainConfig;
    }

    @NotNull
    public ProjectFileLocator getLocator() {
        return locator;
    }

    public void update() {
    }

    @Nullable
    public String getClassNameOf(@NotNull IResFile cls) {
        return cacheClassNameMap.get(cls.getPath());
    }

    public boolean isInvalidClassFile(@NotNull String fileName, @NotNull IResFile cls) {
        String className = getClassNameOf(cls);
        return className != null && className.equals(fileName);
    }

    @Nullable
    public IFoundFile lookupInClassPath(@NotNull String fileName) {
        if ("LinearLayout.class".equals(fileName)) {
            return null;
        }
        
        XOptional<FoundFile> result = cacheClassLookMap.get(fileName);
        if (result != null) {
            return result.getValue();
        }
        return super.lookupInClassPath(fileName);
    }

    @Nullable
    protected IFoundFile lookupInArchive(@NotNull String archivePath, @NotNull String fileName) {
        XOptional<FoundFile> result = cacheClassLookMap.get(fileName);
        return result != null ? result.getValue() : null;
    }

    private String loadClassName(Path cls) {
        try (InputStream inputStream = Files.newInputStream(cls)) {
            String className = SourceLocator.getNameOfClassUnsafe(inputStream);
            return className != null ? className.replace('.', '/') + ".class" : null;
        } catch (IOException e) {
            return null;
        }
    }

    private XOptional<FoundFile> lookupClass(String fileName) {
        for (IResFile resFile : getLocator().findFromFileIndexMap(
            fileName.split("/"), 
            AbstractFileIndexer.getDefaultClassCompareMode()
        )) {
            if (isInvalidClassFile(fileName, resFile)) {
                return XOptional.of(new FoundFile(resFile.getPath()));
            }
        }
        return null;
    }
}
