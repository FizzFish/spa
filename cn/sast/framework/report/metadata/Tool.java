/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.metadata.Analyzer
 *  cn.sast.framework.report.metadata.Analyzer$$serializer
 *  cn.sast.framework.report.metadata.Tool
 *  cn.sast.framework.report.metadata.Tool$$serializer
 *  cn.sast.framework.report.metadata.Tool$Companion
 *  kotlin.Metadata
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
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.metadata;

import cn.sast.framework.report.metadata.Analyzer;
import cn.sast.framework.report.metadata.Analyzer$;
import cn.sast.framework.report.metadata.Tool;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0002<=Bk\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fB\u008f\u0001\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u000e\u0010\u0014J\u0015\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u00c6\u0003J\t\u0010(\u001a\u00020\u0004H\u00c6\u0003J\t\u0010)\u001a\u00020\u0004H\u00c6\u0003J\t\u0010*\u001a\u00020\u0004H\u00c6\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u00c6\u0003J\u0015\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0004H\u00c6\u0003J}\u0010.\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\r\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00102\u001a\u00020\u0011H\u00d6\u0001J\t\u00103\u001a\u00020\u0004H\u00d6\u0001J%\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0001\u00a2\u0006\u0002\b;R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001aR\u001c\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u001aR\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u0018R(\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u0016R\u001c\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001a\u00a8\u0006>"}, d2={"Lcn/sast/framework/report/metadata/Tool;", "", "analyzers", "", "", "Lcn/sast/framework/report/metadata/Analyzer;", "command", "", "name", "outputPath", "projectRoot", "multipleProjectRoot", "resultSourceFiles", "workingDirectory", "<init>", "(Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAnalyzers", "()Ljava/util/Map;", "getCommand", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getOutputPath$annotations", "()V", "getOutputPath", "getProjectRoot$annotations", "getProjectRoot", "getMultipleProjectRoot$annotations", "getMultipleProjectRoot", "getResultSourceFiles$annotations", "getResultSourceFiles", "getWorkingDirectory$annotations", "getWorkingDirectory", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
public final class Tool {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Map<String, Analyzer> analyzers;
    @NotNull
    private final List<String> command;
    @NotNull
    private final String name;
    @NotNull
    private final String outputPath;
    @NotNull
    private final String projectRoot;
    @NotNull
    private final List<String> multipleProjectRoot;
    @NotNull
    private final Map<String, String> resultSourceFiles;
    @NotNull
    private final String workingDirectory;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public Tool(@NotNull Map<String, Analyzer> analyzers, @NotNull List<String> command, @NotNull String name, @NotNull String outputPath, @NotNull String projectRoot, @NotNull List<String> multipleProjectRoot, @NotNull Map<String, String> resultSourceFiles, @NotNull String workingDirectory) {
        Intrinsics.checkNotNullParameter(analyzers, (String)"analyzers");
        Intrinsics.checkNotNullParameter(command, (String)"command");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)outputPath, (String)"outputPath");
        Intrinsics.checkNotNullParameter((Object)projectRoot, (String)"projectRoot");
        Intrinsics.checkNotNullParameter(multipleProjectRoot, (String)"multipleProjectRoot");
        Intrinsics.checkNotNullParameter(resultSourceFiles, (String)"resultSourceFiles");
        Intrinsics.checkNotNullParameter((Object)workingDirectory, (String)"workingDirectory");
        this.analyzers = analyzers;
        this.command = command;
        this.name = name;
        this.outputPath = outputPath;
        this.projectRoot = projectRoot;
        this.multipleProjectRoot = multipleProjectRoot;
        this.resultSourceFiles = resultSourceFiles;
        this.workingDirectory = workingDirectory;
    }

    @NotNull
    public final Map<String, Analyzer> getAnalyzers() {
        return this.analyzers;
    }

    @NotNull
    public final List<String> getCommand() {
        return this.command;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getOutputPath() {
        return this.outputPath;
    }

    @SerialName(value="output_path")
    public static /* synthetic */ void getOutputPath$annotations() {
    }

    @NotNull
    public final String getProjectRoot() {
        return this.projectRoot;
    }

    @SerialName(value="project_root")
    public static /* synthetic */ void getProjectRoot$annotations() {
    }

    @NotNull
    public final List<String> getMultipleProjectRoot() {
        return this.multipleProjectRoot;
    }

    @SerialName(value="multiple_project_root")
    public static /* synthetic */ void getMultipleProjectRoot$annotations() {
    }

    @NotNull
    public final Map<String, String> getResultSourceFiles() {
        return this.resultSourceFiles;
    }

    @SerialName(value="result_source_files")
    public static /* synthetic */ void getResultSourceFiles$annotations() {
    }

    @NotNull
    public final String getWorkingDirectory() {
        return this.workingDirectory;
    }

    @SerialName(value="working_directory")
    public static /* synthetic */ void getWorkingDirectory$annotations() {
    }

    @NotNull
    public final Map<String, Analyzer> component1() {
        return this.analyzers;
    }

    @NotNull
    public final List<String> component2() {
        return this.command;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @NotNull
    public final String component4() {
        return this.outputPath;
    }

    @NotNull
    public final String component5() {
        return this.projectRoot;
    }

    @NotNull
    public final List<String> component6() {
        return this.multipleProjectRoot;
    }

    @NotNull
    public final Map<String, String> component7() {
        return this.resultSourceFiles;
    }

    @NotNull
    public final String component8() {
        return this.workingDirectory;
    }

    @NotNull
    public final Tool copy(@NotNull Map<String, Analyzer> analyzers, @NotNull List<String> command, @NotNull String name, @NotNull String outputPath, @NotNull String projectRoot, @NotNull List<String> multipleProjectRoot, @NotNull Map<String, String> resultSourceFiles, @NotNull String workingDirectory) {
        Intrinsics.checkNotNullParameter(analyzers, (String)"analyzers");
        Intrinsics.checkNotNullParameter(command, (String)"command");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)outputPath, (String)"outputPath");
        Intrinsics.checkNotNullParameter((Object)projectRoot, (String)"projectRoot");
        Intrinsics.checkNotNullParameter(multipleProjectRoot, (String)"multipleProjectRoot");
        Intrinsics.checkNotNullParameter(resultSourceFiles, (String)"resultSourceFiles");
        Intrinsics.checkNotNullParameter((Object)workingDirectory, (String)"workingDirectory");
        return new Tool(analyzers, command, name, outputPath, projectRoot, multipleProjectRoot, resultSourceFiles, workingDirectory);
    }

    public static /* synthetic */ Tool copy$default(Tool tool, Map map, List list, String string, String string2, String string3, List list2, Map map2, String string4, int n, Object object) {
        if ((n & 1) != 0) {
            map = tool.analyzers;
        }
        if ((n & 2) != 0) {
            list = tool.command;
        }
        if ((n & 4) != 0) {
            string = tool.name;
        }
        if ((n & 8) != 0) {
            string2 = tool.outputPath;
        }
        if ((n & 0x10) != 0) {
            string3 = tool.projectRoot;
        }
        if ((n & 0x20) != 0) {
            list2 = tool.multipleProjectRoot;
        }
        if ((n & 0x40) != 0) {
            map2 = tool.resultSourceFiles;
        }
        if ((n & 0x80) != 0) {
            string4 = tool.workingDirectory;
        }
        return tool.copy(map, list, string, string2, string3, list2, map2, string4);
    }

    @NotNull
    public String toString() {
        return "Tool(analyzers=" + this.analyzers + ", command=" + this.command + ", name=" + this.name + ", outputPath=" + this.outputPath + ", projectRoot=" + this.projectRoot + ", multipleProjectRoot=" + this.multipleProjectRoot + ", resultSourceFiles=" + this.resultSourceFiles + ", workingDirectory=" + this.workingDirectory + ")";
    }

    public int hashCode() {
        int result = ((Object)this.analyzers).hashCode();
        result = result * 31 + ((Object)this.command).hashCode();
        result = result * 31 + this.name.hashCode();
        result = result * 31 + this.outputPath.hashCode();
        result = result * 31 + this.projectRoot.hashCode();
        result = result * 31 + ((Object)this.multipleProjectRoot).hashCode();
        result = result * 31 + ((Object)this.resultSourceFiles).hashCode();
        result = result * 31 + this.workingDirectory.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tool)) {
            return false;
        }
        Tool tool = (Tool)other;
        if (!Intrinsics.areEqual((Object)this.analyzers, (Object)tool.analyzers)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.command, (Object)tool.command)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.name, (Object)tool.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.outputPath, (Object)tool.outputPath)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.projectRoot, (Object)tool.projectRoot)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.multipleProjectRoot, (Object)tool.multipleProjectRoot)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.resultSourceFiles, (Object)tool.resultSourceFiles)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.workingDirectory, (Object)tool.workingDirectory);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(Tool self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArray = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)kSerializerArray[0], (Object)self.analyzers);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)kSerializerArray[1], (Object)self.command);
        output.encodeStringElement(serialDesc, 2, self.name);
        output.encodeStringElement(serialDesc, 3, self.outputPath);
        output.encodeStringElement(serialDesc, 4, self.projectRoot);
        output.encodeSerializableElement(serialDesc, 5, (SerializationStrategy)kSerializerArray[5], (Object)self.multipleProjectRoot);
        output.encodeSerializableElement(serialDesc, 6, (SerializationStrategy)kSerializerArray[6], (Object)self.resultSourceFiles);
        output.encodeStringElement(serialDesc, 7, self.workingDirectory);
    }

    public /* synthetic */ Tool(int seen0, Map analyzers, List command, String name, String outputPath, String projectRoot, List multipleProjectRoot, Map resultSourceFiles, String workingDirectory, SerializationConstructorMarker serializationConstructorMarker) {
        if (255 != (0xFF & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)255, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.analyzers = analyzers;
        this.command = command;
        this.name = name;
        this.outputPath = outputPath;
        this.projectRoot = projectRoot;
        this.multipleProjectRoot = multipleProjectRoot;
        this.resultSourceFiles = resultSourceFiles;
        this.workingDirectory = workingDirectory;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)Analyzer$.serializer.INSTANCE), new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), null, null, null, new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE), null};
        $childSerializers = kSerializerArray;
    }
}

