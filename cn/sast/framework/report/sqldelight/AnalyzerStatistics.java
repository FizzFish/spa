/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sqldelight.AnalyzerStatistics
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b[\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00f5\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\b\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\b\u00a2\u0006\u0004\b!\u0010\"J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\bH\u00c6\u0003J\t\u0010I\u001a\u00020\bH\u00c6\u0003J\t\u0010J\u001a\u00020\u0003H\u00c6\u0003J\t\u0010K\u001a\u00020\u0003H\u00c6\u0003J\t\u0010L\u001a\u00020\bH\u00c6\u0003J\t\u0010M\u001a\u00020\bH\u00c6\u0003J\t\u0010N\u001a\u00020\bH\u00c6\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u00101J\u0010\u0010P\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u00101J\u0010\u0010Q\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u00101J\t\u0010R\u001a\u00020\u0003H\u00c6\u0003J\t\u0010S\u001a\u00020\u0003H\u00c6\u0003J\t\u0010T\u001a\u00020\u0003H\u00c6\u0003J\t\u0010U\u001a\u00020\u0003H\u00c6\u0003J\t\u0010V\u001a\u00020\u0003H\u00c6\u0003J\t\u0010W\u001a\u00020\u0003H\u00c6\u0003J\t\u0010X\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Y\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Z\u001a\u00020\u0003H\u00c6\u0003J\t\u0010[\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\\\u001a\u00020\bH\u00c6\u0003J\t\u0010]\u001a\u00020\u0003H\u00c6\u0003J\t\u0010^\u001a\u00020\bH\u00c6\u0003J\t\u0010_\u001a\u00020\u0003H\u00c6\u0003J\t\u0010`\u001a\u00020\bH\u00c6\u0003J\u00b6\u0002\u0010a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\bH\u00c6\u0001\u00a2\u0006\u0002\u0010bJ\u0013\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010f\u001a\u00020gH\u00d6\u0001J\t\u0010h\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010$R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0011\u0010\f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0011\u0010\r\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0011\u0010\u000e\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u00102\u001a\u0004\b3\u00101R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u00102\u001a\u0004\b4\u00101R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010$R\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010$R\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010$R\u0011\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010$R\u0011\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010$R\u0011\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010$R\u0011\u0010\u001a\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010$R\u0011\u0010\u001b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010$R\u0011\u0010\u001c\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010)R\u0011\u0010\u001d\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010$R\u0011\u0010\u001e\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010)R\u0011\u0010\u001f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010$R\u0011\u0010 \u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010)\u00a8\u0006i"}, d2={"Lcn/sast/framework/report/sqldelight/AnalyzerStatistics;", "", "name", "", "corax_probe_version", "analyzer_version", "analysis_begin_date", "analysis_begin_timestamp", "", "analysis_escape_seconds", "analysis_escape_time", "analysis_end_date", "analysis_end_timestamp", "file_count", "line_count", "code_coverage_covered", "code_coverage_missed", "num_of_report_dir", "source_paths", "os_name", "command_json", "working_directory", "output_path", "project_root", "log_file", "enable_rules", "disable_rules", "failed_sources", "failed_sources_num", "successful_sources", "successful_sources_num", "skipped_sources", "skipped_sources_num", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;JJJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;J)V", "getName", "()Ljava/lang/String;", "getCorax_probe_version", "getAnalyzer_version", "getAnalysis_begin_date", "getAnalysis_begin_timestamp", "()J", "getAnalysis_escape_seconds", "getAnalysis_escape_time", "getAnalysis_end_date", "getAnalysis_end_timestamp", "getFile_count", "getLine_count", "getCode_coverage_covered", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCode_coverage_missed", "getNum_of_report_dir", "getSource_paths", "getOs_name", "getCommand_json", "getWorking_directory", "getOutput_path", "getProject_root", "getLog_file", "getEnable_rules", "getDisable_rules", "getFailed_sources", "getFailed_sources_num", "getSuccessful_sources", "getSuccessful_sources_num", "getSkipped_sources", "getSkipped_sources_num", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;JJJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;J)Lcn/sast/framework/report/sqldelight/AnalyzerStatistics;", "equals", "", "other", "hashCode", "", "toString", "corax-framework"})
public final class AnalyzerStatistics {
    @NotNull
    private final String name;
    @NotNull
    private final String corax_probe_version;
    @NotNull
    private final String analyzer_version;
    @NotNull
    private final String analysis_begin_date;
    private final long analysis_begin_timestamp;
    private final long analysis_escape_seconds;
    @NotNull
    private final String analysis_escape_time;
    @NotNull
    private final String analysis_end_date;
    private final long analysis_end_timestamp;
    private final long file_count;
    private final long line_count;
    @Nullable
    private final Long code_coverage_covered;
    @Nullable
    private final Long code_coverage_missed;
    @Nullable
    private final Long num_of_report_dir;
    @NotNull
    private final String source_paths;
    @NotNull
    private final String os_name;
    @NotNull
    private final String command_json;
    @NotNull
    private final String working_directory;
    @NotNull
    private final String output_path;
    @NotNull
    private final String project_root;
    @NotNull
    private final String log_file;
    @NotNull
    private final String enable_rules;
    @NotNull
    private final String disable_rules;
    @NotNull
    private final String failed_sources;
    private final long failed_sources_num;
    @NotNull
    private final String successful_sources;
    private final long successful_sources_num;
    @NotNull
    private final String skipped_sources;
    private final long skipped_sources_num;

    public AnalyzerStatistics(@NotNull String name, @NotNull String corax_probe_version, @NotNull String analyzer_version, @NotNull String analysis_begin_date, long analysis_begin_timestamp, long analysis_escape_seconds, @NotNull String analysis_escape_time, @NotNull String analysis_end_date, long analysis_end_timestamp, long file_count, long line_count, @Nullable Long code_coverage_covered, @Nullable Long code_coverage_missed, @Nullable Long num_of_report_dir, @NotNull String source_paths, @NotNull String os_name, @NotNull String command_json, @NotNull String working_directory, @NotNull String output_path, @NotNull String project_root, @NotNull String log_file, @NotNull String enable_rules, @NotNull String disable_rules, @NotNull String failed_sources, long failed_sources_num, @NotNull String successful_sources, long successful_sources_num, @NotNull String skipped_sources, long skipped_sources_num) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)corax_probe_version, (String)"corax_probe_version");
        Intrinsics.checkNotNullParameter((Object)analyzer_version, (String)"analyzer_version");
        Intrinsics.checkNotNullParameter((Object)analysis_begin_date, (String)"analysis_begin_date");
        Intrinsics.checkNotNullParameter((Object)analysis_escape_time, (String)"analysis_escape_time");
        Intrinsics.checkNotNullParameter((Object)analysis_end_date, (String)"analysis_end_date");
        Intrinsics.checkNotNullParameter((Object)source_paths, (String)"source_paths");
        Intrinsics.checkNotNullParameter((Object)os_name, (String)"os_name");
        Intrinsics.checkNotNullParameter((Object)command_json, (String)"command_json");
        Intrinsics.checkNotNullParameter((Object)working_directory, (String)"working_directory");
        Intrinsics.checkNotNullParameter((Object)output_path, (String)"output_path");
        Intrinsics.checkNotNullParameter((Object)project_root, (String)"project_root");
        Intrinsics.checkNotNullParameter((Object)log_file, (String)"log_file");
        Intrinsics.checkNotNullParameter((Object)enable_rules, (String)"enable_rules");
        Intrinsics.checkNotNullParameter((Object)disable_rules, (String)"disable_rules");
        Intrinsics.checkNotNullParameter((Object)failed_sources, (String)"failed_sources");
        Intrinsics.checkNotNullParameter((Object)successful_sources, (String)"successful_sources");
        Intrinsics.checkNotNullParameter((Object)skipped_sources, (String)"skipped_sources");
        this.name = name;
        this.corax_probe_version = corax_probe_version;
        this.analyzer_version = analyzer_version;
        this.analysis_begin_date = analysis_begin_date;
        this.analysis_begin_timestamp = analysis_begin_timestamp;
        this.analysis_escape_seconds = analysis_escape_seconds;
        this.analysis_escape_time = analysis_escape_time;
        this.analysis_end_date = analysis_end_date;
        this.analysis_end_timestamp = analysis_end_timestamp;
        this.file_count = file_count;
        this.line_count = line_count;
        this.code_coverage_covered = code_coverage_covered;
        this.code_coverage_missed = code_coverage_missed;
        this.num_of_report_dir = num_of_report_dir;
        this.source_paths = source_paths;
        this.os_name = os_name;
        this.command_json = command_json;
        this.working_directory = working_directory;
        this.output_path = output_path;
        this.project_root = project_root;
        this.log_file = log_file;
        this.enable_rules = enable_rules;
        this.disable_rules = disable_rules;
        this.failed_sources = failed_sources;
        this.failed_sources_num = failed_sources_num;
        this.successful_sources = successful_sources;
        this.successful_sources_num = successful_sources_num;
        this.skipped_sources = skipped_sources;
        this.skipped_sources_num = skipped_sources_num;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getCorax_probe_version() {
        return this.corax_probe_version;
    }

    @NotNull
    public final String getAnalyzer_version() {
        return this.analyzer_version;
    }

    @NotNull
    public final String getAnalysis_begin_date() {
        return this.analysis_begin_date;
    }

    public final long getAnalysis_begin_timestamp() {
        return this.analysis_begin_timestamp;
    }

    public final long getAnalysis_escape_seconds() {
        return this.analysis_escape_seconds;
    }

    @NotNull
    public final String getAnalysis_escape_time() {
        return this.analysis_escape_time;
    }

    @NotNull
    public final String getAnalysis_end_date() {
        return this.analysis_end_date;
    }

    public final long getAnalysis_end_timestamp() {
        return this.analysis_end_timestamp;
    }

    public final long getFile_count() {
        return this.file_count;
    }

    public final long getLine_count() {
        return this.line_count;
    }

    @Nullable
    public final Long getCode_coverage_covered() {
        return this.code_coverage_covered;
    }

    @Nullable
    public final Long getCode_coverage_missed() {
        return this.code_coverage_missed;
    }

    @Nullable
    public final Long getNum_of_report_dir() {
        return this.num_of_report_dir;
    }

    @NotNull
    public final String getSource_paths() {
        return this.source_paths;
    }

    @NotNull
    public final String getOs_name() {
        return this.os_name;
    }

    @NotNull
    public final String getCommand_json() {
        return this.command_json;
    }

    @NotNull
    public final String getWorking_directory() {
        return this.working_directory;
    }

    @NotNull
    public final String getOutput_path() {
        return this.output_path;
    }

    @NotNull
    public final String getProject_root() {
        return this.project_root;
    }

    @NotNull
    public final String getLog_file() {
        return this.log_file;
    }

    @NotNull
    public final String getEnable_rules() {
        return this.enable_rules;
    }

    @NotNull
    public final String getDisable_rules() {
        return this.disable_rules;
    }

    @NotNull
    public final String getFailed_sources() {
        return this.failed_sources;
    }

    public final long getFailed_sources_num() {
        return this.failed_sources_num;
    }

    @NotNull
    public final String getSuccessful_sources() {
        return this.successful_sources;
    }

    public final long getSuccessful_sources_num() {
        return this.successful_sources_num;
    }

    @NotNull
    public final String getSkipped_sources() {
        return this.skipped_sources;
    }

    public final long getSkipped_sources_num() {
        return this.skipped_sources_num;
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.corax_probe_version;
    }

    @NotNull
    public final String component3() {
        return this.analyzer_version;
    }

    @NotNull
    public final String component4() {
        return this.analysis_begin_date;
    }

    public final long component5() {
        return this.analysis_begin_timestamp;
    }

    public final long component6() {
        return this.analysis_escape_seconds;
    }

    @NotNull
    public final String component7() {
        return this.analysis_escape_time;
    }

    @NotNull
    public final String component8() {
        return this.analysis_end_date;
    }

    public final long component9() {
        return this.analysis_end_timestamp;
    }

    public final long component10() {
        return this.file_count;
    }

    public final long component11() {
        return this.line_count;
    }

    @Nullable
    public final Long component12() {
        return this.code_coverage_covered;
    }

    @Nullable
    public final Long component13() {
        return this.code_coverage_missed;
    }

    @Nullable
    public final Long component14() {
        return this.num_of_report_dir;
    }

    @NotNull
    public final String component15() {
        return this.source_paths;
    }

    @NotNull
    public final String component16() {
        return this.os_name;
    }

    @NotNull
    public final String component17() {
        return this.command_json;
    }

    @NotNull
    public final String component18() {
        return this.working_directory;
    }

    @NotNull
    public final String component19() {
        return this.output_path;
    }

    @NotNull
    public final String component20() {
        return this.project_root;
    }

    @NotNull
    public final String component21() {
        return this.log_file;
    }

    @NotNull
    public final String component22() {
        return this.enable_rules;
    }

    @NotNull
    public final String component23() {
        return this.disable_rules;
    }

    @NotNull
    public final String component24() {
        return this.failed_sources;
    }

    public final long component25() {
        return this.failed_sources_num;
    }

    @NotNull
    public final String component26() {
        return this.successful_sources;
    }

    public final long component27() {
        return this.successful_sources_num;
    }

    @NotNull
    public final String component28() {
        return this.skipped_sources;
    }

    public final long component29() {
        return this.skipped_sources_num;
    }

    @NotNull
    public final AnalyzerStatistics copy(@NotNull String name, @NotNull String corax_probe_version, @NotNull String analyzer_version, @NotNull String analysis_begin_date, long analysis_begin_timestamp, long analysis_escape_seconds, @NotNull String analysis_escape_time, @NotNull String analysis_end_date, long analysis_end_timestamp, long file_count, long line_count, @Nullable Long code_coverage_covered, @Nullable Long code_coverage_missed, @Nullable Long num_of_report_dir, @NotNull String source_paths, @NotNull String os_name, @NotNull String command_json, @NotNull String working_directory, @NotNull String output_path, @NotNull String project_root, @NotNull String log_file, @NotNull String enable_rules, @NotNull String disable_rules, @NotNull String failed_sources, long failed_sources_num, @NotNull String successful_sources, long successful_sources_num, @NotNull String skipped_sources, long skipped_sources_num) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)corax_probe_version, (String)"corax_probe_version");
        Intrinsics.checkNotNullParameter((Object)analyzer_version, (String)"analyzer_version");
        Intrinsics.checkNotNullParameter((Object)analysis_begin_date, (String)"analysis_begin_date");
        Intrinsics.checkNotNullParameter((Object)analysis_escape_time, (String)"analysis_escape_time");
        Intrinsics.checkNotNullParameter((Object)analysis_end_date, (String)"analysis_end_date");
        Intrinsics.checkNotNullParameter((Object)source_paths, (String)"source_paths");
        Intrinsics.checkNotNullParameter((Object)os_name, (String)"os_name");
        Intrinsics.checkNotNullParameter((Object)command_json, (String)"command_json");
        Intrinsics.checkNotNullParameter((Object)working_directory, (String)"working_directory");
        Intrinsics.checkNotNullParameter((Object)output_path, (String)"output_path");
        Intrinsics.checkNotNullParameter((Object)project_root, (String)"project_root");
        Intrinsics.checkNotNullParameter((Object)log_file, (String)"log_file");
        Intrinsics.checkNotNullParameter((Object)enable_rules, (String)"enable_rules");
        Intrinsics.checkNotNullParameter((Object)disable_rules, (String)"disable_rules");
        Intrinsics.checkNotNullParameter((Object)failed_sources, (String)"failed_sources");
        Intrinsics.checkNotNullParameter((Object)successful_sources, (String)"successful_sources");
        Intrinsics.checkNotNullParameter((Object)skipped_sources, (String)"skipped_sources");
        return new AnalyzerStatistics(name, corax_probe_version, analyzer_version, analysis_begin_date, analysis_begin_timestamp, analysis_escape_seconds, analysis_escape_time, analysis_end_date, analysis_end_timestamp, file_count, line_count, code_coverage_covered, code_coverage_missed, num_of_report_dir, source_paths, os_name, command_json, working_directory, output_path, project_root, log_file, enable_rules, disable_rules, failed_sources, failed_sources_num, successful_sources, successful_sources_num, skipped_sources, skipped_sources_num);
    }

    public static /* synthetic */ AnalyzerStatistics copy$default(AnalyzerStatistics analyzerStatistics, String string, String string2, String string3, String string4, long l, long l2, String string5, String string6, long l3, long l4, long l5, Long l6, Long l7, Long l8, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14, String string15, String string16, long l9, String string17, long l10, String string18, long l11, int n, Object object) {
        if ((n & 1) != 0) {
            string = analyzerStatistics.name;
        }
        if ((n & 2) != 0) {
            string2 = analyzerStatistics.corax_probe_version;
        }
        if ((n & 4) != 0) {
            string3 = analyzerStatistics.analyzer_version;
        }
        if ((n & 8) != 0) {
            string4 = analyzerStatistics.analysis_begin_date;
        }
        if ((n & 0x10) != 0) {
            l = analyzerStatistics.analysis_begin_timestamp;
        }
        if ((n & 0x20) != 0) {
            l2 = analyzerStatistics.analysis_escape_seconds;
        }
        if ((n & 0x40) != 0) {
            string5 = analyzerStatistics.analysis_escape_time;
        }
        if ((n & 0x80) != 0) {
            string6 = analyzerStatistics.analysis_end_date;
        }
        if ((n & 0x100) != 0) {
            l3 = analyzerStatistics.analysis_end_timestamp;
        }
        if ((n & 0x200) != 0) {
            l4 = analyzerStatistics.file_count;
        }
        if ((n & 0x400) != 0) {
            l5 = analyzerStatistics.line_count;
        }
        if ((n & 0x800) != 0) {
            l6 = analyzerStatistics.code_coverage_covered;
        }
        if ((n & 0x1000) != 0) {
            l7 = analyzerStatistics.code_coverage_missed;
        }
        if ((n & 0x2000) != 0) {
            l8 = analyzerStatistics.num_of_report_dir;
        }
        if ((n & 0x4000) != 0) {
            string7 = analyzerStatistics.source_paths;
        }
        if ((n & 0x8000) != 0) {
            string8 = analyzerStatistics.os_name;
        }
        if ((n & 0x10000) != 0) {
            string9 = analyzerStatistics.command_json;
        }
        if ((n & 0x20000) != 0) {
            string10 = analyzerStatistics.working_directory;
        }
        if ((n & 0x40000) != 0) {
            string11 = analyzerStatistics.output_path;
        }
        if ((n & 0x80000) != 0) {
            string12 = analyzerStatistics.project_root;
        }
        if ((n & 0x100000) != 0) {
            string13 = analyzerStatistics.log_file;
        }
        if ((n & 0x200000) != 0) {
            string14 = analyzerStatistics.enable_rules;
        }
        if ((n & 0x400000) != 0) {
            string15 = analyzerStatistics.disable_rules;
        }
        if ((n & 0x800000) != 0) {
            string16 = analyzerStatistics.failed_sources;
        }
        if ((n & 0x1000000) != 0) {
            l9 = analyzerStatistics.failed_sources_num;
        }
        if ((n & 0x2000000) != 0) {
            string17 = analyzerStatistics.successful_sources;
        }
        if ((n & 0x4000000) != 0) {
            l10 = analyzerStatistics.successful_sources_num;
        }
        if ((n & 0x8000000) != 0) {
            string18 = analyzerStatistics.skipped_sources;
        }
        if ((n & 0x10000000) != 0) {
            l11 = analyzerStatistics.skipped_sources_num;
        }
        return analyzerStatistics.copy(string, string2, string3, string4, l, l2, string5, string6, l3, l4, l5, l6, l7, l8, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, l9, string17, l10, string18, l11);
    }

    @NotNull
    public String toString() {
        return "AnalyzerStatistics(name=" + this.name + ", corax_probe_version=" + this.corax_probe_version + ", analyzer_version=" + this.analyzer_version + ", analysis_begin_date=" + this.analysis_begin_date + ", analysis_begin_timestamp=" + this.analysis_begin_timestamp + ", analysis_escape_seconds=" + this.analysis_escape_seconds + ", analysis_escape_time=" + this.analysis_escape_time + ", analysis_end_date=" + this.analysis_end_date + ", analysis_end_timestamp=" + this.analysis_end_timestamp + ", file_count=" + this.file_count + ", line_count=" + this.line_count + ", code_coverage_covered=" + this.code_coverage_covered + ", code_coverage_missed=" + this.code_coverage_missed + ", num_of_report_dir=" + this.num_of_report_dir + ", source_paths=" + this.source_paths + ", os_name=" + this.os_name + ", command_json=" + this.command_json + ", working_directory=" + this.working_directory + ", output_path=" + this.output_path + ", project_root=" + this.project_root + ", log_file=" + this.log_file + ", enable_rules=" + this.enable_rules + ", disable_rules=" + this.disable_rules + ", failed_sources=" + this.failed_sources + ", failed_sources_num=" + this.failed_sources_num + ", successful_sources=" + this.successful_sources + ", successful_sources_num=" + this.successful_sources_num + ", skipped_sources=" + this.skipped_sources + ", skipped_sources_num=" + this.skipped_sources_num + ")";
    }

    public int hashCode() {
        int result = this.name.hashCode();
        result = result * 31 + this.corax_probe_version.hashCode();
        result = result * 31 + this.analyzer_version.hashCode();
        result = result * 31 + this.analysis_begin_date.hashCode();
        result = result * 31 + Long.hashCode(this.analysis_begin_timestamp);
        result = result * 31 + Long.hashCode(this.analysis_escape_seconds);
        result = result * 31 + this.analysis_escape_time.hashCode();
        result = result * 31 + this.analysis_end_date.hashCode();
        result = result * 31 + Long.hashCode(this.analysis_end_timestamp);
        result = result * 31 + Long.hashCode(this.file_count);
        result = result * 31 + Long.hashCode(this.line_count);
        result = result * 31 + (this.code_coverage_covered == null ? 0 : ((Object)this.code_coverage_covered).hashCode());
        result = result * 31 + (this.code_coverage_missed == null ? 0 : ((Object)this.code_coverage_missed).hashCode());
        result = result * 31 + (this.num_of_report_dir == null ? 0 : ((Object)this.num_of_report_dir).hashCode());
        result = result * 31 + this.source_paths.hashCode();
        result = result * 31 + this.os_name.hashCode();
        result = result * 31 + this.command_json.hashCode();
        result = result * 31 + this.working_directory.hashCode();
        result = result * 31 + this.output_path.hashCode();
        result = result * 31 + this.project_root.hashCode();
        result = result * 31 + this.log_file.hashCode();
        result = result * 31 + this.enable_rules.hashCode();
        result = result * 31 + this.disable_rules.hashCode();
        result = result * 31 + this.failed_sources.hashCode();
        result = result * 31 + Long.hashCode(this.failed_sources_num);
        result = result * 31 + this.successful_sources.hashCode();
        result = result * 31 + Long.hashCode(this.successful_sources_num);
        result = result * 31 + this.skipped_sources.hashCode();
        result = result * 31 + Long.hashCode(this.skipped_sources_num);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnalyzerStatistics)) {
            return false;
        }
        AnalyzerStatistics analyzerStatistics = (AnalyzerStatistics)other;
        if (!Intrinsics.areEqual((Object)this.name, (Object)analyzerStatistics.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.corax_probe_version, (Object)analyzerStatistics.corax_probe_version)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.analyzer_version, (Object)analyzerStatistics.analyzer_version)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.analysis_begin_date, (Object)analyzerStatistics.analysis_begin_date)) {
            return false;
        }
        if (this.analysis_begin_timestamp != analyzerStatistics.analysis_begin_timestamp) {
            return false;
        }
        if (this.analysis_escape_seconds != analyzerStatistics.analysis_escape_seconds) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.analysis_escape_time, (Object)analyzerStatistics.analysis_escape_time)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.analysis_end_date, (Object)analyzerStatistics.analysis_end_date)) {
            return false;
        }
        if (this.analysis_end_timestamp != analyzerStatistics.analysis_end_timestamp) {
            return false;
        }
        if (this.file_count != analyzerStatistics.file_count) {
            return false;
        }
        if (this.line_count != analyzerStatistics.line_count) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.code_coverage_covered, (Object)analyzerStatistics.code_coverage_covered)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.code_coverage_missed, (Object)analyzerStatistics.code_coverage_missed)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.num_of_report_dir, (Object)analyzerStatistics.num_of_report_dir)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.source_paths, (Object)analyzerStatistics.source_paths)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.os_name, (Object)analyzerStatistics.os_name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.command_json, (Object)analyzerStatistics.command_json)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.working_directory, (Object)analyzerStatistics.working_directory)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.output_path, (Object)analyzerStatistics.output_path)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.project_root, (Object)analyzerStatistics.project_root)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.log_file, (Object)analyzerStatistics.log_file)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.enable_rules, (Object)analyzerStatistics.enable_rules)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.disable_rules, (Object)analyzerStatistics.disable_rules)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.failed_sources, (Object)analyzerStatistics.failed_sources)) {
            return false;
        }
        if (this.failed_sources_num != analyzerStatistics.failed_sources_num) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.successful_sources, (Object)analyzerStatistics.successful_sources)) {
            return false;
        }
        if (this.successful_sources_num != analyzerStatistics.successful_sources_num) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.skipped_sources, (Object)analyzerStatistics.skipped_sources)) {
            return false;
        }
        return this.skipped_sources_num == analyzerStatistics.skipped_sources_num;
    }
}

