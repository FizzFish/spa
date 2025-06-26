/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  kotlin.Metadata
 *  kotlin.sequences.Sequence
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.common;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0010\u0010/\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u00100\u001a\u000201H&J\b\u00102\u001a\u000203H&J\u0010\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u000203H&J\b\u00106\u001a\u000207H&J\b\u0010:\u001a\u000207H\u0016J\b\u0010;\u001a\u000207H\u0016J\u000e\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00030=H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0012\u0010\u0011\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0012\u0010\u0012\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u0012\u0010\u0013\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\tR\u0012\u0010\u0015\u001a\u00020\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0012\u0010\u001a\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u000fR\u0012\u0010\u001b\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u000fR\u0012\u0010\u001c\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u000fR\u0012\u0010\u001d\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0005R\u0012\u0010\u001f\u001a\u00020 X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00020$X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u0004\u0018\u00010\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010\tR\u0012\u0010)\u001a\u00020*X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u0004\u0018\u00010\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010\u0017R\u0014\u00108\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010\u000fR\u0012\u0010>\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010\t\u0082\u0001\u000331@\u00a8\u0006A"}, d2={"Lcn/sast/common/IResource;", "", "path", "Ljava/nio/file/Path;", "getPath", "()Ljava/nio/file/Path;", "name", "", "getName", "()Ljava/lang/String;", "extension", "getExtension", "exists", "", "getExists", "()Z", "isFile", "isDirectory", "isRegularFile", "absolutePath", "getAbsolutePath", "absolute", "getAbsolute", "()Lcn/sast/common/IResource;", "normalize", "getNormalize", "isFileScheme", "isJrtScheme", "isJarScheme", "schemePath", "getSchemePath", "uri", "Ljava/net/URI;", "getUri", "()Ljava/net/URI;", "url", "Ljava/net/URL;", "getUrl", "()Ljava/net/URL;", "zipEntry", "getZipEntry", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "parent", "getParent", "resolve", "toFile", "Lcn/sast/common/IResFile;", "toDirectory", "Lcn/sast/common/IResDirectory;", "expandRes", "outPut", "mkdirs", "", "zipLike", "getZipLike", "deleteDirectoryRecursively", "deleteDirectoryContents", "seq", "Lkotlin/sequences/Sequence;", "pathString", "getPathString", "Lcn/sast/common/Resource$ResourceBasic;", "corax-api"})
public interface IResource
extends Comparable<IResource> {
    @NotNull
    public Path getPath();

    @NotNull
    public String getName();

    @NotNull
    public String getExtension();

    public boolean getExists();

    public boolean isFile();

    public boolean isDirectory();

    public boolean isRegularFile();

    @NotNull
    public String getAbsolutePath();

    @NotNull
    public IResource getAbsolute();

    @NotNull
    public IResource getNormalize();

    public boolean isFileScheme();

    public boolean isJrtScheme();

    public boolean isJarScheme();

    @NotNull
    public Path getSchemePath();

    @NotNull
    public URI getUri();

    @NotNull
    public URL getUrl();

    @Nullable
    public String getZipEntry();

    @NotNull
    public File getFile() throws UnsupportedOperationException;

    @Nullable
    public IResource getParent();

    @NotNull
    public IResource resolve(@NotNull String var1);

    @NotNull
    public IResFile toFile();

    @NotNull
    public IResDirectory toDirectory();

    @NotNull
    public IResource expandRes(@NotNull IResDirectory var1);

    public void mkdirs();

    public boolean getZipLike();

    public void deleteDirectoryRecursively() throws IOException;

    public void deleteDirectoryContents() throws IOException;

    @NotNull
    public Sequence<Path> seq();

    @NotNull
    public String getPathString();
}

