/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ExtSettings
 *  cn.sast.api.config.StaticFieldTrackingMode
 *  cn.sast.api.util.OthersKt
 *  cn.sast.common.CustomRepeatingTimer
 *  cn.sast.dataflow.interprocedural.analysis.AJimpleInterProceduralAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.AJimpleInterProceduralAnalysis$Companion
 *  cn.sast.dataflow.interprocedural.analysis.AJimpleInterProceduralAnalysis$normalFlowFunction$1
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv
 *  cn.sast.dataflow.interprocedural.analysis.CallStackContext
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.FieldUtil
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IIFact
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IVGlobal
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorV
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorV$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.JSootFieldType
 *  cn.sast.idfa.analysis.Context
 *  cn.sast.idfa.analysis.ForwardInterProceduralAnalysis
 *  cn.sast.idfa.analysis.ForwardInterProceduralAnalysis$InvokeResult
 *  cn.sast.idfa.analysis.InterproceduralCFG
 *  cn.sast.idfa.analysis.ProcessInfoView
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.collections.immutable.ImmutableSet
 *  kotlinx.coroutines.Deferred
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.ArrayType
 *  soot.BooleanType
 *  soot.Context
 *  soot.G
 *  soot.Local
 *  soot.RefLikeType
 *  soot.RefType
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.Value
 *  soot.VoidType
 *  soot.jimple.AnyNewExpr
 *  soot.jimple.ArrayRef
 *  soot.jimple.BinopExpr
 *  soot.jimple.CastExpr
 *  soot.jimple.CaughtExceptionRef
 *  soot.jimple.Constant
 *  soot.jimple.DefinitionStmt
 *  soot.jimple.Expr
 *  soot.jimple.IdentityRef
 *  soot.jimple.IfStmt
 *  soot.jimple.InstanceFieldRef
 *  soot.jimple.InstanceInvokeExpr
 *  soot.jimple.InstanceOfExpr
 *  soot.jimple.IntConstant
 *  soot.jimple.InvokeExpr
 *  soot.jimple.NewArrayExpr
 *  soot.jimple.ParameterRef
 *  soot.jimple.ReturnStmt
 *  soot.jimple.ReturnVoidStmt
 *  soot.jimple.StaticFieldRef
 *  soot.jimple.Stmt
 *  soot.jimple.TableSwitchStmt
 *  soot.jimple.ThisRef
 *  soot.jimple.UnopExpr
 *  soot.jimple.infoflow.cfg.FlowDroidEssentialMethodTag
 *  soot.jimple.internal.JEqExpr
 *  soot.jimple.internal.JimpleLocal
 *  soot.tagkit.Tag
 *  soot.toolkits.graph.DirectedBodyGraph
 *  soot.toolkits.graph.DirectedGraph
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.api.config.ExtSettings;
import cn.sast.api.config.StaticFieldTrackingMode;
import cn.sast.api.util.OthersKt;
import cn.sast.common.CustomRepeatingTimer;
import cn.sast.dataflow.interprocedural.analysis.AJimpleInterProceduralAnalysis;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv;
import cn.sast.dataflow.interprocedural.analysis.CallStackContext;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.FieldUtil;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IIFact;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IVGlobal;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.JOperatorV;
import cn.sast.dataflow.interprocedural.analysis.JSootFieldType;
import cn.sast.idfa.analysis.ForwardInterProceduralAnalysis;
import cn.sast.idfa.analysis.InterproceduralCFG;
import cn.sast.idfa.analysis.ProcessInfoView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.collections.immutable.ImmutableSet;
import kotlinx.coroutines.Deferred;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;
import soot.BooleanType;
import soot.Context;
import soot.G;
import soot.Local;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.VoidType;
import soot.jimple.AnyNewExpr;
import soot.jimple.ArrayRef;
import soot.jimple.BinopExpr;
import soot.jimple.CastExpr;
import soot.jimple.CaughtExceptionRef;
import soot.jimple.Constant;
import soot.jimple.DefinitionStmt;
import soot.jimple.Expr;
import soot.jimple.IdentityRef;
import soot.jimple.IfStmt;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InstanceOfExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.NewArrayExpr;
import soot.jimple.ParameterRef;
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.TableSwitchStmt;
import soot.jimple.ThisRef;
import soot.jimple.UnopExpr;
import soot.jimple.infoflow.cfg.FlowDroidEssentialMethodTag;
import soot.jimple.internal.JEqExpr;
import soot.jimple.internal.JimpleLocal;
import soot.tagkit.Tag;
import soot.toolkits.graph.DirectedBodyGraph;
import soot.toolkits.graph.DirectedGraph;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 X*\u0004\b\u0000\u0010\u0001* \b\u0001\u0010\u0002*\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00060\u00032,\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\b\u0012\u0004\u0012\u0002H\u00020\u0007:\u0001XB\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u001f\u001a\u00020\fH\u0016J+\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00028\u00012\u0006\u0010#\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&\u00a2\u0006\u0002\u0010%J4\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&J(\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002J9\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\"\u001a\u00028\u00012\u0006\u0010#\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016\u00a2\u0006\u0002\u0010.J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J9\u00103\u001a\u00028\u00012\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u0005052\u0006\u00106\u001a\u00020\u00042\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u00108\u001a\u00020\u0014H\u0016\u00a2\u0006\u0002\u00109JB\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\"\u001a\u00028\u00012\u0006\u0010#\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u00101\u001a\u000202H\u0096@\u00a2\u0006\u0002\u0010;J \u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0004H\u0016JA\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\"\u001a\u00028\u00012\u0006\u0010>\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016\u00a2\u0006\u0002\u0010@Jq\u0010A\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0B2\u0006\u0010\"\u001a\u00028\u00012\u0006\u0010>\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u00108\u001a\u00020\u0014H\u0016\u00a2\u0006\u0002\u0010DJq\u0010E\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0B2\u0006\u0010\"\u001a\u00028\u00012\u0006\u0010>\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u00108\u001a\u00020\u0014H\u0016\u00a2\u0006\u0002\u0010DJy\u0010F\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0B2\u0006\u0010\"\u001a\u00028\u00012\f\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010>\u001a\u00020\u00042\f\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010H\u001a\u00028\u00012\u0006\u0010#\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0014H\u0016\u00a2\u0006\u0002\u0010IJ\u001e\u0010J\u001a\b\u0012\u0004\u0012\u00020\u0005052\u0006\u00106\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0014H\u0016J\u001e\u00108\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u00042\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J$\u0010L\u001a\u0002002\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00040N2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00040NH\u0016J.\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000\b*\b\u0012\u0004\u0012\u00028\u00000Q2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006Y"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/AJimpleInterProceduralAnalysis;", "V", "CTX", "Lcn/sast/idfa/analysis/Context;", "Lsoot/SootMethod;", "Lsoot/Unit;", "Lcn/sast/dataflow/interprocedural/analysis/IFact;", "Lcn/sast/idfa/analysis/ForwardInterProceduralAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "icfg", "Lcn/sast/idfa/analysis/InterproceduralCFG;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;Lcn/sast/idfa/analysis/InterproceduralCFG;)V", "getHf", "()Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "getIcfg", "()Lcn/sast/idfa/analysis/InterproceduralCFG;", "analyzeLibraryClasses", "", "getAnalyzeLibraryClasses", "()Z", "setAnalyzeLibraryClasses", "(Z)V", "needAnalyze", "Lkotlin/Function1;", "getNeedAnalyze", "()Lkotlin/jvm/functions/Function1;", "setNeedAnalyze", "(Lkotlin/jvm/functions/Function1;)V", "programRepresentation", "newExprEnv", "Lcn/sast/dataflow/interprocedural/analysis/AnyNewExprEnv;", "context", "node", "inValue", "(Lcn/sast/idfa/analysis/Context;Lsoot/Unit;Lcn/sast/dataflow/interprocedural/analysis/IFact;)Lcn/sast/dataflow/interprocedural/analysis/AnyNewExprEnv;", "resolveTargets", "", "callerMethod", "ie", "Lsoot/jimple/InvokeExpr;", "resolveClinit", "normalFlowUnAccessibleFunction", "succ", "(Lcn/sast/idfa/analysis/Context;Lsoot/Unit;Lsoot/Unit;Lcn/sast/dataflow/interprocedural/analysis/IFact;)Lcn/sast/dataflow/interprocedural/analysis/IFact;", "shutDownAnalyze", "", "isNegativeBranch", "Ljava/util/concurrent/atomic/AtomicBoolean;", "newContext", "cfg", "Lsoot/toolkits/graph/DirectedGraph;", "method", "entryValue", "isAnalyzable", "(Lsoot/toolkits/graph/DirectedGraph;Lsoot/SootMethod;Lcn/sast/dataflow/interprocedural/analysis/IFact;Z)Lcn/sast/idfa/analysis/Context;", "normalFlowFunction", "(Lcn/sast/idfa/analysis/Context;Lsoot/Unit;Lsoot/Unit;Lcn/sast/dataflow/interprocedural/analysis/IFact;Ljava/util/concurrent/atomic/AtomicBoolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDummyComponentInvoke", "container", "callee", "callEntryFlowFunction", "(Lcn/sast/idfa/analysis/Context;Lsoot/SootMethod;Lsoot/Unit;Lsoot/Unit;Lcn/sast/dataflow/interprocedural/analysis/IFact;)Lcn/sast/dataflow/interprocedural/analysis/IFact;", "recursiveCallFlowFunction", "Lcn/sast/idfa/analysis/ForwardInterProceduralAnalysis$InvokeResult;", "siteValue", "(Lcn/sast/idfa/analysis/Context;Lsoot/SootMethod;Lsoot/Unit;Lsoot/Unit;Lcn/sast/dataflow/interprocedural/analysis/IFact;Lcn/sast/dataflow/interprocedural/analysis/IFact;Z)Lcn/sast/idfa/analysis/ForwardInterProceduralAnalysis$InvokeResult;", "failedInvokeResult", "callExitFlowFunction", "callEdgeValue", "calleeCtx", "(Lcn/sast/idfa/analysis/Context;Lcn/sast/dataflow/interprocedural/analysis/IFact;Lsoot/SootMethod;Lcn/sast/dataflow/interprocedural/analysis/IFact;Lcn/sast/idfa/analysis/Context;Lsoot/Unit;Lsoot/Unit;Z)Lcn/sast/idfa/analysis/ForwardInterProceduralAnalysis$InvokeResult;", "getCfg", "in1", "doAnalysis", "entries", "", "methodsMustAnalyze", "resolveExpr", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "expr", "Lsoot/jimple/Expr;", "resType", "Lsoot/Type;", "Companion", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nAJimpleInterProceduralAnalysis.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AJimpleInterProceduralAnalysis.kt\ncn/sast/dataflow/interprocedural/analysis/AJimpleInterProceduralAnalysis\n+ 2 SootUtils.kt\ncn/sast/api/util/SootUtilsKt\n+ 3 IFact.kt\ncn/sast/dataflow/interprocedural/analysis/FieldUtil\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,859:1\n333#2,6:860\n333#2,6:870\n44#3:866\n44#3:867\n44#3:868\n44#3:869\n44#3:876\n1755#4,3:877\n*S KotlinDebug\n*F\n+ 1 AJimpleInterProceduralAnalysis.kt\ncn/sast/dataflow/interprocedural/analysis/AJimpleInterProceduralAnalysis\n*L\n267#1:860,6\n586#1:870,6\n432#1:866\n442#1:867\n492#1:868\n499#1:869\n608#1:876\n768#1:877,3\n*E\n"})
public abstract class AJimpleInterProceduralAnalysis<V, CTX extends cn.sast.idfa.analysis.Context<SootMethod, Unit, IFact<V>>>
extends ForwardInterProceduralAnalysis<SootMethod, Unit, IFact<V>, IHeapValues<V>, CTX> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final AbstractHeapFactory<V> hf;
    @NotNull
    private final InterproceduralCFG icfg;
    private boolean analyzeLibraryClasses;
    @Nullable
    private Function1<? super SootMethod, Boolean> needAnalyze;
    @NotNull
    private static KLogger logger = KotlinLogging.INSTANCE.logger(AJimpleInterProceduralAnalysis::logger$lambda$13);

    public AJimpleInterProceduralAnalysis(@NotNull AbstractHeapFactory<V> hf, @NotNull InterproceduralCFG icfg) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)icfg, (String)"icfg");
        super(null, 1, null);
        this.hf = hf;
        this.icfg = icfg;
        this.analyzeLibraryClasses = true;
    }

    @NotNull
    public final AbstractHeapFactory<V> getHf() {
        return this.hf;
    }

    @NotNull
    public final InterproceduralCFG getIcfg() {
        return this.icfg;
    }

    public final boolean getAnalyzeLibraryClasses() {
        return this.analyzeLibraryClasses;
    }

    public final void setAnalyzeLibraryClasses(boolean bl) {
        this.analyzeLibraryClasses = bl;
    }

    @Nullable
    public final Function1<SootMethod, Boolean> getNeedAnalyze() {
        return this.needAnalyze;
    }

    public final void setNeedAnalyze(@Nullable Function1<? super SootMethod, Boolean> function1) {
        this.needAnalyze = function1;
    }

    @NotNull
    public InterproceduralCFG programRepresentation() {
        return this.icfg;
    }

    @NotNull
    public abstract AnyNewExprEnv newExprEnv(@NotNull CTX var1, @NotNull Unit var2, @NotNull IFact<V> var3);

    @NotNull
    public abstract Set<SootMethod> resolveTargets(@NotNull SootMethod var1, @NotNull InvokeExpr var2, @NotNull Unit var3, @NotNull IFact<V> var4);

    private final SootMethod resolveClinit(SootMethod callerMethod, Unit node, IFact<V> inValue) {
        if (inValue.isBottom()) {
            return null;
        }
        Intrinsics.checkNotNull((Object)node, (String)"null cannot be cast to non-null type soot.jimple.Stmt");
        Stmt stmt = (Stmt)node;
        if (!(stmt instanceof DefinitionStmt)) {
            return null;
        }
        SootMethod ret = null;
        Value value = ((DefinitionStmt)stmt).getLeftOp();
        Intrinsics.checkNotNullExpressionValue((Object)value, (String)"getLeftOp(...)");
        Value lhsOp = value;
        Value value2 = ((DefinitionStmt)stmt).getRightOp();
        Intrinsics.checkNotNullExpressionValue((Object)value2, (String)"getRightOp(...)");
        Value rhsOp = value2;
        StaticFieldRef staticReference = null;
        if (lhsOp instanceof StaticFieldRef) {
            staticReference = (StaticFieldRef)lhsOp;
        } else if (rhsOp instanceof StaticFieldRef) {
            staticReference = (StaticFieldRef)rhsOp;
        }
        if (staticReference != null) {
            SootClass sootClass = staticReference.getField().getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
            SootClass declaringClass = sootClass;
            if (declaringClass.isLibraryClass()) {
                Iterator iterator2 = declaringClass.getFields().iterator();
                Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"iterator(...)");
                Iterator iterator3 = iterator2;
                while (iterator3.hasNext()) {
                    SootField field = (SootField)iterator3.next();
                    if (!field.isStatic() || !(field.getType() instanceof RefLikeType)) continue;
                }
            }
            if (declaringClass.declaresMethodByName("<clinit>")) {
                SootMethod sootMethod = declaringClass.getMethodByName("<clinit>");
                Intrinsics.checkNotNullExpressionValue((Object)sootMethod, (String)"getMethodByName(...)");
                SootMethod clinit = sootMethod;
                ImmutableSet clinitCalled = inValue.getCalledMethods();
                if (!clinitCalled.contains((Object)clinit)) {
                    ret = clinit;
                }
            }
        }
        if (Intrinsics.areEqual(ret, (Object)callerMethod)) {
            ret = null;
        }
        return ret;
    }

    @NotNull
    public IFact<V> normalFlowUnAccessibleFunction(@NotNull CTX context, @NotNull Unit node, @NotNull Unit succ, @NotNull IFact<V> inValue) {
        Intrinsics.checkNotNullParameter(context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter((Object)succ, (String)"succ");
        Intrinsics.checkNotNullParameter(inValue, (String)"inValue");
        if (node instanceof ReturnStmt || node instanceof ReturnVoidStmt) {
            IFact.Builder out = inValue.builder();
            SootMethod method = (SootMethod)context.getMethod();
            if (!method.isStatic()) {
                out.summarizeTargetFields((Object)-1);
            }
            int n = method.getParameterCount();
            for (int i = 0; i < n; ++i) {
                out.summarizeTargetFields((Object)i);
            }
            if (!(method.getReturnType() instanceof VoidType)) {
                HeapValuesEnv env = this.hf.env(node);
                Type type = method.getReturnType();
                Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getReturnType(...)");
                IHeapValues iHeapValues = this.hf.push(env, this.hf.newSummaryVal(env, type, (Object)"return")).markSummaryReturnValueInCalleeSite().popHV();
                if (method.getReturnType() instanceof RefType) {
                    iHeapValues = iHeapValues.plus(this.hf.push(env, this.hf.getNullConst()).markSummaryReturnValueInCalleeSite().popHV());
                }
                IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)out, (HeapValuesEnv)env, (Object)this.hf.getVg().getRETURN_LOCAL(), (IHeapValues)iHeapValues, (boolean)false, (int)8, null);
            }
            return out.build();
        }
        return inValue;
    }

    public void shutDownAnalyze(@NotNull AtomicBoolean isNegativeBranch) {
        Intrinsics.checkNotNullParameter((Object)isNegativeBranch, (String)"isNegativeBranch");
    }

    @NotNull
    public CTX newContext(@NotNull DirectedGraph<Unit> cfg, @NotNull SootMethod method, @NotNull IFact<V> entryValue, boolean isAnalyzable) {
        Intrinsics.checkNotNullParameter(cfg, (String)"cfg");
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Intrinsics.checkNotNullParameter(entryValue, (String)"entryValue");
        cn.sast.idfa.analysis.Context ctx2 = super.newContext(cfg, (Object)method, entryValue, isAnalyzable);
        if (logger.isTraceEnabled()) {
            logger.trace(() -> AJimpleInterProceduralAnalysis.newContext$lambda$0(method));
            logger.trace(() -> AJimpleInterProceduralAnalysis.newContext$lambda$1(method));
        }
        if (ctx2.getPathSensitiveEnable() && OthersKt.getSkipPathSensitive((SootMethod)method)) {
            ctx2.setPathSensitiveEnable(false);
        }
        return (CTX)ctx2;
    }

    @Nullable
    public Object normalFlowFunction(@NotNull CTX context, @NotNull Unit node, @NotNull Unit succ, @NotNull IFact<V> inValue, @NotNull AtomicBoolean isNegativeBranch, @NotNull Continuation<? super IFact<V>> $completion) {
        return AJimpleInterProceduralAnalysis.normalFlowFunction$suspendImpl((AJimpleInterProceduralAnalysis)this, context, (Unit)node, (Unit)succ, inValue, (AtomicBoolean)isNegativeBranch, $completion);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    static /* synthetic */ <V, CTX extends cn.sast.idfa.analysis.Context<SootMethod, Unit, IFact<V>>> Object normalFlowFunction$suspendImpl(AJimpleInterProceduralAnalysis<V, CTX> var0, CTX var1_1, Unit var2_2, Unit var3_3, IFact<V> var4_4, AtomicBoolean var5_5, Continuation<? super IFact<V>> $completion) {
        block77: {
            block87: {
                block82: {
                    block86: {
                        block83: {
                            block84: {
                                block85: {
                                    block81: {
                                        block80: {
                                            block79: {
                                                block78: {
                                                    block76: {
                                                        block73: {
                                                            block74: {
                                                                block75: {
                                                                    if (!($completion instanceof normalFlowFunction.1)) ** GOTO lbl-1000
                                                                    var29_7 = $completion;
                                                                    if ((var29_7.label & -2147483648) != 0) {
                                                                        var29_7.label -= -2147483648;
                                                                    } else lbl-1000:
                                                                    // 2 sources

                                                                    {
                                                                        $continuation = new /* Unavailable Anonymous Inner Class!! */;
                                                                    }
                                                                    $result = $continuation.result;
                                                                    var30_9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                    switch ($continuation.label) {
                                                                        case 0: {
                                                                            ResultKt.throwOnFailure((Object)$result);
                                                                            if (inValue.isBottom()) {
                                                                                return inValue;
                                                                            }
                                                                            env = $this.hf.env(node);
                                                                            Intrinsics.checkNotNull((Object)node, (String)"null cannot be cast to non-null type soot.jimple.Stmt");
                                                                            stmt = (Stmt)node;
                                                                            out = new Ref.ObjectRef();
                                                                            out.element = inValue.builder();
                                                                            if (stmt instanceof ReturnStmt) {
                                                                                op = ((ReturnStmt)stmt).getOp();
                                                                                lhs = $this.hf.getVg().getRETURN_LOCAL();
                                                                                if (op instanceof Local) {
                                                                                    ((IFact.Builder)out.element).assignLocal(env, (Object)lhs, (Object)op);
                                                                                } else if (op instanceof Constant) {
                                                                                    $this$accurateType$iv = (Constant)op;
                                                                                    $i$f$accurateType = false;
                                                                                    it$iv = $this$accurateType$iv.getType();
                                                                                    $i$a$-let-SootUtilsKt$accurateType$1$iv = false;
                                                                                    if (it$iv instanceof RefLikeType) {
                                                                                        v0 = it$iv;
                                                                                    } else {
                                                                                        $i$a$-accurateType-AJimpleInterProceduralAnalysis$normalFlowFunction$type$1 = false;
                                                                                        v1 = ((SootMethod)context.getMethod()).getReturnType();
                                                                                        v0 = v1;
                                                                                        Intrinsics.checkNotNullExpressionValue((Object)v1, (String)"getReturnType(...)");
                                                                                    }
                                                                                    type = v0;
                                                                                    IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)((IFact.Builder)out.element), (HeapValuesEnv)env, (Object)lhs, (IHeapValues)JOperatorV.DefaultImpls.markOfConstant$default((JOperatorV)$this.hf.push(env, $this.hf.newConstVal((Constant)op, (Type)type)), (Constant)((Constant)op), null, (int)2, null).popHV(), (boolean)false, (int)8, null);
                                                                                } else {
                                                                                    throw new RuntimeException(op.toString());
                                                                                }
                                                                            }
                                                                            if (!(stmt instanceof ReturnStmt) && !(stmt instanceof ReturnVoidStmt)) break;
                                                                            $continuation.label = 1;
                                                                            v2 = $this.returnFlowFunction(context, (Object)node, (Object)((IFact.Builder)out.element).build(), (Continuation)$continuation);
                                                                            if (v2 == var30_9) {
                                                                                return var30_9;
                                                                            }
                                                                            ** GOTO lbl52
                                                                        }
                                                                        case 1: {
                                                                            ResultKt.throwOnFailure((Object)$result);
                                                                            v2 = $result;
lbl52:
                                                                            // 2 sources

                                                                            return v2;
                                                                        }
                                                                    }
                                                                    if (stmt instanceof IfStmt) {
                                                                        cond = ((IfStmt)stmt).getCondition();
                                                                        if (cond instanceof Local) {
                                                                            v3 = ((IFact.Builder)out.element).getTargets((Object)cond);
                                                                        } else if (cond instanceof Constant) {
                                                                            v4 = $this.hf;
                                                                            v5 = $this.hf;
                                                                            v6 = (Constant)cond;
                                                                            v7 = G.v().soot_BooleanType();
                                                                            Intrinsics.checkNotNullExpressionValue((Object)v7, (String)"soot_BooleanType(...)");
                                                                            v3 = JOperatorV.DefaultImpls.markOfConstant$default((JOperatorV)v4.push(env, v5.newConstVal(v6, (Type)v7)), (Constant)((Constant)cond), null, (int)2, null).popHV();
                                                                        } else if (cond instanceof Expr) {
                                                                            v8 = (IFact.Builder)out.element;
                                                                            v9 = (Expr)cond;
                                                                            type = G.v().soot_BooleanType();
                                                                            Intrinsics.checkNotNullExpressionValue((Object)type, (String)"soot_BooleanType(...)");
                                                                            v3 = $this.resolveExpr(v8, env, v9, (Type)type);
                                                                        } else {
                                                                            throw new RuntimeException(cond.toString());
                                                                        }
                                                                        condition = v3;
                                                                        v10 = isTrue = condition.isSingle() != false ? AbstractHeapFactory.getBooleanValue$default((AbstractHeapFactory)$this.hf, (Object)condition.getSingle().getValue(), (boolean)false, (int)2, null) : null;
                                                                        if (isTrue != null) {
                                                                            v11 = isTrue == false ? Intrinsics.areEqual((Object)((IfStmt)stmt).getTarget(), (Object)succ) : (negativeBranch = Intrinsics.areEqual((Object)((IfStmt)stmt).getTarget(), (Object)succ) == false);
                                                                            if (negativeBranch) {
                                                                                isNegativeBranch.set(true);
                                                                            }
                                                                        }
                                                                    }
                                                                    if (stmt instanceof TableSwitchStmt) {
                                                                        $this$normalFlowFunction_u24lambda_u243 = (TableSwitchStmt)stmt;
                                                                        $i$a$-with-AJimpleInterProceduralAnalysis$normalFlowFunction$2 = false;
                                                                        key = $this$normalFlowFunction_u24lambda_u243.getKeyBox().getValue();
                                                                        if (key instanceof Local) {
                                                                            v12 = ((IFact.Builder)out.element).getTargets((Object)key);
                                                                        } else if (key instanceof Constant) {
                                                                            v13 = $this.hf;
                                                                            v14 = $this.hf;
                                                                            v15 = (Constant)key;
                                                                            v16 = ((Constant)key).getType();
                                                                            Intrinsics.checkNotNullExpressionValue((Object)v16, (String)"getType(...)");
                                                                            v12 = JOperatorV.DefaultImpls.markOfConstant$default((JOperatorV)v13.push(env, v14.newConstVal(v15, v16)), (Constant)((Constant)key), null, (int)2, null).popHV();
                                                                        } else if (key instanceof Expr) {
                                                                            v17 = (IFact.Builder)out.element;
                                                                            v18 = (Expr)key;
                                                                            v19 = ((Expr)key).getType();
                                                                            Intrinsics.checkNotNullExpressionValue((Object)v19, (String)"getType(...)");
                                                                            v12 = $this.resolveExpr(v17, env, v18, v19);
                                                                        } else {
                                                                            throw new RuntimeException(key.toString());
                                                                        }
                                                                        keyValue = v12;
                                                                        low = $this$normalFlowFunction_u24lambda_u243.getLowIndex();
                                                                        high = $this$normalFlowFunction_u24lambda_u243.getHighIndex();
                                                                        cases = new LinkedHashSet<E>();
                                                                        for (i = low; i < high; ++i) {
                                                                            Intrinsics.checkNotNullExpressionValue((Object)((TableSwitchStmt)stmt).getTarget(i - low), (String)"getTarget(...)");
                                                                            v20 = targetNode = target == $this$normalFlowFunction_u24lambda_u243 ? node : target;
                                                                            if (!Intrinsics.areEqual((Object)targetNode, (Object)succ)) continue;
                                                                            cases.add(Boxing.boxInt((int)i));
                                                                        }
                                                                        target = $this$normalFlowFunction_u24lambda_u243.getTarget(high - low);
                                                                        v21 /* !! */  = targetNode = target == $this$normalFlowFunction_u24lambda_u243 ? node : target;
                                                                        if (Intrinsics.areEqual((Object)targetNode, (Object)succ)) {
                                                                            cases.add(Boxing.boxInt((int)high));
                                                                        }
                                                                        if (((Collection)cases).isEmpty() == false) {
                                                                            b = $this.hf.emptyBuilder();
                                                                            var21_60 = cases.iterator();
                                                                            while (var21_60.hasNext()) {
                                                                                case = ((Number)var21_60.next()).intValue();
                                                                                constantCase = IntConstant.v((int)case);
                                                                                v22 = $this.hf;
                                                                                v23 = $this.hf;
                                                                                Intrinsics.checkNotNull((Object)constantCase);
                                                                                v24 = (Constant)constantCase;
                                                                                v25 = G.v().soot_IntType();
                                                                                Intrinsics.checkNotNullExpressionValue((Object)v25, (String)"soot_IntType(...)");
                                                                                caseValue = JOperatorV.DefaultImpls.markOfConstant$default((JOperatorV)v22.push(env, v23.newConstVal(v24, (Type)v25)), (Constant)((Constant)constantCase), null, (int)2, null).popHV();
                                                                                b.add(caseValue);
                                                                            }
                                                                            isEquality = AJimpleInterProceduralAnalysis.normalFlowFunction$lambda$3$check((AJimpleInterProceduralAnalysis)$this, (HeapValuesEnv)env, (Ref.ObjectRef)out, (IHeapValues)keyValue, (Value)key, (IHeapValues)b.build());
                                                                            if (Intrinsics.areEqual((Object)isEquality, (Object)Boxing.boxBoolean((boolean)false))) {
                                                                                isNegativeBranch.set(true);
                                                                            }
                                                                        }
                                                                        v26 = defaultTargetNode = $this$normalFlowFunction_u24lambda_u243.getDefaultTarget() == $this$normalFlowFunction_u24lambda_u243 ? node : $this$normalFlowFunction_u24lambda_u243.getDefaultTarget();
                                                                        if (Intrinsics.areEqual((Object)defaultTargetNode, (Object)succ)) {
                                                                            case = high + 1;
                                                                            for (case = low; case < case; ++case) {
                                                                                constantCase = IntConstant.v((int)case);
                                                                                v27 = $this.hf;
                                                                                v28 = $this.hf;
                                                                                Intrinsics.checkNotNull((Object)constantCase);
                                                                                v29 = (Constant)constantCase;
                                                                                v30 = G.v().soot_IntType();
                                                                                Intrinsics.checkNotNullExpressionValue((Object)v30, (String)"soot_IntType(...)");
                                                                                caseValue = JOperatorV.DefaultImpls.markOfConstant$default((JOperatorV)v27.push(env, v28.newConstVal(v29, (Type)v30)), (Constant)((Constant)constantCase), null, (int)2, null).popHV();
                                                                                isEquality = AJimpleInterProceduralAnalysis.normalFlowFunction$lambda$3$check((AJimpleInterProceduralAnalysis)$this, (HeapValuesEnv)env, (Ref.ObjectRef)out, (IHeapValues)keyValue, (Value)key, (IHeapValues)caseValue);
                                                                                if (!Intrinsics.areEqual((Object)isEquality, (Object)Boxing.boxBoolean((boolean)true))) continue;
                                                                                isNegativeBranch.set(true);
                                                                            }
                                                                        }
                                                                    }
                                                                    if (!stmt.containsInvokeExpr()) break block73;
                                                                    ie = stmt.getInvokeExpr();
                                                                    v31 = (SootMethod)context.getMethod();
                                                                    Intrinsics.checkNotNull((Object)ie);
                                                                    callees = $this.resolveTargets(v31, ie, node, (IFact)inValue);
                                                                    if (!(((Collection)callees).isEmpty() == false)) break block74;
                                                                    localValue = (IFact)$this.callLocalFlowFunction(context, node, (Unit)succ, (Object)inValue);
                                                                    if (Intrinsics.areEqual((Object)localValue, (Object)$this.bottomValue())) break block75;
                                                                    out.element = localValue.builder();
                                                                    break block74;
                                                                }
                                                                invokeFold = (IFact)$this.bottomValue();
                                                                $continuation.L$0 = $this;
                                                                $continuation.L$1 = env;
                                                                $continuation.L$2 = stmt;
                                                                $continuation.L$3 = out;
                                                                $continuation.L$4 = invokeFold;
                                                                $continuation.label = 2;
                                                                v32 = $this.processAndReturnResult(context, (Object)node, (Object)succ, callees, (Object)inValue, (Continuation)$continuation);
                                                                if (v32 == var30_9) {
                                                                    return var30_9;
                                                                }
                                                                ** GOTO lbl184
                                                                {
                                                                    case 2: {
                                                                        invokeFold = (IFact)$continuation.L$4;
                                                                        out = (Ref.ObjectRef)$continuation.L$3;
                                                                        stmt = (Stmt)$continuation.L$2;
                                                                        env = (HeapValuesEnv)$continuation.L$1;
                                                                        $this = (AJimpleInterProceduralAnalysis)$continuation.L$0;
                                                                        ResultKt.throwOnFailure((Object)$result);
                                                                        v32 = $result;
lbl184:
                                                                        // 2 sources

                                                                        keyValue = ((Map)v32).entrySet().iterator();
lbl185:
                                                                        // 2 sources

                                                                        while (keyValue.hasNext()) {
                                                                            low = keyValue.next();
                                                                            callee2 = (SootMethod)low.getKey();
                                                                            calleeOut = (Deferred)low.getValue();
                                                                            $continuation.L$0 = $this;
                                                                            $continuation.L$1 = env;
                                                                            $continuation.L$2 = stmt;
                                                                            $continuation.L$3 = out;
                                                                            $continuation.L$4 = invokeFold;
                                                                            $continuation.L$5 = keyValue;
                                                                            $continuation.L$6 = callee2;
                                                                            $continuation.label = 3;
                                                                            v33 = calleeOut.await((Continuation)$continuation);
                                                                            if (v33 == var30_9) {
                                                                                return var30_9;
                                                                            }
                                                                            ** GOTO lbl212
                                                                        }
                                                                        break;
                                                                    }
                                                                    case 3: {
                                                                        callee2 = (SootMethod)$continuation.L$6;
                                                                        keyValue = (Iterator<Map.Entry<K, V>>)$continuation.L$5;
                                                                        invokeFold = (IFact)$continuation.L$4;
                                                                        out = (Ref.ObjectRef)$continuation.L$3;
                                                                        stmt = (Stmt)$continuation.L$2;
                                                                        env = (HeapValuesEnv)$continuation.L$1;
                                                                        $this = (AJimpleInterProceduralAnalysis)$continuation.L$0;
                                                                        ResultKt.throwOnFailure((Object)$result);
                                                                        v33 = $result;
lbl212:
                                                                        // 2 sources

                                                                        target = (ForwardInterProceduralAnalysis.InvokeResult)v33;
                                                                        callee = (SootMethod)target.component1();
                                                                        invokeOut = (IFact)target.component2();
                                                                        resultValue = (IHeapValues)target.component3();
                                                                        if (!Intrinsics.areEqual((Object)callee, (Object)callee2)) {
                                                                            constantCase = "Failed requirement.";
                                                                            throw new IllegalArgumentException(constantCase.toString());
                                                                        }
                                                                        if (stmt instanceof DefinitionStmt) {
                                                                            Intrinsics.checkNotNullExpressionValue((Object)((DefinitionStmt)stmt).getLeftOp(), (String)"getLeftOp(...)");
                                                                            lhsLocal = (Local)lhsOp;
                                                                            b = invokeOut.builder();
                                                                            if (resultValue == null) {
                                                                                v34 = $this.hf;
                                                                                v35 = $this.hf;
                                                                                var26_70 = callee.getReturnType();
                                                                                Intrinsics.checkNotNullExpressionValue((Object)var26_70, (String)"getReturnType(...)");
                                                                                summaryReturnValue = v34.push(env, v35.newSummaryVal(env, var26_70, (Object)lhsLocal)).markSummaryReturnValueInCalleeSite().popHV();
                                                                                IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)b, (HeapValuesEnv)env, (Object)lhsLocal, (IHeapValues)summaryReturnValue, (boolean)false, (int)8, null);
                                                                            } else {
                                                                                IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)b, (HeapValuesEnv)env, (Object)lhsLocal, (IHeapValues)resultValue, (boolean)false, (int)8, null);
                                                                            }
                                                                            v36 = (IFact)$this.meet((Object)invokeFold, (Object)b.build());
                                                                        } else {
                                                                            v36 = (IFact)$this.meet((Object)invokeFold, (Object)invokeOut);
                                                                        }
                                                                        invokeFold = v36;
                                                                        ** GOTO lbl185
                                                                    }
                                                                }
                                                                out.element = invokeFold.builder();
                                                            }
                                                            ((IFact.Builder)out.element).gc();
                                                            return ((IFact.Builder)out.element).build();
                                                        }
                                                        if (!(stmt instanceof DefinitionStmt)) {
                                                            return ((IFact.Builder)out.element).build();
                                                        }
                                                        v37 = ((DefinitionStmt)stmt).getLeftOp();
                                                        Intrinsics.checkNotNullExpressionValue((Object)v37, (String)"getLeftOp(...)");
                                                        lhsOp = v37;
                                                        v38 = ((DefinitionStmt)stmt).getRightOp();
                                                        Intrinsics.checkNotNullExpressionValue((Object)v38, (String)"getRightOp(...)");
                                                        rhsOp = v38;
                                                        if (!(lhsOp instanceof InstanceFieldRef)) break block76;
                                                        v39 = ((InstanceFieldRef)lhsOp).getBase();
                                                        Intrinsics.checkNotNull((Object)v39, (String)"null cannot be cast to non-null type soot.Local");
                                                        lhs = (Local)v39;
                                                        keyValue = ((InstanceFieldRef)lhsOp).getField();
                                                        Intrinsics.checkNotNullExpressionValue((Object)keyValue, (String)"getField(...)");
                                                        field = keyValue;
                                                        v40 = (IFact.Builder)out.element;
                                                        $i$f$of = false;
                                                        v41 = (JFieldType)new JSootFieldType(field);
                                                        keyValue = field.getType();
                                                        Intrinsics.checkNotNullExpressionValue((Object)keyValue, (String)"getType(...)");
                                                        IFact.Builder.DefaultImpls.assignFieldSootValue$default((IFact.Builder)v40, (HeapValuesEnv)env, (Object)lhs, (JFieldType)v41, (Value)rhsOp, (Type)keyValue, (boolean)false, (int)32, null);
                                                        break block77;
                                                    }
                                                    if (!(lhsOp instanceof ArrayRef)) break block78;
                                                    v42 = ((ArrayRef)lhsOp).getBase();
                                                    Intrinsics.checkNotNull((Object)v42, (String)"null cannot be cast to non-null type soot.Local");
                                                    lhs = (Local)v42;
                                                    index = ((ArrayRef)lhsOp).getIndex();
                                                    v43 = (IFact.Builder)out.element;
                                                    Intrinsics.checkNotNull((Object)index);
                                                    keyValue = ((ArrayRef)lhsOp).getType();
                                                    Intrinsics.checkNotNullExpressionValue((Object)keyValue, (String)"getType(...)");
                                                    v43.setArraySootValue(env, (Object)lhs, index, rhsOp, keyValue);
                                                    break block77;
                                                }
                                                if (!(rhsOp instanceof InstanceFieldRef)) break block79;
                                                v44 = ((InstanceFieldRef)rhsOp).getBase();
                                                Intrinsics.checkNotNull((Object)v44, (String)"null cannot be cast to non-null type soot.Local");
                                                rhs = (Local)v44;
                                                keyValue = ((InstanceFieldRef)rhsOp).getField();
                                                Intrinsics.checkNotNullExpressionValue((Object)keyValue, (String)"getField(...)");
                                                field = keyValue;
                                                $i$f$of = false;
                                                IFact.Builder.DefaultImpls.getField$default((IFact.Builder)((IFact.Builder)out.element), (HeapValuesEnv)env, (Object)((Local)lhsOp), (Object)rhs, (JFieldType)((JFieldType)new JSootFieldType(field)), (boolean)false, (int)16, null);
                                                break block77;
                                            }
                                            if (!(rhsOp instanceof ArrayRef)) break block80;
                                            v45 = ((ArrayRef)rhsOp).getBase();
                                            Intrinsics.checkNotNull((Object)v45, (String)"null cannot be cast to non-null type soot.Local");
                                            rhs = (Local)v45;
                                            index = ((ArrayRef)rhsOp).getIndex();
                                            if (!((IFact.Builder)out.element).getArrayValue(env, (Object)((Local)lhsOp), (Value)rhs, index)) {
                                                $this.shutDownAnalyze((AtomicBoolean)isNegativeBranch);
                                            }
                                            break block77;
                                        }
                                        if (!(rhsOp instanceof AnyNewExpr)) break block81;
                                        anyNewExpr = (AnyNewExpr)rhsOp;
                                        lhs = (Local)lhsOp;
                                        newVal = $this.hf.push(env, $this.hf.anyNewVal($this.newExprEnv(context, node, (IFact)inValue), anyNewExpr)).markOfNewExpr((AnyNewExpr)rhsOp).popHV();
                                        if (anyNewExpr instanceof NewArrayExpr) {
                                            v46 = (IFact.Builder)out.element;
                                            $i$f$of = ((NewArrayExpr)anyNewExpr).getType();
                                            Intrinsics.checkNotNull((Object)$i$f$of, (String)"null cannot be cast to non-null type soot.ArrayType");
                                            v47 = (ArrayType)$i$f$of;
                                            $i$f$of = ((NewArrayExpr)anyNewExpr).getSize();
                                            Intrinsics.checkNotNullExpressionValue((Object)$i$f$of, (String)"getSize(...)");
                                            v46.assignNewArray(env, (Object)lhsOp, newVal, v47, (Value)$i$f$of);
                                        } else {
                                            IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)((IFact.Builder)out.element), (HeapValuesEnv)env, (Object)lhs, (IHeapValues)newVal, (boolean)false, (int)8, null);
                                        }
                                        break block77;
                                    }
                                    if (rhsOp instanceof InvokeExpr) {
                                        throw new IllegalStateException(String.valueOf(node).toString());
                                    }
                                    if (!(lhsOp instanceof StaticFieldRef) && !(rhsOp instanceof StaticFieldRef)) break block82;
                                    v48 = $this.resolveClinit((SootMethod)context.getMethod(), node, (IFact)inValue);
                                    if (v48 == null) break block83;
                                    it = v48;
                                    $i$a$-let-AJimpleInterProceduralAnalysis$normalFlowFunction$3 = false;
                                    callees = Collections.singleton(it);
                                    Intrinsics.checkNotNull(callees);
                                    if (!(((Collection)callees).isEmpty() == false)) break block84;
                                    localValue = (IFact)$this.callLocalFlowFunction(context, node, (Unit)succ, (Object)inValue);
                                    if (Intrinsics.areEqual((Object)localValue, (Object)$this.bottomValue())) break block85;
                                    out.element = localValue.builder();
                                    break block84;
                                }
                                invokeFold = (IFact)$this.bottomValue();
                                $continuation.L$0 = $this;
                                $continuation.L$1 = context;
                                $continuation.L$2 = node;
                                $continuation.L$3 = env;
                                $continuation.L$4 = out;
                                $continuation.L$5 = lhsOp;
                                $continuation.L$6 = rhsOp;
                                $continuation.L$7 = invokeFold;
                                $continuation.label = 4;
                                v49 = $this.processAndReturnResult(context, (Object)node, (Object)succ, callees, (Object)inValue, (Continuation)$continuation);
                                if (v49 == var30_9) {
                                    return var30_9;
                                }
                                ** GOTO lbl356
                                {
                                    case 4: {
                                        $i$a$-let-AJimpleInterProceduralAnalysis$normalFlowFunction$3 = false;
                                        invokeFold = (IFact)$continuation.L$7;
                                        rhsOp = (Value)$continuation.L$6;
                                        lhsOp = (Value)$continuation.L$5;
                                        out = (Ref.ObjectRef)$continuation.L$4;
                                        env = (HeapValuesEnv)$continuation.L$3;
                                        node = (Unit)$continuation.L$2;
                                        context = (cn.sast.idfa.analysis.Context)$continuation.L$1;
                                        $this = (AJimpleInterProceduralAnalysis)$continuation.L$0;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v49 = $result;
lbl356:
                                        // 2 sources

                                        var19_58 = ((Map)v49).entrySet().iterator();
lbl357:
                                        // 2 sources

                                        while (var19_58.hasNext()) {
                                            var20_59 = var19_58.next();
                                            callee2 = (SootMethod)var20_59.getKey();
                                            calleeOut = (Deferred)var20_59.getValue();
                                            $continuation.L$0 = $this;
                                            $continuation.L$1 = context;
                                            $continuation.L$2 = node;
                                            $continuation.L$3 = env;
                                            $continuation.L$4 = out;
                                            $continuation.L$5 = lhsOp;
                                            $continuation.L$6 = rhsOp;
                                            $continuation.L$7 = invokeFold;
                                            $continuation.L$8 = var19_58;
                                            $continuation.L$9 = callee2;
                                            $continuation.label = 5;
                                            v50 = calleeOut.await((Continuation)$continuation);
                                            if (v50 == var30_9) {
                                                return var30_9;
                                            }
                                            ** GOTO lbl391
                                        }
                                        break;
                                    }
                                    case 5: {
                                        $i$a$-let-AJimpleInterProceduralAnalysis$normalFlowFunction$3 = false;
                                        callee2 = (SootMethod)$continuation.L$9;
                                        var19_58 = (Iterator<Map.Entry<K, V>>)$continuation.L$8;
                                        invokeFold = (IFact)$continuation.L$7;
                                        rhsOp = (Value)$continuation.L$6;
                                        lhsOp = (Value)$continuation.L$5;
                                        out = (Ref.ObjectRef)$continuation.L$4;
                                        env = (HeapValuesEnv)$continuation.L$3;
                                        node = (Unit)$continuation.L$2;
                                        context = (cn.sast.idfa.analysis.Context)$continuation.L$1;
                                        $this = (AJimpleInterProceduralAnalysis)$continuation.L$0;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v50 = $result;
lbl391:
                                        // 2 sources

                                        var23_67 = (ForwardInterProceduralAnalysis.InvokeResult)v50;
                                        callee = (SootMethod)var23_67.component1();
                                        invokeOut = (IFact)var23_67.component2();
                                        resultValue = (IHeapValues)var23_67.component3();
                                        if (!Intrinsics.areEqual((Object)callee, (Object)callee2)) {
                                            var27_72 = "Failed requirement.";
                                            throw new IllegalArgumentException(var27_72.toString());
                                        }
                                        v51 = resultValue;
                                        if (!(v51 != null ? v51.isEmpty() : true)) {
                                            var27_73 = "Failed requirement.";
                                            throw new IllegalArgumentException(var27_73.toString());
                                        }
                                        invokeFold = (IFact)$this.meet((Object)invokeFold, (Object)invokeOut);
                                        ** GOTO lbl357
                                    }
                                }
                                out.element = invokeFold.builder();
                            }
                            v52 = kotlin.Unit.INSTANCE;
                            break block86;
                        }
                        v52 = null;
                    }
                    if (lhsOp instanceof StaticFieldRef) {
                        lhs = ((StaticFieldRef)lhsOp).getField();
                        Intrinsics.checkNotNullExpressionValue((Object)lhs, (String)"getField(...)");
                        staticField = lhs;
                        v53 = (IFact.Builder)out.element;
                        v54 = $this.hf.getVg().getGLOBAL_LOCAL();
                        $i$f$of = false;
                        v55 = (JFieldType)new JSootFieldType(staticField);
                        lhs = staticField.getType();
                        Intrinsics.checkNotNullExpressionValue((Object)lhs, (String)"getType(...)");
                        IFact.Builder.DefaultImpls.assignFieldSootValue$default((IFact.Builder)v53, (HeapValuesEnv)env, (Object)v54, (JFieldType)v55, (Value)rhsOp, (Type)lhs, (boolean)false, (int)32, null);
                    } else if (rhsOp instanceof StaticFieldRef) {
                        Intrinsics.checkNotNull((Object)lhsOp, (String)"null cannot be cast to non-null type soot.Local");
                        lhsLocal = (Local)lhsOp;
                        $i$f$of = ((StaticFieldRef)rhsOp).getField();
                        Intrinsics.checkNotNullExpressionValue((Object)$i$f$of, (String)"getField(...)");
                        staticField = $i$f$of;
                        $i$f$of = false;
                        IFact.Builder.DefaultImpls.getField$default((IFact.Builder)((IFact.Builder)out.element), (HeapValuesEnv)env, (Object)lhsLocal, (Object)$this.hf.getVg().getGLOBAL_LOCAL(), (JFieldType)((JFieldType)new JSootFieldType(staticField)), (boolean)false, (int)16, null);
                    }
                    break block77;
                }
                if (!(rhsOp instanceof CaughtExceptionRef)) break block87;
                lhs = (Local)lhsOp;
                v56 = (IFact.Builder)out.element;
                v57 = $this.hf;
                v58 = $this.hf;
                staticField = ((CaughtExceptionRef)rhsOp).getType();
                Intrinsics.checkNotNullExpressionValue((Object)staticField, (String)"getType(...)");
                IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)v56, (HeapValuesEnv)env, (Object)lhs, (IHeapValues)v57.push(env, v58.newSummaryVal(env, (Type)staticField, (Object)lhs)).markSummaryValueInCaughtExceptionRhs().popHV(), (boolean)false, (int)8, null);
                break block77;
            }
            if (!(rhsOp instanceof IdentityRef)) ** GOTO lbl457
            lhs = (Local)lhsOp;
            staticField = (IdentityRef)rhsOp;
            if (staticField instanceof ParameterRef) {
                ((IFact.Builder)out.element).assignLocal(env, (Object)lhs, (Object)Boxing.boxInt((int)((ParameterRef)rhsOp).getIndex()));
            } else if (staticField instanceof ThisRef) {
                ((IFact.Builder)out.element).assignLocal(env, (Object)lhs, (Object)Boxing.boxInt((int)-1));
            } else {
                throw new IllegalStateException(String.valueOf(stmt).toString());
lbl457:
                // 1 sources

                if (lhsOp instanceof Local) {
                    lhs = (Local)lhsOp;
                    if (rhsOp instanceof Expr) {
                        v59 = (IFact.Builder)out.element;
                        v60 = (Expr)rhsOp;
                        $i$f$of = lhs.getType();
                        Intrinsics.checkNotNullExpressionValue((Object)$i$f$of, (String)"getType(...)");
                        rhsValue = $this.resolveExpr(v59, env, v60, $i$f$of);
                        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)((IFact.Builder)out.element), (HeapValuesEnv)env, (Object)lhs, (IHeapValues)rhsValue, (boolean)false, (int)8, null);
                    } else {
                        v61 = (IFact.Builder)out.element;
                        var13_15 = lhs.getType();
                        Intrinsics.checkNotNullExpressionValue((Object)var13_15, (String)"getType(...)");
                        v61.assignLocalSootValue(env, (Object)lhs, rhsOp, (Type)var13_15);
                    }
                } else {
                    throw new RuntimeException(node.toString());
                }
            }
        }
        v62 = $this.icfg;
        var13_15 = context.getControlFlowGraph();
        Intrinsics.checkNotNull((Object)var13_15, (String)"null cannot be cast to non-null type soot.toolkits.graph.DirectedBodyGraph<soot.Unit>");
        deadLocals = v62.getNonLiveLocals((DirectedBodyGraph)var13_15, node);
        for (Local killLocal : deadLocals) {
            ((IFact.Builder)out.element).kill((Object)killLocal);
        }
        if (((Collection)deadLocals).isEmpty() == false) {
            ((IFact.Builder)out.element).gc();
        }
        return ((IFact.Builder)out.element).build();
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public boolean isDummyComponentInvoke(@NotNull SootMethod container, @NotNull Unit node, @NotNull SootMethod callee) {
        Intrinsics.checkNotNullParameter((Object)container, (String)"container");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter((Object)callee, (String)"callee");
        return false;
    }

    @NotNull
    public IFact<V> callEntryFlowFunction(@NotNull CTX context, @NotNull SootMethod callee, @NotNull Unit node, @NotNull Unit succ, @NotNull IFact<V> inValue) {
        Iterator iterator2;
        Intrinsics.checkNotNullParameter(context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)callee, (String)"callee");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter((Object)succ, (String)"succ");
        Intrinsics.checkNotNullParameter(inValue, (String)"inValue");
        if (inValue.isBottom()) {
            return inValue;
        }
        Stmt callStmt = (Stmt)node;
        boolean isDummyComponentInvoke = this.isDummyComponentInvoke((SootMethod)context.getMethod(), node, callee);
        SootMethod caller = (SootMethod)context.getMethod();
        IFact.Builder callEdge = inValue.builder();
        if (!caller.isStatic()) {
            callEdge.kill((Object)-1);
        }
        int n = caller.getParameterCount();
        for (int callerArgs = 0; callerArgs < n; ++callerArgs) {
            callEdge.kill((Object)callerArgs);
        }
        HeapValuesEnv env = this.hf.env(node);
        if (callStmt.containsInvokeExpr()) {
            InvokeExpr invokeExpr = callStmt.getInvokeExpr();
            if (invokeExpr instanceof InstanceInvokeExpr && caller.hasActiveBody()) {
                Integer n2 = -1;
                Value value = ((InstanceInvokeExpr)invokeExpr).getBase();
                Intrinsics.checkNotNull((Object)value, (String)"null cannot be cast to non-null type soot.Local");
                callEdge.assignLocal(env, (Object)n2, (Object)((Local)value));
            }
            int n3 = invokeExpr.getArgCount();
            for (int i = 0; i < n3; ++i) {
                Value argValue = invokeExpr.getArg(i);
                if (argValue instanceof Local) {
                    if (isDummyComponentInvoke && ((Local)argValue).getType() instanceof ArrayType) {
                        Type type = ((Local)argValue).getType();
                        Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
                        Object summaryValue = this.hf.newSummaryVal(env, type, (Object)"dummyMainMethodArgArrayElement");
                        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)callEdge, (HeapValuesEnv)env, (Object)i, (IHeapValues)this.hf.push(env, summaryValue).markOfEntryMethodParam(callee).popHV(), (boolean)false, (int)8, null);
                        continue;
                    }
                    callEdge.assignLocal(env, (Object)i, (Object)argValue);
                    continue;
                }
                if (argValue instanceof Constant) {
                    IHeapValues iHeapValues;
                    Type type;
                    Constant $this$accurateType$iv = (Constant)argValue;
                    boolean $i$f$accurateType = false;
                    Type it$iv = $this$accurateType$iv.getType();
                    boolean bl = false;
                    if (it$iv instanceof RefLikeType) {
                        type = it$iv;
                    } else {
                        boolean bl2 = false;
                        Type type2 = invokeExpr.getMethodRef().getParameterType(i);
                        type = type2;
                        Intrinsics.checkNotNullExpressionValue((Object)type2, (String)"getParameterType(...)");
                    }
                    type = type;
                    if (!isDummyComponentInvoke) {
                        iHeapValues = JOperatorV.DefaultImpls.markOfConstant$default((JOperatorV)this.hf.push(env, this.hf.newConstVal((Constant)argValue, type)), (Constant)((Constant)argValue), null, (int)2, null).popHV();
                    } else {
                        Object summaryValue = this.hf.newSummaryVal(env, type, (Object)"dummyMainMethodArg");
                        iHeapValues = this.hf.push(env, summaryValue).markOfEntryMethodParam(callee).popHV();
                    }
                    value = iHeapValues;
                    IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)callEdge, (HeapValuesEnv)env, (Object)i, (IHeapValues)value, (boolean)false, (int)8, null);
                    continue;
                }
                throw new RuntimeException(argValue.toString());
            }
        } else {
            if (!callee.isStaticInitializer()) {
                String i = "Failed requirement.";
                throw new IllegalArgumentException(i.toString());
            }
            Iterator iterator3 = callee.getDeclaringClass().getFields().iterator();
            Intrinsics.checkNotNullExpressionValue((Object)iterator3, (String)"iterator(...)");
            iterator2 = iterator3;
            while (iterator2.hasNext()) {
                SootField field = (SootField)iterator2.next();
                IVGlobal iVGlobal = this.hf.getVg();
                Type type = field.getType();
                Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
                Pair pair = iVGlobal.defaultValue(type);
                Constant constant = (Constant)pair.component1();
                type = (Type)pair.component2();
                if (!field.isStatic()) continue;
                String string = this.hf.getVg().getGLOBAL_LOCAL();
                value = FieldUtil.INSTANCE;
                Intrinsics.checkNotNull((Object)field);
                SootField field$iv = field;
                boolean $i$f$of = false;
                callEdge.setFieldNew(env, (Object)string, (JFieldType)new JSootFieldType(field$iv), JOperatorV.DefaultImpls.markOfConstant$default((JOperatorV)this.hf.push(env, this.hf.newConstVal(constant, type)), (Constant)constant, null, (int)2, null).popHV());
            }
        }
        if (caller.hasActiveBody()) {
            Iterator iterator4 = caller.getActiveBody().getLocals().iterator();
            Intrinsics.checkNotNullExpressionValue((Object)iterator4, (String)"iterator(...)");
            iterator2 = iterator4;
            while (iterator2.hasNext()) {
                Local callerLocal = (Local)iterator2.next();
                Intrinsics.checkNotNull((Object)callerLocal);
                callEdge.kill((Object)callerLocal);
            }
        }
        callEdge.kill((Object)this.hf.getVg().getRETURN_LOCAL());
        callEdge.callEntryFlowFunction(context, callee, node, succ);
        if (this.hf.getVg().getStaticFieldTrackingMode() == StaticFieldTrackingMode.ContextFlowInsensitive || callee.isJavaLibraryMethod() || callee.getDeclaringClass().isLibraryClass()) {
            callEdge.kill((Object)this.hf.getVg().getGLOBAL_LOCAL());
        }
        callEdge.gc();
        if (this.hf.getVg().getStaticFieldTrackingMode() == StaticFieldTrackingMode.ContextFlowInsensitive) {
            IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)callEdge, (HeapValuesEnv)env, (Object)this.hf.getVg().getGLOBAL_LOCAL(), (IHeapValues)this.hf.push(env, (Object)this.hf.getVg().getGLOBAL_SITE()).popHV(), (boolean)false, (int)8, null);
        }
        return callEdge.build();
    }

    @NotNull
    public ForwardInterProceduralAnalysis.InvokeResult<SootMethod, IFact<V>, IHeapValues<V>> recursiveCallFlowFunction(@NotNull CTX context, @NotNull SootMethod callee, @NotNull Unit node, @NotNull Unit succ, @NotNull IFact<V> inValue, @NotNull IFact<V> siteValue, boolean isAnalyzable) {
        IHeapValues iHeapValues;
        Intrinsics.checkNotNullParameter(context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)callee, (String)"callee");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter((Object)succ, (String)"succ");
        Intrinsics.checkNotNullParameter(inValue, (String)"inValue");
        Intrinsics.checkNotNullParameter(siteValue, (String)"siteValue");
        Type returnType = callee.getReturnType();
        boolean hasReturnValue = !Intrinsics.areEqual((Object)returnType, (Object)G.v().soot_VoidType());
        IFact.Builder intraEdge = siteValue.builder();
        if (hasReturnValue) {
            HeapValuesEnv env = this.hf.env(node);
            Intrinsics.checkNotNull((Object)returnType);
            iHeapValues = this.hf.push(env, this.hf.newSummaryVal(env, returnType, (Object)"recursiveReturn")).markSummaryReturnValueInCalleeSite().popHV();
        } else {
            iHeapValues = null;
        }
        IHeapValues returnValue = iHeapValues;
        intraEdge.addCalledMethod(callee);
        return new ForwardInterProceduralAnalysis.InvokeResult((Object)callee, (Object)intraEdge.build(), returnValue);
    }

    @NotNull
    public ForwardInterProceduralAnalysis.InvokeResult<SootMethod, IFact<V>, IHeapValues<V>> failedInvokeResult(@NotNull CTX context, @NotNull SootMethod callee, @NotNull Unit node, @NotNull Unit succ, @NotNull IFact<V> inValue, @NotNull IFact<V> siteValue, boolean isAnalyzable) {
        IHeapValues iHeapValues;
        Intrinsics.checkNotNullParameter(context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)callee, (String)"callee");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter((Object)succ, (String)"succ");
        Intrinsics.checkNotNullParameter(inValue, (String)"inValue");
        Intrinsics.checkNotNullParameter(siteValue, (String)"siteValue");
        Type returnType = callee.getReturnType();
        boolean hasReturnValue = !Intrinsics.areEqual((Object)returnType, (Object)G.v().soot_VoidType());
        IFact.Builder intraEdge = siteValue.builder();
        if (hasReturnValue) {
            HeapValuesEnv env = this.hf.env(node);
            Intrinsics.checkNotNull((Object)returnType);
            iHeapValues = this.hf.push(env, this.hf.newSummaryVal(env, returnType, (Object)"failedReturn")).markSummaryReturnValueInCalleeSite().popHV();
        } else {
            iHeapValues = null;
        }
        IHeapValues returnValue = iHeapValues;
        intraEdge.addCalledMethod(callee);
        return new ForwardInterProceduralAnalysis.InvokeResult((Object)callee, (Object)intraEdge.build(), returnValue);
    }

    @NotNull
    public ForwardInterProceduralAnalysis.InvokeResult<SootMethod, IFact<V>, IHeapValues<V>> callExitFlowFunction(@NotNull CTX context, @NotNull IFact<V> siteValue, @NotNull SootMethod callee, @NotNull IFact<V> callEdgeValue, @NotNull CTX calleeCtx, @NotNull Unit node, @NotNull Unit succ, boolean isAnalyzable) {
        Intrinsics.checkNotNullParameter(context, (String)"context");
        Intrinsics.checkNotNullParameter(siteValue, (String)"siteValue");
        Intrinsics.checkNotNullParameter((Object)callee, (String)"callee");
        Intrinsics.checkNotNullParameter(callEdgeValue, (String)"callEdgeValue");
        Intrinsics.checkNotNullParameter(calleeCtx, (String)"calleeCtx");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter((Object)succ, (String)"succ");
        IFact.Builder intraEdge = siteValue.builder();
        Object object = calleeCtx.getExitValue();
        Intrinsics.checkNotNull((Object)object);
        IFact calleeExitAbs = (IFact)object;
        Type returnType = callee.getReturnType();
        boolean hasReturnValue = !Intrinsics.areEqual((Object)returnType, (Object)G.v().soot_VoidType());
        HeapValuesEnv env = this.hf.env(node);
        IHeapValues returnValue = intraEdge.updateIntraEdge(env, (Context)context, (Context)calleeCtx, callEdgeValue, hasReturnValue);
        if (hasReturnValue && (returnValue == null || returnValue.isEmpty())) {
            logger.trace(() -> AJimpleInterProceduralAnalysis.callExitFlowFunction$lambda$6(env, calleeExitAbs));
            Intrinsics.checkNotNull((Object)returnType);
            returnValue = this.hf.push(env, this.hf.newSummaryVal(env, returnType, (Object)("ret_" + callee.getDeclaringClass().getShortName() + "::" + callee.getName()))).markSummaryReturnValueInCalleeSite().popHV();
        }
        intraEdge.addCalledMethod(callee);
        return new ForwardInterProceduralAnalysis.InvokeResult((Object)callee, (Object)intraEdge.build(), (Object)returnValue);
    }

    @NotNull
    public DirectedGraph<Unit> getCfg(@NotNull SootMethod method, boolean isAnalyzable) {
        DirectedGraph directedGraph;
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        if (method.hasActiveBody()) {
            DirectedGraph cfg = this.programRepresentation().getControlFlowGraph(method);
            List list = cfg.getHeads();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getHeads(...)");
            directedGraph = !((Collection)list).isEmpty() ? cfg : this.programRepresentation().getSummaryControlFlowGraph(method);
        } else {
            directedGraph = this.programRepresentation().getSummaryControlFlowGraph(method);
        }
        return directedGraph;
    }

    public boolean isAnalyzable(@NotNull SootMethod callee, @NotNull IFact<V> in1) {
        boolean bl;
        block14: {
            Intrinsics.checkNotNullParameter((Object)callee, (String)"callee");
            Intrinsics.checkNotNullParameter(in1, (String)"in1");
            if (!this.icfg.isAnalyzable(callee)) {
                return false;
            }
            Function1 function1 = this.needAnalyze;
            boolean bl2 = function1 != null ? ((Boolean)function1.invoke((Object)callee)).booleanValue() : false;
            if (bl2) {
                return true;
            }
            if (this.analyzeLibraryClasses) {
                int dataFlowInterProceduralCalleeDepChainMaxNumForLibClasses = ExtSettings.INSTANCE.getCalleeDepChainMaxNumForLibClassesInInterProceduraldataFlow();
                if (dataFlowInterProceduralCalleeDepChainMaxNumForLibClasses >= 0) {
                    CallStackContext cur = in1.getCallStack();
                    List libraryMethods = new ArrayList();
                    if (!callee.getDeclaringClass().isApplicationClass()) {
                        libraryMethods.add(callee);
                    }
                    while (cur != null) {
                        if (!cur.getMethod().getDeclaringClass().isApplicationClass()) {
                            libraryMethods.add(cur.getMethod());
                        }
                        if (libraryMethods.size() > dataFlowInterProceduralCalleeDepChainMaxNumForLibClasses) {
                            return false;
                        }
                        cur = cur.getCaller();
                    }
                }
            } else if (!callee.getDeclaringClass().isApplicationClass()) {
                return false;
            }
            List list = callee.getTags();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getTags(...)");
            Iterable $this$any$iv = list;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    Tag it = (Tag)element$iv;
                    boolean bl3 = false;
                    if (!(it instanceof FlowDroidEssentialMethodTag)) continue;
                    bl = true;
                    break block14;
                }
                bl = false;
            }
        }
        if (bl) {
            return true;
        }
        return !Scene.v().isExcluded(callee.getDeclaringClass());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void doAnalysis(@NotNull Collection<? extends SootMethod> entries, @NotNull Collection<? extends SootMethod> methodsMustAnalyze) {
        Intrinsics.checkNotNullParameter(entries, (String)"entries");
        Intrinsics.checkNotNullParameter(methodsMustAnalyze, (String)"methodsMustAnalyze");
        Set reachableMethodsTotal = new LinkedHashSet();
        Set methodsMustAnalyzeSet = SetsKt.plus((Set)CollectionsKt.toSet((Iterable)methodsMustAnalyze), (Iterable)entries);
        logger.info(AJimpleInterProceduralAnalysis::doAnalysis$lambda$8);
        Ref.ObjectRef works = new Ref.ObjectRef();
        works.element = CollectionsKt.toSet((Iterable)entries);
        Set surplusOld = methodsMustAnalyzeSet;
        Ref.IntRef count = new Ref.IntRef();
        while (!((Collection)surplusOld).isEmpty() || !((Collection)works.element).isEmpty()) {
            CustomRepeatingTimer customRepeatingTimer;
            if (((Set)works.element).isEmpty()) {
                works.element = surplusOld;
            }
            logger.info(() -> AJimpleInterProceduralAnalysis.doAnalysis$lambda$9(count, works, methodsMustAnalyze));
            CustomRepeatingTimer $this$doAnalysis_u24lambda_u2411 = customRepeatingTimer = new CustomRepeatingTimer(60000L, AJimpleInterProceduralAnalysis::doAnalysis$lambda$10);
            boolean bl = false;
            $this$doAnalysis_u24lambda_u2411.setRepeats(true);
            $this$doAnalysis_u24lambda_u2411.start();
            CustomRepeatingTimer gcTimer = customRepeatingTimer;
            try {
                this.doAnalysis((Collection)works.element);
            }
            finally {
                gcTimer.stop();
            }
            int n = count.element;
            count.element = n + 1;
            CollectionsKt.addAll((Collection)reachableMethodsTotal, (Iterable)((Iterable)this.getReachableMethods()));
            Set newSurplus = SetsKt.minus((Set)methodsMustAnalyzeSet, (Iterable)reachableMethodsTotal);
            if (Intrinsics.areEqual((Object)surplusOld, (Object)newSurplus)) break;
            surplusOld = newSurplus;
            works.element = newSurplus;
        }
    }

    @NotNull
    public final IHeapValues<V> resolveExpr(@NotNull IFact.Builder<V> $this$resolveExpr, @NotNull HeapValuesEnv env, @NotNull Expr expr, @NotNull Type resType) {
        IOpCalculator iOpCalculator;
        Intrinsics.checkNotNullParameter($this$resolveExpr, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
        Intrinsics.checkNotNullParameter((Object)resType, (String)"resType");
        Expr expr2 = expr;
        if (expr2 instanceof CastExpr) {
            Type toType = ((CastExpr)expr).getCastType();
            Value value = ((CastExpr)expr).getOp();
            Intrinsics.checkNotNullExpressionValue((Object)value, (String)"getOp(...)");
            Type type = ((CastExpr)expr).getOp().getType();
            Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
            IHeapValues fromValues = $this$resolveExpr.getOfSootValue(env, value, type);
            AbstractHeapFactory abstractHeapFactory = $this$resolveExpr.getHf();
            Intrinsics.checkNotNull((Object)toType);
            iOpCalculator = abstractHeapFactory.resolveCast(env, $this$resolveExpr, toType, fromValues);
            if (iOpCalculator == null || (iOpCalculator = iOpCalculator.getRes()) == null || (iOpCalculator = iOpCalculator.build()) == null) {
                iOpCalculator = fromValues;
            }
        } else if (expr2 instanceof InstanceOfExpr) {
            Type checkType = ((InstanceOfExpr)expr).getCheckType();
            Value value = ((InstanceOfExpr)expr).getOp();
            Intrinsics.checkNotNullExpressionValue((Object)value, (String)"getOp(...)");
            Type type = ((InstanceOfExpr)expr).getOp().getType();
            Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
            IHeapValues fromValues = $this$resolveExpr.getOfSootValue(env, value, type);
            AbstractHeapFactory abstractHeapFactory = $this$resolveExpr.getHf();
            Intrinsics.checkNotNull((Object)checkType);
            iOpCalculator = abstractHeapFactory.resolveInstanceOf(env, fromValues, checkType).getRes().build();
        } else if (expr2 instanceof UnopExpr) {
            Value value = ((UnopExpr)expr).getOp();
            Intrinsics.checkNotNullExpressionValue((Object)value, (String)"getOp(...)");
            Type type = ((UnopExpr)expr).getOp().getType();
            Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
            IHeapValues opValues = $this$resolveExpr.getOfSootValue(env, value, type);
            iOpCalculator = $this$resolveExpr.getHf().resolveUnop(env, (IIFact)$this$resolveExpr, opValues, (UnopExpr)expr, resType).getRes().build();
        } else if (expr2 instanceof BinopExpr) {
            Value value = ((BinopExpr)expr).getOp1();
            Intrinsics.checkNotNullExpressionValue((Object)value, (String)"getOp1(...)");
            Type type = ((BinopExpr)expr).getOp1().getType();
            Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
            IHeapValues op1Values = $this$resolveExpr.getOfSootValue(env, value, type);
            Value value2 = ((BinopExpr)expr).getOp2();
            Intrinsics.checkNotNullExpressionValue((Object)value2, (String)"getOp2(...)");
            Type type2 = ((BinopExpr)expr).getOp2().getType();
            Intrinsics.checkNotNullExpressionValue((Object)type2, (String)"getType(...)");
            IHeapValues op2Values = $this$resolveExpr.getOfSootValue(env, value2, type2);
            iOpCalculator = $this$resolveExpr.getHf().resolveBinop(env, $this$resolveExpr, op1Values, op2Values, (BinopExpr)expr, resType).getRes().build();
        } else {
            $this$resolveExpr.getHf().getLogger().error(() -> AJimpleInterProceduralAnalysis.resolveExpr$lambda$12(expr));
            return $this$resolveExpr.getHf().empty();
        }
        return iOpCalculator;
    }

    private static final Object newContext$lambda$0(SootMethod $method) {
        return "new context for " + $method;
    }

    private static final Object newContext$lambda$1(SootMethod $method) {
        return $method.getActiveBody();
    }

    private static final <V, CTX extends cn.sast.idfa.analysis.Context<SootMethod, Unit, IFact<V>>> Boolean normalFlowFunction$lambda$3$check(AJimpleInterProceduralAnalysis<V, CTX> this$0, HeapValuesEnv env, Ref.ObjectRef<IFact.Builder<V>> out, IHeapValues<V> keyValue, Value key2, IHeapValues<V> caseValue) {
        BooleanType resType = G.v().soot_BooleanType();
        AbstractHeapFactory abstractHeapFactory = this$0.hf;
        IFact.Builder builder2 = (IFact.Builder)out.element;
        BinopExpr binopExpr = (BinopExpr)new JEqExpr((Value)new JimpleLocal("a", key2.getType()), (Value)new JimpleLocal("b", key2.getType()));
        Intrinsics.checkNotNull((Object)resType);
        IOpCalculator r = abstractHeapFactory.resolveBinop(env, builder2, keyValue, caseValue, binopExpr, (Type)resType);
        IHeapValues eq = r.getRes().build();
        if (r.isFullySimplified() && eq.isSingle()) {
            Object object = eq.getSingle().getValue();
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.analysis.IValue");
            return FactValuesKt.getBooleanValue((IValue)((IValue)object), (boolean)true);
        }
        return null;
    }

    private static final Object callExitFlowFunction$lambda$6(HeapValuesEnv $env, IFact $calleeExitAbs) {
        return "returnValue is empty. at " + $env + " exitValue: " + $calleeExitAbs;
    }

    private static final Object doAnalysis$lambda$8() {
        return "Before Analyze: Process information: " + ProcessInfoView.Companion.getGlobalProcessInfo().getProcessInfoText();
    }

    private static final Object doAnalysis$lambda$9(Ref.IntRef $count, Ref.ObjectRef $works, Collection $methodsMustAnalyze) {
        return "iteration " + $count.element + " : [" + ((Set)$works.element).size() + "/" + $methodsMustAnalyze.size() + "]";
    }

    private static final kotlin.Unit doAnalysis$lambda$10() {
        System.gc();
        return kotlin.Unit.INSTANCE;
    }

    private static final Object resolveExpr$lambda$12(Expr $expr) {
        return "resolveExpr: not yet impl type of expr " + $expr;
    }

    private static final kotlin.Unit logger$lambda$13() {
        return kotlin.Unit.INSTANCE;
    }
}

