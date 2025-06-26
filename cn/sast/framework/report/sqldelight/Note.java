/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sqldelight.Note
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\t\u0010'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\u0082\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u000201H\u00d6\u0001J\t\u00102\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u001aR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001f\u0010\u001a\u00a8\u00063"}, d2={"Lcn/sast/framework/report/sqldelight/Note;", "", "id", "", "kind", "", "display_hint", "__file_id", "_file_abs_path", "line", "column", "message_en", "message_zh", "__notices_region_id", "__func_region_id", "<init>", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getId", "()J", "getKind", "()Ljava/lang/String;", "getDisplay_hint", "get__file_id", "get_file_abs_path", "getLine", "getColumn", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMessage_en", "getMessage_zh", "get__notices_region_id", "get__func_region_id", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcn/sast/framework/report/sqldelight/Note;", "equals", "", "other", "hashCode", "", "toString", "corax-framework"})
public final class Note {
    private final long id;
    @NotNull
    private final String kind;
    @NotNull
    private final String display_hint;
    private final long __file_id;
    @NotNull
    private final String _file_abs_path;
    private final long line;
    @Nullable
    private final Long column;
    @NotNull
    private final String message_en;
    @NotNull
    private final String message_zh;
    @Nullable
    private final Long __notices_region_id;
    @Nullable
    private final Long __func_region_id;

    public Note(long id, @NotNull String kind, @NotNull String display_hint, long __file_id, @NotNull String _file_abs_path, long line, @Nullable Long column, @NotNull String message_en, @NotNull String message_zh, @Nullable Long __notices_region_id, @Nullable Long __func_region_id) {
        Intrinsics.checkNotNullParameter((Object)kind, (String)"kind");
        Intrinsics.checkNotNullParameter((Object)display_hint, (String)"display_hint");
        Intrinsics.checkNotNullParameter((Object)_file_abs_path, (String)"_file_abs_path");
        Intrinsics.checkNotNullParameter((Object)message_en, (String)"message_en");
        Intrinsics.checkNotNullParameter((Object)message_zh, (String)"message_zh");
        this.id = id;
        this.kind = kind;
        this.display_hint = display_hint;
        this.__file_id = __file_id;
        this._file_abs_path = _file_abs_path;
        this.line = line;
        this.column = column;
        this.message_en = message_en;
        this.message_zh = message_zh;
        this.__notices_region_id = __notices_region_id;
        this.__func_region_id = __func_region_id;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getKind() {
        return this.kind;
    }

    @NotNull
    public final String getDisplay_hint() {
        return this.display_hint;
    }

    public final long get__file_id() {
        return this.__file_id;
    }

    @NotNull
    public final String get_file_abs_path() {
        return this._file_abs_path;
    }

    public final long getLine() {
        return this.line;
    }

    @Nullable
    public final Long getColumn() {
        return this.column;
    }

    @NotNull
    public final String getMessage_en() {
        return this.message_en;
    }

    @NotNull
    public final String getMessage_zh() {
        return this.message_zh;
    }

    @Nullable
    public final Long get__notices_region_id() {
        return this.__notices_region_id;
    }

    @Nullable
    public final Long get__func_region_id() {
        return this.__func_region_id;
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.kind;
    }

    @NotNull
    public final String component3() {
        return this.display_hint;
    }

    public final long component4() {
        return this.__file_id;
    }

    @NotNull
    public final String component5() {
        return this._file_abs_path;
    }

    public final long component6() {
        return this.line;
    }

    @Nullable
    public final Long component7() {
        return this.column;
    }

    @NotNull
    public final String component8() {
        return this.message_en;
    }

    @NotNull
    public final String component9() {
        return this.message_zh;
    }

    @Nullable
    public final Long component10() {
        return this.__notices_region_id;
    }

    @Nullable
    public final Long component11() {
        return this.__func_region_id;
    }

    @NotNull
    public final Note copy(long id, @NotNull String kind, @NotNull String display_hint, long __file_id, @NotNull String _file_abs_path, long line, @Nullable Long column, @NotNull String message_en, @NotNull String message_zh, @Nullable Long __notices_region_id, @Nullable Long __func_region_id) {
        Intrinsics.checkNotNullParameter((Object)kind, (String)"kind");
        Intrinsics.checkNotNullParameter((Object)display_hint, (String)"display_hint");
        Intrinsics.checkNotNullParameter((Object)_file_abs_path, (String)"_file_abs_path");
        Intrinsics.checkNotNullParameter((Object)message_en, (String)"message_en");
        Intrinsics.checkNotNullParameter((Object)message_zh, (String)"message_zh");
        return new Note(id, kind, display_hint, __file_id, _file_abs_path, line, column, message_en, message_zh, __notices_region_id, __func_region_id);
    }

    public static /* synthetic */ Note copy$default(Note note, long l, String string, String string2, long l2, String string3, long l3, Long l4, String string4, String string5, Long l5, Long l6, int n, Object object) {
        if ((n & 1) != 0) {
            l = note.id;
        }
        if ((n & 2) != 0) {
            string = note.kind;
        }
        if ((n & 4) != 0) {
            string2 = note.display_hint;
        }
        if ((n & 8) != 0) {
            l2 = note.__file_id;
        }
        if ((n & 0x10) != 0) {
            string3 = note._file_abs_path;
        }
        if ((n & 0x20) != 0) {
            l3 = note.line;
        }
        if ((n & 0x40) != 0) {
            l4 = note.column;
        }
        if ((n & 0x80) != 0) {
            string4 = note.message_en;
        }
        if ((n & 0x100) != 0) {
            string5 = note.message_zh;
        }
        if ((n & 0x200) != 0) {
            l5 = note.__notices_region_id;
        }
        if ((n & 0x400) != 0) {
            l6 = note.__func_region_id;
        }
        return note.copy(l, string, string2, l2, string3, l3, l4, string4, string5, l5, l6);
    }

    @NotNull
    public String toString() {
        return "Note(id=" + this.id + ", kind=" + this.kind + ", display_hint=" + this.display_hint + ", __file_id=" + this.__file_id + ", _file_abs_path=" + this._file_abs_path + ", line=" + this.line + ", column=" + this.column + ", message_en=" + this.message_en + ", message_zh=" + this.message_zh + ", __notices_region_id=" + this.__notices_region_id + ", __func_region_id=" + this.__func_region_id + ")";
    }

    public int hashCode() {
        int result = Long.hashCode(this.id);
        result = result * 31 + this.kind.hashCode();
        result = result * 31 + this.display_hint.hashCode();
        result = result * 31 + Long.hashCode(this.__file_id);
        result = result * 31 + this._file_abs_path.hashCode();
        result = result * 31 + Long.hashCode(this.line);
        result = result * 31 + (this.column == null ? 0 : ((Object)this.column).hashCode());
        result = result * 31 + this.message_en.hashCode();
        result = result * 31 + this.message_zh.hashCode();
        result = result * 31 + (this.__notices_region_id == null ? 0 : ((Object)this.__notices_region_id).hashCode());
        result = result * 31 + (this.__func_region_id == null ? 0 : ((Object)this.__func_region_id).hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Note)) {
            return false;
        }
        Note note = (Note)other;
        if (this.id != note.id) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.kind, (Object)note.kind)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.display_hint, (Object)note.display_hint)) {
            return false;
        }
        if (this.__file_id != note.__file_id) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this._file_abs_path, (Object)note._file_abs_path)) {
            return false;
        }
        if (this.line != note.line) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.column, (Object)note.column)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.message_en, (Object)note.message_en)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.message_zh, (Object)note.message_zh)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.__notices_region_id, (Object)note.__notices_region_id)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.__func_region_id, (Object)note.__func_region_id);
    }
}

