package cn.sast.coroutines;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Collection;
import java.util.Iterator;

public final class WorkQueueKt {
    @Nullable
    public static <T> Object runWork(
            @NotNull CoroutineDispatcher dispatcher,
            int numberOfCoroutines,
            @NotNull Collection<? extends T> initialWorkload,
            @NotNull Function3<? super WorkQueue<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> doWork,
            @NotNull Continuation<? super Unit> completion) {

        WorkQueue<T> queue = new WorkQueue<>(dispatcher, doWork);
        Iterator<? extends T> iterator = initialWorkload.iterator();

        while (iterator.hasNext()) {
            T item = iterator.next();
            Object result = queue.getChannel().send(item, completion);
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return result;
            }
        }

        Object startResult = queue.start(numberOfCoroutines, completion);
        if (startResult == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return startResult;
        }

        return Unit.INSTANCE;
    }
}