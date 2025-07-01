package cn.sast.coroutines;

import cn.sast.common.ExceptionsKt;
import cn.sast.common.OS;
import java.io.Closeable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MultiWorkerQueue<T> implements Closeable, Cloneable {
    private final String name;
    private final int workersCount;
    private final TaskProcessor<T> action;
    private final Channel<T> tasksQueue;
    private final Channel<CancellableContinuation<T>> availableWorkers;
    private final AtomicReference<CompletableFuture<Unit>> futureAtomicRef;
    private final OnDemandAllocatingPool<Thread> workerPool;
    private final AtomicLong tasksAndWorkersCounter;
    private final AtomicLong activeCounter;

    public MultiWorkerQueue(@NotNull String name, int workersCount, @NotNull TaskProcessor<T> action) {
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        if (action == null) throw new IllegalArgumentException("action cannot be null");
        if (workersCount <= 0) {
            throw new IllegalStateException("workersCount: " + workersCount + " must be greater than zero");
        }

        this.name = name;
        this.workersCount = workersCount;
        this.action = action;
        this.tasksQueue = new Channel<>(Integer.MAX_VALUE);
        this.availableWorkers = new Channel<>(Integer.MAX_VALUE);
        this.futureAtomicRef = new AtomicReference<>();
        this.workerPool = new OnDemandAllocatingPool<>(workersCount, ctl -> createWorkerThread(ctl));
        this.tasksAndWorkersCounter = new AtomicLong(0);
        this.activeCounter = new AtomicLong(0);
    }

    public MultiWorkerQueue(@NotNull String name, @NotNull TaskProcessor<T> action) {
        this(name, Math.max(OS.getMaxThreadNum() - 1, 1), action);
    }

    @Nullable
    public Object beforeExecute(T task, @NotNull Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Nullable
    public Object process(T task, @NotNull Continuation<? super Unit> continuation) {
        try {
            Object beforeResult = beforeExecute(task, continuation);
            if (beforeResult == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return beforeResult;
            }

            Object processResult = action.process(task, continuation);
            if (processResult == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return processResult;
            }

            return afterExecute(task, null, continuation);
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable t) {
            ExceptionsKt.checkCritical(t);
            return afterExecute(task, t, continuation);
        }
    }

    @Nullable
    public Object afterExecute(T task, @Nullable Throwable t, @NotNull Continuation<? super Unit> continuation) {
        if (t != null) {
            t.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    private Thread createWorkerThread(int ctl) {
        String threadName = name + "-" + ctl;
        return new Thread(this::workerRunLoop, threadName);
    }

    private void workerRunLoop() {
        try {
            while (true) {
                T task = tasksQueue.receive();
                CancellableContinuation<T> continuation = obtainWorker();
                continuation.resumeWith(Result.success(task));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private CancellableContinuation<T> obtainWorker() {
        CancellableContinuation<T> continuation = availableWorkers.poll();
        if (continuation == null) {
            continuation = new CancellableContinuation<>();
        }
        return continuation;
    }

    public void dispatch(T data) {
        long state = tasksAndWorkersCounter.getAndUpdate(prev -> {
            if ((prev & 1L) == 1L) {
                throw new IllegalStateException("Dispatcher " + name + " was closed, attempted to schedule: " + data);
            }
            return prev + 2;
        });

        activeCounter.incrementAndGet();
        
        if (state < 0) {
            obtainWorker().resumeWith(Result.success(data));
        } else {
            workerPool.allocate();
            tasksQueue.send(data);
        }
    }

    public void dispatch(@NotNull Collection<? extends T> data) {
        if (data == null) throw new IllegalArgumentException("data cannot be null");
        for (T item : data) {
            dispatch(item);
        }
    }

    @Override
    public void close() {
        tasksAndWorkersCounter.updateAndGet(prev -> prev | 1L);
        
        List<Thread> workers = workerPool.close();
        while (tasksAndWorkersCounter.get() < 0) {
            activeCounter.incrementAndGet();
            CancellableContinuation.cancel(obtainWorker());
        }

        for (Thread worker : workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        futureAtomicRef.set(null);
    }

    @Nullable
    public Object join(@NotNull Continuation<? super Unit> continuation) {
        CompletableFuture<Unit> future = futureAtomicRef.updateAndGet(prev -> 
            prev != null ? prev : new CompletableFuture<>()
        );

        if (futureAtomicRef.get() == future) {
            resumeJoinCoroutineAndUpdate(0L);
        }

        return FutureKt.await(future, continuation);
    }

    public void waitAndBlock() {
        try {
            join(new Continuation<Unit>() {
                @Override
                public void resumeWith(@NotNull Object result) {}
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void resumeJoinCoroutineAndUpdate(long dec) {
        long active = activeCounter.addAndGet(-dec);
        if (active == 0) {
            CompletableFuture<Unit> future = futureAtomicRef.getAndSet(null);
            if (future != null) {
                future.complete(Unit.INSTANCE);
            }
        } else if (active < 0) {
            throw new IllegalStateException("Internal invariants of " + this + " were violated");
        }
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    interface TaskProcessor<T> {
        @Nullable
        Object process(T task, @NotNull Continuation<? super Unit> continuation);
    }
}
