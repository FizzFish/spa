/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.metadata.AnalysisMetadata
 *  cn.sast.framework.report.metadata.AnalysisMetadata$$serializer
 *  cn.sast.framework.report.metadata.AnalysisMetadata$Companion
 *  cn.sast.framework.report.metadata.Counter
 *  cn.sast.framework.report.metadata.Counter$$serializer
 *  cn.sast.framework.report.metadata.Tool
 *  cn.sast.framework.report.metadata.Tool$$serializer
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerialName
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JsonBuilder
 *  kotlinx.serialization.json.JsonKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.metadata;

import cn.sast.framework.report.metadata.AnalysisMetadata;
import cn.sast.framework.report.metadata.AnalysisMetadata$;
import cn.sast.framework.report.metadata.Counter;
import cn.sast.framework.report.metadata.Tool;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 <2\u00020\u0001:\u0002<=BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t\u00a2\u0006\u0004\b\u000e\u0010\u000fBg\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u000e\u0010\u0013J\u0006\u0010&\u001a\u00020\nJ\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0006H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\t\u0010,\u001a\u00020\nH\u00c6\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0\tH\u00c6\u0003J[\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tH\u00c6\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00102\u001a\u00020\u0003H\u00d6\u0001J\t\u00103\u001a\u00020\nH\u00d6\u0001J%\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0001\u00a2\u0006\u0002\b;R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010!R\u001c\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010$R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010!\u00a8\u0006>"}, d2={"Lcn/sast/framework/report/metadata/AnalysisMetadata;", "", "fileCount", "", "lineCount", "codeCoverage", "Lcn/sast/framework/report/metadata/Counter;", "numOfReportDir", "sourcePaths", "", "", "osName", "tools", "Lcn/sast/framework/report/metadata/Tool;", "<init>", "(IILcn/sast/framework/report/metadata/Counter;ILjava/util/List;Ljava/lang/String;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILcn/sast/framework/report/metadata/Counter;ILjava/util/List;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFileCount$annotations", "()V", "getFileCount", "()I", "getLineCount$annotations", "getLineCount", "getCodeCoverage$annotations", "getCodeCoverage", "()Lcn/sast/framework/report/metadata/Counter;", "getNumOfReportDir$annotations", "getNumOfReportDir", "getSourcePaths$annotations", "getSourcePaths", "()Ljava/util/List;", "getOsName$annotations", "getOsName", "()Ljava/lang/String;", "getTools", "toJson", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "Companion", "$serializer", "corax-framework"})
public final class AnalysisMetadata {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int fileCount;
    private final int lineCount;
    @NotNull
    private final Counter codeCoverage;
    private final int numOfReportDir;
    @NotNull
    private final List<String> sourcePaths;
    @NotNull
    private final String osName;
    @NotNull
    private final List<Tool> tools;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;
    @NotNull
    private static final Json jsonFormat;

    public AnalysisMetadata(int fileCount, int lineCount, @NotNull Counter codeCoverage, int numOfReportDir, @NotNull List<String> sourcePaths, @NotNull String osName, @NotNull List<Tool> tools) {
        Intrinsics.checkNotNullParameter((Object)codeCoverage, (String)"codeCoverage");
        Intrinsics.checkNotNullParameter(sourcePaths, (String)"sourcePaths");
        Intrinsics.checkNotNullParameter((Object)osName, (String)"osName");
        Intrinsics.checkNotNullParameter(tools, (String)"tools");
        this.fileCount = fileCount;
        this.lineCount = lineCount;
        this.codeCoverage = codeCoverage;
        this.numOfReportDir = numOfReportDir;
        this.sourcePaths = sourcePaths;
        this.osName = osName;
        this.tools = tools;
    }

    public final int getFileCount() {
        return this.fileCount;
    }

    @SerialName(value="file_count")
    public static /* synthetic */ void getFileCount$annotations() {
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    @SerialName(value="line_count")
    public static /* synthetic */ void getLineCount$annotations() {
    }

    @NotNull
    public final Counter getCodeCoverage() {
        return this.codeCoverage;
    }

    @SerialName(value="code_coverage")
    public static /* synthetic */ void getCodeCoverage$annotations() {
    }

    public final int getNumOfReportDir() {
        return this.numOfReportDir;
    }

    @SerialName(value="num_of_report_dir")
    public static /* synthetic */ void getNumOfReportDir$annotations() {
    }

    @NotNull
    public final List<String> getSourcePaths() {
        return this.sourcePaths;
    }

    @SerialName(value="source_paths")
    public static /* synthetic */ void getSourcePaths$annotations() {
    }

    @NotNull
    public final String getOsName() {
        return this.osName;
    }

    @SerialName(value="os_name")
    public static /* synthetic */ void getOsName$annotations() {
    }

    @NotNull
    public final List<Tool> getTools() {
        return this.tools;
    }

    @NotNull
    public final String toJson() {
        return jsonFormat.encodeToString((SerializationStrategy)Companion.serializer(), (Object)this);
    }

    public final int component1() {
        return this.fileCount;
    }

    public final int component2() {
        return this.lineCount;
    }

    @NotNull
    public final Counter component3() {
        return this.codeCoverage;
    }

    public final int component4() {
        return this.numOfReportDir;
    }

    @NotNull
    public final List<String> component5() {
        return this.sourcePaths;
    }

    @NotNull
    public final String component6() {
        return this.osName;
    }

    @NotNull
    public final List<Tool> component7() {
        return this.tools;
    }

    @NotNull
    public final AnalysisMetadata copy(int fileCount, int lineCount, @NotNull Counter codeCoverage, int numOfReportDir, @NotNull List<String> sourcePaths, @NotNull String osName, @NotNull List<Tool> tools) {
        Intrinsics.checkNotNullParameter((Object)codeCoverage, (String)"codeCoverage");
        Intrinsics.checkNotNullParameter(sourcePaths, (String)"sourcePaths");
        Intrinsics.checkNotNullParameter((Object)osName, (String)"osName");
        Intrinsics.checkNotNullParameter(tools, (String)"tools");
        return new AnalysisMetadata(fileCount, lineCount, codeCoverage, numOfReportDir, sourcePaths, osName, tools);
    }

    public static /* synthetic */ AnalysisMetadata copy$default(AnalysisMetadata analysisMetadata2, int n, int n2, Counter counter, int n3, List list, String string, List list2, int n4, Object object) {
        if ((n4 & 1) != 0) {
            n = analysisMetadata2.fileCount;
        }
        if ((n4 & 2) != 0) {
            n2 = analysisMetadata2.lineCount;
        }
        if ((n4 & 4) != 0) {
            counter = analysisMetadata2.codeCoverage;
        }
        if ((n4 & 8) != 0) {
            n3 = analysisMetadata2.numOfReportDir;
        }
        if ((n4 & 0x10) != 0) {
            list = analysisMetadata2.sourcePaths;
        }
        if ((n4 & 0x20) != 0) {
            string = analysisMetadata2.osName;
        }
        if ((n4 & 0x40) != 0) {
            list2 = analysisMetadata2.tools;
        }
        return analysisMetadata2.copy(n, n2, counter, n3, list, string, list2);
    }

    @NotNull
    public String toString() {
        return "AnalysisMetadata(fileCount=" + this.fileCount + ", lineCount=" + this.lineCount + ", codeCoverage=" + this.codeCoverage + ", numOfReportDir=" + this.numOfReportDir + ", sourcePaths=" + this.sourcePaths + ", osName=" + this.osName + ", tools=" + this.tools + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.fileCount);
        result = result * 31 + Integer.hashCode(this.lineCount);
        result = result * 31 + this.codeCoverage.hashCode();
        result = result * 31 + Integer.hashCode(this.numOfReportDir);
        result = result * 31 + ((Object)this.sourcePaths).hashCode();
        result = result * 31 + this.osName.hashCode();
        result = result * 31 + ((Object)this.tools).hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnalysisMetadata)) {
            return false;
        }
        AnalysisMetadata analysisMetadata2 = (AnalysisMetadata)other;
        if (this.fileCount != analysisMetadata2.fileCount) {
            return false;
        }
        if (this.lineCount != analysisMetadata2.lineCount) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.codeCoverage, (Object)analysisMetadata2.codeCoverage)) {
            return false;
        }
        if (this.numOfReportDir != analysisMetadata2.numOfReportDir) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.sourcePaths, (Object)analysisMetadata2.sourcePaths)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.osName, (Object)analysisMetadata2.osName)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.tools, (Object)analysisMetadata2.tools);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(AnalysisMetadata self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArray = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.fileCount);
        output.encodeIntElement(serialDesc, 1, self.lineCount);
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)Counter.$serializer.INSTANCE, (Object)self.codeCoverage);
        output.encodeIntElement(serialDesc, 3, self.numOfReportDir);
        output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy)kSerializerArray[4], (Object)self.sourcePaths);
        output.encodeStringElement(serialDesc, 5, self.osName);
        output.encodeSerializableElement(serialDesc, 6, (SerializationStrategy)kSerializerArray[6], (Object)self.tools);
    }

    public /* synthetic */ AnalysisMetadata(int seen0, int fileCount, int lineCount, Counter codeCoverage, int numOfReportDir, List sourcePaths, String osName, List tools, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (0x7F & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)127, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.fileCount = fileCount;
        this.lineCount = lineCount;
        this.codeCoverage = codeCoverage;
        this.numOfReportDir = numOfReportDir;
        this.sourcePaths = sourcePaths;
        this.osName = osName;
        this.tools = tools;
    }

    private static final Unit jsonFormat$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter((Object)$this$Json, (String)"$this$Json");
        $this$Json.setUseArrayPolymorphism(true);
        $this$Json.setPrettyPrint(true);
        $this$Json.setEncodeDefaults(false);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{null, null, null, null, new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), null, new ArrayListSerializer((KSerializer)Tool.$serializer.INSTANCE)};
        $childSerializers = kSerializerArray;
        jsonFormat = JsonKt.Json$default(null, AnalysisMetadata::jsonFormat$lambda$0, (int)1, null);
    }
}

