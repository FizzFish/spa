/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.InfoflowConfigurationExt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.infoflow;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2={"Lcn/sast/dataflow/infoflow/InfoflowConfigurationExt;", "", "useSparseOpt", "", "missing_summaries_file", "", "<init>", "(ZLjava/lang/String;)V", "getUseSparseOpt", "()Z", "setUseSparseOpt", "(Z)V", "getMissing_summaries_file", "()Ljava/lang/String;", "setMissing_summaries_file", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "corax-data-flow"})
public final class InfoflowConfigurationExt {
    private boolean useSparseOpt;
    @Nullable
    private String missing_summaries_file;

    public InfoflowConfigurationExt(boolean useSparseOpt, @Nullable String missing_summaries_file) {
        this.useSparseOpt = useSparseOpt;
        this.missing_summaries_file = missing_summaries_file;
    }

    public /* synthetic */ InfoflowConfigurationExt(boolean bl, String string, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            bl = true;
        }
        if ((n & 2) != 0) {
            string = null;
        }
        this(bl, string);
    }

    public final boolean getUseSparseOpt() {
        return this.useSparseOpt;
    }

    public final void setUseSparseOpt(boolean bl) {
        this.useSparseOpt = bl;
    }

    @Nullable
    public final String getMissing_summaries_file() {
        return this.missing_summaries_file;
    }

    public final void setMissing_summaries_file(@Nullable String string) {
        this.missing_summaries_file = string;
    }

    public final boolean component1() {
        return this.useSparseOpt;
    }

    @Nullable
    public final String component2() {
        return this.missing_summaries_file;
    }

    @NotNull
    public final InfoflowConfigurationExt copy(boolean useSparseOpt, @Nullable String missing_summaries_file) {
        return new InfoflowConfigurationExt(useSparseOpt, missing_summaries_file);
    }

    public static /* synthetic */ InfoflowConfigurationExt copy$default(InfoflowConfigurationExt infoflowConfigurationExt, boolean bl, String string, int n, Object object) {
        if ((n & 1) != 0) {
            bl = infoflowConfigurationExt.useSparseOpt;
        }
        if ((n & 2) != 0) {
            string = infoflowConfigurationExt.missing_summaries_file;
        }
        return infoflowConfigurationExt.copy(bl, string);
    }

    @NotNull
    public String toString() {
        return "InfoflowConfigurationExt(useSparseOpt=" + this.useSparseOpt + ", missing_summaries_file=" + this.missing_summaries_file + ")";
    }

    public int hashCode() {
        int result = Boolean.hashCode(this.useSparseOpt);
        result = result * 31 + (this.missing_summaries_file == null ? 0 : this.missing_summaries_file.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InfoflowConfigurationExt)) {
            return false;
        }
        InfoflowConfigurationExt infoflowConfigurationExt = (InfoflowConfigurationExt)other;
        if (this.useSparseOpt != infoflowConfigurationExt.useSparseOpt) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.missing_summaries_file, (Object)infoflowConfigurationExt.missing_summaries_file);
    }

    public InfoflowConfigurationExt() {
        this(false, null, 3, null);
    }
}

