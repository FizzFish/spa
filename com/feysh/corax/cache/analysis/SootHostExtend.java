/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.javaparser.ast.CompilationUnit
 *  com.github.javaparser.ast.Node
 *  com.github.javaparser.ast.nodeTypes.NodeWithRange
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.tagkit.Host
 *  soot.tagkit.Tag
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.analysis.SootHostExtendKt;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.tagkit.Host;
import soot.tagkit.Tag;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u001e\u0010&\u001a\u00020'2\u000e\u0010(\u001a\n )*\u0004\u0018\u00010\u00010\u0001H\u0096\u0001\u00a2\u0006\u0002\u0010*J\u001e\u0010+\u001a\u00020'2\u000e\u0010(\u001a\n )*\u0004\u0018\u00010,0,H\u0096\u0001\u00a2\u0006\u0002\u0010-J&\u0010.\u001a\n )*\u0004\u0018\u00010,0,2\u000e\u0010(\u001a\n )*\u0004\u0018\u00010/0/H\u0096\u0001\u00a2\u0006\u0002\u00100J2\u00101\u001a&\u0012\f\u0012\n )*\u0004\u0018\u00010,0, )*\u0012\u0012\f\u0012\n )*\u0004\u0018\u00010,0,\u0018\u00010302H\u0096\u0001\u00a2\u0006\u0002\u00104J\u001e\u00105\u001a\u0002062\u000e\u0010(\u001a\n )*\u0004\u0018\u00010/0/H\u0096\u0001\u00a2\u0006\u0002\u00107J\t\u00108\u001a\u00020'H\u0096\u0001J\u001e\u00109\u001a\u00020'2\u000e\u0010(\u001a\n )*\u0004\u0018\u00010/0/H\u0096\u0001\u00a2\u0006\u0002\u0010:R\u0014\u0010\u0002\u001a\u00020\u0001X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0017R\u0016\u0010 \u001a\u0004\u0018\u00010\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0017R\u0016\u0010\"\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0017R\u0016\u0010$\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010\u0017\u0082\u0001\u0003;<=\u00a8\u0006>"}, d2={"Lcom/feysh/corax/cache/analysis/SootHostExtend;", "Lsoot/tagkit/Host;", "host", "cu", "Lcom/github/javaparser/ast/CompilationUnit;", "<init>", "(Lsoot/tagkit/Host;Lcom/github/javaparser/ast/CompilationUnit;)V", "getHost", "()Lsoot/tagkit/Host;", "getCu", "()Lcom/github/javaparser/ast/CompilationUnit;", "decl", "Lcom/github/javaparser/ast/nodeTypes/NodeWithRange;", "Lcom/github/javaparser/ast/Node;", "getDecl", "()Lcom/github/javaparser/ast/nodeTypes/NodeWithRange;", "nameDecl", "getNameDecl", "getJavaSourceStartLineNumber", "", "getJavaSourceStartColumnNumber", "javaNameSourceStartLineNumber", "getJavaNameSourceStartLineNumber", "()Ljava/lang/Integer;", "javaNameSourceStartColumnNumber", "getJavaNameSourceStartColumnNumber", "javaNameSourceEndLineNumber", "getJavaNameSourceEndLineNumber", "javaNameSourceEndColumnNumber", "getJavaNameSourceEndColumnNumber", "startLine", "getStartLine", "startLineColumn", "getStartLineColumn", "endLine", "getEndLine", "endLineColumn", "getEndLineColumn", "addAllTagsOf", "", "p0", "kotlin.jvm.PlatformType", "(Lsoot/tagkit/Host;)V", "addTag", "Lsoot/tagkit/Tag;", "(Lsoot/tagkit/Tag;)V", "getTag", "", "(Ljava/lang/String;)Lsoot/tagkit/Tag;", "getTags", "", "", "()Ljava/util/List;", "hasTag", "", "(Ljava/lang/String;)Z", "removeAllTags", "removeTag", "(Ljava/lang/String;)V", "Lcom/feysh/corax/cache/analysis/SootClassExtend;", "Lcom/feysh/corax/cache/analysis/SootFieldExtend;", "Lcom/feysh/corax/cache/analysis/SootMethodExtend;", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nSootHostExtend.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SootHostExtend.kt\ncom/feysh/corax/cache/analysis/SootHostExtend\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,391:1\n1#2:392\n*E\n"})
public abstract class SootHostExtend
implements Host {
    @NotNull
    private final Host host;
    @NotNull
    private final CompilationUnit cu;

    private SootHostExtend(Host host, CompilationUnit cu) {
        this.host = host;
        this.cu = cu;
    }

    @NotNull
    public Host getHost() {
        return this.host;
    }

    @NotNull
    public CompilationUnit getCu() {
        return this.cu;
    }

    @Nullable
    public abstract NodeWithRange<Node> getDecl();

    @Nullable
    public abstract NodeWithRange<Node> getNameDecl();

    public int getJavaSourceStartLineNumber() {
        int n;
        Integer n2 = this.getHost().getJavaSourceStartLineNumber();
        int it = ((Number)n2).intValue();
        boolean bl = false;
        Integer n3 = it != -1 ? n2 : null;
        if (n3 != null) {
            n = n3;
        } else {
            Integer n4 = this.getStartLine();
            n = n4 != null ? n4 : -1;
        }
        return n;
    }

    public int getJavaSourceStartColumnNumber() {
        int n;
        Integer n2 = this.getHost().getJavaSourceStartColumnNumber();
        int it = ((Number)n2).intValue();
        boolean bl = false;
        Integer n3 = it != -1 ? n2 : null;
        if (n3 != null) {
            n = n3;
        } else {
            Integer n4 = this.getStartLineColumn();
            n = n4 != null ? n4 : -1;
        }
        return n;
    }

    @Nullable
    public final Integer getJavaNameSourceStartLineNumber() {
        Object object = this.getNameDecl();
        return object != null && (object = object.getBegin()) != null ? SootHostExtendKt.getLine(object) : null;
    }

    @Nullable
    public final Integer getJavaNameSourceStartColumnNumber() {
        Object object = this.getNameDecl();
        return object != null && (object = object.getBegin()) != null ? SootHostExtendKt.getColumn(object) : null;
    }

    @Nullable
    public final Integer getJavaNameSourceEndLineNumber() {
        Object object = this.getNameDecl();
        return object != null && (object = object.getEnd()) != null ? SootHostExtendKt.getLine(object) : null;
    }

    @Nullable
    public final Integer getJavaNameSourceEndColumnNumber() {
        Object object = this.getNameDecl();
        return object != null && (object = object.getEnd()) != null ? SootHostExtendKt.getColumn(object) : null;
    }

    @Nullable
    public Integer getStartLine() {
        Object object = this.getDecl();
        return object != null && (object = object.getBegin()) != null ? SootHostExtendKt.getLine(object) : null;
    }

    @Nullable
    public Integer getStartLineColumn() {
        Object object = this.getDecl();
        return object != null && (object = object.getBegin()) != null ? SootHostExtendKt.getColumn(object) : null;
    }

    @Nullable
    public Integer getEndLine() {
        Object object = this.getDecl();
        return object != null && (object = object.getEnd()) != null ? SootHostExtendKt.getLine(object) : null;
    }

    @Nullable
    public Integer getEndLineColumn() {
        Object object = this.getDecl();
        return object != null && (object = object.getEnd()) != null ? SootHostExtendKt.getColumn(object) : null;
    }

    public List<Tag> getTags() {
        return this.host.getTags();
    }

    public Tag getTag(String p0) {
        return this.host.getTag(p0);
    }

    public void addTag(Tag p0) {
        this.host.addTag(p0);
    }

    public void removeTag(String p0) {
        this.host.removeTag(p0);
    }

    public boolean hasTag(String p0) {
        return this.host.hasTag(p0);
    }

    public void removeAllTags() {
        this.host.removeAllTags();
    }

    public void addAllTagsOf(Host p0) {
        this.host.addAllTagsOf(p0);
    }

    public /* synthetic */ SootHostExtend(Host host, CompilationUnit cu, DefaultConstructorMarker $constructor_marker) {
        this(host, cu);
    }
}

