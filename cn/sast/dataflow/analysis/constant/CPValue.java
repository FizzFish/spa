/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.analysis.constant.CPValue
 *  cn.sast.dataflow.analysis.constant.CPValue$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.analysis.constant;

import cn.sast.dataflow.analysis.constant.CPValue;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\t\b\u0012\u00a2\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0012\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lcn/sast/dataflow/analysis/constant/CPValue;", "", "<init>", "()V", "val", "", "(I)V", "value", "equals", "", "other", "hashCode", "toString", "", "Companion", "corax-data-flow"})
public class CPValue {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private int value;
    @NotNull
    private static final CPValue nac = (CPValue)new /* Unavailable Anonymous Inner Class!! */;
    @NotNull
    private static final CPValue undef = (CPValue)new /* Unavailable Anonymous Inner Class!! */;

    private CPValue() {
    }

    private CPValue(int val) {
        this.value = val;
    }

    public final int value() {
        return this.value;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(this.getClass(), other.getClass())) {
            return false;
        }
        if (this == undef && other == nac) {
            return false;
        }
        if (this == nac && other == undef) {
            return false;
        }
        CPValue cpValue = (CPValue)other;
        return this.value == cpValue.value;
    }

    public int hashCode() {
        Object[] objectArray = new Object[]{this.value};
        return Objects.hash(objectArray);
    }

    @NotNull
    public String toString() {
        if (this == nac) {
            return "NAC";
        }
        return this == undef ? "UNDEF" : String.valueOf(this.value);
    }

    @JvmStatic
    @NotNull
    public static final CPValue makeConstant(int value) {
        return Companion.makeConstant(value);
    }

    public static final /* synthetic */ CPValue access$getNac$cp() {
        return nac;
    }

    public static final /* synthetic */ CPValue access$getUndef$cp() {
        return undef;
    }

    public /* synthetic */ CPValue(int val, DefaultConstructorMarker $constructor_marker) {
        this(val);
    }

    public /* synthetic */ CPValue(DefaultConstructorMarker $constructor_marker) {
        this();
    }
}

