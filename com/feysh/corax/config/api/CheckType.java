/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.PolymorphicSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.LinkedHashSetSerializer
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.IChecker;
import com.feysh.corax.config.api.IRule;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.ObjectSerializer;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 02\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003B+\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0002\u0010\u000bJ\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u001f2\u0006\u0010 \u001a\u00020\bJ\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00000'J\b\u0010(\u001a\u00020\bH\u0016J \u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0007R\u0012\u0010\f\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0014\u0010!\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010#\u00a8\u00061\u0080\u00e5\b\u0006"}, d2={"Lcom/feysh/corax/config/api/CheckType;", "", "<init>", "()V", "seen0", "", "aliasNames", "", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Set;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "checker", "Lcom/feysh/corax/config/api/IChecker;", "getChecker", "()Lcom/feysh/corax/config/api/IChecker;", "getAliasNames", "()Ljava/util/Set;", "bugMessage", "", "Lcom/feysh/corax/config/api/Language;", "Lcom/feysh/corax/config/api/BugMessage;", "getBugMessage", "()Ljava/util/Map;", "report", "Lcom/feysh/corax/config/api/IRule;", "getReport", "()Lcom/feysh/corax/config/api/IRule;", "standards", "getStandards", "getRulesByName", "", "standardName", "serializerName", "getSerializerName", "()Ljava/lang/String;", "simpleName", "getSimpleName", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Companion", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nAIAnalysisApi.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIAnalysisApi.kt\ncom/feysh/corax/config/api/CheckType\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,839:1\n865#2,2:840\n*S KotlinDebug\n*F\n+ 1 AIAnalysisApi.kt\ncom/feysh/corax/config/api/CheckType\n*L\n133#1:840,2\n*E\n"})
public abstract class CheckType {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Set<String> aliasNames;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;
    @NotNull
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

    public CheckType() {
        this.aliasNames = SetsKt.emptySet();
    }

    @NotNull
    public abstract IChecker getChecker();

    @NotNull
    public Set<String> getAliasNames() {
        return this.aliasNames;
    }

    @NotNull
    public abstract Map<Language, BugMessage> getBugMessage();

    @NotNull
    public IRule getReport() {
        return this.getChecker().getReport();
    }

    @NotNull
    public Set<IRule> getStandards() {
        return SetsKt.plus(this.getChecker().getStandards(), (Object)this.getReport());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Set<IRule> getRulesByName(@NotNull String standardName) {
        void var3_3;
        void $this$filterTo$iv;
        Intrinsics.checkNotNullParameter((Object)standardName, (String)"standardName");
        Iterable iterable = this.getStandards();
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$filterTo = false;
        for (Object element$iv : $this$filterTo$iv) {
            IRule it = (IRule)element$iv;
            boolean bl = false;
            if (!Intrinsics.areEqual((Object)it.getStandard().getRealName(), (Object)standardName)) continue;
            destination$iv.add(element$iv);
        }
        return (Set)var3_3;
    }

    @NotNull
    public String getSerializerName() {
        String string = this.getClass().getCanonicalName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getCanonicalName(...)");
        return string;
    }

    @NotNull
    public String getSimpleName() {
        String string = this.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getSimpleName(...)");
        return string;
    }

    @NotNull
    public final KSerializer<CheckType> serializer() {
        return new ObjectSerializer<CheckType>(this.getSerializerName(), this);
    }

    @NotNull
    public String toString() {
        return this.getChecker().getSimpleName() + "." + this.getSimpleName();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(CheckType self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArray = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) ? true : !Intrinsics.areEqual(self.getAliasNames(), (Object)SetsKt.emptySet())) {
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)kSerializerArray[0], self.getAliasNames());
        }
    }

    public /* synthetic */ CheckType(int seen0, Set aliasNames, SerializationConstructorMarker serializationConstructorMarker) {
        this.aliasNames = (seen0 & 1) == 0 ? SetsKt.emptySet() : aliasNames;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{new LinkedHashSetSerializer((KSerializer)StringSerializer.INSTANCE)};
        $childSerializers = kSerializerArray;
        $cachedSerializer$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(CheckType.class), new Annotation[0]));
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Lcom/feysh/corax/config/api/CheckType$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/feysh/corax/config/api/CheckType;", "corax-config-api"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<CheckType> serializer() {
            return this.get$cachedSerializer();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer)$cachedSerializer$delegate.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

