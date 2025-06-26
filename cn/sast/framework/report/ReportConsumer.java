/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResDirectory
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.IReportConsumer
 *  cn.sast.framework.report.IReportConsumer$DefaultImpls
 *  cn.sast.framework.report.ReportConsumer
 *  cn.sast.framework.report.ReportConsumer$MetaData
 *  cn.sast.framework.result.OutputType
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report;

import cn.sast.common.IResDirectory;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.IReportConsumer;
import cn.sast.framework.report.ReportConsumer;
import cn.sast.framework.result.OutputType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2={"Lcn/sast/framework/report/ReportConsumer;", "Lcn/sast/framework/report/IReportConsumer;", "type", "Lcn/sast/framework/result/OutputType;", "outputDir", "Lcn/sast/common/IResDirectory;", "<init>", "(Lcn/sast/framework/result/OutputType;Lcn/sast/common/IResDirectory;)V", "getType", "()Lcn/sast/framework/result/OutputType;", "getOutputDir", "()Lcn/sast/common/IResDirectory;", "metadata", "Lcn/sast/framework/report/ReportConsumer$MetaData;", "getMetadata", "()Lcn/sast/framework/report/ReportConsumer$MetaData;", "init", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MetaData", "corax-framework"})
public abstract class ReportConsumer
implements IReportConsumer {
    @NotNull
    private final OutputType type;
    @NotNull
    private final IResDirectory outputDir;

    public ReportConsumer(@NotNull OutputType type, @NotNull IResDirectory outputDir) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)outputDir, (String)"outputDir");
        this.type = type;
        this.outputDir = outputDir;
        this.outputDir.mkdirs();
    }

    @NotNull
    public OutputType getType() {
        return this.type;
    }

    @NotNull
    public final IResDirectory getOutputDir() {
        return this.outputDir;
    }

    @NotNull
    public abstract MetaData getMetadata();

    @Nullable
    public Object init(@NotNull Continuation<? super Unit> $completion) {
        return ReportConsumer.init$suspendImpl((ReportConsumer)this, $completion);
    }

    static /* synthetic */ Object init$suspendImpl(ReportConsumer $this, Continuation<? super Unit> $completion) {
        $this.outputDir.deleteDirectoryContents();
        $this.outputDir.mkdirs();
        return Unit.INSTANCE;
    }

    @Nullable
    public Object run(@NotNull IProjectFileLocator locator2, @NotNull Continuation<? super Unit> $completion) {
        return IReportConsumer.DefaultImpls.run((IReportConsumer)this, (IProjectFileLocator)locator2, $completion);
    }
}

