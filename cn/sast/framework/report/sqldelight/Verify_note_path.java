/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sqldelight.Verify_note_path
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.sqldelight;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0014"}, d2={"Lcn/sast/framework/report/sqldelight/Verify_note_path;", "", "id", "", "__note_array_hash_id", "<init>", "(JJ)V", "getId", "()J", "get__note_array_hash_id", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "corax-framework"})
public final class Verify_note_path {
    private final long id;
    private final long __note_array_hash_id;

    public Verify_note_path(long id, long __note_array_hash_id) {
        this.id = id;
        this.__note_array_hash_id = __note_array_hash_id;
    }

    public final long getId() {
        return this.id;
    }

    public final long get__note_array_hash_id() {
        return this.__note_array_hash_id;
    }

    public final long component1() {
        return this.id;
    }

    public final long component2() {
        return this.__note_array_hash_id;
    }

    @NotNull
    public final Verify_note_path copy(long id, long __note_array_hash_id) {
        return new Verify_note_path(id, __note_array_hash_id);
    }

    public static /* synthetic */ Verify_note_path copy$default(Verify_note_path verify_note_path, long l, long l2, int n, Object object) {
        if ((n & 1) != 0) {
            l = verify_note_path.id;
        }
        if ((n & 2) != 0) {
            l2 = verify_note_path.__note_array_hash_id;
        }
        return verify_note_path.copy(l, l2);
    }

    @NotNull
    public String toString() {
        return "Verify_note_path(id=" + this.id + ", __note_array_hash_id=" + this.__note_array_hash_id + ")";
    }

    public int hashCode() {
        int result = Long.hashCode(this.id);
        result = result * 31 + Long.hashCode(this.__note_array_hash_id);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Verify_note_path)) {
            return false;
        }
        Verify_note_path verify_note_path = (Verify_note_path)other;
        if (this.id != verify_note_path.id) {
            return false;
        }
        return this.__note_array_hash_id == verify_note_path.__note_array_hash_id;
    }
}

