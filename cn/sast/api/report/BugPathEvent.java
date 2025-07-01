package cn.sast.api.report;

import cn.sast.api.report.IBugResInfo;
import cn.sast.api.report.IReportHashAble;
import cn.sast.api.report.IReportHashCalculator;
import cn.sast.api.util.ComparatorUtilsKt;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.report.Region;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BugPathEvent implements Comparable<BugPathEvent>, IReportHashAble {
    @NotNull
    private final Map<Language, String> message;
    @NotNull
    private final IBugResInfo classname;
    @NotNull
    private final Region region;
    @Nullable
    private final Integer stackDepth;

    public BugPathEvent(@NotNull Map<Language, String> message, @NotNull IBugResInfo classname, 
                        @NotNull Region region, @Nullable Integer stackDepth) {
        Objects.requireNonNull(message, "message");
        Objects.requireNonNull(classname, "classname");
        Objects.requireNonNull(region, "region");
        this.message = message;
        this.classname = classname;
        this.region = region;
        this.stackDepth = stackDepth;
    }

    public BugPathEvent(@NotNull Map<Language, String> message, @NotNull IBugResInfo classname, 
                        @NotNull Region region) {
        this(message, classname, region, null);
    }

    @NotNull
    public Map<Language, String> getMessage() {
        return message;
    }

    @NotNull
    public IBugResInfo getClassname() {
        return classname;
    }

    @NotNull
    public Region getRegion() {
        return region;
    }

    @Nullable
    public Integer getStackDepth() {
        return stackDepth;
    }

    @Override
    public int compareTo(@NotNull BugPathEvent other) {
        Objects.requireNonNull(other, "other");
        
        int result = ComparatorUtilsKt.compareToMap(message, other.message);
        if (result != 0) return result;
        
        result = classname.compareTo(other.classname);
        if (result != 0) return result;
        
        result = region.compareTo(other.region);
        if (result != 0) return result;
        
        return 0;
    }

    @Override
    @NotNull
    public String reportHash(@NotNull IReportHashCalculator c) {
        Objects.requireNonNull(c, "c");
        return classname.reportHash(c) + ":" + region;
    }

    @NotNull
    public String reportHashWithMessage(@NotNull IReportHashCalculator c) {
        Objects.requireNonNull(c, "c");
        return reportHash(c) + " " + new TreeSet<>(message.values());
    }

    @Override
    @NotNull
    public String toString() {
        return classname + " at " + region + " " + message;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof BugPathEvent)) return false;
        
        BugPathEvent that = (BugPathEvent) other;
        return message.equals(that.message) &&
               classname.equals(that.classname) &&
               region.equals(that.region) &&
               Objects.equals(stackDepth, that.stackDepth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, classname, region, stackDepth);
    }

    @NotNull
    public BugPathEvent copy(@NotNull Map<Language, String> message, @NotNull IBugResInfo classname, 
                            @NotNull Region region, @Nullable Integer stackDepth) {
        Objects.requireNonNull(message, "message");
        Objects.requireNonNull(classname, "classname");
        Objects.requireNonNull(region, "region");
        return new BugPathEvent(message, classname, region, stackDepth);
    }
}