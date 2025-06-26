/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.entries.IEntryPointProvider
 *  cn.sast.framework.entries.IEntryPointProvider$AnalyzeTask
 *  kotlin.Metadata
 *  kotlinx.coroutines.flow.Flow
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.entries;

import cn.sast.framework.entries.IEntryPointProvider;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\nJ\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2={"Lcn/sast/framework/entries/IEntryPointProvider;", "", "iterator", "Lkotlinx/coroutines/flow/Flow;", "Lcn/sast/framework/entries/IEntryPointProvider$AnalyzeTask;", "getIterator", "()Lkotlinx/coroutines/flow/Flow;", "startAnalyse", "", "endAnalyse", "AnalyzeTask", "corax-framework"})
public interface IEntryPointProvider {
    @NotNull
    public Flow<AnalyzeTask> getIterator();

    public void startAnalyse();

    public void endAnalyse();
}

