package cn.sast.framework.report;

import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.TransactionWithoutReturn;
import cn.sast.api.config.ChapterFlat;
import cn.sast.api.config.CheckerInfo;
import cn.sast.api.config.CheckerInfoGenResult;
import cn.sast.api.config.CheckerPriorityConfig;
import cn.sast.api.config.Tag;
import cn.sast.common.Resource;
import cn.sast.framework.report.sqldelight.Database;
import cn.sast.framework.report.sqldelight.Rule;
import cn.sast.framework.report.sqldelight.RuleMapping;
import cn.sast.framework.report.sqldelight.RuleMappingQueries;
import cn.sast.framework.report.sqldelight.RuleQueries;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RuleAndRuleMapping {
    private static final Logger logger = LoggerFactory.getLogger(RuleAndRuleMapping.class);
    
    @NotNull
    private final CheckerInfoGenResult checkerInfo;
    @NotNull
    private final Path ruleSortYaml;
    @NotNull
    private final Set<Rule> rules;
    @NotNull
    private final Set<RuleMapping> ruleMapping;
    @NotNull
    private Map<String, Rule> id2checkerMap;

    public RuleAndRuleMapping(@NotNull CheckerInfoGenResult checkerInfo, @NotNull Path ruleSortYaml) {
        if (checkerInfo == null) throw new IllegalArgumentException("checkerInfo cannot be null");
        if (ruleSortYaml == null) throw new IllegalArgumentException("ruleSortYaml cannot be null");
        
        this.checkerInfo = checkerInfo;
        this.ruleSortYaml = ruleSortYaml;
        this.id2checkerMap = new LinkedHashMap<>();
        
        Pair<Set<Rule>, Set<RuleMapping>> rulesAndRuleMappingsPair = parseRuleAndRuleMapping(this.ruleSortYaml);
        this.rules = rulesAndRuleMappingsPair.getFirst();
        this.ruleMapping = rulesAndRuleMappingsPair.getSecond();
        
        for (Rule rule : this.rules) {
            this.id2checkerMap.put(rule.getName(), rule);
        }
    }

    @NotNull
    public Map<String, Rule> getId2checkerMap() {
        return id2checkerMap;
    }

    public void setId2checkerMap(@NotNull Map<String, Rule> id2checkerMap) {
        if (id2checkerMap == null) throw new IllegalArgumentException("id2checkerMap cannot be null");
        this.id2checkerMap = id2checkerMap;
    }

    private Pair<Set<Rule>, Set<RuleMapping>> parseRuleAndRuleMapping(Path ruleSortYaml) {
        if (!Files.exists(ruleSortYaml)) {
            logger.warn("The ruleSortYaml {} is not exists", ruleSortYaml);
            return new Pair<>(Collections.emptySet(), Collections.emptySet());
        }

        Map<String, IndexedValue<ChapterFlat>> ruleWithSortNumber = 
            CheckerPriorityConfig.deserialize(Resource.fileOf(ruleSortYaml))
                .getRuleWithSortNumber(checkerInfo.getChapters())
                .stream()
                .collect(Collectors.toMap(
                    iv -> iv.getValue().getRuleId(),
                    iv -> iv
                ));

        Set<CheckerInfo> rows = checkerInfo.getCheckerInfoList();
        Set<RuleMapping> ruleMappings = new LinkedHashSet<>();
        Set<Rule> rules = new LinkedHashSet<>();

        for (CheckerInfo row : rows) {
            String name = row.getChecker_id();
            IndexedValue<ChapterFlat> ruleSortNumber = ruleWithSortNumber.get(name);
            
            if (ruleWithSortNumber != null && ruleSortNumber == null) {
                logger.warn("can't find the category '{}' of {} in {}", 
                    row.getCategory().get("zh-CN"), name, ruleSortYaml);
            }

            ruleMappings.addAll(getCurrentRuleMappingSet(row, name));
            
            rules.add(new Rule(
                name,
                row.getName().getOrDefault("en-US", "None"),
                row.getName().getOrDefault("zh-CN", "None"),
                row.getSeverity(),
                null,
                "Java",
                row.getPrecision(),
                row.getReCall(),
                row.getLikelihood(),
                row.getImpact(),
                row.getImpl(),
                "",
                "",
                row.getImplemented() != null ? (row.getImplemented() ? 1L : 0L) : null,
                1L,
                null,
                null,
                row.getCategory().getOrDefault("en-US", "None"),
                row.getCategory().getOrDefault("zh-CN", "None"),
                ruleSortNumber != null ? (long) ruleSortNumber.getIndex() : rows.size() + 1L,
                row.getChapterFlat() != null ? row.getChapterFlat().getCategory() : null,
                row.getChapterFlat() != null ? row.getChapterFlat().getSeverity() : null,
                row.getChapterFlat() != null ? row.getChapterFlat().getRuleId() : null,
                null,
                row.getAbstract().getOrDefault("en-US", "None"),
                row.getAbstract().getOrDefault("zh-CN", "None"),
                row.getDescription().getOrDefault("en-US", "None"),
                row.getDescription().getOrDefault("zh-CN", "None")
            ));
        }

        return new Pair<>(rules, ruleMappings);
    }

    private Set<RuleMapping> getCurrentRuleMappingSet(CheckerInfo row, String name) {
        Set<RuleMapping> mappings = new LinkedHashSet<>();
        for (Tag tag : row.getTags()) {
            mappings.add(new RuleMapping(name, tag.getStandard(), tag.getRule()));
        }
        return mappings;
    }

    public void insert(@NotNull Database database) {
        insert(database, null);
    }

    public void insert(@NotNull Database database, @Nullable Set<String> filter) {
        if (database == null) throw new IllegalArgumentException("database cannot be null");
        
        database.transaction(false, tx -> {
            RuleQueries ruleQueries = database.getRuleQueries();
            for (Rule rule : rules) {
                if (filter == null || filter.contains(rule.getName())) {
                    ruleQueries.insert(rule);
                }
            }

            RuleMappingQueries ruleMappingQueries = database.getRuleMappingQueries();
            for (RuleMapping mapping : ruleMapping) {
                if (filter == null || filter.contains(mapping.getRule_name())) {
                    ruleMappingQueries.insert(mapping);
                }
            }
        });
    }

    private static class Pair<F, S> {
        private final F first;
        private final S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() { return first; }
        public S getSecond() { return second; }
    }
}
