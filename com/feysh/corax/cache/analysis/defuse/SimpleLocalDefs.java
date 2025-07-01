package com.feysh.corax.cache.analysis.defuse;

import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import soot.IdentityUnit;
import soot.Local;
import soot.Timers;
import soot.Trap;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.options.Options;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.scalar.FlowAnalysis;
import soot.toolkits.scalar.ForwardFlowAnalysis;
import soot.toolkits.scalar.LocalDefs;

public class SimpleLocalDefs implements LocalDefs {
    public enum FlowAnalysisMode {
        Automatic,
        OmitSSA,
        FlowInsensitive
    }

    private final LocalDefs def;
    private Map<Local, Integer> localNumberMap;

    public SimpleLocalDefs(UnitGraph graph) {
        this(graph, FlowAnalysisMode.Automatic);
    }

    public SimpleLocalDefs(UnitGraph graph, FlowAnalysisMode mode) {
        this(graph, graph.getBody().getLocals(), mode);
    }

    public SimpleLocalDefs(DirectedGraph<Unit> graph, Collection<Local> locals, FlowAnalysisMode mode) {
        this(graph, locals.toArray(new Local[0]), mode);
    }

    protected SimpleLocalDefs(DirectedGraph<Unit> graph, Local[] locals, boolean omitSSA) {
        this(graph, locals, omitSSA ? FlowAnalysisMode.OmitSSA : FlowAnalysisMode.Automatic);
    }

    protected SimpleLocalDefs(DirectedGraph<Unit> graph, Local[] locals, FlowAnalysisMode mode) {
        boolean time = Options.v().time();
        if (time) {
            Timers.v().defsTimer.start();
        }
        this.localNumberMap = number2index(locals);
        this.def = init(graph, locals, mode);
        this.localNumberMap = null;
        if (time) {
            Timers.v().defsTimer.end();
        }
    }

    protected Map<Local, Integer> number2index(Local[] locals) {
        Map<Local, Integer> localNumberMap = Maps.newHashMapWithExpectedSize(locals.length);
        for (int i = 0; i < locals.length; i++) {
            localNumberMap.put(locals[i], i);
        }
        return localNumberMap;
    }

    protected LocalDefs init(DirectedGraph<Unit> graph, Local[] locals, FlowAnalysisMode mode) {
        boolean omitSSA = mode == FlowAnalysisMode.OmitSSA;
        List<Unit>[] unitList = new List[locals.length];
        Arrays.fill(unitList, Collections.emptyList());
        boolean doFlowAnalysis = omitSSA;
        int units = 0;

        for (Unit unit : graph) {
            for (ValueBox box : unit.getDefBoxes()) {
                Value v = box.getValue();
                if (!(v instanceof Local)) continue;
                
                Local l = (Local)v;
                int lno = getLocalNumber(l);
                switch (unitList[lno].size()) {
                    case 0:
                        unitList[lno] = Collections.singletonList(unit);
                        if (!omitSSA) continue;
                        units++;
                        break;
                    case 1:
                        if (!omitSSA) units++;
                        unitList[lno] = new ArrayList<>(unitList[lno]);
                        doFlowAnalysis = true;
                        break;
                }
                unitList[lno].add(unit);
                units++;
            }
        }

        if (doFlowAnalysis && mode != FlowAnalysisMode.FlowInsensitive) {
            return new FlowAssignment(graph, locals, unitList, units, omitSSA);
        }
        return new StaticSingleAssignment(locals, unitList);
    }

    protected int getLocalNumber(Local l) {
        return localNumberMap.get(l);
    }

    @Override
    public List<Unit> getDefsOfAt(Local l, Unit s) {
        return def.getDefsOfAt(l, s);
    }

    @Override
    public List<Unit> getDefsOf(Local l) {
        return def.getDefsOf(l);
    }

    public class FlowAssignment extends ForwardFlowAnalysis<Unit, FlowAssignment.FlowBitSet> implements LocalDefs {
        private final Map<Local, Integer> locals;
        private final List<Unit>[] unitList;
        private final int[] localRange;
        private final Unit[] universe;
        private Map<Unit, Integer> indexOfUnit;
        class FlowBitSet extends BitSet {
            private static final long serialVersionUID = -8348696077189400377L;

            FlowBitSet() {
                super(universe.length);
            }

            List<Unit> asList(int fromIndex, int toIndex) {
                if (fromIndex < 0 || toIndex < fromIndex || universe.length < toIndex) {
                    throw new IndexOutOfBoundsException();
                }
                if (fromIndex == toIndex) return Collections.emptyList();
                if (fromIndex == toIndex - 1) {
                    return get(fromIndex) ? Collections.singletonList(universe[fromIndex]) : Collections.emptyList();
                }

                int i = nextSetBit(fromIndex);
                if (i < 0 || i >= toIndex) return Collections.emptyList();
                if (i == toIndex - 1) return Collections.singletonList(universe[i]);

                List<Unit> elements = new ArrayList<>(toIndex - i);
                do {
                    int endOfRun = Math.min(toIndex, nextClearBit(i + 1));
                    do {
                        elements.add(universe[i++]);
                    } while (i < endOfRun);
                } while (i < toIndex && (i = nextSetBit(i + 1)) >= 0 && i < toIndex);
                return elements;
            }
        }
        public FlowAssignment(DirectedGraph<Unit> graph, Local[] locals, List<Unit>[] unitList, int units, boolean omitSSA) {
            super(graph);
            this.unitList = unitList;
            this.universe = new Unit[units];
            this.indexOfUnit = new HashMap<>(units);
            this.locals = new HashMap<>(locals.length * 3 / 2 + 7);
            this.localRange = new int[locals.length + 1];

            int j = 0;
            for (int i = 0; i < locals.length; i++) {
                List<Unit> currUnitList = unitList[i];
                if (currUnitList != null && !currUnitList.isEmpty()) {
                    this.localRange[i + 1] = j;
                    this.locals.put(locals[i], i);
                    if (currUnitList.size() >= 2) {
                        for (Unit u : currUnitList) {
                            this.indexOfUnit.put(u, j);
                            this.universe[j++] = u;
                        }
                    } else if (omitSSA) {
                        this.universe[j++] = currUnitList.get(0);
                    }
                }
                this.localRange[++i] = j;
            }
            assert this.localRange[locals.length] == units;
            doAnalysis();
            this.indexOfUnit = null;
        }

        @Override
        protected void flowThrough(FlowBitSet in, Unit unit, FlowBitSet out) {
            copy(in, out);
            for (ValueBox vb : unit.getDefBoxes()) {
                Value v = vb.getValue();
                if (!(v instanceof Local)) continue;
                
                Local l = (Local)v;
                int lno = SimpleLocalDefs.this.getLocalNumber(l);
                int from = localRange[lno];
                int to = localRange[lno + 1];
                if (from == to) continue;
                
                assert from <= to;
                if (to - from == 1) {
                    out.set(from);
                } else {
                    out.clear(from, to);
                    out.set(indexOfUnit.get(unit));
                }
            }
        }

        @Override
        protected FlowBitSet newInitialFlow() {
            return new FlowBitSet();
        }

        @Override
        protected void merge(FlowBitSet flowBitSet, FlowBitSet a1, FlowBitSet a2) {

        }

        @Override
        protected void copy(FlowBitSet flowBitSet, FlowBitSet a1) {

        }

        @Override
        protected void mergeInto(Unit succNode, FlowBitSet inout, FlowBitSet in) {
            inout.or(in);
        }

        @Override
        public List<Unit> getDefsOfAt(Local l, Unit s) {
            Integer lno = locals.get(l);
            if (lno == null) return Collections.emptyList();
            
            int from = localRange[lno];
            int to = localRange[lno + 1];
            assert from <= to;
            
            if (from == to) {
                assert unitList[lno].size() == 1;
                return unitList[lno];
            }
            return getFlowBefore(s).asList(from, to);
        }

        @Override
        public List<Unit> getDefsOf(Local l) {
            List<Unit> defs = new ArrayList<>();
            for (Unit u : graph) {
                defs.addAll(getDefsOfAt(l, u));
            }
            return defs;
        }


    }

    public static class StaticSingleAssignment implements LocalDefs {
        private final Map<Local, List<Unit>> result;

        public StaticSingleAssignment(Local[] locals, List<Unit>[] unitList) {
            assert locals.length == unitList.length;
            this.result = new HashMap<>(locals.length * 3 / 2 + 7);
            for (int i = 0; i < locals.length; i++) {
                List<Unit> curr = unitList[i];
                if (!curr.isEmpty()) {
                    assert curr.size() == 1;
                    result.put(locals[i], curr);
                }
            }
        }

        @Override
        public List<Unit> getDefsOfAt(Local l, Unit s) {
            List<Unit> lst = result.get(l);
            return lst != null ? lst : Collections.emptyList();
        }

        @Override
        public List<Unit> getDefsOf(Local l) {
            return getDefsOfAt(l, null);
        }
    }
}