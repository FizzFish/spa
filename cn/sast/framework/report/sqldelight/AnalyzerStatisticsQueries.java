/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.Query
 *  app.cash.sqldelight.QueryKt
 *  app.cash.sqldelight.TransacterImpl
 *  app.cash.sqldelight.db.SqlCursor
 *  app.cash.sqldelight.db.SqlDriver
 *  app.cash.sqldelight.db.SqlPreparedStatement
 *  cn.sast.framework.report.sqldelight.AnalyzerStatistics
 *  cn.sast.framework.report.sqldelight.AnalyzerStatisticsQueries
 *  cn.sast.framework.report.sqldelight.AnalyzerStatisticsQueries$selectAll$2
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.FunctionN
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import cn.sast.framework.report.sqldelight.AnalyzerStatistics;
import cn.sast.framework.report.sqldelight.AnalyzerStatisticsQueries;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.FunctionN;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0092\u0005\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2\u00f4\u0004\u0010\n\u001a\u00ef\u0004\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\b0\u000b\u00a2\u0006\u0002\u0010,J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020-0\u0007J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020-\u00a8\u00061"}, d2={"Lcn/sast/framework/report/sqldelight/AnalyzerStatisticsQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "selectAll", "Lapp/cash/sqldelight/Query;", "T", "", "mapper", "Lkotlin/Function29;", "", "Lkotlin/ParameterName;", "name", "corax_probe_version", "analyzer_version", "analysis_begin_date", "", "analysis_begin_timestamp", "analysis_escape_seconds", "analysis_escape_time", "analysis_end_date", "analysis_end_timestamp", "file_count", "line_count", "code_coverage_covered", "code_coverage_missed", "num_of_report_dir", "source_paths", "os_name", "command_json", "working_directory", "output_path", "project_root", "log_file", "enable_rules", "disable_rules", "failed_sources", "failed_sources_num", "successful_sources", "successful_sources_num", "skipped_sources", "skipped_sources_num", "(Lkotlin/jvm/functions/FunctionN;)Lapp/cash/sqldelight/Query;", "Lcn/sast/framework/report/sqldelight/AnalyzerStatistics;", "insert", "", "AnalyzerStatistics", "corax-framework"})
public final class AnalyzerStatisticsQueries
extends TransacterImpl {
    public AnalyzerStatisticsQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull FunctionN<? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"AnalyzerStatistics"};
        return QueryKt.Query((int)2087699017, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"AnalyzerStatistics.sq", (String)"selectAll", (String)"SELECT AnalyzerStatistics.name, AnalyzerStatistics.corax_probe_version, AnalyzerStatistics.analyzer_version, AnalyzerStatistics.analysis_begin_date, AnalyzerStatistics.analysis_begin_timestamp, AnalyzerStatistics.analysis_escape_seconds, AnalyzerStatistics.analysis_escape_time, AnalyzerStatistics.analysis_end_date, AnalyzerStatistics.analysis_end_timestamp, AnalyzerStatistics.file_count, AnalyzerStatistics.line_count, AnalyzerStatistics.code_coverage_covered, AnalyzerStatistics.code_coverage_missed, AnalyzerStatistics.num_of_report_dir, AnalyzerStatistics.source_paths, AnalyzerStatistics.os_name, AnalyzerStatistics.command_json, AnalyzerStatistics.working_directory, AnalyzerStatistics.output_path, AnalyzerStatistics.project_root, AnalyzerStatistics.log_file, AnalyzerStatistics.enable_rules, AnalyzerStatistics.disable_rules, AnalyzerStatistics.failed_sources, AnalyzerStatistics.failed_sources_num, AnalyzerStatistics.successful_sources, AnalyzerStatistics.successful_sources_num, AnalyzerStatistics.skipped_sources, AnalyzerStatistics.skipped_sources_num\nFROM AnalyzerStatistics", arg_0 -> AnalyzerStatisticsQueries.selectAll$lambda$0(mapper, arg_0));
    }

    @NotNull
    public final Query<AnalyzerStatistics> selectAll() {
        return this.selectAll((FunctionN)selectAll.2.INSTANCE);
    }

    public final void insert(@NotNull AnalyzerStatistics AnalyzerStatistics2) {
        Intrinsics.checkNotNullParameter((Object)AnalyzerStatistics2, (String)"AnalyzerStatistics");
        this.getDriver().execute(Integer.valueOf(402637301), "INSERT OR IGNORE INTO AnalyzerStatistics (name, corax_probe_version, analyzer_version, analysis_begin_date, analysis_begin_timestamp, analysis_escape_seconds, analysis_escape_time, analysis_end_date, analysis_end_timestamp, file_count, line_count, code_coverage_covered, code_coverage_missed, num_of_report_dir, source_paths, os_name, command_json, working_directory, output_path, project_root, log_file, enable_rules, disable_rules, failed_sources, failed_sources_num, successful_sources, successful_sources_num, skipped_sources, skipped_sources_num)\nVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 29, arg_0 -> AnalyzerStatisticsQueries.insert$lambda$1(AnalyzerStatistics2, arg_0));
        this.notifyQueries(402637301, AnalyzerStatisticsQueries::insert$lambda$2);
    }

    private static final Object selectAll$lambda$0(FunctionN $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Object[] objectArray = new Object[29];
        Intrinsics.checkNotNull((Object)cursor.getString(0));
        Intrinsics.checkNotNull((Object)cursor.getString(1));
        Intrinsics.checkNotNull((Object)cursor.getString(2));
        Intrinsics.checkNotNull((Object)cursor.getString(3));
        Intrinsics.checkNotNull((Object)cursor.getLong(4));
        Intrinsics.checkNotNull((Object)cursor.getLong(5));
        Intrinsics.checkNotNull((Object)cursor.getString(6));
        Intrinsics.checkNotNull((Object)cursor.getString(7));
        Intrinsics.checkNotNull((Object)cursor.getLong(8));
        Intrinsics.checkNotNull((Object)cursor.getLong(9));
        Intrinsics.checkNotNull((Object)cursor.getLong(10));
        objectArray[11] = cursor.getLong(11);
        objectArray[12] = cursor.getLong(12);
        objectArray[13] = cursor.getLong(13);
        Intrinsics.checkNotNull((Object)cursor.getString(14));
        Intrinsics.checkNotNull((Object)cursor.getString(15));
        Intrinsics.checkNotNull((Object)cursor.getString(16));
        Intrinsics.checkNotNull((Object)cursor.getString(17));
        Intrinsics.checkNotNull((Object)cursor.getString(18));
        Intrinsics.checkNotNull((Object)cursor.getString(19));
        Intrinsics.checkNotNull((Object)cursor.getString(20));
        Intrinsics.checkNotNull((Object)cursor.getString(21));
        Intrinsics.checkNotNull((Object)cursor.getString(22));
        Intrinsics.checkNotNull((Object)cursor.getString(23));
        Intrinsics.checkNotNull((Object)cursor.getLong(24));
        Intrinsics.checkNotNull((Object)cursor.getString(25));
        Intrinsics.checkNotNull((Object)cursor.getLong(26));
        Intrinsics.checkNotNull((Object)cursor.getString(27));
        Intrinsics.checkNotNull((Object)cursor.getLong(28));
        return $mapper.invoke(objectArray);
    }

    private static final Unit insert$lambda$1(AnalyzerStatistics $AnalyzerStatistics, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $AnalyzerStatistics.getName());
        $this$execute.bindString(1, $AnalyzerStatistics.getCorax_probe_version());
        $this$execute.bindString(2, $AnalyzerStatistics.getAnalyzer_version());
        $this$execute.bindString(3, $AnalyzerStatistics.getAnalysis_begin_date());
        $this$execute.bindLong(4, Long.valueOf($AnalyzerStatistics.getAnalysis_begin_timestamp()));
        $this$execute.bindLong(5, Long.valueOf($AnalyzerStatistics.getAnalysis_escape_seconds()));
        $this$execute.bindString(6, $AnalyzerStatistics.getAnalysis_escape_time());
        $this$execute.bindString(7, $AnalyzerStatistics.getAnalysis_end_date());
        $this$execute.bindLong(8, Long.valueOf($AnalyzerStatistics.getAnalysis_end_timestamp()));
        $this$execute.bindLong(9, Long.valueOf($AnalyzerStatistics.getFile_count()));
        $this$execute.bindLong(10, Long.valueOf($AnalyzerStatistics.getLine_count()));
        $this$execute.bindLong(11, $AnalyzerStatistics.getCode_coverage_covered());
        $this$execute.bindLong(12, $AnalyzerStatistics.getCode_coverage_missed());
        $this$execute.bindLong(13, $AnalyzerStatistics.getNum_of_report_dir());
        $this$execute.bindString(14, $AnalyzerStatistics.getSource_paths());
        $this$execute.bindString(15, $AnalyzerStatistics.getOs_name());
        $this$execute.bindString(16, $AnalyzerStatistics.getCommand_json());
        $this$execute.bindString(17, $AnalyzerStatistics.getWorking_directory());
        $this$execute.bindString(18, $AnalyzerStatistics.getOutput_path());
        $this$execute.bindString(19, $AnalyzerStatistics.getProject_root());
        $this$execute.bindString(20, $AnalyzerStatistics.getLog_file());
        $this$execute.bindString(21, $AnalyzerStatistics.getEnable_rules());
        $this$execute.bindString(22, $AnalyzerStatistics.getDisable_rules());
        $this$execute.bindString(23, $AnalyzerStatistics.getFailed_sources());
        $this$execute.bindLong(24, Long.valueOf($AnalyzerStatistics.getFailed_sources_num()));
        $this$execute.bindString(25, $AnalyzerStatistics.getSuccessful_sources());
        $this$execute.bindLong(26, Long.valueOf($AnalyzerStatistics.getSuccessful_sources_num()));
        $this$execute.bindString(27, $AnalyzerStatistics.getSkipped_sources());
        $this$execute.bindLong(28, Long.valueOf($AnalyzerStatistics.getSkipped_sources_num()));
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$2(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"AnalyzerStatistics");
        return Unit.INSTANCE;
    }
}

