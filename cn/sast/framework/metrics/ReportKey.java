/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.metrics.ReportKey
 *  cn.sast.framework.metrics.ReportKey$$serializer
 *  cn.sast.framework.metrics.ReportKey$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.metrics;

import cn.sast.framework.metrics.ReportKey;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 &2\u00020\u0001:\u0002%&B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0007\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0006H\u00c6\u0003J)\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001\u00a2\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006'"}, d2={"Lcn/sast/framework/metrics/ReportKey;", "", "category", "", "type", "size", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCategory", "()Ljava/lang/String;", "getType", "getSize", "()I", "setSize", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
public final class ReportKey {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final String category;
    @NotNull
    private final String type;
    private int size;

    public ReportKey(@Nullable String category, @NotNull String type, int size) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        this.category = category;
        this.type = type;
        this.size = size;
    }

    public /* synthetic */ ReportKey(String string, String string2, int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            string = null;
        }
        if ((n2 & 4) != 0) {
            n = -1;
        }
        this(string, string2, n);
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final int getSize() {
        return this.size;
    }

    public final void setSize(int n) {
        this.size = n;
    }

    @Nullable
    public final String component1() {
        return this.category;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    public final int component3() {
        return this.size;
    }

    @NotNull
    public final ReportKey copy(@Nullable String category, @NotNull String type, int size) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        return new ReportKey(category, type, size);
    }

    public static /* synthetic */ ReportKey copy$default(ReportKey reportKey, String string, String string2, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = reportKey.category;
        }
        if ((n2 & 2) != 0) {
            string2 = reportKey.type;
        }
        if ((n2 & 4) != 0) {
            n = reportKey.size;
        }
        return reportKey.copy(string, string2, n);
    }

    @NotNull
    public String toString() {
        return "ReportKey(category=" + this.category + ", type=" + this.type + ", size=" + this.size + ")";
    }

    public int hashCode() {
        int result = this.category == null ? 0 : this.category.hashCode();
        result = result * 31 + this.type.hashCode();
        result = result * 31 + Integer.hashCode(this.size);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportKey)) {
            return false;
        }
        ReportKey reportKey = (ReportKey)other;
        if (!Intrinsics.areEqual((Object)this.category, (Object)reportKey.category)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.type, (Object)reportKey.type)) {
            return false;
        }
        return this.size == reportKey.size;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(ReportKey self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) ? true : self.category != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.category);
        }
        output.encodeStringElement(serialDesc, 1, self.type);
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.size != -1) {
            output.encodeIntElement(serialDesc, 2, self.size);
        }
    }

    public /* synthetic */ ReportKey(int seen0, String category, String type, int size, SerializationConstructorMarker serializationConstructorMarker) {
        if (2 != (2 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)2, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.category = (seen0 & 1) == 0 ? null : category;
        this.type = type;
        this.size = (seen0 & 4) == 0 ? -1 : size;
    }
}

