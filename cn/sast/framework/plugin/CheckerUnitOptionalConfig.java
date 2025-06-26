/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.plugin.CheckerUnitOptionalConfig
 *  cn.sast.framework.plugin.CheckerUnitOptionalConfig$$serializer
 *  cn.sast.framework.plugin.CheckerUnitOptionalConfig$Companion
 *  cn.sast.framework.plugin.ConfigSerializable
 *  cn.sast.framework.plugin.IFieldOptions
 *  cn.sast.framework.plugin.IOptional
 *  com.feysh.corax.config.api.SAOptions
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.PolymorphicSerializer
 *  kotlinx.serialization.SerialName
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.plugin;

import cn.sast.framework.plugin.CheckerUnitOptionalConfig;
import cn.sast.framework.plugin.CheckerUnitOptionalConfig$;
import cn.sast.framework.plugin.ConfigSerializable;
import cn.sast.framework.plugin.IFieldOptions;
import cn.sast.framework.plugin.IOptional;
import com.feysh.corax.config.api.SAOptions;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@SerialName(value="CheckerUnitOptionalConfig")
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002*+B&\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\r\u0010\b\u001a\t\u0018\u00010\t\u00a2\u0006\u0002\b\n\u00a2\u0006\u0004\b\u000b\u0010\fB7\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u000b\u0010\u0011J\u0011\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0001H\u0096\u0002J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0007H\u00c6\u0003J\u0010\u0010\u001c\u001a\t\u0018\u00010\t\u00a2\u0006\u0002\b\nH\u00c6\u0003J.\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000f\b\u0002\u0010\b\u001a\t\u0018\u00010\t\u00a2\u0006\u0002\b\nH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001fH\u00d6\u0003J\t\u0010 \u001a\u00020\u000eH\u00d6\u0001J\t\u0010!\u001a\u00020\u0005H\u00d6\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001\u00a2\u0006\u0002\b)R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\b\u001a\t\u0018\u00010\t\u00a2\u0006\u0002\b\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006,"}, d2={"Lcn/sast/framework/plugin/CheckerUnitOptionalConfig;", "Lcn/sast/framework/plugin/ConfigSerializable;", "Lcn/sast/framework/plugin/IOptional;", "Lcn/sast/framework/plugin/IFieldOptions;", "name", "", "enable", "", "options", "Lcom/feysh/corax/config/api/SAOptions;", "Lkotlinx/serialization/Polymorphic;", "<init>", "(Ljava/lang/String;ZLcom/feysh/corax/config/api/SAOptions;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLcom/feysh/corax/config/api/SAOptions;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getEnable", "()Z", "getOptions", "()Lcom/feysh/corax/config/api/SAOptions;", "compareTo", "other", "component1", "component2", "component3", "copy", "equals", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nSAConfiguration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SAConfiguration.kt\ncn/sast/framework/plugin/CheckerUnitOptionalConfig\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,557:1\n1#2:558\n*E\n"})
public final class CheckerUnitOptionalConfig
extends ConfigSerializable
implements IOptional,
IFieldOptions {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String name;
    private final boolean enable;
    @Nullable
    private final SAOptions options;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public CheckerUnitOptionalConfig(@NotNull String name, boolean enable, @Nullable SAOptions options) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        super(null);
        this.name = name;
        this.enable = enable;
        this.options = options;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public boolean getEnable() {
        return this.enable;
    }

    @Nullable
    public SAOptions getOptions() {
        return this.options;
    }

    public int compareTo(@NotNull ConfigSerializable other) {
        Integer n;
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        if (!(other instanceof CheckerUnitOptionalConfig)) {
            return super.compareTo(other);
        }
        Integer n2 = super.compareTo(other);
        int it = ((Number)n2).intValue();
        boolean bl = false;
        Integer n3 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl2 = false;
            return it;
        }
        if (this.getEnable() != ((CheckerUnitOptionalConfig)other).getEnable()) {
            return this.getEnable() ? -1 : 1;
        }
        return 0;
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    public final boolean component2() {
        return this.enable;
    }

    @Nullable
    public final SAOptions component3() {
        return this.options;
    }

    @NotNull
    public final CheckerUnitOptionalConfig copy(@NotNull String name, boolean enable, @Nullable SAOptions options) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return new CheckerUnitOptionalConfig(name, enable, options);
    }

    public static /* synthetic */ CheckerUnitOptionalConfig copy$default(CheckerUnitOptionalConfig checkerUnitOptionalConfig, String string, boolean bl, SAOptions sAOptions, int n, Object object) {
        if ((n & 1) != 0) {
            string = checkerUnitOptionalConfig.name;
        }
        if ((n & 2) != 0) {
            bl = checkerUnitOptionalConfig.enable;
        }
        if ((n & 4) != 0) {
            sAOptions = checkerUnitOptionalConfig.options;
        }
        return checkerUnitOptionalConfig.copy(string, bl, sAOptions);
    }

    @NotNull
    public String toString() {
        return "CheckerUnitOptionalConfig(name=" + this.name + ", enable=" + this.enable + ", options=" + this.options + ")";
    }

    public int hashCode() {
        int result = this.name.hashCode();
        result = result * 31 + Boolean.hashCode(this.enable);
        result = result * 31 + (this.options == null ? 0 : this.options.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckerUnitOptionalConfig)) {
            return false;
        }
        CheckerUnitOptionalConfig checkerUnitOptionalConfig = (CheckerUnitOptionalConfig)other;
        if (!Intrinsics.areEqual((Object)this.name, (Object)checkerUnitOptionalConfig.name)) {
            return false;
        }
        if (this.enable != checkerUnitOptionalConfig.enable) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.options, (Object)checkerUnitOptionalConfig.options);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(CheckerUnitOptionalConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        ConfigSerializable.write$Self((ConfigSerializable)((ConfigSerializable)self), (CompositeEncoder)output, (SerialDescriptor)serialDesc);
        KSerializer[] kSerializerArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.getName());
        output.encodeBooleanElement(serialDesc, 1, self.getEnable());
        output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy)kSerializerArray[2], (Object)self.getOptions());
    }

    public /* synthetic */ CheckerUnitOptionalConfig(int seen0, String name, boolean enable, SAOptions options, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (7 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)7, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        super(seen0, serializationConstructorMarker);
        this.name = name;
        this.enable = enable;
        this.options = options;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{null, null, new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(SAOptions.class), new Annotation[0])};
        $childSerializers = kSerializerArray;
    }
}

