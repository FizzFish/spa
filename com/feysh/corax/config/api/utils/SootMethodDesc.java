/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.Type
 */
package com.feysh.corax.config.api.utils;

import com.feysh.corax.config.api.utils.IMethodDescriptor;
import com.feysh.corax.config.api.utils.SootMethodDesc$;
import com.feysh.corax.config.api.utils.UtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Type;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002,-B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\u0004\b\b\u0010\tBI\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\b\u0010\u000eJ\b\u0010\u0019\u001a\u00020\u0003H\u0016J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J7\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u00d6\u0003J\t\u0010#\u001a\u00020\u000bH\u00d6\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001\u00a2\u0006\u0002\b+R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00038FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006."}, d2={"Lcom/feysh/corax/config/api/utils/SootMethodDesc;", "Lcom/feysh/corax/config/api/utils/IMethodDescriptor;", "clazz", "", "name", "returnType", "parameters", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getClazz", "()Ljava/lang/String;", "getName", "getReturnType", "getParameters", "()Ljava/util/List;", "signature", "getSignature", "signature$delegate", "Lkotlin/Lazy;", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_config_api", "Companion", "$serializer", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/feysh/corax/config/api/utils/SootMethodDesc\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,484:1\n1#2:485\n*E\n"})
public final class SootMethodDesc
implements IMethodDescriptor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String clazz;
    @NotNull
    private final String name;
    @NotNull
    private final String returnType;
    @NotNull
    private final List<String> parameters;
    @NotNull
    private final Lazy signature$delegate;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;
    @NotNull
    private static final Pattern patternMethodSig;

    public SootMethodDesc(@NotNull String clazz, @NotNull String name, @NotNull String returnType, @NotNull List<String> parameters) {
        Intrinsics.checkNotNullParameter((Object)clazz, (String)"clazz");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)returnType, (String)"returnType");
        Intrinsics.checkNotNullParameter(parameters, (String)"parameters");
        this.clazz = clazz;
        this.name = name;
        this.returnType = returnType;
        this.parameters = parameters;
        if (!(StringsKt.indexOf$default((CharSequence)this.getClazz(), (char)'/', (int)0, (boolean)false, (int)6, null) == -1)) {
            boolean bl = false;
            String string = "invalid format clazz: " + this.getClazz();
            throw new IllegalArgumentException(string.toString());
        }
        this.signature$delegate = LazyKt.lazy(() -> SootMethodDesc.signature_delegate$lambda$1(this));
    }

    @Override
    @NotNull
    public String getClazz() {
        return this.clazz;
    }

    @Override
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override
    @NotNull
    public String getReturnType() {
        return this.returnType;
    }

    @Override
    @NotNull
    public List<String> getParameters() {
        return this.parameters;
    }

    @NotNull
    public final String getSignature() {
        Lazy lazy = this.signature$delegate;
        return (String)lazy.getValue();
    }

    @NotNull
    public String toString() {
        return this.getSignature();
    }

    @NotNull
    public final String component1() {
        return this.clazz;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.returnType;
    }

    @NotNull
    public final List<String> component4() {
        return this.parameters;
    }

    @NotNull
    public final SootMethodDesc copy(@NotNull String clazz, @NotNull String name, @NotNull String returnType, @NotNull List<String> parameters) {
        Intrinsics.checkNotNullParameter((Object)clazz, (String)"clazz");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)returnType, (String)"returnType");
        Intrinsics.checkNotNullParameter(parameters, (String)"parameters");
        return new SootMethodDesc(clazz, name, returnType, parameters);
    }

    public static /* synthetic */ SootMethodDesc copy$default(SootMethodDesc sootMethodDesc, String string, String string2, String string3, List list, int n, Object object) {
        if ((n & 1) != 0) {
            string = sootMethodDesc.clazz;
        }
        if ((n & 2) != 0) {
            string2 = sootMethodDesc.name;
        }
        if ((n & 4) != 0) {
            string3 = sootMethodDesc.returnType;
        }
        if ((n & 8) != 0) {
            list = sootMethodDesc.parameters;
        }
        return sootMethodDesc.copy(string, string2, string3, list);
    }

    public int hashCode() {
        int result = this.clazz.hashCode();
        result = result * 31 + this.name.hashCode();
        result = result * 31 + this.returnType.hashCode();
        result = result * 31 + ((Object)this.parameters).hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SootMethodDesc)) {
            return false;
        }
        SootMethodDesc sootMethodDesc = (SootMethodDesc)other;
        if (!Intrinsics.areEqual((Object)this.clazz, (Object)sootMethodDesc.clazz)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.name, (Object)sootMethodDesc.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.returnType, (Object)sootMethodDesc.returnType)) {
            return false;
        }
        return Intrinsics.areEqual(this.parameters, sootMethodDesc.parameters);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_config_api(SootMethodDesc self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.getClazz());
        output.encodeStringElement(serialDesc, 1, self.getName());
        output.encodeStringElement(serialDesc, 2, self.getReturnType());
        output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy)kSerializerArray[3], self.getParameters());
    }

    public /* synthetic */ SootMethodDesc(int seen0, String clazz, String name, String returnType, List parameters, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (0xF & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)15, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.clazz = clazz;
        this.name = name;
        this.returnType = returnType;
        this.parameters = parameters;
        if (!(StringsKt.indexOf$default((CharSequence)this.getClazz(), (char)'/', (int)0, (boolean)false, (int)6, null) == -1)) {
            boolean bl = false;
            String string = "invalid format clazz: " + this.getClazz();
            throw new IllegalArgumentException(string.toString());
        }
        this.signature$delegate = LazyKt.lazy(() -> SootMethodDesc._init_$lambda$3(this));
    }

    private static final String signature_delegate$lambda$1(SootMethodDesc this$0) {
        return "<" + this$0.getClazz() + ": " + this$0.getReturnType() + " " + this$0.getName() + "(" + CollectionsKt.joinToString$default((Iterable)this$0.getParameters(), (CharSequence)",", null, null, (int)0, null, null, (int)62, null) + ")>";
    }

    private static final String _init_$lambda$3(SootMethodDesc this$0) {
        return "<" + this$0.getClazz() + ": " + this$0.getReturnType() + " " + this$0.getName() + "(" + CollectionsKt.joinToString$default((Iterable)this$0.getParameters(), (CharSequence)",", null, null, (int)0, null, null, (int)62, null) + ")>";
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{null, null, null, new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE)};
        $childSerializers = kSerializerArray;
        Pattern pattern = Pattern.compile("^<(?<className>.*?): (?<returnType>.*?) (?<methodName>.*?)\\((?<parameters>.*?)\\)>$");
        Intrinsics.checkNotNullExpressionValue((Object)pattern, (String)"compile(...)");
        patternMethodSig = pattern;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0086\u0002J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0002J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lcom/feysh/corax/config/api/utils/SootMethodDesc$Companion;", "", "<init>", "()V", "patternMethodSig", "Ljava/util/regex/Pattern;", "invoke", "Lcom/feysh/corax/config/api/utils/SootMethodDesc;", "parseString", "", "sm", "Lsoot/SootMethod;", "serializer", "Lkotlinx/serialization/KSerializer;", "corax-config-api"})
    @SourceDebugExtension(value={"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/feysh/corax/config/api/utils/SootMethodDesc$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,484:1\n1557#2:485\n1628#2,3:486\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/feysh/corax/config/api/utils/SootMethodDesc$Companion\n*L\n87#1:485\n87#1:486,3\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final SootMethodDesc invoke(@NotNull String parseString) {
            Intrinsics.checkNotNullParameter((Object)parseString, (String)"parseString");
            if (((CharSequence)parseString).length() == 0) {
                return null;
            }
            Matcher matcher = patternMethodSig.matcher(parseString);
            Intrinsics.checkNotNullExpressionValue((Object)matcher, (String)"matcher(...)");
            Matcher matcher2 = matcher;
            if (matcher2.matches()) {
                String className = matcher2.group("className");
                String returnType = matcher2.group("returnType");
                String methodName = matcher2.group("methodName");
                String paramList = matcher2.group("parameters");
                Intrinsics.checkNotNull((Object)className);
                Intrinsics.checkNotNull((Object)methodName);
                Intrinsics.checkNotNull((Object)returnType);
                Intrinsics.checkNotNull((Object)paramList);
                String[] stringArray = new String[]{","};
                return new SootMethodDesc(className, methodName, returnType, StringsKt.split$default((CharSequence)paramList, (String[])stringArray, (boolean)false, (int)0, (int)6, null));
            }
            return null;
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final SootMethodDesc invoke(@NotNull SootMethod sm) {
            Collection<String> collection;
            void $this$mapTo$iv$iv;
            void $this$map$iv;
            Intrinsics.checkNotNullParameter((Object)sm, (String)"sm");
            String string = sm.getDeclaringClass().getName();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
            String string2 = sm.getName();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getName(...)");
            Type type = sm.getReturnType();
            Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getReturnType(...)");
            String string3 = UtilsKt.getTypename(type);
            if (string3 == null) {
                String string4 = sm.getReturnType().toString();
                string3 = string4;
                Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"toString(...)");
            }
            List list = sm.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getParameterTypes(...)");
            Iterable iterable = list;
            String string5 = string3;
            String string6 = string2;
            String string7 = string;
            boolean $i$f$map = false;
            void var4_7 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                Type type2 = (Type)item$iv$iv;
                collection = destination$iv$iv;
                boolean bl = false;
                Intrinsics.checkNotNull((Object)it);
                String string8 = UtilsKt.getTypename((Type)it);
                if (string8 == null) {
                    String string9 = it.toString();
                    string8 = string9;
                    Intrinsics.checkNotNullExpressionValue((Object)string9, (String)"toString(...)");
                }
                collection.add(string8);
            }
            Collection<String> collection2 = collection = (List)destination$iv$iv;
            String string10 = string5;
            String string11 = string6;
            String string12 = string7;
            return new SootMethodDesc(string12, string11, string10, (List<String>)collection2);
        }

        @NotNull
        public final KSerializer<SootMethodDesc> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

