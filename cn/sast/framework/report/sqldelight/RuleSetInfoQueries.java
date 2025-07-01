package cn.sast.framework.report.sqldelight;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class RuleSetInfoQueries extends TransacterImpl {
    public RuleSetInfoQueries(@NotNull SqlDriver driver) {
        super(driver);
    }

    @NotNull
    public <T> Query<T> selectAll(@NotNull Function8<String, String, String, String, String, Long, String, String, T> mapper) {
        String[] stringArray = {"RuleSetInfo"};
        return QueryKt.Query(1731641704, stringArray, this.getDriver(), "RuleSetInfo.sq", 
            "selectAll", 
            "SELECT RuleSetInfo.name, RuleSetInfo.language, RuleSetInfo.description, RuleSetInfo.prefix, RuleSetInfo.id_pattern, RuleSetInfo.section_level, RuleSetInfo.version, RuleSetInfo.revision\nFROM RuleSetInfo", 
            cursor -> {
                String name = cursor.getString(0);
                String language = cursor.getString(1);
                String description = cursor.getString(2);
                String prefix = cursor.getString(3);
                String idPattern = cursor.getString(4);
                Long sectionLevel = cursor.getLong(5);
                String version = cursor.getString(6);
                String revision = cursor.getString(7);
                return mapper.apply(name, language, description, prefix, idPattern, sectionLevel, version, revision);
            });
    }

    @NotNull
    public Query<RuleSetInfo> selectAll() {
        return selectAll(RuleSetInfo::new);
    }

    public void insert(@NotNull RuleSetInfo ruleSetInfo) {
        getDriver().execute(1006841654, 
            "INSERT OR IGNORE INTO RuleSetInfo (name, language, description, prefix, id_pattern, section_level, version, revision)\nVALUES (?, ?, ?, ?, ?, ?, ?, ?)", 
            8, 
            stmt -> {
                stmt.bindString(0, ruleSetInfo.getName());
                stmt.bindString(1, ruleSetInfo.getLanguage());
                stmt.bindString(2, ruleSetInfo.getDescription());
                stmt.bindString(3, ruleSetInfo.getPrefix());
                stmt.bindString(4, ruleSetInfo.getId_pattern());
                stmt.bindLong(5, ruleSetInfo.getSection_level());
                stmt.bindString(6, ruleSetInfo.getVersion());
                stmt.bindString(7, ruleSetInfo.getRevision());
                return null;
            });
        notifyQueries(1006841654, emit -> {
            emit.accept("RuleSetInfo");
            return null;
        });
    }

    @FunctionalInterface
    public interface Function8<A, B, C, D, E, F, G, H, R> {
        R apply(A a, B b, C c, D d, E e, F f, G g, H h);
    }
}