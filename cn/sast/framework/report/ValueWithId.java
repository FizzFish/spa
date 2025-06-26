/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.ValueWithId
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0004H\u00c6\u0003J\u000e\u0010\u000e\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000bJ(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u0000H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0018"}, d2={"Lcn/sast/framework/report/ValueWithId;", "T", "", "id", "", "value", "<init>", "(JLjava/lang/Object;)V", "getId", "()J", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(JLjava/lang/Object;)Lcn/sast/framework/report/ValueWithId;", "equals", "", "other", "hashCode", "", "toString", "", "corax-framework"})
final class ValueWithId<T> {
    private final long id;
    private final T value;

    public ValueWithId(long id, T value) {
        this.id = id;
        this.value = value;
    }

    public final long getId() {
        return this.id;
    }

    public final T getValue() {
        return (T)this.value;
    }

    public final long component1() {
        return this.id;
    }

    public final T component2() {
        return (T)this.value;
    }

    @NotNull
    public final ValueWithId<T> copy(long id, T value) {
        return new ValueWithId(id, value);
    }

    public static /* synthetic */ ValueWithId copy$default(ValueWithId valueWithId, long l, Object object, int n, Object object2) {
        if ((n & 1) != 0) {
            l = valueWithId.id;
        }
        if ((n & 2) != 0) {
            object = valueWithId.value;
        }
        return valueWithId.copy(l, object);
    }

    @NotNull
    public String toString() {
        return "ValueWithId(id=" + this.id + ", value=" + this.value + ")";
    }

    public int hashCode() {
        int result = Long.hashCode(this.id);
        result = result * 31 + (this.value == null ? 0 : this.value.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ValueWithId)) {
            return false;
        }
        ValueWithId valueWithId = (ValueWithId)other;
        if (this.id != valueWithId.id) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.value, (Object)valueWithId.value);
    }
}

