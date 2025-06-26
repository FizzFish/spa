/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.validator.RowType
 *  cn.sast.framework.validator.RowUnknownType
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.validator;

import cn.sast.framework.validator.RowType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2={"Lcn/sast/framework/validator/RowUnknownType;", "Lcn/sast/framework/validator/RowType;", "type", "", "<init>", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "corax-framework"})
public final class RowUnknownType
extends RowType {
    @NotNull
    private final String type;

    public RowUnknownType(@NotNull String type) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        super(null);
        this.type = type;
    }

    @NotNull
    public String getType() {
        return this.type;
    }

    @NotNull
    public String toString() {
        return this.getType();
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    @NotNull
    public final RowUnknownType copy(@NotNull String type) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        return new RowUnknownType(type);
    }

    public static /* synthetic */ RowUnknownType copy$default(RowUnknownType rowUnknownType, String string, int n, Object object) {
        if ((n & 1) != 0) {
            string = rowUnknownType.type;
        }
        return rowUnknownType.copy(string);
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RowUnknownType)) {
            return false;
        }
        RowUnknownType rowUnknownType = (RowUnknownType)other;
        return Intrinsics.areEqual((Object)this.type, (Object)rowUnknownType.type);
    }
}

