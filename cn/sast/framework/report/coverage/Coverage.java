/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.coverage.ClassSourceInfo
 *  cn.sast.framework.report.coverage.ClassSourceOfSCKey
 *  cn.sast.framework.report.coverage.Coverage
 *  cn.sast.framework.report.coverage.Coverage$ClassCoverage
 *  cn.sast.framework.report.coverage.Coverage$Companion
 *  cn.sast.framework.report.coverage.Coverage$JacocoCover
 *  cn.sast.framework.report.coverage.Coverage$analyzeClass$1
 *  cn.sast.framework.report.coverage.Coverage$calculateSourceCoverage$1
 *  cn.sast.framework.report.coverage.Coverage$computeCoverageBuilder$1
 *  cn.sast.framework.report.coverage.Coverage$cover$1
 *  cn.sast.framework.report.coverage.Coverage$cover$2
 *  cn.sast.framework.report.coverage.Coverage$createAnalyzingVisitor$builder$1
 *  cn.sast.framework.report.coverage.Coverage$createReport$4
 *  cn.sast.framework.report.coverage.Coverage$flushCoverage$1
 *  cn.sast.framework.report.coverage.Coverage$processCoverQueueData$1
 *  cn.sast.framework.report.coverage.JacocoSourceLocator
 *  cn.sast.framework.report.coverage.SourceCoverage
 *  cn.sast.framework.report.coverage.SourceCoverage$JavaSourceCoverage
 *  com.feysh.corax.cache.AnalysisCache$G
 *  com.feysh.corax.cache.AnalysisKey
 *  com.github.benmanes.caffeine.cache.AsyncCacheLoader
 *  com.github.benmanes.caffeine.cache.AsyncLoadingCache
 *  com.github.benmanes.caffeine.cache.Caffeine
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.io.FilesKt
 *  kotlin.io.TextStreamsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.ExecutorsKt
 *  kotlinx.coroutines.future.FutureKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jacoco.core.analysis.Analyzer
 *  org.jacoco.core.analysis.CoverageBuilder
 *  org.jacoco.core.analysis.IBundleCoverage
 *  org.jacoco.core.analysis.ICoverageVisitor
 *  org.jacoco.core.analysis.ISourceFileCoverage
 *  org.jacoco.core.data.ExecutionData
 *  org.jacoco.core.data.ExecutionDataStore
 *  org.jacoco.core.data.SessionInfo
 *  org.jacoco.core.data.SessionInfoStore
 *  org.jacoco.core.internal.analysis.ClassAnalyzer
 *  org.jacoco.core.internal.analysis.ClassCoverageImpl
 *  org.jacoco.core.internal.analysis.StringPool
 *  org.jacoco.core.internal.flow.ClassProbesAdapter
 *  org.jacoco.core.internal.flow.ClassProbesVisitor
 *  org.jacoco.report.DirectorySourceFileLocator
 *  org.jacoco.report.ISourceFileLocator
 *  org.jacoco.report.InputStreamSourceFileLocator
 *  org.jacoco.report.MultiSourceFileLocator
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.objectweb.asm.ClassVisitor
 *  soot.jimple.infoflow.collect.ConcurrentHashSet
 */
package cn.sast.framework.report.coverage;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.coverage.ClassSourceInfo;
import cn.sast.framework.report.coverage.ClassSourceOfSCKey;
import cn.sast.framework.report.coverage.Coverage;
import cn.sast.framework.report.coverage.JacocoSourceLocator;
import cn.sast.framework.report.coverage.SourceCoverage;
import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisKey;
import com.github.benmanes.caffeine.cache.AsyncCacheLoader;
import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.lang.invoke.LambdaMetafactory;
import java.nio.charset.Charset;
import java.time.Instant;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.future.FutureKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.analysis.IBundleCoverage;
import org.jacoco.core.analysis.ICoverageVisitor;
import org.jacoco.core.analysis.ISourceFileCoverage;
import org.jacoco.core.data.ExecutionData;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.core.data.SessionInfo;
import org.jacoco.core.data.SessionInfoStore;
import org.jacoco.core.internal.analysis.ClassAnalyzer;
import org.jacoco.core.internal.analysis.ClassCoverageImpl;
import org.jacoco.core.internal.analysis.StringPool;
import org.jacoco.core.internal.flow.ClassProbesAdapter;
import org.jacoco.core.internal.flow.ClassProbesVisitor;
import org.jacoco.report.DirectorySourceFileLocator;
import org.jacoco.report.ISourceFileLocator;
import org.jacoco.report.InputStreamSourceFileLocator;
import org.jacoco.report.MultiSourceFileLocator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.ClassVisitor;
import soot.jimple.infoflow.collect.ConcurrentHashSet;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00d4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 ]2\u00020\u0001:\u0003[\\]B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018J \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\fH\u0002J\u0018\u0010&\u001a\u0004\u0018\u00010\r2\u0006\u0010'\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010(J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020,J&\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0086@\u00a2\u0006\u0002\u00103J\u000e\u00104\u001a\u000205H\u0086@\u00a2\u0006\u0002\u00106J\u001a\u0010>\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020908H\u0086@\u00a2\u0006\u0002\u00106J6\u0010?\u001a\u00020\u00142\u0006\u0010@\u001a\u0002092\u0006\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u0002002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0086@\u00a2\u0006\u0002\u0010EJ<\u0010?\u001a\u00020\u00142\u0006\u0010@\u001a\u0002092\u0006\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u0002002\f\u0010F\u001a\b\u0012\u0004\u0012\u00020H0G2\u0006\u0010C\u001a\u00020DH\u0086@\u00a2\u0006\u0002\u0010IJ6\u0010?\u001a\u00020\u00142\u0006\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u0002002\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020H2\u0006\u0010C\u001a\u00020MH\u0086@\u00a2\u0006\u0002\u0010NJ\u000e\u0010O\u001a\u0002092\u0006\u0010/\u001a\u000200J\u0016\u0010P\u001a\u00020B2\u0006\u0010L\u001a\u00020Q2\u0006\u0010R\u001a\u00020SJ&\u0010T\u001a\u00020\u00142\u0006\u0010L\u001a\u00020Q2\u0006\u0010U\u001a\u00020D2\u0006\u0010R\u001a\u00020SH\u0096@\u00a2\u0006\u0002\u0010VJ\u0016\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u0002092\u0006\u0010A\u001a\u00020BJ\u001e\u0010W\u001a\u00020X2\u0006\u0010L\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0086@\u00a2\u0006\u0002\u0010ZR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r0%X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u00107\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000209\u0018\u000108X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=\u00a8\u0006^"}, d2={"Lcn/sast/framework/report/coverage/Coverage;", "", "<init>", "()V", "startTimestamp", "Ljava/time/Instant;", "stringPool", "Lorg/jacoco/core/internal/analysis/StringPool;", "getStringPool", "()Lorg/jacoco/core/internal/analysis/StringPool;", "classCoverageMap", "", "", "Lcn/sast/framework/report/coverage/Coverage$ClassCoverage;", "getClassCoverageMap", "()Ljava/util/Map;", "coverQueue", "Lsoot/jimple/infoflow/collect/ConcurrentHashSet;", "Lcn/sast/framework/report/coverage/Coverage$JacocoCover;", "cover", "", "clazz", "Lcn/sast/framework/report/coverage/ClassSourceInfo;", "line", "", "(Lcn/sast/framework/report/coverage/ClassSourceInfo;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "className", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "([BILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coverByQueue", "createAnalyzingVisitor", "Lorg/objectweb/asm/ClassVisitor;", "classCoverage", "classId", "", "cache", "Lcom/github/benmanes/caffeine/cache/AsyncLoadingCache;", "analyzeClass", "source", "(Lcn/sast/framework/report/coverage/ClassSourceInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSessionInfo", "Lorg/jacoco/core/data/SessionInfo;", "getSessionInfoStore", "Lorg/jacoco/core/data/SessionInfoStore;", "flushExecutionDataFile", "sessionInfoStore", "executionDataStore", "Lorg/jacoco/core/data/ExecutionDataStore;", "dumpFile", "Lcn/sast/common/IResFile;", "(Lorg/jacoco/core/data/SessionInfoStore;Lorg/jacoco/core/data/ExecutionDataStore;Lcn/sast/common/IResFile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processCoverQueueData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coverageBuilderPair", "Lkotlin/Pair;", "Lorg/jacoco/core/analysis/CoverageBuilder;", "getCoverageBuilderPair", "()Lkotlin/Pair;", "setCoverageBuilderPair", "(Lkotlin/Pair;)V", "computeCoverageBuilder", "createReport", "coverageBuilder", "mLocator", "Lorg/jacoco/report/MultiSourceFileLocator;", "reportDirectory", "Lcn/sast/common/IResDirectory;", "(Lorg/jacoco/core/analysis/CoverageBuilder;Lorg/jacoco/core/data/SessionInfoStore;Lorg/jacoco/core/data/ExecutionDataStore;Lorg/jacoco/report/MultiSourceFileLocator;Lcn/sast/common/IResDirectory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sourceDirectory", "", "Lorg/jacoco/report/ISourceFileLocator;", "(Lorg/jacoco/core/analysis/CoverageBuilder;Lorg/jacoco/core/data/SessionInfoStore;Lorg/jacoco/core/data/ExecutionDataStore;Ljava/util/List;Lcn/sast/common/IResDirectory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bundleCoverage", "Lorg/jacoco/core/analysis/IBundleCoverage;", "locator", "Ljava/io/File;", "(Lorg/jacoco/core/data/SessionInfoStore;Lorg/jacoco/core/data/ExecutionDataStore;Lorg/jacoco/core/analysis/IBundleCoverage;Lorg/jacoco/report/ISourceFileLocator;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeCoverageBuilder", "getMultiSourceFileLocator", "Lcn/sast/framework/report/IProjectFileLocator;", "encoding", "Ljava/nio/charset/Charset;", "flushCoverage", "outputDir", "(Lcn/sast/framework/report/IProjectFileLocator;Lcn/sast/common/IResDirectory;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateSourceCoverage", "Lcn/sast/framework/report/coverage/SourceCoverage;", "coverage", "(Lcn/sast/framework/report/IProjectFileLocator;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "JacocoCover", "ClassCoverage", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nCoverage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Coverage.kt\ncn/sast/framework/report/coverage/Coverage\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,490:1\n1863#2,2:491\n1863#2,2:493\n*S KotlinDebug\n*F\n+ 1 Coverage.kt\ncn/sast/framework/report/coverage/Coverage\n*L\n363#1:491,2\n420#1:493,2\n*E\n"})
public class Coverage {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private Instant startTimestamp;
    @NotNull
    private final StringPool stringPool = new StringPool();
    @NotNull
    private final Map<String, ClassCoverage> classCoverageMap = new ConcurrentHashMap(1000);
    @NotNull
    private final ConcurrentHashSet<JacocoCover> coverQueue = new ConcurrentHashSet();
    @NotNull
    private final AsyncLoadingCache<ClassSourceInfo, ClassCoverage> cache;
    @Nullable
    private Pair<ExecutionDataStore, ? extends CoverageBuilder> coverageBuilderPair;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(Coverage::logger$lambda$5);

    public Coverage() {
        Function2 function2 = (arg_0, arg_1) -> Coverage.cache$lambda$0(this, arg_0, arg_1);
        AsyncLoadingCache asyncLoadingCache = Caffeine.newBuilder().buildAsync((AsyncCacheLoader)new /* Unavailable Anonymous Inner Class!! */);
        Intrinsics.checkNotNullExpressionValue((Object)asyncLoadingCache, (String)"buildAsync(...)");
        this.cache = asyncLoadingCache;
    }

    @NotNull
    public final StringPool getStringPool() {
        return this.stringPool;
    }

    @NotNull
    public final Map<String, ClassCoverage> getClassCoverageMap() {
        return this.classCoverageMap;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object cover(@NotNull ClassSourceInfo var1_1, int var2_2, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof cover.1)) ** GOTO lbl-1000
        var6_4 = $completion;
        if ((var6_4.label & -2147483648) != 0) {
            var6_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var7_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.I$0 = line;
                $continuation.label = 1;
                v0 = this.analyzeClass((ClassSourceInfo)clazz, (Continuation)$continuation);
                if (v0 == var7_6) {
                    return var7_6;
                }
                ** GOTO lbl22
            }
            case 1: {
                line = $continuation.I$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                v1 = (ClassCoverage)v0;
                if (v1 == null) {
                    return Unit.INSTANCE;
                }
                classCoverage = v1;
                classCoverage.cover(line);
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object cover(@NotNull String var1_1, int var2_2, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof cover.2)) ** GOTO lbl-1000
        var6_4 = $completion;
        if ((var6_4.label & -2147483648) != 0) {
            var6_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var7_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = this;
                $continuation.I$0 = line;
                $continuation.label = 1;
                v0 = AnalysisCache.G.INSTANCE.getAsync((AnalysisKey)new ClassSourceOfSCKey((String)className), (CoroutineContext)Dispatchers.getDefault(), (Continuation)$continuation);
                if (v0 == var7_6) {
                    return var7_6;
                }
                ** GOTO lbl24
            }
            case 1: {
                line = $continuation.I$0;
                this = (Coverage)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl24:
                // 2 sources

                v1 = (ClassSourceInfo)v0;
                if (v1 == null) {
                    return Unit.INSTANCE;
                }
                classSource = v1;
                $continuation.L$0 = null;
                $continuation.label = 2;
                v2 = this.cover(classSource, line, (Continuation)$continuation);
                if (v2 == var7_6) {
                    return var7_6;
                }
                ** GOTO lbl37
            }
            case 2: {
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl37:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object cover(@NotNull byte[] clazz, int line, @NotNull Continuation<? super Unit> $completion) {
        Object object = this.cover(ClassSourceInfo.Companion.invoke(clazz), line, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    public final void coverByQueue(@NotNull String className, int line) {
        Intrinsics.checkNotNullParameter((Object)className, (String)"className");
        ((Collection)this.coverQueue).add(new JacocoCover(className, line));
    }

    private final ClassVisitor createAnalyzingVisitor(ClassCoverage classCoverage, long classId, String className) {
        boolean noMatch = false;
        ClassCoverageImpl coverage = new ClassCoverageImpl(className, classId, noMatch);
        createAnalyzingVisitor.builder.1 builder2 = new /* Unavailable Anonymous Inner Class!! */;
        StringPool stringPool = this.stringPool;
        ClassAnalyzer analyzer2 = (ClassAnalyzer)new /* Unavailable Anonymous Inner Class!! */;
        return (ClassVisitor)new ClassProbesAdapter((ClassProbesVisitor)analyzer2, false);
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object analyzeClass(@NotNull ClassSourceInfo var1_1, @NotNull Continuation<? super ClassCoverage> $completion) {
        if (!($completion instanceof analyzeClass.1)) ** GOTO lbl-1000
        var7_3 = $completion;
        if ((var7_3.label & -2147483648) != 0) {
            var7_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var8_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                if (this.startTimestamp == null) {
                    this.startTimestamp = Instant.now();
                }
                if ((exists = (ClassCoverage)this.classCoverageMap.get(source.getClassName())) != null) {
                    return exists;
                }
                classCoverageCompletableFuture = this.cache.get((Object)source);
                Intrinsics.checkNotNull((Object)classCoverageCompletableFuture);
                $continuation.L$0 = this;
                $continuation.L$1 = source;
                $continuation.label = 1;
                v0 = FutureKt.await((CompletionStage)classCoverageCompletableFuture, (Continuation)$continuation);
                if (v0 == var8_5) {
                    return var8_5;
                }
                ** GOTO lbl30
            }
            case 1: {
                source = (ClassSourceInfo)$continuation.L$1;
                this = (Coverage)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl30:
                // 2 sources

                if ((classCoverage = (ClassCoverage)v0) == null) {
                    return null;
                }
                this.classCoverageMap.put(source.getClassName(), classCoverage);
                return classCoverage;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public final SessionInfo getSessionInfo() {
        Instant instant = this.startTimestamp;
        if (instant == null) {
            instant = Instant.now();
        }
        Instant startTimestamp = instant;
        Instant dumpTimestamp = Instant.now();
        return new SessionInfo(UUID.randomUUID().toString(), startTimestamp.getEpochSecond(), dumpTimestamp.getEpochSecond());
    }

    @NotNull
    public final SessionInfoStore getSessionInfoStore() {
        SessionInfo sessionInfo = this.getSessionInfo();
        SessionInfoStore sessionInfoStore = new SessionInfoStore();
        sessionInfoStore.visitSessionInfo(sessionInfo);
        return sessionInfoStore;
    }

    @Nullable
    public final Object flushExecutionDataFile(@NotNull SessionInfoStore sessionInfoStore, @NotNull ExecutionDataStore executionDataStore, @NotNull IResFile dumpFile, @NotNull Continuation<? super Unit> $completion) {
        dumpFile.mkdirs();
        Object object = BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object processCoverQueueData(@NotNull Continuation<? super Boolean> $completion) {
        if (!($completion instanceof processCoverQueueData.1)) ** GOTO lbl-1000
        var7_2 = $completion;
        if ((var7_2.label & -2147483648) != 0) {
            var7_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var8_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                if (this.coverQueue.isEmpty()) {
                    return Boxing.boxBoolean((boolean)false);
                }
                v0 = this.coverQueue.iterator();
                Intrinsics.checkNotNullExpressionValue((Object)v0, (String)"iterator(...)");
                var2_5 = v0;
lbl17:
                // 3 sources

                while (var2_5.hasNext()) {
                    var3_6 = (JacocoCover)var2_5.next();
                    name = var3_6.component1();
                    ln = var3_6.component2();
                    $continuation.L$0 = this;
                    $continuation.L$1 = var2_5;
                    $continuation.label = 1;
                    v1 = this.cover(name, ln, (Continuation)$continuation);
                    if (v1 != var8_4) continue;
                    return var8_4;
                }
                break;
            }
            case 1: {
                var2_5 = (Iterator)$continuation.L$1;
                this = (Coverage)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
                ** GOTO lbl17
            }
        }
        this.coverQueue.clear();
        return Boxing.boxBoolean((boolean)false);
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Pair<ExecutionDataStore, CoverageBuilder> getCoverageBuilderPair() {
        return this.coverageBuilderPair;
    }

    public final void setCoverageBuilderPair(@Nullable Pair<ExecutionDataStore, ? extends CoverageBuilder> pair) {
        this.coverageBuilderPair = pair;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object computeCoverageBuilder(@NotNull Continuation<? super Pair<ExecutionDataStore, ? extends CoverageBuilder>> $completion) {
        if (!($completion instanceof computeCoverageBuilder.1)) ** GOTO lbl-1000
        var9_2 = $completion;
        if ((var9_2.label & -2147483648) != 0) {
            var9_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var10_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                coverageBuilderPair = this.coverageBuilderPair;
                $continuation.L$0 = this;
                $continuation.L$1 = coverageBuilderPair;
                $continuation.label = 1;
                v0 = this.processCoverQueueData((Continuation)$continuation);
                if (v0 == var10_4) {
                    return var10_4;
                }
                ** GOTO lbl25
            }
            case 1: {
                coverageBuilderPair = (Pair)$continuation.L$1;
                this = (Coverage)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl25:
                // 2 sources

                if (!((Boolean)v0).booleanValue() && coverageBuilderPair != null) {
                    return coverageBuilderPair;
                }
                executionDataStore = new ExecutionDataStore();
                var4_7 = this.classCoverageMap.entrySet().iterator();
                while (var4_7.hasNext()) {
                    classCoverage = (ClassCoverage)var4_7.next().getValue();
                    probes = new boolean[classCoverage.getCount()];
                    classCoverage.getProbes().stream().forEach((IntConsumer)new /* Unavailable Anonymous Inner Class!! */);
                    try {
                        executionDataStore.put(new ExecutionData(classCoverage.getClassId(), StringsKt.replace$default((String)classCoverage.getClassName(), (String)".", (String)"/", (boolean)false, (int)4, null), probes));
                    }
                    catch (Exception e) {
                        Coverage.logger.error((Throwable)e, (Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, computeCoverageBuilder$lambda$1(cn.sast.framework.report.coverage.Coverage$ClassCoverage ), ()Ljava/lang/Object;)((ClassCoverage)classCoverage));
                    }
                }
                coverageBuilder = this.makeCoverageBuilder(executionDataStore);
                this.coverageBuilderPair = coverageBuilderPair = TuplesKt.to((Object)executionDataStore, (Object)coverageBuilder);
                return coverageBuilderPair;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object createReport(@NotNull CoverageBuilder coverageBuilder, @NotNull SessionInfoStore sessionInfoStore, @NotNull ExecutionDataStore executionDataStore, @NotNull MultiSourceFileLocator mLocator, @NotNull IResDirectory reportDirectory, @NotNull Continuation<? super Unit> $completion) throws IOException {
        IBundleCoverage bundleCoverage = coverageBuilder.getBundle("CoraxCoverage");
        Intrinsics.checkNotNull((Object)bundleCoverage);
        Object object = this.createReport(sessionInfoStore, executionDataStore, bundleCoverage, (ISourceFileLocator)mLocator, reportDirectory.getFile(), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object createReport(@NotNull CoverageBuilder coverageBuilder, @NotNull SessionInfoStore sessionInfoStore, @NotNull ExecutionDataStore executionDataStore, @NotNull List<? extends ISourceFileLocator> sourceDirectory, @NotNull IResDirectory reportDirectory, @NotNull Continuation<? super Unit> $completion) throws IOException {
        MultiSourceFileLocator mLocator = new MultiSourceFileLocator(4);
        Iterable $this$forEach$iv = sourceDirectory;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ISourceFileLocator p0 = (ISourceFileLocator)element$iv;
            boolean $i$f$createReport$stub_for_inlining = false;
            boolean bl = false;
            mLocator.add(p0);
        }
        Object object = this.createReport(coverageBuilder, sessionInfoStore, executionDataStore, mLocator, reportDirectory, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object createReport(@NotNull SessionInfoStore var1_1, @NotNull ExecutionDataStore var2_2, @NotNull IBundleCoverage var3_3, @NotNull ISourceFileLocator var4_4, @NotNull File var5_5, @NotNull Continuation<? super Unit> $completion) throws IOException {
        if (!($completion instanceof createReport.4)) ** GOTO lbl-1000
        var8_7 = $completion;
        if ((var8_7.label & -2147483648) != 0) {
            var8_7.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var9_9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                if (!reportDirectory.exists()) {
                    reportDirectory.mkdir();
                }
                $continuation.L$0 = reportDirectory;
                $continuation.label = 1;
                v0 = BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (Continuation)$continuation);
                if (v0 == var9_9) {
                    return var9_9;
                }
                ** GOTO lbl25
            }
            case 1: {
                reportDirectory = (File)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl25:
                // 2 sources

                Coverage.logger.info((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, createReport$lambda$2(java.io.File ), ()Ljava/lang/Object;)((File)reportDirectory));
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public final CoverageBuilder makeCoverageBuilder(@NotNull ExecutionDataStore executionDataStore) {
        CoverageBuilder coverageBuilder;
        Intrinsics.checkNotNullParameter((Object)executionDataStore, (String)"executionDataStore");
        CoverageBuilder $this$makeCoverageBuilder_u24lambda_u243 = coverageBuilder = new CoverageBuilder();
        boolean bl = false;
        Analyzer analyzer2 = new Analyzer(executionDataStore, (ICoverageVisitor)$this$makeCoverageBuilder_u24lambda_u243);
        Iterator iterator2 = this.classCoverageMap.entrySet().iterator();
        while (iterator2.hasNext()) {
            ClassCoverage classCoverage = (ClassCoverage)iterator2.next().getValue();
            analyzer2.analyzeClass(classCoverage.getByteArray(), classCoverage.getClassName());
        }
        CoverageBuilder coverage = coverageBuilder;
        return coverage;
    }

    @NotNull
    public final MultiSourceFileLocator getMultiSourceFileLocator(@NotNull IProjectFileLocator locator2, @NotNull Charset encoding) {
        Intrinsics.checkNotNullParameter((Object)locator2, (String)"locator");
        Intrinsics.checkNotNullParameter((Object)encoding, (String)"encoding");
        Object[] objectArray = new InputStreamSourceFileLocator[]{new DirectorySourceFileLocator(new File("."), encoding.name(), 4), new JacocoSourceLocator(locator2, null, 0, 6, null)};
        List jacocoLocators = CollectionsKt.listOf((Object[])objectArray);
        MultiSourceFileLocator mLocator = new MultiSourceFileLocator(4);
        Iterable $this$forEach$iv = jacocoLocators;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ISourceFileLocator p0 = (ISourceFileLocator)element$iv;
            boolean $i$f$getMultiSourceFileLocator$stub_for_inlining$4 = false;
            boolean bl = false;
            mLocator.add(p0);
        }
        return mLocator;
    }

    @Nullable
    public Object flushCoverage(@NotNull IProjectFileLocator locator2, @NotNull IResDirectory outputDir, @NotNull Charset encoding, @NotNull Continuation<? super Unit> $completion) {
        return Coverage.flushCoverage$suspendImpl((Coverage)this, (IProjectFileLocator)locator2, (IResDirectory)outputDir, (Charset)encoding, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ Object flushCoverage$suspendImpl(Coverage var0, IProjectFileLocator var1_1, IResDirectory var2_2, Charset var3_3, Continuation<? super Unit> $completion) {
        if (!($completion instanceof flushCoverage.1)) ** GOTO lbl-1000
        var11_5 = $completion;
        if ((var11_5.label & -2147483648) != 0) {
            var11_5.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var12_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                outputDir.deleteDirectoryRecursively();
                outputDir.mkdirs();
                $continuation.L$0 = $this;
                $continuation.L$1 = locator;
                $continuation.L$2 = outputDir;
                $continuation.L$3 = encoding;
                $continuation.label = 1;
                v0 = $this.computeCoverageBuilder((Continuation)$continuation);
                if (v0 == var12_7) {
                    return var12_7;
                }
                ** GOTO lbl30
            }
            case 1: {
                encoding = (Charset)$continuation.L$3;
                outputDir = (IResDirectory)$continuation.L$2;
                locator = (IProjectFileLocator)$continuation.L$1;
                $this = (Coverage)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl30:
                // 2 sources

                var5_8 = (Pair)v0;
                executionDataStore = (ExecutionDataStore)var5_8.component1();
                coverageBuilder = (CoverageBuilder)var5_8.component2();
                sessionInfoStore = $this.getSessionInfoStore();
                $continuation.L$0 = $this;
                $continuation.L$1 = locator;
                $continuation.L$2 = outputDir;
                $continuation.L$3 = encoding;
                $continuation.L$4 = executionDataStore;
                $continuation.L$5 = coverageBuilder;
                $continuation.L$6 = sessionInfoStore;
                $continuation.label = 2;
                v1 = $this.flushExecutionDataFile(sessionInfoStore, executionDataStore, outputDir.resolve("jacoco.exec").toFile(), (Continuation)$continuation);
                if (v1 == var12_7) {
                    return var12_7;
                }
                ** GOTO lbl56
            }
            case 2: {
                sessionInfoStore = (SessionInfoStore)$continuation.L$6;
                coverageBuilder = (CoverageBuilder)$continuation.L$5;
                executionDataStore = (ExecutionDataStore)$continuation.L$4;
                encoding = (Charset)$continuation.L$3;
                outputDir = (IResDirectory)$continuation.L$2;
                locator = (IProjectFileLocator)$continuation.L$1;
                $this = (Coverage)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl56:
                // 2 sources

                mLocator = $this.getMultiSourceFileLocator(locator, encoding);
                $continuation.L$0 = null;
                $continuation.L$1 = null;
                $continuation.L$2 = null;
                $continuation.L$3 = null;
                $continuation.L$4 = null;
                $continuation.L$5 = null;
                $continuation.L$6 = null;
                $continuation.label = 3;
                v2 = var0.createReport(coverageBuilder, sessionInfoStore, executionDataStore, mLocator, outputDir.toDirectory(), (Continuation)$continuation);
                if (v2 == var12_7) {
                    return var12_7;
                }
                ** GOTO lbl72
            }
            case 3: {
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl72:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public final SourceCoverage calculateSourceCoverage(@NotNull CoverageBuilder coverage, @NotNull MultiSourceFileLocator mLocator) {
        Intrinsics.checkNotNullParameter((Object)coverage, (String)"coverage");
        Intrinsics.checkNotNullParameter((Object)mLocator, (String)"mLocator");
        Map sourceCoverage = new LinkedHashMap();
        for (ISourceFileCoverage srcCov : coverage.getSourceFiles()) {
            int n;
            String sourceKey = srcCov.getPackageName() + "/" + srcCov.getName();
            try {
                Reader reader = mLocator.getSourceFile(srcCov.getPackageName(), srcCov.getName());
                if (reader == null) continue;
                n = TextStreamsKt.readLines((Reader)reader).size();
            }
            catch (Exception e) {
                logger.error("Source file " + sourceKey + " cannot be read!", (Throwable)e);
                continue;
            }
            int lineCount = n;
            Intrinsics.checkNotNull((Object)srcCov);
            sourceCoverage.put(sourceKey, new SourceCoverage.JavaSourceCoverage(lineCount, srcCov));
        }
        return new SourceCoverage(sourceCoverage);
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object calculateSourceCoverage(@NotNull IProjectFileLocator var1_1, @NotNull Charset var2_2, @NotNull Continuation<? super SourceCoverage> $completion) {
        if (!($completion instanceof calculateSourceCoverage.1)) ** GOTO lbl-1000
        var7_4 = $completion;
        if ((var7_4.label & -2147483648) != 0) {
            var7_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var8_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = this;
                $continuation.L$1 = locator;
                $continuation.L$2 = encoding;
                $continuation.label = 1;
                v0 = this.computeCoverageBuilder((Continuation)$continuation);
                if (v0 == var8_6) {
                    return var8_6;
                }
                ** GOTO lbl26
            }
            case 1: {
                encoding = (Charset)$continuation.L$2;
                locator = (IProjectFileLocator)$continuation.L$1;
                this = (Coverage)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl26:
                // 2 sources

                coverageBuilder = (CoverageBuilder)((Pair)v0).component2();
                mLocator = this.getMultiSourceFileLocator(locator, encoding);
                return this.calculateSourceCoverage(coverageBuilder, mLocator);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private static final CompletableFuture cache$lambda$0(Coverage this$0, ClassSourceInfo source, Executor executor) {
        Intrinsics.checkNotNullParameter((Object)executor, (String)"executor");
        String className = source.getClassName();
        long classId = source.getJacocoClassId();
        ClassCoverage classCoverage = new ClassCoverage(className, source.getByteArray(), classId);
        return FutureKt.future$default((CoroutineScope)CoroutineScopeKt.CoroutineScope((CoroutineContext)((CoroutineContext)ExecutorsKt.from((Executor)executor))), null, null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)3, null);
    }

    private static final Object computeCoverageBuilder$lambda$1(ClassCoverage $classCoverage) {
        return "An error occurred: class=" + $classCoverage.getClassName();
    }

    private static final Object createReport$lambda$2(File $reportDirectory) {
        File file = FilesKt.resolve((File)$reportDirectory, (String)"index.html").getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue((Object)file, (String)"getAbsoluteFile(...)");
        return "Jacoco coverage html reports: " + FilesKt.normalize((File)file);
    }

    private static final Unit logger$lambda$5() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ ClassVisitor access$createAnalyzingVisitor(Coverage $this, ClassCoverage classCoverage, long classId, String className) {
        return $this.createAnalyzingVisitor(classCoverage, classId, className);
    }
}

