/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sqldelight.Rule
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\bN\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u00a2\u0006\u0004\b \u0010!J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0002\u00101J\u0010\u0010O\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0002\u00101J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010R\u001a\u00020\u0003H\u00c6\u0003J\t\u0010S\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0002\u00101J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010Y\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010[\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\\\u001a\u00020\u0003H\u00c6\u0003J\u00cc\u0002\u0010]\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010^J\u0013\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010b\u001a\u00020cH\u00d6\u0001J\t\u0010d\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010#R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\n\n\u0002\u00102\u001a\u0004\b3\u00101R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010#R\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010#R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\n\n\u0002\u00102\u001a\u0004\b8\u00101R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010#R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010#R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010#R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010#R\u0011\u0010\u001c\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010#R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010#R\u0011\u0010\u001e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010#R\u0011\u0010\u001f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010#\u00a8\u0006e"}, d2={"Lcn/sast/framework/report/sqldelight/Rule;", "", "name", "", "short_description_en", "short_description_zh", "severity", "priority", "language", "precision", "recall", "likelihood", "impact", "technique", "analysis_scope", "performance", "configurable", "", "implemented", "static_analyzability", "c_allocated_target", "category_en", "category_zh", "rule_sort_number", "chapter_name_1", "chapter_name_2", "chapter_name_3", "chapter_name_4", "description_en", "description_zh", "document_en", "document_zh", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getShort_description_en", "getShort_description_zh", "getSeverity", "getPriority", "getLanguage", "getPrecision", "getRecall", "getLikelihood", "getImpact", "getTechnique", "getAnalysis_scope", "getPerformance", "getConfigurable", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getImplemented", "getStatic_analyzability", "getC_allocated_target", "getCategory_en", "getCategory_zh", "getRule_sort_number", "getChapter_name_1", "getChapter_name_2", "getChapter_name_3", "getChapter_name_4", "getDescription_en", "getDescription_zh", "getDocument_en", "getDocument_zh", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcn/sast/framework/report/sqldelight/Rule;", "equals", "", "other", "hashCode", "", "toString", "corax-framework"})
public final class Rule {
    @NotNull
    private final String name;
    @NotNull
    private final String short_description_en;
    @NotNull
    private final String short_description_zh;
    @Nullable
    private final String severity;
    @Nullable
    private final String priority;
    @NotNull
    private final String language;
    @Nullable
    private final String precision;
    @Nullable
    private final String recall;
    @Nullable
    private final String likelihood;
    @Nullable
    private final String impact;
    @Nullable
    private final String technique;
    @Nullable
    private final String analysis_scope;
    @Nullable
    private final String performance;
    @Nullable
    private final Long configurable;
    @Nullable
    private final Long implemented;
    @Nullable
    private final String static_analyzability;
    @Nullable
    private final String c_allocated_target;
    @NotNull
    private final String category_en;
    @NotNull
    private final String category_zh;
    @Nullable
    private final Long rule_sort_number;
    @Nullable
    private final String chapter_name_1;
    @Nullable
    private final String chapter_name_2;
    @Nullable
    private final String chapter_name_3;
    @Nullable
    private final String chapter_name_4;
    @NotNull
    private final String description_en;
    @Nullable
    private final String description_zh;
    @NotNull
    private final String document_en;
    @NotNull
    private final String document_zh;

    public Rule(@NotNull String name, @NotNull String short_description_en, @NotNull String short_description_zh, @Nullable String severity, @Nullable String priority, @NotNull String language, @Nullable String precision, @Nullable String recall, @Nullable String likelihood, @Nullable String impact, @Nullable String technique, @Nullable String analysis_scope, @Nullable String performance, @Nullable Long configurable, @Nullable Long implemented, @Nullable String static_analyzability, @Nullable String c_allocated_target, @NotNull String category_en, @NotNull String category_zh, @Nullable Long rule_sort_number, @Nullable String chapter_name_1, @Nullable String chapter_name_2, @Nullable String chapter_name_3, @Nullable String chapter_name_4, @NotNull String description_en, @Nullable String description_zh, @NotNull String document_en, @NotNull String document_zh) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)short_description_en, (String)"short_description_en");
        Intrinsics.checkNotNullParameter((Object)short_description_zh, (String)"short_description_zh");
        Intrinsics.checkNotNullParameter((Object)language, (String)"language");
        Intrinsics.checkNotNullParameter((Object)category_en, (String)"category_en");
        Intrinsics.checkNotNullParameter((Object)category_zh, (String)"category_zh");
        Intrinsics.checkNotNullParameter((Object)description_en, (String)"description_en");
        Intrinsics.checkNotNullParameter((Object)document_en, (String)"document_en");
        Intrinsics.checkNotNullParameter((Object)document_zh, (String)"document_zh");
        this.name = name;
        this.short_description_en = short_description_en;
        this.short_description_zh = short_description_zh;
        this.severity = severity;
        this.priority = priority;
        this.language = language;
        this.precision = precision;
        this.recall = recall;
        this.likelihood = likelihood;
        this.impact = impact;
        this.technique = technique;
        this.analysis_scope = analysis_scope;
        this.performance = performance;
        this.configurable = configurable;
        this.implemented = implemented;
        this.static_analyzability = static_analyzability;
        this.c_allocated_target = c_allocated_target;
        this.category_en = category_en;
        this.category_zh = category_zh;
        this.rule_sort_number = rule_sort_number;
        this.chapter_name_1 = chapter_name_1;
        this.chapter_name_2 = chapter_name_2;
        this.chapter_name_3 = chapter_name_3;
        this.chapter_name_4 = chapter_name_4;
        this.description_en = description_en;
        this.description_zh = description_zh;
        this.document_en = document_en;
        this.document_zh = document_zh;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getShort_description_en() {
        return this.short_description_en;
    }

    @NotNull
    public final String getShort_description_zh() {
        return this.short_description_zh;
    }

    @Nullable
    public final String getSeverity() {
        return this.severity;
    }

    @Nullable
    public final String getPriority() {
        return this.priority;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final String getPrecision() {
        return this.precision;
    }

    @Nullable
    public final String getRecall() {
        return this.recall;
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
    public final String getPerformance() {
        return this.performance;
    }

    @Nullable
    public final Long getConfigurable() {
        return this.configurable;
    }

    @Nullable
    public final Long getImplemented() {
        return this.implemented;
    }

    @Nullable
    public final String getStatic_analyzability() {
        return this.static_analyzability;
    }

    @Nullable
    public final String getC_allocated_target() {
        return this.c_allocated_target;
    }

    @NotNull
    public final String getCategory_en() {
        return this.category_en;
    }

    @NotNull
    public final String getCategory_zh() {
        return this.category_zh;
    }

    @Nullable
    public final Long getRule_sort_number() {
        return this.rule_sort_number;
    }

    @Nullable
    public final String getChapter_name_1() {
        return this.chapter_name_1;
    }

    @Nullable
    public final String getChapter_name_2() {
        return this.chapter_name_2;
    }

    @Nullable
    public final String getChapter_name_3() {
        return this.chapter_name_3;
    }

    @Nullable
    public final String getChapter_name_4() {
        return this.chapter_name_4;
    }

    @NotNull
    public final String getDescription_en() {
        return this.description_en;
    }

    @Nullable
    public final String getDescription_zh() {
        return this.description_zh;
    }

    @NotNull
    public final String getDocument_en() {
        return this.document_en;
    }

    @NotNull
    public final String getDocument_zh() {
        return this.document_zh;
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.short_description_en;
    }

    @NotNull
    public final String component3() {
        return this.short_description_zh;
    }

    @Nullable
    public final String component4() {
        return this.severity;
    }

    @Nullable
    public final String component5() {
        return this.priority;
    }

    @NotNull
    public final String component6() {
        return this.language;
    }

    @Nullable
    public final String component7() {
        return this.precision;
    }

    @Nullable
    public final String component8() {
        return this.recall;
    }

    @Nullable
    public final String component9() {
        return this.likelihood;
    }

    @Nullable
    public final String component10() {
        return this.impact;
    }

    @Nullable
    public final String component11() {
        return this.technique;
    }

    @Nullable
    public final String component12() {
        return this.analysis_scope;
    }

    @Nullable
    public final String component13() {
        return this.performance;
    }

    @Nullable
    public final Long component14() {
        return this.configurable;
    }

    @Nullable
    public final Long component15() {
        return this.implemented;
    }

    @Nullable
    public final String component16() {
        return this.static_analyzability;
    }

    @Nullable
    public final String component17() {
        return this.c_allocated_target;
    }

    @NotNull
    public final String component18() {
        return this.category_en;
    }

    @NotNull
    public final String component19() {
        return this.category_zh;
    }

    @Nullable
    public final Long component20() {
        return this.rule_sort_number;
    }

    @Nullable
    public final String component21() {
        return this.chapter_name_1;
    }

    @Nullable
    public final String component22() {
        return this.chapter_name_2;
    }

    @Nullable
    public final String component23() {
        return this.chapter_name_3;
    }

    @Nullable
    public final String component24() {
        return this.chapter_name_4;
    }

    @NotNull
    public final String component25() {
        return this.description_en;
    }

    @Nullable
    public final String component26() {
        return this.description_zh;
    }

    @NotNull
    public final String component27() {
        return this.document_en;
    }

    @NotNull
    public final String component28() {
        return this.document_zh;
    }

    @NotNull
    public final Rule copy(@NotNull String name, @NotNull String short_description_en, @NotNull String short_description_zh, @Nullable String severity, @Nullable String priority, @NotNull String language, @Nullable String precision, @Nullable String recall, @Nullable String likelihood, @Nullable String impact, @Nullable String technique, @Nullable String analysis_scope, @Nullable String performance, @Nullable Long configurable, @Nullable Long implemented, @Nullable String static_analyzability, @Nullable String c_allocated_target, @NotNull String category_en, @NotNull String category_zh, @Nullable Long rule_sort_number, @Nullable String chapter_name_1, @Nullable String chapter_name_2, @Nullable String chapter_name_3, @Nullable String chapter_name_4, @NotNull String description_en, @Nullable String description_zh, @NotNull String document_en, @NotNull String document_zh) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)short_description_en, (String)"short_description_en");
        Intrinsics.checkNotNullParameter((Object)short_description_zh, (String)"short_description_zh");
        Intrinsics.checkNotNullParameter((Object)language, (String)"language");
        Intrinsics.checkNotNullParameter((Object)category_en, (String)"category_en");
        Intrinsics.checkNotNullParameter((Object)category_zh, (String)"category_zh");
        Intrinsics.checkNotNullParameter((Object)description_en, (String)"description_en");
        Intrinsics.checkNotNullParameter((Object)document_en, (String)"document_en");
        Intrinsics.checkNotNullParameter((Object)document_zh, (String)"document_zh");
        return new Rule(name, short_description_en, short_description_zh, severity, priority, language, precision, recall, likelihood, impact, technique, analysis_scope, performance, configurable, implemented, static_analyzability, c_allocated_target, category_en, category_zh, rule_sort_number, chapter_name_1, chapter_name_2, chapter_name_3, chapter_name_4, description_en, description_zh, document_en, document_zh);
    }

    public static /* synthetic */ Rule copy$default(Rule rule, String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, Long l, Long l2, String string14, String string15, String string16, String string17, Long l3, String string18, String string19, String string20, String string21, String string22, String string23, String string24, String string25, int n, Object object) {
        if ((n & 1) != 0) {
            string = rule.name;
        }
        if ((n & 2) != 0) {
            string2 = rule.short_description_en;
        }
        if ((n & 4) != 0) {
            string3 = rule.short_description_zh;
        }
        if ((n & 8) != 0) {
            string4 = rule.severity;
        }
        if ((n & 0x10) != 0) {
            string5 = rule.priority;
        }
        if ((n & 0x20) != 0) {
            string6 = rule.language;
        }
        if ((n & 0x40) != 0) {
            string7 = rule.precision;
        }
        if ((n & 0x80) != 0) {
            string8 = rule.recall;
        }
        if ((n & 0x100) != 0) {
            string9 = rule.likelihood;
        }
        if ((n & 0x200) != 0) {
            string10 = rule.impact;
        }
        if ((n & 0x400) != 0) {
            string11 = rule.technique;
        }
        if ((n & 0x800) != 0) {
            string12 = rule.analysis_scope;
        }
        if ((n & 0x1000) != 0) {
            string13 = rule.performance;
        }
        if ((n & 0x2000) != 0) {
            l = rule.configurable;
        }
        if ((n & 0x4000) != 0) {
            l2 = rule.implemented;
        }
        if ((n & 0x8000) != 0) {
            string14 = rule.static_analyzability;
        }
        if ((n & 0x10000) != 0) {
            string15 = rule.c_allocated_target;
        }
        if ((n & 0x20000) != 0) {
            string16 = rule.category_en;
        }
        if ((n & 0x40000) != 0) {
            string17 = rule.category_zh;
        }
        if ((n & 0x80000) != 0) {
            l3 = rule.rule_sort_number;
        }
        if ((n & 0x100000) != 0) {
            string18 = rule.chapter_name_1;
        }
        if ((n & 0x200000) != 0) {
            string19 = rule.chapter_name_2;
        }
        if ((n & 0x400000) != 0) {
            string20 = rule.chapter_name_3;
        }
        if ((n & 0x800000) != 0) {
            string21 = rule.chapter_name_4;
        }
        if ((n & 0x1000000) != 0) {
            string22 = rule.description_en;
        }
        if ((n & 0x2000000) != 0) {
            string23 = rule.description_zh;
        }
        if ((n & 0x4000000) != 0) {
            string24 = rule.document_en;
        }
        if ((n & 0x8000000) != 0) {
            string25 = rule.document_zh;
        }
        return rule.copy(string, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, l, l2, string14, string15, string16, string17, l3, string18, string19, string20, string21, string22, string23, string24, string25);
    }

    @NotNull
    public String toString() {
        return "Rule(name=" + this.name + ", short_description_en=" + this.short_description_en + ", short_description_zh=" + this.short_description_zh + ", severity=" + this.severity + ", priority=" + this.priority + ", language=" + this.language + ", precision=" + this.precision + ", recall=" + this.recall + ", likelihood=" + this.likelihood + ", impact=" + this.impact + ", technique=" + this.technique + ", analysis_scope=" + this.analysis_scope + ", performance=" + this.performance + ", configurable=" + this.configurable + ", implemented=" + this.implemented + ", static_analyzability=" + this.static_analyzability + ", c_allocated_target=" + this.c_allocated_target + ", category_en=" + this.category_en + ", category_zh=" + this.category_zh + ", rule_sort_number=" + this.rule_sort_number + ", chapter_name_1=" + this.chapter_name_1 + ", chapter_name_2=" + this.chapter_name_2 + ", chapter_name_3=" + this.chapter_name_3 + ", chapter_name_4=" + this.chapter_name_4 + ", description_en=" + this.description_en + ", description_zh=" + this.description_zh + ", document_en=" + this.document_en + ", document_zh=" + this.document_zh + ")";
    }

    public int hashCode() {
        int result = this.name.hashCode();
        result = result * 31 + this.short_description_en.hashCode();
        result = result * 31 + this.short_description_zh.hashCode();
        result = result * 31 + (this.severity == null ? 0 : this.severity.hashCode());
        result = result * 31 + (this.priority == null ? 0 : this.priority.hashCode());
        result = result * 31 + this.language.hashCode();
        result = result * 31 + (this.precision == null ? 0 : this.precision.hashCode());
        result = result * 31 + (this.recall == null ? 0 : this.recall.hashCode());
        result = result * 31 + (this.likelihood == null ? 0 : this.likelihood.hashCode());
        result = result * 31 + (this.impact == null ? 0 : this.impact.hashCode());
        result = result * 31 + (this.technique == null ? 0 : this.technique.hashCode());
        result = result * 31 + (this.analysis_scope == null ? 0 : this.analysis_scope.hashCode());
        result = result * 31 + (this.performance == null ? 0 : this.performance.hashCode());
        result = result * 31 + (this.configurable == null ? 0 : ((Object)this.configurable).hashCode());
        result = result * 31 + (this.implemented == null ? 0 : ((Object)this.implemented).hashCode());
        result = result * 31 + (this.static_analyzability == null ? 0 : this.static_analyzability.hashCode());
        result = result * 31 + (this.c_allocated_target == null ? 0 : this.c_allocated_target.hashCode());
        result = result * 31 + this.category_en.hashCode();
        result = result * 31 + this.category_zh.hashCode();
        result = result * 31 + (this.rule_sort_number == null ? 0 : ((Object)this.rule_sort_number).hashCode());
        result = result * 31 + (this.chapter_name_1 == null ? 0 : this.chapter_name_1.hashCode());
        result = result * 31 + (this.chapter_name_2 == null ? 0 : this.chapter_name_2.hashCode());
        result = result * 31 + (this.chapter_name_3 == null ? 0 : this.chapter_name_3.hashCode());
        result = result * 31 + (this.chapter_name_4 == null ? 0 : this.chapter_name_4.hashCode());
        result = result * 31 + this.description_en.hashCode();
        result = result * 31 + (this.description_zh == null ? 0 : this.description_zh.hashCode());
        result = result * 31 + this.document_en.hashCode();
        result = result * 31 + this.document_zh.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Rule)) {
            return false;
        }
        Rule rule = (Rule)other;
        if (!Intrinsics.areEqual((Object)this.name, (Object)rule.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.short_description_en, (Object)rule.short_description_en)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.short_description_zh, (Object)rule.short_description_zh)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.severity, (Object)rule.severity)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.priority, (Object)rule.priority)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.language, (Object)rule.language)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.precision, (Object)rule.precision)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.recall, (Object)rule.recall)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.likelihood, (Object)rule.likelihood)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.impact, (Object)rule.impact)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.technique, (Object)rule.technique)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.analysis_scope, (Object)rule.analysis_scope)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.performance, (Object)rule.performance)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.configurable, (Object)rule.configurable)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.implemented, (Object)rule.implemented)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.static_analyzability, (Object)rule.static_analyzability)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.c_allocated_target, (Object)rule.c_allocated_target)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.category_en, (Object)rule.category_en)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.category_zh, (Object)rule.category_zh)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.rule_sort_number, (Object)rule.rule_sort_number)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.chapter_name_1, (Object)rule.chapter_name_1)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.chapter_name_2, (Object)rule.chapter_name_2)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.chapter_name_3, (Object)rule.chapter_name_3)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.chapter_name_4, (Object)rule.chapter_name_4)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.description_en, (Object)rule.description_en)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.description_zh, (Object)rule.description_zh)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.document_en, (Object)rule.document_en)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.document_zh, (Object)rule.document_zh);
    }
}

