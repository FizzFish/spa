/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.ExecutableQuery
 *  app.cash.sqldelight.Query
 *  app.cash.sqldelight.QueryKt
 *  app.cash.sqldelight.TransacterImpl
 *  app.cash.sqldelight.db.SqlCursor
 *  app.cash.sqldelight.db.SqlDriver
 *  app.cash.sqldelight.db.SqlPreparedStatement
 *  cn.sast.framework.report.sqldelight.RuleMapping
 *  cn.sast.framework.report.sqldelight.RuleMappingQueries
 *  cn.sast.framework.report.sqldelight.RuleMappingQueries$Verify_rule_nameQuery
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.ExecutableQuery;
import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import cn.sast.framework.report.sqldelight.RuleMapping;
import cn.sast.framework.report.sqldelight.RuleMappingQueries;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005Jg\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2O\u0010\n\u001aK\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007Jg\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0014\"\b\b\u0000\u0010\b*\u00020\t2O\u0010\n\u001aK\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012\u00a8\u0006\u0019"}, d2={"Lcn/sast/framework/report/sqldelight/RuleMappingQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "verify_rule_name", "Lapp/cash/sqldelight/ExecutableQuery;", "T", "", "mapper", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "rule_name", "standard_name", "standard_rule", "Lcn/sast/framework/report/sqldelight/RuleMapping;", "selectAll", "Lapp/cash/sqldelight/Query;", "insert", "", "RuleMapping", "Verify_rule_nameQuery", "corax-framework"})
public final class RuleMappingQueries
extends TransacterImpl {
    public RuleMappingQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_rule_name(@NotNull Function3<? super String, ? super String, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return (ExecutableQuery)new Verify_rule_nameQuery(this, arg_0 -> RuleMappingQueries.verify_rule_name$lambda$0(mapper, arg_0));
    }

    @NotNull
    public final ExecutableQuery<RuleMapping> verify_rule_name() {
        return this.verify_rule_name(RuleMappingQueries::verify_rule_name$lambda$1);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function3<? super String, ? super String, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"RuleMapping"};
        return QueryKt.Query((int)1383017866, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"RuleMapping.sq", (String)"selectAll", (String)"SELECT RuleMapping.rule_name, RuleMapping.standard_name, RuleMapping.standard_rule\nFROM RuleMapping", arg_0 -> RuleMappingQueries.selectAll$lambda$2(mapper, arg_0));
    }

    @NotNull
    public final Query<RuleMapping> selectAll() {
        return this.selectAll(RuleMappingQueries::selectAll$lambda$3);
    }

    public final void insert(@NotNull RuleMapping RuleMapping2) {
        Intrinsics.checkNotNullParameter((Object)RuleMapping2, (String)"RuleMapping");
        this.getDriver().execute(Integer.valueOf(-1057683884), "INSERT OR IGNORE INTO RuleMapping (rule_name, standard_name, standard_rule)\nVALUES (?, ?, ?)", 3, arg_0 -> RuleMappingQueries.insert$lambda$4(RuleMapping2, arg_0));
        this.notifyQueries(-1057683884, RuleMappingQueries::insert$lambda$5);
    }

    private static final Object verify_rule_name$lambda$0(Function3 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        String string = cursor.getString(0);
        Intrinsics.checkNotNull((Object)string);
        return $mapper.invoke((Object)string, (Object)cursor.getString(1), (Object)cursor.getString(2));
    }

    private static final RuleMapping verify_rule_name$lambda$1(String rule_name, String standard_name, String standard_rule) {
        Intrinsics.checkNotNullParameter((Object)rule_name, (String)"rule_name");
        return new RuleMapping(rule_name, standard_name, standard_rule);
    }

    private static final Object selectAll$lambda$2(Function3 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        String string = cursor.getString(0);
        Intrinsics.checkNotNull((Object)string);
        return $mapper.invoke((Object)string, (Object)cursor.getString(1), (Object)cursor.getString(2));
    }

    private static final RuleMapping selectAll$lambda$3(String rule_name, String standard_name, String standard_rule) {
        Intrinsics.checkNotNullParameter((Object)rule_name, (String)"rule_name");
        return new RuleMapping(rule_name, standard_name, standard_rule);
    }

    private static final Unit insert$lambda$4(RuleMapping $RuleMapping, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $RuleMapping.getRule_name());
        $this$execute.bindString(1, $RuleMapping.getStandard_name());
        $this$execute.bindString(2, $RuleMapping.getStandard_rule());
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$5(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"RuleMapping");
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ SqlDriver access$getDriver(RuleMappingQueries $this) {
        return $this.getDriver();
    }
}

