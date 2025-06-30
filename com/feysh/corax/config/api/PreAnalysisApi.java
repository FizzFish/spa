/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.javaparser.Position
 *  com.github.javaparser.ast.nodeTypes.NodeWithRange
 *  de.fraunhofer.aisec.cpg.sarif.Region
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KCallable
 *  kotlinx.coroutines.Deferred
 *  kotlinx.coroutines.Job
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.jimple.toolkits.callgraph.CallGraph
 *  soot.tagkit.Host
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.AnalysisApi;
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
import com.feysh.corax.config.api.IPreAnalysisFieldConfig;
import com.feysh.corax.config.api.IPreAnalysisFileConfig;
import com.feysh.corax.config.api.IPreAnalysisInvokeConfig;
import com.feysh.corax.config.api.IPreAnalysisMethodConfig;
import com.feysh.corax.config.api.ISourceFileCheckPoint;
import com.feysh.corax.config.api.baseimpl.MatchUtilsKt;
import com.feysh.corax.config.api.report.Region;
import com.feysh.corax.config.api.utils.UtilsKt;
import com.github.javaparser.Position;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import java.io.File;
import java.nio.file.Path;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KCallable;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.tagkit.Host;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001mJ \u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r*\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\fH&J=\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u000f\"\u0004\b\u0000\u0010\r2\u001c\u0010\u0011\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H&R\u00020\u0010\u00a2\u0006\u0002\u0010\u0015J5\u0010\u0016\u001a\u00020\u0017\"\u0004\b\u0000\u0010\r2\u001c\u0010\u0011\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0016R\u00020\u0010\u00a2\u0006\u0002\u0010\u0018Ji\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001f2'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140 \u00a2\u0006\u0002\b\u001fH&R\u00020\u0010\u00a2\u0006\u0002\u0010\"Ja\u0010#\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001f2'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140 \u00a2\u0006\u0002\b\u001fH&R\u00020\u0010\u00a2\u0006\u0002\u0010$Ji\u0010%\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\u0006\u0010&\u001a\u00020'2\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001f2'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020)\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140 \u00a2\u0006\u0002\b\u001fH&R\u00020\u0010\u00a2\u0006\u0002\u0010*Jm\u0010%\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030+2\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001f2'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020)\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140 \u00a2\u0006\u0002\b\u001fH\u0016R\u00020\u0010\u00a2\u0006\u0002\u0010,Ja\u0010-\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001f2'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020)\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140 \u00a2\u0006\u0002\b\u001fH&R\u00020\u0010\u00a2\u0006\u0002\u0010$Ji\u0010.\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\u0006\u0010/\u001a\u0002002\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001f2'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u000202\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140 \u00a2\u0006\u0002\b\u001fH&R\u00020\u0010\u00a2\u0006\u0002\u00103JQ\u00104\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001f2\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002H\r0\u0012\u00a2\u0006\u0002\b\u001fH&R\u00020\u0010\u00a2\u0006\u0002\u00105Ji\u00106\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\u0006\u00107\u001a\u00020'2\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001f2'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u000209\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140 \u00a2\u0006\u0002\b\u001fH&R\u00020\u0010\u00a2\u0006\u0002\u0010*Jm\u00106\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\n\u00107\u001a\u0006\u0012\u0002\b\u00030+2\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001f2'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u000209\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140 \u00a2\u0006\u0002\b\u001fH\u0016R\u00020\u0010\u00a2\u0006\u0002\u0010,Ja\u0010:\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001f2'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u000209\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140 \u00a2\u0006\u0002\b\u001fH&R\u00020\u0010\u00a2\u0006\u0002\u0010$Jy\u0010;\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=2\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001f2'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020@\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140 \u00a2\u0006\u0002\b\u001fH&R\u00020\u0010\u00a2\u0006\u0002\u0010AJi\u0010B\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\u0006\u0010C\u001a\u00020\b2\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001f2'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020@\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140 \u00a2\u0006\u0002\b\u001fH&R\u00020\u0010\u00a2\u0006\u0002\u0010DJB\u0010E\u001a\u00020\u001e\"\f\b\u0000\u0010F*\u00020G*\u00020H*\u0002HF2\u0006\u0010I\u001a\u00020J2\u0019\b\u0002\u0010K\u001a\u0013\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001fH&\u00a2\u0006\u0002\u0010MJJ\u0010E\u001a\u00020\u001e\"\f\b\u0000\u0010F*\u00020G*\u00020H*\u0002HF2\u0006\u0010I\u001a\u00020J2\u0006\u0010N\u001a\u00020O2\u0019\b\u0002\u0010K\u001a\u0013\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001fH\u0016\u00a2\u0006\u0002\u0010PJ7\u0010E\u001a\u00020\u001e*\u00020@2\u0006\u0010I\u001a\u00020J2\u0006\u0010N\u001a\u00020O2\u0019\b\u0002\u0010K\u001a\u0013\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001fH\u0016J>\u0010E\u001a\u0004\u0018\u00010\u001e*\u00020@2\u0006\u0010I\u001a\u00020J2\u0006\u0010Q\u001a\u00020R2\u0019\b\u0002\u0010K\u001a\u0013\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001fH\u0016\u00a2\u0006\u0002\u0010SJH\u0010E\u001a\u0004\u0018\u00010\u001e*\u00020@2\u0006\u0010I\u001a\u00020J2\u0006\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010U2\u0019\b\u0002\u0010K\u001a\u0013\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001fH\u0016\u00a2\u0006\u0002\u0010WJB\u0010E\u001a\u0004\u0018\u00010\u001e*\u00020@2\u0006\u0010I\u001a\u00020J2\n\u0010X\u001a\u0006\u0012\u0002\b\u00030Y2\u0019\b\u0002\u0010K\u001a\u0013\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001fH\u0016\u00a2\u0006\u0002\u0010ZJ3\u0010E\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020J2\u0006\u0010[\u001a\u00020\\2\u0019\b\u0002\u0010K\u001a\u0013\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001fH&J=\u0010E\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020J2\u0006\u0010[\u001a\u00020\\2\b\u0010N\u001a\u0004\u0018\u00010O2\u0019\b\u0002\u0010K\u001a\u0013\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001fH\u0016J;\u0010E\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020J2\u0006\u0010]\u001a\u00020\b2\u0006\u0010N\u001a\u00020O2\u0019\b\u0002\u0010K\u001a\u0013\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001e0\u0012\u00a2\u0006\u0002\b\u001fH&J\u0018\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020=H&J\u001e\u0010a\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020=\u0018\u00010b2\u0006\u0010c\u001a\u00020\bH&J\u0018\u0010d\u001a\u00020e*\u00020\b2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\bH&J\u0018\u0010g\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010h2\u0006\u0010i\u001a\u00020=H&R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010j\u001a\u00020=*\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bk\u0010l\u00a8\u0006n"}, d2={"Lcom/feysh/corax/config/api/PreAnalysisApi;", "Lcom/feysh/corax/config/api/AnalysisApi;", "Lcom/feysh/corax/config/api/IAnalysisDepends;", "cg", "Lsoot/jimple/toolkits/callgraph/CallGraph;", "getCg", "()Lsoot/jimple/toolkits/callgraph/CallGraph;", "outputPath", "Ljava/nio/file/Path;", "getOutputPath", "()Ljava/nio/file/Path;", "nonNull", "Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "T", "runInSceneAsync", "Lkotlinx/coroutines/Deferred;", "Lcom/feysh/corax/config/api/CheckerUnit;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/feysh/corax/config/api/CheckerUnit;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Deferred;", "runInScene", "Lkotlinx/coroutines/Job;", "(Lcom/feysh/corax/config/api/CheckerUnit;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "atClass", "clazz", "Lcom/feysh/corax/config/api/IClassMatch;", "config", "Lcom/feysh/corax/config/api/IPreAnalysisClassConfig;", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/Function2;", "Lcom/feysh/corax/config/api/IClassCheckPoint;", "(Lcom/feysh/corax/config/api/CheckerUnit;Lcom/feysh/corax/config/api/IClassMatch;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "atAnyClass", "(Lcom/feysh/corax/config/api/CheckerUnit;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "atMethod", "method", "Lcom/feysh/corax/config/api/IMethodMatch;", "Lcom/feysh/corax/config/api/IPreAnalysisMethodConfig;", "Lcom/feysh/corax/config/api/IMethodCheckPoint;", "(Lcom/feysh/corax/config/api/CheckerUnit;Lcom/feysh/corax/config/api/IMethodMatch;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "Lkotlin/reflect/KCallable;", "(Lcom/feysh/corax/config/api/CheckerUnit;Lkotlin/reflect/KCallable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "atAnyMethod", "atField", "field", "Lcom/feysh/corax/config/api/IFieldMatch;", "Lcom/feysh/corax/config/api/IPreAnalysisFieldConfig;", "Lcom/feysh/corax/config/api/IFieldCheckPoint;", "(Lcom/feysh/corax/config/api/CheckerUnit;Lcom/feysh/corax/config/api/IFieldMatch;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "atAnyField", "(Lcom/feysh/corax/config/api/CheckerUnit;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "atInvoke", "callee", "Lcom/feysh/corax/config/api/IPreAnalysisInvokeConfig;", "Lcom/feysh/corax/config/api/IInvokeCheckPoint;", "atAnyInvoke", "atAnySourceFile", "extension", "", "filename", "Lcom/feysh/corax/config/api/IPreAnalysisFileConfig;", "Lcom/feysh/corax/config/api/ISourceFileCheckPoint;", "(Lcom/feysh/corax/config/api/CheckerUnit;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "atSourceFile", "path", "(Lcom/feysh/corax/config/api/CheckerUnit;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "report", "P", "Lcom/feysh/corax/config/api/ICheckPoint;", "Lcom/feysh/corax/config/api/INodeWithRange;", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "env", "Lcom/feysh/corax/config/api/BugMessage$Env;", "(Lcom/feysh/corax/config/api/ICheckPoint;Lcom/feysh/corax/config/api/CheckType;Lkotlin/jvm/functions/Function1;)V", "region", "Lcom/feysh/corax/config/api/report/Region;", "(Lcom/feysh/corax/config/api/ICheckPoint;Lcom/feysh/corax/config/api/CheckType;Lcom/feysh/corax/config/api/report/Region;Lkotlin/jvm/functions/Function1;)V", "cpgRegion", "Lde/fraunhofer/aisec/cpg/sarif/Region;", "(Lcom/feysh/corax/config/api/ISourceFileCheckPoint;Lcom/feysh/corax/config/api/CheckType;Lde/fraunhofer/aisec/cpg/sarif/Region;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "jpsStart", "Lcom/github/javaparser/Position;", "jpsEnd", "(Lcom/feysh/corax/config/api/ISourceFileCheckPoint;Lcom/feysh/corax/config/api/CheckType;Lcom/github/javaparser/Position;Lcom/github/javaparser/Position;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "regionNode", "Lcom/github/javaparser/ast/nodeTypes/NodeWithRange;", "(Lcom/feysh/corax/config/api/ISourceFileCheckPoint;Lcom/feysh/corax/config/api/CheckType;Lcom/github/javaparser/ast/nodeTypes/NodeWithRange;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "sootHost", "Lsoot/tagkit/Host;", "file", "archivePath", "archiveFile", "entry", "getZipEntry", "Lkotlin/Pair;", "innerFilePath", "getShadowFile", "Ljava/io/File;", "copyDest", "globPath", "", "glob", "fullCanonicalPathString", "getFullCanonicalPathString", "(Ljava/nio/file/Path;)Ljava/lang/String;", "Result", "corax-config-api"})
public interface PreAnalysisApi
extends AnalysisApi,
IAnalysisDepends {
    @NotNull
    public CallGraph getCg();

    @NotNull
    public Path getOutputPath();

    @NotNull
    public <T> Result<T> nonNull(@NotNull Result<T> var1);

    @NotNull
    public <T> Deferred<T> runInSceneAsync(@NotNull CheckerUnit var1, @NotNull Function1<? super Continuation<? super T>, ? extends Object> var2);

    @NotNull
    public <T> Job runInScene(@NotNull CheckerUnit var1, @NotNull Function1<? super Continuation<? super T>, ? extends Object> var2);

    @NotNull
    public <T> Result<T> atClass(@NotNull CheckerUnit var1, @NotNull IClassMatch var2, @NotNull Function1<? super IPreAnalysisClassConfig, Unit> var3, @NotNull Function2<? super IClassCheckPoint, ? super Continuation<? super T>, ? extends Object> var4);

    @NotNull
    public <T> Result<T> atAnyClass(@NotNull CheckerUnit var1, @NotNull Function1<? super IPreAnalysisClassConfig, Unit> var2, @NotNull Function2<? super IClassCheckPoint, ? super Continuation<? super T>, ? extends Object> var3);

    @NotNull
    public <T> Result<T> atMethod(@NotNull CheckerUnit var1, @NotNull IMethodMatch var2, @NotNull Function1<? super IPreAnalysisMethodConfig, Unit> var3, @NotNull Function2<? super IMethodCheckPoint, ? super Continuation<? super T>, ? extends Object> var4);

    @NotNull
    public <T> Result<T> atMethod(@NotNull CheckerUnit var1, @NotNull KCallable<?> var2, @NotNull Function1<? super IPreAnalysisMethodConfig, Unit> var3, @NotNull Function2<? super IMethodCheckPoint, ? super Continuation<? super T>, ? extends Object> var4);

    @NotNull
    public <T> Result<T> atAnyMethod(@NotNull CheckerUnit var1, @NotNull Function1<? super IPreAnalysisMethodConfig, Unit> var2, @NotNull Function2<? super IMethodCheckPoint, ? super Continuation<? super T>, ? extends Object> var3);

    @NotNull
    public <T> Result<T> atField(@NotNull CheckerUnit var1, @NotNull IFieldMatch var2, @NotNull Function1<? super IPreAnalysisFieldConfig, Unit> var3, @NotNull Function2<? super IFieldCheckPoint, ? super Continuation<? super T>, ? extends Object> var4);

    @NotNull
    public <T> Result<T> atAnyField(@NotNull CheckerUnit var1, @NotNull Function1<? super IPreAnalysisFieldConfig, Unit> var2, @NotNull Function1<? super IFieldCheckPoint, ? extends T> var3);

    @NotNull
    public <T> Result<T> atInvoke(@NotNull CheckerUnit var1, @NotNull IMethodMatch var2, @NotNull Function1<? super IPreAnalysisInvokeConfig, Unit> var3, @NotNull Function2<? super IInvokeCheckPoint, ? super Continuation<? super T>, ? extends Object> var4);

    @NotNull
    public <T> Result<T> atInvoke(@NotNull CheckerUnit var1, @NotNull KCallable<?> var2, @NotNull Function1<? super IPreAnalysisInvokeConfig, Unit> var3, @NotNull Function2<? super IInvokeCheckPoint, ? super Continuation<? super T>, ? extends Object> var4);

    @NotNull
    public <T> Result<T> atAnyInvoke(@NotNull CheckerUnit var1, @NotNull Function1<? super IPreAnalysisInvokeConfig, Unit> var2, @NotNull Function2<? super IInvokeCheckPoint, ? super Continuation<? super T>, ? extends Object> var3);

    @NotNull
    public <T> Result<T> atAnySourceFile(@NotNull CheckerUnit var1, @Nullable String var2, @Nullable String var3, @NotNull Function1<? super IPreAnalysisFileConfig, Unit> var4, @NotNull Function2<? super ISourceFileCheckPoint, ? super Continuation<? super T>, ? extends Object> var5);

    @NotNull
    public <T> Result<T> atSourceFile(@NotNull CheckerUnit var1, @NotNull Path var2, @NotNull Function1<? super IPreAnalysisFileConfig, Unit> var3, @NotNull Function2<? super ISourceFileCheckPoint, ? super Continuation<? super T>, ? extends Object> var4);

    public <P extends ICheckPoint & INodeWithRange> void report(@NotNull P var1, @NotNull CheckType var2, @NotNull Function1<? super BugMessage.Env, Unit> var3);

    public <P extends ICheckPoint & INodeWithRange> void report(@NotNull P var1, @NotNull CheckType var2, @NotNull Region var3, @NotNull Function1<? super BugMessage.Env, Unit> var4);

    public void report(@NotNull ISourceFileCheckPoint var1, @NotNull CheckType var2, @NotNull Region var3, @NotNull Function1<? super BugMessage.Env, Unit> var4);

    @Nullable
    public Unit report(@NotNull ISourceFileCheckPoint var1, @NotNull CheckType var2, @NotNull de.fraunhofer.aisec.cpg.sarif.Region var3, @NotNull Function1<? super BugMessage.Env, Unit> var4);

    @Nullable
    public Unit report(@NotNull ISourceFileCheckPoint var1, @NotNull CheckType var2, @NotNull Position var3, @Nullable Position var4, @NotNull Function1<? super BugMessage.Env, Unit> var5);

    @Nullable
    public Unit report(@NotNull ISourceFileCheckPoint var1, @NotNull CheckType var2, @NotNull NodeWithRange<?> var3, @NotNull Function1<? super BugMessage.Env, Unit> var4);

    public void report(@NotNull CheckType var1, @NotNull Host var2, @NotNull Function1<? super BugMessage.Env, Unit> var3);

    public void report(@NotNull CheckType var1, @NotNull Host var2, @Nullable Region var3, @NotNull Function1<? super BugMessage.Env, Unit> var4);

    public void report(@NotNull CheckType var1, @NotNull Path var2, @NotNull Region var3, @NotNull Function1<? super BugMessage.Env, Unit> var4);

    @NotNull
    public Path archivePath(@NotNull Path var1, @NotNull String var2);

    @Nullable
    public Pair<Path, String> getZipEntry(@NotNull Path var1);

    @NotNull
    public File getShadowFile(@NotNull Path var1, @Nullable Path var2);

    @Nullable
    public List<Path> globPath(@NotNull String var1);

    @NotNull
    public String getFullCanonicalPathString(@NotNull Path var1);

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    @SourceDebugExtension(value={"SMAP\nPreAnalysisApi.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreAnalysisApi.kt\ncom/feysh/corax/config/api/PreAnalysisApi$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,212:1\n1#2:213\n*E\n"})
    public static final class DefaultImpls {
        @NotNull
        public static <T> Job runInScene(@NotNull PreAnalysisApi $this, @NotNull CheckerUnit $context_receiver_0, @NotNull Function1<? super Continuation<? super T>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
            Intrinsics.checkNotNullParameter(block, (String)"block");
            return (Job)$this.runInSceneAsync($context_receiver_0, block);
        }

        public static /* synthetic */ Result atClass$default(PreAnalysisApi preAnalysisApi, CheckerUnit checkerUnit, IClassMatch iClassMatch, Function1 function1, Function2 function2, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: atClass");
            }
            if ((n & 4) != 0) {
                function1 = DefaultImpls::atClass$lambda$0;
            }
            return preAnalysisApi.atClass(checkerUnit, iClassMatch, (Function1<? super IPreAnalysisClassConfig, Unit>)function1, function2);
        }

        public static /* synthetic */ Result atAnyClass$default(PreAnalysisApi preAnalysisApi, CheckerUnit checkerUnit, Function1 function1, Function2 function2, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: atAnyClass");
            }
            if ((n & 2) != 0) {
                function1 = DefaultImpls::atAnyClass$lambda$1;
            }
            return preAnalysisApi.atAnyClass(checkerUnit, (Function1<? super IPreAnalysisClassConfig, Unit>)function1, function2);
        }

        public static /* synthetic */ Result atMethod$default(PreAnalysisApi preAnalysisApi, CheckerUnit checkerUnit, IMethodMatch iMethodMatch, Function1 function1, Function2 function2, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: atMethod");
            }
            if ((n & 4) != 0) {
                function1 = DefaultImpls::atMethod$lambda$2;
            }
            return preAnalysisApi.atMethod(checkerUnit, iMethodMatch, (Function1<? super IPreAnalysisMethodConfig, Unit>)function1, function2);
        }

        @NotNull
        public static <T> Result<T> atMethod(@NotNull PreAnalysisApi $this, @NotNull CheckerUnit $context_receiver_0, @NotNull KCallable<?> method, @NotNull Function1<? super IPreAnalysisMethodConfig, Unit> config, @NotNull Function2<? super IMethodCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
            Intrinsics.checkNotNullParameter(method, (String)"method");
            Intrinsics.checkNotNullParameter(config, (String)"config");
            Intrinsics.checkNotNullParameter(block, (String)"block");
            return $this.atMethod($context_receiver_0, MatchUtilsKt.matchSoot(UtilsKt.getSootSignature(method)), config, block);
        }

        public static /* synthetic */ Result atMethod$default(PreAnalysisApi preAnalysisApi, CheckerUnit checkerUnit, KCallable kCallable, Function1 function1, Function2 function2, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: atMethod");
            }
            if ((n & 4) != 0) {
                function1 = DefaultImpls::atMethod$lambda$3;
            }
            return preAnalysisApi.atMethod(checkerUnit, kCallable, (Function1<? super IPreAnalysisMethodConfig, Unit>)function1, function2);
        }

        public static /* synthetic */ Result atAnyMethod$default(PreAnalysisApi preAnalysisApi, CheckerUnit checkerUnit, Function1 function1, Function2 function2, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: atAnyMethod");
            }
            if ((n & 2) != 0) {
                function1 = DefaultImpls::atAnyMethod$lambda$4;
            }
            return preAnalysisApi.atAnyMethod(checkerUnit, (Function1<? super IPreAnalysisMethodConfig, Unit>)function1, function2);
        }

        public static /* synthetic */ Result atField$default(PreAnalysisApi preAnalysisApi, CheckerUnit checkerUnit, IFieldMatch iFieldMatch, Function1 function1, Function2 function2, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: atField");
            }
            if ((n & 4) != 0) {
                function1 = DefaultImpls::atField$lambda$5;
            }
            return preAnalysisApi.atField(checkerUnit, iFieldMatch, (Function1<? super IPreAnalysisFieldConfig, Unit>)function1, function2);
        }

        public static /* synthetic */ Result atAnyField$default(PreAnalysisApi preAnalysisApi, CheckerUnit checkerUnit, Function1 function1, Function1 function12, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: atAnyField");
            }
            if ((n & 2) != 0) {
                function1 = DefaultImpls::atAnyField$lambda$6;
            }
            return preAnalysisApi.atAnyField(checkerUnit, (Function1<? super IPreAnalysisFieldConfig, Unit>)function1, function12);
        }

        public static /* synthetic */ Result atInvoke$default(PreAnalysisApi preAnalysisApi, CheckerUnit checkerUnit, IMethodMatch iMethodMatch, Function1 function1, Function2 function2, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: atInvoke");
            }
            if ((n & 4) != 0) {
                function1 = DefaultImpls::atInvoke$lambda$7;
            }
            return preAnalysisApi.atInvoke(checkerUnit, iMethodMatch, (Function1<? super IPreAnalysisInvokeConfig, Unit>)function1, function2);
        }

        @NotNull
        public static <T> Result<T> atInvoke(@NotNull PreAnalysisApi $this, @NotNull CheckerUnit $context_receiver_0, @NotNull KCallable<?> callee, @NotNull Function1<? super IPreAnalysisInvokeConfig, Unit> config, @NotNull Function2<? super IInvokeCheckPoint, ? super Continuation<? super T>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter((Object)$context_receiver_0, (String)"$context_receiver_0");
            Intrinsics.checkNotNullParameter(callee, (String)"callee");
            Intrinsics.checkNotNullParameter(config, (String)"config");
            Intrinsics.checkNotNullParameter(block, (String)"block");
            return $this.atInvoke($context_receiver_0, MatchUtilsKt.matchSoot(UtilsKt.getSootSignature(callee)), config, block);
        }

        public static /* synthetic */ Result atInvoke$default(PreAnalysisApi preAnalysisApi, CheckerUnit checkerUnit, KCallable kCallable, Function1 function1, Function2 function2, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: atInvoke");
            }
            if ((n & 4) != 0) {
                function1 = DefaultImpls::atInvoke$lambda$8;
            }
            return preAnalysisApi.atInvoke(checkerUnit, kCallable, (Function1<? super IPreAnalysisInvokeConfig, Unit>)function1, function2);
        }

        public static /* synthetic */ Result atAnyInvoke$default(PreAnalysisApi preAnalysisApi, CheckerUnit checkerUnit, Function1 function1, Function2 function2, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: atAnyInvoke");
            }
            if ((n & 2) != 0) {
                function1 = DefaultImpls::atAnyInvoke$lambda$9;
            }
            return preAnalysisApi.atAnyInvoke(checkerUnit, (Function1<? super IPreAnalysisInvokeConfig, Unit>)function1, function2);
        }

        public static /* synthetic */ Result atAnySourceFile$default(PreAnalysisApi preAnalysisApi, CheckerUnit checkerUnit, String string, String string2, Function1 function1, Function2 function2, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: atAnySourceFile");
            }
            if ((n & 2) != 0) {
                string = null;
            }
            if ((n & 4) != 0) {
                string2 = null;
            }
            if ((n & 8) != 0) {
                function1 = DefaultImpls::atAnySourceFile$lambda$10;
            }
            return preAnalysisApi.atAnySourceFile(checkerUnit, string, string2, (Function1<? super IPreAnalysisFileConfig, Unit>)function1, function2);
        }

        public static /* synthetic */ Result atSourceFile$default(PreAnalysisApi preAnalysisApi, CheckerUnit checkerUnit, Path path, Function1 function1, Function2 function2, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: atSourceFile");
            }
            if ((n & 4) != 0) {
                function1 = DefaultImpls::atSourceFile$lambda$11;
            }
            return preAnalysisApi.atSourceFile(checkerUnit, path, (Function1<? super IPreAnalysisFileConfig, Unit>)function1, function2);
        }

        public static /* synthetic */ void report$default(PreAnalysisApi preAnalysisApi, ICheckPoint iCheckPoint, CheckType checkType, Function1 function1, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
            }
            if ((n & 2) != 0) {
                function1 = DefaultImpls::report$lambda$12;
            }
            preAnalysisApi.report(iCheckPoint, checkType, (Function1<? super BugMessage.Env, Unit>)function1);
        }

        public static <P extends ICheckPoint & INodeWithRange> void report(@NotNull PreAnalysisApi $this, @NotNull P $receiver, @NotNull CheckType checkType, @NotNull Region region, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
            Intrinsics.checkNotNullParameter((Object)region, (String)"region");
            Intrinsics.checkNotNullParameter(env, (String)"env");
            $this.report($receiver, checkType, (Function1<? super BugMessage.Env, Unit>)((Function1)arg_0 -> DefaultImpls.report$lambda$14(region, env, arg_0)));
        }

        public static /* synthetic */ void report$default(PreAnalysisApi preAnalysisApi, ICheckPoint iCheckPoint, CheckType checkType, Region region, Function1 function1, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
            }
            if ((n & 4) != 0) {
                function1 = DefaultImpls::report$lambda$13;
            }
            preAnalysisApi.report(iCheckPoint, checkType, region, (Function1<? super BugMessage.Env, Unit>)function1);
        }

        public static void report(@NotNull PreAnalysisApi $this, @NotNull ISourceFileCheckPoint $receiver, @NotNull CheckType checkType, @NotNull Region region, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
            Intrinsics.checkNotNullParameter((Object)region, (String)"region");
            Intrinsics.checkNotNullParameter(env, (String)"env");
            $this.report(checkType, $receiver.getPath(), region, env);
        }

        public static /* synthetic */ void report$default(PreAnalysisApi preAnalysisApi, ISourceFileCheckPoint iSourceFileCheckPoint, CheckType checkType, Region region, Function1 function1, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
            }
            if ((n & 4) != 0) {
                function1 = DefaultImpls::report$lambda$15;
            }
            preAnalysisApi.report(iSourceFileCheckPoint, checkType, region, (Function1<? super BugMessage.Env, Unit>)function1);
        }

        @Nullable
        public static Unit report(@NotNull PreAnalysisApi $this, @NotNull ISourceFileCheckPoint $receiver, @NotNull CheckType checkType, @NotNull de.fraunhofer.aisec.cpg.sarif.Region cpgRegion, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            Unit unit;
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
            Intrinsics.checkNotNullParameter((Object)cpgRegion, (String)"cpgRegion");
            Intrinsics.checkNotNullParameter(env, (String)"env");
            Region region = Region.Companion.invoke(cpgRegion);
            if (region != null) {
                Region it = region;
                boolean bl = false;
                $this.report($receiver, checkType, it, env);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            return unit;
        }

        public static /* synthetic */ Unit report$default(PreAnalysisApi preAnalysisApi, ISourceFileCheckPoint iSourceFileCheckPoint, CheckType checkType, de.fraunhofer.aisec.cpg.sarif.Region region, Function1 function1, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
            }
            if ((n & 4) != 0) {
                function1 = DefaultImpls::report$lambda$16;
            }
            return preAnalysisApi.report(iSourceFileCheckPoint, checkType, region, (Function1<? super BugMessage.Env, Unit>)function1);
        }

        @Nullable
        public static Unit report(@NotNull PreAnalysisApi $this, @NotNull ISourceFileCheckPoint $receiver, @NotNull CheckType checkType, @NotNull Position jpsStart, @Nullable Position jpsEnd, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            Unit unit;
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
            Intrinsics.checkNotNullParameter((Object)jpsStart, (String)"jpsStart");
            Intrinsics.checkNotNullParameter(env, (String)"env");
            Region region = Region.Companion.invoke(jpsStart, jpsEnd);
            if (region != null) {
                Region it = region;
                boolean bl = false;
                $this.report($receiver, checkType, it, env);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            return unit;
        }

        public static /* synthetic */ Unit report$default(PreAnalysisApi preAnalysisApi, ISourceFileCheckPoint iSourceFileCheckPoint, CheckType checkType, Position position, Position position2, Function1 function1, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
            }
            if ((n & 8) != 0) {
                function1 = DefaultImpls::report$lambda$18;
            }
            return preAnalysisApi.report(iSourceFileCheckPoint, checkType, position, position2, (Function1<? super BugMessage.Env, Unit>)function1);
        }

        @Nullable
        public static Unit report(@NotNull PreAnalysisApi $this, @NotNull ISourceFileCheckPoint $receiver, @NotNull CheckType checkType, @NotNull NodeWithRange<?> regionNode, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            Unit unit;
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
            Intrinsics.checkNotNullParameter(regionNode, (String)"regionNode");
            Intrinsics.checkNotNullParameter(env, (String)"env");
            Region region = Region.Companion.invoke(regionNode);
            if (region != null) {
                Region it = region;
                boolean bl = false;
                $this.report($receiver, checkType, it, env);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            return unit;
        }

        public static /* synthetic */ Unit report$default(PreAnalysisApi preAnalysisApi, ISourceFileCheckPoint iSourceFileCheckPoint, CheckType checkType, NodeWithRange nodeWithRange, Function1 function1, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
            }
            if ((n & 4) != 0) {
                function1 = DefaultImpls::report$lambda$20;
            }
            return preAnalysisApi.report(iSourceFileCheckPoint, checkType, nodeWithRange, (Function1<? super BugMessage.Env, Unit>)function1);
        }

        public static /* synthetic */ void report$default(PreAnalysisApi preAnalysisApi, CheckType checkType, Host host, Function1 function1, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
            }
            if ((n & 4) != 0) {
                function1 = DefaultImpls::report$lambda$22;
            }
            preAnalysisApi.report(checkType, host, (Function1<? super BugMessage.Env, Unit>)function1);
        }

        public static void report(@NotNull PreAnalysisApi $this, @NotNull CheckType checkType, @NotNull Host sootHost, @Nullable Region region, @NotNull Function1<? super BugMessage.Env, Unit> env) {
            Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
            Intrinsics.checkNotNullParameter((Object)sootHost, (String)"sootHost");
            Intrinsics.checkNotNullParameter(env, (String)"env");
            $this.report(checkType, sootHost, (Function1<? super BugMessage.Env, Unit>)((Function1)arg_0 -> DefaultImpls.report$lambda$24(region, env, arg_0)));
        }

        public static /* synthetic */ void report$default(PreAnalysisApi preAnalysisApi, CheckType checkType, Host host, Region region, Function1 function1, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
            }
            if ((n & 8) != 0) {
                function1 = DefaultImpls::report$lambda$23;
            }
            preAnalysisApi.report(checkType, host, region, (Function1<? super BugMessage.Env, Unit>)function1);
        }

        public static /* synthetic */ void report$default(PreAnalysisApi preAnalysisApi, CheckType checkType, Path path, Region region, Function1 function1, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
            }
            if ((n & 8) != 0) {
                function1 = DefaultImpls::report$lambda$25;
            }
            preAnalysisApi.report(checkType, path, region, (Function1<? super BugMessage.Env, Unit>)function1);
        }

        public static /* synthetic */ File getShadowFile$default(PreAnalysisApi preAnalysisApi, Path path, Path path2, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getShadowFile");
            }
            if ((n & 1) != 0) {
                path2 = null;
            }
            return preAnalysisApi.getShadowFile(path, path2);
        }

        private static Unit atClass$lambda$0(IPreAnalysisClassConfig iPreAnalysisClassConfig) {
            Intrinsics.checkNotNullParameter((Object)iPreAnalysisClassConfig, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit atAnyClass$lambda$1(IPreAnalysisClassConfig iPreAnalysisClassConfig) {
            Intrinsics.checkNotNullParameter((Object)iPreAnalysisClassConfig, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit atMethod$lambda$2(IPreAnalysisMethodConfig iPreAnalysisMethodConfig) {
            Intrinsics.checkNotNullParameter((Object)iPreAnalysisMethodConfig, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit atMethod$lambda$3(IPreAnalysisMethodConfig iPreAnalysisMethodConfig) {
            Intrinsics.checkNotNullParameter((Object)iPreAnalysisMethodConfig, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit atAnyMethod$lambda$4(IPreAnalysisMethodConfig iPreAnalysisMethodConfig) {
            Intrinsics.checkNotNullParameter((Object)iPreAnalysisMethodConfig, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit atField$lambda$5(IPreAnalysisFieldConfig iPreAnalysisFieldConfig) {
            Intrinsics.checkNotNullParameter((Object)iPreAnalysisFieldConfig, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit atAnyField$lambda$6(IPreAnalysisFieldConfig iPreAnalysisFieldConfig) {
            Intrinsics.checkNotNullParameter((Object)iPreAnalysisFieldConfig, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit atInvoke$lambda$7(IPreAnalysisInvokeConfig iPreAnalysisInvokeConfig) {
            Intrinsics.checkNotNullParameter((Object)iPreAnalysisInvokeConfig, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit atInvoke$lambda$8(IPreAnalysisInvokeConfig iPreAnalysisInvokeConfig) {
            Intrinsics.checkNotNullParameter((Object)iPreAnalysisInvokeConfig, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit atAnyInvoke$lambda$9(IPreAnalysisInvokeConfig iPreAnalysisInvokeConfig) {
            Intrinsics.checkNotNullParameter((Object)iPreAnalysisInvokeConfig, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit atAnySourceFile$lambda$10(IPreAnalysisFileConfig iPreAnalysisFileConfig) {
            Intrinsics.checkNotNullParameter((Object)iPreAnalysisFileConfig, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit atSourceFile$lambda$11(IPreAnalysisFileConfig iPreAnalysisFileConfig) {
            Intrinsics.checkNotNullParameter((Object)iPreAnalysisFileConfig, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit report$lambda$12(BugMessage.Env env) {
            Intrinsics.checkNotNullParameter((Object)env, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit report$lambda$13(BugMessage.Env env) {
            Intrinsics.checkNotNullParameter((Object)env, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit report$lambda$14(Region $region, Function1 $env, BugMessage.Env $this$report) {
            Intrinsics.checkNotNullParameter((Object)$this$report, (String)"$this$report");
            $this$report.setRegion($region.getMutable());
            $env.invoke((Object)$this$report);
            return Unit.INSTANCE;
        }

        private static Unit report$lambda$15(BugMessage.Env env) {
            Intrinsics.checkNotNullParameter((Object)env, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit report$lambda$16(BugMessage.Env env) {
            Intrinsics.checkNotNullParameter((Object)env, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit report$lambda$18(BugMessage.Env env) {
            Intrinsics.checkNotNullParameter((Object)env, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit report$lambda$20(BugMessage.Env env) {
            Intrinsics.checkNotNullParameter((Object)env, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit report$lambda$22(BugMessage.Env env) {
            Intrinsics.checkNotNullParameter((Object)env, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit report$lambda$23(BugMessage.Env env) {
            Intrinsics.checkNotNullParameter((Object)env, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit report$lambda$24(Region $region, Function1 $env, BugMessage.Env $this$report) {
            Intrinsics.checkNotNullParameter((Object)$this$report, (String)"$this$report");
            if ($region != null) {
                $this$report.setRegion($region.getMutable());
            }
            $env.invoke((Object)$this$report);
            return Unit.INSTANCE;
        }

        private static Unit report$lambda$25(BugMessage.Env env) {
            Intrinsics.checkNotNullParameter((Object)env, (String)"<this>");
            return Unit.INSTANCE;
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096@\u00a2\u0006\u0002\u0010\u0005R\u001e\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lcom/feysh/corax/config/api/PreAnalysisApi$Result;", "T", "", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asyncResult", "Lkotlinx/coroutines/Deferred;", "getAsyncResult", "()Lkotlinx/coroutines/Deferred;", "corax-config-api"})
    public static interface Result<T> {
        @Nullable
        public Object await(@NotNull Continuation<? super List<? extends T>> var1);

        @NotNull
        public Deferred<List<T>> getAsyncResult();

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @Nullable
            public static <T> Object await(@NotNull Result<T> $this, @NotNull Continuation<? super List<? extends T>> $completion) {
                return $this.getAsyncResult().await($completion);
            }
        }
    }
}

