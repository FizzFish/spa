/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.common.FileSystemLocator
 *  cn.sast.common.FileSystemLocator$Companion
 *  cn.sast.common.FileSystemLocator$TraverseMode
 *  cn.sast.common.FileSystemLocator$process$1
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.common.PathExtensionsKt
 *  cn.sast.common.Resource
 *  cn.sast.common.WalkFileTreeResult
 *  com.github.benmanes.caffeine.cache.CacheLoader
 *  com.github.benmanes.caffeine.cache.Caffeine
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Deferred
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.common;

import cn.sast.api.config.MainConfig;
import cn.sast.common.FileSystemLocator;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.PathExtensionsKt;
import cn.sast.common.Resource;
import cn.sast.common.WalkFileTreeResult;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0082@\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lcn/sast/common/FileSystemLocator;", "", "<init>", "()V", "visitedArchive", "", "Ljava/nio/file/Path;", "process", "", "path", "traverseMode", "Lcn/sast/common/FileSystemLocator$TraverseMode;", "(Ljava/nio/file/Path;Lcn/sast/common/FileSystemLocator$TraverseMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "visit", "res", "Lcn/sast/common/WalkFileTreeResult;", "(Lcn/sast/common/WalkFileTreeResult;Lcn/sast/common/FileSystemLocator$TraverseMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "traverseArchive", "archiveLike", "Lcn/sast/common/IResFile;", "visitFile", "file", "visitArchive", "", "visitDirectory", "dir", "Lcn/sast/common/IResDirectory;", "TraverseMode", "Companion", "corax-api"})
public abstract class FileSystemLocator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Set<Path> visitedArchive;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(FileSystemLocator::logger$lambda$3);
    @NotNull
    private static final LoadingCache<Path, Deferred<WalkFileTreeResult>> walkTreeCache;

    public FileSystemLocator() {
        Set set = Collections.synchronizedSet(new HashSet(1000));
        Intrinsics.checkNotNullExpressionValue(set, (String)"synchronizedSet(...)");
        this.visitedArchive = set;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object process(@NotNull Path var1_1, @NotNull TraverseMode var2_2, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof process.1)) ** GOTO lbl-1000
        var6_4 = $completion;
        if ((var6_4.label & -2147483648) != 0) {
            var6_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var7_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                var4_7 = this;
                $continuation.L$0 = traverseMode;
                $continuation.L$1 = var4_7;
                $continuation.label = 1;
                v0 = FileSystemLocator.Companion.getWalkTreeResultSafe((Path)path).await((Continuation)$continuation);
                if (v0 == var7_6) {
                    return var7_6;
                }
                ** GOTO lbl25
            }
            case 1: {
                var4_7 = (FileSystemLocator)$continuation.L$1;
                traverseMode = (TraverseMode)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl25:
                // 2 sources

                $continuation.L$0 = null;
                $continuation.L$1 = null;
                $continuation.label = 2;
                v1 = var4_7.visit((WalkFileTreeResult)v0, traverseMode, (Continuation)$continuation);
                if (v1 == var7_6) {
                    return var7_6;
                }
                ** GOTO lbl35
            }
            case 2: {
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl35:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private final Object visit(WalkFileTreeResult res, TraverseMode traverseMode, Continuation<? super Unit> $completion) {
        List archives = new ArrayList();
        for (Path it : res.getFiles()) {
            IResFile file = Resource.INSTANCE.fileOf(it);
            this.visitFile(file);
            if (!traverseMode.getProcessArchive() || !file.getZipLike()) continue;
            archives.add(file);
        }
        for (Path dir : res.getDirs()) {
            this.visitDirectory(Resource.INSTANCE.dirOf(dir));
        }
        if (archives.isEmpty()) {
            return Unit.INSTANCE;
        }
        Object object = CoroutineScopeKt.coroutineScope((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final WalkFileTreeResult traverseArchive(IResFile archiveLike) {
        List files2 = new ArrayList();
        List dirs = new ArrayList();
        files2.add(archiveLike.getPath());
        int errorCnt = 0;
        Set entries = archiveLike.getEntries();
        for (String entry : entries) {
            try {
                Path innerPath = Resource.INSTANCE.archivePath(archiveLike.getPath(), entry);
                boolean bl = PathExtensionsKt.isDirectory((Path)innerPath) ? dirs.add(innerPath) : files2.add(innerPath);
            }
            catch (Exception e) {
                logger.error(() -> FileSystemLocator.traverseArchive$lambda$0(archiveLike, entry, e));
                logger.debug((Throwable)e, () -> FileSystemLocator.traverseArchive$lambda$1(archiveLike, entry));
                if (errorCnt++ < 10) continue;
                logger.error(() -> FileSystemLocator.traverseArchive$lambda$2(archiveLike));
                break;
            }
        }
        return new WalkFileTreeResult(archiveLike.getPath(), files2, dirs);
    }

    public void visitFile(@NotNull IResFile file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
    }

    public boolean visitArchive(@NotNull IResFile file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        try {
            if (Intrinsics.areEqual((Object)file.getExtension(), (Object)"apk")) {
                return false;
            }
            if (MainConfig.Companion.getExcludeFiles().contains(file.getName())) {
                return false;
            }
            if (file.resolve("java.base/module-info.java").getExists()) {
                return false;
            }
            if (file.resolve("jdk.zipfs/module-info.java").getExists()) {
                return false;
            }
            if (file.getZipLike() && file.resolve("AndroidManifest.xml").getExists() && !Intrinsics.areEqual((Object)file.getExtension(), (Object)"aar")) {
                return false;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return true;
    }

    public void visitDirectory(@NotNull IResDirectory dir) {
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
    }

    private static final Object traverseArchive$lambda$0(IResFile $archiveLike, String $entry, Exception $e) {
        return "invalid inner zip file: `" + $archiveLike + "!/" + $entry + "` " + $e.getClass() + " " + $e.getMessage();
    }

    private static final Object traverseArchive$lambda$1(IResFile $archiveLike, String $entry) {
        return "invalid inner zip file: `" + $archiveLike + "!/" + $entry + "`";
    }

    private static final Object traverseArchive$lambda$2(IResFile $archiveLike) {
        return "Skip invalid zip file: `" + $archiveLike + "`";
    }

    private static final Unit logger$lambda$3() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$visit(FileSystemLocator $this, WalkFileTreeResult res, TraverseMode traverseMode, Continuation $completion) {
        return $this.visit(res, traverseMode, $completion);
    }

    public static final /* synthetic */ Set access$getVisitedArchive$p(FileSystemLocator $this) {
        return $this.visitedArchive;
    }

    public static final /* synthetic */ WalkFileTreeResult access$traverseArchive(FileSystemLocator $this, IResFile archiveLike) {
        return $this.traverseArchive(archiveLike);
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }

    public static final /* synthetic */ LoadingCache access$getWalkTreeCache$cp() {
        return walkTreeCache;
    }

    static {
        LoadingCache loadingCache = Caffeine.newBuilder().expireAfterAccess(Duration.ofSeconds(15L)).build((CacheLoader)new /* Unavailable Anonymous Inner Class!! */);
        Intrinsics.checkNotNullExpressionValue((Object)loadingCache, (String)"build(...)");
        walkTreeCache = loadingCache;
    }
}

