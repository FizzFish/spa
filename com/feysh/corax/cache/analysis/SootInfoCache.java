package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.feysh.corax.config.api.report.RegionKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.tagkit.AbstractHost;
import soot.tagkit.Host;
import soot.tagkit.SourceLnPosTag;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface SootInfoCache {
    @NotNull
    AnalysisCache getCache();

    @NotNull
    AnalysisDataFactory.Key<SootHostExtend> getHostKey();

    @Nullable
    default SootHostExtend getExt(@NotNull Host host) {
        return SootHostExtendKt.ext(host, getCache(), getHostKey());
    }

    @Nullable
    default BodyDeclaration<?> getMemberAtLine(@NotNull SootClass sootClass, int ln) {
        SootHostExtend ext = getExt(sootClass);
        SootClassExtend classExtend = ext instanceof SootClassExtend ? (SootClassExtend) ext : null;
        if (classExtend == null || (classExtend = classExtend.getDecl()) == null) {
            return null;
        }

        if (classExtend instanceof TypeDeclaration) {
            return getNormalMembers((TypeDeclaration<?>) classExtend, ln);
        } else if (classExtend instanceof ObjectCreationExpr) {
            return getMembersOfAnonymousClass((ObjectCreationExpr) classExtend, ln);
        }
        return null;
    }

    private BodyDeclaration<?> getMember(List<? extends BodyDeclaration<?>> members, int ln) {
        List<BodyDeclaration<?>> matching = new ArrayList<>();
        for (BodyDeclaration<?> member : members) {
            Optional<Integer> beginLine = member.getBegin().flatMap(SootHostExtendKt::getLine);
            Optional<Integer> endLine = member.getEnd().flatMap(SootHostExtendKt::getLine);

            if (beginLine.isPresent() && endLine.isPresent()) {
                int start = beginLine.get();
                int end = endLine.get();
                if (start <= ln && ln <= end) {
                    matching.add(member);
                }
            }
        }
        return matching.isEmpty() ? null : matching.get(0);
    }

    private BodyDeclaration<?> getNormalMembers(TypeDeclaration<?> decl, int ln) {
        NodeList<BodyDeclaration<?>> members = decl.getMembers();
        return getMember(members, ln);
    }

    private BodyDeclaration<?> getMembersOfAnonymousClass(ObjectCreationExpr decl, int ln) {
        List<BodyDeclaration<?>> members = decl.findAll(BodyDeclaration.class, Node.TreeTraversal.DIRECT_CHILDREN);
        return getMember(members, ln);
    }

    default int getJavaNameSourceStartLineNumber(@NotNull AbstractHost host) {
        SootHostExtend ext = getExt(host);
        if (ext != null && ext.getJavaNameSourceStartLineNumber() != null) {
            return ext.getJavaNameSourceStartLineNumber();
        }
        return ext != null ? ext.getJavaSourceStartLineNumber() : host.getJavaSourceStartLineNumber();
    }

    default int getJavaNameSourceStartColumnNumber(@NotNull AbstractHost host) {
        SootHostExtend ext = getExt(host);
        if (ext != null && ext.getJavaNameSourceStartColumnNumber() != null) {
            return ext.getJavaNameSourceStartColumnNumber();
        }
        return ext != null ? ext.getJavaSourceStartColumnNumber() : host.getJavaSourceStartColumnNumber();
    }

    default int getJavaNameSourceEndLineNumber(@NotNull AbstractHost host) {
        SootHostExtend ext = getExt(host);
        if (ext != null && ext.getJavaNameSourceEndLineNumber() != null) {
            return ext.getJavaNameSourceEndLineNumber();
        }
        SourceLnPosTag tag = RegionKt.getPos(host);
        return tag != null ? tag.endLn() : -1;
    }

    default int getJavaNameSourceEndColumnNumber(@NotNull AbstractHost host) {
        SootHostExtend ext = getExt(host);
        if (ext != null && ext.getJavaNameSourceEndColumnNumber() != null) {
            return ext.getJavaNameSourceEndColumnNumber();
        }
        SourceLnPosTag tag = RegionKt.getPos(host);
        return tag != null ? tag.endPos() : -1;
    }
}
