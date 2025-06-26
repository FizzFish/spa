/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ClassSerializer
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.MainConfigKt
 *  cn.sast.api.incremental.IncrementalAnalyze
 *  cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResource
 *  cn.sast.common.Resource
 *  com.charleskorn.kaml.PolymorphismStyle
 *  com.charleskorn.kaml.SequenceStyle
 *  com.charleskorn.kaml.Yaml
 *  com.charleskorn.kaml.YamlConfiguration
 *  com.feysh.corax.config.api.IAnalysisDepends
 *  com.feysh.corax.config.api.PhantomAnalysisDepends
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.modules.PolymorphicModuleBuilder
 *  kotlinx.serialization.modules.SerializersModule
 *  kotlinx.serialization.modules.SerializersModuleBuilder
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
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
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u001a\n\u0010\f\u001a\u00020\r*\u00020\u000e\u001a\n\u0010\u000f\u001a\u00020\r*\u00020\u000e\u001a\u0012\u0010\u0010\u001a\u00020\u0011*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013\u001a \u0010\u0014\u001a\u0004\u0018\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0011\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0019"}, d2={"serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "yamlConfiguration", "Lcom/charleskorn/kaml/YamlConfiguration;", "getYamlConfiguration", "()Lcom/charleskorn/kaml/YamlConfiguration;", "yamlFormat", "Lcom/charleskorn/kaml/Yaml;", "getYamlFormat", "()Lcom/charleskorn/kaml/Yaml;", "simpleIAnalysisDepends", "Lcom/feysh/corax/config/api/IAnalysisDepends;", "Lcn/sast/api/config/MainConfig;", "interProceduralAnalysisDepends", "skipResourceInArchive", "", "res", "Lcn/sast/common/IResource;", "checkerInfoDir", "Lcn/sast/common/IResDirectory;", "configDirs", "", "stopOnError", "corax-api"})
@SourceDebugExtension(value={"SMAP\nMainConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainConfig.kt\ncn/sast/api/config/MainConfigKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SerializersModuleBuilders.kt\nkotlinx/serialization/modules/SerializersModuleBuildersKt\n*L\n1#1,463:1\n1#2:464\n31#3,2:465\n254#3,9:467\n33#3:476\n*S KotlinDebug\n*F\n+ 1 MainConfig.kt\ncn/sast/api/config/MainConfigKt\n*L\n51#1:465,2\n52#1:467,9\n51#1:476\n*E\n"})
public final class MainConfigKt {
    @NotNull
    private static final SerializersModule serializersModule;
    @NotNull
    private static final YamlConfiguration yamlConfiguration;
    @NotNull
    private static final Yaml yamlFormat;

    @NotNull
    public static final SerializersModule getSerializersModule() {
        return serializersModule;
    }

    @NotNull
    public static final YamlConfiguration getYamlConfiguration() {
        return yamlConfiguration;
    }

    @NotNull
    public static final Yaml getYamlFormat() {
        return yamlFormat;
    }

    @NotNull
    public static final IAnalysisDepends simpleIAnalysisDepends(@NotNull MainConfig $this$simpleIAnalysisDepends) {
        Intrinsics.checkNotNullParameter((Object)$this$simpleIAnalysisDepends, (String)"<this>");
        IncrementalAnalyze incrementalAnalyze = $this$simpleIAnalysisDepends.getIncrementAnalyze();
        IncrementalAnalyzeByChangeFiles incrementalAnalyzeByChangeFiles = incrementalAnalyze instanceof IncrementalAnalyzeByChangeFiles ? (IncrementalAnalyzeByChangeFiles)incrementalAnalyze : null;
        IAnalysisDepends analysisDepends = (IAnalysisDepends)(incrementalAnalyzeByChangeFiles != null ? incrementalAnalyzeByChangeFiles.getSimpleDeclAnalysisDependsGraph() : null);
        if (analysisDepends == null) {
            analysisDepends = (IAnalysisDepends)PhantomAnalysisDepends.INSTANCE;
        }
        return analysisDepends;
    }

    @NotNull
    public static final IAnalysisDepends interProceduralAnalysisDepends(@NotNull MainConfig $this$interProceduralAnalysisDepends) {
        Intrinsics.checkNotNullParameter((Object)$this$interProceduralAnalysisDepends, (String)"<this>");
        IncrementalAnalyze incrementalAnalyze = $this$interProceduralAnalysisDepends.getIncrementAnalyze();
        IncrementalAnalyzeByChangeFiles incrementalAnalyzeByChangeFiles = incrementalAnalyze instanceof IncrementalAnalyzeByChangeFiles ? (IncrementalAnalyzeByChangeFiles)incrementalAnalyze : null;
        IAnalysisDepends analysisDepends = (IAnalysisDepends)(incrementalAnalyzeByChangeFiles != null ? incrementalAnalyzeByChangeFiles.getInterProceduralAnalysisDependsGraph() : null);
        if (analysisDepends == null) {
            analysisDepends = (IAnalysisDepends)PhantomAnalysisDepends.INSTANCE;
        }
        return analysisDepends;
    }

    public static final boolean skipResourceInArchive(@NotNull MainConfig $this$skipResourceInArchive, @NotNull IResource res) {
        Intrinsics.checkNotNullParameter((Object)$this$skipResourceInArchive, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        if (!res.isJarScheme()) {
            return false;
        }
        try {
            if ($this$skipResourceInArchive.getSourcePathZFS().contains((Object)Resource.INSTANCE.getZipFileSystem(res.getSchemePath()))) {
                return false;
            }
        }
        catch (Exception e) {
            return true;
        }
        return true;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Nullable
    public static final IResDirectory checkerInfoDir(@NotNull List<? extends IResource> configDirs, boolean stopOnError) {
        Intrinsics.checkNotNullParameter(configDirs, (String)"configDirs");
        if (configDirs.size() != 1) {
            if (!(stopOnError == false)) {
                $i$a$-check-MainConfigKt$checkerInfoDir$1 = false;
                $i$a$-check-MainConfigKt$checkerInfoDir$1 = "Only one plugin folder could be exists: " + configDirs;
                throw new IllegalStateException($i$a$-check-MainConfigKt$checkerInfoDir$1.toString());
            }
            return null;
        }
        analysisConfigDir = ((IResource)CollectionsKt.single(configDirs)).getPath();
        checkerInfoDir = analysisConfigDir.normalize();
        Intrinsics.checkNotNull((Object)checkerInfoDir);
        v0 = new LinkOption[]{};
        if (!Files.exists(checkerInfoDir, Arrays.copyOf(v0, v0.length))) {
            if (!(stopOnError == false)) {
                $i$a$-check-MainConfigKt$checkerInfoDir$2 = false;
                var5_7 = checkerInfoDir + " is not exists";
                throw new IllegalStateException(var5_7.toString());
            }
            return null;
        }
        it = var5_8 = checkerInfoDir;
        $i$a$-takeIf-MainConfigKt$checkerInfoDir$3 = false;
        v1 = new LinkOption[]{};
        if (!Files.exists(it, Arrays.copyOf(v1, v1.length))) ** GOTO lbl-1000
        v2 = it.resolve("checker_info.csv");
        Intrinsics.checkNotNullExpressionValue((Object)v2, (String)"resolve(...)");
        var8_14 = v2;
        var9_16 /* !! */  = new LinkOption[]{};
        if (Files.exists(var8_14, Arrays.copyOf(var9_16 /* !! */ , var9_16 /* !! */ .length))) {
            v3 = true;
        } else lbl-1000:
        // 2 sources

        {
            v3 = false;
        }
        v4 = var4_17 = v3 != false ? var5_8 : null;
        if (var4_17 != null) {
            it = var4_17;
            $i$a$-let-MainConfigKt$checkerInfoDir$4 = false;
            return Resource.INSTANCE.dirOf(it);
        }
        it = it = (checkerInfoDirInConfigProjectDevPath = analysisConfigDir.resolve("../../Canary/analysis-config").normalize());
        $i$a$-takeIf-MainConfigKt$checkerInfoDir$5 = false;
        Intrinsics.checkNotNull((Object)it);
        v5 = new LinkOption[]{};
        if (!Files.exists(it, Arrays.copyOf(v5, v5.length))) ** GOTO lbl-1000
        v6 = it.resolve("checker_info.csv");
        Intrinsics.checkNotNullExpressionValue((Object)v6, (String)"resolve(...)");
        var9_16 /* !! */  = v6;
        var10_18 = new LinkOption[]{};
        if (Files.exists((Path)var9_16 /* !! */ , Arrays.copyOf(var10_18, var10_18.length))) {
            v7 = true;
        } else lbl-1000:
        // 2 sources

        {
            v7 = false;
        }
        v8 = var5_8 = v7 != false ? it : null;
        if (var5_8 != null) {
            it = var5_8;
            $i$a$-let-MainConfigKt$checkerInfoDir$6 = false;
            return Resource.INSTANCE.dirOf(it);
        }
        if (!(stopOnError == false)) {
            $i$a$-check-MainConfigKt$checkerInfoDir$7 = false;
            var6_11 = "checker_info.csv not exists in " + checkerInfoDir;
            throw new IllegalStateException(var6_11.toString());
        }
        return null;
    }

    public static /* synthetic */ IResDirectory checkerInfoDir$default(List list, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        return MainConfigKt.checkerInfoDir((List)list, (boolean)bl);
    }

    /*
     * WARNING - void declaration
     */
    static {
        void $this$polymorphic_u24default$iv;
        PolymorphicModuleBuilder builder$iv;
        SerializersModuleBuilder builder$iv2;
        boolean $i$f$SerializersModule = false;
        SerializersModuleBuilder $this$serializersModule_u24lambda_u241 = builder$iv2 = new SerializersModuleBuilder();
        boolean bl = false;
        SerializersModuleBuilder serializersModuleBuilder = $this$serializersModule_u24lambda_u241;
        KClass baseClass$iv = Reflection.getOrCreateKotlinClass(Type.class);
        KSerializer baseSerializer$iv = null;
        boolean $i$f$polymorphic = false;
        PolymorphicModuleBuilder $this$serializersModule_u24lambda_u241_u24lambda_u240 = builder$iv = new PolymorphicModuleBuilder(baseClass$iv, baseSerializer$iv);
        boolean bl2 = false;
        $this$serializersModule_u24lambda_u241_u24lambda_u240.subclass(Reflection.getOrCreateKotlinClass(Class.class), (KSerializer)ClassSerializer.INSTANCE);
        builder$iv.buildTo((SerializersModuleBuilder)$this$polymorphic_u24default$iv);
        serializersModule = builder$iv2.build();
        PolymorphismStyle polymorphismStyle = PolymorphismStyle.Tag;
        SequenceStyle sequenceStyle = SequenceStyle.Block;
        yamlConfiguration = new YamlConfiguration(true, false, null, polymorphismStyle, null, 0, 200, sequenceStyle, null, null, null, 0, false, null, 16182, null);
        yamlFormat = new Yaml(serializersModule, yamlConfiguration);
    }
}

