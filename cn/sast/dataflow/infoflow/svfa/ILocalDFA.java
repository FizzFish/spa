/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.svfa.AP
 *  cn.sast.dataflow.infoflow.svfa.ILocalDFA
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  soot.Unit
 */
package cn.sast.dataflow.infoflow.svfa;

import cn.sast.dataflow.infoflow.svfa.AP;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import soot.Unit;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H&J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2={"Lcn/sast/dataflow/infoflow/svfa/ILocalDFA;", "", "getUsesOfAt", "", "Lsoot/Unit;", "ap", "Lcn/sast/dataflow/infoflow/svfa/AP;", "stmt", "getDefUsesOfAt", "corax-data-flow"})
public interface ILocalDFA {
    @NotNull
    public List<Unit> getUsesOfAt(@NotNull AP var1, @NotNull Unit var2);

    @NotNull
    public List<Unit> getDefUsesOfAt(@NotNull AP var1, @NotNull Unit var2);
}

