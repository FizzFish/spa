/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.callgraph.ReachableStmtSequenceKt
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  org.jetbrains.annotations.NotNull
 *  soot.MethodOrMethodContext
 *  soot.SootMethod
 *  soot.jimple.Stmt
 */
package cn.sast.dataflow.callgraph;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import soot.MethodOrMethodContext;
import soot.SootMethod;
import soot.jimple.Stmt;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u001a\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a8\u0006\b"}, d2={"reachableMethodSequence", "Lkotlin/sequences/Sequence;", "Lsoot/SootMethod;", "entryPoints", "", "Lsoot/MethodOrMethodContext;", "reachableStmtSequence", "Lsoot/jimple/Stmt;", "corax-data-flow"})
public final class ReachableStmtSequenceKt {
    @NotNull
    public static final Sequence<SootMethod> reachableMethodSequence(@NotNull Collection<? extends MethodOrMethodContext> entryPoints) {
        Intrinsics.checkNotNullParameter(entryPoints, (String)"entryPoints");
        return SequencesKt.sequence((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
    }

    @NotNull
    public static final Sequence<Stmt> reachableStmtSequence(@NotNull Collection<? extends MethodOrMethodContext> entryPoints) {
        Intrinsics.checkNotNullParameter(entryPoints, (String)"entryPoints");
        return SequencesKt.sequence((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
    }
}

