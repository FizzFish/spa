/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.Counter
 *  cn.sast.common.IResFile
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.text.Charsets
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.api.report;

import cn.sast.common.IResFile;
import java.io.Closeable;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\u0002\u0010\rJ\u0013\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0011J(\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0013H\u0002J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\tJ\u0006\u0010\u001b\u001a\u00020\u0010R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Lcn/sast/api/report/Counter;", "T", "", "<init>", "()V", "statistics", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicInteger;", "count", "", "item", "map", "", "(Ljava/lang/Object;Ljava/util/Map;)V", "(Ljava/lang/Object;)V", "get", "", "(Ljava/lang/Object;)I", "sortMap", "", "input", "writeResults", "file", "Lcn/sast/common/IResFile;", "isNotEmpty", "", "clear", "size", "corax-api"})
@SourceDebugExtension(value={"SMAP\nCounter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Counter.kt\ncn/sast/api/report/Counter\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,53:1\n462#2:54\n412#2:55\n1246#3,4:56\n1062#3:60\n1216#3,2:61\n1246#3,4:63\n1053#3:67\n*S KotlinDebug\n*F\n+ 1 Counter.kt\ncn/sast/api/report/Counter\n*L\n26#1:54\n26#1:55\n26#1:56,4\n26#1:60\n27#1:61,2\n27#1:63,4\n36#1:67\n*E\n"})
public final class Counter<T> {
    @NotNull
    private ConcurrentHashMap<T, AtomicInteger> statistics = new ConcurrentHashMap();

    public final void count(T item, @NotNull Map<T, AtomicInteger> map) {
        Intrinsics.checkNotNullParameter(map, (String)"map");
        AtomicInteger ai = null;
        ai = new AtomicInteger();
        Counter $this$count_u24lambda_u240 = this;
        boolean bl = false;
        AtomicInteger old = map.putIfAbsent(item, ai);
        if (old != null) {
            ai = old;
        }
        ai.incrementAndGet();
    }

    public final void count(T item) {
        this.count(item, (Map)this.statistics);
    }

    public final int get(T item) {
        AtomicInteger atomicInteger = (AtomicInteger)this.statistics.get(item);
        return atomicInteger != null ? atomicInteger.get() : 0;
    }

    /*
     * WARNING - void declaration
     */
    private final Map<T, Integer> sortMap(Map<T, ? extends AtomicInteger> input) {
        void $this$associateByTo$iv$iv;
        Integer n;
        Map map;
        Object k;
        void $this$mapValuesTo$iv$iv;
        Map<T, AtomicInteger> $this$mapValues$iv = input;
        boolean $i$f$mapValues = false;
        Map<T, AtomicInteger> map2 = $this$mapValues$iv;
        Object destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity((int)$this$mapValues$iv.size()));
        boolean $i$f$mapValuesTo = false;
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValuesTo$iv$iv.entrySet();
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            void it;
            void it$iv$iv;
            Map.Entry entry = (Map.Entry)element$iv$iv$iv;
            Map map3 = destination$iv$iv;
            boolean bl = false;
            Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
            k = it$iv$iv.getKey();
            map = map3;
            boolean bl2 = false;
            n = ((AtomicInteger)it.getValue()).get();
            map.put(k, n);
        }
        Iterable $this$sortedByDescending$iv = destination$iv$iv.entrySet();
        boolean $i$f$sortedByDescending = false;
        Iterable $this$associateBy$iv = CollectionsKt.sortedWith((Iterable)$this$sortedByDescending$iv, (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */));
        boolean $i$f$associateBy = false;
        int capacity$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateBy$iv, (int)10)), (int)16);
        destination$iv$iv = $this$associateBy$iv;
        Map destination$iv$iv2 = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateByTo2 = false;
        for (Object element$iv$iv : $this$associateByTo$iv$iv) {
            Object element$iv$iv$iv;
            element$iv$iv$iv = (Map.Entry)element$iv$iv;
            map = destination$iv$iv2;
            boolean bl = false;
            Map.Entry it = (Map.Entry)element$iv$iv;
            k = it.getKey();
            boolean bl3 = false;
            n = ((Number)it.getValue()).intValue();
            map.put(k, n);
        }
        return destination$iv$iv2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void writeResults(@NotNull IResFile file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        Map statistics = this.sortMap((Map)this.statistics);
        if (statistics.isEmpty()) {
            return;
        }
        file.mkdirs();
        Object object = file.getPath();
        Unit unit = new Unit[]{};
        Object object2 = Charsets.UTF_8;
        object = new OutputStreamWriter(Files.newOutputStream((Path)object, Arrays.copyOf(unit, ((OpenOption[])unit).length)), (Charset)object2);
        object2 = null;
        try {
            OutputStreamWriter writer = (OutputStreamWriter)object;
            boolean bl = false;
            writer.write("--------sort--------\n");
            Iterable entry = statistics.keySet();
            boolean $i$f$sortedBy = false;
            for (Object e : CollectionsKt.sortedWith((Iterable)entry, (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */))) {
                writer.write(e + "\n");
            }
            writer.write("\n--------frequency--------\n");
            for (Map.Entry entry2 : statistics.entrySet()) {
                Object item = entry2.getKey();
                int count = ((Number)entry2.getValue()).intValue();
                writer.write(count + " " + item + "\n");
            }
            writer.flush();
            unit = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            object2 = throwable;
            throw throwable;
        }
        finally {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        }
    }

    public final boolean isNotEmpty() {
        return !((Map)this.statistics).isEmpty();
    }

    public final void clear() {
        this.statistics.clear();
    }

    public final int size() {
        return this.statistics.size();
    }
}

