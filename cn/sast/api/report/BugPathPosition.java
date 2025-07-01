package cn.sast.api.report;

import cn.sast.api.report.IBugResInfo;
import cn.sast.api.util.ComparatorUtilsKt;
import com.feysh.corax.config.api.report.Region;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BugPathPosition implements Comparable<BugPathPosition> {
    @NotNull
    private final IBugResInfo classname;
    @Nullable
    private final Region region;

    public BugPathPosition(@NotNull IBugResInfo classname, @Nullable Region region) {
        if (classname == null) {
            throw new IllegalArgumentException("classname cannot be null");
        }
        this.classname = classname;
        this.region = region;
    }

    @NotNull
    public IBugResInfo getClassname() {
        return classname;
    }

    @Nullable
    public Region getRegion() {
        return region;
    }

    @Override
    public int compareTo(@NotNull BugPathPosition other) {
        if (other == null) {
            throw new IllegalArgumentException("other cannot be null");
        }
        
        int classnameComparison = classname.compareTo(other.classname);
        if (classnameComparison != 0) {
            return classnameComparison;
        }
        
        return ComparatorUtilsKt.compareToNullable(region, other.region);
    }

    @Override
    public String toString() {
        return classname + " " + region;
    }

    @Override
    public int hashCode() {
        int result = classname.hashCode();
        result = 31 * result + (region != null ? region.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof BugPathPosition)) return false;
        
        BugPathPosition that = (BugPathPosition) other;
        return classname.equals(that.classname) &&
               (region != null ? region.equals(that.region) : that.region == null);
    }

    @NotNull
    public BugPathPosition copy(@NotNull IBugResInfo classname, @Nullable Region region) {
        return new BugPathPosition(classname, region);
    }
}