/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.Counter
 *  cn.sast.api.report.IResultCollector
 *  cn.sast.common.IResFile
 *  cn.sast.framework.result.IMissingSummaryReporter
 *  cn.sast.framework.result.MissingSummaryReporter
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 */
package cn.sast.framework.result;

import cn.sast.api.report.Counter;
import cn.sast.api.report.IResultCollector;
import cn.sast.common.IResFile;
import cn.sast.framework.result.IMissingSummaryReporter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u000e\u0010\r\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lcn/sast/framework/result/MissingSummaryReporter;", "Lcn/sast/framework/result/IMissingSummaryReporter;", "Lcn/sast/api/report/IResultCollector;", "outputFile", "Lcn/sast/common/IResFile;", "<init>", "(Lcn/sast/common/IResFile;)V", "counter", "Lcn/sast/api/report/Counter;", "Lsoot/SootMethod;", "reportMissingMethod", "", "method", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "corax-framework"})
public final class MissingSummaryReporter
implements IMissingSummaryReporter,
IResultCollector {
    @Nullable
    private final IResFile outputFile;
    @NotNull
    private final Counter<SootMethod> counter;

    public MissingSummaryReporter(@Nullable IResFile outputFile) {
        this.outputFile = outputFile;
        this.counter = new Counter();
    }

    public /* synthetic */ MissingSummaryReporter(IResFile iResFile, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            iResFile = null;
        }
        this(iResFile);
    }

    public void reportMissingMethod(@NotNull SootMethod method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        this.counter.count((Object)method);
    }

    @Nullable
    public Object flush(@NotNull Continuation<? super Unit> $completion) {
        block0: {
            IResFile iResFile = this.outputFile;
            if (iResFile == null) break block0;
            IResFile it = iResFile;
            boolean bl = false;
            this.counter.writeResults(it);
        }
        return Unit.INSTANCE;
    }

    public MissingSummaryReporter() {
        this(null, 1, null);
    }
}

