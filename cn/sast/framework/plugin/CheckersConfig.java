/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.plugin.CheckersConfig
 *  cn.sast.framework.plugin.CheckersConfig$$serializer
 *  cn.sast.framework.plugin.CheckersConfig$CheckTypeConfig
 *  cn.sast.framework.plugin.CheckersConfig$CheckTypeConfig$$serializer
 *  cn.sast.framework.plugin.CheckersConfig$Companion
 *  cn.sast.framework.plugin.ConfigSerializable
 *  cn.sast.framework.plugin.IOptional
 *  com.feysh.corax.config.api.IChecker
 *  com.feysh.corax.config.api.utils.UtilsKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerialName
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.LinkedHashSetSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.plugin;

import cn.sast.framework.plugin.CheckersConfig;
import cn.sast.framework.plugin.CheckersConfig$;
import cn.sast.framework.plugin.CheckersConfig$CheckTypeConfig$;
import cn.sast.framework.plugin.ConfigSerializable;
import cn.sast.framework.plugin.IOptional;
import com.feysh.corax.config.api.IChecker;
import com.feysh.corax.config.api.utils.UtilsKt;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@SerialName(value="CheckerTypeConfig")
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 42\u00020\u00012\u00020\u0002:\u0003234B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0004\b\u000b\u0010\u000fBG\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u000b\u0010\u0014J\u0006\u0010\u001e\u001a\u00020\u0000J\u0011\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0001H\u0096\u0002J\t\u0010!\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\t\u0010#\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J9\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0001J\u0013\u0010&\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010'H\u00d6\u0003J\t\u0010(\u001a\u00020\u0011H\u00d6\u0001J\t\u0010)\u001a\u00020\u0004H\u00d6\u0001J%\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001\u00a2\u0006\u0002\b1R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u00065"}, d2={"Lcn/sast/framework/plugin/CheckersConfig;", "Lcn/sast/framework/plugin/ConfigSerializable;", "Lcn/sast/framework/plugin/IOptional;", "name", "", "desc", "enable", "", "checkTypes", "Ljava/util/LinkedHashSet;", "Lcn/sast/framework/plugin/CheckersConfig$CheckTypeConfig;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/LinkedHashSet;)V", "checker", "Lcom/feysh/corax/config/api/IChecker;", "(Lcom/feysh/corax/config/api/IChecker;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ZLjava/util/LinkedHashSet;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getDesc", "getEnable", "()Z", "getCheckTypes", "()Ljava/util/LinkedHashSet;", "setCheckTypes", "(Ljava/util/LinkedHashSet;)V", "sort", "compareTo", "other", "component1", "component2", "component3", "component4", "copy", "equals", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "CheckTypeConfig", "$serializer", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nSAConfiguration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SAConfiguration.kt\ncn/sast/framework/plugin/CheckersConfig\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,557:1\n1#2:558\n*E\n"})
public final class CheckersConfig
extends ConfigSerializable
implements IOptional {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String name;
    @Nullable
    private final String desc;
    private final boolean enable;
    @NotNull
    private LinkedHashSet<CheckTypeConfig> checkTypes;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public CheckersConfig(@NotNull String name, @Nullable String desc, boolean enable, @NotNull LinkedHashSet<CheckTypeConfig> checkTypes) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(checkTypes, (String)"checkTypes");
        super(null);
        this.name = name;
        this.desc = desc;
        this.enable = enable;
        this.checkTypes = checkTypes;
    }

    public /* synthetic */ CheckersConfig(String string, String string2, boolean bl, LinkedHashSet linkedHashSet, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            string2 = null;
        }
        if ((n & 8) != 0) {
            linkedHashSet = new LinkedHashSet();
        }
        this(string, string2, bl, linkedHashSet);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    public boolean getEnable() {
        return this.enable;
    }

    @NotNull
    public final LinkedHashSet<CheckTypeConfig> getCheckTypes() {
        return this.checkTypes;
    }

    public final void setCheckTypes(@NotNull LinkedHashSet<CheckTypeConfig> linkedHashSet) {
        Intrinsics.checkNotNullParameter(linkedHashSet, (String)"<set-?>");
        this.checkTypes = linkedHashSet;
    }

    public CheckersConfig(@NotNull IChecker checker) {
        Intrinsics.checkNotNullParameter((Object)checker, (String)"checker");
        this(UtilsKt.getSootTypeName(checker.getClass()), checker.getDesc(), true, null, 8, null);
    }

    @NotNull
    public final CheckersConfig sort() {
        this.checkTypes = (LinkedHashSet)CollectionsKt.toCollection((Iterable)CollectionsKt.sorted((Iterable)this.checkTypes), (Collection)new LinkedHashSet());
        return this;
    }

    public int compareTo(@NotNull ConfigSerializable other) {
        Integer n;
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        if (!(other instanceof CheckersConfig)) {
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
        if (this.getEnable() != ((CheckersConfig)other).getEnable()) {
            return this.getEnable() ? -1 : 1;
        }
        return 0;
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final String component2() {
        return this.desc;
    }

    public final boolean component3() {
        return this.enable;
    }

    @NotNull
    public final LinkedHashSet<CheckTypeConfig> component4() {
        return this.checkTypes;
    }

    @NotNull
    public final CheckersConfig copy(@NotNull String name, @Nullable String desc, boolean enable, @NotNull LinkedHashSet<CheckTypeConfig> checkTypes) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(checkTypes, (String)"checkTypes");
        return new CheckersConfig(name, desc, enable, checkTypes);
    }

    public static /* synthetic */ CheckersConfig copy$default(CheckersConfig checkersConfig, String string, String string2, boolean bl, LinkedHashSet linkedHashSet, int n, Object object) {
        if ((n & 1) != 0) {
            string = checkersConfig.name;
        }
        if ((n & 2) != 0) {
            string2 = checkersConfig.desc;
        }
        if ((n & 4) != 0) {
            bl = checkersConfig.enable;
        }
        if ((n & 8) != 0) {
            linkedHashSet = checkersConfig.checkTypes;
        }
        return checkersConfig.copy(string, string2, bl, linkedHashSet);
    }

    @NotNull
    public String toString() {
        return "CheckersConfig(name=" + this.name + ", desc=" + this.desc + ", enable=" + this.enable + ", checkTypes=" + this.checkTypes + ")";
    }

    public int hashCode() {
        int result = this.name.hashCode();
        result = result * 31 + (this.desc == null ? 0 : this.desc.hashCode());
        result = result * 31 + Boolean.hashCode(this.enable);
        result = result * 31 + this.checkTypes.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckersConfig)) {
            return false;
        }
        CheckersConfig checkersConfig = (CheckersConfig)other;
        if (!Intrinsics.areEqual((Object)this.name, (Object)checkersConfig.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.desc, (Object)checkersConfig.desc)) {
            return false;
        }
        if (this.enable != checkersConfig.enable) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.checkTypes, (Object)checkersConfig.checkTypes);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(CheckersConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        ConfigSerializable.write$Self((ConfigSerializable)((ConfigSerializable)self), (CompositeEncoder)output, (SerialDescriptor)serialDesc);
        KSerializer[] kSerializerArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.getName());
        if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : self.desc != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.desc);
        }
        output.encodeBooleanElement(serialDesc, 2, self.getEnable());
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : !Intrinsics.areEqual((Object)self.checkTypes, new LinkedHashSet())) {
            output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy)kSerializerArray[3], (Object)self.checkTypes);
        }
    }

    public /* synthetic */ CheckersConfig(int seen0, String name, String desc, boolean enable, LinkedHashSet checkTypes, SerializationConstructorMarker serializationConstructorMarker) {
        if (5 != (5 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)5, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        super(seen0, serializationConstructorMarker);
        this.name = name;
        this.desc = (seen0 & 2) == 0 ? null : desc;
        this.enable = enable;
        this.checkTypes = (seen0 & 8) == 0 ? new LinkedHashSet() : checkTypes;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{null, null, null, new LinkedHashSetSerializer((KSerializer)CheckTypeConfig$$serializer.INSTANCE)};
        $childSerializers = kSerializerArray;
    }
}

