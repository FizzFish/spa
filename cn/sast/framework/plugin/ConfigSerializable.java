/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.plugin.CheckerUnitOptionalConfig
 *  cn.sast.framework.plugin.CheckerUnitOptionalConfig$$serializer
 *  cn.sast.framework.plugin.CheckersConfig
 *  cn.sast.framework.plugin.CheckersConfig$$serializer
 *  cn.sast.framework.plugin.ConfigSerializable
 *  cn.sast.framework.plugin.ConfigSerializable$Companion
 *  cn.sast.framework.plugin.IConfig
 *  cn.sast.framework.plugin.SootOptionsConfig
 *  cn.sast.framework.plugin.SootOptionsConfig$$serializer
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SealedClassSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.plugin;

import cn.sast.framework.plugin.CheckerUnitOptionalConfig;
import cn.sast.framework.plugin.CheckerUnitOptionalConfig$;
import cn.sast.framework.plugin.CheckersConfig;
import cn.sast.framework.plugin.CheckersConfig$;
import cn.sast.framework.plugin.ConfigSerializable;
import cn.sast.framework.plugin.IConfig;
import cn.sast.framework.plugin.SootOptionsConfig;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0017B\t\b\u0004\u00a2\u0006\u0004\b\u0003\u0010\u0004B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0003\u0010\tJ\u0011\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0000H\u0096\u0002J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007R\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0001\u0003\u0018\u0019\u001a\u00a8\u0006\u001b"}, d2={"Lcn/sast/framework/plugin/ConfigSerializable;", "Lcn/sast/framework/plugin/IConfig;", "", "<init>", "()V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "name", "", "getName", "()Ljava/lang/String;", "compareTo", "other", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Companion", "Lcn/sast/framework/plugin/CheckerUnitOptionalConfig;", "Lcn/sast/framework/plugin/CheckersConfig;", "Lcn/sast/framework/plugin/SootOptionsConfig;", "corax-framework"})
public abstract class ConfigSerializable
implements IConfig,
Comparable<ConfigSerializable> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> {
        KClass[] kClassArray = new KClass[]{Reflection.getOrCreateKotlinClass(CheckerUnitOptionalConfig.class), Reflection.getOrCreateKotlinClass(CheckersConfig.class), Reflection.getOrCreateKotlinClass(SootOptionsConfig.class)};
        KClass[] kClassArray2 = kClassArray;
        kClassArray = new KSerializer[]{CheckerUnitOptionalConfig$.serializer.INSTANCE, CheckersConfig$.serializer.INSTANCE, SootOptionsConfig.$serializer.INSTANCE};
        return (KSerializer)new SealedClassSerializer("cn.sast.framework.plugin.ConfigSerializable", Reflection.getOrCreateKotlinClass(ConfigSerializable.class), kClassArray2, (KSerializer[])kClassArray, new Annotation[0]);
    });

    private ConfigSerializable() {
    }

    @NotNull
    public abstract String getName();

    @Override
    public int compareTo(@NotNull ConfigSerializable other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        String string = other.getClass().getName();
        String string2 = this.getClass().getName();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getName(...)");
        int compare = string.compareTo(string2);
        if (compare == 0) {
            return this.getName().compareTo(other.getName());
        }
        return 0;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(ConfigSerializable self, CompositeEncoder output, SerialDescriptor serialDesc) {
    }

    public /* synthetic */ ConfigSerializable(int seen0, SerializationConstructorMarker serializationConstructorMarker) {
    }

    public /* synthetic */ ConfigSerializable(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }
}

