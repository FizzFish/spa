/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.PreAnalysisConfig
 *  cn.sast.api.config.PreAnalysisConfig$$serializer
 *  cn.sast.api.config.PreAnalysisConfig$Companion
 *  cn.sast.common.ResourceImplKt
 *  cn.sast.common.ResourceKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerialName
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.Transient
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.IntSerializer
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.config;

import cn.sast.api.config.PreAnalysisConfig;
import cn.sast.api.config.PreAnalysisConfig$;
import cn.sast.common.ResourceImplKt;
import cn.sast.common.ResourceKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@SerialName(value="PreAnalysisConfig")
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 72\u00020\u0001:\u000267BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0004\b\n\u0010\u000bBQ\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\n\u0010\u000fJ\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\b\u00a2\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c2\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003JG\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010*\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001J\t\u0010-\u001a\u00020\bH\u00d6\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001\u00a2\u0006\u0002\b5R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00078\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0011R\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00078\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0011\u00a8\u00068"}, d2={"Lcn/sast/api/config/PreAnalysisConfig;", "", "cancelAnalysisInErrorCount", "", "largeFileSize", "largeFileSemaphorePermits", "_fileExtensionToSizeThreshold", "", "", "maximumFileSizeThresholdWarnings", "<init>", "(IIILjava/util/Map;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIILjava/util/Map;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCancelAnalysisInErrorCount$annotations", "()V", "getCancelAnalysisInErrorCount", "()I", "getLargeFileSize$annotations", "getLargeFileSize", "getLargeFileSemaphorePermits$annotations", "getLargeFileSemaphorePermits", "get_fileExtensionToSizeThreshold$annotations", "getMaximumFileSizeThresholdWarnings$annotations", "getMaximumFileSizeThresholdWarnings", "fileExtensionToSizeThreshold", "getFileExtensionToSizeThreshold$annotations", "getSizeThreshold", "extension", "(Ljava/lang/String;)Ljava/lang/Integer;", "fileSizeThresholdExceeded", "", "fileSize", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_api", "$serializer", "Companion", "corax-api"})
@SourceDebugExtension(value={"SMAP\nPreAnalysisConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreAnalysisConfig.kt\ncn/sast/api/config/PreAnalysisConfig\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n126#2:59\n153#2,2:60\n155#2:66\n153#2,3:68\n1557#3:62\n1628#3,3:63\n1#4:67\n*S KotlinDebug\n*F\n+ 1 PreAnalysisConfig.kt\ncn/sast/api/config/PreAnalysisConfig\n*L\n50#1:59\n50#1:60,2\n50#1:66\n50#1:68,3\n50#1:62\n50#1:63,3\n*E\n"})
public final class PreAnalysisConfig {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int cancelAnalysisInErrorCount;
    private final int largeFileSize;
    private final int largeFileSemaphorePermits;
    @NotNull
    private final Map<String, Integer> _fileExtensionToSizeThreshold;
    private final int maximumFileSizeThresholdWarnings;
    @NotNull
    private final Map<String, Integer> fileExtensionToSizeThreshold;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    /*
     * WARNING - void declaration
     */
    public PreAnalysisConfig(int cancelAnalysisInErrorCount, int largeFileSize, int largeFileSemaphorePermits, @NotNull Map<String, Integer> _fileExtensionToSizeThreshold, int maximumFileSizeThresholdWarnings) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter(_fileExtensionToSizeThreshold, (String)"_fileExtensionToSizeThreshold");
        this.cancelAnalysisInErrorCount = cancelAnalysisInErrorCount;
        this.largeFileSize = largeFileSize;
        this.largeFileSemaphorePermits = largeFileSemaphorePermits;
        this._fileExtensionToSizeThreshold = _fileExtensionToSizeThreshold;
        this.maximumFileSizeThresholdWarnings = maximumFileSizeThresholdWarnings;
        Map map = this._fileExtensionToSizeThreshold;
        PreAnalysisConfig preAnalysisConfig = this;
        boolean $i$f$map = false;
        void var8_9 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.size());
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            void $this$mapTo$iv$iv2;
            Map.Entry item$iv$iv;
            Map.Entry entry = item$iv$iv = iterator2.next();
            Collection collection = destination$iv$iv;
            boolean bl = false;
            String k = (String)entry.getKey();
            int v = ((Number)entry.getValue()).intValue();
            String[] stringArray = new String[]{","};
            Iterable $this$map$iv2 = StringsKt.split$default((CharSequence)k, (String[])stringArray, (boolean)false, (int)0, (int)6, null);
            boolean $i$f$map2 = false;
            Iterable iterable = $this$map$iv2;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv2, (int)10));
            boolean $i$f$mapTo2 = false;
            for (Object item$iv$iv2 : $this$mapTo$iv$iv2) {
                void it;
                String string = (String)item$iv$iv2;
                Collection collection2 = destination$iv$iv2;
                boolean bl2 = false;
                collection2.add(TuplesKt.to((Object)it, (Object)v));
            }
            collection.add((List)destination$iv$iv2);
        }
        preAnalysisConfig.fileExtensionToSizeThreshold = MapsKt.toMap((Iterable)CollectionsKt.flatten((Iterable)((List)destination$iv$iv)));
    }

    public /* synthetic */ PreAnalysisConfig(int n, int n2, int n3, Map map, int n4, int n5, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n5 & 1) != 0) {
            n = 10;
        }
        if ((n5 & 2) != 0) {
            n2 = 512000;
        }
        if ((n5 & 4) != 0) {
            n3 = 3;
        }
        if ((n5 & 8) != 0) {
            Pair[] pairArray = new Pair[4];
            pairArray[0] = TuplesKt.to((Object)CollectionsKt.joinToString$default((Iterable)ResourceKt.getJavaExtensions(), (CharSequence)",", null, null, (int)0, null, null, (int)62, null), (Object)0x100000);
            pairArray[1] = TuplesKt.to((Object)CollectionsKt.joinToString$default((Iterable)ResourceImplKt.getZipExtensions(), (CharSequence)",", null, null, (int)0, null, null, (int)62, null), (Object)-1);
            Object[] objectArray = new String[]{"html", "htm", "adoc", "gradle", "properties", "config", "cnf", "txt", "json", "xml", "yml", "yaml", "toml", "ini"};
            pairArray[2] = TuplesKt.to((Object)CollectionsKt.joinToString$default((Iterable)CollectionsKt.listOf((Object[])objectArray), (CharSequence)",", null, null, (int)0, null, null, (int)62, null), (Object)0x500000);
            pairArray[3] = TuplesKt.to((Object)"*", (Object)0x500000);
            map = MapsKt.mapOf((Pair[])pairArray);
        }
        if ((n5 & 0x10) != 0) {
            n4 = 20;
        }
        this(n, n2, n3, map, n4);
    }

    public final int getCancelAnalysisInErrorCount() {
        return this.cancelAnalysisInErrorCount;
    }

    @SerialName(value="cancel_analysis_in_error_count")
    public static /* synthetic */ void getCancelAnalysisInErrorCount$annotations() {
    }

    public final int getLargeFileSize() {
        return this.largeFileSize;
    }

    @SerialName(value="large_file_size")
    public static /* synthetic */ void getLargeFileSize$annotations() {
    }

    public final int getLargeFileSemaphorePermits() {
        return this.largeFileSemaphorePermits;
    }

    @SerialName(value="large_file_semaphore_permits")
    public static /* synthetic */ void getLargeFileSemaphorePermits$annotations() {
    }

    @SerialName(value="file_extension_to_size_threshold")
    private static /* synthetic */ void get_fileExtensionToSizeThreshold$annotations() {
    }

    public final int getMaximumFileSizeThresholdWarnings() {
        return this.maximumFileSizeThresholdWarnings;
    }

    @SerialName(value="maximum_file_size_threshold_warnings")
    public static /* synthetic */ void getMaximumFileSizeThresholdWarnings$annotations() {
    }

    @Transient
    private static /* synthetic */ void getFileExtensionToSizeThreshold$annotations() {
    }

    @Nullable
    public final Integer getSizeThreshold(@NotNull String extension) {
        Integer n;
        Intrinsics.checkNotNullParameter((Object)extension, (String)"extension");
        Integer n2 = (Integer)this.fileExtensionToSizeThreshold.get(extension);
        if (n2 == null) {
            n2 = (Integer)this.fileExtensionToSizeThreshold.get("*");
        }
        if (n2 != null) {
            Integer n3 = n2;
            int it = ((Number)n3).intValue();
            boolean bl = false;
            n = it > 0 ? n3 : null;
        } else {
            n = null;
        }
        return n;
    }

    public final boolean fileSizeThresholdExceeded(@NotNull String extension, long fileSize) {
        Intrinsics.checkNotNullParameter((Object)extension, (String)"extension");
        Integer n = this.getSizeThreshold(extension);
        if (n == null) {
            return false;
        }
        int sizeThreshold = n;
        return fileSize > (long)sizeThreshold;
    }

    public final int component1() {
        return this.cancelAnalysisInErrorCount;
    }

    public final int component2() {
        return this.largeFileSize;
    }

    public final int component3() {
        return this.largeFileSemaphorePermits;
    }

    private final Map<String, Integer> component4() {
        return this._fileExtensionToSizeThreshold;
    }

    public final int component5() {
        return this.maximumFileSizeThresholdWarnings;
    }

    @NotNull
    public final PreAnalysisConfig copy(int cancelAnalysisInErrorCount, int largeFileSize, int largeFileSemaphorePermits, @NotNull Map<String, Integer> _fileExtensionToSizeThreshold, int maximumFileSizeThresholdWarnings) {
        Intrinsics.checkNotNullParameter(_fileExtensionToSizeThreshold, (String)"_fileExtensionToSizeThreshold");
        return new PreAnalysisConfig(cancelAnalysisInErrorCount, largeFileSize, largeFileSemaphorePermits, _fileExtensionToSizeThreshold, maximumFileSizeThresholdWarnings);
    }

    public static /* synthetic */ PreAnalysisConfig copy$default(PreAnalysisConfig preAnalysisConfig, int n, int n2, int n3, Map map, int n4, int n5, Object object) {
        if ((n5 & 1) != 0) {
            n = preAnalysisConfig.cancelAnalysisInErrorCount;
        }
        if ((n5 & 2) != 0) {
            n2 = preAnalysisConfig.largeFileSize;
        }
        if ((n5 & 4) != 0) {
            n3 = preAnalysisConfig.largeFileSemaphorePermits;
        }
        if ((n5 & 8) != 0) {
            map = preAnalysisConfig._fileExtensionToSizeThreshold;
        }
        if ((n5 & 0x10) != 0) {
            n4 = preAnalysisConfig.maximumFileSizeThresholdWarnings;
        }
        return preAnalysisConfig.copy(n, n2, n3, map, n4);
    }

    @NotNull
    public String toString() {
        return "PreAnalysisConfig(cancelAnalysisInErrorCount=" + this.cancelAnalysisInErrorCount + ", largeFileSize=" + this.largeFileSize + ", largeFileSemaphorePermits=" + this.largeFileSemaphorePermits + ", _fileExtensionToSizeThreshold=" + this._fileExtensionToSizeThreshold + ", maximumFileSizeThresholdWarnings=" + this.maximumFileSizeThresholdWarnings + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.cancelAnalysisInErrorCount);
        result = result * 31 + Integer.hashCode(this.largeFileSize);
        result = result * 31 + Integer.hashCode(this.largeFileSemaphorePermits);
        result = result * 31 + ((Object)this._fileExtensionToSizeThreshold).hashCode();
        result = result * 31 + Integer.hashCode(this.maximumFileSizeThresholdWarnings);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreAnalysisConfig)) {
            return false;
        }
        PreAnalysisConfig preAnalysisConfig = (PreAnalysisConfig)other;
        if (this.cancelAnalysisInErrorCount != preAnalysisConfig.cancelAnalysisInErrorCount) {
            return false;
        }
        if (this.largeFileSize != preAnalysisConfig.largeFileSize) {
            return false;
        }
        if (this.largeFileSemaphorePermits != preAnalysisConfig.largeFileSemaphorePermits) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this._fileExtensionToSizeThreshold, (Object)preAnalysisConfig._fileExtensionToSizeThreshold)) {
            return false;
        }
        return this.maximumFileSizeThresholdWarnings == preAnalysisConfig.maximumFileSizeThresholdWarnings;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_api(PreAnalysisConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean bl;
        KSerializer[] kSerializerArray = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) ? true : self.cancelAnalysisInErrorCount != 10) {
            output.encodeIntElement(serialDesc, 0, self.cancelAnalysisInErrorCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : self.largeFileSize != 512000) {
            output.encodeIntElement(serialDesc, 1, self.largeFileSize);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.largeFileSemaphorePermits != 3) {
            output.encodeIntElement(serialDesc, 2, self.largeFileSemaphorePermits);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3)) {
            bl = true;
        } else {
            Pair[] pairArray = new Pair[4];
            pairArray[0] = TuplesKt.to((Object)CollectionsKt.joinToString$default((Iterable)ResourceKt.getJavaExtensions(), (CharSequence)",", null, null, (int)0, null, null, (int)62, null), (Object)0x100000);
            pairArray[1] = TuplesKt.to((Object)CollectionsKt.joinToString$default((Iterable)ResourceImplKt.getZipExtensions(), (CharSequence)",", null, null, (int)0, null, null, (int)62, null), (Object)-1);
            Object[] objectArray = new String[]{"html", "htm", "adoc", "gradle", "properties", "config", "cnf", "txt", "json", "xml", "yml", "yaml", "toml", "ini"};
            pairArray[2] = TuplesKt.to((Object)CollectionsKt.joinToString$default((Iterable)CollectionsKt.listOf((Object[])objectArray), (CharSequence)",", null, null, (int)0, null, null, (int)62, null), (Object)0x500000);
            pairArray[3] = TuplesKt.to((Object)"*", (Object)0x500000);
            bl = !Intrinsics.areEqual((Object)self._fileExtensionToSizeThreshold, (Object)MapsKt.mapOf((Pair[])pairArray));
        }
        if (bl) {
            output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy)kSerializerArray[3], (Object)self._fileExtensionToSizeThreshold);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : self.maximumFileSizeThresholdWarnings != 20) {
            output.encodeIntElement(serialDesc, 4, self.maximumFileSizeThresholdWarnings);
        }
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ PreAnalysisConfig(int seen0, int cancelAnalysisInErrorCount, int largeFileSize, int largeFileSemaphorePermits, Map _fileExtensionToSizeThreshold, int maximumFileSizeThresholdWarnings, SerializationConstructorMarker serializationConstructorMarker) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Object object;
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)0, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.cancelAnalysisInErrorCount = (seen0 & 1) == 0 ? 10 : cancelAnalysisInErrorCount;
        this.largeFileSize = (seen0 & 2) == 0 ? 512000 : largeFileSize;
        this.largeFileSemaphorePermits = (seen0 & 4) == 0 ? 3 : largeFileSemaphorePermits;
        if ((seen0 & 8) == 0) {
            object = new Pair[4];
            object[0] = TuplesKt.to((Object)CollectionsKt.joinToString$default((Iterable)ResourceKt.getJavaExtensions(), (CharSequence)",", null, null, (int)0, null, null, (int)62, null), (Object)0x100000);
            object[1] = TuplesKt.to((Object)CollectionsKt.joinToString$default((Iterable)ResourceImplKt.getZipExtensions(), (CharSequence)",", null, null, (int)0, null, null, (int)62, null), (Object)-1);
            Object[] objectArray = new String[]{"html", "htm", "adoc", "gradle", "properties", "config", "cnf", "txt", "json", "xml", "yml", "yaml", "toml", "ini"};
            object[2] = TuplesKt.to((Object)CollectionsKt.joinToString$default((Iterable)CollectionsKt.listOf((Object[])objectArray), (CharSequence)",", null, null, (int)0, null, null, (int)62, null), (Object)0x500000);
            object[3] = TuplesKt.to((Object)"*", (Object)0x500000);
            this._fileExtensionToSizeThreshold = MapsKt.mapOf((Pair[])object);
        } else {
            this._fileExtensionToSizeThreshold = _fileExtensionToSizeThreshold;
        }
        this.maximumFileSizeThresholdWarnings = (seen0 & 0x10) == 0 ? 20 : maximumFileSizeThresholdWarnings;
        object = this._fileExtensionToSizeThreshold;
        PreAnalysisConfig preAnalysisConfig = this;
        boolean $i$f$map = false;
        void var10_12 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.size());
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            void $this$mapTo$iv$iv2;
            Map.Entry item$iv$iv;
            Map.Entry entry = item$iv$iv = iterator2.next();
            Collection collection = destination$iv$iv;
            boolean bl = false;
            String k = (String)entry.getKey();
            int v = ((Number)entry.getValue()).intValue();
            String[] stringArray = new String[]{","};
            Iterable $this$map$iv2 = StringsKt.split$default((CharSequence)k, (String[])stringArray, (boolean)false, (int)0, (int)6, null);
            boolean $i$f$map2 = false;
            Iterable iterable = $this$map$iv2;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv2, (int)10));
            boolean $i$f$mapTo2 = false;
            for (Object item$iv$iv2 : $this$mapTo$iv$iv2) {
                void it;
                String string = (String)item$iv$iv2;
                Collection collection2 = destination$iv$iv2;
                boolean bl2 = false;
                collection2.add(TuplesKt.to((Object)it, (Object)v));
            }
            collection.add((List)destination$iv$iv2);
        }
        preAnalysisConfig.fileExtensionToSizeThreshold = MapsKt.toMap((Iterable)CollectionsKt.flatten((Iterable)((List)destination$iv$iv)));
    }

    public PreAnalysisConfig() {
        this(0, 0, 0, null, 0, 31, null);
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{null, null, null, new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)IntSerializer.INSTANCE), null};
        $childSerializers = kSerializerArray;
    }
}

