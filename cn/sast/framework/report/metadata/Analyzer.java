package cn.sast.framework.report.metadata;

import java.util.Map;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
public final class Analyzer {
    @NotNull
    private final AnalyzerStatistics analyzerStatistics;
    @NotNull
    private final Map<String, String> checkers;

    public Analyzer(@NotNull AnalyzerStatistics analyzerStatistics, @NotNull Map<String, String> checkers) {
        if (analyzerStatistics == null) {
            throw new IllegalArgumentException("analyzerStatistics cannot be null");
        }
        if (checkers == null) {
            throw new IllegalArgumentException("checkers cannot be null");
        }
        this.analyzerStatistics = analyzerStatistics;
        this.checkers = checkers;
    }

    public Analyzer(@NotNull AnalyzerStatistics analyzerStatistics) {
        this(analyzerStatistics, Map.of());
    }

    @NotNull
    public AnalyzerStatistics getAnalyzerStatistics() {
        return analyzerStatistics;
    }

    @NotNull
    public Map<String, String> getCheckers() {
        return checkers;
    }

    @NotNull
    public Analyzer copy(@NotNull AnalyzerStatistics analyzerStatistics, @NotNull Map<String, String> checkers) {
        if (analyzerStatistics == null || checkers == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        return new Analyzer(analyzerStatistics, checkers);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof Analyzer)) return false;
        Analyzer analyzer = (Analyzer) other;
        return analyzerStatistics.equals(analyzer.analyzerStatistics) && 
               checkers.equals(analyzer.checkers);
    }

    @Override
    public int hashCode() {
        int result = analyzerStatistics.hashCode();
        result = 31 * result + checkers.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Analyzer(analyzerStatistics=" + analyzerStatistics + 
               ", checkers=" + checkers + ")";
    }

    public static final class Serializer {
        private static final KSerializer<Object>[] childSerializers = new KSerializer[]{
            null,
            new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE)
        };

        public static void write$Self(Analyzer self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(
                serialDesc, 
                0, 
                AnalyzerStatistics.Serializer.INSTANCE, 
                self.analyzerStatistics
            );
            
            if (output.shouldEncodeElementDefault(serialDesc, 1) || 
                !self.checkers.isEmpty()) {
                output.encodeSerializableElement(
                    serialDesc, 
                    1, 
                    childSerializers[1], 
                    self.checkers
                );
            }
        }
    }
}