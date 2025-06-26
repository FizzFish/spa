/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.ScanFilter
 *  cn.sast.api.report.ClassResInfo
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.api.report.Report
 *  cn.sast.api.util.IMonitor
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.common.ResourceKt
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.IReportConsumer
 *  cn.sast.framework.report.IWrapperFileGenerator
 *  cn.sast.framework.report.NullWrapperFileGenerator
 *  cn.sast.framework.report.ReportConverter
 *  cn.sast.framework.report.ReportConverter$Companion
 *  cn.sast.framework.report.ReportConverter$findAllSourceFiles$1
 *  cn.sast.framework.report.coverage.JacocoCompoundCoverage
 *  cn.sast.idfa.progressbar.ProgressBarExt
 *  com.feysh.corax.config.api.rules.ProcessRule$ScanAction
 *  com.github.ajalt.mordant.rendering.Theme
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.CoroutineScopeKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Scene
 *  soot.SootClass
 *  soot.util.Chain
 */
package cn.sast.framework.report;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.ScanFilter;
import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.api.report.Report;
import cn.sast.api.util.IMonitor;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.ResourceKt;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.IReportConsumer;
import cn.sast.framework.report.IWrapperFileGenerator;
import cn.sast.framework.report.NullWrapperFileGenerator;
import cn.sast.framework.report.ReportConverter;
import cn.sast.framework.report.coverage.JacocoCompoundCoverage;
import cn.sast.idfa.progressbar.ProgressBarExt;
import com.feysh.corax.config.api.rules.ProcessRule;
import com.github.ajalt.mordant.rendering.Theme;
import java.io.Closeable;
import java.io.OutputStreamWriter;
import java.lang.invoke.LambdaMetafactory;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootClass;
import soot.util.Chain;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000eH\u0002J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@\u00a2\u0006\u0002\u0010\u0012J>\u0010\u0013\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u0002JJ\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2={"Lcn/sast/framework/report/ReportConverter;", "", "mainConfig", "Lcn/sast/api/config/MainConfig;", "progressBarExt", "Lcn/sast/idfa/progressbar/ProgressBarExt;", "<init>", "(Lcn/sast/api/config/MainConfig;Lcn/sast/idfa/progressbar/ProgressBarExt;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "filterSourceFiles", "", "Lcn/sast/common/IResFile;", "sources", "", "findAllSourceFiles", "locator", "Lcn/sast/framework/report/IProjectFileLocator;", "(Lcn/sast/framework/report/IProjectFileLocator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportSourceFileWhichClassNotFound", "Lkotlin/Pair;", "", "allSourceFiles", "outputDir", "Lcn/sast/common/IResDirectory;", "flush", "", "coverage", "Lcn/sast/framework/report/coverage/JacocoCompoundCoverage;", "consumers", "", "Lcn/sast/framework/report/IReportConsumer;", "reports", "Lcn/sast/api/report/Report;", "(Lcn/sast/api/config/MainConfig;Lcn/sast/framework/report/IProjectFileLocator;Lcn/sast/framework/report/coverage/JacocoCompoundCoverage;Ljava/util/List;Ljava/util/Collection;Lcn/sast/common/IResDirectory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nReportConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReportConverter.kt\ncn/sast/framework/report/ReportConverter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,391:1\n774#2:392\n865#2,2:393\n774#2:395\n865#2,2:396\n1279#2,2:398\n1293#2,4:400\n1053#2:404\n*S KotlinDebug\n*F\n+ 1 ReportConverter.kt\ncn/sast/framework/report/ReportConverter\n*L\n53#1:392\n53#1:393,2\n83#1:395\n83#1:396,2\n84#1:398,2\n84#1:400,4\n96#1:404\n*E\n"})
public final class ReportConverter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final ProgressBarExt progressBarExt;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(ReportConverter::logger$lambda$7);

    public ReportConverter(@NotNull MainConfig mainConfig, @NotNull ProgressBarExt progressBarExt) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        Intrinsics.checkNotNullParameter((Object)progressBarExt, (String)"progressBarExt");
        this.mainConfig = mainConfig;
        this.progressBarExt = progressBarExt;
    }

    public /* synthetic */ ReportConverter(MainConfig mainConfig, ProgressBarExt progressBarExt, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            progressBarExt = new ProgressBarExt(0, 0, 3, null);
        }
        this(mainConfig, progressBarExt);
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    /*
     * WARNING - void declaration
     */
    private final Set<IResFile> filterSourceFiles(Collection<? extends IResFile> sources) {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = sources;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            IResFile it = (IResFile)element$iv$iv;
            boolean bl = false;
            if (!(it == null ? false : (Intrinsics.areEqual((Object)it.getExtension(), (Object)"kts") && StringsKt.contains((CharSequence)it.getName(), (CharSequence)"gradle", (boolean)true) ? false : (StringsKt.contains((CharSequence)it.getName(), (CharSequence)"package-info", (boolean)true) ? false : ScanFilter.getActionOf$default((ScanFilter)this.mainConfig.getScanFilter(), null, (Path)it.getPath(), null, (int)4, null) != ProcessRule.ScanAction.Skip)))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (Set)CollectionsKt.filterNotNullTo((Iterable)((List)destination$iv$iv), (Collection)new LinkedHashSet());
    }

    /*
     * Unable to fully structure code
     */
    private final Object findAllSourceFiles(IProjectFileLocator var1_1, Continuation<? super Set<? extends IResFile>> $completion) {
        if (!($completion instanceof findAllSourceFiles.1)) ** GOTO lbl-1000
        var8_3 = $completion;
        if ((var8_3.label & -2147483648) != 0) {
            var8_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var9_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                allSourceFiles = new LinkedHashSet<E>();
                var4_7 = ResourceKt.getJavaExtensions().iterator();
lbl14:
                // 2 sources

                while (var4_7.hasNext()) {
                    javaExtension = (String)var4_7.next();
                    var6_9 = allSourceFiles;
                    $continuation.L$0 = this;
                    $continuation.L$1 = locator;
                    $continuation.L$2 = allSourceFiles;
                    $continuation.L$3 = var4_7;
                    $continuation.L$4 = var6_9;
                    $continuation.label = 1;
                    v0 = locator.getByFileExtension(javaExtension, (Continuation)$continuation);
                    if (v0 == var9_5) {
                        return var9_5;
                    }
                    ** GOTO lbl36
                }
                break;
            }
            case 1: {
                var6_9 = (Collection)$continuation.L$4;
                var4_7 = (Iterator<E>)$continuation.L$3;
                allSourceFiles = (Set)$continuation.L$2;
                locator = (IProjectFileLocator)$continuation.L$1;
                this = (ReportConverter)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl36:
                // 2 sources

                CollectionsKt.addAll((Collection)var6_9, (Sequence)SequencesKt.filter((Sequence)((Sequence)v0), (Function1)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, findAllSourceFiles$lambda$1(cn.sast.framework.report.ReportConverter cn.sast.common.IResFile ), (Lcn/sast/common/IResFile;)Ljava/lang/Boolean;)((ReportConverter)this)));
                ** GOTO lbl14
            }
        }
        return allSourceFiles;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    private final Pair<Set<IResFile>, Set<IResFile>> reportSourceFileWhichClassNotFound(Set<? extends IResFile> allSourceFiles, IResDirectory outputDir, IProjectFileLocator locator2) {
        void $this$filterTo$iv$iv;
        IMonitor iMonitor = this.mainConfig.getMonitor();
        if (iMonitor != null && (iMonitor = iMonitor.getProjectMetrics()) != null) {
            iMonitor.setTotalSourceFileNum((long)allSourceFiles.size());
        }
        Chain chain = Scene.v().getApplicationClasses();
        Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getApplicationClasses(...)");
        Collection collection = (Collection)chain;
        Chain chain2 = Scene.v().getLibraryClasses();
        Intrinsics.checkNotNullExpressionValue((Object)chain2, (String)"getLibraryClasses(...)");
        Iterable $this$filter$iv = CollectionsKt.plus((Collection)collection, (Iterable)((Iterable)chain2));
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            SootClass it = (SootClass)element$iv$iv;
            boolean bl = false;
            if (!(!it.isPhantom())) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List allNonPhantomClasses = (List)destination$iv$iv;
        Iterable $this$associateWith$iv = allNonPhantomClasses;
        boolean $i$f$associateWith = false;
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv, (int)10)), (int)16));
        Iterable $this$associateWithTo$iv$iv = $this$associateWith$iv;
        boolean $i$f$associateWithTo = false;
        for (Object element$iv$iv : $this$associateWithTo$iv$iv) {
            void it;
            SootClass bl = (SootClass)element$iv$iv;
            Object e = element$iv$iv;
            Map map = result$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull((Object)it);
            IResFile iResFile = locator2.get((IBugResInfo)new ClassResInfo((SootClass)it), (IWrapperFileGenerator)NullWrapperFileGenerator.INSTANCE);
            map.put(e, iResFile);
        }
        Map foundSourceCodes = result$iv;
        Set classFoundSourceFiles = (Set)CollectionsKt.filterNotNullTo((Iterable)foundSourceCodes.values(), (Collection)new LinkedHashSet());
        Set classNotFoundSourceFile = SetsKt.minus(allSourceFiles, (Iterable)classFoundSourceFiles);
        IResFile nfd = outputDir.resolve("source_files_which_class_not_found.txt").toFile();
        if (!((Collection)classNotFoundSourceFile).isEmpty()) {
            Object element$iv$iv;
            logger.warn(() -> ReportConverter.reportSourceFileWhichClassNotFound$lambda$4(classNotFoundSourceFile, nfd));
            nfd.mkdirs();
            Object object = nfd.getPath();
            element$iv$iv = new OpenOption[]{};
            Object object2 = Charsets.UTF_8;
            object = new OutputStreamWriter(Files.newOutputStream((Path)object, (OpenOption[])Arrays.copyOf(element$iv$iv, ((Object)element$iv$iv).length)), (Charset)object2);
            object2 = null;
            try {
                OutputStreamWriter writer = (OutputStreamWriter)object;
                boolean bl = false;
                Iterable $this$sortedBy$iv = classNotFoundSourceFile;
                boolean $i$f$sortedBy = false;
                for (IResFile file : CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */))) {
                    writer.write(file + "\n");
                }
                writer.flush();
                Unit unit = Unit.INSTANCE;
            }
            catch (Throwable throwable) {
                object2 = throwable;
                throw throwable;
            }
            finally {
                CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
            }
        } else {
            Files.deleteIfExists(nfd.getPath());
        }
        return TuplesKt.to((Object)classFoundSourceFiles, (Object)classNotFoundSourceFile);
    }

    @Nullable
    public final Object flush(@NotNull MainConfig mainConfig, @NotNull IProjectFileLocator locator2, @NotNull JacocoCompoundCoverage coverage, @NotNull List<? extends IReportConsumer> consumers, @NotNull Collection<Report> reports, @NotNull IResDirectory outputDir, @NotNull Continuation<? super Unit> $completion) {
        Object object = CoroutineScopeKt.coroutineScope((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private static final boolean findAllSourceFiles$lambda$1(ReportConverter this$0, IResFile it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return this$0.mainConfig.getAutoAppSrcInZipScheme() || it.isFileScheme();
    }

    private static final Object reportSourceFileWhichClassNotFound$lambda$4(Set $classNotFoundSourceFile, IResFile $nfd) {
        return Theme.Companion.getDefault().getWarning().invoke("Incomplete analysis! The num of " + $classNotFoundSourceFile.size() + " source files not found any class!!! check: " + $nfd.getAbsolute().getNormalize());
    }

    private static final Unit logger$lambda$7() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$findAllSourceFiles(ReportConverter $this, IProjectFileLocator locator2, Continuation $completion) {
        return $this.findAllSourceFiles(locator2, $completion);
    }

    public static final /* synthetic */ Set access$filterSourceFiles(ReportConverter $this, Collection sources) {
        return $this.filterSourceFiles(sources);
    }

    public static final /* synthetic */ Pair access$reportSourceFileWhichClassNotFound(ReportConverter $this, Set allSourceFiles, IResDirectory outputDir, IProjectFileLocator locator2) {
        return $this.reportSourceFileWhichClassNotFound(allSourceFiles, outputDir, locator2);
    }

    public static final /* synthetic */ ProgressBarExt access$getProgressBarExt$p(ReportConverter $this) {
        return $this.progressBarExt;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }
}

