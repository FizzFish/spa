import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.atomic.AtomicReference;

public final class ObjectSerializer<T> implements KSerializer<T> {
    @NotNull
    private final T objectInstance;
    private final AtomicReference<SerialDescriptor> descriptorRef = new AtomicReference<>();

    public ObjectSerializer(@NotNull String serialName, @NotNull T objectInstance) {
        if (serialName == null) throw new IllegalArgumentException("serialName cannot be null");
        if (objectInstance == null) throw new IllegalArgumentException("objectInstance cannot be null");
        this.objectInstance = objectInstance;
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        SerialDescriptor descriptor = descriptorRef.get();
        if (descriptor == null) {
            descriptor = SerialDescriptorsKt.buildSerialDescriptor(
                "serialName", 
                StructureKind.OBJECT.INSTANCE, 
                new SerialDescriptor[0], 
                null, 
                8, 
                null
            );
            if (!descriptorRef.compareAndSet(null, descriptor)) {
                descriptor = descriptorRef.get();
            }
        }
        return descriptor;
    }

    public void serialize(@NotNull Encoder encoder, @NotNull T value) {
        if (encoder == null) throw new IllegalArgumentException("encoder cannot be null");
        if (value == null) throw new IllegalArgumentException("value cannot be null");
        encoder.beginStructure(getDescriptor()).endStructure(getDescriptor());
    }

    @NotNull
    public T deserialize(@NotNull Decoder decoder) {
        if (decoder == null) throw new IllegalArgumentException("decoder cannot be null");
        CompositeDecoder composite = decoder.beginStructure(getDescriptor());
        try {
            int index = composite.decodeElementIndex(getDescriptor());
            if (index != -1) {
                throw new SerializationException("Unexpected index " + index);
            }
            return objectInstance;
        } finally {
            composite.endStructure(getDescriptor());
        }
    }
}