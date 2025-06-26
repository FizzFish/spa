/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.OS
 *  cn.sast.common.TaskQueue
 *  cn.sast.common.TaskQueue$Companion
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineName
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.Job
 *  kotlinx.coroutines.channels.Channel
 *  kotlinx.coroutines.channels.ChannelKt
 *  kotlinx.coroutines.channels.ChannelResult
 *  kotlinx.coroutines.channels.ChannelsKt
 *  kotlinx.coroutines.channels.SendChannel
 *  kotlinx.coroutines.channels.SendChannel$DefaultImpls
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.common;

import cn.sast.common.OS;
import cn.sast.common.TaskQueue;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="Use MultiWorkerQueue instead.", replaceWith=@ReplaceWith(expression="MultiWorkerQueue", imports={}))
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u0019*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0019BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012(\u0010\u0007\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00028\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\u0014\u0010\u0010\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015J\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u0007\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lcn/sast/common/TaskQueue;", "TaskData", "", "name", "", "numberThreads", "", "action", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Ljava/lang/String;ILkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function3;", "queue", "Lkotlinx/coroutines/channels/Channel;", "addTask", "taskData", "isLast", "", "(Ljava/lang/Object;Z)V", "", "addTaskFinished", "runTask", "Lkotlinx/coroutines/Job;", "Companion", "corax-api"})
public final class TaskQueue<TaskData> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String name;
    private final int numberThreads;
    @NotNull
    private final Function3<TaskData, Integer, Continuation<? super Unit>, Object> action;
    @NotNull
    private final Channel<TaskData> queue;

    public TaskQueue(@NotNull String name, int numberThreads, @NotNull Function3<? super TaskData, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> action) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(action, (String)"action");
        this.name = name;
        this.numberThreads = numberThreads;
        this.action = action;
        this.queue = ChannelKt.Channel$default((int)(this.numberThreads * 2), null, null, (int)6, null);
    }

    public /* synthetic */ TaskQueue(String string, int n, Function3 function3, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            n = Math.max(OS.INSTANCE.getMaxThreadNum() - 1, 1);
        }
        this(string, n, function3);
    }

    public final void addTask(TaskData taskData, boolean isLast) {
        ChannelResult.getOrThrow-impl((Object)ChannelsKt.trySendBlocking((SendChannel)((SendChannel)this.queue), taskData));
        if (isLast) {
            SendChannel.DefaultImpls.close$default((SendChannel)((SendChannel)this.queue), null, (int)1, null);
        }
    }

    public static /* synthetic */ void addTask$default(TaskQueue taskQueue, Object object, boolean bl, int n, Object object2) {
        if ((n & 2) != 0) {
            bl = false;
        }
        taskQueue.addTask(object, bl);
    }

    public final void addTask(@NotNull Iterable<? extends TaskData> taskData) {
        Intrinsics.checkNotNullParameter(taskData, (String)"taskData");
        for (TaskData t : taskData) {
            this.addTask(t, false);
        }
    }

    public final void addTaskFinished() {
        SendChannel.DefaultImpls.close$default((SendChannel)((SendChannel)this.queue), null, (int)1, null);
    }

    @NotNull
    public final Job runTask() {
        CoroutineScope scope = CoroutineScopeKt.CoroutineScope((CoroutineContext)((CoroutineContext)Dispatchers.getDefault()));
        ArrayList<Job> jobs3 = new ArrayList<Job>();
        int n = this.numberThreads;
        for (int i = 0; i < n; ++i) {
            Job job2 = BuildersKt.launch$default((CoroutineScope)scope, (CoroutineContext)((CoroutineContext)new CoroutineName(this.name + "-" + i)), null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)2, null);
            jobs3.add(job2);
        }
        return BuildersKt.launch$default((CoroutineScope)scope, (CoroutineContext)((CoroutineContext)new CoroutineName(this.name + "-joinAll")), null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)2, null);
    }

    public static final /* synthetic */ Channel access$getQueue$p(TaskQueue $this) {
        return $this.queue;
    }

    public static final /* synthetic */ Function3 access$getAction$p(TaskQueue $this) {
        return $this.action;
    }
}

