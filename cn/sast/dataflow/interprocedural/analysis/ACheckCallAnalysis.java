/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ExtSettings
 *  cn.sast.api.report.Counter
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis$Companion
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis$computeEntryValue$1
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis$evalCall$2
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis$postCallAtCallSite$1
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis$prevCallFunction$1
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis$returnFlowFunction$1
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysisKt
 *  cn.sast.dataflow.interprocedural.analysis.AIContext
 *  cn.sast.dataflow.interprocedural.analysis.AJimpleInterProceduralAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.HookEnv
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage
 *  cn.sast.dataflow.interprocedural.analysis.WideningPrimitive
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$PostCall
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$PrevCall
 *  cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl
 *  cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl$PostCall
 *  cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl$PrevCall
 *  cn.sast.dataflow.util.SootUtilsKt
 *  cn.sast.idfa.analysis.Context
 *  cn.sast.idfa.analysis.ForwardInterProceduralAnalysis$InvokeResult
 *  cn.sast.idfa.analysis.InterproceduralCFG
 *  cn.sast.idfa.check.CallBackManager
 *  kotlin.Metadata
 *  kotlin.NotImplementedError
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$BooleanRef
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Body
 *  soot.Local
 *  soot.PrimType
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.SootMethodRef
 *  soot.Type
 *  soot.Unit
 *  soot.Value
 *  soot.jimple.DefinitionStmt
 *  soot.jimple.InstanceInvokeExpr
 *  soot.jimple.InvokeExpr
 *  soot.jimple.Stmt
 *  soot.toolkits.graph.BriefUnitGraph
 *  soot.toolkits.graph.DirectedGraph
 *  soot.toolkits.graph.UnitGraph
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.api.config.ExtSettings;
import cn.sast.api.report.Counter;
import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysisKt;
import cn.sast.dataflow.interprocedural.analysis.AIContext;
import cn.sast.dataflow.interprocedural.analysis.AJimpleInterProceduralAnalysis;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.HookEnv;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.analysis.WideningPrimitive;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl;
import cn.sast.dataflow.util.SootUtilsKt;
import cn.sast.idfa.analysis.Context;
import cn.sast.idfa.analysis.ForwardInterProceduralAnalysis;
import cn.sast.idfa.analysis.InterproceduralCFG;
import cn.sast.idfa.check.CallBackManager;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Body;
import soot.Local;
import soot.PrimType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.DefinitionStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.toolkits.graph.BriefUnitGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.UnitGraph;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 Y2\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001YB!\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dJ'\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00172\u0017\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00150!\u00a2\u0006\u0002\b#J+\u0010$\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00172\u001b\u0010$\u001a\u0017\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00150!j\u0002`&\u00a2\u0006\u0002\b#J+\u0010'\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00172\u001b\u0010(\u001a\u0017\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00150!j\u0002`*\u00a2\u0006\u0002\b#J\u0016\u0010+\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-J\u0016\u0010.\u001a\u00020\u00152\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0016J$\u0010.\u001a\u00020\u00152\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\f\u00102\u001a\b\u0012\u0004\u0012\u00020100H\u0016J\u001e\u00103\u001a\b\u0012\u0004\u0012\u000205042\u0006\u00106\u001a\u0002012\u0006\u00107\u001a\u00020\u0019H\u0016J(\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0010\u0010=\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030>Jj\u0010$\u001a,\u0012\u0004\u0012\u000201\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030@\u0012\u0010\u0012\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010A\u0018\u00010?2\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u0002012\u0006\u0010;\u001a\u0002052\u0006\u0010D\u001a\u0002052\u0010\u0010E\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030@H\u0096@\u00a2\u0006\u0002\u0010FJ \u0010G\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030@2\u0006\u0010B\u001a\u00020\u0004H\u0096@\u00a2\u0006\u0002\u0010HJJ\u0010I\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030@2\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u0002012\u0006\u0010;\u001a\u0002052\u0006\u0010D\u001a\u0002052\u0010\u0010J\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030@H\u0096@\u00a2\u0006\u0002\u0010FJ\u001a\u0010K\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030@2\u0006\u0010B\u001a\u00020\u0004H\u0016J:\u0010L\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030@2\u0006\u0010B\u001a\u00020\u00042\u0006\u0010;\u001a\u0002052\u0010\u0010M\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030@H\u0096@\u00a2\u0006\u0002\u0010NJ\u0010\u0010S\u001a\u00020\u00152\u0006\u0010C\u001a\u000201H\u0016J~\u0010T\u001a*\u0012\u0004\u0012\u000201\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030@\u0012\u0010\u0012\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010A0?2\u0006\u0010B\u001a\u00020\u00042\u0006\u0010;\u001a\u0002052\u0006\u0010D\u001a\u0002052.\u0010U\u001a*\u0012\u0004\u0012\u000201\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030@\u0012\u0010\u0012\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010A0?H\u0096@\u00a2\u0006\u0002\u0010VJ>\u0010W\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010@2\u0006\u0010B\u001a\u00020\u00042\u0006\u0010;\u001a\u0002052\u0006\u0010D\u001a\u0002052\u0010\u0010X\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030@H\u0016J\"\u00107\u001a\u00020\u00192\u0006\u0010C\u001a\u0002012\u0010\u0010U\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030@H\u0016R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010O\u001a\b\u0012\u0004\u0012\u0002010P\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u0010R\u00a8\u0006Z"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/AJimpleInterProceduralAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "Lcn/sast/dataflow/interprocedural/analysis/AIContext;", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "icfg", "Lcn/sast/idfa/analysis/InterproceduralCFG;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;Lcn/sast/idfa/analysis/InterproceduralCFG;)V", "callBackManager", "Lcn/sast/idfa/check/CallBackManager;", "getCallBackManager", "()Lcn/sast/idfa/check/CallBackManager;", "summaries", "", "Lcn/sast/dataflow/interprocedural/analysis/SummaryHandlePackage;", "getSummaries", "()Ljava/util/List;", "registerWrapper", "", "smr", "", "isStatic", "", "Lsoot/SootMethodRef;", "registerClassAllWrapper", "sc", "Lsoot/SootClass;", "evalCallAtCaller", "methodSignature", "prevCall", "Lkotlin/Function1;", "Lcn/sast/dataflow/interprocedural/check/callback/CallerSiteCBImpl$EvalCall;", "Lkotlin/ExtensionFunctionType;", "evalCall", "Lcn/sast/dataflow/interprocedural/check/callback/CalleeCBImpl$EvalCall;", "Lcn/sast/dataflow/interprocedural/analysis/EvalCallInCallee;", "postCallAtCaller", "postCall", "Lcn/sast/dataflow/interprocedural/check/callback/CallerSiteCBImpl$PostCall;", "Lcn/sast/dataflow/interprocedural/analysis/PostCallInCallee;", "registerJimpleWrapper", "jimple", "Lsoot/toolkits/graph/UnitGraph;", "doAnalysis", "entries", "", "Lsoot/SootMethod;", "methodsMustAnalyze", "getCfg", "Lsoot/toolkits/graph/DirectedGraph;", "Lsoot/Unit;", "method", "isAnalyzable", "returnPhantom", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "node", "Lsoot/jimple/Stmt;", "builder", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "Lcn/sast/idfa/analysis/ForwardInterProceduralAnalysis$InvokeResult;", "Lcn/sast/dataflow/interprocedural/analysis/IFact;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "context", "callee", "succ", "inValue", "(Lcn/sast/dataflow/interprocedural/analysis/AIContext;Lsoot/SootMethod;Lsoot/Unit;Lsoot/Unit;Lcn/sast/dataflow/interprocedural/analysis/IFact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeEntryValue", "(Lcn/sast/dataflow/interprocedural/analysis/AIContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prevCallFunction", "callSiteValue", "computeExitValue", "returnFlowFunction", "returnValue", "(Lcn/sast/dataflow/interprocedural/analysis/AIContext;Lsoot/Unit;Lcn/sast/dataflow/interprocedural/analysis/IFact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "excludeMethods", "Lcn/sast/api/report/Counter;", "getExcludeMethods", "()Lcn/sast/api/report/Counter;", "skip", "postCallAtCallSite", "in1", "(Lcn/sast/dataflow/interprocedural/analysis/AIContext;Lsoot/Unit;Lsoot/Unit;Lcn/sast/idfa/analysis/ForwardInterProceduralAnalysis$InvokeResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wideningFunction", "in", "Companion", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nACheckCallAnalysis.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ACheckCallAnalysis.kt\ncn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 CheckerManager.kt\ncn/sast/idfa/check/CallBackManager\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,426:1\n1863#2,2:427\n1863#2:438\n1864#2:440\n1863#2,2:462\n1863#2,2:469\n1863#2,2:487\n1863#2,2:494\n1863#2,2:512\n83#3,3:429\n83#3,3:432\n83#3,3:435\n146#3,2:441\n137#3,14:443\n137#3,5:457\n137#3,5:464\n146#3,2:471\n137#3,14:473\n137#3,5:489\n146#3,2:496\n137#3,14:498\n1#4:439\n*S KotlinDebug\n*F\n+ 1 ACheckCallAnalysis.kt\ncn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis\n*L\n65#1:427,2\n108#1:438\n108#1:440\n199#1:462,2\n214#1:469,2\n254#1:487,2\n293#1:494,2\n329#1:512,2\n80#1:429,3\n86#1:432,3\n92#1:435,3\n157#1:441,2\n157#1:443,14\n199#1:457,5\n214#1:464,5\n254#1:471,2\n254#1:473,14\n293#1:489,5\n329#1:496,2\n329#1:498,14\n*E\n"})
public abstract class ACheckCallAnalysis
extends AJimpleInterProceduralAnalysis<IValue, AIContext> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final CallBackManager callBackManager;
    @NotNull
    private final List<SummaryHandlePackage<IValue>> summaries;
    @NotNull
    private final Counter<SootMethod> excludeMethods;
    @NotNull
    private static KLogger logger = KotlinLogging.INSTANCE.logger(ACheckCallAnalysis::logger$lambda$21);

    public ACheckCallAnalysis(@NotNull AbstractHeapFactory<IValue> hf, @NotNull InterproceduralCFG icfg) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)icfg, (String)"icfg");
        super(hf, icfg);
        this.callBackManager = new CallBackManager();
        this.summaries = new ArrayList();
        this.excludeMethods = new Counter();
    }

    @NotNull
    public final CallBackManager getCallBackManager() {
        return this.callBackManager;
    }

    @NotNull
    public final List<SummaryHandlePackage<IValue>> getSummaries() {
        return this.summaries;
    }

    public final void registerWrapper(@NotNull String smr, boolean isStatic) {
        Intrinsics.checkNotNullParameter((Object)smr, (String)"smr");
        this.registerWrapper(SootUtilsKt.sootSignatureToRef((String)smr, (boolean)isStatic));
    }

    public final void registerWrapper(@NotNull SootMethodRef smr) {
        BriefUnitGraph briefUnitGraph;
        Intrinsics.checkNotNullParameter((Object)smr, (String)"smr");
        SootMethod sm = smr.resolve();
        try {
            Body body = sm.retrieveActiveBody();
            if (body == null) {
                return;
            }
            briefUnitGraph = new BriefUnitGraph(body);
        }
        catch (Exception e) {
            return;
        }
        BriefUnitGraph ug = briefUnitGraph;
        String string = sm.getSignature();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getSignature(...)");
        this.registerJimpleWrapper(string, (UnitGraph)ug);
    }

    public final void registerClassAllWrapper(@NotNull String sc) {
        Intrinsics.checkNotNullParameter((Object)sc, (String)"sc");
        SootClass sootClass = Scene.v().getSootClassUnsafe(sc, true);
        Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getSootClassUnsafe(...)");
        this.registerClassAllWrapper(sootClass);
    }

    public final void registerClassAllWrapper(@NotNull SootClass sc) {
        Intrinsics.checkNotNullParameter((Object)sc, (String)"sc");
        List list = sc.getMethods();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getMethods(...)");
        Iterable $this$forEach$iv = list;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Body body;
            SootMethod sm = (SootMethod)element$iv;
            boolean bl = false;
            if (sm.getSource() == null && !sm.hasActiveBody()) {
                logger.warn(() -> ACheckCallAnalysis.registerClassAllWrapper$lambda$1$lambda$0(sm));
                continue;
            }
            Scene.v().forceResolve(sm.getDeclaringClass().getName(), 3);
            if (sm.retrieveActiveBody() == null) continue;
            BriefUnitGraph ug = new BriefUnitGraph(body);
            String string = sm.getSignature();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getSignature(...)");
            this.registerJimpleWrapper(string, (UnitGraph)ug);
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void evalCallAtCaller(@NotNull String methodSignature, @NotNull Function1<? super CallerSiteCBImpl.EvalCall, kotlin.Unit> prevCall) {
        block0: {
            void this_$iv;
            Intrinsics.checkNotNullParameter((Object)methodSignature, (String)"methodSignature");
            Intrinsics.checkNotNullParameter(prevCall, (String)"prevCall");
            SootMethod sootMethod = Scene.v().grabMethod(methodSignature);
            if (sootMethod == null) break block0;
            SootMethod it = sootMethod;
            boolean bl = false;
            CallBackManager callBackManager = this.callBackManager;
            Function2 cb$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
            boolean $i$f$put = false;
            Class<CallerSiteCBImpl.EvalCall> x$iv = CallerSiteCBImpl.EvalCall.class;
            this_$iv.put(x$iv, it, cb$iv);
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void evalCall(@NotNull String methodSignature, @NotNull Function1<? super CalleeCBImpl.EvalCall, kotlin.Unit> evalCall2) {
        block0: {
            void this_$iv;
            Intrinsics.checkNotNullParameter((Object)methodSignature, (String)"methodSignature");
            Intrinsics.checkNotNullParameter(evalCall2, (String)"evalCall");
            SootMethod sootMethod = Scene.v().grabMethod(methodSignature);
            if (sootMethod == null) break block0;
            SootMethod it = sootMethod;
            boolean bl = false;
            CallBackManager callBackManager = this.callBackManager;
            Function2 cb$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
            boolean $i$f$put = false;
            Class<CalleeCBImpl.EvalCall> x$iv = CalleeCBImpl.EvalCall.class;
            this_$iv.put(x$iv, it, cb$iv);
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void postCallAtCaller(@NotNull String methodSignature, @NotNull Function1<? super CallerSiteCBImpl.PostCall, kotlin.Unit> postCall) {
        block0: {
            void this_$iv;
            Intrinsics.checkNotNullParameter((Object)methodSignature, (String)"methodSignature");
            Intrinsics.checkNotNullParameter(postCall, (String)"postCall");
            SootMethod sootMethod = Scene.v().grabMethod(methodSignature);
            if (sootMethod == null) break block0;
            SootMethod it = sootMethod;
            boolean bl = false;
            CallBackManager callBackManager = this.callBackManager;
            Function2 cb$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
            boolean $i$f$put = false;
            Class<CallerSiteCBImpl.PostCall> x$iv = CallerSiteCBImpl.PostCall.class;
            this_$iv.put(x$iv, it, cb$iv);
        }
    }

    public final void registerJimpleWrapper(@NotNull String methodSignature, @NotNull UnitGraph jimple) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)methodSignature, (String)"methodSignature");
            Intrinsics.checkNotNullParameter((Object)jimple, (String)"jimple");
            SootMethod sootMethod = Scene.v().grabMethod(methodSignature);
            if (sootMethod == null) break block0;
            SootMethod it = sootMethod;
            boolean bl = false;
            this.callBackManager.putUnitGraphOverride(it, jimple);
        }
    }

    public void doAnalysis(@NotNull Collection<? extends SootMethod> entries) {
        Intrinsics.checkNotNullParameter(entries, (String)"entries");
        super.doAnalysis(entries);
        this.excludeMethods.clear();
    }

    public void doAnalysis(@NotNull Collection<? extends SootMethod> entries, @NotNull Collection<? extends SootMethod> methodsMustAnalyze) {
        Intrinsics.checkNotNullParameter(entries, (String)"entries");
        Intrinsics.checkNotNullParameter(methodsMustAnalyze, (String)"methodsMustAnalyze");
        Iterable $this$forEach$iv = this.summaries;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            SummaryHandlePackage it = (SummaryHandlePackage)element$iv;
            boolean bl = false;
            SummaryHandlePackage $this$doAnalysis_u24lambda_u249_u24lambda_u248 = it;
            boolean bl2 = false;
            $this$doAnalysis_u24lambda_u249_u24lambda_u248.register(this);
        }
        super.doAnalysis(entries, methodsMustAnalyze);
    }

    @NotNull
    public DirectedGraph<Unit> getCfg(@NotNull SootMethod method, boolean isAnalyzable) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        UnitGraph unitGraph = this.callBackManager.getUnitGraphOverride(method);
        return unitGraph != null ? (DirectedGraph)unitGraph : super.getCfg(method, isAnalyzable);
    }

    public final void returnPhantom(@NotNull HeapValuesEnv env, @NotNull Stmt node, @NotNull IFact.Builder<IValue> builder2) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter(builder2, (String)"builder");
        if (node.containsInvokeExpr()) {
            InvokeExpr invokeExpr = node.getInvokeExpr();
            if (invokeExpr instanceof InstanceInvokeExpr) {
                Value value = ((InstanceInvokeExpr)invokeExpr).getBase();
                Intrinsics.checkNotNull((Object)value, (String)"null cannot be cast to non-null type soot.Local");
                builder2.summarizeTargetFields((Object)((Local)value));
            }
            int n = invokeExpr.getArgCount();
            for (int i = 0; i < n; ++i) {
                Value argValue = invokeExpr.getArg(i);
                if (!(argValue instanceof Local)) continue;
                builder2.summarizeTargetFields((Object)argValue);
            }
        }
        if (node instanceof DefinitionStmt && ((DefinitionStmt)node).getLeftOp() != null) {
            Value value = ((DefinitionStmt)node).getLeftOp();
            Intrinsics.checkNotNullExpressionValue((Object)value, (String)"getLeftOp(...)");
            Value lhsOp = value;
            if (lhsOp instanceof Local) {
                AbstractHeapFactory abstractHeapFactory = this.getHf();
                AbstractHeapFactory abstractHeapFactory2 = this.getHf();
                Type type = ((DefinitionStmt)node).getRightOp().getType();
                Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
                IFact.Builder.DefaultImpls.assignNewExpr$default(builder2, (HeapValuesEnv)env, (Object)lhsOp, (IHeapValues)abstractHeapFactory.push(env, abstractHeapFactory2.newSummaryVal(env, type, (Object)lhsOp)).markSummaryReturnValueFailedInHook().popHV(), (boolean)false, (int)8, null);
            } else {
                throw new RuntimeException(lhsOp.toString());
            }
        }
    }

    @Nullable
    public Object evalCall(@NotNull AIContext context, @NotNull SootMethod callee, @NotNull Unit node, @NotNull Unit succ, @NotNull IFact<IValue> inValue, @NotNull Continuation<? super ForwardInterProceduralAnalysis.InvokeResult<SootMethod, IFact<IValue>, IHeapValues<IValue>>> $completion) {
        return ACheckCallAnalysis.evalCall$suspendImpl((ACheckCallAnalysis)this, (AIContext)context, (SootMethod)callee, (Unit)node, (Unit)succ, inValue, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ Object evalCall$suspendImpl(ACheckCallAnalysis var0, AIContext var1_1, SootMethod var2_2, Unit var3_3, Unit var4_4, IFact<IValue> var5_5, Continuation<? super ForwardInterProceduralAnalysis.InvokeResult<SootMethod, IFact<IValue>, IHeapValues<IValue>>> $completion) {
        if (!($completion instanceof evalCall.2)) ** GOTO lbl-1000
        var24_7 = $completion;
        if ((var24_7.label & -2147483648) != 0) {
            var24_7.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var25_9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                curValue = inValue.builder();
                caller = (SootMethod)context.getMethod();
                hasEvalCall = 0;
                var11_13 = $this.callBackManager;
                var12_14 = new Object[]{node, callee};
                keys$iv = var12_14;
                $i$f$get = false;
                for (Object key$iv : keys$iv) {
                    this_$iv$iv = this_$iv;
                    $i$f$get = false;
                    x$iv$iv = CallerSiteCBImpl.EvalCall.class;
                    var20_27 = key$iv;
                    if (var20_27 instanceof Unit) {
                        v0 = this_$iv$iv.get(x$iv$iv, (Unit)key$iv);
                    } else if (var20_27 instanceof SootMethod) {
                        v0 = this_$iv$iv.get(x$iv$iv, (SootMethod)key$iv);
                    } else {
                        var21_29 = key$iv.getClass() + ": " + key$iv;
                        throw new NotImplementedError("An operation is not implemented: " + var21_29);
                    }
                    if ((v1 = (r$iv = v0)) == null) {
                        continue;
                    }
                    ** GOTO lbl36
                }
                v1 = null;
lbl36:
                // 2 sources

                cbs = v1;
                lastResult = null;
                if (cbs == null) ** GOTO lbl97
                env = $this.getHf().env((AIContext)context, node);
                var13_16 = cbs.iterator();
lbl41:
                // 3 sources

                while (var13_16.hasNext()) {
                    cb = (Function2)var13_16.next();
                    bak = curValue.build();
                    v2 = $this.getHf();
                    Intrinsics.checkNotNull((Object)node, (String)"null cannot be cast to non-null type soot.jimple.Stmt");
                    v3 = (Stmt)node;
                    v4 = callee.getReturnType();
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"getReturnType(...)");
                    callerCB = new CallerSiteCBImpl(v2, caller, v3, curValue, v4, env);
                    evalCall = new CallerSiteCBImpl.EvalCall(callerCB);
                    $continuation.L$0 = $this;
                    $continuation.L$1 = callee;
                    $continuation.L$2 = node;
                    $continuation.L$3 = curValue;
                    $continuation.L$4 = caller;
                    $continuation.L$5 = lastResult;
                    $continuation.L$6 = env;
                    $continuation.L$7 = var13_16;
                    $continuation.L$8 = bak;
                    $continuation.L$9 = evalCall;
                    $continuation.I$0 = hasEvalCall;
                    $continuation.label = 1;
                    v5 = cb.invoke((Object)evalCall, (Object)$continuation);
                    ** if (v5 != var25_9) goto lbl68
lbl67:
                    // 1 sources

                    return var25_9;
lbl68:
                    // 1 sources

                    ** GOTO lbl86
                }
                ** GOTO lbl97
            }
            case 1: {
                hasEvalCall = $continuation.I$0;
                evalCall = (CallerSiteCBImpl.EvalCall)$continuation.L$9;
                bak = (IFact)$continuation.L$8;
                var13_16 = (Iterator<E>)$continuation.L$7;
                env = (HookEnv)$continuation.L$6;
                lastResult = (IHeapValues)$continuation.L$5;
                caller = (SootMethod)$continuation.L$4;
                curValue = (IFact.Builder)$continuation.L$3;
                node = (Unit)$continuation.L$2;
                callee = (SootMethod)$continuation.L$1;
                $this = (ACheckCallAnalysis)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl86:
                    // 2 sources

                    if (!evalCall.isEvalAble()) ** GOTO lbl41
                    curValue = evalCall.getOut();
                    hasEvalCall = 1;
                    lastResult = evalCall.getReturn();
                }
                catch (CancellationException e) {
                    throw e;
                }
                catch (Exception e) {
                    ACheckCallAnalysis.logger.error((Throwable)e, (Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, evalCall$lambda$10(), ()Ljava/lang/Object;)());
                    curValue = bak.builder();
                    ** GOTO lbl41
                }
lbl97:
                // 3 sources

                if (hasEvalCall != 0) {
                    return new ForwardInterProceduralAnalysis.InvokeResult((Object)callee, (Object)curValue.build(), (Object)lastResult);
                }
                return null;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public Object computeEntryValue(@NotNull AIContext context, @NotNull Continuation<? super IFact<IValue>> $completion) {
        return ACheckCallAnalysis.computeEntryValue$suspendImpl((ACheckCallAnalysis)this, (AIContext)context, $completion);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    static /* synthetic */ Object computeEntryValue$suspendImpl(ACheckCallAnalysis var0, AIContext var1_1, Continuation<? super IFact<IValue>> $completion) {
        block33: {
            if (!($completion instanceof computeEntryValue.1)) ** GOTO lbl-1000
            var23_3 = $completion;
            if ((var23_3.label & -2147483648) != 0) {
                var23_3.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new /* Unavailable Anonymous Inner Class!! */;
            }
            $result = $continuation.result;
            var24_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    var21_7 = curValue = new Ref.ObjectRef();
                    $continuation.L$0 = $this;
                    $continuation.L$1 = context;
                    $continuation.L$2 = curValue;
                    $continuation.L$3 = var21_7;
                    $continuation.label = 1;
                    v0 = super.computeEntryValue((Context)context, (Continuation)$continuation);
                    if (v0 == var24_5) {
                        return var24_5;
                    }
                    ** GOTO lbl29
                }
                case 1: {
                    var21_7 = (Ref.ObjectRef)$continuation.L$3;
                    curValue = (Ref.ObjectRef)$continuation.L$2;
                    context = (AIContext)$continuation.L$1;
                    $this = (ACheckCallAnalysis)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl29:
                    // 2 sources

                    var21_7.element = ((IFact)v0).builder();
                    if (!((IFact.Builder)curValue.element).isValid()) {
                        return ((IFact.Builder)curValue.element).build();
                    }
                    v1 = context.getControlFlowGraph().getHeads();
                    Intrinsics.checkNotNullExpressionValue((Object)v1, (String)"getHeads(...)");
                    node = (Unit)CollectionsKt.first((List)v1);
                    callee = (SootMethod)context.getMethod();
                    v2 = $this.getHf();
                    Intrinsics.checkNotNull((Object)node);
                    env = v2.env(context, node);
                    this_$iv = $this.callBackManager;
                    $i$f$get = false;
                    x$iv = CalleeCBImpl.PrevCall.class;
                    var10_14 = callee;
                    if (var10_14 instanceof Unit) {
                        v3 = this_$iv.get((Class)x$iv, (Unit)callee);
                    } else if (var10_14 instanceof SootMethod) {
                        v3 = this_$iv.get((Class)x$iv, callee);
                    } else {
                        var11_15 = callee.getClass() + ": " + callee;
                        throw new NotImplementedError("An operation is not implemented: " + var11_15);
                    }
                    if (v3 == null) break;
                    $this$forEach$iv = v3;
                    $i$f$forEach = false;
                    x$iv = $this$forEach$iv.iterator();
lbl55:
                    // 2 sources

                    while (x$iv.hasNext()) {
                        element$iv /* !! */  = x$iv.next();
                        it /* !! */  = (Function2)element$iv /* !! */ ;
                        $i$a$-forEach-ACheckCallAnalysis$computeEntryValue$2 = false;
                        bak = ((IFact.Builder)curValue.element).build();
                        v4 = $this.getHf();
                        Intrinsics.checkNotNull((Object)node, (String)"null cannot be cast to non-null type soot.jimple.Stmt");
                        calleeCB = new CalleeCBImpl(v4, callee, (Stmt)node, (IFact.Builder)curValue.element, env);
                        prevCall = new CalleeCBImpl.PrevCall(calleeCB);
                        var16_21 = curValue;
                        var17_24 = var16_21;
                        $continuation.L$0 = $this;
                        $continuation.L$1 = context;
                        $continuation.L$2 = curValue;
                        $continuation.L$3 = node;
                        $continuation.L$4 = callee;
                        $continuation.L$5 = env;
                        $continuation.L$6 = x$iv;
                        $continuation.L$7 = bak;
                        $continuation.L$8 = prevCall;
                        $continuation.L$9 = var16_21;
                        $continuation.L$10 = var17_24;
                        $continuation.label = 2;
                        v5 = it /* !! */ .invoke((Object)prevCall, (Object)$continuation);
                        ** if (v5 != var24_5) goto lbl83
lbl82:
                        // 1 sources

                        return var24_5;
lbl83:
                        // 1 sources

                        ** GOTO lbl103
                    }
                    break;
                }
                case 2: {
                    $i$f$forEach = false;
                    $i$a$-forEach-ACheckCallAnalysis$computeEntryValue$2 = false;
                    var17_24 = (Ref.ObjectRef)$continuation.L$10;
                    var16_21 = (Ref.ObjectRef)$continuation.L$9;
                    prevCall = (CalleeCBImpl.PrevCall)$continuation.L$8;
                    bak = (IFact)$continuation.L$7;
                    x$iv = (Iterator)$continuation.L$6;
                    env = (HookEnv)$continuation.L$5;
                    callee = (SootMethod)$continuation.L$4;
                    node = (Unit)$continuation.L$3;
                    curValue = (Ref.ObjectRef)$continuation.L$2;
                    context = (AIContext)$continuation.L$1;
                    $this = (ACheckCallAnalysis)$continuation.L$0;
                    try {
                        ResultKt.throwOnFailure((Object)$result);
                        v5 = $result;
lbl103:
                        // 2 sources

                        v6 = var17_24;
                        var19_25 = prevCall.getOut();
                    }
                    catch (CancellationException var20_27) {
                        v7 = var16_21;
                        throw e;
                    }
                    catch (Exception e) {
                        v6 = var16_21;
                        ACheckCallAnalysis.logger.error((Throwable)e, (Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, computeEntryValue$lambda$12$lambda$11(), ()Ljava/lang/Object;)());
                        var19_25 = bak.builder();
                    }
                    v6.element = var19_25;
                    ** GOTO lbl55
                }
            }
            this_$iv = $this.callBackManager;
            $i$f$get = false;
            x$iv = CalleeCBImpl.EvalCall.class;
            element$iv /* !! */  = callee;
            if (element$iv /* !! */  instanceof Unit) {
                v8 = this_$iv.get((Class)x$iv, (Unit)callee);
            } else if (element$iv /* !! */  instanceof SootMethod) {
                v8 = this_$iv.get((Class)x$iv, callee);
            } else {
                it /* !! */  = callee.getClass() + ": " + callee;
                throw new NotImplementedError("An operation is not implemented: " + (String)it /* !! */ );
            }
            if (v8 == null) break block33;
            $this$forEach$iv = v8;
            $i$f$forEach = false;
            var9_13 = $this$forEach$iv.iterator();
lbl134:
            // 3 sources

            while (var9_13.hasNext()) {
                element$iv /* !! */  = var9_13.next();
                it /* !! */  = (Function2)element$iv /* !! */ ;
                $i$a$-forEach-ACheckCallAnalysis$computeEntryValue$3 = false;
                bak = ((IFact.Builder)curValue.element).build();
                v9 = $this.getHf();
                Intrinsics.checkNotNull((Object)node, (String)"null cannot be cast to non-null type soot.jimple.Stmt");
                calleeCB = new CalleeCBImpl(v9, callee, (Stmt)node, (IFact.Builder)curValue.element, env);
                evalCall = new CalleeCBImpl.EvalCall(calleeCB);
                $continuation.L$0 = $this;
                $continuation.L$1 = context;
                $continuation.L$2 = curValue;
                $continuation.L$3 = node;
                $continuation.L$4 = callee;
                $continuation.L$5 = env;
                $continuation.L$6 = var9_13;
                $continuation.L$7 = bak;
                $continuation.L$8 = evalCall;
                $continuation.L$9 = null;
                $continuation.L$10 = null;
                $continuation.label = 3;
                v10 = it /* !! */ .invoke((Object)evalCall, (Object)$continuation);
                ** if (v10 != var24_5) goto lbl160
lbl159:
                // 1 sources

                return var24_5;
lbl160:
                // 1 sources

                ** GOTO lbl178
            }
            {
                break;
                case 3: {
                    $i$f$forEach = false;
                    $i$a$-forEach-ACheckCallAnalysis$computeEntryValue$3 = false;
                    evalCall = (CalleeCBImpl.EvalCall)$continuation.L$8;
                    bak = (IFact)$continuation.L$7;
                    var9_13 = (Iterator<T>)$continuation.L$6;
                    env = (HookEnv)$continuation.L$5;
                    callee = (SootMethod)$continuation.L$4;
                    node = (Unit)$continuation.L$3;
                    curValue = (Ref.ObjectRef)$continuation.L$2;
                    context = (AIContext)$continuation.L$1;
                    $this = (ACheckCallAnalysis)$continuation.L$0;
                    try {
                        ResultKt.throwOnFailure((Object)$result);
                        v10 = $result;
lbl178:
                        // 2 sources

                        if (evalCall.isEvalAble()) {
                            curValue.element = evalCall.getOut();
                            context.clearWorkList();
                            context.setSkipAnalysis(true);
                            cfg = context.getControlFlowGraph();
                            exitValue = ((IFact.Builder)curValue.element).build();
                            for (Unit tailNode : cfg.getTails()) {
                                Intrinsics.checkNotNull((Object)tailNode);
                                context.setEdgeValue((Object)tailNode, (Object)tailNode, (Object)exitValue);
                            }
                            return exitValue;
                        }
                        $this.returnPhantom((HeapValuesEnv)env, (Stmt)node, (IFact.Builder)curValue.element);
                        ** GOTO lbl134
                    }
                    catch (CancellationException e) {
                        throw e;
                    }
                    catch (Exception e) {
                        ACheckCallAnalysis.logger.error((Throwable)e, (Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, computeEntryValue$lambda$14$lambda$13(), ()Ljava/lang/Object;)());
                        curValue.element = bak.builder();
                        ** GOTO lbl134
                    }
                }
            }
        }
        return ((IFact.Builder)curValue.element).build();
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public Object prevCallFunction(@NotNull AIContext context, @NotNull SootMethod callee, @NotNull Unit node, @NotNull Unit succ, @NotNull IFact<IValue> callSiteValue, @NotNull Continuation<? super IFact<IValue>> $completion) {
        return ACheckCallAnalysis.prevCallFunction$suspendImpl((ACheckCallAnalysis)this, (AIContext)context, (SootMethod)callee, (Unit)node, (Unit)succ, callSiteValue, $completion);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    static /* synthetic */ Object prevCallFunction$suspendImpl(ACheckCallAnalysis var0, AIContext var1_1, SootMethod var2_2, Unit var3_3, Unit var4_4, IFact<IValue> var5_5, Continuation<? super IFact<IValue>> $completion) {
        if (!($completion instanceof prevCallFunction.1)) ** GOTO lbl-1000
        var25_7 = $completion;
        if ((var25_7.label & -2147483648) != 0) {
            var25_7.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var26_9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                caller = (SootMethod)context.getMethod();
                curValue = new Ref.ObjectRef();
                curValue.element = callSiteValue.builder();
                env = $this.getHf().env((AIContext)context, node);
                var10_13 = $this.callBackManager;
                var11_14 = new Object[]{node, callee};
                keys$iv = var11_14;
                $i$f$get = false;
                for (Object key$iv : keys$iv) {
                    this_$iv$iv = this_$iv;
                    $i$f$get = false;
                    x$iv$iv = CallerSiteCBImpl.PrevCall.class;
                    var19_28 /* !! */  = key$iv;
                    if (var19_28 /* !! */  instanceof Unit) {
                        v0 = this_$iv$iv.get(x$iv$iv, (Unit)key$iv);
                    } else if (var19_28 /* !! */  instanceof SootMethod) {
                        v0 = this_$iv$iv.get(x$iv$iv, (SootMethod)key$iv);
                    } else {
                        var20_30 = key$iv.getClass() + ": " + key$iv;
                        throw new NotImplementedError("An operation is not implemented: " + var20_30);
                    }
                    if ((v1 = (r$iv = v0)) == null) {
                        continue;
                    }
                    ** GOTO lbl37
                }
                v1 = null;
lbl37:
                // 2 sources

                if (v1 == null) break;
                $this$forEach$iv = v1;
                $i$f$forEach = false;
                var12_17 = $this$forEach$iv.iterator();
lbl41:
                // 2 sources

                while (var12_17.hasNext()) {
                    element$iv = var12_17.next();
                    it = (Function2)element$iv;
                    $i$a$-forEach-ACheckCallAnalysis$prevCallFunction$2 = false;
                    bak = ((IFact.Builder)curValue.element).build();
                    v2 = $this.getHf();
                    Intrinsics.checkNotNull((Object)node, (String)"null cannot be cast to non-null type soot.jimple.Stmt");
                    v3 = (Stmt)node;
                    v4 = (IFact.Builder)curValue.element;
                    v5 = callee.getReturnType();
                    Intrinsics.checkNotNullExpressionValue((Object)v5, (String)"getReturnType(...)");
                    callerCB = new CallerSiteCBImpl(v2, caller, v3, v4, v5, env);
                    prevCall = new CallerSiteCBImpl.PrevCall(callerCB);
                    var19_28 /* !! */  = curValue;
                    var20_31 = var19_28 /* !! */ ;
                    $continuation.L$0 = $this;
                    $continuation.L$1 = callee;
                    $continuation.L$2 = node;
                    $continuation.L$3 = caller;
                    $continuation.L$4 = curValue;
                    $continuation.L$5 = env;
                    $continuation.L$6 = var12_17;
                    $continuation.L$7 = bak;
                    $continuation.L$8 = prevCall;
                    $continuation.L$9 = var19_28 /* !! */ ;
                    $continuation.L$10 = var20_31;
                    $continuation.label = 1;
                    v6 = it.invoke((Object)prevCall, (Object)$continuation);
                    ** if (v6 != var26_9) goto lbl73
lbl72:
                    // 1 sources

                    return var26_9;
lbl73:
                    // 1 sources

                    ** GOTO lbl93
                }
                break;
            }
            case 1: {
                $i$f$forEach = false;
                $i$a$-forEach-ACheckCallAnalysis$prevCallFunction$2 = false;
                var20_31 = (Ref.ObjectRef)$continuation.L$10;
                var19_28 /* !! */  = (Ref.ObjectRef)$continuation.L$9;
                prevCall = (CallerSiteCBImpl.PrevCall)$continuation.L$8;
                bak = (IFact)$continuation.L$7;
                var12_17 = (Iterator<T>)$continuation.L$6;
                env = (HookEnv)$continuation.L$5;
                curValue = (Ref.ObjectRef)$continuation.L$4;
                caller = (SootMethod)$continuation.L$3;
                node = (Unit)$continuation.L$2;
                callee = (SootMethod)$continuation.L$1;
                $this = (ACheckCallAnalysis)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v6 = $result;
lbl93:
                    // 2 sources

                    v7 = var20_31;
                    var22_32 = prevCall.getOut();
                }
                catch (CancellationException var23_34) {
                    v8 = var19_28 /* !! */ ;
                    throw e;
                }
                catch (Exception e) {
                    v7 = var19_28 /* !! */ ;
                    ACheckCallAnalysis.logger.error((Throwable)e, (Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, prevCallFunction$lambda$16$lambda$15(), ()Ljava/lang/Object;)());
                    var22_32 = bak.builder();
                }
                v7.element = var22_32;
                ** GOTO lbl41
            }
        }
        return ((IFact.Builder)curValue.element).build();
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public IFact<IValue> computeExitValue(@NotNull AIContext context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        IFact exit = (IFact)super.computeExitValue((Context)context);
        if (exit.isBottom()) {
            return exit;
        }
        SootMethod callee = (SootMethod)context.getMethod();
        List list = context.getControlFlowGraph().getTails();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getTails(...)");
        Object object = CollectionsKt.first((List)list);
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type soot.jimple.Stmt");
        Stmt tail = (Stmt)object;
        HeapValuesEnv env = this.getHf().env((Unit)tail);
        IFact.Builder exitBuilder = exit.builder();
        exitBuilder.gc();
        return exitBuilder.build();
    }

    @Nullable
    public Object returnFlowFunction(@NotNull AIContext context, @NotNull Unit node, @NotNull IFact<IValue> returnValue, @NotNull Continuation<? super IFact<IValue>> $completion) {
        return ACheckCallAnalysis.returnFlowFunction$suspendImpl((ACheckCallAnalysis)this, (AIContext)context, (Unit)node, returnValue, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ Object returnFlowFunction$suspendImpl(ACheckCallAnalysis var0, AIContext var1_1, Unit var2_2, IFact<IValue> var3_3, Continuation<? super IFact<IValue>> $completion) {
        if (!($completion instanceof returnFlowFunction.1)) ** GOTO lbl-1000
        var24_5 = $completion;
        if ((var24_5.label & -2147483648) != 0) {
            var24_5.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var25_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                callee = (SootMethod)context.getMethod();
                env = $this.getHf().env((AIContext)context, (Unit)node);
                var9_10 = context.getControlFlowGraph().getTails();
                Intrinsics.checkNotNullExpressionValue((Object)var9_10, (String)"getTails(...)");
                v0 = CollectionsKt.first((List)var9_10);
                Intrinsics.checkNotNull((Object)v0, (String)"null cannot be cast to non-null type soot.jimple.Stmt");
                tail = (Stmt)v0;
                curValue = new Ref.ObjectRef();
                curValue.element = returnValue.builder();
                this_$iv = $this.callBackManager;
                $i$f$get = false;
                x$iv = CalleeCBImpl.PostCall.class;
                var13_16 = callee;
                if (var13_16 instanceof Unit) {
                    v1 = this_$iv.get(x$iv, (Unit)callee);
                } else if (var13_16 instanceof SootMethod) {
                    v1 = this_$iv.get(x$iv, callee);
                } else {
                    var14_17 = callee.getClass() + ": " + callee;
                    throw new NotImplementedError("An operation is not implemented: " + var14_17);
                }
                if (v1 == null) break;
                $this$forEach$iv = v1;
                $i$f$forEach = false;
                var12_15 = $this$forEach$iv.iterator();
lbl37:
                // 2 sources

                while (var12_15.hasNext()) {
                    element$iv = var12_15.next();
                    it = (Function2)element$iv;
                    $i$a$-forEach-ACheckCallAnalysis$returnFlowFunction$2 = false;
                    bak = ((IFact.Builder)curValue.element).build();
                    calleeCB = new CalleeCBImpl($this.getHf(), callee, tail, (IFact.Builder)curValue.element, env);
                    postCall = new CalleeCBImpl.PostCall(calleeCB);
                    var19_23 = curValue;
                    var20_24 = var19_23;
                    $continuation.L$0 = $this;
                    $continuation.L$1 = callee;
                    $continuation.L$2 = env;
                    $continuation.L$3 = tail;
                    $continuation.L$4 = curValue;
                    $continuation.L$5 = var12_15;
                    $continuation.L$6 = bak;
                    $continuation.L$7 = postCall;
                    $continuation.L$8 = var19_23;
                    $continuation.L$9 = var20_24;
                    $continuation.label = 1;
                    v2 = it.invoke((Object)postCall, (Object)$continuation);
                    ** if (v2 != var25_7) goto lbl62
lbl61:
                    // 1 sources

                    return var25_7;
lbl62:
                    // 1 sources

                    ** GOTO lbl81
                }
                break;
            }
            case 1: {
                $i$f$forEach = false;
                $i$a$-forEach-ACheckCallAnalysis$returnFlowFunction$2 = false;
                var20_24 = (Ref.ObjectRef)$continuation.L$9;
                var19_23 = (Ref.ObjectRef)$continuation.L$8;
                postCall = (CalleeCBImpl.PostCall)$continuation.L$7;
                bak = (IFact)$continuation.L$6;
                var12_15 = (Iterator<T>)$continuation.L$5;
                curValue = (Ref.ObjectRef)$continuation.L$4;
                tail = (Stmt)$continuation.L$3;
                env = (HookEnv)$continuation.L$2;
                callee = (SootMethod)$continuation.L$1;
                $this = (ACheckCallAnalysis)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v2 = $result;
lbl81:
                    // 2 sources

                    v3 = var20_24;
                    var21_25 = postCall.getOut();
                }
                catch (CancellationException var22_27) {
                    v4 = var19_23;
                    throw e;
                }
                catch (Exception e) {
                    v3 = var19_23;
                    ACheckCallAnalysis.logger.error((Throwable)e, (Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, returnFlowFunction$lambda$18$lambda$17(), ()Ljava/lang/Object;)());
                    var21_25 = bak.builder();
                }
                v3.element = var21_25;
                ** GOTO lbl37
            }
        }
        return ((IFact.Builder)curValue.element).build();
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public final Counter<SootMethod> getExcludeMethods() {
        return this.excludeMethods;
    }

    public void skip(@NotNull SootMethod callee) {
        Intrinsics.checkNotNullParameter((Object)callee, (String)"callee");
        this.excludeMethods.count((Object)callee);
    }

    @Nullable
    public Object postCallAtCallSite(@NotNull AIContext context, @NotNull Unit node, @NotNull Unit succ, @NotNull ForwardInterProceduralAnalysis.InvokeResult<SootMethod, IFact<IValue>, IHeapValues<IValue>> in1, @NotNull Continuation<? super ForwardInterProceduralAnalysis.InvokeResult<SootMethod, IFact<IValue>, IHeapValues<IValue>>> $completion) {
        return ACheckCallAnalysis.postCallAtCallSite$suspendImpl((ACheckCallAnalysis)this, (AIContext)context, (Unit)node, (Unit)succ, in1, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ Object postCallAtCallSite$suspendImpl(ACheckCallAnalysis var0, AIContext var1_1, Unit var2_2, Unit var3_3, ForwardInterProceduralAnalysis.InvokeResult<SootMethod, IFact<IValue>, IHeapValues<IValue>> var4_4, Continuation<? super ForwardInterProceduralAnalysis.InvokeResult<SootMethod, IFact<IValue>, IHeapValues<IValue>>> $completion) {
        if (!($completion instanceof postCallAtCallSite.1)) ** GOTO lbl-1000
        var26_6 = $completion;
        if ((var26_6.label & -2147483648) != 0) {
            var26_6.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var27_8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                caller = (SootMethod)context.getMethod();
                callee = (SootMethod)in1.getCallee();
                curValue = (IFact)in1.getCallSiteOutAbstract();
                curBuilder = new Ref.ObjectRef();
                curBuilder.element = curValue.builder();
                change = new Ref.BooleanRef();
                lastResult = new Ref.ObjectRef();
                lastResult.element = in1.getResultValue();
                env = $this.getHf().env((AIContext)context, node);
                var13_16 = $this.callBackManager;
                var14_17 = new Object[]{node, callee};
                keys$iv = var14_17;
                $i$f$get = false;
                for (Object key$iv : keys$iv) {
                    this_$iv$iv = this_$iv;
                    $i$f$get = false;
                    x$iv$iv = CallerSiteCBImpl.PostCall.class;
                    var22_31 = key$iv;
                    if (var22_31 instanceof Unit) {
                        v0 = this_$iv$iv.get(x$iv$iv, (Unit)key$iv);
                    } else if (var22_31 instanceof SootMethod) {
                        v0 = this_$iv$iv.get(x$iv$iv, (SootMethod)key$iv);
                    } else {
                        var23_35 = key$iv.getClass() + ": " + key$iv;
                        throw new NotImplementedError("An operation is not implemented: " + var23_35);
                    }
                    if ((v1 = (r$iv = v0)) == null) {
                        continue;
                    }
                    ** GOTO lbl42
                }
                v1 = null;
lbl42:
                // 2 sources

                if (v1 == null) break;
                $this$forEach$iv = v1;
                $i$f$forEach = false;
                var15_20 = $this$forEach$iv.iterator();
lbl46:
                // 3 sources

                while (var15_20.hasNext()) {
                    element$iv = var15_20.next();
                    it = (Function2)element$iv;
                    $i$a$-forEach-ACheckCallAnalysis$postCallAtCallSite$2 = false;
                    bak = ((IFact.Builder)curBuilder.element).build();
                    v2 = $this.getHf();
                    Intrinsics.checkNotNull((Object)node, (String)"null cannot be cast to non-null type soot.jimple.Stmt");
                    v3 = (Stmt)node;
                    v4 = (IFact.Builder)curBuilder.element;
                    v5 = callee.getReturnType();
                    Intrinsics.checkNotNullExpressionValue((Object)v5, (String)"getReturnType(...)");
                    callerCB = new CallerSiteCBImpl(v2, caller, v3, v4, v5, env);
                    v6 = (IHeapValues)lastResult.element;
                    v7 = v6 != null ? v6.isNotEmpty() : false;
                    if (v7) {
                        v8 = lastResult.element;
                        Intrinsics.checkNotNull((Object)v8);
                        callerCB.setReturn((IHeapValues)v8);
                    }
                    postCall = new CallerSiteCBImpl.PostCall(callerCB);
                    $continuation.L$0 = $this;
                    $continuation.L$1 = node;
                    $continuation.L$2 = in1;
                    $continuation.L$3 = caller;
                    $continuation.L$4 = callee;
                    $continuation.L$5 = curBuilder;
                    $continuation.L$6 = change;
                    $continuation.L$7 = lastResult;
                    $continuation.L$8 = env;
                    $continuation.L$9 = var15_20;
                    $continuation.L$10 = bak;
                    $continuation.L$11 = postCall;
                    $continuation.label = 1;
                    v9 = it.invoke((Object)postCall, (Object)$continuation);
                    ** if (v9 != var27_8) goto lbl83
lbl82:
                    // 1 sources

                    return var27_8;
lbl83:
                    // 1 sources

                    ** GOTO lbl104
                }
                break;
            }
            case 1: {
                $i$f$forEach = false;
                $i$a$-forEach-ACheckCallAnalysis$postCallAtCallSite$2 = false;
                postCall = (CallerSiteCBImpl.PostCall)$continuation.L$11;
                bak = (IFact)$continuation.L$10;
                var15_20 = (Iterator<T>)$continuation.L$9;
                env = (HookEnv)$continuation.L$8;
                lastResult = (Ref.ObjectRef)$continuation.L$7;
                change = (Ref.BooleanRef)$continuation.L$6;
                curBuilder = (Ref.ObjectRef)$continuation.L$5;
                callee = (SootMethod)$continuation.L$4;
                caller = (SootMethod)$continuation.L$3;
                in1 = (ForwardInterProceduralAnalysis.InvokeResult)$continuation.L$2;
                node = (Unit)$continuation.L$1;
                $this = (ACheckCallAnalysis)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v9 = $result;
lbl104:
                    // 2 sources

                    curBuilder.element = postCall.getOut();
                    change.element = true;
                    lastResult.element = postCall.getReturn();
                    ** GOTO lbl46
                }
                catch (CancellationException e) {
                    throw e;
                }
                catch (Exception e) {
                    ACheckCallAnalysis.logger.error((Throwable)e, (Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, postCallAtCallSite$lambda$20$lambda$19(), ()Ljava/lang/Object;)());
                    curBuilder.element = bak.builder();
                    ** GOTO lbl46
                }
            }
        }
        if (!change.element) {
            return in1;
        }
        return ForwardInterProceduralAnalysis.InvokeResult.copy$default((ForwardInterProceduralAnalysis.InvokeResult)in1, null, (Object)((IFact.Builder)curBuilder.element).build(), (Object)lastResult.element, (int)1, null);
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public IFact<IValue> wideningFunction(@NotNull AIContext context, @NotNull Unit node, @NotNull Unit succ, @NotNull IFact<IValue> in) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter((Object)succ, (String)"succ");
        Intrinsics.checkNotNullParameter(in, (String)"in");
        IFact.Builder out = in.builder();
        Set oldSlots = in.getSlots();
        HeapValuesEnv env = this.getHf().env(node);
        for (Object local : oldSlots) {
            IHeapValues target = in.getTargets(local);
            IValue iValue = (IValue)CollectionsKt.firstOrNull((Iterable)((Iterable)target.getValues()));
            Object anyType = iValue != null ? iValue.getType() : null;
            if (!(anyType instanceof PrimType)) continue;
            CompanionV summary = this.getHf().push(env, this.getHf().newSummaryVal(env, anyType, (Object)WideningPrimitive.INSTANCE)).markOfWideningSummary().pop();
            IHeapValues.Builder builder2 = out.getTargets(local).builder();
            builder2.add(summary);
            IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)out, (HeapValuesEnv)env, local, (IHeapValues)builder2.build(), (boolean)false, (int)8, null);
        }
        return out.build();
    }

    public boolean isAnalyzable(@NotNull SootMethod callee, @NotNull IFact<IValue> in1) {
        Intrinsics.checkNotNullParameter((Object)callee, (String)"callee");
        Intrinsics.checkNotNullParameter(in1, (String)"in1");
        if (this.callBackManager.getUnitGraphOverride(callee) != null) {
            return true;
        }
        if (!super.isAnalyzable(callee, in1)) {
            return false;
        }
        if (ACheckCallAnalysisKt.getExcludeSubSignature().contains(callee.getSubSignature())) {
            return false;
        }
        int hit = this.excludeMethods.get((Object)callee);
        if (hit > 0) {
            if (callee.getDeclaringClass().isApplicationClass()) {
                if (hit > 2) {
                    return false;
                }
            } else {
                return false;
            }
        }
        DirectedGraph cfg = this.getCfg(callee, true);
        int dataFlowMethodUnitsSizeLimit = ExtSettings.INSTANCE.getDataFlowMethodUnitsSizeLimit();
        return dataFlowMethodUnitsSizeLimit <= 0 || cfg.size() <= dataFlowMethodUnitsSizeLimit;
    }

    private static final Object registerClassAllWrapper$lambda$1$lambda$0(SootMethod $sm) {
        return "method source of " + $sm + " is null";
    }

    private static final /* synthetic */ Object evalCallAtCaller$lambda$2$suspendConversion0(Function1 $this$evalCallAtCaller_u24lambda_u242_u24suspendConversion0, CallerSiteCBImpl.EvalCall p0, Continuation $completion) {
        $this$evalCallAtCaller_u24lambda_u242_u24suspendConversion0.invoke((Object)p0);
        return kotlin.Unit.INSTANCE;
    }

    private static final /* synthetic */ Object evalCall$lambda$4$suspendConversion0$3(Function1 $this$evalCall_u24lambda_u244_u24suspendConversion0_u243, CalleeCBImpl.EvalCall p0, Continuation $completion) {
        $this$evalCall_u24lambda_u244_u24suspendConversion0_u243.invoke((Object)p0);
        return kotlin.Unit.INSTANCE;
    }

    private static final /* synthetic */ Object postCallAtCaller$lambda$6$suspendConversion0$5(Function1 $this$postCallAtCaller_u24lambda_u246_u24suspendConversion0_u245, CallerSiteCBImpl.PostCall p0, Continuation $completion) {
        $this$postCallAtCaller_u24lambda_u246_u24suspendConversion0_u245.invoke((Object)p0);
        return kotlin.Unit.INSTANCE;
    }

    private static final Object evalCall$lambda$10() {
        return "IR intercept exception";
    }

    private static final Object computeEntryValue$lambda$12$lambda$11() {
        return "IR intercept exception";
    }

    private static final Object computeEntryValue$lambda$14$lambda$13() {
        return "IR intercept exception";
    }

    private static final Object prevCallFunction$lambda$16$lambda$15() {
        return "IR intercept exception";
    }

    private static final Object returnFlowFunction$lambda$18$lambda$17() {
        return "IR intercept exception";
    }

    private static final Object postCallAtCallSite$lambda$20$lambda$19() {
        return "IR intercept exception";
    }

    private static final kotlin.Unit logger$lambda$21() {
        return kotlin.Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$evalCallAtCaller$lambda$2$suspendConversion0(Function1 $receiver, CallerSiteCBImpl.EvalCall p0, Continuation $completion) {
        return ACheckCallAnalysis.evalCallAtCaller$lambda$2$suspendConversion0((Function1)$receiver, (CallerSiteCBImpl.EvalCall)p0, (Continuation)$completion);
    }

    public static final /* synthetic */ Object access$evalCall$lambda$4$suspendConversion0$3(Function1 $receiver, CalleeCBImpl.EvalCall p0, Continuation $completion) {
        return ACheckCallAnalysis.evalCall$lambda$4$suspendConversion0$3((Function1)$receiver, (CalleeCBImpl.EvalCall)p0, (Continuation)$completion);
    }

    public static final /* synthetic */ Object access$postCallAtCaller$lambda$6$suspendConversion0$5(Function1 $receiver, CallerSiteCBImpl.PostCall p0, Continuation $completion) {
        return ACheckCallAnalysis.postCallAtCaller$lambda$6$suspendConversion0$5((Function1)$receiver, (CallerSiteCBImpl.PostCall)p0, (Continuation)$completion);
    }
}

