/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.common.JarMerger
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.ReportConsumer$MetaData
 *  cn.sast.framework.report.SarifDiagnostics
 *  cn.sast.framework.report.SarifDiagnostics$SarifDiagnosticsImpl
 *  cn.sast.framework.report.SarifDiagnosticsPack
 *  cn.sast.framework.report.SarifDiagnosticsPack$Companion
 *  cn.sast.framework.report.SarifDiagnosticsPack$SarifDiagnosticsPackImpl
 *  cn.sast.framework.report.SarifDiagnosticsPack$init$1
 *  cn.sast.framework.report.sarif.Description
 *  cn.sast.framework.report.sarif.UriBase
 *  cn.sast.framework.result.OutputType
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.MapsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.utbot.common.LoggerWithLogMethod
 *  org.utbot.common.LoggingKt
 *  org.utbot.common.Maybe
 */
package cn.sast.framework.report;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.JarMerger;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.ReportConsumer;
import cn.sast.framework.report.SarifDiagnostics;
import cn.sast.framework.report.SarifDiagnosticsPack;
import cn.sast.framework.report.sarif.Description;
import cn.sast.framework.report.sarif.UriBase;
import cn.sast.framework.result.OutputType;
import java.io.Closeable;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.common.LoggerWithLogMethod;
import org.utbot.common.LoggingKt;
import org.utbot.common.Maybe;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0002$%B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0011\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0013J\u001c\u0010\u001d\u001a\u00060\u001eR\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006&"}, d2={"Lcn/sast/framework/report/SarifDiagnosticsPack;", "Lcn/sast/framework/report/SarifDiagnostics;", "Ljava/io/Closeable;", "outputDir", "Lcn/sast/common/IResDirectory;", "sourceJarRootMapKey", "", "sourceJarRootMapValue", "sourceJarFileName", "type", "Lcn/sast/framework/result/OutputType;", "<init>", "(Lcn/sast/common/IResDirectory;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcn/sast/framework/result/OutputType;)V", "sourceJarPath", "Lcn/sast/common/IResFile;", "sourceJar", "Lcn/sast/common/JarMerger;", "init", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "originalUriBaseIds", "", "Lcn/sast/framework/report/sarif/UriBase;", "getOriginalUriBaseIds", "()Ljava/util/Map;", "entriesMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getEntriesMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "getSarifDiagnosticsImpl", "Lcn/sast/framework/report/SarifDiagnostics$SarifDiagnosticsImpl;", "metadata", "Lcn/sast/framework/report/ReportConsumer$MetaData;", "locator", "Lcn/sast/framework/report/IProjectFileLocator;", "close", "SarifDiagnosticsPackImpl", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nSarifDiagnosticsPack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SarifDiagnosticsPack.kt\ncn/sast/framework/report/SarifDiagnosticsPack\n+ 2 Logging.kt\norg/utbot/common/LoggingKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,92:1\n49#2,13:93\n62#2,11:108\n216#3,2:106\n*S KotlinDebug\n*F\n+ 1 SarifDiagnosticsPack.kt\ncn/sast/framework/report/SarifDiagnosticsPack\n*L\n71#1:93,13\n71#1:108,11\n72#1:106,2\n*E\n"})
public final class SarifDiagnosticsPack
extends SarifDiagnostics
implements Closeable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String sourceJarRootMapKey;
    @NotNull
    private final String sourceJarFileName;
    private IResFile sourceJarPath;
    private JarMerger sourceJar;
    @NotNull
    private final Map<String, UriBase> originalUriBaseIds;
    @NotNull
    private final ConcurrentHashMap<String, IResFile> entriesMap;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(SarifDiagnosticsPack::logger$lambda$4);

    public SarifDiagnosticsPack(@NotNull IResDirectory outputDir, @NotNull String sourceJarRootMapKey, @NotNull String sourceJarRootMapValue, @NotNull String sourceJarFileName, @NotNull OutputType type) {
        Intrinsics.checkNotNullParameter((Object)outputDir, (String)"outputDir");
        Intrinsics.checkNotNullParameter((Object)sourceJarRootMapKey, (String)"sourceJarRootMapKey");
        Intrinsics.checkNotNullParameter((Object)sourceJarRootMapValue, (String)"sourceJarRootMapValue");
        Intrinsics.checkNotNullParameter((Object)sourceJarFileName, (String)"sourceJarFileName");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        super(outputDir, type);
        this.sourceJarRootMapKey = sourceJarRootMapKey;
        this.sourceJarFileName = sourceJarFileName;
        this.originalUriBaseIds = MapsKt.mapOf((Pair)TuplesKt.to((Object)this.sourceJarRootMapKey, (Object)new UriBase(sourceJarRootMapValue, new Description("Should replace " + sourceJarRootMapValue + " with file:///{absolute-uncompressed-path-of-" + this.sourceJarFileName + ".jar}/" + this.sourceJarFileName + "/"))));
        this.entriesMap = new ConcurrentHashMap();
    }

    public /* synthetic */ SarifDiagnosticsPack(IResDirectory iResDirectory, String string, String string2, String string3, OutputType outputType, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            string = "SRCROOT";
        }
        if ((n & 4) != 0) {
            string2 = "%SRCROOT%";
        }
        if ((n & 8) != 0) {
            string3 = "src_root";
        }
        if ((n & 0x10) != 0) {
            outputType = OutputType.SarifPackSrc;
        }
        this(iResDirectory, string, string2, string3, outputType);
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public Object init(@NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof init.1)) ** GOTO lbl-1000
        var3_2 = $completion;
        if ((var3_2.label & -2147483648) != 0) {
            var3_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var4_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = this;
                $continuation.label = 1;
                v0 = super.init((Continuation)$continuation);
                if (v0 == var4_4) {
                    return var4_4;
                }
                ** GOTO lbl22
            }
            case 1: {
                this = (SarifDiagnosticsPack)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                if ((v1 = (this.sourceJarPath = this.getOutputDir().resolve(this.sourceJarFileName + ".jar").toFile())) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"sourceJarPath");
                    v1 = null;
                }
                Files.deleteIfExists(v1.getPath());
                v2 = this.sourceJarPath;
                if (v2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"sourceJarPath");
                    v2 = null;
                }
                this.sourceJar = new JarMerger(v2.getPath(), null, 2, null);
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public final Map<String, UriBase> getOriginalUriBaseIds() {
        return this.originalUriBaseIds;
    }

    @NotNull
    public final ConcurrentHashMap<String, IResFile> getEntriesMap() {
        return this.entriesMap;
    }

    @NotNull
    public SarifDiagnostics.SarifDiagnosticsImpl getSarifDiagnosticsImpl(@NotNull ReportConsumer.MetaData metadata, @NotNull IProjectFileLocator locator2) {
        Intrinsics.checkNotNullParameter((Object)metadata, (String)"metadata");
        Intrinsics.checkNotNullParameter((Object)locator2, (String)"locator");
        return (SarifDiagnostics.SarifDiagnosticsImpl)new SarifDiagnosticsPackImpl(this, metadata, locator2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    @Override
    public void close() {
        JarMerger jarMerger;
        void $this$bracket_u24default$iv;
        Ref.IntRef errorCnt = new Ref.IntRef();
        LoggerWithLogMethod loggerWithLogMethod = LoggingKt.info((KLogger)logger);
        String msg$iv = this.getType() + ": Compressing ...";
        boolean $i$f$bracket = false;
        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
        LocalDateTime startTime$iv = LocalDateTime.now();
        boolean alreadyLogged$iv = false;
        Ref.ObjectRef res$iv = new Ref.ObjectRef();
        res$iv.element = Maybe.Companion.empty();
        try {
            Ref.ObjectRef objectRef = res$iv;
            boolean bl = false;
            Map $this$forEach$iv = this.entriesMap;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry element$iv;
                Map.Entry entry = element$iv = iterator2.next();
                boolean bl2 = false;
                String entry2 = (String)entry.getKey();
                IResFile file = (IResFile)entry.getValue();
                try {
                    JarMerger jarMerger2 = this.sourceJar;
                    if (jarMerger2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException((String)"sourceJar");
                        jarMerger2 = null;
                    }
                    jarMerger2.addFile(entry2, file.getPath());
                }
                catch (Exception e) {
                    int n = errorCnt.element;
                    errorCnt.element = n + 1;
                    if (errorCnt.element >= 5) continue;
                    logger.warn((Throwable)e, SarifDiagnosticsPack::close$lambda$2$lambda$1$lambda$0);
                }
            }
            Unit unit = Unit.INSTANCE;
            objectRef.element = new Maybe((Object)unit);
            Object object = ((Maybe)res$iv.element).getOrThrow();
        }
        catch (Throwable t$iv) {
            try {
                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                alreadyLogged$iv = true;
                throw t$iv;
            }
            catch (Throwable throwable) {
                if (!alreadyLogged$iv) {
                    if (((Maybe)res$iv.element).getHasValue()) {
                        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                    } else {
                        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                    }
                }
                throw throwable;
            }
        }
        if (((Maybe)res$iv.element).getHasValue()) {
            $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
        }
        if (errorCnt.element > 0) {
            logger.warn(() -> SarifDiagnosticsPack.close$lambda$3(this, errorCnt));
        }
        if ((jarMerger = this.sourceJar) == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"sourceJar");
            jarMerger = null;
        }
        jarMerger.close();
    }

    private static final Object close$lambda$2$lambda$1$lambda$0() {
        return "An error occurred";
    }

    private static final Object close$lambda$3(SarifDiagnosticsPack this$0, Ref.IntRef $errorCnt) {
        return this$0.getType() + ": A total of " + $errorCnt.element + " errors were generated";
    }

    private static final Unit logger$lambda$4() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ String access$getSourceJarRootMapKey$p(SarifDiagnosticsPack $this) {
        return $this.sourceJarRootMapKey;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }
}

