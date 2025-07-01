package cn.sast.api.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TimeRange implements Comparable<TimeRange> {
    private long min;
    private long max;
    private boolean leftClose = true;
    private boolean rightClose = true;

    public TimeRange(long min, long max) {
        set(min, max);
    }

    public final long getMin() {
        return min;
    }

    public final long getMax() {
        return max;
    }

    @Override
    public int compareTo(@Nullable TimeRange r) {
        if (r == null) {
            throw new NullPointerException("The input cannot be null!");
        }
        return Long.compare(min, r.min) != 0 ? Long.compare(min, r.min) : Long.compare(max, r.max);
    }

    public final void setMin(long min) {
        if (min < 0 || min > max) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.min = min;
    }

    public final void setMax(long max) {
        if (max < 0 || max < min) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.max = max;
    }

    public final boolean contains(@NotNull TimeRange r) {
        Objects.requireNonNull(r, "r");
        return min <= r.min && max >= r.max;
    }

    public final boolean contains(long min, long max) {
        if (leftClose && rightClose) {
            return this.min <= min && this.max >= max;
        } else if (leftClose) {
            return this.min <= min && this.max > max;
        } else if (rightClose) {
            return this.min < min && this.max >= max;
        } else {
            return this.min < min && this.max > max;
        }
    }

    public final boolean contains(long time) {
        if (leftClose && rightClose) {
            return time >= min && time <= max;
        } else if (leftClose) {
            return time >= min && time < max;
        } else if (rightClose) {
            return time > min && time <= max;
        } else {
            return time > min && time < max;
        }
    }

    public final void set(long min, long max) {
        if (min > max) {
            throw new IllegalArgumentException("min:" + min + " should not be larger than max: " + max);
        }
        this.min = min;
        this.max = max;
    }

    public final boolean intersects(@NotNull TimeRange r) {
        Objects.requireNonNull(r, "r");
        if ((!leftClose || !r.rightClose) && r.max < min) return false;
        if (!leftClose && !r.rightClose && r.max <= min) return false;
        if (leftClose && r.rightClose && r.max <= min - 2L) return false;
        if ((!rightClose || !r.leftClose) && r.min > max) return false;
        if (!rightClose && !r.leftClose && r.min >= max) return false;
        return !rightClose || !r.leftClose || r.min < max + 2L;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeRange that = (TimeRange) o;
        return min == that.min && max == that.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

    public final boolean overlaps(@NotNull TimeRange rhs) {
        Objects.requireNonNull(rhs, "rhs");
        if ((!leftClose || !rhs.rightClose) && rhs.max <= min) return false;
        if (!leftClose && !rhs.rightClose && rhs.max <= min + 1L) return false;
        if (leftClose && rhs.rightClose && rhs.max < min) return false;
        if ((!rightClose || !rhs.leftClose) && rhs.min >= max) return false;
        if (!rightClose && !rhs.leftClose && rhs.min + 1L >= max) return false;
        return !rightClose || !rhs.leftClose || rhs.min <= max;
    }

    @Override
    public @NotNull String toString() {
        StringBuilder res = new StringBuilder();
        res.append(leftClose ? "[ " : "( ");
        res.append(min).append(" : ").append(max);
        res.append(rightClose ? " ]" : " )");
        return res.toString();
    }

    public final boolean getLeftClose() {
        return leftClose;
    }

    public final void setLeftClose(boolean leftClose) {
        this.leftClose = leftClose;
    }

    public final boolean getRightClose() {
        return rightClose;
    }

    public final void setRightClose(boolean rightClose) {
        this.rightClose = rightClose;
    }

    public final void merge(@NotNull TimeRange rhs) {
        Objects.requireNonNull(rhs, "rhs");
        set(Math.min(min, rhs.min), Math.max(max, rhs.max));
    }

    public final @NotNull List<TimeRange> getRemains(@NotNull List<TimeRange> timeRangesPrev) {
        Objects.requireNonNull(timeRangesPrev, "timeRangesPrev");
        List<TimeRange> remains = new ArrayList<>();
        for (TimeRange prev : timeRangesPrev) {
            if (prev.min >= max + 2L) break;
            if (!intersects(prev)) continue;
            
            if (prev.contains(this)) {
                return remains;
            }
            if (contains(prev)) {
                if (prev.min > min && prev.max == max) {
                    setMax(prev.min);
                    rightClose = false;
                    remains.add(this);
                    return remains;
                }
                if (prev.min == min) {
                    min = prev.max;
                    leftClose = false;
                    continue;
                }
                TimeRange r = new TimeRange(min, prev.min);
                r.leftClose = leftClose;
                r.rightClose = false;
                remains.add(r);
                min = prev.max;
                leftClose = false;
                continue;
            }
            if (prev.min < min) {
                min = prev.max;
                leftClose = false;
                continue;
            }
            setMax(prev.min);
            rightClose = false;
            remains.add(this);
            return remains;
        }
        remains.add(this);
        return remains;
    }
}