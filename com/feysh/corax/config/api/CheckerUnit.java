/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.AnalysisApiNotImplException;
import com.feysh.corax.config.api.CheckerUnit;
import java.lang.invoke.LambdaMetafactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2={"Lcom/feysh/corax/config/api/CheckerUnit;", "", "<init>", "()V", "enableDefault", "", "getEnableDefault", "()Z", "Companion", "corax-config-api"})
public abstract class CheckerUnit {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean enableDefault;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(CheckerUnit::logger$lambda$0);

    public CheckerUnit() {
        this.enableDefault = true;
    }

    public boolean getEnableDefault() {
        return this.enableDefault;
    }

    private static final Unit logger$lambda$0() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JM\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u0002H\b2\u0006\u0010\n\u001a\u00020\u000b2'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r\u00a2\u0006\u0002\b\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lcom/feysh/corax/config/api/CheckerUnit$Companion;", "", "<init>", "()V", "logger", "Lmu/KLogger;", "processUnit", "", "API", "api", "checker", "Lcom/feysh/corax/config/api/CheckerUnit;", "config", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lcom/feysh/corax/config/api/CheckerUnit;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "corax-config-api"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * Unable to fully structure code
         */
        @Nullable
        public final <API> Object processUnit(API var1_1, @NotNull CheckerUnit var2_2, @NotNull Function2<? super API, ? super Continuation<? super Unit>, ? extends Object> var3_3, @NotNull Continuation<? super Unit> $completion) {
            if (!($completion instanceof processUnit.1)) ** GOTO lbl-1000
            var7_5 = $completion;
            if ((var7_5.label & -2147483648) != 0) {
                var7_5.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(this, $completion){
                    Object L$0;
                    /* synthetic */ Object result;
                    final /* synthetic */ Companion this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.processUnit(null, null, null, (Continuation<? super Unit>)((Continuation)this));
                    }
                };
            }
            $result = $continuation.result;
            var8_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    $continuation.L$0 = checker;
                    $continuation.label = 1;
                    v0 = config.invoke((Object)api, $continuation);
                    ** if (v0 != var8_7) goto lbl19
lbl18:
                    // 1 sources

                    return var8_7;
lbl19:
                    // 1 sources

                    ** GOTO lbl31
                }
                case 1: {
                    checker = (CheckerUnit)$continuation.L$0;
                    try {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
                    }
                    catch (AnalysisApiNotImplException var5_8) {
                    }
                    catch (Exception e) {
                        CheckerUnit.access$getLogger$cp().error((Throwable)e, (Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, processUnit$lambda$0(com.feysh.corax.config.api.CheckerUnit ), ()Ljava/lang/Object;)((CheckerUnit)checker));
                    }
lbl31:
                    // 4 sources

                    return Unit.INSTANCE;
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final Object processUnit$lambda$0(CheckerUnit $checker) {
            return "A bug occurs when process " + $checker + "[" + $checker.getClass() + "]::config. Please file this bug to us.";
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

