package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.feysh.corax.cache.analysis.cpg.InferenceConfigurationType;
import com.feysh.corax.cache.analysis.cpg.Lang;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import de.fraunhofer.aisec.cpg.ConfigurationException;
import de.fraunhofer.aisec.cpg.TranslationConfiguration;
import de.fraunhofer.aisec.cpg.TranslationManager;
import de.fraunhofer.aisec.cpg.TranslationResult;
import de.fraunhofer.aisec.cpg.passes.Pass;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import kotlin.collections.CollectionsKt;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CompilationUnitOfCPGDataFactory
    implements AnalysisDataFactory<TranslationResult, CPGCompilationUnitKey> {

    @NotNull
    public static final CompilationUnitOfCPGDataFactory INSTANCE = new CompilationUnitOfCPGDataFactory();

    private static final Logger logger = LoggerFactory.getLogger(CompilationUnitOfCPGDataFactory.class);

    @NotNull
    private static final LoadingCache<CPGCompilationUnitKey, XOptional<TranslationResult>> cache =
        AnalysisCacheKt.buildX(INSTANCE.getDefaultBuilder(), key -> INSTANCE.analyzeInternal(key));

    @NotNull
    private static final AnalysisDataFactory.Key<TranslationResult> key = new AnalysisDataFactory.Key<>() {};

    private CompilationUnitOfCPGDataFactory() {
    }

    private Caffeine<Object, Object> getDefaultBuilder() {
        return Caffeine.newBuilder()
            .expireAfterAccess(45L, TimeUnit.SECONDS)
            .softValues();
    }

    @Override
    @NotNull
    public LoadingCache<CPGCompilationUnitKey, XOptional<TranslationResult>> getCache() {
        return cache;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<TranslationResult> getKey() {
        return key;
    }

    @Nullable
    public TranslationResult analyze(
        @NotNull List<? extends File> files,
        @Nullable File topLevel,
        @NotNull List<KClass<? extends Pass<?>>> passTypes,
        @NotNull InferenceConfigurationType inferenceConfigurationType,
        @NotNull Lang lang
    ) throws Exception {
        if (files == null) throw new IllegalArgumentException("files cannot be null");
        if (passTypes == null) throw new IllegalArgumentException("passTypes cannot be null");
        if (inferenceConfigurationType == null) throw new IllegalArgumentException("inferenceConfigurationType cannot be null");
        if (lang == null) throw new IllegalArgumentException("lang cannot be null");

        TranslationConfiguration.Builder builder = TranslationConfiguration.Companion.builder()
            .sourceLocations(files)
            .topLevel(topLevel)
            .loadIncludes(false)
            .debugParser(false)
            .failOnError(true)
            .useParallelFrontends(true)
            .registerLanguage(lang.getLanguage())
            .inferenceConfiguration(inferenceConfigurationType.getConfiguration());

        if (passTypes.isEmpty()) {
            builder.defaultPasses();
        } else {
            for (KClass<? extends Pass<?>> passType : passTypes) {
                builder.registerPass(passType);
            }
        }

        TranslationConfiguration config = builder.build();
        TranslationManager analyzer = TranslationManager.builder().config(config).build();
        return analyzer.analyze().get(2000L, TimeUnit.MILLISECONDS);
    }

    @NotNull
    public TranslationResult analyze2(
        @NotNull List<? extends File> files,
        @Nullable Consumer<TranslationConfiguration.Builder> configModifier
    ) throws ConfigurationException, ExecutionException, InterruptedException {
        if (files == null) throw new IllegalArgumentException("files cannot be null");

        TranslationConfiguration.Builder builder = TranslationConfiguration.Companion.builder()
            .sourceLocations(files)
            .defaultPasses();

        if (configModifier != null) {
            configModifier.accept(builder);
        }

        TranslationConfiguration config = builder.build();
        TranslationManager analyzer = TranslationManager.builder().config(config).build();
        return analyzer.analyze().get();
    }

    static {
        AnalysisCache.G.INSTANCE.registerFactory(INSTANCE);
    }

    private TranslationResult analyzeInternal(CPGCompilationUnitKey key2) {
        TranslationResult translationResultAnalyze;
        try {
            translationResultAnalyze = CompilationUnitOfCPGDataFactory.INSTANCE.analyze(
                    CollectionsKt.toList(key2.getCpgKeyConfiguration().getSourceFiles()),
                    key2.getCpgKeyConfiguration().getTopLevel(),
                    CollectionsKt.toList(key2.getCpgKeyConfiguration().getPassTypes()),
                    key2.getCpgKeyConfiguration().getInferenceConfigurationType(),
                    key2.getCpgKeyConfiguration().getLang());
        } catch (Exception e) {
            translationResultAnalyze = null;
        }
        return translationResultAnalyze;

    }
}
