package cn.sast.dataflow.interprocedural.analysis;

import soot.Local;
import soot.PointsToAnalysis;
import soot.PointsToSet;
import soot.Scene;
import soot.Value;
import soot.jimple.ArrayRef;
import soot.jimple.InstanceFieldRef;
import soot.jimple.StaticFieldRef;
import soot.jimple.infoflow.data.AccessPath;

public final class DemandPTAKt {
    private static PointsToSet getPointsToSet(AccessPath accessPath) {
        PointsToSet pointsToSet;
        if (accessPath.isLocal()) {
            pointsToSet = Scene.v().getPointsToAnalysis().reachingObjects(accessPath.getPlainValue());
        } else if (accessPath.isInstanceFieldRef()) {
            pointsToSet = Scene.v().getPointsToAnalysis().reachingObjects(accessPath.getPlainValue(), accessPath.getFirstField());
        } else if (accessPath.isStaticFieldRef()) {
            pointsToSet = Scene.v().getPointsToAnalysis().reachingObjects(accessPath.getFirstField());
        } else {
            throw new RuntimeException("Unexpected access path type");
        }
        return pointsToSet;
    }

    private static PointsToSet getPointsToSet(PointsToAnalysis pta, Value targetValue) {
        PointsToAnalysis pta2 = Scene.v().getPointsToAnalysis();
        synchronized (pta2) {
            if (targetValue instanceof Local) {
                return pta2.reachingObjects((Local) targetValue);
            } else if (targetValue instanceof InstanceFieldRef) {
                Value value = ((InstanceFieldRef) targetValue).getBase();
                if (!(value instanceof Local)) {
                    throw new ClassCastException("null cannot be cast to non-null type soot.Local");
                }
                return pta2.reachingObjects((Local) value, ((InstanceFieldRef) targetValue).getField());
            } else if (targetValue instanceof StaticFieldRef) {
                return pta2.reachingObjects(((StaticFieldRef) targetValue).getField());
            } else if (targetValue instanceof ArrayRef) {
                Value value = ((ArrayRef) targetValue).getBase();
                if (!(value instanceof Local)) {
                    throw new ClassCastException("null cannot be cast to non-null type soot.Local");
                }
                return pta2.reachingObjects((Local) value);
            }
            return null;
        }
    }

    private static boolean isAliasedAtStmt(PointsToAnalysis pta, PointsToSet ptsTaint, Value v) {
        if (ptsTaint == null) {
            return false;
        }
        PointsToSet ptsRight = getPointsToSet(pta, v);
        return ptsRight != null && ptsTaint.hasNonEmptyIntersection(ptsRight);
    }
}