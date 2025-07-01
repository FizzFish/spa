package com.feysh.corax.cache.analysis;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootField;
import soot.tagkit.Host;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public final class SootFieldExtend extends SootHostExtend {
    @NotNull
    private final SootField host;
    @NotNull
    private final CompilationUnit cu;
    @Nullable
    private Node classDecl;
    @Nullable
    private FieldDeclaration decl;

    public SootFieldExtend(@NotNull SootField host, @NotNull CompilationUnit cu) {
        super(host, cu);
        this.host = host;
        this.cu = cu;
    }

    @NotNull
    public SootField getHost() {
        return host;
    }

    @Override
    @NotNull
    public CompilationUnit getCu() {
        return cu;
    }

    @Nullable
    public final Node getClassDecl() {
        if (classDecl == null) {
            SootClass sootClass = host.getDeclaringClass();
            classDecl = SootHostExtendKt.getDecl(cu, sootClass);
        }
        return classDecl;
    }

    @Nullable
    public FieldDeclaration getDecl() {
        if (decl == null) {
            Node classDecl = getClassDecl();
            if (classDecl == null) {
                return null;
            }

            if (classDecl instanceof TypeDeclaration) {
                decl = getNormalFields((TypeDeclaration<?>) classDecl);
            } else if (classDecl instanceof ObjectCreationExpr) {
                decl = getFieldsOfAnonymousClass((ObjectCreationExpr) classDecl);
            }
        }
        return decl;
    }

    @Override
    @Nullable
    public NodeWithRange<Node> getNameDecl() {
        FieldDeclaration fieldDeclaration = getDecl();
        return fieldDeclaration != null ? fieldDeclaration.getElementType() : null;
    }

    private FieldDeclaration getFields(List<? extends FieldDeclaration> fields) {
        Optional<? extends FieldDeclaration> result = fields.stream()
            .filter(f -> f.getVariables().stream()
                .anyMatch(v -> v.getNameAsString().equals(host.getName())))
            .findFirst();
        return result.orElse(null);
    }

    private FieldDeclaration getNormalFields(TypeDeclaration<?> classDecl) {
        return getFields(classDecl.getFields());
    }

    private FieldDeclaration getFieldsOfAnonymousClass(ObjectCreationExpr classDecl) {
        List<FieldDeclaration> fields = classDecl.findAll(FieldDeclaration.class, Node.TreeTraversal.DIRECT_CHILDREN);
        return getFields(fields);
    }

    @NotNull
    public final SootFieldExtend copy(@NotNull SootField host, @NotNull CompilationUnit cu) {
        return new SootFieldExtend(host, cu);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof SootFieldExtend)) return false;
        SootFieldExtend that = (SootFieldExtend) other;
        return host.equals(that.host) && cu.equals(that.cu);
    }

    @Override
    public int hashCode() {
        int result = host.hashCode();
        result = 31 * result + cu.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SootFieldExtend(host=" + host + ", cu=" + cu + ")";
    }
}
