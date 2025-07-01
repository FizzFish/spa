package cn.sast.api.incremental;

import org.eclipse.jgit.diff.DiffEntry;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import kotlin.Pair;

public interface IncrementalAnalyzeByChangeFiles extends IncrementalAnalyze {
    @NotNull
    SimpleDeclAnalysisDependsGraph getSimpleDeclAnalysisDependsGraph();

    @NotNull
    InterProceduralAnalysisDependsGraph getInterProceduralAnalysisDependsGraph();

    @NotNull
    Pair<DiffEntry, DiffEntry> getChangeTypeOfClass(@NotNull SootClass cls);

    @NotNull
    Pair<DiffEntry, DiffEntry> getChangeTypeOfFile(@NotNull String file);

    interface SimpleDeclAnalysisDependsGraph {}
    interface InterProceduralAnalysisDependsGraph {}
    interface IDependsGraph {}
}