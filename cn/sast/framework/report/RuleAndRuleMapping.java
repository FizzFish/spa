/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.Transacter
 *  app.cash.sqldelight.Transacter$DefaultImpls
 *  app.cash.sqldelight.TransactionWithoutReturn
 *  cn.sast.api.config.ChapterFlat
 *  cn.sast.api.config.CheckerInfo
 *  cn.sast.api.config.CheckerInfoGenResult
 *  cn.sast.api.config.CheckerPriorityConfig
 *  cn.sast.api.config.Tag
 *  cn.sast.common.Resource
 *  cn.sast.framework.report.RuleAndRuleMapping
 *  cn.sast.framework.report.RuleAndRuleMapping$Companion
 *  cn.sast.framework.report.sqldelight.Database
 *  cn.sast.framework.report.sqldelight.Rule
 *  cn.sast.framework.report.sqldelight.RuleMapping
 *  cn.sast.framework.report.sqldelight.RuleMappingQueries
 *  cn.sast.framework.report.sqldelight.RuleQueries
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IndexedValue
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report;

import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.TransactionWithoutReturn;
import cn.sast.api.config.ChapterFlat;
import cn.sast.api.config.CheckerInfo;
import cn.sast.api.config.CheckerInfoGenResult;
import cn.sast.api.config.CheckerPriorityConfig;
import cn.sast.api.config.Tag;
import cn.sast.common.Resource;
import cn.sast.framework.report.RuleAndRuleMapping;
import cn.sast.framework.report.sqldelight.Database;
import cn.sast.framework.report.sqldelight.Rule;
import cn.sast.framework.report.sqldelight.RuleMapping;
import cn.sast.framework.report.sqldelight.RuleMappingQueries;
import cn.sast.framework.report.sqldelight.RuleQueries;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J(\u0010\u0014\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\u00152\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2={"Lcn/sast/framework/report/RuleAndRuleMapping;", "", "checkerInfo", "Lcn/sast/api/config/CheckerInfoGenResult;", "ruleSortYaml", "Ljava/nio/file/Path;", "<init>", "(Lcn/sast/api/config/CheckerInfoGenResult;Ljava/nio/file/Path;)V", "rules", "", "Lcn/sast/framework/report/sqldelight/Rule;", "ruleMapping", "Lcn/sast/framework/report/sqldelight/RuleMapping;", "id2checkerMap", "", "", "getId2checkerMap", "()Ljava/util/Map;", "setId2checkerMap", "(Ljava/util/Map;)V", "parseRuleAndRuleMapping", "Lkotlin/Pair;", "getCurrentRuleMappingSet", "row", "Lcn/sast/api/config/CheckerInfo;", "name", "insert", "", "database", "Lcn/sast/framework/report/sqldelight/Database;", "filter", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nSqliteDiagnostics.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SqliteDiagnostics.kt\ncn/sast/framework/report/RuleAndRuleMapping\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,813:1\n1202#2,2:814\n1230#2,4:816\n1202#2,2:820\n1230#2,4:822\n1628#2,2:826\n1630#2:829\n1628#2,3:830\n774#2:833\n865#2,2:834\n1863#2,2:836\n774#2:838\n865#2,2:839\n1863#2,2:841\n1#3:828\n*S KotlinDebug\n*F\n+ 1 SqliteDiagnostics.kt\ncn/sast/framework/report/RuleAndRuleMapping\n*L\n137#1:814,2\n137#1:816,4\n147#1:820,2\n147#1:822,4\n151#1:826,2\n151#1:829\n194#1:830,3\n208#1:833\n208#1:834,2\n208#1:836,2\n209#1:838\n209#1:839,2\n209#1:841,2\n*E\n"})
public final class RuleAndRuleMapping {
    @NotNull
    public static final Companion Companion = new Companion(null);
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
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(RuleAndRuleMapping::logger$lambda$12);

    /*
     * WARNING - void declaration
     */
    public RuleAndRuleMapping(@NotNull CheckerInfoGenResult checkerInfo, @NotNull Path ruleSortYaml) {
        void $this$associateByTo$iv$iv;
        void $this$associateBy$iv;
        Intrinsics.checkNotNullParameter((Object)checkerInfo, (String)"checkerInfo");
        Intrinsics.checkNotNullParameter((Object)ruleSortYaml, (String)"ruleSortYaml");
        this.checkerInfo = checkerInfo;
        this.ruleSortYaml = ruleSortYaml;
        this.id2checkerMap = new LinkedHashMap();
        Pair rulesAndRuleMappingsPair = this.parseRuleAndRuleMapping(this.ruleSortYaml);
        this.rules = (Set)rulesAndRuleMappingsPair.getFirst();
        this.ruleMapping = (Set)rulesAndRuleMappingsPair.getSecond();
        Iterable iterable = this.rules;
        RuleAndRuleMapping ruleAndRuleMapping = this;
        boolean $i$f$associateBy = false;
        int capacity$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateBy$iv, (int)10)), (int)16);
        void var7_8 = $this$associateBy$iv;
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv : $this$associateByTo$iv$iv) {
            void it;
            Rule rule = (Rule)element$iv$iv;
            Map map = destination$iv$iv;
            boolean bl = false;
            map.put(it.getName(), element$iv$iv);
        }
        ruleAndRuleMapping.id2checkerMap = destination$iv$iv;
    }

    @NotNull
    public final Map<String, Rule> getId2checkerMap() {
        return this.id2checkerMap;
    }

    public final void setId2checkerMap(@NotNull Map<String, Rule> map) {
        Intrinsics.checkNotNullParameter(map, (String)"<set-?>");
        this.id2checkerMap = map;
    }

    /*
     * WARNING - void declaration
     */
    private final Pair<Set<Rule>, Set<RuleMapping>> parseRuleAndRuleMapping(Path ruleSortYaml) {
        void destination$iv;
        void $this$mapTo$iv;
        CheckerInfo it;
        Object object;
        Iterable $this$associateByTo$iv$iv;
        Object destination$iv$iv;
        Object object2;
        LinkOption[] linkOptionArray = new LinkOption[]{};
        if (!Files.exists(ruleSortYaml, Arrays.copyOf(linkOptionArray, linkOptionArray.length))) {
            logger.warn(() -> RuleAndRuleMapping.parseRuleAndRuleMapping$lambda$1(ruleSortYaml));
            object2 = null;
        } else {
            Iterable $this$associateBy$iv = CheckerPriorityConfig.Companion.deserialize(Resource.INSTANCE.fileOf(ruleSortYaml)).getRuleWithSortNumber(this.checkerInfo.getChapters());
            boolean $i$f$associateBy = false;
            int capacity$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateBy$iv, (int)10)), (int)16);
            Iterable iterable = $this$associateBy$iv;
            destination$iv$iv = new LinkedHashMap(capacity$iv);
            boolean $i$f$associateByTo = false;
            for (Object element$iv$iv : $this$associateByTo$iv$iv) {
                IndexedValue indexedValue = (IndexedValue)element$iv$iv;
                object = destination$iv$iv;
                boolean bl = false;
                object.put(((ChapterFlat)it.getValue()).getRuleId(), element$iv$iv);
            }
            object2 = destination$iv$iv;
        }
        Object ruleWithSortNumber = object2;
        LinkedHashSet rows = this.checkerInfo.getCheckerInfoList();
        Set ruleMappings = new LinkedHashSet();
        $this$associateByTo$iv$iv = rows;
        destination$iv$iv = new LinkedHashSet();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            Long l;
            String string6;
            IndexedValue ruleSortNumber;
            void row;
            it = (CheckerInfo)item$iv;
            object = destination$iv;
            boolean bl = false;
            String name = row.getChecker_id();
            Object object3 = ruleWithSortNumber;
            IndexedValue indexedValue = ruleSortNumber = object3 != null ? (IndexedValue)object3.get(name) : null;
            if (ruleWithSortNumber != null && ruleSortNumber == null) {
                logger.warn(() -> RuleAndRuleMapping.parseRuleAndRuleMapping$lambda$5$lambda$3((CheckerInfo)row, name, ruleSortYaml));
            }
            ChapterFlat chapterFlat = row.getChapterFlat();
            ruleMappings.addAll(this.getCurrentRuleMappingSet((CheckerInfo)row, name));
            String string7 = name;
            String string8 = (String)row.getName().get("en-US");
            if (string8 == null) {
                string8 = "None";
            }
            if ((string6 = (String)row.getName().get("zh-CN")) == null) {
                string6 = "None";
            }
            String string9 = row.getSeverity();
            String string10 = null;
            String string11 = "Java";
            String string12 = row.getPrecision();
            String string13 = row.getReCall();
            String string14 = row.getLikelihood();
            String string15 = row.getImpact();
            String string16 = row.getImpl();
            String string17 = "";
            String string18 = "";
            Long l2 = 1L;
            Boolean bl2 = row.getImplemented();
            if (bl2 != null) {
                void it2;
                boolean bl3 = bl2;
                Long l3 = l2;
                String string19 = string18;
                String string20 = string17;
                String string21 = string16;
                String string22 = string15;
                String string23 = string14;
                String string24 = string13;
                String string25 = string12;
                String string26 = string11;
                String string27 = string10;
                String string28 = string9;
                String string29 = string6;
                String string30 = string8;
                String string31 = string7;
                boolean bl4 = false;
                Long l4 = it2 != false ? 1L : 0L;
                string7 = string31;
                string8 = string30;
                string6 = string29;
                string9 = string28;
                string10 = string27;
                string11 = string26;
                string12 = string25;
                string13 = string24;
                string14 = string23;
                string15 = string22;
                string16 = string21;
                string17 = string20;
                string18 = string19;
                l2 = l3;
                l = l4;
            } else {
                l = null;
            }
            if ((string5 = (String)row.getCategory().get("en-US")) == null) {
                string5 = "None";
            }
            if ((string4 = (String)row.getCategory().get("zh-CN")) == null) {
                string4 = "None";
            }
            IndexedValue indexedValue2 = ruleSortNumber;
            Long l5 = indexedValue2 != null ? (long)indexedValue2.getIndex() : (long)rows.size() + 1L;
            ChapterFlat chapterFlat2 = chapterFlat;
            String string32 = chapterFlat2 != null ? chapterFlat2.getCategory() : null;
            ChapterFlat chapterFlat3 = chapterFlat;
            String string33 = chapterFlat3 != null ? chapterFlat3.getSeverity() : null;
            ChapterFlat chapterFlat4 = chapterFlat;
            String string34 = chapterFlat4 != null ? chapterFlat4.getRuleId() : null;
            String string35 = (String)row.getAbstract().get("en-US");
            if (string35 == null) {
                string35 = "None";
            }
            if ((string3 = (String)row.getAbstract().get("zh-CN")) == null) {
                string3 = "None";
            }
            if ((string2 = (String)row.getDescription().get("en-US")) == null) {
                string2 = "None";
            }
            if ((string = (String)row.getDescription().get("zh-CN")) == null) {
                string = "None";
            }
            String string36 = string;
            String string37 = string2;
            String string38 = string3;
            String string39 = string35;
            String string40 = null;
            String string41 = string34;
            String string42 = string33;
            String string43 = string32;
            Long l6 = l5;
            String string44 = string4;
            String string45 = string5;
            String string46 = null;
            String string47 = null;
            Long l7 = l;
            Long l8 = l2;
            String string48 = string18;
            String string49 = string17;
            String string50 = string16;
            String string51 = string15;
            String string52 = string14;
            String string53 = string13;
            String string54 = string12;
            String string55 = string11;
            String string56 = string10;
            String string57 = string9;
            String string58 = string6;
            String string59 = string8;
            String string60 = string7;
            object.add(new Rule(string60, string59, string58, string57, string56, string55, string54, string53, string52, string51, string50, string49, string48, l8, l7, string47, string46, string45, string44, l6, string43, string42, string41, string40, string39, string38, string37, string36));
        }
        Set rules2 = (Set)destination$iv;
        return new Pair((Object)rules2, (Object)ruleMappings);
    }

    /*
     * WARNING - void declaration
     */
    private final Set<RuleMapping> getCurrentRuleMappingSet(CheckerInfo row, String name) {
        void destination$iv;
        void $this$mapTo$iv;
        Iterable iterable = row.getTags();
        Collection collection = new LinkedHashSet();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            Tag tag = (Tag)item$iv;
            void var10_10 = destination$iv;
            boolean bl = false;
            var10_10.add(new RuleMapping(name, it.getStandard(), it.getRule()));
        }
        return (Set)destination$iv;
    }

    public final void insert(@NotNull Database database) {
        Intrinsics.checkNotNullParameter((Object)database, (String)"database");
        this.insert(database, null);
    }

    public final void insert(@NotNull Database database, @Nullable Set<String> filter2) {
        Set<String> set;
        Intrinsics.checkNotNullParameter((Object)database, (String)"database");
        Set<String> set2 = filter2;
        if (set2 != null) {
            Set<String> set3;
            Set<String> it = set3 = set2;
            boolean bl = false;
            set = !((Collection)it).isEmpty() ? set3 : null;
        } else {
            set = null;
        }
        Set<String> f = set;
        Transacter.DefaultImpls.transaction$default((Transacter)((Transacter)database), (boolean)false, arg_0 -> RuleAndRuleMapping.insert$lambda$11(this, database, f, arg_0), (int)1, null);
    }

    private static final Object parseRuleAndRuleMapping$lambda$1(Path $ruleSortYaml) {
        return "The ruleSortYaml " + $ruleSortYaml + " is not exists";
    }

    private static final Object parseRuleAndRuleMapping$lambda$5$lambda$3(CheckerInfo $row, String $name, Path $ruleSortYaml) {
        return "can't find the category '" + $row.getCategory().get("zh-CN") + "' of " + $name + " in " + $ruleSortYaml;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit insert$lambda$11(RuleAndRuleMapping this$0, Database $database, Set $f, TransactionWithoutReturn $this$transaction) {
        void $this$filterTo$iv$iv;
        Object p0;
        void $this$forEach$iv;
        void $this$filterTo$iv$iv2;
        Intrinsics.checkNotNullParameter((Object)$this$transaction, (String)"$this$transaction");
        Iterable $this$filter$iv = this$0.rules;
        boolean $i$f$filter22 = false;
        Iterable iterable = $this$filter$iv;
        Object destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv2) {
            Rule it = (Rule)element$iv$iv;
            boolean bl = false;
            Set set = $f;
            if (!(set != null ? set.contains(it.getName()) : true)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        RuleQueries $i$f$filter22 = $database.getRuleQueries();
        boolean $i$f$forEach22 = false;
        for (Object element$iv : $this$forEach$iv) {
            p0 = (Rule)element$iv;
            boolean bl = false;
            boolean $i$f$insert$lambda$11$stub_for_inlining = false;
            $i$f$filter22.insert((Rule)p0);
        }
        $this$filter$iv = this$0.ruleMapping;
        boolean $i$f$filter = false;
        Iterable $i$f$forEach22 = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            RuleMapping it = (RuleMapping)element$iv$iv;
            boolean bl = false;
            Set set = $f;
            if (!(set != null ? set.contains(it.getRule_name()) : true)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        RuleMappingQueries ruleMappingQueries = $database.getRuleMappingQueries();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            p0 = (RuleMapping)element$iv;
            boolean bl = false;
            boolean $i$f$insert$lambda$11$stub_for_inlining$10 = false;
            ruleMappingQueries.insert((RuleMapping)p0);
        }
        return Unit.INSTANCE;
    }

    private static final Unit logger$lambda$12() {
        return Unit.INSTANCE;
    }
}

