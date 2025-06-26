/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResFile
 *  cn.sast.common.JarMerger
 *  cn.sast.common.Resource
 *  cn.sast.common.ResourceImplKt
 *  cn.sast.common.ResourceKt
 *  cn.sast.framework.util.SootUtils
 *  com.github.benmanes.caffeine.cache.CacheLoader
 *  com.github.benmanes.caffeine.cache.Caffeine
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  com.googlecode.d2j.dex.Dex2jar
 *  com.googlecode.d2j.dex.DexExceptionHandler
 *  com.googlecode.d2j.reader.BaseDexFileReader
 *  com.googlecode.d2j.reader.MultiDexFileReader
 *  com.googlecode.dex2jar.tools.BaksmaliBaseDexExceptionHandler
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.CloseableKt
 *  kotlin.io.path.PathsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  kotlin.text.StringsKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.utbot.common.LoggerWithLogMethod
 *  org.utbot.common.LoggingKt
 *  org.utbot.common.Maybe
 *  soot.ClassSource
 *  soot.DexClassSource
 *  soot.FoundFile
 *  soot.IFoundFile
 *  soot.ModuleUtil
 *  soot.SourceLocator
 *  soot.asm.AsmClassSource
 */
package cn.sast.framework.util;

import cn.sast.common.IResFile;
import cn.sast.common.JarMerger;
import cn.sast.common.Resource;
import cn.sast.common.ResourceImplKt;
import cn.sast.common.ResourceKt;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.googlecode.d2j.dex.Dex2jar;
import com.googlecode.d2j.dex.DexExceptionHandler;
import com.googlecode.d2j.reader.BaseDexFileReader;
import com.googlecode.d2j.reader.MultiDexFileReader;
import com.googlecode.dex2jar.tools.BaksmaliBaseDexExceptionHandler;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.path.PathsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import kotlin.text.StringsKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.common.LoggerWithLogMethod;
import org.utbot.common.LoggingKt;
import org.utbot.common.Maybe;
import soot.ClassSource;
import soot.DexClassSource;
import soot.FoundFile;
import soot.IFoundFile;
import soot.ModuleUtil;
import soot.SourceLocator;
import soot.asm.AsmClassSource;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003Jz\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\tJ\u001c\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u0007\u001a\u00020\u0005J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020!R \u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00160\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2={"Lcn/sast/framework/util/SootUtils;", "", "<init>", "()V", "dex2jar", "Ljava/nio/file/Path;", "dexSource", "output", "notHandleException", "", "reuseReg", "debugInfo", "optmizeSynchronized", "printIR", "noCode", "skipExceptions", "dontSanitizeNames", "computeFrames", "topoLogicalSort", "", "sootClass2classFileCache", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "Ljava/util/Optional;", "lookupInArchive", "Lcn/sast/common/IResFile;", "archivePath", "fileName", "", "getClassSourceFromSoot", "className", "logger", "Lmu/KLogger;", "cleanUp", "", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nSootUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SootUtils.kt\ncn/sast/framework/util/SootUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ReportConverter.kt\ncn/sast/framework/report/ReportConverterKt\n+ 4 Logging.kt\norg/utbot/common/LoggingKt\n*L\n1#1,158:1\n1#2:159\n38#3,3:160\n38#3,3:163\n38#3,3:166\n38#3,3:169\n38#3,3:172\n49#4,24:175\n*S KotlinDebug\n*F\n+ 1 SootUtils.kt\ncn/sast/framework/util/SootUtils\n*L\n122#1:160,3\n123#1:163,3\n124#1:166,3\n125#1:169,3\n141#1:172,3\n41#1:175,24\n*E\n"})
public final class SootUtils {
    @NotNull
    public static final SootUtils INSTANCE = new SootUtils();
    @NotNull
    private static final LoadingCache<Path, Optional<Path>> sootClass2classFileCache;
    @NotNull
    private static final KLogger logger;

    private SootUtils() {
    }

    @NotNull
    public final Path dex2jar(@NotNull Path dexSource, @NotNull Path output, boolean notHandleException, boolean reuseReg, boolean debugInfo, boolean optmizeSynchronized, boolean printIR, boolean noCode, boolean skipExceptions, boolean dontSanitizeNames, boolean computeFrames, boolean topoLogicalSort) throws Exception {
        Intrinsics.checkNotNullParameter((Object)dexSource, (String)"dexSource");
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        ResourceKt.findCacheFromDeskOrCreate((Path)dexSource, (Path)output, () -> SootUtils.dex2jar$lambda$2(dexSource, output, notHandleException, reuseReg, debugInfo, optmizeSynchronized, printIR, noCode, skipExceptions, dontSanitizeNames, computeFrames, topoLogicalSort));
        return output;
    }

    public static /* synthetic */ Path dex2jar$default(SootUtils sootUtils, Path path, Path path2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, int n, Object object) throws Exception {
        if ((n & 4) != 0) {
            bl = false;
        }
        if ((n & 8) != 0) {
            bl2 = false;
        }
        if ((n & 0x10) != 0) {
            bl3 = true;
        }
        if ((n & 0x20) != 0) {
            bl4 = true;
        }
        if ((n & 0x40) != 0) {
            bl5 = false;
        }
        if ((n & 0x80) != 0) {
            bl6 = false;
        }
        if ((n & 0x100) != 0) {
            bl7 = false;
        }
        if ((n & 0x200) != 0) {
            bl8 = false;
        }
        if ((n & 0x400) != 0) {
            bl9 = true;
        }
        if ((n & 0x800) != 0) {
            bl10 = true;
        }
        return sootUtils.dex2jar(path, path2, bl, bl2, bl3, bl4, bl5, bl6, bl7, bl8, bl9, bl10);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public final Path dex2jar(@NotNull Set<? extends Path> dexSource, @NotNull Path output) throws Exception {
        Intrinsics.checkNotNullParameter(dexSource, (String)"dexSource");
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        if (dexSource.size() == 1) {
            OpenOption[] openOptionArray = new OpenOption[]{};
            InputStream inputStream = Files.newInputStream((Path)CollectionsKt.first((Iterable)dexSource), Arrays.copyOf(openOptionArray, openOptionArray.length));
            Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"newInputStream(...)");
            Closeable closeable = inputStream;
            Throwable throwable = null;
            try {
                InputStream it = (InputStream)closeable;
                boolean bl = false;
                Dex2jar.from((InputStream)it).to(output);
                it = Unit.INSTANCE;
            }
            catch (Throwable it) {
                throwable = it;
                throw it;
            }
            finally {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
            }
        }
        Closeable closeable = (Closeable)new JarMerger(output, null, 2, null);
        Throwable throwable = null;
        try {
            JarMerger merger = (JarMerger)closeable;
            boolean bl = false;
            for (Path path : dexSource) {
                Path part = Files.createTempFile(ResourceImplKt.getSAstTempDirectory(), PathsKt.getName((Path)path), ".jar", new FileAttribute[0]);
                Intrinsics.checkNotNull((Object)part);
                Path jar = SootUtils.dex2jar$default((SootUtils)INSTANCE, (Path)path, (Path)part, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)true, (boolean)false, (boolean)false, (int)3580, null);
                JarMerger.addJar$default((JarMerger)merger, (Path)jar, null, null, (int)6, null);
                Files.deleteIfExists(part);
            }
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
        return output;
    }

    private final IResFile lookupInArchive(IResFile archivePath, String fileName) {
        Set entryNames = archivePath.getEntries();
        return entryNames.contains(fileName) ? Resource.INSTANCE.fileOf(Resource.INSTANCE.archivePath(archivePath.getPath(), fileName)) : null;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Nullable
    public final IResFile getClassSourceFromSoot(@NotNull String className) {
        IResFile iResFile;
        Intrinsics.checkNotNullParameter((Object)className, (String)"className");
        ClassSource classSource = SourceLocator.v().getClassSource(className);
        if (classSource == null) {
            return null;
        }
        ClassSource clazz = classSource;
        ClassSource classSource2 = clazz;
        if (classSource2 instanceof AsmClassSource) {
            void $this$getField$iv;
            void $this$getField$iv2;
            IFoundFile iFoundFile;
            ClassSource classSource3 = clazz;
            String name$iv = "foundFile";
            boolean $i$f$getField = false;
            Field it$iv = classSource3.getClass().getDeclaredField(name$iv);
            boolean bl = false;
            it$iv.setAccessible(true);
            Object object = it$iv.get(classSource3);
            if (!(object instanceof IFoundFile)) {
                object = null;
            }
            if (!((iFoundFile = (IFoundFile)object) instanceof FoundFile)) return null;
            FoundFile foundFile = (FoundFile)iFoundFile;
            if (foundFile == null) {
                return null;
            }
            FoundFile foundFile2 = foundFile;
            iFoundFile = foundFile2;
            String string = "path";
            boolean $i$f$getField2 = false;
            Field it$iv2 = $this$getField$iv2.getClass().getDeclaredField(string);
            $i$a$-let-ReportConverterKt$getField$1$iv = false;
            it$iv2.setAccessible(true);
            Object object2 = it$iv2.get($this$getField$iv2);
            if (!(object2 instanceof Path)) {
                object2 = null;
            }
            Path path = (Path)object2;
            FoundFile foundFile3 = foundFile2;
            name$iv = "file";
            $i$f$getField = false;
            it$iv = foundFile3.getClass().getDeclaredField(name$iv);
            bl = false;
            it$iv.setAccessible(true);
            Object object3 = it$iv.get(foundFile3);
            if (!(object3 instanceof File)) {
                object3 = null;
            }
            File zipFile = (File)object3;
            name$iv = foundFile2;
            String name$iv2 = "entryName";
            boolean $i$f$getField3 = false;
            Field it$iv3 = $this$getField$iv.getClass().getDeclaredField(name$iv2);
            $i$a$-let-ReportConverterKt$getField$1$iv = false;
            it$iv3.setAccessible(true);
            Object object4 = it$iv3.get($this$getField$iv);
            if (!(object4 instanceof String)) {
                object4 = null;
            }
            String string2 = (String)object4;
            if (path != null) {
                iResFile = Resource.INSTANCE.of(path).toFile();
                return iResFile;
            } else {
                if (zipFile == null) return null;
                if (string2 == null) return null;
                Path path2 = zipFile.toPath();
                Intrinsics.checkNotNullExpressionValue((Object)path2, (String)"toPath(...)");
                iResFile = Resource.INSTANCE.fileOf(path2).resolve(string2).toFile();
            }
            return iResFile;
        } else {
            if (!(classSource2 instanceof DexClassSource)) return null;
            if (ModuleUtil.module_mode()) {
                return null;
            }
            String clsFile = StringsKt.replace$default((String)className, (char)'.', (char)'/', (boolean)false, (int)4, null) + ".class";
            ClassSource classSource4 = clazz;
            String name$iv = "path";
            boolean $i$f$getField = false;
            Field it$iv = classSource4.getClass().getDeclaredField(name$iv);
            boolean bl = false;
            it$iv.setAccessible(true);
            Object object = it$iv.get(classSource4);
            if (!(object instanceof File)) {
                object = null;
            }
            File file = (File)object;
            if (file == null) {
                return null;
            }
            File dex = file;
            Path path = dex.toPath();
            Intrinsics.checkNotNullExpressionValue((Object)path, (String)"toPath(...)");
            Path path3 = path.toAbsolutePath();
            Intrinsics.checkNotNullExpressionValue((Object)path3, (String)"toAbsolutePath(...)");
            Object object5 = sootClass2classFileCache.get((Object)path3.normalize());
            Intrinsics.checkNotNullExpressionValue((Object)object5, (String)"get(...)");
            Path path4 = (Path)OptionalsKt.getOrNull((Optional)((Optional)object5));
            if (path4 == null) {
                return null;
            }
            Path jar = path4;
            iResFile = this.lookupInArchive(Resource.INSTANCE.fileOf(jar), clsFile);
        }
        return iResFile;
    }

    public final void cleanUp() {
        sootClass2classFileCache.cleanUp();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    private static final Unit dex2jar$lambda$2(Path $dexSource, Path $output, boolean $notHandleException, boolean $reuseReg, boolean $debugInfo, boolean $optmizeSynchronized, boolean $printIR, boolean $noCode, boolean $skipExceptions, boolean $dontSanitizeNames, boolean $computeFrames, boolean $topoLogicalSort) {
        void $this$bracket_u24default$iv;
        LoggerWithLogMethod loggerWithLogMethod = LoggingKt.info((KLogger)logger);
        String msg$iv = "dex2jar " + ((Object)$dexSource).toString() + " -> " + $output;
        boolean $i$f$bracket = false;
        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
        LocalDateTime startTime$iv = LocalDateTime.now();
        boolean alreadyLogged$iv = false;
        Ref.ObjectRef res$iv = new Ref.ObjectRef();
        res$iv.element = Maybe.Companion.empty();
        try {
            Dex2jar dex2jar;
            Ref.ObjectRef objectRef = res$iv;
            boolean bl = false;
            BaseDexFileReader baseDexFileReader = MultiDexFileReader.open((byte[])Files.readAllBytes($dexSource));
            Intrinsics.checkNotNullExpressionValue((Object)baseDexFileReader, (String)"open(...)");
            BaseDexFileReader reader = baseDexFileReader;
            BaksmaliBaseDexExceptionHandler handler = $notHandleException ? null : new BaksmaliBaseDexExceptionHandler();
            Dex2jar it = dex2jar = Dex2jar.from((BaseDexFileReader)reader).withExceptionHandler((DexExceptionHandler)handler).reUseReg($reuseReg);
            boolean bl2 = false;
            if ($topoLogicalSort) {
                it.topoLogicalSort();
            }
            dex2jar.skipDebug(!$debugInfo).optimizeSynchronized($optmizeSynchronized).printIR($printIR).noCode($noCode).skipExceptions($skipExceptions).dontSanitizeNames($dontSanitizeNames).computeFrames($computeFrames).to($output);
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
        return Unit.INSTANCE;
    }

    private static final Object sootClass2classFileCache$lambda$6$lambda$5(Path $dexSource) {
        return "failed to convert dex: " + $dexSource + " to jar file.";
    }

    private static final Optional sootClass2classFileCache$lambda$6(Path dexSource) {
        try {
            Path path = Resource.INSTANCE.getZipExtractOutputDir().resolve("dex2jar");
            Intrinsics.checkNotNull((Object)dexSource);
            Path output = path.resolve(StringsKt.substringBeforeLast$default((String)PathsKt.getName((Path)dexSource), (String)".", null, (int)2, null) + "-" + Math.abs(((Object)dexSource).toString().hashCode() + 1) + ".jar");
            Intrinsics.checkNotNull((Object)output);
            Path r = SootUtils.dex2jar$default((SootUtils)INSTANCE, (Path)dexSource, (Path)output, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (int)3580, null);
            return Optional.of(r);
        }
        catch (Exception e) {
            logger.warn((Throwable)e, () -> SootUtils.sootClass2classFileCache$lambda$6$lambda$5(dexSource));
            return Optional.ofNullable(null);
        }
    }

    private static final Unit logger$lambda$7() {
        return Unit.INSTANCE;
    }

    static {
        Function1 function1 = SootUtils::sootClass2classFileCache$lambda$6;
        LoadingCache loadingCache = Caffeine.newBuilder().build((CacheLoader)new /* Unavailable Anonymous Inner Class!! */);
        Intrinsics.checkNotNullExpressionValue((Object)loadingCache, (String)"build(...)");
        sootClass2classFileCache = loadingCache;
        logger = KotlinLogging.INSTANCE.logger(SootUtils::logger$lambda$7);
    }
}

