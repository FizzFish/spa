/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sqldelight.SchemaInfo
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.sqldelight;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0013"}, d2={"Lcn/sast/framework/report/sqldelight/SchemaInfo;", "", "key", "", "value_", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getValue_", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "corax-framework"})
public final class SchemaInfo {
    @NotNull
    private final String key;
    @NotNull
    private final String value_;

    public SchemaInfo(@NotNull String key2, @NotNull String value_) {
        Intrinsics.checkNotNullParameter((Object)key2, (String)"key");
        Intrinsics.checkNotNullParameter((Object)value_, (String)"value_");
        this.key = key2;
        this.value_ = value_;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @NotNull
    public final String getValue_() {
        return this.value_;
    }

    @NotNull
    public final String component1() {
        return this.key;
    }

    @NotNull
    public final String component2() {
        return this.value_;
    }

    @NotNull
    public final SchemaInfo copy(@NotNull String key2, @NotNull String value_) {
        Intrinsics.checkNotNullParameter((Object)key2, (String)"key");
        Intrinsics.checkNotNullParameter((Object)value_, (String)"value_");
        return new SchemaInfo(key2, value_);
    }

    public static /* synthetic */ SchemaInfo copy$default(SchemaInfo schemaInfo, String string, String string2, int n, Object object) {
        if ((n & 1) != 0) {
            string = schemaInfo.key;
        }
        if ((n & 2) != 0) {
            string2 = schemaInfo.value_;
        }
        return schemaInfo.copy(string, string2);
    }

    @NotNull
    public String toString() {
        return "SchemaInfo(key=" + this.key + ", value_=" + this.value_ + ")";
    }

    public int hashCode() {
        int result = this.key.hashCode();
        result = result * 31 + this.value_.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SchemaInfo)) {
            return false;
        }
        SchemaInfo schemaInfo = (SchemaInfo)other;
        if (!Intrinsics.areEqual((Object)this.key, (Object)schemaInfo.key)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.value_, (Object)schemaInfo.value_);
    }
}

