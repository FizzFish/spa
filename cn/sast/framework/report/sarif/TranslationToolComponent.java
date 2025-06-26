/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sarif.Rule
 *  cn.sast.framework.report.sarif.Rule$$serializer
 *  cn.sast.framework.report.sarif.TranslationToolComponent
 *  cn.sast.framework.report.sarif.TranslationToolComponent$$serializer
 *  cn.sast.framework.report.sarif.TranslationToolComponent$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.sarif;

import cn.sast.framework.report.sarif.Rule;
import cn.sast.framework.report.sarif.Rule$;
import cn.sast.framework.report.sarif.TranslationToolComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J-\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001\u00a2\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006'"}, d2={"Lcn/sast/framework/report/sarif/TranslationToolComponent;", "", "language", "", "name", "rules", "", "Lcn/sast/framework/report/sarif/Rule;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLanguage", "()Ljava/lang/String;", "getName", "getRules", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
public final class TranslationToolComponent {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String language;
    @NotNull
    private final String name;
    @NotNull
    private final List<Rule> rules;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public TranslationToolComponent(@NotNull String language, @NotNull String name, @NotNull List<Rule> rules2) {
        Intrinsics.checkNotNullParameter((Object)language, (String)"language");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(rules2, (String)"rules");
        this.language = language;
        this.name = name;
        this.rules = rules2;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final List<Rule> getRules() {
        return this.rules;
    }

    @NotNull
    public final String component1() {
        return this.language;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final List<Rule> component3() {
        return this.rules;
    }

    @NotNull
    public final TranslationToolComponent copy(@NotNull String language, @NotNull String name, @NotNull List<Rule> rules2) {
        Intrinsics.checkNotNullParameter((Object)language, (String)"language");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(rules2, (String)"rules");
        return new TranslationToolComponent(language, name, rules2);
    }

    public static /* synthetic */ TranslationToolComponent copy$default(TranslationToolComponent translationToolComponent, String string, String string2, List list, int n, Object object) {
        if ((n & 1) != 0) {
            string = translationToolComponent.language;
        }
        if ((n & 2) != 0) {
            string2 = translationToolComponent.name;
        }
        if ((n & 4) != 0) {
            list = translationToolComponent.rules;
        }
        return translationToolComponent.copy(string, string2, list);
    }

    @NotNull
    public String toString() {
        return "TranslationToolComponent(language=" + this.language + ", name=" + this.name + ", rules=" + this.rules + ")";
    }

    public int hashCode() {
        int result = this.language.hashCode();
        result = result * 31 + this.name.hashCode();
        result = result * 31 + ((Object)this.rules).hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TranslationToolComponent)) {
            return false;
        }
        TranslationToolComponent translationToolComponent = (TranslationToolComponent)other;
        if (!Intrinsics.areEqual((Object)this.language, (Object)translationToolComponent.language)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.name, (Object)translationToolComponent.name)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.rules, (Object)translationToolComponent.rules);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(TranslationToolComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.language);
        output.encodeStringElement(serialDesc, 1, self.name);
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)kSerializerArray[2], (Object)self.rules);
    }

    public /* synthetic */ TranslationToolComponent(int seen0, String language, String name, List rules2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (7 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)7, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.language = language;
        this.name = name;
        this.rules = rules2;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{null, null, new ArrayListSerializer((KSerializer)Rule$.serializer.INSTANCE)};
        $childSerializers = kSerializerArray;
    }
}

