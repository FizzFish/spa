/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.Kotlin_extKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.api.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u001a\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0001\u001a+\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\b\"\u0002H\u0006\u00a2\u0006\u0002\u0010\t\u001a\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006\u00a8\u0006\n"}, d2={"nonNullValue", "", "K", "V", "concurrentHashSetOf", "", "E", "pairs", "", "([Ljava/lang/Object;)Ljava/util/Set;", "corax-api"})
@SourceDebugExtension(value={"SMAP\nkotlin-ext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 kotlin-ext.kt\ncn/sast/api/util/Kotlin_extKt\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,13:1\n136#2,9:14\n216#2:23\n217#2:25\n145#2:26\n1#3:24\n9326#4,2:27\n9476#4,4:29\n*S KotlinDebug\n*F\n+ 1 kotlin-ext.kt\ncn/sast/api/util/Kotlin_extKt\n*L\n7#1:14,9\n7#1:23\n7#1:25\n7#1:26\n7#1:24\n10#1:27,2\n10#1:29,4\n*E\n"})
public final class Kotlin_extKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V> Map<K, V> nonNullValue(@NotNull Map<K, ? extends V> $this$nonNullValue) {
        void $this$mapNotNullTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$nonNullValue, (String)"<this>");
        Map<K, ? extends V> $this$mapNotNull$iv = $this$nonNullValue;
        boolean $i$f$mapNotNull = false;
        Map<K, ? extends V> map = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Pair pair;
            Map.Entry element$iv$iv$iv;
            Map.Entry element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl = false;
            Map.Entry it = element$iv$iv;
            boolean bl2 = false;
            Object v = it.getValue();
            if (v == null) {
                Object var14_14 = null;
                pair = var14_14;
            } else {
                pair = TuplesKt.to(it.getKey(), v);
            }
            if (pair == null) continue;
            Pair it$iv$iv = pair;
            boolean bl3 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        return MapsKt.toMap((Iterable)((List)destination$iv$iv));
    }

    @NotNull
    public static final <E> Set<E> concurrentHashSetOf(E ... pairs) {
        Intrinsics.checkNotNullParameter(pairs, (String)"pairs");
        E[] $this$associateWith$iv = pairs;
        boolean $i$f$associateWith = false;
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)$this$associateWith$iv.length), (int)16));
        E[] $this$associateWithTo$iv$iv = $this$associateWith$iv;
        boolean $i$f$associateWithTo = false;
        int n = $this$associateWithTo$iv$iv.length;
        for (int i = 0; i < n; ++i) {
            E element$iv$iv;
            E e = element$iv$iv = $this$associateWithTo$iv$iv[i];
            E e2 = element$iv$iv;
            Map map = result$iv;
            boolean bl = false;
            Boolean bl2 = true;
            map.put(e2, bl2);
        }
        Map map = result$iv;
        Set set = Collections.newSetFromMap(new ConcurrentHashMap(map));
        Intrinsics.checkNotNullExpressionValue(set, (String)"newSetFromMap(...)");
        return set;
    }

    @NotNull
    public static final <E> Set<E> concurrentHashSetOf() {
        Set set = Collections.newSetFromMap(new ConcurrentHashMap());
        Intrinsics.checkNotNullExpressionValue(set, (String)"newSetFromMap(...)");
        return set;
    }
}

