/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.PathGeneratorKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.check;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\"'\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"removeAdjacentDuplicates", "", "E", "getRemoveAdjacentDuplicates", "(Ljava/util/List;)Ljava/util/List;", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nPathGenerator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathGenerator.kt\ncn/sast/dataflow/interprocedural/check/PathGeneratorKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,213:1\n774#2:214\n865#2,2:215\n1557#2:217\n1628#2,3:218\n*S KotlinDebug\n*F\n+ 1 PathGenerator.kt\ncn/sast/dataflow/interprocedural/check/PathGeneratorKt\n*L\n22#1:214\n22#1:215,2\n23#1:217\n23#1:218,3\n*E\n"})
public final class PathGeneratorKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <E> List<E> getRemoveAdjacentDuplicates(@NotNull List<? extends E> $this$removeAdjacentDuplicates) {
        List list;
        Intrinsics.checkNotNullParameter($this$removeAdjacentDuplicates, (String)"<this>");
        if ($this$removeAdjacentDuplicates.isEmpty()) {
            list = $this$removeAdjacentDuplicates;
        } else {
            void $this$mapTo$iv$iv;
            Pair it;
            Iterable $this$filterTo$iv$iv;
            Iterable $this$filter$iv = CollectionsKt.zipWithNext((Iterable)$this$removeAdjacentDuplicates);
            boolean $i$f$filter = false;
            Iterable iterable = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                it = (Pair)element$iv$iv;
                boolean bl = false;
                if (!(!Intrinsics.areEqual((Object)it.getFirst(), (Object)it.getSecond()))) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Iterable $this$map$iv = (List)destination$iv$iv;
            boolean $i$f$map = false;
            $this$filterTo$iv$iv = $this$map$iv;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                it = (Pair)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl = false;
                collection.add(it.getFirst());
            }
            list = CollectionsKt.plus((Collection)((List)destination$iv$iv), (Object)CollectionsKt.last($this$removeAdjacentDuplicates));
        }
        return list;
    }
}

