/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ChapterFlat
 *  cn.sast.api.config.CheckerPriorityConfig
 *  cn.sast.api.config.CheckerPriorityConfig$$serializer
 *  cn.sast.api.config.CheckerPriorityConfig$Companion
 *  com.charleskorn.kaml.Yaml
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IndexedValue
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
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

import cn.sast.api.config.ChapterFlat;
import cn.sast.api.config.CheckerPriorityConfig;
import cn.sast.api.config.CheckerPriorityConfig$;
import com.charleskorn.kaml.Yaml;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
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
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002/0B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007B;\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0006\u0010\fJ\u0018\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016H\u0002J$\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00150\u00150\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003H\u0002J2\u0010\u001a\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u001b0\u001b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003J(\u0010\u001c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00150\u00150\u001e0\u001d2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J)\u0010!\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020\tH\u00d6\u0001J\t\u0010&\u001a\u00020\u0004H\u00d6\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001\u00a2\u0006\u0002\b.R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010\u00a8\u00061"}, d2={"Lcn/sast/api/config/CheckerPriorityConfig;", "", "categoryList", "", "", "severityList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCategoryList$annotations", "()V", "getCategoryList", "()Ljava/util/List;", "getSeverityList$annotations", "getSeverityList", "getComparator", "Ljava/util/Comparator;", "Lcn/sast/api/config/ChapterFlat;", "Lkotlin/Comparator;", "sort", "kotlin.jvm.PlatformType", "chapters", "getSortTree", "", "getRuleWithSortNumber", "", "Lkotlin/collections/IndexedValue;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_api", "Companion", "$serializer", "corax-api"})
@SourceDebugExtension(value={"SMAP\nCheckerPriorityConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckerPriorityConfig.kt\ncn/sast/api/config/CheckerPriorityConfig\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,52:1\n1187#2,2:53\n1261#2,4:55\n1187#2,2:59\n1261#2,4:61\n1485#2:65\n1510#2,3:66\n1513#2,3:76\n1246#2,2:81\n1485#2:83\n1510#2,3:84\n1513#2,3:94\n1246#2,2:99\n1557#2:101\n1628#2,3:102\n1249#2:105\n1249#2:106\n381#3,7:69\n462#3:79\n412#3:80\n381#3,7:87\n462#3:97\n412#3:98\n*S KotlinDebug\n*F\n+ 1 CheckerPriorityConfig.kt\ncn/sast/api/config/CheckerPriorityConfig\n*L\n16#1:53,2\n16#1:55,4\n17#1:59,2\n17#1:61,4\n31#1:65\n31#1:66,3\n31#1:76,3\n31#1:81,2\n32#1:83\n32#1:84,3\n32#1:94,3\n32#1:99,2\n33#1:101\n33#1:102,3\n32#1:105\n31#1:106\n31#1:69,7\n31#1:79\n31#1:80\n32#1:87,7\n32#1:97\n32#1:98\n*E\n"})
public final class CheckerPriorityConfig {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<String> categoryList;
    @NotNull
    private final List<String> severityList;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;
    @NotNull
    private static final Yaml yamlFormat;

    public CheckerPriorityConfig(@NotNull List<String> categoryList, @NotNull List<String> severityList) {
        Intrinsics.checkNotNullParameter(categoryList, (String)"categoryList");
        Intrinsics.checkNotNullParameter(severityList, (String)"severityList");
        this.categoryList = categoryList;
        this.severityList = severityList;
    }

    @NotNull
    public final List<String> getCategoryList() {
        return this.categoryList;
    }

    @SerialName(value="category")
    public static /* synthetic */ void getCategoryList$annotations() {
    }

    @NotNull
    public final List<String> getSeverityList() {
        return this.severityList;
    }

    @SerialName(value="severity")
    public static /* synthetic */ void getSeverityList$annotations() {
    }

    /*
     * WARNING - void declaration
     */
    private final Comparator<ChapterFlat> getComparator() {
        void $this$associateTo$iv$iv;
        Object object;
        void $this$associateTo$iv$iv2;
        Iterable $this$associate$iv = CollectionsKt.withIndex((Iterable)this.categoryList);
        boolean $i$f$associate = false;
        int capacity$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associate$iv, (int)10)), (int)16);
        Iterable iterable = $this$associate$iv;
        Object destination$iv$iv = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateTo = false;
        for (Object element$iv$iv : $this$associateTo$iv$iv2) {
            Map map = destination$iv$iv;
            IndexedValue it = (IndexedValue)element$iv$iv;
            boolean bl = false;
            object = TuplesKt.to((Object)it.getValue(), (Object)it.getIndex());
            map.put(object.getFirst(), object.getSecond());
        }
        Map categoryMap = destination$iv$iv;
        Iterable $this$associate$iv2 = CollectionsKt.withIndex((Iterable)this.severityList);
        boolean $i$f$associate2 = false;
        int capacity$iv2 = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associate$iv2, (int)10)), (int)16);
        destination$iv$iv = $this$associate$iv2;
        Map destination$iv$iv2 = new LinkedHashMap(capacity$iv2);
        boolean $i$f$associateTo2 = false;
        for (Object element$iv$iv : $this$associateTo$iv$iv) {
            object = destination$iv$iv2;
            IndexedValue it = (IndexedValue)element$iv$iv;
            boolean bl = false;
            Pair pair = TuplesKt.to((Object)it.getValue(), (Object)it.getIndex());
            object.put(pair.getFirst(), pair.getSecond());
        }
        Map severityMap = destination$iv$iv2;
        return (Comparator)new /* Unavailable Anonymous Inner Class!! */;
    }

    private final List<ChapterFlat> sort(List<ChapterFlat> chapters) {
        return CollectionsKt.toList((Iterable)CollectionsKt.toSortedSet((Iterable)chapters, (Comparator)this.getComparator()));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Map<String, Map<String, List<String>>> getSortTree(@NotNull List<ChapterFlat> chapters) {
        void $this$mapValuesTo$iv$iv;
        Object value$iv$iv$iv;
        Object key$iv$iv;
        Map $this$groupByTo$iv$iv;
        Intrinsics.checkNotNullParameter(chapters, (String)"chapters");
        Iterable $this$groupBy$iv = this.sort(chapters);
        boolean $i$f$groupBy = false;
        Iterable iterable = $this$groupBy$iv;
        Map destination$iv$iv = new LinkedHashMap();
        boolean $i$f$groupByTo = false;
        Iterator iterator2 = $this$groupByTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Object object;
            Object element$iv$iv = iterator2.next();
            ChapterFlat it = (ChapterFlat)element$iv$iv;
            boolean bl = false;
            key$iv$iv = it.getCategory();
            Map $this$getOrPut$iv$iv$iv = destination$iv$iv;
            boolean $i$f$getOrPut = false;
            value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                boolean bl2 = false;
                List answer$iv$iv$iv = new ArrayList();
                $this$getOrPut$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                object = answer$iv$iv$iv;
            } else {
                object = value$iv$iv$iv;
            }
            List list$iv$iv = (List)object;
            list$iv$iv.add(element$iv$iv);
        }
        Map $this$mapValues$iv = destination$iv$iv;
        boolean $i$f$mapValues = false;
        $this$groupByTo$iv$iv = $this$mapValues$iv;
        destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity((int)$this$mapValues$iv.size()));
        boolean $i$f$mapValuesTo = false;
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValuesTo$iv$iv.entrySet();
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            void $this$mapValuesTo$iv$iv2;
            void $this$mapValues$iv2;
            Object value$iv$iv$iv2;
            Object key$iv$iv2;
            void $this$groupByTo$iv$iv2;
            void it1;
            void it$iv$iv;
            key$iv$iv = (Map.Entry)element$iv$iv$iv;
            Map map = destination$iv$iv;
            boolean bl = false;
            value$iv$iv$iv = (Map.Entry)element$iv$iv$iv;
            Object k = it$iv$iv.getKey();
            Map map2 = map;
            boolean bl3 = false;
            Object $this$groupBy$iv2 = (Iterable)it1.getValue();
            boolean $i$f$groupBy2 = false;
            Iterable iterable2 = $this$groupBy$iv2;
            Map destination$iv$iv2 = new LinkedHashMap();
            boolean $i$f$groupByTo2 = false;
            for (Object element$iv$iv : $this$groupByTo$iv$iv2) {
                Object object;
                ChapterFlat it = (ChapterFlat)element$iv$iv;
                boolean bl4 = false;
                key$iv$iv2 = it.getSeverity();
                Map $this$getOrPut$iv$iv$iv = destination$iv$iv2;
                boolean $i$f$getOrPut = false;
                value$iv$iv$iv2 = $this$getOrPut$iv$iv$iv.get(key$iv$iv2);
                if (value$iv$iv$iv2 == null) {
                    boolean bl5 = false;
                    List answer$iv$iv$iv = new ArrayList();
                    $this$getOrPut$iv$iv$iv.put(key$iv$iv2, answer$iv$iv$iv);
                    object = answer$iv$iv$iv;
                } else {
                    object = value$iv$iv$iv2;
                }
                List list$iv$iv = (List)object;
                list$iv$iv.add(element$iv$iv);
            }
            $this$groupBy$iv2 = destination$iv$iv2;
            boolean $i$f$mapValues2 = false;
            $this$groupByTo$iv$iv2 = $this$mapValues$iv2;
            destination$iv$iv2 = new LinkedHashMap(MapsKt.mapCapacity((int)$this$mapValues$iv2.size()));
            boolean $i$f$mapValuesTo2 = false;
            Iterable $this$associateByTo$iv$iv$iv2 = $this$mapValuesTo$iv$iv2.entrySet();
            boolean $i$f$associateByTo2 = false;
            for (Object element$iv$iv$iv2 : $this$associateByTo$iv$iv$iv2) {
                void $this$mapTo$iv$iv;
                void it2;
                void it$iv$iv2;
                key$iv$iv2 = (Map.Entry)element$iv$iv$iv2;
                Map map3 = destination$iv$iv2;
                $i$a$-associateByTo-MapsKt__MapsKt$mapValuesTo$1$iv$iv = false;
                value$iv$iv$iv2 = (Map.Entry)element$iv$iv$iv2;
                Object k2 = it$iv$iv2.getKey();
                Map map4 = map3;
                boolean bl6 = false;
                Iterable $this$map$iv = (Iterable)it2.getValue();
                boolean $i$f$map = false;
                Iterable iterable3 = $this$map$iv;
                Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void it;
                    ChapterFlat chapterFlat = (ChapterFlat)item$iv$iv;
                    Collection collection = destination$iv$iv3;
                    boolean bl7 = false;
                    collection.add(it.getRuleId());
                }
                List list = (List)destination$iv$iv3;
                map4.put(k2, list);
            }
            Map map5 = destination$iv$iv2;
            map2.put(k, map5);
        }
        return destination$iv$iv;
    }

    @NotNull
    public final Iterable<IndexedValue<ChapterFlat>> getRuleWithSortNumber(@NotNull List<ChapterFlat> chapters) {
        Intrinsics.checkNotNullParameter(chapters, (String)"chapters");
        return CollectionsKt.withIndex((Iterable)this.sort(chapters));
    }

    @NotNull
    public final List<String> component1() {
        return this.categoryList;
    }

    @NotNull
    public final List<String> component2() {
        return this.severityList;
    }

    @NotNull
    public final CheckerPriorityConfig copy(@NotNull List<String> categoryList, @NotNull List<String> severityList) {
        Intrinsics.checkNotNullParameter(categoryList, (String)"categoryList");
        Intrinsics.checkNotNullParameter(severityList, (String)"severityList");
        return new CheckerPriorityConfig(categoryList, severityList);
    }

    public static /* synthetic */ CheckerPriorityConfig copy$default(CheckerPriorityConfig checkerPriorityConfig, List list, List list2, int n, Object object) {
        if ((n & 1) != 0) {
            list = checkerPriorityConfig.categoryList;
        }
        if ((n & 2) != 0) {
            list2 = checkerPriorityConfig.severityList;
        }
        return checkerPriorityConfig.copy(list, list2);
    }

    @NotNull
    public String toString() {
        return "CheckerPriorityConfig(categoryList=" + this.categoryList + ", severityList=" + this.severityList + ")";
    }

    public int hashCode() {
        int result = ((Object)this.categoryList).hashCode();
        result = result * 31 + ((Object)this.severityList).hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckerPriorityConfig)) {
            return false;
        }
        CheckerPriorityConfig checkerPriorityConfig = (CheckerPriorityConfig)other;
        if (!Intrinsics.areEqual((Object)this.categoryList, (Object)checkerPriorityConfig.categoryList)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.severityList, (Object)checkerPriorityConfig.severityList);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_api(CheckerPriorityConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArray = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)kSerializerArray[0], (Object)self.categoryList);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)kSerializerArray[1], (Object)self.severityList);
    }

    public /* synthetic */ CheckerPriorityConfig(int seen0, List categoryList, List severityList, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.categoryList = categoryList;
        this.severityList = severityList;
    }

    public static final /* synthetic */ Yaml access$getYamlFormat$cp() {
        return yamlFormat;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE)};
        $childSerializers = kSerializerArray;
        yamlFormat = new Yaml(null, null, 3, null);
    }
}

