/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.JarMerger
 *  cn.sast.common.JarMerger$Companion
 *  cn.sast.common.JarMerger$Relocator
 *  cn.sast.common.JarMerger$Transformer
 *  com.google.common.collect.ImmutableSortedMap
 *  com.google.common.collect.ImmutableSortedMap$Builder
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.apache.commons.compress.archivers.ArchiveEntry
 *  org.apache.commons.compress.archivers.jar.JarArchiveEntry
 *  org.apache.commons.compress.archivers.jar.JarArchiveInputStream
 *  org.apache.commons.compress.archivers.jar.JarArchiveOutputStream
 *  org.apache.commons.compress.archivers.zip.ZipArchiveEntry
 *  org.apache.commons.compress.archivers.zip.ZipMethod
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.common;

import cn.sast.common.JarMerger;
import com.google.common.collect.ImmutableSortedMap;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.jar.JarArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipMethod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0003'()B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0003J:\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J.\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00032\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0016\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0003J\u0016\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0010H\u0016J\u001a\u0010\u001f\u001a\u00020\u00102\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060!J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001dH\u0002J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2={"Lcn/sast/common/JarMerger;", "Ljava/io/Closeable;", "jarFile", "Ljava/nio/file/Path;", "filter", "Ljava/util/function/Predicate;", "", "<init>", "(Ljava/nio/file/Path;Ljava/util/function/Predicate;)V", "buffer", "", "jarOutputStream", "Lorg/apache/commons/compress/archivers/jar/JarArchiveOutputStream;", "toSystemIndependentPath", "path", "addDirectory", "", "directory", "filterOverride", "transformer", "Lcn/sast/common/JarMerger$Transformer;", "relocator", "Lcn/sast/common/JarMerger$Relocator;", "addJar", "file", "addFile", "entryPath", "addEntry", "input", "Ljava/io/InputStream;", "close", "setManifestProperties", "properties", "", "write", "entry", "Lorg/apache/commons/compress/archivers/jar/JarArchiveEntry;", "from", "setEntryAttributes", "Transformer", "Relocator", "Companion", "corax-api"})
@SourceDebugExtension(value={"SMAP\nJarMerger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JarMerger.kt\ncn/sast/common/JarMerger\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,200:1\n1#2:201\n216#3,2:202\n*S KotlinDebug\n*F\n+ 1 JarMerger.kt\ncn/sast/common/JarMerger\n*L\n148#1:202,2\n*E\n"})
public final class JarMerger
implements Closeable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Predicate<String> filter;
    @NotNull
    private final byte[] buffer;
    @NotNull
    private final JarArchiveOutputStream jarOutputStream;
    @NotNull
    private static final FileTime fileTime;

    @JvmOverloads
    public JarMerger(@NotNull Path jarFile, @Nullable Predicate<String> filter2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)jarFile, (String)"jarFile");
        this.filter = filter2;
        this.buffer = new byte[8192];
        Files.createDirectories(jarFile.getParent(), new FileAttribute[0]);
        this.jarOutputStream = new JarArchiveOutputStream((OutputStream)new BufferedOutputStream(Files.newOutputStream(jarFile, new OpenOption[0])));
    }

    public /* synthetic */ JarMerger(Path path, Predicate predicate, int n, DefaultConstructorMarker defaultConstructorMarker) throws IOException {
        if ((n & 2) != 0) {
            predicate = null;
        }
        this(path, predicate);
    }

    @NotNull
    public final String toSystemIndependentPath(@NotNull Path path) {
        String string;
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        String filePath = ((Object)path).toString();
        if (!Intrinsics.areEqual((Object)path.getFileSystem().getSeparator(), (Object)"/")) {
            String string2 = path.getFileSystem().getSeparator();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getSeparator(...)");
            string = StringsKt.replace$default((String)filePath, (String)string2, (String)"/", (boolean)false, (int)4, null);
        } else {
            string = filePath;
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @JvmOverloads
    public final void addDirectory(@NotNull Path directory, @Nullable Predicate<String> filterOverride, @Nullable Transformer transformer, @Nullable Relocator relocator) throws IOException {
        Intrinsics.checkNotNullParameter((Object)directory, (String)"directory");
        ImmutableSortedMap.Builder candidateFiles = ImmutableSortedMap.naturalOrder();
        Files.walkFileTree(directory, (FileVisitor)new /* Unavailable Anonymous Inner Class!! */);
        ImmutableSortedMap sortedFiles = candidateFiles.build();
        Intrinsics.checkNotNull((Object)sortedFiles);
        for (Map.Entry entry : ((Map)sortedFiles).entrySet()) {
            String entryPath = (String)entry.getKey();
            Path value = (Path)entry.getValue();
            Closeable closeable = new BufferedInputStream(Files.newInputStream(value, new OpenOption[0]));
            Throwable throwable = null;
            try {
                BufferedInputStream is = (BufferedInputStream)closeable;
                boolean bl = false;
                if (transformer != null) {
                    Intrinsics.checkNotNull((Object)entryPath);
                    InputStream is2 = transformer.filter(entryPath, (InputStream)is);
                    if (is2 != null) {
                        this.write(new JarArchiveEntry(entryPath), is2);
                    }
                } else {
                    this.write(new JarArchiveEntry(entryPath), (InputStream)is);
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
        }
    }

    public static /* synthetic */ void addDirectory$default(JarMerger jarMerger, Path path, Predicate predicate, Transformer transformer, Relocator relocator, int n, Object object) throws IOException {
        if ((n & 2) != 0) {
            predicate = jarMerger.filter;
        }
        if ((n & 4) != 0) {
            transformer = null;
        }
        if ((n & 8) != 0) {
            relocator = null;
        }
        jarMerger.addDirectory(path, predicate, transformer, relocator);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @JvmOverloads
    public final void addJar(@NotNull Path file, @Nullable Predicate<String> filterOverride, @Nullable Relocator relocator) throws IOException {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        Closeable closeable = (Closeable)new JarArchiveInputStream(Files.newInputStream(file, new OpenOption[0]));
        Throwable throwable = null;
        try {
            JarArchiveInputStream zis = (JarArchiveInputStream)closeable;
            boolean bl = false;
            while (zis.getNextZipEntry() != null) {
                ZipArchiveEntry entry;
                if (entry.isDirectory()) continue;
                String name = entry.getName();
                if (filterOverride != null && !filterOverride.test(name)) continue;
                if (relocator != null) {
                    String string = name;
                    Intrinsics.checkNotNull((Object)string);
                    name = relocator.relocate(string);
                }
                JarArchiveEntry newEntry = new JarArchiveEntry(name);
                newEntry.setMethod(entry.getMethod());
                if (newEntry.getMethod() == ZipMethod.STORED.getCode()) {
                    newEntry.setSize(entry.getSize());
                    newEntry.setCompressedSize(entry.getCompressedSize());
                    newEntry.setCrc(entry.getCrc());
                }
                newEntry.setLastModifiedTime(FileTime.fromMillis(0L));
                this.write(newEntry, (InputStream)zis);
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
    }

    public static /* synthetic */ void addJar$default(JarMerger jarMerger, Path path, Predicate predicate, Relocator relocator, int n, Object object) throws IOException {
        if ((n & 2) != 0) {
            predicate = jarMerger.filter;
        }
        if ((n & 4) != 0) {
            relocator = null;
        }
        jarMerger.addJar(path, predicate, relocator);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void addFile(@NotNull String entryPath, @NotNull Path file) throws IOException {
        Intrinsics.checkNotNullParameter((Object)entryPath, (String)"entryPath");
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        Closeable closeable = new BufferedInputStream(Files.newInputStream(file, new OpenOption[0]));
        Throwable throwable = null;
        try {
            BufferedInputStream is = (BufferedInputStream)closeable;
            boolean bl = false;
            this.write(new JarArchiveEntry(entryPath), (InputStream)is);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void addEntry(@NotNull String entryPath, @NotNull InputStream input) throws IOException {
        Intrinsics.checkNotNullParameter((Object)entryPath, (String)"entryPath");
        Intrinsics.checkNotNullParameter((Object)input, (String)"input");
        Closeable closeable = new BufferedInputStream(input);
        Throwable throwable = null;
        try {
            BufferedInputStream is = (BufferedInputStream)closeable;
            boolean bl = false;
            this.write(new JarArchiveEntry(entryPath), (InputStream)is);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
    }

    @Override
    public void close() throws IOException {
        this.jarOutputStream.close();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void setManifestProperties(@NotNull Map<String, String> properties) throws IOException {
        Intrinsics.checkNotNullParameter(properties, (String)"properties");
        Manifest manifest = new Manifest();
        Attributes global = manifest.getMainAttributes();
        Intrinsics.checkNotNull((Object)global);
        ((Map)global).put(Attributes.Name.MANIFEST_VERSION, "1.0.0");
        Map<String, String> $this$forEach$iv = properties;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<String, String>> iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, String> element$iv;
            Map.Entry<String, String> entry = element$iv = iterator2.next();
            boolean bl = false;
            String attributeName = entry.getKey();
            String attributeValue = entry.getValue();
            ((Map)global).put(new Attributes.Name(attributeName), attributeValue);
        }
        JarArchiveEntry manifestEntry = new JarArchiveEntry("META-INF/MANIFEST.MF");
        this.setEntryAttributes(manifestEntry);
        this.jarOutputStream.putArchiveEntry((ArchiveEntry)manifestEntry);
        try {
            manifest.write((OutputStream)this.jarOutputStream);
        }
        finally {
            this.jarOutputStream.closeArchiveEntry();
        }
    }

    private final void write(JarArchiveEntry entry, InputStream from) throws IOException {
        int count;
        this.setEntryAttributes(entry);
        this.jarOutputStream.putArchiveEntry((ArchiveEntry)entry);
        while ((count = from.read(this.buffer)) != -1) {
            this.jarOutputStream.write(this.buffer, 0, count);
        }
        this.jarOutputStream.closeArchiveEntry();
    }

    private final void setEntryAttributes(JarArchiveEntry entry) {
        entry.setLastModifiedTime(fileTime);
        entry.setLastAccessTime(fileTime);
        entry.setCreationTime(fileTime);
    }

    @JvmOverloads
    public JarMerger(@NotNull Path jarFile) throws IOException {
        Intrinsics.checkNotNullParameter((Object)jarFile, (String)"jarFile");
        this(jarFile, null, 2, null);
    }

    @JvmOverloads
    public final void addDirectory(@NotNull Path directory, @Nullable Predicate<String> filterOverride, @Nullable Transformer transformer) throws IOException {
        Intrinsics.checkNotNullParameter((Object)directory, (String)"directory");
        JarMerger.addDirectory$default((JarMerger)this, (Path)directory, filterOverride, (Transformer)transformer, null, (int)8, null);
    }

    @JvmOverloads
    public final void addDirectory(@NotNull Path directory, @Nullable Predicate<String> filterOverride) throws IOException {
        Intrinsics.checkNotNullParameter((Object)directory, (String)"directory");
        JarMerger.addDirectory$default((JarMerger)this, (Path)directory, filterOverride, null, null, (int)12, null);
    }

    @JvmOverloads
    public final void addDirectory(@NotNull Path directory) throws IOException {
        Intrinsics.checkNotNullParameter((Object)directory, (String)"directory");
        JarMerger.addDirectory$default((JarMerger)this, (Path)directory, null, null, null, (int)14, null);
    }

    @JvmOverloads
    public final void addJar(@NotNull Path file, @Nullable Predicate<String> filterOverride) throws IOException {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        JarMerger.addJar$default((JarMerger)this, (Path)file, filterOverride, null, (int)4, null);
    }

    @JvmOverloads
    public final void addJar(@NotNull Path file) throws IOException {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        JarMerger.addJar$default((JarMerger)this, (Path)file, null, null, (int)6, null);
    }

    public static final /* synthetic */ FileTime access$getFileTime$cp() {
        return fileTime;
    }

    static {
        FileTime fileTime = FileTime.fromMillis(0L);
        Intrinsics.checkNotNullExpressionValue((Object)fileTime, (String)"fromMillis(...)");
        JarMerger.fileTime = fileTime;
    }
}

