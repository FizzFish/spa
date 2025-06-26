/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.SootCtx
 *  cn.sast.framework.entries.IEntryPointProvider
 *  cn.sast.framework.entries.IEntryPointProvider$AnalyzeTask
 *  cn.sast.framework.entries.IEntryPointProvider$DefaultImpls
 *  cn.sast.framework.entries.java.UnReachableEntryProvider
 *  cn.sast.framework.entries.java.UnReachableEntryProvider$Companion
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.util.Chain
 */
package cn.sast.framework.entries.java;

import cn.sast.framework.SootCtx;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.entries.java.UnReachableEntryProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.util.Chain;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2={"Lcn/sast/framework/entries/java/UnReachableEntryProvider;", "Lcn/sast/framework/entries/IEntryPointProvider;", "ctx", "Lcn/sast/framework/SootCtx;", "exclude", "", "", "<init>", "(Lcn/sast/framework/SootCtx;Ljava/util/Set;)V", "getExclude", "()Ljava/util/Set;", "getEntryMethods", "", "Lsoot/SootMethod;", "iterator", "Lkotlinx/coroutines/flow/Flow;", "Lcn/sast/framework/entries/IEntryPointProvider$AnalyzeTask;", "getIterator", "()Lkotlinx/coroutines/flow/Flow;", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nUnReachableEntryProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnReachableEntryProvider.kt\ncn/sast/framework/entries/java/UnReachableEntryProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,79:1\n1368#2:80\n1454#2,5:81\n774#2:86\n865#2,2:87\n*S KotlinDebug\n*F\n+ 1 UnReachableEntryProvider.kt\ncn/sast/framework/entries/java/UnReachableEntryProvider\n*L\n59#1:80\n59#1:81,5\n59#1:86\n59#1:87,2\n*E\n"})
public class UnReachableEntryProvider
implements IEntryPointProvider {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final SootCtx ctx;
    @NotNull
    private final Set<String> exclude;
    @NotNull
    private final Flow<IEntryPointProvider.AnalyzeTask> iterator;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(UnReachableEntryProvider::logger$lambda$3);

    public UnReachableEntryProvider(@NotNull SootCtx ctx2, @NotNull Set<String> exclude) {
        Intrinsics.checkNotNullParameter((Object)ctx2, (String)"ctx");
        Intrinsics.checkNotNullParameter(exclude, (String)"exclude");
        this.ctx = ctx2;
        this.exclude = exclude;
        this.iterator = FlowKt.flow((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
    }

    public /* synthetic */ UnReachableEntryProvider(SootCtx sootCtx, Set set, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            set = new LinkedHashSet();
        }
        this(sootCtx, set);
    }

    @NotNull
    public final Set<String> getExclude() {
        return this.exclude;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public Set<SootMethod> getEntryMethods() {
        void $this$filterTo$iv$iv;
        void $this$filter$iv;
        SootClass it;
        void $this$flatMapTo$iv$iv;
        Scene scene = Scene.v();
        Chain reachClasses = scene.getApplicationClasses();
        logger.info(() -> UnReachableEntryProvider.getEntryMethods$lambda$0(reachClasses));
        Intrinsics.checkNotNull((Object)reachClasses);
        Iterable $this$flatMap$iv = (Iterable)reachClasses;
        boolean $i$f$flatMap = false;
        Iterable iterable = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            it = (SootClass)element$iv$iv;
            boolean bl = false;
            List list = it.getMethods();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getMethods(...)");
            Iterable list$iv$iv = list;
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        $this$flatMap$iv = (List)destination$iv$iv;
        boolean $i$f$filter = false;
        $this$flatMapTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (SootMethod)element$iv$iv;
            boolean bl = false;
            if (!(!scene.isExcluded(it.getDeclaringClass().getName()) || scene.isIncluded(it.getDeclaringClass().getName()))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List filterSm = (List)destination$iv$iv;
        return Companion.getEntryPoints(this.ctx, filterSm);
    }

    @NotNull
    public Flow<IEntryPointProvider.AnalyzeTask> getIterator() {
        return this.iterator;
    }

    public void startAnalyse() {
        IEntryPointProvider.DefaultImpls.startAnalyse((IEntryPointProvider)this);
    }

    public void endAnalyse() {
        IEntryPointProvider.DefaultImpls.endAnalyse((IEntryPointProvider)this);
    }

    private static final Object getEntryMethods$lambda$0(Chain $reachClasses) {
        return "reach classes num: " + $reachClasses.size();
    }

    private static final Unit logger$lambda$3() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }
}

