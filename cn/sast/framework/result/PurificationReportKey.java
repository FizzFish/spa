/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.BugPathEvent
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.framework.result.PurificationReportKey
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.result;

import cn.sast.api.report.BugPathEvent;
import cn.sast.api.report.IBugResInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\tH\u00c6\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001e"}, d2={"Lcn/sast/framework/result/PurificationReportKey;", "", "bugResFile", "Lcn/sast/api/report/IBugResInfo;", "line", "", "checkName", "", "firstEvent", "Lcn/sast/api/report/BugPathEvent;", "<init>", "(Lcn/sast/api/report/IBugResInfo;ILjava/lang/String;Lcn/sast/api/report/BugPathEvent;)V", "getBugResFile", "()Lcn/sast/api/report/IBugResInfo;", "getLine", "()I", "getCheckName", "()Ljava/lang/String;", "getFirstEvent", "()Lcn/sast/api/report/BugPathEvent;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "corax-framework"})
public final class PurificationReportKey {
    @NotNull
    private final IBugResInfo bugResFile;
    private final int line;
    @NotNull
    private final String checkName;
    @NotNull
    private final BugPathEvent firstEvent;

    public PurificationReportKey(@NotNull IBugResInfo bugResFile, int line, @NotNull String checkName, @NotNull BugPathEvent firstEvent) {
        Intrinsics.checkNotNullParameter((Object)bugResFile, (String)"bugResFile");
        Intrinsics.checkNotNullParameter((Object)checkName, (String)"checkName");
        Intrinsics.checkNotNullParameter((Object)firstEvent, (String)"firstEvent");
        this.bugResFile = bugResFile;
        this.line = line;
        this.checkName = checkName;
        this.firstEvent = firstEvent;
    }

    @NotNull
    public final IBugResInfo getBugResFile() {
        return this.bugResFile;
    }

    public final int getLine() {
        return this.line;
    }

    @NotNull
    public final String getCheckName() {
        return this.checkName;
    }

    @NotNull
    public final BugPathEvent getFirstEvent() {
        return this.firstEvent;
    }

    @NotNull
    public final IBugResInfo component1() {
        return this.bugResFile;
    }

    public final int component2() {
        return this.line;
    }

    @NotNull
    public final String component3() {
        return this.checkName;
    }

    @NotNull
    public final BugPathEvent component4() {
        return this.firstEvent;
    }

    @NotNull
    public final PurificationReportKey copy(@NotNull IBugResInfo bugResFile, int line, @NotNull String checkName, @NotNull BugPathEvent firstEvent) {
        Intrinsics.checkNotNullParameter((Object)bugResFile, (String)"bugResFile");
        Intrinsics.checkNotNullParameter((Object)checkName, (String)"checkName");
        Intrinsics.checkNotNullParameter((Object)firstEvent, (String)"firstEvent");
        return new PurificationReportKey(bugResFile, line, checkName, firstEvent);
    }

    public static /* synthetic */ PurificationReportKey copy$default(PurificationReportKey purificationReportKey, IBugResInfo iBugResInfo, int n, String string, BugPathEvent bugPathEvent, int n2, Object object) {
        if ((n2 & 1) != 0) {
            iBugResInfo = purificationReportKey.bugResFile;
        }
        if ((n2 & 2) != 0) {
            n = purificationReportKey.line;
        }
        if ((n2 & 4) != 0) {
            string = purificationReportKey.checkName;
        }
        if ((n2 & 8) != 0) {
            bugPathEvent = purificationReportKey.firstEvent;
        }
        return purificationReportKey.copy(iBugResInfo, n, string, bugPathEvent);
    }

    @NotNull
    public String toString() {
        return "PurificationReportKey(bugResFile=" + this.bugResFile + ", line=" + this.line + ", checkName=" + this.checkName + ", firstEvent=" + this.firstEvent + ")";
    }

    public int hashCode() {
        int result = this.bugResFile.hashCode();
        result = result * 31 + Integer.hashCode(this.line);
        result = result * 31 + this.checkName.hashCode();
        result = result * 31 + this.firstEvent.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurificationReportKey)) {
            return false;
        }
        PurificationReportKey purificationReportKey = (PurificationReportKey)other;
        if (!Intrinsics.areEqual((Object)this.bugResFile, (Object)purificationReportKey.bugResFile)) {
            return false;
        }
        if (this.line != purificationReportKey.line) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.checkName, (Object)purificationReportKey.checkName)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.firstEvent, (Object)purificationReportKey.firstEvent);
    }
}

