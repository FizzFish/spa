/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.TimeRange
 *  cn.sast.api.util.TimeRange$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.util;

import cn.sast.api.util.TimeRange;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 *2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0001:\u0001*B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0000H\u0096\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0000J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0000J\u0013\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\fH\u0016J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0000J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010&\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0000J\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00000(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00000(R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u001e\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"\u00a8\u0006+"}, d2={"Lcn/sast/api/util/TimeRange;", "", "min", "", "max", "<init>", "(JJ)V", "value", "getMin", "()J", "getMax", "compareTo", "", "r", "setMin", "", "setMax", "contains", "", "time", "set", "intersects", "equals", "o", "", "hashCode", "overlaps", "rhs", "toString", "", "leftClose", "getLeftClose", "()Z", "setLeftClose", "(Z)V", "rightClose", "getRightClose", "setRightClose", "merge", "getRemains", "", "timeRangesPrev", "Companion", "corax-api"})
@SourceDebugExtension(value={"SMAP\nTimeRange.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeRange.kt\ncn/sast/api/util/TimeRange\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,331:1\n1#2:332\n*E\n"})
public final class TimeRange
implements Comparable<TimeRange> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private long min;
    private long max;
    private boolean leftClose = true;
    private boolean rightClose = true;

    public TimeRange(long min, long max) {
        this.set(min, max);
    }

    public final long getMin() {
        return this.min;
    }

    public final long getMax() {
        return this.max;
    }

    @Override
    public int compareTo(@Nullable TimeRange r) {
        if (r == null) {
            throw new NullPointerException("The input cannot be null!");
        }
        return this.min > r.min ? 1 : (this.min < r.min ? -1 : (this.max > r.max ? 1 : (this.max < r.max ? -1 : 0)));
    }

    public final void setMin(long min) {
        if (!(min >= 0L && min <= this.max)) {
            boolean bl = false;
            String string = "Invalid input!";
            throw new IllegalArgumentException(string.toString());
        }
        this.min = min;
    }

    public final void setMax(long max) {
        if (!(max >= 0L && max >= this.min)) {
            boolean bl = false;
            String string = "Invalid input!";
            throw new IllegalArgumentException(string.toString());
        }
        this.max = max;
    }

    public final boolean contains(@NotNull TimeRange r) {
        Intrinsics.checkNotNullParameter((Object)r, (String)"r");
        return this.min <= r.min && this.max >= r.max;
    }

    public final boolean contains(long min, long max) {
        return this.leftClose && this.rightClose ? this.min <= min && this.max >= max : (this.leftClose ? this.min <= min && this.max > max : (this.rightClose ? this.min < min && this.max >= max : this.min < min && this.max > max));
    }

    public final boolean contains(long time) {
        return this.leftClose && this.rightClose ? time >= this.min && time <= this.max : (this.leftClose ? time >= this.min && time < this.max : (this.rightClose ? time > this.min && time <= this.max : time > this.min && time < this.max));
    }

    public final void set(long min, long max) {
        if (!(min <= max)) {
            boolean bl = false;
            String string = "min:" + min + " should not be larger than max: " + max;
            throw new IllegalArgumentException(string.toString());
        }
        this.min = min;
        this.max = max;
    }

    public final boolean intersects(@NotNull TimeRange r) {
        Intrinsics.checkNotNullParameter((Object)r, (String)"r");
        return (!this.leftClose || !r.rightClose) && r.max < this.min ? false : (!this.leftClose && !r.rightClose && r.max <= this.min ? false : (this.leftClose && r.rightClose && r.max <= this.min - (long)2 ? false : ((!this.rightClose || !r.leftClose) && r.min > this.max ? false : (!this.rightClose && !r.leftClose && r.min >= this.max ? false : !this.rightClose || !r.leftClose || r.min < this.max + (long)2))));
    }

    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !Intrinsics.areEqual(this.getClass(), o.getClass())) {
            return false;
        }
        TimeRange that = (TimeRange)o;
        return this.min == that.min && this.max == that.max;
    }

    public int hashCode() {
        Object[] objectArray = new Object[]{this.min, this.max};
        return Objects.hash(objectArray);
    }

    public final boolean overlaps(@NotNull TimeRange rhs) {
        Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
        return (!this.leftClose || !rhs.rightClose) && rhs.max <= this.min ? false : (!this.leftClose && !rhs.rightClose && rhs.max <= this.min + 1L ? false : (this.leftClose && rhs.rightClose && rhs.max < this.min ? false : ((!this.rightClose || !rhs.leftClose) && rhs.min >= this.max ? false : (!this.rightClose && !rhs.leftClose && rhs.min + 1L >= this.max ? false : !this.rightClose || !rhs.leftClose || rhs.min <= this.max))));
    }

    @NotNull
    public String toString() {
        StringBuilder res = new StringBuilder();
        StringBuilder stringBuilder = this.leftClose ? res.append("[ ") : res.append("( ");
        res.append(this.min).append(" : ").append(this.max);
        StringBuilder stringBuilder2 = this.rightClose ? res.append(" ]") : res.append(" )");
        String string = res.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        return string;
    }

    public final boolean getLeftClose() {
        return this.leftClose;
    }

    public final void setLeftClose(boolean bl) {
        this.leftClose = bl;
    }

    public final boolean getRightClose() {
        return this.rightClose;
    }

    public final void setRightClose(boolean bl) {
        this.rightClose = bl;
    }

    public final void merge(@NotNull TimeRange rhs) {
        Intrinsics.checkNotNullParameter((Object)rhs, (String)"rhs");
        this.set(RangesKt.coerceAtMost((long)this.min, (long)rhs.min), RangesKt.coerceAtLeast((long)this.max, (long)rhs.max));
    }

    @NotNull
    public final List<TimeRange> getRemains(@NotNull List<TimeRange> timeRangesPrev) {
        Intrinsics.checkNotNullParameter(timeRangesPrev, (String)"timeRangesPrev");
        List remains = new ArrayList();
        for (TimeRange prev : timeRangesPrev) {
            if (prev.min >= this.max + (long)2) break;
            if (!this.intersects(prev)) continue;
            if (prev.contains(this)) {
                return remains;
            }
            if (this.contains(prev)) {
                if (prev.min > this.min && prev.max == this.max) {
                    this.setMax(prev.min);
                    this.rightClose = false;
                    remains.add(this);
                    return remains;
                }
                if (prev.min == this.min) {
                    this.min = prev.max;
                    this.leftClose = false;
                    continue;
                }
                TimeRange r = new TimeRange(this.min, prev.min);
                r.leftClose = this.leftClose;
                r.rightClose = false;
                remains.add(r);
                this.min = prev.max;
                this.leftClose = false;
                continue;
            }
            if (prev.min < this.min) {
                this.min = prev.max;
                this.leftClose = false;
                continue;
            }
            this.setMax(prev.min);
            this.rightClose = false;
            remains.add(this);
            return remains;
        }
        remains.add(this);
        return remains;
    }
}

