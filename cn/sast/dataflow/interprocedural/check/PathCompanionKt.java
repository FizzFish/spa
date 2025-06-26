/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.CompanionValueOfConst
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  cn.sast.dataflow.interprocedural.check.MergePath
 *  cn.sast.dataflow.interprocedural.check.MergePath$Companion
 *  cn.sast.dataflow.interprocedural.check.PathCompanionKt
 *  cn.sast.dataflow.interprocedural.check.PathCompanionV
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.CompanionValueOfConst;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.MergePath;
import cn.sast.dataflow.interprocedural.check.PathCompanionV;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00152\u0006\u0010\u0016\u001a\u00020\u0017\"#\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006*\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\"<\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r0\u000b\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r0\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"*\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0010\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0012*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001*\f\b\u0000\u0010\u0002\"\u00020\u00032\u00020\u0003\u00a8\u0006\u0018"}, d2={"CompanionValueImpl", "Lcn/sast/dataflow/interprocedural/check/CompanionValueImpl1;", "CompanionValueImplConst", "Lcn/sast/dataflow/interprocedural/check/CompanionValueOfConst;", "bindDelegate", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "getBindDelegate", "(Lcn/sast/dataflow/interprocedural/analysis/CompanionV;)Lcn/sast/dataflow/interprocedural/analysis/IValue;", "short", "", "K", "V", "getShort", "(Ljava/util/Map;)Ljava/util/Map;", "", "E", "(Ljava/util/Set;)Ljava/util/Set;", "path", "Lcn/sast/dataflow/interprocedural/check/IPath;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nPathCompanion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathCompanion.kt\ncn/sast/dataflow/interprocedural/check/PathCompanionKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,994:1\n1628#2,3:995\n*S KotlinDebug\n*F\n+ 1 PathCompanion.kt\ncn/sast/dataflow/interprocedural/check/PathCompanionKt\n*L\n643#1:995,3\n*E\n"})
public final class PathCompanionKt {
    @NotNull
    public static final IValue getBindDelegate(@NotNull CompanionV<IValue> $this$bindDelegate) {
        Intrinsics.checkNotNullParameter($this$bindDelegate, (String)"<this>");
        return $this$bindDelegate instanceof CompanionValueOfConst ? ((CompanionValueOfConst)$this$bindDelegate).getAttr() : (IValue)$this$bindDelegate.getValue();
    }

    private static final <K, V> Map<K, V> getShort(Map<K, ? extends V> $this$short) {
        int sz = $this$short.size();
        return switch (sz) {
            case 1 -> {
                Map.Entry<K, V> var3_2 = $this$short.entrySet().iterator().next();
                K k = var3_2.getKey();
                V v = var3_2.getValue();
                Map<K, V> var2_5 = Collections.singletonMap(k, v);
                Intrinsics.checkNotNull(var2_5);
                yield var2_5;
            }
            case 0 -> {
                Map var2_6 = Collections.emptyMap();
                Intrinsics.checkNotNull(var2_6);
                yield var2_6;
            }
            default -> $this$short;
        };
    }

    private static final <E> Set<E> getShort(Set<? extends E> $this$short) {
        int sz = $this$short.size();
        return switch (sz) {
            case 1 -> {
                E e = $this$short.iterator().next();
                Set<E> var2_3 = Collections.singleton(e);
                Intrinsics.checkNotNull(var2_3);
                yield var2_3;
            }
            case 0 -> {
                Set var2_4 = Collections.emptySet();
                Intrinsics.checkNotNull(var2_4);
                yield var2_4;
            }
            default -> $this$short;
        };
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final IPath path(@NotNull IHeapValues<IValue> $this$path, @NotNull HeapValuesEnv env) {
        Collection collection;
        void $this$mapTo$iv;
        Intrinsics.checkNotNullParameter($this$path, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Iterable iterable = (Iterable)$this$path.getValuesCompanion();
        Collection collection2 = new HashSet($this$path.getValuesCompanion().size());
        HeapValuesEnv heapValuesEnv = env;
        MergePath.Companion companion = MergePath.Companion;
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            void destination$iv;
            CompanionV companionV = (CompanionV)item$iv;
            collection = destination$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)it, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.check.PathCompanionV");
            collection.add(((PathCompanionV)it).getPath());
        }
        collection = collection2;
        return companion.v(heapValuesEnv, (Set)collection);
    }

    public static final /* synthetic */ Map access$getShort(Map $receiver) {
        return PathCompanionKt.getShort((Map)$receiver);
    }
}

