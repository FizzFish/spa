/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.benmanes.caffeine.cache.Caffeine
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  de.fraunhofer.aisec.cpg.TranslationConfiguration
 *  de.fraunhofer.aisec.cpg.TranslationConfiguration$Builder
 *  de.fraunhofer.aisec.cpg.TranslationManager
 *  de.fraunhofer.aisec.cpg.TranslationResult
 *  de.fraunhofer.aisec.cpg.passes.Pass
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisCacheKt;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.XOptional;
import com.feysh.corax.cache.analysis.CPGCompilationUnitKey;
import com.feysh.corax.cache.analysis.CompilationUnitOfCPGDataFactory;
import com.feysh.corax.cache.analysis.cpg.InferenceConfigurationType;
import com.feysh.corax.cache.analysis.cpg.Lang;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import de.fraunhofer.aisec.cpg.TranslationConfiguration;
import de.fraunhofer.aisec.cpg.TranslationManager;
import de.fraunhofer.aisec.cpg.TranslationResult;
import de.fraunhofer.aisec.cpg.passes.Pass;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005JJ\u0010\u0017\u001a\u0004\u0018\u00010\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0018\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001e0\u001d0\u00192\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J&\u0010#\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR:\u0010\r\u001a(\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f0\u000ej\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0014X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006'"}, d2={"Lcom/feysh/corax/cache/analysis/CompilationUnitOfCPGDataFactory;", "Lcom/feysh/corax/cache/AnalysisDataFactory;", "Lde/fraunhofer/aisec/cpg/TranslationResult;", "Lcom/feysh/corax/cache/analysis/CPGCompilationUnitKey;", "<init>", "()V", "logger", "Lmu/KLogger;", "defaultBuilder", "Lcom/github/benmanes/caffeine/cache/Caffeine;", "", "getDefaultBuilder", "()Lcom/github/benmanes/caffeine/cache/Caffeine;", "cache", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "Lcom/feysh/corax/cache/XOptional;", "Lcom/feysh/corax/cache/XLoadingCache;", "getCache", "()Lcom/github/benmanes/caffeine/cache/LoadingCache;", "key", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "getKey", "()Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "analyze", "files", "", "Ljava/io/File;", "topLevel", "passTypes", "Lkotlin/reflect/KClass;", "Lde/fraunhofer/aisec/cpg/passes/Pass;", "inferenceConfigurationType", "Lcom/feysh/corax/cache/analysis/cpg/InferenceConfigurationType;", "lang", "Lcom/feysh/corax/cache/analysis/cpg/Lang;", "analyze2", "configModifier", "Ljava/util/function/Consumer;", "Lde/fraunhofer/aisec/cpg/TranslationConfiguration$Builder;", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nCompilationUnitOfCPG.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompilationUnitOfCPG.kt\ncom/feysh/corax/cache/analysis/CompilationUnitOfCPGDataFactory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n1863#2,2:113\n*S KotlinDebug\n*F\n+ 1 CompilationUnitOfCPG.kt\ncom/feysh/corax/cache/analysis/CompilationUnitOfCPGDataFactory\n*L\n91#1:113,2\n*E\n"})
public final class CompilationUnitOfCPGDataFactory
implements AnalysisDataFactory<TranslationResult, CPGCompilationUnitKey> {
    @NotNull
    public static final CompilationUnitOfCPGDataFactory INSTANCE = new CompilationUnitOfCPGDataFactory();
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(CompilationUnitOfCPGDataFactory::logger$lambda$0);
    @NotNull
    private static final LoadingCache<CPGCompilationUnitKey, XOptional<TranslationResult>> cache = AnalysisCacheKt.buildX(INSTANCE.getDefaultBuilder(), cache.1.INSTANCE);
    @NotNull
    private static final AnalysisDataFactory.Key<TranslationResult> key = new AnalysisDataFactory.Key<TranslationResult>(){};

    private CompilationUnitOfCPGDataFactory() {
    }

    private final Caffeine<Object, Object> getDefaultBuilder() {
        Caffeine caffeine = Caffeine.newBuilder().expireAfterAccess(45L, TimeUnit.SECONDS).softValues();
        Intrinsics.checkNotNullExpressionValue((Object)caffeine, (String)"softValues(...)");
        return caffeine;
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
    public final TranslationResult analyze(@NotNull List<? extends File> files, @Nullable File topLevel, @NotNull List<? extends KClass<? extends Pass<?>>> passTypes, @NotNull InferenceConfigurationType inferenceConfigurationType, @NotNull Lang lang) throws Exception {
        Intrinsics.checkNotNullParameter(files, (String)"files");
        Intrinsics.checkNotNullParameter(passTypes, (String)"passTypes");
        Intrinsics.checkNotNullParameter((Object)((Object)inferenceConfigurationType), (String)"inferenceConfigurationType");
        Intrinsics.checkNotNullParameter((Object)((Object)lang), (String)"lang");
        TranslationConfiguration.Builder builder = TranslationConfiguration.Companion.builder().sourceLocations(files).topLevel(topLevel).loadIncludes(false).debugParser(false).failOnError(true).useParallelFrontends(true).registerLanguage(lang.getLanguage()).inferenceConfiguration(inferenceConfigurationType.getConfiguration());
        if (passTypes.isEmpty()) {
            builder.defaultPasses();
        } else {
            Iterable $this$forEach$iv = passTypes;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                KClass it = (KClass)element$iv;
                boolean bl = false;
                builder.registerPass(it);
            }
        }
        TranslationConfiguration config = builder.build();
        TranslationManager analyzer = TranslationManager.Companion.builder().config(config).build();
        return (TranslationResult)analyzer.analyze().get(2000L, TimeUnit.MILLISECONDS);
    }

    @NotNull
    public final TranslationResult analyze2(@NotNull List<? extends File> files, @Nullable Consumer<TranslationConfiguration.Builder> configModifier) {
        Intrinsics.checkNotNullParameter(files, (String)"files");
        TranslationConfiguration.Builder builder = TranslationConfiguration.Companion.builder().sourceLocations(files).defaultPasses();
        Consumer<TranslationConfiguration.Builder> consumer = configModifier;
        if (consumer != null) {
            consumer.accept(builder);
        }
        TranslationConfiguration config = builder.build();
        TranslationManager analyzer = TranslationManager.Companion.builder().config(config).build();
        Object t = analyzer.analyze().get();
        Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
        return (TranslationResult)t;
    }

    public static /* synthetic */ TranslationResult analyze2$default(CompilationUnitOfCPGDataFactory compilationUnitOfCPGDataFactory, List list, Consumer consumer, int n, Object object) {
        if ((n & 2) != 0) {
            consumer = null;
        }
        return compilationUnitOfCPGDataFactory.analyze2(list, consumer);
    }

    private static final Unit logger$lambda$0() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getLogger$p() {
        return logger;
    }

    static {
        AnalysisCache.G.INSTANCE.registerFactory(INSTANCE);
    }
}

