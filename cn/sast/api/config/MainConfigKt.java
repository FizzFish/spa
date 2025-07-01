package cn.sast.api.config;

import cn.sast.api.config.ClassSerializer;
import cn.sast.api.config.MainConfig;
import cn.sast.api.incremental.IncrementalAnalyze;
import cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResource;
import cn.sast.common.Resource;
import com.charleskorn.kaml.PolymorphismStyle;
import com.charleskorn.kaml.SequenceStyle;
import com.charleskorn.kaml.Yaml;
import com.charleskorn.kaml.YamlConfiguration;
import com.feysh.corax.config.api.IAnalysisDepends;
import com.feysh.corax.config.api.PhantomAnalysisDepends;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MainConfigKt {
    private static final SerializersModule serializersModule;
    private static final YamlConfiguration yamlConfiguration;
    private static final Yaml yamlFormat;

    @NotNull
    public static SerializersModule getSerializersModule() {
        return serializersModule;
    }

    @NotNull
    public static YamlConfiguration getYamlConfiguration() {
        return yamlConfiguration;
    }

    @NotNull
    public static Yaml getYamlFormat() {
        return yamlFormat;
    }

    @NotNull
    public static IAnalysisDepends simpleIAnalysisDepends(@NotNull MainConfig config) {
        IncrementalAnalyze incrementalAnalyze = config.getIncrementAnalyze();
        IncrementalAnalyzeByChangeFiles incrementalAnalyzeByChangeFiles = 
            incrementalAnalyze instanceof IncrementalAnalyzeByChangeFiles ? 
            (IncrementalAnalyzeByChangeFiles) incrementalAnalyze : null;
        
        IAnalysisDepends analysisDepends = incrementalAnalyzeByChangeFiles != null ? 
            incrementalAnalyzeByChangeFiles.getSimpleDeclAnalysisDependsGraph() : null;
        
        return analysisDepends != null ? analysisDepends : PhantomAnalysisDepends.INSTANCE;
    }

    @NotNull
    public static IAnalysisDepends interProceduralAnalysisDepends(@NotNull MainConfig config) {
        IncrementalAnalyze incrementalAnalyze = config.getIncrementAnalyze();
        IncrementalAnalyzeByChangeFiles incrementalAnalyzeByChangeFiles = 
            incrementalAnalyze instanceof IncrementalAnalyzeByChangeFiles ? 
            (IncrementalAnalyzeByChangeFiles) incrementalAnalyze : null;
        
        IAnalysisDepends analysisDepends = incrementalAnalyzeByChangeFiles != null ? 
            incrementalAnalyzeByChangeFiles.getInterProceduralAnalysisDependsGraph() : null;
        
        return analysisDepends != null ? analysisDepends : PhantomAnalysisDepends.INSTANCE;
    }

    public static boolean skipResourceInArchive(@NotNull MainConfig config, @NotNull IResource res) {
        if (!res.isJarScheme()) {
            return false;
        }
        try {
            if (config.getSourcePathZFS().contains(Resource.INSTANCE.getZipFileSystem(res.getSchemePath()))) {
                return false;
            }
        } catch (Exception e) {
            return true;
        }
        return true;
    }

    @Nullable
    public static IResDirectory checkerInfoDir(@NotNull List<? extends IResource> configDirs, boolean stopOnError) {
        if (configDirs.size() != 1) {
            if (stopOnError) {
                throw new IllegalStateException("Only one plugin folder could be exists: " + configDirs);
            }
            return null;
        }

        Path analysisConfigDir = configDirs.get(0).getPath();
        Path checkerInfoDir = analysisConfigDir.normalize();
        
        if (!Files.exists(checkerInfoDir)) {
            if (stopOnError) {
                throw new IllegalStateException(checkerInfoDir + " is not exists");
            }
            return null;
        }

        Path csvPath = checkerInfoDir.resolve("checker_info.csv");
        if (Files.exists(csvPath)) {
            return Resource.INSTANCE.dirOf(checkerInfoDir);
        }

        Path devPath = analysisConfigDir.resolve("../../Canary/analysis-config").normalize();
        if (Files.exists(devPath)) {
            csvPath = devPath.resolve("checker_info.csv");
            if (Files.exists(csvPath)) {
                return Resource.INSTANCE.dirOf(devPath);
            }
        }

        if (stopOnError) {
            throw new IllegalStateException("checker_info.csv not exists in " + checkerInfoDir);
        }
        return null;
    }

    static {
        SerializersModuleBuilder builder = new SerializersModuleBuilder();
        builder.polymorphic(Type.class, polyBuilder -> {
            polyBuilder.subclass(Class.class, ClassSerializer.INSTANCE);
        });
        serializersModule = builder.build();

        yamlConfiguration = new YamlConfiguration(
            true, false, null, PolymorphismStyle.Tag, null, 
            0, 200, SequenceStyle.Block, null, null, null, 
            0, false, null, 16182, null
        );
        yamlFormat = new Yaml(serializersModule, yamlConfiguration);
    }
}
