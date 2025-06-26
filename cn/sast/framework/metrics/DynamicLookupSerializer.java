/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.metrics.DynamicLookupSerializer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 *  kotlinx.serialization.ContextualSerializer
 *  kotlinx.serialization.ExperimentalSerializationApi
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.SerializersKt
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.Decoder
 *  kotlinx.serialization.encoding.Encoder
 *  kotlinx.serialization.modules.SerializersModule
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.metrics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;

@ExperimentalSerializationApi
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2={"Lcn/sast/framework/metrics/DynamicLookupSerializer;", "Lkotlinx/serialization/KSerializer;", "", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "corax-framework"})
public final class DynamicLookupSerializer
implements KSerializer<Object> {
    @NotNull
    private final SerialDescriptor descriptor = new ContextualSerializer(Reflection.getOrCreateKotlinClass(Object.class), null, new KSerializer[0]).getDescriptor();

    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public void serialize(@NotNull Encoder encoder, @NotNull Object value) {
        Intrinsics.checkNotNullParameter((Object)encoder, (String)"encoder");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        KSerializer kSerializer = SerializersModule.getContextual$default((SerializersModule)encoder.getSerializersModule(), (KClass)Reflection.getOrCreateKotlinClass(value.getClass()), null, (int)2, null);
        if (kSerializer == null) {
            kSerializer = SerializersKt.serializer((KClass)Reflection.getOrCreateKotlinClass(value.getClass()));
        }
        KSerializer actualSerializer = kSerializer;
        Intrinsics.checkNotNull((Object)actualSerializer, (String)"null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
        encoder.encodeSerializableValue((SerializationStrategy)actualSerializer, value);
    }

    @NotNull
    public Object deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter((Object)decoder, (String)"decoder");
        throw new IllegalStateException("not support yet".toString());
    }
}

