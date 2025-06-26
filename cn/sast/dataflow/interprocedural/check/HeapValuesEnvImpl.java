/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.check.HeapValuesEnvImpl
 *  cn.sast.dataflow.interprocedural.check.HeapValuesEnvImpl$Companion
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.Unit
 *  soot.jimple.internal.JNopStmt
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.check.HeapValuesEnvImpl;
import cn.sast.dataflow.interprocedural.check.IPath;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.Unit;
import soot.jimple.internal.JNopStmt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0004\u0010\b\u00a8\u0006\n"}, d2={"Lcn/sast/dataflow/interprocedural/check/HeapValuesEnvImpl;", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "node", "Lsoot/Unit;", "<init>", "(Lsoot/Unit;)V", "p", "Lcn/sast/dataflow/interprocedural/check/IPath;", "(Lcn/sast/dataflow/interprocedural/check/IPath;)V", "Companion", "corax-data-flow"})
public final class HeapValuesEnvImpl
extends HeapValuesEnv {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final JNopStmt phantomUnit = new JNopStmt();

    public HeapValuesEnvImpl(@NotNull Unit node) {
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        super(node);
    }

    public HeapValuesEnvImpl(@NotNull IPath p) {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        this(p.getNode());
    }

    public static final /* synthetic */ JNopStmt access$getPhantomUnit$cp() {
        return phantomUnit;
    }
}

