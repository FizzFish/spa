package cn.sast.framework.report.sarif;

import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
public final class MessageStrings {
    @NotNull
    private final Message default;

    public MessageStrings(@NotNull Message defaultMessage) {
        if (defaultMessage == null) {
            throw new IllegalArgumentException("default cannot be null");
        }
        this.default = defaultMessage;
    }

    @NotNull
    public Message getDefault() {
        return default;
    }

    @NotNull
    public MessageStrings copy(@NotNull Message defaultMessage) {
        if (defaultMessage == null) {
            throw new IllegalArgumentException("default cannot be null");
        }
        return new MessageStrings(defaultMessage);
    }

    @Override
    public String toString() {
        return "MessageStrings(default=" + default + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof MessageStrings)) return false;
        MessageStrings that = (MessageStrings) other;
        return default.equals(that.default);
    }

    @Override
    public int hashCode() {
        return default.hashCode();
    }

    @JvmStatic
    public static void write$Self$corax_framework(MessageStrings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, Message.$serializer.INSTANCE, self.default);
    }

    public MessageStrings(int seen0, Message message, SerializationConstructorMarker serializationConstructorMarker) {
        if ((1 & seen0) != 1) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, $serializer.INSTANCE.getDescriptor());
        }
        this.default = message;
    }

    public static final class Companion {
        private Companion() {}
    }
}