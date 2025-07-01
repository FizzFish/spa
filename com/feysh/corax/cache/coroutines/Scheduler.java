package com.feysh.corax.cache.coroutines;

import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;

public interface Scheduler {
    @NotNull
    Deferred<Unit> schedule(@NotNull Executor executor, @NotNull Runnable command, long duration);
}