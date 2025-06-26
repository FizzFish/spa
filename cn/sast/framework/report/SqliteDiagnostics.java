/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.ExecutableQuery
 *  app.cash.sqldelight.Transacter
 *  app.cash.sqldelight.Transacter$DefaultImpls
 *  app.cash.sqldelight.TransactionWithoutReturn
 *  cn.sast.api.AnalyzerEnv
 *  cn.sast.api.config.CheckerInfoGenResult
 *  cn.sast.api.config.ExtSettings
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.MainConfig$RelativePath
 *  cn.sast.api.report.BugPathEvent
 *  cn.sast.api.report.CheckType2StringKind
 *  cn.sast.api.report.ClassResInfo
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.api.report.Report
 *  cn.sast.api.util.PhaseIntervalTimerKt
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.common.Resource
 *  cn.sast.common.ResourceImplKt
 *  cn.sast.common.ResourceKt
 *  cn.sast.framework.metrics.MetricsMonitor
 *  cn.sast.framework.metrics.MetricsMonitorKt
 *  cn.sast.framework.report.EmptyWrapperFileGenerator
 *  cn.sast.framework.report.FileID
 *  cn.sast.framework.report.FileX
 *  cn.sast.framework.report.FileX$ID
 *  cn.sast.framework.report.IFileReportConsumer
 *  cn.sast.framework.report.IMetadataVisitor
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.IWrapperFileGenerator
 *  cn.sast.framework.report.ReportConsumer
 *  cn.sast.framework.report.ReportConsumer$MetaData
 *  cn.sast.framework.report.RuleAndRuleMapping
 *  cn.sast.framework.report.SQLiteDB
 *  cn.sast.framework.report.SqliteDiagnostics
 *  cn.sast.framework.report.SqliteDiagnostics$ArrayHashIdGenerator
 *  cn.sast.framework.report.SqliteDiagnostics$Companion
 *  cn.sast.framework.report.SqliteDiagnostics$flush$1
 *  cn.sast.framework.report.SqliteDiagnostics$init$1
 *  cn.sast.framework.report.ValueWithId
 *  cn.sast.framework.report.metadata.AnalysisMetadata
 *  cn.sast.framework.report.metadata.Analyzer
 *  cn.sast.framework.report.metadata.AnalyzerStatistics
 *  cn.sast.framework.report.metadata.Tool
 *  cn.sast.framework.report.sqldelight.AnalyzerResultFile
 *  cn.sast.framework.report.sqldelight.AnalyzerStatistics
 *  cn.sast.framework.report.sqldelight.ControlFlow
 *  cn.sast.framework.report.sqldelight.ControlFlowPath
 *  cn.sast.framework.report.sqldelight.Database
 *  cn.sast.framework.report.sqldelight.Diagnostic
 *  cn.sast.framework.report.sqldelight.File
 *  cn.sast.framework.report.sqldelight.Note
 *  cn.sast.framework.report.sqldelight.NotePath
 *  cn.sast.framework.report.sqldelight.Region
 *  cn.sast.framework.report.sqldelight.Rule
 *  cn.sast.framework.result.OutputType
 *  com.feysh.corax.cache.analysis.SootInfoCache
 *  com.feysh.corax.cache.analysis.SootLineToMethodMapFactory
 *  com.feysh.corax.commons.NullableLateinit
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.api.Language
 *  com.feysh.corax.config.api.report.Region
 *  com.github.benmanes.caffeine.cache.CacheLoader
 *  com.github.benmanes.caffeine.cache.Caffeine
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  com.github.javaparser.ast.body.BodyDeclaration
 *  kotlin.Lazy
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KProperty
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  kotlin.time.Duration
 *  kotlin.time.DurationKt
 *  kotlin.time.DurationUnit
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.ExecutorCoroutineDispatcher
 *  kotlinx.coroutines.ExecutorsKt
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.StringSerializer
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JsonBuilder
 *  kotlinx.serialization.json.JsonKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 */
package cn.sast.framework.report;

import app.cash.sqldelight.ExecutableQuery;
import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.TransactionWithoutReturn;
import cn.sast.api.AnalyzerEnv;
import cn.sast.api.config.CheckerInfoGenResult;
import cn.sast.api.config.ExtSettings;
import cn.sast.api.config.MainConfig;
import cn.sast.api.report.BugPathEvent;
import cn.sast.api.report.CheckType2StringKind;
import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.api.report.Report;
import cn.sast.api.util.PhaseIntervalTimerKt;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.Resource;
import cn.sast.common.ResourceImplKt;
import cn.sast.common.ResourceKt;
import cn.sast.framework.metrics.MetricsMonitor;
import cn.sast.framework.metrics.MetricsMonitorKt;
import cn.sast.framework.report.EmptyWrapperFileGenerator;
import cn.sast.framework.report.FileID;
import cn.sast.framework.report.FileX;
import cn.sast.framework.report.IFileReportConsumer;
import cn.sast.framework.report.IMetadataVisitor;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.IWrapperFileGenerator;
import cn.sast.framework.report.ReportConsumer;
import cn.sast.framework.report.RuleAndRuleMapping;
import cn.sast.framework.report.SQLiteDB;
import cn.sast.framework.report.SqliteDiagnostics;
import cn.sast.framework.report.ValueWithId;
import cn.sast.framework.report.metadata.AnalysisMetadata;
import cn.sast.framework.report.metadata.Analyzer;
import cn.sast.framework.report.metadata.AnalyzerStatistics;
import cn.sast.framework.report.metadata.Tool;
import cn.sast.framework.report.sqldelight.AnalyzerResultFile;
import cn.sast.framework.report.sqldelight.ControlFlow;
import cn.sast.framework.report.sqldelight.ControlFlowPath;
import cn.sast.framework.report.sqldelight.Database;
import cn.sast.framework.report.sqldelight.Diagnostic;
import cn.sast.framework.report.sqldelight.File;
import cn.sast.framework.report.sqldelight.Note;
import cn.sast.framework.report.sqldelight.NotePath;
import cn.sast.framework.report.sqldelight.Region;
import cn.sast.framework.report.sqldelight.Rule;
import cn.sast.framework.result.OutputType;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.cache.analysis.SootLineToMethodMapFactory;
import com.feysh.corax.commons.NullableLateinit;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.Language;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.javaparser.ast.body.BodyDeclaration;
import java.lang.invoke.LambdaMetafactory;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00ba\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u0090\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u008f\u0001\u0090\u0001B5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010A\u001a\u00020BH\u0096@\u00a2\u0006\u0002\u0010CJ\u0010\u0010D\u001a\u00020B2\b\b\u0002\u0010E\u001a\u00020=J\b\u0010F\u001a\u00020BH\u0002J\u0018\u0010G\u001a\u00020B*\u0006\u0012\u0002\b\u00030H2\u0006\u0010I\u001a\u00020=H\u0002J\u0006\u0010G\u001a\u00020BJ\b\u0010J\u001a\u00020BH\u0016J,\u0010K\u001a\u00020B2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020N0M2\u0006\u0010O\u001a\u00020=2\u0006\u0010P\u001a\u00020QH\u0096@\u00a2\u0006\u0002\u0010RJ\u0010\u0010S\u001a\u00020B2\u0006\u0010T\u001a\u00020UH\u0016J,\u0010V\u001a\u00020B2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020N0M2\u0006\u0010P\u001a\u00020Q2\u0006\u0010O\u001a\u00020=H\u0082@\u00a2\u0006\u0002\u0010WJ\u001a\u0010X\u001a\u0004\u0018\u0001012\u0006\u0010P\u001a\u00020Q2\u0006\u0010Y\u001a\u00020ZH\u0002J\u001e\u0010[\u001a\b\u0018\u00010\\R\u0002062\u0006\u0010P\u001a\u00020Q2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0016\u0010]\u001a\b\u0018\u00010\\R\u0002062\u0006\u0010^\u001a\u00020&H\u0002J\u0014\u0010_\u001a\b\u0018\u00010\\R\u0002062\u0006\u0010Y\u001a\u00020&J\u0010\u0010`\u001a\u0002062\u0006\u0010^\u001a\u00020&H\u0002J\u0016\u0010e\u001a\u0004\u0018\u00010=*\u0002062\u0006\u0010f\u001a\u00020gH\u0002J,\u0010h\u001a\n\u0012\u0004\u0012\u00020j\u0018\u00010i2\u0006\u0010P\u001a\u00020Q2\u0006\u0010k\u001a\u00020Z2\n\u0010l\u001a\u00060mj\u0002`nH\u0002J \u0010o\u001a\n\u0018\u00010mj\u0004\u0018\u0001`n2\u0006\u0010p\u001a\u00020Z2\u0006\u0010f\u001a\u00020gH\u0002J \u0010q\u001a\n\u0012\u0004\u0012\u00020r\u0018\u00010i2\u0006\u0010P\u001a\u00020Q2\u0006\u0010s\u001a\u00020tH\u0002J \u0010u\u001a\n\u0012\u0004\u0012\u00020v\u0018\u00010i2\u0006\u0010P\u001a\u00020Q2\u0006\u0010s\u001a\u00020tH\u0002J%\u0010z\u001a\u0004\u0018\u00010x2\u0006\u0010P\u001a\u00020Q2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020t0|H\u0002\u00a2\u0006\u0002\u0010}J%\u0010~\u001a\u0004\u0018\u00010x2\u0006\u0010P\u001a\u00020Q2\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020t0|H\u0002\u00a2\u0006\u0002\u0010}J#\u0010\u0080\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0081\u0001\u0018\u00010i2\u0006\u0010P\u001a\u00020Q2\u0007\u0010\u0082\u0001\u001a\u00020NH\u0002J!\u0010\u0083\u0001\u001a\n\u0012\u0005\u0012\u00030\u0085\u00010\u0084\u00012\u000e\u0010\u0086\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010MH\u0002J!\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\u0006\u0010Y\u001a\u00020&2\u000b\b\u0002\u0010\u008a\u0001\u001a\u0004\u0018\u00010=H\u0002J\u0007\u0010\u008b\u0001\u001a\u00020BJ\u001b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0007\u0010\u008e\u0001\u001a\u00020U2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R+\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00188B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\"8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020(8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020100X\u0082\u0004\u00a2\u0006\u0002\n\u0000Rh\u00102\u001aZ\u0012\f\u0012\n 4*\u0004\u0018\u00010&0&\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000206 4*\n\u0012\u0004\u0012\u000206\u0018\u00010505 4*,\u0012\f\u0012\n 4*\u0004\u0018\u00010&0&\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000206 4*\n\u0012\u0004\u0012\u000206\u0018\u00010505\u0018\u00010303X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u00107R\u0018\u00108\u001a\u000209*\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010;R\u0018\u0010<\u001a\u00020=*\u00020>8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010@R\u001a\u0010a\u001a\u0004\u0018\u00010b*\u00020N8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bc\u0010dR\u001a\u0010w\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020x00X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010y\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020x00X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0091\u0001"}, d2={"Lcn/sast/framework/report/SqliteDiagnostics;", "Lcn/sast/framework/report/ReportConsumer;", "Lcn/sast/framework/report/IFileReportConsumer;", "Lcn/sast/framework/report/IMetadataVisitor;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "info", "Lcom/feysh/corax/cache/analysis/SootInfoCache;", "outputDir", "Lcn/sast/common/IResDirectory;", "monitor", "Lcn/sast/framework/metrics/MetricsMonitor;", "type", "Lcn/sast/framework/result/OutputType;", "<init>", "(Lcn/sast/api/config/MainConfig;Lcom/feysh/corax/cache/analysis/SootInfoCache;Lcn/sast/common/IResDirectory;Lcn/sast/framework/metrics/MetricsMonitor;Lcn/sast/framework/result/OutputType;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "getInfo", "()Lcom/feysh/corax/cache/analysis/SootInfoCache;", "getMonitor", "()Lcn/sast/framework/metrics/MetricsMonitor;", "_sdb", "Lcom/feysh/corax/commons/NullableLateinit;", "Lcn/sast/framework/report/SQLiteDB;", "<set-?>", "sqLiteDB", "getSqLiteDB", "()Lcn/sast/framework/report/SQLiteDB;", "setSqLiteDB", "(Lcn/sast/framework/report/SQLiteDB;)V", "sqLiteDB$delegate", "Lcom/feysh/corax/commons/NullableLateinit;", "database", "Lcn/sast/framework/report/sqldelight/Database;", "getDatabase", "()Lcn/sast/framework/report/sqldelight/Database;", "sqliteReportDb", "Lcn/sast/common/IResFile;", "metadata", "Lcn/sast/framework/report/ReportConsumer$MetaData;", "getMetadata", "()Lcn/sast/framework/report/ReportConsumer$MetaData;", "writeDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "ruleAndRuleMapping", "Lcn/sast/framework/report/RuleAndRuleMapping;", "fileIdMap", "", "Lcn/sast/framework/report/FileID;", "fileCache", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "kotlin.jvm.PlatformType", "Ljava/util/Optional;", "Lcn/sast/framework/report/FileX;", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "sourceEncoding", "Ljava/nio/charset/Charset;", "getSourceEncoding", "(Lcn/sast/common/IResFile;)Ljava/nio/charset/Charset;", "id", "", "Lcom/feysh/corax/config/api/CheckType;", "getId", "(Lcom/feysh/corax/config/api/CheckType;)Ljava/lang/String;", "init", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "open", "journalMode", "createRuleAndRuleMapping", "verify", "Lapp/cash/sqldelight/ExecutableQuery;", "name", "close", "flush", "reports", "", "Lcn/sast/api/report/Report;", "filename", "locator", "Lcn/sast/framework/report/IProjectFileLocator;", "(Ljava/util/List;Ljava/lang/String;Lcn/sast/framework/report/IProjectFileLocator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "visit", "analysisMetadata", "Lcn/sast/framework/report/metadata/AnalysisMetadata;", "serializeReportsToDb", "(Ljava/util/List;Lcn/sast/framework/report/IProjectFileLocator;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFileCached", "file", "Lcn/sast/api/report/IBugResInfo;", "createFileXCached", "Lcn/sast/framework/report/FileX$ID;", "createFileXCachedFromAbsFile", "absFile", "createFileXCachedFromFile", "createFile", "associateChecker", "Lcn/sast/framework/report/sqldelight/Rule;", "getAssociateChecker", "(Lcn/sast/api/report/Report;)Lcn/sast/framework/report/sqldelight/Rule;", "lineContent", "line", "", "createRegion", "Lcn/sast/framework/report/ValueWithId;", "Lcn/sast/framework/report/sqldelight/Region;", "res", "region", "Lcom/feysh/corax/config/api/report/Region;", "Lcn/sast/framework/report/AliasRegion;", "getFuncRange", "classInfo", "createNote", "Lcn/sast/framework/report/sqldelight/Note;", "event", "Lcn/sast/api/report/BugPathEvent;", "createControlFlow", "Lcn/sast/framework/report/sqldelight/ControlFlow;", "noteHashIdAutoIncrement", "", "ctrlFlowHashIdAutoIncrement", "createControlFlowPath", "path", "", "(Lcn/sast/framework/report/IProjectFileLocator;Ljava/util/List;)Ljava/lang/Long;", "createNotePath", "pathEvents", "createDiagnostic", "Lcn/sast/framework/report/sqldelight/Diagnostic;", "report", "getAnalyzerStatisticsSet", "", "Lcn/sast/framework/report/metadata/AnalyzerStatistics;", "tools", "Lcn/sast/framework/report/metadata/Tool;", "createAnalyzerResultFile", "Lcn/sast/framework/report/sqldelight/AnalyzerResultFile;", "fileName", "writeAnalyzerResultFiles", "createAnalyzerStatistics", "Lcn/sast/framework/report/sqldelight/AnalyzerStatistics;", "data", "ArrayHashIdGenerator", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nSqliteDiagnostics.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SqliteDiagnostics.kt\ncn/sast/framework/report/SqliteDiagnostics\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Region.kt\ncom/feysh/corax/config/api/report/Region\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,813:1\n381#2,7:814\n381#2,7:821\n1#3:828\n1#3:830\n1#3:834\n59#4:829\n57#4:831\n60#4:832\n59#4:833\n57#4,2:835\n1279#5,2:837\n1293#5,4:839\n1863#5,2:843\n1279#5,2:845\n1293#5,4:847\n1863#5,2:851\n1863#5:853\n1863#5,2:854\n1864#5:856\n1863#5,2:857\n1863#5,2:859\n1628#5,3:861\n1863#5,2:864\n*S KotlinDebug\n*F\n+ 1 SqliteDiagnostics.kt\ncn/sast/framework/report/SqliteDiagnostics\n*L\n365#1:814,7\n379#1:821,7\n465#1:830\n474#1:834\n465#1:829\n465#1:831\n474#1:832\n474#1:833\n474#1:835,2\n573#1:837,2\n573#1:839,4\n593#1:843,2\n600#1:845,2\n600#1:847,4\n624#1:851,2\n708#1:853\n709#1:854,2\n708#1:856\n755#1:857,2\n762#1:859,2\n770#1:861,3\n738#1:864,2\n*E\n"})
public class SqliteDiagnostics
extends ReportConsumer
implements IFileReportConsumer,
IMetadataVisitor {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final MainConfig mainConfig;
    @Nullable
    private final SootInfoCache info;
    @Nullable
    private final MetricsMonitor monitor;
    @NotNull
    private NullableLateinit<SQLiteDB> _sdb;
    @NotNull
    private final NullableLateinit sqLiteDB$delegate;
    @NotNull
    private IResFile sqliteReportDb;
    @NotNull
    private final ExecutorCoroutineDispatcher writeDispatcher;
    @Nullable
    private RuleAndRuleMapping ruleAndRuleMapping;
    @NotNull
    private final Map<IResFile, FileID> fileIdMap;
    private final LoadingCache<IResFile, Optional<FileX>> fileCache;
    @NotNull
    private final Map<String, Long> noteHashIdAutoIncrement;
    @NotNull
    private final Map<String, Long> ctrlFlowHashIdAutoIncrement;
    @NotNull
    private static final KLogger logger;
    @NotNull
    private static final Json jsonFormat;

    public SqliteDiagnostics(@NotNull MainConfig mainConfig, @Nullable SootInfoCache info2, @NotNull IResDirectory outputDir, @Nullable MetricsMonitor monitor, @NotNull OutputType type) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        Intrinsics.checkNotNullParameter((Object)outputDir, (String)"outputDir");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        super(type, outputDir);
        this.mainConfig = mainConfig;
        this.info = info2;
        this.monitor = monitor;
        this.sqLiteDB$delegate = this._sdb = new NullableLateinit("SQLiteDB is not initialized yet");
        this.sqliteReportDb = this.mainConfig.getSqlite_report_db();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue((Object)executorService, (String)"newSingleThreadExecutor(...)");
        this.writeDispatcher = ExecutorsKt.from((ExecutorService)executorService);
        Map map = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(map, (String)"synchronizedMap(...)");
        this.fileIdMap = map;
        this.fileCache = Caffeine.newBuilder().initialCapacity(1000).softValues().build((CacheLoader)new /* Unavailable Anonymous Inner Class!! */);
        this.noteHashIdAutoIncrement = new HashMap(1000);
        this.ctrlFlowHashIdAutoIncrement = new HashMap(1000);
    }

    public /* synthetic */ SqliteDiagnostics(MainConfig mainConfig, SootInfoCache sootInfoCache, IResDirectory iResDirectory, MetricsMonitor metricsMonitor, OutputType outputType, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x10) != 0) {
            outputType = OutputType.SQLITE;
        }
        this(mainConfig, sootInfoCache, iResDirectory, metricsMonitor, outputType);
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    @Nullable
    public final SootInfoCache getInfo() {
        return this.info;
    }

    @Nullable
    public final MetricsMonitor getMonitor() {
        return this.monitor;
    }

    private final SQLiteDB getSqLiteDB() {
        return (SQLiteDB)this.sqLiteDB$delegate.getValue((Object)this, $$delegatedProperties[0]);
    }

    private final void setSqLiteDB(SQLiteDB sQLiteDB) {
        this.sqLiteDB$delegate.setValue((Object)this, $$delegatedProperties[0], (Object)sQLiteDB);
    }

    private final Database getDatabase() {
        return this.getSqLiteDB().getDatabase();
    }

    @NotNull
    public final ReportConsumer.MetaData getMetadata() {
        return new ReportConsumer.MetaData("CoraxJava sqlite report", "1.0", "CoraxJava");
    }

    @NotNull
    public Charset getSourceEncoding(@NotNull IResFile $this$sourceEncoding) {
        Intrinsics.checkNotNullParameter((Object)$this$sourceEncoding, (String)"<this>");
        return Charsets.UTF_8;
    }

    private final String getId(CheckType $this$id) {
        return (String)CheckType2StringKind.Companion.getCheckType2StringKind().getConvert().invoke((Object)$this$id);
    }

    @Nullable
    public Object init(@NotNull Continuation<? super Unit> $completion) {
        return SqliteDiagnostics.init$suspendImpl((SqliteDiagnostics)this, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ Object init$suspendImpl(SqliteDiagnostics var0, Continuation<? super Unit> $completion) {
        if (!($completion instanceof init.1)) ** GOTO lbl-1000
        var3_2 = $completion;
        if ((var3_2.label & -2147483648) != 0) {
            var3_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var4_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = $this;
                $continuation.label = 1;
                v0 = super.init((Continuation)$continuation);
                if (v0 == var4_4) {
                    return var4_4;
                }
                ** GOTO lbl22
            }
            case 1: {
                $this = (SqliteDiagnostics)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                SqliteDiagnostics.open$default((SqliteDiagnostics)$this, null, (int)1, null);
                $this.createRuleAndRuleMapping();
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final void open(@NotNull String journalMode) {
        Intrinsics.checkNotNullParameter((Object)journalMode, (String)"journalMode");
        this.sqliteReportDb.mkdirs();
        this.setSqLiteDB(Companion.openDataBase(this.sqliteReportDb.getPathString(), journalMode));
        this.getSqLiteDB().createSchema();
    }

    public static /* synthetic */ void open$default(SqliteDiagnostics sqliteDiagnostics, String string, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: open");
        }
        if ((n & 1) != 0) {
            string = ExtSettings.INSTANCE.getSqliteJournalMode();
        }
        sqliteDiagnostics.open(string);
    }

    private final void createRuleAndRuleMapping() {
        block2: {
            Lazy checkerInfo;
            IResFile ruleSortYaml;
            block1: {
                ruleSortYaml = this.mainConfig.getRule_sort_yaml();
                Lazy lazy = this.mainConfig.getCheckerInfo();
                if (lazy == null || (lazy = (CheckerInfoGenResult)lazy.getValue()) == null) {
                    SqliteDiagnostics $this$createRuleAndRuleMapping_u24lambda_u241 = this;
                    boolean bl = false;
                    logger.warn(SqliteDiagnostics::createRuleAndRuleMapping$lambda$1$lambda$0);
                    lazy = null;
                }
                checkerInfo = lazy;
                if (ruleSortYaml != null && checkerInfo != null) break block1;
                logger.warn(SqliteDiagnostics::createRuleAndRuleMapping$lambda$2);
                break block2;
            }
            RuleAndRuleMapping ruleAndRuleMapping = this.ruleAndRuleMapping = new RuleAndRuleMapping((CheckerInfoGenResult)checkerInfo, ruleSortYaml.getPath());
            if (ruleAndRuleMapping == null) break block2;
            ruleAndRuleMapping.insert(this.getDatabase());
        }
    }

    private final void verify(ExecutableQuery<?> $this$verify, String name) {
        List it = $this$verify.executeAsList();
        boolean bl = false;
        if (!((Collection)it).isEmpty()) {
            logger.error(() -> SqliteDiagnostics.verify$lambda$4$lambda$3(name, it));
        }
    }

    public final void verify() {
        this.verify(this.getDatabase().getRuleMappingQueries().verify_rule_name(), "RuleMapping.rule_name");
        this.verify(this.getDatabase().getDiagnosticQueries().verify_rule_name(), "diagnostic.rule_name");
        this.verify(this.getDatabase().getDiagnosticQueries().verify_file(), "diagnostic.__file_id");
        this.verify(this.getDatabase().getDiagnosticQueries().verify_note_path(), "diagnostic.__note_array_hash_id");
        this.verify(this.getDatabase().getDiagnosticQueries().verify_control_flow_path(), "diagnostic.__control_flow_array_hash_id");
        this.verify(this.getDatabase().getDiagnosticQueries().verify_macro(), "diagnostic.__macro_note_set_hash_id");
        this.verify(this.getDatabase().getNotePathQueries().verify_note(), "NotePath.__note_id");
        this.verify(this.getDatabase().getControlFlowPathQueries().verify_control_flow(), "ControlFlowPath.__control_flow_id");
        this.verify(this.getDatabase().getMacroExpansionQueries().verify_note(), "MacroExpansion.__macro_note_id");
        this.verify(this.getDatabase().getControlFlowQueries().verify_file(), "ControlFlow.__file_id");
        this.verify(this.getDatabase().getNoteQueries().verify_file(), "Note.__file_id");
        this.verify(this.getDatabase().getAnalyzeResultFileQueries().verify_file(), "AnalyzeResultFile.__file_id");
        this.verify(this.getDatabase().getAbsoluteFilePathQueries().verify_absolute_file_path(), "AbsoluteFilePath.__file_id");
    }

    public void close() {
        this.verify();
        this.getSqLiteDB().close();
        this._sdb.uninitialized();
        this.noteHashIdAutoIncrement.clear();
        this.ctrlFlowHashIdAutoIncrement.clear();
        this.fileCache.cleanUp();
        this.fileIdMap.clear();
    }

    @Nullable
    public Object flush(@NotNull List<Report> reports, @NotNull String filename, @NotNull IProjectFileLocator locator2, @NotNull Continuation<? super Unit> $completion) {
        return SqliteDiagnostics.flush$suspendImpl((SqliteDiagnostics)this, reports, (String)filename, (IProjectFileLocator)locator2, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ Object flush$suspendImpl(SqliteDiagnostics var0, List<Report> var1_1, String var2_2, IProjectFileLocator var3_3, Continuation<? super Unit> $completion) {
        if (!($completion instanceof flush.1)) ** GOTO lbl-1000
        var7_5 = $completion;
        if ((var7_5.label & -2147483648) != 0) {
            var7_5.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var8_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.label = 1;
                v0 = $this.serializeReportsToDb((List)reports, (IProjectFileLocator)locator, (String)filename, (Continuation)$continuation);
                ** if (v0 != var8_7) goto lbl18
lbl17:
                // 1 sources

                return var8_7;
lbl18:
                // 1 sources

                ** GOTO lbl28
            }
            case 1: {
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
                }
                catch (Exception e) {
                    SqliteDiagnostics.logger.debug((Throwable)e, (Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, flush$lambda$5(java.lang.Exception ), ()Ljava/lang/Object;)((Exception)e));
                    SqliteDiagnostics.logger.error((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, flush$lambda$6(java.lang.Exception ), ()Ljava/lang/Object;)((Exception)e));
                }
lbl28:
                // 3 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public void visit(@NotNull AnalysisMetadata analysisMetadata2) {
        Intrinsics.checkNotNullParameter((Object)analysisMetadata2, (String)"analysisMetadata");
        if (this.monitor != null) {
            Transacter.DefaultImpls.transaction$default((Transacter)((Transacter)this.getDatabase()), (boolean)false, arg_0 -> SqliteDiagnostics.visit$lambda$7(this, analysisMetadata2, arg_0), (int)1, null);
        }
    }

    private final Object serializeReportsToDb(List<Report> reports, IProjectFileLocator locator2, String filename, Continuation<? super Unit> $completion) {
        Object object = BuildersKt.withContext((CoroutineContext)((CoroutineContext)this.writeDispatcher), (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final FileID createFileCached(IProjectFileLocator locator2, IBugResInfo file) {
        Object object;
        IResFile iResFile = locator2.get(file, (IWrapperFileGenerator)EmptyWrapperFileGenerator.INSTANCE);
        if (iResFile == null || (iResFile = iResFile.getAbsolute()) == null || (iResFile = iResFile.getNormalize()) == null) {
            return null;
        }
        IResFile location = iResFile;
        Map $this$getOrPut$iv = this.fileIdMap;
        boolean $i$f$getOrPut = false;
        Object value$iv = $this$getOrPut$iv.get(location);
        if (value$iv == null) {
            boolean bl = false;
            Object object2 = this.fileCache.get((Object)location);
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"get(...)");
            FileX fileX = (FileX)OptionalsKt.getOrNull((Optional)((Optional)object2));
            if (fileX == null) {
                return null;
            }
            FileX f = fileX;
            FileID answer$iv = new FileID(f.insert(this.getDatabase()).getId(), f.getAssociateAbsFile());
            $this$getOrPut$iv.put(location, answer$iv);
            object = answer$iv;
        } else {
            object = value$iv;
        }
        return (FileID)object;
    }

    private final FileX.ID createFileXCached(IProjectFileLocator locator2, IBugResInfo file) {
        IResFile iResFile = locator2.get(file, (IWrapperFileGenerator)EmptyWrapperFileGenerator.INSTANCE);
        if (iResFile == null || (iResFile = iResFile.getAbsolute()) == null || (iResFile = iResFile.getNormalize()) == null) {
            return null;
        }
        IResFile location = iResFile;
        return this.createFileXCachedFromAbsFile(location);
    }

    private final FileX.ID createFileXCachedFromAbsFile(IResFile absFile) {
        Object object;
        Object object2 = this.fileCache.get((Object)absFile);
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"get(...)");
        FileX fileX = (FileX)OptionalsKt.getOrNull((Optional)((Optional)object2));
        if (fileX == null) {
            return null;
        }
        FileX f = fileX;
        Map $this$getOrPut$iv = this.fileIdMap;
        boolean $i$f$getOrPut = false;
        Object value$iv = $this$getOrPut$iv.get(absFile);
        if (value$iv == null) {
            boolean bl = false;
            FileID answer$iv = new FileID(f.insert(this.getDatabase()).getId(), f.getAssociateAbsFile());
            $this$getOrPut$iv.put(absFile, answer$iv);
            object = answer$iv;
        } else {
            object = value$iv;
        }
        FileID id = (FileID)object;
        return f.withId(id.getId());
    }

    @Nullable
    public final FileX.ID createFileXCachedFromFile(@NotNull IResFile file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        return this.createFileXCachedFromAbsFile(file.getAbsolute().getNormalize());
    }

    private final FileX createFile(IResFile absFile) {
        byte[] bytesContent = ResourceKt.readAllBytes((IResFile)absFile);
        String hash = ResourceImplKt.calculate((byte[])bytesContent, (String)"sha256");
        Charset encoding = this.getSourceEncoding(absFile);
        List lines2 = StringsKt.lines((CharSequence)new String(bytesContent, encoding));
        IResource original = Resource.INSTANCE.getOriginFileFromExpandAbsPath((IResource)absFile);
        MainConfig.RelativePath relativePath = this.mainConfig.tryGetRelativePathFromAbsolutePath(original);
        String string = StringsKt.removePrefix((String)relativePath.getRelativePath(), (CharSequence)"/");
        long l = lines2.size();
        String string2 = encoding.name();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"name(...)");
        String string3 = string2;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"getDefault(...)");
        String string4 = string3.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"toLowerCase(...)");
        File it = new File(-1L, hash, string, l, string4, (long)bytesContent.length, bytesContent);
        boolean bl = false;
        return new FileX(it, relativePath, absFile, lines2);
    }

    private final Rule getAssociateChecker(Report $this$associateChecker) {
        Object object = this.ruleAndRuleMapping;
        return object != null && (object = object.getId2checkerMap()) != null ? (Rule)object.get($this$associateChecker.getCheck_name()) : null;
    }

    /*
     * WARNING - void declaration
     */
    private final String lineContent(FileX $this$lineContent, int line) {
        String string;
        String string2 = (String)CollectionsKt.getOrNull((List)$this$lineContent.getLines(), (int)(line - 1));
        if (string2 != null) {
            void var3_3;
            String it = string2;
            boolean bl = false;
            if (it.length() > 384) {
                String string3 = it.substring(0, 384);
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"substring(...)");
                return string3;
            }
            string = var3_3;
        } else {
            string = null;
        }
        return string;
    }

    private final ValueWithId<Region> createRegion(IProjectFileLocator locator2, IBugResInfo res, com.feysh.corax.config.api.report.Region region) {
        FileID fileID = this.createFileCached(locator2, res);
        if (fileID == null) {
            return null;
        }
        FileID file = fileID;
        Region it = new Region(0L, file.getId(), (long)region.startLine, Long.valueOf(region.startColumn), Long.valueOf(region.getEndLine()), Long.valueOf(region.getEndColumn()));
        boolean bl = false;
        this.getDatabase().getRegionQueries().insert(it.get__file_id(), it.getStart_line(), it.getStart_column(), it.getEnd_line(), it.getEnd_column());
        long id = ((Number)CollectionsKt.first((List)this.getDatabase().getRegionQueries().id(it.get__file_id(), it.getStart_line(), it.getStart_column(), it.getEnd_line(), it.getEnd_column()).executeAsList())).longValue();
        return new ValueWithId(id, (Object)it);
    }

    /*
     * WARNING - void declaration
     */
    private final com.feysh.corax.config.api.report.Region getFuncRange(IBugResInfo classInfo, int line) {
        if (classInfo instanceof ClassResInfo) {
            com.feysh.corax.config.api.report.Region range;
            BodyDeclaration member;
            if (this.info != null) {
                SootInfoCache $this$getFuncRange_u24lambda_u2413 = this.info;
                boolean bl = false;
                v0 = $this$getFuncRange_u24lambda_u2413.getMemberAtLine(((ClassResInfo)classInfo).getSc(), line);
            } else {
                v0 = member = null;
            }
            if (member != null) {
                Optional optional = member.getRange();
                Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getRange(...)");
                range = com.feysh.corax.config.api.report.Region.Companion.invoke_Optional_Range(optional);
                if (range != null) {
                    return range;
                }
            }
            if ((range = SootLineToMethodMapFactory.getSootMethodAtLine$default((SootLineToMethodMapFactory)SootLineToMethodMapFactory.INSTANCE, (SootClass)((ClassResInfo)classInfo).getSc(), (int)line, (boolean)false, (int)4, null)) != null) {
                void this_$iv;
                void var10_11;
                Pair it = range.getRange();
                boolean bl = false;
                com.feysh.corax.config.api.report.Region region = new com.feysh.corax.config.api.report.Region(((Number)it.getFirst()).intValue() - 1, 0, ((Number)it.getSecond()).intValue() + 1, 0);
                boolean $i$f$getTakeIfValid = false;
                void it$iv = var10_11 = this_$iv;
                boolean bl2 = false;
                void this_$iv$iv = this_$iv;
                boolean $i$f$getValid = false;
                return this_$iv$iv.startLine >= 0 ? var10_11 : null;
            }
        }
        return null;
    }

    private final ValueWithId<Note> createNote(IProjectFileLocator locator2, BugPathEvent event) {
        String string;
        ValueWithId valueWithId;
        ValueWithId valueWithId2;
        com.feysh.corax.config.api.report.Region region;
        FileID fileID = this.createFileCached(locator2, event.getClassname());
        if (fileID == null) {
            return null;
        }
        FileID file = fileID;
        com.feysh.corax.config.api.report.Region this_$iv = event.getRegion();
        boolean $i$f$getTakeIfColumnValid = false;
        com.feysh.corax.config.api.report.Region this_$iv$iv = this_$iv;
        boolean $i$f$getTakeIfValid = false;
        com.feysh.corax.config.api.report.Region it$iv$iv = region = this_$iv$iv;
        boolean bl = false;
        com.feysh.corax.config.api.report.Region this_$iv$iv$iv = this_$iv$iv;
        boolean $i$f$getValid = false;
        com.feysh.corax.config.api.report.Region it$iv = this_$iv$iv = this_$iv$iv$iv.startLine >= 0 ? region : null;
        boolean bl2 = false;
        com.feysh.corax.config.api.report.Region this_$iv$iv2 = this_$iv;
        boolean $i$f$getColumnValid = false;
        Object object = this_$iv$iv2.startColumn >= 0 && this_$iv$iv2.getEndColumn() >= 0 ? this_$iv$iv : null;
        if (object != null) {
            com.feysh.corax.config.api.report.Region it = object;
            boolean bl3 = false;
            valueWithId2 = this.createRegion(locator2, event.getClassname(), it);
        } else {
            valueWithId2 = null;
        }
        ValueWithId noticesRegion = valueWithId2;
        com.feysh.corax.config.api.report.Region region2 = this.getFuncRange(event.getClassname(), event.getRegion().startLine);
        if (region2 != null) {
            com.feysh.corax.config.api.report.Region it = region2;
            boolean bl4 = false;
            valueWithId = this.createRegion(locator2, event.getClassname(), it);
        } else {
            valueWithId = null;
        }
        ValueWithId funcRange = valueWithId;
        long l = file.getId();
        String string2 = file.getFileAbsPath();
        long l2 = event.getRegion().startLine;
        Long l3 = event.getRegion().startColumn;
        String string3 = (String)event.getMessage().get(Language.EN);
        if (string3 == null) {
            string3 = "";
        }
        if ((string = (String)event.getMessage().get(Language.ZH)) == null) {
            string = "";
        }
        ValueWithId valueWithId3 = noticesRegion;
        ValueWithId valueWithId4 = funcRange;
        Note it = new Note(0L, "event", "Below", l, string2, l2, l3, string3, string, valueWithId3 != null ? Long.valueOf(valueWithId3.getId()) : null, valueWithId4 != null ? Long.valueOf(valueWithId4.getId()) : null);
        boolean bl5 = false;
        this.getDatabase().getNoteQueries().insert(it.getKind(), it.getDisplay_hint(), it.get__file_id(), it.get_file_abs_path(), it.getLine(), it.getColumn(), it.getMessage_en(), it.getMessage_zh(), it.get__notices_region_id(), it.get__func_region_id());
        long id = ((Number)CollectionsKt.first((List)this.getDatabase().getNoteQueries().id(it.getKind(), it.getDisplay_hint(), it.get__file_id(), it.get_file_abs_path(), it.getLine(), it.getColumn(), it.getMessage_en(), it.getMessage_zh(), it.get__notices_region_id(), it.get__func_region_id()).executeAsList())).longValue();
        return new ValueWithId(id, (Object)it);
    }

    private final ValueWithId<ControlFlow> createControlFlow(IProjectFileLocator locator2, BugPathEvent event) {
        return null;
    }

    /*
     * WARNING - void declaration
     */
    private final Long createControlFlowPath(IProjectFileLocator locator2, List<BugPathEvent> path) {
        Iterable $this$associateWith$iv = path;
        boolean $i$f$associateWith = false;
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv, (int)10)), (int)16));
        Iterable $this$associateWithTo$iv$iv = $this$associateWith$iv;
        boolean $i$f$associateWithTo22 = false;
        for (Object element$iv$iv : $this$associateWithTo$iv$iv) {
            void it;
            BugPathEvent bugPathEvent = (BugPathEvent)element$iv$iv;
            Object t = element$iv$iv;
            Map map = result$iv;
            boolean bl = false;
            ValueWithId valueWithId = this.createControlFlow(locator2, (BugPathEvent)it);
            map.put(t, valueWithId);
        }
        Map path2controlFlow = result$iv;
        ArrayHashIdGenerator arrayHashIdG = new ArrayHashIdGenerator(this.ctrlFlowHashIdAutoIncrement);
        long i = 0L;
        List array = new ArrayList();
        Iterator $i$f$associateWithTo22 = path2controlFlow.entrySet().iterator();
        while ($i$f$associateWithTo22.hasNext()) {
            List list;
            ValueWithId controlFlow = (ValueWithId)$i$f$associateWithTo22.next().getValue();
            if (controlFlow == null) continue;
            long l = i;
            i = l + 1L;
            ControlFlowPath control = new ControlFlowPath(-1L, l, controlFlow.getId());
            ((Collection)array).add(control);
            List $this$createControlFlowPath_u24lambda_u2419 = list = arrayHashIdG.getArray();
            boolean bl = false;
            $this$createControlFlowPath_u24lambda_u2419.add(String.valueOf(control.get__control_flow_id()));
            $this$createControlFlowPath_u24lambda_u2419.add(String.valueOf(control.getControl_flow_sequence()));
        }
        Long l = arrayHashIdG.getArrayId();
        if (l == null) {
            return null;
        }
        long arrayId = l;
        Iterable $this$forEach$iv = array;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ControlFlowPath it = (ControlFlowPath)element$iv;
            boolean bl = false;
            this.getDatabase().getControlFlowPathQueries().insert(ControlFlowPath.copy$default((ControlFlowPath)it, (long)arrayId, (long)0L, (long)0L, (int)6, null));
        }
        return arrayId;
    }

    /*
     * WARNING - void declaration
     */
    private final Long createNotePath(IProjectFileLocator locator2, List<BugPathEvent> pathEvents) {
        boolean bl;
        Iterable $this$associateWith$iv = pathEvents;
        boolean $i$f$associateWith = false;
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv, (int)10)), (int)16));
        Iterable $this$associateWithTo$iv$iv = $this$associateWith$iv;
        boolean $i$f$associateWithTo = false;
        for (Object element$iv$iv : $this$associateWithTo$iv$iv) {
            void it;
            BugPathEvent bugPathEvent = (BugPathEvent)element$iv$iv;
            Object t = element$iv$iv;
            Map map = result$iv;
            boolean bl2 = false;
            ValueWithId valueWithId = this.createNote(locator2, (BugPathEvent)it);
            map.put(t, valueWithId);
        }
        Map event2note = result$iv;
        ArrayHashIdGenerator arrayHashIdG = new ArrayHashIdGenerator(this.noteHashIdAutoIncrement);
        long i = 0L;
        List array = new ArrayList();
        for (Map.Entry entry : event2note.entrySet()) {
            List list;
            BugPathEvent event = (BugPathEvent)entry.getKey();
            ValueWithId note = (ValueWithId)entry.getValue();
            if (note == null) continue;
            long l = i;
            i = l + 1L;
            Integer n = event.getStackDepth();
            NotePath notePath = new NotePath(-1L, l, n != null ? Long.valueOf(n.intValue()) : null, Long.valueOf(0L), note.getId());
            ((Collection)array).add(notePath);
            List $this$createNotePath_u24lambda_u2422 = list = arrayHashIdG.getArray();
            bl = false;
            $this$createNotePath_u24lambda_u2422.add(String.valueOf(notePath.getNote_sequence()));
            $this$createNotePath_u24lambda_u2422.add(String.valueOf(notePath.getNote_stack_depth()));
            $this$createNotePath_u24lambda_u2422.add(String.valueOf(notePath.getNote_is_key_event()));
            $this$createNotePath_u24lambda_u2422.add(String.valueOf(notePath.get__note_id()));
        }
        Long l = arrayHashIdG.getArrayId();
        if (l == null) {
            return null;
        }
        long arrayId = l;
        Iterable $this$forEach$iv = array;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            NotePath it = (NotePath)element$iv;
            bl = false;
            this.getDatabase().getNotePathQueries().insert(NotePath.copy$default((NotePath)it, (long)arrayId, (long)0L, null, null, (long)0L, (int)30, null));
        }
        return arrayId;
    }

    private final ValueWithId<Diagnostic> createDiagnostic(IProjectFileLocator locator2, Report report) {
        String string;
        String string2;
        FileX.ID iD = this.createFileXCached(locator2, report.getBugResFile());
        if (iD == null) {
            return null;
        }
        FileX.ID file = iD;
        if (report.getPathEvents().isEmpty()) {
            logger.error(() -> SqliteDiagnostics.createDiagnostic$lambda$24(report));
            return null;
        }
        BugPathEvent lastPathEvents = (BugPathEvent)CollectionsKt.last((List)report.getPathEvents());
        Long l = this.createNotePath(locator2, report.getPathEvents());
        if (l == null) {
            SqliteDiagnostics $this$createDiagnostic_u24lambda_u2426 = this;
            boolean bl = false;
            logger.error(() -> SqliteDiagnostics.createDiagnostic$lambda$26$lambda$25(report));
            return null;
        }
        long noteArrayHashId = l;
        Long controlFlowArrayHashId = this.createControlFlowPath(locator2, report.getNotes());
        int line = lastPathEvents.getRegion().startLine;
        String string3 = report.getCheck_name();
        Rule rule = this.getAssociateChecker(report);
        String string4 = rule != null ? rule.getShort_description_zh() : null;
        Long l2 = file.getId();
        String string5 = file.getFile().getFileAbsPath();
        long l3 = line;
        long l4 = lastPathEvents.getRegion().startColumn;
        String string6 = (String)report.getMessage().get(Language.EN);
        if (string6 == null) {
            string6 = "";
        }
        if ((string2 = (String)report.getMessage().get(Language.ZH)) == null) {
            string2 = "";
        }
        if ((string = report.getSeverity()) == null) {
            Rule rule2 = this.getAssociateChecker(report);
            string = rule2 != null ? rule2.getSeverity() : null;
            if (string == null) {
                string = "None";
            }
        }
        Diagnostic it = new Diagnostic(0L, string3, string4, l2, string5, l3, l4, string6, string2, string, null, null, null, null, null, this.lineContent(file.getFile(), line), noteArrayHashId, controlFlowArrayHashId, null);
        boolean bl = false;
        this.getDatabase().getDiagnosticQueries().insert(it.getRule_name(), it.get_rule_short_description_zh(), it.get__file_id(), it.get_file_abs_path(), it.get_line(), it.get_column(), it.get_message_en(), it.get_message_zh(), it.getSeverity(), it.getPrecision(), it.getLikelihood(), it.getImpact(), it.getTechnique(), it.getAnalysis_scope(), it.getLine_content(), it.get__note_array_hash_id(), it.get__control_flow_array_hash_id(), it.get__macro_note_set_hash_id());
        long id = ((Number)CollectionsKt.first((List)this.getDatabase().getDiagnosticQueries().id(it.getRule_name(), it.get_rule_short_description_zh(), it.get__file_id(), it.get_file_abs_path(), it.getSeverity(), it.getPrecision(), it.getLikelihood(), it.getImpact(), it.getTechnique(), it.getAnalysis_scope(), it.getLine_content(), it.get__note_array_hash_id(), it.get__control_flow_array_hash_id(), it.get__macro_note_set_hash_id()).executeAsList())).longValue();
        return new ValueWithId(id, (Object)it);
    }

    private final Set<AnalyzerStatistics> getAnalyzerStatisticsSet(List<Tool> tools) {
        Set analyzerStatisticsSet = new LinkedHashSet();
        Iterable $this$forEach$iv = tools;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Tool it = (Tool)element$iv;
            boolean bl = false;
            Iterable $this$forEach$iv2 = it.getAnalyzers().values();
            boolean $i$f$forEach2 = false;
            for (Object element$iv2 : $this$forEach$iv2) {
                Analyzer analyzer2 = (Analyzer)element$iv2;
                boolean bl2 = false;
                analyzerStatisticsSet.add(analyzer2.getAnalyzerStatistics());
            }
        }
        return analyzerStatisticsSet;
    }

    private final AnalyzerResultFile createAnalyzerResultFile(IResFile file, String fileName) {
        AnalyzerResultFile analyzerResultFile;
        IResFile absFile = file.getAbsolute().getNormalize();
        FileX.ID iD = this.createFileXCachedFromAbsFile(absFile);
        if (iD == null) {
            return null;
        }
        FileX.ID fileX = iD;
        String string = fileName;
        if (string == null) {
            string = StringsKt.removePrefix((String)this.mainConfig.tryGetRelativePathFromAbsolutePath((IResource)absFile).getRelativePath(), (CharSequence)"/");
        }
        AnalyzerResultFile it = analyzerResultFile = new AnalyzerResultFile(string, absFile.getPathString(), fileX.getId());
        boolean bl = false;
        this.getDatabase().getAnalyzeResultFileQueries().insert(it);
        return analyzerResultFile;
    }

    static /* synthetic */ AnalyzerResultFile createAnalyzerResultFile$default(SqliteDiagnostics sqliteDiagnostics, IResFile iResFile, String string, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createAnalyzerResultFile");
        }
        if ((n & 2) != 0) {
            string = null;
        }
        return sqliteDiagnostics.createAnalyzerResultFile(iResFile, string);
    }

    public final void writeAnalyzerResultFiles() {
        Transacter.DefaultImpls.transaction$default((Transacter)((Transacter)this.getDatabase()), (boolean)false, arg_0 -> SqliteDiagnostics.writeAnalyzerResultFiles$lambda$32(this, arg_0), (int)1, null);
    }

    /*
     * WARNING - void declaration
     */
    private final cn.sast.framework.report.sqldelight.AnalyzerStatistics createAnalyzerStatistics(AnalysisMetadata data, MetricsMonitor monitor) {
        Object object;
        cn.sast.framework.report.sqldelight.AnalyzerStatistics analyzerStatistics;
        String string;
        Set enableCheckers;
        List tools = data.getTools();
        Set analyzerStatisticsSet = this.getAnalyzerStatisticsSet(tools);
        int failed = 0;
        int successful = 0;
        LinkedHashSet failedSources = new LinkedHashSet();
        LinkedHashSet successfulSources = new LinkedHashSet();
        Iterable $this$forEach$iv = analyzerStatisticsSet;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            AnalyzerStatistics it = (AnalyzerStatistics)element$iv;
            boolean bl = false;
            failed += it.getFailed();
            failedSources.addAll(it.getFailedSources());
            successful += it.getSuccessful();
            successfulSources.addAll(it.getSuccessfulSources());
        }
        List command = new ArrayList();
        Iterable $this$forEach$iv2 = tools;
        boolean $i$f$forEach2 = false;
        for (Object element$iv : $this$forEach$iv2) {
            Tool it = (Tool)element$iv;
            boolean bl = false;
            command.addAll(it.getCommand());
        }
        String workingDirectory = CollectionsKt.joinToString$default((Iterable)tools, (CharSequence)",", null, null, (int)0, null, SqliteDiagnostics::createAnalyzerStatistics$lambda$35, (int)30, null);
        String commandJson = jsonFormat.encodeToString((SerializationStrategy)new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), (Object)command);
        String outputPath = CollectionsKt.joinToString$default((Iterable)tools, (CharSequence)",", null, null, (int)0, null, SqliteDiagnostics::createAnalyzerStatistics$lambda$36, (int)30, null);
        String projectRoot = CollectionsKt.joinToString$default((Iterable)tools, (CharSequence)",", null, null, (int)0, null, SqliteDiagnostics::createAnalyzerStatistics$lambda$37, (int)30, null);
        long beginMillis = monitor.getBeginMillis();
        long endTimestamp = System.currentTimeMillis();
        Long elapsed = MetricsMonitorKt.timeSub((Long)PhaseIntervalTimerKt.currentNanoTime(), (long)monitor.getBeginNanoTime());
        Object object2 = this.mainConfig.getSaConfig();
        if (object2 != null && (object2 = object2.getEnableCheckTypes()) != null) {
            void $this$mapTo$iv;
            Iterable iterable = (Iterable)object2;
            Collection destination$iv = new LinkedHashSet();
            boolean $i$f$mapTo = false;
            for (Object item$iv : $this$mapTo$iv) {
                void it;
                CheckType checkType = (CheckType)item$iv;
                Collection collection = destination$iv;
                boolean bl = false;
                collection.add(this.getId((CheckType)it));
            }
            v1 = (Set)destination$iv;
        } else {
            v1 = enableCheckers = SetsKt.emptySet();
        }
        if ((string = this.mainConfig.getVersion()) == null) {
            string = "None";
        }
        String string2 = MetricsMonitorKt.getDateStringFromMillis((long)beginMillis);
        long l = (long)PhaseIntervalTimerKt.nanoTimeInSeconds$default((Number)elapsed, (int)0, (int)1, null);
        Object object3 = elapsed;
        if (object3 == null || (object3 = Duration.toString-impl((long)DurationKt.toDuration((long)((Long)object3), (DurationUnit)DurationUnit.NANOSECONDS))) == null) {
            object3 = "";
        }
        cn.sast.framework.report.sqldelight.AnalyzerStatistics it = analyzerStatistics = new cn.sast.framework.report.sqldelight.AnalyzerStatistics("Corax", "", string, string2, beginMillis, l, (String)object3, MetricsMonitorKt.getDateStringFromMillis((long)endTimestamp), endTimestamp, (long)data.getFileCount(), (long)data.getLineCount(), Long.valueOf(data.getCodeCoverage().getCovered()), Long.valueOf(data.getCodeCoverage().getMissed()), Long.valueOf(data.getNumOfReportDir()), CollectionsKt.joinToString$default((Iterable)data.getSourcePaths(), (CharSequence)",", null, null, (int)0, null, null, (int)62, null), data.getOsName(), commandJson, workingDirectory, outputPath, projectRoot, "", CollectionsKt.joinToString$default((Iterable)enableCheckers, (CharSequence)",", null, null, (int)0, null, null, (int)62, null), CollectionsKt.joinToString$default((Iterable)CollectionsKt.minus((Iterable)((object = this.mainConfig.getCheckerInfo()) != null && (object = (CheckerInfoGenResult)object.getValue()) != null && (object = object.getExistsCheckerIds()) != null ? (Collection)object : (Collection)CollectionsKt.emptyList()), (Iterable)enableCheckers), (CharSequence)",", null, null, (int)0, null, null, (int)62, null), CollectionsKt.joinToString$default((Iterable)failedSources, (CharSequence)",", null, null, (int)0, null, null, (int)62, null), (long)failed, CollectionsKt.joinToString$default((Iterable)successfulSources, (CharSequence)",", null, null, (int)0, null, null, (int)62, null), (long)successful, "", 1L);
        boolean bl = false;
        this.getDatabase().getAnalyzerStatisticsQueries().insert(it);
        return analyzerStatistics;
    }

    private static final Object createRuleAndRuleMapping$lambda$1$lambda$0() {
        return "The checkerInfo field of mainConfig is null";
    }

    private static final Object createRuleAndRuleMapping$lambda$2() {
        return "rule_sort.yaml is not exists";
    }

    private static final Object verify$lambda$4$lambda$3(String $name, List $it) {
        return "reference of " + $name + ": " + $it + " is not exists in the parent table";
    }

    private static final Object flush$lambda$5(Exception $e) {
        return "There are some errors when serialize data to sqlite: " + $e.getMessage();
    }

    private static final Object flush$lambda$6(Exception $e) {
        return "There are some errors when serialize data to sqlite: " + $e.getMessage();
    }

    private static final Unit visit$lambda$7(SqliteDiagnostics this$0, AnalysisMetadata $analysisMetadata, TransactionWithoutReturn $this$transaction) {
        Intrinsics.checkNotNullParameter((Object)$this$transaction, (String)"$this$transaction");
        this$0.createAnalyzerStatistics($analysisMetadata, this$0.monitor);
        return Unit.INSTANCE;
    }

    private static final Object createDiagnostic$lambda$24(Report $report) {
        return "Report.pathEvents is empty! report: " + $report;
    }

    private static final Object createDiagnostic$lambda$26$lambda$25(Report $report) {
        return "invalid report: " + $report;
    }

    private static final Unit writeAnalyzerResultFiles$lambda$32(SqliteDiagnostics this$0, TransactionWithoutReturn $this$transaction) {
        Intrinsics.checkNotNullParameter((Object)$this$transaction, (String)"$this$transaction");
        IResDirectory out = this$0.mainConfig.getOutput_dir();
        Object[] objectArray = new Pair[]{TuplesKt.to((Object)AnalyzerEnv.INSTANCE.getLastLogFile(), (Object)"\u8be6\u7ec6\u5f15\u64ce\u65e5\u5fd7"), TuplesKt.to((Object)out.resolve("project-env/versions.txt"), (Object)"\u9879\u76ee\u4f9d\u8d56\u5e93\u7248\u672c\u4fe1\u606f"), TuplesKt.to((Object)out.resolve("metrics.yml"), (Object)"ProfileMetrics"), TuplesKt.to((Object)out.resolve("phantom_dependence_classes.txt"), (Object)"phantom_dependence_classes"), TuplesKt.to((Object)out.resolve("source_files_which_class_not_found.txt"), (Object)"source_files_which_class_not_found"), TuplesKt.to((Object)out.resolve("undefined_summary_methods.txt"), (Object)"\u65e0Taint\u914d\u7f6e\u7684\u65b9\u6cd5"), TuplesKt.to((Object)out.resolve("scan-classifier-info.json"), (Object)"\u9ed1\u767d\u540d\u5355\u5206\u7c7b\u7ed3\u679c"), TuplesKt.to((Object)out.resolve("top.log"), (Object)"\u8fdb\u7a0b\u76d1\u63a7\u65e5\u5fd7")};
        Iterable $this$forEach$iv = CollectionsKt.listOf((Object[])objectArray);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Pair pair = (Pair)element$iv;
            boolean bl = false;
            IResource path = (IResource)pair.component1();
            String name = (String)pair.component2();
            IResFile file = path.toFile();
            if (!file.getExists()) continue;
            this$0.createAnalyzerResultFile(file, name);
        }
        return Unit.INSTANCE;
    }

    private static final CharSequence createAnalyzerStatistics$lambda$35(Tool it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getWorkingDirectory();
    }

    private static final CharSequence createAnalyzerStatistics$lambda$36(Tool it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getOutputPath();
    }

    private static final CharSequence createAnalyzerStatistics$lambda$37(Tool it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getProjectRoot();
    }

    private static final Unit logger$lambda$40() {
        return Unit.INSTANCE;
    }

    private static final Unit jsonFormat$lambda$41(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter((Object)$this$Json, (String)"$this$Json");
        $this$Json.setUseArrayPolymorphism(true);
        $this$Json.setPrettyPrint(true);
        $this$Json.setEncodeDefaults(false);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$serializeReportsToDb(SqliteDiagnostics $this, List reports, IProjectFileLocator locator2, String filename, Continuation $completion) {
        return $this.serializeReportsToDb(reports, locator2, filename, $completion);
    }

    public static final /* synthetic */ Database access$getDatabase(SqliteDiagnostics $this) {
        return $this.getDatabase();
    }

    public static final /* synthetic */ ValueWithId access$createDiagnostic(SqliteDiagnostics $this, IProjectFileLocator locator2, Report report) {
        return $this.createDiagnostic(locator2, report);
    }

    public static final /* synthetic */ FileX access$createFile(SqliteDiagnostics $this, IResFile absFile) {
        return $this.createFile(absFile);
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SqliteDiagnostics.class, "sqLiteDB", "getSqLiteDB()Lcn/sast/framework/report/SQLiteDB;", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        logger = KotlinLogging.INSTANCE.logger(SqliteDiagnostics::logger$lambda$40);
        jsonFormat = JsonKt.Json$default(null, SqliteDiagnostics::jsonFormat$lambda$41, (int)1, null);
    }
}

