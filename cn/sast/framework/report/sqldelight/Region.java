/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sqldelight.Region
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0010JP\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\"H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006#"}, d2={"Lcn/sast/framework/report/sqldelight/Region;", "", "id", "", "__file_id", "start_line", "start_column", "end_line", "end_column", "<init>", "(JJJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getId", "()J", "get__file_id", "getStart_line", "getStart_column", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEnd_line", "getEnd_column", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(JJJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcn/sast/framework/report/sqldelight/Region;", "equals", "", "other", "hashCode", "", "toString", "", "corax-framework"})
public final class Region {
    private final long id;
    private final long __file_id;
    private final long start_line;
    @Nullable
    private final Long start_column;
    @Nullable
    private final Long end_line;
    @Nullable
    private final Long end_column;

    public Region(long id, long __file_id, long start_line, @Nullable Long start_column, @Nullable Long end_line, @Nullable Long end_column) {
        this.id = id;
        this.__file_id = __file_id;
        this.start_line = start_line;
        this.start_column = start_column;
        this.end_line = end_line;
        this.end_column = end_column;
    }

    public final long getId() {
        return this.id;
    }

    public final long get__file_id() {
        return this.__file_id;
    }

    public final long getStart_line() {
        return this.start_line;
    }

    @Nullable
    public final Long getStart_column() {
        return this.start_column;
    }

    @Nullable
    public final Long getEnd_line() {
        return this.end_line;
    }

    @Nullable
    public final Long getEnd_column() {
        return this.end_column;
    }

    public final long component1() {
        return this.id;
    }

    public final long component2() {
        return this.__file_id;
    }

    public final long component3() {
        return this.start_line;
    }

    @Nullable
    public final Long component4() {
        return this.start_column;
    }

    @Nullable
    public final Long component5() {
        return this.end_line;
    }

    @Nullable
    public final Long component6() {
        return this.end_column;
    }

    @NotNull
    public final Region copy(long id, long __file_id, long start_line, @Nullable Long start_column, @Nullable Long end_line, @Nullable Long end_column) {
        return new Region(id, __file_id, start_line, start_column, end_line, end_column);
    }

    public static /* synthetic */ Region copy$default(Region region, long l, long l2, long l3, Long l4, Long l5, Long l6, int n, Object object) {
        if ((n & 1) != 0) {
            l = region.id;
        }
        if ((n & 2) != 0) {
            l2 = region.__file_id;
        }
        if ((n & 4) != 0) {
            l3 = region.start_line;
        }
        if ((n & 8) != 0) {
            l4 = region.start_column;
        }
        if ((n & 0x10) != 0) {
            l5 = region.end_line;
        }
        if ((n & 0x20) != 0) {
            l6 = region.end_column;
        }
        return region.copy(l, l2, l3, l4, l5, l6);
    }

    @NotNull
    public String toString() {
        return "Region(id=" + this.id + ", __file_id=" + this.__file_id + ", start_line=" + this.start_line + ", start_column=" + this.start_column + ", end_line=" + this.end_line + ", end_column=" + this.end_column + ")";
    }

    public int hashCode() {
        int result = Long.hashCode(this.id);
        result = result * 31 + Long.hashCode(this.__file_id);
        result = result * 31 + Long.hashCode(this.start_line);
        result = result * 31 + (this.start_column == null ? 0 : ((Object)this.start_column).hashCode());
        result = result * 31 + (this.end_line == null ? 0 : ((Object)this.end_line).hashCode());
        result = result * 31 + (this.end_column == null ? 0 : ((Object)this.end_column).hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Region)) {
            return false;
        }
        Region region = (Region)other;
        if (this.id != region.id) {
            return false;
        }
        if (this.__file_id != region.__file_id) {
            return false;
        }
        if (this.start_line != region.start_line) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.start_column, (Object)region.start_column)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.end_line, (Object)region.end_line)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.end_column, (Object)region.end_column);
    }
}

