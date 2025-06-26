/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sqldelight.NotePath
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003JD\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b\u00a8\u0006 "}, d2={"Lcn/sast/framework/report/sqldelight/NotePath;", "", "__note_array_hash_id", "", "note_sequence", "note_stack_depth", "note_is_key_event", "__note_id", "<init>", "(JJLjava/lang/Long;Ljava/lang/Long;J)V", "get__note_array_hash_id", "()J", "getNote_sequence", "getNote_stack_depth", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNote_is_key_event", "get__note_id", "component1", "component2", "component3", "component4", "component5", "copy", "(JJLjava/lang/Long;Ljava/lang/Long;J)Lcn/sast/framework/report/sqldelight/NotePath;", "equals", "", "other", "hashCode", "", "toString", "", "corax-framework"})
public final class NotePath {
    private final long __note_array_hash_id;
    private final long note_sequence;
    @Nullable
    private final Long note_stack_depth;
    @Nullable
    private final Long note_is_key_event;
    private final long __note_id;

    public NotePath(long __note_array_hash_id, long note_sequence, @Nullable Long note_stack_depth, @Nullable Long note_is_key_event, long __note_id) {
        this.__note_array_hash_id = __note_array_hash_id;
        this.note_sequence = note_sequence;
        this.note_stack_depth = note_stack_depth;
        this.note_is_key_event = note_is_key_event;
        this.__note_id = __note_id;
    }

    public final long get__note_array_hash_id() {
        return this.__note_array_hash_id;
    }

    public final long getNote_sequence() {
        return this.note_sequence;
    }

    @Nullable
    public final Long getNote_stack_depth() {
        return this.note_stack_depth;
    }

    @Nullable
    public final Long getNote_is_key_event() {
        return this.note_is_key_event;
    }

    public final long get__note_id() {
        return this.__note_id;
    }

    public final long component1() {
        return this.__note_array_hash_id;
    }

    public final long component2() {
        return this.note_sequence;
    }

    @Nullable
    public final Long component3() {
        return this.note_stack_depth;
    }

    @Nullable
    public final Long component4() {
        return this.note_is_key_event;
    }

    public final long component5() {
        return this.__note_id;
    }

    @NotNull
    public final NotePath copy(long __note_array_hash_id, long note_sequence, @Nullable Long note_stack_depth, @Nullable Long note_is_key_event, long __note_id) {
        return new NotePath(__note_array_hash_id, note_sequence, note_stack_depth, note_is_key_event, __note_id);
    }

    public static /* synthetic */ NotePath copy$default(NotePath notePath, long l, long l2, Long l3, Long l4, long l5, int n, Object object) {
        if ((n & 1) != 0) {
            l = notePath.__note_array_hash_id;
        }
        if ((n & 2) != 0) {
            l2 = notePath.note_sequence;
        }
        if ((n & 4) != 0) {
            l3 = notePath.note_stack_depth;
        }
        if ((n & 8) != 0) {
            l4 = notePath.note_is_key_event;
        }
        if ((n & 0x10) != 0) {
            l5 = notePath.__note_id;
        }
        return notePath.copy(l, l2, l3, l4, l5);
    }

    @NotNull
    public String toString() {
        return "NotePath(__note_array_hash_id=" + this.__note_array_hash_id + ", note_sequence=" + this.note_sequence + ", note_stack_depth=" + this.note_stack_depth + ", note_is_key_event=" + this.note_is_key_event + ", __note_id=" + this.__note_id + ")";
    }

    public int hashCode() {
        int result = Long.hashCode(this.__note_array_hash_id);
        result = result * 31 + Long.hashCode(this.note_sequence);
        result = result * 31 + (this.note_stack_depth == null ? 0 : ((Object)this.note_stack_depth).hashCode());
        result = result * 31 + (this.note_is_key_event == null ? 0 : ((Object)this.note_is_key_event).hashCode());
        result = result * 31 + Long.hashCode(this.__note_id);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotePath)) {
            return false;
        }
        NotePath notePath = (NotePath)other;
        if (this.__note_array_hash_id != notePath.__note_array_hash_id) {
            return false;
        }
        if (this.note_sequence != notePath.note_sequence) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.note_stack_depth, (Object)notePath.note_stack_depth)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.note_is_key_event, (Object)notePath.note_is_key_event)) {
            return false;
        }
        return this.__note_id == notePath.__note_id;
    }
}

