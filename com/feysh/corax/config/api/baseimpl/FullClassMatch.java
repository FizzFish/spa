/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerialName
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  soot.Scene
 *  soot.SootClass
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IClassMatch;
import com.feysh.corax.config.api.baseimpl.FullClassMatch$;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootClass;

@Serializable
@SerialName(value="FullClassMatch")
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0004\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0004\u0010\u000fJ\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001\u00a2\u0006\u0002\b\u001fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2={"Lcom/feysh/corax/config/api/baseimpl/FullClassMatch;", "Lcom/feysh/corax/config/api/IClassMatch;", "className", "", "<init>", "(Ljava/lang/String;)V", "sc", "Lsoot/SootClass;", "(Lsoot/SootClass;)V", "seen0", "", "simpleName", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getClassName", "()Ljava/lang/String;", "matched", "scene", "Lsoot/Scene;", "getSimpleName", "()Ljava/util/List;", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_config_api", "$serializer", "Companion", "corax-config-api"})
public final class FullClassMatch
implements IClassMatch {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String className;
    @NotNull
    private final List<String> simpleName;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public FullClassMatch(@NotNull String className) {
        Intrinsics.checkNotNullParameter((Object)className, (String)"className");
        this.className = className;
        this.simpleName = CollectionsKt.listOf((Object)StringsKt.substringAfterLast$default((String)this.className, (String)".", null, (int)2, null));
    }

    @NotNull
    public final String getClassName() {
        return this.className;
    }

    public FullClassMatch(@NotNull SootClass sc) {
        Intrinsics.checkNotNullParameter((Object)sc, (String)"sc");
        String string = sc.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        this(string);
    }

    @Override
    @NotNull
    public List<SootClass> matched(@NotNull Scene scene) {
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        SootClass sootClass = Scene.v().getSootClassUnsafe(this.className, false);
        if (sootClass == null) {
            return CollectionsKt.emptyList();
        }
        SootClass sc = sootClass;
        return CollectionsKt.listOf((Object)sc);
    }

    @Override
    @NotNull
    public List<String> getSimpleName() {
        return this.simpleName;
    }

    @NotNull
    public String toString() {
        return this.className;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_config_api(FullClassMatch self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.className);
        if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : !Intrinsics.areEqual(self.getSimpleName(), (Object)CollectionsKt.listOf((Object)StringsKt.substringAfterLast$default((String)self.className, (String)".", null, (int)2, null)))) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)kSerializerArray[1], self.getSimpleName());
        }
    }

    public /* synthetic */ FullClassMatch(int seen0, String className, List simpleName, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.className = className;
        this.simpleName = (seen0 & 2) == 0 ? CollectionsKt.listOf((Object)StringsKt.substringAfterLast$default((String)this.className, (String)".", null, (int)2, null)) : simpleName;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{null, new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE)};
        $childSerializers = kSerializerArray;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Lcom/feysh/corax/config/api/baseimpl/FullClassMatch$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/feysh/corax/config/api/baseimpl/FullClassMatch;", "corax-config-api"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<FullClassMatch> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

