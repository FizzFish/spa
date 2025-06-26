/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.report.IReportHashCalculator
 *  cn.sast.api.report.Report
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.common.ResourceKt
 *  cn.sast.framework.report.IFileReportConsumer
 *  cn.sast.framework.report.IMetadataVisitor
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.PlistDiagnostics
 *  cn.sast.framework.report.PlistDiagnostics$Companion
 *  cn.sast.framework.report.PlistDiagnostics$PlistDiagnosticImpl
 *  cn.sast.framework.report.PlistDiagnostics$flush$1
 *  cn.sast.framework.report.ReportConsumer
 *  cn.sast.framework.report.ReportConsumer$MetaData
 *  cn.sast.framework.report.metadata.AnalysisMetadata
 *  cn.sast.framework.result.OutputType
 *  com.feysh.corax.cache.analysis.SootInfoCache
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.Dispatchers
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report;

import cn.sast.api.config.MainConfig;
import cn.sast.api.report.IReportHashCalculator;
import cn.sast.api.report.Report;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.ResourceKt;
import cn.sast.framework.report.IFileReportConsumer;
import cn.sast.framework.report.IMetadataVisitor;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.PlistDiagnostics;
import cn.sast.framework.report.ReportConsumer;
import cn.sast.framework.report.metadata.AnalysisMetadata;
import cn.sast.framework.result.OutputType;
import com.feysh.corax.cache.analysis.SootInfoCache;
import java.io.IOException;
import java.lang.invoke.LambdaMetafactory;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002()B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ,\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0096@\u00a2\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u0019H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006*"}, d2={"Lcn/sast/framework/report/PlistDiagnostics;", "Lcn/sast/framework/report/ReportConsumer;", "Lcn/sast/framework/report/IFileReportConsumer;", "Lcn/sast/framework/report/IMetadataVisitor;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "info", "Lcom/feysh/corax/cache/analysis/SootInfoCache;", "outputDir", "Lcn/sast/common/IResDirectory;", "<init>", "(Lcn/sast/api/config/MainConfig;Lcom/feysh/corax/cache/analysis/SootInfoCache;Lcn/sast/common/IResDirectory;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "getInfo", "()Lcom/feysh/corax/cache/analysis/SootInfoCache;", "metadata", "Lcn/sast/framework/report/ReportConsumer$MetaData;", "getMetadata", "()Lcn/sast/framework/report/ReportConsumer$MetaData;", "hashCalculator", "Lcn/sast/api/report/IReportHashCalculator;", "getHashCalculator", "()Lcn/sast/api/report/IReportHashCalculator;", "flush", "", "reports", "", "Lcn/sast/api/report/Report;", "filename", "", "locator", "Lcn/sast/framework/report/IProjectFileLocator;", "(Ljava/util/List;Ljava/lang/String;Lcn/sast/framework/report/IProjectFileLocator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "visit", "analysisMetadata", "Lcn/sast/framework/report/metadata/AnalysisMetadata;", "getReportFileName", "fileName", "close", "PlistDiagnosticImpl", "Companion", "corax-framework"})
public final class PlistDiagnostics
extends ReportConsumer
implements IFileReportConsumer,
IMetadataVisitor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MainConfig mainConfig;
    @Nullable
    private final SootInfoCache info;
    @NotNull
    private final IReportHashCalculator hashCalculator;
    @NotNull
    private static final FileTime hardcodeModifiedTime;
    @NotNull
    private static final KLogger logger;

    public PlistDiagnostics(@NotNull MainConfig mainConfig, @Nullable SootInfoCache info2, @NotNull IResDirectory outputDir) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        Intrinsics.checkNotNullParameter((Object)outputDir, (String)"outputDir");
        super(OutputType.PLIST, outputDir);
        this.mainConfig = mainConfig;
        this.info = info2;
        this.hashCalculator = (IReportHashCalculator)new /* Unavailable Anonymous Inner Class!! */;
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    @Nullable
    public final SootInfoCache getInfo() {
        return this.info;
    }

    @NotNull
    public ReportConsumer.MetaData getMetadata() {
        return new ReportConsumer.MetaData("CoraxJava plist report", "1.0", "CoraxJava");
    }

    @NotNull
    public final IReportHashCalculator getHashCalculator() {
        return this.hashCalculator;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public Object flush(@NotNull List<Report> var1_1, @NotNull String var2_2, @NotNull IProjectFileLocator var3_3, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof flush.1)) ** GOTO lbl-1000
        var11_5 = $completion;
        if ((var11_5.label & -2147483648) != 0) {
            var11_5.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var12_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                outputFileName = this.getReportFileName((String)filename);
                fullPath = this.getOutputDir().resolve(outputFileName);
                v0 = new PlistDiagnosticImpl(this, this.getMetadata(), (IProjectFileLocator)locator).getRoot((List)reports);
                if (v0 == null) break;
                it = v0;
                $i$a$-let-PlistDiagnostics$flush$2 = false;
                $continuation.L$0 = fullPath;
                $continuation.label = 1;
                v1 = BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (Continuation)$continuation);
                if (v1 == var12_7) {
                    return var12_7;
                }
                ** GOTO lbl29
            }
            case 1: {
                $i$a$-let-PlistDiagnostics$flush$2 = false;
                fullPath = (IResource)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl29:
                // 2 sources

                try {
                    Intrinsics.checkNotNullExpressionValue((Object)Files.setLastModifiedTime(fullPath.getPath(), PlistDiagnostics.hardcodeModifiedTime), (String)"setLastModifiedTime(...)");
                }
                catch (IOException var9_13) {
                    // empty catch block
                }
                PlistDiagnostics.logger.trace((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, flush$lambda$1$lambda$0(cn.sast.common.IResource ), ()Ljava/lang/Object;)((IResource)fullPath));
                break;
            }
        }
        return Unit.INSTANCE;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public void visit(@NotNull AnalysisMetadata analysisMetadata2) {
        Intrinsics.checkNotNullParameter((Object)analysisMetadata2, (String)"analysisMetadata");
        IResFile metadataFilePath = this.getOutputDir().resolve("metadata.json").toFile();
        ResourceKt.writeText$default((IResFile)metadataFilePath, (String)analysisMetadata2.toJson(), null, (int)2, null);
    }

    private final String getReportFileName(String fileName) {
        String string = this.getMetadata().getAnalyzerName();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"getDefault(...)");
        String string2 = string.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
        return fileName + "_" + string2 + ".plist";
    }

    public void close() {
    }

    private static final Object flush$lambda$1$lambda$0(IResource $fullPath) {
        return "Create/modify plist file: '" + $fullPath + "'";
    }

    private static final Unit logger$lambda$2() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }

    static {
        SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
        String newLastModified = "10/10/2100";
        hardcodeModifiedTime = FileTime.from(sdf.parse(newLastModified).toInstant());
        logger = KotlinLogging.INSTANCE.logger(PlistDiagnostics::logger$lambda$2);
    }
}

