/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ChapterFlat
 *  cn.sast.api.config.CheckerInfo
 *  cn.sast.api.config.CheckerInfo$$serializer
 *  cn.sast.api.config.CheckerInfo$Companion
 *  cn.sast.api.config.Tag
 *  cn.sast.api.config.Tag$$serializer
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.EncodeDefault
 *  kotlinx.serialization.EncodeDefault$Mode
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.BooleanSerializer
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.config;

import cn.sast.api.config.ChapterFlat;
import cn.sast.api.config.CheckerInfo;
import cn.sast.api.config.CheckerInfo$;
import cn.sast.api.config.Tag;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.EncodeDefault;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 a2\u00020\u0001:\u0002`aB\u00dd\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u00fb\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\u0019\u0010\u001fJ\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0003J\u0015\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0003J\u0015\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0003J\u0015\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u00c6\u0003J\u000f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u00c6\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0018H\u00c6\u0003\u00a2\u0006\u0002\u0010;J\u00fa\u0001\u0010R\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u00c6\u0001\u00a2\u0006\u0002\u0010SJ\u0013\u0010T\u001a\u00020\u00182\b\u0010U\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010V\u001a\u00020\u001cH\u00d6\u0001J\t\u0010W\u001a\u00020\u0003H\u00d6\u0001J%\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u00002\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^H\u0001\u00a2\u0006\u0002\b_R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b.\u0010/\u001a\u0004\b0\u0010!R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b1\u0010/\u001a\u0004\b2\u0010!R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b3\u0010/\u001a\u0004\b4\u0010!R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b5\u0010/\u001a\u0004\b6\u0010!R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b7\u0010/\u001a\u0004\b8\u0010!R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004\u00a2\u0006\u0010\n\u0002\u0010<\u0012\u0004\b9\u0010/\u001a\u0004\b:\u0010;R\u0013\u0010=\u001a\u0004\u0018\u00010>8F\u00a2\u0006\u0006\u001a\u0004\b?\u0010@\u00a8\u0006b"}, d2={"Lcn/sast/api/config/CheckerInfo;", "", "type", "", "format_version", "analyzer", "language", "checker_id", "severity", "category", "", "name", "abstract", "description", "", "tags", "", "Lcn/sast/api/config/Tag;", "impact", "likelihood", "precision", "reCall", "impl", "implemented", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType", "()Ljava/lang/String;", "getFormat_version", "getAnalyzer", "getLanguage", "getChecker_id", "getSeverity", "getCategory", "()Ljava/util/Map;", "getName", "getAbstract", "getDescription", "getTags", "()Ljava/util/List;", "getImpact$annotations", "()V", "getImpact", "getLikelihood$annotations", "getLikelihood", "getPrecision$annotations", "getPrecision", "getReCall$annotations", "getReCall", "getImpl$annotations", "getImpl", "getImplemented$annotations", "getImplemented", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "chapterFlat", "Lcn/sast/api/config/ChapterFlat;", "getChapterFlat", "()Lcn/sast/api/config/ChapterFlat;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcn/sast/api/config/CheckerInfo;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_api", "$serializer", "Companion", "corax-api"})
@SourceDebugExtension(value={"SMAP\nCheckerInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckerInfo.kt\ncn/sast/api/config/CheckerInfo\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1#2:50\n*E\n"})
public final class CheckerInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String type;
    @NotNull
    private final String format_version;
    @NotNull
    private final String analyzer;
    @NotNull
    private final String language;
    @NotNull
    private final String checker_id;
    @NotNull
    private final String severity;
    @NotNull
    private final Map<String, String> category;
    @NotNull
    private final Map<String, String> name;
    @NotNull
    private final Map<String, String> abstract;
    @NotNull
    private final Map<String, String> description;
    @NotNull
    private final List<Tag> tags;
    @Nullable
    private final String impact;
    @Nullable
    private final String likelihood;
    @Nullable
    private final String precision;
    @Nullable
    private final String reCall;
    @Nullable
    private final String impl;
    @Nullable
    private final Boolean implemented;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public CheckerInfo(@NotNull String type, @NotNull String format_version, @NotNull String analyzer2, @NotNull String language, @NotNull String checker_id, @NotNull String severity, @NotNull Map<String, String> category, @NotNull Map<String, String> name, @NotNull Map<String, String> map, @NotNull Map<String, String> description, @NotNull List<Tag> tags, @Nullable String impact, @Nullable String likelihood, @Nullable String precision, @Nullable String reCall, @Nullable String impl, @Nullable Boolean implemented) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)format_version, (String)"format_version");
        Intrinsics.checkNotNullParameter((Object)analyzer2, (String)"analyzer");
        Intrinsics.checkNotNullParameter((Object)language, (String)"language");
        Intrinsics.checkNotNullParameter((Object)checker_id, (String)"checker_id");
        Intrinsics.checkNotNullParameter((Object)severity, (String)"severity");
        Intrinsics.checkNotNullParameter(category, (String)"category");
        Intrinsics.checkNotNullParameter(name, (String)"name");
        Intrinsics.checkNotNullParameter(map, (String)"abstract");
        Intrinsics.checkNotNullParameter(description, (String)"description");
        Intrinsics.checkNotNullParameter(tags, (String)"tags");
        this.type = type;
        this.format_version = format_version;
        this.analyzer = analyzer2;
        this.language = language;
        this.checker_id = checker_id;
        this.severity = severity;
        this.category = category;
        this.name = name;
        this.abstract = map;
        this.description = description;
        this.tags = tags;
        this.impact = impact;
        this.likelihood = likelihood;
        this.precision = precision;
        this.reCall = reCall;
        this.impl = impl;
        this.implemented = implemented;
    }

    public /* synthetic */ CheckerInfo(String string, String string2, String string3, String string4, String string5, String string6, Map map, Map map2, Map map3, Map map4, List list, String string7, String string8, String string9, String string10, String string11, Boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x800) != 0) {
            string7 = null;
        }
        if ((n & 0x1000) != 0) {
            string8 = null;
        }
        if ((n & 0x2000) != 0) {
            string9 = null;
        }
        if ((n & 0x4000) != 0) {
            string10 = null;
        }
        if ((n & 0x8000) != 0) {
            string11 = null;
        }
        if ((n & 0x10000) != 0) {
            bl = null;
        }
        this(string, string2, string3, string4, string5, string6, map, map2, map3, map4, list, string7, string8, string9, string10, string11, bl);
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getFormat_version() {
        return this.format_version;
    }

    @NotNull
    public final String getAnalyzer() {
        return this.analyzer;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    public final String getChecker_id() {
        return this.checker_id;
    }

    @NotNull
    public final String getSeverity() {
        return this.severity;
    }

    @NotNull
    public final Map<String, String> getCategory() {
        return this.category;
    }

    @NotNull
    public final Map<String, String> getName() {
        return this.name;
    }

    @NotNull
    public final Map<String, String> getAbstract() {
        return this.abstract;
    }

    @NotNull
    public final Map<String, String> getDescription() {
        return this.description;
    }

    @NotNull
    public final List<Tag> getTags() {
        return this.tags;
    }

    @Nullable
    public final String getImpact() {
        return this.impact;
    }

    @EncodeDefault(mode=EncodeDefault.Mode.ALWAYS)
    public static /* synthetic */ void getImpact$annotations() {
    }

    @Nullable
    public final String getLikelihood() {
        return this.likelihood;
    }

    @EncodeDefault(mode=EncodeDefault.Mode.ALWAYS)
    public static /* synthetic */ void getLikelihood$annotations() {
    }

    @Nullable
    public final String getPrecision() {
        return this.precision;
    }

    @EncodeDefault(mode=EncodeDefault.Mode.ALWAYS)
    public static /* synthetic */ void getPrecision$annotations() {
    }

    @Nullable
    public final String getReCall() {
        return this.reCall;
    }

    @EncodeDefault(mode=EncodeDefault.Mode.ALWAYS)
    public static /* synthetic */ void getReCall$annotations() {
    }

    @Nullable
    public final String getImpl() {
        return this.impl;
    }

    @EncodeDefault(mode=EncodeDefault.Mode.ALWAYS)
    public static /* synthetic */ void getImpl$annotations() {
    }

    @Nullable
    public final Boolean getImplemented() {
        return this.implemented;
    }

    @EncodeDefault(mode=EncodeDefault.Mode.ALWAYS)
    public static /* synthetic */ void getImplemented$annotations() {
    }

    @Nullable
    public final ChapterFlat getChapterFlat() {
        ChapterFlat chapterFlat;
        String string = (String)this.category.get("zh-CN");
        if (string != null) {
            String it = string;
            boolean bl = false;
            chapterFlat = new ChapterFlat(it, this.severity, this.checker_id);
        } else {
            chapterFlat = null;
        }
        return chapterFlat;
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.format_version;
    }

    @NotNull
    public final String component3() {
        return this.analyzer;
    }

    @NotNull
    public final String component4() {
        return this.language;
    }

    @NotNull
    public final String component5() {
        return this.checker_id;
    }

    @NotNull
    public final String component6() {
        return this.severity;
    }

    @NotNull
    public final Map<String, String> component7() {
        return this.category;
    }

    @NotNull
    public final Map<String, String> component8() {
        return this.name;
    }

    @NotNull
    public final Map<String, String> component9() {
        return this.abstract;
    }

    @NotNull
    public final Map<String, String> component10() {
        return this.description;
    }

    @NotNull
    public final List<Tag> component11() {
        return this.tags;
    }

    @Nullable
    public final String component12() {
        return this.impact;
    }

    @Nullable
    public final String component13() {
        return this.likelihood;
    }

    @Nullable
    public final String component14() {
        return this.precision;
    }

    @Nullable
    public final String component15() {
        return this.reCall;
    }

    @Nullable
    public final String component16() {
        return this.impl;
    }

    @Nullable
    public final Boolean component17() {
        return this.implemented;
    }

    @NotNull
    public final CheckerInfo copy(@NotNull String type, @NotNull String format_version, @NotNull String analyzer2, @NotNull String language, @NotNull String checker_id, @NotNull String severity, @NotNull Map<String, String> category, @NotNull Map<String, String> name, @NotNull Map<String, String> map, @NotNull Map<String, String> description, @NotNull List<Tag> tags, @Nullable String impact, @Nullable String likelihood, @Nullable String precision, @Nullable String reCall, @Nullable String impl, @Nullable Boolean implemented) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)format_version, (String)"format_version");
        Intrinsics.checkNotNullParameter((Object)analyzer2, (String)"analyzer");
        Intrinsics.checkNotNullParameter((Object)language, (String)"language");
        Intrinsics.checkNotNullParameter((Object)checker_id, (String)"checker_id");
        Intrinsics.checkNotNullParameter((Object)severity, (String)"severity");
        Intrinsics.checkNotNullParameter(category, (String)"category");
        Intrinsics.checkNotNullParameter(name, (String)"name");
        Intrinsics.checkNotNullParameter(map, (String)"abstract");
        Intrinsics.checkNotNullParameter(description, (String)"description");
        Intrinsics.checkNotNullParameter(tags, (String)"tags");
        return new CheckerInfo(type, format_version, analyzer2, language, checker_id, severity, category, name, map, description, tags, impact, likelihood, precision, reCall, impl, implemented);
    }

    public static /* synthetic */ CheckerInfo copy$default(CheckerInfo checkerInfo, String string, String string2, String string3, String string4, String string5, String string6, Map map, Map map2, Map map3, Map map4, List list, String string7, String string8, String string9, String string10, String string11, Boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            string = checkerInfo.type;
        }
        if ((n & 2) != 0) {
            string2 = checkerInfo.format_version;
        }
        if ((n & 4) != 0) {
            string3 = checkerInfo.analyzer;
        }
        if ((n & 8) != 0) {
            string4 = checkerInfo.language;
        }
        if ((n & 0x10) != 0) {
            string5 = checkerInfo.checker_id;
        }
        if ((n & 0x20) != 0) {
            string6 = checkerInfo.severity;
        }
        if ((n & 0x40) != 0) {
            map = checkerInfo.category;
        }
        if ((n & 0x80) != 0) {
            map2 = checkerInfo.name;
        }
        if ((n & 0x100) != 0) {
            map3 = checkerInfo.abstract;
        }
        if ((n & 0x200) != 0) {
            map4 = checkerInfo.description;
        }
        if ((n & 0x400) != 0) {
            list = checkerInfo.tags;
        }
        if ((n & 0x800) != 0) {
            string7 = checkerInfo.impact;
        }
        if ((n & 0x1000) != 0) {
            string8 = checkerInfo.likelihood;
        }
        if ((n & 0x2000) != 0) {
            string9 = checkerInfo.precision;
        }
        if ((n & 0x4000) != 0) {
            string10 = checkerInfo.reCall;
        }
        if ((n & 0x8000) != 0) {
            string11 = checkerInfo.impl;
        }
        if ((n & 0x10000) != 0) {
            bl = checkerInfo.implemented;
        }
        return checkerInfo.copy(string, string2, string3, string4, string5, string6, map, map2, map3, map4, list, string7, string8, string9, string10, string11, bl);
    }

    @NotNull
    public String toString() {
        return "CheckerInfo(type=" + this.type + ", format_version=" + this.format_version + ", analyzer=" + this.analyzer + ", language=" + this.language + ", checker_id=" + this.checker_id + ", severity=" + this.severity + ", category=" + this.category + ", name=" + this.name + ", abstract=" + this.abstract + ", description=" + this.description + ", tags=" + this.tags + ", impact=" + this.impact + ", likelihood=" + this.likelihood + ", precision=" + this.precision + ", reCall=" + this.reCall + ", impl=" + this.impl + ", implemented=" + this.implemented + ")";
    }

    public int hashCode() {
        int result = this.type.hashCode();
        result = result * 31 + this.format_version.hashCode();
        result = result * 31 + this.analyzer.hashCode();
        result = result * 31 + this.language.hashCode();
        result = result * 31 + this.checker_id.hashCode();
        result = result * 31 + this.severity.hashCode();
        result = result * 31 + ((Object)this.category).hashCode();
        result = result * 31 + ((Object)this.name).hashCode();
        result = result * 31 + ((Object)this.abstract).hashCode();
        result = result * 31 + ((Object)this.description).hashCode();
        result = result * 31 + ((Object)this.tags).hashCode();
        result = result * 31 + (this.impact == null ? 0 : this.impact.hashCode());
        result = result * 31 + (this.likelihood == null ? 0 : this.likelihood.hashCode());
        result = result * 31 + (this.precision == null ? 0 : this.precision.hashCode());
        result = result * 31 + (this.reCall == null ? 0 : this.reCall.hashCode());
        result = result * 31 + (this.impl == null ? 0 : this.impl.hashCode());
        result = result * 31 + (this.implemented == null ? 0 : ((Object)this.implemented).hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckerInfo)) {
            return false;
        }
        CheckerInfo checkerInfo = (CheckerInfo)other;
        if (!Intrinsics.areEqual((Object)this.type, (Object)checkerInfo.type)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.format_version, (Object)checkerInfo.format_version)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.analyzer, (Object)checkerInfo.analyzer)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.language, (Object)checkerInfo.language)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.checker_id, (Object)checkerInfo.checker_id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.severity, (Object)checkerInfo.severity)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.category, (Object)checkerInfo.category)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.name, (Object)checkerInfo.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.abstract, (Object)checkerInfo.abstract)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.description, (Object)checkerInfo.description)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.tags, (Object)checkerInfo.tags)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.impact, (Object)checkerInfo.impact)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.likelihood, (Object)checkerInfo.likelihood)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.precision, (Object)checkerInfo.precision)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.reCall, (Object)checkerInfo.reCall)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.impl, (Object)checkerInfo.impl)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.implemented, (Object)checkerInfo.implemented);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_api(CheckerInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.type);
        output.encodeStringElement(serialDesc, 1, self.format_version);
        output.encodeStringElement(serialDesc, 2, self.analyzer);
        output.encodeStringElement(serialDesc, 3, self.language);
        output.encodeStringElement(serialDesc, 4, self.checker_id);
        output.encodeStringElement(serialDesc, 5, self.severity);
        output.encodeSerializableElement(serialDesc, 6, (SerializationStrategy)kSerializerArray[6], (Object)self.category);
        output.encodeSerializableElement(serialDesc, 7, (SerializationStrategy)kSerializerArray[7], (Object)self.name);
        output.encodeSerializableElement(serialDesc, 8, (SerializationStrategy)kSerializerArray[8], (Object)self.abstract);
        output.encodeSerializableElement(serialDesc, 9, (SerializationStrategy)kSerializerArray[9], (Object)self.description);
        output.encodeSerializableElement(serialDesc, 10, (SerializationStrategy)kSerializerArray[10], (Object)self.tags);
        output.encodeNullableSerializableElement(serialDesc, 11, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.impact);
        output.encodeNullableSerializableElement(serialDesc, 12, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.likelihood);
        output.encodeNullableSerializableElement(serialDesc, 13, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.precision);
        output.encodeNullableSerializableElement(serialDesc, 14, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.reCall);
        output.encodeNullableSerializableElement(serialDesc, 15, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.impl);
        output.encodeNullableSerializableElement(serialDesc, 16, (SerializationStrategy)BooleanSerializer.INSTANCE, (Object)self.implemented);
    }

    public /* synthetic */ CheckerInfo(int seen0, String type, String format_version, String analyzer2, String language, String checker_id, String severity, Map category, Map name, Map map, Map description, List tags, String impact, String likelihood, String precision, String reCall, String impl, Boolean implemented, SerializationConstructorMarker serializationConstructorMarker) {
        if (2047 != (0x7FF & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)2047, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.type = type;
        this.format_version = format_version;
        this.analyzer = analyzer2;
        this.language = language;
        this.checker_id = checker_id;
        this.severity = severity;
        this.category = category;
        this.name = name;
        this.abstract = map;
        this.description = description;
        this.tags = tags;
        this.impact = (seen0 & 0x800) == 0 ? null : impact;
        this.likelihood = (seen0 & 0x1000) == 0 ? null : likelihood;
        this.precision = (seen0 & 0x2000) == 0 ? null : precision;
        this.reCall = (seen0 & 0x4000) == 0 ? null : reCall;
        this.impl = (seen0 & 0x8000) == 0 ? null : impl;
        this.implemented = (seen0 & 0x10000) == 0 ? null : implemented;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{null, null, null, null, null, null, new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE), new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE), new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE), new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE), new ArrayListSerializer((KSerializer)Tag.$serializer.INSTANCE), null, null, null, null, null, null};
        $childSerializers = kSerializerArray;
    }
}

