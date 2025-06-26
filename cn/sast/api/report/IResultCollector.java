/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.IResultCollector
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.report;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u0096@\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lcn/sast/api/report/IResultCollector;", "", "flush", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "corax-api"})
public interface IResultCollector {
    @Nullable
    public Object flush(@NotNull Continuation<? super Unit> var1);
}

