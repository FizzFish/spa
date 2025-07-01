package cn.sast.framework.incremental;

import cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles;
import cn.sast.api.incremental.ModifyInfoFactory;
import cn.sast.api.util.OthersKt;
import cn.sast.common.IResource;
import cn.sast.framework.incremental.DependsGraph;
import com.feysh.corax.config.api.XDecl;
import com.feysh.corax.config.api.rules.ProcessRule;
import org.eclipse.jgit.diff.DiffEntry;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.util.Chain;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ModifyInfoFactoryImpl implements ModifyInfoFactory {

    @NotNull
    @Override
    public XDecl toDecl(@NotNull Object target) {
        if (target instanceof SootClass) {
            return new ClassDecl((SootClass) target);
        } else if (target instanceof SootMethod) {
            return new MethodDecl((SootMethod) target);
        } else if (target instanceof SootField) {
            return new FieldDecl((SootField) target);
        } else if (target instanceof Path) {
            return new FileDecl((Path) target);
        } else if (target instanceof File) {
            return new FileDecl(((File) target).toPath());
        } else if (target instanceof IResource) {
            return new FileDecl((IResource) target);
        } else {
            throw new IllegalStateException("not support yet");
        }
    }

    @NotNull
    @Override
    public Collection<XDecl> getPatchedDeclsByDiff(@NotNull Object target, @NotNull DiffEntry diff) {
        return getSubDecls(toDecl(target));
    }

    @NotNull
    @Override
    public Collection<XDecl> getSubDecls(@NotNull XDecl decl) {
        if (decl instanceof FileDecl) {
            return List.of(decl);
        } else if (decl instanceof ClassDecl) {
            SootClass target = ((ClassDecl) decl).getTarget();
            List<SootMethod> methods = target.getMethods();
            Chain<SootField> fields = target.getFields();
            
            ArrayList<XDecl> result = new ArrayList<>(methods.size() + fields.size() + 1);
            result.add(decl);
            
            for (SootMethod method : methods) {
                result.add(toDecl(method));
            }
            for (SootField field : fields) {
                result.add(toDecl(field));
            }
            
            return result;
        } else if (decl instanceof MethodDecl || decl instanceof FieldDecl) {
            return List.of(decl);
        } else {
            throw new IllegalStateException("invalid type of " + decl);
        }
    }

    @NotNull
    @Override
    public IncrementalAnalyzeByChangeFiles.InterProceduralAnalysisDependsGraph createInterProceduralAnalysisDependsGraph() {
        DependsGraph d = new DependsGraph(this);
        return new IncrementalAnalyzeByChangeFiles.InterProceduralAnalysisDependsGraph(d);
    }

    @NotNull
    @Override
    public ProcessRule.ScanAction getScanAction(@NotNull XDecl target) {
        if (target instanceof MethodDecl && OthersKt.isDummy(((MethodDecl) target).getTarget())) {
            return ProcessRule.ScanAction.Skip;
        }
        return ProcessRule.ScanAction.Keep;
    }

    @NotNull
    @Override
    public IncrementalAnalyzeByChangeFiles.SimpleDeclAnalysisDependsGraph createSimpleDeclAnalysisDependsGraph() {
        DependsGraph d = new DependsGraph(this);
        return new IncrementalAnalyzeByChangeFiles.SimpleDeclAnalysisDependsGraph(d);
    }

    public static final class FileDecl implements XDecl {
        // Implementation omitted
    }

    public static final class ClassDecl implements XDecl {
        // Implementation omitted
    }

    public static final class MethodDecl implements XDecl {
        // Implementation omitted
    }

    public static final class FieldDecl implements XDecl {
        // Implementation omitted
    }
}