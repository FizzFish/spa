/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sarif.Description
 *  cn.sast.framework.report.sarif.Description$$serializer
 *  cn.sast.framework.report.sarif.UriBase
 *  cn.sast.framework.report.sarif.UriBase$$serializer
 *  cn.sast.framework.report.sarif.UriBase$Companion
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
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.sarif;

import cn.sast.framework.report.sarif.Description;
import cn.sast.framework.report.sarif.Description$;
import cn.sast.framework.report.sarif.UriBase;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001\u00a2\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006#"}, d2={"Lcn/sast/framework/report/sarif/UriBase;", "", "uri", "", "description", "Lcn/sast/framework/report/sarif/Description;", "<init>", "(Ljava/lang/String;Lcn/sast/framework/report/sarif/Description;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcn/sast/framework/report/sarif/Description;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUri", "()Ljava/lang/String;", "getDescription", "()Lcn/sast/framework/report/sarif/Description;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
public final class UriBase {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String uri;
    @Nullable
    private final Description description;

    public UriBase(@NotNull String uri, @Nullable Description description) {
        Intrinsics.checkNotNullParameter((Object)uri, (String)"uri");
        this.uri = uri;
        this.description = description;
    }

    public /* synthetic */ UriBase(String string, Description description, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            description = null;
        }
        this(string, description);
    }

    @NotNull
    public final String getUri() {
        return this.uri;
    }

    @Nullable
    public final Description getDescription() {
        return this.description;
    }

    @NotNull
    public final String component1() {
        return this.uri;
    }

    @Nullable
    public final Description component2() {
        return this.description;
    }

    @NotNull
    public final UriBase copy(@NotNull String uri, @Nullable Description description) {
        Intrinsics.checkNotNullParameter((Object)uri, (String)"uri");
        return new UriBase(uri, description);
    }

    public static /* synthetic */ UriBase copy$default(UriBase uriBase, String string, Description description, int n, Object object) {
        if ((n & 1) != 0) {
            string = uriBase.uri;
        }
        if ((n & 2) != 0) {
            description = uriBase.description;
        }
        return uriBase.copy(string, description);
    }

    @NotNull
    public String toString() {
        return "UriBase(uri=" + this.uri + ", description=" + this.description + ")";
    }

    public int hashCode() {
        int result = this.uri.hashCode();
        result = result * 31 + (this.description == null ? 0 : this.description.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UriBase)) {
            return false;
        }
        UriBase uriBase = (UriBase)other;
        if (!Intrinsics.areEqual((Object)this.uri, (Object)uriBase.uri)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.description, (Object)uriBase.description);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(UriBase self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.uri);
        if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy)Description$.serializer.INSTANCE, (Object)self.description);
        }
    }

    public /* synthetic */ UriBase(int seen0, String uri, Description description, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.uri = uri;
        this.description = (seen0 & 2) == 0 ? null : description;
    }
}

