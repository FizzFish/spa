/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.ProjectMetrics
 *  cn.sast.api.report.ProjectMetrics$$serializer
 *  cn.sast.api.report.ProjectMetrics$Companion
 *  cn.sast.common.OS
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerialName
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.Transient
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.report;

import cn.sast.api.report.ProjectMetrics;
import cn.sast.api.report.ProjectMetrics$;
import cn.sast.common.OS;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010#\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u0087\u00012\u00020\u0001:\u0004\u0086\u0001\u0087\u0001B\u0085\u0002\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\b\u00a2\u0006\u0004\b \u0010!B\u00eb\u0001\b\u0010\u0012\u0006\u0010\"\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\u0006\u0010\u001e\u001a\u00020\u000f\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\b\u0010#\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b \u0010%J\u0006\u0010_\u001a\u00020`J\u0011\u0010a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u00c6\u0003J\t\u0010c\u001a\u00020\bH\u00c6\u0003J\t\u0010d\u001a\u00020\bH\u00c6\u0003J\t\u0010e\u001a\u00020\bH\u00c6\u0003J\t\u0010f\u001a\u00020\bH\u00c6\u0003J\t\u0010g\u001a\u00020\bH\u00c6\u0003J\t\u0010h\u001a\u00020\bH\u00c6\u0003J\t\u0010i\u001a\u00020\u000fH\u00c2\u0003J\t\u0010j\u001a\u00020\bH\u00c6\u0003J\t\u0010k\u001a\u00020\u000fH\u00c2\u0003J\t\u0010l\u001a\u00020\bH\u00c6\u0003J\t\u0010m\u001a\u00020\bH\u00c6\u0003J\t\u0010n\u001a\u00020\bH\u00c6\u0003J\t\u0010o\u001a\u00020\u0016H\u00c6\u0003J\t\u0010p\u001a\u00020\u0016H\u00c6\u0003J\t\u0010q\u001a\u00020\u0016H\u00c6\u0003J\t\u0010r\u001a\u00020\bH\u00c2\u0003J\t\u0010s\u001a\u00020\bH\u00c2\u0003J\t\u0010t\u001a\u00020\bH\u00c2\u0003J\t\u0010u\u001a\u00020\u000fH\u00c2\u0003J\t\u0010v\u001a\u00020\bH\u00c2\u0003J\t\u0010w\u001a\u00020\u000fH\u00c2\u0003J\t\u0010x\u001a\u00020\bH\u00c6\u0003J\u0087\u0002\u0010y\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\bH\u00c6\u0001J\u0013\u0010z\u001a\u00020{2\b\u0010|\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010}\u001a\u00020\bH\u00d6\u0001J\t\u0010~\u001a\u00020\u0004H\u00d6\u0001J+\u0010\u007f\u001a\u00020`2\u0007\u0010\u0080\u0001\u001a\u00020\u00002\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0001\u00a2\u0006\u0003\b\u0085\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R\u001a\u0010\f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010-\"\u0004\b7\u0010/R\u001a\u0010\r\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010-\"\u0004\b9\u0010/R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010-\"\u0004\b=\u0010/R\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010-\"\u0004\b?\u0010/R\u001a\u0010\u0014\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010-\"\u0004\bA\u0010/R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010\u0017\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010C\"\u0004\bG\u0010ER\u001a\u0010\u0018\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010C\"\u0004\bI\u0010ER\u0018\u0010\u0019\u001a\u00020\b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\bJ\u0010KR\u0018\u0010\u001a\u001a\u00020\b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\bL\u0010KR\u0018\u0010\u001b\u001a\u00020\b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\bM\u0010KR\u000e\u0010\u001c\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\bN\u0010KR\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010-\"\u0004\bP\u0010/R\"\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00040R8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\bS\u0010K\u001a\u0004\bT\u0010UR\"\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00040R8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\bW\u0010K\u001a\u0004\bX\u0010UR\"\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00040R8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\bZ\u0010K\u001a\u0004\b[\u0010UR\"\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00040R8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b]\u0010K\u001a\u0004\b^\u0010U\u00a8\u0006\u0088\u0001"}, d2={"Lcn/sast/api/report/ProjectMetrics;", "", "command", "", "", "paths", "", "applicationClasses", "", "libraryClasses", "phantomClasses", "applicationMethods", "libraryMethods", "applicationMethodsHaveBody", "applicationMethodsHaveBodyRatio", "", "libraryMethodsHaveBody", "libraryMethodsHaveBodyRatio", "analyzedFiles", "appJavaFileCount", "appJavaLineCount", "totalFileNum", "", "totalAnySourceFileNum", "totalSourceFileNum", "_analyzedClasses", "_analyzedMethodEntries", "_analyzedApplicationMethods", "analyzedApplicationMethodsRatio", "_analyzedLibraryMethods", "analyzedLibraryMethodsRatio", "serializedReports", "<init>", "(Ljava/util/List;Ljava/util/List;IIIIIIFIFIIIJJJIIIFIFI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;IIIIIIFIFIIIJJJIIIFIFILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCommand", "()Ljava/util/List;", "setCommand", "(Ljava/util/List;)V", "getPaths", "setPaths", "getApplicationClasses", "()I", "setApplicationClasses", "(I)V", "getLibraryClasses", "setLibraryClasses", "getPhantomClasses", "setPhantomClasses", "getApplicationMethods", "setApplicationMethods", "getLibraryMethods", "setLibraryMethods", "getApplicationMethodsHaveBody", "setApplicationMethodsHaveBody", "getLibraryMethodsHaveBody", "setLibraryMethodsHaveBody", "getAnalyzedFiles", "setAnalyzedFiles", "getAppJavaFileCount", "setAppJavaFileCount", "getAppJavaLineCount", "setAppJavaLineCount", "getTotalFileNum", "()J", "setTotalFileNum", "(J)V", "getTotalAnySourceFileNum", "setTotalAnySourceFileNum", "getTotalSourceFileNum", "setTotalSourceFileNum", "get_analyzedClasses$annotations", "()V", "get_analyzedMethodEntries$annotations", "get_analyzedApplicationMethods$annotations", "get_analyzedLibraryMethods$annotations", "getSerializedReports", "setSerializedReports", "analyzedClasses", "", "getAnalyzedClasses$annotations", "getAnalyzedClasses", "()Ljava/util/Set;", "analyzedMethodEntries", "getAnalyzedMethodEntries$annotations", "getAnalyzedMethodEntries", "analyzedApplicationMethods", "getAnalyzedApplicationMethods$annotations", "getAnalyzedApplicationMethods", "analyzedLibraryMethods", "getAnalyzedLibraryMethods$annotations", "getAnalyzedLibraryMethods", "process", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_api", "$serializer", "Companion", "corax-api"})
public final class ProjectMetrics {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private List<String> command;
    @NotNull
    private List<String> paths;
    private int applicationClasses;
    private int libraryClasses;
    private int phantomClasses;
    private int applicationMethods;
    private int libraryMethods;
    private int applicationMethodsHaveBody;
    private float applicationMethodsHaveBodyRatio;
    private int libraryMethodsHaveBody;
    private float libraryMethodsHaveBodyRatio;
    private int analyzedFiles;
    private int appJavaFileCount;
    private int appJavaLineCount;
    private long totalFileNum;
    private long totalAnySourceFileNum;
    private long totalSourceFileNum;
    private int _analyzedClasses;
    private int _analyzedMethodEntries;
    private int _analyzedApplicationMethods;
    private float analyzedApplicationMethodsRatio;
    private int _analyzedLibraryMethods;
    private float analyzedLibraryMethodsRatio;
    private int serializedReports;
    @NotNull
    private final Set<String> analyzedClasses;
    @NotNull
    private final Set<String> analyzedMethodEntries;
    @NotNull
    private final Set<String> analyzedApplicationMethods;
    @NotNull
    private final Set<String> analyzedLibraryMethods;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public ProjectMetrics(@Nullable List<String> command, @NotNull List<String> paths, int applicationClasses, int libraryClasses, int phantomClasses, int applicationMethods, int libraryMethods, int applicationMethodsHaveBody, float applicationMethodsHaveBodyRatio, int libraryMethodsHaveBody, float libraryMethodsHaveBodyRatio, int analyzedFiles, int appJavaFileCount, int appJavaLineCount, long totalFileNum, long totalAnySourceFileNum, long totalSourceFileNum, int _analyzedClasses, int _analyzedMethodEntries, int _analyzedApplicationMethods, float analyzedApplicationMethodsRatio, int _analyzedLibraryMethods, float analyzedLibraryMethodsRatio, int serializedReports) {
        Intrinsics.checkNotNullParameter(paths, (String)"paths");
        this.command = command;
        this.paths = paths;
        this.applicationClasses = applicationClasses;
        this.libraryClasses = libraryClasses;
        this.phantomClasses = phantomClasses;
        this.applicationMethods = applicationMethods;
        this.libraryMethods = libraryMethods;
        this.applicationMethodsHaveBody = applicationMethodsHaveBody;
        this.applicationMethodsHaveBodyRatio = applicationMethodsHaveBodyRatio;
        this.libraryMethodsHaveBody = libraryMethodsHaveBody;
        this.libraryMethodsHaveBodyRatio = libraryMethodsHaveBodyRatio;
        this.analyzedFiles = analyzedFiles;
        this.appJavaFileCount = appJavaFileCount;
        this.appJavaLineCount = appJavaLineCount;
        this.totalFileNum = totalFileNum;
        this.totalAnySourceFileNum = totalAnySourceFileNum;
        this.totalSourceFileNum = totalSourceFileNum;
        this._analyzedClasses = _analyzedClasses;
        this._analyzedMethodEntries = _analyzedMethodEntries;
        this._analyzedApplicationMethods = _analyzedApplicationMethods;
        this.analyzedApplicationMethodsRatio = analyzedApplicationMethodsRatio;
        this._analyzedLibraryMethods = _analyzedLibraryMethods;
        this.analyzedLibraryMethodsRatio = analyzedLibraryMethodsRatio;
        this.serializedReports = serializedReports;
        Set set = Collections.synchronizedSet(new LinkedHashSet());
        Intrinsics.checkNotNullExpressionValue(set, (String)"synchronizedSet(...)");
        this.analyzedClasses = set;
        Set set2 = Collections.synchronizedSet(new LinkedHashSet());
        Intrinsics.checkNotNullExpressionValue(set2, (String)"synchronizedSet(...)");
        this.analyzedMethodEntries = set2;
        Set set3 = Collections.synchronizedSet(new LinkedHashSet());
        Intrinsics.checkNotNullExpressionValue(set3, (String)"synchronizedSet(...)");
        this.analyzedApplicationMethods = set3;
        Set set4 = Collections.synchronizedSet(new LinkedHashSet());
        Intrinsics.checkNotNullExpressionValue(set4, (String)"synchronizedSet(...)");
        this.analyzedLibraryMethods = set4;
    }

    public /* synthetic */ ProjectMetrics(List list, List list2, int n, int n2, int n3, int n4, int n5, int n6, float f, int n7, float f2, int n8, int n9, int n10, long l, long l2, long l3, int n11, int n12, int n13, float f3, int n14, float f4, int n15, int n16, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n16 & 1) != 0) {
            list = OS.getCommandLine$default((OS)OS.INSTANCE, null, (boolean)false, (int)3, null);
        }
        if ((n16 & 2) != 0) {
            list2 = new ArrayList();
        }
        if ((n16 & 4) != 0) {
            n = -1;
        }
        if ((n16 & 8) != 0) {
            n2 = -1;
        }
        if ((n16 & 0x10) != 0) {
            n3 = -1;
        }
        if ((n16 & 0x20) != 0) {
            n4 = -1;
        }
        if ((n16 & 0x40) != 0) {
            n5 = -1;
        }
        if ((n16 & 0x80) != 0) {
            n6 = -1;
        }
        if ((n16 & 0x100) != 0) {
            f = -1.0f;
        }
        if ((n16 & 0x200) != 0) {
            n7 = -1;
        }
        if ((n16 & 0x400) != 0) {
            f2 = -1.0f;
        }
        if ((n16 & 0x800) != 0) {
            n8 = -1;
        }
        if ((n16 & 0x1000) != 0) {
            n9 = -1;
        }
        if ((n16 & 0x2000) != 0) {
            n10 = -1;
        }
        if ((n16 & 0x4000) != 0) {
            l = -1L;
        }
        if ((n16 & 0x8000) != 0) {
            l2 = -1L;
        }
        if ((n16 & 0x10000) != 0) {
            l3 = -1L;
        }
        if ((n16 & 0x20000) != 0) {
            n11 = -1;
        }
        if ((n16 & 0x40000) != 0) {
            n12 = -1;
        }
        if ((n16 & 0x80000) != 0) {
            n13 = -1;
        }
        if ((n16 & 0x100000) != 0) {
            f3 = -1.0f;
        }
        if ((n16 & 0x200000) != 0) {
            n14 = -1;
        }
        if ((n16 & 0x400000) != 0) {
            f4 = -1.0f;
        }
        if ((n16 & 0x800000) != 0) {
            n15 = -1;
        }
        this(list, list2, n, n2, n3, n4, n5, n6, f, n7, f2, n8, n9, n10, l, l2, l3, n11, n12, n13, f3, n14, f4, n15);
    }

    @Nullable
    public final List<String> getCommand() {
        return this.command;
    }

    public final void setCommand(@Nullable List<String> list) {
        this.command = list;
    }

    @NotNull
    public final List<String> getPaths() {
        return this.paths;
    }

    public final void setPaths(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.paths = list;
    }

    public final int getApplicationClasses() {
        return this.applicationClasses;
    }

    public final void setApplicationClasses(int n) {
        this.applicationClasses = n;
    }

    public final int getLibraryClasses() {
        return this.libraryClasses;
    }

    public final void setLibraryClasses(int n) {
        this.libraryClasses = n;
    }

    public final int getPhantomClasses() {
        return this.phantomClasses;
    }

    public final void setPhantomClasses(int n) {
        this.phantomClasses = n;
    }

    public final int getApplicationMethods() {
        return this.applicationMethods;
    }

    public final void setApplicationMethods(int n) {
        this.applicationMethods = n;
    }

    public final int getLibraryMethods() {
        return this.libraryMethods;
    }

    public final void setLibraryMethods(int n) {
        this.libraryMethods = n;
    }

    public final int getApplicationMethodsHaveBody() {
        return this.applicationMethodsHaveBody;
    }

    public final void setApplicationMethodsHaveBody(int n) {
        this.applicationMethodsHaveBody = n;
    }

    public final int getLibraryMethodsHaveBody() {
        return this.libraryMethodsHaveBody;
    }

    public final void setLibraryMethodsHaveBody(int n) {
        this.libraryMethodsHaveBody = n;
    }

    public final int getAnalyzedFiles() {
        return this.analyzedFiles;
    }

    public final void setAnalyzedFiles(int n) {
        this.analyzedFiles = n;
    }

    public final int getAppJavaFileCount() {
        return this.appJavaFileCount;
    }

    public final void setAppJavaFileCount(int n) {
        this.appJavaFileCount = n;
    }

    public final int getAppJavaLineCount() {
        return this.appJavaLineCount;
    }

    public final void setAppJavaLineCount(int n) {
        this.appJavaLineCount = n;
    }

    public final long getTotalFileNum() {
        return this.totalFileNum;
    }

    public final void setTotalFileNum(long l) {
        this.totalFileNum = l;
    }

    public final long getTotalAnySourceFileNum() {
        return this.totalAnySourceFileNum;
    }

    public final void setTotalAnySourceFileNum(long l) {
        this.totalAnySourceFileNum = l;
    }

    public final long getTotalSourceFileNum() {
        return this.totalSourceFileNum;
    }

    public final void setTotalSourceFileNum(long l) {
        this.totalSourceFileNum = l;
    }

    @SerialName(value="analyzedClasses")
    private static /* synthetic */ void get_analyzedClasses$annotations() {
    }

    @SerialName(value="analyzedMethodEntries")
    private static /* synthetic */ void get_analyzedMethodEntries$annotations() {
    }

    @SerialName(value="analyzedApplicationMethods")
    private static /* synthetic */ void get_analyzedApplicationMethods$annotations() {
    }

    @SerialName(value="analyzedLibraryMethods")
    private static /* synthetic */ void get_analyzedLibraryMethods$annotations() {
    }

    public final int getSerializedReports() {
        return this.serializedReports;
    }

    public final void setSerializedReports(int n) {
        this.serializedReports = n;
    }

    @NotNull
    public final Set<String> getAnalyzedClasses() {
        return this.analyzedClasses;
    }

    @Transient
    public static /* synthetic */ void getAnalyzedClasses$annotations() {
    }

    @NotNull
    public final Set<String> getAnalyzedMethodEntries() {
        return this.analyzedMethodEntries;
    }

    @Transient
    public static /* synthetic */ void getAnalyzedMethodEntries$annotations() {
    }

    @NotNull
    public final Set<String> getAnalyzedApplicationMethods() {
        return this.analyzedApplicationMethods;
    }

    @Transient
    public static /* synthetic */ void getAnalyzedApplicationMethods$annotations() {
    }

    @NotNull
    public final Set<String> getAnalyzedLibraryMethods() {
        return this.analyzedLibraryMethods;
    }

    @Transient
    public static /* synthetic */ void getAnalyzedLibraryMethods$annotations() {
    }

    public final void process() {
        this._analyzedClasses = ((Collection)this.analyzedClasses).size();
        this._analyzedApplicationMethods = ((Collection)this.analyzedApplicationMethods).size();
        this._analyzedLibraryMethods = ((Collection)this.analyzedLibraryMethods).size();
        this._analyzedMethodEntries = ((Collection)this.analyzedMethodEntries).size();
        if (this.applicationMethods != 0) {
            this.applicationMethodsHaveBodyRatio = (float)this.applicationMethodsHaveBody / (float)this.applicationMethods;
            this.analyzedApplicationMethodsRatio = (float)this._analyzedApplicationMethods / (float)this.applicationMethods;
        }
        if (this.libraryMethods != 0) {
            this.libraryMethodsHaveBodyRatio = (float)this.libraryMethodsHaveBody / (float)this.libraryMethods;
            this.analyzedLibraryMethodsRatio = (float)this._analyzedLibraryMethods / (float)this.libraryMethods;
        }
    }

    @Nullable
    public final List<String> component1() {
        return this.command;
    }

    @NotNull
    public final List<String> component2() {
        return this.paths;
    }

    public final int component3() {
        return this.applicationClasses;
    }

    public final int component4() {
        return this.libraryClasses;
    }

    public final int component5() {
        return this.phantomClasses;
    }

    public final int component6() {
        return this.applicationMethods;
    }

    public final int component7() {
        return this.libraryMethods;
    }

    public final int component8() {
        return this.applicationMethodsHaveBody;
    }

    private final float component9() {
        return this.applicationMethodsHaveBodyRatio;
    }

    public final int component10() {
        return this.libraryMethodsHaveBody;
    }

    private final float component11() {
        return this.libraryMethodsHaveBodyRatio;
    }

    public final int component12() {
        return this.analyzedFiles;
    }

    public final int component13() {
        return this.appJavaFileCount;
    }

    public final int component14() {
        return this.appJavaLineCount;
    }

    public final long component15() {
        return this.totalFileNum;
    }

    public final long component16() {
        return this.totalAnySourceFileNum;
    }

    public final long component17() {
        return this.totalSourceFileNum;
    }

    private final int component18() {
        return this._analyzedClasses;
    }

    private final int component19() {
        return this._analyzedMethodEntries;
    }

    private final int component20() {
        return this._analyzedApplicationMethods;
    }

    private final float component21() {
        return this.analyzedApplicationMethodsRatio;
    }

    private final int component22() {
        return this._analyzedLibraryMethods;
    }

    private final float component23() {
        return this.analyzedLibraryMethodsRatio;
    }

    public final int component24() {
        return this.serializedReports;
    }

    @NotNull
    public final ProjectMetrics copy(@Nullable List<String> command, @NotNull List<String> paths, int applicationClasses, int libraryClasses, int phantomClasses, int applicationMethods, int libraryMethods, int applicationMethodsHaveBody, float applicationMethodsHaveBodyRatio, int libraryMethodsHaveBody, float libraryMethodsHaveBodyRatio, int analyzedFiles, int appJavaFileCount, int appJavaLineCount, long totalFileNum, long totalAnySourceFileNum, long totalSourceFileNum, int _analyzedClasses, int _analyzedMethodEntries, int _analyzedApplicationMethods, float analyzedApplicationMethodsRatio, int _analyzedLibraryMethods, float analyzedLibraryMethodsRatio, int serializedReports) {
        Intrinsics.checkNotNullParameter(paths, (String)"paths");
        return new ProjectMetrics(command, paths, applicationClasses, libraryClasses, phantomClasses, applicationMethods, libraryMethods, applicationMethodsHaveBody, applicationMethodsHaveBodyRatio, libraryMethodsHaveBody, libraryMethodsHaveBodyRatio, analyzedFiles, appJavaFileCount, appJavaLineCount, totalFileNum, totalAnySourceFileNum, totalSourceFileNum, _analyzedClasses, _analyzedMethodEntries, _analyzedApplicationMethods, analyzedApplicationMethodsRatio, _analyzedLibraryMethods, analyzedLibraryMethodsRatio, serializedReports);
    }

    public static /* synthetic */ ProjectMetrics copy$default(ProjectMetrics projectMetrics, List list, List list2, int n, int n2, int n3, int n4, int n5, int n6, float f, int n7, float f2, int n8, int n9, int n10, long l, long l2, long l3, int n11, int n12, int n13, float f3, int n14, float f4, int n15, int n16, Object object) {
        if ((n16 & 1) != 0) {
            list = projectMetrics.command;
        }
        if ((n16 & 2) != 0) {
            list2 = projectMetrics.paths;
        }
        if ((n16 & 4) != 0) {
            n = projectMetrics.applicationClasses;
        }
        if ((n16 & 8) != 0) {
            n2 = projectMetrics.libraryClasses;
        }
        if ((n16 & 0x10) != 0) {
            n3 = projectMetrics.phantomClasses;
        }
        if ((n16 & 0x20) != 0) {
            n4 = projectMetrics.applicationMethods;
        }
        if ((n16 & 0x40) != 0) {
            n5 = projectMetrics.libraryMethods;
        }
        if ((n16 & 0x80) != 0) {
            n6 = projectMetrics.applicationMethodsHaveBody;
        }
        if ((n16 & 0x100) != 0) {
            f = projectMetrics.applicationMethodsHaveBodyRatio;
        }
        if ((n16 & 0x200) != 0) {
            n7 = projectMetrics.libraryMethodsHaveBody;
        }
        if ((n16 & 0x400) != 0) {
            f2 = projectMetrics.libraryMethodsHaveBodyRatio;
        }
        if ((n16 & 0x800) != 0) {
            n8 = projectMetrics.analyzedFiles;
        }
        if ((n16 & 0x1000) != 0) {
            n9 = projectMetrics.appJavaFileCount;
        }
        if ((n16 & 0x2000) != 0) {
            n10 = projectMetrics.appJavaLineCount;
        }
        if ((n16 & 0x4000) != 0) {
            l = projectMetrics.totalFileNum;
        }
        if ((n16 & 0x8000) != 0) {
            l2 = projectMetrics.totalAnySourceFileNum;
        }
        if ((n16 & 0x10000) != 0) {
            l3 = projectMetrics.totalSourceFileNum;
        }
        if ((n16 & 0x20000) != 0) {
            n11 = projectMetrics._analyzedClasses;
        }
        if ((n16 & 0x40000) != 0) {
            n12 = projectMetrics._analyzedMethodEntries;
        }
        if ((n16 & 0x80000) != 0) {
            n13 = projectMetrics._analyzedApplicationMethods;
        }
        if ((n16 & 0x100000) != 0) {
            f3 = projectMetrics.analyzedApplicationMethodsRatio;
        }
        if ((n16 & 0x200000) != 0) {
            n14 = projectMetrics._analyzedLibraryMethods;
        }
        if ((n16 & 0x400000) != 0) {
            f4 = projectMetrics.analyzedLibraryMethodsRatio;
        }
        if ((n16 & 0x800000) != 0) {
            n15 = projectMetrics.serializedReports;
        }
        return projectMetrics.copy(list, list2, n, n2, n3, n4, n5, n6, f, n7, f2, n8, n9, n10, l, l2, l3, n11, n12, n13, f3, n14, f4, n15);
    }

    @NotNull
    public String toString() {
        return "ProjectMetrics(command=" + this.command + ", paths=" + this.paths + ", applicationClasses=" + this.applicationClasses + ", libraryClasses=" + this.libraryClasses + ", phantomClasses=" + this.phantomClasses + ", applicationMethods=" + this.applicationMethods + ", libraryMethods=" + this.libraryMethods + ", applicationMethodsHaveBody=" + this.applicationMethodsHaveBody + ", applicationMethodsHaveBodyRatio=" + this.applicationMethodsHaveBodyRatio + ", libraryMethodsHaveBody=" + this.libraryMethodsHaveBody + ", libraryMethodsHaveBodyRatio=" + this.libraryMethodsHaveBodyRatio + ", analyzedFiles=" + this.analyzedFiles + ", appJavaFileCount=" + this.appJavaFileCount + ", appJavaLineCount=" + this.appJavaLineCount + ", totalFileNum=" + this.totalFileNum + ", totalAnySourceFileNum=" + this.totalAnySourceFileNum + ", totalSourceFileNum=" + this.totalSourceFileNum + ", _analyzedClasses=" + this._analyzedClasses + ", _analyzedMethodEntries=" + this._analyzedMethodEntries + ", _analyzedApplicationMethods=" + this._analyzedApplicationMethods + ", analyzedApplicationMethodsRatio=" + this.analyzedApplicationMethodsRatio + ", _analyzedLibraryMethods=" + this._analyzedLibraryMethods + ", analyzedLibraryMethodsRatio=" + this.analyzedLibraryMethodsRatio + ", serializedReports=" + this.serializedReports + ")";
    }

    public int hashCode() {
        int result = this.command == null ? 0 : ((Object)this.command).hashCode();
        result = result * 31 + ((Object)this.paths).hashCode();
        result = result * 31 + Integer.hashCode(this.applicationClasses);
        result = result * 31 + Integer.hashCode(this.libraryClasses);
        result = result * 31 + Integer.hashCode(this.phantomClasses);
        result = result * 31 + Integer.hashCode(this.applicationMethods);
        result = result * 31 + Integer.hashCode(this.libraryMethods);
        result = result * 31 + Integer.hashCode(this.applicationMethodsHaveBody);
        result = result * 31 + Float.hashCode(this.applicationMethodsHaveBodyRatio);
        result = result * 31 + Integer.hashCode(this.libraryMethodsHaveBody);
        result = result * 31 + Float.hashCode(this.libraryMethodsHaveBodyRatio);
        result = result * 31 + Integer.hashCode(this.analyzedFiles);
        result = result * 31 + Integer.hashCode(this.appJavaFileCount);
        result = result * 31 + Integer.hashCode(this.appJavaLineCount);
        result = result * 31 + Long.hashCode(this.totalFileNum);
        result = result * 31 + Long.hashCode(this.totalAnySourceFileNum);
        result = result * 31 + Long.hashCode(this.totalSourceFileNum);
        result = result * 31 + Integer.hashCode(this._analyzedClasses);
        result = result * 31 + Integer.hashCode(this._analyzedMethodEntries);
        result = result * 31 + Integer.hashCode(this._analyzedApplicationMethods);
        result = result * 31 + Float.hashCode(this.analyzedApplicationMethodsRatio);
        result = result * 31 + Integer.hashCode(this._analyzedLibraryMethods);
        result = result * 31 + Float.hashCode(this.analyzedLibraryMethodsRatio);
        result = result * 31 + Integer.hashCode(this.serializedReports);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProjectMetrics)) {
            return false;
        }
        ProjectMetrics projectMetrics = (ProjectMetrics)other;
        if (!Intrinsics.areEqual((Object)this.command, (Object)projectMetrics.command)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.paths, (Object)projectMetrics.paths)) {
            return false;
        }
        if (this.applicationClasses != projectMetrics.applicationClasses) {
            return false;
        }
        if (this.libraryClasses != projectMetrics.libraryClasses) {
            return false;
        }
        if (this.phantomClasses != projectMetrics.phantomClasses) {
            return false;
        }
        if (this.applicationMethods != projectMetrics.applicationMethods) {
            return false;
        }
        if (this.libraryMethods != projectMetrics.libraryMethods) {
            return false;
        }
        if (this.applicationMethodsHaveBody != projectMetrics.applicationMethodsHaveBody) {
            return false;
        }
        if (Float.compare(this.applicationMethodsHaveBodyRatio, projectMetrics.applicationMethodsHaveBodyRatio) != 0) {
            return false;
        }
        if (this.libraryMethodsHaveBody != projectMetrics.libraryMethodsHaveBody) {
            return false;
        }
        if (Float.compare(this.libraryMethodsHaveBodyRatio, projectMetrics.libraryMethodsHaveBodyRatio) != 0) {
            return false;
        }
        if (this.analyzedFiles != projectMetrics.analyzedFiles) {
            return false;
        }
        if (this.appJavaFileCount != projectMetrics.appJavaFileCount) {
            return false;
        }
        if (this.appJavaLineCount != projectMetrics.appJavaLineCount) {
            return false;
        }
        if (this.totalFileNum != projectMetrics.totalFileNum) {
            return false;
        }
        if (this.totalAnySourceFileNum != projectMetrics.totalAnySourceFileNum) {
            return false;
        }
        if (this.totalSourceFileNum != projectMetrics.totalSourceFileNum) {
            return false;
        }
        if (this._analyzedClasses != projectMetrics._analyzedClasses) {
            return false;
        }
        if (this._analyzedMethodEntries != projectMetrics._analyzedMethodEntries) {
            return false;
        }
        if (this._analyzedApplicationMethods != projectMetrics._analyzedApplicationMethods) {
            return false;
        }
        if (Float.compare(this.analyzedApplicationMethodsRatio, projectMetrics.analyzedApplicationMethodsRatio) != 0) {
            return false;
        }
        if (this._analyzedLibraryMethods != projectMetrics._analyzedLibraryMethods) {
            return false;
        }
        if (Float.compare(this.analyzedLibraryMethodsRatio, projectMetrics.analyzedLibraryMethodsRatio) != 0) {
            return false;
        }
        return this.serializedReports == projectMetrics.serializedReports;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_api(ProjectMetrics self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArray = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) ? true : !Intrinsics.areEqual((Object)self.command, (Object)OS.getCommandLine$default((OS)OS.INSTANCE, null, (boolean)false, (int)3, null))) {
            output.encodeNullableSerializableElement(serialDesc, 0, (SerializationStrategy)kSerializerArray[0], (Object)self.command);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : !Intrinsics.areEqual((Object)self.paths, (Object)new ArrayList())) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)kSerializerArray[1], (Object)self.paths);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.applicationClasses != -1) {
            output.encodeIntElement(serialDesc, 2, self.applicationClasses);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.libraryClasses != -1) {
            output.encodeIntElement(serialDesc, 3, self.libraryClasses);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : self.phantomClasses != -1) {
            output.encodeIntElement(serialDesc, 4, self.phantomClasses);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) ? true : self.applicationMethods != -1) {
            output.encodeIntElement(serialDesc, 5, self.applicationMethods);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) ? true : self.libraryMethods != -1) {
            output.encodeIntElement(serialDesc, 6, self.libraryMethods);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) ? true : self.applicationMethodsHaveBody != -1) {
            output.encodeIntElement(serialDesc, 7, self.applicationMethodsHaveBody);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) ? true : Float.compare(self.applicationMethodsHaveBodyRatio, -1.0f) != 0) {
            output.encodeFloatElement(serialDesc, 8, self.applicationMethodsHaveBodyRatio);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) ? true : self.libraryMethodsHaveBody != -1) {
            output.encodeIntElement(serialDesc, 9, self.libraryMethodsHaveBody);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) ? true : Float.compare(self.libraryMethodsHaveBodyRatio, -1.0f) != 0) {
            output.encodeFloatElement(serialDesc, 10, self.libraryMethodsHaveBodyRatio);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) ? true : self.analyzedFiles != -1) {
            output.encodeIntElement(serialDesc, 11, self.analyzedFiles);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) ? true : self.appJavaFileCount != -1) {
            output.encodeIntElement(serialDesc, 12, self.appJavaFileCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) ? true : self.appJavaLineCount != -1) {
            output.encodeIntElement(serialDesc, 13, self.appJavaLineCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) ? true : self.totalFileNum != -1L) {
            output.encodeLongElement(serialDesc, 14, self.totalFileNum);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) ? true : self.totalAnySourceFileNum != -1L) {
            output.encodeLongElement(serialDesc, 15, self.totalAnySourceFileNum);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) ? true : self.totalSourceFileNum != -1L) {
            output.encodeLongElement(serialDesc, 16, self.totalSourceFileNum);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) ? true : self._analyzedClasses != -1) {
            output.encodeIntElement(serialDesc, 17, self._analyzedClasses);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) ? true : self._analyzedMethodEntries != -1) {
            output.encodeIntElement(serialDesc, 18, self._analyzedMethodEntries);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) ? true : self._analyzedApplicationMethods != -1) {
            output.encodeIntElement(serialDesc, 19, self._analyzedApplicationMethods);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) ? true : Float.compare(self.analyzedApplicationMethodsRatio, -1.0f) != 0) {
            output.encodeFloatElement(serialDesc, 20, self.analyzedApplicationMethodsRatio);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) ? true : self._analyzedLibraryMethods != -1) {
            output.encodeIntElement(serialDesc, 21, self._analyzedLibraryMethods);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) ? true : Float.compare(self.analyzedLibraryMethodsRatio, -1.0f) != 0) {
            output.encodeFloatElement(serialDesc, 22, self.analyzedLibraryMethodsRatio);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 23) ? true : self.serializedReports != -1) {
            output.encodeIntElement(serialDesc, 23, self.serializedReports);
        }
    }

    public /* synthetic */ ProjectMetrics(int seen0, List command, List paths, int applicationClasses, int libraryClasses, int phantomClasses, int applicationMethods, int libraryMethods, int applicationMethodsHaveBody, float applicationMethodsHaveBodyRatio, int libraryMethodsHaveBody, float libraryMethodsHaveBodyRatio, int analyzedFiles, int appJavaFileCount, int appJavaLineCount, long totalFileNum, long totalAnySourceFileNum, long totalSourceFileNum, int _analyzedClasses, int _analyzedMethodEntries, int _analyzedApplicationMethods, float analyzedApplicationMethodsRatio, int _analyzedLibraryMethods, float analyzedLibraryMethodsRatio, int serializedReports, SerializationConstructorMarker serializationConstructorMarker) {
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)0, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.command = (seen0 & 1) == 0 ? OS.getCommandLine$default((OS)OS.INSTANCE, null, (boolean)false, (int)3, null) : command;
        this.paths = (seen0 & 2) == 0 ? (List)new ArrayList() : paths;
        this.applicationClasses = (seen0 & 4) == 0 ? -1 : applicationClasses;
        this.libraryClasses = (seen0 & 8) == 0 ? -1 : libraryClasses;
        this.phantomClasses = (seen0 & 0x10) == 0 ? -1 : phantomClasses;
        this.applicationMethods = (seen0 & 0x20) == 0 ? -1 : applicationMethods;
        this.libraryMethods = (seen0 & 0x40) == 0 ? -1 : libraryMethods;
        this.applicationMethodsHaveBody = (seen0 & 0x80) == 0 ? -1 : applicationMethodsHaveBody;
        this.applicationMethodsHaveBodyRatio = (seen0 & 0x100) == 0 ? -1.0f : applicationMethodsHaveBodyRatio;
        this.libraryMethodsHaveBody = (seen0 & 0x200) == 0 ? -1 : libraryMethodsHaveBody;
        this.libraryMethodsHaveBodyRatio = (seen0 & 0x400) == 0 ? -1.0f : libraryMethodsHaveBodyRatio;
        this.analyzedFiles = (seen0 & 0x800) == 0 ? -1 : analyzedFiles;
        this.appJavaFileCount = (seen0 & 0x1000) == 0 ? -1 : appJavaFileCount;
        this.appJavaLineCount = (seen0 & 0x2000) == 0 ? -1 : appJavaLineCount;
        this.totalFileNum = (seen0 & 0x4000) == 0 ? -1L : totalFileNum;
        this.totalAnySourceFileNum = (seen0 & 0x8000) == 0 ? -1L : totalAnySourceFileNum;
        this.totalSourceFileNum = (seen0 & 0x10000) == 0 ? -1L : totalSourceFileNum;
        this._analyzedClasses = (seen0 & 0x20000) == 0 ? -1 : _analyzedClasses;
        this._analyzedMethodEntries = (seen0 & 0x40000) == 0 ? -1 : _analyzedMethodEntries;
        this._analyzedApplicationMethods = (seen0 & 0x80000) == 0 ? -1 : _analyzedApplicationMethods;
        this.analyzedApplicationMethodsRatio = (seen0 & 0x100000) == 0 ? -1.0f : analyzedApplicationMethodsRatio;
        this._analyzedLibraryMethods = (seen0 & 0x200000) == 0 ? -1 : _analyzedLibraryMethods;
        this.analyzedLibraryMethodsRatio = (seen0 & 0x400000) == 0 ? -1.0f : analyzedLibraryMethodsRatio;
        this.serializedReports = (seen0 & 0x800000) == 0 ? -1 : serializedReports;
        Set set = Collections.synchronizedSet(new LinkedHashSet());
        Intrinsics.checkNotNullExpressionValue(set, (String)"synchronizedSet(...)");
        this.analyzedClasses = set;
        Set set2 = Collections.synchronizedSet(new LinkedHashSet());
        Intrinsics.checkNotNullExpressionValue(set2, (String)"synchronizedSet(...)");
        this.analyzedMethodEntries = set2;
        Set set3 = Collections.synchronizedSet(new LinkedHashSet());
        Intrinsics.checkNotNullExpressionValue(set3, (String)"synchronizedSet(...)");
        this.analyzedApplicationMethods = set3;
        Set set4 = Collections.synchronizedSet(new LinkedHashSet());
        Intrinsics.checkNotNullExpressionValue(set4, (String)"synchronizedSet(...)");
        this.analyzedLibraryMethods = set4;
    }

    public ProjectMetrics() {
        this(null, null, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0.0f, 0, 0, 0, 0L, 0L, 0L, 0, 0, 0, 0.0f, 0, 0.0f, 0, 0xFFFFFF, null);
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
        $childSerializers = kSerializerArray;
    }
}

