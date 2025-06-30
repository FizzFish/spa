/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerializationException
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.descriptors.SerialDescriptorsKt
 *  kotlinx.serialization.descriptors.SerialKind
 *  kotlinx.serialization.descriptors.StructureKind$OBJECT
 *  kotlinx.serialization.encoding.CompositeDecoder
 *  kotlinx.serialization.encoding.Decoder
 *  kotlinx.serialization.encoding.Encoder
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0017J\u0015\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u001aH\u0016\u00a2\u0006\u0002\u0010\u001bR\u0010\u0010\u0006\u001a\u00028\u0000X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\tR!\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2={"Lcom/feysh/corax/config/api/ObjectSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serialName", "", "objectInstance", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "Ljava/lang/Object;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "()V", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "corax-config-api"})
@PublishedApi
@SourceDebugExtension(value={"SMAP\nAIAnalysisApi.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIAnalysisApi.kt\ncom/feysh/corax/config/api/ObjectSerializer\n+ 2 Decoding.kt\nkotlinx/serialization/encoding/DecodingKt\n*L\n1#1,839:1\n565#2,4:840\n*S KotlinDebug\n*F\n+ 1 AIAnalysisApi.kt\ncom/feysh/corax/config/api/ObjectSerializer\n*L\n114#1:840,4\n*E\n"})
public final class ObjectSerializer<T>
implements KSerializer<T> {
    @NotNull
    private final T objectInstance;
    @NotNull
    private final Lazy descriptor$delegate;

    public ObjectSerializer(@NotNull String serialName, @NotNull T objectInstance) {
        Intrinsics.checkNotNullParameter((Object)serialName, (String)"serialName");
        Intrinsics.checkNotNullParameter(objectInstance, (String)"objectInstance");
        this.objectInstance = objectInstance;
        this.descriptor$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> ObjectSerializer.descriptor_delegate$lambda$0(serialName));
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        Lazy lazy = this.descriptor$delegate;
        return (SerialDescriptor)lazy.getValue();
    }

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    public void serialize(@NotNull Encoder encoder, @NotNull T value) {
        Intrinsics.checkNotNullParameter((Object)encoder, (String)"encoder");
        Intrinsics.checkNotNullParameter(value, (String)"value");
        encoder.beginStructure(this.getDescriptor()).endStructure(this.getDescriptor());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public T deserialize(@NotNull Decoder decoder) {
        void $this$decodeStructure$iv;
        CompositeDecoder composite$iv;
        Intrinsics.checkNotNullParameter((Object)decoder, (String)"decoder");
        Decoder decoder2 = decoder;
        SerialDescriptor descriptor$iv = this.getDescriptor();
        boolean $i$f$decodeStructure = false;
        CompositeDecoder $this$deserialize_u24lambda_u241 = composite$iv = $this$decodeStructure$iv.beginStructure(descriptor$iv);
        boolean bl = false;
        int index = $this$deserialize_u24lambda_u241.decodeElementIndex(this.getDescriptor());
        if (index != -1) {
            throw new SerializationException("Unexpected index " + index);
        }
        Unit result$iv = Unit.INSTANCE;
        composite$iv.endStructure(descriptor$iv);
        return this.objectInstance;
    }

    private static final SerialDescriptor descriptor_delegate$lambda$0(String $serialName) {
        return SerialDescriptorsKt.buildSerialDescriptor$default((String)$serialName, (SerialKind)((SerialKind)StructureKind.OBJECT.INSTANCE), (SerialDescriptor[])new SerialDescriptor[0], null, (int)8, null);
    }
}

