/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.CoverData
 *  cn.sast.api.report.CoverInst
 *  cn.sast.api.report.CoverTaint
 *  cn.sast.api.report.ICoverageCollector
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.coverage.Coverage
 *  cn.sast.framework.report.coverage.JacocoCompoundCoverage
 *  cn.sast.framework.report.coverage.JacocoCompoundCoverage$getCoveredLineCounter$1
 *  cn.sast.framework.report.coverage.SourceCoverage
 *  cn.sast.framework.report.coverage.TaintCoverage
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.CoroutineScopeKt
 *  org.jacoco.core.analysis.ICounter
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.coverage;

import cn.sast.api.report.CoverData;
import cn.sast.api.report.CoverInst;
import cn.sast.api.report.CoverTaint;
import cn.sast.api.report.ICoverageCollector;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.coverage.Coverage;
import cn.sast.framework.report.coverage.JacocoCompoundCoverage;
import cn.sast.framework.report.coverage.SourceCoverage;
import cn.sast.framework.report.coverage.TaintCoverage;
import java.nio.charset.Charset;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jacoco.core.analysis.ICounter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00a2\u0006\u0002\u0010\u0016J$\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u0015H\u0096@\u00a2\u0006\u0002\u0010\u001dJ\"\u0010\u0011\u001a\u00020\u000e*\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u001fJ.\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006!"}, d2={"Lcn/sast/framework/report/coverage/JacocoCompoundCoverage;", "Lcn/sast/api/report/ICoverageCollector;", "locator", "Lcn/sast/framework/report/IProjectFileLocator;", "taintCoverage", "Lcn/sast/framework/report/coverage/Coverage;", "executionCoverage", "enableCoveredTaint", "", "<init>", "(Lcn/sast/framework/report/IProjectFileLocator;Lcn/sast/framework/report/coverage/Coverage;Lcn/sast/framework/report/coverage/Coverage;Z)V", "getEnableCoveredTaint", "()Z", "cover", "", "coverInfo", "Lcn/sast/api/report/CoverData;", "flush", "output", "Lcn/sast/common/IResDirectory;", "sourceEncoding", "Ljava/nio/charset/Charset;", "(Lcn/sast/common/IResDirectory;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCoveredLineCounter", "Lorg/jacoco/core/analysis/ICounter;", "allSourceFiles", "", "Lcn/sast/common/IResFile;", "encoding", "(Ljava/util/Set;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "out", "(Lcn/sast/framework/report/coverage/Coverage;Lcn/sast/common/IResDirectory;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copy", "corax-framework"})
public final class JacocoCompoundCoverage
implements ICoverageCollector {
    @NotNull
    private final IProjectFileLocator locator;
    @NotNull
    private final Coverage taintCoverage;
    @NotNull
    private final Coverage executionCoverage;
    private final boolean enableCoveredTaint;

    public JacocoCompoundCoverage(@NotNull IProjectFileLocator locator2, @NotNull Coverage taintCoverage, @NotNull Coverage executionCoverage, boolean enableCoveredTaint) {
        Intrinsics.checkNotNullParameter((Object)locator2, (String)"locator");
        Intrinsics.checkNotNullParameter((Object)taintCoverage, (String)"taintCoverage");
        Intrinsics.checkNotNullParameter((Object)executionCoverage, (String)"executionCoverage");
        this.locator = locator2;
        this.taintCoverage = taintCoverage;
        this.executionCoverage = executionCoverage;
        this.enableCoveredTaint = enableCoveredTaint;
    }

    public /* synthetic */ JacocoCompoundCoverage(IProjectFileLocator iProjectFileLocator, Coverage coverage, Coverage coverage2, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            coverage = (Coverage)new TaintCoverage();
        }
        if ((n & 4) != 0) {
            coverage2 = new Coverage();
        }
        if ((n & 8) != 0) {
            bl = false;
        }
        this(iProjectFileLocator, coverage, coverage2, bl);
    }

    public boolean getEnableCoveredTaint() {
        return this.enableCoveredTaint;
    }

    public void cover(@NotNull CoverData coverInfo) {
        Intrinsics.checkNotNullParameter((Object)coverInfo, (String)"coverInfo");
        CoverData coverData = coverInfo;
        if (coverData instanceof CoverTaint) {
            this.taintCoverage.coverByQueue(((CoverTaint)coverInfo).getClassName(), ((CoverTaint)coverInfo).getLineNumber());
        } else if (coverData instanceof CoverInst) {
            this.executionCoverage.coverByQueue(((CoverInst)coverInfo).getClassName(), ((CoverInst)coverInfo).getLineNumber());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Nullable
    public Object flush(@NotNull IResDirectory output, @NotNull Charset sourceEncoding, @NotNull Continuation<? super Unit> $completion) {
        Object object = CoroutineScopeKt.coroutineScope((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public Object getCoveredLineCounter(@NotNull Set<? extends IResFile> var1_1, @NotNull Charset var2_2, @NotNull Continuation<? super ICounter> $completion) {
        if (!($completion instanceof getCoveredLineCounter.1)) ** GOTO lbl-1000
        var5_4 = $completion;
        if ((var5_4.label & -2147483648) != 0) {
            var5_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var6_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = allSourceFiles;
                $continuation.label = 1;
                v0 = this.executionCoverage.calculateSourceCoverage(this.locator, (Charset)encoding, (Continuation)$continuation);
                if (v0 == var6_6) {
                    return var6_6;
                }
                ** GOTO lbl22
            }
            case 1: {
                allSourceFiles = (Set)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                return ((SourceCoverage)v0).calculateCoveredRatio(allSourceFiles);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object flush(@NotNull Coverage $this$flush, @NotNull IResDirectory out, @NotNull Charset sourceEncoding, @NotNull Continuation<? super Unit> $completion) {
        Object object = $this$flush.flushCoverage(this.locator, out, sourceEncoding, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final JacocoCompoundCoverage copy(@NotNull IProjectFileLocator locator2, @NotNull Coverage taintCoverage, @NotNull Coverage executionCoverage, boolean enableCoveredTaint) {
        Intrinsics.checkNotNullParameter((Object)locator2, (String)"locator");
        Intrinsics.checkNotNullParameter((Object)taintCoverage, (String)"taintCoverage");
        Intrinsics.checkNotNullParameter((Object)executionCoverage, (String)"executionCoverage");
        return new JacocoCompoundCoverage(locator2, taintCoverage, executionCoverage, enableCoveredTaint);
    }

    public static /* synthetic */ JacocoCompoundCoverage copy$default(JacocoCompoundCoverage jacocoCompoundCoverage, IProjectFileLocator iProjectFileLocator, Coverage coverage, Coverage coverage2, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            iProjectFileLocator = jacocoCompoundCoverage.locator;
        }
        if ((n & 2) != 0) {
            coverage = jacocoCompoundCoverage.taintCoverage;
        }
        if ((n & 4) != 0) {
            coverage2 = jacocoCompoundCoverage.executionCoverage;
        }
        if ((n & 8) != 0) {
            bl = jacocoCompoundCoverage.getEnableCoveredTaint();
        }
        return jacocoCompoundCoverage.copy(iProjectFileLocator, coverage, coverage2, bl);
    }

    public static final /* synthetic */ Coverage access$getTaintCoverage$p(JacocoCompoundCoverage $this) {
        return $this.taintCoverage;
    }

    public static final /* synthetic */ Coverage access$getExecutionCoverage$p(JacocoCompoundCoverage $this) {
        return $this.executionCoverage;
    }
}

