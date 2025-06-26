/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.CoverInst
 *  cn.sast.api.report.CoverSootCode
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.Unit
 */
package cn.sast.api.report;

import cn.sast.api.report.CoverSootCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0017"}, d2={"Lcn/sast/api/report/CoverInst;", "Lcn/sast/api/report/CoverSootCode;", "method", "Lsoot/SootMethod;", "unit", "Lsoot/Unit;", "<init>", "(Lsoot/SootMethod;Lsoot/Unit;)V", "getMethod", "()Lsoot/SootMethod;", "getUnit", "()Lsoot/Unit;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "corax-api"})
public final class CoverInst
extends CoverSootCode {
    @NotNull
    private final SootMethod method;
    @NotNull
    private final Unit unit;

    public CoverInst(@NotNull SootMethod method, @NotNull Unit unit) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        super(method, unit, null);
        this.method = method;
        this.unit = unit;
    }

    @NotNull
    public SootMethod getMethod() {
        return this.method;
    }

    @NotNull
    public Unit getUnit() {
        return this.unit;
    }

    @NotNull
    public final SootMethod component1() {
        return this.method;
    }

    @NotNull
    public final Unit component2() {
        return this.unit;
    }

    @NotNull
    public final CoverInst copy(@NotNull SootMethod method, @NotNull Unit unit) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        return new CoverInst(method, unit);
    }

    public static /* synthetic */ CoverInst copy$default(CoverInst coverInst, SootMethod sootMethod, Unit unit, int n, Object object) {
        if ((n & 1) != 0) {
            sootMethod = coverInst.method;
        }
        if ((n & 2) != 0) {
            unit = coverInst.unit;
        }
        return coverInst.copy(sootMethod, unit);
    }

    @NotNull
    public String toString() {
        return "CoverInst(method=" + this.method + ", unit=" + this.unit + ")";
    }

    public int hashCode() {
        int result = this.method.hashCode();
        result = result * 31 + this.unit.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoverInst)) {
            return false;
        }
        CoverInst coverInst = (CoverInst)other;
        if (!Intrinsics.areEqual((Object)this.method, (Object)coverInst.method)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.unit, (Object)coverInst.unit);
    }
}

