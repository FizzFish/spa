package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class AnalyzerStatisticsQueries extends TransacterImpl {
    public AnalyzerStatisticsQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function<Object[], T> mapper) {
        String[] stringArray = new String[]{"AnalyzerStatistics"};
        return QueryKt.Query(
            2087699017,
            stringArray,
            this.getDriver(),
            "AnalyzerStatistics.sq",
            "selectAll",
            "SELECT AnalyzerStatistics.name, AnalyzerStatistics.corax_probe_version, AnalyzerStatistics.analyzer_version, " +
                "AnalyzerStatistics.analysis_begin_date, AnalyzerStatistics.analysis_begin_timestamp, " +
                "AnalyzerStatistics.analysis_escape_seconds, AnalyzerStatistics.analysis_escape_time, " +
                "AnalyzerStatistics.analysis_end_date, AnalyzerStatistics.analysis_end_timestamp, " +
                "AnalyzerStatistics.file_count, AnalyzerStatistics.line_count, AnalyzerStatistics.code_coverage_covered, " +
                "AnalyzerStatistics.code_coverage_missed, AnalyzerStatistics.num_of_report_dir, " +
                "AnalyzerStatistics.source_paths, AnalyzerStatistics.os_name, AnalyzerStatistics.command_json, " +
                "AnalyzerStatistics.working_directory, AnalyzerStatistics.output_path, AnalyzerStatistics.project_root, " +
                "AnalyzerStatistics.log_file, AnalyzerStatistics.enable_rules, AnalyzerStatistics.disable_rules, " +
                "AnalyzerStatistics.failed_sources, AnalyzerStatistics.failed_sources_num, " +
                "AnalyzerStatistics.successful_sources, AnalyzerStatistics.successful_sources_num, " +
                "AnalyzerStatistics.skipped_sources, AnalyzerStatistics.skipped_sources_num " +
                "FROM AnalyzerStatistics",
            cursor -> {
                Object[] objectArray = new Object[29];
                objectArray[0] = cursor.getString(0);
                objectArray[1] = cursor.getString(1);
                objectArray[2] = cursor.getString(2);
                objectArray[3] = cursor.getString(3);
                objectArray[4] = cursor.getLong(4);
                objectArray[5] = cursor.getLong(5);
                objectArray[6] = cursor.getString(6);
                objectArray[7] = cursor.getString(7);
                objectArray[8] = cursor.getLong(8);
                objectArray[9] = cursor.getLong(9);
                objectArray[10] = cursor.getLong(10);
                objectArray[11] = cursor.getLong(11);
                objectArray[12] = cursor.getLong(12);
                objectArray[13] = cursor.getLong(13);
                objectArray[14] = cursor.getString(14);
                objectArray[15] = cursor.getString(15);
                objectArray[16] = cursor.getString(16);
                objectArray[17] = cursor.getString(17);
                objectArray[18] = cursor.getString(18);
                objectArray[19] = cursor.getString(19);
                objectArray[20] = cursor.getString(20);
                objectArray[21] = cursor.getString(21);
                objectArray[22] = cursor.getString(22);
                objectArray[23] = cursor.getString(23);
                objectArray[24] = cursor.getLong(24);
                objectArray[25] = cursor.getString(25);
                objectArray[26] = cursor.getLong(26);
                objectArray[27] = cursor.getString(27);
                objectArray[28] = cursor.getLong(28);
                return mapper.apply(objectArray);
            }
        );
    }

    @NotNull
    public final Query<AnalyzerStatistics> selectAll() {
        return this.selectAll(AnalyzerStatistics::new);
    }

    public final void insert(@NotNull AnalyzerStatistics analyzerStatistics) {
        this.getDriver().execute(
            402637301,
            "INSERT OR IGNORE INTO AnalyzerStatistics (name, corax_probe_version, analyzer_version, " +
                "analysis_begin_date, analysis_begin_timestamp, analysis_escape_seconds, analysis_escape_time, " +
                "analysis_end_date, analysis_end_timestamp, file_count, line_count, code_coverage_covered, " +
                "code_coverage_missed, num_of_report_dir, source_paths, os_name, command_json, working_directory, " +
                "output_path, project_root, log_file, enable_rules, disable_rules, failed_sources, " +
                "failed_sources_num, successful_sources, successful_sources_num, skipped_sources, skipped_sources_num) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
            29,
            stmt -> {
                stmt.bindString(0, analyzerStatistics.getName());
                stmt.bindString(1, analyzerStatistics.getCorax_probe_version());
                stmt.bindString(2, analyzerStatistics.getAnalyzer_version());
                stmt.bindString(3, analyzerStatistics.getAnalysis_begin_date());
                stmt.bindLong(4, analyzerStatistics.getAnalysis_begin_timestamp());
                stmt.bindLong(5, analyzerStatistics.getAnalysis_escape_seconds());
                stmt.bindString(6, analyzerStatistics.getAnalysis_escape_time());
                stmt.bindString(7, analyzerStatistics.getAnalysis_end_date());
                stmt.bindLong(8, analyzerStatistics.getAnalysis_end_timestamp());
                stmt.bindLong(9, analyzerStatistics.getFile_count());
                stmt.bindLong(10, analyzerStatistics.getLine_count());
                stmt.bindLong(11, analyzerStatistics.getCode_coverage_covered());
                stmt.bindLong(12, analyzerStatistics.getCode_coverage_missed());
                stmt.bindLong(13, analyzerStatistics.getNum_of_report_dir());
                stmt.bindString(14, analyzerStatistics.getSource_paths());
                stmt.bindString(15, analyzerStatistics.getOs_name());
                stmt.bindString(16, analyzerStatistics.getCommand_json());
                stmt.bindString(17, analyzerStatistics.getWorking_directory());
                stmt.bindString(18, analyzerStatistics.getOutput_path());
                stmt.bindString(19, analyzerStatistics.getProject_root());
                stmt.bindString(20, analyzerStatistics.getLog_file());
                stmt.bindString(21, analyzerStatistics.getEnable_rules());
                stmt.bindString(22, analyzerStatistics.getDisable_rules());
                stmt.bindString(23, analyzerStatistics.getFailed_sources());
                stmt.bindLong(24, analyzerStatistics.getFailed_sources_num());
                stmt.bindString(25, analyzerStatistics.getSuccessful_sources());
                stmt.bindLong(26, analyzerStatistics.getSuccessful_sources_num());
                stmt.bindString(27, analyzerStatistics.getSkipped_sources());
                stmt.bindLong(28, analyzerStatistics.getSkipped_sources_num());
                return null;
            }
        );
        this.notifyQueries(402637301, emit -> {
            emit.accept("AnalyzerStatistics");
            return null;
        });
    }
}