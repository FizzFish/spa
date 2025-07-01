package cn.sast.framework.util;

import cn.sast.framework.engine.PreAnalysisImpl;
import com.feysh.corax.config.api.CheckerUnit;
import com.feysh.corax.config.api.ICheckPoint;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CancellationException;

public final class SafeAnalyzeUtil {
    private final int errorLimitCount;
    private int errorCount;

    public SafeAnalyzeUtil(int errorLimitCount, int errorCount) {
        this.errorLimitCount = errorLimitCount;
        this.errorCount = errorCount;
    }

    public SafeAnalyzeUtil(int errorLimitCount) {
        this(errorLimitCount, 0);
    }

    @Nullable
    public final <C extends ICheckPoint, T> Object safeAnalyze(
            @NotNull CoroutineScope scope,
            @NotNull C point,
            @NotNull Function2<? super C, ? super Continuation<? super T>, ? extends Object> block,
            @NotNull Continuation<? super T> completion) {
        try {
            Object result = block.invoke(point, completion);
            if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return result;
            }
            return result instanceof Unit ? null : result;
        } catch (Throwable t) {
            onCheckerError(t, () -> {
                PreAnalysisImpl.Companion.getKLogger().error(t, () -> 
                    "When analyzing this location: " + point + ", please file this bug to us");
                errorCount++;
                if (errorCount > errorLimitCount) {
                    scope.cancel(null);
                }
                return Unit.INSTANCE;
            });
            return null;
        }
    }

    @Nullable
    public final <T> Object safeRunInSceneAsync(
            @NotNull CheckerUnit unit,
            @NotNull Function1<? super Continuation<? super T>, ? extends Object> block,
            @NotNull Continuation<? super T> completion) {
        try {
            Object result = block.invoke(completion);
            if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return result;
            }
            return result;
        } catch (Exception t) {
            onCheckerError(t, () -> {
                PreAnalysisImpl.Companion.getKLogger().error(t, () -> 
                    "Occur a exception while call " + unit + ":runInSceneAsync, please file this bug to us");
                return Unit.INSTANCE;
            });
            return null;
        }
    }

    private void onCheckerError(Throwable t, Function0<Unit> onCheckerError) {
        if (t instanceof CancellationException) {
            throw (CancellationException) t;
        }
        if (!(t instanceof Exception) && !(t instanceof kotlin.NotImplementedError)) {
            throw new RuntimeException(t);
        }
        onCheckerError.invoke();
    }
}
