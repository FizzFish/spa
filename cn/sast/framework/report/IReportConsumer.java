/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.IReportConsumer
 *  cn.sast.framework.result.OutputType
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report;

import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.result.OutputType;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\fR\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\r"}, d2={"Lcn/sast/framework/report/IReportConsumer;", "Ljava/io/Closeable;", "type", "Lcn/sast/framework/result/OutputType;", "getType", "()Lcn/sast/framework/result/OutputType;", "init", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "run", "locator", "Lcn/sast/framework/report/IProjectFileLocator;", "(Lcn/sast/framework/report/IProjectFileLocator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "corax-framework"})
public interface IReportConsumer
extends Closeable {
    @NotNull
    public OutputType getType();

    @Nullable
    public Object init(@NotNull Continuation<? super Unit> var1);

    @Nullable
    public Object run(@NotNull IProjectFileLocator var1, @NotNull Continuation<? super Unit> var2);
}

