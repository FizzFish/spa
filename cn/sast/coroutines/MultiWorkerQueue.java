/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.ExceptionsKt
 *  cn.sast.common.OS
 *  cn.sast.coroutines.MultiWorkerQueue
 *  cn.sast.coroutines.MultiWorkerQueue$process$1
 *  cn.sast.coroutines.OnDemandAllocatingPool
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.concurrent.ThreadsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.atomicfu.AtomicFU
 *  kotlinx.atomicfu.AtomicLong
 *  kotlinx.atomicfu.AtomicRef
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CancellableContinuation
 *  kotlinx.coroutines.CancellableContinuation$DefaultImpls
 *  kotlinx.coroutines.channels.Channel
 *  kotlinx.coroutines.channels.ChannelKt
 *  kotlinx.coroutines.channels.ChannelResult
 *  kotlinx.coroutines.future.FutureKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.coroutines;

import cn.sast.common.ExceptionsKt;
import cn.sast.common.OS;
import cn.sast.coroutines.MultiWorkerQueue;
import cn.sast.coroutines.OnDemandAllocatingPool;
import java.io.Closeable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicLong;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.future.FutureKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00028\u0000H\u0096@\u00a2\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00028\u0000H\u0096@\u00a2\u0006\u0002\u0010\u001cJ \u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00028\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096@\u00a2\u0006\u0002\u0010!J\r\u0010$\u001a\u00020%*\u00020&H\u0082\bJ\r\u0010'\u001a\u00020%*\u00020&H\u0082\bJ\r\u0010(\u001a\u00020%*\u00020&H\u0082\bJ\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020&H\u0002J\b\u0010,\u001a\u00020\u000bH\u0002J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002J\u0013\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00028\u0000\u00a2\u0006\u0002\u00100J\u0014\u0010.\u001a\u00020\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000001J\b\u00102\u001a\u00020\u000bH\u0016J\u000e\u00103\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u00104J\r\u00105\u001a\u00020\u000bH\u0007\u00a2\u0006\u0002\b6J\u001b\u00107\u001a\u00020\u000b2\n\u00108\u001a\u0006\u0012\u0002\b\u000309H\u0002\u00a2\u0006\u0004\b:\u00100R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\tX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00160\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2={"Lcn/sast/coroutines/MultiWorkerQueue;", "T", "", "Ljava/io/Closeable;", "name", "", "workersCount", "", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "<init>", "(Ljava/lang/String;ILkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "tasksQueue", "Lkotlinx/coroutines/channels/Channel;", "availableWorkers", "Lkotlinx/coroutines/CancellableContinuation;", "futureAtomicRef", "Lkotlinx/atomicfu/AtomicRef;", "Ljava/util/concurrent/CompletableFuture;", "workerPool", "Lcn/sast/coroutines/OnDemandAllocatingPool;", "Ljava/lang/Thread;", "beforeExecute", "task", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "process", "afterExecute", "t", "", "(Ljava/lang/Object;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tasksAndWorkersCounter", "Lkotlinx/atomicfu/AtomicLong;", "isClosed", "", "", "hasTasks", "hasWorkers", "activeCounter", "resumeJoinCoroutineAndUpdate", "dec", "workerRunLoop", "obtainWorker", "dispatch", "data", "(Ljava/lang/Object;)V", "", "close", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wait", "waitAndBlock", "checkChannelResult", "result", "Lkotlinx/coroutines/channels/ChannelResult;", "checkChannelResult-rs8usWo", "corax-api"})
@SourceDebugExtension(value={"SMAP\nMultiWorkerQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiWorkerQueue.kt\ncn/sast/coroutines/MultiWorkerQueue\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AtomicFU.common.kt\nkotlinx/atomicfu/AtomicFU_commonKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,186:1\n68#1:199\n70#1:201\n68#1:207\n70#1:212\n70#1:214\n1#2:187\n498#3,4:188\n174#3,4:192\n487#3,3:196\n490#3:200\n487#3,3:204\n490#3:208\n487#3,3:209\n490#3:213\n174#3,4:217\n174#3,4:221\n174#3,4:225\n1863#4,2:202\n1863#4,2:215\n*S KotlinDebug\n*F\n+ 1 MultiWorkerQueue.kt\ncn/sast/coroutines/MultiWorkerQueue\n*L\n119#1:199\n124#1:201\n140#1:207\n145#1:212\n148#1:214\n75#1:188,4\n77#1:192,4\n118#1:196,3\n118#1:200\n140#1:204,3\n140#1:208\n144#1:209,3\n144#1:213\n157#1:217,4\n162#1:221,4\n168#1:225,4\n135#1:202,2\n156#1:215,2\n*E\n"})
public class MultiWorkerQueue<T>
implements Cloneable,
Closeable {
    @NotNull
    private final String name;
    private final int workersCount;
    @NotNull
    private final Function2<T, Continuation<? super Unit>, Object> action;
    @NotNull
    private final Channel<T> tasksQueue;
    @NotNull
    private final Channel<CancellableContinuation<T>> availableWorkers;
    @NotNull
    private final AtomicRef<CompletableFuture<Unit>> futureAtomicRef;
    @NotNull
    private final OnDemandAllocatingPool<Thread> workerPool;
    @NotNull
    private final AtomicLong tasksAndWorkersCounter;
    @NotNull
    private final AtomicLong activeCounter;

    public MultiWorkerQueue(@NotNull String name, int workersCount, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(action, (String)"action");
        this.name = name;
        this.workersCount = workersCount;
        this.action = action;
        if (!(this.workersCount > 0)) {
            boolean bl = false;
            String string = "workersCount: " + this.workersCount + " must be greater than zero";
            throw new IllegalStateException(string.toString());
        }
        this.tasksQueue = ChannelKt.Channel$default((int)Integer.MAX_VALUE, null, null, (int)6, null);
        this.availableWorkers = ChannelKt.Channel$default((int)Integer.MAX_VALUE, null, null, (int)6, null);
        this.futureAtomicRef = AtomicFU.atomic(null);
        this.workerPool = new OnDemandAllocatingPool(this.workersCount, arg_0 -> MultiWorkerQueue.workerPool$lambda$2(this, arg_0));
        this.tasksAndWorkersCounter = AtomicFU.atomic((long)0L);
        this.activeCounter = AtomicFU.atomic((long)0L);
    }

    public /* synthetic */ MultiWorkerQueue(String string, int n, Function2 function2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            n = Math.max(OS.INSTANCE.getMaxThreadNum() - 1, 1);
        }
        this(string, n, function2);
    }

    @Nullable
    public Object beforeExecute(T task2, @NotNull Continuation<? super Unit> $completion) {
        return MultiWorkerQueue.beforeExecute$suspendImpl((MultiWorkerQueue)this, task2, $completion);
    }

    static /* synthetic */ <T> Object beforeExecute$suspendImpl(MultiWorkerQueue<T> $this, T task2, Continuation<? super Unit> $completion) {
        return Unit.INSTANCE;
    }

    @Nullable
    public Object process(T task2, @NotNull Continuation<? super Unit> $completion) {
        return MultiWorkerQueue.process$suspendImpl((MultiWorkerQueue)this, task2, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ <T> Object process$suspendImpl(MultiWorkerQueue<T> var0, T var1_1, Continuation<? super Unit> $completion) {
        if (!($completion instanceof process.1)) ** GOTO lbl-1000
        var5_3 = $completion;
        if ((var5_3.label & -2147483648) != 0) {
            var5_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var6_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = $this;
                $continuation.L$1 = task;
                $continuation.label = 1;
                v0 = $this.beforeExecute(task, (Continuation)$continuation);
                ** if (v0 != var6_5) goto lbl20
lbl19:
                // 1 sources

                return var6_5;
lbl20:
                // 1 sources

                ** GOTO lbl28
            }
            case 1: {
                task = $continuation.L$1;
                $this = (MultiWorkerQueue)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl28:
                // 2 sources

                $continuation.L$0 = $this;
                $continuation.L$1 = task;
                $continuation.label = 2;
                v1 = $this.action.invoke(task, (Object)$continuation);
                ** if (v1 != var6_5) goto lbl34
lbl33:
                // 1 sources

                return var6_5;
lbl34:
                // 1 sources

                ** GOTO lbl42
            }
            case 2: {
                task = $continuation.L$1;
                $this = (MultiWorkerQueue)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl42:
                // 2 sources

                $continuation.L$0 = $this;
                $continuation.L$1 = task;
                $continuation.label = 3;
                v2 = $this.afterExecute(task, null, (Continuation)$continuation);
                ** if (v2 != var6_5) goto lbl48
lbl47:
                // 1 sources

                return var6_5;
lbl48:
                // 1 sources

                ** GOTO lbl71
            }
            case 3: {
                task = $continuation.L$1;
                $this = (MultiWorkerQueue)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v2 = $result;
                    ** GOTO lbl71
                }
                catch (CancellationException e) {
                    throw e;
                }
                catch (Throwable t) {
                    ExceptionsKt.checkCritical((Throwable)t);
                    $continuation.L$0 = null;
                    $continuation.L$1 = null;
                    $continuation.label = 4;
                    v3 = $this.afterExecute(task, t, (Continuation)$continuation);
                    if (v3 == var6_5) {
                        return var6_5;
                    }
                    ** GOTO lbl71
                }
            }
            case 4: {
                ResultKt.throwOnFailure((Object)$result);
                v3 = $result;
lbl71:
                // 4 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public Object afterExecute(T task2, @Nullable Throwable t, @NotNull Continuation<? super Unit> $completion) {
        return MultiWorkerQueue.afterExecute$suspendImpl((MultiWorkerQueue)this, task2, (Throwable)t, $completion);
    }

    static /* synthetic */ <T> Object afterExecute$suspendImpl(MultiWorkerQueue<T> $this, T task2, Throwable t, Continuation<? super Unit> $completion) {
        block0: {
            Throwable throwable = t;
            if (throwable == null) break block0;
            throwable.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    private final boolean isClosed(long $this$isClosed) {
        boolean $i$f$isClosed = false;
        return ($this$isClosed & 1L) == 1L;
    }

    private final boolean hasTasks(long $this$hasTasks) {
        boolean $i$f$hasTasks = false;
        return $this$hasTasks >= 2L;
    }

    private final boolean hasWorkers(long $this$hasWorkers) {
        boolean $i$f$hasWorkers = false;
        return $this$hasWorkers < 0L;
    }

    private final void resumeJoinCoroutineAndUpdate(long dec) {
        long it;
        long upd$iv;
        long cur$iv;
        AtomicLong $this$updateAndGet$iv = this.activeCounter;
        boolean $i$f$updateAndGet = false;
        do {
            it = cur$iv = $this$updateAndGet$iv.getValue();
            boolean bl = false;
        } while (!$this$updateAndGet$iv.compareAndSet(cur$iv, upd$iv = it - dec));
        long active = upd$iv;
        if (active == 0L) {
            Object cur$iv2;
            AtomicRef $this$getAndUpdate$iv = this.futureAtomicRef;
            boolean $i$f$getAndUpdate = false;
            do {
                cur$iv2 = $this$getAndUpdate$iv.getValue();
                CompletableFuture it2 = (CompletableFuture)cur$iv2;
                boolean bl = false;
            } while (!$this$getAndUpdate$iv.compareAndSet(cur$iv2, upd$iv = null));
            CompletableFuture completableFuture = (CompletableFuture)cur$iv2;
            if (completableFuture != null) {
                completableFuture.complete(Unit.INSTANCE);
            }
        } else if (active < 0L) {
            throw new IllegalStateException("Internal invariants of " + this + " were violated, please file this bug to us. activeCount: " + active);
        }
    }

    private final void workerRunLoop() {
        BuildersKt.runBlocking$default(null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)1, null);
    }

    private final CancellableContinuation<T> obtainWorker() {
        CancellableContinuation cancellableContinuation = (CancellableContinuation)ChannelResult.getOrNull-impl((Object)this.availableWorkers.tryReceive-PtdJZtk());
        if (cancellableContinuation == null) {
            cancellableContinuation = (CancellableContinuation)BuildersKt.runBlocking$default(null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)1, null);
        }
        return cancellableContinuation;
    }

    public final void dispatch(T data) {
        long it;
        long upd$iv;
        long cur$iv;
        AtomicLong $this$getAndUpdate$iv = this.tasksAndWorkersCounter;
        boolean $i$f$getAndUpdate = false;
        do {
            it = cur$iv = $this$getAndUpdate$iv.getValue();
            boolean bl = false;
            MultiWorkerQueue multiWorkerQueue = this;
            long $this$isClosed$iv = it;
            boolean $i$f$isClosed = false;
            if (!(($this$isClosed$iv & 1L) == 1L)) continue;
            throw new IllegalStateException("Dispatcher " + this.name + " was closed, attempted to schedule: " + data);
        } while (!$this$getAndUpdate$iv.compareAndSet(cur$iv, upd$iv = it + (long)2));
        long state = cur$iv;
        this.activeCounter.incrementAndGet();
        $this$getAndUpdate$iv = this;
        long $this$hasWorkers$iv = state;
        boolean $i$f$hasWorkers = false;
        if ($this$hasWorkers$iv < 0L) {
            ((Continuation)this.obtainWorker()).resumeWith(Result.constructor-impl(data));
        } else {
            this.workerPool.allocate();
            Object result = this.tasksQueue.trySend-JP2dKIU(data);
            this.checkChannelResult-rs8usWo(result);
        }
    }

    public final void dispatch(@NotNull Collection<? extends T> data) {
        Intrinsics.checkNotNullParameter(data, (String)"data");
        Iterable $this$forEach$iv = data;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.iterator();
        while (iterator2.hasNext()) {
            Object element$iv;
            Object p0 = element$iv = iterator2.next();
            boolean $i$f$dispatch$stub_for_inlining = false;
            boolean bl = false;
            this.dispatch(p0);
        }
    }

    @Override
    public void close() {
        Object cur$iv;
        long it;
        long $this$isClosed$iv;
        long upd$iv;
        long cur$iv2;
        AtomicLong $this$getAndUpdate$iv = this.tasksAndWorkersCounter;
        boolean $i$f$getAndUpdate = false;
        do {
            it = cur$iv2 = $this$getAndUpdate$iv.getValue();
            boolean bl = false;
            MultiWorkerQueue multiWorkerQueue = this;
            $this$isClosed$iv = it;
            boolean $i$f$isClosed = false;
        } while (!$this$getAndUpdate$iv.compareAndSet(cur$iv2, upd$iv = ($this$isClosed$iv & 1L) == 1L ? it : it | 1L));
        List workers = this.workerPool.close();
        while (true) {
            long it2;
            long $this$hasWorkers$iv;
            long upd$iv2;
            long cur$iv3;
            AtomicLong $this$getAndUpdate$iv2 = this.tasksAndWorkersCounter;
            boolean $i$f$getAndUpdate2 = false;
            do {
                it2 = cur$iv3 = $this$getAndUpdate$iv2.getValue();
                boolean bl = false;
                MultiWorkerQueue $i$f$isClosed = this;
                $this$hasWorkers$iv = it2;
                boolean $i$f$hasWorkers = false;
            } while (!$this$getAndUpdate$iv2.compareAndSet(cur$iv3, upd$iv2 = $this$hasWorkers$iv < 0L ? it2 + (long)2 : it2));
            long state = cur$iv3;
            this.activeCounter.incrementAndGet();
            $this$getAndUpdate$iv2 = this;
            long $this$hasWorkers$iv2 = state;
            boolean $i$f$hasWorkers = false;
            if (!($this$hasWorkers$iv2 < 0L)) break;
            CancellableContinuation.DefaultImpls.cancel$default((CancellableContinuation)this.obtainWorker(), null, (int)1, null);
        }
        Iterable $this$forEach$iv = workers;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Thread it3 = (Thread)element$iv;
            boolean bl = false;
            it3.join();
        }
        AtomicRef $this$getAndUpdate$iv3 = this.futureAtomicRef;
        boolean $i$f$getAndUpdate3 = false;
        do {
            cur$iv = $this$getAndUpdate$iv3.getValue();
            CompletableFuture it4 = (CompletableFuture)cur$iv;
            boolean bl = false;
        } while (!$this$getAndUpdate$iv3.compareAndSet(cur$iv, upd$iv = null));
    }

    @Nullable
    public final Object join(@NotNull Continuation<? super Unit> $completion) {
        CompletableFuture completableFuture;
        CompletableFuture upd$iv;
        Object cur$iv;
        AtomicRef $this$getAndUpdate$iv = this.futureAtomicRef;
        boolean $i$f$getAndUpdate = false;
        do {
            cur$iv = $this$getAndUpdate$iv.getValue();
            CompletableFuture it = (CompletableFuture)cur$iv;
            boolean bl = false;
            completableFuture = it;
            if (completableFuture != null) continue;
            completableFuture = new CompletableFuture();
        } while (!$this$getAndUpdate$iv.compareAndSet(cur$iv, (Object)(upd$iv = completableFuture)));
        CompletableFuture old = (CompletableFuture)cur$iv;
        if (old == null) {
            CompletableFuture it;
            CompletableFuture upd$iv2;
            Object cur$iv2;
            this.resumeJoinCoroutineAndUpdate(0L);
            AtomicRef $this$getAndUpdate$iv2 = this.futureAtomicRef;
            boolean $i$f$getAndUpdate2 = false;
            do {
                cur$iv2 = $this$getAndUpdate$iv2.getValue();
                it = (CompletableFuture)cur$iv2;
                boolean bl = false;
            } while (!$this$getAndUpdate$iv2.compareAndSet(cur$iv2, (Object)(upd$iv2 = it)));
            CompletableFuture completableFuture2 = (CompletableFuture)cur$iv2;
            if (completableFuture2 != null) {
                return FutureKt.await((CompletionStage)completableFuture2, $completion);
            }
        } else {
            return FutureKt.await((CompletionStage)old, $completion);
        }
        return Unit.INSTANCE;
    }

    @JvmName(name="waitAndBlock")
    public final void waitAndBlock() {
        BuildersKt.runBlocking$default(null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)1, null);
    }

    private final void checkChannelResult-rs8usWo(Object result) {
        if (!ChannelResult.isSuccess-impl((Object)result)) {
            throw new IllegalStateException("Internal invariants of " + this + " were violated, please file this bug to us", ChannelResult.exceptionOrNull-impl((Object)result));
        }
    }

    @NotNull
    public Object clone() {
        return super.clone();
    }

    private static final Unit workerPool$lambda$2$lambda$1(MultiWorkerQueue this$0) {
        this$0.workerRunLoop();
        return Unit.INSTANCE;
    }

    private static final Thread workerPool$lambda$2(MultiWorkerQueue this$0, int ctl) {
        String name = this$0.name + "-" + ctl;
        return ThreadsKt.thread$default((boolean)false, (boolean)false, null, (String)name, (int)0, () -> MultiWorkerQueue.workerPool$lambda$2$lambda$1(this$0), (int)23, null);
    }

    public static final /* synthetic */ AtomicLong access$getTasksAndWorkersCounter$p(MultiWorkerQueue $this) {
        return $this.tasksAndWorkersCounter;
    }

    public static final /* synthetic */ Channel access$getTasksQueue$p(MultiWorkerQueue $this) {
        return $this.tasksQueue;
    }

    public static final /* synthetic */ void access$resumeJoinCoroutineAndUpdate(MultiWorkerQueue $this, long dec) {
        $this.resumeJoinCoroutineAndUpdate(dec);
    }

    public static final /* synthetic */ Channel access$getAvailableWorkers$p(MultiWorkerQueue $this) {
        return $this.availableWorkers;
    }

    public static final /* synthetic */ void access$checkChannelResult-rs8usWo(MultiWorkerQueue $this, Object result) {
        $this.checkChannelResult-rs8usWo(result);
    }
}

