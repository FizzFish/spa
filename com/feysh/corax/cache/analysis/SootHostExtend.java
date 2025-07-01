package com.feysh.corax.cache.analysis;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.tagkit.Host;
import soot.tagkit.Tag;

import java.util.List;

public abstract class SootHostExtend implements Host {
    @NotNull
    private final Host host;
    @NotNull
    private final CompilationUnit cu;

    protected SootHostExtend(@NotNull Host host, @NotNull CompilationUnit cu) {
        this.host = host;
        this.cu = cu;
    }

    @NotNull
    public Host getHost() {
        return host;
    }

    @NotNull
    public CompilationUnit getCu() {
        return cu;
    }

    @Nullable
    public abstract NodeWithRange<Node> getDecl();

    @Nullable
    public abstract NodeWithRange<Node> getNameDecl();

    public int getJavaSourceStartLineNumber() {
        Integer hostLine = host.getJavaSourceStartLineNumber();
        if (hostLine != null && hostLine != -1) {
            return hostLine;
        }
        Integer startLine = getStartLine();
        return startLine != null ? startLine : -1;
    }

    public int getJavaSourceStartColumnNumber() {
        Integer hostColumn = host.getJavaSourceStartColumnNumber();
        if (hostColumn != null && hostColumn != -1) {
            return hostColumn;
        }
        Integer startColumn = getStartLineColumn();
        return startColumn != null ? startColumn : -1;
    }

    @Nullable
    public final Integer getJavaNameSourceStartLineNumber() {
        NodeWithRange<Node> nameDecl = getNameDecl();
        return nameDecl != null && nameDecl.getBegin() != null 
            ? SootHostExtendKt.getLine(nameDecl.getBegin()) 
            : null;
    }

    @Nullable
    public final Integer getJavaNameSourceStartColumnNumber() {
        NodeWithRange<Node> nameDecl = getNameDecl();
        return nameDecl != null && nameDecl.getBegin() != null 
            ? SootHostExtendKt.getColumn(nameDecl.getBegin()) 
            : null;
    }

    @Nullable
    public final Integer getJavaNameSourceEndLineNumber() {
        NodeWithRange<Node> nameDecl = getNameDecl();
        return nameDecl != null && nameDecl.getEnd() != null 
            ? SootHostExtendKt.getLine(nameDecl.getEnd()) 
            : null;
    }

    @Nullable
    public final Integer getJavaNameSourceEndColumnNumber() {
        NodeWithRange<Node> nameDecl = getNameDecl();
        return nameDecl != null && nameDecl.getEnd() != null 
            ? SootHostExtendKt.getColumn(nameDecl.getEnd()) 
            : null;
    }

    @Nullable
    public Integer getStartLine() {
        NodeWithRange<Node> decl = getDecl();
        return decl != null && decl.getBegin() != null 
            ? SootHostExtendKt.getLine(decl.getBegin()) 
            : null;
    }

    @Nullable
    public Integer getStartLineColumn() {
        NodeWithRange<Node> decl = getDecl();
        return decl != null && decl.getBegin() != null 
            ? SootHostExtendKt.getColumn(decl.getBegin()) 
            : null;
    }

    @Nullable
    public Integer getEndLine() {
        NodeWithRange<Node> decl = getDecl();
        return decl != null && decl.getEnd() != null 
            ? SootHostExtendKt.getLine(decl.getEnd()) 
            : null;
    }

    @Nullable
    public Integer getEndLineColumn() {
        NodeWithRange<Node> decl = getDecl();
        return decl != null && decl.getEnd() != null 
            ? SootHostExtendKt.getColumn(decl.getEnd()) 
            : null;
    }

    @Override
    public List<Tag> getTags() {
        return host.getTags();
    }

    @Override
    public Tag getTag(String name) {
        return host.getTag(name);
    }

    @Override
    public void addTag(Tag tag) {
        host.addTag(tag);
    }

    @Override
    public void removeTag(String name) {
        host.removeTag(name);
    }

    @Override
    public boolean hasTag(String name) {
        return host.hasTag(name);
    }

    @Override
    public void removeAllTags() {
        host.removeAllTags();
    }

    @Override
    public void addAllTagsOf(Host other) {
        host.addAllTagsOf(other);
    }
}