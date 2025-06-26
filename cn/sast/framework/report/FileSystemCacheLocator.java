/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.FileSystemLocator$TraverseMode
 *  cn.sast.common.IResource
 *  cn.sast.framework.report.FileIndexer
 *  cn.sast.framework.report.FileIndexerBuilder
 *  cn.sast.framework.report.FileSystemCacheLocator
 *  cn.sast.framework.report.FileSystemCacheLocator$getIndexer$1
 *  com.github.benmanes.caffeine.cache.CacheLoader
 *  com.github.benmanes.caffeine.cache.Caffeine
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.Deferred
 *  kotlinx.coroutines.GlobalScope
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report;

import cn.sast.common.FileSystemLocator;
import cn.sast.common.IResource;
import cn.sast.framework.report.FileIndexer;
import cn.sast.framework.report.FileIndexerBuilder;
import cn.sast.framework.report.FileSystemCacheLocator;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\bH\u0002J$\u0010\u0011\u001a\u00020\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\u0006\u0010\u0010\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016R5\u0010\u0004\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0005\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2={"Lcn/sast/framework/report/FileSystemCacheLocator;", "", "<init>", "()V", "cache", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "Lkotlin/Pair;", "Lcn/sast/common/IResource;", "Lcn/sast/common/FileSystemLocator$TraverseMode;", "Lkotlinx/coroutines/Deferred;", "Lcn/sast/framework/report/FileIndexer;", "getCache$annotations", "getCache", "()Lcom/github/benmanes/caffeine/cache/LoadingCache;", "getFileIndexer", "res", "traverseMode", "getIndexer", "Lcn/sast/framework/report/FileIndexerBuilder;", "", "(Ljava/util/Set;Lcn/sast/common/FileSystemLocator$TraverseMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nJavaSourceLocator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaSourceLocator.kt\ncn/sast/framework/report/FileSystemCacheLocator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,490:1\n1557#2:491\n1628#2,3:492\n1863#2,2:495\n*S KotlinDebug\n*F\n+ 1 JavaSourceLocator.kt\ncn/sast/framework/report/FileSystemCacheLocator\n*L\n312#1:491\n312#1:492,3\n312#1:495,2\n*E\n"})
public final class FileSystemCacheLocator {
    @NotNull
    public static final FileSystemCacheLocator INSTANCE = new FileSystemCacheLocator();
    @NotNull
    private static final LoadingCache<Pair<IResource, FileSystemLocator.TraverseMode>, Deferred<FileIndexer>> cache;

    private FileSystemCacheLocator() {
    }

    @NotNull
    public final LoadingCache<Pair<IResource, FileSystemLocator.TraverseMode>, Deferred<FileIndexer>> getCache() {
        return cache;
    }

    public static /* synthetic */ void getCache$annotations() {
    }

    private final Deferred<FileIndexer> getFileIndexer(IResource res, FileSystemLocator.TraverseMode traverseMode) {
        Object object = cache.get((Object)TuplesKt.to((Object)res, (Object)traverseMode));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        return (Deferred)object;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object getIndexer(@NotNull Set<? extends IResource> var1_1, @NotNull FileSystemLocator.TraverseMode var2_2, @NotNull Continuation<? super FileIndexerBuilder> $completion) {
        if (!($completion instanceof getIndexer.1)) ** GOTO lbl-1000
        var16_4 = $completion;
        if ((var16_4.label & -2147483648) != 0) {
            var16_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var17_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                union = new FileIndexerBuilder();
                $this$map$iv = (Iterable)res;
                $i$f$map = false;
                var7_10 = $this$map$iv;
                destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                $i$f$mapTo = false;
                for (T item$iv$iv : $this$mapTo$iv$iv) {
                    var12_17 = (IResource)item$iv$iv;
                    var14_19 = destination$iv$iv;
                    $i$a$-map-FileSystemCacheLocator$getIndexer$2 = false;
                    var14_19.add(FileSystemCacheLocator.INSTANCE.getFileIndexer((IResource)it, (FileSystemLocator.TraverseMode)traverseMode));
                }
                $this$forEach$iv = (List)destination$iv$iv;
                $i$f$forEach = false;
                var7_10 = $this$forEach$iv.iterator();
lbl28:
                // 2 sources

                while (var7_10.hasNext()) {
                    element$iv = var7_10.next();
                    it = (Deferred)element$iv;
                    $i$a$-forEach-FileSystemCacheLocator$getIndexer$3 = false;
                    var11_16 = union;
                    $continuation.L$0 = union;
                    $continuation.L$1 = var7_10;
                    $continuation.L$2 = var11_16;
                    $continuation.label = 1;
                    v0 = it.await((Continuation)$continuation);
                    if (v0 == var17_6) {
                        return var17_6;
                    }
                    ** GOTO lbl50
                }
                break;
            }
            case 1: {
                $i$f$forEach = false;
                $i$a$-forEach-FileSystemCacheLocator$getIndexer$3 = false;
                var11_16 = (FileIndexerBuilder)$continuation.L$2;
                var7_10 = (Iterator)$continuation.L$1;
                union = (FileIndexerBuilder)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl50:
                // 2 sources

                var11_16.union((FileIndexer)v0);
                ** GOTO lbl28
            }
        }
        return union;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final void clear() {
        cache.cleanUp();
    }

    private static final Deferred cache$lambda$0(Pair pair) {
        IResource root = (IResource)pair.component1();
        FileSystemLocator.TraverseMode traverseMode = (FileSystemLocator.TraverseMode)pair.component2();
        GlobalScope scope = GlobalScope.INSTANCE;
        return BuildersKt.async$default((CoroutineScope)((CoroutineScope)scope), null, null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)3, null);
    }

    static {
        Function1 function1 = FileSystemCacheLocator::cache$lambda$0;
        LoadingCache loadingCache = Caffeine.newBuilder().build((CacheLoader)new /* Unavailable Anonymous Inner Class!! */);
        Intrinsics.checkNotNullExpressionValue((Object)loadingCache, (String)"build(...)");
        cache = loadingCache;
    }
}

