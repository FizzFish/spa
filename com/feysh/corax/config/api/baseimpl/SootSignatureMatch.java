/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Function
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KCallable
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerialName
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.Transient
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.EnumsKt
 *  kotlinx.serialization.internal.IntSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Scene
 *  soot.SootMethod
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.baseimpl.SootSignatureMatch$;
import com.feysh.corax.config.api.utils.KFunctionType;
import com.feysh.corax.config.api.utils.SootMethodDesc;
import com.feysh.corax.config.api.utils.SootMethodDesc$;
import com.feysh.corax.config.api.utils.UtilsKt;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootMethod;

@Serializable
@SerialName(value="SootSignatureMatch")
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002+,B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\b\u0010\rJ\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001\u00a2\u0006\u0002\b*R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u00060\u0016j\u0002`\u00178\u0016X\u0097\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006-"}, d2={"Lcom/feysh/corax/config/api/baseimpl/SootSignatureMatch;", "Lcom/feysh/corax/config/api/IMethodMatch;", "sm", "Lcom/feysh/corax/config/api/utils/SootMethodDesc;", "argumentCnt", "", "actualType", "Lcom/feysh/corax/config/api/utils/KFunctionType;", "<init>", "(Lcom/feysh/corax/config/api/utils/SootMethodDesc;Ljava/lang/Integer;Lcom/feysh/corax/config/api/utils/KFunctionType;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/feysh/corax/config/api/utils/SootMethodDesc;Ljava/lang/Integer;Lcom/feysh/corax/config/api/utils/KFunctionType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSm", "()Lcom/feysh/corax/config/api/utils/SootMethodDesc;", "getArgumentCnt", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActualType", "()Lcom/feysh/corax/config/api/utils/KFunctionType;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getException$annotations", "()V", "getException", "()Ljava/lang/Exception;", "matched", "", "Lsoot/SootMethod;", "scene", "Lsoot/Scene;", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_config_api", "Companion", "$serializer", "corax-config-api"})
public final class SootSignatureMatch
implements IMethodMatch {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final SootMethodDesc sm;
    @Nullable
    private final Integer argumentCnt;
    @Nullable
    private final KFunctionType actualType;
    @NotNull
    private final Exception exception;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public SootSignatureMatch(@NotNull SootMethodDesc sm, @Nullable Integer argumentCnt, @Nullable KFunctionType actualType) {
        Intrinsics.checkNotNullParameter((Object)sm, (String)"sm");
        this.sm = sm;
        this.argumentCnt = argumentCnt;
        this.actualType = actualType;
        this.exception = new Exception();
    }

    @NotNull
    public final SootMethodDesc getSm() {
        return this.sm;
    }

    @Override
    @Nullable
    public Integer getArgumentCnt() {
        return this.argumentCnt;
    }

    @Override
    @Nullable
    public KFunctionType getActualType() {
        return this.actualType;
    }

    @Override
    @NotNull
    public Exception getException() {
        return this.exception;
    }

    @Transient
    public static /* synthetic */ void getException$annotations() {
    }

    @Override
    @NotNull
    public List<SootMethod> matched(@NotNull Scene scene) {
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        SootMethod sootMethod = scene.grabMethod(this.sm.getSignature());
        if (sootMethod == null) {
            return CollectionsKt.emptyList();
        }
        SootMethod sm = sootMethod;
        if (this.getActualType() != null) {
            if (sm.isConstructor() && this.getActualType() != KFunctionType.Constructor) {
                return CollectionsKt.emptyList();
            }
            if (sm.isStatic() && this.getActualType() != KFunctionType.StaticMethod) {
                return CollectionsKt.emptyList();
            }
            if (!(sm.isStatic() || sm.isConstructor() || sm.isStaticInitializer() || this.getActualType() == KFunctionType.InstanceMethod)) {
                return CollectionsKt.emptyList();
            }
        }
        return CollectionsKt.listOf((Object)sm);
    }

    @NotNull
    public String toString() {
        return "match sootMethod: " + this.sm;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_config_api(SootSignatureMatch self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArray = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)SootMethodDesc$.serializer.INSTANCE, (Object)self.sm);
        output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy)IntSerializer.INSTANCE, (Object)self.getArgumentCnt());
        output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy)kSerializerArray[2], (Object)self.getActualType());
    }

    public /* synthetic */ SootSignatureMatch(int seen0, SootMethodDesc sm, Integer argumentCnt, KFunctionType actualType, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (7 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)7, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.sm = sm;
        this.argumentCnt = argumentCnt;
        this.actualType = actualType;
        this.exception = new Exception();
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{null, null, EnumsKt.createSimpleEnumSerializer((String)"com.feysh.corax.config.api.utils.KFunctionType", (Enum[])KFunctionType.values())};
        $childSerializers = kSerializerArray;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\u0086\u0002J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0086\u0002J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u00a8\u0006\u000f"}, d2={"Lcom/feysh/corax/config/api/baseimpl/SootSignatureMatch$Companion;", "", "<init>", "()V", "invoke", "Lcom/feysh/corax/config/api/baseimpl/SootSignatureMatch;", "R", "function", "Lkotlin/Function;", "sootSig", "", "sm", "Lsoot/SootMethod;", "serializer", "Lkotlinx/serialization/KSerializer;", "corax-config-api"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final <R> SootSignatureMatch invoke(@NotNull Function<? extends R> function) {
            Intrinsics.checkNotNullParameter(function, (String)"function");
            KCallable call = (KCallable)function;
            String sootSig = UtilsKt.getSootSignature(call);
            SootMethodDesc sootMethodDesc = SootMethodDesc.Companion.invoke(sootSig);
            if (sootMethodDesc == null) {
                throw new IllegalStateException(("invalid soot signature: " + sootSig).toString());
            }
            SootMethodDesc sm = sootMethodDesc;
            return new SootSignatureMatch(sm, UtilsKt.getSootParamStringList(call).size(), UtilsKt.getFunctionType(call));
        }

        @NotNull
        public final SootSignatureMatch invoke(@NotNull String sootSig) {
            Intrinsics.checkNotNullParameter((Object)sootSig, (String)"sootSig");
            SootMethodDesc sootMethodDesc = SootMethodDesc.Companion.invoke(sootSig);
            if (sootMethodDesc == null) {
                throw new IllegalStateException(("invalid soot signature: " + sootSig).toString());
            }
            SootMethodDesc sm = sootMethodDesc;
            return new SootSignatureMatch(sm, sm.getParameters().size(), null);
        }

        @NotNull
        public final SootSignatureMatch invoke(@NotNull SootMethod sm) {
            Intrinsics.checkNotNullParameter((Object)sm, (String)"sm");
            SootMethodDesc smd = SootMethodDesc.Companion.invoke(sm);
            return new SootSignatureMatch(smd, sm.getParameterCount(), UtilsKt.getFunctionType(sm));
        }

        @NotNull
        public final KSerializer<SootSignatureMatch> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

