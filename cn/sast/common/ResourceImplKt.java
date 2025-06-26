/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.common.Resource
 *  cn.sast.common.ResourceImplKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IndexedValue
 *  kotlin.collections.MapsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.common;

import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.Resource;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000D\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u0012\u0010\u0011\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u0012\u0010\u0011\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u0012\u0010\u0011\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u0001\u001a\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\t2\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0001\u001a\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u0001\u001a\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u0001\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001e"}, d2={"tempDirectoryPath", "", "getTempDirectoryPath", "()Ljava/lang/String;", "sAstTempDirectory", "Ljava/nio/file/Path;", "getSAstTempDirectory", "()Ljava/nio/file/Path;", "zipExtensions", "", "getZipExtensions", "()Ljava/util/List;", "createFileSystem", "Ljava/nio/file/FileSystem;", "uri", "Ljava/net/URI;", "path", "calculate", "fis", "Ljava/io/InputStream;", "algorithm", "", "Lcn/sast/common/IResFile;", "splitGlobPath", "Lkotlin/Pair;", "Lcn/sast/common/IResource;", "p", "globPaths", "pattern", "globPath", "corax-api"})
@SourceDebugExtension(value={"SMAP\nResourceImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResourceImpl.kt\ncn/sast/common/ResourceImplKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,730:1\n1#2:731\n1557#3:732\n1628#3,3:733\n1734#3,3:736\n1557#3:739\n1628#3,3:740\n1557#3:743\n1628#3,3:744\n1368#3:747\n1454#3,5:748\n*S KotlinDebug\n*F\n+ 1 ResourceImpl.kt\ncn/sast/common/ResourceImplKt\n*L\n681#1:732\n681#1:733,3\n682#1:736,3\n694#1:739\n694#1:740,3\n696#1:743\n696#1:744,3\n697#1:747\n697#1:748,5\n*E\n"})
public final class ResourceImplKt {
    @NotNull
    private static final String tempDirectoryPath;
    @NotNull
    private static final List<String> zipExtensions;

    @NotNull
    public static final String getTempDirectoryPath() {
        return tempDirectoryPath;
    }

    @NotNull
    public static final Path getSAstTempDirectory() {
        Object object = new String[]{"0a-sast-corax-can-delete", new SimpleDateFormat("YYYY.MM.DD.HH.mm").format(System.currentTimeMillis())};
        Object it = object = Paths.get(tempDirectoryPath, (String[])object);
        boolean bl = false;
        it.toFile().mkdirs();
        Object object2 = object;
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"also(...)");
        return object2;
    }

    @NotNull
    public static final List<String> getZipExtensions() {
        return zipExtensions;
    }

    @NotNull
    public static final FileSystem createFileSystem(@NotNull URI uri) {
        Intrinsics.checkNotNullParameter((Object)uri, (String)"uri");
        Map env = MapsKt.toMutableMap((Map)Resource.INSTANCE.getNewFileSystemEnv());
        ZipException zipException = null;
        List encodings = CollectionsKt.toMutableList((Collection)Resource.INSTANCE.getFileSystemEncodings());
        if (encodings.isEmpty()) {
            encodings.add("UTF-8");
        }
        for (IndexedValue encodingI : CollectionsKt.withIndex((Iterable)encodings)) {
            String encoding = (String)encodingI.getValue();
            env.put("encoding", encoding);
            try {
                FileSystem fileSystem = FileSystems.newFileSystem(uri, env);
                Intrinsics.checkNotNullExpressionValue((Object)fileSystem, (String)"newFileSystem(...)");
                return fileSystem;
            }
            catch (ZipException e) {
                zipException = e;
            }
        }
        ZipException zipException2 = zipException;
        Intrinsics.checkNotNull(zipException2);
        throw zipException2;
    }

    @NotNull
    public static final FileSystem createFileSystem(@NotNull Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Map env = MapsKt.toMutableMap((Map)Resource.INSTANCE.getNewFileSystemEnv());
        ZipException zipException = null;
        List encodings = CollectionsKt.toMutableList((Collection)Resource.INSTANCE.getFileSystemEncodings());
        if (encodings.isEmpty()) {
            encodings.add("UTF-8");
        }
        for (IndexedValue encodingI : CollectionsKt.withIndex((Iterable)encodings)) {
            String encoding = (String)encodingI.getValue();
            env.put("encoding", encoding);
            try {
                FileSystem fileSystem = FileSystems.newFileSystem((Path)path, (Map)env);
                Intrinsics.checkNotNullExpressionValue((Object)fileSystem, (String)"newFileSystem(...)");
                return fileSystem;
            }
            catch (ZipException e) {
                zipException = e;
            }
        }
        ZipException zipException2 = zipException;
        Intrinsics.checkNotNull(zipException2);
        throw zipException2;
    }

    @NotNull
    public static final String calculate(@NotNull InputStream fis, @NotNull String algorithm) {
        Intrinsics.checkNotNullParameter((Object)fis, (String)"fis");
        Intrinsics.checkNotNullParameter((Object)algorithm, (String)"algorithm");
        byte[] buffer = new byte[8192];
        int bytesRead = 0;
        MessageDigest md = MessageDigest.getInstance(algorithm);
        while (true) {
            int n;
            int it = n = fis.read(buffer);
            boolean bl = false;
            bytesRead = it;
            if (n == -1) break;
            md.update(buffer, 0, bytesRead);
        }
        byte[] byArray = md.digest();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"digest(...)");
        return ArraysKt.joinToString$default((byte[])byArray, (CharSequence)"", null, null, (int)0, null, ResourceImplKt::calculate$lambda$2, (int)30, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public static final String calculate(@NotNull byte[] $this$calculate, @NotNull String algorithm) {
        String string;
        Intrinsics.checkNotNullParameter((Object)$this$calculate, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)algorithm, (String)"algorithm");
        Closeable closeable = new ByteArrayInputStream($this$calculate);
        Throwable throwable = null;
        try {
            ByteArrayInputStream it = (ByteArrayInputStream)closeable;
            boolean bl = false;
            string = ResourceImplKt.calculate((InputStream)it, (String)algorithm);
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public static final String calculate(@NotNull Path $this$calculate, @NotNull String algorithm) {
        String string;
        Intrinsics.checkNotNullParameter((Object)$this$calculate, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)algorithm, (String)"algorithm");
        OpenOption[] openOptionArray = new OpenOption[]{};
        InputStream inputStream = Files.newInputStream($this$calculate, Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"newInputStream(...)");
        Closeable closeable = inputStream;
        Throwable throwable = null;
        try {
            InputStream fis = (InputStream)closeable;
            boolean bl = false;
            string = ResourceImplKt.calculate((InputStream)fis, (String)algorithm);
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
        return string;
    }

    @NotNull
    public static final String calculate(@NotNull IResFile $this$calculate, @NotNull String algorithm) {
        Intrinsics.checkNotNullParameter((Object)$this$calculate, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)algorithm, (String)"algorithm");
        return ResourceImplKt.calculate((Path)$this$calculate.getPath(), (String)algorithm);
    }

    @NotNull
    public static final Pair<IResource, String> splitGlobPath(@NotNull String p) {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        String cur = null;
        cur = StringsKt.replace$default((String)StringsKt.replace$default((String)p, (String)"\\", (String)"/", (boolean)false, (int)4, null), (String)"//", (String)"/", (boolean)false, (int)4, null);
        List glob = new ArrayList();
        while (true) {
            Object $i$a$-runCatching-ResourceImplKt$splitGlobPath$22;
            try {
                boolean $i$a$-runCatching-ResourceImplKt$splitGlobPath$22 = false;
                IResource r = Resource.INSTANCE.of(cur);
                if (r.getExists()) {
                    if (glob.isEmpty()) {
                        return TuplesKt.to((Object)r, null);
                    }
                    return TuplesKt.to((Object)r, (Object)CollectionsKt.joinToString$default((Iterable)glob, (CharSequence)"/", null, null, (int)0, null, null, (int)62, null));
                }
                $i$a$-runCatching-ResourceImplKt$splitGlobPath$22 = Result.constructor-impl((Object)Unit.INSTANCE);
            }
            catch (Throwable throwable) {
                $i$a$-runCatching-ResourceImplKt$splitGlobPath$22 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
            if (Intrinsics.areEqual((Object)cur, (Object)"./")) break;
            int index = StringsKt.lastIndexOf$default((CharSequence)cur, (String)"/", (int)0, (boolean)false, (int)6, null);
            if (index == -1) {
                glob.add(0, cur);
                cur = "./";
                continue;
            }
            String string = cur.substring(index + 1);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"substring(...)");
            glob.add(0, string);
            Intrinsics.checkNotNullExpressionValue((Object)cur.substring(0, index), (String)"substring(...)");
        }
        throw new IllegalStateException(("\"" + p + "\" is a invalid path").toString());
    }

    @NotNull
    public static final List<IResource> globPaths(@NotNull IResource path, @NotNull String pattern) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter((Object)pattern, (String)"pattern");
        PathMatcher pathMatcher = path.getPath().getFileSystem().getPathMatcher("glob:" + pattern);
        List r = new ArrayList();
        Path p = path.getPath().normalize();
        Files.walkFileTree(p, (FileVisitor)new /* Unavailable Anonymous Inner Class!! */);
        return r;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final List<IResource> globPaths(@NotNull String p) {
        boolean bl;
        List r;
        Object object;
        block5: {
            Iterator $this$mapTo$iv$iv;
            Intrinsics.checkNotNullParameter((Object)p, (String)"p");
            object = new String[]{File.pathSeparator};
            Iterable $this$map$iv = StringsKt.split$default((CharSequence)p, (String[])object, (boolean)false, (int)0, (int)6, null);
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            Iterator iterator2 = $this$mapTo$iv$iv.iterator();
            while (iterator2.hasNext()) {
                void it;
                Object item$iv$iv = iterator2.next();
                String string = (String)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add(ResourceImplKt.globPath((String)it));
            }
            r = (List)destination$iv$iv;
            Iterable $this$all$iv = r;
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    List it = (List)element$iv;
                    boolean bl3 = false;
                    if (it == null) continue;
                    bl = false;
                    break block5;
                }
                bl = true;
            }
        }
        if (bl) {
            return null;
        }
        Object it = object = CollectionsKt.flatten((Iterable)CollectionsKt.filterNotNull((Iterable)r));
        boolean bl4 = false;
        return !((Collection)it).isEmpty() ? object : null;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final List<IResource> globPath(@NotNull String p) {
        List list;
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        File file = new File(p);
        if (!file.exists()) {
            boolean bl = false;
            String[] stringArray = new String[]{"!"};
            List parts = StringsKt.split$default((CharSequence)p, (String[])stringArray, (boolean)false, (int)0, (int)6, null);
            List collect = new ArrayList();
            boolean first = true;
            for (String part : parts) {
                void $this$flatMapTo$iv$iv;
                void $this$mapTo$iv$iv;
                Iterable iterable;
                Iterator item$iv$iv2;
                Iterable destination$iv$iv;
                List list2;
                if (first) {
                    list2 = CollectionsKt.listOf((Object)part);
                } else {
                    void $this$mapTo$iv$iv2;
                    Iterable $this$map$iv = collect;
                    boolean $i$f$map = false;
                    Iterable iterable2 = $this$map$iv;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                    boolean $i$f$mapTo = false;
                    for (Iterator item$iv$iv2 : $this$mapTo$iv$iv2) {
                        void it;
                        IResource iResource = (IResource)item$iv$iv2;
                        iterable = destination$iv$iv;
                        boolean bl2 = false;
                        iterable.add((IResource)it + "!" + part);
                    }
                    list2 = (List)destination$iv$iv;
                }
                List walkFiles = list2;
                first = false;
                Iterable $this$map$iv = walkFiles;
                boolean $i$f$map = false;
                destination$iv$iv = $this$map$iv;
                Iterable destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                boolean $i$f$mapTo = false;
                item$iv$iv2 = $this$mapTo$iv$iv.iterator();
                while (item$iv$iv2.hasNext()) {
                    void it;
                    Object item$iv$iv3 = item$iv$iv2.next();
                    String bl2 = (String)item$iv$iv3;
                    iterable = destination$iv$iv2;
                    boolean bl3 = false;
                    iterable.add(ResourceImplKt.splitGlobPath((String)it));
                }
                List splitFileAndGlob = (List)destination$iv$iv2;
                Iterable $this$flatMap$iv = splitFileAndGlob;
                boolean $i$f$flatMap = false;
                destination$iv$iv2 = $this$flatMap$iv;
                Collection destination$iv$iv3 = new ArrayList();
                boolean $i$f$flatMapTo = false;
                for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                    Pair o = (Pair)element$iv$iv;
                    boolean bl4 = false;
                    String g2 = (String)o.getSecond();
                    Iterable list$iv$iv = g2 == null ? CollectionsKt.listOf((Object)o.getFirst()) : ResourceImplKt.globPaths((IResource)((IResource)o.getFirst()), (String)g2);
                    CollectionsKt.addAll((Collection)destination$iv$iv3, (Iterable)list$iv$iv);
                }
                List matchedFiles = (List)destination$iv$iv3;
                collect = CollectionsKt.toMutableList((Collection)matchedFiles);
            }
            if (!collect.isEmpty()) {
                return collect;
            }
            list = null;
        } else {
            list = CollectionsKt.listOf((Object)Resource.INSTANCE.of(p));
        }
        return list;
    }

    private static final CharSequence calculate$lambda$2(byte it) {
        String string = "%02x";
        Object[] objectArray = new Object[]{it};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
        return string2;
    }

    static {
        String string = System.getProperty("java.io.tmpdir");
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getProperty(...)");
        tempDirectoryPath = string;
        Object[] objectArray = new String[]{"zip", "jar", "war", "apk", "aar"};
        zipExtensions = CollectionsKt.listOf((Object[])objectArray);
    }
}

