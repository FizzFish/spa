package cn.sast.framework.metrics;

import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;

@ExperimentalSerializationApi
public final class DynamicLookupSerializer implements KSerializer<Object> {
    @NotNull
    private final SerialDescriptor descriptor = new ContextualSerializer(Object.class, null, new KSerializer[0]).getDescriptor();

    @Override
    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override
    public void serialize(@NotNull Encoder encoder, @NotNull Object value) {
        if (encoder == null) throw new IllegalArgumentException("encoder cannot be null");
        if (value == null) throw new IllegalArgumentException("value cannot be null");

        KSerializer<?> serializer = encoder.getSerializersModule().getContextual(value.getClass());
        if (serializer == null) {
            serializer = SerializersKt.serializer(value.getClass());
        }

        encoder.encodeSerializableValue((SerializationStrategy<? super Object>) serializer, value);
    }

    @Override
    @NotNull
    public Object deserialize(@NotNull Decoder decoder) {
        if (decoder == null) throw new IllegalArgumentException("decoder cannot be null");
        throw new IllegalStateException("not support yet");
    }
}