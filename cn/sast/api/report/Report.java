/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ExtSettings
 *  cn.sast.api.report.BugPathEvent
 *  cn.sast.api.report.BugPathPosition
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.api.report.IReportHashAble
 *  cn.sast.api.report.IReportHashCalculator
 *  cn.sast.api.report.MacroExpansion
 *  cn.sast.api.report.Report
 *  cn.sast.api.report.Report$Companion
 *  cn.sast.api.report.Report$HashType
 *  cn.sast.api.report.Report$WhenMappings
 *  cn.sast.api.report.ReportKt
 *  cn.sast.api.util.ComparatorUtilsKt
 *  cn.sast.common.GLB
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.api.IRule
 *  com.feysh.corax.config.api.Language
 *  com.feysh.corax.config.api.report.Region
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.DeserializationStrategy
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.StringSerializer
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JsonBuilder
 *  kotlinx.serialization.json.JsonKt
 *  kotlinx.serialization.json.JvmStreamsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.report;

import cn.sast.api.config.ExtSettings;
import cn.sast.api.report.BugPathEvent;
import cn.sast.api.report.BugPathPosition;
import cn.sast.api.report.IBugResInfo;
import cn.sast.api.report.IReportHashAble;
import cn.sast.api.report.IReportHashCalculator;
import cn.sast.api.report.MacroExpansion;
import cn.sast.api.report.Report;
import cn.sast.api.report.ReportKt;
import cn.sast.api.util.ComparatorUtilsKt;
import cn.sast.common.GLB;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IRule;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.report.Region;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JvmStreamsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u0000 e2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0002efB\u00cb\u0001\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020BH\u0016J\u001e\u0010C\u001a\u00020D2\u0006\u0010A\u001a\u00020B2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\n0\u0018H\u0002J\u001e\u0010F\u001a\u00020D2\u0006\u0010A\u001a\u00020B2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\n0\u0018H\u0002J(\u0010G\u001a\u00020D2\u0006\u0010A\u001a\u00020B2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\n0\u00182\b\b\u0002\u0010H\u001a\u00020IH\u0002J\u0016\u0010@\u001a\u00020\n2\u0006\u0010J\u001a\u00020B2\u0006\u0010K\u001a\u00020LJ\u0011\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0000H\u0096\u0002J\t\u0010P\u001a\u00020\u0004H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0006H\u00c6\u0003J\u0015\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u00c6\u0003J\t\u0010S\u001a\u00020\nH\u00c6\u0003J\t\u0010T\u001a\u00020\nH\u00c6\u0003J\t\u0010U\u001a\u00020\nH\u00c6\u0003J\u000f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u00c6\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u0010[\u001a\u00020\u0016H\u00c6\u0003J\u000f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u00c6\u0003J\u000f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018H\u00c6\u0003J\u000f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u00c6\u0003J\u000f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018H\u00c6\u0003J\u00db\u0001\u0010`\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018H\u00c6\u0001J\u0013\u0010a\u001a\u00020I2\b\u0010O\u001a\u0004\u0018\u00010bH\u00d6\u0003J\t\u0010c\u001a\u00020NH\u00d6\u0001J\t\u0010d\u001a\u00020\nH\u00d6\u0001R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010(R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u00104\"\u0004\b:\u00106R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u00104\"\u0004\b<\u00106R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00040>8F\u00a2\u0006\u0006\u001a\u0004\b?\u0010,\u00a8\u0006g"}, d2={"Lcn/sast/api/report/Report;", "", "Lcn/sast/api/report/IReportHashAble;", "bugResFile", "Lcn/sast/api/report/IBugResInfo;", "region", "Lcom/feysh/corax/config/api/report/Region;", "message", "", "Lcom/feysh/corax/config/api/Language;", "", "check_name", "detector_name", "type", "standard", "", "Lcom/feysh/corax/config/api/IRule;", "severity", "analyzer_name", "category", "analyzer_result_file_path", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "pathEvents", "", "Lcn/sast/api/report/BugPathEvent;", "bug_path_positions", "Lcn/sast/api/report/BugPathPosition;", "notes", "macro_expansions", "Lcn/sast/api/report/MacroExpansion;", "<init>", "(Lcn/sast/api/report/IBugResInfo;Lcom/feysh/corax/config/api/report/Region;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/feysh/corax/config/api/CheckType;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBugResFile", "()Lcn/sast/api/report/IBugResInfo;", "getRegion", "()Lcom/feysh/corax/config/api/report/Region;", "getMessage", "()Ljava/util/Map;", "getCheck_name", "()Ljava/lang/String;", "getDetector_name", "getType", "getStandard", "()Ljava/util/Set;", "getSeverity", "getAnalyzer_name", "getCategory", "getAnalyzer_result_file_path", "getCheckType", "()Lcom/feysh/corax/config/api/CheckType;", "getPathEvents", "()Ljava/util/List;", "setPathEvents", "(Ljava/util/List;)V", "getBug_path_positions", "setBug_path_positions", "getNotes", "setNotes", "getMacro_expansions", "setMacro_expansions", "classes", "", "getClasses", "reportHash", "c", "Lcn/sast/api/report/IReportHashCalculator;", "getReportHashContextFree", "", "ret", "getReportHashPathSensitive", "getReportHashDiagnosticMessage", "onlyHeadTail", "", "hashCalculator", "hashType", "Lcn/sast/api/report/Report$HashType;", "compareTo", "", "other", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "", "hashCode", "toString", "Companion", "HashType", "corax-api"})
@SourceDebugExtension(value={"SMAP\nReport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Report.kt\ncn/sast/api/report/Report\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,451:1\n1628#2,3:452\n1628#2,3:455\n1628#2,3:458\n1628#2,3:461\n1#3:464\n*S KotlinDebug\n*F\n+ 1 Report.kt\ncn/sast/api/report/Report\n*L\n330#1:452,3\n331#1:455,3\n332#1:458,3\n333#1:461,3\n*E\n"})
public final class Report
implements Comparable<Report>,
IReportHashAble {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final IBugResInfo bugResFile;
    @NotNull
    private final Region region;
    @NotNull
    private final Map<Language, String> message;
    @NotNull
    private final String check_name;
    @NotNull
    private final String detector_name;
    @NotNull
    private final String type;
    @NotNull
    private final Set<IRule> standard;
    @Nullable
    private final String severity;
    @Nullable
    private final String analyzer_name;
    @Nullable
    private final String category;
    @Nullable
    private final String analyzer_result_file_path;
    @NotNull
    private final CheckType checkType;
    @NotNull
    private List<BugPathEvent> pathEvents;
    @NotNull
    private List<BugPathPosition> bug_path_positions;
    @NotNull
    private List<BugPathEvent> notes;
    @NotNull
    private List<MacroExpansion> macro_expansions;
    @NotNull
    private static final Map<String, String> deprecatedRuleCategoryMap;
    private static int hashVersion;

    public Report(@NotNull IBugResInfo bugResFile, @NotNull Region region, @NotNull Map<Language, String> message, @NotNull String check_name, @NotNull String detector_name, @NotNull String type, @NotNull Set<? extends IRule> standard, @Nullable String severity, @Nullable String analyzer_name, @Nullable String category, @Nullable String analyzer_result_file_path, @NotNull CheckType checkType, @NotNull List<BugPathEvent> pathEvents, @NotNull List<BugPathPosition> bug_path_positions, @NotNull List<BugPathEvent> notes, @NotNull List<MacroExpansion> macro_expansions) {
        Intrinsics.checkNotNullParameter((Object)bugResFile, (String)"bugResFile");
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        Intrinsics.checkNotNullParameter(message, (String)"message");
        Intrinsics.checkNotNullParameter((Object)check_name, (String)"check_name");
        Intrinsics.checkNotNullParameter((Object)detector_name, (String)"detector_name");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter(standard, (String)"standard");
        Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
        Intrinsics.checkNotNullParameter(pathEvents, (String)"pathEvents");
        Intrinsics.checkNotNullParameter(bug_path_positions, (String)"bug_path_positions");
        Intrinsics.checkNotNullParameter(notes, (String)"notes");
        Intrinsics.checkNotNullParameter(macro_expansions, (String)"macro_expansions");
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
        ((Collection)this.pathEvents).add(new BugPathEvent(this.message, this.bugResFile, this.region, null, 8, null));
    }

    public /* synthetic */ Report(IBugResInfo iBugResInfo, Region region, Map map, String string, String string2, String string3, Set set, String string4, String string5, String string6, String string7, CheckType checkType, List list, List list2, List list3, List list4, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x80) != 0) {
            string4 = null;
        }
        if ((n & 0x100) != 0) {
            string5 = null;
        }
        if ((n & 0x200) != 0) {
            string6 = null;
        }
        if ((n & 0x400) != 0) {
            string7 = null;
        }
        if ((n & 0x1000) != 0) {
            list = new ArrayList();
        }
        if ((n & 0x2000) != 0) {
            list2 = new ArrayList();
        }
        if ((n & 0x4000) != 0) {
            list3 = new ArrayList();
        }
        if ((n & 0x8000) != 0) {
            list4 = new ArrayList();
        }
        this(iBugResInfo, region, map, string, string2, string3, set, string4, string5, string6, string7, checkType, list, list2, list3, list4);
    }

    @NotNull
    public final IBugResInfo getBugResFile() {
        return this.bugResFile;
    }

    @NotNull
    public final Region getRegion() {
        return this.region;
    }

    @NotNull
    public final Map<Language, String> getMessage() {
        return this.message;
    }

    @NotNull
    public final String getCheck_name() {
        return this.check_name;
    }

    @NotNull
    public final String getDetector_name() {
        return this.detector_name;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final Set<IRule> getStandard() {
        return this.standard;
    }

    @Nullable
    public final String getSeverity() {
        return this.severity;
    }

    @Nullable
    public final String getAnalyzer_name() {
        return this.analyzer_name;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final String getAnalyzer_result_file_path() {
        return this.analyzer_result_file_path;
    }

    @NotNull
    public final CheckType getCheckType() {
        return this.checkType;
    }

    @NotNull
    public final List<BugPathEvent> getPathEvents() {
        return this.pathEvents;
    }

    public final void setPathEvents(@NotNull List<BugPathEvent> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.pathEvents = list;
    }

    @NotNull
    public final List<BugPathPosition> getBug_path_positions() {
        return this.bug_path_positions;
    }

    public final void setBug_path_positions(@NotNull List<BugPathPosition> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.bug_path_positions = list;
    }

    @NotNull
    public final List<BugPathEvent> getNotes() {
        return this.notes;
    }

    public final void setNotes(@NotNull List<BugPathEvent> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.notes = list;
    }

    @NotNull
    public final List<MacroExpansion> getMacro_expansions() {
        return this.macro_expansions;
    }

    public final void setMacro_expansions(@NotNull List<MacroExpansion> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.macro_expansions = list;
    }

    @NotNull
    public final Set<IBugResInfo> getClasses() {
        BugPathPosition it;
        Collection collection;
        Object[] objectArray = new IBugResInfo[]{this.bugResFile};
        Set ret = SetsKt.mutableSetOf((Object[])objectArray);
        Iterable $this$mapTo$iv = this.pathEvents;
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            BugPathEvent bugPathEvent = (BugPathEvent)item$iv;
            collection = ret;
            boolean bl = false;
            collection.add(it.getClassname());
        }
        $this$mapTo$iv = this.bug_path_positions;
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (BugPathPosition)item$iv;
            collection = ret;
            boolean bl = false;
            collection.add(it.getClassname());
        }
        $this$mapTo$iv = this.notes;
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (BugPathEvent)item$iv;
            collection = ret;
            boolean bl = false;
            collection.add(it.getClassname());
        }
        $this$mapTo$iv = this.macro_expansions;
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (MacroExpansion)item$iv;
            collection = ret;
            boolean bl = false;
            collection.add(it.getClassname());
        }
        return ret;
    }

    @NotNull
    public String reportHash(@NotNull IReportHashCalculator c) {
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        return this.bugResFile.reportHash(c) + ":" + this.region + " " + this.check_name + "," + this.detector_name + "," + this.type + "," + this.category + "," + this.severity + "," + this.analyzer_name + "} ";
    }

    private final void getReportHashContextFree(IReportHashCalculator c, List<String> ret) {
        ret.add(this.reportHash(c));
    }

    private final void getReportHashPathSensitive(IReportHashCalculator c, List<String> ret) {
        block0: {
            BugPathEvent bugPathEvent;
            BugPathEvent bugPathEvent2 = (BugPathEvent)CollectionsKt.lastOrNull((List)this.pathEvents);
            if (bugPathEvent2 == null) break block0;
            BugPathEvent last = bugPathEvent = bugPathEvent2;
            boolean bl = false;
            ret.add(last.reportHash(c));
        }
    }

    private final void getReportHashDiagnosticMessage(IReportHashCalculator c, List<String> ret, boolean onlyHeadTail) {
        block4: {
            BugPathEvent bugPathEvent;
            Object object;
            block3: {
                if (!onlyHeadTail) break block3;
                for (BugPathEvent be : this.pathEvents) {
                    ret.add(be.reportHashWithMessage(c));
                }
                break block4;
            }
            BugPathEvent bugPathEvent2 = (BugPathEvent)CollectionsKt.firstOrNull((List)this.pathEvents);
            if (bugPathEvent2 != null) {
                BugPathEvent it = bugPathEvent2;
                boolean bl = false;
                ret.add(it.reportHashWithMessage(c));
            }
            if ((object = (BugPathEvent)CollectionsKt.lastOrNull((List)this.pathEvents)) == null) break block4;
            BugPathEvent it = bugPathEvent = object;
            boolean bl = false;
            object = this.pathEvents.size() >= 2 ? bugPathEvent : null;
            if (object != null) {
                it = object;
                boolean bl2 = false;
                ret.add(it.reportHashWithMessage(c));
            }
        }
    }

    static /* synthetic */ void getReportHashDiagnosticMessage$default(Report report, IReportHashCalculator iReportHashCalculator, List list, boolean bl, int n, Object object) {
        if ((n & 4) != 0) {
            bl = false;
        }
        report.getReportHashDiagnosticMessage(iReportHashCalculator, list, bl);
    }

    @NotNull
    public final String reportHash(@NotNull IReportHashCalculator hashCalculator2, @NotNull HashType hashType) {
        Intrinsics.checkNotNullParameter((Object)hashCalculator2, (String)"hashCalculator");
        Intrinsics.checkNotNullParameter((Object)hashType, (String)"hashType");
        List ret = new ArrayList();
        switch (WhenMappings.$EnumSwitchMapping$0[hashType.ordinal()]) {
            case 1: {
                this.getReportHashContextFree(hashCalculator2, ret);
                break;
            }
            case 2: {
                this.getReportHashContextFree(hashCalculator2, ret);
                this.getReportHashPathSensitive(hashCalculator2, ret);
                break;
            }
            case 3: {
                this.getReportHashContextFree(hashCalculator2, ret);
                Report.getReportHashDiagnosticMessage$default((Report)this, (IReportHashCalculator)hashCalculator2, (List)ret, (boolean)false, (int)4, null);
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return ReportKt.toHex((byte[])ReportKt.md5((String)CollectionsKt.joinToString$default((Iterable)ret, (CharSequence)"|", null, null, (int)0, null, null, (int)62, null)));
    }

    @Override
    public int compareTo(@NotNull Report other) {
        Integer n;
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Integer n2 = ComparatorUtilsKt.compareToNullable((Comparable)((Comparable)((Object)this.analyzer_name)), (Comparable)((Comparable)((Object)other.analyzer_name)));
        int it = ((Number)n2).intValue();
        boolean bl = false;
        Integer n3 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl2 = false;
            return it;
        }
        n2 = this.bugResFile.compareTo((Object)other.bugResFile);
        it = ((Number)n2).intValue();
        boolean bl3 = false;
        Integer n4 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl4 = false;
            return it;
        }
        n2 = Intrinsics.compare((int)this.region.startLine, (int)other.region.startLine);
        it = ((Number)n2).intValue();
        boolean bl5 = false;
        Integer n5 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl6 = false;
            return it;
        }
        n2 = ComparatorUtilsKt.compareToMap((Map)MapsKt.toSortedMap((Map)this.message), (Map)MapsKt.toSortedMap((Map)other.message));
        it = ((Number)n2).intValue();
        boolean bl7 = false;
        Integer n6 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl8 = false;
            return it;
        }
        n2 = this.check_name.compareTo(other.check_name);
        it = ((Number)n2).intValue();
        boolean bl9 = false;
        Integer n7 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl10 = false;
            return it;
        }
        n2 = this.detector_name.compareTo(other.detector_name);
        it = ((Number)n2).intValue();
        boolean bl11 = false;
        Integer n8 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl12 = false;
            return it;
        }
        n2 = this.type.compareTo(other.type);
        it = ((Number)n2).intValue();
        boolean bl13 = false;
        Integer n9 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl14 = false;
            return it;
        }
        n2 = ((Comparator)new /* Unavailable Anonymous Inner Class!! */).compare(this.checkType, other.checkType);
        it = ((Number)n2).intValue();
        boolean bl15 = false;
        Integer n10 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl16 = false;
            return it;
        }
        n2 = ComparatorUtilsKt.compareTo((Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */), (Collection)this.standard, (Collection)other.standard);
        it = ((Number)n2).intValue();
        boolean bl17 = false;
        Integer n11 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl18 = false;
            return it;
        }
        n2 = Intrinsics.compare((int)this.region.startColumn, (int)other.region.startColumn);
        it = ((Number)n2).intValue();
        boolean bl19 = false;
        Integer n12 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl20 = false;
            return it;
        }
        n2 = ComparatorUtilsKt.compareToNullable((Comparable)((Comparable)((Object)this.severity)), (Comparable)((Comparable)((Object)other.severity)));
        it = ((Number)n2).intValue();
        boolean bl21 = false;
        Integer n13 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl22 = false;
            return it;
        }
        n2 = ComparatorUtilsKt.compareToNullable((Comparable)((Comparable)((Object)this.category)), (Comparable)((Comparable)((Object)other.category)));
        it = ((Number)n2).intValue();
        boolean bl23 = false;
        Integer n14 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl24 = false;
            return it;
        }
        n2 = ComparatorUtilsKt.compareToNullable((Comparable)((Comparable)((Object)this.analyzer_result_file_path)), (Comparable)((Comparable)((Object)other.analyzer_result_file_path)));
        it = ((Number)n2).intValue();
        boolean bl25 = false;
        Integer n15 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl26 = false;
            return it;
        }
        n2 = ComparatorUtilsKt.compareToCollection((Collection)this.pathEvents, (Collection)other.pathEvents);
        it = ((Number)n2).intValue();
        boolean bl27 = false;
        Integer n16 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl28 = false;
            return it;
        }
        n2 = ComparatorUtilsKt.compareToCollection((Collection)this.bug_path_positions, (Collection)other.bug_path_positions);
        it = ((Number)n2).intValue();
        boolean bl29 = false;
        Integer n17 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl30 = false;
            return it;
        }
        n2 = ComparatorUtilsKt.compareToCollection((Collection)this.notes, (Collection)other.notes);
        it = ((Number)n2).intValue();
        boolean bl31 = false;
        Integer n18 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl32 = false;
            return it;
        }
        n2 = ComparatorUtilsKt.compareToCollection((Collection)this.macro_expansions, (Collection)other.macro_expansions);
        it = ((Number)n2).intValue();
        boolean bl33 = false;
        Integer n19 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl34 = false;
            return it;
        }
        return 0;
    }

    @NotNull
    public final IBugResInfo component1() {
        return this.bugResFile;
    }

    @NotNull
    public final Region component2() {
        return this.region;
    }

    @NotNull
    public final Map<Language, String> component3() {
        return this.message;
    }

    @NotNull
    public final String component4() {
        return this.check_name;
    }

    @NotNull
    public final String component5() {
        return this.detector_name;
    }

    @NotNull
    public final String component6() {
        return this.type;
    }

    @NotNull
    public final Set<IRule> component7() {
        return this.standard;
    }

    @Nullable
    public final String component8() {
        return this.severity;
    }

    @Nullable
    public final String component9() {
        return this.analyzer_name;
    }

    @Nullable
    public final String component10() {
        return this.category;
    }

    @Nullable
    public final String component11() {
        return this.analyzer_result_file_path;
    }

    @NotNull
    public final CheckType component12() {
        return this.checkType;
    }

    @NotNull
    public final List<BugPathEvent> component13() {
        return this.pathEvents;
    }

    @NotNull
    public final List<BugPathPosition> component14() {
        return this.bug_path_positions;
    }

    @NotNull
    public final List<BugPathEvent> component15() {
        return this.notes;
    }

    @NotNull
    public final List<MacroExpansion> component16() {
        return this.macro_expansions;
    }

    @NotNull
    public final Report copy(@NotNull IBugResInfo bugResFile, @NotNull Region region, @NotNull Map<Language, String> message, @NotNull String check_name, @NotNull String detector_name, @NotNull String type, @NotNull Set<? extends IRule> standard, @Nullable String severity, @Nullable String analyzer_name, @Nullable String category, @Nullable String analyzer_result_file_path, @NotNull CheckType checkType, @NotNull List<BugPathEvent> pathEvents, @NotNull List<BugPathPosition> bug_path_positions, @NotNull List<BugPathEvent> notes, @NotNull List<MacroExpansion> macro_expansions) {
        Intrinsics.checkNotNullParameter((Object)bugResFile, (String)"bugResFile");
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        Intrinsics.checkNotNullParameter(message, (String)"message");
        Intrinsics.checkNotNullParameter((Object)check_name, (String)"check_name");
        Intrinsics.checkNotNullParameter((Object)detector_name, (String)"detector_name");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter(standard, (String)"standard");
        Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
        Intrinsics.checkNotNullParameter(pathEvents, (String)"pathEvents");
        Intrinsics.checkNotNullParameter(bug_path_positions, (String)"bug_path_positions");
        Intrinsics.checkNotNullParameter(notes, (String)"notes");
        Intrinsics.checkNotNullParameter(macro_expansions, (String)"macro_expansions");
        return new Report(bugResFile, region, message, check_name, detector_name, type, standard, severity, analyzer_name, category, analyzer_result_file_path, checkType, pathEvents, bug_path_positions, notes, macro_expansions);
    }

    public static /* synthetic */ Report copy$default(Report report, IBugResInfo iBugResInfo, Region region, Map map, String string, String string2, String string3, Set set, String string4, String string5, String string6, String string7, CheckType checkType, List list, List list2, List list3, List list4, int n, Object object) {
        if ((n & 1) != 0) {
            iBugResInfo = report.bugResFile;
        }
        if ((n & 2) != 0) {
            region = report.region;
        }
        if ((n & 4) != 0) {
            map = report.message;
        }
        if ((n & 8) != 0) {
            string = report.check_name;
        }
        if ((n & 0x10) != 0) {
            string2 = report.detector_name;
        }
        if ((n & 0x20) != 0) {
            string3 = report.type;
        }
        if ((n & 0x40) != 0) {
            set = report.standard;
        }
        if ((n & 0x80) != 0) {
            string4 = report.severity;
        }
        if ((n & 0x100) != 0) {
            string5 = report.analyzer_name;
        }
        if ((n & 0x200) != 0) {
            string6 = report.category;
        }
        if ((n & 0x400) != 0) {
            string7 = report.analyzer_result_file_path;
        }
        if ((n & 0x800) != 0) {
            checkType = report.checkType;
        }
        if ((n & 0x1000) != 0) {
            list = report.pathEvents;
        }
        if ((n & 0x2000) != 0) {
            list2 = report.bug_path_positions;
        }
        if ((n & 0x4000) != 0) {
            list3 = report.notes;
        }
        if ((n & 0x8000) != 0) {
            list4 = report.macro_expansions;
        }
        return report.copy(iBugResInfo, region, map, string, string2, string3, set, string4, string5, string6, string7, checkType, list, list2, list3, list4);
    }

    @NotNull
    public String toString() {
        return "Report(bugResFile=" + this.bugResFile + ", region=" + this.region + ", message=" + this.message + ", check_name=" + this.check_name + ", detector_name=" + this.detector_name + ", type=" + this.type + ", standard=" + this.standard + ", severity=" + this.severity + ", analyzer_name=" + this.analyzer_name + ", category=" + this.category + ", analyzer_result_file_path=" + this.analyzer_result_file_path + ", checkType=" + this.checkType + ", pathEvents=" + this.pathEvents + ", bug_path_positions=" + this.bug_path_positions + ", notes=" + this.notes + ", macro_expansions=" + this.macro_expansions + ")";
    }

    public int hashCode() {
        int result = this.bugResFile.hashCode();
        result = result * 31 + this.region.hashCode();
        result = result * 31 + ((Object)this.message).hashCode();
        result = result * 31 + this.check_name.hashCode();
        result = result * 31 + this.detector_name.hashCode();
        result = result * 31 + this.type.hashCode();
        result = result * 31 + ((Object)this.standard).hashCode();
        result = result * 31 + (this.severity == null ? 0 : this.severity.hashCode());
        result = result * 31 + (this.analyzer_name == null ? 0 : this.analyzer_name.hashCode());
        result = result * 31 + (this.category == null ? 0 : this.category.hashCode());
        result = result * 31 + (this.analyzer_result_file_path == null ? 0 : this.analyzer_result_file_path.hashCode());
        result = result * 31 + this.checkType.hashCode();
        result = result * 31 + ((Object)this.pathEvents).hashCode();
        result = result * 31 + ((Object)this.bug_path_positions).hashCode();
        result = result * 31 + ((Object)this.notes).hashCode();
        result = result * 31 + ((Object)this.macro_expansions).hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Report)) {
            return false;
        }
        Report report = (Report)other;
        if (!Intrinsics.areEqual((Object)this.bugResFile, (Object)report.bugResFile)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.region, (Object)report.region)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.message, (Object)report.message)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.check_name, (Object)report.check_name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.detector_name, (Object)report.detector_name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.type, (Object)report.type)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.standard, (Object)report.standard)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.severity, (Object)report.severity)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.analyzer_name, (Object)report.analyzer_name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.category, (Object)report.category)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.analyzer_result_file_path, (Object)report.analyzer_result_file_path)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.checkType, (Object)report.checkType)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pathEvents, (Object)report.pathEvents)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.bug_path_positions, (Object)report.bug_path_positions)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.notes, (Object)report.notes)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.macro_expansions, (Object)report.macro_expansions);
    }

    private static final Unit deprecatedRuleCategoryMap$lambda$46$lambda$44(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter((Object)$this$Json, (String)"$this$Json");
        $this$Json.setUseArrayPolymorphism(true);
        $this$Json.setPrettyPrint(true);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ int access$getHashVersion$cp() {
        return hashVersion;
    }

    public static final /* synthetic */ void access$setHashVersion$cp(int n) {
        hashVersion = n;
    }

    public static final /* synthetic */ Map access$getDeprecatedRuleCategoryMap$cp() {
        return deprecatedRuleCategoryMap;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static {
        int n;
        Map map;
        Companion $this$deprecatedRuleCategoryMap_u24lambda_u2446 = Companion = new Companion(null);
        boolean bl = false;
        Json jsonFormat = JsonKt.Json$default(null, Report::deprecatedRuleCategoryMap$lambda$46$lambda$44, (int)1, null);
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("deprecated_rule_category.json");
        Intrinsics.checkNotNull((Object)inputStream);
        Closeable closeable = inputStream;
        Throwable throwable = null;
        try {
            InputStream it = (InputStream)closeable;
            boolean bl2 = false;
            map = (Map)JvmStreamsKt.decodeFromStream((Json)jsonFormat, (DeserializationStrategy)((DeserializationStrategy)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE)), (InputStream)it);
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
        deprecatedRuleCategoryMap = map;
        int it = n = ExtSettings.INSTANCE.getHashVersion();
        boolean bl3 = false;
        if (!(1 <= it ? it < 3 : false)) {
            throw new IllegalStateException(("Bad hash version: " + it).toString());
        }
        hashVersion = n;
    }
}

