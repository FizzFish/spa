/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.Report
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResource
 *  cn.sast.framework.report.IFileReportConsumer
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.ReportConsumer
 *  cn.sast.framework.report.ReportConsumer$MetaData
 *  cn.sast.framework.report.SarifDiagnostics
 *  cn.sast.framework.report.SarifDiagnostics$Companion
 *  cn.sast.framework.report.SarifDiagnostics$SarifDiagnosticsImpl
 *  cn.sast.framework.report.SarifDiagnostics$flush$1
 *  cn.sast.framework.result.OutputType
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.Dispatchers
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report;

import cn.sast.api.report.Report;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResource;
import cn.sast.framework.report.IFileReportConsumer;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.ReportConsumer;
import cn.sast.framework.report.SarifDiagnostics;
import cn.sast.framework.result.OutputType;
import java.lang.invoke.LambdaMetafactory;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0004\u001c\u001d\u001e\u001fB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\r\u001a\u00060\u000eR\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J,\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00a2\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0016R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006 "}, d2={"Lcn/sast/framework/report/SarifDiagnostics;", "Lcn/sast/framework/report/ReportConsumer;", "Lcn/sast/framework/report/IFileReportConsumer;", "outputDir", "Lcn/sast/common/IResDirectory;", "type", "Lcn/sast/framework/result/OutputType;", "<init>", "(Lcn/sast/common/IResDirectory;Lcn/sast/framework/result/OutputType;)V", "metadata", "Lcn/sast/framework/report/ReportConsumer$MetaData;", "getMetadata", "()Lcn/sast/framework/report/ReportConsumer$MetaData;", "getSarifDiagnosticsImpl", "Lcn/sast/framework/report/SarifDiagnostics$SarifDiagnosticsImpl;", "locator", "Lcn/sast/framework/report/IProjectFileLocator;", "flush", "", "reports", "", "Lcn/sast/api/report/Report;", "filename", "", "(Ljava/util/List;Ljava/lang/String;Lcn/sast/framework/report/IProjectFileLocator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReportFileName", "fileName", "close", "SarifMetadata", "MultiLangRule", "SarifDiagnosticsImpl", "Companion", "corax-framework"})
public class SarifDiagnostics
extends ReportConsumer
implements IFileReportConsumer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(SarifDiagnostics::logger$lambda$1);

    public SarifDiagnostics(@NotNull IResDirectory outputDir, @NotNull OutputType type) {
        Intrinsics.checkNotNullParameter((Object)outputDir, (String)"outputDir");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        super(type, outputDir);
    }

    public /* synthetic */ SarifDiagnostics(IResDirectory iResDirectory, OutputType outputType, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            outputType = OutputType.SARIF;
        }
        this(iResDirectory, outputType);
    }

    @NotNull
    public ReportConsumer.MetaData getMetadata() {
        return new ReportConsumer.MetaData("corax", "1.0", "CoraxJava");
    }

    @NotNull
    public SarifDiagnosticsImpl getSarifDiagnosticsImpl(@NotNull ReportConsumer.MetaData metadata, @NotNull IProjectFileLocator locator2) {
        Intrinsics.checkNotNullParameter((Object)metadata, (String)"metadata");
        Intrinsics.checkNotNullParameter((Object)locator2, (String)"locator");
        return new SarifDiagnosticsImpl(this, metadata, locator2);
    }

    @Nullable
    public Object flush(@NotNull List<Report> reports, @NotNull String filename, @NotNull IProjectFileLocator locator2, @NotNull Continuation<? super Unit> $completion) {
        return SarifDiagnostics.flush$suspendImpl((SarifDiagnostics)this, reports, (String)filename, (IProjectFileLocator)locator2, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ Object flush$suspendImpl(SarifDiagnostics var0, List<Report> var1_1, String var2_2, IProjectFileLocator var3_3, Continuation<? super Unit> $completion) {
        if (!($completion instanceof flush.1)) ** GOTO lbl-1000
        var8_5 = $completion;
        if ((var8_5.label & -2147483648) != 0) {
            var8_5.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var9_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                outputFileName = $this.getReportFileName((String)filename);
                fullPath = $this.getOutputDir().resolve(outputFileName);
                $continuation.L$0 = fullPath;
                $continuation.label = 1;
                v0 = BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (Continuation)$continuation);
                if (v0 == var9_7) {
                    return var9_7;
                }
                ** GOTO lbl24
            }
            case 1: {
                fullPath = (IResource)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl24:
                // 2 sources

                SarifDiagnostics.logger.trace((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, flush$lambda$0(cn.sast.common.IResource ), ()Ljava/lang/Object;)((IResource)fullPath));
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private final String getReportFileName(String fileName) {
        String string = this.getMetadata().getAnalyzerName();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"getDefault(...)");
        String string2 = string.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
        return fileName + "_" + string2 + ".sarif";
    }

    public void close() {
    }

    private static final Object flush$lambda$0(IResource $fullPath) {
        return "Create/modify plist file: '" + $fullPath + "'";
    }

    private static final Unit logger$lambda$1() {
        return Unit.INSTANCE;
    }
}

