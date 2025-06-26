/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sqldelight.AbsoluteFilePath
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.sqldelight;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2={"Lcn/sast/framework/report/sqldelight/AbsoluteFilePath;", "", "file_abs_path", "", "__file_id", "", "<init>", "(Ljava/lang/String;J)V", "getFile_abs_path", "()Ljava/lang/String;", "get__file_id", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "corax-framework"})
public final class AbsoluteFilePath {
    @NotNull
    private final String file_abs_path;
    private final long __file_id;

    public AbsoluteFilePath(@NotNull String file_abs_path, long __file_id) {
        Intrinsics.checkNotNullParameter((Object)file_abs_path, (String)"file_abs_path");
        this.file_abs_path = file_abs_path;
        this.__file_id = __file_id;
    }

    @NotNull
    public final String getFile_abs_path() {
        return this.file_abs_path;
    }

    public final long get__file_id() {
        return this.__file_id;
    }

    @NotNull
    public final String component1() {
        return this.file_abs_path;
    }

    public final long component2() {
        return this.__file_id;
    }

    @NotNull
    public final AbsoluteFilePath copy(@NotNull String file_abs_path, long __file_id) {
        Intrinsics.checkNotNullParameter((Object)file_abs_path, (String)"file_abs_path");
        return new AbsoluteFilePath(file_abs_path, __file_id);
    }

    public static /* synthetic */ AbsoluteFilePath copy$default(AbsoluteFilePath absoluteFilePath, String string, long l, int n, Object object) {
        if ((n & 1) != 0) {
            string = absoluteFilePath.file_abs_path;
        }
        if ((n & 2) != 0) {
            l = absoluteFilePath.__file_id;
        }
        return absoluteFilePath.copy(string, l);
    }

    @NotNull
    public String toString() {
        return "AbsoluteFilePath(file_abs_path=" + this.file_abs_path + ", __file_id=" + this.__file_id + ")";
    }

    public int hashCode() {
        int result = this.file_abs_path.hashCode();
        result = result * 31 + Long.hashCode(this.__file_id);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbsoluteFilePath)) {
            return false;
        }
        AbsoluteFilePath absoluteFilePath = (AbsoluteFilePath)other;
        if (!Intrinsics.areEqual((Object)this.file_abs_path, (Object)absoluteFilePath.file_abs_path)) {
            return false;
        }
        return this.__file_id == absoluteFilePath.__file_id;
    }
}

