/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.IReportHashAble
 *  cn.sast.api.report.IReportHashCalculator
 *  cn.sast.api.report.Range
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.report;

import cn.sast.api.report.IReportHashAble;
import cn.sast.api.report.IReportHashCalculator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\t\u0010\u0016\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0004H\u00c6\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001dH\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0004H\u00d6\u0001R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b\u00a8\u0006\u001f"}, d2={"Lcn/sast/api/report/Range;", "", "Lcn/sast/api/report/IReportHashAble;", "start_line", "", "start_col", "end_line", "end_col", "<init>", "(IIII)V", "getStart_line", "()I", "getStart_col", "getEnd_line", "getEnd_col", "compareTo", "other", "reportHash", "", "c", "Lcn/sast/api/report/IReportHashCalculator;", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "", "hashCode", "corax-api"})
@SourceDebugExtension(value={"SMAP\nReport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Report.kt\ncn/sast/api/report/Range\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,451:1\n1#2:452\n*E\n"})
public final class Range
implements Comparable<Range>,
IReportHashAble {
    private final int start_line;
    private final int start_col;
    private final int end_line;
    private final int end_col;

    public Range(int start_line, int start_col, int end_line, int end_col) {
        this.start_line = start_line;
        this.start_col = start_col;
        this.end_line = end_line;
        this.end_col = end_col;
    }

    public final int getStart_line() {
        return this.start_line;
    }

    public final int getStart_col() {
        return this.start_col;
    }

    public final int getEnd_line() {
        return this.end_line;
    }

    public final int getEnd_col() {
        return this.end_col;
    }

    @Override
    public int compareTo(@NotNull Range other) {
        Integer n;
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Integer n2 = Intrinsics.compare((int)this.start_line, (int)other.start_line);
        int it = ((Number)n2).intValue();
        boolean bl = false;
        Integer n3 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl2 = false;
            return it;
        }
        n2 = Intrinsics.compare((int)this.start_col, (int)other.start_col);
        it = ((Number)n2).intValue();
        boolean bl3 = false;
        Integer n4 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl4 = false;
            return it;
        }
        n2 = Intrinsics.compare((int)this.end_line, (int)other.end_line);
        it = ((Number)n2).intValue();
        boolean bl5 = false;
        Integer n5 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl6 = false;
            return it;
        }
        n2 = Intrinsics.compare((int)this.end_col, (int)other.end_col);
        it = ((Number)n2).intValue();
        boolean bl7 = false;
        Integer n6 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl8 = false;
            return it;
        }
        return 0;
    }

    @NotNull
    public String reportHash(@NotNull IReportHashCalculator c) {
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        return this.start_line + "," + this.start_col + "," + this.end_line + "," + this.end_col;
    }

    @NotNull
    public String toString() {
        return "[" + this.start_line + ":" + this.start_col + "," + this.end_line + ":" + this.end_col + "]";
    }

    public final int component1() {
        return this.start_line;
    }

    public final int component2() {
        return this.start_col;
    }

    public final int component3() {
        return this.end_line;
    }

    public final int component4() {
        return this.end_col;
    }

    @NotNull
    public final Range copy(int start_line, int start_col, int end_line, int end_col) {
        return new Range(start_line, start_col, end_line, end_col);
    }

    public static /* synthetic */ Range copy$default(Range range, int n, int n2, int n3, int n4, int n5, Object object) {
        if ((n5 & 1) != 0) {
            n = range.start_line;
        }
        if ((n5 & 2) != 0) {
            n2 = range.start_col;
        }
        if ((n5 & 4) != 0) {
            n3 = range.end_line;
        }
        if ((n5 & 8) != 0) {
            n4 = range.end_col;
        }
        return range.copy(n, n2, n3, n4);
    }

    public int hashCode() {
        int result = Integer.hashCode(this.start_line);
        result = result * 31 + Integer.hashCode(this.start_col);
        result = result * 31 + Integer.hashCode(this.end_line);
        result = result * 31 + Integer.hashCode(this.end_col);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Range)) {
            return false;
        }
        Range range = (Range)other;
        if (this.start_line != range.start_line) {
            return false;
        }
        if (this.start_col != range.start_col) {
            return false;
        }
        if (this.end_line != range.end_line) {
            return false;
        }
        return this.end_col == range.end_col;
    }
}

