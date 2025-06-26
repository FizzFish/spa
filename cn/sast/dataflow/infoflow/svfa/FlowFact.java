/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.svfa.FlowFact
 *  cn.sast.dataflow.infoflow.svfa.VFNode
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.PersistentMap
 *  kotlinx.collections.immutable.PersistentSet
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Value
 */
package cn.sast.dataflow.infoflow.svfa;

import cn.sast.dataflow.infoflow.svfa.VFNode;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentMap;
import kotlinx.collections.immutable.PersistentSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Value;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R,\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2={"Lcn/sast/dataflow/infoflow/svfa/FlowFact;", "", "<init>", "()V", "data", "Lkotlinx/collections/immutable/PersistentMap;", "Lsoot/Value;", "Lkotlinx/collections/immutable/PersistentSet;", "Lcn/sast/dataflow/infoflow/svfa/VFNode;", "getData", "()Lkotlinx/collections/immutable/PersistentMap;", "setData", "(Lkotlinx/collections/immutable/PersistentMap;)V", "toString", "", "hashCode", "", "equals", "", "other", "corax-data-flow"})
public final class FlowFact {
    @NotNull
    private PersistentMap<Value, ? extends PersistentSet<VFNode>> data = ExtensionsKt.persistentHashMapOf();

    @NotNull
    public final PersistentMap<Value, PersistentSet<VFNode>> getData() {
        return this.data;
    }

    public final void setData(@NotNull PersistentMap<Value, ? extends PersistentSet<VFNode>> persistentMap) {
        Intrinsics.checkNotNullParameter(persistentMap, (String)"<set-?>");
        this.data = persistentMap;
    }

    @NotNull
    public String toString() {
        return "\n" + CollectionsKt.joinToString$default((Iterable)CollectionsKt.flatten((Iterable)this.data.values()), (CharSequence)"\n", null, null, (int)0, null, null, (int)62, null);
    }

    public int hashCode() {
        Object[] objectArray = new Object[]{this.data};
        return Objects.hash(objectArray);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowFact)) {
            return false;
        }
        return Intrinsics.areEqual((Object)((FlowFact)other).data, (Object)this.data);
    }
}

