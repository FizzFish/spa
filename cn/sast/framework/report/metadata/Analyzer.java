/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.metadata.Analyzer
 *  cn.sast.framework.report.metadata.Analyzer$$serializer
 *  cn.sast.framework.report.metadata.Analyzer$Companion
 *  cn.sast.framework.report.metadata.AnalyzerStatistics
 *  cn.sast.framework.report.metadata.AnalyzerStatistics$$serializer
 *  kotlin.Metadata
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerialName
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report.metadata;

import cn.sast.framework.report.metadata.Analyzer;
import cn.sast.framework.report.metadata.Analyzer$;
import cn.sast.framework.report.metadata.AnalyzerStatistics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bB;\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J)\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\nH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0006H\u00d6\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001\u00a2\u0006\u0002\b#R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006&"}, d2={"Lcn/sast/framework/report/metadata/Analyzer;", "", "analyzerStatistics", "Lcn/sast/framework/report/metadata/AnalyzerStatistics;", "checkers", "", "", "<init>", "(Lcn/sast/framework/report/metadata/AnalyzerStatistics;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcn/sast/framework/report/metadata/AnalyzerStatistics;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAnalyzerStatistics$annotations", "()V", "getAnalyzerStatistics", "()Lcn/sast/framework/report/metadata/AnalyzerStatistics;", "getCheckers", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_framework", "$serializer", "Companion", "corax-framework"})
public final class Analyzer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final AnalyzerStatistics analyzerStatistics;
    @NotNull
    private final Map<String, String> checkers;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public Analyzer(@NotNull AnalyzerStatistics analyzerStatistics, @NotNull Map<String, String> checkers) {
        Intrinsics.checkNotNullParameter((Object)analyzerStatistics, (String)"analyzerStatistics");
        Intrinsics.checkNotNullParameter(checkers, (String)"checkers");
        this.analyzerStatistics = analyzerStatistics;
        this.checkers = checkers;
    }

    public /* synthetic */ Analyzer(AnalyzerStatistics analyzerStatistics, Map map, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        this(analyzerStatistics, map);
    }

    @NotNull
    public final AnalyzerStatistics getAnalyzerStatistics() {
        return this.analyzerStatistics;
    }

    @SerialName(value="analyzer_statistics")
    public static /* synthetic */ void getAnalyzerStatistics$annotations() {
    }

    @NotNull
    public final Map<String, String> getCheckers() {
        return this.checkers;
    }

    @NotNull
    public final AnalyzerStatistics component1() {
        return this.analyzerStatistics;
    }

    @NotNull
    public final Map<String, String> component2() {
        return this.checkers;
    }

    @NotNull
    public final Analyzer copy(@NotNull AnalyzerStatistics analyzerStatistics, @NotNull Map<String, String> checkers) {
        Intrinsics.checkNotNullParameter((Object)analyzerStatistics, (String)"analyzerStatistics");
        Intrinsics.checkNotNullParameter(checkers, (String)"checkers");
        return new Analyzer(analyzerStatistics, checkers);
    }

    public static /* synthetic */ Analyzer copy$default(Analyzer analyzer2, AnalyzerStatistics analyzerStatistics, Map map, int n, Object object) {
        if ((n & 1) != 0) {
            analyzerStatistics = analyzer2.analyzerStatistics;
        }
        if ((n & 2) != 0) {
            map = analyzer2.checkers;
        }
        return analyzer2.copy(analyzerStatistics, map);
    }

    @NotNull
    public String toString() {
        return "Analyzer(analyzerStatistics=" + this.analyzerStatistics + ", checkers=" + this.checkers + ")";
    }

    public int hashCode() {
        int result = this.analyzerStatistics.hashCode();
        result = result * 31 + ((Object)this.checkers).hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Analyzer)) {
            return false;
        }
        Analyzer analyzer2 = (Analyzer)other;
        if (!Intrinsics.areEqual((Object)this.analyzerStatistics, (Object)analyzer2.analyzerStatistics)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.checkers, (Object)analyzer2.checkers);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_framework(Analyzer self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArray = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)AnalyzerStatistics.$serializer.INSTANCE, (Object)self.analyzerStatistics);
        if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : !Intrinsics.areEqual((Object)self.checkers, (Object)MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)kSerializerArray[1], (Object)self.checkers);
        }
    }

    public /* synthetic */ Analyzer(int seen0, AnalyzerStatistics analyzerStatistics, Map checkers, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.analyzerStatistics = analyzerStatistics;
        this.checkers = (seen0 & 2) == 0 ? MapsKt.emptyMap() : checkers;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{null, new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE)};
        $childSerializers = kSerializerArray;
    }
}

