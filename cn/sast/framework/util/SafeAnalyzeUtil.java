/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.engine.PreAnalysisImpl
 *  cn.sast.framework.util.SafeAnalyzeUtil
 *  cn.sast.framework.util.SafeAnalyzeUtil$safeAnalyze$1
 *  cn.sast.framework.util.SafeAnalyzeUtil$safeRunInSceneAsync$1
 *  com.feysh.corax.config.api.CheckerUnit
 *  com.feysh.corax.config.api.ICheckPoint
 *  kotlin.Metadata
 *  kotlin.NotImplementedError
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.util;

import cn.sast.framework.engine.PreAnalysisImpl;
import cn.sast.framework.util.SafeAnalyzeUtil;
import com.feysh.corax.config.api.CheckerUnit;
import com.feysh.corax.config.api.ICheckPoint;
import java.lang.invoke.LambdaMetafactory;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006JU\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\t*\u00020\n\"\u0004\b\u0001\u0010\b2\u0006\u0010\f\u001a\u0002H\t2'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e\u00a2\u0006\u0002\b\u0010H\u0086@R\u00020\u000b\u00a2\u0006\u0002\u0010\u0011J8\u0010\u0012\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014H\u0086@R\u00020\u0013\u00a2\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u001aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lcn/sast/framework/util/SafeAnalyzeUtil;", "", "errorLimitCount", "", "errorCount", "<init>", "(II)V", "safeAnalyze", "T", "C", "Lcom/feysh/corax/config/api/ICheckPoint;", "Lkotlinx/coroutines/CoroutineScope;", "point", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lcom/feysh/corax/config/api/ICheckPoint;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeRunInSceneAsync", "Lcom/feysh/corax/config/api/CheckerUnit;", "Lkotlin/Function1;", "(Lcom/feysh/corax/config/api/CheckerUnit;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCheckerError", "", "t", "", "Lkotlin/Function0;", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nSafeAnalyzeUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeAnalyzeUtil.kt\ncn/sast/framework/util/SafeAnalyzeUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,57:1\n1#2:58\n*E\n"})
public final class SafeAnalyzeUtil {
    private final int errorLimitCount;
    private int errorCount;

    public SafeAnalyzeUtil(int errorLimitCount, int errorCount) {
        this.errorLimitCount = errorLimitCount;
        this.errorCount = errorCount;
    }

    public /* synthetic */ SafeAnalyzeUtil(int n, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        this(n, n2);
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final <C extends ICheckPoint, T> Object safeAnalyze(@NotNull CoroutineScope var1_1, @NotNull C var2_2, @NotNull Function2<? super C, ? super Continuation<? super T>, ? extends Object> var3_3, @NotNull Continuation<? super T> $completion) {
        if (!($completion instanceof safeAnalyze.1)) ** GOTO lbl-1000
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
                $continuation.L$0 = this;
                $continuation.L$1 = $context_receiver_0;
                $continuation.L$2 = point;
                $continuation.label = 1;
                v0 = block.invoke((Object)point, (Object)$continuation);
                ** if (v0 != var10_7) goto lbl21
lbl20:
                // 1 sources

                return var10_7;
lbl21:
                // 1 sources

                ** GOTO lbl30
            }
            case 1: {
                point = (ICheckPoint)$continuation.L$2;
                $context_receiver_0 = (CoroutineScope)$continuation.L$1;
                this = (SafeAnalyzeUtil)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl30:
                    // 2 sources

                    it = var5_8 = v0;
                    $i$a$-takeIf-SafeAnalyzeUtil$safeAnalyze$2 = false;
                    var5_8 = Intrinsics.areEqual((Object)it, (Object)Unit.INSTANCE) == false != false ? var5_8 : null;
                }
                catch (Throwable t) {
                    this.onCheckerError(t, (Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, safeAnalyze$lambda$2(java.lang.Throwable cn.sast.framework.util.SafeAnalyzeUtil kotlinx.coroutines.CoroutineScope com.feysh.corax.config.api.ICheckPoint ), ()Lkotlin/Unit;)((Throwable)t, (SafeAnalyzeUtil)this, (CoroutineScope)$context_receiver_0, (ICheckPoint)point));
                    var5_8 = null;
                }
                return var5_8;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final <T> Object safeRunInSceneAsync(@NotNull CheckerUnit var1_1, @NotNull Function1<? super Continuation<? super T>, ? extends Object> var2_2, @NotNull Continuation<? super T> $completion) {
        if (!($completion instanceof safeRunInSceneAsync.1)) ** GOTO lbl-1000
        var6_4 = $completion;
        if ((var6_4.label & -2147483648) != 0) {
            var6_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var7_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = this;
                $continuation.L$1 = $context_receiver_0;
                $continuation.label = 1;
                v0 = block.invoke((Object)$continuation);
                ** if (v0 != var7_6) goto lbl20
lbl19:
                // 1 sources

                return var7_6;
lbl20:
                // 1 sources

                ** GOTO lbl28
            }
            case 1: {
                $context_receiver_0 = (CheckerUnit)$continuation.L$1;
                this = (SafeAnalyzeUtil)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl28:
                    // 2 sources

                    return v0;
                }
                catch (Exception t) {
                    this.onCheckerError((Throwable)t, (Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, safeRunInSceneAsync$lambda$4(java.lang.Exception com.feysh.corax.config.api.CheckerUnit ), ()Lkotlin/Unit;)((Exception)t, (CheckerUnit)$context_receiver_0));
                    return null;
                }
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private final void onCheckerError(Throwable t, Function0<Unit> onCheckerError) {
        Throwable throwable = t;
        if (throwable instanceof CancellationException) {
            throw t;
        }
        if (!(throwable instanceof Exception) && !(throwable instanceof NotImplementedError)) {
            throw t;
        }
        onCheckerError.invoke();
    }

    private static final Object safeAnalyze$lambda$2$lambda$1(ICheckPoint $point) {
        return "When analyzing this location: " + $point + ", please file this bug to us";
    }

    private static final Unit safeAnalyze$lambda$2(Throwable $t, SafeAnalyzeUtil this$0, CoroutineScope $$context_receiver_0, ICheckPoint $point) {
        PreAnalysisImpl.Companion.getKLogger().error($t, () -> SafeAnalyzeUtil.safeAnalyze$lambda$2$lambda$1($point));
        ++this$0.errorCount;
        if (this$0.errorCount > this$0.errorLimitCount) {
            CoroutineScopeKt.cancel$default((CoroutineScope)$$context_receiver_0, null, (int)1, null);
        }
        return Unit.INSTANCE;
    }

    private static final Object safeRunInSceneAsync$lambda$4$lambda$3(CheckerUnit $$context_receiver_0) {
        return "Occur a exception while call " + $$context_receiver_0 + ":runInSceneAsync, please file this bug to us";
    }

    private static final Unit safeRunInSceneAsync$lambda$4(Exception $t, CheckerUnit $$context_receiver_0) {
        PreAnalysisImpl.Companion.getKLogger().error((Throwable)$t, () -> SafeAnalyzeUtil.safeRunInSceneAsync$lambda$4$lambda$3($$context_receiver_0));
        return Unit.INSTANCE;
    }
}

