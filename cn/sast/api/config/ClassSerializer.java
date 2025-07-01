package cn.sast.api.config;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

public final class ClassSerializer implements KSerializer<Class<?>> {
    @NotNull
    public static final ClassSerializer INSTANCE = new ClassSerializer();
    @NotNull
    private static final SerialDescriptor descriptor = 
        SerialDescriptorsKt.PrimitiveSerialDescriptor("ClassSerializer", PrimitiveKind.STRING.INSTANCE);

    private ClassSerializer() {
    }

    @Override
    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override
    public void serialize(@NotNull Encoder encoder, @NotNull Class<?> value) {
        if (encoder == null) throw new IllegalArgumentException("encoder cannot be null");
        if (value == null) throw new IllegalArgumentException("value cannot be null");
        encoder.encodeString(value.getName());
    }

    @Override
    @NotNull
    public Class<?> deserialize(@NotNull Decoder decoder) {
        if (decoder == null) throw new IllegalArgumentException("decoder cannot be null");
        try {
            return Class.forName(decoder.decodeString());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to deserialize class", e);
        }
    }
}