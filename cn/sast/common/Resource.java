/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.common.OS
 *  cn.sast.common.Resource
 *  cn.sast.common.Resource$ExpandResKey
 *  cn.sast.common.Resource$ResourceBasic
 *  cn.sast.common.Resource$archiveSystemCache$1
 *  cn.sast.common.ResourceImplKt
 *  cn.sast.common.ResourceKt
 *  cn.sast.common.SharedZipFileCacheWrapper
 *  com.github.benmanes.caffeine.cache.CacheLoader
 *  com.github.benmanes.caffeine.cache.Caffeine
 *  com.github.benmanes.caffeine.cache.LoadingCache
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.io.ByteStreamsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jdk7.AutoCloseableKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.apache.commons.compress.archivers.zip.ZipArchiveEntry
 *  org.apache.commons.compress.archivers.zip.ZipFile
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.utbot.common.FileUtilKt
 *  soot.util.SharedCloseable
 */
package cn.sast.common;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.OS;
import cn.sast.common.Resource;
import cn.sast.common.ResourceImplKt;
import cn.sast.common.ResourceKt;
import cn.sast.common.SharedZipFileCacheWrapper;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.ProviderNotFoundException;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.spi.FileSystemProvider;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.common.FileUtilKt;
import soot.util.SharedCloseable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004_`abB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\"2\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020'J\u000e\u0010+\u001a\u00020,2\u0006\u0010.\u001a\u00020/J\u000e\u0010+\u001a\u00020,2\u0006\u0010$\u001a\u00020\u0007J\u000e\u00100\u001a\u0004\u0018\u00010'*\u00020'H\u0002J\u0012\u00104\u001a\u00020/2\n\u00105\u001a\u0006\u0012\u0002\b\u000306J\u0012\u00107\u001a\u00020,2\n\u00105\u001a\u0006\u0012\u0002\b\u000306J\u0014\u00108\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u0005H\u0002J\b\u0010<\u001a\u00020;H\u0002J\b\u0010=\u001a\u00020;H\u0002J\u000e\u0010B\u001a\u00020@2\u0006\u0010$\u001a\u00020\u0007J\u0016\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020,2\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0005J\u000e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0007J\u000e\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0005J\u000e\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0007J\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020,0\"2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013J\u000e\u0010P\u001a\u00020,2\u0006\u0010Q\u001a\u00020,J\u000e\u0010R\u001a\u00020,2\u0006\u0010S\u001a\u00020,J\u0010\u0010T\u001a\u00020(2\u0006\u0010Q\u001a\u00020,H\u0002J\u0012\u0010U\u001a\u0004\u0018\u00010,2\u0006\u0010V\u001a\u00020,H\u0002J\u0012\u0010W\u001a\u0004\u0018\u00010\u00072\u0006\u0010X\u001a\u00020,H\u0002J\u0006\u0010Y\u001a\u00020ZJ\u001e\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\"0!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010%\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&\u0012\u0004\u0012\u00020\u00070!\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u00101\u001a\u0004\u0018\u00010\u0005*\u00020'8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00103R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e\u00a2\u0006\u0002\n\u0000RP\u0010>\u001aB\u0012\f\u0012\n ?*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n ?*\u0004\u0018\u00010@0@ ?* \u0012\f\u0012\n ?*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n ?*\u0004\u0018\u00010@0@\u0018\u00010!0!X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010ARP\u0010M\u001aB\u0012\f\u0012\n ?*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n ?*\u0004\u0018\u00010\u00010\u0001 ?* \u0012\f\u0012\n ?*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n ?*\u0004\u0018\u00010\u00010\u0001\u0018\u00010N0NX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010O\u00a8\u0006c"}, d2={"Lcn/sast/common/Resource;", "", "<init>", "()V", "EXTRACT_DIR_NAME", "", "zipExtractOutputDir", "Ljava/nio/file/Path;", "getZipExtractOutputDir", "()Ljava/nio/file/Path;", "setZipExtractOutputDir", "(Ljava/nio/file/Path;)V", "newFileSystemEnv", "", "getNewFileSystemEnv", "()Ljava/util/Map;", "setNewFileSystemEnv", "(Ljava/util/Map;)V", "fileSystemEncodings", "", "getFileSystemEncodings", "()Ljava/util/List;", "setFileSystemEncodings", "(Ljava/util/List;)V", "logger", "Lmu/KLogger;", "PATH_CACHE_CAPACITY", "", "archivePathToZip", "Lcn/sast/common/SharedZipFileCacheWrapper;", "getArchivePathToZip", "()Lcn/sast/common/SharedZipFileCacheWrapper;", "archivePathToEntriesCache", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "", "getEntriesUnsafe", "path", "uriToPathCached", "Lkotlin/Pair;", "Ljava/net/URI;", "", "getUriToPathCached", "()Lcom/github/benmanes/caffeine/cache/LoadingCache;", "of", "Lcn/sast/common/IResource;", "uri", "url", "Ljava/net/URL;", "extractJarName", "entry", "getEntry", "(Ljava/net/URI;)Ljava/lang/String;", "locateClass", "clazz", "Ljava/lang/Class;", "locateAllClass", "extract", "scheme", "zipFsProvider", "Ljava/nio/file/spi/FileSystemProvider;", "getZipFsProvider", "findZipFsProvider", "archiveSystemCache", "kotlin.jvm.PlatformType", "Ljava/nio/file/FileSystem;", "Lcom/github/benmanes/caffeine/cache/LoadingCache;", "getZipFileSystem", "archivePath", "archive", "dirOf", "Lcn/sast/common/IResDirectory;", "directory", "fileOf", "Lcn/sast/common/IResFile;", "file", "multipleOf", "paths", "jarCacheBuilder", "Lcom/github/benmanes/caffeine/cache/Caffeine;", "Lcom/github/benmanes/caffeine/cache/Caffeine;", "getOriginFileFromExpandPath", "p", "getOriginFileFromExpandAbsPath", "absolute", "isUnderExtractDir", "getOriginFileFromExpandAbsolutePath", "abs", "findFileMappingInZip", "nFile", "clean", "", "extractZipToFolder", "archiveFile", "entryPrefix", "destFolder", "ExpandResKey", "ResourceBasic", "ResFileImpl", "ResDirectoryImpl", "corax-api"})
@SourceDebugExtension(value={"SMAP\nResourceImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResourceImpl.kt\ncn/sast/common/Resource\n+ 2 Resource.kt\ncn/sast/common/ResourceKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,730:1\n36#2:731\n36#2:734\n36#2:736\n1#3:732\n1#3:733\n1#3:735\n1#3:737\n1#3:747\n1368#4:738\n1454#4,5:739\n1628#4,3:744\n*S KotlinDebug\n*F\n+ 1 ResourceImpl.kt\ncn/sast/common/Resource\n*L\n152#1:731\n197#1:734\n212#1:736\n152#1:732\n197#1:735\n212#1:737\n301#1:738\n301#1:739,5\n302#1:744,3\n*E\n"})
public final class Resource {
    @NotNull
    public static final Resource INSTANCE = new Resource();
    @NotNull
    public static final String EXTRACT_DIR_NAME = "archive-extract";
    @NotNull
    private static Path zipExtractOutputDir = ResourceImplKt.getSAstTempDirectory();
    @NotNull
    private static Map<String, ? extends Object> newFileSystemEnv;
    @NotNull
    private static List<String> fileSystemEncodings;
    @NotNull
    private static final KLogger logger;
    private static final int PATH_CACHE_CAPACITY = 50000;
    @NotNull
    private static final SharedZipFileCacheWrapper archivePathToZip;
    @NotNull
    private static final LoadingCache<Path, Set<String>> archivePathToEntriesCache;
    @NotNull
    private static final LoadingCache<Pair<URI, Boolean>, Path> uriToPathCached;
    @Nullable
    private static FileSystemProvider zipFsProvider;
    private static final LoadingCache<Path, FileSystem> archiveSystemCache;
    private static final Caffeine<Object, Object> jarCacheBuilder;

    private Resource() {
    }

    @NotNull
    public final Path getZipExtractOutputDir() {
        return zipExtractOutputDir;
    }

    public final void setZipExtractOutputDir(@NotNull Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<set-?>");
        zipExtractOutputDir = path;
    }

    @NotNull
    public final Map<String, Object> getNewFileSystemEnv() {
        return newFileSystemEnv;
    }

    public final void setNewFileSystemEnv(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, (String)"<set-?>");
        newFileSystemEnv = map;
    }

    @NotNull
    public final List<String> getFileSystemEncodings() {
        return fileSystemEncodings;
    }

    public final void setFileSystemEncodings(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        fileSystemEncodings = list;
    }

    @NotNull
    public final SharedZipFileCacheWrapper getArchivePathToZip() {
        return archivePathToZip;
    }

    @NotNull
    public final Set<String> getEntriesUnsafe(@NotNull Path path) throws Exception {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Path path2 = path.toAbsolutePath();
        Intrinsics.checkNotNullExpressionValue((Object)path2, (String)"toAbsolutePath(...)");
        Object object = archivePathToEntriesCache.get((Object)path2.normalize());
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        return (Set)object;
    }

    @NotNull
    public final LoadingCache<Pair<URI, Boolean>, Path> getUriToPathCached() {
        return uriToPathCached;
    }

    @NotNull
    public final IResource of(@NotNull URI uri) {
        IResource iResource;
        Intrinsics.checkNotNullParameter((Object)uri, (String)"uri");
        if (Intrinsics.areEqual((Object)uri.getScheme(), (Object)"file")) {
            Path path = Paths.get(uri);
            Intrinsics.checkNotNullExpressionValue((Object)path, (String)"get(...)");
            iResource = (IResource)new ResourceBasic(path);
        } else {
            ResourceBasic resourceBasic;
            URI $this$isJarScheme$iv = uri;
            boolean $i$f$isJarScheme = false;
            String it$iv = $this$isJarScheme$iv.getScheme();
            boolean bl = false;
            boolean bl2 = Intrinsics.areEqual((Object)it$iv, (Object)"jar") || StringsKt.equals((String)it$iv, (String)"zip", (boolean)true);
            if (bl2) {
                String spec = uri.getSchemeSpecificPart();
                Intrinsics.checkNotNull((Object)spec);
                int sep = StringsKt.lastIndexOf$default((CharSequence)spec, (String)"!/", (int)0, (boolean)false, (int)6, null);
                if (sep == -1) {
                    throw new IllegalArgumentException("URI: " + uri + " does not contain path info ex. jar:file:/c:/foo.zip!/BAR");
                }
                String string = spec.substring(0, sep);
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"substring(...)");
                Path path = Paths.get(ResourceKt.uriOf((String)string));
                Intrinsics.checkNotNullExpressionValue((Object)path, (String)"get(...)");
                FileSystem system = this.getZipFileSystem(path);
                String string2 = spec.substring(sep + 1);
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"substring(...)");
                Path path2 = system.getPath(string2, new String[0]);
                Intrinsics.checkNotNull((Object)path2);
                resourceBasic = new ResourceBasic(path2);
            } else {
                try {
                    FileSystems.getFileSystem(uri);
                }
                catch (FileSystemNotFoundException e) {
                    ResourceImplKt.createFileSystem((URI)uri);
                }
                Path path = Paths.get(uri);
                Intrinsics.checkNotNullExpressionValue((Object)path, (String)"get(...)");
                resourceBasic = new ResourceBasic(path);
            }
            iResource = (IResource)resourceBasic;
        }
        return iResource;
    }

    @NotNull
    public final IResource of(@NotNull URL url) {
        Intrinsics.checkNotNullParameter((Object)url, (String)"url");
        URI uRI = url.toURI();
        Intrinsics.checkNotNullExpressionValue((Object)uRI, (String)"toURI(...)");
        return this.of(uRI);
    }

    @NotNull
    public final IResource of(@NotNull Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        return (IResource)new ResourceBasic(path);
    }

    private final URI extractJarName(URI $this$extractJarName) {
        URI uRI;
        String it = $this$extractJarName.getSchemeSpecificPart();
        boolean bl = false;
        Intrinsics.checkNotNull((Object)it);
        int index = StringsKt.lastIndexOf$default((CharSequence)it, (String)"!/", (int)0, (boolean)false, (int)6, null);
        if (index == -1) {
            uRI = null;
        } else {
            String string = it.substring(0, index);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"substring(...)");
            uRI = ResourceKt.uriOf((String)string);
        }
        return uRI;
    }

    private final String getEntry(URI $this$entry) {
        String string;
        String it = $this$entry.getSchemeSpecificPart();
        boolean bl = false;
        Intrinsics.checkNotNull((Object)it);
        int index = StringsKt.lastIndexOf$default((CharSequence)it, (String)"!/", (int)0, (boolean)false, (int)6, null);
        if (index == -1) {
            string = null;
        } else {
            String string2 = it.substring(index + 2, it.length());
            string = string2;
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"substring(...)");
        }
        return string;
    }

    @NotNull
    public final URL locateClass(@NotNull Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        String path = FileUtilKt.toClassFilePath(clazz);
        URL uRL = clazz.getClassLoader().getResource(path);
        if (uRL == null) {
            boolean bl = false;
            String string = "No such file: " + path;
            throw new IllegalArgumentException(string.toString());
        }
        return uRL;
    }

    @NotNull
    public final IResource locateAllClass(@NotNull Class<?> clazz) {
        IResource iResource;
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        String path = FileUtilKt.toClassFilePath(clazz);
        URL resource = this.locateClass(clazz);
        URI uRI = resource.toURI();
        Intrinsics.checkNotNullExpressionValue((Object)uRI, (String)"toURI(...)");
        URI $this$isJarScheme$iv = uRI;
        boolean $i$f$isJarScheme = false;
        String it$iv = $this$isJarScheme$iv.getScheme();
        boolean bl = false;
        boolean bl2 = Intrinsics.areEqual((Object)it$iv, (Object)"jar") || StringsKt.equals((String)it$iv, (String)"zip", (boolean)true);
        if (bl2) {
            URI uRI2 = resource.toURI();
            Intrinsics.checkNotNullExpressionValue((Object)uRI2, (String)"toURI(...)");
            URI uRI3 = this.extractJarName(uRI2);
            if (uRI3 == null) {
                throw new IllegalStateException(("internal error: resource=" + resource).toString());
            }
            URI jarLocation = uRI3;
            iResource = this.of(jarLocation);
        } else {
            String fullPath = StringsKt.removeSuffix((String)StringsKt.replace$default((String)StringsKt.replace$default((String)this.of(resource).getAbsolute().getNormalize().toString(), (String)"\\", (String)"/", (boolean)false, (int)4, null), (String)"//", (String)"/", (boolean)false, (int)4, null), (CharSequence)path);
            iResource = this.of(fullPath);
        }
        return iResource;
    }

    private final Path extract(Path $this$extract, String scheme) {
        String schemeFinal;
        String string = schemeFinal = Intrinsics.areEqual((Object)scheme, (Object)"zip") ? "jar" : scheme;
        if (Intrinsics.areEqual((Object)schemeFinal, (Object)"jar")) {
            URI uRI = $this$extract.toUri();
            Intrinsics.checkNotNullExpressionValue((Object)uRI, (String)"toUri(...)");
            URI $this$isJarScheme$iv = uRI;
            boolean $i$f$isJarScheme = false;
            String it$iv = $this$isJarScheme$iv.getScheme();
            boolean bl = false;
            boolean bl2 = Intrinsics.areEqual((Object)it$iv, (Object)"jar") || StringsKt.equals((String)it$iv, (String)"zip", (boolean)true);
            if (bl2) {
                return this.extract(this.of($this$extract).expandRes(this.dirOf(zipExtractOutputDir)).getPath(), scheme);
            }
        }
        return $this$extract;
    }

    private final FileSystemProvider getZipFsProvider() {
        FileSystemProvider result = zipFsProvider;
        if (result == null) {
            zipFsProvider = result = this.findZipFsProvider();
        }
        return result;
    }

    private final FileSystemProvider findZipFsProvider() {
        for (FileSystemProvider provider : FileSystemProvider.installedProviders()) {
            try {
                if (!Intrinsics.areEqual((Object)provider.getScheme(), (Object)"jar")) continue;
                Intrinsics.checkNotNull((Object)provider);
                return provider;
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
            }
        }
        throw new ProviderNotFoundException("Provider not found");
    }

    @NotNull
    public final FileSystem getZipFileSystem(@NotNull Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Path path2 = path.toAbsolutePath();
        Intrinsics.checkNotNullExpressionValue((Object)path2, (String)"toAbsolutePath(...)");
        Object object = archiveSystemCache.get((Object)path2.normalize());
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        return (FileSystem)object;
    }

    @NotNull
    public final Path archivePath(@NotNull Path archive, @NotNull String entry) {
        Path path;
        Intrinsics.checkNotNullParameter((Object)archive, (String)"archive");
        Intrinsics.checkNotNullParameter((Object)entry, (String)"entry");
        int index = StringsKt.indexOf$default((CharSequence)entry, (String)"!", (int)0, (boolean)false, (int)6, null);
        if (index != -1) {
            Path first = this.archivePath(archive, StringsKt.substringBefore$default((String)entry, (String)"!", null, (int)2, null));
            String string = entry.substring(index + 1);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"substring(...)");
            String end = string;
            path = this.archivePath(first, end);
        } else {
            Path path2 = StringsKt.startsWith$default((String)entry, (String)"/", (boolean)false, (int)2, null) ? this.getZipFileSystem(archive).getPath(entry, new String[0]) : this.getZipFileSystem(archive).getPath("/" + entry, new String[0]);
            Intrinsics.checkNotNull((Object)path2);
            path = path2;
        }
        return path;
    }

    @NotNull
    public final IResource of(@NotNull String path) {
        Path path2;
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        int index = StringsKt.indexOf$default((CharSequence)path, (String)"!", (int)0, (boolean)false, (int)6, null);
        if (index == -1) {
            path2 = Paths.get(path, new String[0]);
        } else {
            String string = path.substring(0, index);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"substring(...)");
            String archive = string;
            String string2 = path.substring(index + 1);
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"substring(...)");
            String entry = string2;
            Path path3 = Paths.get(archive, new String[0]);
            Intrinsics.checkNotNullExpressionValue((Object)path3, (String)"get(...)");
            path2 = this.archivePath(path3, entry);
        }
        Path p = path2;
        Intrinsics.checkNotNull((Object)p);
        return (IResource)new ResourceBasic(p);
    }

    @NotNull
    public final IResDirectory dirOf(@NotNull String directory) {
        Intrinsics.checkNotNullParameter((Object)directory, (String)"directory");
        return this.of(directory).toDirectory();
    }

    @NotNull
    public final IResDirectory dirOf(@NotNull Path directory) {
        Intrinsics.checkNotNullParameter((Object)directory, (String)"directory");
        return this.of(directory).toDirectory();
    }

    @NotNull
    public final IResFile fileOf(@NotNull String file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        return this.of(file).toFile();
    }

    @NotNull
    public final IResFile fileOf(@NotNull Path file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        return this.of(file).toFile();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Set<IResource> multipleOf(@NotNull List<String> paths) {
        void destination$iv;
        void $this$mapTo$iv;
        void $this$flatMapTo$iv$iv;
        Intrinsics.checkNotNullParameter(paths, (String)"paths");
        Iterable $this$flatMap$iv = paths;
        boolean $i$f$flatMap22 = false;
        Iterable iterable = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            List list;
            String it = (String)element$iv$iv;
            boolean bl = false;
            CharSequence charSequence = it;
            String string = File.pathSeparator;
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"pathSeparator");
            if (StringsKt.contains$default((CharSequence)charSequence, (CharSequence)string, (boolean)false, (int)2, null)) {
                String[] stringArray = new String[]{File.pathSeparator};
                list = StringsKt.split$default((CharSequence)it, (String[])stringArray, (boolean)false, (int)0, (int)6, null);
            } else {
                list = CollectionsKt.listOf((Object)it);
            }
            Iterable list$iv$iv = list;
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        List flat = (List)destination$iv$iv;
        $this$flatMap$iv = flat;
        Collection $i$f$flatMap22 = new LinkedHashSet();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            String string = (String)item$iv;
            void var13_17 = destination$iv;
            boolean bl = false;
            var13_17.add(INSTANCE.of((String)it));
        }
        return (Set)destination$iv;
    }

    @NotNull
    public final IResource getOriginFileFromExpandPath(@NotNull IResource p) {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        return this.getOriginFileFromExpandAbsPath(p.getAbsolute().getNormalize());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final IResource getOriginFileFromExpandAbsPath(@NotNull IResource absolute) {
        Intrinsics.checkNotNullParameter((Object)absolute, (String)"absolute");
        IResource it = absolute;
        boolean bl = false;
        IResource iResource = INSTANCE.getOriginFileFromExpandAbsolutePath(it);
        if (iResource == null) {
            void var2_2;
            iResource = var2_2;
        }
        return iResource;
    }

    private final boolean isUnderExtractDir(IResource p) {
        return p.isFileScheme() && StringsKt.contains$default((CharSequence)p.toString(), (CharSequence)EXTRACT_DIR_NAME, (boolean)false, (int)2, null);
    }

    private final IResource getOriginFileFromExpandAbsolutePath(IResource abs) {
        IResource schemePath;
        if (this.isUnderExtractDir(abs)) {
            Path found = this.findFileMappingInZip(abs);
            if (found != null) {
                return this.of(found);
            }
            return null;
        }
        String entry = abs.getZipEntry();
        if (entry != null && this.isUnderExtractDir(schemePath = this.of(abs.getSchemePath()))) {
            IResource iResource = this.getOriginFileFromExpandAbsolutePath(schemePath);
            return iResource != null ? iResource.resolve(entry) : null;
        }
        return null;
    }

    private final Path findFileMappingInZip(IResource nFile) {
        if (!nFile.isFileScheme()) {
            String string = "Check failed.";
            throw new IllegalStateException(string.toString());
        }
        Path p = nFile.getPath();
        for (Map.Entry entry : ((Map)ExpandResKey.Companion.getMappingUnzipDirToZip$corax_api()).entrySet()) {
            IResDirectory uncompress = (IResDirectory)entry.getKey();
            IResource fromZip = (IResource)entry.getValue();
            if (!p.startsWith(uncompress.getPath())) continue;
            try {
                Path after = p.subpath(uncompress.getPath().getNameCount(), p.getNameCount());
                return fromZip.resolve(((Object)after).toString()).getPath();
            }
            catch (Exception e) {
                logger.warn(() -> Resource.findFileMappingInZip$lambda$8(nFile, e));
            }
        }
        return null;
    }

    public final void clean() {
        ResourceBasic.Companion.getJarInnerResourceCache$corax_api().cleanUp();
        ExpandResKey.Companion.getJarTempCache$corax_api().cleanUp();
        ExpandResKey.Companion.getMappingUnzipDirToZip$corax_api().clear();
        archiveSystemCache.cleanUp();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public final Path extractZipToFolder(@NotNull Path archiveFile, @NotNull String entryPrefix, @NotNull Path destFolder) throws IOException {
        Intrinsics.checkNotNullParameter((Object)archiveFile, (String)"archiveFile");
        Intrinsics.checkNotNullParameter((Object)entryPrefix, (String)"entryPrefix");
        Intrinsics.checkNotNullParameter((Object)destFolder, (String)"destFolder");
        String entryPrefixFixed = StringsKt.removePrefix((String)entryPrefix, (CharSequence)"/");
        int errNo = 0;
        AutoCloseable autoCloseable = (AutoCloseable)archivePathToZip.getRef(archiveFile);
        Throwable throwable = null;
        try {
            SharedCloseable archiveRef = (SharedCloseable)autoCloseable;
            boolean bl = false;
            ZipFile archive = (ZipFile)archiveRef.get();
            Enumeration entries = archive.getEntries();
            Intrinsics.checkNotNull((Object)entries);
            Iterator iterator2 = CollectionsKt.iterator((Enumeration)entries);
            while (iterator2.hasNext()) {
                Object object;
                ZipArchiveEntry entry = (ZipArchiveEntry)iterator2.next();
                String string = entry.getName();
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
                String entryName = StringsKt.removePrefix((String)string, (CharSequence)"/");
                if (!StringsKt.startsWith$default((String)entryName, (String)entryPrefixFixed, (boolean)false, (int)2, null)) continue;
                if (StringsKt.indexOf$default((CharSequence)entryName, (String)"..", (int)0, (boolean)false, (int)6, null) != -1) {
                    logger.warn(() -> Resource.extractZipToFolder$lambda$14$lambda$9(archiveFile, entryName));
                    continue;
                }
                try {
                    object = destFolder.resolve(entryName);
                }
                catch (InvalidPathException e) {
                    int n = errNo;
                    errNo = n + 1;
                    if (n >= 3) continue;
                    logger.error((Throwable)e, () -> Resource.extractZipToFolder$lambda$14$lambda$10(entryName, destFolder));
                    continue;
                }
                Path destFile = object;
                if (entry.isDirectory()) {
                    Files.createDirectories(destFile, new FileAttribute[0]);
                    continue;
                }
                if (destFile.getParent() != null) {
                    Path it;
                    boolean bl2 = false;
                    LinkOption[] linkOptionArray = new LinkOption[]{};
                    if (!Files.exists(it, Arrays.copyOf(linkOptionArray, linkOptionArray.length))) {
                        Files.createDirectories(it, new FileAttribute[0]);
                    }
                }
                object = archive.getInputStream(entry);
                Throwable throwable2 = null;
                try {
                    Path path;
                    InputStream it = (InputStream)object;
                    boolean bl3 = false;
                    Intrinsics.checkNotNull((Object)it);
                    Files.write(destFile, ByteStreamsKt.readBytes((InputStream)it), new OpenOption[0]);
                    if (OS.INSTANCE.getPosixFilePermissions() != null) {
                        Set p;
                        boolean bl4 = false;
                        path = Files.setPosixFilePermissions(destFile, p);
                    } else {
                        path = null;
                    }
                    Path path2 = path;
                }
                catch (Throwable throwable3) {
                    throwable2 = throwable3;
                    throw throwable3;
                }
                finally {
                    CloseableKt.closeFinally((Closeable)object, (Throwable)throwable2);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable4) {
            throwable = throwable4;
            throw throwable4;
        }
        finally {
            AutoCloseableKt.closeFinally((AutoCloseable)autoCloseable, (Throwable)throwable);
        }
        Path path = destFolder.resolve(entryPrefix);
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"resolve(...)");
        return path;
    }

    private static final Unit logger$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final Path uriToPathCached$lambda$1(Pair args) {
        URI uri = (URI)args.component1();
        boolean getRootFsPath = (Boolean)args.component2();
        return ResourceKt.uriToPath((URI)uri, (boolean)getRootFsPath);
    }

    private static final Object findFileMappingInZip$lambda$8(IResource $nFile, Exception $e) {
        return "failed to get findFileMappingInZip of " + $nFile + ". e: " + $e.getMessage();
    }

    private static final Object extractZipToFolder$lambda$14$lambda$9(Path $archiveFile, String $entryName) {
        return "skipping bad zip entry: `" + $archiveFile + "!/" + $entryName + "`. (zip slip)";
    }

    private static final Object extractZipToFolder$lambda$14$lambda$10(String $entryName, Path $destFolder) {
        return "Illegal entry name [" + $entryName + "] in " + $destFolder;
    }

    public static final /* synthetic */ Caffeine access$getJarCacheBuilder$p() {
        return jarCacheBuilder;
    }

    public static final /* synthetic */ IResource access$getOriginFileFromExpandAbsolutePath(Resource $this, IResource abs) {
        return $this.getOriginFileFromExpandAbsolutePath(abs);
    }

    public static final /* synthetic */ String access$getEntry(Resource $this, URI $receiver) {
        return $this.getEntry($receiver);
    }

    public static final /* synthetic */ KLogger access$getLogger$p() {
        return logger;
    }

    static {
        Object[] objectArray = new Pair[]{TuplesKt.to((Object)"create", (Object)"true"), TuplesKt.to((Object)"zipinfo-time", (Object)"false")};
        newFileSystemEnv = MapsKt.mapOf((Pair[])objectArray);
        objectArray = new String[]{"UTF-8", "GBK"};
        fileSystemEncodings = CollectionsKt.listOf((Object[])objectArray);
        logger = KotlinLogging.INSTANCE.logger(Resource::logger$lambda$0);
        archivePathToZip = new SharedZipFileCacheWrapper(5, 50000);
        LoadingCache loadingCache = Caffeine.newBuilder().expireAfterAccess(Duration.ofSeconds(12L)).build((CacheLoader)new /* Unavailable Anonymous Inner Class!! */);
        Intrinsics.checkNotNullExpressionValue((Object)loadingCache, (String)"build(...)");
        archivePathToEntriesCache = loadingCache;
        Function1 function1 = Resource::uriToPathCached$lambda$1;
        LoadingCache loadingCache2 = Caffeine.newBuilder().initialCapacity(5).maximumSize(5000L).softValues().build((CacheLoader)new /* Unavailable Anonymous Inner Class!! */);
        Intrinsics.checkNotNullExpressionValue((Object)loadingCache2, (String)"build(...)");
        uriToPathCached = loadingCache2;
        archiveSystemCache = Caffeine.newBuilder().weakValues().build((CacheLoader)archiveSystemCache.1.INSTANCE);
        jarCacheBuilder = Caffeine.newBuilder().initialCapacity(4);
    }
}

