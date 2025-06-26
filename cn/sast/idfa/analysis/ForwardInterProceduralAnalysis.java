/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ExtSettings
 *  cn.sast.api.config.StaticFieldTrackingMode
 *  cn.sast.common.OS
 *  cn.sast.coroutines.caffine.impl.FastCacheImpl
 *  cn.sast.graph.HashMutableDirectedGraph
 *  cn.sast.idfa.analysis.Context
 *  cn.sast.idfa.analysis.FixPointStatus
 *  cn.sast.idfa.analysis.FixPointStatus$Companion
 *  cn.sast.idfa.analysis.ForwardInterProceduralAnalysis
 *  cn.sast.idfa.analysis.ForwardInterProceduralAnalysis$Companion
 *  cn.sast.idfa.analysis.ForwardInterProceduralAnalysis$FactKey
 *  cn.sast.idfa.analysis.ForwardInterProceduralAnalysis$InvokeResult
 *  cn.sast.idfa.analysis.ForwardInterProceduralAnalysis$WhenMappings
 *  cn.sast.idfa.analysis.ForwardInterProceduralAnalysis$computeInValue$1
 *  cn.sast.idfa.analysis.ForwardInterProceduralAnalysis$interProceduralAnalyze$1
 *  cn.sast.idfa.analysis.ForwardInterProceduralAnalysis$processContent$1
 *  cn.sast.idfa.analysis.ForwardInterProceduralAnalysis$wrapperCustom$1$1
 *  cn.sast.idfa.analysis.InterProceduralAnalysis
 *  cn.sast.idfa.analysis.ProcessInfoView
 *  cn.sast.idfa.analysis.UsefulMetrics
 *  cn.sast.idfa.progressbar.ProgressBarExt
 *  cn.sast.idfa.progressbar.ProgressBarExt$DefaultProcessInfoRenderer
 *  cn.sast.idfa.progressbar.ProgressBarExtKt
 *  com.feysh.corax.cache.coroutines.RecCoroutineLoadingCache
 *  com.google.common.base.Stopwatch
 *  com.google.common.collect.Sets
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineName
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Deferred
 *  kotlinx.coroutines.ExecutorCoroutineDispatcher
 *  kotlinx.coroutines.ExecutorsKt
 *  kotlinx.coroutines.Job
 *  kotlinx.coroutines.SupervisorKt
 *  kotlinx.coroutines.YieldKt
 *  kotlinx.coroutines.sync.Semaphore
 *  kotlinx.coroutines.sync.SemaphoreKt
 *  me.tongfei.progressbar.ProgressBar
 *  me.tongfei.progressbar.ProgressBarRenderer
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.Unit
 *  soot.jimple.infoflow.collect.ConcurrentHashSet
 *  soot.jimple.infoflow.solver.executors.InterruptableExecutor
 *  soot.toolkits.graph.DirectedGraph
 */
package cn.sast.idfa.analysis;

import cn.sast.api.config.ExtSettings;
import cn.sast.api.config.StaticFieldTrackingMode;
import cn.sast.common.OS;
import cn.sast.coroutines.caffine.impl.FastCacheImpl;
import cn.sast.graph.HashMutableDirectedGraph;
import cn.sast.idfa.analysis.Context;
import cn.sast.idfa.analysis.FixPointStatus;
import cn.sast.idfa.analysis.ForwardInterProceduralAnalysis;
import cn.sast.idfa.analysis.InterProceduralAnalysis;
import cn.sast.idfa.analysis.ProcessInfoView;
import cn.sast.idfa.analysis.UsefulMetrics;
import cn.sast.idfa.progressbar.ProgressBarExt;
import cn.sast.idfa.progressbar.ProgressBarExtKt;
import com.feysh.corax.cache.coroutines.RecCoroutineLoadingCache;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarRenderer;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.infoflow.collect.ConcurrentHashSet;
import soot.jimple.infoflow.solver.executors.InterruptableExecutor;
import soot.toolkits.graph.DirectedGraph;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00ec\u0001\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 \u00b4\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u0004*\u001a\b\u0004\u0010\u0005*\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007:\u0006\u00b2\u0001\u00b3\u0001\u00b4\u0001B\u0011\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\f\u0010%\u001a\u00020&*\u00020'H\u0016J\b\u0010>\u001a\u00020?H\u0016J;\u0010B\u001a\u00028\u00042\u0006\u0010C\u001a\u00028\u00002\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00010E2\u0006\u0010F\u001a\u00028\u00022\u0006\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020\u0017H&\u00a2\u0006\u0002\u0010IJ3\u0010J\u001a\u00028\u00042\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00010E2\u0006\u0010C\u001a\u00028\u00002\u0006\u0010F\u001a\u00028\u00022\u0006\u0010H\u001a\u00020\u0017H\u0016\u00a2\u0006\u0002\u0010KJ\u001e\u0010L\u001a\u00028\u00022\u0006\u0010M\u001a\u00028\u00042\u0006\u0010N\u001a\u00028\u0001H\u0096@\u00a2\u0006\u0002\u0010OJ\u0016\u0010P\u001a\u00028\u00022\u0006\u0010M\u001a\u00028\u0004H\u0096@\u00a2\u0006\u0002\u0010QJ\u0015\u0010R\u001a\u00028\u00022\u0006\u0010M\u001a\u00028\u0004H\u0016\u00a2\u0006\u0002\u0010SJ5\u0010T\u001a\u00028\u00022\u0006\u0010U\u001a\u00028\u00042\u0006\u0010N\u001a\u00028\u00012\u0006\u0010V\u001a\u00028\u00002\u0006\u0010W\u001a\u00028\u00022\u0006\u0010X\u001a\u00028\u0002H\u0016\u00a2\u0006\u0002\u0010YJL\u0010Z\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u0003\u0018\u00010[2\u0006\u0010M\u001a\u00028\u00042\u0006\u0010V\u001a\u00028\u00002\u0006\u0010N\u001a\u00028\u00012\u0006\u0010\\\u001a\u00028\u00012\u0006\u0010X\u001a\u00028\u0002H\u0096@\u00a2\u0006\u0002\u0010]JY\u0010^\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00030[2\u0006\u0010M\u001a\u00028\u00042\u0006\u0010V\u001a\u00028\u00002\u0006\u0010N\u001a\u00028\u00012\u0006\u0010\\\u001a\u00028\u00012\u0006\u0010X\u001a\u00028\u00022\u0006\u0010_\u001a\u00028\u00022\u0006\u0010H\u001a\u00020\u0017H&\u00a2\u0006\u0002\u0010`JY\u0010a\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00030[2\u0006\u0010M\u001a\u00028\u00042\u0006\u0010V\u001a\u00028\u00002\u0006\u0010N\u001a\u00028\u00012\u0006\u0010\\\u001a\u00028\u00012\u0006\u0010X\u001a\u00028\u00022\u0006\u0010_\u001a\u00028\u00022\u0006\u0010H\u001a\u00020\u0017H&\u00a2\u0006\u0002\u0010`J\u000e\u0010q\u001a\u00020?2\u0006\u0010r\u001a\u00020sJJ\u0010t\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00030[2\u0006\u0010U\u001a\u00028\u00042\u0006\u0010V\u001a\u00028\u00002\u0006\u0010N\u001a\u00028\u00012\u0006\u0010\\\u001a\u00028\u00012\u0006\u0010W\u001a\u00028\u0002H\u0096@\u00a2\u0006\u0002\u0010]J\u0015\u0010u\u001a\u00020?2\u0006\u0010V\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010vJV\u0010w\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00030[2\u0006\u0010M\u001a\u00028\u00042\u0006\u0010N\u001a\u00028\u00012\u0006\u0010\\\u001a\u00028\u00012\u001a\u0010x\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00030[H\u0096@\u00a2\u0006\u0002\u0010yJ6\u0010z\u001a\u00028\u00022\u0006\u0010M\u001a\u00028\u00042\u0006\u0010V\u001a\u00028\u00002\u0006\u0010N\u001a\u00028\u00012\u0006\u0010\\\u001a\u00028\u00012\u0006\u0010W\u001a\u00028\u0002H\u0096@\u00a2\u0006\u0002\u0010]Jc\u0010{\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00030[0}0|2\u0006\u0010M\u001a\u00028\u00042\u0006\u0010N\u001a\u00028\u00012\u0006\u0010\\\u001a\u00028\u00012\f\u0010~\u001a\b\u0012\u0004\u0012\u00028\u00000\u007f2\u0006\u0010W\u001a\u00028\u0002H\u0096@\u00a2\u0006\u0003\u0010\u0080\u0001J\u0013\u0010\u0084\u0001\u001a\u00020?*\u00028\u0004H\u0096@\u00a2\u0006\u0002\u0010QJ3\u0010\u0087\u0001\u001a\u00028\u00042\u0019\u0010\u0088\u0001\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020f2\u0006\u0010U\u001a\u00028\u0004H\u0096@\u00a2\u0006\u0003\u0010\u0089\u0001J\u0018\u0010\u008c\u0001\u001a\u00020?2\u0006\u0010C\u001a\u00028\u0000H\u0086@\u00a2\u0006\u0003\u0010\u008d\u0001J1\u0010\u008e\u0001\u001a\u0012\u0012\u0005\u0012\u00030\u0090\u0001\u0012\u0006\u0012\u0004\u0018\u00010&0\u008f\u00012\u0006\u0010r\u001a\u00020s2\u000e\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0092\u0001H\u0016J\u0019\u0010\u0093\u0001\u001a\u00020?2\u000e\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0092\u0001H\u0016J:\u0010\u0094\u0001\u001a\u00028\u00022\u0006\u0010M\u001a\u00028\u00042\u0006\u0010N\u001a\u00028\u00012\u0006\u0010\\\u001a\u00028\u00012\u0006\u0010X\u001a\u00028\u00022\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u00a6@\u00a2\u0006\u0003\u0010\u0097\u0001JE\u0010\u0098\u0001\u001a\u00028\u00022\u001a\u0010M\u001a\u0016\u0012\u0005\u0012\u00030\u0099\u0001\u0012\u0005\u0012\u00030\u009a\u0001\u0012\u0004\u0012\u00028\u00020\u00062\u0007\u0010N\u001a\u00030\u009a\u00012\u0007\u0010\\\u001a\u00030\u009a\u00012\u0006\u0010W\u001a\u00028\u0002H\u0016\u00a2\u0006\u0003\u0010\u009b\u0001J6\u0010\u009c\u0001\u001a\u00028\u00022\u0006\u0010M\u001a\u00028\u00042\u0006\u0010V\u001a\u00028\u00002\u0006\u0010N\u001a\u00028\u00012\u0006\u0010\\\u001a\u00028\u00012\u0006\u0010X\u001a\u00028\u0002H&\u00a2\u0006\u0002\u0010YJe\u0010\u009d\u0001\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00030[2\u0006\u0010M\u001a\u00028\u00042\u0006\u0010_\u001a\u00028\u00022\u0006\u0010V\u001a\u00028\u00002\u0007\u0010\u009e\u0001\u001a\u00028\u00022\u0007\u0010\u009f\u0001\u001a\u00028\u00042\u0006\u0010N\u001a\u00028\u00012\u0006\u0010\\\u001a\u00028\u00012\u0006\u0010H\u001a\u00020\u0017H&\u00a2\u0006\u0003\u0010\u00a0\u0001J)\u0010\u00a1\u0001\u001a\u00028\u00022\u0006\u0010M\u001a\u00028\u00042\u0006\u0010N\u001a\u00028\u00012\u0007\u0010\u00a2\u0001\u001a\u00028\u0002H\u0096@\u00a2\u0006\u0003\u0010\u00a3\u0001J2\u0010\u00a4\u0001\u001a\u0004\u0018\u00018\u00022\u0006\u0010M\u001a\u00028\u00042\u0006\u0010N\u001a\u00028\u00012\u0006\u0010\\\u001a\u00028\u00012\u0007\u0010\u00a5\u0001\u001a\u00028\u0002H\u0016\u00a2\u0006\u0003\u0010\u00a6\u0001J:\u0010\u00a7\u0001\u001a\u00030\u00a8\u00012\u0006\u0010M\u001a\u00028\u00042\u0006\u0010N\u001a\u00028\u00012\u0006\u0010\\\u001a\u00028\u00012\u0007\u0010\u00a9\u0001\u001a\u00028\u00022\u0007\u0010\u00aa\u0001\u001a\u00028\u0002H\u0016\u00a2\u0006\u0003\u0010\u00ab\u0001J\u001e\u0010H\u001a\u00020\u00172\u0006\u0010V\u001a\u00028\u00002\u0006\u0010x\u001a\u00028\u0002H&\u00a2\u0006\u0003\u0010\u00ac\u0001J&\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u007f2\u0007\u0010\u00ae\u0001\u001a\u00028\u00002\u0006\u0010N\u001a\u00028\u0001H\u0016\u00a2\u0006\u0003\u0010\u00af\u0001J%\u0010\u00b0\u0001\u001a\b\u0012\u0004\u0012\u00028\u00010E2\u0006\u0010C\u001a\u00028\u00002\u0006\u0010H\u001a\u00020\u0017H&\u00a2\u0006\u0003\u0010\u00b1\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0017@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010(\u001a\u00020)X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00028\u000005\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107R\"\u00108\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000109X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020)X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010+R\u000e\u0010b\u001a\u00020cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R8\u0010d\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020f\u0012\u0004\u0012\u00028\u00040eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020)X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010+\"\u0004\bm\u0010-R\u001a\u0010n\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0013\"\u0004\bp\u0010\u0015R\u0017\u0010\u0081\u0001\u001a\u00028\u00028BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0010\u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u008b\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00b5\u0001"}, d2={"Lcn/sast/idfa/analysis/ForwardInterProceduralAnalysis;", "M", "N", "A", "R", "CTX", "Lcn/sast/idfa/analysis/Context;", "Lcn/sast/idfa/analysis/InterProceduralAnalysis;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "stopWatch", "Lcom/google/common/base/Stopwatch;", "timeOutDuration", "", "getTimeOutDuration", "()J", "setTimeOutDuration", "(J)V", "timeOutOn", "", "getTimeOutOn", "()Z", "setTimeOutOn", "(Z)V", "usedTime", "", "value", "isTimeout", "limitedAnalytics", "progressBarExt", "Lcn/sast/idfa/progressbar/ProgressBarExt;", "getProgressBarExt", "()Lcn/sast/idfa/progressbar/ProgressBarExt;", "wrapperCustom", "Lcn/sast/idfa/progressbar/ProgressBarExt$DefaultProcessInfoRenderer;", "Lme/tongfei/progressbar/ProgressBar;", "numberThreads", "", "getNumberThreads", "()I", "setNumberThreads", "(I)V", "staticFieldTrackingMode", "Lcn/sast/api/config/StaticFieldTrackingMode;", "getStaticFieldTrackingMode", "()Lcn/sast/api/config/StaticFieldTrackingMode;", "setStaticFieldTrackingMode", "(Lcn/sast/api/config/StaticFieldTrackingMode;)V", "reachableMethods", "Lsoot/jimple/infoflow/collect/ConcurrentHashSet;", "getReachableMethods", "()Lsoot/jimple/infoflow/collect/ConcurrentHashSet;", "directedGraph", "Lcn/sast/graph/HashMutableDirectedGraph;", "getDirectedGraph", "()Lcn/sast/graph/HashMutableDirectedGraph;", "setDirectedGraph", "(Lcn/sast/graph/HashMutableDirectedGraph;)V", "cacheConfig", "", "progressBarVolume", "getProgressBarVolume", "makeContext", "method", "cfg", "Lsoot/toolkits/graph/DirectedGraph;", "entryValue", "reverse", "isAnalyzable", "(Ljava/lang/Object;Lsoot/toolkits/graph/DirectedGraph;Ljava/lang/Object;ZZ)Lcn/sast/idfa/analysis/Context;", "newContext", "(Lsoot/toolkits/graph/DirectedGraph;Ljava/lang/Object;Ljava/lang/Object;Z)Lcn/sast/idfa/analysis/Context;", "computeInValue", "context", "node", "(Lcn/sast/idfa/analysis/Context;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeEntryValue", "(Lcn/sast/idfa/analysis/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeExitValue", "(Lcn/sast/idfa/analysis/Context;)Ljava/lang/Object;", "initCallEdgeValue", "currentContext", "callee", "callSiteValue", "inValue", "(Lcn/sast/idfa/analysis/Context;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "evalCall", "Lcn/sast/idfa/analysis/ForwardInterProceduralAnalysis$InvokeResult;", "succ", "(Lcn/sast/idfa/analysis/Context;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recursiveCallFlowFunction", "siteValue", "(Lcn/sast/idfa/analysis/Context;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Z)Lcn/sast/idfa/analysis/ForwardInterProceduralAnalysis$InvokeResult;", "failedInvokeResult", "contextStateId", "Ljava/util/concurrent/atomic/AtomicLong;", "cache", "Lcom/feysh/corax/cache/coroutines/RecCoroutineLoadingCache;", "Lcn/sast/idfa/analysis/ForwardInterProceduralAnalysis$FactKey;", "getCache", "()Lcom/feysh/corax/cache/coroutines/RecCoroutineLoadingCache;", "setCache", "(Lcom/feysh/corax/cache/coroutines/RecCoroutineLoadingCache;)V", "dataFlowInterProceduralCalleeTimeOut", "getDataFlowInterProceduralCalleeTimeOut", "setDataFlowInterProceduralCalleeTimeOut", "dataFlowInterProceduralCalleeDepChainMaxNum", "getDataFlowInterProceduralCalleeDepChainMaxNum", "setDataFlowInterProceduralCalleeDepChainMaxNum", "init", "scope", "Lkotlinx/coroutines/CoroutineScope;", "processCallCoroutine", "skip", "(Ljava/lang/Object;)V", "postCallAtCallSite", "in1", "(Lcn/sast/idfa/analysis/Context;Ljava/lang/Object;Ljava/lang/Object;Lcn/sast/idfa/analysis/ForwardInterProceduralAnalysis$InvokeResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prevCallFunction", "processAndReturnResult", "", "Lkotlinx/coroutines/Deferred;", "callees", "", "(Lcn/sast/idfa/analysis/Context;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Set;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bottom", "getBottom", "()Ljava/lang/Object;", "processContent", "transformStmtTotalCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "interProceduralAnalyze", "key", "(Lcn/sast/idfa/analysis/ForwardInterProceduralAnalysis$FactKey;Lcn/sast/idfa/analysis/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "curAnalysingMethods", "", "processMethod", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doAnalyze", "Lkotlin/Pair;", "Lkotlinx/coroutines/Job;", "entries", "", "doAnalysis", "normalFlowFunction", "isNegativeBranch", "Ljava/util/concurrent/atomic/AtomicBoolean;", "(Lcn/sast/idfa/analysis/Context;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicBoolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callLocalFlowFunction", "Lsoot/SootMethod;", "Lsoot/Unit;", "(Lcn/sast/idfa/analysis/Context;Lsoot/Unit;Lsoot/Unit;Ljava/lang/Object;)Ljava/lang/Object;", "callEntryFlowFunction", "callExitFlowFunction", "callEdgeValue", "calleeCtx", "(Lcn/sast/idfa/analysis/Context;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lcn/sast/idfa/analysis/Context;Ljava/lang/Object;Ljava/lang/Object;Z)Lcn/sast/idfa/analysis/ForwardInterProceduralAnalysis$InvokeResult;", "returnFlowFunction", "returnValue", "(Lcn/sast/idfa/analysis/Context;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wideningFunction", "in", "(Lcn/sast/idfa/analysis/Context;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "hasChange", "Lcn/sast/idfa/analysis/FixPointStatus;", "old", "new", "(Lcn/sast/idfa/analysis/Context;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcn/sast/idfa/analysis/FixPointStatus;", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "resolveTargets", "callerMethod", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Set;", "getCfg", "(Ljava/lang/Object;Z)Lsoot/toolkits/graph/DirectedGraph;", "FactKey", "InvokeResult", "Companion", "corax-idfa-framework"})
@SourceDebugExtension(value={"SMAP\nForwardInterProceduralAnalysis.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ForwardInterProceduralAnalysis.kt\ncn/sast/idfa/analysis/ForwardInterProceduralAnalysis\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n+ 4 FixPointStatus.kt\ncn/sast/idfa/analysis/FixPointStatus$Companion\n*L\n1#1,678:1\n1279#2,2:679\n1293#2,2:681\n1296#2:684\n1557#2:685\n1628#2,3:686\n326#3:683\n10#4:689\n*S KotlinDebug\n*F\n+ 1 ForwardInterProceduralAnalysis.kt\ncn/sast/idfa/analysis/ForwardInterProceduralAnalysis\n*L\n341#1:679,2\n341#1:681,2\n341#1:684\n512#1:685\n512#1:686,3\n342#1:683\n663#1:689\n*E\n"})
public abstract class ForwardInterProceduralAnalysis<M, N, A, R, CTX extends Context<M, N, A>>
extends InterProceduralAnalysis<M, N, A> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String name;
    @Nullable
    private Stopwatch stopWatch;
    private long timeOutDuration;
    private boolean timeOutOn;
    private double usedTime;
    private boolean isTimeout;
    private boolean limitedAnalytics;
    @NotNull
    private final ProgressBarExt progressBarExt;
    private int numberThreads;
    @NotNull
    private StaticFieldTrackingMode staticFieldTrackingMode;
    @NotNull
    private final ConcurrentHashSet<M> reachableMethods;
    @Nullable
    private HashMutableDirectedGraph<M> directedGraph;
    private final int progressBarVolume;
    @NotNull
    private final AtomicLong contextStateId;
    public RecCoroutineLoadingCache<FactKey<M, N, A>, CTX> cache;
    private int dataFlowInterProceduralCalleeTimeOut;
    private long dataFlowInterProceduralCalleeDepChainMaxNum;
    @NotNull
    private AtomicInteger transformStmtTotalCount;
    @NotNull
    private final Set<M> curAnalysingMethods;
    @NotNull
    private static KLogger logger = KotlinLogging.INSTANCE.logger(ForwardInterProceduralAnalysis::logger$lambda$13);

    public ForwardInterProceduralAnalysis(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        super(false);
        this.name = name;
        this.progressBarExt = new ProgressBarExt(0, 0, 3, null);
        this.numberThreads = OS.INSTANCE.getMaxThreadNum();
        this.staticFieldTrackingMode = StaticFieldTrackingMode.ContextFlowSensitive;
        this.reachableMethods = new ConcurrentHashSet();
        this.progressBarVolume = 100;
        this.contextStateId = new AtomicLong(0L);
        this.dataFlowInterProceduralCalleeTimeOut = -1;
        this.dataFlowInterProceduralCalleeDepChainMaxNum = -1L;
        this.transformStmtTotalCount = new AtomicInteger();
        Set set = Sets.newConcurrentHashSet();
        Intrinsics.checkNotNullExpressionValue((Object)set, (String)"newConcurrentHashSet(...)");
        this.curAnalysingMethods = set;
    }

    public /* synthetic */ ForwardInterProceduralAnalysis(String string, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            string = Companion.getClass().getSimpleName();
        }
        this(string);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    protected final long getTimeOutDuration() {
        return this.timeOutDuration;
    }

    protected final void setTimeOutDuration(long l) {
        this.timeOutDuration = l;
    }

    protected final boolean getTimeOutOn() {
        return this.timeOutOn;
    }

    protected final void setTimeOutOn(boolean bl) {
        this.timeOutOn = bl;
    }

    public final boolean isTimeout() {
        return this.isTimeout;
    }

    @NotNull
    public final ProgressBarExt getProgressBarExt() {
        return this.progressBarExt;
    }

    @NotNull
    public ProgressBarExt.DefaultProcessInfoRenderer wrapperCustom(@NotNull ProgressBar $this$wrapperCustom) {
        Intrinsics.checkNotNullParameter((Object)$this$wrapperCustom, (String)"<this>");
        return (ProgressBarExt.DefaultProcessInfoRenderer)ProgressBarExtKt.wrapper((ProgressBar)$this$wrapperCustom, (arg_0, arg_1) -> ForwardInterProceduralAnalysis.wrapperCustom$lambda$0(this, arg_0, arg_1));
    }

    public int getNumberThreads() {
        return this.numberThreads;
    }

    public void setNumberThreads(int n) {
        this.numberThreads = n;
    }

    @NotNull
    public StaticFieldTrackingMode getStaticFieldTrackingMode() {
        return this.staticFieldTrackingMode;
    }

    public void setStaticFieldTrackingMode(@NotNull StaticFieldTrackingMode staticFieldTrackingMode) {
        Intrinsics.checkNotNullParameter((Object)staticFieldTrackingMode, (String)"<set-?>");
        this.staticFieldTrackingMode = staticFieldTrackingMode;
    }

    @NotNull
    public final ConcurrentHashSet<M> getReachableMethods() {
        return this.reachableMethods;
    }

    @Nullable
    public final HashMutableDirectedGraph<M> getDirectedGraph() {
        return this.directedGraph;
    }

    public final void setDirectedGraph(@Nullable HashMutableDirectedGraph<M> hashMutableDirectedGraph) {
        this.directedGraph = hashMutableDirectedGraph;
    }

    public void cacheConfig() {
    }

    public int getProgressBarVolume() {
        return this.progressBarVolume;
    }

    @NotNull
    public abstract CTX makeContext(M var1, @NotNull DirectedGraph<N> var2, A var3, boolean var4, boolean var5);

    @NotNull
    public CTX newContext(@NotNull DirectedGraph<N> cfg, M method, A entryValue, boolean isAnalyzable) {
        Intrinsics.checkNotNullParameter(cfg, (String)"cfg");
        this.programRepresentation().setOwnerStatement((Iterable)cfg, method);
        Context context = this.makeContext(method, cfg, entryValue, false, isAnalyzable);
        context.setBottomValue(this.bottomValue());
        List heads = cfg.getHeads();
        Iterator iterator2 = cfg.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"iterator(...)");
        Iterator iterator3 = iterator2;
        while (iterator3.hasNext()) {
            Object node = iterator3.next();
            if (heads.contains(node)) {
                Object object = context.getEntryValue();
                Intrinsics.checkNotNull((Object)object);
                context.setValueBefore(node, object);
                continue;
            }
            context.setValueBefore(node, this.bottomValue());
        }
        context.initworklist();
        context.setExitValue(this.bottomValue());
        return (CTX)context;
    }

    @Nullable
    public Object computeInValue(@NotNull CTX context, N node, @NotNull Continuation<? super A> $completion) {
        return ForwardInterProceduralAnalysis.computeInValue$suspendImpl((ForwardInterProceduralAnalysis)this, context, node, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ <M, N, A, R, CTX extends Context<M, N, A>> Object computeInValue$suspendImpl(ForwardInterProceduralAnalysis<M, N, A, R, CTX> var0, CTX var1_1, N var2_2, Continuation<? super A> $completion) {
        if (!($completion instanceof computeInValue.1)) ** GOTO lbl-1000
        var11_4 = $completion;
        if ((var11_4.label & -2147483648) != 0) {
            var11_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var12_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                in1 = $this.bottomValue();
                cfg = context.getControlFlowGraph();
                predecessors = cfg.getPredsOf(node);
                if (predecessors.size() == 0) ** GOTO lbl21
                for (E pred : predecessors) {
                    predOut = context.getEdgeValue(pred, node);
                    in1 = $this.meet(in1, predOut);
                }
                ** GOTO lbl34
lbl21:
                // 1 sources

                $continuation.L$0 = context;
                $continuation.L$1 = node;
                $continuation.label = 1;
                v0 = $this.computeEntryValue(context, (Continuation)$continuation);
                if (v0 == var12_6) {
                    return var12_6;
                }
                ** GOTO lbl33
            }
            case 1: {
                node = $continuation.L$1;
                context = (Context)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl33:
                // 2 sources

                in1 = v0;
lbl34:
                // 2 sources

                context.setValueBefore(node, in1);
                return in1;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public Object computeEntryValue(@NotNull CTX context, @NotNull Continuation<? super A> $completion) {
        return ForwardInterProceduralAnalysis.computeEntryValue$suspendImpl((ForwardInterProceduralAnalysis)this, context, $completion);
    }

    static /* synthetic */ <M, N, A, R, CTX extends Context<M, N, A>> Object computeEntryValue$suspendImpl(ForwardInterProceduralAnalysis<M, N, A, R, CTX> $this, CTX context, Continuation<? super A> $completion) {
        Object object = context.getEntryValue();
        Intrinsics.checkNotNull((Object)object);
        return object;
    }

    public A computeExitValue(@NotNull CTX context) {
        Intrinsics.checkNotNullParameter(context, (String)"context");
        DirectedGraph cfg = context.getControlFlowGraph();
        Object exitValue = this.bottomValue();
        for (Object tailNode : cfg.getTails()) {
            Object tailOut = context.getEdgeValue(tailNode, tailNode);
            exitValue = this.meet(exitValue, tailOut);
        }
        return (A)exitValue;
    }

    public A initCallEdgeValue(@NotNull CTX currentContext, N node, M callee, A callSiteValue, A inValue) {
        Intrinsics.checkNotNullParameter(currentContext, (String)"currentContext");
        return inValue;
    }

    @Nullable
    public Object evalCall(@NotNull CTX context, M callee, N node, N succ, A inValue, @NotNull Continuation<? super InvokeResult<M, A, R>> $completion) {
        return ForwardInterProceduralAnalysis.evalCall$suspendImpl((ForwardInterProceduralAnalysis)this, context, callee, node, succ, inValue, $completion);
    }

    static /* synthetic */ <M, N, A, R, CTX extends Context<M, N, A>> Object evalCall$suspendImpl(ForwardInterProceduralAnalysis<M, N, A, R, CTX> $this, CTX context, M callee, N node, N succ, A inValue, Continuation<? super InvokeResult<M, A, R>> $completion) {
        return null;
    }

    @NotNull
    public abstract InvokeResult<M, A, R> recursiveCallFlowFunction(@NotNull CTX var1, M var2, N var3, N var4, A var5, A var6, boolean var7);

    @NotNull
    public abstract InvokeResult<M, A, R> failedInvokeResult(@NotNull CTX var1, M var2, N var3, N var4, A var5, A var6, boolean var7);

    @NotNull
    public final RecCoroutineLoadingCache<FactKey<M, N, A>, CTX> getCache() {
        RecCoroutineLoadingCache recCoroutineLoadingCache = this.cache;
        if (recCoroutineLoadingCache != null) {
            return recCoroutineLoadingCache;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"cache");
        return null;
    }

    public final void setCache(@NotNull RecCoroutineLoadingCache<FactKey<M, N, A>, CTX> recCoroutineLoadingCache) {
        Intrinsics.checkNotNullParameter(recCoroutineLoadingCache, (String)"<set-?>");
        this.cache = recCoroutineLoadingCache;
    }

    public final int getDataFlowInterProceduralCalleeTimeOut() {
        return this.dataFlowInterProceduralCalleeTimeOut;
    }

    public final void setDataFlowInterProceduralCalleeTimeOut(int n) {
        this.dataFlowInterProceduralCalleeTimeOut = n;
    }

    public final long getDataFlowInterProceduralCalleeDepChainMaxNum() {
        return this.dataFlowInterProceduralCalleeDepChainMaxNum;
    }

    public final void setDataFlowInterProceduralCalleeDepChainMaxNum(long l) {
        this.dataFlowInterProceduralCalleeDepChainMaxNum = l;
    }

    public final void init(@NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter((Object)scope, (String)"scope");
        this.setCache(FastCacheImpl.INSTANCE.buildRecCoroutineLoadingCache(scope, ForwardInterProceduralAnalysis::init$lambda$1, (Function3)new /* Unavailable Anonymous Inner Class!! */));
    }

    @Nullable
    public Object processCallCoroutine(@NotNull CTX currentContext, M callee, N node, N succ, A callSiteValue, @NotNull Continuation<? super InvokeResult<M, A, R>> $completion) {
        return ForwardInterProceduralAnalysis.processCallCoroutine$suspendImpl((ForwardInterProceduralAnalysis)this, currentContext, callee, node, succ, callSiteValue, $completion);
    }

    /*
     * Exception decompiling
     */
    static /* synthetic */ <M, N, A, R, CTX extends Context<M, N, A>> Object processCallCoroutine$suspendImpl(ForwardInterProceduralAnalysis<M, N, A, R, CTX> var0, CTX var1_1, M var2_2, N var3_3, N var4_4, A var5_5, Continuation<? super InvokeResult<M, A, R>> $completion) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[SWITCH], 8[CASE]], but top level block is 2[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1050)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public abstract void skip(M var1);

    @Nullable
    public Object postCallAtCallSite(@NotNull CTX context, N node, N succ, @NotNull InvokeResult<M, A, R> in1, @NotNull Continuation<? super InvokeResult<M, A, R>> $completion) {
        return ForwardInterProceduralAnalysis.postCallAtCallSite$suspendImpl((ForwardInterProceduralAnalysis)this, context, node, succ, in1, $completion);
    }

    static /* synthetic */ <M, N, A, R, CTX extends Context<M, N, A>> Object postCallAtCallSite$suspendImpl(ForwardInterProceduralAnalysis<M, N, A, R, CTX> $this, CTX context, N node, N succ, InvokeResult<M, A, R> in1, Continuation<? super InvokeResult<M, A, R>> $completion) {
        return in1;
    }

    @Nullable
    public Object prevCallFunction(@NotNull CTX context, M callee, N node, N succ, A callSiteValue, @NotNull Continuation<? super A> $completion) {
        return ForwardInterProceduralAnalysis.prevCallFunction$suspendImpl((ForwardInterProceduralAnalysis)this, context, callee, node, succ, callSiteValue, $completion);
    }

    static /* synthetic */ <M, N, A, R, CTX extends Context<M, N, A>> Object prevCallFunction$suspendImpl(ForwardInterProceduralAnalysis<M, N, A, R, CTX> $this, CTX context, M callee, N node, N succ, A callSiteValue, Continuation<? super A> $completion) {
        return callSiteValue;
    }

    @Nullable
    public Object processAndReturnResult(@NotNull CTX context, N node, N succ, @NotNull Set<? extends M> callees, A callSiteValue, @NotNull Continuation<? super Map<M, ? extends Deferred<InvokeResult<M, A, R>>>> $completion) {
        return ForwardInterProceduralAnalysis.processAndReturnResult$suspendImpl((ForwardInterProceduralAnalysis)this, context, node, succ, callees, callSiteValue, $completion);
    }

    /*
     * WARNING - void declaration
     */
    static /* synthetic */ <M, N, A, R, CTX extends Context<M, N, A>> Object processAndReturnResult$suspendImpl(ForwardInterProceduralAnalysis<M, N, A, R, CTX> $this, CTX context, N node, N succ, Set<? extends M> callees, A callSiteValue, Continuation<? super Map<M, ? extends Deferred<InvokeResult<M, A, R>>>> $completion) {
        Iterable $this$associateWith$iv = callees;
        boolean $i$f$associateWith = false;
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv, (int)10)), (int)16));
        Iterable $this$associateWithTo$iv$iv = $this$associateWith$iv;
        boolean $i$f$associateWithTo = false;
        Iterator iterator2 = $this$associateWithTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void callee;
            Object element$iv$iv;
            Object t = element$iv$iv = iterator2.next();
            Object t2 = element$iv$iv;
            Map map = result$iv;
            boolean bl = false;
            Continuation<? super Map<M, ? extends Deferred<InvokeResult<M, A, R>>>> continuation = $completion;
            boolean $i$f$currentCoroutineContext = false;
            Deferred deferred = BuildersKt.async$default((CoroutineScope)CoroutineScopeKt.CoroutineScope((CoroutineContext)$completion.getContext()), null, null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)3, null);
            map.put(t2, deferred);
        }
        return result$iv;
    }

    private final A getBottom() {
        return (A)this.bottomValue();
    }

    @Nullable
    public Object processContent(@NotNull CTX $this$processContent, @NotNull Continuation<? super kotlin.Unit> $completion) {
        return ForwardInterProceduralAnalysis.processContent$suspendImpl((ForwardInterProceduralAnalysis)this, $this$processContent, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ <M, N, A, R, CTX extends Context<M, N, A>> Object processContent$suspendImpl(ForwardInterProceduralAnalysis<M, N, A, R, CTX> var0, CTX var1_1, Continuation<? super kotlin.Unit> $completion) {
        if (!($completion instanceof processContent.1)) ** GOTO lbl-1000
        var14_3 = $completion;
        if ((var14_3.label & -2147483648) != 0) {
            var14_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var15_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = $this;
                $continuation.L$1 = $receiver;
                $continuation.label = 1;
                v0 = YieldKt.yield((Continuation)$continuation);
                if (v0 == var15_5) {
                    return var15_5;
                }
                ** GOTO lbl24
            }
            case 1: {
                $receiver = (Context)$continuation.L$1;
                $this = (ForwardInterProceduralAnalysis)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl24:
                // 2 sources

                currentContext = $receiver;
                v1 = currentContext.getWorklist().pollFirst();
                Intrinsics.checkNotNull(v1);
                var4_7 = (Pair)v1;
                node = var4_7.component1();
                succ = var4_7.component2();
                $continuation.L$0 = $this;
                $continuation.L$1 = currentContext;
                $continuation.L$2 = node;
                $continuation.L$3 = succ;
                $continuation.label = 2;
                v2 = $this.computeInValue(currentContext, node, (Continuation)$continuation);
                if (v2 == var15_5) {
                    return var15_5;
                }
                ** GOTO lbl46
            }
            case 2: {
                succ = $continuation.L$3;
                node = $continuation.L$2;
                currentContext = (Context)$continuation.L$1;
                $this = (ForwardInterProceduralAnalysis)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = in1 = $result;
lbl46:
                // 2 sources

                if (ForwardInterProceduralAnalysis.logger.isTraceEnabled()) {
                    ForwardInterProceduralAnalysis.logger.trace("  IN: {}", in1);
                    ForwardInterProceduralAnalysis.logger.trace("EDGE: [{} --> {}]", node, succ);
                }
                if (Intrinsics.areEqual((Object)in1, (Object)$this.getBottom())) {
                    return kotlin.Unit.INSTANCE;
                }
                if (!currentContext.isAnalyzable() || currentContext.getSkipAnalysis()) {
                    currentContext.clearWorkList();
                    cfg = currentContext.getControlFlowGraph();
                    for (E tailNode : cfg.getTails()) {
                        currentContext.setEdgeValue(tailNode, tailNode, in1);
                    }
                    return kotlin.Unit.INSTANCE;
                }
                $continuation.L$0 = $this;
                $continuation.L$1 = currentContext;
                $continuation.L$2 = node;
                $continuation.L$3 = succ;
                $continuation.L$4 = in1;
                $continuation.label = 3;
                v3 = YieldKt.yield((Continuation)$continuation);
                if (v3 == var15_5) {
                    return var15_5;
                }
                ** GOTO lbl76
            }
            case 3: {
                in1 = $continuation.L$4;
                succ = $continuation.L$3;
                node = $continuation.L$2;
                currentContext = (Context)$continuation.L$1;
                $this = (ForwardInterProceduralAnalysis)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v3 = $result;
lbl76:
                // 2 sources

                isNegativeBranch = new AtomicBoolean(false);
                $continuation.L$0 = $this;
                $continuation.L$1 = currentContext;
                $continuation.L$2 = node;
                $continuation.L$3 = succ;
                $continuation.L$4 = isNegativeBranch;
                $continuation.label = 4;
                v4 = $this.normalFlowFunction(currentContext, node, succ, in1, isNegativeBranch, (Continuation)$continuation);
                if (v4 == var15_5) {
                    return var15_5;
                }
                ** GOTO lbl95
            }
            case 4: {
                isNegativeBranch = (AtomicBoolean)$continuation.L$4;
                succ = $continuation.L$3;
                node = $continuation.L$2;
                currentContext = (Context)$continuation.L$1;
                $this = (ForwardInterProceduralAnalysis)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v4 = out = $result;
lbl95:
                // 2 sources

                if (currentContext.getPathSensitiveEnable() && isNegativeBranch.get()) {
                    currentContext.setEdgeValue(node, succ, $this.getBottom());
                    return kotlin.Unit.INSTANCE;
                }
                oldOut = currentContext.getEdgeValue(node, succ);
                currentContext.setEdgeValue(node, succ, out);
                if (ForwardInterProceduralAnalysis.logger.isTraceEnabled()) {
                    ForwardInterProceduralAnalysis.logger.trace("  OUT_old: {}", oldOut);
                    ForwardInterProceduralAnalysis.logger.trace("  OUT_new: {}", out);
                    ForwardInterProceduralAnalysis.logger.trace("");
                }
                var11_17 = $this.hasChange(currentContext, node, succ, oldOut, out);
                switch (WhenMappings.$EnumSwitchMapping$0[var11_17.ordinal()]) {
                    case 1: {
                        currentContext.addToWorklist(succ);
                        break;
                    }
                    case 2: {
                        widen = $this.wideningFunction(currentContext, node, succ, out);
                        if (widen != null) {
                            currentContext.setEdgeValue(node, succ, widen);
                        }
                        currentContext.addToWorklist(succ);
                        currentContext.setPathSensitiveEnable(false);
                        break;
                    }
                    case 3: {
                        break;
                    }
                    default: {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                return kotlin.Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public Object interProceduralAnalyze(@NotNull FactKey<M, N, A> key2, @NotNull CTX currentContext, @NotNull Continuation<? super CTX> $completion) {
        return ForwardInterProceduralAnalysis.interProceduralAnalyze$suspendImpl((ForwardInterProceduralAnalysis)this, key2, currentContext, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ <M, N, A, R, CTX extends Context<M, N, A>> Object interProceduralAnalyze$suspendImpl(ForwardInterProceduralAnalysis<M, N, A, R, CTX> var0, FactKey<M, N, A> var1_1, CTX var2_2, Continuation<? super CTX> $completion) {
        if (!($completion instanceof interProceduralAnalyze.1)) ** GOTO lbl-1000
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
                $this.reachableMethods.add(currentContext.getMethod());
lbl14:
                // 2 sources

                while (!currentContext.getWorklist().isEmpty()) {
                    $continuation.L$0 = $this;
                    $continuation.L$1 = currentContext;
                    $continuation.label = 1;
                    v0 = $this.processContent(currentContext, (Continuation)$continuation);
                    if (v0 == var7_6) {
                        return var7_6;
                    }
                    ** GOTO lbl28
                }
                break;
            }
            case 1: {
                currentContext = (Context)$continuation.L$1;
                $this = (ForwardInterProceduralAnalysis)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl28:
                // 2 sources

                $this.transformStmtTotalCount.getAndIncrement();
                ** GOTO lbl14
            }
        }
        exitValue = $this.computeExitValue(currentContext);
        if (Intrinsics.areEqual((Object)exitValue, (Object)$this.getBottom())) {
            v1 = currentContext.getEntryValue();
            Intrinsics.checkNotNull((Object)v1);
            exitValue = v1;
        }
        currentContext.setExitValue(exitValue);
        currentContext.markAnalysed();
        return currentContext;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object processMethod(M method, @NotNull Continuation<? super kotlin.Unit> $completion) {
        int dataFlowInterProceduralCalleeTimeOut = this.dataFlowInterProceduralCalleeTimeOut;
        FactKey key2 = new FactKey(this.boundaryValue(method), method, true);
        Object object = SupervisorKt.supervisorScope((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return kotlin.Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public Pair<Job, ProgressBarExt.DefaultProcessInfoRenderer> doAnalyze(@NotNull CoroutineScope scope, @NotNull Collection<? extends M> entries) {
        void $this$mapTo$iv$iv;
        ProgressBarExt.DefaultProcessInfoRenderer progressBarRenderer;
        Intrinsics.checkNotNullParameter((Object)scope, (String)"scope");
        Intrinsics.checkNotNullParameter(entries, (String)"entries");
        logger.info(() -> ForwardInterProceduralAnalysis.doAnalyze$lambda$6(this));
        this.init(scope);
        int size = entries.size();
        AtomicInteger counter = new AtomicInteger();
        ProgressBarExt.DefaultProcessInfoRenderer defaultProcessInfoRenderer = progressBarRenderer = !ExtSettings.INSTANCE.getEnableProcessBar() ? null : this.wrapperCustom(ProgressBarExt.getProgressBar$default((ProgressBarExt)this.progressBarExt, (String)"e", (long)size, null, null, (int)12, null));
        if (defaultProcessInfoRenderer != null) {
            defaultProcessInfoRenderer.setSplitLines(20L);
        }
        Semaphore semaphore = SemaphoreKt.Semaphore$default((int)Math.max(this.getNumberThreads() * 4, 4), (int)0, (int)2, null);
        Iterable $this$map$iv = entries;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void method;
            Object item$iv$iv;
            Object t = item$iv$iv = iterator2.next();
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(BuildersKt.launch$default((CoroutineScope)scope, (CoroutineContext)((CoroutineContext)new CoroutineName("process-" + method)), null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)2, null));
        }
        List jobs3 = (List)destination$iv$iv;
        return TuplesKt.to((Object)BuildersKt.launch$default((CoroutineScope)scope, null, null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)3, null), (Object)progressBarRenderer);
    }

    public void doAnalysis(@NotNull Collection<? extends M> entries) {
        Intrinsics.checkNotNullParameter(entries, (String)"entries");
        InterruptableExecutor executor = new InterruptableExecutor(this.getNumberThreads(), Integer.MAX_VALUE, 5L, TimeUnit.SECONDS, (BlockingQueue)new LinkedBlockingQueue());
        ExecutorCoroutineDispatcher coroutineCtx = ExecutorsKt.from((ExecutorService)((ExecutorService)executor));
        CoroutineScope scope = CoroutineScopeKt.CoroutineScope((CoroutineContext)coroutineCtx.plus((CoroutineContext)new CoroutineName("Scope-AI-analysis")));
        int size = entries.size();
        Ref.ObjectRef progressBarRenderer = new Ref.ObjectRef();
        BuildersKt.runBlocking$default(null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)1, null);
        if (!executor.isFinished()) {
            logger.warn(ForwardInterProceduralAnalysis::doAnalysis$lambda$8);
            executor.awaitCompletion(6000L, TimeUnit.SECONDS);
            logger.info(ForwardInterProceduralAnalysis::doAnalysis$lambda$9);
        }
        ProgressBarExt.DefaultProcessInfoRenderer defaultProcessInfoRenderer = (ProgressBarExt.DefaultProcessInfoRenderer)progressBarRenderer.element;
        if (defaultProcessInfoRenderer != null) {
            ProgressBarExt.DefaultProcessInfoRenderer $this$doAnalysis_u24lambda_u2411 = defaultProcessInfoRenderer;
            boolean bl = false;
            logger.warn(() -> ForwardInterProceduralAnalysis.doAnalysis$lambda$11$lambda$10($this$doAnalysis_u24lambda_u2411));
        }
        executor.interrupt();
        executor.shutdown();
        if (!this.getCache().validateAfterFinished() || UsefulMetrics.Companion.getMetrics().isMemoryThresholdTriggered()) {
            this.getCache().cleanUp();
        }
        System.gc();
        Thread.sleep(500L);
        logger.info(ForwardInterProceduralAnalysis::doAnalysis$lambda$12);
    }

    @Nullable
    public abstract Object normalFlowFunction(@NotNull CTX var1, N var2, N var3, A var4, @NotNull AtomicBoolean var5, @NotNull Continuation<? super A> var6);

    public A callLocalFlowFunction(@NotNull Context<SootMethod, Unit, A> context, @NotNull Unit node, @NotNull Unit succ, A callSiteValue) {
        Intrinsics.checkNotNullParameter(context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter((Object)succ, (String)"succ");
        return (A)this.bottomValue();
    }

    public abstract A callEntryFlowFunction(@NotNull CTX var1, M var2, N var3, N var4, A var5);

    @NotNull
    public abstract InvokeResult<M, A, R> callExitFlowFunction(@NotNull CTX var1, A var2, M var3, A var4, @NotNull CTX var5, N var6, N var7, boolean var8);

    @Nullable
    public Object returnFlowFunction(@NotNull CTX context, N node, A returnValue, @NotNull Continuation<? super A> $completion) {
        return ForwardInterProceduralAnalysis.returnFlowFunction$suspendImpl((ForwardInterProceduralAnalysis)this, context, node, returnValue, $completion);
    }

    static /* synthetic */ <M, N, A, R, CTX extends Context<M, N, A>> Object returnFlowFunction$suspendImpl(ForwardInterProceduralAnalysis<M, N, A, R, CTX> $this, CTX context, N node, A returnValue, Continuation<? super A> $completion) {
        return returnValue;
    }

    @Nullable
    public A wideningFunction(@NotNull CTX context, N node, N succ, A in) {
        Intrinsics.checkNotNullParameter(context, (String)"context");
        return null;
    }

    @NotNull
    public FixPointStatus hasChange(@NotNull CTX context, N node, N succ, A old, A a) {
        Intrinsics.checkNotNullParameter(context, (String)"context");
        FixPointStatus.Companion companion = FixPointStatus.Companion;
        boolean hasChange$iv = Intrinsics.areEqual(old, a);
        boolean $i$f$of = false;
        return hasChange$iv ? FixPointStatus.HasChange : FixPointStatus.Fixpoint;
    }

    public abstract boolean isAnalyzable(M var1, A var2);

    @NotNull
    public Set<M> resolveTargets(M callerMethod, N node) {
        return this.programRepresentation().getCalleesOfCallAt(callerMethod, node);
    }

    @NotNull
    public abstract DirectedGraph<N> getCfg(M var1, boolean var2);

    private static final wrapperCustom.1.1 wrapperCustom$lambda$0(ForwardInterProceduralAnalysis this$0, ProgressBar processBar, ProgressBarRenderer render) {
        Intrinsics.checkNotNullParameter((Object)processBar, (String)"processBar");
        Intrinsics.checkNotNullParameter((Object)render, (String)"render");
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    private static final Object[] init$lambda$1(Context it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Object[] objectArray = new Object[]{it};
        return objectArray;
    }

    private static final Object processCallCoroutine$lambda$3(Object $callee, Context $currentContext, Object $node) {
        return "skip recursive await " + $callee + " at " + $currentContext.getMethod() + ": at line " + $node;
    }

    private static final Object processCallCoroutine$lambda$4(Object $callee, Object $node, Context $currentContext) {
        return "An error occurred when analyzing callee method: " + $callee + " at " + $node + " in " + $currentContext.getMethod();
    }

    private static final Object doAnalyze$lambda$6(ForwardInterProceduralAnalysis this$0) {
        return "num threads: " + this$0.getNumberThreads();
    }

    private static final Object doAnalysis$lambda$8() {
        return "AIAnalysis: There are still tasks running in the executor. waiting ...";
    }

    private static final Object doAnalysis$lambda$9() {
        return "AIAnalysis: Done";
    }

    private static final Object doAnalysis$lambda$11$lambda$10(ProgressBarExt.DefaultProcessInfoRenderer $this_run) {
        return "Maximum memory usage: " + $this_run.getMaxUsedMemoryText() + " G";
    }

    private static final Object doAnalysis$lambda$12() {
        return "After Analyze: Process information: " + ProcessInfoView.Companion.getGlobalProcessInfo().getProcessInfoText();
    }

    private static final kotlin.Unit logger$lambda$13() {
        return kotlin.Unit.INSTANCE;
    }

    public ForwardInterProceduralAnalysis() {
        this(null, 1, null);
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }

    public static final /* synthetic */ AtomicInteger access$getTransformStmtTotalCount$p(ForwardInterProceduralAnalysis $this) {
        return $this.transformStmtTotalCount;
    }

    public static final /* synthetic */ boolean access$getLimitedAnalytics$p(ForwardInterProceduralAnalysis $this) {
        return $this.limitedAnalytics;
    }

    public static final /* synthetic */ Set access$getCurAnalysingMethods$p(ForwardInterProceduralAnalysis $this) {
        return $this.curAnalysingMethods;
    }
}

