/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.engine.SootMethodSerializer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializer
 *  kotlinx.serialization.descriptors.PrimitiveKind
 *  kotlinx.serialization.descriptors.PrimitiveKind$STRING
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.descriptors.SerialDescriptorsKt
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.encoding.Decoder
 *  kotlinx.serialization.encoding.Encoder
 *  org.jetbrains.annotations.NotNull
 *  soot.SootMethod
 */
package cn.sast.framework.engine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2={"Lcn/sast/framework/engine/SootMethodSerializer;", "Lkotlinx/serialization/KSerializer;", "Lsoot/SootMethod;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "corax-framework"})
@Serializer(forClass=SootMethod.class)
@SourceDebugExtension(value={"SMAP\nIPAnalysisEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IPAnalysisEngine.kt\ncn/sast/framework/engine/SootMethodSerializer\n+ 2 Encoding.kt\nkotlinx/serialization/encoding/EncodingKt\n*L\n1#1,344:1\n475#2,4:345\n*S KotlinDebug\n*F\n+ 1 IPAnalysisEngine.kt\ncn/sast/framework/engine/SootMethodSerializer\n*L\n69#1:345,4\n*E\n"})
public final class SootMethodSerializer
implements KSerializer<SootMethod> {
    @NotNull
    public static final SootMethodSerializer INSTANCE = new SootMethodSerializer();
    @NotNull
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor((String)"SootMethod", (PrimitiveKind)((PrimitiveKind)PrimitiveKind.STRING.INSTANCE));

    private SootMethodSerializer() {
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @NotNull
    public SootMethod deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter((Object)decoder, (String)"decoder");
        throw new IllegalStateException("Not yet implemented".toString());
    }

    /*
     * WARNING - void declaration
     */
    public void serialize(@NotNull Encoder encoder, @NotNull SootMethod value) {
        void $this$encodeStructure$iv;
        CompositeEncoder composite$iv;
        Intrinsics.checkNotNullParameter((Object)encoder, (String)"encoder");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Encoder encoder2 = encoder;
        SerialDescriptor descriptor$iv = this.getDescriptor();
        boolean $i$f$encodeStructure = false;
        CompositeEncoder $this$serialize_u24lambda_u240 = composite$iv = $this$encodeStructure$iv.beginStructure(descriptor$iv);
        boolean bl = false;
        String string = value.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        encoder.encodeString(string);
        composite$iv.endStructure(descriptor$iv);
    }
}

