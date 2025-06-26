/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.BuiltinAnalysisConfig
 *  cn.sast.api.config.BuiltinAnalysisConfig$$serializer
 *  cn.sast.api.config.BuiltinAnalysisConfig$Companion
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
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
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.config;

import cn.sast.api.config.BuiltinAnalysisConfig;
import cn.sast.api.config.BuiltinAnalysisConfig$;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@SerialName(value="BuiltinAnalysisConfig")
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B;\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nBK\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\t\u0010\u000eJ\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00c6\u0003J=\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00d6\u0001J\t\u0010#\u001a\u00020\u0004H\u00d6\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001\u00a2\u0006\u0002\b+R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0017\u00a8\u0006."}, d2={"Lcn/sast/api/config/BuiltinAnalysisConfig;", "", "unusedDetectorSootSigPatternBlackList", "", "", "unusedDetectorMethodSigBlackList", "maximumUnusedFieldReportsEachClass", "", "maximumUnusedMethodReportsEachClass", "<init>", "(Ljava/util/List;Ljava/util/List;II)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUnusedDetectorSootSigPatternBlackList$annotations", "()V", "getUnusedDetectorSootSigPatternBlackList", "()Ljava/util/List;", "getUnusedDetectorMethodSigBlackList$annotations", "getUnusedDetectorMethodSigBlackList", "getMaximumUnusedFieldReportsEachClass$annotations", "getMaximumUnusedFieldReportsEachClass", "()I", "getMaximumUnusedMethodReportsEachClass$annotations", "getMaximumUnusedMethodReportsEachClass", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_api", "$serializer", "Companion", "corax-api"})
public final class BuiltinAnalysisConfig {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<String> unusedDetectorSootSigPatternBlackList;
    @NotNull
    private final List<String> unusedDetectorMethodSigBlackList;
    private final int maximumUnusedFieldReportsEachClass;
    private final int maximumUnusedMethodReportsEachClass;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public BuiltinAnalysisConfig(@NotNull List<String> unusedDetectorSootSigPatternBlackList, @NotNull List<String> unusedDetectorMethodSigBlackList, int maximumUnusedFieldReportsEachClass, int maximumUnusedMethodReportsEachClass) {
        Intrinsics.checkNotNullParameter(unusedDetectorSootSigPatternBlackList, (String)"unusedDetectorSootSigPatternBlackList");
        Intrinsics.checkNotNullParameter(unusedDetectorMethodSigBlackList, (String)"unusedDetectorMethodSigBlackList");
        this.unusedDetectorSootSigPatternBlackList = unusedDetectorSootSigPatternBlackList;
        this.unusedDetectorMethodSigBlackList = unusedDetectorMethodSigBlackList;
        this.maximumUnusedFieldReportsEachClass = maximumUnusedFieldReportsEachClass;
        this.maximumUnusedMethodReportsEachClass = maximumUnusedMethodReportsEachClass;
    }

    public /* synthetic */ BuiltinAnalysisConfig(List list, List list2, int n, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        Object[] objectArray;
        if ((n3 & 1) != 0) {
            objectArray = new String[]{"<.*: void start\\(.*BundleContext\\)>", "<.*: void stop\\(.*BundleContext\\)>", "<.*\\.R(\\$.*)?: .*>"};
            list = CollectionsKt.listOf((Object[])objectArray);
        }
        if ((n3 & 2) != 0) {
            objectArray = new String[]{"org.osgi.framework.BundleActivator: void start(BundleContext context)", "org.osgi.framework.BundleActivator: void stop(BundleContext context)"};
            list2 = CollectionsKt.listOf((Object[])objectArray);
        }
        if ((n3 & 4) != 0) {
            n = 10;
        }
        if ((n3 & 8) != 0) {
            n2 = 40;
        }
        this(list, list2, n, n2);
    }

    @NotNull
    public final List<String> getUnusedDetectorSootSigPatternBlackList() {
        return this.unusedDetectorSootSigPatternBlackList;
    }

    @SerialName(value="unused_detector_soot_sig_pattern_blacklist")
    public static /* synthetic */ void getUnusedDetectorSootSigPatternBlackList$annotations() {
    }

    @NotNull
    public final List<String> getUnusedDetectorMethodSigBlackList() {
        return this.unusedDetectorMethodSigBlackList;
    }

    @SerialName(value="unused_detector_method_sig_blacklist")
    public static /* synthetic */ void getUnusedDetectorMethodSigBlackList$annotations() {
    }

    public final int getMaximumUnusedFieldReportsEachClass() {
        return this.maximumUnusedFieldReportsEachClass;
    }

    @SerialName(value="maximum_unused_field_reports_each_class")
    public static /* synthetic */ void getMaximumUnusedFieldReportsEachClass$annotations() {
    }

    public final int getMaximumUnusedMethodReportsEachClass() {
        return this.maximumUnusedMethodReportsEachClass;
    }

    @SerialName(value="maximum_unused_method_reports_each_class")
    public static /* synthetic */ void getMaximumUnusedMethodReportsEachClass$annotations() {
    }

    @NotNull
    public final List<String> component1() {
        return this.unusedDetectorSootSigPatternBlackList;
    }

    @NotNull
    public final List<String> component2() {
        return this.unusedDetectorMethodSigBlackList;
    }

    public final int component3() {
        return this.maximumUnusedFieldReportsEachClass;
    }

    public final int component4() {
        return this.maximumUnusedMethodReportsEachClass;
    }

    @NotNull
    public final BuiltinAnalysisConfig copy(@NotNull List<String> unusedDetectorSootSigPatternBlackList, @NotNull List<String> unusedDetectorMethodSigBlackList, int maximumUnusedFieldReportsEachClass, int maximumUnusedMethodReportsEachClass) {
        Intrinsics.checkNotNullParameter(unusedDetectorSootSigPatternBlackList, (String)"unusedDetectorSootSigPatternBlackList");
        Intrinsics.checkNotNullParameter(unusedDetectorMethodSigBlackList, (String)"unusedDetectorMethodSigBlackList");
        return new BuiltinAnalysisConfig(unusedDetectorSootSigPatternBlackList, unusedDetectorMethodSigBlackList, maximumUnusedFieldReportsEachClass, maximumUnusedMethodReportsEachClass);
    }

    public static /* synthetic */ BuiltinAnalysisConfig copy$default(BuiltinAnalysisConfig builtinAnalysisConfig, List list, List list2, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            list = builtinAnalysisConfig.unusedDetectorSootSigPatternBlackList;
        }
        if ((n3 & 2) != 0) {
            list2 = builtinAnalysisConfig.unusedDetectorMethodSigBlackList;
        }
        if ((n3 & 4) != 0) {
            n = builtinAnalysisConfig.maximumUnusedFieldReportsEachClass;
        }
        if ((n3 & 8) != 0) {
            n2 = builtinAnalysisConfig.maximumUnusedMethodReportsEachClass;
        }
        return builtinAnalysisConfig.copy(list, list2, n, n2);
    }

    @NotNull
    public String toString() {
        return "BuiltinAnalysisConfig(unusedDetectorSootSigPatternBlackList=" + this.unusedDetectorSootSigPatternBlackList + ", unusedDetectorMethodSigBlackList=" + this.unusedDetectorMethodSigBlackList + ", maximumUnusedFieldReportsEachClass=" + this.maximumUnusedFieldReportsEachClass + ", maximumUnusedMethodReportsEachClass=" + this.maximumUnusedMethodReportsEachClass + ")";
    }

    public int hashCode() {
        int result = ((Object)this.unusedDetectorSootSigPatternBlackList).hashCode();
        result = result * 31 + ((Object)this.unusedDetectorMethodSigBlackList).hashCode();
        result = result * 31 + Integer.hashCode(this.maximumUnusedFieldReportsEachClass);
        result = result * 31 + Integer.hashCode(this.maximumUnusedMethodReportsEachClass);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuiltinAnalysisConfig)) {
            return false;
        }
        BuiltinAnalysisConfig builtinAnalysisConfig = (BuiltinAnalysisConfig)other;
        if (!Intrinsics.areEqual((Object)this.unusedDetectorSootSigPatternBlackList, (Object)builtinAnalysisConfig.unusedDetectorSootSigPatternBlackList)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.unusedDetectorMethodSigBlackList, (Object)builtinAnalysisConfig.unusedDetectorMethodSigBlackList)) {
            return false;
        }
        if (this.maximumUnusedFieldReportsEachClass != builtinAnalysisConfig.maximumUnusedFieldReportsEachClass) {
            return false;
        }
        return this.maximumUnusedMethodReportsEachClass == builtinAnalysisConfig.maximumUnusedMethodReportsEachClass;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_api(BuiltinAnalysisConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean bl;
        Object[] objectArray;
        boolean bl2;
        KSerializer[] kSerializerArray = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0)) {
            bl2 = true;
        } else {
            objectArray = new String[]{"<.*: void start\\(.*BundleContext\\)>", "<.*: void stop\\(.*BundleContext\\)>", "<.*\\.R(\\$.*)?: .*>"};
            bl2 = !Intrinsics.areEqual((Object)self.unusedDetectorSootSigPatternBlackList, (Object)CollectionsKt.listOf((Object[])objectArray));
        }
        if (bl2) {
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)kSerializerArray[0], (Object)self.unusedDetectorSootSigPatternBlackList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1)) {
            bl = true;
        } else {
            objectArray = new String[]{"org.osgi.framework.BundleActivator: void start(BundleContext context)", "org.osgi.framework.BundleActivator: void stop(BundleContext context)"};
            bl = !Intrinsics.areEqual((Object)self.unusedDetectorMethodSigBlackList, (Object)CollectionsKt.listOf((Object[])objectArray));
        }
        if (bl) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)kSerializerArray[1], (Object)self.unusedDetectorMethodSigBlackList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.maximumUnusedFieldReportsEachClass != 10) {
            output.encodeIntElement(serialDesc, 2, self.maximumUnusedFieldReportsEachClass);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.maximumUnusedMethodReportsEachClass != 40) {
            output.encodeIntElement(serialDesc, 3, self.maximumUnusedMethodReportsEachClass);
        }
    }

    public /* synthetic */ BuiltinAnalysisConfig(int seen0, List unusedDetectorSootSigPatternBlackList, List unusedDetectorMethodSigBlackList, int maximumUnusedFieldReportsEachClass, int maximumUnusedMethodReportsEachClass, SerializationConstructorMarker serializationConstructorMarker) {
        Object[] objectArray;
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)0, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        if ((seen0 & 1) == 0) {
            objectArray = new String[]{"<.*: void start\\(.*BundleContext\\)>", "<.*: void stop\\(.*BundleContext\\)>", "<.*\\.R(\\$.*)?: .*>"};
            this.unusedDetectorSootSigPatternBlackList = CollectionsKt.listOf((Object[])objectArray);
        } else {
            this.unusedDetectorSootSigPatternBlackList = unusedDetectorSootSigPatternBlackList;
        }
        if ((seen0 & 2) == 0) {
            objectArray = new String[]{"org.osgi.framework.BundleActivator: void start(BundleContext context)", "org.osgi.framework.BundleActivator: void stop(BundleContext context)"};
            this.unusedDetectorMethodSigBlackList = CollectionsKt.listOf((Object[])objectArray);
        } else {
            this.unusedDetectorMethodSigBlackList = unusedDetectorMethodSigBlackList;
        }
        this.maximumUnusedFieldReportsEachClass = (seen0 & 4) == 0 ? 10 : maximumUnusedFieldReportsEachClass;
        this.maximumUnusedMethodReportsEachClass = (seen0 & 8) == 0 ? 40 : maximumUnusedMethodReportsEachClass;
    }

    public BuiltinAnalysisConfig() {
        this(null, null, 0, 0, 15, null);
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), null, null};
        $childSerializers = kSerializerArray;
    }
}

