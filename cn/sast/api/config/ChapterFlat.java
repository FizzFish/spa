/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ChapterFlat
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u0016"}, d2={"Lcn/sast/api/config/ChapterFlat;", "", "category", "", "severity", "ruleId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getSeverity", "getRuleId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "corax-api"})
public final class ChapterFlat {
    @NotNull
    private final String category;
    @NotNull
    private final String severity;
    @NotNull
    private final String ruleId;

    public ChapterFlat(@NotNull String category, @NotNull String severity, @NotNull String ruleId) {
        Intrinsics.checkNotNullParameter((Object)category, (String)"category");
        Intrinsics.checkNotNullParameter((Object)severity, (String)"severity");
        Intrinsics.checkNotNullParameter((Object)ruleId, (String)"ruleId");
        this.category = category;
        this.severity = severity;
        this.ruleId = ruleId;
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final String getSeverity() {
        return this.severity;
    }

    @NotNull
    public final String getRuleId() {
        return this.ruleId;
    }

    @NotNull
    public final String component1() {
        return this.category;
    }

    @NotNull
    public final String component2() {
        return this.severity;
    }

    @NotNull
    public final String component3() {
        return this.ruleId;
    }

    @NotNull
    public final ChapterFlat copy(@NotNull String category, @NotNull String severity, @NotNull String ruleId) {
        Intrinsics.checkNotNullParameter((Object)category, (String)"category");
        Intrinsics.checkNotNullParameter((Object)severity, (String)"severity");
        Intrinsics.checkNotNullParameter((Object)ruleId, (String)"ruleId");
        return new ChapterFlat(category, severity, ruleId);
    }

    public static /* synthetic */ ChapterFlat copy$default(ChapterFlat chapterFlat, String string, String string2, String string3, int n, Object object) {
        if ((n & 1) != 0) {
            string = chapterFlat.category;
        }
        if ((n & 2) != 0) {
            string2 = chapterFlat.severity;
        }
        if ((n & 4) != 0) {
            string3 = chapterFlat.ruleId;
        }
        return chapterFlat.copy(string, string2, string3);
    }

    @NotNull
    public String toString() {
        return "ChapterFlat(category=" + this.category + ", severity=" + this.severity + ", ruleId=" + this.ruleId + ")";
    }

    public int hashCode() {
        int result = this.category.hashCode();
        result = result * 31 + this.severity.hashCode();
        result = result * 31 + this.ruleId.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChapterFlat)) {
            return false;
        }
        ChapterFlat chapterFlat = (ChapterFlat)other;
        if (!Intrinsics.areEqual((Object)this.category, (Object)chapterFlat.category)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.severity, (Object)chapterFlat.severity)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.ruleId, (Object)chapterFlat.ruleId);
    }
}

