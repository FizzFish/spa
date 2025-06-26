/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sqldelight.AnalyzerResultFile
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0006H\u00c6\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0018"}, d2={"Lcn/sast/framework/report/sqldelight/AnalyzerResultFile;", "", "file_name", "", "file_path", "__file_id", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getFile_name", "()Ljava/lang/String;", "getFile_path", "get__file_id", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "corax-framework"})
public final class AnalyzerResultFile {
    @NotNull
    private final String file_name;
    @Nullable
    private final String file_path;
    private final long __file_id;

    public AnalyzerResultFile(@NotNull String file_name, @Nullable String file_path, long __file_id) {
        Intrinsics.checkNotNullParameter((Object)file_name, (String)"file_name");
        this.file_name = file_name;
        this.file_path = file_path;
        this.__file_id = __file_id;
    }

    @NotNull
    public final String getFile_name() {
        return this.file_name;
    }

    @Nullable
    public final String getFile_path() {
        return this.file_path;
    }

    public final long get__file_id() {
        return this.__file_id;
    }

    @NotNull
    public final String component1() {
        return this.file_name;
    }

    @Nullable
    public final String component2() {
        return this.file_path;
    }

    public final long component3() {
        return this.__file_id;
    }

    @NotNull
    public final AnalyzerResultFile copy(@NotNull String file_name, @Nullable String file_path, long __file_id) {
        Intrinsics.checkNotNullParameter((Object)file_name, (String)"file_name");
        return new AnalyzerResultFile(file_name, file_path, __file_id);
    }

    public static /* synthetic */ AnalyzerResultFile copy$default(AnalyzerResultFile analyzerResultFile, String string, String string2, long l, int n, Object object) {
        if ((n & 1) != 0) {
            string = analyzerResultFile.file_name;
        }
        if ((n & 2) != 0) {
            string2 = analyzerResultFile.file_path;
        }
        if ((n & 4) != 0) {
            l = analyzerResultFile.__file_id;
        }
        return analyzerResultFile.copy(string, string2, l);
    }

    @NotNull
    public String toString() {
        return "AnalyzerResultFile(file_name=" + this.file_name + ", file_path=" + this.file_path + ", __file_id=" + this.__file_id + ")";
    }

    public int hashCode() {
        int result = this.file_name.hashCode();
        result = result * 31 + (this.file_path == null ? 0 : this.file_path.hashCode());
        result = result * 31 + Long.hashCode(this.__file_id);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnalyzerResultFile)) {
            return false;
        }
        AnalyzerResultFile analyzerResultFile = (AnalyzerResultFile)other;
        if (!Intrinsics.areEqual((Object)this.file_name, (Object)analyzerResultFile.file_name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.file_path, (Object)analyzerResultFile.file_path)) {
            return false;
        }
        return this.__file_id == analyzerResultFile.__file_id;
    }
}

