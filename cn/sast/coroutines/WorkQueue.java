/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.coroutines.WorkQueue
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.CoroutineDispatcher
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.channels.Channel
 *  kotlinx.coroutines.channels.ChannelKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.coroutines;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BS\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012B\u0010\u0005\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u00a2\u0006\u0002\b\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000RL\u0010\u0005\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u00a2\u0006\u0002\b\fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2={"Lcn/sast/coroutines/WorkQueue;", "T", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "doWork", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "nextItem", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function3;", "channel", "Lkotlinx/coroutines/channels/Channel;", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "start", "numberOfCoroutines", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "corax-api"})
public final class WorkQueue<T> {
    @NotNull
    private final CoroutineDispatcher dispatcher;
    @NotNull
    private final Function3<WorkQueue<T>, T, Continuation<? super Unit>, Object> doWork;
    @NotNull
    private final Channel<T> channel;

    public WorkQueue(@NotNull CoroutineDispatcher dispatcher, @NotNull Function3<? super WorkQueue<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> doWork) {
        Intrinsics.checkNotNullParameter((Object)dispatcher, (String)"dispatcher");
        Intrinsics.checkNotNullParameter(doWork, (String)"doWork");
        this.dispatcher = dispatcher;
        this.doWork = doWork;
        this.channel = ChannelKt.Channel$default((int)Integer.MAX_VALUE, null, null, (int)6, null);
    }

    @NotNull
    public final Channel<T> getChannel() {
        return this.channel;
    }

    @Nullable
    public final Object start(int numberOfCoroutines, @NotNull Continuation<? super Unit> $completion) {
        AtomicInteger idleCount = new AtomicInteger(0);
        Object object = CoroutineScopeKt.coroutineScope((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ CoroutineDispatcher access$getDispatcher$p(WorkQueue $this) {
        return $this.dispatcher;
    }

    public static final /* synthetic */ Function3 access$getDoWork$p(WorkQueue $this) {
        return $this.doWork;
    }
}

