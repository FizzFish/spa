/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  soot.Local
 *  soot.Timers
 *  soot.Unit
 *  soot.Value
 *  soot.ValueBox
 *  soot.options.Options
 *  soot.toolkits.graph.UnitGraph
 *  soot.toolkits.scalar.LocalDefs
 *  soot.toolkits.scalar.LocalUses
 *  soot.toolkits.scalar.UnitValueBoxPair
 */
package com.feysh.corax.cache.analysis.defuse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.Local;
import soot.Timers;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.options.Options;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.scalar.LocalDefs;
import soot.toolkits.scalar.LocalUses;
import soot.toolkits.scalar.UnitValueBoxPair;

public class SimpleLocalUses
implements LocalUses {
    private static final Logger logger = LoggerFactory.getLogger(SimpleLocalUses.class);
    private final Map<Unit, List<UnitValueBoxPair>> unitToUses = new HashMap<Unit, List<UnitValueBoxPair>>();

    public SimpleLocalUses(UnitGraph graph, LocalDefs localDefs) {
        this((Iterable<Unit>)graph.getBody().getUnits(), localDefs);
    }

    public SimpleLocalUses(Iterable<Unit> units, LocalDefs localDefs) {
        Options options = Options.v();
        if (options.time()) {
            Timers.v().usesTimer.start();
        }
        for (Unit unit : units) {
            for (ValueBox useBox : unit.getUseBoxes()) {
                Local l;
                List defs;
                Value v = useBox.getValue();
                if (!(v instanceof Local) || (defs = localDefs.getDefsOfAt(l = (Local)v, unit)) == null) continue;
                UnitValueBoxPair newPair = new UnitValueBoxPair(unit, useBox);
                for (Unit def : defs) {
                    List<UnitValueBoxPair> lst = this.unitToUses.get(def);
                    if (lst == null) {
                        lst = new ArrayList<UnitValueBoxPair>();
                        this.unitToUses.put(def, lst);
                    }
                    lst.add(newPair);
                }
            }
        }
        if (options.time()) {
            Timers.v().usesTimer.end();
        }
    }

    public List<UnitValueBoxPair> getUsesOf(Unit s) {
        List<UnitValueBoxPair> l = this.unitToUses.get(s);
        return l == null ? Collections.emptyList() : Collections.unmodifiableList(l);
    }

    public Set<Local> getUsedVariables() {
        HashSet<Local> res = new HashSet<Local>();
        for (List<UnitValueBoxPair> vals : this.unitToUses.values()) {
            for (UnitValueBoxPair val : vals) {
                res.add((Local)val.valueBox.getValue());
            }
        }
        return res;
    }

    public Set<Local> getUnusedVariables(Collection<Local> locals) {
        HashSet<Local> res = new HashSet<Local>(locals);
        res.retainAll(this.getUsedVariables());
        return res;
    }
}

