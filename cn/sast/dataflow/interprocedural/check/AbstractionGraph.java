/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.AbstractionGraph
 *  kotlin.Metadata
 *  kotlin._Assertions
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  soot.jimple.infoflow.data.Abstraction
 *  soot.toolkits.graph.DirectedGraph
 */
package cn.sast.dataflow.interprocedural.check;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.data.Abstraction;
import soot.toolkits.graph.DirectedGraph;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001c\u001a\u00020\u001dJ@\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\rH\u0002J<\u0010\"\u001a\u00020\u001d2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\r2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\rH\u0014J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020$H\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020$H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020$2\u0006\u0010'\u001a\u00020\u0002H\u0016J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020$2\u0006\u0010'\u001a\u00020\u0002H\u0016J\b\u0010)\u001a\u00020*H\u0016J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020,H\u0096\u0002J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0002J\u000e\u00100\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR,\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R,\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\u0018\u00a8\u00061"}, d2={"Lcn/sast/dataflow/interprocedural/check/AbstractionGraph;", "Lsoot/toolkits/graph/DirectedGraph;", "Lsoot/jimple/infoflow/data/Abstraction;", "sink", "<init>", "(Lsoot/jimple/infoflow/data/Abstraction;)V", "getSink", "()Lsoot/jimple/infoflow/data/Abstraction;", "absChain", "Ljava/util/ArrayList;", "getAbsChain", "()Ljava/util/ArrayList;", "unitToSuccs", "Ljava/util/IdentityHashMap;", "getUnitToSuccs", "()Ljava/util/IdentityHashMap;", "setUnitToSuccs", "(Ljava/util/IdentityHashMap;)V", "unitToPreds", "getUnitToPreds", "setUnitToPreds", "mHeads", "getMHeads", "setMHeads", "(Ljava/util/ArrayList;)V", "mTails", "getMTails", "setMTails", "buildHeadsAndTails", "", "addEdge", "currentAbs", "target", "successors", "buildUnexceptionalEdges", "getHeads", "", "getTails", "getPredsOf", "s", "getSuccsOf", "size", "", "iterator", "", "isTail", "", "abs", "isHead", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nAbstractionGraph.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractionGraph.kt\ncn/sast/dataflow/interprocedural/check/AbstractionGraph\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,239:1\n360#2,7:240\n360#2,7:247\n360#2,7:254\n*S KotlinDebug\n*F\n+ 1 AbstractionGraph.kt\ncn/sast/dataflow/interprocedural/check/AbstractionGraph\n*L\n60#1:240,7\n119#1:247,7\n123#1:254,7\n*E\n"})
public abstract class AbstractionGraph
implements DirectedGraph<Abstraction> {
    @NotNull
    private final Abstraction sink;
    @NotNull
    private final ArrayList<Abstraction> absChain;
    public IdentityHashMap<Abstraction, ArrayList<Abstraction>> unitToSuccs;
    public IdentityHashMap<Abstraction, ArrayList<Abstraction>> unitToPreds;
    public ArrayList<Abstraction> mHeads;
    public ArrayList<Abstraction> mTails;

    public AbstractionGraph(@NotNull Abstraction sink) {
        Intrinsics.checkNotNullParameter((Object)sink, (String)"sink");
        this.sink = sink;
        this.absChain = new ArrayList();
        LinkedList<Abstraction> abstractionQueue = new LinkedList<Abstraction>();
        abstractionQueue.add(this.sink);
        Set<Abstraction> set = Collections.newSetFromMap(new IdentityHashMap());
        while (!abstractionQueue.isEmpty()) {
            Object e = abstractionQueue.remove(0);
            Intrinsics.checkNotNullExpressionValue(e, (String)"removeAt(...)");
            Abstraction abstraction = (Abstraction)e;
            this.absChain.add(abstraction);
            if (abstraction.getSourceContext() != null) {
                boolean bl;
                boolean bl2 = bl = abstraction.getPredecessor() == null;
                if (_Assertions.ENABLED && !bl) {
                    String string = "Assertion failed";
                    throw new AssertionError((Object)string);
                }
            } else if (set.add(abstraction.getPredecessor())) {
                abstractionQueue.add(abstraction.getPredecessor());
            }
            if (abstraction.getNeighbors() == null) continue;
            for (Abstraction nb : abstraction.getNeighbors()) {
                if (!set.add(nb)) continue;
                abstractionQueue.add(nb);
            }
        }
    }

    @NotNull
    public final Abstraction getSink() {
        return this.sink;
    }

    @NotNull
    public final ArrayList<Abstraction> getAbsChain() {
        return this.absChain;
    }

    @NotNull
    public final IdentityHashMap<Abstraction, ArrayList<Abstraction>> getUnitToSuccs() {
        IdentityHashMap identityHashMap = this.unitToSuccs;
        if (identityHashMap != null) {
            return identityHashMap;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"unitToSuccs");
        return null;
    }

    public final void setUnitToSuccs(@NotNull IdentityHashMap<Abstraction, ArrayList<Abstraction>> identityHashMap) {
        Intrinsics.checkNotNullParameter(identityHashMap, (String)"<set-?>");
        this.unitToSuccs = identityHashMap;
    }

    @NotNull
    public final IdentityHashMap<Abstraction, ArrayList<Abstraction>> getUnitToPreds() {
        IdentityHashMap identityHashMap = this.unitToPreds;
        if (identityHashMap != null) {
            return identityHashMap;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"unitToPreds");
        return null;
    }

    public final void setUnitToPreds(@NotNull IdentityHashMap<Abstraction, ArrayList<Abstraction>> identityHashMap) {
        Intrinsics.checkNotNullParameter(identityHashMap, (String)"<set-?>");
        this.unitToPreds = identityHashMap;
    }

    @NotNull
    public final ArrayList<Abstraction> getMHeads() {
        ArrayList arrayList = this.mHeads;
        if (arrayList != null) {
            return arrayList;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"mHeads");
        return null;
    }

    public final void setMHeads(@NotNull ArrayList<Abstraction> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, (String)"<set-?>");
        this.mHeads = arrayList;
    }

    @NotNull
    public final ArrayList<Abstraction> getMTails() {
        ArrayList arrayList = this.mTails;
        if (arrayList != null) {
            return arrayList;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"mTails");
        return null;
    }

    public final void setMTails(@NotNull ArrayList<Abstraction> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, (String)"<set-?>");
        this.mTails = arrayList;
    }

    public final void buildHeadsAndTails() {
        this.setMTails(new ArrayList());
        this.setMHeads(new ArrayList());
        Iterator iterator2 = this.absChain.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator2, (String)"iterator(...)");
        Iterator iterator3 = iterator2;
        while (iterator3.hasNext()) {
            ArrayList preds;
            Collection collection;
            Object e = iterator3.next();
            Intrinsics.checkNotNullExpressionValue(e, (String)"next(...)");
            Abstraction s = (Abstraction)e;
            ArrayList succs = (ArrayList)this.getUnitToSuccs().get(s);
            Collection collection2 = succs;
            if (collection2 == null || collection2.isEmpty()) {
                this.getMTails().add(s);
            }
            if (!((collection = (Collection)(preds = (ArrayList)this.getUnitToPreds().get(s))) == null || collection.isEmpty())) continue;
            this.getMHeads().add(s);
        }
    }

    private final void addEdge(Abstraction currentAbs, Abstraction target, ArrayList<Abstraction> successors, IdentityHashMap<Abstraction, ArrayList<Abstraction>> unitToPreds) {
        int n;
        block4: {
            List $this$indexOfFirst$iv = successors;
            boolean $i$f$indexOfFirst = false;
            int index$iv = 0;
            for (Object item$iv : $this$indexOfFirst$iv) {
                Abstraction it = (Abstraction)item$iv;
                boolean bl = false;
                if (it == target) {
                    n = index$iv;
                    break block4;
                }
                ++index$iv;
            }
            n = -1;
        }
        if (n == -1) {
            successors.add(target);
            ArrayList<Object> preds = unitToPreds.get(target);
            if (preds == null) {
                preds = new ArrayList();
                ((Map)unitToPreds).put(target, preds);
            }
            preds.add(currentAbs);
        }
    }

    protected void buildUnexceptionalEdges(@NotNull IdentityHashMap<Abstraction, ArrayList<Abstraction>> unitToSuccs, @NotNull IdentityHashMap<Abstraction, ArrayList<Abstraction>> unitToPreds) {
        Abstraction nextAbs;
        Intrinsics.checkNotNullParameter(unitToSuccs, (String)"unitToSuccs");
        Intrinsics.checkNotNullParameter(unitToPreds, (String)"unitToPreds");
        Iterator iterator2 = this.absChain.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator2, (String)"iterator(...)");
        Iterator unitIt = iterator2;
        Abstraction abstraction = nextAbs = unitIt.hasNext() ? (Abstraction)unitIt.next() : null;
        while (nextAbs != null) {
            Abstraction currentAbs = nextAbs;
            nextAbs = unitIt.hasNext() ? (Abstraction)unitIt.next() : null;
            ArrayList successors = new ArrayList();
            if (currentAbs.getPredecessor() != null) {
                Abstraction abstraction2 = currentAbs.getPredecessor();
                Intrinsics.checkNotNullExpressionValue((Object)abstraction2, (String)"getPredecessor(...)");
                this.addEdge(currentAbs, abstraction2, successors, unitToPreds);
                if (currentAbs.getPredecessor().getNeighbors() != null) {
                    Set it;
                    boolean bl = false;
                    for (Abstraction targetBox : it) {
                        Intrinsics.checkNotNull((Object)targetBox);
                        this.addEdge(currentAbs, targetBox, successors, unitToPreds);
                    }
                }
            }
            if (!(!((Collection)successors).isEmpty())) continue;
            successors.trimToSize();
            ((Map)unitToSuccs).put(currentAbs, successors);
        }
    }

    @NotNull
    public List<Abstraction> getHeads() {
        return this.getMHeads();
    }

    @NotNull
    public List<Abstraction> getTails() {
        return this.getMTails();
    }

    @NotNull
    public List<Abstraction> getPredsOf(@NotNull Abstraction s) {
        Intrinsics.checkNotNullParameter((Object)s, (String)"s");
        ArrayList arrayList = (ArrayList)this.getUnitToPreds().get(s);
        return arrayList != null ? (List)arrayList : CollectionsKt.emptyList();
    }

    @NotNull
    public List<Abstraction> getSuccsOf(@NotNull Abstraction s) {
        Intrinsics.checkNotNullParameter((Object)s, (String)"s");
        ArrayList arrayList = (ArrayList)this.getUnitToSuccs().get(s);
        return arrayList != null ? (List)arrayList : CollectionsKt.emptyList();
    }

    public int size() {
        return this.absChain.size();
    }

    @NotNull
    public Iterator<Abstraction> iterator() {
        Iterator<Abstraction> iterator2 = this.absChain.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator2, (String)"iterator(...)");
        return iterator2;
    }

    public final boolean isTail(@NotNull Abstraction abs) {
        int n;
        block2: {
            Intrinsics.checkNotNullParameter((Object)abs, (String)"abs");
            List $this$indexOfFirst$iv = this.getTails();
            boolean $i$f$indexOfFirst = false;
            int index$iv = 0;
            for (Object item$iv : $this$indexOfFirst$iv) {
                Abstraction it = (Abstraction)item$iv;
                boolean bl = false;
                if (it == abs) {
                    n = index$iv;
                    break block2;
                }
                ++index$iv;
            }
            n = -1;
        }
        return n != -1;
    }

    public final boolean isHead(@NotNull Abstraction abs) {
        int n;
        block2: {
            Intrinsics.checkNotNullParameter((Object)abs, (String)"abs");
            List $this$indexOfFirst$iv = this.getHeads();
            boolean $i$f$indexOfFirst = false;
            int index$iv = 0;
            for (Object item$iv : $this$indexOfFirst$iv) {
                Abstraction it = (Abstraction)item$iv;
                boolean bl = false;
                if (it == abs) {
                    n = index$iv;
                    break block2;
                }
                ++index$iv;
            }
            n = -1;
        }
        return n != -1;
    }
}

