package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.ExecutableQuery;
import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class RuleMappingQueries extends TransacterImpl {

    public RuleMappingQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public final <T> ExecutableQuery<T> verify_rule_name(@NotNull Function3<String, String, String, T> mapper) {
        return new VerifyRuleNameQuery(this, cursor -> {
            String ruleName = cursor.getString(0);
            return mapper.apply(ruleName, cursor.getString(1), cursor.getString(2));
        });
    }

    @NotNull
    public final ExecutableQuery<RuleMapping> verify_rule_name() {
        return verify_rule_name(RuleMapping::new);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function3<String, String, String, T> mapper) {
        return QueryKt.Query(
            1383017866,
            new String[]{"RuleMapping"},
            getDriver(),
            "RuleMapping.sq",
            "selectAll",
            "SELECT RuleMapping.rule_name, RuleMapping.standard_name, RuleMapping.standard_rule\nFROM RuleMapping",
            cursor -> {
                String ruleName = cursor.getString(0);
                return mapper.apply(ruleName, cursor.getString(1), cursor.getString(2));
            }
        );
    }

    @NotNull
    public final Query<RuleMapping> selectAll() {
        return selectAll(RuleMapping::new);
    }

    public final void insert(@NotNull RuleMapping ruleMapping) {
        getDriver().execute(
            -1057683884,
            "INSERT OR IGNORE INTO RuleMapping (rule_name, standard_name, standard_rule)\nVALUES (?, ?, ?)",
            3,
            stmt -> {
                stmt.bindString(0, ruleMapping.getRule_name());
                stmt.bindString(1, ruleMapping.getStandard_name());
                stmt.bindString(2, ruleMapping.getStandard_rule());
                return null;
            }
        );
        notifyQueries(-1057683884, emit -> {
            emit.accept("RuleMapping");
            return null;
        });
    }

    @FunctionalInterface
    public interface Function3<A, B, C, R> {
        R apply(A a, B b, C c);
    }

    private static final class VerifyRuleNameQuery<T> implements ExecutableQuery<T> {
        private final RuleMappingQueries queries;
        private final Function<SqlCursor, T> mapper;

        VerifyRuleNameQuery(RuleMappingQueries queries, Function<SqlCursor, T> mapper) {
            this.queries = queries;
            this.mapper = mapper;
        }

        @Override
        public T execute() {
            try (SqlCursor cursor = queries.getDriver().executeQuery(null, "SELECT rule_name, standard_name, standard_rule FROM RuleMapping")) {
                return mapper.apply(cursor);
            }
        }
    }
}