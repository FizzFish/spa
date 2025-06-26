/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.Tag
 *  cn.sast.api.config.Tag$$serializer
 *  cn.sast.api.config.Tag$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.config;

import cn.sast.api.config.Tag;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\bH\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001\u00a2\u0006\u0002\b\u001eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r\u00a8\u0006!"}, d2={"Lcn/sast/api/config/Tag;", "", "standard", "", "rule", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStandard", "()Ljava/lang/String;", "getRule", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_api", "$serializer", "Companion", "corax-api"})
public final class Tag {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String standard;
    @NotNull
    private final String rule;

    public Tag(@NotNull String standard, @NotNull String rule) {
        Intrinsics.checkNotNullParameter((Object)standard, (String)"standard");
        Intrinsics.checkNotNullParameter((Object)rule, (String)"rule");
        this.standard = standard;
        this.rule = rule;
    }

    @NotNull
    public final String getStandard() {
        return this.standard;
    }

    @NotNull
    public final String getRule() {
        return this.rule;
    }

    @NotNull
    public final String component1() {
        return this.standard;
    }

    @NotNull
    public final String component2() {
        return this.rule;
    }

    @NotNull
    public final Tag copy(@NotNull String standard, @NotNull String rule) {
        Intrinsics.checkNotNullParameter((Object)standard, (String)"standard");
        Intrinsics.checkNotNullParameter((Object)rule, (String)"rule");
        return new Tag(standard, rule);
    }

    public static /* synthetic */ Tag copy$default(Tag tag, String string, String string2, int n, Object object) {
        if ((n & 1) != 0) {
            string = tag.standard;
        }
        if ((n & 2) != 0) {
            string2 = tag.rule;
        }
        return tag.copy(string, string2);
    }

    @NotNull
    public String toString() {
        return "Tag(standard=" + this.standard + ", rule=" + this.rule + ")";
    }

    public int hashCode() {
        int result = this.standard.hashCode();
        result = result * 31 + this.rule.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag)other;
        if (!Intrinsics.areEqual((Object)this.standard, (Object)tag.standard)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.rule, (Object)tag.rule);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_api(Tag self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.standard);
        output.encodeStringElement(serialDesc, 1, self.rule);
    }

    public /* synthetic */ Tag(int seen0, String standard, String rule, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.standard = standard;
        this.rule = rule;
    }
}

