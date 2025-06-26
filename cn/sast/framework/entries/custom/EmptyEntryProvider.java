/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.entries.IEntryPointProvider
 *  cn.sast.framework.entries.IEntryPointProvider$AnalyzeTask
 *  cn.sast.framework.entries.IEntryPointProvider$DefaultImpls
 *  cn.sast.framework.entries.custom.EmptyEntryProvider
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function2
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowKt
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.entries.custom;

import cn.sast.framework.entries.IEntryPointProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lcn/sast/framework/entries/custom/EmptyEntryProvider;", "Lcn/sast/framework/entries/IEntryPointProvider;", "<init>", "()V", "iterator", "Lkotlinx/coroutines/flow/Flow;", "Lcn/sast/framework/entries/IEntryPointProvider$AnalyzeTask;", "getIterator", "()Lkotlinx/coroutines/flow/Flow;", "corax-framework"})
public final class EmptyEntryProvider
implements IEntryPointProvider {
    @NotNull
    public static final EmptyEntryProvider INSTANCE = new EmptyEntryProvider();
    @NotNull
    private static final Flow<IEntryPointProvider.AnalyzeTask> iterator = FlowKt.flow((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));

    private EmptyEntryProvider() {
    }

    @NotNull
    public Flow<IEntryPointProvider.AnalyzeTask> getIterator() {
        return iterator;
    }

    public void startAnalyse() {
        IEntryPointProvider.DefaultImpls.startAnalyse((IEntryPointProvider)this);
    }

    public void endAnalyse() {
        IEntryPointProvider.DefaultImpls.endAnalyse((IEntryPointProvider)this);
    }
}

