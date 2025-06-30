/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  soot.Unit
 *  soot.UnitPatchingChain
 *  utils.INewUnits
 *  utils.NewUnitsAtLastImmediately
 */
package utils;

import java.util.List;
import soot.Unit;
import soot.UnitPatchingChain;
import utils.INewUnits;

public class NewUnitsAtLastImmediately
implements INewUnits {
    UnitPatchingChain unitPatchingChain;

    public NewUnitsAtLastImmediately(UnitPatchingChain unitPatchingChain) {
        this.unitPatchingChain = unitPatchingChain;
    }

    public NewUnitsAtLastImmediately addAll(List<Unit> units) {
        this.unitPatchingChain.addAll(units);
        return this;
    }

    public NewUnitsAtLastImmediately add(Unit unit) {
        this.unitPatchingChain.add(unit);
        return this;
    }
}

