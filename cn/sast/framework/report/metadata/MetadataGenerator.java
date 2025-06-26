/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.common.OS
 *  cn.sast.common.Resource
 *  cn.sast.coroutines.MultiWorkerQueue
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.metadata.AnalysisMetadata
 *  cn.sast.framework.report.metadata.Analyzer
 *  cn.sast.framework.report.metadata.AnalyzerStatistics
 *  cn.sast.framework.report.metadata.Counter
 *  cn.sast.framework.report.metadata.MetadataGenerator
 *  cn.sast.framework.report.metadata.MetadataGenerator$Companion
 *  cn.sast.framework.report.metadata.MetadataGenerator$getMetadata$1
 *  cn.sast.framework.report.metadata.Tool
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jacoco.core.analysis.ICounter
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Scene
 *  soot.SootClass
 *  soot.jimple.infoflow.collect.ConcurrentHashSet
 */
package cn.sast.framework.report.metadata;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.OS;
import cn.sast.common.Resource;
import cn.sast.coroutines.MultiWorkerQueue;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.metadata.AnalysisMetadata;
import cn.sast.framework.report.metadata.Analyzer;
import cn.sast.framework.report.metadata.AnalyzerStatistics;
import cn.sast.framework.report.metadata.Counter;
import cn.sast.framework.report.metadata.MetadataGenerator;
import cn.sast.framework.report.metadata.Tool;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import mu.KLogger;
import mu.KotlinLogging;
import org.jacoco.core.analysis.ICounter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootClass;
import soot.jimple.infoflow.collect.ConcurrentHashSet;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!BY\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0018J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2={"Lcn/sast/framework/report/metadata/MetadataGenerator;", "", "projectRoot", "", "multipleProjectRoot", "", "outputPath", "Lcn/sast/common/IResDirectory;", "sourcePaths", "coveredCounter", "Lorg/jacoco/core/analysis/ICounter;", "successfulFiles", "", "Lcn/sast/common/IResFile;", "failedFiles", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcn/sast/common/IResDirectory;Ljava/util/List;Lorg/jacoco/core/analysis/ICounter;Ljava/util/Set;Ljava/util/Set;)V", "resultSourceFiles", "", "updateResultSourceMapping", "", "result", "source", "getMetadata", "Lcn/sast/framework/report/metadata/AnalysisMetadata;", "locator", "Lcn/sast/framework/report/IProjectFileLocator;", "(Lcn/sast/framework/report/IProjectFileLocator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateFailedMetaData", "generateMetaData", "fileCount", "", "lineCount", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nMetadataGenerator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MetadataGenerator.kt\ncn/sast/framework/report/metadata/MetadataGenerator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,104:1\n1557#2:105\n1628#2,3:106\n1557#2:109\n1628#2,3:110\n1#3:113\n*S KotlinDebug\n*F\n+ 1 MetadataGenerator.kt\ncn/sast/framework/report/metadata/MetadataGenerator\n*L\n80#1:105\n80#1:106,3\n82#1:109\n82#1:110,3\n*E\n"})
public final class MetadataGenerator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final String projectRoot;
    @NotNull
    private final List<String> multipleProjectRoot;
    @NotNull
    private final IResDirectory outputPath;
    @NotNull
    private final List<String> sourcePaths;
    @NotNull
    private final ICounter coveredCounter;
    @NotNull
    private final Set<IResFile> successfulFiles;
    @NotNull
    private final Set<IResFile> failedFiles;
    @NotNull
    private Map<String, String> resultSourceFiles;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(MetadataGenerator::logger$lambda$4);

    public MetadataGenerator(@Nullable String projectRoot, @NotNull List<String> multipleProjectRoot, @NotNull IResDirectory outputPath, @NotNull List<String> sourcePaths, @NotNull ICounter coveredCounter, @NotNull Set<? extends IResFile> successfulFiles, @NotNull Set<? extends IResFile> failedFiles) {
        Intrinsics.checkNotNullParameter(multipleProjectRoot, (String)"multipleProjectRoot");
        Intrinsics.checkNotNullParameter((Object)outputPath, (String)"outputPath");
        Intrinsics.checkNotNullParameter(sourcePaths, (String)"sourcePaths");
        Intrinsics.checkNotNullParameter((Object)coveredCounter, (String)"coveredCounter");
        Intrinsics.checkNotNullParameter(successfulFiles, (String)"successfulFiles");
        Intrinsics.checkNotNullParameter(failedFiles, (String)"failedFiles");
        this.projectRoot = projectRoot;
        this.multipleProjectRoot = multipleProjectRoot;
        this.outputPath = outputPath;
        this.sourcePaths = sourcePaths;
        this.coveredCounter = coveredCounter;
        this.successfulFiles = successfulFiles;
        this.failedFiles = failedFiles;
        this.resultSourceFiles = new LinkedHashMap();
    }

    public final void updateResultSourceMapping(@NotNull String result, @NotNull String source) {
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        this.resultSourceFiles.put(((Object)this.outputPath.resolve(result).getAbsolute().getNormalize().getPath()).toString(), source);
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object getMetadata(@NotNull IProjectFileLocator var1_1, @NotNull Continuation<? super AnalysisMetadata> $completion) {
        if (!($completion instanceof getMetadata.1)) ** GOTO lbl-1000
        var10_3 = $completion;
        if ((var10_3.label & -2147483648) != 0) {
            var10_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var11_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                fileCount = new AtomicInteger(0);
                lineCount = new AtomicInteger(0);
                visited = new ConcurrentHashSet();
                task = new MultiWorkerQueue("Metadata", OS.INSTANCE.getMaxThreadNum(), (Function2)new /* Unavailable Anonymous Inner Class!! */);
                v0 = Scene.v().getApplicationClasses().iterator();
                Intrinsics.checkNotNullExpressionValue((Object)v0, (String)"iterator(...)");
                var7_10 = v0;
                while (var7_10.hasNext()) {
                    appClass = (SootClass)var7_10.next();
                    if (Scene.v().isExcluded(appClass)) continue;
                    Intrinsics.checkNotNull((Object)appClass);
                    task.dispatch((Object)appClass);
                }
                $continuation.L$0 = this;
                $continuation.L$1 = fileCount;
                $continuation.L$2 = lineCount;
                $continuation.L$3 = task;
                $continuation.label = 1;
                v1 = task.join((Continuation)$continuation);
                if (v1 == var11_5) {
                    return var11_5;
                }
                ** GOTO lbl41
            }
            case 1: {
                task = (MultiWorkerQueue)$continuation.L$3;
                lineCount = (AtomicInteger)$continuation.L$2;
                fileCount = (AtomicInteger)$continuation.L$1;
                this = (MetadataGenerator)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl41:
                // 2 sources

                task.close();
                MetadataGenerator.logger.info((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, getMetadata$lambda$0(), ()Ljava/lang/Object;)());
                return this.generateMetaData(fileCount.get(), lineCount.get());
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public final AnalysisMetadata generateFailedMetaData() {
        return this.generateMetaData(0, 0);
    }

    /*
     * WARNING - void declaration
     */
    private final AnalysisMetadata generateMetaData(int fileCount, int lineCount) {
        Collection<String> collection;
        IResFile it;
        Collection<String> collection2;
        Iterable $this$mapTo$iv$iv;
        Iterable $this$map$iv;
        Counter counter = new Counter(this.coveredCounter.getMissedCount(), this.coveredCounter.getCoveredCount());
        List list = CollectionsKt.sorted((Iterable)this.sourcePaths);
        String string = System.getProperty("os.name");
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getProperty(...)");
        String string2 = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
        Iterable iterable = this.failedFiles;
        int n = this.failedFiles.size();
        Object object = "corax";
        String string3 = string2;
        List list2 = list;
        int n2 = 1;
        Counter counter2 = counter;
        int n3 = lineCount;
        int n4 = fileCount;
        boolean $i$f$map = false;
        void var5_13 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            IResFile iResFile = (IResFile)item$iv$iv;
            collection2 = destination$iv$iv;
            boolean bl = false;
            collection2.add(Resource.INSTANCE.getOriginFileFromExpandPath((IResource)it).getPathString());
        }
        collection2 = (List)destination$iv$iv;
        $this$map$iv = this.successfulFiles;
        int n5 = this.successfulFiles.size();
        collection2 = CollectionsKt.sorted((Iterable)collection2);
        $i$f$map = false;
        $this$mapTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            it = (IResFile)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(Resource.INSTANCE.getOriginFileFromExpandPath((IResource)it).getPathString());
        }
        collection = (List)destination$iv$iv;
        int n6 = n4;
        int n7 = n3;
        Counter counter3 = counter2;
        int n8 = n2;
        List list3 = list2;
        String string4 = string3;
        String string5 = "";
        List list4 = CollectionsKt.sorted((Iterable)collection);
        int n9 = n5;
        Collection<String> collection3 = collection2;
        int n10 = n;
        Map map = MapsKt.emptyMap();
        AnalyzerStatistics analyzerStatistics = new AnalyzerStatistics(n10, collection3, n9, list4, string5);
        Object object2 = MapsKt.mapOf((Pair)TuplesKt.to((Object)object, (Object)new Analyzer(analyzerStatistics, map)));
        List list5 = OS.getCommandLine$default((OS)OS.INSTANCE, null, (boolean)false, (int)3, null);
        if (list5 == null) {
            List list6;
            String string6 = System.getProperty("java.home");
            if (string6 != null) {
                void it2;
                String $i$f$mapTo2 = string6;
                object = object2;
                string3 = string4;
                list2 = list3;
                n2 = n8;
                counter2 = counter3;
                n3 = n7;
                n4 = n6;
                boolean bl = false;
                List list7 = CollectionsKt.listOf((Object)it2);
                n6 = n4;
                n7 = n3;
                counter3 = counter2;
                n8 = n2;
                list3 = list2;
                string4 = string3;
                object2 = object;
                list6 = list7;
            } else {
                list6 = list5 = null;
            }
            if (list6 == null) {
                list5 = CollectionsKt.emptyList();
            }
        }
        String string7 = ((Object)this.outputPath.getAbsolute().getNormalize().getPath()).toString();
        String string8 = this.projectRoot;
        if (string8 == null) {
            string8 = "";
        }
        Map map2 = MapsKt.toSortedMap((Map)this.resultSourceFiles);
        String string9 = System.getProperty("user.dir");
        Intrinsics.checkNotNullExpressionValue((Object)string9, (String)"getProperty(...)");
        String string10 = string9;
        Map map3 = map2;
        List list8 = this.multipleProjectRoot;
        String string11 = string8;
        String string12 = string7;
        String string13 = "corax";
        List list9 = list5;
        Object object3 = object2;
        List list10 = CollectionsKt.listOf((Object)new Tool((Map)object3, list9, string13, string12, string11, list8, map3, string10));
        String string14 = string4;
        List list11 = list3;
        int n11 = n8;
        Counter counter4 = counter3;
        int n12 = n7;
        int n13 = n6;
        return new AnalysisMetadata(n13, n12, counter4, n11, list11, string14, list10);
    }

    private static final Object getMetadata$lambda$0() {
        return "Metadata: Java executable file path: " + OS.INSTANCE.getJavaExecutableFilePath();
    }

    private static final Unit logger$lambda$4() {
        return Unit.INSTANCE;
    }
}

