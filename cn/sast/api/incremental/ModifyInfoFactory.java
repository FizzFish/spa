package cn.sast.api.incremental;

import com.feysh.corax.config.api.XDecl;
import com.feysh.corax.config.api.rules.ProcessRule;
import org.eclipse.jgit.diff.DiffEntry;
import org.jetbrains.annotations.NotNull;
import java.util.Collection;

public interface ModifyInfoFactory {
    @NotNull
    XDecl toDecl(@NotNull Object target);

    @NotNull
    Collection<XDecl> getPatchedDeclsByDiff(@NotNull Object target, @NotNull DiffEntry diff);

    @NotNull
    Collection<XDecl> getSubDecls(@NotNull XDecl decl);

    @NotNull
    IncrementalAnalyzeByChangeFiles.SimpleDeclAnalysisDependsGraph createSimpleDeclAnalysisDependsGraph();

    @NotNull
    IncrementalAnalyzeByChangeFiles.InterProceduralAnalysisDependsGraph createInterProceduralAnalysisDependsGraph();

    @NotNull
    ProcessRule.ScanAction getScanAction(@NotNull XDecl decl);
}