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
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.PolymorphicSerializer
 *  kotlinx.serialization.SerialName
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.Transient
 *  kotlinx.serialization.builtins.BuiltinSerializersKt
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.EnumsKt
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.ArrayType
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.Type
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IClassMatch;
import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.baseimpl.QualifiedRefType;
import com.feysh.corax.config.api.baseimpl.RawSignatureMatch$;
import com.feysh.corax.config.api.utils.KFunctionType;
import com.feysh.corax.config.api.utils.UtilsKt;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.Transient;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;

@Serializable
@SerialName(value="RawSignatureMatch")
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0002GHBE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000b\u0010\fB[\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u000b\u0010\u0011J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00052\u0006\u0010'\u001a\u00020(H\u0016J\u001a\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020&H\u0002J\b\u00104\u001a\u00020\u0006H\u0016J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0013\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\nH\u00c6\u0003JO\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\u0013\u0010;\u001a\u00020*2\b\u0010<\u001a\u0004\u0018\u00010=H\u00d6\u0003J\t\u0010>\u001a\u00020\u000eH\u00d6\u0001J%\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0001\u00a2\u0006\u0002\bFR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u00060\u001cj\u0002`\u001d8\u0016X\u0097\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u001b\u00100\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b1\u0010\u0017\u00a8\u0006I"}, d2={"Lcom/feysh/corax/config/api/baseimpl/RawSignatureMatch;", "Lcom/feysh/corax/config/api/IMethodMatch;", "clazz", "Lcom/feysh/corax/config/api/IClassMatch;", "name", "", "", "returnType", "parameters", "actualType", "Lcom/feysh/corax/config/api/utils/KFunctionType;", "<init>", "(Lcom/feysh/corax/config/api/IClassMatch;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lcom/feysh/corax/config/api/utils/KFunctionType;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/feysh/corax/config/api/IClassMatch;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lcom/feysh/corax/config/api/utils/KFunctionType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getClazz", "()Lcom/feysh/corax/config/api/IClassMatch;", "getName", "()Ljava/util/List;", "getReturnType", "()Ljava/lang/String;", "getParameters", "getActualType", "()Lcom/feysh/corax/config/api/utils/KFunctionType;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getException$annotations", "()V", "getException", "()Ljava/lang/Exception;", "argumentCnt", "getArgumentCnt", "()Ljava/lang/Integer;", "matched", "Lsoot/SootMethod;", "scene", "Lsoot/Scene;", "isMatches", "", "type", "Lsoot/Type;", "t", "match", "sm", "signature", "getSignature", "signature$delegate", "Lkotlin/Lazy;", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_config_api", "Companion", "$serializer", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nMatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Matchers.kt\ncom/feysh/corax/config/api/baseimpl/RawSignatureMatch\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,243:1\n1#2:244\n1734#3,3:245\n1863#3,2:248\n1863#3,2:250\n774#3:252\n865#3,2:253\n1368#3:255\n1454#3,2:256\n774#3:258\n865#3,2:259\n1456#3,3:261\n1872#3,3:264\n1863#3,2:267\n1863#3,2:269\n*S KotlinDebug\n*F\n+ 1 Matchers.kt\ncom/feysh/corax/config/api/baseimpl/RawSignatureMatch\n*L\n227#1:245,3\n228#1:248,2\n233#1:250,2\n161#1:252\n161#1:253,2\n162#1:255\n162#1:256,2\n162#1:258\n162#1:259,2\n162#1:261,3\n195#1:264,3\n228#1:267,2\n233#1:269,2\n*E\n"})
public final class RawSignatureMatch
implements IMethodMatch {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final IClassMatch clazz;
    @NotNull
    private final List<String> name;
    @Nullable
    private final String returnType;
    @Nullable
    private final List<String> parameters;
    @Nullable
    private final KFunctionType actualType;
    @NotNull
    private final Exception exception;
    @NotNull
    private final Lazy signature$delegate;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public RawSignatureMatch(@NotNull IClassMatch clazz, @NotNull List<String> name, @Nullable String returnType, @Nullable List<String> parameters, @Nullable KFunctionType actualType) {
        block9: {
            String it;
            boolean bl;
            List<String> cNames;
            block8: {
                Intrinsics.checkNotNullParameter((Object)clazz, (String)"clazz");
                Intrinsics.checkNotNullParameter(name, (String)"name");
                this.clazz = clazz;
                this.name = name;
                this.returnType = returnType;
                this.parameters = parameters;
                this.actualType = actualType;
                this.exception = new Exception();
                this.signature$delegate = LazyKt.lazy(() -> RawSignatureMatch.signature_delegate$lambda$4(this));
                cNames = this.clazz.getSimpleName();
                if (!(!((Collection)cNames).isEmpty())) {
                    boolean $i$a$-check-RawSignatureMatch$102 = false;
                    String $i$a$-check-RawSignatureMatch$102 = "error syntax: " + this;
                    throw new IllegalStateException($i$a$-check-RawSignatureMatch$102.toString());
                }
                if (!(!((Collection)this.name).isEmpty())) {
                    boolean $i$a$-check-RawSignatureMatch$122 = false;
                    String $i$a$-check-RawSignatureMatch$122 = "error syntax: " + this;
                    throw new IllegalStateException($i$a$-check-RawSignatureMatch$122.toString());
                }
                Iterable $this$all$iv = this.name;
                boolean $i$f$all = false;
                if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                    bl = true;
                } else {
                    for (Object element$iv : $this$all$iv) {
                        it = (String)element$iv;
                        boolean bl2 = false;
                        if (((CharSequence)it).length() > 0) continue;
                        bl = false;
                        break block8;
                    }
                    bl = true;
                }
            }
            if (!bl) {
                boolean $i$a$-check-RawSignatureMatch$132 = false;
                String $i$a$-check-RawSignatureMatch$132 = "error syntax: " + this;
                throw new IllegalStateException($i$a$-check-RawSignatureMatch$132.toString());
            }
            Iterable $this$forEach$iv = cNames;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                it = (String)element$iv;
                boolean bl3 = false;
                if (!this.name.contains(it)) continue;
                throw new IllegalStateException(("This is a constructor: " + this).toString());
            }
            List<String> list = this.parameters;
            if (list == null) break block9;
            Iterable $this$forEach$iv2 = list;
            boolean $i$f$forEach2 = false;
            for (Object element$iv : $this$forEach$iv2) {
                String it2 = (String)element$iv;
                boolean bl4 = false;
                String string = it2;
                boolean bl5 = string != null ? ((CharSequence)string).length() == 0 : false;
                if (!bl5) continue;
                throw new IllegalStateException(("invalid type: " + this).toString());
            }
        }
    }

    public /* synthetic */ RawSignatureMatch(IClassMatch iClassMatch, List list, String string, List list2, KFunctionType kFunctionType, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x10) != 0) {
            kFunctionType = null;
        }
        this(iClassMatch, list, string, list2, kFunctionType);
    }

    @NotNull
    public final IClassMatch getClazz() {
        return this.clazz;
    }

    @NotNull
    public final List<String> getName() {
        return this.name;
    }

    @Nullable
    public final String getReturnType() {
        return this.returnType;
    }

    @Nullable
    public final List<String> getParameters() {
        return this.parameters;
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
    @Nullable
    public Integer getArgumentCnt() {
        Integer n;
        List<String> list = this.parameters;
        boolean bl = list != null ? list.contains("**") : false;
        if (bl) {
            n = null;
        } else {
            List<String> list2 = this.parameters;
            n = list2 != null ? Integer.valueOf(list2.size()) : null;
        }
        return n;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<SootMethod> matched(@NotNull Scene scene) {
        void $this$flatMapTo$iv$iv;
        Iterable $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        Iterable $this$filter$iv = this.clazz.matched(scene);
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            SootClass it = (SootClass)element$iv$iv;
            boolean bl = false;
            if (!(it.resolvingLevel() >= 2)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$flatMap$iv = (List)destination$iv$iv;
        boolean $i$f$flatMap = false;
        $this$filterTo$iv$iv = $this$flatMap$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            void $this$filterTo$iv$iv2;
            SootClass cl = (SootClass)element$iv$iv;
            boolean bl = false;
            List list = cl.getMethods();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getMethods(...)");
            Iterable $this$filter$iv2 = list;
            boolean $i$f$filter2 = false;
            Iterable iterable2 = $this$filter$iv2;
            Collection destination$iv$iv2 = new ArrayList();
            boolean $i$f$filterTo2 = false;
            for (Object element$iv$iv2 : $this$filterTo$iv$iv2) {
                SootMethod it = (SootMethod)element$iv$iv2;
                boolean bl2 = false;
                Intrinsics.checkNotNull((Object)it);
                if (!this.match(it)) continue;
                destination$iv$iv2.add(element$iv$iv2);
            }
            Iterable list$iv$iv = (List)destination$iv$iv2;
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    private final boolean isMatches(Type type, String t) {
        boolean bl;
        if (t == null || Intrinsics.areEqual((Object)t, (Object)"*")) {
            bl = true;
        } else if (Intrinsics.areEqual((Object)type.toString(), (Object)t)) {
            bl = true;
        } else if (type instanceof ArrayType && StringsKt.endsWith$default((String)t, (String)"[]", (boolean)false, (int)2, null)) {
            Type type2 = ((ArrayType)type).getElementType();
            Intrinsics.checkNotNullExpressionValue((Object)type2, (String)"getElementType(...)");
            bl = this.isMatches(type2, StringsKt.substringBefore$default((String)t, (String)"[", null, (int)2, null));
        } else {
            if (((CharSequence)t).length() == 0) {
                throw new IllegalStateException(("invalid type: " + this).toString());
            }
            String string = UtilsKt.getTypename(type);
            if (Intrinsics.areEqual(string != null ? StringsKt.substringAfterLast$default((String)string, (String)".", null, (int)2, null) : null, (Object)t)) {
                bl = true;
            } else {
                String string2 = UtilsKt.getTypename(type);
                bl = Intrinsics.areEqual(string2 != null ? StringsKt.substringAfterLast$default((String)string2, (String)"$", null, (int)2, null) : null, (Object)t);
            }
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    private final boolean match(SootMethod sm) {
        if (!this.name.contains(sm.getName())) {
            return false;
        }
        Type type = sm.getReturnType();
        Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getReturnType(...)");
        if (!this.isMatches(type, this.returnType)) {
            return false;
        }
        if (this.parameters == null) {
            return true;
        }
        int count = 0;
        Iterable $this$forEachIndexed$iv = this.parameters;
        boolean $i$f$forEachIndexed = false;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            void match;
            int n;
            if ((n = index$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String string = (String)item$iv;
            int index = n;
            boolean bl = false;
            if (Intrinsics.areEqual((Object)match, (Object)"**")) {
                return true;
            }
            if (index >= sm.getParameterCount()) {
                return false;
            }
            Type type2 = sm.getParameterType(index);
            if (type2 == null || !this.isMatches(type2, (String)match)) {
                return false;
            }
            ++count;
        }
        return count == sm.getParameterCount();
    }

    @NotNull
    public final String getSignature() {
        Lazy lazy = this.signature$delegate;
        return (String)lazy.getValue();
    }

    @NotNull
    public String toString() {
        return "method match: " + this.getSignature();
    }

    @NotNull
    public final IClassMatch component1() {
        return this.clazz;
    }

    @NotNull
    public final List<String> component2() {
        return this.name;
    }

    @Nullable
    public final String component3() {
        return this.returnType;
    }

    @Nullable
    public final List<String> component4() {
        return this.parameters;
    }

    @Nullable
    public final KFunctionType component5() {
        return this.actualType;
    }

    @NotNull
    public final RawSignatureMatch copy(@NotNull IClassMatch clazz, @NotNull List<String> name, @Nullable String returnType, @Nullable List<String> parameters, @Nullable KFunctionType actualType) {
        Intrinsics.checkNotNullParameter((Object)clazz, (String)"clazz");
        Intrinsics.checkNotNullParameter(name, (String)"name");
        return new RawSignatureMatch(clazz, name, returnType, parameters, actualType);
    }

    public static /* synthetic */ RawSignatureMatch copy$default(RawSignatureMatch rawSignatureMatch, IClassMatch iClassMatch, List list, String string, List list2, KFunctionType kFunctionType, int n, Object object) {
        if ((n & 1) != 0) {
            iClassMatch = rawSignatureMatch.clazz;
        }
        if ((n & 2) != 0) {
            list = rawSignatureMatch.name;
        }
        if ((n & 4) != 0) {
            string = rawSignatureMatch.returnType;
        }
        if ((n & 8) != 0) {
            list2 = rawSignatureMatch.parameters;
        }
        if ((n & 0x10) != 0) {
            kFunctionType = rawSignatureMatch.actualType;
        }
        return rawSignatureMatch.copy(iClassMatch, list, string, list2, kFunctionType);
    }

    public int hashCode() {
        int result = this.clazz.hashCode();
        result = result * 31 + ((Object)this.name).hashCode();
        result = result * 31 + (this.returnType == null ? 0 : this.returnType.hashCode());
        result = result * 31 + (this.parameters == null ? 0 : ((Object)this.parameters).hashCode());
        result = result * 31 + (this.actualType == null ? 0 : this.actualType.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RawSignatureMatch)) {
            return false;
        }
        RawSignatureMatch rawSignatureMatch = (RawSignatureMatch)other;
        if (!Intrinsics.areEqual((Object)this.clazz, (Object)rawSignatureMatch.clazz)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.name, rawSignatureMatch.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.returnType, (Object)rawSignatureMatch.returnType)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.parameters, rawSignatureMatch.parameters)) {
            return false;
        }
        return this.actualType == rawSignatureMatch.actualType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_config_api(RawSignatureMatch self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArray = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)kSerializerArray[0], (Object)self.clazz);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)kSerializerArray[1], self.name);
        output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.returnType);
        output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)kSerializerArray[3], self.parameters);
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : self.getActualType() != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy)kSerializerArray[4], (Object)self.getActualType());
        }
    }

    public /* synthetic */ RawSignatureMatch(int seen0, IClassMatch clazz, List name, String returnType, List parameters, KFunctionType actualType, SerializationConstructorMarker serializationConstructorMarker) {
        String it;
        boolean bl;
        List<String> cNames;
        block10: {
            if (15 != (0xF & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)15, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
            }
            this.clazz = clazz;
            this.name = name;
            this.returnType = returnType;
            this.parameters = parameters;
            this.actualType = (seen0 & 0x10) == 0 ? null : actualType;
            this.exception = new Exception();
            this.signature$delegate = LazyKt.lazy(() -> RawSignatureMatch._init_$lambda$11(this));
            cNames = this.clazz.getSimpleName();
            if (!(!((Collection)cNames).isEmpty())) {
                boolean $i$a$-check-RawSignatureMatch$102 = false;
                String $i$a$-check-RawSignatureMatch$102 = "error syntax: " + this;
                throw new IllegalStateException($i$a$-check-RawSignatureMatch$102.toString());
            }
            if (!(!((Collection)this.name).isEmpty())) {
                boolean $i$a$-check-RawSignatureMatch$122 = false;
                String $i$a$-check-RawSignatureMatch$122 = "error syntax: " + this;
                throw new IllegalStateException($i$a$-check-RawSignatureMatch$122.toString());
            }
            Iterable $this$all$iv = this.name;
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    it = (String)element$iv;
                    boolean bl2 = false;
                    if (((CharSequence)it).length() > 0) continue;
                    bl = false;
                    break block10;
                }
                bl = true;
            }
        }
        if (!bl) {
            boolean $i$a$-check-RawSignatureMatch$132 = false;
            String $i$a$-check-RawSignatureMatch$132 = "error syntax: " + this;
            throw new IllegalStateException($i$a$-check-RawSignatureMatch$132.toString());
        }
        Iterable $this$forEach$iv = cNames;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            it = (String)element$iv;
            boolean bl3 = false;
            if (!this.name.contains(it)) continue;
            throw new IllegalStateException(("This is a constructor: " + this).toString());
        }
        List<String> list = this.parameters;
        if (list != null) {
            Iterable $this$forEach$iv2 = list;
            boolean $i$f$forEach2 = false;
            for (Object element$iv : $this$forEach$iv2) {
                String it2 = (String)element$iv;
                boolean bl4 = false;
                String string = it2;
                boolean bl5 = string != null ? ((CharSequence)string).length() == 0 : false;
                if (!bl5) continue;
                throw new IllegalStateException(("invalid type: " + this).toString());
            }
        }
    }

    private static final String signature_delegate$lambda$4(RawSignatureMatch this$0) {
        Object object;
        String nameString = this$0.name.size() == 1 ? (String)CollectionsKt.first(this$0.name) : CollectionsKt.joinToString$default((Iterable)this$0.name, (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", (int)0, null, null, (int)56, null);
        IClassMatch iClassMatch = this$0.clazz;
        String string = this$0.returnType;
        if (string == null) {
            string = "*";
        }
        if ((object = this$0.parameters) == null || (object = CollectionsKt.joinToString$default((Iterable)((Iterable)object), (CharSequence)",", null, null, (int)0, null, null, (int)62, null)) == null) {
            object = "**";
        }
        return "^" + iClassMatch + ": " + string + " " + nameString + "(" + (String)object + ")";
    }

    private static final String _init_$lambda$11(RawSignatureMatch this$0) {
        Object object;
        String nameString = this$0.name.size() == 1 ? (String)CollectionsKt.first(this$0.name) : CollectionsKt.joinToString$default((Iterable)this$0.name, (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", (int)0, null, null, (int)56, null);
        IClassMatch iClassMatch = this$0.clazz;
        String string = this$0.returnType;
        if (string == null) {
            string = "*";
        }
        if ((object = this$0.parameters) == null || (object = CollectionsKt.joinToString$default((Iterable)((Iterable)object), (CharSequence)",", null, null, (int)0, null, null, (int)62, null)) == null) {
            object = "**";
        }
        return "^" + iClassMatch + ": " + string + " " + nameString + "(" + (String)object + ")";
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(IClassMatch.class), new Annotation[0]), new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), null, new ArrayListSerializer(BuiltinSerializersKt.getNullable((KSerializer)((KSerializer)StringSerializer.INSTANCE))), EnumsKt.createSimpleEnumSerializer((String)"com.feysh.corax.config.api.utils.KFunctionType", (Enum[])KFunctionType.values())};
        $childSerializers = kSerializerArray;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0086\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f\u00a8\u0006\u0010"}, d2={"Lcom/feysh/corax/config/api/baseimpl/RawSignatureMatch$Companion;", "", "<init>", "()V", "invoke", "Lcom/feysh/corax/config/api/baseimpl/RawSignatureMatch;", "clazz", "", "name", "returnType", "parameters", "", "actualType", "Lcom/feysh/corax/config/api/utils/KFunctionType;", "serializer", "Lkotlinx/serialization/KSerializer;", "corax-config-api"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final RawSignatureMatch invoke(@NotNull String clazz, @NotNull String name, @Nullable String returnType, @Nullable List<String> parameters, @Nullable KFunctionType actualType) {
            Intrinsics.checkNotNullParameter((Object)clazz, (String)"clazz");
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            return new RawSignatureMatch(new QualifiedRefType(clazz), CollectionsKt.listOf((Object)name), returnType, parameters, actualType);
        }

        public static /* synthetic */ RawSignatureMatch invoke$default(Companion companion, String string, String string2, String string3, List list, KFunctionType kFunctionType, int n, Object object) {
            if ((n & 0x10) != 0) {
                kFunctionType = null;
            }
            return companion.invoke(string, string2, string3, list, kFunctionType);
        }

        @NotNull
        public final KSerializer<RawSignatureMatch> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

