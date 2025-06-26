/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sqldelight.NoteExt
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u0018"}, d2={"Lcn/sast/framework/report/sqldelight/NoteExt;", "", "__note_id", "", "attr_name", "", "attr_value", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "get__note_id", "()J", "getAttr_name", "()Ljava/lang/String;", "getAttr_value", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "corax-framework"})
public final class NoteExt {
    private final long __note_id;
    @NotNull
    private final String attr_name;
    @NotNull
    private final String attr_value;

    public NoteExt(long __note_id, @NotNull String attr_name, @NotNull String attr_value) {
        Intrinsics.checkNotNullParameter((Object)attr_name, (String)"attr_name");
        Intrinsics.checkNotNullParameter((Object)attr_value, (String)"attr_value");
        this.__note_id = __note_id;
        this.attr_name = attr_name;
        this.attr_value = attr_value;
    }

    public final long get__note_id() {
        return this.__note_id;
    }

    @NotNull
    public final String getAttr_name() {
        return this.attr_name;
    }

    @NotNull
    public final String getAttr_value() {
        return this.attr_value;
    }

    public final long component1() {
        return this.__note_id;
    }

    @NotNull
    public final String component2() {
        return this.attr_name;
    }

    @NotNull
    public final String component3() {
        return this.attr_value;
    }

    @NotNull
    public final NoteExt copy(long __note_id, @NotNull String attr_name, @NotNull String attr_value) {
        Intrinsics.checkNotNullParameter((Object)attr_name, (String)"attr_name");
        Intrinsics.checkNotNullParameter((Object)attr_value, (String)"attr_value");
        return new NoteExt(__note_id, attr_name, attr_value);
    }

    public static /* synthetic */ NoteExt copy$default(NoteExt noteExt, long l, String string, String string2, int n, Object object) {
        if ((n & 1) != 0) {
            l = noteExt.__note_id;
        }
        if ((n & 2) != 0) {
            string = noteExt.attr_name;
        }
        if ((n & 4) != 0) {
            string2 = noteExt.attr_value;
        }
        return noteExt.copy(l, string, string2);
    }

    @NotNull
    public String toString() {
        return "NoteExt(__note_id=" + this.__note_id + ", attr_name=" + this.attr_name + ", attr_value=" + this.attr_value + ")";
    }

    public int hashCode() {
        int result = Long.hashCode(this.__note_id);
        result = result * 31 + this.attr_name.hashCode();
        result = result * 31 + this.attr_value.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NoteExt)) {
            return false;
        }
        NoteExt noteExt = (NoteExt)other;
        if (this.__note_id != noteExt.__note_id) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.attr_name, (Object)noteExt.attr_name)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.attr_value, (Object)noteExt.attr_value);
    }
}

