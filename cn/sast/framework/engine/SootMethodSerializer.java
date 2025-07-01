package cn.sast.framework.engine;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;

@Serializer(forClass = SootMethod.class)
public final class SootMethodSerializer implements KSerializer<SootMethod> {
    public static final SootMethodSerializer INSTANCE = new SootMethodSerializer();
    private static final SerialDescriptor descriptor = 
        SerialDescriptorsKt.PrimitiveSerialDescriptor("SootMethod", PrimitiveKind.STRING.INSTANCE);

    private SootMethodSerializer() {
    }

    @Override
    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override
    @NotNull
    public SootMethod deserialize(@NotNull Decoder decoder) {
        if (decoder == null) throw new IllegalArgumentException("decoder cannot be null");
        throw new IllegalStateException("Not yet implemented");
    }

    @Override
    public void serialize(@NotNull Encoder encoder, @NotNull SootMethod value) {
        if (encoder == null) throw new IllegalArgumentException("encoder cannot be null");
        if (value == null) throw new IllegalArgumentException("value cannot be null");
        
        CompositeEncoder composite = encoder.beginStructure(getDescriptor());
        try {
            composite.encodeString(value.toString());
        } finally {
            composite.endStructure(getDescriptor());
        }
    }
}