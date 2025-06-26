/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.api.report.MacroExpansion
 *  cn.sast.api.report.Range
 *  cn.sast.api.util.ComparatorUtilsKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.report;

import cn.sast.api.report.IBugResInfo;
import cn.sast.api.report.Range;
import cn.sast.api.util.ComparatorUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u00c6\u0003J=\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010 H\u00d6\u0003J\t\u0010!\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006#"}, d2={"Lcn/sast/api/report/MacroExpansion;", "", "message", "", "classname", "Lcn/sast/api/report/IBugResInfo;", "line", "", "column", "range", "Lcn/sast/api/report/Range;", "<init>", "(Ljava/lang/String;Lcn/sast/api/report/IBugResInfo;IILcn/sast/api/report/Range;)V", "getMessage", "()Ljava/lang/String;", "getClassname", "()Lcn/sast/api/report/IBugResInfo;", "getLine", "()I", "getColumn", "getRange", "()Lcn/sast/api/report/Range;", "compareTo", "other", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "", "hashCode", "toString", "corax-api"})
@SourceDebugExtension(value={"SMAP\nReport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Report.kt\ncn/sast/api/report/MacroExpansion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,451:1\n1#2:452\n*E\n"})
public final class MacroExpansion
implements Comparable<MacroExpansion> {
    @NotNull
    private final String message;
    @NotNull
    private final IBugResInfo classname;
    private final int line;
    private final int column;
    @Nullable
    private final Range range;

    public MacroExpansion(@NotNull String message, @NotNull IBugResInfo classname, int line, int column, @Nullable Range range) {
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
        Intrinsics.checkNotNullParameter((Object)classname, (String)"classname");
        this.message = message;
        this.classname = classname;
        this.line = line;
        this.column = column;
        this.range = range;
    }

    public /* synthetic */ MacroExpansion(String string, IBugResInfo iBugResInfo, int n, int n2, Range range, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 0x10) != 0) {
            range = null;
        }
        this(string, iBugResInfo, n, n2, range);
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final IBugResInfo getClassname() {
        return this.classname;
    }

    public final int getLine() {
        return this.line;
    }

    public final int getColumn() {
        return this.column;
    }

    @Nullable
    public final Range getRange() {
        return this.range;
    }

    @Override
    public int compareTo(@NotNull MacroExpansion other) {
        Integer n;
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Integer n2 = this.message.compareTo(other.message);
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
        n2 = Intrinsics.compare((int)this.line, (int)other.line);
        it = ((Number)n2).intValue();
        boolean bl5 = false;
        Integer n5 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl6 = false;
            return it;
        }
        n2 = Intrinsics.compare((int)this.column, (int)other.column);
        it = ((Number)n2).intValue();
        boolean bl7 = false;
        Integer n6 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl8 = false;
            return it;
        }
        n2 = ComparatorUtilsKt.compareToNullable((Comparable)((Comparable)this.range), (Comparable)((Comparable)other.range));
        it = ((Number)n2).intValue();
        boolean bl9 = false;
        Integer n7 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl10 = false;
            return it;
        }
        return 0;
    }

    @NotNull
    public final String component1() {
        return this.message;
    }

    @NotNull
    public final IBugResInfo component2() {
        return this.classname;
    }

    public final int component3() {
        return this.line;
    }

    public final int component4() {
        return this.column;
    }

    @Nullable
    public final Range component5() {
        return this.range;
    }

    @NotNull
    public final MacroExpansion copy(@NotNull String message, @NotNull IBugResInfo classname, int line, int column, @Nullable Range range) {
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
        Intrinsics.checkNotNullParameter((Object)classname, (String)"classname");
        return new MacroExpansion(message, classname, line, column, range);
    }

    public static /* synthetic */ MacroExpansion copy$default(MacroExpansion macroExpansion, String string, IBugResInfo iBugResInfo, int n, int n2, Range range, int n3, Object object) {
        if ((n3 & 1) != 0) {
            string = macroExpansion.message;
        }
        if ((n3 & 2) != 0) {
            iBugResInfo = macroExpansion.classname;
        }
        if ((n3 & 4) != 0) {
            n = macroExpansion.line;
        }
        if ((n3 & 8) != 0) {
            n2 = macroExpansion.column;
        }
        if ((n3 & 0x10) != 0) {
            range = macroExpansion.range;
        }
        return macroExpansion.copy(string, iBugResInfo, n, n2, range);
    }

    @NotNull
    public String toString() {
        return "MacroExpansion(message=" + this.message + ", classname=" + this.classname + ", line=" + this.line + ", column=" + this.column + ", range=" + this.range + ")";
    }

    public int hashCode() {
        int result = this.message.hashCode();
        result = result * 31 + this.classname.hashCode();
        result = result * 31 + Integer.hashCode(this.line);
        result = result * 31 + Integer.hashCode(this.column);
        result = result * 31 + (this.range == null ? 0 : this.range.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MacroExpansion)) {
            return false;
        }
        MacroExpansion macroExpansion = (MacroExpansion)other;
        if (!Intrinsics.areEqual((Object)this.message, (Object)macroExpansion.message)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.classname, (Object)macroExpansion.classname)) {
            return false;
        }
        if (this.line != macroExpansion.line) {
            return false;
        }
        if (this.column != macroExpansion.column) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.range, (Object)macroExpansion.range);
    }
}

