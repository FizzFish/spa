/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.TaskQueueKt
 *  cn.sast.common.TaskQueueKt$runInMilliSeconds$1
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlinx.coroutines.Job
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.common;

import cn.sast.common.TaskQueueKt;
import java.lang.invoke.LambdaMetafactory;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.Job;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0086@\u00a2\u0006\u0002\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"logger", "Lmu/KLogger;", "runInMilliSeconds", "", "job", "Lkotlinx/coroutines/Job;", "milliSeconds", "", "name", "", "timeoutAction", "Lkotlin/Function0;", "(Lkotlinx/coroutines/Job;JLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "corax-api"})
public final class TaskQueueKt {
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(TaskQueueKt::logger$lambda$0);

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final Object runInMilliSeconds(@NotNull Job var0, long var1_1, @NotNull String var3_2, @NotNull Function0<Unit> var4_3, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof runInMilliSeconds.1)) ** GOTO lbl-1000
        var12_5 = $completion;
        if ((var12_5.label & -2147483648) != 0) {
            var12_5.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var13_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                start = System.currentTimeMillis();
                timer = new Timer();
                timer.schedule((TimerTask)new /* Unavailable Anonymous Inner Class!! */, milliSeconds);
                $continuation.L$0 = name;
                $continuation.L$1 = timer;
                $continuation.J$0 = milliSeconds;
                $continuation.J$1 = start;
                $continuation.label = 1;
                v0 = job.join((Continuation)$continuation);
                if (v0 == var13_7) {
                    return var13_7;
                }
                ** GOTO lbl31
            }
            case 1: {
                start = $continuation.J$1;
                milliSeconds = $continuation.J$0;
                timer = (Timer)$continuation.L$1;
                name = (String)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl31:
                // 2 sources

                timer.cancel();
                end = System.currentTimeMillis();
                if ((double)(end - start - milliSeconds) / (double)milliSeconds > 0.1) {
                    TaskQueueKt.logger.warn((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, runInMilliSeconds$lambda$1(java.lang.String long long long ), ()Ljava/lang/Object;)((String)name, (long)milliSeconds, (long)end, (long)start));
                }
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private static final Unit logger$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final Object runInMilliSeconds$lambda$1(String $name, long $milliSeconds, long $end, long $start) {
        return $name + " runInMilliSeconds cost more than expected expect=" + $milliSeconds + ", actual=" + ($end - $start);
    }

    public static final /* synthetic */ KLogger access$getLogger$p() {
        return logger;
    }
}

