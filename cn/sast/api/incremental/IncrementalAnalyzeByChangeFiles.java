/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.incremental.IncrementalAnalyze
 *  cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles
 *  cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles$InterProceduralAnalysisDependsGraph
 *  cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles$SimpleDeclAnalysisDependsGraph
 *  kotlin.Metadata
 *  kotlin.Pair
 *  org.eclipse.jgit.diff.DiffEntry
 *  org.jetbrains.annotations.NotNull
 *  soot.SootClass
 */
package cn.sast.api.incremental;

import cn.sast.api.incremental.IncrementalAnalyze;
import cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles;
import kotlin.Metadata;
import kotlin.Pair;
import org.eclipse.jgit.diff.DiffEntry;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0013\u0014\u0015J$\u0010\n\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J$\u0010\u0010\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bj\u0002`\r2\u0006\u0010\u0011\u001a\u00020\u0012H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0016"}, d2={"Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles;", "Lcn/sast/api/incremental/IncrementalAnalyze;", "simpleDeclAnalysisDependsGraph", "Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles$SimpleDeclAnalysisDependsGraph;", "getSimpleDeclAnalysisDependsGraph", "()Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles$SimpleDeclAnalysisDependsGraph;", "interProceduralAnalysisDependsGraph", "Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles$InterProceduralAnalysisDependsGraph;", "getInterProceduralAnalysisDependsGraph", "()Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles$InterProceduralAnalysisDependsGraph;", "getChangeTypeOfClass", "Lkotlin/Pair;", "Lorg/eclipse/jgit/diff/DiffEntry;", "Lcn/sast/api/incremental/ChangeType;", "cls", "Lsoot/SootClass;", "getChangeTypeOfFile", "file", "", "IDependsGraph", "SimpleDeclAnalysisDependsGraph", "InterProceduralAnalysisDependsGraph", "corax-api"})
public interface IncrementalAnalyzeByChangeFiles
extends IncrementalAnalyze {
    @NotNull
    public SimpleDeclAnalysisDependsGraph getSimpleDeclAnalysisDependsGraph();

    @NotNull
    public InterProceduralAnalysisDependsGraph getInterProceduralAnalysisDependsGraph();

    @NotNull
    public Pair<DiffEntry, DiffEntry> getChangeTypeOfClass(@NotNull SootClass var1);

    @NotNull
    public Pair<DiffEntry, DiffEntry> getChangeTypeOfFile(@NotNull String var1);
}

