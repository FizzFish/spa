package com.feysh.corax.config.api;

import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;

public abstract class CheckerUnit {
    public static final Companion Companion = new Companion();
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(CheckerUnit.class);
    private final boolean enableDefault = true;

    public boolean getEnableDefault() {
        return enableDefault;
    }

    public static final class Companion {
        private Companion() {}

        @Nullable
        public final <API> Object processUnit(
            API api,
            @NotNull CheckerUnit checker,
            @NotNull Function2<? super API, ? super Continuation<? super Unit>, ? extends Object> config,
            @NotNull Continuation<? super Unit> completion
        ) {
            Object result;
            try {
                result = config.invoke(api, completion);
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return result;
                }
            } catch (AnalysisApiNotImplException ignored) {
            } catch (Exception e) {
                logger.error(e, () -> "A bug occurs when process " + checker + "[" + checker.getClass() + "]::config. Please file this bug to us.");
            }
            return Unit.INSTANCE;
        }
    }
}
