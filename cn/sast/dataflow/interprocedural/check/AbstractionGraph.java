package cn.sast.dataflow.interprocedural.check;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.data.Abstraction;
import soot.toolkits.graph.DirectedGraph;

public abstract class AbstractionGraph implements DirectedGraph<Abstraction> {
    @NotNull
    private final Abstraction sink;
    @NotNull
    private final ArrayList<Abstraction> absChain;
    private IdentityHashMap<Abstraction, ArrayList<Abstraction>> unitToSuccs;
    private IdentityHashMap<Abstraction, ArrayList<Abstraction>> unitToPreds;
    private ArrayList<Abstraction> mHeads;
    private ArrayList<Abstraction> mTails;

    public AbstractionGraph(@NotNull Abstraction sink) {
        if (sink == null) {
            throw new IllegalArgumentException("sink cannot be null");
        }
        this.sink = sink;
        this.absChain = new ArrayList<>();
        LinkedList<Abstraction> abstractionQueue = new LinkedList<>();
        abstractionQueue.add(this.sink);
        Set<Abstraction> visited = Collections.newSetFromMap(new IdentityHashMap<>());

        while (!abstractionQueue.isEmpty()) {
            Abstraction abstraction = abstractionQueue.remove(0);
            absChain.add(abstraction);

            if (abstraction.getSourceContext() != null) {
                if (abstraction.getPredecessor() != null) {
                    throw new AssertionError("Assertion failed");
                }
            } else if (visited.add(abstraction.getPredecessor())) {
                abstractionQueue.add(abstraction.getPredecessor());
            }

            if (abstraction.getNeighbors() != null) {
                for (Abstraction nb : abstraction.getNeighbors()) {
                    if (visited.add(nb)) {
                        abstractionQueue.add(nb);
                    }
                }
            }
        }
    }

    @NotNull
    public final Abstraction getSink() {
        return sink;
    }

    @NotNull
    public final ArrayList<Abstraction> getAbsChain() {
        return absChain;
    }

    @NotNull
    public final IdentityHashMap<Abstraction, ArrayList<Abstraction>> getUnitToSuccs() {
        if (unitToSuccs == null) {
            throw new IllegalStateException("unitToSuccs not initialized");
        }
        return unitToSuccs;
    }

    public final void setUnitToSuccs(@NotNull IdentityHashMap<Abstraction, ArrayList<Abstraction>> unitToSuccs) {
        if (unitToSuccs == null) {
            throw new IllegalArgumentException("unitToSuccs cannot be null");
        }
        this.unitToSuccs = unitToSuccs;
    }

    @NotNull
    public final IdentityHashMap<Abstraction, ArrayList<Abstraction>> getUnitToPreds() {
        if (unitToPreds == null) {
            throw new IllegalStateException("unitToPreds not initialized");
        }
        return unitToPreds;
    }

    public final void setUnitToPreds(@NotNull IdentityHashMap<Abstraction, ArrayList<Abstraction>> unitToPreds) {
        if (unitToPreds == null) {
            throw new IllegalArgumentException("unitToPreds cannot be null");
        }
        this.unitToPreds = unitToPreds;
    }

    @NotNull
    public final ArrayList<Abstraction> getMHeads() {
        if (mHeads == null) {
            throw new IllegalStateException("mHeads not initialized");
        }
        return mHeads;
    }

    public final void setMHeads(@NotNull ArrayList<Abstraction> mHeads) {
        if (mHeads == null) {
            throw new IllegalArgumentException("mHeads cannot be null");
        }
        this.mHeads = mHeads;
    }

    @NotNull
    public final ArrayList<Abstraction> getMTails() {
        if (mTails == null) {
            throw new IllegalStateException("mTails not initialized");
        }
        return mTails;
    }

    public final void setMTails(@NotNull ArrayList<Abstraction> mTails) {
        if (mTails == null) {
            throw new IllegalArgumentException("mTails cannot be null");
        }
        this.mTails = mTails;
    }

    public final void buildHeadsAndTails() {
        setMTails(new ArrayList<>());
        setMHeads(new ArrayList<>());

        for (Abstraction s : absChain) {
            ArrayList<Abstraction> succs = getUnitToSuccs().get(s);
            if (succs == null || succs.isEmpty()) {
                getMTails().add(s);
            }

            ArrayList<Abstraction> preds = getUnitToPreds().get(s);
            if (preds == null || preds.isEmpty()) {
                getMHeads().add(s);
            }
        }
    }

    private void addEdge(Abstraction currentAbs, Abstraction target, ArrayList<Abstraction> successors, 
                        IdentityHashMap<Abstraction, ArrayList<Abstraction>> unitToPreds) {
        if (!successors.contains(target)) {
            successors.add(target);
            ArrayList<Abstraction> preds = unitToPreds.computeIfAbsent(target, k -> new ArrayList<>());
            preds.add(currentAbs);
        }
    }

    protected void buildUnexceptionalEdges(@NotNull IdentityHashMap<Abstraction, ArrayList<Abstraction>> unitToSuccs,
                                         @NotNull IdentityHashMap<Abstraction, ArrayList<Abstraction>> unitToPreds) {
        if (unitToSuccs == null || unitToPreds == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }

        Iterator<Abstraction> unitIt = absChain.iterator();
        if (!unitIt.hasNext()) {
            return;
        }

        Abstraction nextAbs = unitIt.next();
        while (nextAbs != null) {
            Abstraction currentAbs = nextAbs;
            nextAbs = unitIt.hasNext() ? unitIt.next() : null;

            ArrayList<Abstraction> successors = new ArrayList<>();
            if (currentAbs.getPredecessor() != null) {
                Abstraction predecessor = currentAbs.getPredecessor();
                addEdge(currentAbs, predecessor, successors, unitToPreds);

                if (predecessor.getNeighbors() != null) {
                    for (Abstraction targetBox : predecessor.getNeighbors()) {
                        addEdge(currentAbs, targetBox, successors, unitToPreds);
                    }
                }
            }

            if (!successors.isEmpty()) {
                successors.trimToSize();
                unitToSuccs.put(currentAbs, successors);
            }
        }
    }

    @Override
    @NotNull
    public List<Abstraction> getHeads() {
        return getMHeads();
    }

    @Override
    @NotNull
    public List<Abstraction> getTails() {
        return getMTails();
    }

    @Override
    @NotNull
    public List<Abstraction> getPredsOf(@NotNull Abstraction s) {
        if (s == null) {
            throw new IllegalArgumentException("s cannot be null");
        }
        ArrayList<Abstraction> preds = getUnitToPreds().get(s);
        return preds != null ? preds : Collections.emptyList();
    }

    @Override
    @NotNull
    public List<Abstraction> getSuccsOf(@NotNull Abstraction s) {
        if (s == null) {
            throw new IllegalArgumentException("s cannot be null");
        }
        ArrayList<Abstraction> succs = getUnitToSuccs().get(s);
        return succs != null ? succs : Collections.emptyList();
    }

    @Override
    public int size() {
        return absChain.size();
    }

    @Override
    @NotNull
    public Iterator<Abstraction> iterator() {
        return absChain.iterator();
    }

    public final boolean isTail(@NotNull Abstraction abs) {
        if (abs == null) {
            throw new IllegalArgumentException("abs cannot be null");
        }
        return getTails().contains(abs);
    }

    public final boolean isHead(@NotNull Abstraction abs) {
        if (abs == null) {
            throw new IllegalArgumentException("abs cannot be null");
        }
        return getHeads().contains(abs);
    }
}
