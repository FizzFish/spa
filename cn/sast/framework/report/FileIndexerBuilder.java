/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResFile
 *  cn.sast.framework.report.FileIndexer
 *  cn.sast.framework.report.FileIndexerBuilder
 *  cn.sast.framework.report.FileIndexerBuilder$Companion
 *  kotlin.Metadata
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  soot.util.ArraySet
 */
package cn.sast.framework.report;

import cn.sast.common.IResFile;
import cn.sast.framework.report.FileIndexer;
import cn.sast.framework.report.FileIndexerBuilder;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import soot.util.ArraySet;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\u000fR \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u0004\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u00078\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2={"Lcn/sast/framework/report/FileIndexerBuilder;", "", "<init>", "()V", "fileNameToPathMap", "Ljava/util/concurrent/ConcurrentNavigableMap;", "", "Ljava/util/NavigableSet;", "Lcn/sast/common/IResFile;", "extensionToPathMap", "addIndexMap", "", "resFile", "union", "indexer", "Lcn/sast/framework/report/FileIndexer;", "build", "compressToSet", "", "E", "getCompressToSet", "(Ljava/util/NavigableSet;)Ljava/util/Set;", "sortAndOptimizeMem", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nJavaSourceLocator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaSourceLocator.kt\ncn/sast/framework/report/FileIndexerBuilder\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,490:1\n267#1,5:507\n267#1,5:517\n72#2,2:491\n72#2,2:494\n72#2,2:497\n72#2,2:500\n1#3:493\n1#3:496\n1#3:499\n1#3:502\n462#4:503\n412#4:504\n462#4:513\n412#4:514\n1246#5,2:505\n1249#5:512\n1246#5,2:515\n1249#5:522\n*S KotlinDebug\n*F\n+ 1 JavaSourceLocator.kt\ncn/sast/framework/report/FileIndexerBuilder\n*L\n277#1:507,5\n278#1:517,5\n248#1:491,2\n249#1:494,2\n254#1:497,2\n257#1:500,2\n248#1:493\n249#1:496\n254#1:499\n257#1:502\n277#1:503\n277#1:504\n278#1:513\n278#1:514\n277#1:505,2\n277#1:512\n278#1:515,2\n278#1:522\n*E\n"})
public class FileIndexerBuilder {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ConcurrentNavigableMap<String, NavigableSet<IResFile>> fileNameToPathMap = new ConcurrentSkipListMap();
    @NotNull
    private final ConcurrentNavigableMap<String, NavigableSet<IResFile>> extensionToPathMap = new ConcurrentSkipListMap();

    public final void addIndexMap(@NotNull IResFile resFile) {
        boolean bl;
        NavigableSet default$iv;
        ConcurrentMap $this$getOrPut$iv;
        Intrinsics.checkNotNullParameter((Object)resFile, (String)"resFile");
        if (!resFile.isFile()) {
            return;
        }
        ConcurrentMap concurrentMap = this.fileNameToPathMap;
        String key$iv = resFile.getName();
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(key$iv);
        if (object == null) {
            boolean bl2 = false;
            default$iv = new ConcurrentSkipListSet();
            bl = false;
            object = $this$getOrPut$iv.putIfAbsent(key$iv, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        ((NavigableSet)object).add(resFile);
        $this$getOrPut$iv = this.extensionToPathMap;
        key$iv = resFile.getExtension();
        $i$f$getOrPut = false;
        Object object2 = $this$getOrPut$iv.get(key$iv);
        if (object2 == null) {
            boolean bl3 = false;
            default$iv = new ConcurrentSkipListSet();
            bl = false;
            object2 = $this$getOrPut$iv.putIfAbsent(key$iv, default$iv);
            if (object2 == null) {
                object2 = default$iv;
            }
        }
        ((NavigableSet)object2).add(resFile);
    }

    public final void union(@NotNull FileIndexer indexer2) {
        boolean bl;
        NavigableSet default$iv;
        boolean $i$f$getOrPut;
        ConcurrentMap $this$getOrPut$iv;
        Set v;
        String k;
        Intrinsics.checkNotNullParameter((Object)indexer2, (String)"indexer");
        for (Map.Entry entry : indexer2.getFileNameToPathMap$corax_framework().entrySet()) {
            k = (String)entry.getKey();
            v = (Set)entry.getValue();
            $this$getOrPut$iv = this.fileNameToPathMap;
            $i$f$getOrPut = false;
            Object object = $this$getOrPut$iv.get(k);
            if (object == null) {
                boolean bl2 = false;
                default$iv = new ConcurrentSkipListSet();
                bl = false;
                object = $this$getOrPut$iv.putIfAbsent(k, default$iv);
                if (object == null) {
                    object = default$iv;
                }
            }
            ((NavigableSet)object).addAll(v);
        }
        for (Map.Entry entry : indexer2.getExtensionToPathMap$corax_framework().entrySet()) {
            k = (String)entry.getKey();
            v = (Set)entry.getValue();
            $this$getOrPut$iv = this.extensionToPathMap;
            $i$f$getOrPut = false;
            Object object = $this$getOrPut$iv.get(k);
            if (object == null) {
                boolean bl3 = false;
                default$iv = new ConcurrentSkipListSet();
                bl = false;
                object = $this$getOrPut$iv.putIfAbsent(k, default$iv);
                if (object == null) {
                    object = default$iv;
                }
            }
            ((NavigableSet)object).addAll(v);
        }
    }

    @NotNull
    public final FileIndexer build() {
        return new FileIndexer((Map)this.fileNameToPathMap, (Map)this.extensionToPathMap);
    }

    private final <E> Set<E> getCompressToSet(NavigableSet<E> $this$compressToSet) {
        Set set;
        boolean $i$f$getCompressToSet = false;
        int n = $this$compressToSet.size();
        if (n == 0) {
            set = SetsKt.emptySet();
        } else if (n == 1) {
            Set set2 = Collections.singleton($this$compressToSet.first());
            set = set2;
            Intrinsics.checkNotNullExpressionValue(set2, (String)"singleton(...)");
        } else {
            set = (0 <= n ? n < 17 : false) ? (Set)new ArraySet((Collection)$this$compressToSet) : (Set)$this$compressToSet;
        }
        return set;
    }

    @NotNull
    public final FileIndexer sortAndOptimizeMem() {
        Set<Object> set;
        int n;
        boolean $i$f$getCompressToSet;
        NavigableSet $this$compressToSet$iv;
        Map.Entry it;
        Map map;
        Object object;
        Map.Entry it$iv$iv;
        boolean bl;
        Map map2;
        Map $this$mapValuesTo$iv$iv;
        Map $this$mapValues$iv = this.fileNameToPathMap;
        boolean $i$f$mapValues = false;
        Map map3 = $this$mapValues$iv;
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity((int)$this$mapValues$iv.size()));
        boolean $i$f$mapValuesTo = false;
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValuesTo$iv$iv.entrySet();
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Set set2;
            Map.Entry entry = (Map.Entry)element$iv$iv$iv;
            map2 = destination$iv$iv;
            bl = false;
            Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
            object = it$iv$iv.getKey();
            map = map2;
            boolean bl2 = false;
            FileIndexerBuilder fileIndexerBuilder = this;
            Object v = it.getValue();
            Intrinsics.checkNotNullExpressionValue(v, (String)"<get-value>(...)");
            $this$compressToSet$iv = (NavigableSet)v;
            $i$f$getCompressToSet = false;
            n = $this$compressToSet$iv.size();
            if (n == 0) {
                set2 = SetsKt.emptySet();
            } else if (n == 1) {
                Set set3 = Collections.singleton($this$compressToSet$iv.first());
                set2 = set3;
                Intrinsics.checkNotNullExpressionValue(set3, (String)"singleton(...)");
            } else {
                set2 = (0 <= n ? n < 17 : false) ? (Set)new ArraySet((Collection)$this$compressToSet$iv) : (Set)$this$compressToSet$iv;
            }
            set = set2;
            map.put(object, set);
        }
        $this$mapValues$iv = this.extensionToPathMap;
        map = destination$iv$iv;
        $i$f$mapValues = false;
        $this$mapValuesTo$iv$iv = $this$mapValues$iv;
        destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity((int)$this$mapValues$iv.size()));
        $i$f$mapValuesTo = false;
        $this$associateByTo$iv$iv$iv = $this$mapValuesTo$iv$iv.entrySet();
        $i$f$associateByTo = false;
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Set set4;
            it$iv$iv = (Map.Entry)element$iv$iv$iv;
            map2 = destination$iv$iv;
            bl = false;
            it = (Map.Entry)element$iv$iv$iv;
            set = it$iv$iv.getKey();
            object = map2;
            boolean bl3 = false;
            FileIndexerBuilder this_$iv = this;
            Object v = it.getValue();
            Intrinsics.checkNotNullExpressionValue(v, (String)"<get-value>(...)");
            $this$compressToSet$iv = (NavigableSet)v;
            $i$f$getCompressToSet = false;
            n = $this$compressToSet$iv.size();
            if (n == 0) {
                set4 = SetsKt.emptySet();
            } else if (n == 1) {
                Set set5 = Collections.singleton($this$compressToSet$iv.first());
                set4 = set5;
                Intrinsics.checkNotNullExpressionValue(set5, (String)"singleton(...)");
            } else {
                set4 = (0 <= n ? n < 17 : false) ? (Set)new ArraySet((Collection)$this$compressToSet$iv) : (Set)$this$compressToSet$iv;
            }
            Set set6 = set4;
            object.put((Set)set, set6);
        }
        Map map4 = destination$iv$iv;
        Map map5 = map;
        return new FileIndexer(map5, map4);
    }
}

