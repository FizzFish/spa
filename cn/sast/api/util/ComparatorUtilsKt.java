/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.ComparatorUtilsKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000,\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0006\u001a<\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0003j\b\u0012\u0004\u0012\u0002H\u0002`\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001az\u0010\b\u001a\u00020\u0001\"\u000e\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n\"\u000e\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\n**\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u000b0\f0\u0003j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u000b0\f`\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u000b0\r\u001aJ\u0010\b\u001a\u00020\u0001\"\u000e\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n\"\u000e\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\n*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u000b0\r\u001a.\u0010\u000f\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\n*\b\u0012\u0004\u0012\u0002H\u00100\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0006\u001a+\u0010\u0011\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n*\u0004\u0018\u0001H\u00022\b\u0010\u000e\u001a\u0004\u0018\u0001H\u0002\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006\u0013"}, d2={"compareTo", "", "T", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "a", "", "b", "compareToMap", "K", "", "V", "Lkotlin/Pair;", "", "other", "compareToCollection", "E", "compareToNullable", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "corax-api"})
@SourceDebugExtension(value={"SMAP\nComparatorUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComparatorUtils.kt\ncn/sast/api/util/ComparatorUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,37:1\n1#2:38\n*E\n"})
public final class ComparatorUtilsKt {
    public static final <T> int compareTo(@NotNull Comparator<T> $this$compareTo, @NotNull Collection<? extends T> a, @NotNull Collection<? extends T> b) {
        Intrinsics.checkNotNullParameter($this$compareTo, (String)"<this>");
        Intrinsics.checkNotNullParameter(a, (String)"a");
        Intrinsics.checkNotNullParameter(b, (String)"b");
        Iterator<T> bI = b.iterator();
        for (T e : a) {
            if (!bI.hasNext()) {
                return 1;
            }
            int c = $this$compareTo.compare(e, bI.next());
            if (c == 0) continue;
            return c;
        }
        if (bI.hasNext()) {
            return -1;
        }
        return 0;
    }

    public static final <K extends Comparable<? super K>, V extends Comparable<? super V>> int compareToMap(@NotNull Comparator<Pair<K, V>> $this$compareToMap, @NotNull Map<K, ? extends V> a, @NotNull Map<K, ? extends V> b) {
        Integer n;
        Intrinsics.checkNotNullParameter($this$compareToMap, (String)"<this>");
        Intrinsics.checkNotNullParameter(a, (String)"a");
        Intrinsics.checkNotNullParameter(b, (String)"b");
        Integer n2 = Intrinsics.compare((int)a.size(), (int)b.size());
        int it = ((Number)n2).intValue();
        boolean bl = false;
        Integer n3 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl2 = false;
            return it;
        }
        List aSorted = CollectionsKt.sortedWith((Iterable)MapsKt.toList(a), $this$compareToMap);
        List bSorted = CollectionsKt.sortedWith((Iterable)MapsKt.toList(b), $this$compareToMap);
        return ComparatorUtilsKt.compareTo($this$compareToMap, (Collection)aSorted, (Collection)bSorted);
    }

    public static final <K extends Comparable<? super K>, V extends Comparable<? super V>> int compareToMap(@NotNull Map<K, ? extends V> $this$compareToMap, @NotNull Map<K, ? extends V> other) {
        Intrinsics.checkNotNullParameter($this$compareToMap, (String)"<this>");
        Intrinsics.checkNotNullParameter(other, (String)"other");
        Comparator comparator = ComparisonsKt.then((Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */), (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */));
        return ComparatorUtilsKt.compareToMap((Comparator)comparator, $this$compareToMap, other);
    }

    public static final <E extends Comparable<? super E>> int compareToCollection(@NotNull Collection<? extends E> $this$compareToCollection, @NotNull Collection<? extends E> other) {
        Intrinsics.checkNotNullParameter($this$compareToCollection, (String)"<this>");
        Intrinsics.checkNotNullParameter(other, (String)"other");
        return ComparatorUtilsKt.compareTo((Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */), $this$compareToCollection, other);
    }

    public static final <T extends Comparable<? super T>> int compareToNullable(@Nullable T $this$compareToNullable, @Nullable T other) {
        Integer n;
        if ($this$compareToNullable == null && other == null) {
            return 0;
        }
        if ($this$compareToNullable == null) {
            return 1;
        }
        if (other == null) {
            return -1;
        }
        Integer n2 = $this$compareToNullable.compareTo(other);
        int it = ((Number)n2).intValue();
        boolean bl = false;
        Integer n3 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl2 = false;
            return it;
        }
        return 0;
    }
}

