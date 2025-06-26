/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.entries.IEntryPointProvider
 *  cn.sast.framework.entries.IEntryPointProvider$AnalyzeTask
 *  cn.sast.framework.entries.IEntryPointProvider$DefaultImpls
 *  cn.sast.framework.entries.allmethods.AllMethodsProvider
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowKt
 *  org.jetbrains.annotations.NotNull
 *  soot.Scene
 *  soot.SootClass
 */
package cn.sast.framework.entries.allmethods;

import cn.sast.framework.entries.IEntryPointProvider;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootClass;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2={"Lcn/sast/framework/entries/allmethods/AllMethodsProvider;", "Lcn/sast/framework/entries/IEntryPointProvider;", "classes", "", "Lsoot/SootClass;", "<init>", "(Ljava/util/Collection;)V", "getClasses", "()Ljava/util/Collection;", "iterator", "Lkotlinx/coroutines/flow/Flow;", "Lcn/sast/framework/entries/IEntryPointProvider$AnalyzeTask;", "getIterator", "()Lkotlinx/coroutines/flow/Flow;", "corax-framework"})
public final class AllMethodsProvider
implements IEntryPointProvider {
    @NotNull
    private final Collection<SootClass> classes;
    @NotNull
    private final Flow<IEntryPointProvider.AnalyzeTask> iterator;

    public AllMethodsProvider(@NotNull Collection<? extends SootClass> classes) {
        Intrinsics.checkNotNullParameter(classes, (String)"classes");
        this.classes = classes;
        this.iterator = FlowKt.flow((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
    }

    public /* synthetic */ AllMethodsProvider(Collection collection, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            collection = (Collection)Scene.v().getApplicationClasses();
        }
        this(collection);
    }

    @NotNull
    public final Collection<SootClass> getClasses() {
        return this.classes;
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

    public AllMethodsProvider() {
        this(null, 1, null);
    }
}

