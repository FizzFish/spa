package cn.sast.api.report;

import cn.sast.api.config.ExtSettings;
import cn.sast.api.report.BugPathEvent;
import cn.sast.api.report.BugPathPosition;
import cn.sast.api.report.IBugResInfo;
import cn.sast.api.report.IReportHashAble;
import cn.sast.api.report.IReportHashCalculator;
import cn.sast.api.report.MacroExpansion;
import cn.sast.api.report.ReportKt;
import cn.sast.api.util.ComparatorUtilsKt;
import cn.sast.common.GLB;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IRule;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.report.Region;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Closeable;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public final class Report implements Comparable<Report>, IReportHashAble {
    public enum HashType {
        CONTEXT_FREE,
        PATH_SENSITIVE,
        DIAGNOSTIC_MESSAGE
    }

    private static final Map<String, String> deprecatedRuleCategoryMap;
    private static int hashVersion;

    static {
        Json jsonFormat = JsonKt.Json$default(null, $this$Json -> {
            $this$Json.setUseArrayPolymorphism(true);
            $this$Json.setPrettyPrint(true);
            return Unit.INSTANCE;
        }, 1, null);

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("deprecated_rule_category.json");
        Objects.requireNonNull(inputStream);

        try (InputStream it = inputStream) {
            deprecatedRuleCategoryMap = JvmStreamsKt.decodeFromStream(jsonFormat, 
                new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), it);
        }

        int version = ExtSettings.INSTANCE.getHashVersion();
        if (version < 1 || version >= 3) {
            throw new IllegalStateException("Bad hash version: " + version);
        }
        hashVersion = version;
    }

    @NotNull private final IBugResInfo bugResFile;
    @NotNull private final Region region;
    @NotNull private final Map<Language, String> message;
    @NotNull private final String check_name;
    @NotNull private final String detector_name;
    @NotNull private final String type;
    @NotNull private final Set<IRule> standard;
    @Nullable private final String severity;
    @Nullable private final String analyzer_name;
    @Nullable private final String category;
    @Nullable private final String analyzer_result_file_path;
    @NotNull private final CheckType checkType;
    @NotNull private List<BugPathEvent> pathEvents;
    @NotNull private List<BugPathPosition> bug_path_positions;
    @NotNull private List<BugPathEvent> notes;
    @NotNull private List<MacroExpansion> macro_expansions;

    public Report(@NotNull IBugResInfo bugResFile, @NotNull Region region, @NotNull Map<Language, String> message,
                 @NotNull String check_name, @NotNull String detector_name, @NotNull String type,
                 @NotNull Set<? extends IRule> standard, @Nullable String severity, @Nullable String analyzer_name,
                 @Nullable String category, @Nullable String analyzer_result_file_path, @NotNull CheckType checkType,
                 @NotNull List<BugPathEvent> pathEvents, @NotNull List<BugPathPosition> bug_path_positions,
                 @NotNull List<BugPathEvent> notes, @NotNull List<MacroExpansion> macro_expansions) {
        Objects.requireNonNull(bugResFile, "bugResFile");
        Objects.requireNonNull(region, "region");
        Objects.requireNonNull(message, "message");
        Objects.requireNonNull(check_name, "check_name");
        Objects.requireNonNull(detector_name, "detector_name");
        Objects.requireNonNull(type, "type");
        Objects.requireNonNull(standard, "standard");
        Objects.requireNonNull(checkType, "checkType");
        Objects.requireNonNull(pathEvents, "pathEvents");
        Objects.requireNonNull(bug_path_positions, "bug_path_positions");
        Objects.requireNonNull(notes, "notes");
        Objects.requireNonNull(macro_expansions, "macro_expansions");

        this.bugResFile = bugResFile;
        this.region = region;
        this.message = message;
        this.check_name = check_name;
        this.detector_name = detector_name;
        this.type = type;
        this.standard = standard;
        this.severity = severity;
        this.analyzer_name = analyzer_name;
        this.category = category;
        this.analyzer_result_file_path = analyzer_result_file_path;
        this.checkType = checkType;
        this.pathEvents = pathEvents;
        this.bug_path_positions = bug_path_positions;
        this.notes = notes;
        this.macro_expansions = macro_expansions;

        GLB.INSTANCE.plusAssign(this.checkType);
        this.pathEvents.add(new BugPathEvent(this.message, this.bugResFile, this.region, null, 8, null));
    }

    // Getters
    @NotNull public IBugResInfo getBugResFile() { return bugResFile; }
    @NotNull public Region getRegion() { return region; }
    @NotNull public Map<Language, String> getMessage() { return message; }
    @NotNull public String getCheck_name() { return check_name; }
    @NotNull public String getDetector_name() { return detector_name; }
    @NotNull public String getType() { return type; }
    @NotNull public Set<IRule> getStandard() { return standard; }
    @Nullable public String getSeverity() { return severity; }
    @Nullable public String getAnalyzer_name() { return analyzer_name; }
    @Nullable public String getCategory() { return category; }
    @Nullable public String getAnalyzer_result_file_path() { return analyzer_result_file_path; }
    @NotNull public CheckType getCheckType() { return checkType; }

    // List getters and setters
    @NotNull public List<BugPathEvent> getPathEvents() { return pathEvents; }
    public void setPathEvents(@NotNull List<BugPathEvent> pathEvents) {
        this.pathEvents = Objects.requireNonNull(pathEvents);
    }

    @NotNull public List<BugPathPosition> getBug_path_positions() { return bug_path_positions; }
    public void setBug_path_positions(@NotNull List<BugPathPosition> bug_path_positions) {
        this.bug_path_positions = Objects.requireNonNull(bug_path_positions);
    }

    @NotNull public List<BugPathEvent> getNotes() { return notes; }
    public void setNotes(@NotNull List<BugPathEvent> notes) {
        this.notes = Objects.requireNonNull(notes);
    }

    @NotNull public List<MacroExpansion> getMacro_expansions() { return macro_expansions; }
    public void setMacro_expansions(@NotNull List<MacroExpansion> macro_expansions) {
        this.macro_expansions = Objects.requireNonNull(macro_expansions);
    }

    @NotNull
    public Set<IBugResInfo> getClasses() {
        Set<IBugResInfo> ret = new HashSet<>();
        ret.add(bugResFile);

        pathEvents.stream().map(BugPathEvent::getClassname).forEach(ret::add);
        bug_path_positions.stream().map(BugPathPosition::getClassname).forEach(ret::add);
        notes.stream().map(BugPathEvent::getClassname).forEach(ret::add);
        macro_expansions.stream().map(MacroExpansion::getClassname).forEach(ret::add);

        return ret;
    }

    @Override
    @NotNull
    public String reportHash(@NotNull IReportHashCalculator c) {
        Objects.requireNonNull(c, "c");
        return bugResFile.reportHash(c) + ":" + region + " " + check_name + "," + detector_name + "," + type + 
               "," + category + "," + severity + "," + analyzer_name + "} ";
    }

    @NotNull
    public String reportHash(@NotNull IReportHashCalculator hashCalculator, @NotNull HashType hashType) {
        Objects.requireNonNull(hashCalculator, "hashCalculator");
        Objects.requireNonNull(hashType, "hashType");

        List<String> ret = new ArrayList<>();
        switch (hashType) {
            case CONTEXT_FREE:
                getReportHashContextFree(hashCalculator, ret);
                break;
            case PATH_SENSITIVE:
                getReportHashContextFree(hashCalculator, ret);
                getReportHashPathSensitive(hashCalculator, ret);
                break;
            case DIAGNOSTIC_MESSAGE:
                getReportHashContextFree(hashCalculator, ret);
                getReportHashDiagnosticMessage(hashCalculator, ret, false);
                break;
            default:
                throw new IllegalStateException("Unexpected hash type: " + hashType);
        }
        return ReportKt.toHex(ReportKt.md5(String.join("|", ret)));
    }

    private void getReportHashContextFree(IReportHashCalculator c, List<String> ret) {
        ret.add(reportHash(c));
    }

    private void getReportHashPathSensitive(IReportHashCalculator c, List<String> ret) {
        if (!pathEvents.isEmpty()) {
            ret.add(pathEvents.get(pathEvents.size() - 1).reportHash(c));
        }
    }

    private void getReportHashDiagnosticMessage(IReportHashCalculator c, List<String> ret, boolean onlyHeadTail) {
        if (onlyHeadTail) {
            pathEvents.forEach(be -> ret.add(be.reportHashWithMessage(c)));
        } else {
            if (!pathEvents.isEmpty()) {
                ret.add(pathEvents.get(0).reportHashWithMessage(c));
                if (pathEvents.size() >= 2) {
                    ret.add(pathEvents.get(pathEvents.size() - 1).reportHashWithMessage(c));
                }
            }
        }
    }

    @Override
    public int compareTo(@NotNull Report other) {
        Objects.requireNonNull(other, "other");

        int cmp = ComparatorUtilsKt.compareToNullable(analyzer_name, other.analyzer_name);
        if (cmp != 0) return cmp;

        cmp = bugResFile.compareTo(other.bugResFile);
        if (cmp != 0) return cmp;

        cmp = Integer.compare(region.startLine, other.region.startLine);
        if (cmp != 0) return cmp;

        cmp = ComparatorUtilsKt.compareToMap(new TreeMap<>(message), new TreeMap<>(other.message));
        if (cmp != 0) return cmp;

        cmp = check_name.compareTo(other.check_name);
        if (cmp != 0) return cmp;

        cmp = detector_name.compareTo(other.detector_name);
        if (cmp != 0) return cmp;

        cmp = type.compareTo(other.type);
        if (cmp != 0) return cmp;

        cmp = checkType.compareTo(other.checkType);
        if (cmp != 0) return cmp;

        cmp = ComparatorUtilsKt.compareTo(Comparator.comparing(IRule::getName), standard, other.standard);
        if (cmp != 0) return cmp;

        cmp = Integer.compare(region.startColumn, other.region.startColumn);
        if (cmp != 0) return cmp;

        cmp = ComparatorUtilsKt.compareToNullable(severity, other.severity);
        if (cmp != 0) return cmp;

        cmp = ComparatorUtilsKt.compareToNullable(category, other.category);
        if (cmp != 0) return cmp;

        cmp = ComparatorUtilsKt.compareToNullable(analyzer_result_file_path, other.analyzer_result_file_path);
        if (cmp != 0) return cmp;

        cmp = ComparatorUtilsKt.compareToCollection(pathEvents, other.pathEvents);
        if (cmp != 0) return cmp;

        cmp = ComparatorUtilsKt.compareToCollection(bug_path_positions, other.bug_path_positions);
        if (cmp != 0) return cmp;

        cmp = ComparatorUtilsKt.compareToCollection(notes, other.notes);
        if (cmp != 0) return cmp;

        return ComparatorUtilsKt.compareToCollection(macro_expansions, other.macro_expansions);
    }

    // Component methods
    @NotNull public IBugResInfo component1() { return bugResFile; }
    @NotNull public Region component2() { return region; }
    @NotNull public Map<Language, String> component3() { return message; }
    @NotNull public String component4() { return check_name; }
    @NotNull public String component5() { return detector_name; }
    @NotNull public String component6() { return type; }
    @NotNull public Set<IRule> component7() { return standard; }
    @Nullable public String component8() { return severity; }
    @Nullable public String component9() { return analyzer_name; }
    @Nullable public String component10() { return category; }
    @Nullable public String component11() { return analyzer_result_file_path; }
    @NotNull public CheckType component12() { return checkType; }
    @NotNull public List<BugPathEvent> component13() { return pathEvents; }
    @NotNull public List<BugPathPosition> component14() { return bug_path_positions; }
    @NotNull public List<BugPathEvent> component15() { return notes; }
    @NotNull public List<MacroExpansion> component16() { return macro_expansions; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Report)) return false;
        Report report = (Report) o;
        return bugResFile.equals(report.bugResFile) &&
               region.equals(report.region) &&
               message.equals(report.message) &&
               check_name.equals(report.check_name) &&
               detector_name.equals(report.detector_name) &&
               type.equals(report.type) &&
               standard.equals(report.standard) &&
               Objects.equals(severity, report.severity) &&
               Objects.equals(analyzer_name, report.analyzer_name) &&
               Objects.equals(category, report.category) &&
               Objects.equals(analyzer_result_file_path, report.analyzer_result_file_path) &&
               checkType.equals(report.checkType) &&
               pathEvents.equals(report.pathEvents) &&
               bug_path_positions.equals(report.bug_path_positions) &&
               notes.equals(report.notes) &&
               macro_expansions.equals(report.macro_expansions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bugResFile, region, message, check_name, detector_name, type, standard, severity,
                          analyzer_name, category, analyzer_result_file_path, checkType, pathEvents, 
                          bug_path_positions, notes, macro_expansions);
    }

    @Override
    public String toString() {
        return "Report(bugResFile=" + bugResFile + ", region=" + region + ", message=" + message + 
               ", check_name=" + check_name + ", detector_name=" + detector_name + ", type=" + type + 
               ", standard=" + standard + ", severity=" + severity + ", analyzer_name=" + analyzer_name + 
               ", category=" + category + ", analyzer_result_file_path=" + analyzer_result_file_path + 
               ", checkType=" + checkType + ", pathEvents=" + pathEvents + ", bug_path_positions=" + 
               bug_path_positions + ", notes=" + notes + ", macro_expansions=" + macro_expansions + ")";
    }
}
