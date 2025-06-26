/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sqldelight.File
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.sqldelight;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u000bH\u00c6\u0003JQ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020$H\u00d6\u0001J\t\u0010%\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006&"}, d2={"Lcn/sast/framework/report/sqldelight/File;", "", "id", "", "file_raw_content_hash", "", "relative_path", "lines", "encoding", "file_raw_content_size", "file_raw_content", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;J[B)V", "getId", "()J", "getFile_raw_content_hash", "()Ljava/lang/String;", "getRelative_path", "getLines", "getEncoding", "getFile_raw_content_size", "getFile_raw_content", "()[B", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "corax-framework"})
public final class File {
    private final long id;
    @NotNull
    private final String file_raw_content_hash;
    @NotNull
    private final String relative_path;
    private final long lines;
    @Nullable
    private final String encoding;
    private final long file_raw_content_size;
    @NotNull
    private final byte[] file_raw_content;

    public File(long id, @NotNull String file_raw_content_hash, @NotNull String relative_path, long lines2, @Nullable String encoding, long file_raw_content_size, @NotNull byte[] file_raw_content) {
        Intrinsics.checkNotNullParameter((Object)file_raw_content_hash, (String)"file_raw_content_hash");
        Intrinsics.checkNotNullParameter((Object)relative_path, (String)"relative_path");
        Intrinsics.checkNotNullParameter((Object)file_raw_content, (String)"file_raw_content");
        this.id = id;
        this.file_raw_content_hash = file_raw_content_hash;
        this.relative_path = relative_path;
        this.lines = lines2;
        this.encoding = encoding;
        this.file_raw_content_size = file_raw_content_size;
        this.file_raw_content = file_raw_content;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getFile_raw_content_hash() {
        return this.file_raw_content_hash;
    }

    @NotNull
    public final String getRelative_path() {
        return this.relative_path;
    }

    public final long getLines() {
        return this.lines;
    }

    @Nullable
    public final String getEncoding() {
        return this.encoding;
    }

    public final long getFile_raw_content_size() {
        return this.file_raw_content_size;
    }

    @NotNull
    public final byte[] getFile_raw_content() {
        return this.file_raw_content;
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.file_raw_content_hash;
    }

    @NotNull
    public final String component3() {
        return this.relative_path;
    }

    public final long component4() {
        return this.lines;
    }

    @Nullable
    public final String component5() {
        return this.encoding;
    }

    public final long component6() {
        return this.file_raw_content_size;
    }

    @NotNull
    public final byte[] component7() {
        return this.file_raw_content;
    }

    @NotNull
    public final File copy(long id, @NotNull String file_raw_content_hash, @NotNull String relative_path, long lines2, @Nullable String encoding, long file_raw_content_size, @NotNull byte[] file_raw_content) {
        Intrinsics.checkNotNullParameter((Object)file_raw_content_hash, (String)"file_raw_content_hash");
        Intrinsics.checkNotNullParameter((Object)relative_path, (String)"relative_path");
        Intrinsics.checkNotNullParameter((Object)file_raw_content, (String)"file_raw_content");
        return new File(id, file_raw_content_hash, relative_path, lines2, encoding, file_raw_content_size, file_raw_content);
    }

    public static /* synthetic */ File copy$default(File file, long l, String string, String string2, long l2, String string3, long l3, byte[] byArray, int n, Object object) {
        if ((n & 1) != 0) {
            l = file.id;
        }
        if ((n & 2) != 0) {
            string = file.file_raw_content_hash;
        }
        if ((n & 4) != 0) {
            string2 = file.relative_path;
        }
        if ((n & 8) != 0) {
            l2 = file.lines;
        }
        if ((n & 0x10) != 0) {
            string3 = file.encoding;
        }
        if ((n & 0x20) != 0) {
            l3 = file.file_raw_content_size;
        }
        if ((n & 0x40) != 0) {
            byArray = file.file_raw_content;
        }
        return file.copy(l, string, string2, l2, string3, l3, byArray);
    }

    @NotNull
    public String toString() {
        return "File(id=" + this.id + ", file_raw_content_hash=" + this.file_raw_content_hash + ", relative_path=" + this.relative_path + ", lines=" + this.lines + ", encoding=" + this.encoding + ", file_raw_content_size=" + this.file_raw_content_size + ", file_raw_content=" + Arrays.toString(this.file_raw_content) + ")";
    }

    public int hashCode() {
        int result = Long.hashCode(this.id);
        result = result * 31 + this.file_raw_content_hash.hashCode();
        result = result * 31 + this.relative_path.hashCode();
        result = result * 31 + Long.hashCode(this.lines);
        result = result * 31 + (this.encoding == null ? 0 : this.encoding.hashCode());
        result = result * 31 + Long.hashCode(this.file_raw_content_size);
        result = result * 31 + Arrays.hashCode(this.file_raw_content);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof File)) {
            return false;
        }
        File file = (File)other;
        if (this.id != file.id) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.file_raw_content_hash, (Object)file.file_raw_content_hash)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.relative_path, (Object)file.relative_path)) {
            return false;
        }
        if (this.lines != file.lines) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.encoding, (Object)file.encoding)) {
            return false;
        }
        if (this.file_raw_content_size != file.file_raw_content_size) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.file_raw_content, (Object)file.file_raw_content);
    }
}

