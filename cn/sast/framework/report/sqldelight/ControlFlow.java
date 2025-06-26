/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sqldelight.ControlFlow
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003JS\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e\u00a8\u0006$"}, d2={"Lcn/sast/framework/report/sqldelight/ControlFlow;", "", "id", "", "__file_id", "_file_abs_path", "", "message_en", "message_zh", "__edge_from_region_id", "__edge_to_region_id", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getId", "()J", "get__file_id", "get_file_abs_path", "()Ljava/lang/String;", "getMessage_en", "getMessage_zh", "get__edge_from_region_id", "get__edge_to_region_id", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "corax-framework"})
public final class ControlFlow {
    private final long id;
    private final long __file_id;
    @NotNull
    private final String _file_abs_path;
    @Nullable
    private final String message_en;
    @Nullable
    private final String message_zh;
    private final long __edge_from_region_id;
    private final long __edge_to_region_id;

    public ControlFlow(long id, long __file_id, @NotNull String _file_abs_path, @Nullable String message_en, @Nullable String message_zh, long __edge_from_region_id, long __edge_to_region_id) {
        Intrinsics.checkNotNullParameter((Object)_file_abs_path, (String)"_file_abs_path");
        this.id = id;
        this.__file_id = __file_id;
        this._file_abs_path = _file_abs_path;
        this.message_en = message_en;
        this.message_zh = message_zh;
        this.__edge_from_region_id = __edge_from_region_id;
        this.__edge_to_region_id = __edge_to_region_id;
    }

    public final long getId() {
        return this.id;
    }

    public final long get__file_id() {
        return this.__file_id;
    }

    @NotNull
    public final String get_file_abs_path() {
        return this._file_abs_path;
    }

    @Nullable
    public final String getMessage_en() {
        return this.message_en;
    }

    @Nullable
    public final String getMessage_zh() {
        return this.message_zh;
    }

    public final long get__edge_from_region_id() {
        return this.__edge_from_region_id;
    }

    public final long get__edge_to_region_id() {
        return this.__edge_to_region_id;
    }

    public final long component1() {
        return this.id;
    }

    public final long component2() {
        return this.__file_id;
    }

    @NotNull
    public final String component3() {
        return this._file_abs_path;
    }

    @Nullable
    public final String component4() {
        return this.message_en;
    }

    @Nullable
    public final String component5() {
        return this.message_zh;
    }

    public final long component6() {
        return this.__edge_from_region_id;
    }

    public final long component7() {
        return this.__edge_to_region_id;
    }

    @NotNull
    public final ControlFlow copy(long id, long __file_id, @NotNull String _file_abs_path, @Nullable String message_en, @Nullable String message_zh, long __edge_from_region_id, long __edge_to_region_id) {
        Intrinsics.checkNotNullParameter((Object)_file_abs_path, (String)"_file_abs_path");
        return new ControlFlow(id, __file_id, _file_abs_path, message_en, message_zh, __edge_from_region_id, __edge_to_region_id);
    }

    public static /* synthetic */ ControlFlow copy$default(ControlFlow controlFlow, long l, long l2, String string, String string2, String string3, long l3, long l4, int n, Object object) {
        if ((n & 1) != 0) {
            l = controlFlow.id;
        }
        if ((n & 2) != 0) {
            l2 = controlFlow.__file_id;
        }
        if ((n & 4) != 0) {
            string = controlFlow._file_abs_path;
        }
        if ((n & 8) != 0) {
            string2 = controlFlow.message_en;
        }
        if ((n & 0x10) != 0) {
            string3 = controlFlow.message_zh;
        }
        if ((n & 0x20) != 0) {
            l3 = controlFlow.__edge_from_region_id;
        }
        if ((n & 0x40) != 0) {
            l4 = controlFlow.__edge_to_region_id;
        }
        return controlFlow.copy(l, l2, string, string2, string3, l3, l4);
    }

    @NotNull
    public String toString() {
        return "ControlFlow(id=" + this.id + ", __file_id=" + this.__file_id + ", _file_abs_path=" + this._file_abs_path + ", message_en=" + this.message_en + ", message_zh=" + this.message_zh + ", __edge_from_region_id=" + this.__edge_from_region_id + ", __edge_to_region_id=" + this.__edge_to_region_id + ")";
    }

    public int hashCode() {
        int result = Long.hashCode(this.id);
        result = result * 31 + Long.hashCode(this.__file_id);
        result = result * 31 + this._file_abs_path.hashCode();
        result = result * 31 + (this.message_en == null ? 0 : this.message_en.hashCode());
        result = result * 31 + (this.message_zh == null ? 0 : this.message_zh.hashCode());
        result = result * 31 + Long.hashCode(this.__edge_from_region_id);
        result = result * 31 + Long.hashCode(this.__edge_to_region_id);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ControlFlow)) {
            return false;
        }
        ControlFlow controlFlow = (ControlFlow)other;
        if (this.id != controlFlow.id) {
            return false;
        }
        if (this.__file_id != controlFlow.__file_id) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this._file_abs_path, (Object)controlFlow._file_abs_path)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.message_en, (Object)controlFlow.message_en)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.message_zh, (Object)controlFlow.message_zh)) {
            return false;
        }
        if (this.__edge_from_region_id != controlFlow.__edge_from_region_id) {
            return false;
        }
        return this.__edge_to_region_id == controlFlow.__edge_to_region_id;
    }
}

