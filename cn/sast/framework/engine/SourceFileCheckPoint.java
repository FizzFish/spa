/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.MainConfig$RelativePath
 *  cn.sast.api.report.DefaultEnv
 *  cn.sast.api.report.FileResInfo
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.framework.engine.CheckPoint
 *  cn.sast.framework.engine.SourceFileCheckPoint
 *  cn.sast.framework.engine.SourceFileCheckPoint$Companion
 *  cn.sast.framework.engine.SourceFileCheckPoint$lines$1
 *  cn.sast.framework.engine.SourceFileCheckPoint$text$1
 *  com.feysh.corax.config.api.ISourceFileCheckPoint
 *  com.feysh.corax.config.api.ISourceFileCheckPoint$DefaultImpls
 *  com.feysh.corax.config.api.report.Region
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IndexedValue
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.Dispatchers
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.engine;

import cn.sast.api.config.MainConfig;
import cn.sast.api.report.DefaultEnv;
import cn.sast.api.report.FileResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.framework.engine.CheckPoint;
import cn.sast.framework.engine.SourceFileCheckPoint;
import com.feysh.corax.config.api.ISourceFileCheckPoint;
import com.feysh.corax.config.api.report.Region;
import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 /2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001/B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010+\u001a\u00020%H\u0096@\u00a2\u0006\u0002\u0010,J\u0010\u0010&\u001a\u0004\u0018\u00010'H\u0096@\u00a2\u0006\u0002\u0010,J\u001a\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0*0)H\u0096@\u00a2\u0006\u0002\u0010,J\b\u0010-\u001a\u00020.H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\r8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0*\u0018\u00010)X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2={"Lcn/sast/framework/engine/SourceFileCheckPoint;", "Lcom/feysh/corax/config/api/ISourceFileCheckPoint;", "Lcn/sast/framework/engine/CheckPoint;", "Ljava/io/Closeable;", "sFile", "Lcn/sast/common/IResFile;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "<init>", "(Lcn/sast/common/IResFile;Lcn/sast/api/config/MainConfig;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "path", "Ljava/nio/file/Path;", "getPath", "()Ljava/nio/file/Path;", "relativePath", "Lcn/sast/api/config/MainConfig$RelativePath;", "getRelativePath", "()Lcn/sast/api/config/MainConfig$RelativePath;", "uri", "Ljava/net/URI;", "getUri", "()Ljava/net/URI;", "archiveFile", "getArchiveFile", "archiveFile$delegate", "Lkotlin/Lazy;", "file", "Lcn/sast/api/report/IBugResInfo;", "getFile", "()Lcn/sast/api/report/IBugResInfo;", "env", "Lcn/sast/api/report/DefaultEnv;", "getEnv$corax_framework", "()Lcn/sast/api/report/DefaultEnv;", "bytes", "", "text", "", "lines", "", "Lkotlin/collections/IndexedValue;", "readAllBytes", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nPreAnalysisImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreAnalysisImpl.kt\ncn/sast/framework/engine/SourceFileCheckPoint\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,760:1\n1#2:761\n1557#3:762\n1628#3,3:763\n*S KotlinDebug\n*F\n+ 1 PreAnalysisImpl.kt\ncn/sast/framework/engine/SourceFileCheckPoint\n*L\n747#1:762\n747#1:763,3\n*E\n"})
public final class SourceFileCheckPoint
extends CheckPoint
implements ISourceFileCheckPoint,
Closeable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final IResFile sFile;
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final Path path;
    @NotNull
    private final Lazy archiveFile$delegate;
    @NotNull
    private final IBugResInfo file;
    @Nullable
    private byte[] bytes;
    @Nullable
    private String text;
    @Nullable
    private List<IndexedValue<String>> lines;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(SourceFileCheckPoint::logger$lambda$7);

    public SourceFileCheckPoint(@NotNull IResFile sFile, @NotNull MainConfig mainConfig) {
        Intrinsics.checkNotNullParameter((Object)sFile, (String)"sFile");
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        this.sFile = sFile;
        this.mainConfig = mainConfig;
        this.path = this.sFile.getPath();
        this.archiveFile$delegate = LazyKt.lazy(() -> SourceFileCheckPoint.archiveFile_delegate$lambda$0(this));
        this.file = (IBugResInfo)new FileResInfo(this.sFile);
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    @NotNull
    public Path getPath() {
        return this.path;
    }

    @NotNull
    public MainConfig.RelativePath getRelativePath() {
        return this.mainConfig.tryGetRelativePath((IResource)this.sFile);
    }

    @NotNull
    public URI getUri() {
        return this.sFile.getUri();
    }

    @Nullable
    public Path getArchiveFile() {
        Lazy lazy = this.archiveFile$delegate;
        return (Path)lazy.getValue();
    }

    @NotNull
    public IBugResInfo getFile() {
        return this.file;
    }

    @NotNull
    public DefaultEnv getEnv$corax_framework() {
        return new DefaultEnv(Region.Companion.getERROR().getMutable(), null, null, null, null, null, null, null, null, 510, null);
    }

    @Nullable
    public Object readAllBytes(@NotNull Continuation<? super byte[]> $completion) {
        byte[] byArray;
        byte[] it = byArray = this.bytes;
        boolean bl = false;
        Object object = it != null ? byArray : null;
        if (object == null) {
            return BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), $completion);
        }
        return object;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public Object text(@NotNull Continuation<? super String> $completion) {
        if (!($completion instanceof text.1)) ** GOTO lbl-1000
        var6_2 = $completion;
        if ((var6_2.label & -2147483648) != 0) {
            var6_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var9_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                it = var2_5 = this.text;
                $i$a$-takeIf-SourceFileCheckPoint$text$2 = false;
                v0 = it != null != false ? var2_5 : null;
                if (v0 != null) ** GOTO lbl40
                $continuation.L$0 = this;
                $continuation.label = 1;
                v1 = this.readAllBytes((Continuation)$continuation);
                ** if (v1 != var9_4) goto lbl23
lbl22:
                // 1 sources

                return var9_4;
lbl23:
                // 1 sources

                ** GOTO lbl30
            }
            case 1: {
                this = (SourceFileCheckPoint)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl30:
                    // 2 sources

                    var7_9 = Charsets.UTF_8;
                    var8_10 = (byte[])v1;
                    it = var2_5 = new String(var8_10, var7_9);
                    $i$a$-also-SourceFileCheckPoint$text$3 = false;
                    this.text = it;
                }
                catch (IOException var3_7) {
                    SourceFileCheckPoint.logger.error("read config file " + this.getPath() + " failed");
                    var2_5 = null;
                }
                v0 = var2_5;
lbl40:
                // 2 sources

                return v0;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public Object lines(@NotNull Continuation<? super List<IndexedValue<String>>> $completion) {
        if (!($completion instanceof lines.1)) ** GOTO lbl-1000
        var17_2 = $completion;
        if ((var17_2.label & -2147483648) != 0) {
            var17_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var18_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                it = var2_5 = this.lines;
                $i$a$-takeIf-SourceFileCheckPoint$lines$2 = false;
                v0 = it != null != false ? var2_5 : null;
                if (v0 != null) ** GOTO lbl48
                $i$a$-run-SourceFileCheckPoint$lines$3 = false;
                $continuation.L$0 = this;
                $continuation.label = 1;
                v1 = this.text((Continuation)$continuation);
                if (v1 == var18_4) {
                    return var18_4;
                }
                ** GOTO lbl28
            }
            case 1: {
                $i$a$-run-SourceFileCheckPoint$lines$3 = false;
                this = (SourceFileCheckPoint)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl28:
                // 2 sources

                if ((v2 = (String)v1) != null && (v2 = StringsKt.split$default((CharSequence)((CharSequence)v2), (String[])(var4_9 = new String[]{"\n"}), (boolean)false, (int)0, (int)6, null)) != null && (v2 = CollectionsKt.withIndex((Iterable)((Iterable)v2))) != null) {
                    $this$map$iv = v2;
                    $i$f$map = false;
                    var7_12 = $this$map$iv;
                    destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                    $i$f$mapTo = false;
                    for (T item$iv$iv : $this$mapTo$iv$iv) {
                        var12_17 = (IndexedValue)item$iv$iv;
                        var13_18 = destination$iv$iv;
                        $i$a$-map-SourceFileCheckPoint$lines$3$r$1 = false;
                        var13_18.add(new IndexedValue(it.getIndex() + 1, it.getValue()));
                    }
                    v3 = (List)destination$iv$iv;
                } else {
                    v3 = CollectionsKt.emptyList();
                }
                this.lines = r = v3;
                v0 = r;
lbl48:
                // 2 sources

                return v0;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override
    public void close() {
        this.text = null;
        this.lines = null;
        this.bytes = null;
    }

    @NotNull
    public String getFilename() {
        return ISourceFileCheckPoint.DefaultImpls.getFilename((ISourceFileCheckPoint)this);
    }

    private static final Path archiveFile_delegate$lambda$0(SourceFileCheckPoint this$0) {
        Path path;
        if (this$0.sFile.isJarScheme()) {
            Path path2 = this$0.sFile.getSchemePath().toAbsolutePath();
            path = path2;
            Intrinsics.checkNotNullExpressionValue((Object)path2, (String)"toAbsolutePath(...)");
        } else {
            path = null;
        }
        return path;
    }

    private static final Unit logger$lambda$7() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ IResFile access$getSFile$p(SourceFileCheckPoint $this) {
        return $this.sFile;
    }

    public static final /* synthetic */ void access$setBytes$p(SourceFileCheckPoint $this, byte[] byArray) {
        $this.bytes = byArray;
    }
}

