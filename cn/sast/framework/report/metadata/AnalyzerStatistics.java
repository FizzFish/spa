package cn.sast.framework.report.metadata;

import java.util.List;
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
import org.jetbrains.annotations.NotNull;

@Serializable
public final class AnalyzerStatistics {
    private final int failed;
    @NotNull
    private final List<String> failedSources;
    private final int successful;
    @NotNull
    private final List<String> successfulSources;
    @NotNull
    private final String version;

    public AnalyzerStatistics(int failed, @NotNull List<String> failedSources, 
                            int successful, @NotNull List<String> successfulSources, 
                            @NotNull String version) {
        if (failedSources == null) throw new IllegalArgumentException("failedSources cannot be null");
        if (successfulSources == null) throw new IllegalArgumentException("successfulSources cannot be null");
        if (version == null) throw new IllegalArgumentException("version cannot be null");
        
        this.failed = failed;
        this.failedSources = failedSources;
        this.successful = successful;
        this.successfulSources = successfulSources;
        this.version = version;
    }

    public int getFailed() {
        return failed;
    }

    @NotNull
    public List<String> getFailedSources() {
        return failedSources;
    }

    public int getSuccessful() {
        return successful;
    }

    @NotNull
    public List<String> getSuccessfulSources() {
        return successfulSources;
    }

    @NotNull
    public String getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof AnalyzerStatistics)) return false;
        
        AnalyzerStatistics that = (AnalyzerStatistics) other;
        return failed == that.failed &&
               successful == that.successful &&
               failedSources.equals(that.failedSources) &&
               successfulSources.equals(that.successfulSources) &&
               version.equals(that.version);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(failed);
        result = 31 * result + failedSources.hashCode();
        result = 31 * result + Integer.hashCode(successful);
        result = 31 * result + successfulSources.hashCode();
        result = 31 * result + version.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AnalyzerStatistics(failed=" + failed + 
               ", failedSources=" + failedSources + 
               ", successful=" + successful + 
               ", successfulSources=" + successfulSources + 
               ", version=" + version + ")";
    }

    public static final class Serializer {
        private static final KSerializer<?>[] childSerializers = new KSerializer[]{
            null, 
            new ArrayListSerializer<>(StringSerializer.INSTANCE), 
            null, 
            new ArrayListSerializer<>(StringSerializer.INSTANCE), 
            null
        };

        @JvmStatic
        public static void write$Self(AnalyzerStatistics self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeIntElement(serialDesc, 0, self.failed);
            output.encodeSerializableElement(serialDesc, 1, 
                (SerializationStrategy)childSerializers[1], self.failedSources);
            output.encodeIntElement(serialDesc, 2, self.successful);
            output.encodeSerializableElement(serialDesc, 3, 
                (SerializationStrategy)childSerializers[3], self.successfulSources);
            output.encodeStringElement(serialDesc, 4, self.version);
        }
    }
}