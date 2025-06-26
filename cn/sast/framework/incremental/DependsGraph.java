/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles$IDependsGraph
 *  cn.sast.api.incremental.ModifyInfoFactory
 *  cn.sast.framework.incremental.DependsGraph
 *  cn.sast.graph.HashMutableDirectedGraph
 *  com.feysh.corax.config.api.XDecl
 *  com.feysh.corax.config.api.rules.ProcessRule$ScanAction
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  org.jetbrains.annotations.NotNull
 *  soot.toolkits.graph.MutableDirectedGraph
 */
package cn.sast.framework.incremental;

import cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles;
import cn.sast.api.incremental.ModifyInfoFactory;
import cn.sast.graph.HashMutableDirectedGraph;
import com.feysh.corax.config.api.XDecl;
import com.feysh.corax.config.api.rules.ProcessRule;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import soot.toolkits.graph.MutableDirectedGraph;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0013\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\n0\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0015H\u0096\u0004J\u001e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\u0015\u0010\u0013\u001a\u00020\u0014*\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0096\u0004J&\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00152\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u0015H\u0016J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$H\u0016J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\u001d2\u0006\u0010#\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010#\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020'2\u0006\u0010#\u001a\u00020$H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2={"Lcn/sast/framework/incremental/DependsGraph;", "Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles$IDependsGraph;", "factory", "Lcn/sast/api/incremental/ModifyInfoFactory;", "<init>", "(Lcn/sast/api/incremental/ModifyInfoFactory;)V", "getFactory", "()Lcn/sast/api/incremental/ModifyInfoFactory;", "dependenceGraph", "Lsoot/toolkits/graph/MutableDirectedGraph;", "Lcom/feysh/corax/config/api/XDecl;", "patchRelateAnalysisTargets", "", "", "", "patchRelateObjects", "patchRelateChangedWalk", "isOld", "", "dependsOn", "", "", "deps", "visitChangedDecl", "diffPath", "changed", "walkALl", "dep", "walk", "Lkotlin/sequences/Sequence;", "node", "forward", "targetsRelate", "targets", "toDecl", "target", "", "targetRelate", "shouldReAnalyzeDecl", "Lcom/feysh/corax/config/api/rules/ProcessRule$ScanAction;", "shouldReAnalyzeTarget", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nIncrementalAnalyzeImplByChangeFiles.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IncrementalAnalyzeImplByChangeFiles.kt\ncn/sast/framework/incremental/DependsGraph\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,395:1\n381#2,7:396\n1317#3,2:403\n*S KotlinDebug\n*F\n+ 1 IncrementalAnalyzeImplByChangeFiles.kt\ncn/sast/framework/incremental/DependsGraph\n*L\n157#1:396,7\n168#1:403,2\n*E\n"})
public final class DependsGraph
implements IncrementalAnalyzeByChangeFiles.IDependsGraph {
    @NotNull
    private final ModifyInfoFactory factory;
    @NotNull
    private final MutableDirectedGraph<XDecl> dependenceGraph;
    @NotNull
    private final Map<String, Set<XDecl>> patchRelateAnalysisTargets;
    @NotNull
    private final Set<XDecl> patchRelateObjects;
    @NotNull
    private final Set<XDecl> patchRelateChangedWalk;
    private boolean isOld;

    public DependsGraph(@NotNull ModifyInfoFactory factory) {
        Intrinsics.checkNotNullParameter((Object)factory, (String)"factory");
        this.factory = factory;
        this.dependenceGraph = (MutableDirectedGraph)new HashMutableDirectedGraph();
        this.patchRelateAnalysisTargets = new LinkedHashMap();
        this.patchRelateObjects = new LinkedHashSet();
        this.patchRelateChangedWalk = new LinkedHashSet();
    }

    @NotNull
    public ModifyInfoFactory getFactory() {
        return this.factory;
    }

    public void dependsOn(@NotNull Collection<? extends XDecl> $this$dependsOn, @NotNull Collection<? extends XDecl> deps) {
        Intrinsics.checkNotNullParameter($this$dependsOn, (String)"<this>");
        Intrinsics.checkNotNullParameter(deps, (String)"deps");
        Collection<? extends XDecl> nodes = $this$dependsOn;
        for (XDecl xDecl : nodes) {
            for (XDecl xDecl2 : deps) {
                this.dependsOn(xDecl, xDecl2);
            }
        }
    }

    public void visitChangedDecl(@NotNull String diffPath, @NotNull Collection<? extends XDecl> changed) {
        Intrinsics.checkNotNullParameter((Object)diffPath, (String)"diffPath");
        Intrinsics.checkNotNullParameter(changed, (String)"changed");
        for (XDecl xDecl : changed) {
            Object object;
            Map $this$getOrPut$iv = this.patchRelateAnalysisTargets;
            boolean $i$f$getOrPut = false;
            Object value$iv = $this$getOrPut$iv.get(diffPath);
            if (value$iv == null) {
                boolean bl = false;
                Set answer$iv = new LinkedHashSet();
                $this$getOrPut$iv.put(diffPath, answer$iv);
                object = answer$iv;
            } else {
                object = value$iv;
            }
            ((Set)object).add(xDecl);
            ((Collection)this.patchRelateObjects).add(xDecl);
        }
        this.patchRelateChangedWalk.clear();
        this.isOld = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void walkALl() {
        if (!this.isOld) {
            return;
        }
        DependsGraph dependsGraph = this;
        synchronized (dependsGraph) {
            boolean bl = false;
            if (!this.isOld) {
                return;
            }
            Sequence $this$forEach$iv = this.targetsRelate((Collection)this.patchRelateObjects);
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                XDecl it = (XDecl)element$iv;
                boolean bl2 = false;
                ((Collection)this.patchRelateChangedWalk).add(it);
            }
            this.isOld = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    public void dependsOn(@NotNull XDecl $this$dependsOn, @NotNull XDecl dep) {
        Intrinsics.checkNotNullParameter((Object)$this$dependsOn, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)dep, (String)"dep");
        this.dependenceGraph.addEdge((Object)$this$dependsOn, (Object)dep);
        this.isOld = true;
    }

    private final Sequence<XDecl> walk(Collection<? extends XDecl> node, boolean forward) {
        return SequencesKt.sequence((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
    }

    @NotNull
    public Sequence<XDecl> targetsRelate(@NotNull Collection<? extends XDecl> targets) {
        Intrinsics.checkNotNullParameter(targets, (String)"targets");
        return SequencesKt.plus((Sequence)this.walk(targets, true), (Sequence)this.walk(targets, false));
    }

    @NotNull
    public XDecl toDecl(@NotNull Object target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        return this.getFactory().toDecl(target);
    }

    @NotNull
    public Sequence<XDecl> targetRelate(@NotNull XDecl target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        return this.targetsRelate((Collection)CollectionsKt.listOf((Object)target));
    }

    @NotNull
    public ProcessRule.ScanAction shouldReAnalyzeDecl(@NotNull XDecl target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        this.walkALl();
        ProcessRule.ScanAction actionByFactory = this.getFactory().getScanAction(target);
        if (actionByFactory != ProcessRule.ScanAction.Keep) {
            return actionByFactory;
        }
        if (this.patchRelateChangedWalk.contains(target)) {
            return ProcessRule.ScanAction.Process;
        }
        return ProcessRule.ScanAction.Skip;
    }

    @NotNull
    public ProcessRule.ScanAction shouldReAnalyzeTarget(@NotNull Object target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        return this.shouldReAnalyzeDecl(this.getFactory().toDecl(target));
    }

    public static final /* synthetic */ MutableDirectedGraph access$getDependenceGraph$p(DependsGraph $this) {
        return $this.dependenceGraph;
    }
}

