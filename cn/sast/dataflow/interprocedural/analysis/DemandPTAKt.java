/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.DemandPTAKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  soot.Local
 *  soot.PointsToAnalysis
 *  soot.PointsToSet
 *  soot.Scene
 *  soot.Value
 *  soot.jimple.ArrayRef
 *  soot.jimple.InstanceFieldRef
 *  soot.jimple.StaticFieldRef
 *  soot.jimple.infoflow.data.AccessPath
 */
package cn.sast.dataflow.interprocedural.analysis;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import soot.Local;
import soot.PointsToAnalysis;
import soot.PointsToSet;
import soot.Scene;
import soot.Value;
import soot.jimple.ArrayRef;
import soot.jimple.InstanceFieldRef;
import soot.jimple.StaticFieldRef;
import soot.jimple.infoflow.data.AccessPath;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\u0007H\u0002\u00a8\u0006\f"}, d2={"getPointsToSet", "Lsoot/PointsToSet;", "accessPath", "Lsoot/jimple/infoflow/data/AccessPath;", "pta", "Lsoot/PointsToAnalysis;", "targetValue", "Lsoot/Value;", "isAliasedAtStmt", "", "ptsTaint", "v", "corax-data-flow"})
public final class DemandPTAKt {
    private static final PointsToSet getPointsToSet(AccessPath accessPath) {
        PointsToSet pointsToSet;
        if (accessPath.isLocal()) {
            pointsToSet = Scene.v().getPointsToAnalysis().reachingObjects(accessPath.getPlainValue());
        } else if (accessPath.isInstanceFieldRef()) {
            pointsToSet = Scene.v().getPointsToAnalysis().reachingObjects(accessPath.getPlainValue(), accessPath.getFirstField());
        } else if (accessPath.isStaticFieldRef()) {
            pointsToSet = Scene.v().getPointsToAnalysis().reachingObjects(accessPath.getFirstField());
        } else {
            throw new RuntimeException("Unexepected access path type");
        }
        return pointsToSet;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final PointsToSet getPointsToSet(PointsToAnalysis pta, Value targetValue) {
        PointsToAnalysis pta2 = Scene.v().getPointsToAnalysis();
        Intrinsics.checkNotNull((Object)pta2);
        PointsToAnalysis pointsToAnalysis = pta2;
        synchronized (pointsToAnalysis) {
            PointsToSet pointsToSet;
            boolean bl = false;
            if (targetValue instanceof Local) {
                pointsToSet = pta2.reachingObjects((Local)targetValue);
            } else if (targetValue instanceof InstanceFieldRef) {
                Value value = ((InstanceFieldRef)targetValue).getBase();
                Intrinsics.checkNotNull((Object)value, (String)"null cannot be cast to non-null type soot.Local");
                pointsToSet = pta2.reachingObjects((Local)value, ((InstanceFieldRef)targetValue).getField());
            } else if (targetValue instanceof StaticFieldRef) {
                pointsToSet = pta2.reachingObjects(((StaticFieldRef)targetValue).getField());
            } else if (targetValue instanceof ArrayRef) {
                Value value = ((ArrayRef)targetValue).getBase();
                Intrinsics.checkNotNull((Object)value, (String)"null cannot be cast to non-null type soot.Local");
                pointsToSet = pta2.reachingObjects((Local)value);
            } else {
                pointsToSet = null;
            }
            PointsToSet pointsToSet2 = pointsToSet;
            return pointsToSet2;
        }
    }

    private static final boolean isAliasedAtStmt(PointsToAnalysis pta, PointsToSet ptsTaint, Value v) {
        if (ptsTaint != null) {
            PointsToSet ptsRight = DemandPTAKt.getPointsToSet((PointsToAnalysis)pta, (Value)v);
            return ptsRight != null && ptsTaint.hasNonEmptyIntersection(ptsRight);
        }
        return false;
    }
}

