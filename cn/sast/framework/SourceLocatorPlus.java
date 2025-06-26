/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.common.FileSystemLocator$TraverseMode
 *  cn.sast.common.IResFile
 *  cn.sast.common.Resource
 *  cn.sast.framework.SourceLocatorPlus
 *  cn.sast.framework.SourceLocatorPlusKt
 *  cn.sast.framework.report.AbstractFileIndexer
 *  cn.sast.framework.report.ProjectFileLocator
 *  com.feysh.corax.cache.XOptional
 *  com.github.benmanes.caffeine.cache.CacheLoader
 *  com.github.benmanes.caffeine.cache.Caffeine
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.FoundFile
 *  soot.IFoundFile
 *  soot.SourceLocator
 */
package cn.sast.framework;

import cn.sast.api.config.MainConfig;
import cn.sast.common.FileSystemLocator;
import cn.sast.common.IResFile;
import cn.sast.common.Resource;
import cn.sast.framework.SourceLocatorPlusKt;
import cn.sast.framework.report.AbstractFileIndexer;
import cn.sast.framework.report.ProjectFileLocator;
import com.feysh.corax.cache.XOptional;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.FoundFile;
import soot.IFoundFile;
import soot.SourceLocator;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006!"}, d2={"Lcn/sast/framework/SourceLocatorPlus;", "Lsoot/SourceLocator;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "<init>", "(Lcn/sast/api/config/MainConfig;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "cacheClassNameMap", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "Ljava/nio/file/Path;", "", "cacheClassLookMap", "Lcom/feysh/corax/cache/XOptional;", "Lsoot/FoundFile;", "locator", "Lcn/sast/framework/report/ProjectFileLocator;", "getLocator", "()Lcn/sast/framework/report/ProjectFileLocator;", "locator$delegate", "Lkotlin/Lazy;", "update", "", "getClassNameOf", "cls", "Lcn/sast/common/IResFile;", "isInvalidClassFile", "", "fileName", "lookupInClassPath", "Lsoot/IFoundFile;", "lookupInArchive", "archivePath", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nSourceLocatorPlus.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SourceLocatorPlus.kt\ncn/sast/framework/SourceLocatorPlus\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,116:1\n1#2:117\n183#3,2:118\n1628#4,3:120\n*S KotlinDebug\n*F\n+ 1 SourceLocatorPlus.kt\ncn/sast/framework/SourceLocatorPlus\n*L\n69#1:118,2\n77#1:120,3\n*E\n"})
public final class SourceLocatorPlus
extends SourceLocator {
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final LoadingCache<Path, String> cacheClassNameMap;
    @NotNull
    private final LoadingCache<String, XOptional<FoundFile>> cacheClassLookMap;
    @NotNull
    private final Lazy locator$delegate;

    /*
     * WARNING - void declaration
     */
    public SourceLocatorPlus(@NotNull MainConfig mainConfig) {
        void $this$cacheClassLookMap_u24lambda_u243;
        Caffeine $this$cacheClassNameMap_u24lambda_u240;
        Caffeine caffeine;
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        super(null);
        this.mainConfig = mainConfig;
        Caffeine caffeine2 = caffeine = Caffeine.newBuilder().softValues();
        SourceLocatorPlus sourceLocatorPlus = this;
        boolean bl = false;
        $this$cacheClassNameMap_u24lambda_u240.initialCapacity(5000);
        Caffeine caffeine3 = caffeine;
        caffeine = SourceLocatorPlus::cacheClassNameMap$lambda$2;
        LoadingCache loadingCache = caffeine3.build((CacheLoader)new /* Unavailable Anonymous Inner Class!! */);
        Intrinsics.checkNotNullExpressionValue((Object)loadingCache, (String)"build(...)");
        sourceLocatorPlus.cacheClassNameMap = loadingCache;
        $this$cacheClassNameMap_u24lambda_u240 = caffeine = Caffeine.newBuilder().softValues();
        sourceLocatorPlus = this;
        boolean bl2 = false;
        $this$cacheClassLookMap_u24lambda_u243.initialCapacity(5000);
        Caffeine caffeine4 = caffeine;
        caffeine = arg_0 -> SourceLocatorPlus.cacheClassLookMap$lambda$7(this, arg_0);
        LoadingCache loadingCache2 = caffeine4.build((CacheLoader)new /* Unavailable Anonymous Inner Class!! */);
        Intrinsics.checkNotNullExpressionValue((Object)loadingCache2, (String)"build(...)");
        sourceLocatorPlus.cacheClassLookMap = loadingCache2;
        this.locator$delegate = LazyKt.lazy(() -> SourceLocatorPlus.locator_delegate$lambda$10(this));
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    @NotNull
    public final ProjectFileLocator getLocator() {
        Lazy lazy = this.locator$delegate;
        return (ProjectFileLocator)lazy.getValue();
    }

    public final void update() {
    }

    @Nullable
    public final String getClassNameOf(@NotNull IResFile cls) {
        Intrinsics.checkNotNullParameter((Object)cls, (String)"cls");
        return (String)this.cacheClassNameMap.get((Object)cls.getPath());
    }

    public final boolean isInvalidClassFile(@NotNull String fileName, @NotNull IResFile cls) {
        Intrinsics.checkNotNullParameter((Object)fileName, (String)"fileName");
        Intrinsics.checkNotNullParameter((Object)cls, (String)"cls");
        String string = this.getClassNameOf(cls);
        if (string == null) {
            return false;
        }
        String realClsName = string;
        return Intrinsics.areEqual((Object)realClsName, (Object)fileName);
    }

    @Nullable
    public IFoundFile lookupInClassPath(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter((Object)fileName, (String)"fileName");
        if (Intrinsics.areEqual((Object)"LinearLayout.class", (Object)fileName)) {
            return null;
        }
        XOptional xOptional = (XOptional)this.cacheClassLookMap.get((Object)fileName);
        if (xOptional != null) {
            XOptional it = xOptional;
            boolean bl = false;
            return (IFoundFile)it.getValue();
        }
        xOptional = super.lookupInClassPath(fileName);
        if (xOptional != null) {
            XOptional it = xOptional;
            boolean bl = false;
            return it;
        }
        return null;
    }

    @Nullable
    protected IFoundFile lookupInArchive(@NotNull String archivePath, @NotNull String fileName) {
        Intrinsics.checkNotNullParameter((Object)archivePath, (String)"archivePath");
        Intrinsics.checkNotNullParameter((Object)fileName, (String)"fileName");
        XOptional xOptional = (XOptional)this.cacheClassLookMap.get((Object)fileName);
        if (xOptional != null) {
            XOptional it = xOptional;
            boolean bl = false;
            return (IFoundFile)it.getValue();
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final String cacheClassNameMap$lambda$2(Path cls) {
        Intrinsics.checkNotNullParameter((Object)cls, (String)"cls");
        try {
            OpenOption[] openOptionArray = new OpenOption[]{};
            InputStream inputStream = Files.newInputStream(cls, Arrays.copyOf(openOptionArray, openOptionArray.length));
            Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"newInputStream(...)");
            Closeable closeable = inputStream;
            Throwable throwable = null;
            try {
                String string;
                InputStream inputStream2 = (InputStream)closeable;
                boolean bl = false;
                if (SourceLocator.getNameOfClassUnsafe((InputStream)inputStream2) == null) {
                    String string2 = null;
                    return string2;
                }
                String string3 = StringsKt.replace$default((String)string, (char)'.', (char)'/', (boolean)false, (int)4, null) + ".class";
                return string3;
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
            }
        }
        catch (IOException iOException) {
            return null;
        }
    }

    private static final XOptional cacheClassLookMap$lambda$7(SourceLocatorPlus this$0, String fileName) {
        Object v0;
        block2: {
            Intrinsics.checkNotNullParameter((Object)fileName, (String)"fileName");
            String[] stringArray = new String[]{"/"};
            Sequence $this$firstOrNull$iv = this$0.getLocator().findFromFileIndexMap(StringsKt.split$default((CharSequence)fileName, (String[])stringArray, (boolean)false, (int)0, (int)6, null), AbstractFileIndexer.Companion.getDefaultClassCompareMode());
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                IResFile it = (IResFile)element$iv;
                boolean bl = false;
                if (!this$0.isInvalidClassFile(fileName, it)) continue;
                v0 = element$iv;
                break block2;
            }
            v0 = null;
        }
        IResFile iResFile = v0;
        if (iResFile != null) {
            IResFile it = iResFile;
            boolean bl = false;
            it = new FoundFile(it.getPath());
            boolean bl2 = false;
            return XOptional.Companion.of((Object)it);
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    private static final ProjectFileLocator locator_delegate$lambda$10(SourceLocatorPlus this$0) {
        void $this$mapTo$iv;
        Iterable iterable = this$0.mainConfig.getSoot_process_dir();
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            String string = (String)item$iv;
            Collection collection = destination$iv;
            boolean bl = false;
            collection.add(Resource.INSTANCE.of((String)it));
        }
        Set append = SourceLocatorPlusKt.sootClassPathsCvt((Set)((Set)destination$iv));
        Iterable it = iterable = new ProjectFileLocator(this$0.mainConfig.getMonitor(), append, null, FileSystemLocator.TraverseMode.IndexArchive, false);
        boolean bl = false;
        it.update();
        return iterable;
    }
}

