/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.BugPathPosition
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.api.util.ComparatorUtilsKt
 *  com.feysh.corax.config.api.report.Region
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.report;

import cn.sast.api.report.IBugResInfo;
import cn.sast.api.util.ComparatorUtilsKt;
import com.feysh.corax.config.api.report.Region;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\rH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0018"}, d2={"Lcn/sast/api/report/BugPathPosition;", "", "classname", "Lcn/sast/api/report/IBugResInfo;", "region", "Lcom/feysh/corax/config/api/report/Region;", "<init>", "(Lcn/sast/api/report/IBugResInfo;Lcom/feysh/corax/config/api/report/Region;)V", "getClassname", "()Lcn/sast/api/report/IBugResInfo;", "getRegion", "()Lcom/feysh/corax/config/api/report/Region;", "compareTo", "", "other", "toString", "", "component1", "component2", "copy", "equals", "", "", "hashCode", "corax-api"})
@SourceDebugExtension(value={"SMAP\nReport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Report.kt\ncn/sast/api/report/BugPathPosition\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,451:1\n1#2:452\n*E\n"})
public final class BugPathPosition
implements Comparable<BugPathPosition> {
    @NotNull
    private final IBugResInfo classname;
    @Nullable
    private final Region region;

    public BugPathPosition(@NotNull IBugResInfo classname, @Nullable Region region) {
        Intrinsics.checkNotNullParameter((Object)classname, (String)"classname");
        this.classname = classname;
        this.region = region;
    }

    @NotNull
    public final IBugResInfo getClassname() {
        return this.classname;
    }

    @Nullable
    public final Region getRegion() {
        return this.region;
    }

    @Override
    public int compareTo(@NotNull BugPathPosition other) {
        Integer n;
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Integer n2 = this.classname.compareTo((Object)other.classname);
        int it = ((Number)n2).intValue();
        boolean bl = false;
        Integer n3 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl2 = false;
            return it;
        }
        n2 = ComparatorUtilsKt.compareToNullable((Comparable)((Comparable)this.region), (Comparable)((Comparable)other.region));
        it = ((Number)n2).intValue();
        boolean bl3 = false;
        Integer n4 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl4 = false;
            return it;
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return this.classname + " " + this.region;
    }

    @NotNull
    public final IBugResInfo component1() {
        return this.classname;
    }

    @Nullable
    public final Region component2() {
        return this.region;
    }

    @NotNull
    public final BugPathPosition copy(@NotNull IBugResInfo classname, @Nullable Region region) {
        Intrinsics.checkNotNullParameter((Object)classname, (String)"classname");
        return new BugPathPosition(classname, region);
    }

    public static /* synthetic */ BugPathPosition copy$default(BugPathPosition bugPathPosition, IBugResInfo iBugResInfo, Region region, int n, Object object) {
        if ((n & 1) != 0) {
            iBugResInfo = bugPathPosition.classname;
        }
        if ((n & 2) != 0) {
            region = bugPathPosition.region;
        }
        return bugPathPosition.copy(iBugResInfo, region);
    }

    public int hashCode() {
        int result = this.classname.hashCode();
        result = result * 31 + (this.region == null ? 0 : this.region.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BugPathPosition)) {
            return false;
        }
        BugPathPosition bugPathPosition = (BugPathPosition)other;
        if (!Intrinsics.areEqual((Object)this.classname, (Object)bugPathPosition.classname)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.region, (Object)bugPathPosition.region);
    }
}

