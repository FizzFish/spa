package cn.sast.common;

import kotlinx.coroutines.Job;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;

import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Supplier;

public final class TaskQueueKt {
    private static final KLogger logger = KotlinLogging.INSTANCE.logger("TaskQueueKt");

    public static void runInMilliSeconds(@NotNull Job job, long milliSeconds, @NotNull String name, 
            @NotNull Runnable timeoutAction) {
        long start = System.currentTimeMillis();
        Timer timer = new Timer();
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeoutAction.run();
            }
        }, milliSeconds);

        job.join();
        timer.cancel();
        
        long end = System.currentTimeMillis();
        long actualDuration = end - start;
        if ((double)(actualDuration - milliSeconds) / milliSeconds > 0.1) {
            logger.warn(() -> name + " runInMilliSeconds cost more than expected expect=" 
                    + milliSeconds + ", actual=" + actualDuration);
        }
    }
}