/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.ClassResInfo
 *  cn.sast.api.report.FileResInfo
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.api.util.IMonitor
 *  cn.sast.common.FileSystemLocator$TraverseMode
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.common.ResourceKt
 *  cn.sast.framework.report.AbstractFileIndexer
 *  cn.sast.framework.report.AbstractFileIndexer$CompareMode
 *  cn.sast.framework.report.FileIndexer
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.IWrapperFileGenerator
 *  cn.sast.framework.report.ProjectFileLocator
 *  cn.sast.framework.report.ProjectFileLocator$Companion
 *  cn.sast.framework.report.ProjectFileLocator$getAllFiles$1
 *  cn.sast.framework.report.ProjectFileLocator$getByFileExtension$1
 *  cn.sast.framework.report.ProjectFileLocator$getByFileName$1
 *  com.github.benmanes.caffeine.cache.CacheLoader
 *  com.github.benmanes.caffeine.cache.Caffeine
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.Deferred
 *  kotlinx.coroutines.GlobalScope
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report;

import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.FileResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.api.util.IMonitor;
import cn.sast.common.FileSystemLocator;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.ResourceKt;
import cn.sast.framework.report.AbstractFileIndexer;
import cn.sast.framework.report.FileIndexer;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.IWrapperFileGenerator;
import cn.sast.framework.report.ProjectFileLocator;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import java.lang.invoke.LambdaMetafactory;
import java.util.Collection;
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
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.GlobalScope;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 :2\u00020\u0001:\u0001:B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0016\u001a\u00020\u0015H\u0082@\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u001a\u0010&\u001a\u0004\u0018\u00010\u001d2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u001a\u00100\u001a\u0004\u0018\u00010\u001d2\u0006\u0010'\u001a\u0002012\u0006\u0010)\u001a\u00020*H\u0002J\u001a\u00100\u001a\u0004\u0018\u00010\u001d2\u0006\u0010'\u001a\u0002022\u0006\u0010)\u001a\u00020*H\u0002J\u001a\u00100\u001a\u0004\u0018\u00010\u001d2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u00104\u001a\u00020 H\u0096@\u00a2\u0006\u0002\u00105J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u00107\u001a\u00020 H\u0096@\u00a2\u0006\u0002\u00105J\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0096@\u00a2\u0006\u0002\u0010\u0017J\b\u00109\u001a\u00020 H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u0010+\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020*0-\u0012\u0006\u0012\u0004\u0018\u00010\u001d0,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010.\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020*0-\u0012\u0006\u0012\u0004\u0018\u00010\u001d0/X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2={"Lcn/sast/framework/report/ProjectFileLocator;", "Lcn/sast/framework/report/IProjectFileLocator;", "monitor", "Lcn/sast/api/util/IMonitor;", "sourceDir", "", "Lcn/sast/common/IResource;", "fileWrapperOutPutDir", "Lcn/sast/common/IResDirectory;", "traverseMode", "Lcn/sast/common/FileSystemLocator$TraverseMode;", "enableInfo", "", "<init>", "(Lcn/sast/api/util/IMonitor;Ljava/util/Set;Lcn/sast/common/IResDirectory;Lcn/sast/common/FileSystemLocator$TraverseMode;Z)V", "getSourceDir", "()Ljava/util/Set;", "setSourceDir", "(Ljava/util/Set;)V", "updateJob", "Lkotlinx/coroutines/Deferred;", "Lcn/sast/framework/report/FileIndexer;", "indexer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "indexerBlock", "update", "", "findFromFileIndexMap", "Lkotlin/sequences/Sequence;", "Lcn/sast/common/IResFile;", "parentSubPath", "", "", "mode", "Lcn/sast/framework/report/AbstractFileIndexer$CompareMode;", "totalFiles", "", "totalJavaSrcFiles", "makeWrapperFile", "resInfo", "Lcn/sast/api/report/IBugResInfo;", "fileWrapperIfNotEExists", "Lcn/sast/framework/report/IWrapperFileGenerator;", "loader", "Lcom/github/benmanes/caffeine/cache/CacheLoader;", "Lkotlin/Pair;", "cache", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "get", "Lcn/sast/api/report/ClassResInfo;", "Lcn/sast/api/report/FileResInfo;", "getByFileExtension", "extension", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByFileName", "filename", "getAllFiles", "toString", "Companion", "corax-framework"})
public class ProjectFileLocator
implements IProjectFileLocator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final IMonitor monitor;
    @NotNull
    private Set<? extends IResource> sourceDir;
    @Nullable
    private final IResDirectory fileWrapperOutPutDir;
    @NotNull
    private FileSystemLocator.TraverseMode traverseMode;
    private final boolean enableInfo;
    @Nullable
    private Deferred<FileIndexer> updateJob;
    @NotNull
    private final CacheLoader<Pair<IBugResInfo, IWrapperFileGenerator>, IResFile> loader;
    @NotNull
    private final LoadingCache<Pair<IBugResInfo, IWrapperFileGenerator>, IResFile> cache;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(ProjectFileLocator::logger$lambda$2);

    /*
     * WARNING - void declaration
     */
    public ProjectFileLocator(@Nullable IMonitor monitor, @NotNull Set<? extends IResource> sourceDir, @Nullable IResDirectory fileWrapperOutPutDir, @NotNull FileSystemLocator.TraverseMode traverseMode, boolean enableInfo) {
        void $this$cache_u24lambda_u240;
        Caffeine caffeine;
        Intrinsics.checkNotNullParameter(sourceDir, (String)"sourceDir");
        Intrinsics.checkNotNullParameter((Object)traverseMode, (String)"traverseMode");
        this.monitor = monitor;
        this.sourceDir = sourceDir;
        this.fileWrapperOutPutDir = fileWrapperOutPutDir;
        this.traverseMode = traverseMode;
        this.enableInfo = enableInfo;
        this.loader = (CacheLoader)new /* Unavailable Anonymous Inner Class!! */;
        Caffeine caffeine2 = caffeine = Caffeine.newBuilder().softValues();
        ProjectFileLocator projectFileLocator = this;
        boolean bl = false;
        $this$cache_u24lambda_u240.maximumSize(8000L);
        LoadingCache loadingCache = caffeine.build(this.loader);
        Intrinsics.checkNotNullExpressionValue((Object)loadingCache, (String)"build(...)");
        projectFileLocator.cache = loadingCache;
    }

    public /* synthetic */ ProjectFileLocator(IMonitor iMonitor, Set set, IResDirectory iResDirectory, FileSystemLocator.TraverseMode traverseMode, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x10) != 0) {
            bl = true;
        }
        this(iMonitor, set, iResDirectory, traverseMode, bl);
    }

    @NotNull
    public Set<IResource> getSourceDir() {
        return this.sourceDir;
    }

    public void setSourceDir(@NotNull Set<? extends IResource> set) {
        Intrinsics.checkNotNullParameter(set, (String)"<set-?>");
        this.sourceDir = set;
    }

    private final Object indexer(Continuation<? super FileIndexer> $completion) {
        Deferred deferred = this.updateJob;
        if (deferred == null) {
            throw new IllegalStateException("update at first!".toString());
        }
        Deferred job2 = deferred;
        return job2.await($completion);
    }

    private final FileIndexer indexerBlock() {
        Deferred deferred = this.updateJob;
        if (deferred == null) {
            throw new IllegalStateException("update at first!".toString());
        }
        Deferred job2 = deferred;
        if (job2.isCompleted()) {
            return (FileIndexer)job2.getCompleted();
        }
        return (FileIndexer)BuildersKt.runBlocking$default(null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)1, null);
    }

    public void update() {
        block1: {
            if (!(this.updateJob == null)) {
                String string = "Check failed.";
                throw new IllegalStateException(string.toString());
            }
            Deferred deferred = this.updateJob = BuildersKt.async$default((CoroutineScope)((CoroutineScope)GlobalScope.INSTANCE), null, null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)3, null);
            if (deferred == null) break block1;
            deferred.start();
        }
    }

    @NotNull
    public Sequence<IResFile> findFromFileIndexMap(@NotNull List<String> parentSubPath, @NotNull AbstractFileIndexer.CompareMode mode) {
        Intrinsics.checkNotNullParameter(parentSubPath, (String)"parentSubPath");
        Intrinsics.checkNotNullParameter((Object)mode, (String)"mode");
        return this.indexerBlock().findFromFileIndexMap(parentSubPath, mode);
    }

    public final long totalFiles() {
        long c = 0L;
        for (Map.Entry x : this.indexerBlock().getFileNameToPathMap$corax_framework().entrySet()) {
            c += (long)((Set)x.getValue()).size();
        }
        return c;
    }

    public final long totalJavaSrcFiles() {
        Map extensionToPathMap = this.indexerBlock().getExtensionToPathMap$corax_framework();
        long count = 0L;
        for (String ext : ResourceKt.getJavaExtensions()) {
            Set set = (Set)extensionToPathMap.get(ext);
            int c = set != null ? ((Collection)set).size() : 0;
            count += (long)c;
        }
        return count;
    }

    private final IResFile makeWrapperFile(IBugResInfo resInfo, IWrapperFileGenerator fileWrapperIfNotEExists) {
        if (this.fileWrapperOutPutDir == null) {
            return null;
        }
        return fileWrapperIfNotEExists.makeWrapperFile(this.fileWrapperOutPutDir, resInfo);
    }

    private final IResFile get(ClassResInfo resInfo, IWrapperFileGenerator fileWrapperIfNotEExists) {
        IResFile found = (IResFile)this.indexerBlock().findAnyFile((Collection)resInfo.getSourceFile(), AbstractFileIndexer.Companion.getDefaultClassCompareMode());
        IResFile iResFile = found;
        if (iResFile == null) {
            iResFile = this.makeWrapperFile((IBugResInfo)resInfo, fileWrapperIfNotEExists);
        }
        return iResFile;
    }

    private final IResFile get(FileResInfo resInfo, IWrapperFileGenerator fileWrapperIfNotEExists) {
        if (resInfo.getSourcePath().getExists()) {
            return resInfo.getSourcePath();
        }
        return this.makeWrapperFile((IBugResInfo)resInfo, fileWrapperIfNotEExists);
    }

    @Nullable
    public IResFile get(@NotNull IBugResInfo resInfo, @NotNull IWrapperFileGenerator fileWrapperIfNotEExists) {
        Intrinsics.checkNotNullParameter((Object)resInfo, (String)"resInfo");
        Intrinsics.checkNotNullParameter((Object)fileWrapperIfNotEExists, (String)"fileWrapperIfNotEExists");
        return (IResFile)this.cache.get((Object)TuplesKt.to((Object)resInfo, (Object)fileWrapperIfNotEExists));
    }

    @Nullable
    public Object getByFileExtension(@NotNull String extension, @NotNull Continuation<? super Sequence<? extends IResFile>> $completion) {
        return ProjectFileLocator.getByFileExtension$suspendImpl((ProjectFileLocator)this, (String)extension, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ Object getByFileExtension$suspendImpl(ProjectFileLocator var0, String var1_1, Continuation<? super Sequence<? extends IResFile>> $completion) {
        if (!($completion instanceof getByFileExtension.1)) ** GOTO lbl-1000
        var4_3 = $completion;
        if ((var4_3.label & -2147483648) != 0) {
            var4_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = extension;
                $continuation.label = 1;
                v0 = $this.indexer((Continuation)$continuation);
                if (v0 == var5_5) {
                    return var5_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                extension = (String)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                if ((v1 = (Set)((FileIndexer)v0).getExtensionToPathMap$corax_framework().get(extension)) == null || (v1 = CollectionsKt.asSequence((Iterable)v1)) == null) {
                    v1 = SequencesKt.emptySequence();
                }
                return v1;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public Object getByFileName(@NotNull String filename, @NotNull Continuation<? super Sequence<? extends IResFile>> $completion) {
        return ProjectFileLocator.getByFileName$suspendImpl((ProjectFileLocator)this, (String)filename, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ Object getByFileName$suspendImpl(ProjectFileLocator var0, String var1_1, Continuation<? super Sequence<? extends IResFile>> $completion) {
        if (!($completion instanceof getByFileName.1)) ** GOTO lbl-1000
        var4_3 = $completion;
        if ((var4_3.label & -2147483648) != 0) {
            var4_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = filename;
                $continuation.label = 1;
                v0 = $this.indexer((Continuation)$continuation);
                if (v0 == var5_5) {
                    return var5_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                filename = (String)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                if ((v1 = (Set)((FileIndexer)v0).getFileNameToPathMap$corax_framework().get(filename)) == null || (v1 = CollectionsKt.asSequence((Iterable)v1)) == null) {
                    v1 = SequencesKt.emptySequence();
                }
                return v1;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public Object getAllFiles(@NotNull Continuation<? super Sequence<? extends IResFile>> $completion) {
        return ProjectFileLocator.getAllFiles$suspendImpl((ProjectFileLocator)this, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ Object getAllFiles$suspendImpl(ProjectFileLocator var0, Continuation<? super Sequence<? extends IResFile>> $completion) {
        if (!($completion instanceof getAllFiles.1)) ** GOTO lbl-1000
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
                $continuation.label = 1;
                v0 = $this.indexer((Continuation)$continuation);
                if (v0 == var4_4) {
                    return var4_4;
                }
                ** GOTO lbl20
            }
            case 1: {
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl20:
                // 2 sources

                return SequencesKt.flatMapIterable((Sequence)MapsKt.asSequence((Map)((FileIndexer)v0).getFileNameToPathMap$corax_framework()), (Function1)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, getAllFiles$lambda$1(java.util.Map$Entry ), (Ljava/util/Map$Entry;)Ljava/lang/Iterable;)());
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public String toString() {
        return "Source-Locator@" + System.identityHashCode(this);
    }

    private static final Iterable getAllFiles$lambda$1(Map.Entry it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return (Iterable)it.getValue();
    }

    private static final Unit logger$lambda$2() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$indexer(ProjectFileLocator $this, Continuation $completion) {
        return $this.indexer($completion);
    }

    public static final /* synthetic */ boolean access$getEnableInfo$p(ProjectFileLocator $this) {
        return $this.enableInfo;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }

    public static final /* synthetic */ FileSystemLocator.TraverseMode access$getTraverseMode$p(ProjectFileLocator $this) {
        return $this.traverseMode;
    }

    public static final /* synthetic */ IMonitor access$getMonitor$p(ProjectFileLocator $this) {
        return $this.monitor;
    }

    public static final /* synthetic */ IResFile access$get(ProjectFileLocator $this, ClassResInfo resInfo, IWrapperFileGenerator fileWrapperIfNotEExists) {
        return $this.get(resInfo, fileWrapperIfNotEExists);
    }

    public static final /* synthetic */ IResFile access$get(ProjectFileLocator $this, FileResInfo resInfo, IWrapperFileGenerator fileWrapperIfNotEExists) {
        return $this.get(resInfo, fileWrapperIfNotEExists);
    }
}

