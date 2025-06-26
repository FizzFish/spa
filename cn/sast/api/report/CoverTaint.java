/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.CoverSootCode
 *  cn.sast.api.report.CoverTaint
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001b"}, d2={"Lcn/sast/api/report/CoverTaint;", "Lcn/sast/api/report/CoverSootCode;", "method", "Lsoot/SootMethod;", "unit", "Lsoot/Unit;", "value", "", "<init>", "(Lsoot/SootMethod;Lsoot/Unit;Ljava/lang/Object;)V", "getMethod", "()Lsoot/SootMethod;", "getUnit", "()Lsoot/Unit;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "corax-api"})
public final class CoverTaint
extends CoverSootCode {
    @NotNull
    private final SootMethod method;
    @NotNull
    private final Unit unit;
    @NotNull
    private final Object value;

    public CoverTaint(@NotNull SootMethod method, @NotNull Unit unit, @NotNull Object value) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        super(method, unit, null);
        this.method = method;
        this.unit = unit;
        this.value = value;
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
    public final Object getValue() {
        return this.value;
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
    public final Object component3() {
        return this.value;
    }

    @NotNull
    public final CoverTaint copy(@NotNull SootMethod method, @NotNull Unit unit, @NotNull Object value) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        return new CoverTaint(method, unit, value);
    }

    public static /* synthetic */ CoverTaint copy$default(CoverTaint coverTaint, SootMethod sootMethod, Unit unit, Object object, int n, Object object2) {
        if ((n & 1) != 0) {
            sootMethod = coverTaint.method;
        }
        if ((n & 2) != 0) {
            unit = coverTaint.unit;
        }
        if ((n & 4) != 0) {
            object = coverTaint.value;
        }
        return coverTaint.copy(sootMethod, unit, object);
    }

    @NotNull
    public String toString() {
        return "CoverTaint(method=" + this.method + ", unit=" + this.unit + ", value=" + this.value + ")";
    }

    public int hashCode() {
        int result = this.method.hashCode();
        result = result * 31 + this.unit.hashCode();
        result = result * 31 + this.value.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoverTaint)) {
            return false;
        }
        CoverTaint coverTaint = (CoverTaint)other;
        if (!Intrinsics.areEqual((Object)this.method, (Object)coverTaint.method)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.unit, (Object)coverTaint.unit)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.value, (Object)coverTaint.value);
    }
}

