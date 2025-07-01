package cn.sast.framework.report.metadata;

import java.util.List;
import java.util.Map;
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

@Serializable
public final class Tool {
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

    public Tool(@NotNull Map<String, Analyzer> analyzers, @NotNull List<String> command, 
                @NotNull String name, @NotNull String outputPath, @NotNull String projectRoot, 
                @NotNull List<String> multipleProjectRoot, @NotNull Map<String, String> resultSourceFiles, 
                @NotNull String workingDirectory) {
        if (analyzers == null) throw new IllegalArgumentException("analyzers cannot be null");
        if (command == null) throw new IllegalArgumentException("command cannot be null");
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        if (outputPath == null) throw new IllegalArgumentException("outputPath cannot be null");
        if (projectRoot == null) throw new IllegalArgumentException("projectRoot cannot be null");
        if (multipleProjectRoot == null) throw new IllegalArgumentException("multipleProjectRoot cannot be null");
        if (resultSourceFiles == null) throw new IllegalArgumentException("resultSourceFiles cannot be null");
        if (workingDirectory == null) throw new IllegalArgumentException("workingDirectory cannot be null");

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
    public Map<String, Analyzer> getAnalyzers() {
        return analyzers;
    }

    @NotNull
    public List<String> getCommand() {
        return command;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getOutputPath() {
        return outputPath;
    }

    @NotNull
    public String getProjectRoot() {
        return projectRoot;
    }

    @NotNull
    public List<String> getMultipleProjectRoot() {
        return multipleProjectRoot;
    }

    @NotNull
    public Map<String, String> getResultSourceFiles() {
        return resultSourceFiles;
    }

    @NotNull
    public String getWorkingDirectory() {
        return workingDirectory;
    }

    @Override
    public String toString() {
        return "Tool(analyzers=" + analyzers + ", command=" + command + ", name=" + name + 
               ", outputPath=" + outputPath + ", projectRoot=" + projectRoot + 
               ", multipleProjectRoot=" + multipleProjectRoot + ", resultSourceFiles=" + 
               resultSourceFiles + ", workingDirectory=" + workingDirectory + ")";
    }

    @Override
    public int hashCode() {
        int result = analyzers.hashCode();
        result = 31 * result + command.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + outputPath.hashCode();
        result = 31 * result + projectRoot.hashCode();
        result = 31 * result + multipleProjectRoot.hashCode();
        result = 31 * result + resultSourceFiles.hashCode();
        result = 31 * result + workingDirectory.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Tool)) return false;
        
        Tool tool = (Tool) other;
        return analyzers.equals(tool.analyzers) &&
               command.equals(tool.command) &&
               name.equals(tool.name) &&
               outputPath.equals(tool.outputPath) &&
               projectRoot.equals(tool.projectRoot) &&
               multipleProjectRoot.equals(tool.multipleProjectRoot) &&
               resultSourceFiles.equals(tool.resultSourceFiles) &&
               workingDirectory.equals(tool.workingDirectory);
    }

    public static final class Serializer {
        private static final KSerializer<?>[] childSerializers = new KSerializer[]{
            new LinkedHashMapSerializer(StringSerializer.INSTANCE, Analyzer.Serializer.INSTANCE),
            new ArrayListSerializer(StringSerializer.INSTANCE),
            null,
            null,
            null,
            new ArrayListSerializer(StringSerializer.INSTANCE),
            new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE),
            null
        };

        @JvmStatic
        public static void write$Self(Tool self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)childSerializers[0], self.analyzers);
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)childSerializers[1], self.command);
            output.encodeStringElement(serialDesc, 2, self.name);
            output.encodeStringElement(serialDesc, 3, self.outputPath);
            output.encodeStringElement(serialDesc, 4, self.projectRoot);
            output.encodeSerializableElement(serialDesc, 5, (SerializationStrategy)childSerializers[5], self.multipleProjectRoot);
            output.encodeSerializableElement(serialDesc, 6, (SerializationStrategy)childSerializers[6], self.resultSourceFiles);
            output.encodeStringElement(serialDesc, 7, self.workingDirectory);
        }
    }
}
