package cn.sast.framework.report.sarif;

import cn.sast.api.config.ExtSettings;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Serializable
public final class SarifLog {
    @NotNull
    private final String schema;
    @NotNull
    private final String version;
    @NotNull
    private final List<Run> runs;

    private static final KSerializer<Object>[] $childSerializers;
    private static final Json jsonFormat;

    static {
        $childSerializers = new KSerializer[]{
            null,
            null,
            new ArrayListSerializer<>(Run.serializer())
        };
        jsonFormat = JsonKt.Json$default(null, SarifLog::configureJson, 1, null);
    }

    public SarifLog(@JsonProperty("$schema") @NotNull String schema,
                   @NotNull String version,
                   @NotNull List<Run> runs) {
        if (schema == null) throw new IllegalArgumentException("schema cannot be null");
        if (version == null) throw new IllegalArgumentException("version cannot be null");
        if (runs == null) throw new IllegalArgumentException("runs cannot be null");
        
        this.schema = schema;
        this.version = version;
        this.runs = runs;
    }

    @NotNull
    public String getSchema() {
        return schema;
    }

    @NotNull
    public String getVersion() {
        return version;
    }

    @NotNull
    public List<Run> getRuns() {
        return runs;
    }

    @NotNull
    public String toJson() {
        return jsonFormat.encodeToString(SarifLogSerializer.INSTANCE, this);
    }

    @NotNull
    public SarifLog copy(@JsonProperty("$schema") @NotNull String schema,
                        @NotNull String version,
                        @NotNull List<Run> runs) {
        return new SarifLog(schema, version, runs);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof SarifLog)) return false;
        
        SarifLog sarifLog = (SarifLog) other;
        return schema.equals(sarifLog.schema) &&
               version.equals(sarifLog.version) &&
               runs.equals(sarifLog.runs);
    }

    @Override
    public int hashCode() {
        int result = schema.hashCode();
        result = 31 * result + version.hashCode();
        result = 31 * result + runs.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SarifLog(schema=" + schema + ", version=" + version + ", runs=" + runs + ")";
    }

    private static void configureJson(JsonBuilder builder) {
        builder.setUseArrayPolymorphism(true);
        builder.setPrettyPrint(ExtSettings.INSTANCE.getPrettyPrintJsonReport());
        builder.setEncodeDefaults(false);
    }

    public static final class SarifLogSerializer implements KSerializer<SarifLog> {
        public static final SarifLogSerializer INSTANCE = new SarifLogSerializer();

        private SarifLogSerializer() {}

        @Override
        public void serialize(CompositeEncoder encoder, SarifLog value, SerialDescriptor descriptor) {
            encoder.encodeStringElement(descriptor, 0, value.schema);
            encoder.encodeStringElement(descriptor, 1, value.version);
            encoder.encodeSerializableElement(descriptor, 2, $childSerializers[2], value.runs);
        }
    }
}