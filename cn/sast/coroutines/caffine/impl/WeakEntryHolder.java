/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.coroutines.caffine.impl.WeakEntryHolder
 *  com.google.common.collect.Maps
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.coroutines.caffine.impl;

import com.google.common.collect.Maps;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\fR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lcn/sast/coroutines/caffine/impl/WeakEntryHolder;", "K", "V", "", "<init>", "()V", "referenceQueue", "Ljava/lang/ref/ReferenceQueue;", "backingMap", "", "Ljava/lang/ref/Reference;", "put", "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "clean", "corax-api"})
public final class WeakEntryHolder<K, V> {
    @NotNull
    private final ReferenceQueue<V> referenceQueue = new ReferenceQueue();
    @NotNull
    private final Map<Reference<? extends V>, K> backingMap;

    public WeakEntryHolder() {
        ConcurrentMap concurrentMap = Maps.newConcurrentMap();
        Intrinsics.checkNotNullExpressionValue((Object)concurrentMap, (String)"newConcurrentMap(...)");
        this.backingMap = concurrentMap;
    }

    public final void put(K key2, V value) {
        this.clean();
        WeakReference<V> reference = new WeakReference<V>(value, this.referenceQueue);
        this.backingMap.put(reference, key2);
    }

    public final void clean() {
        Reference ref = this.referenceQueue.poll();
        while (ref != null) {
            this.backingMap.remove(ref);
            ref = this.referenceQueue.poll();
        }
    }
}

