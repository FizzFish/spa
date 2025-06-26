/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sqldelight.Diagnostic
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b@\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00b5\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0005H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\t\u00104\u001a\u00020\u0005H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0005H\u00c6\u0003J\t\u00108\u001a\u00020\u0005H\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u0010\u0010B\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u00e2\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010H\u001a\u00020IH\u00d6\u0001J\t\u0010J\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001aR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b.\u0010\u001fR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b/\u0010\u001f\u00a8\u0006K"}, d2={"Lcn/sast/framework/report/sqldelight/Diagnostic;", "", "id", "", "rule_name", "", "_rule_short_description_zh", "__file_id", "_file_abs_path", "_line", "_column", "_message_en", "_message_zh", "severity", "precision", "likelihood", "impact", "technique", "analysis_scope", "line_content", "__note_array_hash_id", "__control_flow_array_hash_id", "__macro_note_set_hash_id", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;)V", "getId", "()J", "getRule_name", "()Ljava/lang/String;", "get_rule_short_description_zh", "get__file_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "get_file_abs_path", "get_line", "get_column", "get_message_en", "get_message_zh", "getSeverity", "getPrecision", "getLikelihood", "getImpact", "getTechnique", "getAnalysis_scope", "getLine_content", "get__note_array_hash_id", "get__control_flow_array_hash_id", "get__macro_note_set_hash_id", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;)Lcn/sast/framework/report/sqldelight/Diagnostic;", "equals", "", "other", "hashCode", "", "toString", "corax-framework"})
public final class Diagnostic {
    private final long id;
    @NotNull
    private final String rule_name;
    @Nullable
    private final String _rule_short_description_zh;
    @Nullable
    private final Long __file_id;
    @NotNull
    private final String _file_abs_path;
    private final long _line;
    private final long _column;
    @NotNull
    private final String _message_en;
    @NotNull
    private final String _message_zh;
    @Nullable
    private final String severity;
    @Nullable
    private final String precision;
    @Nullable
    private final String likelihood;
    @Nullable
    private final String impact;
    @Nullable
    private final String technique;
    @Nullable
    private final String analysis_scope;
    @Nullable
    private final String line_content;
    private final long __note_array_hash_id;
    @Nullable
    private final Long __control_flow_array_hash_id;
    @Nullable
    private final Long __macro_note_set_hash_id;

    public Diagnostic(long id, @NotNull String rule_name, @Nullable String _rule_short_description_zh, @Nullable Long __file_id, @NotNull String _file_abs_path, long _line, long _column, @NotNull String _message_en, @NotNull String _message_zh, @Nullable String severity, @Nullable String precision, @Nullable String likelihood, @Nullable String impact, @Nullable String technique, @Nullable String analysis_scope, @Nullable String line_content, long __note_array_hash_id, @Nullable Long __control_flow_array_hash_id, @Nullable Long __macro_note_set_hash_id) {
        Intrinsics.checkNotNullParameter((Object)rule_name, (String)"rule_name");
        Intrinsics.checkNotNullParameter((Object)_file_abs_path, (String)"_file_abs_path");
        Intrinsics.checkNotNullParameter((Object)_message_en, (String)"_message_en");
        Intrinsics.checkNotNullParameter((Object)_message_zh, (String)"_message_zh");
        this.id = id;
        this.rule_name = rule_name;
        this._rule_short_description_zh = _rule_short_description_zh;
        this.__file_id = __file_id;
        this._file_abs_path = _file_abs_path;
        this._line = _line;
        this._column = _column;
        this._message_en = _message_en;
        this._message_zh = _message_zh;
        this.severity = severity;
        this.precision = precision;
        this.likelihood = likelihood;
        this.impact = impact;
        this.technique = technique;
        this.analysis_scope = analysis_scope;
        this.line_content = line_content;
        this.__note_array_hash_id = __note_array_hash_id;
        this.__control_flow_array_hash_id = __control_flow_array_hash_id;
        this.__macro_note_set_hash_id = __macro_note_set_hash_id;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getRule_name() {
        return this.rule_name;
    }

    @Nullable
    public final String get_rule_short_description_zh() {
        return this._rule_short_description_zh;
    }

    @Nullable
    public final Long get__file_id() {
        return this.__file_id;
    }

    @NotNull
    public final String get_file_abs_path() {
        return this._file_abs_path;
    }

    public final long get_line() {
        return this._line;
    }

    public final long get_column() {
        return this._column;
    }

    @NotNull
    public final String get_message_en() {
        return this._message_en;
    }

    @NotNull
    public final String get_message_zh() {
        return this._message_zh;
    }

    @Nullable
    public final String getSeverity() {
        return this.severity;
    }

    @Nullable
    public final String getPrecision() {
        return this.precision;
    }

    @Nullable
    public final String getLikelihood() {
        return this.likelihood;
    }

    @Nullable
    public final String getImpact() {
        return this.impact;
    }

    @Nullable
    public final String getTechnique() {
        return this.technique;
    }

    @Nullable
    public final String getAnalysis_scope() {
        return this.analysis_scope;
    }

    @Nullable
    public final String getLine_content() {
        return this.line_content;
    }

    public final long get__note_array_hash_id() {
        return this.__note_array_hash_id;
    }

    @Nullable
    public final Long get__control_flow_array_hash_id() {
        return this.__control_flow_array_hash_id;
    }

    @Nullable
    public final Long get__macro_note_set_hash_id() {
        return this.__macro_note_set_hash_id;
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.rule_name;
    }

    @Nullable
    public final String component3() {
        return this._rule_short_description_zh;
    }

    @Nullable
    public final Long component4() {
        return this.__file_id;
    }

    @NotNull
    public final String component5() {
        return this._file_abs_path;
    }

    public final long component6() {
        return this._line;
    }

    public final long component7() {
        return this._column;
    }

    @NotNull
    public final String component8() {
        return this._message_en;
    }

    @NotNull
    public final String component9() {
        return this._message_zh;
    }

    @Nullable
    public final String component10() {
        return this.severity;
    }

    @Nullable
    public final String component11() {
        return this.precision;
    }

    @Nullable
    public final String component12() {
        return this.likelihood;
    }

    @Nullable
    public final String component13() {
        return this.impact;
    }

    @Nullable
    public final String component14() {
        return this.technique;
    }

    @Nullable
    public final String component15() {
        return this.analysis_scope;
    }

    @Nullable
    public final String component16() {
        return this.line_content;
    }

    public final long component17() {
        return this.__note_array_hash_id;
    }

    @Nullable
    public final Long component18() {
        return this.__control_flow_array_hash_id;
    }

    @Nullable
    public final Long component19() {
        return this.__macro_note_set_hash_id;
    }

    @NotNull
    public final Diagnostic copy(long id, @NotNull String rule_name, @Nullable String _rule_short_description_zh, @Nullable Long __file_id, @NotNull String _file_abs_path, long _line, long _column, @NotNull String _message_en, @NotNull String _message_zh, @Nullable String severity, @Nullable String precision, @Nullable String likelihood, @Nullable String impact, @Nullable String technique, @Nullable String analysis_scope, @Nullable String line_content, long __note_array_hash_id, @Nullable Long __control_flow_array_hash_id, @Nullable Long __macro_note_set_hash_id) {
        Intrinsics.checkNotNullParameter((Object)rule_name, (String)"rule_name");
        Intrinsics.checkNotNullParameter((Object)_file_abs_path, (String)"_file_abs_path");
        Intrinsics.checkNotNullParameter((Object)_message_en, (String)"_message_en");
        Intrinsics.checkNotNullParameter((Object)_message_zh, (String)"_message_zh");
        return new Diagnostic(id, rule_name, _rule_short_description_zh, __file_id, _file_abs_path, _line, _column, _message_en, _message_zh, severity, precision, likelihood, impact, technique, analysis_scope, line_content, __note_array_hash_id, __control_flow_array_hash_id, __macro_note_set_hash_id);
    }

    public static /* synthetic */ Diagnostic copy$default(Diagnostic diagnostic, long l, String string, String string2, Long l2, String string3, long l3, long l4, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, long l5, Long l6, Long l7, int n, Object object) {
        if ((n & 1) != 0) {
            l = diagnostic.id;
        }
        if ((n & 2) != 0) {
            string = diagnostic.rule_name;
        }
        if ((n & 4) != 0) {
            string2 = diagnostic._rule_short_description_zh;
        }
        if ((n & 8) != 0) {
            l2 = diagnostic.__file_id;
        }
        if ((n & 0x10) != 0) {
            string3 = diagnostic._file_abs_path;
        }
        if ((n & 0x20) != 0) {
            l3 = diagnostic._line;
        }
        if ((n & 0x40) != 0) {
            l4 = diagnostic._column;
        }
        if ((n & 0x80) != 0) {
            string4 = diagnostic._message_en;
        }
        if ((n & 0x100) != 0) {
            string5 = diagnostic._message_zh;
        }
        if ((n & 0x200) != 0) {
            string6 = diagnostic.severity;
        }
        if ((n & 0x400) != 0) {
            string7 = diagnostic.precision;
        }
        if ((n & 0x800) != 0) {
            string8 = diagnostic.likelihood;
        }
        if ((n & 0x1000) != 0) {
            string9 = diagnostic.impact;
        }
        if ((n & 0x2000) != 0) {
            string10 = diagnostic.technique;
        }
        if ((n & 0x4000) != 0) {
            string11 = diagnostic.analysis_scope;
        }
        if ((n & 0x8000) != 0) {
            string12 = diagnostic.line_content;
        }
        if ((n & 0x10000) != 0) {
            l5 = diagnostic.__note_array_hash_id;
        }
        if ((n & 0x20000) != 0) {
            l6 = diagnostic.__control_flow_array_hash_id;
        }
        if ((n & 0x40000) != 0) {
            l7 = diagnostic.__macro_note_set_hash_id;
        }
        return diagnostic.copy(l, string, string2, l2, string3, l3, l4, string4, string5, string6, string7, string8, string9, string10, string11, string12, l5, l6, l7);
    }

    @NotNull
    public String toString() {
        return "Diagnostic(id=" + this.id + ", rule_name=" + this.rule_name + ", _rule_short_description_zh=" + this._rule_short_description_zh + ", __file_id=" + this.__file_id + ", _file_abs_path=" + this._file_abs_path + ", _line=" + this._line + ", _column=" + this._column + ", _message_en=" + this._message_en + ", _message_zh=" + this._message_zh + ", severity=" + this.severity + ", precision=" + this.precision + ", likelihood=" + this.likelihood + ", impact=" + this.impact + ", technique=" + this.technique + ", analysis_scope=" + this.analysis_scope + ", line_content=" + this.line_content + ", __note_array_hash_id=" + this.__note_array_hash_id + ", __control_flow_array_hash_id=" + this.__control_flow_array_hash_id + ", __macro_note_set_hash_id=" + this.__macro_note_set_hash_id + ")";
    }

    public int hashCode() {
        int result = Long.hashCode(this.id);
        result = result * 31 + this.rule_name.hashCode();
        result = result * 31 + (this._rule_short_description_zh == null ? 0 : this._rule_short_description_zh.hashCode());
        result = result * 31 + (this.__file_id == null ? 0 : ((Object)this.__file_id).hashCode());
        result = result * 31 + this._file_abs_path.hashCode();
        result = result * 31 + Long.hashCode(this._line);
        result = result * 31 + Long.hashCode(this._column);
        result = result * 31 + this._message_en.hashCode();
        result = result * 31 + this._message_zh.hashCode();
        result = result * 31 + (this.severity == null ? 0 : this.severity.hashCode());
        result = result * 31 + (this.precision == null ? 0 : this.precision.hashCode());
        result = result * 31 + (this.likelihood == null ? 0 : this.likelihood.hashCode());
        result = result * 31 + (this.impact == null ? 0 : this.impact.hashCode());
        result = result * 31 + (this.technique == null ? 0 : this.technique.hashCode());
        result = result * 31 + (this.analysis_scope == null ? 0 : this.analysis_scope.hashCode());
        result = result * 31 + (this.line_content == null ? 0 : this.line_content.hashCode());
        result = result * 31 + Long.hashCode(this.__note_array_hash_id);
        result = result * 31 + (this.__control_flow_array_hash_id == null ? 0 : ((Object)this.__control_flow_array_hash_id).hashCode());
        result = result * 31 + (this.__macro_note_set_hash_id == null ? 0 : ((Object)this.__macro_note_set_hash_id).hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Diagnostic)) {
            return false;
        }
        Diagnostic diagnostic = (Diagnostic)other;
        if (this.id != diagnostic.id) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.rule_name, (Object)diagnostic.rule_name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this._rule_short_description_zh, (Object)diagnostic._rule_short_description_zh)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.__file_id, (Object)diagnostic.__file_id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this._file_abs_path, (Object)diagnostic._file_abs_path)) {
            return false;
        }
        if (this._line != diagnostic._line) {
            return false;
        }
        if (this._column != diagnostic._column) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this._message_en, (Object)diagnostic._message_en)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this._message_zh, (Object)diagnostic._message_zh)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.severity, (Object)diagnostic.severity)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.precision, (Object)diagnostic.precision)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.likelihood, (Object)diagnostic.likelihood)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.impact, (Object)diagnostic.impact)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.technique, (Object)diagnostic.technique)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.analysis_scope, (Object)diagnostic.analysis_scope)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.line_content, (Object)diagnostic.line_content)) {
            return false;
        }
        if (this.__note_array_hash_id != diagnostic.__note_array_hash_id) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.__control_flow_array_hash_id, (Object)diagnostic.__control_flow_array_hash_id)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.__macro_note_set_hash_id, (Object)diagnostic.__macro_note_set_hash_id);
    }
}

