/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.coroutines.WorkQueue
 *  cn.sast.coroutines.WorkQueueKt
 *  cn.sast.coroutines.WorkQueueKt$runWork$1
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function3
 *  kotlinx.coroutines.CoroutineDispatcher
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.coroutines;

import cn.sast.coroutines.WorkQueue;
import cn.sast.coroutines.WorkQueueKt;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001av\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b2B\u0010\t\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000b\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\n\u00a2\u0006\u0002\b\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006\u0013"}, d2={"runWork", "", "T", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "numberOfCoroutines", "", "initialWorkload", "", "doWork", "Lkotlin/Function3;", "Lcn/sast/coroutines/WorkQueue;", "Lkotlin/ParameterName;", "name", "nextItem", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineDispatcher;ILjava/util/Collection;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "corax-api"})
public final class WorkQueueKt {
    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final <T> Object runWork(@NotNull CoroutineDispatcher var0, int var1_1, @NotNull Collection<? extends T> var2_2, @NotNull Function3<? super WorkQueue<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> var3_3, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof runWork.1)) ** GOTO lbl-1000
        var9_5 = $completion;
        if ((var9_5.label & -2147483648) != 0) {
            var9_5.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var10_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                queue = new WorkQueue(dispatcher, (Function3)doWork);
                var6_9 = initialWorkload.iterator();
lbl14:
                // 3 sources

                while (var6_9.hasNext()) {
                    item = var6_9.next();
                    $continuation.L$0 = queue;
                    $continuation.L$1 = var6_9;
                    $continuation.I$0 = numberOfCoroutines;
                    $continuation.label = 1;
                    v0 = queue.getChannel().send(item, (Continuation)$continuation);
                    if (v0 != var10_7) continue;
                    return var10_7;
                }
                break;
            }
            case 1: {
                numberOfCoroutines = $continuation.I$0;
                var6_9 = (Iterator<E>)$continuation.L$1;
                queue = (WorkQueue)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
                ** GOTO lbl14
            }
        }
        $continuation.L$0 = null;
        $continuation.L$1 = null;
        $continuation.label = 2;
        v1 = queue.start(numberOfCoroutines, (Continuation)$continuation);
        if (v1 == var10_7) {
            return var10_7;
        }
        ** GOTO lbl41
        {
            case 2: {
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl41:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

