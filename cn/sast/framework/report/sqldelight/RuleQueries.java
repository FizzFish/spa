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
 *  cn.sast.framework.report.sqldelight.Rule
 *  cn.sast.framework.report.sqldelight.RuleQueries
 *  cn.sast.framework.report.sqldelight.RuleQueries$selectAll$2
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
import cn.sast.framework.report.sqldelight.Rule;
import cn.sast.framework.report.sqldelight.RuleQueries;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.FunctionN;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u009d\u0005\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2\u00ff\u0004\u0010\n\u001a\u00fa\u0004\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001e\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\"\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b($\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b('\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(*\u0012\u0004\u0012\u0002H\b0\u000b\u00a2\u0006\u0002\u0010+J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020,0\u0007J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020,\u00a8\u00060"}, d2={"Lcn/sast/framework/report/sqldelight/RuleQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "selectAll", "Lapp/cash/sqldelight/Query;", "T", "", "mapper", "Lkotlin/Function28;", "", "Lkotlin/ParameterName;", "name", "short_description_en", "short_description_zh", "severity", "priority", "language", "precision", "recall", "likelihood", "impact", "technique", "analysis_scope", "performance", "", "configurable", "implemented", "static_analyzability", "c_allocated_target", "category_en", "category_zh", "rule_sort_number", "chapter_name_1", "chapter_name_2", "chapter_name_3", "chapter_name_4", "description_en", "description_zh", "document_en", "document_zh", "(Lkotlin/jvm/functions/FunctionN;)Lapp/cash/sqldelight/Query;", "Lcn/sast/framework/report/sqldelight/Rule;", "insert", "", "Rule", "corax-framework"})
public final class RuleQueries
extends TransacterImpl {
    public RuleQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull FunctionN<? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"Rule"};
        return QueryKt.Query((int)177633238, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"Rule.sq", (String)"selectAll", (String)"SELECT Rule.name, Rule.short_description_en, Rule.short_description_zh, Rule.severity, Rule.priority, Rule.language, Rule.precision, Rule.recall, Rule.likelihood, Rule.impact, Rule.technique, Rule.analysis_scope, Rule.performance, Rule.configurable, Rule.implemented, Rule.static_analyzability, Rule.c_allocated_target, Rule.category_en, Rule.category_zh, Rule.rule_sort_number, Rule.chapter_name_1, Rule.chapter_name_2, Rule.chapter_name_3, Rule.chapter_name_4, Rule.description_en, Rule.description_zh, Rule.document_en, Rule.document_zh\nFROM Rule", arg_0 -> RuleQueries.selectAll$lambda$0(mapper, arg_0));
    }

    @NotNull
    public final Query<Rule> selectAll() {
        return this.selectAll((FunctionN)selectAll.2.INSTANCE);
    }

    public final void insert(@NotNull Rule Rule2) {
        Intrinsics.checkNotNullParameter((Object)Rule2, (String)"Rule");
        this.getDriver().execute(Integer.valueOf(-1201750136), "INSERT OR IGNORE INTO Rule (name, short_description_en, short_description_zh, severity, priority, language, precision, recall, likelihood, impact, technique, analysis_scope, performance, configurable, implemented, static_analyzability, c_allocated_target, category_en, category_zh, rule_sort_number, chapter_name_1, chapter_name_2, chapter_name_3, chapter_name_4, description_en, description_zh, document_en, document_zh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 28, arg_0 -> RuleQueries.insert$lambda$1(Rule2, arg_0));
        this.notifyQueries(-1201750136, RuleQueries::insert$lambda$2);
    }

    private static final Object selectAll$lambda$0(FunctionN $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Object[] objectArray = new Object[28];
        Intrinsics.checkNotNull((Object)cursor.getString(0));
        Intrinsics.checkNotNull((Object)cursor.getString(1));
        Intrinsics.checkNotNull((Object)cursor.getString(2));
        objectArray[3] = cursor.getString(3);
        objectArray[4] = cursor.getString(4);
        Intrinsics.checkNotNull((Object)cursor.getString(5));
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
        Intrinsics.checkNotNull((Object)cursor.getString(17));
        Intrinsics.checkNotNull((Object)cursor.getString(18));
        objectArray[19] = cursor.getLong(19);
        objectArray[20] = cursor.getString(20);
        objectArray[21] = cursor.getString(21);
        objectArray[22] = cursor.getString(22);
        objectArray[23] = cursor.getString(23);
        Intrinsics.checkNotNull((Object)cursor.getString(24));
        objectArray[25] = cursor.getString(25);
        Intrinsics.checkNotNull((Object)cursor.getString(26));
        Intrinsics.checkNotNull((Object)cursor.getString(27));
        return $mapper.invoke(objectArray);
    }

    private static final Unit insert$lambda$1(Rule $Rule, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $Rule.getName());
        $this$execute.bindString(1, $Rule.getShort_description_en());
        $this$execute.bindString(2, $Rule.getShort_description_zh());
        $this$execute.bindString(3, $Rule.getSeverity());
        $this$execute.bindString(4, $Rule.getPriority());
        $this$execute.bindString(5, $Rule.getLanguage());
        $this$execute.bindString(6, $Rule.getPrecision());
        $this$execute.bindString(7, $Rule.getRecall());
        $this$execute.bindString(8, $Rule.getLikelihood());
        $this$execute.bindString(9, $Rule.getImpact());
        $this$execute.bindString(10, $Rule.getTechnique());
        $this$execute.bindString(11, $Rule.getAnalysis_scope());
        $this$execute.bindString(12, $Rule.getPerformance());
        $this$execute.bindLong(13, $Rule.getConfigurable());
        $this$execute.bindLong(14, $Rule.getImplemented());
        $this$execute.bindString(15, $Rule.getStatic_analyzability());
        $this$execute.bindString(16, $Rule.getC_allocated_target());
        $this$execute.bindString(17, $Rule.getCategory_en());
        $this$execute.bindString(18, $Rule.getCategory_zh());
        $this$execute.bindLong(19, $Rule.getRule_sort_number());
        $this$execute.bindString(20, $Rule.getChapter_name_1());
        $this$execute.bindString(21, $Rule.getChapter_name_2());
        $this$execute.bindString(22, $Rule.getChapter_name_3());
        $this$execute.bindString(23, $Rule.getChapter_name_4());
        $this$execute.bindString(24, $Rule.getDescription_en());
        $this$execute.bindString(25, $Rule.getDescription_zh());
        $this$execute.bindString(26, $Rule.getDocument_en());
        $this$execute.bindString(27, $Rule.getDocument_zh());
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$2(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"Rule");
        return Unit.INSTANCE;
    }
}

