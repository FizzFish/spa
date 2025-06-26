/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sarif.IndexedMessage
 *  cn.sast.framework.report.sarif.IndexedMessage$$serializer
 *  cn.sast.framework.report.sarif.IndexedMessage$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.EncodeDefault
 *  kotlinx.serialization.EncodeDefault$Mode
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.sarif;

import cn.sast.framework.report.sarif.IndexedMessage;
import cn.sast.framework.report.sarif.IndexedMessage$;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.EncodeDefault;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0004\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001\u00a2\u0006\u0002\b\u001dR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006 "}, d2={"Lcn/sast/framework/report/sarif/IndexedMessage;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
public final class IndexedMessage {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String id;

    public IndexedMessage(@NotNull String id) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        this.id = id;
    }

    public /* synthetic */ IndexedMessage(String string, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            string = "default";
        }
        this(string);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @EncodeDefault(mode=EncodeDefault.Mode.ALWAYS)
    public static /* synthetic */ void getId$annotations() {
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final IndexedMessage copy(@NotNull String id) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        return new IndexedMessage(id);
    }

    public static /* synthetic */ IndexedMessage copy$default(IndexedMessage indexedMessage, String string, int n, Object object) {
        if ((n & 1) != 0) {
            string = indexedMessage.id;
        }
        return indexedMessage.copy(string);
    }

    @NotNull
    public String toString() {
        return "IndexedMessage(id=" + this.id + ")";
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IndexedMessage)) {
            return false;
        }
        IndexedMessage indexedMessage = (IndexedMessage)other;
        return Intrinsics.areEqual((Object)this.id, (Object)indexedMessage.id);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(IndexedMessage self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.id);
    }

    public /* synthetic */ IndexedMessage(int seen0, String id, SerializationConstructorMarker serializationConstructorMarker) {
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)0, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.id = (seen0 & 1) == 0 ? "default" : id;
    }

    public IndexedMessage() {
        this(null, 1, null);
    }
}

