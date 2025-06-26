/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.MainConfigKt
 *  cn.sast.api.config.PreAnalysisConfig
 *  cn.sast.api.config.PreAnalysisCoroutineScope
 *  cn.sast.api.config.PreAnalysisCoroutineScope$DefaultImpls
 *  cn.sast.api.config.SaConfig
 *  cn.sast.api.config.ScanFilter
 *  cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles
 *  cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles$SimpleDeclAnalysisDependsGraph
 *  cn.sast.api.report.DefaultEnv
 *  cn.sast.api.report.FileResInfo
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.api.util.IMonitor
 *  cn.sast.api.util.Kotlin_extKt
 *  cn.sast.api.util.OthersKt
 *  cn.sast.api.util.SootUtilsKt
 *  cn.sast.api.util.Timer
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.common.Resource
 *  cn.sast.common.ResourceImplKt
 *  cn.sast.coroutines.caffine.impl.FastCacheImpl
 *  cn.sast.framework.engine.CheckPoint
 *  cn.sast.framework.engine.ClassCheckPoint
 *  cn.sast.framework.engine.FieldCheckPoint
 *  cn.sast.framework.engine.InvokeCheckPoint
 *  cn.sast.framework.engine.MethodCheckPoint
 *  cn.sast.framework.engine.PreAnalysisClassConfig
 *  cn.sast.framework.engine.PreAnalysisFieldConfig
 *  cn.sast.framework.engine.PreAnalysisFileConfig
 *  cn.sast.framework.engine.PreAnalysisImpl
 *  cn.sast.framework.engine.PreAnalysisImpl$Companion
 *  cn.sast.framework.engine.PreAnalysisImpl$InvokePointData
 *  cn.sast.framework.engine.PreAnalysisInvokeConfig
 *  cn.sast.framework.engine.PreAnalysisMethodConfig
 *  cn.sast.framework.engine.PreAnalysisReportEnv
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.result.IPreAnalysisResultCollector
 *  cn.sast.framework.util.SafeAnalyzeUtil
 *  com.feysh.corax.cache.analysis.SootInfoCache
 *  com.feysh.corax.cache.coroutines.FastCache
 *  com.feysh.corax.commons.NullableLateinit
 *  com.feysh.corax.config.api.BugMessage$Env
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.api.CheckerUnit
 *  com.feysh.corax.config.api.IAnalysisDepends
 *  com.feysh.corax.config.api.ICheckPoint
 *  com.feysh.corax.config.api.IClassCheckPoint
 *  com.feysh.corax.config.api.IClassMatch
 *  com.feysh.corax.config.api.IFieldCheckPoint
 *  com.feysh.corax.config.api.IFieldMatch
 *  com.feysh.corax.config.api.IInvokeCheckPoint
 *  com.feysh.corax.config.api.IMethodCheckPoint
 *  com.feysh.corax.config.api.IMethodMatch
 *  com.feysh.corax.config.api.INodeWithRange
 *  com.feysh.corax.config.api.IPreAnalysisClassConfig
 *  com.feysh.corax.config.api.IPreAnalysisConfig
 *  com.feysh.corax.config.api.IPreAnalysisFieldConfig
 *  com.feysh.corax.config.api.IPreAnalysisFileConfig
 *  com.feysh.corax.config.api.IPreAnalysisInvokeConfig
 *  com.feysh.corax.config.api.IPreAnalysisMethodConfig
 *  com.feysh.corax.config.api.ISourceFileCheckPoint
 *  com.feysh.corax.config.api.PreAnalysisApi$Result
 *  com.feysh.corax.config.api.XDecl
 *  com.feysh.corax.config.api.report.Region
 *  com.feysh.corax.config.api.rules.ProcessRule
 *  com.feysh.corax.config.api.rules.ProcessRule$ClassMemberMatch$MatchTarget
 *  com.feysh.corax.config.api.rules.ProcessRule$FileMatch$MatchTarget
 *  com.feysh.corax.config.api.rules.ProcessRule$IMatchItem
 *  com.feysh.corax.config.api.rules.ProcessRule$IMatchTarget
 *  com.feysh.corax.config.api.rules.ProcessRule$ScanAction
 *  com.feysh.corax.config.api.utils.UtilsKt
 *  com.github.javaparser.Position
 *  com.github.javaparser.ast.nodeTypes.NodeWithRange
 *  de.fraunhofer.aisec.cpg.sarif.Region
 *  io.vertx.core.impl.ConcurrentHashSet
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KProperty
 *  kotlin.sequences.Sequence
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.Deferred
 *  kotlinx.coroutines.Job
 *  kotlinx.coroutines.sync.Semaphore
 *  kotlinx.coroutines.sync.SemaphoreKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 *  soot.jimple.InstanceInvokeExpr
 *  soot.jimple.Stmt
 *  soot.jimple.toolkits.callgraph.CallGraph
 *  soot.jimple.toolkits.callgraph.Edge
 *  soot.tagkit.Host
 *  soot.util.HashMultiMap
 *  soot.util.MultiMap
 */
package cn.sast.framework.engine;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.MainConfigKt;
import cn.sast.api.config.PreAnalysisConfig;
import cn.sast.api.config.PreAnalysisCoroutineScope;
import cn.sast.api.config.SaConfig;
import cn.sast.api.config.ScanFilter;
import cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles;
import cn.sast.api.report.DefaultEnv;
import cn.sast.api.report.FileResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.api.util.IMonitor;
import cn.sast.api.util.Kotlin_extKt;
import cn.sast.api.util.OthersKt;
import cn.sast.api.util.SootUtilsKt;
import cn.sast.api.util.Timer;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.Resource;
import cn.sast.common.ResourceImplKt;
import cn.sast.coroutines.caffine.impl.FastCacheImpl;
import cn.sast.framework.engine.CheckPoint;
import cn.sast.framework.engine.ClassCheckPoint;
import cn.sast.framework.engine.FieldCheckPoint;
import cn.sast.framework.engine.InvokeCheckPoint;
import cn.sast.framework.engine.MethodCheckPoint;
import cn.sast.framework.engine.PreAnalysisClassConfig;
import cn.sast.framework.engine.PreAnalysisFieldConfig;
import cn.sast.framework.engine.PreAnalysisFileConfig;
import cn.sast.framework.engine.PreAnalysisImpl;
import cn.sast.framework.engine.PreAnalysisInvokeConfig;
import cn.sast.framework.engine.PreAnalysisMethodConfig;
import cn.sast.framework.engine.PreAnalysisReportEnv;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.result.IPreAnalysisResultCollector;
import cn.sast.framework.util.SafeAnalyzeUtil;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.cache.coroutines.FastCache;
import com.feysh.corax.commons.NullableLateinit;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.CheckerUnit;
import com.feysh.corax.config.api.IAnalysisDepends;
import com.feysh.corax.config.api.ICheckPoint;
import com.feysh.corax.config.api.IClassCheckPoint;
import com.feysh.corax.config.api.IClassMatch;
import com.feysh.corax.config.api.IFieldCheckPoint;
import com.feysh.corax.config.api.IFieldMatch;
import com.feysh.corax.config.api.IInvokeCheckPoint;
import com.feysh.corax.config.api.IMethodCheckPoint;
import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.INodeWithRange;
import com.feysh.corax.config.api.IPreAnalysisClassConfig;
import com.feysh.corax.config.api.IPreAnalysisConfig;
import com.feysh.corax.config.api.IPreAnalysisFieldConfig;
import com.feysh.corax.config.api.IPreAnalysisFileConfig;
import com.feysh.corax.config.api.IPreAnalysisInvokeConfig;
import com.feysh.corax.config.api.IPreAnalysisMethodConfig;
import com.feysh.corax.config.api.ISourceFileCheckPoint;
import com.feysh.corax.config.api.PreAnalysisApi;
import com.feysh.corax.config.api.XDecl;
import com.feysh.corax.config.api.report.Region;
import com.feysh.corax.config.api.rules.ProcessRule;
import com.feysh.corax.config.api.utils.UtilsKt;
import com.github.javaparser.Position;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import io.vertx.core.impl.ConcurrentHashSet;
import java.io.File;
import java.lang.invoke.LambdaMetafactory;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.tagkit.Host;
import soot.util.HashMultiMap;
import soot.util.MultiMap;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00ce\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00dc\u00012\u00020\u00012\u00020\u0002:\u0004\u00dc\u0001\u00dd\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010I\u001a\u00020JH\u0016J\u0012\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020=H\u0002J\u0012\u0010N\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020=H\u0002J \u0010b\u001a\b\u0012\u0004\u0012\u0002Hd0c\"\u0004\b\u0000\u0010d*\n\u0012\u0006\u0012\u0004\u0018\u0001Hd0cH\u0016J\u001a\u0010e\u001a\u0004\u0018\u00010f2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020_H\u0002Jm\u0010j\u001a\b\u0012\u0004\u0012\u0002Hd0c\"\u0004\b\u0000\u0010d2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u001d0l2\u0017\u0010m\u001a\u0013\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bp2'\u0010q\u001a#\b\u0001\u0012\u0004\u0012\u00020s\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hd0t\u0012\u0006\u0012\u0004\u0018\u00010u0r\u00a2\u0006\u0002\bpH\u0016R\u00020h\u00a2\u0006\u0002\u0010vJm\u0010w\u001a\b\u0012\u0004\u0012\u0002Hd0c\"\u0004\b\u0000\u0010d2\f\u0010x\u001a\b\u0012\u0004\u0012\u0002000l2\u0017\u0010m\u001a\u0013\u0012\u0004\u0012\u00020y\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bp2'\u0010q\u001a#\b\u0001\u0012\u0004\u0012\u00020z\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hd0t\u0012\u0006\u0012\u0004\u0018\u00010u0r\u00a2\u0006\u0002\bpH\u0016R\u00020h\u00a2\u0006\u0002\u0010vJm\u0010{\u001a\b\u0012\u0004\u0012\u0002Hd0c\"\u0004\b\u0000\u0010d2\f\u0010|\u001a\b\u0012\u0004\u0012\u0002020l2\u0017\u0010m\u001a\u0013\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bp2'\u0010q\u001a#\b\u0001\u0012\u0004\u0012\u00020~\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hd0t\u0012\u0006\u0012\u0004\u0018\u00010u0r\u00a2\u0006\u0002\bpH\u0016R\u00020h\u00a2\u0006\u0002\u0010vJs\u0010\u007f\u001a\b\u0012\u0004\u0012\u0002Hd0c\"\u0004\b\u0000\u0010d2\u000f\u0010\u0080\u0001\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/2\u0018\u0010m\u001a\u0014\u0012\u0005\u0012\u00030\u0081\u0001\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bp2(\u0010q\u001a$\b\u0001\u0012\u0005\u0012\u00030\u0082\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hd0t\u0012\u0006\u0012\u0004\u0018\u00010u0r\u00a2\u0006\u0002\bpH\u0016R\u00020h\u00a2\u0006\u0003\u0010\u0083\u0001J\u0011\u0010\u0084\u0001\u001a\u00020L2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001J\u0089\u0001\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u0002Hd0c\"\u0004\b\u0000\u0010d2$\u0010\u0088\u0001\u001a\u001f\b\u0001\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020!0\u0089\u00010t\u0012\u0006\u0012\u0004\u0018\u00010u0n2\u0018\u0010m\u001a\u0014\u0012\u0005\u0012\u00030\u008a\u0001\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bp2(\u0010q\u001a$\b\u0001\u0012\u0005\u0012\u00030\u008b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hd0t\u0012\u0006\u0012\u0004\u0018\u00010u0r\u00a2\u0006\u0002\bpH\u0016R\u00020h\u00a2\u0006\u0003\u0010\u008c\u0001Jj\u0010j\u001a\b\u0012\u0004\u0012\u0002Hd0c\"\u0004\b\u0000\u0010d2\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u0017\u0010m\u001a\u0013\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bp2'\u0010q\u001a#\b\u0001\u0012\u0004\u0012\u00020s\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hd0t\u0012\u0006\u0012\u0004\u0018\u00010u0r\u00a2\u0006\u0002\bpH\u0016R\u00020h\u00a2\u0006\u0003\u0010\u008f\u0001Ja\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u0002Hd0c\"\u0004\b\u0000\u0010d2\u0017\u0010m\u001a\u0013\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bp2'\u0010q\u001a#\b\u0001\u0012\u0004\u0012\u00020s\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hd0t\u0012\u0006\u0012\u0004\u0018\u00010u0r\u00a2\u0006\u0002\bpH\u0016R\u00020h\u00a2\u0006\u0003\u0010\u0091\u0001Jj\u0010w\u001a\b\u0012\u0004\u0012\u0002Hd0c\"\u0004\b\u0000\u0010d2\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0017\u0010m\u001a\u0013\u0012\u0004\u0012\u00020y\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bp2'\u0010q\u001a#\b\u0001\u0012\u0004\u0012\u00020z\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hd0t\u0012\u0006\u0012\u0004\u0018\u00010u0r\u00a2\u0006\u0002\bpH\u0016R\u00020h\u00a2\u0006\u0003\u0010\u0094\u0001Ja\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u0002Hd0c\"\u0004\b\u0000\u0010d2\u0017\u0010m\u001a\u0013\u0012\u0004\u0012\u00020y\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bp2'\u0010q\u001a#\b\u0001\u0012\u0004\u0012\u00020z\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hd0t\u0012\u0006\u0012\u0004\u0018\u00010u0r\u00a2\u0006\u0002\bpH\u0016R\u00020h\u00a2\u0006\u0003\u0010\u0091\u0001Jj\u0010{\u001a\b\u0012\u0004\u0012\u0002Hd0c\"\u0004\b\u0000\u0010d2\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0017\u0010m\u001a\u0013\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bp2'\u0010q\u001a#\b\u0001\u0012\u0004\u0012\u00020~\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hd0t\u0012\u0006\u0012\u0004\u0018\u00010u0r\u00a2\u0006\u0002\bpH\u0016R\u00020h\u00a2\u0006\u0003\u0010\u0098\u0001JQ\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u0002Hd0c\"\u0004\b\u0000\u0010d2\u0017\u0010m\u001a\u0013\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bp2\u0017\u0010q\u001a\u0013\u0012\u0004\u0012\u00020~\u0012\u0004\u0012\u0002Hd0n\u00a2\u0006\u0002\bpH\u0016R\u00020h\u00a2\u0006\u0003\u0010\u009a\u0001Jl\u0010\u007f\u001a\b\u0012\u0004\u0012\u0002Hd0c\"\u0004\b\u0000\u0010d2\b\u0010\u009b\u0001\u001a\u00030\u0093\u00012\u0018\u0010m\u001a\u0014\u0012\u0005\u0012\u00030\u0081\u0001\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bp2(\u0010q\u001a$\b\u0001\u0012\u0005\u0012\u00030\u0082\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hd0t\u0012\u0006\u0012\u0004\u0018\u00010u0r\u00a2\u0006\u0002\bpH\u0016R\u00020h\u00a2\u0006\u0003\u0010\u0094\u0001Jc\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u0002Hd0c\"\u0004\b\u0000\u0010d2\u0018\u0010m\u001a\u0014\u0012\u0005\u0012\u00030\u0081\u0001\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bp2(\u0010q\u001a$\b\u0001\u0012\u0005\u0012\u00030\u0082\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hd0t\u0012\u0006\u0012\u0004\u0018\u00010u0r\u00a2\u0006\u0002\bpH\u0016R\u00020h\u00a2\u0006\u0003\u0010\u0091\u0001Jl\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u0002Hd0c\"\u0004\b\u0000\u0010d2\u0007\u0010\u009d\u0001\u001a\u00020[2\u0018\u0010m\u001a\u0014\u0012\u0005\u0012\u00030\u008a\u0001\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bp2(\u0010q\u001a$\b\u0001\u0012\u0005\u0012\u00030\u008b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hd0t\u0012\u0006\u0012\u0004\u0018\u00010u0r\u00a2\u0006\u0002\bpH\u0016R\u00020h\u00a2\u0006\u0003\u0010\u009e\u0001Jy\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u0002Hd0c\"\u0004\b\u0000\u0010d2\t\u0010\u00a0\u0001\u001a\u0004\u0018\u00010_2\t\u0010\u00a1\u0001\u001a\u0004\u0018\u00010_2\u0018\u0010m\u001a\u0014\u0012\u0005\u0012\u00030\u008a\u0001\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bp2(\u0010q\u001a$\b\u0001\u0012\u0005\u0012\u00030\u008b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hd0t\u0012\u0006\u0012\u0004\u0018\u00010u0r\u00a2\u0006\u0002\bpH\u0016R\u00020h\u00a2\u0006\u0003\u0010\u00a2\u0001JA\u0010\u00a3\u0001\u001a\u00020J2\b\u0010\u00a4\u0001\u001a\u00030\u00a5\u00012\u0007\u0010\u00a6\u0001\u001a\u00020[2\b\u0010\u00a7\u0001\u001a\u00030\u00a8\u00012\u0019\u0010\u00a9\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u00aa\u0001\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bpH\u0016J8\u0010\u00a3\u0001\u001a\u00020J2\b\u0010\u00a4\u0001\u001a\u00030\u00a5\u00012\b\u0010\u00ab\u0001\u001a\u00030\u00ac\u00012\u0019\u0010\u00a9\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u00aa\u0001\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bpH\u0016J@\u0010\u00ad\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u0001Hd0\u00ae\u0001\"\u0004\b\u0000\u0010d2\u001c\u0010q\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hd0t\u0012\u0006\u0012\u0004\u0018\u00010u0nH\u0016R\u00020h\u00a2\u0006\u0003\u0010\u00af\u0001JJ\u0010\u00a3\u0001\u001a\u00020J\"\u000f\b\u0000\u0010\u00b0\u0001*\u00030\u00b1\u0001*\u00030\u00b2\u0001*\u0003H\u00b0\u00012\b\u0010\u00a4\u0001\u001a\u00030\u00a5\u00012\u0019\u0010\u00a9\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u00aa\u0001\u0012\u0004\u0012\u00020J0n\u00a2\u0006\u0002\bpH\u0016\u00a2\u0006\u0003\u0010\u00b3\u0001J\u001b\u0010\u00b4\u0001\u001a\u00020[2\u0007\u0010\u00b5\u0001\u001a\u00020[2\u0007\u0010\u00b6\u0001\u001a\u00020_H\u0016J!\u0010\u00b7\u0001\u001a\u0011\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020_\u0018\u00010\u00b8\u00012\u0007\u0010\u00b9\u0001\u001a\u00020[H\u0016J\u0019\u0010\u00ba\u0001\u001a\u00030\u00bb\u0001*\u00020[2\t\u0010\u00bc\u0001\u001a\u0004\u0018\u00010[H\u0016J\u001a\u0010\u00bd\u0001\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010/2\u0007\u0010\u00be\u0001\u001a\u00020_H\u0016J-\u0010\u00bf\u0001\u001a\t\u0012\u0004\u0012\u00020!0\u00c0\u00012\t\u0010\u00a0\u0001\u001a\u0004\u0018\u00010_2\t\u0010\u00a1\u0001\u001a\u0004\u0018\u00010_H\u0086@\u00a2\u0006\u0003\u0010\u00c1\u0001J\u0018\u0010\u00c2\u0001\u001a\u00030\u00c3\u0001*\u00030\u00c4\u00012\u0007\u0010\u00a6\u0001\u001a\u00020[H\u0002J\u0018\u0010\u00c2\u0001\u001a\u00030\u00c3\u0001*\u00030\u00c4\u00012\u0007\u0010\u00c5\u0001\u001a\u00020\u001dH\u0002J\u0018\u0010\u00c2\u0001\u001a\u00030\u00c3\u0001*\u00030\u00c4\u00012\u0007\u0010\u00c6\u0001\u001a\u000202H\u0002J\u0018\u0010\u00c2\u0001\u001a\u00030\u00c3\u0001*\u00030\u00c4\u00012\u0007\u0010\u00c7\u0001\u001a\u000200H\u0002JB\u0010\u00c2\u0001\u001a\u00030\u00c3\u0001*\u00030\u00c4\u00012\u000b\b\u0002\u0010\u00c9\u0001\u001a\u0004\u0018\u00010_2\u0013\u0010\u00ca\u0001\u001a\u000e\u0012\u0005\u0012\u00030\u00cb\u00010/j\u0003`\u00cc\u00012\u000f\u0010\u00cd\u0001\u001a\n\u0012\u0005\u0012\u00030\u00cf\u00010\u00ce\u0001H\u0002J\u001e\u0010\u00d5\u0001\u001a\t\u0012\u0005\u0012\u00030\u00d6\u00010,2\u000e\u0010\u007f\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/J\u0019\u0010\u00d7\u0001\u001a\u00020J*\u00030\u00d8\u00012\b\u0010\u00d9\u0001\u001a\u00030\u00d8\u0001H\u0096\u0005J%\u0010\u00d7\u0001\u001a\u00020J*\t\u0012\u0005\u0012\u00030\u00d8\u00010l2\u000e\u0010\u00da\u0001\u001a\t\u0012\u0005\u0012\u00030\u00d8\u00010lH\u0096\u0005J\u0014\u0010\u00db\u0001\u001a\u00030\u00d8\u00012\u0007\u0010\u00cd\u0001\u001a\u00020uH\u0096\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0014\u0010#\u001a\u00020$8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010\u001d0\u001d0,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u000100000/X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u00101\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u000102020/X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u00103\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010\u001d0\u001d0/X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u000100000/X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u000102020/X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010B\u001a\u00020@2\u0006\u0010A\u001a\u00020@8V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H*\u0004\bC\u0010DR\u001b\u0010O\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bP\u0010QR\u001b\u0010T\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010S\u001a\u0004\bU\u0010QR\u0014\u0010W\u001a\b\u0012\u0004\u0012\u00020X0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020=X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010Z\u001a\u00020[8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\\\u0010]R\u0018\u0010^\u001a\u00020_*\u00020[8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b`\u0010aR\u000f\u0010\u00c8\u0001\u001a\u00020_X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u00d0\u0001\u001a\u00030\u00d1\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00d4\u0001\u0010S\u001a\u0006\b\u00d2\u0001\u0010\u00d3\u0001\u00a8\u0006\u00de\u0001"}, d2={"Lcn/sast/framework/engine/PreAnalysisImpl;", "Lcn/sast/api/config/PreAnalysisCoroutineScope;", "Lcom/feysh/corax/config/api/IAnalysisDepends;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "locator", "Lcn/sast/framework/report/IProjectFileLocator;", "cg", "Lsoot/jimple/toolkits/callgraph/CallGraph;", "info", "Lcom/feysh/corax/cache/analysis/SootInfoCache;", "resultCollector", "Lcn/sast/framework/result/IPreAnalysisResultCollector;", "scene", "Lsoot/Scene;", "<init>", "(Lcn/sast/api/config/MainConfig;Lcn/sast/framework/report/IProjectFileLocator;Lsoot/jimple/toolkits/callgraph/CallGraph;Lcom/feysh/corax/cache/analysis/SootInfoCache;Lcn/sast/framework/result/IPreAnalysisResultCollector;Lsoot/Scene;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "getLocator", "()Lcn/sast/framework/report/IProjectFileLocator;", "getCg", "()Lsoot/jimple/toolkits/callgraph/CallGraph;", "getInfo", "()Lcom/feysh/corax/cache/analysis/SootInfoCache;", "getScene", "()Lsoot/Scene;", "analyzedClasses", "", "Lsoot/SootClass;", "getAnalyzedClasses", "()Ljava/util/Set;", "analyzedSourceFiles", "Lcn/sast/common/IResFile;", "getAnalyzedSourceFiles", "fastCache", "Lcom/feysh/corax/cache/coroutines/FastCache;", "getFastCache", "()Lcom/feysh/corax/cache/coroutines/FastCache;", "scanFilter", "Lcn/sast/api/config/ScanFilter;", "monitor", "Lcn/sast/api/util/IMonitor;", "allClasses", "", "kotlin.jvm.PlatformType", "allMethods", "", "Lsoot/SootMethod;", "allFields", "Lsoot/SootField;", "appOnlyClasses", "appOnlyMethods", "appOnlyFields", "changeFileBasedIncAnalysis", "Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles;", "dg", "Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles$SimpleDeclAnalysisDependsGraph;", "preAnalysisConfig", "Lcn/sast/api/config/PreAnalysisConfig;", "cancelAnalysisInErrorCount", "", "scopeLateInit", "Lcom/feysh/corax/commons/NullableLateinit;", "Lkotlinx/coroutines/CoroutineScope;", "<set-?>", "scope", "getScope$delegate", "(Lcn/sast/framework/engine/PreAnalysisImpl;)Ljava/lang/Object;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "setScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "uninitializedScope", "", "createNormalAnalyzeSemaphore", "Lkotlinx/coroutines/sync/Semaphore;", "permit", "createResourceSemaphore", "globalNormalAnalyzeSemaphore", "getGlobalNormalAnalyzeSemaphore", "()Lkotlinx/coroutines/sync/Semaphore;", "globalNormalAnalyzeSemaphore$delegate", "Lkotlin/Lazy;", "globalResourceSemaphore", "getGlobalResourceSemaphore", "globalResourceSemaphore$delegate", "filesWhichHitSizeThreshold", "Lcn/sast/common/IResource;", "maximumFileSizeThresholdWarnings", "outputPath", "Ljava/nio/file/Path;", "getOutputPath", "()Ljava/nio/file/Path;", "fullCanonicalPathString", "", "getFullCanonicalPathString", "(Ljava/nio/file/Path;)Ljava/lang/String;", "nonNull", "Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "T", "getPhaseTimer", "Lcn/sast/api/util/Timer;", "unit", "Lcom/feysh/corax/config/api/CheckerUnit;", "apiName", "atClass", "classes", "", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/IPreAnalysisClassConfig;", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlin/Function2;", "Lcom/feysh/corax/config/api/IClassCheckPoint;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/feysh/corax/config/api/CheckerUnit;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "atMethod", "methods", "Lcom/feysh/corax/config/api/IPreAnalysisMethodConfig;", "Lcom/feysh/corax/config/api/IMethodCheckPoint;", "atField", "fields", "Lcom/feysh/corax/config/api/IPreAnalysisFieldConfig;", "Lcom/feysh/corax/config/api/IFieldCheckPoint;", "atInvoke", "targets", "Lcom/feysh/corax/config/api/IPreAnalysisInvokeConfig;", "Lcom/feysh/corax/config/api/IInvokeCheckPoint;", "(Lcom/feysh/corax/config/api/CheckerUnit;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "chooseSemaphore", "fileSize", "", "atSourceFile", "files", "", "Lcom/feysh/corax/config/api/IPreAnalysisFileConfig;", "Lcom/feysh/corax/config/api/ISourceFileCheckPoint;", "(Lcom/feysh/corax/config/api/CheckerUnit;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "clazz", "Lcom/feysh/corax/config/api/IClassMatch;", "(Lcom/feysh/corax/config/api/CheckerUnit;Lcom/feysh/corax/config/api/IClassMatch;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "atAnyClass", "(Lcom/feysh/corax/config/api/CheckerUnit;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "method", "Lcom/feysh/corax/config/api/IMethodMatch;", "(Lcom/feysh/corax/config/api/CheckerUnit;Lcom/feysh/corax/config/api/IMethodMatch;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "atAnyMethod", "field", "Lcom/feysh/corax/config/api/IFieldMatch;", "(Lcom/feysh/corax/config/api/CheckerUnit;Lcom/feysh/corax/config/api/IFieldMatch;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "atAnyField", "(Lcom/feysh/corax/config/api/CheckerUnit;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "callee", "atAnyInvoke", "path", "(Lcom/feysh/corax/config/api/CheckerUnit;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "atAnySourceFile", "extension", "filename", "(Lcom/feysh/corax/config/api/CheckerUnit;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "report", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "file", "region", "Lcom/feysh/corax/config/api/report/Region;", "env", "Lcom/feysh/corax/config/api/BugMessage$Env;", "sootHost", "Lsoot/tagkit/Host;", "runInSceneAsync", "Lkotlinx/coroutines/Deferred;", "(Lcom/feysh/corax/config/api/CheckerUnit;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Deferred;", "P", "Lcom/feysh/corax/config/api/ICheckPoint;", "Lcom/feysh/corax/config/api/INodeWithRange;", "(Lcom/feysh/corax/config/api/ICheckPoint;Lcom/feysh/corax/config/api/CheckType;Lkotlin/jvm/functions/Function1;)V", "archivePath", "archiveFile", "entry", "getZipEntry", "Lkotlin/Pair;", "innerFilePath", "getShadowFile", "Ljava/io/File;", "copyDest", "globPath", "glob", "findFiles", "Lkotlin/sequences/Sequence;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "skip", "", "Lcom/feysh/corax/config/api/IPreAnalysisConfig;", "sc", "sf", "sm", "OrigAction", "origAction", "rule", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchItem;", "Lcom/feysh/corax/config/api/rules/ProcessRulesType;", "target", "Lkotlin/Lazy;", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchTarget;", "invokePointData", "Lcn/sast/framework/engine/PreAnalysisImpl$InvokePointData;", "getInvokePointData", "()Lcn/sast/framework/engine/PreAnalysisImpl$InvokePointData;", "invokePointData$delegate", "invokeCheckPoints", "Lcn/sast/framework/engine/InvokeCheckPoint;", "dependsOn", "Lcom/feysh/corax/config/api/XDecl;", "dep", "deps", "toDecl", "Companion", "InvokePointData", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nPreAnalysisImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreAnalysisImpl.kt\ncn/sast/framework/engine/PreAnalysisImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,760:1\n774#2:761\n865#2,2:762\n1368#2:764\n1454#2,5:765\n1368#2:770\n1454#2,5:771\n774#2:776\n865#2,2:777\n1368#2:779\n1454#2,5:780\n1368#2:785\n1454#2,5:786\n1557#2:792\n1628#2,3:793\n1454#2,5:796\n1#3:791\n*S KotlinDebug\n*F\n+ 1 PreAnalysisImpl.kt\ncn/sast/framework/engine/PreAnalysisImpl\n*L\n82#1:761\n82#1:762,2\n83#1:764\n83#1:765,5\n84#1:770\n84#1:771,5\n86#1:776\n86#1:777,2\n87#1:779\n87#1:780,5\n88#1:785\n88#1:786,5\n466#1:792\n466#1:793,3\n543#1:796,5\n*E\n"})
public final class PreAnalysisImpl
implements PreAnalysisCoroutineScope,
IAnalysisDepends {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final /* synthetic */ IAnalysisDepends $$delegate_0;
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final IProjectFileLocator locator;
    @NotNull
    private final CallGraph cg;
    @NotNull
    private final SootInfoCache info;
    @NotNull
    private final IPreAnalysisResultCollector resultCollector;
    @NotNull
    private final Scene scene;
    @NotNull
    private final Set<SootClass> analyzedClasses;
    @NotNull
    private final Set<IResFile> analyzedSourceFiles;
    @NotNull
    private final ScanFilter scanFilter;
    @Nullable
    private final IMonitor monitor;
    @NotNull
    private final Set<SootClass> allClasses;
    @NotNull
    private final List<SootMethod> allMethods;
    @NotNull
    private final List<SootField> allFields;
    @NotNull
    private final List<SootClass> appOnlyClasses;
    @NotNull
    private final List<SootMethod> appOnlyMethods;
    @NotNull
    private final List<SootField> appOnlyFields;
    @Nullable
    private final IncrementalAnalyzeByChangeFiles changeFileBasedIncAnalysis;
    @Nullable
    private final IncrementalAnalyzeByChangeFiles.SimpleDeclAnalysisDependsGraph dg;
    @Nullable
    private final PreAnalysisConfig preAnalysisConfig;
    private final int cancelAnalysisInErrorCount;
    @NotNull
    private final NullableLateinit<CoroutineScope> scopeLateInit;
    @NotNull
    private final Lazy globalNormalAnalyzeSemaphore$delegate;
    @NotNull
    private final Lazy globalResourceSemaphore$delegate;
    @NotNull
    private final Set<IResource> filesWhichHitSizeThreshold;
    private final int maximumFileSizeThresholdWarnings;
    @NotNull
    private final String OrigAction;
    @NotNull
    private final Lazy invokePointData$delegate;
    @NotNull
    private static final KLogger kLogger;

    /*
     * Unable to fully structure code
     */
    public PreAnalysisImpl(@NotNull MainConfig mainConfig, @NotNull IProjectFileLocator locator, @NotNull CallGraph cg, @NotNull SootInfoCache info, @NotNull IPreAnalysisResultCollector resultCollector, @NotNull Scene scene) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        Intrinsics.checkNotNullParameter((Object)locator, (String)"locator");
        Intrinsics.checkNotNullParameter((Object)cg, (String)"cg");
        Intrinsics.checkNotNullParameter((Object)info, (String)"info");
        Intrinsics.checkNotNullParameter((Object)resultCollector, (String)"resultCollector");
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        super();
        this.$$delegate_0 = MainConfigKt.simpleIAnalysisDepends((MainConfig)mainConfig);
        this.mainConfig = mainConfig;
        this.locator = locator;
        this.cg = cg;
        this.info = info;
        this.resultCollector = resultCollector;
        this.scene = scene;
        this.analyzedClasses = (Set)new ConcurrentHashSet();
        this.analyzedSourceFiles = (Set)new ConcurrentHashSet();
        this.scanFilter = this.getMainConfig().getScanFilter();
        this.monitor = this.getMainConfig().getMonitor();
        v0 = this.scene.getClasses();
        Intrinsics.checkNotNullExpressionValue((Object)v0, (String)"getClasses(...)");
        var7_7 = (Iterable)v0;
        var16_8 = this;
        $i$f$filter = false;
        var9_10 = $this$filter$iv;
        destination$iv$iv = new ArrayList<E>();
        $i$f$filterTo = false;
        for (T element$iv$iv : $this$filterTo$iv$iv) {
            it = (SootClass)element$iv$iv;
            $i$a$-filter-PreAnalysisImpl$allClasses$1 = false;
            if (this.scene.isExcluded(it)) ** GOTO lbl-1000
            Intrinsics.checkNotNull((Object)it);
            if (!OthersKt.isSyntheticComponent((SootClass)it)) {
                v1 = true;
            } else lbl-1000:
            // 2 sources

            {
                v1 = false;
            }
            if (!v1) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        var16_8.allClasses = CollectionsKt.toSet((Iterable)((List)destination$iv$iv));
        $this$filter$iv = this.allClasses;
        var16_8 = this;
        $i$f$flatMap = false;
        $this$filterTo$iv$iv = $this$flatMap$iv;
        destination$iv$iv = new ArrayList<E>();
        $i$f$flatMapTo = false;
        for (T element$iv$iv : $this$flatMapTo$iv$iv) {
            it = (SootClass)element$iv$iv;
            $i$a$-flatMap-PreAnalysisImpl$allMethods$1 = false;
            v2 = it.getMethods();
            Intrinsics.checkNotNullExpressionValue((Object)v2, (String)"getMethods(...)");
            list$iv$iv = v2;
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        var16_8.allMethods = (List)destination$iv$iv;
        $this$flatMap$iv = this.allClasses;
        var16_8 = this;
        $i$f$flatMap = false;
        $this$flatMapTo$iv$iv = $this$flatMap$iv;
        destination$iv$iv = new ArrayList<E>();
        $i$f$flatMapTo = false;
        for (T element$iv$iv : $this$flatMapTo$iv$iv) {
            it = (SootClass)element$iv$iv;
            $i$a$-flatMap-PreAnalysisImpl$allFields$1 = false;
            v3 = it.getFields();
            Intrinsics.checkNotNullExpressionValue((Object)v3, (String)"getFields(...)");
            list$iv$iv = (Iterable)v3;
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        var16_8.allFields = (List)destination$iv$iv;
        $this$flatMap$iv = this.allClasses;
        var16_8 = this;
        $i$f$filter = false;
        $this$flatMapTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList<E>();
        $i$f$filterTo = false;
        for (T element$iv$iv : $this$filterTo$iv$iv) {
            it = (SootClass)element$iv$iv;
            $i$a$-filter-PreAnalysisImpl$appOnlyClasses$1 = false;
            if (!it.isApplicationClass()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        var16_8.appOnlyClasses = (List)destination$iv$iv;
        $this$filter$iv = this.appOnlyClasses;
        var16_8 = this;
        $i$f$flatMap = false;
        $this$filterTo$iv$iv = $this$flatMap$iv;
        destination$iv$iv = new ArrayList<E>();
        $i$f$flatMapTo = false;
        for (T element$iv$iv : $this$flatMapTo$iv$iv) {
            it = (SootClass)element$iv$iv;
            $i$a$-flatMap-PreAnalysisImpl$appOnlyMethods$1 = false;
            v4 = it.getMethods();
            Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"getMethods(...)");
            list$iv$iv = v4;
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        var16_8.appOnlyMethods = (List)destination$iv$iv;
        $this$flatMap$iv = this.appOnlyClasses;
        var16_8 = this;
        $i$f$flatMap = false;
        $this$flatMapTo$iv$iv = $this$flatMap$iv;
        destination$iv$iv = new ArrayList<E>();
        $i$f$flatMapTo = false;
        for (T element$iv$iv : $this$flatMapTo$iv$iv) {
            it = (SootClass)element$iv$iv;
            $i$a$-flatMap-PreAnalysisImpl$appOnlyFields$1 = false;
            v5 = it.getFields();
            Intrinsics.checkNotNullExpressionValue((Object)v5, (String)"getFields(...)");
            list$iv$iv = (Iterable)v5;
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        var16_8.appOnlyFields = (List)destination$iv$iv;
        var7_7 = this.getMainConfig().getIncrementAnalyze();
        v6 = this.changeFileBasedIncAnalysis = var7_7 instanceof IncrementalAnalyzeByChangeFiles != false ? (IncrementalAnalyzeByChangeFiles)var7_7 : null;
        this.dg = v6 != null ? v6.getSimpleDeclAnalysisDependsGraph() : null;
        v7 = this.getMainConfig().getSaConfig();
        v8 = this.preAnalysisConfig = v7 != null ? v7.getPreAnalysisConfig() : null;
        this.cancelAnalysisInErrorCount = v8 != null ? v8.getCancelAnalysisInErrorCount() : 10;
        this.scopeLateInit = new NullableLateinit("scope is not initialized yet");
        this.globalNormalAnalyzeSemaphore$delegate = LazyKt.lazy((Function0)(Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, globalNormalAnalyzeSemaphore_delegate$lambda$6(cn.sast.framework.engine.PreAnalysisImpl ), ()Lkotlinx/coroutines/sync/Semaphore;)((PreAnalysisImpl)this));
        this.globalResourceSemaphore$delegate = LazyKt.lazy((Function0)(Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, globalResourceSemaphore_delegate$lambda$7(cn.sast.framework.engine.PreAnalysisImpl ), ()Lkotlinx/coroutines/sync/Semaphore;)((PreAnalysisImpl)this));
        this.filesWhichHitSizeThreshold = Kotlin_extKt.concurrentHashSetOf();
        v9 = this.preAnalysisConfig;
        this.maximumFileSizeThresholdWarnings = v9 != null ? v9.getMaximumFileSizeThresholdWarnings() : 20;
        this.OrigAction = "PreAnalysis: Process";
        this.invokePointData$delegate = LazyKt.lazy((Function0)(Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, invokePointData_delegate$lambda$18(cn.sast.framework.engine.PreAnalysisImpl ), ()Lcn/sast/framework/engine/PreAnalysisImpl$InvokePointData;)((PreAnalysisImpl)this));
    }

    @NotNull
    public MainConfig getMainConfig() {
        return this.mainConfig;
    }

    @NotNull
    public final IProjectFileLocator getLocator() {
        return this.locator;
    }

    @NotNull
    public CallGraph getCg() {
        return this.cg;
    }

    @NotNull
    public final SootInfoCache getInfo() {
        return this.info;
    }

    @NotNull
    public final Scene getScene() {
        return this.scene;
    }

    @NotNull
    public final Set<SootClass> getAnalyzedClasses() {
        return this.analyzedClasses;
    }

    @NotNull
    public final Set<IResFile> getAnalyzedSourceFiles() {
        return this.analyzedSourceFiles;
    }

    @NotNull
    public FastCache getFastCache() {
        return (FastCache)FastCacheImpl.INSTANCE;
    }

    @NotNull
    public CoroutineScope getScope() {
        return (CoroutineScope)this.scopeLateInit.getValue((Object)this, $$delegatedProperties[0]);
    }

    public void setScope(@NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter((Object)coroutineScope, (String)"<set-?>");
        this.scopeLateInit.setValue((Object)this, $$delegatedProperties[0], (Object)coroutineScope);
    }

    private static Object getScope$delegate(PreAnalysisImpl preAnalysisImpl) {
        return preAnalysisImpl.scopeLateInit;
    }

    public void uninitializedScope() {
        this.scopeLateInit.uninitialized();
    }

    private final Semaphore createNormalAnalyzeSemaphore(int permit) {
        return SemaphoreKt.Semaphore$default((int)permit, (int)0, (int)2, null);
    }

    static /* synthetic */ Semaphore createNormalAnalyzeSemaphore$default(PreAnalysisImpl preAnalysisImpl, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = preAnalysisImpl.getMainConfig().getParallelsNum() * 2;
        }
        return preAnalysisImpl.createNormalAnalyzeSemaphore(n);
    }

    private final Semaphore createResourceSemaphore(int permit) {
        return this.createNormalAnalyzeSemaphore(permit);
    }

    static /* synthetic */ Semaphore createResourceSemaphore$default(PreAnalysisImpl preAnalysisImpl, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            PreAnalysisConfig preAnalysisConfig = preAnalysisImpl.preAnalysisConfig;
            n = preAnalysisConfig != null ? preAnalysisConfig.getLargeFileSemaphorePermits() : 3;
        }
        return preAnalysisImpl.createResourceSemaphore(n);
    }

    private final Semaphore getGlobalNormalAnalyzeSemaphore() {
        Lazy lazy = this.globalNormalAnalyzeSemaphore$delegate;
        return (Semaphore)lazy.getValue();
    }

    private final Semaphore getGlobalResourceSemaphore() {
        Lazy lazy = this.globalResourceSemaphore$delegate;
        return (Semaphore)lazy.getValue();
    }

    @NotNull
    public Path getOutputPath() {
        return this.getMainConfig().getOutput_dir().getPath();
    }

    @NotNull
    public String getFullCanonicalPathString(@NotNull Path $this$fullCanonicalPathString) {
        Intrinsics.checkNotNullParameter((Object)$this$fullCanonicalPathString, (String)"<this>");
        return Resource.INSTANCE.of($this$fullCanonicalPathString).getAbsolute().getNormalize().toString();
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> nonNull(@NotNull PreAnalysisApi.Result<T> $this$nonNull) {
        Intrinsics.checkNotNullParameter($this$nonNull, (String)"<this>");
        return (PreAnalysisApi.Result)new /* Unavailable Anonymous Inner Class!! */;
    }

    private final Timer getPhaseTimer(CheckerUnit unit, String apiName) {
        IMonitor iMonitor = this.monitor;
        return iMonitor != null ? iMonitor.timer("PreAnalysis:" + apiName + ".At:" + UtilsKt.getSootTypeName(unit.getClass())) : null;
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atClass(@NotNull CheckerUnit $context_receiver_0, @NotNull Collection<? extends SootClass> classes, @NotNull Function1<? super IPreAnalysisClassConfig, Unit> config, @NotNull Function2<? super IClassCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter(classes, (String)"classes");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        Timer t = this.getPhaseTimer($context_receiver_0, "atClass");
        PreAnalysisClassConfig preAnalysisClassConfig = new PreAnalysisClassConfig(false, false, 3, null);
        config.invoke((Object)preAnalysisClassConfig);
        PreAnalysisClassConfig conf = preAnalysisClassConfig;
        return (PreAnalysisApi.Result)new /* Unavailable Anonymous Inner Class!! */;
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atMethod(@NotNull CheckerUnit $context_receiver_0, @NotNull Collection<? extends SootMethod> methods, @NotNull Function1<? super IPreAnalysisMethodConfig, Unit> config, @NotNull Function2<? super IMethodCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter(methods, (String)"methods");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        Timer t = this.getPhaseTimer($context_receiver_0, "atMethod");
        PreAnalysisMethodConfig preAnalysisMethodConfig = new PreAnalysisMethodConfig(false, false, 3, null);
        config.invoke((Object)preAnalysisMethodConfig);
        PreAnalysisMethodConfig conf = preAnalysisMethodConfig;
        return (PreAnalysisApi.Result)new /* Unavailable Anonymous Inner Class!! */;
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atField(@NotNull CheckerUnit $context_receiver_0, @NotNull Collection<? extends SootField> fields, @NotNull Function1<? super IPreAnalysisFieldConfig, Unit> config, @NotNull Function2<? super IFieldCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter(fields, (String)"fields");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        Timer t = this.getPhaseTimer($context_receiver_0, "atField");
        PreAnalysisFieldConfig preAnalysisFieldConfig = new PreAnalysisFieldConfig(false, false, 3, null);
        config.invoke((Object)preAnalysisFieldConfig);
        PreAnalysisFieldConfig conf = preAnalysisFieldConfig;
        return (PreAnalysisApi.Result)new /* Unavailable Anonymous Inner Class!! */;
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atInvoke(@NotNull CheckerUnit $context_receiver_0, @Nullable List<? extends SootMethod> targets, @NotNull Function1<? super IPreAnalysisInvokeConfig, Unit> config, @NotNull Function2<? super IInvokeCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        Timer t = this.getPhaseTimer($context_receiver_0, "atInvoke");
        PreAnalysisInvokeConfig preAnalysisInvokeConfig = new PreAnalysisInvokeConfig(false, false, 3, null);
        config.invoke((Object)preAnalysisInvokeConfig);
        PreAnalysisInvokeConfig conf = preAnalysisInvokeConfig;
        return (PreAnalysisApi.Result)new /* Unavailable Anonymous Inner Class!! */;
    }

    @NotNull
    public final Semaphore chooseSemaphore(long fileSize) {
        SaConfig saConfig = this.getMainConfig().getSaConfig();
        Integer it = saConfig != null && (saConfig = saConfig.getPreAnalysisConfig()) != null ? Integer.valueOf(saConfig.getLargeFileSize()) : null;
        boolean bl = false;
        return it != null && fileSize > (long)it.intValue() ? this.getGlobalResourceSemaphore() : this.getGlobalNormalAnalyzeSemaphore();
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atSourceFile(@NotNull CheckerUnit $context_receiver_0, @NotNull Function1<? super Continuation<? super Iterator<? extends IResFile>>, ? extends Object> files2, @NotNull Function1<? super IPreAnalysisFileConfig, Unit> config, @NotNull Function2<? super ISourceFileCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter(files2, (String)"files");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        Timer t = this.getPhaseTimer($context_receiver_0, "atSourceFile");
        PreAnalysisFileConfig preAnalysisFileConfig = new PreAnalysisFileConfig(false, false, 3, null);
        config.invoke((Object)preAnalysisFileConfig);
        PreAnalysisFileConfig conf = preAnalysisFileConfig;
        return (PreAnalysisApi.Result)new /* Unavailable Anonymous Inner Class!! */;
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atClass(@NotNull CheckerUnit $context_receiver_0, @NotNull IClassMatch clazz, @NotNull Function1<? super IPreAnalysisClassConfig, Unit> config, @NotNull Function2<? super IClassCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter((Object)clazz, (String)"clazz");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        return this.atClass($context_receiver_0, (Collection)clazz.matched(this.scene), config, block);
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atAnyClass(@NotNull CheckerUnit $context_receiver_0, @NotNull Function1<? super IPreAnalysisClassConfig, Unit> config, @NotNull Function2<? super IClassCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        PreAnalysisClassConfig preAnalysisClassConfig = new PreAnalysisClassConfig(false, false, 3, null);
        config.invoke((Object)preAnalysisClassConfig);
        PreAnalysisClassConfig conf = preAnalysisClassConfig;
        return this.atClass($context_receiver_0, conf.getAppOnly() ? (Collection)this.appOnlyClasses : (Collection)this.allClasses, config, block);
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atMethod(@NotNull CheckerUnit $context_receiver_0, @NotNull IMethodMatch method, @NotNull Function1<? super IPreAnalysisMethodConfig, Unit> config, @NotNull Function2<? super IMethodCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        return this.atMethod($context_receiver_0, (Collection)method.matched(this.scene), config, block);
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atAnyMethod(@NotNull CheckerUnit $context_receiver_0, @NotNull Function1<? super IPreAnalysisMethodConfig, Unit> config, @NotNull Function2<? super IMethodCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        PreAnalysisMethodConfig preAnalysisMethodConfig = new PreAnalysisMethodConfig(false, false, 3, null);
        config.invoke((Object)preAnalysisMethodConfig);
        PreAnalysisMethodConfig conf = preAnalysisMethodConfig;
        List targets = conf.getAppOnly() ? this.appOnlyMethods : this.allMethods;
        return this.atMethod($context_receiver_0, (Collection)targets, config, block);
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atField(@NotNull CheckerUnit $context_receiver_0, @NotNull IFieldMatch field, @NotNull Function1<? super IPreAnalysisFieldConfig, Unit> config, @NotNull Function2<? super IFieldCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        return this.atField($context_receiver_0, (Collection)field.matched(this.scene), config, block);
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atAnyField(@NotNull CheckerUnit $context_receiver_0, @NotNull Function1<? super IPreAnalysisFieldConfig, Unit> config, @NotNull Function1<? super IFieldCheckPoint, ? extends T> block) {
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        PreAnalysisFieldConfig preAnalysisFieldConfig = new PreAnalysisFieldConfig(false, false, 3, null);
        config.invoke((Object)preAnalysisFieldConfig);
        PreAnalysisFieldConfig conf = preAnalysisFieldConfig;
        List targets = conf.getAppOnly() ? this.appOnlyFields : this.allFields;
        return this.atField($context_receiver_0, (Collection)targets, config, (Function2)new /* Unavailable Anonymous Inner Class!! */);
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atInvoke(@NotNull CheckerUnit $context_receiver_0, @NotNull IMethodMatch callee, @NotNull Function1<? super IPreAnalysisInvokeConfig, Unit> config, @NotNull Function2<? super IInvokeCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter((Object)callee, (String)"callee");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        return this.atInvoke($context_receiver_0, callee.matched(this.scene), config, block);
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atAnyInvoke(@NotNull CheckerUnit $context_receiver_0, @NotNull Function1<? super IPreAnalysisInvokeConfig, Unit> config, @NotNull Function2<? super IInvokeCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        return this.atInvoke($context_receiver_0, null, config, block);
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atSourceFile(@NotNull CheckerUnit $context_receiver_0, @NotNull Path path, @NotNull Function1<? super IPreAnalysisFileConfig, Unit> config, @NotNull Function2<? super ISourceFileCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        return this.atSourceFile($context_receiver_0, (Function1)new /* Unavailable Anonymous Inner Class!! */, config, block);
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atAnySourceFile(@NotNull CheckerUnit $context_receiver_0, @Nullable String extension, @Nullable String filename, @NotNull Function1<? super IPreAnalysisFileConfig, Unit> config, @NotNull Function2<? super ISourceFileCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        return this.atSourceFile($context_receiver_0, (Function1)new /* Unavailable Anonymous Inner Class!! */, config, block);
    }

    public void report(@NotNull CheckType checkType, @NotNull Path file, @NotNull Region region, @NotNull Function1<? super BugMessage.Env, Unit> env) {
        Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        Intrinsics.checkNotNullParameter(env, (String)"env");
        FileResInfo fileInfo = new FileResInfo(Resource.INSTANCE.fileOf(file));
        DefaultEnv defaultEnv = new DefaultEnv(region.getMutable(), fileInfo.getReportFileName(), null, null, null, null, null, null, null, 508, null);
        env.invoke((Object)defaultEnv);
        DefaultEnv finalEnv = defaultEnv;
        PreAnalysisReportEnv info2 = new PreAnalysisReportEnv((IBugResInfo)fileInfo, (BugMessage.Env)finalEnv);
        this.resultCollector.report(checkType, info2);
    }

    public void report(@NotNull CheckType checkType, @NotNull Host sootHost, @NotNull Function1<? super BugMessage.Env, Unit> env) {
        ClassCheckPoint classCheckPoint;
        Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
        Intrinsics.checkNotNullParameter((Object)sootHost, (String)"sootHost");
        Intrinsics.checkNotNullParameter(env, (String)"env");
        Host host = sootHost;
        if (host instanceof SootClass) {
            classCheckPoint = new ClassCheckPoint((SootClass)sootHost, this.info);
        } else if (host instanceof SootMethod) {
            classCheckPoint = new MethodCheckPoint((SootMethod)sootHost, this.info);
        } else if (host instanceof SootField) {
            classCheckPoint = new FieldCheckPoint((SootField)sootHost, this.info);
        } else {
            kLogger.error(() -> PreAnalysisImpl.report$lambda$9(sootHost));
            classCheckPoint = null;
        }
        if (classCheckPoint == null) {
            return;
        }
        ClassCheckPoint point = classCheckPoint;
        this.report((ICheckPoint)point, checkType, env);
    }

    @NotNull
    public <T> Deferred<T> runInSceneAsync(@NotNull CheckerUnit $context_receiver_0, @NotNull Function1<? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        SafeAnalyzeUtil safeAnalyzeUtil = new SafeAnalyzeUtil(this.cancelAnalysisInErrorCount, 0, 2, null);
        return BuildersKt.async$default((CoroutineScope)this.getScope(), null, null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)3, null);
    }

    public <P extends ICheckPoint & INodeWithRange> void report(@NotNull P $this$report, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
        Intrinsics.checkNotNullParameter($this$report, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
        Intrinsics.checkNotNullParameter(env, (String)"env");
        CheckPoint cfr_ignored_0 = (CheckPoint)$this$report;
        DefaultEnv defaultEnv = ((CheckPoint)$this$report).getEnv$corax_framework();
        env.invoke((Object)defaultEnv);
        DefaultEnv finalEnv = defaultEnv;
        PreAnalysisReportEnv info2 = new PreAnalysisReportEnv(((CheckPoint)$this$report).getFile(), (BugMessage.Env)finalEnv);
        this.resultCollector.report(checkType, info2);
    }

    @NotNull
    public Path archivePath(@NotNull Path archiveFile, @NotNull String entry) {
        Intrinsics.checkNotNullParameter((Object)archiveFile, (String)"archiveFile");
        Intrinsics.checkNotNullParameter((Object)entry, (String)"entry");
        return Resource.INSTANCE.archivePath(archiveFile, entry);
    }

    @Nullable
    public Pair<Path, String> getZipEntry(@NotNull Path innerFilePath) {
        Intrinsics.checkNotNullParameter((Object)innerFilePath, (String)"innerFilePath");
        IResource file = Resource.INSTANCE.of(innerFilePath);
        String string = file.getZipEntry();
        if (string == null) {
            return null;
        }
        String zipEntry = string;
        return TuplesKt.to((Object)file.getSchemePath(), (Object)zipEntry);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public File getShadowFile(@NotNull Path $this$getShadowFile, @Nullable Path copyDest) {
        Path path;
        IResource iResource;
        block4: {
            block3: {
                void path2;
                IResDirectory iResDirectory;
                IResource file;
                Intrinsics.checkNotNullParameter((Object)$this$getShadowFile, (String)"<this>");
                iResource = file = Resource.INSTANCE.of($this$getShadowFile);
                path = copyDest;
                if (path == null) break block3;
                Path path3 = path;
                IResource iResource2 = iResource;
                boolean bl = false;
                IResDirectory it = iResDirectory = Resource.INSTANCE.dirOf((Path)path2);
                boolean bl2 = false;
                Object object = it.isFileScheme() ? iResDirectory : null;
                iResource = iResource2;
                path = object;
                if (object != null) break block4;
            }
            path = this.getMainConfig().getOutput_dir();
        }
        IResource ret = iResource.expandRes((IResDirectory)path);
        return ret.getFile();
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public List<Path> globPath(@NotNull String glob) {
        List list;
        Intrinsics.checkNotNullParameter((Object)glob, (String)"glob");
        List list2 = ResourceImplKt.globPath((String)glob);
        if (list2 != null) {
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = list2;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                IResource iResource = (IResource)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl = false;
                collection.add(it.getPath());
            }
            list = (List)destination$iv$iv;
        } else {
            list = null;
        }
        return list;
    }

    @Nullable
    public final Object findFiles(@Nullable String extension, @Nullable String filename, @NotNull Continuation<? super Sequence<? extends IResFile>> $completion) {
        if (extension != null) {
            return this.locator.getByFileExtension(extension, $completion);
        }
        if (filename != null) {
            return this.locator.getByFileName(filename, $completion);
        }
        return this.locator.getAllFiles($completion);
    }

    private final boolean skip(IPreAnalysisConfig $this$skip, Path file) {
        return PreAnalysisImpl.skip$default((PreAnalysisImpl)this, (IPreAnalysisConfig)$this$skip, null, (List)this.scanFilter.getProcessRegex().getClazzRules(), (Lazy)LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.NONE, () -> PreAnalysisImpl.skip$lambda$13(this, file)), (int)1, null);
    }

    private final boolean skip(IPreAnalysisConfig $this$skip, SootClass sc) {
        return PreAnalysisImpl.skip$default((PreAnalysisImpl)this, (IPreAnalysisConfig)$this$skip, null, (List)this.scanFilter.getProcessRegex().getClazzRules(), (Lazy)LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.NONE, () -> PreAnalysisImpl.skip$lambda$14(this, sc)), (int)1, null);
    }

    private final boolean skip(IPreAnalysisConfig $this$skip, SootField sf) {
        return this.skip($this$skip, null, this.scanFilter.getProcessRegex().getClazzRules(), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.NONE, () -> PreAnalysisImpl.skip$lambda$15(this, sf)));
    }

    private final boolean skip(IPreAnalysisConfig $this$skip, SootMethod sm) {
        return PreAnalysisImpl.skip$default((PreAnalysisImpl)this, (IPreAnalysisConfig)$this$skip, null, (List)this.scanFilter.getProcessRegex().getClazzRules(), (Lazy)LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.NONE, () -> PreAnalysisImpl.skip$lambda$16(this, sm)), (int)1, null);
    }

    private final boolean skip(IPreAnalysisConfig $this$skip, String origAction, List<? extends ProcessRule.IMatchItem> rule, Lazy<? extends ProcessRule.IMatchTarget> target) {
        ProcessRule.ScanAction act;
        if (!$this$skip.getIgnoreProjectConfigProcessFilter() && (act = ScanFilter.getActionOf$default((ScanFilter)this.scanFilter, rule, (String)origAction, (ProcessRule.IMatchTarget)((ProcessRule.IMatchTarget)target.getValue()), null, (int)8, null)) == ProcessRule.ScanAction.Skip) {
            return true;
        }
        if ($this$skip.getProcessRules().isEmpty()) {
            return false;
        }
        return ProcessRule.INSTANCE.matches($this$skip.getProcessRules(), (ProcessRule.IMatchTarget)target.getValue()).getSecond() == ProcessRule.ScanAction.Skip;
    }

    static /* synthetic */ boolean skip$default(PreAnalysisImpl preAnalysisImpl, IPreAnalysisConfig iPreAnalysisConfig, String string, List list, Lazy lazy, int n, Object object) {
        if ((n & 1) != 0) {
            string = preAnalysisImpl.OrigAction;
        }
        return preAnalysisImpl.skip(iPreAnalysisConfig, string, list, lazy);
    }

    private final InvokePointData getInvokePointData() {
        Lazy lazy = this.invokePointData$delegate;
        return (InvokePointData)lazy.getValue();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Set<InvokeCheckPoint> invokeCheckPoints(@Nullable List<? extends SootMethod> atInvoke2) {
        Set set;
        List<? extends SootMethod> list = atInvoke2;
        if (list != null) {
            void var3_3;
            void $this$flatMapTo$iv;
            Iterable iterable = list;
            Collection destination$iv = new LinkedHashSet();
            boolean $i$f$flatMapTo = false;
            for (Object element$iv : $this$flatMapTo$iv) {
                SootMethod it = (SootMethod)element$iv;
                boolean bl = false;
                Set set2 = this.getInvokePointData().getTargetsToEdges().get((Object)it);
                Intrinsics.checkNotNullExpressionValue((Object)set2, (String)"get(...)");
                Iterable list$iv = set2;
                CollectionsKt.addAll((Collection)destination$iv, (Iterable)list$iv);
            }
            set = (Set)var3_3;
        } else {
            set = this.getInvokePointData().getAllPoint();
        }
        return set;
    }

    @Nullable
    public Object processPreAnalysisUnits(@NotNull Continuation<? super Unit> $completion) {
        return PreAnalysisCoroutineScope.DefaultImpls.processPreAnalysisUnits((PreAnalysisCoroutineScope)this, $completion);
    }

    @NotNull
    public <T> Job runInScene(@NotNull CheckerUnit $context_receiver_0, @NotNull Function1<? super Continuation<? super T>, ? extends Object> block) {
        return PreAnalysisCoroutineScope.DefaultImpls.runInScene((PreAnalysisCoroutineScope)this, (CheckerUnit)$context_receiver_0, block);
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atMethod(@NotNull CheckerUnit $context_receiver_0, @NotNull KCallable<?> method, @NotNull Function1<? super IPreAnalysisMethodConfig, Unit> config, @NotNull Function2<? super IMethodCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
        return PreAnalysisCoroutineScope.DefaultImpls.atMethod((PreAnalysisCoroutineScope)this, (CheckerUnit)$context_receiver_0, method, config, block);
    }

    @NotNull
    public <T> PreAnalysisApi.Result<T> atInvoke(@NotNull CheckerUnit $context_receiver_0, @NotNull KCallable<?> callee, @NotNull Function1<? super IPreAnalysisInvokeConfig, Unit> config, @NotNull Function2<? super IInvokeCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
        return PreAnalysisCoroutineScope.DefaultImpls.atInvoke((PreAnalysisCoroutineScope)this, (CheckerUnit)$context_receiver_0, callee, config, block);
    }

    public <P extends ICheckPoint & INodeWithRange> void report(@NotNull P $this$report, @NotNull CheckType checkType, @NotNull Region region, @NotNull Function1<? super BugMessage.Env, Unit> env) {
        PreAnalysisCoroutineScope.DefaultImpls.report((PreAnalysisCoroutineScope)this, $this$report, (CheckType)checkType, (Region)region, env);
    }

    public void report(@NotNull ISourceFileCheckPoint $this$report, @NotNull CheckType checkType, @NotNull Region region, @NotNull Function1<? super BugMessage.Env, Unit> env) {
        PreAnalysisCoroutineScope.DefaultImpls.report((PreAnalysisCoroutineScope)this, (ISourceFileCheckPoint)$this$report, (CheckType)checkType, (Region)region, env);
    }

    @Nullable
    public Unit report(@NotNull ISourceFileCheckPoint $this$report, @NotNull CheckType checkType, @NotNull de.fraunhofer.aisec.cpg.sarif.Region cpgRegion, @NotNull Function1<? super BugMessage.Env, Unit> env) {
        return PreAnalysisCoroutineScope.DefaultImpls.report((PreAnalysisCoroutineScope)this, (ISourceFileCheckPoint)$this$report, (CheckType)checkType, (de.fraunhofer.aisec.cpg.sarif.Region)cpgRegion, env);
    }

    @Nullable
    public Unit report(@NotNull ISourceFileCheckPoint $this$report, @NotNull CheckType checkType, @NotNull Position jpsStart, @Nullable Position jpsEnd, @NotNull Function1<? super BugMessage.Env, Unit> env) {
        return PreAnalysisCoroutineScope.DefaultImpls.report((PreAnalysisCoroutineScope)this, (ISourceFileCheckPoint)$this$report, (CheckType)checkType, (Position)jpsStart, (Position)jpsEnd, env);
    }

    @Nullable
    public Unit report(@NotNull ISourceFileCheckPoint $this$report, @NotNull CheckType checkType, @NotNull NodeWithRange<?> regionNode, @NotNull Function1<? super BugMessage.Env, Unit> env) {
        return PreAnalysisCoroutineScope.DefaultImpls.report((PreAnalysisCoroutineScope)this, (ISourceFileCheckPoint)$this$report, (CheckType)checkType, regionNode, env);
    }

    public void report(@NotNull CheckType checkType, @NotNull Host sootHost, @Nullable Region region, @NotNull Function1<? super BugMessage.Env, Unit> env) {
        PreAnalysisCoroutineScope.DefaultImpls.report((PreAnalysisCoroutineScope)this, (CheckType)checkType, (Host)sootHost, (Region)region, env);
    }

    @NotNull
    public XDecl toDecl(@NotNull Object target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        return this.$$delegate_0.toDecl(target);
    }

    public void dependsOn(@NotNull XDecl $this$dependsOn, @NotNull XDecl dep) {
        Intrinsics.checkNotNullParameter((Object)$this$dependsOn, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)dep, (String)"dep");
        this.$$delegate_0.dependsOn($this$dependsOn, dep);
    }

    public void dependsOn(@NotNull Collection<? extends XDecl> $this$dependsOn, @NotNull Collection<? extends XDecl> deps) {
        Intrinsics.checkNotNullParameter($this$dependsOn, (String)"<this>");
        Intrinsics.checkNotNullParameter(deps, (String)"deps");
        this.$$delegate_0.dependsOn($this$dependsOn, deps);
    }

    private static final Semaphore globalNormalAnalyzeSemaphore_delegate$lambda$6(PreAnalysisImpl this$0) {
        return PreAnalysisImpl.createNormalAnalyzeSemaphore$default((PreAnalysisImpl)this$0, (int)0, (int)1, null);
    }

    private static final Semaphore globalResourceSemaphore_delegate$lambda$7(PreAnalysisImpl this$0) {
        return PreAnalysisImpl.createResourceSemaphore$default((PreAnalysisImpl)this$0, (int)0, (int)1, null);
    }

    private static final /* synthetic */ Object atAnyField$suspendConversion0(Function1 $this$atAnyField_u24suspendConversion0, IFieldCheckPoint p0, Continuation $completion) {
        return $this$atAnyField_u24suspendConversion0.invoke((Object)p0);
    }

    private static final Object report$lambda$9(Host $sootHost) {
        return "SootHost type in report(,sootHost: " + $sootHost.getClass() + ",) is not support yet! only support types: SootClass, SootMethod, SootField";
    }

    private static final ProcessRule.FileMatch.MatchTarget skip$lambda$13(PreAnalysisImpl this$0, Path $file) {
        return this$0.scanFilter.get($file);
    }

    private static final ProcessRule.ClassMemberMatch.MatchTarget skip$lambda$14(PreAnalysisImpl this$0, SootClass $sc) {
        return this$0.scanFilter.get($sc);
    }

    private static final ProcessRule.ClassMemberMatch.MatchTarget skip$lambda$15(PreAnalysisImpl this$0, SootField $sf) {
        return this$0.scanFilter.get($sf);
    }

    private static final ProcessRule.ClassMemberMatch.MatchTarget skip$lambda$16(PreAnalysisImpl this$0, SootMethod $sm) {
        return this$0.scanFilter.get($sm);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static final InvokePointData invokePointData_delegate$lambda$18(PreAnalysisImpl this$0) {
        v0 = Scene.v().getRefTypeUnsafe("java.lang.Object");
        if (v0 == null) {
            return new InvokePointData((MultiMap)new HashMultiMap(), SetsKt.emptySet());
        }
        objectType = v0;
        targetsToEdges = (MultiMap)new HashMultiMap();
        allPoint = new LinkedHashSet<E>();
        v1 = this$0.getCg().iterator();
        Intrinsics.checkNotNullExpressionValue((Object)v1, (String)"iterator(...)");
        var4_4 = v1;
        while (var4_4.hasNext()) {
            edge = (Edge)var4_4.next();
            src = edge.src();
            if (src == null || !this$0.appOnlyClasses.contains(src.getDeclaringClass())) continue;
            tgt = edge.tgt();
            callSite = edge.srcUnit();
            v2 /* !! */  = callSite instanceof Stmt != false ? (Stmt)callSite : null;
            if (v2 /* !! */  == null) ** GOTO lbl-1000
            it = var12_12 = v2 /* !! */ ;
            $i$a$-takeIf-PreAnalysisImpl$invokePointData$2$invokeExpr$1 = false;
            v2 /* !! */  = it.containsInvokeExpr() != false ? var12_12 : null;
            if (v2 /* !! */  != null) {
                v3 = v2 /* !! */ .getInvokeExpr();
            } else lbl-1000:
            // 2 sources

            {
                v3 = null;
            }
            invokeExpr = v3;
            v4 = invokeExpr instanceof InstanceInvokeExpr != false ? (InstanceInvokeExpr)invokeExpr : null;
            v5 = v4 != null && (v4 = v4.getBase()) != null ? v4.getType() : (declaredReceiverType = null);
            if (Intrinsics.areEqual((Object)declaredReceiverType, (Object)objectType)) continue;
            subSignature = tgt.getSubSignature();
            Intrinsics.checkNotNullExpressionValue((Object)tgt.getDeclaringClass(), (String)"getDeclaringClass(...)");
            invokeCheckPoint = null;
            Intrinsics.checkNotNull((Object)subSignature);
            for (SootMethod find : SootUtilsKt.findMethodOrNull((SootClass)sootClass, (String)subSignature)) {
                if (!Intrinsics.areEqual((Object)find, (Object)tgt) && find.isConcrete()) continue;
                if (invokeCheckPoint == null) {
                    var16_17 = this$0.info;
                    v6 = invokeExpr;
                    var17_18 = v6 != null ? v6.getMethodRef() : null;
                    Intrinsics.checkNotNull((Object)tgt);
                    var18_19 = tgt;
                    invokeCheckPoint = new InvokeCheckPoint(var16_17, src, callSite, declaredReceiverType, var17_18, var18_19, invokeExpr);
                    ((Collection)allPoint).add(invokeCheckPoint);
                }
                targetsToEdges.put((Object)find, invokeCheckPoint);
            }
        }
        return new InvokePointData(targetsToEdges, allPoint);
    }

    private static final Unit kLogger$lambda$20() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getKLogger$cp() {
        return kLogger;
    }

    public static final /* synthetic */ int access$getCancelAnalysisInErrorCount$p(PreAnalysisImpl $this) {
        return $this.cancelAnalysisInErrorCount;
    }

    public static final /* synthetic */ boolean access$skip(PreAnalysisImpl $this, IPreAnalysisConfig $receiver, SootClass sc) {
        return $this.skip($receiver, sc);
    }

    public static final /* synthetic */ IncrementalAnalyzeByChangeFiles.SimpleDeclAnalysisDependsGraph access$getDg$p(PreAnalysisImpl $this) {
        return $this.dg;
    }

    public static final /* synthetic */ Semaphore access$getGlobalNormalAnalyzeSemaphore(PreAnalysisImpl $this) {
        return $this.getGlobalNormalAnalyzeSemaphore();
    }

    public static final /* synthetic */ boolean access$skip(PreAnalysisImpl $this, IPreAnalysisConfig $receiver, SootMethod sm) {
        return $this.skip($receiver, sm);
    }

    public static final /* synthetic */ boolean access$skip(PreAnalysisImpl $this, IPreAnalysisConfig $receiver, SootField sf) {
        return $this.skip($receiver, sf);
    }

    public static final /* synthetic */ boolean access$skip(PreAnalysisImpl $this, IPreAnalysisConfig $receiver, Path file) {
        return $this.skip($receiver, file);
    }

    public static final /* synthetic */ PreAnalysisConfig access$getPreAnalysisConfig$p(PreAnalysisImpl $this) {
        return $this.preAnalysisConfig;
    }

    public static final /* synthetic */ Set access$getFilesWhichHitSizeThreshold$p(PreAnalysisImpl $this) {
        return $this.filesWhichHitSizeThreshold;
    }

    public static final /* synthetic */ int access$getMaximumFileSizeThresholdWarnings$p(PreAnalysisImpl $this) {
        return $this.maximumFileSizeThresholdWarnings;
    }

    public static final /* synthetic */ Object access$atAnyField$suspendConversion0(Function1 $receiver, IFieldCheckPoint p0, Continuation $completion) {
        return PreAnalysisImpl.atAnyField$suspendConversion0((Function1)$receiver, (IFieldCheckPoint)p0, (Continuation)$completion);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(PreAnalysisImpl.class, "scope", "getScope()Lkotlinx/coroutines/CoroutineScope;", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        kLogger = KotlinLogging.INSTANCE.logger(PreAnalysisImpl::kLogger$lambda$20);
    }
}

