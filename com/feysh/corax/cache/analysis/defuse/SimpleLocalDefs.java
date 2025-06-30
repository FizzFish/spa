/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  soot.IdentityUnit
 *  soot.Local
 *  soot.Timers
 *  soot.Trap
 *  soot.Unit
 *  soot.Value
 *  soot.ValueBox
 *  soot.options.Options
 *  soot.toolkits.graph.DirectedGraph
 *  soot.toolkits.graph.ExceptionalGraph
 *  soot.toolkits.graph.ExceptionalGraph$ExceptionDest
 *  soot.toolkits.graph.UnitGraph
 *  soot.toolkits.scalar.FlowAnalysis$Flow
 *  soot.toolkits.scalar.ForwardFlowAnalysis
 *  soot.toolkits.scalar.LocalDefs
 *  soot.toolkits.scalar.SimpleLocalDefs$FlowAnalysisMode
 */
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
import soot.toolkits.scalar.SimpleLocalDefs;

public class SimpleLocalDefs
implements LocalDefs {
    private final LocalDefs def;
    private Map<Local, Integer> localNumberMap;

    public SimpleLocalDefs(UnitGraph graph) {
        this(graph, SimpleLocalDefs.FlowAnalysisMode.Automatic);
    }

    public SimpleLocalDefs(UnitGraph graph, SimpleLocalDefs.FlowAnalysisMode mode) {
        this((DirectedGraph<Unit>)graph, (Collection<Local>)graph.getBody().getLocals(), mode);
    }

    public SimpleLocalDefs(DirectedGraph<Unit> graph, Collection<Local> locals, SimpleLocalDefs.FlowAnalysisMode mode) {
        this(graph, locals.toArray(new Local[locals.size()]), mode);
    }

    protected SimpleLocalDefs(DirectedGraph<Unit> graph, Local[] locals, boolean omitSSA) {
        this(graph, locals, omitSSA ? SimpleLocalDefs.FlowAnalysisMode.OmitSSA : SimpleLocalDefs.FlowAnalysisMode.Automatic);
    }

    protected SimpleLocalDefs(DirectedGraph<Unit> graph, Local[] locals, SimpleLocalDefs.FlowAnalysisMode mode) {
        boolean time = Options.v().time();
        if (time) {
            Timers.v().defsTimer.start();
        }
        this.localNumberMap = this.number2index(locals);
        this.def = this.init(graph, locals, mode);
        this.localNumberMap = null;
        if (time) {
            Timers.v().defsTimer.end();
        }
    }

    protected void restoreNumbers(Local[] locals, int[] oldNumbers) {
        for (int i = 0; i < oldNumbers.length; ++i) {
            locals[i].setNumber(oldNumbers[i]);
        }
    }

    protected Map<Local, Integer> number2index(Local[] locals) {
        int N = locals.length;
        HashMap localNumberMap = Maps.newHashMapWithExpectedSize((int)N);
        for (int i = 0; i < N; ++i) {
            localNumberMap.put(locals[i], i);
        }
        return localNumberMap;
    }

    protected LocalDefs init(DirectedGraph<Unit> graph, Local[] locals, SimpleLocalDefs.FlowAnalysisMode mode) {
        boolean omitSSA;
        Object[] unitList = new List[locals.length];
        Arrays.fill(unitList, Collections.emptyList());
        boolean doFlowAnalsis = omitSSA = mode == SimpleLocalDefs.FlowAnalysisMode.OmitSSA;
        int units = 0;
        for (Unit unit : graph) {
            block5: for (ValueBox box : unit.getDefBoxes()) {
                Value v = box.getValue();
                if (!(v instanceof Local)) continue;
                Local l = (Local)v;
                int lno = this.getLocalNumber(l);
                switch (unitList[lno].size()) {
                    case 0: {
                        unitList[lno] = Collections.singletonList(unit);
                        if (!omitSSA) continue block5;
                        ++units;
                        continue block5;
                    }
                    case 1: {
                        if (!omitSSA) {
                            ++units;
                        }
                        unitList[lno] = new ArrayList(unitList[lno]);
                        doFlowAnalsis = true;
                    }
                }
                unitList[lno].add(unit);
                ++units;
            }
        }
        if (doFlowAnalsis && mode != SimpleLocalDefs.FlowAnalysisMode.FlowInsensitive) {
            return new FlowAssignment(graph, locals, (List<Unit>[])unitList, units, omitSSA);
        }
        return new StaticSingleAssignment(locals, (List<Unit>[])unitList);
    }

    protected int getLocalNumber(Local l) {
        return this.localNumberMap.get(l);
    }

    public List<Unit> getDefsOfAt(Local l, Unit s) {
        return this.def.getDefsOfAt(l, s);
    }

    public List<Unit> getDefsOf(Local l) {
        return this.def.getDefsOf(l);
    }

    public class FlowAssignment
    extends ForwardFlowAnalysis<Unit, FlowBitSet>
    implements LocalDefs {
        final Map<Local, Integer> locals;
        final List<Unit>[] unitList;
        final int[] localRange;
        final Unit[] universe;
        private Map<Unit, Integer> indexOfUnit;

        public FlowAssignment(DirectedGraph<Unit> graph, Local[] locals, List<Unit>[] unitList, int units, boolean omitSSA) {
            super(graph);
            this.unitList = unitList;
            this.universe = new Unit[units];
            this.indexOfUnit = new HashMap<Unit, Integer>(units);
            int N = locals.length;
            this.locals = new HashMap<Local, Integer>(N * 3 / 2 + 7);
            this.localRange = new int[N + 1];
            int j = 0;
            int i = 0;
            while (i < N) {
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
            assert (this.localRange[N] == units);
            this.doAnalysis();
            this.indexOfUnit = null;
        }

        protected boolean omissible(Unit u) {
            List defs = u.getDefBoxes();
            if (!defs.isEmpty()) {
                for (ValueBox vb : defs) {
                    Value v = vb.getValue();
                    if (!(v instanceof Local)) continue;
                    Local l = (Local)v;
                    int lno = SimpleLocalDefs.this.getLocalNumber(l);
                    return this.localRange[lno] == this.localRange[lno + 1];
                }
            }
            return true;
        }

        protected FlowAnalysis.Flow getFlow(Unit from, Unit to) {
            ExceptionalGraph g;
            if (to instanceof IdentityUnit && this.graph instanceof ExceptionalGraph && !(g = (ExceptionalGraph)this.graph).getExceptionalPredsOf((Object)to).isEmpty()) {
                for (ExceptionalGraph.ExceptionDest exd : g.getExceptionDests((Object)from)) {
                    Trap trap = exd.getTrap();
                    if (trap == null || trap.getHandlerUnit() != to) continue;
                    return FlowAnalysis.Flow.IN;
                }
            }
            return FlowAnalysis.Flow.OUT;
        }

        protected void flowThrough(FlowBitSet in, Unit unit, FlowBitSet out) {
            this.copy(in, out);
            for (ValueBox vb : unit.getDefBoxes()) {
                int to;
                Local l;
                int lno;
                int from;
                Value v = vb.getValue();
                if (!(v instanceof Local) || (from = this.localRange[lno = SimpleLocalDefs.this.getLocalNumber(l = (Local)v)]) == (to = this.localRange[1 + lno])) continue;
                assert (from <= to);
                if (to - from == 1) {
                    out.set(from);
                    continue;
                }
                out.clear(from, to);
                out.set(this.indexOfUnit.get(unit));
            }
        }

        protected void copy(FlowBitSet source, FlowBitSet dest) {
            if (dest != source) {
                dest.clear();
                dest.or(source);
            }
        }

        protected FlowBitSet newInitialFlow() {
            return new FlowBitSet();
        }

        protected void mergeInto(Unit succNode, FlowBitSet inout, FlowBitSet in) {
            inout.or(in);
        }

        protected void merge(FlowBitSet in1, FlowBitSet in2, FlowBitSet out) {
            throw new UnsupportedOperationException("should never be called");
        }

        public List<Unit> getDefsOfAt(Local l, Unit s) {
            Integer lno = this.locals.get(l);
            if (lno == null) {
                return Collections.emptyList();
            }
            int from = this.localRange[lno];
            int to = this.localRange[lno + 1];
            assert (from <= to);
            if (from == to) {
                assert (this.unitList[lno].size() == 1);
                return this.unitList[lno];
            }
            return ((FlowBitSet)this.getFlowBefore(s)).asList(from, to);
        }

        public List<Unit> getDefsOf(Local l) {
            ArrayList<Unit> defs = new ArrayList<Unit>();
            for (Unit u : this.graph) {
                List<Unit> defsOf = this.getDefsOfAt(l, u);
                if (defsOf == null) continue;
                defs.addAll(defsOf);
            }
            return defs;
        }

        class FlowBitSet
        extends BitSet {
            private static final long serialVersionUID = -8348696077189400377L;

            FlowBitSet() {
                super(FlowAssignment.this.universe.length);
            }

            List<Unit> asList(int fromIndex, int toIndex) {
                if (fromIndex < 0 || toIndex < fromIndex || FlowAssignment.this.universe.length < toIndex) {
                    throw new IndexOutOfBoundsException();
                }
                if (fromIndex == toIndex) {
                    return Collections.emptyList();
                }
                if (fromIndex == toIndex - 1) {
                    if (this.get(fromIndex)) {
                        return Collections.singletonList(FlowAssignment.this.universe[fromIndex]);
                    }
                    return Collections.emptyList();
                }
                int i = this.nextSetBit(fromIndex);
                if (i < 0 || i >= toIndex) {
                    return Collections.emptyList();
                }
                if (i == toIndex - 1) {
                    return Collections.singletonList(FlowAssignment.this.universe[i]);
                }
                ArrayList<Unit> elements = new ArrayList<Unit>(toIndex - i);
                do {
                    int endOfRun = Math.min(toIndex, this.nextClearBit(i + 1));
                    do {
                        elements.add(FlowAssignment.this.universe[i++]);
                    } while (i < endOfRun);
                } while (i < toIndex && (i = this.nextSetBit(i + 1)) >= 0 && i < toIndex);
                return elements;
            }
        }
    }

    public static class StaticSingleAssignment
    implements LocalDefs {
        final Map<Local, List<Unit>> result;

        public StaticSingleAssignment(Local[] locals, List<Unit>[] unitList) {
            int N = locals.length;
            assert (N == unitList.length);
            this.result = new HashMap<Local, List<Unit>>(N * 3 / 2 + 7);
            for (int i = 0; i < N; ++i) {
                List<Unit> curr = unitList[i];
                if (curr.isEmpty()) continue;
                assert (curr.size() == 1);
                this.result.put(locals[i], curr);
            }
        }

        public List<Unit> getDefsOfAt(Local l, Unit s) {
            List<Unit> lst = this.result.get(l);
            return lst != null ? lst : Collections.emptyList();
        }

        public List<Unit> getDefsOf(Local l) {
            return this.getDefsOfAt(l, null);
        }
    }
}

