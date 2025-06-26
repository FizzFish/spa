/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sarif.Message
 *  cn.sast.framework.report.sarif.Message$$serializer
 *  cn.sast.framework.report.sarif.MessageStrings
 *  cn.sast.framework.report.sarif.MessageStrings$$serializer
 *  cn.sast.framework.report.sarif.MessageStrings$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.sarif;

import cn.sast.framework.report.sarif.Message;
import cn.sast.framework.report.sarif.MessageStrings;
import cn.sast.framework.report.sarif.MessageStrings$;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001\u00a2\u0006\u0002\b\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001f"}, d2={"Lcn/sast/framework/report/sarif/MessageStrings;", "", "default", "Lcn/sast/framework/report/sarif/Message;", "<init>", "(Lcn/sast/framework/report/sarif/Message;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcn/sast/framework/report/sarif/Message;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDefault", "()Lcn/sast/framework/report/sarif/Message;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
public final class MessageStrings {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Message default;

    public MessageStrings(@NotNull Message message) {
        Intrinsics.checkNotNullParameter((Object)message, (String)"default");
        this.default = message;
    }

    @NotNull
    public final Message getDefault() {
        return this.default;
    }

    @NotNull
    public final Message component1() {
        return this.default;
    }

    @NotNull
    public final MessageStrings copy(@NotNull Message message) {
        Intrinsics.checkNotNullParameter((Object)message, (String)"default");
        return new MessageStrings(message);
    }

    public static /* synthetic */ MessageStrings copy$default(MessageStrings messageStrings, Message message, int n, Object object) {
        if ((n & 1) != 0) {
            message = messageStrings.default;
        }
        return messageStrings.copy(message);
    }

    @NotNull
    public String toString() {
        return "MessageStrings(default=" + this.default + ")";
    }

    public int hashCode() {
        return this.default.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageStrings)) {
            return false;
        }
        MessageStrings messageStrings = (MessageStrings)other;
        return Intrinsics.areEqual((Object)this.default, (Object)messageStrings.default);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(MessageStrings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)Message.$serializer.INSTANCE, (Object)self.default);
    }

    public /* synthetic */ MessageStrings(int seen0, Message message, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.default = message;
    }
}

