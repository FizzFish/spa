/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AJimpleInterProceduralAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.DemandPTA
 *  cn.sast.dataflow.interprocedural.analysis.DemandPTA$Companion
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.idfa.analysis.Context
 *  cn.sast.idfa.analysis.InterproceduralCFG
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Local
 *  soot.PointsToAnalysis
 *  soot.PointsToSet
 *  soot.Scene
 *  soot.SootMethod
 *  soot.Unit
 *  soot.Value
 *  soot.ValueBox
 *  soot.jimple.DefinitionStmt
 *  soot.jimple.infoflow.data.AccessPath
 *  soot.jimple.spark.pag.PAG
 *  soot.jimple.spark.sets.PointsToSetInternal
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AJimpleInterProceduralAnalysis;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.DemandPTA;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.idfa.analysis.Context;
import cn.sast.idfa.analysis.InterproceduralCFG;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Local;
import soot.PointsToAnalysis;
import soot.PointsToSet;
import soot.Scene;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.DefinitionStmt;
import soot.jimple.infoflow.data.AccessPath;
import soot.jimple.spark.pag.PAG;
import soot.jimple.spark.sets.PointsToSetInternal;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 6*\u0004\b\u0000\u0010\u0001* \b\u0001\u0010\u0002*\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00060\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007:\u00016B'\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00150\u00140\u0013H&J\u0016\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040(H\u0016J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020*2\u0006\u0010+\u001a\u00020,JB\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010/\u001a\u00028\u00012\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u00103\u001a\u000204H\u0096@\u00a2\u0006\u0002\u00105R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u00067"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/DemandPTA;", "V", "CTX", "Lcn/sast/idfa/analysis/Context;", "Lsoot/SootMethod;", "Lsoot/Unit;", "Lcn/sast/dataflow/interprocedural/analysis/IFact;", "Lcn/sast/dataflow/interprocedural/analysis/AJimpleInterProceduralAnalysis;", "pta", "Lsoot/PointsToAnalysis;", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "icfg", "Lcn/sast/idfa/analysis/InterproceduralCFG;", "<init>", "(Lsoot/PointsToAnalysis;Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;Lcn/sast/idfa/analysis/InterproceduralCFG;)V", "getPta", "()Lsoot/PointsToAnalysis;", "getLocals", "", "Lkotlin/Pair;", "Lsoot/jimple/infoflow/data/AccessPath;", "associationPTS", "Lsoot/jimple/spark/sets/PointsToSetInternal;", "getAssociationPTS", "()Lsoot/jimple/spark/sets/PointsToSetInternal;", "setAssociationPTS", "(Lsoot/jimple/spark/sets/PointsToSetInternal;)V", "associationInstance", "getAssociationInstance", "setAssociationInstance", "associationStmt", "", "getAssociationStmt", "()Ljava/util/Set;", "setAssociationStmt", "(Ljava/util/Set;)V", "doAnalysis", "", "entries", "", "isAssociation", "", "l", "Lsoot/Local;", "isAssociationInstance", "normalFlowFunction", "context", "node", "succ", "inValue", "isNegativeBranch", "Ljava/util/concurrent/atomic/AtomicBoolean;", "(Lcn/sast/idfa/analysis/Context;Lsoot/Unit;Lsoot/Unit;Lcn/sast/dataflow/interprocedural/analysis/IFact;Ljava/util/concurrent/atomic/AtomicBoolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nDemandPTA.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DemandPTA.kt\ncn/sast/dataflow/interprocedural/analysis/DemandPTA\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,152:1\n1863#2:153\n1864#2:155\n1557#2:156\n1628#2,3:157\n808#2,11:160\n1#3:154\n*S KotlinDebug\n*F\n+ 1 DemandPTA.kt\ncn/sast/dataflow/interprocedural/analysis/DemandPTA\n*L\n70#1:153\n70#1:155\n115#1:156\n115#1:157,3\n115#1:160,11\n*E\n"})
public abstract class DemandPTA<V, CTX extends Context<SootMethod, Unit, IFact<V>>>
extends AJimpleInterProceduralAnalysis<V, CTX> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final PointsToAnalysis pta;
    @Nullable
    private PointsToSetInternal associationPTS;
    @Nullable
    private PointsToSetInternal associationInstance;
    @NotNull
    private Set<Unit> associationStmt;
    @NotNull
    private static KLogger logger = KotlinLogging.INSTANCE.logger(DemandPTA::logger$lambda$4);

    public DemandPTA(@NotNull PointsToAnalysis pta, @NotNull AbstractHeapFactory<V> hf, @NotNull InterproceduralCFG icfg) {
        Intrinsics.checkNotNullParameter((Object)pta, (String)"pta");
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)icfg, (String)"icfg");
        super(hf, icfg);
        this.pta = pta;
        this.associationStmt = new LinkedHashSet();
    }

    public /* synthetic */ DemandPTA(PointsToAnalysis pointsToAnalysis, AbstractHeapFactory abstractHeapFactory, InterproceduralCFG interproceduralCFG, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            pointsToAnalysis = Scene.v().getPointsToAnalysis();
        }
        this(pointsToAnalysis, abstractHeapFactory, interproceduralCFG);
    }

    @NotNull
    public final PointsToAnalysis getPta() {
        return this.pta;
    }

    @NotNull
    public abstract Set<Pair<Unit, AccessPath>> getLocals();

    @Nullable
    public final PointsToSetInternal getAssociationPTS() {
        return this.associationPTS;
    }

    public final void setAssociationPTS(@Nullable PointsToSetInternal pointsToSetInternal) {
        this.associationPTS = pointsToSetInternal;
    }

    @Nullable
    public final PointsToSetInternal getAssociationInstance() {
        return this.associationInstance;
    }

    public final void setAssociationInstance(@Nullable PointsToSetInternal pointsToSetInternal) {
        this.associationInstance = pointsToSetInternal;
    }

    @NotNull
    public final Set<Unit> getAssociationStmt() {
        return this.associationStmt;
    }

    public final void setAssociationStmt(@NotNull Set<Unit> set) {
        Intrinsics.checkNotNullParameter(set, (String)"<set-?>");
        this.associationStmt = set;
    }

    public void doAnalysis(@NotNull Collection<? extends SootMethod> entries) {
        Intrinsics.checkNotNullParameter(entries, (String)"entries");
        if (this.pta instanceof PAG) {
            PointsToSetInternal associationInstance = ((PAG)this.pta).getSetFactory().newSet(null, (PAG)this.pta);
            PointsToSetInternal associationPTS = ((PAG)this.pta).getSetFactory().newSet(null, (PAG)this.pta);
            Iterable $this$forEach$iv = this.getLocals();
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                PointsToSet pts;
                PointsToSet pointsToSet;
                Pair pair = (Pair)element$iv;
                boolean bl = false;
                Unit u = (Unit)pair.component1();
                AccessPath accessPath = (AccessPath)pair.component2();
                if (u != null) {
                    Unit unit;
                    Unit it = unit;
                    boolean bl2 = false;
                    this.associationStmt.add(it);
                }
                if (accessPath.getFirstFragment() != null) {
                    PointsToSet instance = ((PAG)this.pta).reachingObjects(accessPath.getPlainValue());
                    if (instance != null && instance instanceof PointsToSetInternal) {
                        associationInstance.addAll((PointsToSetInternal)instance, null);
                    }
                    pointsToSet = ((PAG)this.pta).reachingObjects(accessPath.getPlainValue(), accessPath.getFirstFragment().getField());
                } else {
                    pointsToSet = ((PAG)this.pta).reachingObjects(accessPath.getPlainValue());
                }
                if ((pts = pointsToSet) == null || !(pts instanceof PointsToSetInternal)) continue;
                associationPTS.addAll((PointsToSetInternal)pts, null);
            }
            this.associationInstance = associationInstance;
            this.associationPTS = associationPTS;
        } else {
            logger.error(() -> DemandPTA.doAnalysis$lambda$2(this));
        }
        super.doAnalysis(entries);
    }

    public final boolean isAssociation(@NotNull Local l) {
        Intrinsics.checkNotNullParameter((Object)l, (String)"l");
        PointsToSet ptsL = this.pta.reachingObjects(l);
        PointsToSetInternal pointsToSetInternal = this.associationPTS;
        return pointsToSetInternal != null ? pointsToSetInternal.hasNonEmptyIntersection(ptsL) : true;
    }

    public final boolean isAssociationInstance(@NotNull Local l) {
        Intrinsics.checkNotNullParameter((Object)l, (String)"l");
        PointsToSet ptsL = this.pta.reachingObjects(l);
        PointsToSetInternal pointsToSetInternal = this.associationInstance;
        return pointsToSetInternal != null ? pointsToSetInternal.hasNonEmptyIntersection(ptsL) : true;
    }

    @Nullable
    public Object normalFlowFunction(@NotNull CTX context, @NotNull Unit node, @NotNull Unit succ, @NotNull IFact<V> inValue, @NotNull AtomicBoolean isNegativeBranch, @NotNull Continuation<? super IFact<V>> $completion) {
        return DemandPTA.normalFlowFunction$suspendImpl((DemandPTA)this, context, (Unit)node, (Unit)succ, inValue, (AtomicBoolean)isNegativeBranch, $completion);
    }

    /*
     * WARNING - void declaration
     */
    static /* synthetic */ <V, CTX extends Context<SootMethod, Unit, IFact<V>>> Object normalFlowFunction$suspendImpl(DemandPTA<V, CTX> $this, CTX context, Unit node, Unit succ, IFact<V> inValue, AtomicBoolean isNegativeBranch, Continuation<? super IFact<V>> $completion) {
        void $this$filterIsInstanceTo$iv$iv;
        void $this$filterIsInstance$iv;
        void $this$mapTo$iv$iv;
        List list = node.getUseAndDefBoxes();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getUseAndDefBoxes(...)");
        Iterable $this$map$iv = list;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            ValueBox valueBox = (ValueBox)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getValue());
        }
        $this$map$iv = (List)destination$iv$iv;
        boolean $i$f$filterIsInstance = false;
        $this$mapTo$iv$iv = $this$filterIsInstance$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof Local)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List locals = (List)destination$iv$iv;
        boolean alias = false;
        if (!(node instanceof DefinitionStmt)) {
            return inValue;
        }
        Value value = ((DefinitionStmt)node).getLeftOp();
        Intrinsics.checkNotNullExpressionValue((Object)value, (String)"getLeftOp(...)");
        Value lhsOp = value;
        Value value2 = ((DefinitionStmt)node).getRightOp();
        Intrinsics.checkNotNullExpressionValue((Object)value2, (String)"getRightOp(...)");
        Value rhsOp = value2;
        boolean isAssociation = true;
        return super.normalFlowFunction(context, node, succ, inValue, isNegativeBranch, $completion);
    }

    private static final Object doAnalysis$lambda$2(DemandPTA this$0) {
        return "error pta type: " + this$0.pta.getClass();
    }

    private static final kotlin.Unit logger$lambda$4() {
        return kotlin.Unit.INSTANCE;
    }
}

