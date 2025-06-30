/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlinx.coroutines.Deferred
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.cache.coroutines;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\nH&\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Lcom/feysh/corax/cache/coroutines/Scheduler;", "", "schedule", "Lkotlinx/coroutines/Deferred;", "", "executor", "Ljava/util/concurrent/Executor;", "command", "Lkotlin/Function0;", "duration", "Lkotlin/time/Duration;", "schedule-SxA4cEA", "(Ljava/util/concurrent/Executor;Lkotlin/jvm/functions/Function0;J)Lkotlinx/coroutines/Deferred;", "corax-config-api"})
public interface Scheduler {
    @NotNull
    public Deferred<Unit> schedule-SxA4cEA(@NotNull Executor var1, @NotNull Function0<Unit> var2, long var3);
}

