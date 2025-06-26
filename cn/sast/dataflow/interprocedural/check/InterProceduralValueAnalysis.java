/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ExtSettings
 *  cn.sast.api.config.StaticFieldTrackingMode
 *  cn.sast.api.util.SootUtilsKt
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.AIContext
 *  cn.sast.dataflow.interprocedural.analysis.AJimpleInterProceduralAnalysisKt
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv
 *  cn.sast.dataflow.interprocedural.analysis.CallStackContext
 *  cn.sast.dataflow.interprocedural.analysis.EntryParam
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IProblemIteratorTerminal
 *  cn.sast.dataflow.interprocedural.analysis.IVGlobal
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.PointsToGraphAbstract
 *  cn.sast.dataflow.interprocedural.check.HeapFactory
 *  cn.sast.dataflow.interprocedural.check.InterProceduralValueAnalysis
 *  cn.sast.dataflow.interprocedural.check.InterProceduralValueAnalysis$Companion
 *  cn.sast.dataflow.interprocedural.check.InterProceduralValueAnalysis$bottom$1
 *  cn.sast.dataflow.interprocedural.check.InterProceduralValueAnalysis$getTopState$top$1
 *  cn.sast.idfa.analysis.Context
 *  cn.sast.idfa.analysis.FixPointStatus
 *  cn.sast.idfa.analysis.InterproceduralCFG
 *  kotlin.Metadata
 *  kotlin.NotImplementedError
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  soot.Body
 *  soot.G
 *  soot.Local
 *  soot.RefLikeType
 *  soot.RefType
 *  soot.Scene
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.Value
 *  soot.jimple.DynamicInvokeExpr
 *  soot.jimple.InstanceInvokeExpr
 *  soot.jimple.InvokeExpr
 *  soot.jimple.Jimple
 *  soot.jimple.NopStmt
 *  soot.jimple.StaticInvokeExpr
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.api.config.ExtSettings;
import cn.sast.api.config.StaticFieldTrackingMode;
import cn.sast.api.util.SootUtilsKt;
import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.AIContext;
import cn.sast.dataflow.interprocedural.analysis.AJimpleInterProceduralAnalysisKt;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv;
import cn.sast.dataflow.interprocedural.analysis.CallStackContext;
import cn.sast.dataflow.interprocedural.analysis.EntryParam;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IProblemIteratorTerminal;
import cn.sast.dataflow.interprocedural.analysis.IVGlobal;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.PointsToGraphAbstract;
import cn.sast.dataflow.interprocedural.check.HeapFactory;
import cn.sast.dataflow.interprocedural.check.InterProceduralValueAnalysis;
import cn.sast.idfa.analysis.Context;
import cn.sast.idfa.analysis.FixPointStatus;
import cn.sast.idfa.analysis.InterproceduralCFG;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.Body;
import soot.G;
import soot.Local;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.NopStmt;
import soot.jimple.StaticInvokeExpr;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\f\b&\u0018\u0000 62\u00020\u0001:\u00016B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0016J*\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0016J*\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0016J*\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0016J&\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0016J \u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00152\u0010\u0010&\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00100\u000fJ\"\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00152\u0010\u0010+\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00100\u000fH\u0016J8\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00150-2\u0006\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u0002002\u0006\u0010$\u001a\u00020%2\u0010\u0010&\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00100\u000fH\u0016JD\u00101\u001a\u0002022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u00103\u001a\u00020%2\u0010\u00104\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00100\u000f2\u0010\u00105\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00100\u000fH\u0016R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\r\u00a8\u00067"}, d2={"Lcn/sast/dataflow/interprocedural/check/InterProceduralValueAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis;", "vg", "Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "icfg", "Lcn/sast/idfa/analysis/InterproceduralCFG;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;Lcn/sast/idfa/analysis/InterproceduralCFG;)V", "bottom", "cn/sast/dataflow/interprocedural/check/InterProceduralValueAnalysis$bottom$1", "Lcn/sast/dataflow/interprocedural/check/InterProceduralValueAnalysis$bottom$1;", "getTopState", "Lcn/sast/dataflow/interprocedural/analysis/IFact;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "callStackContext", "Lcn/sast/dataflow/interprocedural/analysis/CallStackContext;", "boundaryValue", "entryPoint", "Lsoot/SootMethod;", "copy", "src", "meet", "op1", "op2", "shallowMeet", "merge", "local", "ret", "bottomValue", "newExprEnv", "Lcn/sast/dataflow/interprocedural/analysis/AnyNewExprEnv;", "context", "Lcn/sast/dataflow/interprocedural/analysis/AIContext;", "node", "Lsoot/Unit;", "inValue", "isRecursive", "", "callee", "isAnalyzable", "in1", "resolveTargets", "", "callerMethod", "ie", "Lsoot/jimple/InvokeExpr;", "hasChange", "Lcn/sast/idfa/analysis/FixPointStatus;", "succ", "old", "new", "Companion", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nInterProceduralValueAnalysis.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InterProceduralValueAnalysis.kt\ncn/sast/dataflow/interprocedural/check/InterProceduralValueAnalysis\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,315:1\n1#2:316\n1863#3,2:317\n*S KotlinDebug\n*F\n+ 1 InterProceduralValueAnalysis.kt\ncn/sast/dataflow/interprocedural/check/InterProceduralValueAnalysis\n*L\n258#1:317,2\n*E\n"})
public abstract class InterProceduralValueAnalysis
extends ACheckCallAnalysis {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final bottom.1 bottom;
    @NotNull
    private static KLogger logger = KotlinLogging.INSTANCE.logger(InterProceduralValueAnalysis::logger$lambda$3);

    public InterProceduralValueAnalysis(@NotNull IVGlobal vg, @NotNull AbstractHeapFactory<IValue> hf, @NotNull InterproceduralCFG icfg) {
        Intrinsics.checkNotNullParameter((Object)vg, (String)"vg");
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)icfg, (String)"icfg");
        super(hf, icfg);
        NopStmt unit = Jimple.v().newNopStmt();
        SootMethod method = Scene.v().makeSootMethod("initConstantPoolObjectData", CollectionsKt.emptyList(), (Type)G.v().soot_VoidType());
        Intrinsics.checkNotNull((Object)unit);
        Unit unit2 = (Unit)unit;
        Intrinsics.checkNotNull((Object)method);
        CallStackContext callStackContext = new CallStackContext(null, unit2, method, 0);
        hf.setConstantPoolObjectData(this.getTopState(callStackContext).builder());
        this.bottom = new /* Unavailable Anonymous Inner Class!! */;
    }

    public /* synthetic */ InterProceduralValueAnalysis(IVGlobal iVGlobal, AbstractHeapFactory abstractHeapFactory, InterproceduralCFG interproceduralCFG, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            abstractHeapFactory = (AbstractHeapFactory)new HeapFactory(iVGlobal);
        }
        if ((n & 4) != 0) {
            interproceduralCFG = new InterproceduralCFG();
        }
        this(iVGlobal, abstractHeapFactory, interproceduralCFG);
    }

    private final IFact<IValue> getTopState(CallStackContext callStackContext) {
        AbstractHeapFactory abstractHeapFactory = this.getHf();
        getTopState.top.1 top2 = new /* Unavailable Anonymous Inner Class!! */;
        return (IFact)top2;
    }

    @NotNull
    public IFact<IValue> boundaryValue(@NotNull SootMethod entryPoint) {
        Intrinsics.checkNotNullParameter((Object)entryPoint, (String)"entryPoint");
        if (!entryPoint.isConcrete()) {
            return (IFact)this.bottom;
        }
        if (!entryPoint.hasActiveBody()) {
            return (IFact)this.bottom;
        }
        Unit entryUnit = entryPoint.getActiveBody().getUnits().getFirst();
        Intrinsics.checkNotNull((Object)entryUnit);
        CallStackContext callStackContext = new CallStackContext(null, entryUnit, entryPoint, 0);
        IFact top2 = this.getTopState(callStackContext);
        IFact.Builder entryValue = top2.builder();
        int n = entryPoint.getParameterCount();
        for (int argIndex = 0; argIndex < n; ++argIndex) {
            AbstractHeapFactory abstractHeapFactory = this.getHf();
            Body body = entryPoint.getActiveBody();
            Intrinsics.checkNotNullExpressionValue((Object)body, (String)"getActiveBody(...)");
            Unit unit = AJimpleInterProceduralAnalysisKt.getParameterUnit((Body)body, (int)argIndex);
            if (unit == null) {
                unit = entryUnit;
            }
            HeapValuesEnv env = abstractHeapFactory.env(unit);
            IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)entryValue, (HeapValuesEnv)env, (Object)argIndex, (IHeapValues)this.getHf().push(env, (Object)new EntryParam(entryPoint, argIndex)).markOfEntryMethodParam(entryPoint).popHV(), (boolean)false, (int)8, null);
        }
        if (!entryPoint.isStatic()) {
            AbstractHeapFactory abstractHeapFactory = this.getHf();
            Body body = entryPoint.getActiveBody();
            Intrinsics.checkNotNullExpressionValue((Object)body, (String)"getActiveBody(...)");
            Unit unit = AJimpleInterProceduralAnalysisKt.getParameterUnit((Body)body, (int)-1);
            if (unit == null) {
                unit = entryUnit;
            }
            HeapValuesEnv env = abstractHeapFactory.env(unit);
            IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)entryValue, (HeapValuesEnv)env, (Object)-1, (IHeapValues)this.getHf().push(env, (Object)new EntryParam(entryPoint, -1)).markOfEntryMethodParam(entryPoint).popHV(), (boolean)false, (int)8, null);
        }
        this.getHf().getVg().setStaticFieldTrackingMode(this.getStaticFieldTrackingMode());
        if (this.getStaticFieldTrackingMode() != StaticFieldTrackingMode.None) {
            HeapValuesEnv env = this.getHf().env(entryUnit);
            IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)entryValue, (HeapValuesEnv)env, (Object)this.getHf().getVg().getGLOBAL_LOCAL(), (IHeapValues)this.getHf().push(env, (Object)this.getHf().getVg().getGLOBAL_SITE()).markOfEntryMethodParam(entryPoint).popHV(), (boolean)false, (int)8, null);
        }
        return entryValue.build();
    }

    @NotNull
    public IFact<IValue> copy(@NotNull IFact<IValue> src) {
        Intrinsics.checkNotNullParameter(src, (String)"src");
        return src;
    }

    @NotNull
    public IFact<IValue> meet(@NotNull IFact<IValue> op1, @NotNull IFact<IValue> op2) {
        IFact.Builder builder2;
        Intrinsics.checkNotNullParameter(op1, (String)"op1");
        Intrinsics.checkNotNullParameter(op2, (String)"op2");
        if (op1.isBottom()) {
            return op2;
        }
        if (op2.isBottom()) {
            return op1;
        }
        if (op1.isTop()) {
            return op2;
        }
        if (op2.isTop()) {
            return op1;
        }
        if (op1 == op2) {
            return op1;
        }
        IFact.Builder $this$meet_u24lambda_u240 = builder2 = op1.builder();
        boolean bl = false;
        $this$meet_u24lambda_u240.union(op2);
        return builder2.build();
    }

    @NotNull
    public IFact<IValue> shallowMeet(@NotNull IFact<IValue> op1, @NotNull IFact<IValue> op2) {
        Intrinsics.checkNotNullParameter(op1, (String)"op1");
        Intrinsics.checkNotNullParameter(op2, (String)"op2");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @NotNull
    public IFact<IValue> merge(@NotNull IFact<IValue> local, @NotNull IFact<IValue> ret) {
        Intrinsics.checkNotNullParameter(local, (String)"local");
        Intrinsics.checkNotNullParameter(ret, (String)"ret");
        return ret;
    }

    @NotNull
    public IFact<IValue> bottomValue() {
        return (IFact)this.bottom;
    }

    @NotNull
    public AnyNewExprEnv newExprEnv(@NotNull AIContext context, @NotNull Unit node, @NotNull IFact<IValue> inValue) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter(inValue, (String)"inValue");
        return new AnyNewExprEnv((SootMethod)context.getMethod(), node);
    }

    public final boolean isRecursive(@NotNull SootMethod callee, @NotNull IFact<IValue> inValue) {
        Intrinsics.checkNotNullParameter((Object)callee, (String)"callee");
        Intrinsics.checkNotNullParameter(inValue, (String)"inValue");
        PointsToGraphAbstract g2 = (PointsToGraphAbstract)inValue;
        Set set = new LinkedHashSet();
        for (CallStackContext cur = g2.getCallStack(); cur != null; cur = cur.getCaller()) {
            if (set.add(cur.getMethod())) continue;
            return true;
        }
        return false;
    }

    public boolean isAnalyzable(@NotNull SootMethod callee, @NotNull IFact<IValue> in1) {
        Intrinsics.checkNotNullParameter((Object)callee, (String)"callee");
        Intrinsics.checkNotNullParameter(in1, (String)"in1");
        if (!super.isAnalyzable(callee, in1)) {
            return false;
        }
        return !this.isRecursive(callee, in1);
    }

    @NotNull
    public Set<SootMethod> resolveTargets(@NotNull SootMethod callerMethod, @NotNull InvokeExpr ie, @NotNull Unit node, @NotNull IFact<IValue> inValue) {
        Intrinsics.checkNotNullParameter((Object)callerMethod, (String)"callerMethod");
        Intrinsics.checkNotNullParameter((Object)ie, (String)"ie");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter(inValue, (String)"inValue");
        if (ie instanceof StaticInvokeExpr || ie instanceof DynamicInvokeExpr) {
            Set<SootMethod> set = Collections.singleton(ie.getMethod());
            Intrinsics.checkNotNullExpressionValue(set, (String)"singleton(...)");
            return set;
        }
        Set targets = new HashSet();
        Value value = ((InstanceInvokeExpr)ie).getBase();
        Intrinsics.checkNotNull((Object)value, (String)"null cannot be cast to non-null type soot.Local");
        Local receiver = (Local)value;
        IHeapValues heapNodes = inValue.getTargetsUnsafe((Object)receiver);
        if (heapNodes != null && heapNodes.isNotEmpty()) {
            for (IValue v : heapNodes.getValues()) {
                RefLikeType likeType;
                RefLikeType refLikeType;
                RefLikeType type;
                Type type2 = v.getType();
                if ((type2 instanceof RefLikeType ? (RefLikeType)type2 : null) == null) continue;
                type = type;
                if (v.typeIsConcrete()) {
                    refLikeType = type;
                } else if (type instanceof RefType) {
                    Type type3 = receiver.getType();
                    RefType refType = type3 instanceof RefType ? (RefType)type3 : null;
                    if (refType == null) {
                        refType = Scene.v().getObjectType();
                    }
                    RefType refType2 = refType;
                    refLikeType = (RefLikeType)refType2;
                } else {
                    refLikeType = type;
                }
                if ((likeType = refLikeType) == null) continue;
                Iterator iter = SootUtilsKt.getCallTargets((Type)((Type)likeType), (SootMethod)callerMethod, (InvokeExpr)ie, (boolean)false);
                while (iter.hasNext()) {
                    SootMethod target = (SootMethod)iter.next();
                    targets.add(target);
                }
            }
        }
        if (targets.isEmpty()) {
            Iterable $this$forEach$iv = this.resolveTargets((Object)callerMethod, (Object)node);
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                SootMethod target = (SootMethod)element$iv;
                boolean bl = false;
                targets.add(target);
            }
        }
        if (targets.isEmpty()) {
            return SetsKt.setOf((Object)((InstanceInvokeExpr)ie).getMethod());
        }
        long dataFlowResolveTargetsMaxNum = ExtSettings.INSTANCE.getDataFlowResolveTargetsMaxNum();
        if (dataFlowResolveTargetsMaxNum >= 0L && (long)targets.size() >= dataFlowResolveTargetsMaxNum) {
            logger.debug(() -> InterProceduralValueAnalysis.resolveTargets$lambda$2(node, targets, callerMethod));
            return SetsKt.setOf((Object)((InstanceInvokeExpr)ie).getMethod());
        }
        return targets;
    }

    @NotNull
    public FixPointStatus hasChange(@NotNull AIContext context, @NotNull Unit node, @NotNull Unit succ, @NotNull IFact<IValue> old, @NotNull IFact<IValue> iFact) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter((Object)succ, (String)"succ");
        Intrinsics.checkNotNullParameter(old, (String)"old");
        Intrinsics.checkNotNullParameter(iFact, (String)"new");
        Map map = context.getIteratorCount();
        Intrinsics.checkNotNull((Object)map);
        Integer n = (Integer)map.get(node);
        int count = (n != null ? n : 0) + 1;
        Integer n2 = count;
        Map map2 = context.getIteratorCount();
        Intrinsics.checkNotNull((Object)map2);
        map2.put(node, n2);
        if (!iFact.isValid()) {
            return FixPointStatus.HasChange;
        }
        if (!((SootMethod)context.getMethod()).getDeclaringClass().isApplicationClass() && count < ExtSettings.INSTANCE.getDataFlowIteratorCountForLibClasses() || ((SootMethod)context.getMethod()).getDeclaringClass().isApplicationClass() && count < ExtSettings.INSTANCE.getDataFlowIteratorCountForAppClasses()) {
            return old.hasChange((Context)context, (IProblemIteratorTerminal)iFact);
        }
        Set set = context.getWidenNode();
        Intrinsics.checkNotNull((Object)set);
        if (set.add(TuplesKt.to((Object)node, (Object)succ))) {
            return FixPointStatus.NeedWideningOperators;
        }
        return FixPointStatus.Fixpoint;
    }

    private static final Object resolveTargets$lambda$2(Unit $node, Set $targets, SootMethod $callerMethod) {
        return "Too many callee at " + $node + ". size: " + $targets.size() + ". in " + $callerMethod + " line:" + $node.getJavaSourceStartLineNumber();
    }

    private static final kotlin.Unit logger$lambda$3() {
        return kotlin.Unit.INSTANCE;
    }
}

