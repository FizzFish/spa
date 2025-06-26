/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.ReportConsumer$MetaData
 *  cn.sast.framework.report.SarifDiagnostics
 *  cn.sast.framework.report.SarifDiagnostics$SarifDiagnosticsImpl
 *  cn.sast.framework.report.SarifDiagnosticsCopySrc
 *  cn.sast.framework.report.SarifDiagnosticsCopySrc$Companion
 *  cn.sast.framework.report.SarifDiagnosticsCopySrc$SarifDiagnosticsPackImpl
 *  cn.sast.framework.report.sarif.Description
 *  cn.sast.framework.report.sarif.UriBase
 *  cn.sast.framework.result.OutputType
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.utbot.common.LoggerWithLogMethod
 *  org.utbot.common.LoggingKt
 *  org.utbot.common.Maybe
 */
package cn.sast.framework.report;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.ReportConsumer;
import cn.sast.framework.report.SarifDiagnostics;
import cn.sast.framework.report.SarifDiagnosticsCopySrc;
import cn.sast.framework.report.sarif.Description;
import cn.sast.framework.report.sarif.UriBase;
import cn.sast.framework.result.OutputType;
import java.io.Closeable;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.utbot.common.LoggerWithLogMethod;
import org.utbot.common.LoggingKt;
import org.utbot.common.Maybe;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0002 !B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0018\u001a\u00060\u0019R\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\""}, d2={"Lcn/sast/framework/report/SarifDiagnosticsCopySrc;", "Lcn/sast/framework/report/SarifDiagnostics;", "Ljava/io/Closeable;", "outputDir", "Lcn/sast/common/IResDirectory;", "sourceJarRootMapKey", "", "sourceJarRootMapValue", "sourceJarFileName", "type", "Lcn/sast/framework/result/OutputType;", "<init>", "(Lcn/sast/common/IResDirectory;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcn/sast/framework/result/OutputType;)V", "sourceRoot", "originalUriBaseIds", "", "Lcn/sast/framework/report/sarif/UriBase;", "getOriginalUriBaseIds", "()Ljava/util/Map;", "entriesMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcn/sast/common/IResFile;", "getEntriesMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "getSarifDiagnosticsImpl", "Lcn/sast/framework/report/SarifDiagnostics$SarifDiagnosticsImpl;", "metadata", "Lcn/sast/framework/report/ReportConsumer$MetaData;", "locator", "Lcn/sast/framework/report/IProjectFileLocator;", "close", "", "SarifDiagnosticsPackImpl", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nSarifDiagnosticsCopySrc.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SarifDiagnosticsCopySrc.kt\ncn/sast/framework/report/SarifDiagnosticsCopySrc\n+ 2 Logging.kt\norg/utbot/common/LoggingKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,85:1\n49#2,13:86\n62#2,11:101\n216#3,2:99\n*S KotlinDebug\n*F\n+ 1 SarifDiagnosticsCopySrc.kt\ncn/sast/framework/report/SarifDiagnosticsCopySrc\n*L\n62#1:86,13\n62#1:101,11\n63#1:99,2\n*E\n"})
public final class SarifDiagnosticsCopySrc
extends SarifDiagnostics
implements Closeable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String sourceJarRootMapKey;
    @NotNull
    private final String sourceJarFileName;
    @NotNull
    private final IResDirectory sourceRoot;
    @NotNull
    private final Map<String, UriBase> originalUriBaseIds;
    @NotNull
    private final ConcurrentHashMap<String, IResFile> entriesMap;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(SarifDiagnosticsCopySrc::logger$lambda$4);

    public SarifDiagnosticsCopySrc(@NotNull IResDirectory outputDir, @NotNull String sourceJarRootMapKey, @NotNull String sourceJarRootMapValue, @NotNull String sourceJarFileName, @NotNull OutputType type) {
        Intrinsics.checkNotNullParameter((Object)outputDir, (String)"outputDir");
        Intrinsics.checkNotNullParameter((Object)sourceJarRootMapKey, (String)"sourceJarRootMapKey");
        Intrinsics.checkNotNullParameter((Object)sourceJarRootMapValue, (String)"sourceJarRootMapValue");
        Intrinsics.checkNotNullParameter((Object)sourceJarFileName, (String)"sourceJarFileName");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        super(outputDir, type);
        this.sourceJarRootMapKey = sourceJarRootMapKey;
        this.sourceJarFileName = sourceJarFileName;
        this.sourceRoot = outputDir.resolve(this.sourceJarFileName).toDirectory();
        this.originalUriBaseIds = MapsKt.mapOf((Pair)TuplesKt.to((Object)this.sourceJarRootMapKey, (Object)new UriBase(sourceJarRootMapValue, new Description("The path " + sourceJarRootMapValue + " should be replaced with path where be mapped to the virtual path " + this.sourceRoot.getPath().toUri()))));
        this.entriesMap = new ConcurrentHashMap();
    }

    public /* synthetic */ SarifDiagnosticsCopySrc(IResDirectory iResDirectory, String string, String string2, String string3, OutputType outputType, int n, DefaultConstructorMarker defaultConstructorMarker) {
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
            outputType = OutputType.SarifCopySrc;
        }
        this(iResDirectory, string, string2, string3, outputType);
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
        void $this$bracket_u24default$iv;
        Ref.IntRef errorCnt = new Ref.IntRef();
        LoggerWithLogMethod loggerWithLogMethod = LoggingKt.info((KLogger)logger);
        String msg$iv = this.getType() + ": copying ...";
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
                Object object;
                Map.Entry element$iv;
                Map.Entry entry = element$iv = iterator2.next();
                boolean bl2 = false;
                String entry2 = (String)entry.getKey();
                IResFile file = (IResFile)entry.getValue();
                Path target = this.sourceRoot.resolve(entry2).getPath();
                try {
                    Path parent;
                    if (target.getParent() == null) {
                        throw new IllegalStateException(("output not allow here: " + target).toString());
                    }
                    LinkOption[] linkOptionArray = new LinkOption[]{};
                    if (!Files.exists(parent, Arrays.copyOf(linkOptionArray, linkOptionArray.length))) {
                        Files.createDirectories(parent, new FileAttribute[0]);
                    }
                    object = Files.copy(file.getPath(), target, new CopyOption[0]);
                }
                catch (Exception e) {
                    int n = errorCnt.element;
                    errorCnt.element = n + 1;
                    if (errorCnt.element < 5) {
                        logger.warn((Throwable)e, SarifDiagnosticsCopySrc::close$lambda$2$lambda$1$lambda$0);
                    }
                    object = Unit.INSTANCE;
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
            logger.warn(() -> SarifDiagnosticsCopySrc.close$lambda$3(this, errorCnt));
        }
    }

    private static final Object close$lambda$2$lambda$1$lambda$0() {
        return "An error occurred";
    }

    private static final Object close$lambda$3(SarifDiagnosticsCopySrc this$0, Ref.IntRef $errorCnt) {
        return this$0.getType() + ": A total of " + $errorCnt.element + " errors were generated";
    }

    private static final Unit logger$lambda$4() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ String access$getSourceJarRootMapKey$p(SarifDiagnosticsCopySrc $this) {
        return $this.sourceJarRootMapKey;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }
}

