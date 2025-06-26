/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.EntryPath
 *  cn.sast.dataflow.interprocedural.check.KillEntry
 *  cn.sast.dataflow.interprocedural.check.KillEntry$EntryReplace
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.SootMethod
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.EntryPath;
import cn.sast.dataflow.interprocedural.check.KillEntry;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0013j\u0002`\u00140\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2={"Lcn/sast/dataflow/interprocedural/check/KillEntry;", "", "method", "Lsoot/SootMethod;", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "<init>", "(Lsoot/SootMethod;Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;)V", "getMethod", "()Lsoot/SootMethod;", "getEnv", "()Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "entries", "", "Lcn/sast/dataflow/interprocedural/check/EntryPath;", "getEntries", "()Ljava/util/Set;", "factory", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "getFactory", "()Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "EntryReplace", "corax-data-flow"})
public final class KillEntry {
    @NotNull
    private final SootMethod method;
    @NotNull
    private final HeapValuesEnv env;
    @NotNull
    private final Set<EntryPath> entries;
    @NotNull
    private final IReNew<IValue> factory;

    public KillEntry(@NotNull SootMethod method, @NotNull HeapValuesEnv env) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        this.method = method;
        this.env = env;
        this.entries = new LinkedHashSet();
        this.factory = (IReNew)new EntryReplace(this, null, 1, null);
    }

    @NotNull
    public final SootMethod getMethod() {
        return this.method;
    }

    @NotNull
    public final HeapValuesEnv getEnv() {
        return this.env;
    }

    @NotNull
    public final Set<EntryPath> getEntries() {
        return this.entries;
    }

    @NotNull
    public final IReNew<IValue> getFactory() {
        return this.factory;
    }
}

