/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sarif.Rule
 *  cn.sast.framework.report.sarif.Rule$$serializer
 *  cn.sast.framework.report.sarif.ToolComponent
 *  cn.sast.framework.report.sarif.ToolComponent$$serializer
 *  cn.sast.framework.report.sarif.ToolComponent$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.sarif;

import cn.sast.framework.report.sarif.Rule;
import cn.sast.framework.report.sarif.Rule$;
import cn.sast.framework.report.sarif.ToolComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\t\u0010\nBI\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J7\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\fH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001\u00a2\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006*"}, d2={"Lcn/sast/framework/report/sarif/ToolComponent;", "", "name", "", "organization", "version", "rules", "", "Lcn/sast/framework/report/sarif/Rule;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getOrganization", "getVersion", "getRules", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
public final class ToolComponent {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String name;
    @NotNull
    private final String organization;
    @NotNull
    private final String version;
    @NotNull
    private final List<Rule> rules;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public ToolComponent(@NotNull String name, @NotNull String organization, @NotNull String version, @NotNull List<Rule> rules2) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)organization, (String)"organization");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        Intrinsics.checkNotNullParameter(rules2, (String)"rules");
        this.name = name;
        this.organization = organization;
        this.version = version;
        this.rules = rules2;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getOrganization() {
        return this.organization;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    @NotNull
    public final List<Rule> getRules() {
        return this.rules;
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.organization;
    }

    @NotNull
    public final String component3() {
        return this.version;
    }

    @NotNull
    public final List<Rule> component4() {
        return this.rules;
    }

    @NotNull
    public final ToolComponent copy(@NotNull String name, @NotNull String organization, @NotNull String version, @NotNull List<Rule> rules2) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)organization, (String)"organization");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        Intrinsics.checkNotNullParameter(rules2, (String)"rules");
        return new ToolComponent(name, organization, version, rules2);
    }

    public static /* synthetic */ ToolComponent copy$default(ToolComponent toolComponent, String string, String string2, String string3, List list, int n, Object object) {
        if ((n & 1) != 0) {
            string = toolComponent.name;
        }
        if ((n & 2) != 0) {
            string2 = toolComponent.organization;
        }
        if ((n & 4) != 0) {
            string3 = toolComponent.version;
        }
        if ((n & 8) != 0) {
            list = toolComponent.rules;
        }
        return toolComponent.copy(string, string2, string3, list);
    }

    @NotNull
    public String toString() {
        return "ToolComponent(name=" + this.name + ", organization=" + this.organization + ", version=" + this.version + ", rules=" + this.rules + ")";
    }

    public int hashCode() {
        int result = this.name.hashCode();
        result = result * 31 + this.organization.hashCode();
        result = result * 31 + this.version.hashCode();
        result = result * 31 + ((Object)this.rules).hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolComponent)) {
            return false;
        }
        ToolComponent toolComponent = (ToolComponent)other;
        if (!Intrinsics.areEqual((Object)this.name, (Object)toolComponent.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.organization, (Object)toolComponent.organization)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.version, (Object)toolComponent.version)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.rules, (Object)toolComponent.rules);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(ToolComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.name);
        output.encodeStringElement(serialDesc, 1, self.organization);
        output.encodeStringElement(serialDesc, 2, self.version);
        output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy)kSerializerArray[3], (Object)self.rules);
    }

    public /* synthetic */ ToolComponent(int seen0, String name, String organization, String version, List rules2, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (0xF & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)15, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.name = name;
        this.organization = organization;
        this.version = version;
        this.rules = rules2;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{null, null, null, new ArrayListSerializer((KSerializer)Rule$.serializer.INSTANCE)};
        $childSerializers = kSerializerArray;
    }
}

