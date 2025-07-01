package cn.sast.framework.metrics;

import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
public final class ReportKey {
    @Nullable
    private final String category;
    @NotNull
    private final String type;
    private int size;

    public ReportKey(@Nullable String category, @NotNull String type, int size) {
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        this.category = category;
        this.type = type;
        this.size = size;
    }

    public ReportKey(@Nullable String category, @NotNull String type) {
        this(category, type, -1);
    }

    @Nullable
    public String getCategory() {
        return category;
    }

    @NotNull
    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof ReportKey)) return false;
        ReportKey reportKey = (ReportKey) other;
        return (category == null ? reportKey.category == null : category.equals(reportKey.category)) &&
               type.equals(reportKey.type) &&
               size == reportKey.size;
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + type.hashCode();
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        return "ReportKey(category=" + category + ", type=" + type + ", size=" + size + ")";
    }

    public static void write$Self$corax_framework(ReportKey self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.category != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.category);
        }
        output.encodeStringElement(serialDesc, 1, self.type);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.size != -1) {
            output.encodeIntElement(serialDesc, 2, self.size);
        }
    }
}