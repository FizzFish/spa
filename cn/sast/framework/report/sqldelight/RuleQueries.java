package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class RuleQueries extends TransacterImpl {
    public RuleQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public <T> Query<T> selectAll(@NotNull Function<Object[], T> mapper) {
        String[] stringArray = new String[]{"Rule"};
        return QueryKt.Query(177633238, stringArray, this.getDriver(), "Rule.sq", "selectAll", 
            "SELECT Rule.name, Rule.short_description_en, Rule.short_description_zh, Rule.severity, Rule.priority, " +
            "Rule.language, Rule.precision, Rule.recall, Rule.likelihood, Rule.impact, Rule.technique, " +
            "Rule.analysis_scope, Rule.performance, Rule.configurable, Rule.implemented, Rule.static_analyzability, " +
            "Rule.c_allocated_target, Rule.category_en, Rule.category_zh, Rule.rule_sort_number, " +
            "Rule.chapter_name_1, Rule.chapter_name_2, Rule.chapter_name_3, Rule.chapter_name_4, " +
            "Rule.description_en, Rule.description_zh, Rule.document_en, Rule.document_zh " +
            "FROM Rule", 
            cursor -> {
                Object[] objectArray = new Object[28];
                objectArray[0] = cursor.getString(0);
                objectArray[1] = cursor.getString(1);
                objectArray[2] = cursor.getString(2);
                objectArray[3] = cursor.getString(3);
                objectArray[4] = cursor.getString(4);
                objectArray[5] = cursor.getString(5);
                objectArray[6] = cursor.getString(6);
                objectArray[7] = cursor.getString(7);
                objectArray[8] = cursor.getString(8);
                objectArray[9] = cursor.getString(9);
                objectArray[10] = cursor.getString(10);
                objectArray[11] = cursor.getString(11);
                objectArray[12] = cursor.getString(12);
                objectArray[13] = cursor.getLong(13);
                objectArray[14] = cursor.getLong(14);
                objectArray[15] = cursor.getString(15);
                objectArray[16] = cursor.getString(16);
                objectArray[17] = cursor.getString(17);
                objectArray[18] = cursor.getString(18);
                objectArray[19] = cursor.getLong(19);
                objectArray[20] = cursor.getString(20);
                objectArray[21] = cursor.getString(21);
                objectArray[22] = cursor.getString(22);
                objectArray[23] = cursor.getString(23);
                objectArray[24] = cursor.getString(24);
                objectArray[25] = cursor.getString(25);
                objectArray[26] = cursor.getString(26);
                objectArray[27] = cursor.getString(27);
                return mapper.apply(objectArray);
            });
    }

    @NotNull
    public Query<Rule> selectAll() {
        return selectAll(args -> new Rule(
            (String) args[0], (String) args[1], (String) args[2], (String) args[3],
            (String) args[4], (String) args[5], (String) args[6], (String) args[7],
            (String) args[8], (String) args[9], (String) args[10], (String) args[11],
            (String) args[12], (Long) args[13], (Long) args[14], (String) args[15],
            (String) args[16], (String) args[17], (String) args[18], (Long) args[19],
            (String) args[20], (String) args[21], (String) args[22], (String) args[23],
            (String) args[24], (String) args[25], (String) args[26], (String) args[27]
        ));
    }

    public void insert(@NotNull Rule rule) {
        getDriver().execute(-1201750136,
            "INSERT OR IGNORE INTO Rule (name, short_description_en, short_description_zh, severity, priority, " +
            "language, precision, recall, likelihood, impact, technique, analysis_scope, performance, " +
            "configurable, implemented, static_analyzability, c_allocated_target, category_en, category_zh, " +
            "rule_sort_number, chapter_name_1, chapter_name_2, chapter_name_3, chapter_name_4, " +
            "description_en, description_zh, document_en, document_zh) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
            28,
            stmt -> {
                stmt.bindString(0, rule.getName());
                stmt.bindString(1, rule.getShort_description_en());
                stmt.bindString(2, rule.getShort_description_zh());
                stmt.bindString(3, rule.getSeverity());
                stmt.bindString(4, rule.getPriority());
                stmt.bindString(5, rule.getLanguage());
                stmt.bindString(6, rule.getPrecision());
                stmt.bindString(7, rule.getRecall());
                stmt.bindString(8, rule.getLikelihood());
                stmt.bindString(9, rule.getImpact());
                stmt.bindString(10, rule.getTechnique());
                stmt.bindString(11, rule.getAnalysis_scope());
                stmt.bindString(12, rule.getPerformance());
                stmt.bindLong(13, rule.getConfigurable());
                stmt.bindLong(14, rule.getImplemented());
                stmt.bindString(15, rule.getStatic_analyzability());
                stmt.bindString(16, rule.getC_allocated_target());
                stmt.bindString(17, rule.getCategory_en());
                stmt.bindString(18, rule.getCategory_zh());
                stmt.bindLong(19, rule.getRule_sort_number());
                stmt.bindString(20, rule.getChapter_name_1());
                stmt.bindString(21, rule.getChapter_name_2());
                stmt.bindString(22, rule.getChapter_name_3());
                stmt.bindString(23, rule.getChapter_name_4());
                stmt.bindString(24, rule.getDescription_en());
                stmt.bindString(25, rule.getDescription_zh());
                stmt.bindString(26, rule.getDocument_en());
                stmt.bindString(27, rule.getDocument_zh());
                return null;
            });
        notifyQueries(-1201750136, emit -> {
            emit.accept("Rule");
            return null;
        });
    }
}