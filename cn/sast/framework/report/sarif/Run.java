/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.sarif.Result
 *  cn.sast.framework.report.sarif.Result$$serializer
 *  cn.sast.framework.report.sarif.Run
 *  cn.sast.framework.report.sarif.Run$$serializer
 *  cn.sast.framework.report.sarif.Run$Companion
 *  cn.sast.framework.report.sarif.Tool
 *  cn.sast.framework.report.sarif.Tool$$serializer
 *  cn.sast.framework.report.sarif.TranslationToolComponent
 *  cn.sast.framework.report.sarif.TranslationToolComponent$$serializer
 *  cn.sast.framework.report.sarif.UriBase
 *  cn.sast.framework.report.sarif.UriBase$$serializer
 *  kotlin.Metadata
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.sarif;

import cn.sast.framework.report.sarif.Result;
import cn.sast.framework.report.sarif.Result$;
import cn.sast.framework.report.sarif.Run;
import cn.sast.framework.report.sarif.Run$;
import cn.sast.framework.report.sarif.Tool;
import cn.sast.framework.report.sarif.TranslationToolComponent;
import cn.sast.framework.report.sarif.UriBase;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u00a2\u0006\u0004\b\r\u0010\u000eB[\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\r\u0010\u0013J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u00c6\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u00c6\u0003JI\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\u0010H\u00d6\u0001J\t\u0010$\u001a\u00020\u0006H\u00d6\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001\u00a2\u0006\u0002\b,R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019\u00a8\u0006/"}, d2={"Lcn/sast/framework/report/sarif/Run;", "", "tool", "Lcn/sast/framework/report/sarif/Tool;", "originalUriBaseIds", "", "", "Lcn/sast/framework/report/sarif/UriBase;", "results", "", "Lcn/sast/framework/report/sarif/Result;", "translations", "Lcn/sast/framework/report/sarif/TranslationToolComponent;", "<init>", "(Lcn/sast/framework/report/sarif/Tool;Ljava/util/Map;Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcn/sast/framework/report/sarif/Tool;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTool", "()Lcn/sast/framework/report/sarif/Tool;", "getOriginalUriBaseIds", "()Ljava/util/Map;", "getResults", "()Ljava/util/List;", "getTranslations", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
public final class Run {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Tool tool;
    @NotNull
    private final Map<String, UriBase> originalUriBaseIds;
    @NotNull
    private final List<Result> results;
    @NotNull
    private final List<TranslationToolComponent> translations;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public Run(@NotNull Tool tool, @NotNull Map<String, UriBase> originalUriBaseIds, @NotNull List<Result> results, @NotNull List<TranslationToolComponent> translations) {
        Intrinsics.checkNotNullParameter((Object)tool, (String)"tool");
        Intrinsics.checkNotNullParameter(originalUriBaseIds, (String)"originalUriBaseIds");
        Intrinsics.checkNotNullParameter(results, (String)"results");
        Intrinsics.checkNotNullParameter(translations, (String)"translations");
        this.tool = tool;
        this.originalUriBaseIds = originalUriBaseIds;
        this.results = results;
        this.translations = translations;
    }

    public /* synthetic */ Run(Tool tool, Map map, List list, List list2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        this(tool, map, list, list2);
    }

    @NotNull
    public final Tool getTool() {
        return this.tool;
    }

    @NotNull
    public final Map<String, UriBase> getOriginalUriBaseIds() {
        return this.originalUriBaseIds;
    }

    @NotNull
    public final List<Result> getResults() {
        return this.results;
    }

    @NotNull
    public final List<TranslationToolComponent> getTranslations() {
        return this.translations;
    }

    @NotNull
    public final Tool component1() {
        return this.tool;
    }

    @NotNull
    public final Map<String, UriBase> component2() {
        return this.originalUriBaseIds;
    }

    @NotNull
    public final List<Result> component3() {
        return this.results;
    }

    @NotNull
    public final List<TranslationToolComponent> component4() {
        return this.translations;
    }

    @NotNull
    public final Run copy(@NotNull Tool tool, @NotNull Map<String, UriBase> originalUriBaseIds, @NotNull List<Result> results, @NotNull List<TranslationToolComponent> translations) {
        Intrinsics.checkNotNullParameter((Object)tool, (String)"tool");
        Intrinsics.checkNotNullParameter(originalUriBaseIds, (String)"originalUriBaseIds");
        Intrinsics.checkNotNullParameter(results, (String)"results");
        Intrinsics.checkNotNullParameter(translations, (String)"translations");
        return new Run(tool, originalUriBaseIds, results, translations);
    }

    public static /* synthetic */ Run copy$default(Run run2, Tool tool, Map map, List list, List list2, int n, Object object) {
        if ((n & 1) != 0) {
            tool = run2.tool;
        }
        if ((n & 2) != 0) {
            map = run2.originalUriBaseIds;
        }
        if ((n & 4) != 0) {
            list = run2.results;
        }
        if ((n & 8) != 0) {
            list2 = run2.translations;
        }
        return run2.copy(tool, map, list, list2);
    }

    @NotNull
    public String toString() {
        return "Run(tool=" + this.tool + ", originalUriBaseIds=" + this.originalUriBaseIds + ", results=" + this.results + ", translations=" + this.translations + ")";
    }

    public int hashCode() {
        int result = this.tool.hashCode();
        result = result * 31 + ((Object)this.originalUriBaseIds).hashCode();
        result = result * 31 + ((Object)this.results).hashCode();
        result = result * 31 + ((Object)this.translations).hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Run)) {
            return false;
        }
        Run run2 = (Run)other;
        if (!Intrinsics.areEqual((Object)this.tool, (Object)run2.tool)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.originalUriBaseIds, (Object)run2.originalUriBaseIds)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.results, (Object)run2.results)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.translations, (Object)run2.translations);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(Run self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArray = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)Tool.$serializer.INSTANCE, (Object)self.tool);
        if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : !Intrinsics.areEqual((Object)self.originalUriBaseIds, (Object)MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)kSerializerArray[1], (Object)self.originalUriBaseIds);
        }
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)kSerializerArray[2], (Object)self.results);
        output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy)kSerializerArray[3], (Object)self.translations);
    }

    public /* synthetic */ Run(int seen0, Tool tool, Map originalUriBaseIds, List results, List translations, SerializationConstructorMarker serializationConstructorMarker) {
        if (13 != (0xD & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)13, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.tool = tool;
        this.originalUriBaseIds = (seen0 & 2) == 0 ? MapsKt.emptyMap() : originalUriBaseIds;
        this.results = results;
        this.translations = translations;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{null, new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)UriBase.$serializer.INSTANCE), new ArrayListSerializer((KSerializer)Result$.serializer.INSTANCE), new ArrayListSerializer((KSerializer)TranslationToolComponent.$serializer.INSTANCE)};
        $childSerializers = kSerializerArray;
    }
}

