/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.SootCtx
 *  cn.sast.framework.entries.IEntryPointProvider
 *  cn.sast.framework.entries.IEntryPointProvider$AnalyzeTask
 *  cn.sast.framework.entries.IEntryPointProvider$DefaultImpls
 *  cn.sast.framework.entries.component.ComponentEntryPointCreator
 *  cn.sast.framework.entries.component.ComponentEntryProvider
 *  cn.sast.framework.entries.component.ComponentEntryProvider$Companion
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  soot.Scene
 *  soot.SootMethod
 */
package cn.sast.framework.entries.component;

import cn.sast.framework.SootCtx;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.entries.component.ComponentEntryPointCreator;
import cn.sast.framework.entries.component.ComponentEntryProvider;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2={"Lcn/sast/framework/entries/component/ComponentEntryProvider;", "Lcn/sast/framework/entries/IEntryPointProvider;", "ctx", "Lcn/sast/framework/SootCtx;", "entries", "", "", "<init>", "(Lcn/sast/framework/SootCtx;Ljava/util/Collection;)V", "method", "", "Lsoot/SootMethod;", "getMethod", "()Ljava/util/Set;", "iterator", "Lkotlinx/coroutines/flow/Flow;", "Lcn/sast/framework/entries/IEntryPointProvider$AnalyzeTask;", "getIterator", "()Lkotlinx/coroutines/flow/Flow;", "Companion", "corax-framework"})
public final class ComponentEntryProvider
implements IEntryPointProvider {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final SootCtx ctx;
    @NotNull
    private final Collection<String> entries;
    @NotNull
    private final Flow<IEntryPointProvider.AnalyzeTask> iterator;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(ComponentEntryProvider::logger$lambda$0);

    public ComponentEntryProvider(@NotNull SootCtx ctx2, @NotNull Collection<String> entries) {
        Intrinsics.checkNotNullParameter((Object)ctx2, (String)"ctx");
        Intrinsics.checkNotNullParameter(entries, (String)"entries");
        this.ctx = ctx2;
        this.entries = entries;
        this.iterator = FlowKt.flow((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
    }

    @NotNull
    public final Set<SootMethod> getMethod() {
        ComponentEntryPointCreator entryPointCreator = new ComponentEntryPointCreator(this.entries);
        SootMethod sootMethod = entryPointCreator.createDummyMain();
        Intrinsics.checkNotNullExpressionValue((Object)sootMethod, (String)"createDummyMain(...)");
        SootMethod dummyMainMethod = sootMethod;
        if (!dummyMainMethod.getDeclaringClass().isInScene()) {
            Scene.v().addClass(dummyMainMethod.getDeclaringClass());
        }
        dummyMainMethod.getDeclaringClass().setApplicationClass();
        return SetsKt.setOf((Object)dummyMainMethod);
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

    private static final Unit logger$lambda$0() {
        return Unit.INSTANCE;
    }
}

