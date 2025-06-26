/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.BugPathEvent
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.api.report.IReportHashAble
 *  cn.sast.api.report.IReportHashCalculator
 *  cn.sast.api.util.ComparatorUtilsKt
 *  com.feysh.corax.config.api.Language
 *  com.feysh.corax.config.api.report.Region
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.report;

import cn.sast.api.report.IBugResInfo;
import cn.sast.api.report.IReportHashAble;
import cn.sast.api.report.IReportHashCalculator;
import cn.sast.api.util.ComparatorUtilsKt;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.report.Region;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B7\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0000H\u0096\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u00c6\u0003J\t\u0010 \u001a\u00020\bH\u00c6\u0003J\t\u0010!\u001a\u00020\nH\u00c6\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016JD\u0010#\u001a\u00020\u00002\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00c6\u0001\u00a2\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010\u0019\u001a\u0004\u0018\u00010'H\u00d6\u0003J\t\u0010(\u001a\u00020\fH\u00d6\u0001R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006)"}, d2={"Lcn/sast/api/report/BugPathEvent;", "", "Lcn/sast/api/report/IReportHashAble;", "message", "", "Lcom/feysh/corax/config/api/Language;", "", "classname", "Lcn/sast/api/report/IBugResInfo;", "region", "Lcom/feysh/corax/config/api/report/Region;", "stackDepth", "", "<init>", "(Ljava/util/Map;Lcn/sast/api/report/IBugResInfo;Lcom/feysh/corax/config/api/report/Region;Ljava/lang/Integer;)V", "getMessage", "()Ljava/util/Map;", "getClassname", "()Lcn/sast/api/report/IBugResInfo;", "getRegion", "()Lcom/feysh/corax/config/api/report/Region;", "getStackDepth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "compareTo", "other", "reportHash", "c", "Lcn/sast/api/report/IReportHashCalculator;", "reportHashWithMessage", "toString", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/Map;Lcn/sast/api/report/IBugResInfo;Lcom/feysh/corax/config/api/report/Region;Ljava/lang/Integer;)Lcn/sast/api/report/BugPathEvent;", "equals", "", "", "hashCode", "corax-api"})
@SourceDebugExtension(value={"SMAP\nReport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Report.kt\ncn/sast/api/report/BugPathEvent\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,451:1\n1#2:452\n*E\n"})
public final class BugPathEvent
implements Comparable<BugPathEvent>,
IReportHashAble {
    @NotNull
    private final Map<Language, String> message;
    @NotNull
    private final IBugResInfo classname;
    @NotNull
    private final Region region;
    @Nullable
    private final Integer stackDepth;

    public BugPathEvent(@NotNull Map<Language, String> message, @NotNull IBugResInfo classname, @NotNull Region region, @Nullable Integer stackDepth) {
        Intrinsics.checkNotNullParameter(message, (String)"message");
        Intrinsics.checkNotNullParameter((Object)classname, (String)"classname");
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        this.message = message;
        this.classname = classname;
        this.region = region;
        this.stackDepth = stackDepth;
    }

    public /* synthetic */ BugPathEvent(Map map, IBugResInfo iBugResInfo, Region region, Integer n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 8) != 0) {
            n = null;
        }
        this(map, iBugResInfo, region, n);
    }

    @NotNull
    public final Map<Language, String> getMessage() {
        return this.message;
    }

    @NotNull
    public final IBugResInfo getClassname() {
        return this.classname;
    }

    @NotNull
    public final Region getRegion() {
        return this.region;
    }

    @Nullable
    public final Integer getStackDepth() {
        return this.stackDepth;
    }

    @Override
    public int compareTo(@NotNull BugPathEvent other) {
        Integer n;
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Integer n2 = ComparatorUtilsKt.compareToMap((Map)this.message, (Map)other.message);
        int it = ((Number)n2).intValue();
        boolean bl = false;
        Integer n3 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl2 = false;
            return it;
        }
        n2 = this.classname.compareTo((Object)other.classname);
        it = ((Number)n2).intValue();
        boolean bl3 = false;
        Integer n4 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl4 = false;
            return it;
        }
        n2 = this.region.compareTo(other.region);
        it = ((Number)n2).intValue();
        boolean bl5 = false;
        Integer n5 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl6 = false;
            return it;
        }
        return 0;
    }

    @NotNull
    public String reportHash(@NotNull IReportHashCalculator c) {
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        return this.classname.reportHash(c) + ":" + this.region;
    }

    @NotNull
    public final String reportHashWithMessage(@NotNull IReportHashCalculator c) {
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        return this.reportHash(c) + " " + CollectionsKt.toSortedSet((Iterable)this.message.values());
    }

    @NotNull
    public String toString() {
        return this.classname + " at " + this.region + " " + this.message;
    }

    @NotNull
    public final Map<Language, String> component1() {
        return this.message;
    }

    @NotNull
    public final IBugResInfo component2() {
        return this.classname;
    }

    @NotNull
    public final Region component3() {
        return this.region;
    }

    @Nullable
    public final Integer component4() {
        return this.stackDepth;
    }

    @NotNull
    public final BugPathEvent copy(@NotNull Map<Language, String> message, @NotNull IBugResInfo classname, @NotNull Region region, @Nullable Integer stackDepth) {
        Intrinsics.checkNotNullParameter(message, (String)"message");
        Intrinsics.checkNotNullParameter((Object)classname, (String)"classname");
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        return new BugPathEvent(message, classname, region, stackDepth);
    }

    public static /* synthetic */ BugPathEvent copy$default(BugPathEvent bugPathEvent, Map map, IBugResInfo iBugResInfo, Region region, Integer n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            map = bugPathEvent.message;
        }
        if ((n2 & 2) != 0) {
            iBugResInfo = bugPathEvent.classname;
        }
        if ((n2 & 4) != 0) {
            region = bugPathEvent.region;
        }
        if ((n2 & 8) != 0) {
            n = bugPathEvent.stackDepth;
        }
        return bugPathEvent.copy(map, iBugResInfo, region, n);
    }

    public int hashCode() {
        int result = ((Object)this.message).hashCode();
        result = result * 31 + this.classname.hashCode();
        result = result * 31 + this.region.hashCode();
        result = result * 31 + (this.stackDepth == null ? 0 : ((Object)this.stackDepth).hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BugPathEvent)) {
            return false;
        }
        BugPathEvent bugPathEvent = (BugPathEvent)other;
        if (!Intrinsics.areEqual((Object)this.message, (Object)bugPathEvent.message)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.classname, (Object)bugPathEvent.classname)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.region, (Object)bugPathEvent.region)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.stackDepth, (Object)bugPathEvent.stackDepth);
    }
}

