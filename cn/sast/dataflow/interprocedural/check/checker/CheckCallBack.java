/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.ClassResInfo
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CallStackContext
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.ConstVal
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.HookEnv
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  cn.sast.dataflow.interprocedural.check.PathCompanionV
 *  cn.sast.dataflow.interprocedural.check.UnknownPath
 *  cn.sast.dataflow.interprocedural.check.checker.CheckCallBack
 *  cn.sast.dataflow.interprocedural.check.checker.CheckCallBack$Companion
 *  cn.sast.dataflow.interprocedural.check.checker.CheckCallBack$check$ctx$1
 *  cn.sast.dataflow.interprocedural.check.checker.CheckerModeling$Checker
 *  cn.sast.dataflow.interprocedural.check.checker.ProgramStateContext
 *  cn.sast.idfa.analysis.InterproceduralCFG
 *  cn.sast.idfa.check.ICallCB
 *  com.feysh.corax.config.api.IExpr
 *  com.feysh.corax.config.api.report.Region
 *  com.feysh.corax.config.api.report.Region$Mutable
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.Unit
 */
package cn.sast.dataflow.interprocedural.check.checker;

import cn.sast.api.report.ClassResInfo;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CallStackContext;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.HookEnv;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.PathCompanionV;
import cn.sast.dataflow.interprocedural.check.UnknownPath;
import cn.sast.dataflow.interprocedural.check.checker.CheckCallBack;
import cn.sast.dataflow.interprocedural.check.checker.CheckerModeling;
import cn.sast.dataflow.interprocedural.check.checker.ProgramStateContext;
import cn.sast.idfa.analysis.InterproceduralCFG;
import cn.sast.idfa.check.ICallCB;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.report.Region;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J`\u0010\f\u001a\u000e\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0018\u00010\r2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\u00112\u0006\u0010\u0012\u001a\u00020\u00132\"\u0010\u0014\u001a\u001e\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00170\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Lcn/sast/dataflow/interprocedural/check/checker/CheckCallBack;", "", "atMethod", "Lsoot/SootMethod;", "define", "Lcn/sast/dataflow/interprocedural/check/checker/CheckerModeling$Checker;", "<init>", "(Lsoot/SootMethod;Lcn/sast/dataflow/interprocedural/check/checker/CheckerModeling$Checker;)V", "getAtMethod", "()Lsoot/SootMethod;", "toString", "", "check", "Lcn/sast/dataflow/interprocedural/analysis/IFact;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "env", "Lcn/sast/dataflow/interprocedural/analysis/HookEnv;", "summaryCtxCalleeSite", "Lcn/sast/idfa/check/ICallCB;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "icfg", "Lcn/sast/idfa/analysis/InterproceduralCFG;", "(Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;Lcn/sast/dataflow/interprocedural/analysis/HookEnv;Lcn/sast/idfa/check/ICallCB;Lcn/sast/idfa/analysis/InterproceduralCFG;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "corax-data-flow"})
public final class CheckCallBack {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final SootMethod atMethod;
    @NotNull
    private final CheckerModeling.Checker define;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(CheckCallBack::logger$lambda$1);

    public CheckCallBack(@NotNull SootMethod atMethod2, @NotNull CheckerModeling.Checker define) {
        Intrinsics.checkNotNullParameter((Object)atMethod2, (String)"atMethod");
        Intrinsics.checkNotNullParameter((Object)define, (String)"define");
        this.atMethod = atMethod2;
        this.define = define;
    }

    @NotNull
    public final SootMethod getAtMethod() {
        return this.atMethod;
    }

    @NotNull
    public String toString() {
        return "check " + this.atMethod + ":  " + this.define.getGuard();
    }

    @Nullable
    public final Object check(@NotNull AbstractHeapFactory<IValue> hf, @NotNull HookEnv env, @NotNull ICallCB<IHeapValues<IValue>, IFact.Builder<IValue>> summaryCtxCalleeSite, @NotNull InterproceduralCFG icfg, @NotNull Continuation<? super IFact<IValue>> $completion) {
        CallStackContext callStack = ((IFact.Builder)summaryCtxCalleeSite.getOut()).getCallStack();
        IFact.Builder fact = (IFact.Builder)summaryCtxCalleeSite.getOut();
        List booleans = SequencesKt.toList((Sequence)hf.resolve((HeapValuesEnv)env, summaryCtxCalleeSite, this.define.getGuard().getExpr()));
        for (Object isBug : booleans) {
            CompanionV companionV = isBug instanceof CompanionV ? (CompanionV)isBug : null;
            if (companionV == null) continue;
            CompanionV c = companionV;
            PathCompanionV pathCompanionV = c instanceof PathCompanionV ? (PathCompanionV)c : null;
            if (pathCompanionV == null || (pathCompanionV = pathCompanionV.getPath()) == null) {
                pathCompanionV = (IPath)UnknownPath.Companion.v((HeapValuesEnv)env);
            }
            PathCompanionV paths = pathCompanionV;
            Object bool = c.getValue();
            if (!(bool instanceof ConstVal) || !Intrinsics.areEqual((Object)FactValuesKt.getBooleanValue$default((IValue)((IValue)bool), (boolean)false, (int)1, null), (Object)Boxing.boxBoolean((boolean)true))) continue;
            logger.debug(() -> CheckCallBack.check$lambda$0(this));
            SootMethod container = icfg.getMethodOf(env.getNode());
            Region region = Region.Companion.invoke(env.getNode());
            if (region == null) {
                region = Region.Companion.getERROR();
            }
            Region.Mutable mutable = region.getMutable();
            ClassResInfo classResInfo = ClassResInfo.Companion.of(container);
            Unit unit = env.getNode();
            SootMethod sootMethod = this.atMethod;
            IExpr iExpr = this.define.getGuard().getExpr();
            check.ctx.1 ctx2 = new /* Unavailable Anonymous Inner Class!! */;
            mutable = ctx2;
            this.define.getEnv().invoke((Object)mutable);
            env.getCtx().report((IPath)paths, (ProgramStateContext)ctx2, this.define);
        }
        return null;
    }

    private static final Object check$lambda$0(CheckCallBack this$0) {
        return "found a bug at: method: " + this$0.atMethod + ". define = " + this$0.define;
    }

    private static final kotlin.Unit logger$lambda$1() {
        return kotlin.Unit.INSTANCE;
    }
}

