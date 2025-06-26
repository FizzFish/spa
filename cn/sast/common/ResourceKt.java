/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResFile
 *  cn.sast.common.Resource
 *  cn.sast.common.ResourceImplKt
 *  cn.sast.common.ResourceKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.io.CloseableKt
 *  kotlin.io.FilesKt
 *  kotlin.io.TextStreamsKt
 *  kotlin.io.path.PathsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.common;

import cn.sast.common.IResFile;
import cn.sast.common.Resource;
import cn.sast.common.ResourceImplKt;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.io.path.PathsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000h\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u001a>\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u0018*\u00020\u00142'\u0010\u0019\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\u001b\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u0002H\u00180\u001a\u00a2\u0006\u0002\u0010\u001f\u001a\n\u0010 \u001a\u00020!*\u00020\u0014\u001a\u001c\u0010\"\u001a\u00020#*\u00020\u00142\u0006\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u001a\u000e\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u0001\u001a\u0018\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\n\u001a$\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020#00\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0016\u0010\u000e\u001a\u00020\n*\u00020\u000f8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010\"\u0016\u0010\u0011\u001a\u00020\n*\u00020\u000f8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010\"\u0016\u0010\u0012\u001a\u00020\n*\u00020\u000f8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010\"\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010%X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020'X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2={"text", "", "Ljava/net/URL;", "getText", "(Ljava/net/URL;)Ljava/lang/String;", "javaExtensions", "", "getJavaExtensions", "()Ljava/util/List;", "zipLike", "", "Ljava/nio/file/Path;", "getZipLike", "(Ljava/nio/file/Path;)Z", "isJarScheme", "Ljava/net/URI;", "(Ljava/net/URI;)Z", "isFileScheme", "isJrtScheme", "readText", "Lcn/sast/common/IResFile;", "charset", "Ljava/nio/charset/Charset;", "lineSequence", "T", "apply", "Lkotlin/Function1;", "Lkotlin/sequences/Sequence;", "Lkotlin/ParameterName;", "name", "seq", "(Lcn/sast/common/IResFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "readAllBytes", "", "writeText", "", "escapes", "", "urlEscapePattern", "Ljava/util/regex/Pattern;", "uriOf", "uri", "uriToPath", "getRootFsPath", "findCacheFromDeskOrCreate", "input", "output", "creator", "Lkotlin/Function0;", "corax-api"})
@SourceDebugExtension(value={"SMAP\nResource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Resource.kt\ncn/sast/common/ResourceKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n37#1:179\n38#1:180\n1#2:178\n*S KotlinDebug\n*F\n+ 1 Resource.kt\ncn/sast/common/ResourceKt\n*L\n142#1:179\n146#1:180\n*E\n"})
public final class ResourceKt {
    @NotNull
    private static final List<String> javaExtensions;
    @NotNull
    private static final Map<String, String> escapes;
    @NotNull
    private static final Pattern urlEscapePattern;

    @NotNull
    public static final String getText(@NotNull URL $this$text) {
        Intrinsics.checkNotNullParameter((Object)$this$text, (String)"<this>");
        URL uRL = $this$text;
        Charset charset = Charsets.UTF_8;
        byte[] byArray = TextStreamsKt.readBytes((URL)uRL);
        return new String(byArray, charset);
    }

    @NotNull
    public static final List<String> getJavaExtensions() {
        return javaExtensions;
    }

    public static final boolean getZipLike(@NotNull Path $this$zipLike) {
        Intrinsics.checkNotNullParameter((Object)$this$zipLike, (String)"<this>");
        return ResourceImplKt.getZipExtensions().contains(PathsKt.getExtension((Path)$this$zipLike));
    }

    public static final boolean isJarScheme(@NotNull URI $this$isJarScheme) {
        Intrinsics.checkNotNullParameter((Object)$this$isJarScheme, (String)"<this>");
        boolean $i$f$isJarScheme = false;
        String it = $this$isJarScheme.getScheme();
        boolean bl = false;
        return Intrinsics.areEqual((Object)it, (Object)"jar") || StringsKt.equals((String)it, (String)"zip", (boolean)true);
    }

    public static final boolean isFileScheme(@NotNull URI $this$isFileScheme) {
        Intrinsics.checkNotNullParameter((Object)$this$isFileScheme, (String)"<this>");
        boolean $i$f$isFileScheme = false;
        return Intrinsics.areEqual((Object)$this$isFileScheme.getScheme(), (Object)"file");
    }

    public static final boolean isJrtScheme(@NotNull URI $this$isJrtScheme) {
        Intrinsics.checkNotNullParameter((Object)$this$isJrtScheme, (String)"<this>");
        boolean $i$f$isJrtScheme = false;
        return Intrinsics.areEqual((Object)$this$isJrtScheme.getScheme(), (Object)"jrt");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public static final String readText(@NotNull IResFile $this$readText, @NotNull Charset charset) throws IOException {
        String string;
        Intrinsics.checkNotNullParameter((Object)$this$readText, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        Object object = $this$readText.getPath();
        Object object2 = new OpenOption[]{};
        object = new InputStreamReader(Files.newInputStream((Path)object, Arrays.copyOf(object2, ((OpenOption[])object2).length)), charset);
        object2 = null;
        try {
            InputStreamReader rd = (InputStreamReader)object;
            boolean bl = false;
            string = TextStreamsKt.readText((Reader)rd);
        }
        catch (Throwable throwable) {
            object2 = throwable;
            throw throwable;
        }
        finally {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        }
        return string;
    }

    public static /* synthetic */ String readText$default(IResFile iResFile, Charset charset, int n, Object object) throws IOException {
        if ((n & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return ResourceKt.readText((IResFile)iResFile, (Charset)charset);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final <T> T lineSequence(@NotNull IResFile $this$lineSequence, @NotNull Function1<? super Sequence<String>, ? extends T> apply) throws IOException {
        Object object;
        Intrinsics.checkNotNullParameter((Object)$this$lineSequence, (String)"<this>");
        Intrinsics.checkNotNullParameter(apply, (String)"apply");
        Object object2 = $this$lineSequence.getPath();
        OpenOption[] openOptionArray = new OpenOption[]{};
        Object object3 = Charsets.UTF_8;
        int n = 8192;
        object2 = new BufferedReader(new InputStreamReader(Files.newInputStream((Path)object2, Arrays.copyOf(openOptionArray, openOptionArray.length)), (Charset)object3), n);
        object3 = null;
        try {
            BufferedReader it = (BufferedReader)object2;
            boolean bl = false;
            object = apply.invoke((Object)TextStreamsKt.lineSequence((BufferedReader)it));
        }
        catch (Throwable throwable) {
            object3 = throwable;
            throw throwable;
        }
        finally {
            CloseableKt.closeFinally((Closeable)object2, (Throwable)object3);
        }
        return (T)object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public static final byte[] readAllBytes(@NotNull IResFile $this$readAllBytes) throws IOException {
        byte[] byArray;
        Intrinsics.checkNotNullParameter((Object)$this$readAllBytes, (String)"<this>");
        OpenOption[] openOptionArray = new OpenOption[]{};
        InputStream inputStream = Files.newInputStream($this$readAllBytes.getPath(), Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"newInputStream(...)");
        Closeable closeable = inputStream;
        Throwable throwable = null;
        try {
            InputStream it = (InputStream)closeable;
            boolean bl = false;
            byArray = it.readAllBytes();
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"use(...)");
        return byArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void writeText(@NotNull IResFile $this$writeText, @NotNull String text2, @NotNull Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter((Object)$this$writeText, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)text2, (String)"text");
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        Object object = $this$writeText.getPath();
        Object object2 = new OpenOption[]{};
        object = new OutputStreamWriter(Files.newOutputStream((Path)object, Arrays.copyOf(object2, ((OpenOption[])object2).length)), charset);
        object2 = null;
        try {
            OutputStreamWriter it = (OutputStreamWriter)object;
            boolean bl = false;
            it.write(text2);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            object2 = throwable;
            throw throwable;
        }
        finally {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        }
    }

    public static /* synthetic */ void writeText$default(IResFile iResFile, String string, Charset charset, int n, Object object) throws IOException {
        if ((n & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        ResourceKt.writeText((IResFile)iResFile, (String)string, (Charset)charset);
    }

    @NotNull
    public static final URI uriOf(@NotNull String uri) {
        Intrinsics.checkNotNullParameter((Object)uri, (String)"uri");
        Matcher matcher = urlEscapePattern.matcher(uri);
        Intrinsics.checkNotNullExpressionValue((Object)matcher, (String)"matcher(...)");
        Matcher m = matcher;
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, (String)escapes.get(m.group(1)));
        }
        m.appendTail(sb);
        String escaped = new URI(sb.toString()).toASCIIString();
        return new URI(escaped);
    }

    @NotNull
    public static final Path uriToPath(@NotNull URI uri, boolean getRootFsPath) {
        Path path;
        Intrinsics.checkNotNullParameter((Object)uri, (String)"uri");
        URI $this$isFileScheme$iv = uri;
        boolean $i$f$isFileScheme2 = false;
        if (Intrinsics.areEqual((Object)$this$isFileScheme$iv.getScheme(), (Object)"file")) {
            if (!(!getRootFsPath)) {
                String $i$f$isFileScheme2 = "Check failed.";
                throw new IllegalStateException($i$f$isFileScheme2.toString());
            }
            Path path2 = Paths.get(uri);
            Intrinsics.checkNotNullExpressionValue((Object)path2, (String)"get(...)");
            return path2;
        }
        URI $this$isJrtScheme$iv = uri;
        boolean $i$f$isJrtScheme = false;
        if (!(!Intrinsics.areEqual((Object)$this$isJrtScheme$iv.getScheme(), (Object)"jrt"))) {
            boolean $i$a$-check-ResourceKt$uriToPath$22 = false;
            String $i$a$-check-ResourceKt$uriToPath$22 = "unsupported uri: " + uri + " with a JRT scheme.";
            throw new IllegalStateException($i$a$-check-ResourceKt$uriToPath$22.toString());
        }
        String spec = uri.getSchemeSpecificPart();
        Intrinsics.checkNotNull((Object)spec);
        int sep = StringsKt.lastIndexOf$default((CharSequence)spec, (String)"!/", (int)0, (boolean)false, (int)6, null);
        if (sep != -1) {
            String string = spec.substring(0, sep);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"substring(...)");
            String zipPath = string;
            String string2 = spec.substring(sep + 1);
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"substring(...)");
            String entry = string2;
            Path archive = ResourceKt.uriToPath$default((URI)ResourceKt.uriOf((String)zipPath), (boolean)false, (int)2, null);
            if (getRootFsPath) {
                return archive;
            }
            Path path3 = Resource.INSTANCE.getZipFileSystem(archive).getPath(entry, new String[0]);
            Intrinsics.checkNotNull((Object)path3);
            path = path3;
        } else {
            if (!(!getRootFsPath)) {
                String string = "Check failed.";
                throw new IllegalStateException(string.toString());
            }
            Path path4 = Paths.get(ResourceKt.uriOf((String)spec));
            Intrinsics.checkNotNull((Object)path4);
            path = path4;
        }
        return path;
    }

    public static /* synthetic */ Path uriToPath$default(URI uRI, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return ResourceKt.uriToPath((URI)uRI, (boolean)bl);
    }

    @NotNull
    public static final Path findCacheFromDeskOrCreate(@NotNull Path input, @NotNull Path output, @NotNull Function0<Unit> creator) {
        Intrinsics.checkNotNullParameter((Object)input, (String)"input");
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter(creator, (String)"creator");
        String md5 = Resource.INSTANCE.fileOf(input).getMd5();
        Path path = output.toAbsolutePath();
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"toAbsolutePath(...)");
        Path normal = path;
        Comparable<Path> comparable = normal.getParent();
        if (comparable == null || (comparable = comparable.resolve("." + StringsKt.substringBeforeLast$default((String)PathsKt.getName((Path)output), (String)".", null, (int)2, null) + ".successful")) == null || (comparable = comparable.toFile()) == null) {
            throw new IllegalStateException(("bad output paths: " + output).toString());
        }
        Comparable<Path> flag = comparable;
        if (((File)flag).exists() && Intrinsics.areEqual((Object)md5, (Object)FilesKt.readText$default(flag, null, (int)1, null))) {
            LinkOption[] linkOptionArray = new LinkOption[]{};
            if (Files.exists(output, Arrays.copyOf(linkOptionArray, linkOptionArray.length))) {
                return output;
            }
        } else {
            Files.deleteIfExists(output);
        }
        creator.invoke();
        FilesKt.writeText$default(flag, (String)md5, null, (int)2, null);
        return output;
    }

    static {
        Object[] objectArray = new String[]{"java", "kt", "kts", "scala", "groovy", "jsp"};
        javaExtensions = CollectionsKt.listOf((Object[])objectArray);
        objectArray = new Pair[]{TuplesKt.to((Object)"[", (Object)"%5B"), TuplesKt.to((Object)"]", (Object)"%5D"), TuplesKt.to((Object)"{", (Object)"%7B"), TuplesKt.to((Object)"}", (Object)"%7D"), TuplesKt.to((Object)"<", (Object)"%3C"), TuplesKt.to((Object)">", (Object)"%3E"), TuplesKt.to((Object)"#", (Object)"%23"), TuplesKt.to((Object)"?", (Object)"%3F"), TuplesKt.to((Object)"@", (Object)"%40"), TuplesKt.to((Object)" ", (Object)"%20")};
        escapes = MapsKt.mapOf((Pair[])objectArray);
        Pattern pattern = Pattern.compile("([\\[\\]{}<>#?@ ])");
        Intrinsics.checkNotNullExpressionValue((Object)pattern, (String)"compile(...)");
        urlEscapePattern = pattern;
    }
}

